package com.example.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * 用户信息.
 * @author Administrator
 *
 */
@Entity
public class UserInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long uid;// 用户id

    @Column(unique = true)
    private String username;// 帐号

    private String password; // 密码;

    private String email;
    private String phone;
    @ManyToMany(fetch = FetchType.EAGER) // 立即从数据库中进行加载数据
    @JoinTable(name = "UserAtendAgend", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
            @JoinColumn(name = "aid") })
    List<Agenda> attendgendas;
    @OneToMany(mappedBy="Initiator",fetch=FetchType.EAGER)
    List<Agenda> createdgendas;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
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



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Agenda> getAttendgendas() {
        return attendgendas;
    }

    public void setAttendgendas(List<Agenda> attendgendas) {
        this.attendgendas = attendgendas;
    }

    public List<Agenda> getCreatedgendas() {
        return createdgendas;
    }

    public void setCreatedgendas(List<Agenda> createdgendas) {
        this.createdgendas = createdgendas;
    }
}