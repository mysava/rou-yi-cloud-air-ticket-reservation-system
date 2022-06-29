package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FlightMapper;
import com.ruoyi.system.domain.Flight;
import com.ruoyi.system.service.IFlightService;

/**
 * flightService业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-19
 */
@Service
public class FlightServiceImpl implements IFlightService 
{
    @Autowired
    private FlightMapper flightMapper;

    /**
     * 查询flight
     * 
     * @param flightid flight主键
     * @return flight
     */
    @Override
    public Flight selectFlightByFlightid(Long flightid)
    {
        return flightMapper.selectFlightByFlightid(flightid);
    }

    /**
     * 查询flight列表
     * 
     * @param flight flight
     * @return flight
     */
    @Override
    public List<Flight> selectFlightList(Flight flight)
    {
        return flightMapper.selectFlightList(flight);
    }

    /**
     * 新增flight
     * 
     * @param flight flight
     * @return 结果
     */
    @Override
    public int insertFlight(Flight flight)
    {
        return flightMapper.insertFlight(flight);
    }

    /**
     * 修改flight
     * 
     * @param flight flight
     * @return 结果
     */
    @Override
    public int updateFlight(Flight flight)
    {
        return flightMapper.updateFlight(flight);
    }

    /**
     * 批量删除flight
     * 
     * @param flightids 需要删除的flight主键
     * @return 结果
     */
    @Override
    public int deleteFlightByFlightids(Long[] flightids)
    {
        return flightMapper.deleteFlightByFlightids(flightids);
    }

    /**
     * 删除flight信息
     * 
     * @param flightid flight主键
     * @return 结果
     */
    @Override
    public int deleteFlightByFlightid(Long flightid)
    {
        return flightMapper.deleteFlightByFlightid(flightid);
    }

     /**
     * 预订flight
     *
     * @param flight flight
     * @return 结果
     */
    @Override
    public int bookFlight(Flight flight) { return flightMapper.bookFlight(flight); }

}
