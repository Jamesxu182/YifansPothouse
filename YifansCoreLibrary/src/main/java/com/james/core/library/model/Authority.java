package com.james.core.library.model;

import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

import com.james.core.library.model.type.AuthorityType;

@Entity
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHORITY_ID")
    private Long authorityId;

    @Basic
    @Column(name = "AUTHORITY", nullable = false, unique = true, length = 45)
    @Enumerated(EnumType.STRING)
    private AuthorityType authority;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<User> users;

    public Authority() {
    	;
    }
    
    public Authority(AuthorityType authority) {
    	this.authority = authority;
    }
    
	@Override
	public String getAuthority() {
		return this.authority.toString();
	}
}
