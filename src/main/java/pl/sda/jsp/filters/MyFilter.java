package pl.sda.jsp.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "MyFilter"
//            ,servletNames = {"HelloWorldServlet"})
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.write("<html><body><div style='text-align: center;'>");

        String login = req.getParameter("login");

        if (login!=null && login.equals("admin")){
            chain.doFilter(req, resp);
        }else {
            writer.print("<p style='color:red; font-size: 50px;'>User id is invalid. Please try again...</p>");
        }

        writer.write("</div></body></html>");

        writer.close();
    }


}
