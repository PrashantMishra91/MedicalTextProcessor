package com.arizona.eller.mis.nlp.medicaltextprocessor.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.arizona.eller.mis.nlp.medicaltextprocessor.constants.MedicalTextProcessorConstants;
import com.arizona.eller.mis.nlp.medicaltextprocessor.filehandler.OutputFileGenerator;
import com.arizona.eller.mis.nlp.medicaltextprocessor.helper.OutputFilePath;
import com.arizona.eller.mis.nlp.medicaltextprocessor.helper.RowEntry;
import com.arizona.eller.mis.nlp.medicaltextprocessor.helper.UpdateRows;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.pipeline.CoreSentence;

/**
 * @author Prashant
 *
 */
public class MessageProcessor {

	public void processingText(String message, OutputFilePath outputFilePath) {
		try {
			Properties properties = new Properties();
			updateProperties(properties);

			Document simpleDoc = new Document(message);

			simpleDoc.sentence(0);

			CoreDocument doc = new CoreDocument(message);
			StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);
			pipeline.annotate(doc);

			HandleSentences handleSentence = new HandleSentences();
			int totalSentences = handleSentence.getTotalSentences(doc);
			List<CoreSentence> sentences = handleSentence.sentenceList(doc);

			List<RowEntry> rowEntries = new ArrayList<RowEntry>();
			UpdateRows updateRows = new UpdateRows();
			rowEntries = updateRows.getRowEntries(doc, sentences, simpleDoc);

			OutputFileGenerator outputFileGenerator = new OutputFileGenerator();
			outputFileGenerator.writeTexttoFile(rowEntries, totalSentences, outputFilePath);

		} catch (Exception e) {
			System.out.println("Exception while processing the Text of the message  " + e.getMessage());
		}

	}

	private void updateProperties(Properties properties) {
		try {
			properties.setProperty("annotators", MedicalTextProcessorConstants.ANNOTATORS);
			properties.setProperty("regexner.mapping", MedicalTextProcessorConstants.MEDICALTERMSTEXT);
			properties.setProperty("ner.applyFineGrained", "false");
		} catch (Exception e) {
			System.out.println(
					"Exception while updating Properties file for annotating Core NLP doc   " + e.getMessage());
		}
	}

}
