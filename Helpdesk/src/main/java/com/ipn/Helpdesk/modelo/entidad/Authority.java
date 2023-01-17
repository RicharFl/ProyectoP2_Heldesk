package com.ipn.Helpdesk.modelo.entidad;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

}