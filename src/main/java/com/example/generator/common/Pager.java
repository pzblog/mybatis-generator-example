package com.example.generator.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-16
 */
public class Pager<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -6557244954523041805L;

    /**
     * 当前页数
     */
    private int currPage;

    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总记录数
     */
    private int totalCount;

    /**
     * 列表数据
     */
    private List<T> list;

    public Pager(int currPage, int pageSize) {
        this.currPage = currPage;
        this.pageSize = pageSize;
    }

    public Pager(int currPage, int pageSize, int totalCount, List<T> list) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);;
        this.totalCount = totalCount;
        this.list = list;
    }

    public int getCurrPage() {
        return currPage;
    }

    public Pager setCurrPage(int currPage) {
        this.currPage = currPage;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Pager setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public Pager setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public Pager setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public Pager setList(List<T> list) {
        this.list = list;
        return this;
    }
}
