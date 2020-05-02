/*Rishikesh pasham*/
package com.dao;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import com.bean.StudentBean;

public class StudentDAO {
    private String fname;
    private String lname;
    private String studentid;
    private String email;
    private String streetaddress;
    private String city;
    private String country;
    private String state;
    private String zipcode;
    private String telephone;
    private String url;
    private String surveydate;
    private String month;
    private String graduationYear;
    private String likemost;
    private String interestInUniversity;
    private String comments;
    private String recommend;
    private String data;
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public String getFname() {
        return this.fname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getLname() {
        return this.lname;
    }
    
    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }
    
    public String getStudentid() {
        return this.studentid;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    
    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }
    public String getStreetaddress() {
        return this.streetaddress;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return this.state;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public String getZipcode() {
        return this.zipcode;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setSurveydate(String surveydate) {
        this.surveydate = surveydate;
    }
    
    public String getSurveydate() {
        return this.surveydate;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }
    
    public String getMonth() {
        return this.month;
    }
    
    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }
    
    public String getGraduationYear() {
        return this.graduationYear;
    }
    
    public void setLikemost(String likemost) {
        this.likemost = likemost;
    }
    
    public String getLikemost() {
        return this.likemost;
    }
    
    public void setIntuniversity(String interestInUniversity) {
        this.interestInUniversity = interestInUniversity;
    }
    
    public String getIntuniversity() {
        return this.interestInUniversity;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public String getComments() {
        return this.comments;
    }
    
    
    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
    
    public String getRecommend() {
        return this.recommend;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getData() {
        return this.data;
    }
    
    
    // this methods inserts data into database 
    public List<String> storedata() {
        
        ArrayList<String> ar = new ArrayList<String>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu", "rpasham", "sempiste");
            PreparedStatement pstmt = con.prepareStatement("insert into Students(FName,LName,StudentID,Email,StreetAddr,City,Country,States,Zipcode,Telephone,Urls,SurveyDate,GradMonth,GradYear,Likemost,InterestInUniv,Comments,Recommend,Dataval) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, this.fname);
            pstmt.setString(2, this.lname);
            pstmt.setString(3, this.studentid);
            pstmt.setString(4, this.email);
            pstmt.setString(5, this.streetaddress);
            pstmt.setString(6, this.city);
            pstmt.setString(7, this.country);
            pstmt.setString(8, this.state);
            pstmt.setString(9, this.zipcode);
            pstmt.setString(10, this.telephone);
            pstmt.setString(11, this.url);
            pstmt.setString(12, this.surveydate);
            pstmt.setString(13, this.month);
            pstmt.setString(14, this.graduationYear);
            pstmt.setString(15, this.likemost);
            pstmt.setString(16, this.interestInUniversity);
            pstmt.setString(17, this.comments);
            pstmt.setString(18, this.recommend);      
            pstmt.setString(19, this.data);
            
            pstmt.executeUpdate();
            pstmt.close();
            pstmt = con.prepareStatement("select StudentID from Students");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ar.add(rs.getString("StudentID"));
            }
            pstmt.close();
            con.close();//closing connection
            return ar;
        }
        catch (Exception e) {
        	System.out.println("Connection Error");
        	System.out.println(e);
        	
            e.printStackTrace();
            return null;
        }
    }
    
    //this method retrieves data from database
    public StudentBean getStudentData(String stdid) {
        
       StudentBean sb = new StudentBean();
       try {
    	   Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu", "rpasham", "sempiste");
           PreparedStatement pstmt = con.prepareStatement("select * from Students where StudentID=?");
           System.out.println("STDID is:"+stdid);
           pstmt.setString(1, stdid);
           ResultSet results = pstmt.executeQuery();
           int i = 0;
           while (results.next()) {
               ++i;
               sb.setFname(results.getString("FName"));
               sb.setLname(results.getString("LName"));
               sb.setStudentid(results.getString("StudentID"));
               sb.setEmail(results.getString("Email"));
               sb.setStreetaddress(results.getString("StreetAddr"));
               sb.setCity(results.getString("City"));
               sb.setCountry(results.getString("Country"));
               sb.setState(results.getString("States"));
               sb.setZipcode(results.getString("Zipcode"));
               sb.setTelephone(results.getString("Telephone"));
               sb.setUrl(results.getString("Urls"));
               sb.setSurveydate(results.getString("SurveyDate"));
               sb.setMonth(results.getString("GradMonth"));
               sb.setGraduationYear(results.getString("GradYear"));
               sb.setLikemost(results.getString("Likemost"));
               sb.setInterestInUniversity(results.getString("InterestInUniv"));
               sb.setComments(results.getString("Comments"));
               sb.setRecommend(results.getString("Recommend"));
               sb.setData(results.getString("Dataval"));
           }
           pstmt.close();
           con.close();//closing connection
           if (i > 0) {
               return sb;
           }
           return null;
       }
       catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
    


}
