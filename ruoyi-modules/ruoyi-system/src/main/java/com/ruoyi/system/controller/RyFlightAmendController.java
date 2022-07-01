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
import com.ruoyi.system.domain.RyFlightAmend;
import com.ruoyi.system.service.IRyFlightAmendService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单修改Controller
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
@RestController
@RequestMapping("/amend")
public class RyFlightAmendController extends BaseController
{
    @Autowired
    private IRyFlightAmendService ryFlightAmendService;

    /**
     * 查询订单修改列表
     */
    @RequiresPermissions("system:amend:list")
    @GetMapping("/list")
    public TableDataInfo list(RyFlightAmend ryFlightAmend)
    {
        startPage();
        List<RyFlightAmend> list = ryFlightAmendService.selectRyFlightAmendList(ryFlightAmend);
        return getDataTable(list);
    }

    /**
     * 导出订单修改列表
     */
    @RequiresPermissions("system:amend:export")
    @Log(title = "订单修改", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RyFlightAmend ryFlightAmend)
    {
        List<RyFlightAmend> list = ryFlightAmendService.selectRyFlightAmendList(ryFlightAmend);
        ExcelUtil<RyFlightAmend> util = new ExcelUtil<RyFlightAmend>(RyFlightAmend.class);
        util.exportExcel(response, list, "订单修改数据");
    }

    /**
     * 获取订单修改详细信息
     */
    @RequiresPermissions("system:amend:query")
    @GetMapping(value = "/{flightid}")
    public AjaxResult getInfo(@PathVariable("flightid") Long flightid)
    {
        return AjaxResult.success(ryFlightAmendService.selectRyFlightAmendByFlightid(flightid));
    }

    /**
     * 新增订单修改
     */
    @RequiresPermissions("system:amend:add")
    @Log(title = "订单修改", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RyFlightAmend ryFlightAmend)
    {
        return toAjax(ryFlightAmendService.insertRyFlightAmend(ryFlightAmend));
    }

    /**
     * 修改订单修改
     */
    @RequiresPermissions("system:amend:edit")
    @Log(title = "订单修改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RyFlightAmend ryFlightAmend)
    {
        return toAjax(ryFlightAmendService.updateRyFlightAmend(ryFlightAmend));
    }

    /**
     * 删除订单修改
     */
    @RequiresPermissions("system:amend:remove")
    @Log(title = "订单修改", businessType = BusinessType.DELETE)
	@DeleteMapping("/{flightids}")
    public AjaxResult remove(@PathVariable Long[] flightids)
    {
        return toAjax(ryFlightAmendService.deleteRyFlightAmendByFlightids(flightids));
    }
}
