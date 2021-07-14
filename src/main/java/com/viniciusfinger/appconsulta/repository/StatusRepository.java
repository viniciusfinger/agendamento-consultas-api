package com.viniciusfinger.appconsulta.repository;

import com.viniciusfinger.appconsulta.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    public Status findByName(String name);
}
