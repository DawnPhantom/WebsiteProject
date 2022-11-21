package com.bookstore.DAO;

import com.bookstore.pojo.Books;
import com.bookstore.pojo.Cart;

public interface cartDAO
{
	/**
	 * 添加一件商品进入购物车
	 * @param userID    用户ID
	 * @param bookID    商品的书籍ID
	 * @return      受影响的行数
	 */
	public int add(Integer userID,Integer bookID);

	/**
	 * 从购物车中删除一件商品
	 * @param userID    用户ID
	 * @param bookID    商品的书籍ID
	 * @return      受影响的行数
	 */
	public int delete(Integer userID,Integer bookID);

	/**
	 * 清空购物车
	 * @param userID    要清空购物车的用户ID
	 * @return      受影响的行数
	 */
	public int clear(Integer userID);

	/**
	 * 获取购物车所有商品信息
	 * @param userID    用户ID
	 * @return      购物车信息对象
	 */
	public Cart query(Integer userID);

	/**
	 * 获取购物车中商品的数量
	 * @param userID    用户ID
	 * @return      商品数量
	 */
	public Integer counter(Integer userID);
}
