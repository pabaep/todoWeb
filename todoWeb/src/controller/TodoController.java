package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todoweb")
public class TodoController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청 정보에 한해서 한글인 경우에 인코딩 처리하는 설정
		request.setCharacterEncoding("utf-8");
		// command pattern
		String command = request.getParameter("command");
		
		//?? 여기에 각자 쓸 메소드 넣어서 쓰세요 ~
		try{
			if(command.equals("login")){
				login(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
