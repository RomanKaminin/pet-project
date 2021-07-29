package io.kaminin.petproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`user`")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String position;
    private String phone;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String code;
}
