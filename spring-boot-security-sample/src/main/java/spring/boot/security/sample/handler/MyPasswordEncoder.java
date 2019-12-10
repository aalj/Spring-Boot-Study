package spring.boot.security.sample.handler;

import com.jun.utils.SysUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
//        return SysUtils.encryptPassword((String)charSequence);
        return (String) charSequence;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
//        return s.equals(SysUtils.encryptPassword((String) charSequence));
        return s.equals( charSequence.toString());
    }
}
