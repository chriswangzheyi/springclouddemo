package com.wzy.springclouddemo.config;


//spring security的config 需要跟被使用的项目的包名一致或者在被使用项目的包名下
// 如provider的启动项包名是com.wz.yspringclouddemo, 这里就需要是com.wzy.springclouddemo.config

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/hystrix.stream","/turbine.stream") ; //这两个信息忽略安全访问限制
	}
	
	@Resource
	public void configGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("demo").password("demo")
				.roles("USER").and().withUser("admin").password("hello")
				.roles("USER", "ADMIN");
		  // 创建了一个账号名demo,密码demo. 另一个账号名admin，密码hello
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 表示所有的访问都必须进行认证处理后才可以正常进行
		http.httpBasic().and().authorizeRequests().anyRequest()
				.fullyAuthenticated();
		// 所有的Rest服务一定要设置为无状态，以提升操作性能
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
