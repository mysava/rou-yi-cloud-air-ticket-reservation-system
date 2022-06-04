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
import com.ruoyi.system.domain.Seat;
import com.ruoyi.system.service.ISeatService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
@RestController
@RequestMapping("/seat")
public class SeatController extends BaseController
{
    @Autowired
    private ISeatService seatService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:seat:list")
    @GetMapping("/list")
    public TableDataInfo list(Seat seat)
    {
        startPage();
        List<Seat> list = seatService.selectSeatList(seat);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:seat:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Seat seat)
    {
        List<Seat> list = seatService.selectSeatList(seat);
        ExcelUtil<Seat> util = new ExcelUtil<Seat>(Seat.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("system:seat:query")
    @GetMapping(value = "/{seatid}")
    public AjaxResult getInfo(@PathVariable("seatid") Long seatid)
    {
        return AjaxResult.success(seatService.selectSeatBySeatid(seatid));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("system:seat:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Seat seat)
    {
        return toAjax(seatService.insertSeat(seat));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:seat:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Seat seat)
    {
        return toAjax(seatService.updateSeat(seat));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:seat:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{seatids}")
    public AjaxResult remove(@PathVariable Long[] seatids)
    {
        return toAjax(seatService.deleteSeatBySeatids(seatids));
    }
}
