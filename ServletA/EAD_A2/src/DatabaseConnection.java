import java.sql.*;
public class DatabaseConnection
{
        static Connection con;
        protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException
        {
                try
                {
                        Class.forName("com.mysql.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
                return con;
        }

}
