package com.ardhiart.datasiswa.API.Model;

/**
 * Created by Hinata on 10/16/2017.
 */
public class LoginResponse {
    String id = "";
    int ttl = 0;
    String created = "";
    String userId = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
