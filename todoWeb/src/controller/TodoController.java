package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.MessageException;
import model.TodoService;
import model.DTO.UserDTO;

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
		System.out.println(command);
		
		//?? 여기에 각자 쓸 메소드 넣어서 쓰세요 ~
		try{
			if(command.equals("logIn")){
				login(request, response);
			}
			else if(command.equals("signUp")) {
				signUp(request, response);
			}
			else if(command.equals("todoAll")) {
				todoAll(request,response);
			}
			else if(command.equals("deleteTodo")) {
				deleteTodo(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String userEmail = request.getParameter("user_email");
		String userPw = request.getParameter("user_pw");
		try {
			UserDTO user = TodoService.login(userEmail, userPw);
			if(user != null) {
				request.setAttribute("successMsg", "로그인 완료");
				request.setAttribute("user", user);
				request.setAttribute("todoAll", TodoService.getAlltodo(user.getUserId()));
				url = "todoAll.jsp";
			}
			else {
				request.setAttribute("errorMsg", "로그인 오류");
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", "로그인 오류");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String userEmail = request.getParameter("user_email");
		String userName = request.getParameter("user_name");
		String userPw = request.getParameter("user_pw");
		
		UserDTO user = new UserDTO(userEmail, userName, userPw);
		try {
			boolean result = TodoService.addUser(user);
			if(result) {
				request.setAttribute("successMsg", "가입 완료");
				url = "index.html";
			}
		} catch (MessageException e) {
			request.setAttribute("errorMsg", "다시 시도하세요");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void todoAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("uid");
		System.out.println(userId);
		String url = "showError.jsp";
		try {
			request.setAttribute("todoAll", TodoService.getAlltodo(Integer.parseInt(userId)));
			url = "todoAll.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
		
	//todoList 삭제
	public void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("uid");
		String url = "todoAll.jsp";
		try {
			String todoId = request.getParameter("todoId");
			if(TodoService.deleteTodo(todoId)){
				request.setAttribute("todoAll", TodoService.getAlltodo(Integer.parseInt(userId)));
				url = "todoAll.jsp";
			}else{
				request.setAttribute("errorMsg", "재 실행 해 주세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", "todoList가 이미 존재합니다.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
