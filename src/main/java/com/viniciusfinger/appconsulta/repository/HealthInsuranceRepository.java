package com.viniciusfinger.appconsulta.repository;

import com.viniciusfinger.appconsulta.model.HealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthInsuranceRepository extends JpaRepository<HealthInsurance, Long> {
}
