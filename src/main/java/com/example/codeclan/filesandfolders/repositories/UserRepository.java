package com.example.codeclan.filesandfolders.repositories;

import com.example.codeclan.filesandfolders.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
