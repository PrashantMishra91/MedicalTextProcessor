package com.arizona.eller.mis.nlp.medicaltextprocessor.impl;

import java.util.ArrayList;
import java.util.List;

import com.arizona.eller.mis.nlp.medicaltextprocessor.constants.MedicalTextProcessorConstants;

import edu.stanford.nlp.pipeline.CoreSentence;

/**
 * @author Prashant
 *
 */
public class HandleNerTags {

	public List<String> getMedicalTermList(CoreSentence sentence) {
		List<String> medicalList = new ArrayList<String>();
		try {
			List<String> tokens = sentence.tokensAsStrings();
			List<String> nerTags = sentence.nerTags();
			for (int i = 0; i < nerTags.size(); i++) {
				if (nerTags.get(i).equalsIgnoreCase(MedicalTextProcessorConstants.MEDICAL)) {
					medicalList.add(tokens.get(i));
				}
			}
			return medicalList;
		} catch (Exception e) {
			System.out.println("Exception while fetching the list of Medical Terms   " + e.getMessage());
		}
		return medicalList;
	}

	public int getTotalMedicalNerTags(CoreSentence sentence) {
		List<String> nerTags = sentence.nerTags();
		int count = 0;
		for (String tag : nerTags) {
			if (tag.equalsIgnoreCase(MedicalTextProcessorConstants.MEDICAL)) {
				count++;
			}
		}
		return count;
	}

}
