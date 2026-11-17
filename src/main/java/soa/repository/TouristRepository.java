package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import soa.model.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Integer>{

}
