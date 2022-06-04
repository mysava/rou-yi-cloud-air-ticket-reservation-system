package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FlightMapper;
import com.ruoyi.system.domain.Flight;
import com.ruoyi.system.service.IFlightService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
@Service
public class FlightServiceImpl implements IFlightService 
{
    @Autowired
    private FlightMapper flightMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param flightid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Flight selectFlightByFlightid(Long flightid)
    {
        return flightMapper.selectFlightByFlightid(flightid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param flight 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Flight> selectFlightList(Flight flight)
    {
        return flightMapper.selectFlightList(flight);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param flight 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFlight(Flight flight)
    {
        return flightMapper.insertFlight(flight);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param flight 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFlight(Flight flight)
    {
        return flightMapper.updateFlight(flight);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param flightids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFlightByFlightids(Long[] flightids)
    {
        return flightMapper.deleteFlightByFlightids(flightids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param flightid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFlightByFlightid(Long flightid)
    {
        return flightMapper.deleteFlightByFlightid(flightid);
    }
}
