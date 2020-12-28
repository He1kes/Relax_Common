package com.heikes.rent_common.vo;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Create By Intellij IDEA
 *
 * 分页结果类
 * @param <T>
 */
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //总页数
    private int pages;
    //所有导航页号
    private int[] navigatepageNums;
    //总记录数
    private long total;
    //结果集
    private List<T> list;

    public PageResult() {}

    public PageResult(int pageNum, int pageSize, int pages, long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = pages;
        this.total = total;
        this.list = list;
    }

    public PageResult(int pageNum, int pageSize, int pages, int[] navigatepageNums, long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = pages;
        this.navigatepageNums = navigatepageNums;
        this.total = total;
    }

    public PageResult(int pageNum, int pageSize, int pages, int[] navigatepageNums, long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = pages;
        this.navigatepageNums = navigatepageNums;
        this.total = total;
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pages=" + pages +
                ", navigatepageNums=" + Arrays.toString(navigatepageNums) +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
