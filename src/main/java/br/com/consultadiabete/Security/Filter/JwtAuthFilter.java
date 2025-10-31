package br.com.consultadiabete.Security.Filter;

import br.com.consultadiabete.Security.Service.JwtTokenService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtTokenService jwt;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {
        String h = req.getHeader("Authorization");
        if (h != null && h.startsWith("Bearer ")) {
            String token = h.substring(7);
            try {
                Claims claims = jwt.parse(token);  // Extraímos o corpo do token com os claims
                String email = claims.getSubject();  // O e-mail está no "subject"
                String userId = claims.get("id", String.class);  // Obtemos o ID do claim "id"

                // Sem perfis/roles por enquanto, autentica por e-mail e ID
                var auth = new UsernamePasswordAuthenticationToken(email, null, List.of());

                // Adiciona o ID como atributo da autenticação (útil para buscar usuário ou outros processos)
                auth.setDetails(userId);

                // Define a autenticação no contexto de segurança
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception ignored) {
                // Token inválido -> segue 401 em endpoints protegidos
            }
        }
        chain.doFilter(req, res);  // Continua com o fluxo do filtro
    }
}
