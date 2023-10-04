package com.example.librarymanagement.util;

import com.example.librarymanagement.exception.AuthException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.Map;

/**
 * @author mangvientrieu
 */
public final class AuthUtil {

	public static String hashPassword(String password) {
		return DigestUtils.sha256Hex(password);
	}

	public static String generateToken(Map<String, Object> payload, String secretKey) {
		Date now = new Date();
		return Jwts.builder()
				.setClaims(payload)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + 10 * 60 * 1000))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getPayloadJwt(String token, String secretKey) throws AuthException {
		try {
			return (Map<String, Object>) Jwts.parser().setSigningKey(secretKey).parse(token).getBody();
		} catch (ExpiredJwtException e) {
			throw new AuthException("TOKEN_EXPIRED", "Phiên đăng nhập đã hết hạn");
		} catch (Exception e) {
			throw new AuthException("TOKEN_FAIL", "Token không khả dụng");
		}
	}
}
