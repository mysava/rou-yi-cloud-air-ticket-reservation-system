package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MemberMapper;
import com.ruoyi.system.domain.Member;
import com.ruoyi.system.service.IMemberService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
@Service
public class MemberServiceImpl implements IMemberService 
{
    @Autowired
    private MemberMapper memberMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param idcard 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Member selectMemberByIdcard(String idcard)
    {
        return memberMapper.selectMemberByIdcard(idcard);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param member 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Member> selectMemberList(Member member)
    {
        return memberMapper.selectMemberList(member);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param member 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMember(Member member)
    {
        return memberMapper.insertMember(member);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param member 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMember(Member member)
    {
        return memberMapper.updateMember(member);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param idcards 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMemberByIdcards(String[] idcards)
    {
        return memberMapper.deleteMemberByIdcards(idcards);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param idcard 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMemberByIdcard(String idcard)
    {
        return memberMapper.deleteMemberByIdcard(idcard);
    }
}
