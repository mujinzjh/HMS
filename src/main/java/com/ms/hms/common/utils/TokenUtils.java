package com.ms.hms.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ms.hms.common.Constants;
import com.ms.hms.entity.SysUser;

import java.util.Date;

public class TokenUtils {

    public static String createToken(SysUser user) {
        Date date = new Date(System.currentTimeMillis() + Constants.USER_TOKEN_EXPIRE);
        String token = JWT.create().withAudience(String.valueOf(user.getId()))
                .withExpiresAt(date).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
