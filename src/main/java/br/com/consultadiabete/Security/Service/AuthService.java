package br.com.consultadiabete.Security.Service;

import br.com.consultadiabete.Security.dto.LoginRequest;
import br.com.consultadiabete.Security.dto.TokenResponse;
import br.com.consultadiabete.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserJpaRepository users;
    private final PasswordEncoder encoder;
    private final JwtTokenService jwt;

    public TokenResponse login(LoginRequest req) {
        var user = users.findByEmail(req.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas");
        }

        // Gerar o token
        String accessToken = jwt.generate(user.getEmail(), user.getId());

        // Criar a resposta com accessToken, tokenType ("Bearer") e userId
        return new TokenResponse(accessToken, "Bearer", user.getId());
    }


}
