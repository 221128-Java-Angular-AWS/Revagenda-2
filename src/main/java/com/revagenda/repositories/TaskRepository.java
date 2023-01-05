package com.revagenda.repositories;

import com.revagenda.models.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional()
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
