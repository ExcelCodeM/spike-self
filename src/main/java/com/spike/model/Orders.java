package com.spike.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Orders {
    private long orderId;
    private String courseNo;
    private String username;
    private String courseName;
    private Integer coursePrice;
    private BigDecimal payPrice;
    private String payment;
    private String payStatus;
    private Timestamp payDate;
    private Timestamp createDate;
    private String creatBy;
    private Timestamp updateDate;
    private String updateBy;
    private String coursePic;

    @Id
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "course_no")
    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "course_price")
    public Integer getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Integer coursePrice) {
        this.coursePrice = coursePrice;
    }

    @Basic
    @Column(name = "pay_price")
    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    @Basic
    @Column(name = "payment")
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "pay_status")
    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    @Basic
    @Column(name = "pay_date")
    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "creat_by")
    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "course_pic")
    public String getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId &&
                Objects.equals(courseNo, orders.courseNo) &&
                Objects.equals(username, orders.username) &&
                Objects.equals(courseName, orders.courseName) &&
                Objects.equals(coursePrice, orders.coursePrice) &&
                Objects.equals(payPrice, orders.payPrice) &&
                Objects.equals(payment, orders.payment) &&
                Objects.equals(payStatus, orders.payStatus) &&
                Objects.equals(payDate, orders.payDate) &&
                Objects.equals(createDate, orders.createDate) &&
                Objects.equals(creatBy, orders.creatBy) &&
                Objects.equals(updateDate, orders.updateDate) &&
                Objects.equals(updateBy, orders.updateBy) &&
                Objects.equals(coursePic, orders.coursePic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, courseNo, username, courseName, coursePrice, payPrice, payment, payStatus, payDate, createDate, creatBy, updateDate, updateBy, coursePic);
    }
}
