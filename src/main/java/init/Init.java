package init;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;


public class Init implements WebApplicationInitializer{



	public void onStartup(ServletContext container) throws ServletException {

		FilterRegistration.Dynamic characterEncodingFilter = container.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");
		characterEncodingFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");

		//spring容器
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

		//注册spring容器
		context.register(Configurator.class);
		container.addListener(new ContextLoaderListener(context));

		//servlet容器
		AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
		dispatcherServletContext.register(MVCConfigurator.class);
		ServletRegistration.Dynamic dispatcherServlet = container.addServlet("DispatcherServlet", new DispatcherServlet(dispatcherServletContext));
		dispatcherServlet.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("/");

	}



}
