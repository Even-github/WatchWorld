package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

/**
 * 此类为数据库表goods_display的映射
 * @author 曾裕文
 *
 */
public class GoodsDisplay
{
	private int GoodsID;
	private String Brand;
	private String Time;
	
	public int getGoodsID()
	{
		return GoodsID;
	}
	public void setGoodsID(int goodsID)
	{
		GoodsID = goodsID;
	}
	public String getBrand()
	{
		return Brand;
	}
	public void setBrand(String brand)
	{
		Brand = brand;
	}
	public String getTime()
	{
		return Time;
	}
	public void setTime(String time)
	{
		Time = time;
	}
	
}
