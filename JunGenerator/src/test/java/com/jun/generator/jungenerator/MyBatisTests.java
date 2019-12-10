package com.jun.generator.jungenerator;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = JungeneratorApplication.class)
//@Transactional
//@Rollback
public class MyBatisTests {

    /**
     * 注入数据查询接口
     */
//    @Autowired
//    private MaoyanMapper maoyanMapper;

    /**
     * 测试插入数据
     */
    @Test
    public void testInsert() {
        System.out.println("asdfasdfasdf");
    }

    /**
     * 测试删除数据
     */
    @Test
    public void testDelete() {

    }

    /**
     * 测试修改数据
     */
    @Test
    public void testUpdate() {

    }

    /**
     * 测试查询集合
     */
    @Test
    public void testSelect() {
//        List<Maoyan> tbUsers = maoyanMapper.selectAll();
//        for (Maoyan tbUser : tbUsers) {
//            System.out.println(tbUser.getArea());
//        }
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testPage() {

    }
}