package com.github.Tarcio2020.ApiConsultasMedicas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Tarcio2020.ApiConsultasMedicas.entities.ConsultasMedicasEntity;
import com.github.Tarcio2020.ApiConsultasMedicas.repository.ConsultasMedicasRepository;

@Service
public class ConsultasMedicasService {

    @Autowired
    private ConsultasMedicasRepository consultasMedicasRepository;

    public ConsultasMedicasEntity criar(ConsultasMedicasEntity consultasMedicasEntity) {
        return consultasMedicasRepository.save(consultasMedicasEntity);
    }

    public void deletar(Long id_consulta) {
        consultasMedicasRepository.deleteById(id_consulta);
    }

    public ConsultasMedicasEntity update(Long id_consulta, ConsultasMedicasEntity consultasMedicasEntity) {
        // Verifica se a consulta existe
        Optional<ConsultasMedicasEntity> consultaExistente = consultasMedicasRepository.findById(id_consulta);
        
        if (consultaExistente.isPresent()) {
            // Atualiza os campos com os novos dados
            ConsultasMedicasEntity consultaAtualizada = consultaExistente.get();
            consultaAtualizada.setHospital(consultasMedicasEntity.getHospital());
            consultaAtualizada.setMedico(consultasMedicasEntity.getMedico());
            consultaAtualizada.setData(consultasMedicasEntity.getData());
            consultaAtualizada.setHora(consultasMedicasEntity.getHora());
            consultaAtualizada.setRecorrencia(consultasMedicasEntity.getRecorrencia());
            consultaAtualizada.setEspecialidade(consultasMedicasEntity.getEspecialidade());
            consultaAtualizada.setDescricao(consultasMedicasEntity.getDescricao());
            consultaAtualizada.setDiagnostico(consultasMedicasEntity.getDiagnostico());

            // Salva a consulta atualizada
            return consultasMedicasRepository.save(consultaAtualizada);
        } else {
            // Se a consulta não for encontrada, pode-se lançar uma exceção ou retornar null
            throw new RuntimeException("Consulta com id " + id_consulta + " não encontrada");
        }
    }

    public List<ConsultasMedicasEntity> lista() {
        return consultasMedicasRepository.findAll();
    }

    public ConsultasMedicasEntity atualizarParcialmente(Long id_consulta, ConsultasMedicasEntity updates) {
        Optional<ConsultasMedicasEntity> optionalConsultasMedicasEntity = consultasMedicasRepository.findById(id_consulta);

        if (optionalConsultasMedicasEntity.isPresent()) {
            ConsultasMedicasEntity consultasMedicasEntity = optionalConsultasMedicasEntity.get();

            // Atualiza apenas os campos que não são nulos
            if (updates.getHospital() != null) {
                consultasMedicasEntity.setHospital(updates.getHospital());
            }
            if (updates.getMedico() != null) {
                consultasMedicasEntity.setMedico(updates.getMedico());
            }
            if (updates.getData() != null) {
                consultasMedicasEntity.setData(updates.getData());
            }
            if (updates.getHora() != null) {
                consultasMedicasEntity.setHora(updates.getHora());
            }
            if (updates.getRecorrencia() != null) {
                consultasMedicasEntity.setRecorrencia(updates.getRecorrencia());
            }
            if (updates.getEspecialidade() != null) {
                consultasMedicasEntity.setEspecialidade(updates.getEspecialidade());
            }
            if (updates.getDescricao() != null) {
                consultasMedicasEntity.setDescricao(updates.getDescricao());
            }
            if (updates.getDiagnostico() != null) {
                consultasMedicasEntity.setDiagnostico(updates.getDiagnostico());
            }

            return consultasMedicasRepository.save(consultasMedicasEntity);
        } else {
            return null;
        }
    }
}
