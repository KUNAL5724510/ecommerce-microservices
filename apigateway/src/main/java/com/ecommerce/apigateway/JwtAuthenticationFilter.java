package com.ecommerce.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import com.ecommerce.apigateway.Util.JwtUtil;


@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

  @Autowired
  private JwtUtil jwtUtil;

  public JwtAuthenticationFilter() {
    super(Config.class);
  }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            HttpHeaders headers = exchange.getRequest().getHeaders();

            // 1. Check if Authorization header exists
            if (headers.containsKey(HttpHeaders.AUTHORIZATION)) {
                String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);

                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    String token = authHeader.substring(7); // remove "Bearer "

                    // 2. Validate token
                    if (jwtUtil.validateToken(token)) {
                        // 3. Extract email & role from token
                        String email = jwtUtil.extractEmail(token);
                        String role = jwtUtil.extractRole(token);

                        // 4. Add them as headers for downstream services
                        exchange = exchange.mutate()
                                .request(r -> r.headers(h -> {
                                    h.add("X-User-Email", email);
                                    h.add("X-User-Role", role);
                                }))
                                .build();
                    }
                }
            }

            // 5. Continue filter chain (guest or logged-in)
            return chain.filter(exchange);
        };
    }

    public static class Config {
        // Empty class, required for extending AbstractGatewayFilterFactory
    }
}