package com.arizona.eller.mis.nlp.medicaltextprocessor.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arizona.eller.mis.nlp.medicaltextprocessor.filehandler.ReadWebData;

/**
 * Servlet implementation class TextEditorServlet
 */
/**
 * @author Prashant
 *
 */
@WebServlet("/SubmitFile")
public class TextEditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TextEditorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String medicalText = request.getParameter("medicaltext");
		String outPath = request.getParameter("outputpath");

		ReadWebData readWebData = new ReadWebData();
		readWebData.onMessage(medicalText, outPath);

		viewData(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void viewData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String text = "this is a sample Text";
			request.setAttribute("processedText", text);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewProcessedText.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Exception while showing data   " + e.getMessage());
		}
	}

}
