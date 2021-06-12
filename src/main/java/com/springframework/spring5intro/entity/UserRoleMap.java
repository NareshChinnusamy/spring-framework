package com.springframework.spring5intro.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_role_map", schema = "naresh")
public class UserRoleMap {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_map_seq_gen")
    @SequenceGenerator(name = "user_role_map_seq_gen", sequenceName = "user_role_map_seq", schema = "naresh",
            allocationSize = 1)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long user_id;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "created_Date")
    private Instant createdDate;
}
