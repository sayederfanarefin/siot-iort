package com.heyarfan.socialiot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.heyarfan.socialiot.repository.ThingRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    ThingRepository thingsRepository;

    @Override
    public UserDetails loadUserByUsername(String mac) throws UsernameNotFoundException {

    	UserDetails ud = this.thingsRepository.findByMacAddress(mac);
        return ud;
    }
}