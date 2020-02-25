package application.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.News;

@Repository("newsRepository")
public interface NewsRepository extends JpaRepository<News, Serializable> {

}
