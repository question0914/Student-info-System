package com.demo.repository;

import com.demo.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends JpaRepository<StudentEntity, Integer> {

    @Modifying
    @Transactional
    // How to query
    // @Param annotation
    @Query("update StudentEntity us set us.name=:qname, us.id=:qid, us.gpa=:qgpa, us.major=:qmajor where us.id=:qid")
    public void updateUser(@Param("qname") String name, @Param("qid") int id,
                           @Param("qgpa") Double qgpa, @Param("qmajor") String major);
}

