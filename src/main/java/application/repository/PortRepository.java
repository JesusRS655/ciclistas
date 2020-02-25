package application.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Port;

@Repository("portRepository")
public interface PortRepository extends JpaRepository<Port, Serializable> {

}
