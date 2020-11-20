package com.bs.mybs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PropertySource("classpath:security-config.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${security.login.url}")
    private String loginApi;
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/index.html")
                .permitAll()
                .and()
                .csrf().disable();
    }
    //@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                //对于静态资源的获取允许匿名访问
//
//                // 对登录注册要允许匿名访问;
//
//                //其余请求全部需要登录后访问
//                .anyRequest().authenticated()
//                //这里配置的loginProcessingUrl为页面中对应表单的 action ，该请求为 post，并设置可匿名访问
//                .and().formLogin().loginPage("/login.html").loginProcessingUrl("/user/findAll.do").permitAll()
//                //这里指定的是表单中name="username"的参数作为登录用户名，name="password"的参数作为登录密码
//
//                //登录成功后的返回结果
//                .successHandler(((req,resp, authentication) -> {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write(new ObjectMapper().writeValueAsString(authentication.getPrincipal()));
//                    out.flush();
//                    out.close();
//                }))
//                //登录失败后的返回结果
//                .failureHandler(((req,resp, authentication) -> {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write(new ObjectMapper().writeValueAsString(authentication.getMessage()));
//                    out.flush();
//                    out.close();
//                }))
//                //这里配置的logoutUrl为登出接口，并设置可匿名访问
//
//                //登出后的返回结果
//
//                //这里配置的为当未登录访问受保护资源时，返回json
//                .and().exceptionHandling().authenticationEntryPoint(((req,resp, authentication) -> {
//            resp.setContentType("application/json;charset=utf-8");
//            PrintWriter out = resp.getWriter();
//            out.write(new ObjectMapper().writeValueAsString("尚未登录，请登录"));
//            out.flush();
//            out.close();
//        }));
//
//    }

}
