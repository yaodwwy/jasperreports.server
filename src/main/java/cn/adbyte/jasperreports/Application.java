package cn.adbyte.jasperreports;

import cn.adbyte.jasperreports.service.IJasperService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
@SpringBootApplication
public class Application {
    @Resource
    private IJasperService iJasperService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
