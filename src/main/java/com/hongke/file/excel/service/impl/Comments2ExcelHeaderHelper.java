package com.hongke.file.excel.service.impl;

import com.alibaba.excel.EasyExcel;
import com.hongke.file.excel.dao.TableDao;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hanksrang
 * @site cn.hongkezhang.com
 * @date 2022年06月01日
 */
@Service
@Log
public class Comments2ExcelHeaderHelper {

    @Autowired
    private TableDao tableDao;

    @Value("${tablename}")
    private String tableName;

    @Value("${filepath}")
    private String filePath;

    public void export() {
        String[] tables = tableName.split(",");
        if (tables == null || tables.length < 1) {
            log.info("===== 没有输入任何表名！=====");
            return;
        }
        for (String ta : tables) {
            Map<String, String> map = tableDao.queryTable(ta);
            log.info("map: " + map);
            List<Map<String, String>> mapList = tableDao.queryColumns(ta);
            List<String> cols = new ArrayList<>();
            mapList.stream().map(x -> x.get("columnComment")).forEach(x -> cols.add(x));
            EasyExcel.write(filePath + ta + ".xlsx").head(getHead(cols)).sheet("模板").doWrite((Collection<?>) null);
        }
    }

    private List<List<String>> getHead(List<String> columns) {
        List<List<String>> res = new ArrayList<>();
        for(String col : columns) {
            List<String> head = new ArrayList<>();
            head.add(col);
            res.add(head);
        }
        return res;
    }

}
