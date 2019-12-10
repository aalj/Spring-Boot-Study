package spring.boot.security.sample.handler;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import spring.boot.security.sample.entity.SysUserEntity;
import spring.boot.security.sample.mapper.SysUserEntityMapper;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    SysUserEntityMapper sysUserEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Example example = new Example(SysUserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("USERNAME", s);

        List<SysUserEntity> sysUserEntities = sysUserEntityMapper.selectByExample(example);

        User user = new User("root", "root", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        return user;
    }
}
