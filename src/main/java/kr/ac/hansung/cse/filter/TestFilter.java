package kr.ac.hansung.cse.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*") // 루트 이하로 오는 모든 request를 가로채겠다.
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println( ((HttpServletRequest) request).getRequestURL() ); //request의 URL을 가져오고 콘솔에 출력

        // pass the request along for filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
