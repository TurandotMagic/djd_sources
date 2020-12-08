package com.djd.crm.util;

/**
 * Created by HP on 2020/11/18.
 */
public interface PageTurn {
    PageUtils getData(int pageNo);
    void handle(PageUtils date);
}
