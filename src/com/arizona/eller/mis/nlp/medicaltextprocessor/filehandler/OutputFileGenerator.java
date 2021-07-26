package com.arizona.eller.mis.nlp.medicaltextprocessor.filehandler;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.List;

import com.arizona.eller.mis.nlp.medicaltextprocessor.constants.MedicalTextProcessorConstants;
import com.arizona.eller.mis.nlp.medicaltextprocessor.helper.OutputFilePath;
import com.arizona.eller.mis.nlp.medicaltextprocessor.helper.RowEntry;
import com.bethecoder.ascii_table.ASCIITable;

/**
 * @author Prashant
 *
 */
public class OutputFileGenerator {

	/**
	 * @param rowEntries
	 * @param totalSentences
	 * @param outputFilePath
	 */
	public void writeTexttoFile(List<RowEntry> rowEntries, int totalSentences, OutputFilePath outputFilePath) {
		try {
			String finalText = MedicalTextProcessorConstants.OUTPUTHEADING;
			String outPath = outputFilePath.getOutpath();

			FileWriter fileWritter = new FileWriter(outPath);

			String totalSen = "Total Sentences: " + String.valueOf(totalSentences);
			String[] headers = MedicalTextProcessorConstants.TABLEHEADERS_1;
			String[] getterMethods = MedicalTextProcessorConstants.GETTERMETHODS_1;
			String[][] tableData = constructTableData(rowEntries, getterMethods);
			String finalTable1 = ASCIITable.getInstance().getTable(headers, tableData);

			String sentenceTable = constructSentenceTable(rowEntries);

			try {
				fileWritter.write(finalText);
				fileWritter.write("\n");
				fileWritter.write("\n");
				fileWritter.write(totalSen);
				fileWritter.write("\n");
				fileWritter.write(finalTable1);
				fileWritter.write("\n");
				fileWritter.write("\n");
				fileWritter.write(MedicalTextProcessorConstants.SENTENCENOTIFIER);
				fileWritter.write("\n");
				fileWritter.write(sentenceTable);
			} catch (Exception e) {
				System.out.println("Exception while writing to file");
			} finally {
				fileWritter.close();
			}

			System.out.println("Data sucessfully processed and saved");

		} catch (Exception e) {
			System.out.println("Exception in writing file  " + e.getMessage());
		}
	}

	/**
	 * @param rowEntries
	 * @return
	 */
	private String constructSentenceTable(List<RowEntry> rowEntries) {
		try {
			String returnString = "";
			for (RowEntry row : rowEntries) {
				String id = row.getId();
				String sentenceText = row.getSentence();
				String nouns = row.getNounsList();
				String medTerms = row.getMedicalTermsList();

				returnString = returnString + "\n" + "ID: " + id + "\n" + "Sentence: " + sentenceText + "\n" + "Nouns: "
						+ nouns + "\n" + "Medical Terms: " + medTerms + "\n";
			}
			return returnString;
		} catch (Exception e) {
			System.out.println("Exception in constructing sentence table   " + e.getMessage());
		}
		return "";
	}

	/**
	 * @param rowEntries
	 * @param getterMethods
	 * @return
	 */
	private String[][] constructTableData(List<RowEntry> rowEntries, String[] getterMethods) {
		try {
			int length = rowEntries.size();
			int fields = getterMethods.length;
			String[][] tableData = new String[length][fields];

			int rowIndex = 0;
			for (RowEntry row : rowEntries) {
				int colIndex = 0;
				for (String methodName : getterMethods) {

					Method invokeMethod = RowEntry.class.getDeclaredMethod(methodName);
					Object obj = invokeMethod.invoke(row);
					tableData[rowIndex][colIndex] = (String) obj;
					colIndex++;
				}
				rowIndex++;
			}

			return tableData;

		} catch (Exception e) {
			System.out.println("Exception while constructing table data    " + e.getMessage());
		}
		return null;
	}

}
