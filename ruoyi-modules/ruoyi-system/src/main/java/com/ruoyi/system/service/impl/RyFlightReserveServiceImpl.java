package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RyFlightReserveMapper;
import com.ruoyi.system.domain.RyFlightReserve;
import com.ruoyi.system.service.IRyFlightReserveService;

/**
 * 航班预定Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
@Service
public class RyFlightReserveServiceImpl implements IRyFlightReserveService 
{
    @Autowired
    private RyFlightReserveMapper ryFlightReserveMapper;

    /**
     * 查询航班预定
     * 
     * @param flightid 航班预定主键
     * @return 航班预定
     */
    @Override
    public RyFlightReserve selectRyFlightReserveByFlightid(Long flightid)
    {
        return ryFlightReserveMapper.selectRyFlightReserveByFlightid(flightid);
    }


    /**
     * 查询航班预定列表
     * 
     * @param ryFlightReserve 航班预定
     * @return 航班预定
     */
    @Override
    public List<RyFlightReserve> selectRyFlightReserveList(RyFlightReserve ryFlightReserve)
    {
        return ryFlightReserveMapper.selectRyFlightReserveList(ryFlightReserve);
    }

    /**
     * 新增航班预定
     * 
     * @param ryFlightReserve 航班预定
     * @return 结果
     */
    @Override
    public int insertRyFlightReserve(RyFlightReserve ryFlightReserve)
    {
        return ryFlightReserveMapper.insertRyFlightReserve(ryFlightReserve);
    }

    /**
     * 修改航班预定
     * 
     * @param ryFlightReserve 航班预定
     * @return 结果
     */
    @Override
    public int updateRyFlightReserve(RyFlightReserve ryFlightReserve)
    {
        return ryFlightReserveMapper.updateRyFlightReserve(ryFlightReserve);
    }

    /**
     * 批量删除航班预定
     * 
     * @param flightids 需要删除的航班预定主键
     * @return 结果
     */
    @Override
    public int deleteRyFlightReserveByFlightids(Long[] flightids)
    {
        return ryFlightReserveMapper.deleteRyFlightReserveByFlightids(flightids);
    }

    /**
     * 删除航班预定信息
     * 
     * @param flightid 航班预定主键
     * @return 结果
     */
    @Override
    public int deleteRyFlightReserveByFlightid(Long flightid)
    {
        return ryFlightReserveMapper.deleteRyFlightReserveByFlightid(flightid);
    }

    @Override
    public int updatevipsubtract(String ryFlightReserve) {
        return ryFlightReserveMapper.updatevipsubtract(ryFlightReserve);
    }

    @Override
    public int updatecomsubtract(String ryFlightReserve) {
        return ryFlightReserveMapper.updatecomsubtract(ryFlightReserve);
    }

    @Override
    public int updatevipadd(String ryFlightReserve) {
        return ryFlightReserveMapper.updatevipadd(ryFlightReserve);
    }

    @Override
    public int updatecomadd(String ryFlightReserve) {
        return ryFlightReserveMapper.updatecomadd(ryFlightReserve);
    }
}
