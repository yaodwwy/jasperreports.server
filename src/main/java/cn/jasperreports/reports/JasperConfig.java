package cn.jasperreports.reports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
public class JasperConfig extends WebMvcConfigurerAdapter {

    private final static String REPORT_DATA_KEY = "datasource";

    @Bean
    public JasperReportsViewResolver getJasperReportsViewResolver(){
        JasperReportsViewResolver resolver = new JasperReportsViewResolver();
        resolver.setReportDataKey(REPORT_DATA_KEY);
        resolver.setPrefix("classpath:jrxml/");
        resolver.setSuffix(".jasper");
        resolver.setViewNames("*report*");
        //通配视图名称 必须包含此名称的jasper文件才被解析 以上同理
        resolver.setViewClass(JasperReportsMultiFormatView.class);
        resolver.setOrder(1);
        return resolver;
    }

}
