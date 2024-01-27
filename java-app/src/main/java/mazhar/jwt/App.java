package mazhar.jwt;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String secret ="ABCdfKLgABCdfKL";
        long expireTime = 600L;  //10 * 60 = 600 sec => 10 min

        Map<String,Object> claims = getClaims();

        JWTTokenUtil jwtTokenUtil = new JWTTokenUtil(expireTime,secret);
        EncodedBase64JWTTokenUtil base64EncodedTokenUtl = new EncodedBase64JWTTokenUtil(expireTime,secret);
        String token = jwtTokenUtil.generateToken(claims);
        String base64EncodedToken = base64EncodedTokenUtl.generateToken(claims);
        //System.out.println(token);
        System.out.println(base64EncodedToken);
    }

    private static  Map<String,Object> getClaims(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("auth","jwt");
        claims.put("type","stateless");
        return claims;
    }

}