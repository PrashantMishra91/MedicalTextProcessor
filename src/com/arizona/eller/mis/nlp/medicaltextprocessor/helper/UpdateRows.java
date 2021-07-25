package com.arizona.eller.mis.nlp.medicaltextprocessor.helper;

import java.util.ArrayList;
import java.util.List;

import com.arizona.eller.mis.nlp.medicaltextprocessor.impl.HandleNerTags;
import com.arizona.eller.mis.nlp.medicaltextprocessor.impl.HandleNouns;
import com.arizona.eller.mis.nlp.medicaltextprocessor.impl.HandleSentences;
import com.arizona.eller.mis.nlp.medicaltextprocessor.impl.HandleWords;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.simple.Document;

/**
 * @author Prashant
 *
 */
public class UpdateRows {

	public List<RowEntry> getRowEntries(CoreDocument doc, List<CoreSentence> sentences, Document simpleDoc) {
		List<RowEntry> entries = new ArrayList<RowEntry>();
		try {
			if (sentences != null && !sentences.isEmpty()) {
				int index = 1;
				for (CoreSentence sentence : sentences) {
					RowEntry row = new RowEntry();
					row.setId(String.valueOf(index));
					row.setSentence(sentence.text().replace(System.lineSeparator(), " "));
					row.setRefSentence(getFormattedSentence(sentence));
					row.setWords(String.valueOf(getWordsinSentence(sentence)));
					row.setNouns(String.valueOf(getNounsinSentence(sentence)));
					row.setNounsList(String.join(", ", getNounsListinSentence(sentence)));
					row.setMedicalTerms(String.valueOf(getMedicalTermsinSentence(sentence)));
					row.setMedicalTermsList(String.join(", ", getMedicalListinSentence(sentence)));

					entries.add(row);
					index++;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception while fetching the row entries for updating rows " + e.getMessage());
		}
		return entries;
	}

	private List<String> getMedicalListinSentence(CoreSentence sentence) {
		try {
			HandleNerTags handleNerTags = new HandleNerTags();
			List<String> medicalList = handleNerTags.getMedicalTermList(sentence);
			return medicalList;
		} catch (Exception e) {
			System.out.println("Exception while handling medical terms list in a sentence  " + e.getMessage());
		}
		return null;

	}

	private int getMedicalTermsinSentence(CoreSentence sentence) {
		try {
			HandleNerTags handleNerTags = new HandleNerTags();
			return handleNerTags.getTotalMedicalNerTags(sentence);
		} catch (Exception e) {
			System.out.println("Exception while handling medical terms in a sentence  " + e.getMessage());
		}
		return 0;

	}

	private String getFormattedSentence(CoreSentence sentence) {
		try {
			HandleSentences handleSentences = new HandleSentences();
			return handleSentences.formattedSentence(sentence);
		} catch (Exception e) {
			System.out.println("Exception while handling nouns list in a sentence  " + e.getMessage());
		}
		return "";
	}

	private List<String> getNounsListinSentence(CoreSentence sentence) {
		try {
			HandleNouns handleNouns = new HandleNouns();
			List<String> nounsList = handleNouns.getNounsList(sentence);
			return nounsList;
		} catch (Exception e) {
			System.out.println("Exception while handling nouns list in a sentence  " + e.getMessage());
		}
		return null;

	}

	private int getNounsinSentence(CoreSentence sentence) {
		try {
			HandleNouns handleNouns = new HandleNouns();
			int totalNouns = handleNouns.getTotalNouns(sentence);
			return totalNouns;
		} catch (Exception e) {
			System.out.println("Exception while handling nouns in a sentence  " + e.getMessage());
		}
		return 0;

	}

	private int getWordsinSentence(CoreSentence sentence) {
		try {
			HandleWords handleWords = new HandleWords();
			int totalWords = handleWords.getTotalWords(sentence);
			return totalWords;
		} catch (Exception e) {
			System.out.println("Exception in working upon words in a sentence  " + e.getMessage());
		}
		return 0;
	}

}
