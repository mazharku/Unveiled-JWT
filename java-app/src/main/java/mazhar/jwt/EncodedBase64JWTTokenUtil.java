package mazhar.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

public class EncodedBase64JWTTokenUtil {
    private final Long expirationTime;
    private final String secret;

    public EncodedBase64JWTTokenUtil(long expirationTime, String secret) {
        this.expirationTime = expirationTime;
        this.secret = secret;
    }

    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).setSubject("encoded_jwt_token")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime * 1000))
                .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(secret.getBytes())).compact();
    }

}
