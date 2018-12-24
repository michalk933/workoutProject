package com.workoutProject.workoutProject.repository;

import com.workoutProject.workoutProject.entity.Rep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepRepository extends JpaRepository<Rep, Long> {
}
