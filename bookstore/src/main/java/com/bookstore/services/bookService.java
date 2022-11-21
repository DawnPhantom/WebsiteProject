package com.bookstore.services;

import com.bookstore.pojo.Books;
import com.bookstore.pojo.Pages;

import java.util.List;

public interface bookService
{
	/**
	 * 查询请求页码对应的分页信息
	 * @param page_No       查询的分页号
	 * @param page_Size     单页的容量
	 * @return      包含请求获得的书的信息的分页对象
	 */
	public Pages<Books> pages(Integer page_No, Integer page_Size);

	/**
	 * 查询给定价格范围内的书籍的信息
	 * @param page_No       查询的分页号
	 * @param page_Size     单页的容量
	 * @param lower_bound   查询的价格范围下界
	 * @param upper_bound   查询的价格范围上界
	 * @return      包含请求获得的书的信息的分页对象
	 */
	public Pages<Books> pagesByPrice(Integer page_No, Integer page_Size, Integer lower_bound, Integer upper_bound);

	/**
	 * 添加一本书
	 * @param book      要添加鹅书的Bean对象
	 */
	public void addBook(Books book);

	/**
	 * 删除一本书
	 * @param id        要删除的书的id
	 */
	public void deleteBook(Integer id);

	/**
	 * 更新书籍信息
	 * @param book      要更新的书的Bean对象
	 */
	public void updateBookInfo(Books book);

	/**
	 * 查询书籍信息
	 * @param id        要查询的书的id
	 * @return      查询获得的书的Bean对象
	 */
	public Books query(Integer id);

	/**
	 * 获取所有书籍的信息
	 * @return      查询获得的所有书的Bean对象组成的List
	 */
	public List<Books> query();

}
