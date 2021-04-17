package org.tuniu.mybatis.entity;

import java.util.List;

public class LwUserListJob {
    private String userId; //用户id
    private String userName; //用户名称
    private List<LwUserJob> userJobList;//用户工作信息

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<LwUserJob> getUserJobList() {
        return userJobList;
    }

    public void setUserJobList(List<LwUserJob> userJobList) {
        this.userJobList = userJobList;
    }

    @Override
    public String toString() {
        return "LwUserListJob{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userJobList=" + userJobList +
                '}';
    }
}
