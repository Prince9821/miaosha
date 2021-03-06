package com.pro.miaosha.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pro.miaosha.domain.MiaoshaGoods;
import com.pro.miaosha.vo.GoodsVo;

@Mapper
public interface GoodsDao {
	@Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id")
	public List<GoodsVo> listGoodsVo();

	@Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
	public GoodsVo getGoodsVoByGoodsId(@Param("goodsId")long goodsId);

//	@Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goods_id}")
//	@Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId}")
//	public void reduceStock(@Param("goods_id")long goodsId);

	@Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId}")
	public int reduceStock(MiaoshaGoods g);


	@Update("update miaosha_goods set stock_count = #{stockCount} where goods_id = #{goodsId}")
	public int resetStock(MiaoshaGoods g);
}
