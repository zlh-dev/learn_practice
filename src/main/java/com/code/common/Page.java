package com.code.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 分页数据封装类
 *
 * @author zlh-dev
 * @date 2020/05/23 14:37
 */
@Data
public class Page<T> {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 本页数据
     */
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     *
     * @param list 数据
     * @return {@link Page <T>}
     */
    public static <T> Page<T> restPage(List<T> list) {
        Page<T> result = new Page<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

}