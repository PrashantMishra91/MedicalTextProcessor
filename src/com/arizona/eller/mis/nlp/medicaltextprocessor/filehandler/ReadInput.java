package com.arizona.eller.mis.nlp.medicaltextprocessor.filehandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.arizona.eller.mis.nlp.medicaltextprocessor.helper.OutputFilePath;
import com.arizona.eller.mis.nlp.medicaltextprocessor.impl.MessageProcessor;


/**
 * @author Prashant
 *
 */
public class ReadInput {

	private int retryCount;
	private int maxCount;

	private static ReadInput readInput = new ReadInput();;

	/**
	 * Constructor for Class ReadInput
	 */
	public ReadInput() {
		this.retryCount = 1;
		this.maxCount = 5;
	}

	/**
	 * This message is required to read the input file and produce a String. A retry
	 * mechanism is provided in case of any exceptions.
	 */
	private void onMessage() {
		try {
			System.out.println("Enter the path of the medical text file : ");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String filePath = bufferedReader.readLine();
			String text = new String(Files.readAllBytes(Paths.get(filePath)));

			System.out.println();
			System.out.println("Enter the output path (eg: C:\\ProcessedText.txt)");
			BufferedReader bufferedReaderout = new BufferedReader(new InputStreamReader(System.in));
			String outPath = bufferedReaderout.readLine();
			OutputFilePath outputFilePath = new OutputFilePath();
			outputFilePath.setOutpath(outPath);

			readInput.processText(text, outputFilePath);

		} catch (Exception e) {
			System.out.println("Error in reading the input file, Please check the path  " + e.getMessage());
			System.out.println("Retrying... number of retries left  " + (maxCount - retryCount));
			retryCount++;
			if (retryCount == maxCount) {
				System.out.println("Maximum Number of Retries attempted");
				System.exit(0);
			}
			onMessage();
		}
	}

	/**
	 * @param message Here the String message is cleaned (if required) and sent for
	 *                further processing steps
	 * @param outputFilePath 
	 */
	private void processText(String message, OutputFilePath outputFilePath) {
		try {
			MessageProcessor messageProcessor = new MessageProcessor();
			messageProcessor.processingText(message, outputFilePath);
		} catch (Exception e) {
			System.out.println("Error while processing message   " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		readInput.onMessage();
	}

}
