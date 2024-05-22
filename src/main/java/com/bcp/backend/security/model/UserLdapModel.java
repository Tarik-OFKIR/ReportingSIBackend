package com.bcp.backend.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLdapModel {

    private String cn;
    private String sn;
    private String uid;
    private String password;

}