package cn.adbyte.jasperreports.service;

import cn.adbyte.jasperreports.entity.MemberEntity;

import java.util.List;

public interface IJasperService {
    List<MemberEntity> save();

    List<MemberEntity> getReportsData();
}
