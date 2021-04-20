package board_proj.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import board_proj.JdbcUtil;
import board_proj.dao.impl.BoardDaoImpl;
import board_proj.dto.BoardDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardDaoTest {
	private static Connection con = JdbcUtil.getConnection();
	private BoardDaoImpl dao = BoardDaoImpl.getInstance();

	@Before
	public void setUp() throws Exception {
		dao.setCon(con);
	}

//	@BeforeClass
//	public void setUpBeforeClass() throws Exception {
//		dao.setCon(con);
//	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01NextBoardNum() {
		System.out.println("test01NextBoardNum()");
		int res = dao.nextBoardNum();
		Assert.assertNotEquals(0, res);
		System.out.println("next Number >> " + res);
	}

	@Test
	public void test02SelectListcount() {
		System.out.println("test02SelectListcount()");
		int res = dao.selectListcount();
		Assert.assertNotEquals(-1, res);
		System.out.println("ListCount >> " + res);
	}

	@Test
	public void test03SelectArticleList() {
		System.out.println("test03SelectArticleList()");
		int page = 1;
		int limit = 10;
		ArrayList<BoardDTO> list = dao.selectArticleList(page, limit);
		Assert.assertNotNull(list);

		list.stream().forEach(System.out::println);
		System.out.println("===============");
		dao.selectArticleList(2, 10).stream().forEach(System.out::println);
	}

	@Test
	public void test05SelectArticle() {
		System.out.println("test05SelectArticle()");
		BoardDTO res = dao.selectArticle(1);
		Assert.assertNotNull(res);
		System.out.println(res);

	}

	@Test
	public void test04InsertArticle() {
		System.out.println("test04InsertArticle()");
		BoardDTO article = new BoardDTO("홍길동", "1234", "5시 퇴근가능할까?", "불가능 함", "test.txt");
//		System.out.println(newBoard);
		int res = dao.insertArticle(article);
		Assert.assertEquals(1, res);

	}

	@Test
	public void testInsertReplyArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void test08UpdateArticle() {
		System.out.println("test08UpdateArticl()");
		int borad_num = 22;
		BoardDTO article = dao.selectArticle(borad_num);
		int res = dao.updateArticle(article);
		Assert.assertEquals(1, res);
		
		System.out.println("res >> " + res);
	}

	@Test
	public void test09DeleteArticle() {
		System.out.println("test07DeleteArticle()");
		int borad_num = dao.nextBoardNum() - 1;
		int res = dao.deleteArticle(borad_num);
		Assert.assertEquals(1, res);
		System.out.println("res >> " + res);
	}

	@Test
	public void test06UpdateReadCount() {
		System.out.println("test06UpdateReadCount()");
		int count = dao.updateReadCount(46);
		Assert.assertNotNull(count);
		System.out.println(count);
	}

	@Test
	public void test07IsArticleBoardWriter() {
		System.out.println("test07IsArticleBoardWriter()");
		int borad_num = 22;
		boolean res = dao.isArticleBoardWriter(borad_num, "bbb");
		Assert.assertEquals(true, res);
		System.out.println("res >> " + res);
	}

}
