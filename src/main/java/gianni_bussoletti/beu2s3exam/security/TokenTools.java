package gianni_bussoletti.beu2s3exam.security;

import gianni_bussoletti.beu2s3exam.entites.Cliente;
import gianni_bussoletti.beu2s3exam.entites.CreatoreEventi;
import gianni_bussoletti.beu2s3exam.exceptions.UnathorizedException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenTools {
    private String secret;

    public TokenTools(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    public String tokenGeneratorClient(Cliente cliente) {
        return Jwts.builder()
                .issuedAt(new Date((System.currentTimeMillis())))
                .expiration(new Date((System.currentTimeMillis()) + 1000 * 60 * 60 * 24))
                .subject(String.valueOf(cliente.getId()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }
    public String tokenGeneratorCreator(CreatoreEventi creatore) {
        return Jwts.builder()
                .issuedAt(new Date((System.currentTimeMillis())))
                .expiration(new Date((System.currentTimeMillis()) + 1000 * 60 * 60 * 24))
                .subject(String.valueOf(creatore.getId()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }





    public void tokenVerify(String token) {
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(token);
        } catch (Exception ex) {
            throw new UnathorizedException("Il token di login ha avuto un problema, per favore rieffetturare il login");
        }
    }
}
