package org.enset.contrat.repository;


import org.enset.contrat.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ContratRepository extends JpaRepository<Contrat,Long> {


    Contrat findByCinClient(String cin);
}
