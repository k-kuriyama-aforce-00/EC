package jp.co.aforce.session;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/views/adminHome.jsp" })
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初期化処理（必要に応じて実装）
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false); // セッションを取得します（新しく作成しない）

        boolean isLoggedIn = (session != null && session.getAttribute("adminId") != null);
        if (isLoggedIn) {
            // ログイン済みの場合は通常の処理を継続します
            filterChain.doFilter(request, response);
        } else {
            // ログインされていない場合はログインページにリダイレクトします
            response.sendRedirect(request.getContextPath() + "/views/adminlogin.jsp");
        }
    }
}
