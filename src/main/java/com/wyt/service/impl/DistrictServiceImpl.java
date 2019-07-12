package com.wyt.service.impl;

import com.wyt.bean.District;
import com.wyt.dao.DistrictMapper;
import com.wyt.service.DistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 爱明天，更爱大佬
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Resource
    private DistrictMapper districtMapper;

    @Override
    public List<District> finddistricts() {
        return districtMapper.finddistrictlist();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(District record) {
        return 0;
    }

    @Override
    public int insertSelective(District record) {
        return 0;
    }

    @Override
    public District selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(District record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(District record) {
        return 0;
    }
}
