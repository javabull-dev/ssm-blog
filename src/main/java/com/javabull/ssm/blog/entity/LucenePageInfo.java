package com.javabull.ssm.blog.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 */
@Data
@ToString
public class LucenePageInfo<T> implements Serializable {
    //当前页
    private int pageNum;
    //所有数据页数
    private int pages;
    //数据
    private List<T> list;
    //是否有上一页
    private boolean hasNextPage;
    //是否有下一页
    private boolean hasPreviousPage;
    //导航的页数组
    private int[] navigatepageNums;
}
