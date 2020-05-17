package com.patel.pradeep.deployablewar.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class ServletAttributeSetter implements ServletContextAware, InitializingBean {

    private ServletContext servletContext;


    public void updateContext(){

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        updateContext();
    }
}
