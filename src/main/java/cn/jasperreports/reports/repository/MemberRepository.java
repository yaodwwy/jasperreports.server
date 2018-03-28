package cn.jasperreports.reports.repository;

import cn.jasperreports.reports.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface  MemberRepository extends JpaRepository<MemberEntity,UUID> {
}
