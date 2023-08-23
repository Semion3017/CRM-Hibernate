package com.example.demo;




import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.example.demo.util.UtilsHiber;


@ComponentScan ({"com.example.demo.dao", "com.example.demo", "com.example.demo.controller","com.example.demo.customException", "com.example.demo.dto", "com.example.demo.entity", "com.example.demo.service", "com.example.demo.util"})
public class CrmHibernateApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

//	public static void main(String[] args) {
//		SpringApplication.run(CrmHibernateApplication.class, args);
//	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{UtilsHiber.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		 return new Class[]{WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
