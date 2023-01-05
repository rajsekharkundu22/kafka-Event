package com.example.Consumer.repo;

import com.example.Consumer.model.WikiData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiRepo extends JpaRepository<WikiData, Integer> {
}
