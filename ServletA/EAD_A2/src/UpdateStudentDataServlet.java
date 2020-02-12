import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudentDataServlet")
public class UpdateStudentDataServlet extends HttpServlet
{
        private static final long serialVersionUID = 1L;
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
//              System.out.println("in update servlet  dfgh");
                try
                {
//                      System.out.println("in update servlet");
                        Connection con= DatabaseConnection.initializeDatabase();
                        PreparedStatement pst = con.prepareStatement("update studentData set studentFirstName=?, studentLastName=?, studentFatherName=?, studentEMail=?, studentClass=?, studentAge=? where studentID=?");

                        pst.setString(1,request.getParameter("firstName"));
                        pst.setString(2,request.getParameter("lastName"));
                        pst.setString(3,request.getParameter("fatherName"));
                        String email=request.getParameter("email");
                         pst.setString(4,email);
                        pst.setInt(5,Integer.valueOf(request.getParameter("class")));
                        pst.setInt(6,Integer.valueOf(request.getParameter("age")));
                        pst.setInt(7,Integer.valueOf(request.getParameter("ID")));

                        //pst.executeUpdate();

                        PrintWriter out = response.getWriter();
                        if(isEmailExist(email)) {
                                pst.close();
                                con.close();
                                out.println("<html><body><br><br><center><b>Email Already Exist</b></center><br><br><br></body></html>");
                                //response.sendRedirect("index.html");
                                RequestDispatcher rd=request.getRequestDispatcher("/index.html");
                        rd.include(request, response);
                        out.close();
                        return;
                        }
                        pst.executeUpdate();
                        RequestDispatcher rd= request.getRequestDispatcher("/index.html");
                        rd.include(request, response);

                        out.close();
                        con.close();
                        pst.close();

                } catch (SQLException|ClassNotFoundException|NumberFormatException e)
                {
                        e.printStackTrace();
                }
        }
        private boolean isEmailExist(String email) {
                try {
                        Connection con = DatabaseConnection.initializeDatabase();
                        PreparedStatement stmt = con.prepareStatement("select studentID from studentData where studentEMail=?");
                        stmt.setString(1, email);
                        ResultSet rst = stmt.executeQuery();
                        boolean flag=rst.next();
                        return flag;
                }
                catch (Exception e) {
                        e.printStackTrace();
                }
                return true;
        }

}
