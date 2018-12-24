package com.workoutProject.workoutProject.repository;

import com.workoutProject.workoutProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    @Query(
            value = "SELECT EXISTS( SELECT 1 FROM public.users WHERE user_name = ?1)",
            nativeQuery = true
    )
    boolean isExist(String userName);

}
