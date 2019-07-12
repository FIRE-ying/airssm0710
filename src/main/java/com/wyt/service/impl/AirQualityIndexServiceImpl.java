package com.wyt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyt.bean.AirQualityIndex;
import com.wyt.dao.AirQualityIndexMapper;
import com.wyt.service.AirQualityIndexService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 爱明天，更爱大佬
 */
@Service
public class AirQualityIndexServiceImpl implements AirQualityIndexService {
    @Resource
    private AirQualityIndexMapper airmapper;
    @Override
    public PageInfo<AirQualityIndex> findallair(int index, int size, int districtId) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("districtId",districtId);
        List<AirQualityIndex> qualityIndexList = airmapper.findallair(map);
        PageInfo pageInfo=new PageInfo(qualityIndexList);
        return pageInfo;
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer id) {

        return airmapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AirQualityIndex record) {
        return 0;
    }

    @Override
    @Transactional
    public int insertSelective(AirQualityIndex record) {
        return airmapper.insertSelective(record);
    }

    @Override
    public AirQualityIndex selectByPrimaryKey(Integer id) {

        return airmapper.selectByPrimaryKey(id) ;
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(AirQualityIndex record) {

        return airmapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AirQualityIndex record) {
        return 0;
    }
}
