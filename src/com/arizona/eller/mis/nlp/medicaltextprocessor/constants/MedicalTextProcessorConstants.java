package com.arizona.eller.mis.nlp.medicaltextprocessor.constants;

/**
 * @author Prashant
 *
 */
public class MedicalTextProcessorConstants {

	public static final String MEDICALTERMSTEXT = "C:\\Users\\pr1mishra\\Colleges\\EllerMIS\\workspace\\MedicalTextProcessor\\MedicalTextProcessor\\src\\com\\arizona\\eller\\mis\\nlp\\medicaltextprocessor\\impl\\medicalterms.txt";

	public static final String ANNOTATORS = "tokenize,ssplit,pos,lemma,ner,regexner";

	public static final String NOUNS = "NN";

	public static final String MEDICAL = "MEDICAL";

	public static final String OUTPUTHEADING = "MEDICAL TEXT PROCESSOR";

	public static final String[] TABLEHEADERS_1 = { "ID", "Reference Sentence", "Total Words", "Total Nouns",
			"Total Medical Terms" };

	public static final String[] GETTERMETHODS_1 = { "getId", "getRefSentence", "getWords", "getNouns",
			"getMedicalTerms" };

	public static final String SENTENCENOTIFIER = "You can find the detailed Description and Analysis on the Medical Text below";
}
