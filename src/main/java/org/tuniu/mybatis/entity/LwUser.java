package org.tuniu.mybatis.entity;

public class LwUser {
    private String userId; //用户id
    private String userName; //用户名称
    private LwUserJob usreJobInfo;//用户工作信息

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

    public LwUserJob getUsreJobInfo() {
        return usreJobInfo;
    }

    public void setUsreJobInfo(LwUserJob usreJobInfo) {
        this.usreJobInfo = usreJobInfo;
    }

    @Override
    public String toString() {
        return "LwUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", usreJobInfo=" + usreJobInfo +
                '}';
    }
}
