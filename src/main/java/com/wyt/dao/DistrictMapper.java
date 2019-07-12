package com.wyt.dao;

import com.wyt.bean.District;

import java.util.List;

public interface DistrictMapper {
//查询全部城区信息
    public List<District> finddistrictlist();

    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}