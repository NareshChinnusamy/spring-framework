package com.springframework.spring5intro.datasource;

public class DatasourceServiceImpl {

    private String userName;

    private String password;

    private String jdbcSource;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcSource() {
        return jdbcSource;
    }

    public void setJdbcSource(String jdbcSource) {
        this.jdbcSource = jdbcSource;
    }
}
