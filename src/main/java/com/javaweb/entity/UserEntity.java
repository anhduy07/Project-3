package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -4988455421375043688L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "email", unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<RoleEntity> roles = new ArrayList<>();


    @OneToMany(mappedBy="staffs", fetch = FetchType.LAZY)
    private List<AssignmentBuilding> assignmentBuildingEntities = new ArrayList<>();

//    @OneToMany(mappedBy="users", fetch = FetchType.LAZY)
//    private List<UserRoleEntity> userRoleEntities = new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


//        @Override
//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(Long id) {
//        this.id = id;
//    }
}
