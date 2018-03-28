package cn.jasperreports.reports.entity;

import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Cacheable
@Table(name = "t_member")
public class MemberEntity extends BaseEntity {

    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;

    public MemberEntity() {
    }

    public MemberEntity(Boolean del, Date last, Date time, UUID operator, String username, String password, String name, String phone, String email) {
        super(del, last, time, operator);
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}