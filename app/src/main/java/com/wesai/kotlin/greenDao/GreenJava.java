package com.wesai.kotlin.greenDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by long on 2017/11/20.
 */

@Entity
public class GreenJava {

    /*主键；设置为自动增长*/
    @Id(autoincrement = true)
    public Long id;

    /*属性；可以设置属性在数据库中的名称*/
    @Property(nameInDb = "userName")
    public String name;

    /*该字段不能为空*/
    @NotNull
    public String phone = "";

    /*该字段不会在数据库表中建立字段*/
    @Transient
    public String address = "";

    @Generated(hash = 480923557)
    public GreenJava(Long id, String name, @NotNull String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Generated(hash = 1643052482)
    public GreenJava() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "GreenJava{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
