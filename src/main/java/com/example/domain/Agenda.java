package com.example.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * User: FlowingFire
 * Date: 2017/11/14 0014
 * Time: 21:16
 * Description:
 */
@Entity
public class Agenda {
    @Id
    @GeneratedValue
    private long aid;// 会议aid
    @Column(unique = true)
    private String title;//name
    @ManyToOne(targetEntity = UserInfo.class)
    @JoinColumn(name="Initiator")
    private UserInfo Initiator;
    @ManyToMany(fetch = FetchType.EAGER) // 立即从数据库中进行加载数据
    @JoinTable(name = "UserAtendAgend", joinColumns = { @JoinColumn(name = "aid") }, inverseJoinColumns = {
            @JoinColumn(name = "uid") })
    private List<UserInfo> participators;
    private Date starttime;
    private Date endtime;

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserInfo getInitiator() {
        return Initiator;
    }

    public void setInitiator(UserInfo initiator) {
        Initiator = initiator;
    }


    public List<UserInfo> getParticipators() {
        return participators;
    }

    public void setParticipators(List<UserInfo> participators) {
        this.participators = participators;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
