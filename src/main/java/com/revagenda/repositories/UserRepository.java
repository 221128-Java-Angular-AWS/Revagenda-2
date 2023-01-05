package com.revagenda.repositories;

import com.revagenda.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a repository, a bean that handles persistence of a particular type of resource. This repo
 * handles persistence of User objects. Note that we extend JpaRepository, then we typify it with the
 * User model class, and the type of the primary key field, Integer.
 *
 * This is an interface, and is thus abstract. We do not need to provide concrete implementations for the
 * methods. Spring will assemble a bean by creating concrete implementations for us. When we extend the
 * JpaRepository (and mark it as a @Repository bean) we will automatically get a bunch of concrete methods
 * including save, saveAll, findById, findAll, findAllById, delete, and more.
 *
 * Spring will even attempt to create concrete implementations for method signatures we write. It's a little
 * finicky, and we don't have direct control over how it works. See `User findByUsername(String username);` below.
 */
@Repository
@Transactional
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
