package application.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Team;

@Repository("teamRepository")
public interface TeamRepository extends JpaRepository<Team, Serializable> {

}
