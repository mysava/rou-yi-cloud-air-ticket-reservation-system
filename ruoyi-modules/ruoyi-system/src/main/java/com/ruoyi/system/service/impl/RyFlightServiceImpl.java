package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RyFlightMapper;
import com.ruoyi.system.domain.RyFlight;
import com.ruoyi.system.service.IRyFlightService;

/**
 * 航班管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
@Service
public class RyFlightServiceImpl implements IRyFlightService 
{
    @Autowired
    private RyFlightMapper ryFlightMapper;

    /**
     * 查询航班管理
     * 
     * @param flightid 航班管理主键
     * @return 航班管理
     */
    @Override
    public RyFlight selectRyFlightByFlightid(Long flightid)
    {
        return ryFlightMapper.selectRyFlightByFlightid(flightid);
    }

    /**
     * 查询航班管理列表
     * 
     * @param ryFlight 航班管理
     * @return 航班管理
     */
    @Override
    public List<RyFlight> selectRyFlightList(RyFlight ryFlight)
    {
        return ryFlightMapper.selectRyFlightList(ryFlight);
    }

    /**
     * 新增航班管理
     * 
     * @param ryFlight 航班管理
     * @return 结果
     */
    @Override
    public int insertRyFlight(RyFlight ryFlight)
    {
        return ryFlightMapper.insertRyFlight(ryFlight);
    }

    /**
     * 修改航班管理
     * 
     * @param ryFlight 航班管理
     * @return 结果
     */
    @Override
    public int updateRyFlight(RyFlight ryFlight)
    {
        return ryFlightMapper.updateRyFlight(ryFlight);
    }

    /**
     * 批量删除航班管理
     * 
     * @param flightids 需要删除的航班管理主键
     * @return 结果
     */
    @Override
    public int deleteRyFlightByFlightids(Long[] flightids)
    {
        return ryFlightMapper.deleteRyFlightByFlightids(flightids);
    }

    /**
     * 删除航班管理信息
     * 
     * @param flightid 航班管理主键
     * @return 结果
     */
    @Override
    public int deleteRyFlightByFlightid(Long flightid)
    {
        return ryFlightMapper.deleteRyFlightByFlightid(flightid);
    }

}
