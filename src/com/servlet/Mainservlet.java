/*Rishikesh pasham*/

package com.servlet;

import java.io.IOException;
import com.dao.DataProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.DataBean;
import com.dao.StudentDAO;
import com.bean.StudentBean;



public class Mainservlet extends HttpServlet {
    static final long serialVersionUID = 1L;

    public Mainservlet() {}
    //post method collects data of input fields from html page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String likevalues="";
		String vals[]=request.getParameterValues("likemost");
		for(int i=0;i< vals.length;i++)
		{
			likevalues+= vals[i]+",";
		}
		StudentDAO dao = new StudentDAO();
		dao.setFname(request.getParameter("fname"));
		dao.setLname(request.getParameter("lname"));
		dao.setStudentid(request.getParameter("studentid"));
		dao.setEmail(request.getParameter("email"));
		dao.setStreetaddress(request.getParameter("streetaddress"));
		dao.setCity(request.getParameter("city"));
		dao.setCountry(request.getParameter("country"));
		dao.setState(request.getParameter("state"));
		dao.setZipcode(request.getParameter("zipcode"));
		dao.setTelephone(request.getParameter("telephone"));
		dao.setUrl(request.getParameter("url"));
		dao.setSurveydate(request.getParameter("surveydate"));
		dao.setMonth(request.getParameter("month"));
		dao.setGraduationYear(request.getParameter("graduationYear"));
		dao.setLikemost(likevalues);
		dao.setIntuniversity(request.getParameter("interestInUniversity"));
		dao.setComments(request.getParameter("comments"));
		dao.setRecommend(request.getParameter("recommend"));
		dao.setData(request.getParameter("data"));
		
		Object sids = dao.storedata();
		//checking if student id is null
		if(sids==null)
		{
			request.setAttribute("errorID", "Student with a similar ID Already exist, Please enter your unique ID");
			RequestDispatcher rd = request.getRequestDispatcher("SameID.jsp");
			rd.forward(request, response);
		}
		else
		{
			DataProcessor dp = new DataProcessor();
			DataBean dbean = dp.calculate(dao.getData());
			request.setAttribute("stdids", sids);
			request.setAttribute("dataBean", dbean);
			//if mean is more than 90 it redirects to winnerack jsp or else to simpleack jsp
			if(dbean.getMean() >= 90)
			{
				RequestDispatcher rd = request.getRequestDispatcher("WinnerAck.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("SimpleAck.jsp");
				rd.forward(request, response);
			}
		}
	}

// it gets data from database and transfer control to respective jsp file
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		StudentBean stdbean = dao.getStudentData(request.getParameter("param"));
	    if (stdbean == null) {
	    	RequestDispatcher rd = request.getRequestDispatcher("NoStudent.jsp");
		    rd.include(request, response);
	    } else {
	    	HttpSession session = request.getSession();
		      session.setAttribute("stdbean", stdbean);
		      String values = stdbean.getLikemost();
		      
			  String[] tokens = values.split(",");

			  for(int i=0;i<tokens.length;i++)
			  {
				  session.setAttribute(tokens[i],"checked");
			  }
			  session.setAttribute(stdbean.getRecommend(),"selected");


		      RequestDispatcher rd = request.getRequestDispatcher("StudentData.jsp");
		      rd.include(request, response);
	    }
	}


}
