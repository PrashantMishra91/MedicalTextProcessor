# MedicalTextProcessor

Description:
This project is used to identify patterns in medical text using Standford CoreNLP module.

Tech Stack:
1) Java 8
2) Java Servlet
3) Apache Tomcat 9.0

Tool:
1) Eclipse

Steps to setup:
1) Clone the project.
2) Download the stanford-corenlp-4.2.2-models.jar to the External Jars folder**.
3) Add the External Jars in Build Path.
4) Open Properties (<Project> -> Properties -> Deployment Assembly) and add all the external jars
5) Look for medicalterms.txt, copy path for this text file and mention it in the "MedicalTextProcessorConstants.java" file for the variable "MEDICALTERMSTEXT".
  
Execution:
  There are 2 ways to execute this project
  1) Using Java Modules
  2) Using Web Application
  
Using Java Modules:
  Steps:
    1) Run the java file "ReadInput.java"
    2) The inputs required are
        a) The location (path) of the input text file containg the medical data to be processed
        b) The location (path) of the output where the processed data needs to be stored
    3) Check the output file at the given location
  
Using Web Application:
  Steps:
    1) Start the server
    2) Run the application on the Server
    3) once the server starts, load TextEditor.jsp page 
    4) Enter the information
        a) The medical text to be processed
        b) The location where the processed file needs to be saved
    5) Click on "Enter"
    6) The file is generated.
  
