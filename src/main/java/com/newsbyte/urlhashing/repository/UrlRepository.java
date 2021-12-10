package com.newsbyte.urlhashing.repository;

import com.newsbyte.urlhashing.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<URL, String> {

    public Optional<URL> findByUrlHashKey(String hash);

    void deleteByUrlHashKey(String hash);
}
