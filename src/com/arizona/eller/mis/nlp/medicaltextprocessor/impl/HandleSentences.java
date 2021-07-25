package com.arizona.eller.mis.nlp.medicaltextprocessor.impl;

import java.util.List;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;

/**
 * @author Prashant
 *
 */
public class HandleSentences {

	public String formattedSentence(CoreSentence sentence) {
		String text = sentence.text();
		text = replaceNewLine(text);
		Document document = new Document(text);
		Sentence simpleSentence = document.sentence(0);

		int sentenceSize = simpleSentence.words().size();

		if (sentenceSize >= 7) {
			String st = simpleSentence.word(0) + " " + simpleSentence.word(1) + " " + simpleSentence.word(2)
					+ simpleSentence.word(3) + " " + simpleSentence.word(4) + "...";
			return st;
		}

		return text;

	}

	public String replaceNewLine(String text) {
		return text.replace(System.lineSeparator(), " ");
	}

	public List<CoreSentence> sentenceList(CoreDocument doc) {
		return doc.sentences();
	}

	public int getTotalSentences(CoreDocument doc) {
		return doc.sentences().size();
	}
}
