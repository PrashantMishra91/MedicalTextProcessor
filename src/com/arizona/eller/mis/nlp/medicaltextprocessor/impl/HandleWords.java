package com.arizona.eller.mis.nlp.medicaltextprocessor.impl;

import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;

/**
 * @author Prashant
 *
 */
public class HandleWords {

	public int getTotalWords(CoreSentence sentence) {
		String text = sentence.text();
		Document document = new Document(text);
		Sentence simpleSentence = document.sentence(0);
		return getTotalWords(simpleSentence);
	}

	public int getTotalWords(Sentence sentence) {
		return sentence.words().size();
	}

}
