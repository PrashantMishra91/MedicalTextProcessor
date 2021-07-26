package com.arizona.eller.mis.nlp.medicaltextprocessor.filehandler;

import com.arizona.eller.mis.nlp.medicaltextprocessor.helper.OutputFilePath;
import com.arizona.eller.mis.nlp.medicaltextprocessor.impl.MessageProcessor;

/**
 * @author Prashant
 *
 */
public class ReadWebData {

	/**
	 * @param message
	 * @param outPath
	 */
	public void onMessage(String message, String outPath) {
		try {
			OutputFilePath outputFilePath = new OutputFilePath();
			outputFilePath.setOutpath(outPath);

			MessageProcessor messageProcessor = new MessageProcessor();
			messageProcessor.processingText(message, outputFilePath);

		} catch (Exception e) {
			System.out.println("Exception in reading web data    " + e.getMessage());
		}
	}

}
