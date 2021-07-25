package com.arizona.eller.mis.nlp.medicaltextprocessor.helper;

/**
 * @author Prashant
 *
 */
public class RowEntry {
	private String id;
	private String sentence;
	private String refSentence;
	private String words;
	private String nouns;
	private String nounsList;
	private String medicalTerms;
	private String medicalTermsList;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the sentence
	 */
	public String getSentence() {
		return sentence;
	}

	/**
	 * @param sentence the sentence to set
	 */
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getRefSentence() {
		return refSentence;
	}

	public void setRefSentence(String refSentence) {
		this.refSentence = refSentence;
	}

	/**
	 * @return the words
	 */
	public String getWords() {
		return words;
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(String words) {
		this.words = words;
	}

	/**
	 * @return the nouns
	 */
	public String getNouns() {
		return nouns;
	}

	/**
	 * @param nouns the nouns to set
	 */
	public void setNouns(String nouns) {
		this.nouns = nouns;
	}

	public String getNounsList() {
		return nounsList;
	}

	public void setNounsList(String nounsList) {
		this.nounsList = nounsList;
	}

	public String getMedicalTerms() {
		return medicalTerms;
	}

	public void setMedicalTerms(String medicalTerms) {
		this.medicalTerms = medicalTerms;
	}

	public String getMedicalTermsList() {
		return medicalTermsList;
	}

	public void setMedicalTermsList(String medicalTermsList) {
		this.medicalTermsList = medicalTermsList;
	}

}
