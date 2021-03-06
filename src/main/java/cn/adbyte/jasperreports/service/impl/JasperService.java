package cn.adbyte.jasperreports.service.impl;

import cn.adbyte.jasperreports.service.IJasperService;
import cn.adbyte.jasperreports.entity.MemberEntity;
import cn.adbyte.jasperreports.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class JasperService implements IJasperService {

    @Resource
    private MemberRepository memberRepository;

    @Override
    public List<MemberEntity> save() {
        MemberEntity sanZhang = new MemberEntity(false,null,new Date(),UUID.randomUUID(),"san.Zhang", "123456", "张三", "1550123456", "sanZhang@test.com");
        MemberEntity siLi = new MemberEntity(false,null,new Date(),UUID.randomUUID(),"si.Li", "123456", "李四", "1250123456", "siLi@test.com");
        MemberEntity erWang = new MemberEntity(false,null,new Date(),UUID.randomUUID(),"er.Wang", "123456", "王二", "1250123456", "erWang@test.com");
        List<MemberEntity> list = memberRepository.save(List.of(sanZhang, siLi, erWang));
        return list;
    }

    @Override
    public List<MemberEntity> getReportsData() {
        List<MemberEntity> all = memberRepository.findAll();
        return all;
    }
}
