package ma.enset.charefsohailexamjee.web;


import com.nimbusds.jose.Algorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.security.config.Elements.JWT;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@AllArgsConstructor
public class SecurityController {

    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        Algorithm algorithm = Algorithm.HMAC256("MonSecretExamen");
        String jwt = JWT.create()
                .withSubject(authentication.getName())
                .withClaim("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // Expire dans 1h
                .sign(algorithm);

        Map<String, String> idToken = new HashMap<>();
        idToken.put("access-token", jwt);
        return idToken;
    }
}


@Data
class LoginRequest {
    private String username;
    private String password;
}