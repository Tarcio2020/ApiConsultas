package com.github.Tarcio2020.ApiConsultasMedicas.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.Tarcio2020.ApiConsultasMedicas.entities.ConsultasMedicasEntity;

@Repository
public interface ConsultasMedicasRepository extends JpaRepository<ConsultasMedicasEntity, Long> {

    // Consulta para encontrar agendamentos futuros
    List<ConsultasMedicasEntity> findByDataAfter(LocalDate dataAtual);
}
