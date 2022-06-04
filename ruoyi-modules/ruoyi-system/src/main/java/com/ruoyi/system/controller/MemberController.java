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
import com.ruoyi.system.domain.Member;
import com.ruoyi.system.service.IMemberService;
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
@RequestMapping("/member")
public class MemberController extends BaseController
{
    @Autowired
    private IMemberService memberService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:member:list")
    @GetMapping("/list")
    public TableDataInfo list(Member member)
    {
        startPage();
        List<Member> list = memberService.selectMemberList(member);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:member:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Member member)
    {
        List<Member> list = memberService.selectMemberList(member);
        ExcelUtil<Member> util = new ExcelUtil<Member>(Member.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("system:member:query")
    @GetMapping(value = "/{idcard}")
    public AjaxResult getInfo(@PathVariable("idcard") String idcard)
    {
        return AjaxResult.success(memberService.selectMemberByIdcard(idcard));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("system:member:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Member member)
    {
        return toAjax(memberService.insertMember(member));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:member:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Member member)
    {
        return toAjax(memberService.updateMember(member));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:member:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{idcards}")
    public AjaxResult remove(@PathVariable String[] idcards)
    {
        return toAjax(memberService.deleteMemberByIdcards(idcards));
    }
}
