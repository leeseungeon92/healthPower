package LSE.HealthPower.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    //요청되는 url 모두 허용
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

/*        http.authorizeHttpRequests((authorizeRequests) ->
                authorizeRequests.requestMatchers(new AntPathRequestMatcher("/**")).permitAll());
        return http.build();*/

        http
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                )// H2 콘솔에 대한 접근 허용
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                ) // H2 콘솔에 대한 CSRF 보호 비활성화
                .headers(headers -> headers
                        .addHeaderWriter(new XFrameOptionsHeaderWriter(
                                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN
                        ))
                ); // X-Frame-Options 헤더를 SAMEORIGIN으로 설정하여 오류 해결

        return http.build();
    }
}
