
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public  class VoterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=null;
			String name=null,tage=null;
		int age=0;
		//General Setting
		pw=res.getWriter();
		res.setContentType("text/html");
		//get request parameter values(form data)
		name=req.getParameter("name");
		tage=req.getParameter("age");
		age=Integer.parseInt("age");


		//write request processing logic
		if(age>=18){
		pw.println("<h1 style='color:green'>"+name+" You Are Eligible For Vote </h1>");
}
                
		else
                   {
			pw.println("<h1 style='color:blue'>"+name+" You Are Not Eligible For Vote </h1>");
}

		//add hperlink
		pw.println("<a href='page.html'> <img src='rahul.jpg'> </a>");
                pw.close();
                }
}