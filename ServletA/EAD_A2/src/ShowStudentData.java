import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowStudentData")
public class ShowStudentData extends HttpServlet {
        private static final long serialVersionUID = 1L;



        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {

                        PrintWriter out;
                        try {
                                Connection con= DatabaseConnection.initializeDatabase();

                                PreparedStatement pst=con.prepareStatement("select * from studentData");
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
                                out.print("<td>Age</td><td>Action</td></tr>");

                                while (rst.next())
                                {
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
                                        out.print("<td><a href=UpdateStudentData.html?Id="+Id+"&firstName="+firstName+"&lastName="+lastName+"&fatherName="+fatherName+"&email="+email+"&studentClass="+studentClass+"&age="+age+">Update</a></td>");
                                        out.print("</tr>");
                                }

                                out.print("</table>");
                        } catch (Exception e)
                        {
                                e.printStackTrace();
                        }


        }



}
