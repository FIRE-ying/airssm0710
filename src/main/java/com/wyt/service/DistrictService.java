package com.wyt.service;

import com.wyt.bean.District;

import java.util.List;

public interface DistrictService {
//查询全部城区信息
    public List<District> finddistricts();

    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}