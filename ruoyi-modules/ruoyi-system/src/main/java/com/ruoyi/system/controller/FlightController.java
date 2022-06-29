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
import com.ruoyi.system.domain.Flight;
import com.ruoyi.system.service.IFlightService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * flightController
 * 
 * @author ruoyi
 * @date 2022-06-19
 */
@RestController
@RequestMapping("/flight")
public class FlightController extends BaseController
{
    @Autowired
    private IFlightService flightService;

    /**
     * 查询flight列表
     */
    @RequiresPermissions("system:flight:list")
    @GetMapping("/list")
    public TableDataInfo list(Flight flight)
    {
        startPage();
        List<Flight> list = flightService.selectFlightList(flight);
        return getDataTable(list);
    }

    /**
     * 导出flight列表
     */
    @RequiresPermissions("system:flight:export")
    @Log(title = "flight", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Flight flight)
    {
        List<Flight> list = flightService.selectFlightList(flight);
        ExcelUtil<Flight> util = new ExcelUtil<Flight>(Flight.class);
        util.exportExcel(response, list, "flight数据");
    }

    /**
     * 获取flight详细信息
     */
    @RequiresPermissions("system:flight:query")
    @GetMapping(value = "/{flightid}")
    public AjaxResult getInfo(@PathVariable("flightid") Long flightid)
    {
        return AjaxResult.success(flightService.selectFlightByFlightid(flightid));
    }

    /**
     * 新增flight
     */
    @RequiresPermissions("system:flight:add")
    @Log(title = "flight", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Flight flight)
    {
        return toAjax(flightService.insertFlight(flight));
    }

    /**
     * 修改flight
     */
    @RequiresPermissions("system:flight:edit")
    @Log(title = "flight", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Flight flight)
    {
        return toAjax(flightService.updateFlight(flight));
    }

    /**
     * 删除flight
     */
    @RequiresPermissions("system:flight:remove")
    @Log(title = "flight", businessType = BusinessType.DELETE)
	@DeleteMapping("/{flightids}")
    public AjaxResult remove(@PathVariable Long[] flightids)
    {
        return toAjax(flightService.deleteFlightByFlightids(flightids));
    }

    /**
     * 预订flight
     */
    @RequiresPermissions("system:flight:book")
    @Log(title = "flight", businessType = BusinessType.UPDATE)
    @PatchMapping
    public AjaxResult book(@RequestBody Flight flight) { return toAjax(flightService.bookFlight(flight)); }
}
