package com.najkhan.javaNotesApi.repository;

import com.najkhan.javaNotesApi.model.Users;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CassandraRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}
