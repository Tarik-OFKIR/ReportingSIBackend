package com.bcp.backend.security.services;

import com.bcp.backend.security.model.UserLdapModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class Services {
    @Autowired
    private LdapTemplate ldapTemplate;
    private static final String BASE_DN = "dc=example,dc=com";
    public UserLdapModel getUserDetails(String username) {
        return ldapTemplate.search(BASE_DN,
                query().where("uid").is(username).toString(),
                (AttributesMapper<UserLdapModel>) attributes -> {
            UserLdapModel user = new UserLdapModel();
            user.setCn(attributes.get("cn").get().toString());
            user.setSn(attributes.get("sn").get().toString());
            user.setUid(attributes.get("uid").get().toString());
            return user;
        }).get(0);
    }
}

