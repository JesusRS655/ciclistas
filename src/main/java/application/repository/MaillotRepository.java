package application.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Maillot;

@Repository("maillotRepository")
public interface MaillotRepository extends JpaRepository<Maillot, Serializable> {

}
