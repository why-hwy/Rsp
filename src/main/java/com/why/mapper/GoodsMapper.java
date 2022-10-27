package com.why.mapper;

import com.why.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author why
 * 2022/10/12 16:26
 */
public interface GoodsMapper {
    List<Goods> selectAll();

    List<Goods> selectById(int id);

    List<Goods> selectByConition(@Param("status") int status,
                                 @Param("companyName") String companyName,
                                 @Param("goodsName") String goodsName);

    List<Goods> selectByConition(Goods goods);

    List<Goods> selectByConition(Map map);

    List<Goods> selectByConitionSingle(Goods goods);

    List<Goods> selectByConitionSingle(Map map);

    void addGoods(Goods goods);

    void upData(Goods goods);

    void deletById(int id);

    void deletByIds(@Param("ids")int[] ids);
}
