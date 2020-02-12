import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
                PrintWriter out;
                try {
                        Connection con = DatabaseConnection.initializeDatabase();
                        PreparedStatement pst=con.prepareStatement("select * from studentData where studentFirstName=? or studentLastName=? or studentClass=?");
                        pst.setString(1,request.getParameter("firstName"));
                        pst.setString(2,request.getParameter("lastName"));
                        pst.setString(3,request.getParameter("sClass"));
//                      String k=request.getParameter("firstName");
                        response.setContentType("text/html");
                        ResultSet rst= pst.executeQuery();
                        out = response.getWriter();
                        out.flush();

                        out.print("<table width=45% border=1 border-collapse=collapse align=center>");

                        out.print("<center><h2>Student Details</h2></center>");
                        out.print("<tr>");
                        out.print("<td>ID</td>");
                        out.print("<td>First Name</td>");
                        out.print("<td>Last Name</td>");
                        out.print("<td>Father's Name</td>");
                        out.print("<td>Email</td>");
                        out.print("<td>Class</td>");
                        out.print("<td>Age</td></tr>");
//                      System.out.println("ertyh");
//                      out.print(k);
                        while (rst.next())
                        {
//                              System.out.println("pribthgfd");
                                String Id = rst.getString(1);
                                String firstName = rst.getString(2);
                                String lastName = rst.getString(3);
                                String fatherName = rst.getString(4);
                                String email = rst.getString(5);
                                int studentClass = rst.getInt(6);
                                int age = rst.getInt(7);

                                out.print("<tr>");
                                out.print("<td >" + Id + "</td>");
                                out.print("<td >" + firstName + "</td>");
                                out.print("<td >" + lastName + "</td>");
                                out.print("<td >" + fatherName + "</td>");
                                out.print("<td >" + email + "</td>");
                                out.print("<td >" + studentClass + "</td>");
                                out.print("<td >" + age + "</td>");
                                out.print("</tr>");
                        }
                        out.print("</table>");

                }
                catch (SQLException|ClassNotFoundException e)
                {
                        e.printStackTrace();
                }
        }


}

