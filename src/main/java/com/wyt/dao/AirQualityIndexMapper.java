package com.wyt.dao;

import com.wyt.bean.AirQualityIndex;

import java.util.List;
import java.util.Map;

public interface AirQualityIndexMapper {
    //查询全部监测数据
    public List<AirQualityIndex> findallair(Map map);


    //根据主键删除
    int deleteByPrimaryKey(Integer id);

    int insert(AirQualityIndex record);
    //新增监测数据
    int insertSelective(AirQualityIndex record);
   // 根据主键查询
    AirQualityIndex selectByPrimaryKey(Integer id);
   //更新监测数据
    int updateByPrimaryKeySelective(AirQualityIndex record);

    int updateByPrimaryKey(AirQualityIndex record);
}