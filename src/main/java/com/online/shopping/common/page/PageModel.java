package com.online.shopping.common.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.io.Serializable;
import java.util.List;

/**
 * 分页.
 *
 * @param <T> T
 * @author yemin
 */
public class PageModel<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 每页显示多少条
     */
    private int perpage = 10;
    /**
     * 当前显示第几页.
     */
    private int currentpage = 1;
    /**
     * 总共有多少条.
     */
    private int totalcount = 0;
    /**
     * 总共有多少页.
     */
    private int totalpage = 0;
    /**
     * 放数据.
     */
    private List<T> data;

    public PageModel() {
        super();
    }

    /**
     * app page.
     *
     * @param perpage
     * @param currentpage
     */
    public PageModel(final Integer perpage, final Integer currentpage) {
        super();
        if (perpage != null && perpage.intValue() > 0) {
            this.perpage = perpage;
        }
        if (currentpage != null && currentpage.intValue() > 0) {
            this.currentpage = currentpage;
        }
    }

    /**
     * get per page.
     *
     * @return Integer
     */
    public int getPerpage() {
        return perpage;
    }

    /**
     * Set the number of pages per page.
     *
     * @param perpage perpage
     */
    public void setPerpage(final int perpage) {
        this.perpage = perpage;
        if (totalcount != 0) {
            setTotalcount(totalcount); // 重新设置条数和页数（计算页数会用到everyPageCount）
        }
    }

    /**
     * 获取当前显示第几页.
     *
     * @return Integer
     */
    public int getCurrentpage() {
        return currentpage;
    }

    /**
     * 设置当前显示第几页.
     *
     * @param currentpage CurrentPage
     */
    public void setCurrentpage(final int currentpage) {
        this.currentpage = currentpage;
    }

    /**
     * 获取总共有几页.
     *
     * @return Integer
     */
    public int getTotalcount() {
        return totalcount;
    }

    /**
     * 设置总共有几页.
     *
     * @param totalcount totalCount
     */
    public void setTotalcount(final int totalcount) {
        this.totalcount = totalcount;

        int pageCount = totalcount / this.perpage; // 取除的结果
        final int yu = totalcount % this.perpage; // 取余
        if (yu > 0) {
            pageCount++;
            this.totalpage = pageCount;
        }
    }

    /**
     * 获取总共多少页.
     *
     * @return Integer
     */
    public int getTotalpage() {
        return totalpage;
    }

    /**
     * 设置总共多少页。
     *
     * @param totalpage
     */
    public void setTotalpage(final int totalpage) {
        this.totalpage = totalpage;
    }

    /**
     * 获得数据.
     *
     * @return List
     */
    public List<T> getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(final List<T> data) {
        this.data = data;
    }

    /**
     * start.
     */
    public void start() {
        PageHelper.startPage(currentpage, perpage);
    }

    /**
     * 设置结果.
     *
     * @param cvList list
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setResult(final List cvList) {
        if (cvList != null && !cvList.isEmpty()) {
            final Page listCountry = (Page) cvList;
            setData(listCountry.getResult());
            setTotalcount((int) listCountry.getTotal());
            setTotalpage(listCountry.getPages());
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + currentpage;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + perpage;
        result = prime * result + totalcount;
        result = prime * result + totalpage;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("rawtypes")
        final PageModel other = (PageModel) obj;
        if (currentpage != other.currentpage) {
            return false;
        }
        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!data.equals(other.data)) {
            return false;
        }
        if (perpage != other.perpage) {
            return false;
        }
        if (totalcount != other.totalcount) {
            return false;
        }
        return (totalpage != other.totalpage ? false : true);
    }

    @Override
    public String toString() {
        return "AppPage [perpage=" + perpage + ", currentpage=" + currentpage
                + ", totalcount=" + totalcount + ", totalpage=" + totalpage + ", data="
                + data + "]";
    }

    public AppPage<T> convertToAppPageModel() {
        return new AppPage<>(perpage, currentpage, totalcount, totalpage,
                data);
    }
}
