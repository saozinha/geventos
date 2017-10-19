package br.com.oslourencos.filters;

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

import br.com.oslourencos.model.UsuarioModel;


@WebFilter("/sistema/*")
public class AutenticacaoFilter implements Filter {
 
    public AutenticacaoFilter() {
 
    }
 
	public void destroy() {
 
	}
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
		HttpSession httpSession 				= ((HttpServletRequest) request).getSession(); 
 
		HttpServletRequest httpServletRequest   = (HttpServletRequest) request;
 
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
 
		if(httpServletRequest.getRequestURI().indexOf("login.xhtml") <= -1){
 
			UsuarioModel usuarioModel =(UsuarioModel) httpSession.getAttribute("usuarioAutenticado");
 
			if(usuarioModel == null){
				System.out.println("URL : " + httpServletRequest.getContextPath()+ "/login.xhtml");
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+ "/login.xhtml");
 
			}
			else{
 
				chain.doFilter(request, response);
			}
		}		
		else{
 
			chain.doFilter(request, response);
		}
	}
 
	public void init(FilterConfig fConfig) throws ServletException {
 
	}
 
}
