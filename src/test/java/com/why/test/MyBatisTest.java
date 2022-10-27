package com.why.test;

import com.why.mapper.GoodsMapper;
import com.why.pojo.Goods;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author why
 * 2022/10/12 17:21
 */
public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goods = goodsMapper.selectAll();
        System.out.println(goods);
        sqlSession.close();
    }

    @Test
    public void testSelectByConition1() throws IOException {
        int status = 1;
        String companyName = "华为";
        String goodsName = "华为";

        companyName = "%" + companyName + "%";
        goodsName = "%" + goodsName + "%";

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goods = goodsMapper.selectByConition(status, companyName, goodsName);
        System.out.println(goods);
        sqlSession.close();
    }

    @Test
    public void testSelectByConition2() throws IOException {
        int status = 1;
        String companyName = "华为";
        String goodsName = "华为";

        companyName = "%" + companyName + "%";
        goodsName = "%" + goodsName + "%";

        Goods good = new Goods();
        good.setStatus(status);
        good.setCompanyName(companyName);
        good.setGoodsName(goodsName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goods = goodsMapper.selectByConition(good);
        System.out.println(goods);
        sqlSession.close();
    }

    @Test
    public void testSelectByConition3() throws IOException {
        int status = 1;
        String companyName = "华为";
        String goodsName = "华为";

        companyName = "%" + companyName + "%";
        goodsName = "%" + goodsName + "%";
        Map map = new HashMap();
//        map.put("status", status);
//        map.put("companyName", companyName);
//        map.put("goodsName", goodsName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goods = goodsMapper.selectByConitionSingle(map);
        System.out.println(goods);
        sqlSession.close();
    }

    @Test
    public void testInsertAll() throws IOException {

        int status = 1;
        String companyName = "sziit";
        String goodsName = "why";
        String description = "都是人才";
        int ordered = 1000;


        Goods goods = new Goods();
        goods.setStatus(status);
        goods.setCompanyName(companyName);
        goods.setGoodsName(goodsName);
        goods.setDescription(description);
        goods.setOrdered(ordered);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);


        goodsMapper.addGoods(goods);

        System.out.println(goods.getId());

//        提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpData() throws IOException {

        int status = 1;
//        String companyName = "sziit";
//        String goodsName = "lsp";
        String description = "都是78";
        int ordered = 10;

        int id = 6;

        Goods goods = new Goods();
        goods.setStatus(status);
//        goods.setCompanyName(companyName);
//        goods.setGoodsName(goodsName);
        goods.setDescription(description);
        goods.setOrdered(ordered);

        goods.setId(id);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);


        goodsMapper.upData(goods);

        System.out.println(goods.toString());

//        提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDeletById() throws IOException {

        int id = 7;


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);


        goodsMapper.deletById(id);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeletByIds() throws IOException {

        int[] ints = new int[]{5, 6, 8};


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);


        goodsMapper.deletByIds(ints);

        sqlSession.commit();
        sqlSession.close();
    }
}
