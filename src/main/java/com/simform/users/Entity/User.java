package com.simform.users.Entity;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
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
  private String email;
  private String password;
}
