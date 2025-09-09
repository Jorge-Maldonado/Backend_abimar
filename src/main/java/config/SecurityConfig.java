package config;

/**
 *
 * @author Jorge
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // desactiva CSRF (para pruebas y peticiones desde Postman/Angular)
                .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // permite el acceso a todos los endpoints sin login
                )
                .formLogin().disable() // desactiva el formulario de login por defecto
                .httpBasic().disable(); // desactiva la autenticación básica
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
