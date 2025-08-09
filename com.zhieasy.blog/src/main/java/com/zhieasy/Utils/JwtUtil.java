package com.zhieasy.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    // JWT密钥
    private static final String SECRET_KEY = "your-secret-key";
    // JWT过期时间（4小时）
    private static final long EXPIRATION_TIME = 4 * 60 * 60 * 1000;

    /**
     * 生成JWT令牌
     */
    public String generateToken(String phone, Integer userId) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(phone)  // 设置主题为手机号
                .claim("id", userId)  // 添加用户ID到载荷
                .setIssuedAt(new Date())  // 设置签发时间
                .setExpiration(expirationDate)  // 设置过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // 签名
                .compact();
    }

    /**
     * 解析JWT令牌获取手机号
     */
    public String getPhoneFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    /**
     * 解析JWT令牌获取用户ID
     */
    public Integer getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("id", Integer.class);
    }

    /**
     * 验证JWT令牌是否有效
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * 检查JWT令牌是否过期
     */
    public boolean isTokenExpired(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return claims.getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return true;
        }
    }
}
