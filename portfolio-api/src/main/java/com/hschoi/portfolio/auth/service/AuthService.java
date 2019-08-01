package com.hschoi.portfolio.auth.service;

import static com.hschoi.common.code.httpstatus.HttpStatusType.USER_NOT_FOUND;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hschoi.common.exception.CustomException;
import com.hschoi.portfolio.user.dto.UserDto;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * <pre>
 * com.hschoi.portfolio.auth.service_AuthService.java
 * </pre>
 * @date : 2019. 8. 1.
 * @author : hychoi
 */
@Service
public class AuthService {
	
	private final Logger log = LoggerFactory.getLogger(AuthService.class);
	
	private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    private static final String SECRET_KEY = "secret_key";
    private static final String HEADER_AUTH = "Authorization";
    private static final String HEADER_INC = "Bearer ";
    private static final int HOUR = 60 * 60 * 1000;
    
    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : createUserKey
     * @date : 2019. 8. 1.
     * @author : hychoi
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 8. 1.		hychoi				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param user
     * @return
     */ 	
    public String createUserKey(UserDto user) {
        
    	log.info("[AuthService]: >> 회원가입 : {}", user);
    	
    	if (user == null || StringUtils.isEmpty(user.getUserEmail())) {
            throw new CustomException(USER_NOT_FOUND);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("email", user.getUserEmail());

        return generateJWT(map);
    }
    
    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : generateJWT
     * @date : 2019. 8. 1.
     * @author : hychoi
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 8. 1.		hychoi				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param claimsMap
     * @return
     */ 	
    private String generateJWT(Map<String, Object> claimsMap) {
        
    	Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + HOUR);

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("type", "JWT");
        headerMap.put("algo", "HS256");

        JwtBuilder builder = Jwts.builder().setHeader(headerMap)
            .setClaims(claimsMap)
            .setExpiration(expireTime)
            .signWith(signatureAlgorithm, new SecretKeySpec(
                DatatypeConverter.parseBase64Binary(SECRET_KEY), signatureAlgorithm.getJcaName()));

        return builder.compact();
    }
}
