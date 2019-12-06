package com.maxsh.param;

/**
 * PageParam
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/05
 */
public class PageParam {
    /**
     * 起始行
     */
    private int beginLine;
    private Integer pageSize = 3;
    /**
     * 当前页
     */
    private Integer currentPage=0;

    public int getBeginLine() {
        return beginLine;
    }

    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
