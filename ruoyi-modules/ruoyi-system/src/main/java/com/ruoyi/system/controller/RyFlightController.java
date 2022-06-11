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
 * 航班信息管理Controller
 * 
 * @author ruoyi
 * @date 2022-06-10
 */
@RestController
@RequestMapping("/flights")
public class RyFlightController extends BaseController
{
    @Autowired
    private IRyFlightService ryFlightService;

    /**
     * 查询航班信息管理列表
     */
    @RequiresPermissions("system:flights:list")
    @GetMapping("/list")
    public TableDataInfo list(RyFlight ryFlight)
    {
        startPage();
        List<RyFlight> list = ryFlightService.selectRyFlightList(ryFlight);
        return getDataTable(list);
    }

    /**
     * 导出航班信息管理列表
     */
    @RequiresPermissions("system:flights:export")
    @Log(title = "航班信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RyFlight ryFlight)
    {
        List<RyFlight> list = ryFlightService.selectRyFlightList(ryFlight);
        ExcelUtil<RyFlight> util = new ExcelUtil<RyFlight>(RyFlight.class);
        util.exportExcel(response, list, "航班信息管理数据");
    }

    /**
     * 获取航班信息管理详细信息
     */
    @RequiresPermissions("system:flights:query")
    @GetMapping(value = "/{flightno}")
    public AjaxResult getInfo(@PathVariable("flightno") String flightno)
    {
        return AjaxResult.success(ryFlightService.selectRyFlightByFlightno(flightno));
    }

    /**
     * 新增航班信息管理
     */
    @RequiresPermissions("system:flights:add")
    @Log(title = "航班信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RyFlight ryFlight)
    {
        return toAjax(ryFlightService.insertRyFlight(ryFlight));
    }

    /**
     * 修改航班信息管理
     */
    @RequiresPermissions("system:flights:edit")
    @Log(title = "航班信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RyFlight ryFlight)
    {
        return toAjax(ryFlightService.updateRyFlight(ryFlight));
    }

    /**
     * 删除航班信息管理
     */
    @RequiresPermissions("system:flights:remove")
    @Log(title = "航班信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{flightnos}")
    public AjaxResult remove(@PathVariable String[] flightnos)
    {
        return toAjax(ryFlightService.deleteRyFlightByFlightnos(flightnos));
    }
}
