package prac1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoClass extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String actor = req.getParameter("actor");
		String actress = req.getParameter("actress");
		String director = req.getParameter("director");
		String date = req.getParameter("releaseDate");
		String rate = req.getParameter("ratepoint");


	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Entertainment","root","");
		PreparedStatement ps= con.prepareStatement("Insert Into Movies values(?,?,?,?,?,?,?)");
		ps.setInt(1, Integer.parseInt(id));

        ps.setString(2, name);
        ps.setString(3, actor);
        ps.setString(4, actress);
        ps.setString(5, director);
        ps.setString(6, date);
        ps.setFloat(7,Float.parseFloat(rate));
        ps.executeUpdate();

        res.getWriter().print("Movie Added Successfully!");
    } catch (Exception e) { e.printStackTrace(); }

}

}

