package com.this0.headline;

import com.this0.headline.util.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtTest {
    
    @Autowired
    private JwtHelper jwtHelper;
    @Test
    public void testJwt(){
        String token = jwtHelper.createToken(1l);
        System.out.println("token = " + token);

        Long userId = jwtHelper.getUserId(token);
        System.out.println("userId = " + userId);

        boolean expiration = jwtHelper.isExpiration(token);
        System.out.println("expiration = " + expiration);
    }
}
