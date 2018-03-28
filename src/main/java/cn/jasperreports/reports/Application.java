package cn.jasperreports.reports;

import cn.jasperreports.reports.entity.MemberEntity;
import cn.jasperreports.reports.service.IJasperService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
