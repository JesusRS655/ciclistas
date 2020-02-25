package application.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Cyclist;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist, Serializable> {

}
