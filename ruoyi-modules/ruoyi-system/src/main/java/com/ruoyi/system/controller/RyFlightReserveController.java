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
import com.ruoyi.system.domain.RyFlightReserve;
import com.ruoyi.system.service.IRyFlightReserveService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 航班预定Controller
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
@RestController
@RequestMapping("/reserve")
public class RyFlightReserveController extends BaseController
{
    @Autowired
    private IRyFlightReserveService ryFlightReserveService;

    /**
     * 查询航班预定列表
     */
    @RequiresPermissions("system:reserve:list")
    @GetMapping("/list")
    public TableDataInfo list(RyFlightReserve ryFlightReserve)
    {
        startPage();
        List<RyFlightReserve> list = ryFlightReserveService.selectRyFlightReserveList(ryFlightReserve);
        return getDataTable(list);
    }

    /**
     * 导出航班预定列表
     */
    @RequiresPermissions("system:reserve:export")
    @Log(title = "航班预定", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RyFlightReserve ryFlightReserve)
    {
        List<RyFlightReserve> list = ryFlightReserveService.selectRyFlightReserveList(ryFlightReserve);
        ExcelUtil<RyFlightReserve> util = new ExcelUtil<RyFlightReserve>(RyFlightReserve.class);
        util.exportExcel(response, list, "航班预定数据");
    }

    /**
     * 获取航班预定详细信息
     */
    @RequiresPermissions("system:reserve:query")
    @GetMapping(value = "/{flightid}")
    public AjaxResult getInfo(@PathVariable("flightid") Long flightid)
    {
        return AjaxResult.success(ryFlightReserveService.selectRyFlightReserveByFlightid(flightid));
    }

    /**
     * 新增航班预定
     */
    @RequiresPermissions("system:reserve:add")
    @Log(title = "航班预定", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RyFlightReserve ryFlightReserve)
    {
        return toAjax(ryFlightReserveService.insertRyFlightReserve(ryFlightReserve));
    }

    /**
     * 修改航班预定
     */
    @RequiresPermissions("system:reserve:edit")
    @Log(title = "航班预定", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RyFlightReserve ryFlightReserve)
    {
        return toAjax(ryFlightReserveService.updateRyFlightReserve(ryFlightReserve));
    }

    /**
     * 删除航班预定
     */
    @RequiresPermissions("system:reserve:remove")
    @Log(title = "航班预定", businessType = BusinessType.DELETE)
	@DeleteMapping("/{flightids}")
    public AjaxResult remove(@PathVariable Long[] flightids)
    {
        return toAjax(ryFlightReserveService.deleteRyFlightReserveByFlightids(flightids));
    }
}
