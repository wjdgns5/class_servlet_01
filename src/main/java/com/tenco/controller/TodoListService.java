package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet("/todolist")
public class TodoListService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoListService() {
        super();
    }
    // GET 방식
    // http://localhost:8080/class_sevlet_01/todolist
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 다시 HTML 형식을 만들어서 클라이언트에게 내려주는 것은 
		// 서블릿에서 너무 불편하다. 
		// 서블릿 컨텍스트라는 객체를 활용해서 코드를 만들어보자.
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		// http://localhost:8080/class_servlet_01/todolistPage.html
		
		// HTML 파일 읽기
		String htmlFilePath = "/todoListPage.html"; 
		InputStream inputStream = getServletContext().getResourceAsStream(htmlFilePath);
		
		if(inputStream == null) {
			response.getWriter().write("<html><body>해당 파일을 찾을 수 없음 404</body></html>");
			
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer htmlContent = new StringBuffer();
		String line;
		while( (line = reader.readLine())!= null) {
			htmlContent.append(line);
		}
		reader.close();
		
		response.getWriter().write(htmlContent.toString());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
