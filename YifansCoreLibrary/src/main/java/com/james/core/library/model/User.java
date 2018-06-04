package com.james.core.library.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="USER")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name="USER_ID")
	@JsonProperty("userId")
	private UUID userId;
	
	@Column(name="USERNAME", nullable=false, unique=true)
	@JsonProperty("username")
	private String username;
	
	@Column(name="EMAIL", nullable=false, unique=true)
	@JsonProperty("email")
	private String email;
	
	@Column(name="PASSWORD", nullable=false)
	@JsonProperty("password")
	private String password;
	
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_AUTHORITY", joinColumns = @JoinColumn(name = "AUTHORITY_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private Set<Authority> authorities;
	
	public User() {
		;
	}
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	@JsonCreator
	public User(@JsonProperty("userId") UUID userId, @JsonProperty("username") String username, @JsonProperty("email") String email, @JsonProperty("password") String password) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}
	
	public UUID getUserId() {
		return this.userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void addAuthority(Authority authority) {
		if(this.authorities == null) {
			this.authorities = new HashSet<Authority>();
		}
		
		this.authorities.add(authority);
	}
}
