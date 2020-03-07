package pl.sda.jsp.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet"
        , urlPatterns = {"/","/hello"}
        , initParams = {
            @WebInitParam(name = "id",value = "123456")
            , @WebInitParam(name = "localization", value = "Poland")
        })
public class HelloWorldServlet extends HttpServlet {

    private String id, localization;

    @Override
    public void init(ServletConfig config){
        id = config.getInitParameter("id");
        localization = config.getInitParameter("localization");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter writer = response.getWriter();

        writer.println("<h1>Hello World</h1><br>");
        writer.println("Id: "+id+"<br>");
        writer.println("Lokalizacja: "+localization);
    }
}
