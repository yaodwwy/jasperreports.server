package cn.jasperreports.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
public class JasperConfig extends WebMvcConfigurerAdapter {

    private final static String REPORT_DATA_KEY = "datasource";
    private final static String PATH_KEY = "classpath:jrxml/";
    private final static String TYPE_KEY = ".jrxml";
    private final static String VIEW_KEY = "report";

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public JasperReportsViewResolver getJasperReportsViewResolver(){
        JasperReportsViewResolver resolver = new JasperReportsViewResolver();
        resolver.setPrefix(PATH_KEY);
        resolver.setSuffix(TYPE_KEY);
        resolver.setReportDataKey(REPORT_DATA_KEY);
        resolver.setViewNames("*" + VIEW_KEY + "*"); //视图名称，模板名称需要符合 *你定义的key* 如*Report*
        resolver.setViewClass(JasperReportsMultiFormatView.class);
        resolver.setOrder(1);
        return resolver;
    }
}
