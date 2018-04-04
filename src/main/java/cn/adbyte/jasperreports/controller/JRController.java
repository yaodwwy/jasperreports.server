package cn.adbyte.jasperreports.controller;

import cn.adbyte.jasperreports.entity.MemberEntity;
import cn.adbyte.jasperreports.service.IJasperService;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jasper")
public class JRController {

    private static final String FILE_FORMAT = "format";
    private static final String DATASOURCE = "datasource";


    @Resource
    IJasperService iJasperService;

    /**
     * @param modelMap   存放jrDataSource的容器
     * @param reportName 对应jrxml文件名
     * @return
     */

    @GetMapping("/{type}/{reportName}")
    public String getReports(final ModelMap modelMap,
                                   @PathVariable("type") final String type,
                                   @PathVariable("reportName") final String reportName) {
        //为了有测试数据先初始化一部分
        List<MemberEntity> save = iJasperService.save();

        //获取数据源
        List<MemberEntity> reportsData = iJasperService.getReportsData();
        //实例化JR数据源
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(reportsData);
        //写入请求作用域
        modelMap.put(DATASOURCE, jrBeanCollectionDataSource);
        modelMap.put(FILE_FORMAT, type);

        return reportName;
    }
    @GetMapping("/map/{type}/{reportName}")
    public String getMapReports(final ModelMap modelMap,
                                   @PathVariable("type") final String type,
                                   @PathVariable("reportName") final String reportName) {
        Map<String, Object> map = new HashMap<>();
        map.put("id","1");
        map.put("name","张三");
        map.put("score_chinese",50);
        map.put("ranking",1);
        map.put("score_top",30);
        map.put("score_math",80);
        map.put("score_english",70);
        map.put("score_chemistry",60);
        map.put("score_biology",50);
        map.put("score_physical",20);
        List<Map<String, ?>> lists = List.of(map);
        JRMapCollectionDataSource jrMapCollectionDataSource = new JRMapCollectionDataSource(lists);
        modelMap.put(DATASOURCE, jrMapCollectionDataSource);
        modelMap.put(FILE_FORMAT, type);
        modelMap.putAll(map);
        return reportName;
    }
}
