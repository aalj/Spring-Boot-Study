package spring.boot.security.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import spring.boot.security.sample.handler.MyPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidTest {
    @Resource
    SysUserEntityMapper sysUserEntityMapper;

    @Test
    public void maoYan() {
        List<SysUserEntity> maoyans = sysUserEntityMapper.selectAll();
        System.out.println(maoyans);
    }

    @Bean
    public MyPasswordEncoder myPasswordEncoder() {
        return new MyPasswordEncoder();
    }

    @Test
    public void setUser() {
        MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder();
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername("root");
        sysUserEntity.setAccountNonExpired(false);
        sysUserEntity.setAccountNonLocked(false);
        sysUserEntity.setCredentialsNonExpired(false);
        sysUserEntity.setEnabled(false);
        sysUserEntity.setPassword(myPasswordEncoder.encode("12356"));
        sysUserEntityMapper.insertSelective(sysUserEntity);
//        sysUserEntityMapper.insert(sysUserEntity);
        List<SysUserEntity> maoyans = sysUserEntityMapper.selectAll();
        System.out.println(maoyans);
    }
}
