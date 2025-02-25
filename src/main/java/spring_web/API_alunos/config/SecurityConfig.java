package spring_web.API_alunos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Desativa CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        // Permitir acesso de leitura para usuários e gerentes
                        .requestMatchers(HttpMethod.GET, "/aluno", "/aluno/**").hasAnyRole("USER", "MANAGER")
                        // Restringir operações de escrita apenas para gerentes
                        .requestMatchers(HttpMethod.POST, "/aluno/save").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/aluno/update/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/aluno/delete/**").hasRole("MANAGER")

                        // Configurações para documentação Swagger (opcional)
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()

                        // Todas as outras requisições requerem autenticação
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {}); // Habilita autenticação HTTP Basic

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("levi")
                .password(passwordEncoder().encode("levi1144")) // Senha codificada corretamente
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin1234"))
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}