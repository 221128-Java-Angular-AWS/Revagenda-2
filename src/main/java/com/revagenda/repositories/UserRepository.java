package com.revagenda.repositories;

import com.revagenda.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
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

    //auto generate a method that will look for a row in the table with a matching username
    User findByUsername(String username);
}
