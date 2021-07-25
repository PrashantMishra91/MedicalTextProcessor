package com.arizona.eller.mis.nlp.medicaltextprocessor.impl;

import java.util.ArrayList;
import java.util.List;

import com.arizona.eller.mis.nlp.medicaltextprocessor.constants.MedicalTextProcessorConstants;

import edu.stanford.nlp.pipeline.CoreSentence;

/**
 * @author Prashant
 *
 */
public class HandleNouns {

	public List<String> getNounsList(CoreSentence sentence) {
		List<String> nounsList = new ArrayList<String>();
		try {
			List<String> tokens = sentence.tokensAsStrings();
			List<String> posTags = sentence.posTags();
			for (int i = 0; i < posTags.size(); i++) {
				if (posTags.get(i).startsWith(MedicalTextProcessorConstants.NOUNS)) {
					nounsList.add(tokens.get(i));
				}
			}
			return nounsList;
		} catch (Exception e) {
			System.out.println("Exception while fetching the list of Nouns   " + e.getMessage());
		}
		return nounsList;
	}

	public int getTotalNouns(CoreSentence sentence) {
		try {
			List<String> posTags = sentence.posTags();
			int count = 0;
			if (posTags != null && !posTags.isEmpty()) {
				for (String posTag : posTags) {
					if (posTag.startsWith(MedicalTextProcessorConstants.NOUNS)) {
						count++;
					}
				}
			}
			return count;
		} catch (Exception e) {
			System.out.println("Exception in ftehcing total nouns  " + e.getMessage());
		}
		return 0;
	}

}
