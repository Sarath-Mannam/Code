package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet1")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  System.out.println("Control in servlet 1");
          request.setAttribute("Hyder", "Java");
          request.setAttribute("NavinReddy", "telusuko");
          request.setAttribute("Nitin", "API");

          RequestDispatcher resDisp = request.getRequestDispatcher("/servlet2");
          resDisp.forward(request, response);
         System.out.println("Dispatch is success");

	}

}
