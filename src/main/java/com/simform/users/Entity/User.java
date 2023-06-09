package com.simform.users.Entity;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")


public class User {
  @Id
  @SequenceGenerator(
          name = "user_sequence",
          sequenceName = "user_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "user_sequence"
  )
  private Integer id;
  private String userName;
  @Column(name = "email",nullable = false,unique = true)
  private String email;
  private String password;
}
