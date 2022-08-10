package com.example.jpah2demo;

import com.example.jpah2demo.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Endereco, Long> {
}
