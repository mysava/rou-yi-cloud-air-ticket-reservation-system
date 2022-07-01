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
import com.ruoyi.system.domain.RyFlight;
import com.ruoyi.system.service.IRyFlightService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 航班管理Controller
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
@RestController
@RequestMapping("/flight")
public class RyFlightController extends BaseController
{
    @Autowired
    private IRyFlightService ryFlightService;

    /**
     * 查询航班管理列表
     */
    @RequiresPermissions("system:flight:list")
    @GetMapping("/list")
    public TableDataInfo list(RyFlight ryFlight)
    {
        startPage();
        List<RyFlight> list = ryFlightService.selectRyFlightList(ryFlight);
        return getDataTable(list);
    }

    /**
     * 导出航班管理列表
     */
    @RequiresPermissions("system:flight:export")
    @Log(title = "航班管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RyFlight ryFlight)
    {
        List<RyFlight> list = ryFlightService.selectRyFlightList(ryFlight);
        ExcelUtil<RyFlight> util = new ExcelUtil<RyFlight>(RyFlight.class);
        util.exportExcel(response, list, "航班管理数据");
    }

    /**
     * 获取航班管理详细信息
     */
    @RequiresPermissions("system:flight:query")
    @GetMapping(value = "/{flightid}")
    public AjaxResult getInfo(@PathVariable("flightid") Long flightid)
    {
        return AjaxResult.success(ryFlightService.selectRyFlightByFlightid(flightid));
    }

    /**
     * 新增航班管理
     */
    @RequiresPermissions("system:flight:add")
    @Log(title = "航班管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RyFlight ryFlight)
    {
        return toAjax(ryFlightService.insertRyFlight(ryFlight));
    }

    /**
     * 修改航班管理
     */
    @RequiresPermissions("system:flight:edit")
    @Log(title = "航班管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RyFlight ryFlight)
    {
        return toAjax(ryFlightService.updateRyFlight(ryFlight));
    }

    /**
     * 删除航班管理
     */
    @RequiresPermissions("system:flight:remove")
    @Log(title = "航班管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{flightids}")
    public AjaxResult remove(@PathVariable Long[] flightids)
    {
        return toAjax(ryFlightService.deleteRyFlightByFlightids(flightids));
    }
}
