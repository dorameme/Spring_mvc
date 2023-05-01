package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
/*
* 1.파라미터 전송기능
* get쿼리 파라미터
* */
@WebServlet(name="requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName-> System.out.println(paramName+"="+request.getParameter(paramName)));
        //이름-> paramName value->request.getParameter(paramName)
        System.out.println("[단일 파라미터조회]");
        String username=request.getParameter("username");
        String age= request.getParameter("age");
        System.out.println("username = " + username + ", age = " + age);

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames=request.getParameterValues("username");
        for(String name:usernames){
            System.out.println("name:"+name);//이렇게 같은 변수명에 여러개를 한번에 받을수도 있다.
        }
    }//이름이 중복되게 하나의 파라미터에 여러개의 정보를 보내면 우선순위에서 먼저잡힌애를 출력
}//getParameterValues()-> 복수 파라미터 getParameter()->단일파라미ㅎㄷㅅ
//request.getParameter()는 get-url parameter, post-html form 둘다 데이터 뽑을수 있음.