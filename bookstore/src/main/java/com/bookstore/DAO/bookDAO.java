package com.bookstore.DAO;

import com.bookstore.pojo.Books;

import java.awt.print.Book;
import java.util.List;

public interface bookDAO
{
	/**
	 * 添加一本书
	 * @param book  要添加的书的Bean对象
	 * @return      受影响的语句数量
	 */
	public int addBook(Books book);

	/**
	 * 通过ID删除一本书
	 * @param id    要删除的书的ID
	 * @return      受影响的语句数量
	 */
	public int deleteBook(Integer id);

	/**
	 * 更新书的信息
	 * @param book  要更新的书的Bean对象
	 * @return      受影响的语句数量
	 */
	public int updateBookInfo(Books book);

	/**
	 * 通过书的ID查询一本书
	 * @param id    要查询的书的ID
	 * @return      查询获得的书的Bean对象
	 */
	public Books query(Integer id);

	/**
	 * 查询所有书
	 * @return      所有书的Bean对象组成的List
	 */
	public List<Books> query();

	/**
	 * 查询索引号范围内的书
	 * @param begin         查询开始的索引下标
	 * @param page_Size     查询的数量
	 * @return      查询获得的书的Bean对象组成的List
	 */
	public List<Books> query(Integer begin, Integer page_Size);

	/**
	 * 查询索引号范围内、一定价格范围内的书
	 * @param begin         查询开始的索引下标
	 * @param page_Size     查询的数量
	 * @param lower_bound   查询的价格范围下界
	 * @param upper_bound   查询的价格范围上界
	 * @return      查询获得的书的Bean对象组成的List
	 */
	public List<Books> query(Integer begin, Integer page_Size, Integer lower_bound, Integer upper_bound);

	/**
	 * 根据传入的bookID的List查询书籍信息
	 * @return      查询获得的书的Bean对象组成的List
	 */
	public List<Books> query(List<Integer> bookID);

	/**
	 * 查询总的书的数量
	 * @return  总书（类型）数
	 */
	public Integer counter();

	/**
	 * 查询一定价格范围内的书的数量
	 * @param lower_bound   查询的价格范围下界
	 * @param upper_bound   查询的价格范围上界
	 * @return      给定价格范围内的书的数量
	 */
	public Integer counter(Integer lower_bound, Integer upper_bound);

}
