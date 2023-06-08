package com.simform.users.Repository;

import com.simform.users.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User , Integer> {

  @Query("select u from User u where u.email=?1")
  public User fetchByEmail(String email);
}
