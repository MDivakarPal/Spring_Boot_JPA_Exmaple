package com.example.spingDataJpa.springDataJpaTutorial.jpaRepos;

import com.example.spingDataJpa.springDataJpaTutorial.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Long > {
}
