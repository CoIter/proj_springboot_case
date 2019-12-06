package com.maxsh.model;

import com.maxsh.param.PageParam;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * Page
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/06
 */
public class Page<E> implements Serializable {
    /**
     * 当前页数
     */
    private int     currentPage = 1;
    /**
     * 总页数
     */
    private long    totalPage;
    /**
     * 总记录数
     */
    private long    totalNumber;
    /**
     * 数据集
     */
    private List<E> list;

    public Page() {
        super();
    }

    /**
     * @param beginLine   当前页数
     * @param totalNumber 总记录数
     * @param pageSize    页大小
     * @param list        页数据
     */
    public Page(int beginLine, long totalNumber, int pageSize, List<E> list) {
        super();
        this.currentPage = beginLine / pageSize + 1;
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageSize == 0 ? totalNumber
                / pageSize : totalNumber / pageSize + 1;
    }

    public Page(PageParam pageParam, long totalNumber, List<E> list){
        super();
        this.currentPage = pageParam.getCurrentPage();
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageParam.getPageSize() == 0 ? totalNumber
                / pageParam.getPageSize() : totalNumber / pageParam.getPageSize() + 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Page.class.getSimpleName() + "[", "]")
                .add("currentPage=" + currentPage)
                .add("totalPage=" + totalPage)
                .add("totalNumber=" + totalNumber)
                .add("list=" + list)
                .toString();
    }
}
