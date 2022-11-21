package com.bookstore.services;

import com.bookstore.pojo.Books;

import java.util.List;

public interface cartService
{
	/**
	 * 添加一项进入购物车
	 * @param userID    用户ID
	 * @param bookID    要添加的商品的书籍ID
	 */
	public void add(Integer userID,Integer bookID);

	/**
	 * 删除购物车中的一项
	 * @param userID    用户ID
	 * @param bookID    要删除的商品的书籍ID
	 */
	public void delete(Integer userID,Integer bookID);

	public void clear(Integer userID);

	public List<List<Integer>> pages(Integer userID, Integer page_Size);

	/**
	 * 按照给定分页包含的书籍ID列表查询书籍信息
	 * @param pages     各分页包含书籍ID租车呢个的List
	 * @param page_No   要查询的分页
	 * @return      查询获得的书籍的信息组成的List
	 */
	public List<Books> query(List<List<Integer>> pages, Integer page_No);
}
