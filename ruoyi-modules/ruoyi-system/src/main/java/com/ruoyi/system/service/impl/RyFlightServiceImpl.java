package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RyFlightMapper;
import com.ruoyi.system.domain.RyFlight;
import com.ruoyi.system.service.IRyFlightService;

/**
 * 航班信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-10
 */
@Service
public class RyFlightServiceImpl implements IRyFlightService 
{
    @Autowired
    private RyFlightMapper ryFlightMapper;

    /**
     * 查询航班信息管理
     * 
     * @param flightno 航班信息管理主键
     * @return 航班信息管理
     */
    @Override
    public RyFlight selectRyFlightByFlightno(String flightno)
    {
        return ryFlightMapper.selectRyFlightByFlightno(flightno);
    }

    /**
     * 查询航班信息管理列表
     * 
     * @param ryFlight 航班信息管理
     * @return 航班信息管理
     */
    @Override
    public List<RyFlight> selectRyFlightList(RyFlight ryFlight)
    {
        return ryFlightMapper.selectRyFlightList(ryFlight);
    }

    /**
     * 新增航班信息管理
     * 
     * @param ryFlight 航班信息管理
     * @return 结果
     */
    @Override
    public int insertRyFlight(RyFlight ryFlight)
    {
        return ryFlightMapper.insertRyFlight(ryFlight);
    }

    /**
     * 修改航班信息管理
     * 
     * @param ryFlight 航班信息管理
     * @return 结果
     */
    @Override
    public int updateRyFlight(RyFlight ryFlight)
    {
        return ryFlightMapper.updateRyFlight(ryFlight);
    }

    /**
     * 批量删除航班信息管理
     * 
     * @param flightnos 需要删除的航班信息管理主键
     * @return 结果
     */
    @Override
    public int deleteRyFlightByFlightnos(String[] flightnos)
    {
        return ryFlightMapper.deleteRyFlightByFlightnos(flightnos);
    }

    /**
     * 删除航班信息管理信息
     * 
     * @param flightno 航班信息管理主键
     * @return 结果
     */
    @Override
    public int deleteRyFlightByFlightno(String flightno)
    {
        return ryFlightMapper.deleteRyFlightByFlightno(flightno);
    }
}
