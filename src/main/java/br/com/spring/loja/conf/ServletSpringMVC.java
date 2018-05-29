package br.com.spring.loja.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SecurityConfiguration.class, 
				AppWebConfiguration.class, JPAConfiguration.class,
		JPAProductionConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter, new OpenEntityManagerInViewFilter()};
    }
	
	//veja tbm https://cursos.alura.com.br/forum/topico-atualizacao-resources-nao-sao-carregados-na-aula-10-58813
	@Override
	protected void customizeRegistration(Dynamic registration) {
			registration.setMultipartConfig(new MultipartConfigElement(""));
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		super.onStartup(servletContext);
//		servletContext.addListener(RequestContextListener.class);
//		servletContext.setInitParameter("spring.profiles.active", "dev");
//	}
}