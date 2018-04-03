package cn.jasperreports.reports.controller;

import cn.jasperreports.reports.entity.MemberEntity;
import cn.jasperreports.reports.service.IJasperService;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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
}
