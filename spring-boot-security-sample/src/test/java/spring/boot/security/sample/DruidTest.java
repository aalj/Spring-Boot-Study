package spring.boot.security.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidTest {
    @Autowired
    MaoyanMapper maoyanMapper;
    @Test
    public void maoYan(){
        List<Maoyan> maoyans = maoyanMapper.selectAll();
        System.out.println(maoyans);
    }
}
