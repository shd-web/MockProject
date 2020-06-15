package javax.servlet;


	import java.io.IOException;

import javax.servlet.annotation.WebFilter;

	/**
	 * Servlet Filter implementation class Filter
	 */
	@WebFilter("/*")
	public class filter implements javax.servlet.Filter {

	    /**
	     * Default constructor.
	     */
	    public filter() {
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see Filter#destroy()
	     */
	    public void destroy() {
	        // TODO Auto-generated method stub
	    }

	    /**
	     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	     */
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	        // TODO Auto-generated method stub
	        // place your code here
	        request.setCharacterEncoding("UTF-8");

	        // pass the request along the filter chain
	        chain.doFilter(request, response);
	    }

	    /**
	     * @see Filter#init(FilterConfig)
	     */
	    public void init(FilterConfig fConfig) throws ServletException {
	        // TODO Auto-generated method stub
	    }
	}


