package org.example.repository;

import org.example.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}



