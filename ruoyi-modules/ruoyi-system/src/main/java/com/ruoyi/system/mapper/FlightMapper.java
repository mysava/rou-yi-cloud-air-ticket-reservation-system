package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Flight;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public interface FlightMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param flightid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Flight selectFlightByFlightid(Long flightid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param flight 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Flight> selectFlightList(Flight flight);

    /**
     * 新增【请填写功能名称】
     * 
     * @param flight 【请填写功能名称】
     * @return 结果
     */
    public int insertFlight(Flight flight);

    /**
     * 修改【请填写功能名称】
     * 
     * @param flight 【请填写功能名称】
     * @return 结果
     */
    public int updateFlight(Flight flight);

    /**
     * 删除【请填写功能名称】
     * 
     * @param flightid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFlightByFlightid(Long flightid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param flightids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFlightByFlightids(Long[] flightids);
}
