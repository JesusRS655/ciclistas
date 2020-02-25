package application.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Stage;

@Repository("stageRepository")
public interface StageRepository extends JpaRepository<Stage, Serializable> {

}
