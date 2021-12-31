package com.accesstrade.authz.entity;

import org.springframework.stereotype.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Indexed
@Entity
@Table(name = "AUTHZ")
public class AuthzEntity {
    @Id
    @Column(name = "AUTHZ_ID", nullable = false)
    private String id;

    @Column(name = "USESNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CLIENT_ID")
    private String clientId;

    @Column(name = "CLIENT_SECRET")
    private String clientSecret;

    @Column(name = "REDIRECT_URI")
    private String redirectUri;

    @Column(name = "UPDATED_TIMSTM")
    private Timestamp updatedDate;
}
