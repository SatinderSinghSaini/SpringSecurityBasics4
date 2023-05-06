package com.learnspringsecurity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="notice_details")
public class Notice {
    @Id
    @Column(name = "notice_id")
    private Long id;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notic_beg_dt")
    private Date noticeBegDt;

    @Column(name = "notic_end_dt")
    private Date noticeEndDt;

    @Column(name = "create_dt")
    private Date createDt;

    @Column(name = "update_dt")
    private Date updateDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public Date getNoticeBegDt() {
        return noticeBegDt;
    }

    public void setNoticeBegDt(Date noticeBegDt) {
        this.noticeBegDt = noticeBegDt;
    }

    public Date getNoticeEndDt() {
        return noticeEndDt;
    }

    public void setNoticeEndDt(Date noticeEndDt) {
        this.noticeEndDt = noticeEndDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}
