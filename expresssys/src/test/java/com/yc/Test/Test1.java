
package com.yc.Test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.Util.MD5Encryption;
import com.yc.bean.Goods;
import com.yc.bean.Users;
import com.yc.biz.GoodsBiz;
import com.yc.biz.UsersBiz;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:applicationContext.xml") // 告诉容器, spring配置文件位置
public class Test1 {
	@Resource(name="dataSource")
	private DriverManagerDataSource dataSource;
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;

	@Resource(name="usersBizImpl")
	private UsersBiz ub;

	@Resource(name="goodsBizImpl")
	private GoodsBiz gb;

	//查询
	@Test
	public void test1(){
		Map map = new HashMap();

		map.put("start", 0);
		map.put("pagesize", 5);

		Users users = new Users();
		users.setUname("1");
		map.put("users", users);

		System.out.println(ub.findBy(map));

	}

	//add
	@Test
	public void test2(){
		Users users = new Users();
		users.setUname("a");
		users.setUpwd("a");
//		System.out.println(ub.addUsers(users));
		System.out.println(ub.adminlogin(users));;
	}

	//update
	@Test
	public void test3(){
		Users users = new Users();
//		users.setUname("1");
//		users.setUpwd("1");
		users.setUsid(3);
		users.setUstatus(1);
		System.out.println(ub.updateUsers(users));
	}

	@Test
	public void test4(){
		Goods goods = new Goods();
		goods.setGname("123");
		goods.setGtype("日用品");

		System.out.println(gb.addGoods(goods));
	}

	@Test
	public void test5(){
		Goods goods = new Goods();
		goods.setGid(1);
		goods.setGname("1");
		System.out.println(gb.updateGoods(goods));

	}

	@Test
	public void test6(){
		Goods goods = new Goods();
		goods.setGid(2);
		Map map = new HashMap();

		map.put("start", 0);
		map.put("pagesize", 5);
		
		map.put("goods", goods);
		
		System.out.println(gb.findBy(map));
	}
}
