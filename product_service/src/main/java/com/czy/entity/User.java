package com.czy.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    private Integer id;
    @Column( name="username" )
    private String username;

    @Column( name="password" )
    private String password;

    @Column( name="truename" )
    private String trueName;

    @Column( name="role_id" )
    private Integer role_id;

    @Column( name="supervisor" )
    private String supervisor;
}
