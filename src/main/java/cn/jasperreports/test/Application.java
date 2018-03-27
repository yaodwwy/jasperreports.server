package cn.jasperreports.test;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/jasper")
@SpringBootApplication
public class Application {
    private static final String REPORT_NAME = "reportName";
    private static final String FILE_FORMAT = "format";
    private static final String DATASOURCE = "datasource";

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    /**
     * 直接使用模板文件中的sql语句得到报表
     */
    @GetMapping("/{reportName}")
    public ModelAndView getReportByParam(final ModelMap modelMap,
                                         @PathVariable(REPORT_NAME) final String reportName,
                                         @RequestParam(FILE_FORMAT) final String format, HttpServletResponse response) {
        Collection itemsMap = new ArrayList();
        Map<String, Object> map = new HashMap();
//        map.put("name", "张山");
//        map.put("student_id", "2017121108");
//        map.put("ranking", 10);
//        map.put("score_math", 97);
//        map.put("score_chinese", 100);
//        map.put("score_english", 78);
//        map.put("score_chemistry", 70);
//        map.put("score_physical", 89);
//        map.put("score_biology", 99);
//        map.put("score_top", 88);
        map.put("id",1);
        map.put("first_name","Chloe");
        map.put("last_name","Brian");
        map.put("reportName",reportName);
        itemsMap.add(map);

        response.setContentType("text/html;charset=UTF-8");

        JRDataSource jrDataSource = new JRMapCollectionDataSource(itemsMap);
        modelMap.put(DATASOURCE, jrDataSource);
        modelMap.put(FILE_FORMAT, format);
        ModelAndView modelAndView = new ModelAndView(reportName, map);
        return modelAndView;
    }

}
