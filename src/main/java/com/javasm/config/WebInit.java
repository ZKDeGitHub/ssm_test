package com.javasm.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Author zk
 * @Date 2023/7/10 16:27
 * @注释：
 */
public class WebInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // 获取上下文对象
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setServletContext(servletContext);

        // 注册配置类（声明配置类所在的文件）
        applicationContext.register(SpringConfig.class);
        applicationContext.register(SpringMvcConfig.class);

        // 获取全局控制器
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));
        // 拦截所有/
        dispatcher.addMapping("/");
        // 启动优先级
        dispatcher.setLoadOnStartup(1);

    }
}
