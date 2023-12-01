package com.myshop.users.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private    String secretkey ;

    @Value("${application.security.jwt.expiration}")
    private    long jwtExpiration ;

    @Value("${application.security.jwt.refresh-token.expiration}")
    private    long refreshExpiration ;
    public String extractUsername(String token){
        return extractClaims(token , Claims::getSubject) ;
    }


    public <T> T extractClaims(String token , Function<Claims , T> claimsResolver){
        final  Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public String generateToken(   UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    public   String generateToken(
            Map<String,Object> extractClaims,
            UserDetails userDetails
    ){

        return  buildToken(extractClaims ,userDetails , jwtExpiration );
    }
    public   String generateRefreshToken(
            UserDetails userDetails
    ){

        return  buildToken(new HashMap<>() ,userDetails , refreshExpiration );
    }

    private  String buildToken(Map<String,Object> extractClaims,
                               UserDetails userDetails,
                               long expiration){
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token , UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenEXpired(token);
    }

    private boolean isTokenEXpired(String token) {
        return  extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return   extractClaims(token,Claims::getExpiration);

    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretkey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
