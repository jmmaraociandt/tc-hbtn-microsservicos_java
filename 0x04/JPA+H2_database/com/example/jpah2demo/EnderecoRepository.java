package com.example.jpah2demo;

import com.example.jpah2demo.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Telefone, Long> {
}
