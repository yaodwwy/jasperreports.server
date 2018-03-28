package cn.jasperreports.reports.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    protected Boolean del = false;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date last;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date time;
    protected UUID operator;

    public BaseEntity() {
    }

    public BaseEntity(Boolean del, Date last, Date time, UUID operator) {
        this.del = del;
        this.last = last;
        this.time = time;
        this.operator = operator;
    }

    public BaseEntity(UUID id, Boolean del, Date last, Date time, UUID operator) {
        this(del, last, time, operator);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Date getLast() {
        return last;
    }

    public void setLast(Date last) {
        this.last = last;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public UUID getOperator() {
        return operator;
    }

    public void setOperator(UUID operator) {
        this.operator = operator;
    }
}
