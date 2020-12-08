package com.djd.crm.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2020/12/1.
 */
public class RoleEntity {

    private String id;
    private String sn;
    private String name;
    private List<PermissionEntity> permissionList = new ArrayList<PermissionEntity>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionEntity> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionEntity> permissionList) {
        this.permissionList = permissionList;
    }
}
