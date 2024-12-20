package com.doadores.doadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doadores.doadores.entity.Doador;

/**
 * Define as operações que serão realizadas com a entidade Doador.
 */
@Repository
public interface DoadoresRepository extends JpaRepository<Doador, Long>{
}
