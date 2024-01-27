package mazhar.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JWTTokenUtil {

    private final Long expirationTime;
    private final String secret;

    public JWTTokenUtil(long expirationTime, String secret) {
        this.expirationTime = expirationTime;
        this.secret = secret;
    }

    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).setSubject("encoded_jwt_token")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

}
