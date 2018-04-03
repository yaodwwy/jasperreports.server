package cn.adbyte.jasperreports.repository;

import cn.adbyte.jasperreports.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface  MemberRepository extends JpaRepository<MemberEntity,UUID> {
}
