package com.djd.crm.util;

import java.util.List;

/**
 * Created by HP on 2020/11/20.
 * 返回结果集,easyUI dataGrid表格会自动渲染数据到表格中
 * 字段名必须为total,rows
 */

public class PageResult {
    private int total;
    private List<?> rows;

    public int getTotal() {
        return total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public PageResult(int total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }
}
