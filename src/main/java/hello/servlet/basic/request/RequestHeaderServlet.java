package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request, response);
    }

    private static void printStartLine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String method= request.getMethod();
        System.out.println("-----request start-----");
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        String username= request.getParameter("username");
        System.out.println(username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello "+username);
    }

}

