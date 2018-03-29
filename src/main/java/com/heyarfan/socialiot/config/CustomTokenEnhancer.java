package com.heyarfan.socialiot.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.heyarfan.socialiot.model.Thing;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Thing user = (Thing) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();

        additionalInfo.put("id", user.getId());
        additionalInfo.put("firstName", user.getMacAddress());
        additionalInfo.put("lastName", user.getCreatedAt());
       
        
//        String sb = "";
//        
//        Iterator<Role> roles = user.getRoles().iterator();
//		while (roles.hasNext()) {
//			Role r = roles.next();
//			Iterator<Privilege> privileges = r.getPrivileges().iterator();
//			while (privileges.hasNext()) {
//				Privilege privilege1 = privileges.next();
//				sb += " " + privilege1.getName();
//			}
//		}
//		
//		
//        additionalInfo.put("privileges", sb);

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

        return accessToken;
    }

}