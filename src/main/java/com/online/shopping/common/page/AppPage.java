package com.online.shopping.common.page;

import java.io.Serializable;
import java.util.List;

public class AppPage
        <T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int perpage = 10;// item count per page
    private int currentpage = 1;
    private int totalcount = 0;
    private int totalpage = 0;

    private List<T> data;

    public AppPage() {
        super();
    }

    public AppPage(final int perpage, final int currentpage,
                        final int totalcount, final int totalpage, final List<T> data) {
        super();
        this.perpage = perpage;
        this.currentpage = currentpage;
        this.totalcount = totalcount;
        this.totalpage = totalpage;
        this.data = data;
    }


    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(final int perpage) {
        this.perpage = perpage;
        if (totalcount != 0)
            setTotalcount(totalcount);
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(final int currentpage) {
        this.currentpage = currentpage;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(final int totalcount) {
        this.totalcount = totalcount;

        int pageCount = totalcount / this.perpage;
        final int yu = totalcount % this.perpage;
        if (yu > 0)
            pageCount++;
        this.totalpage = pageCount;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(final int totalpage) {
        this.totalpage = totalpage;
    }

    public Object getData() {
        return data;
    }

    public void setData(final List<T> data) {
        this.data = data;
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

}
