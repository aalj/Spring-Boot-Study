package spring.boot.security.sample.handler;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import spring.boot.security.sample.exception.MyAuthenticationException;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    SysUserEntityMapper sysUserEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

//        return  new User("root","123456",true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("USER,ADMIN"));

        Example example = new Example(SysUserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", s);

        List<SysUserEntity> sysUserEntities = sysUserEntityMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(sysUserEntities)) {
            throw new MyAuthenticationException("账号不存在");
        }
        SysUserEntity sysUserEntity = sysUserEntities.get(0);
        return new User(sysUserEntity.getUsername(),
                sysUserEntity.getPassword(),
                sysUserEntity.getEnabled(),
                sysUserEntity.getAccountNonExpired(),
                sysUserEntity.getCredentialsNonExpired(),
                sysUserEntity.getAccountNonLocked(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));

    }
}
