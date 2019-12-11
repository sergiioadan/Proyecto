package com.example.proyecto2.repository;

import com.example.proyecto2.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository  extends JpaRepository<Veterinario,Long> {
}
