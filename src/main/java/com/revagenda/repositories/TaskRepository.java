package com.revagenda.repositories;

import com.revagenda.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * This is a repository, a bean that handles persistence of a particular type of resource. This repo
 * handles persistence of Task objects. Note that we extend JpaRepository, then we typify it with the
 * Task model class, and the type of the primary key field, Integer.
 *
 * This is an interface, and is thus abstract. We do not need to provide concrete implementations for the
 * methods. Spring will assemble a bean by creating concrete implementations for us. When we extend the
 * JpaRepository (and mark it as a @Repository bean) we will automatically get a bunch of concrete methods
 * including save, saveAll, findById, findAll, findAllById, delete, and more.
 *
 * Spring will even attempt to create concrete implementations for method signatures we write. It's a little
 * finicky, and we don't have direct control over how it works. See `List<Task> findTaskByUserId(Integer userId);`
 * below.
 *
 * We can also directly write queries in a number of expression languages including HQL, JPQL, and native SQL.
 * See `List<Task> findByUserIdJpql(@Param("userId") Integer userId);` below.
 */
@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Integer> {
        /*
    Extending the CrudRepository should implement the following CRUD operations for us:
    save()
    saveAll()
    findById() - find task row based on PK task ID
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
     */

    List<Task> findTaskByUserId(Integer userId);

    @Query(value = "SELECT * FROM tasks WHERE user_id = :userId", nativeQuery = true)
    List<Task> findByUserIdJpql(@Param("userId") Integer userId);

}
