package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RyFlightReserve;

/**
 * 航班预定Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
public interface RyFlightReserveMapper 
{
    /**
     * 查询航班预定
     * 
     * @param flightid 航班预定主键
     * @return 航班预定
     */
    public RyFlightReserve selectRyFlightReserveByFlightid(Long flightid);


    /**
     * 查询航班预定列表
     * 
     * @param ryFlightReserve 航班预定
     * @return 航班预定集合
     */
    public List<RyFlightReserve> selectRyFlightReserveList(RyFlightReserve ryFlightReserve);

    /**
     * 新增航班预定
     * 
     * @param ryFlightReserve 航班预定
     * @return 结果
     */
    public int insertRyFlightReserve(RyFlightReserve ryFlightReserve);

    /**
     * 修改航班预定
     * 
     * @param ryFlightReserve 航班预定
     * @return 结果
     */
    public int updateRyFlightReserve(RyFlightReserve ryFlightReserve);

    /**
     * 删除航班预定
     * 
     * @param flightid 航班预定主键
     * @return 结果
     */
    public int deleteRyFlightReserveByFlightid(Long flightid);

    /**
     * 批量删除航班预定
     * 
     * @param flightids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRyFlightReserveByFlightids(Long[] flightids);

    public int updatevipsubtract(String ryFlightReserve);

    public int updatecomsubtract(String ryFlightReserve);

    public int updatevipadd(String ryFlightReserve);

    public int updatecomadd(String ryFlightReserve);
}
