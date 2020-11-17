package com.example.generator.core;

import java.io.Serializable;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-16
 */
public class BaseDTO implements Serializable {

    /**
     * 请求token
     */
    private String token;

    /**
     * 当前页数
     */
    private Integer currPage = 1;

    /**
     * 每页记录数
     */
    private Integer pageSize = 20;

    /**
     * 分页参数（第几行）
     */
    private Integer start;

    /**
     * 分页参数（行数）
     */
    private Integer end;

    /**
     * 登录人ID
     */
    private String loginUserId;

    /**
     * 登录人名称
     */
    private String loginUserName;

    public String getToken() {
        return token;
    }

    public BaseDTO setToken(String token) {
        this.token = token;
        return this;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public BaseDTO setCurrPage(Integer currPage) {
        this.currPage = currPage;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public BaseDTO setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getStart() {
        if (this.currPage != null && this.currPage > 0) {
            start = (currPage - 1) * getPageSize();
            return start;
        }
        return start == null ? 0 : start;
    }

    public BaseDTO setStart(Integer start) {
        this.start = start;
        return this;
    }

    public Integer getEnd() {
        return getPageSize();
    }

    public BaseDTO setEnd(Integer end) {
        this.end = end;
        return this;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public BaseDTO setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
        return this;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public BaseDTO setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
        return this;
    }


}
