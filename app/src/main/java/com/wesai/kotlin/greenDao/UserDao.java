package com.wesai.kotlin.greenDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by long on 2017/11/20.
 */
@Entity
public class UserDao {
    @Id
    public String id;
    @Property
    public String name;

    @Generated(hash = 2144066795)
    public UserDao(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 917059161)
    public UserDao() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
