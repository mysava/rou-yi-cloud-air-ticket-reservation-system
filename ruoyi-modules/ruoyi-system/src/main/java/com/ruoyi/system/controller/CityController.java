package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.domain.City;
import com.ruoyi.system.service.ICityService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 地区Controller
 * 
 * @author ruoyi
 * @date 2022-05-30
 */
@RestController
@RequestMapping("/city")
public class CityController extends BaseController
{
    @Autowired
    private ICityService cityService;

    /**
     * 查询地区列表
     */
    @RequiresPermissions("system:city:list")
    @GetMapping("/list")
    public TableDataInfo list(City city)
    {
        startPage();
        List<City> list = cityService.selectCityList(city);
        return getDataTable(list);
    }

    /**
     * 导出地区列表
     */
    @RequiresPermissions("system:city:export")
    @Log(title = "地区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, City city)
    {
        List<City> list = cityService.selectCityList(city);
        ExcelUtil<City> util = new ExcelUtil<City>(City.class);
        util.exportExcel(response, list, "地区数据");
    }

    /**
     * 获取地区详细信息
     */
    @RequiresPermissions("system:city:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cityService.selectCityById(id));
    }

    /**
     * 新增地区
     */
    @RequiresPermissions("system:city:add")
    @Log(title = "地区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody City city)
    {
        return toAjax(cityService.insertCity(city));
    }

    /**
     * 修改地区
     */
    @RequiresPermissions("system:city:edit")
    @Log(title = "地区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody City city)
    {
        return toAjax(cityService.updateCity(city));
    }

    /**
     * 删除地区
     */
    @RequiresPermissions("system:city:remove")
    @Log(title = "地区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cityService.deleteCityByIds(ids));
    }
}
