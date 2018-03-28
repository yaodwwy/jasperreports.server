package cn.jasperreports.reports.service;

import cn.jasperreports.reports.entity.MemberEntity;

import java.util.List;

public interface IJasperService {
    List<MemberEntity> save();

    List<MemberEntity> getReportsData();
}
