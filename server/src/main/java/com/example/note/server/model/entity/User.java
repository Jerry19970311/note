package com.example.note.server.model.entity;

import com.example.note.server.model.objects.Gender;
import com.example.note.server.model.objects.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;
    @Email
    @Column(unique = true)
    private String email;
    private String password;
    private String userName;
    private Date createTime;
    private Gender gender;
    private Role role;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "noteList",
            joinColumns = {@JoinColumn(name = "uid")}
    )
    private List<Notes> notesList;
}
