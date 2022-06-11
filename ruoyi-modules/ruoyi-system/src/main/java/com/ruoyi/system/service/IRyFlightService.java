package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RyFlight;

/**
 * 航班信息管理Service接口
 * 
 * @author ruoyi
 * @date 2022-06-10
 */
public interface IRyFlightService 
{
    /**
     * 查询航班信息管理
     * 
     * @param flightno 航班信息管理主键
     * @return 航班信息管理
     */
    public RyFlight selectRyFlightByFlightno(String flightno);

    /**
     * 查询航班信息管理列表
     * 
     * @param ryFlight 航班信息管理
     * @return 航班信息管理集合
     */
    public List<RyFlight> selectRyFlightList(RyFlight ryFlight);

    /**
     * 新增航班信息管理
     * 
     * @param ryFlight 航班信息管理
     * @return 结果
     */
    public int insertRyFlight(RyFlight ryFlight);

    /**
     * 修改航班信息管理
     * 
     * @param ryFlight 航班信息管理
     * @return 结果
     */
    public int updateRyFlight(RyFlight ryFlight);

    /**
     * 批量删除航班信息管理
     * 
     * @param flightnos 需要删除的航班信息管理主键集合
     * @return 结果
     */
    public int deleteRyFlightByFlightnos(String[] flightnos);

    /**
     * 删除航班信息管理信息
     * 
     * @param flightno 航班信息管理主键
     * @return 结果
     */
    public int deleteRyFlightByFlightno(String flightno);
}
