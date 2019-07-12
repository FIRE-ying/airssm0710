package com.wyt.web;

import com.alibaba.druid.sql.PagerUtils;
import com.github.pagehelper.PageInfo;
import com.wyt.bean.AirQualityIndex;
import com.wyt.bean.District;
import com.wyt.service.AirQualityIndexService;
import com.wyt.service.DistrictService;
import com.wyt.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * 爱明天，更爱大佬
 */
@Controller
public class AirQualityIndexController {
    @Resource
    private AirQualityIndexService airQualityIndexService;
    @Resource
    private DistrictService districtService;

    /**
     * 检索空气质量检测信息库
     * @param index
     * @param districtId
     * @param map
     * @return
     */
    @RequestMapping("/weather/findall")
    public String findall(@RequestParam(defaultValue = "1") int index,
                          @RequestParam(defaultValue = "-1") int districtId, ModelMap map){
        List<District> districtList = districtService.finddistricts();
        PageInfo<AirQualityIndex> pageInfo =
                airQualityIndexService.findallair(index, PageUtil.pagesize, districtId);
        map.addAttribute("pageInfo",pageInfo);
        map.addAttribute("districtId",districtId);
        map.addAttribute("districtlist",districtList);
        return "show";
    }

    /**
     * 新增前先查询区域信息
     * @param map
     * @return
     */
    @RequestMapping("/weather/finddistrict")
    public String finddistrict(ModelMap map){
        List<District> districts = districtService.finddistricts();
        map.addAttribute("districts",districts);
        return "add";
    }

    /**
     * 新增
     * @param airQualityIndex
     * @param response
     */
    @RequestMapping("/weather/addair")
    public void addair(AirQualityIndex airQualityIndex, HttpServletResponse response){
        try {
            airQualityIndex.setLastModifyTime(new Date());
            int i = airQualityIndexService.insertSelective(airQualityIndex);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if (i>0){
                out.print("<script type='text/javascript'>alert('保存成功');location.href='/weather/findall'</script>");
            }else {
                out.print("<script type='text/javascript'>alert('保存失败');location.href='/weather/finddistrict'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改前先查询空气质量信息
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/weather/findbyid")
    public String findbyid(int id,ModelMap map){
        List<District> districtList = districtService.finddistricts();
        AirQualityIndex airQualityIndex = airQualityIndexService.selectByPrimaryKey(id);
        map.addAttribute("airQualityIndex",airQualityIndex);
        map.addAttribute("districtList",districtList);
        return "update";
    }

    /**
     * 更新天气监测状况
     * @param airQualityIndex
     * @param response
     */
    @RequestMapping("/weather/updateair")
    public void updateair(AirQualityIndex airQualityIndex,HttpServletResponse response){
        try {
            airQualityIndex.setLastModifyTime(new Date());
            int i = airQualityIndexService.updateByPrimaryKeySelective(airQualityIndex);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if (i>0){
                out.print("<script type='text/javascript'>alert('更新成功');location.href='/weather/findall'</script>");
            }else {
                out.print("<script type='text/javascript'>alert('更新失败');" +
                        "location.href='/weather/findbyid?id="+airQualityIndex.getId()+"'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/weather/deleteair")
    public void deleteair(int id,HttpServletResponse response){
        try {
            int i = airQualityIndexService.deleteByPrimaryKey(id);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if (i>0){
                out.print("<script type='text/javascript'>alert('删除成功');location.href='/weather/findall'</script>");
            }else {
                out.print("<script type='text/javascript'>alert('删除失败');location.href='/weather/findall'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
