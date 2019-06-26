package aws.mitocode.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import aws.mitocode.spring.model.Persona;


@Repository
public interface IPersonaDao extends JpaRepository<Persona, Integer>{


}
