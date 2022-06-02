package com.hongke.file.excel.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 列的属性
 *
 * @author hanksrang
 * @site cn.hongkezhang.com
 * @date 2022年06月01日
 */
@Mapper
public interface TableDao {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

}
