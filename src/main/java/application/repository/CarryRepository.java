package application.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Carry;

@Repository("carryRepository")
public interface CarryRepository extends JpaRepository<Carry, Serializable> {

}
