package aws.mitocode.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import aws.mitocode.spring.model.Curso;


@Repository
public interface ICursoDao extends JpaRepository<Curso, Integer>{


}
