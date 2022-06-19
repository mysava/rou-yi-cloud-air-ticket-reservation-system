package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Flight;

/**
 * flightService接口
 * 
 * @author ruoyi
 * @date 2022-06-19
 */
public interface IFlightService 
{
    /**
     * 查询flight
     * 
     * @param flightid flight主键
     * @return flight
     */
    public Flight selectFlightByFlightid(Long flightid);

    /**
     * 查询flight列表
     * 
     * @param flight flight
     * @return flight集合
     */
    public List<Flight> selectFlightList(Flight flight);

    /**
     * 新增flight
     * 
     * @param flight flight
     * @return 结果
     */
    public int insertFlight(Flight flight);

    /**
     * 修改flight
     * 
     * @param flight flight
     * @return 结果
     */
    public int updateFlight(Flight flight);

    /**
     * 批量删除flight
     * 
     * @param flightids 需要删除的flight主键集合
     * @return 结果
     */
    public int deleteFlightByFlightids(Long[] flightids);

    /**
     * 删除flight信息
     * 
     * @param flightid flight主键
     * @return 结果
     */
    public int deleteFlightByFlightid(Long flightid);
}
