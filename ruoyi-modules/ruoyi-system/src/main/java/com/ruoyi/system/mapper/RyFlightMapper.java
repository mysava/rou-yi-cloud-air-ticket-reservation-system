package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RyFlight;

/**
 * 航班管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
public interface RyFlightMapper 
{
    /**
     * 查询航班管理
     * 
     * @param flightid 航班管理主键
     * @return 航班管理
     */
    public RyFlight selectRyFlightByFlightid(Long flightid);

    /**
     * 查询航班管理列表
     * 
     * @param ryFlight 航班管理
     * @return 航班管理集合
     */
    public List<RyFlight> selectRyFlightList(RyFlight ryFlight);

    /**
     * 新增航班管理
     * 
     * @param ryFlight 航班管理
     * @return 结果
     */
    public int insertRyFlight(RyFlight ryFlight);

    /**
     * 修改航班管理
     * 
     * @param ryFlight 航班管理
     * @return 结果
     */
    public int updateRyFlight(RyFlight ryFlight);

    /**
     * 删除航班管理
     * 
     * @param flightid 航班管理主键
     * @return 结果
     */
    public int deleteRyFlightByFlightid(Long flightid);

    /**
     * 批量删除航班管理
     * 
     * @param flightids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRyFlightByFlightids(Long[] flightids);
}
