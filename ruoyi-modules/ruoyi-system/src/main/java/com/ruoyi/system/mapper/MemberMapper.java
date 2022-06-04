package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Member;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public interface MemberMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param idcard 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Member selectMemberByIdcard(String idcard);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param member 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Member> selectMemberList(Member member);

    /**
     * 新增【请填写功能名称】
     * 
     * @param member 【请填写功能名称】
     * @return 结果
     */
    public int insertMember(Member member);

    /**
     * 修改【请填写功能名称】
     * 
     * @param member 【请填写功能名称】
     * @return 结果
     */
    public int updateMember(Member member);

    /**
     * 删除【请填写功能名称】
     * 
     * @param idcard 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMemberByIdcard(String idcard);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param idcards 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMemberByIdcards(String[] idcards);
}
