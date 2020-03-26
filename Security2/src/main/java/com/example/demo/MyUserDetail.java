package com.example.demo;

	import java.util.Arrays;
	import java.util.Collection;
	import java.util.List;
	import java.util.stream.Collectors;

	import org.springframework.security.core.GrantedAuthority;
	import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

	public class MyUserDetail implements UserDetails{

		private String userName;
		private String password;
		private boolean active;
		private List<GrantedAuthority> authorities;
		
		public MyUserDetail(UserModel user) {
			this.userName = user.getUsername();
			this.password = user.getPassword();
			this.active = user.isActive();
			this.authorities = Arrays.stream(user.getRoles().split(","))
										.map(SimpleGrantedAuthority::new)
										.collect(Collectors.toList());
		}
		
		public MyUserDetail() {
			
		}
		
		
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		
		public String getPassword() {
			return password;
		}

		
		public String getUsername() {
			return userName;
		}

		
		public boolean isAccountNonExpired() {
			return true;
		}

		
		public boolean isAccountNonLocked() {
			return true;
		}

		
		public boolean isCredentialsNonExpired() {
			return true;
		}

		
		public boolean isEnabled() {
			return active;
		}

	}
