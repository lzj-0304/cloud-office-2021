package com.lzj.cloud.office.config.security;

import com.lzj.cloud.office.config.security.component.JwtAuthencationTokenFilter;
import com.lzj.cloud.office.config.security.component.RestAuthorizationEntryPoint;
import com.lzj.cloud.office.config.security.component.RestfulAccessDeniedHandler;
import com.lzj.cloud.office.pojo.Admin;
import com.lzj.cloud.office.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security配置类
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private IAdminService adminService;

	@Autowired
	private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

	@Autowired
	private RestAuthorizationEntryPoint restAuthorizationEntryPoint;



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//使用JWT，不需要csrf
		http.csrf()
				.disable()
				// 基于token 不需要session
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers("/login").permitAll()
				// 其他请求必须认证
				.anyRequest().authenticated()
				.and()
				//未授权 与 未登录 失败处理
				.exceptionHandling()
					.accessDeniedHandler(restfulAccessDeniedHandler)
					.authenticationEntryPoint(restAuthorizationEntryPoint);
		// Jwt Token 过滤器校验
		http.addFilterBefore(jwtAuthencationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}


	@Bean
	public JwtAuthencationTokenFilter jwtAuthencationTokenFilter(){
		return new JwtAuthencationTokenFilter();
	}


	@Override
	@Bean
	public UserDetailsService userDetailsService(){
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Admin admin =  adminService.getAdminByUserName(username);
				if(null == admin){
					throw  new UsernameNotFoundException("用户记录不存在!");
				}
				return admin;
			}
		};
	}


	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}