package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=null;
	    String vstatus=null,name=null,tage=null;
	   int age=0;
		//general Settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//get request parameter values(form data)
		 name=req.getParameter("pname");
	    tage=req.getParameter("page");
		//get client side validation status
		vstatus=req.getParameter("vflag");
		//if client side validation not done
		if(vstatus.equals("no"))
		{
			//serverside form validation logic
			if(name.equals("")||name==null||name.length()==0)
			{//required rules
				pw.println("<font color=red>Person name is mandatory</font>");
			return;
		}//if
		if(tage.equals("")||tage==null||tage.length()==0)//required rules
		{	                                               
			pw.println("<font color=red>Person age is mandatory</font>");
			return;
		}//if
		else  //to check given age is numeric value or not
		{
			try{
				//convert given age value to numeric value
				age=Integer.parseInt(tage);
			}
			catch(NumberFormatException nfe)
			{
				pw.println("<font color=red>Age must be numeric value</font>");
				return;
				
			}
		}//else
	System.out.println("Server side validation completed");
}//if
	
else{
	age = Integer.parseInt(tage);   //when client side validation done
}
//write request processing logic
		if(age>=18)
			pw.println("<h1 style='color:green;align:center'>"+name+" you are eligible for vote</h1>");
		else
		pw.println("<h1 style='color:green;align:center'>"+name+" you are not eligible for vote</h1>");	
		//add graphicalhyperlink
		pw.println("<a href='index.html'>home</a>");
		//close stream
		pw.close();
	} //doGet(-,-)
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws 
	                                                                     ServletException,IOException
	{
		System.out.println("voterServlet:doPost(-,-)");
		doGet(req,res);
	}
}//class