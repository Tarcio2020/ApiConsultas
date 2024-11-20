package com.github.Tarcio2020.ApiConsultasMedicas.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultas_medicas")
public class ConsultasMedicasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta") // Se o nome da coluna no BD for diferente do campo na classe
    private Long idConsulta;

    private String hospital;
    private String medico;
    private LocalDate data;
    private LocalTime hora;
    private Long recorrencia;
    private String especialidade;
    private String descricao;
    private String diagnostico;

    @Override
    public int hashCode() {
        return Objects.hash(idConsulta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ConsultasMedicasEntity other = (ConsultasMedicasEntity) obj;
        return Objects.equals(idConsulta, other.idConsulta);
    }

    // Getters and Setters
    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Long getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(Long recorrencia) {
        this.recorrencia = recorrencia;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
