package com.djd.crm.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-14 23:15
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	//当前页码
    private int page = 1;
    //每页条数
    private int limit = 10;

    public Query(Map<String, Object> params){
        this.putAll(params);
        
        if(params.get("page") != null){
        	this.page = Integer.parseInt(params.get("page").toString());
        }
        
        if(params.get("limit") != null){
        	this.limit = Integer.parseInt(params.get("limit").toString());
        }
        
        //分页参数
        this.put("offset", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);

        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        if(params.get("sidx") != null && params.get("order") != null){
        	String sidx = params.get("sidx").toString();
        	String order = params.get("order").toString();
        	this.put("sidx", SQLFilter.sqlInject(sidx));
        	this.put("order", SQLFilter.sqlInject(order));
        }
    }

    public Query(){
        //分页参数
        this.put("offset", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
