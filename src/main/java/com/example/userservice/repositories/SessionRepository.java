package com.example.userservice.repositories;

import com.example.userservice.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    @Override
    <S extends Session> S save(S entity);

    void deleteAllByUserId(Long userId);
}
