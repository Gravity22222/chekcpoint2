package br.com.fiap.checkpoint2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.DTOs.ConsultaDTO;
import br.com.fiap.checkpoint2.model.Consulta;
import br.com.fiap.checkpoint2.model.Paciente;
import br.com.fiap.checkpoint2.model.Profissional;
import br.com.fiap.checkpoint2.repository.ConsultaRepository;
import br.com.fiap.checkpoint2.repository.PacienteRepository;
import br.com.fiap.checkpoint2.repository.ProfissionalRepository;

@Service
public class ConsultaService {
      @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public ConsultaDTO createConsulta(ConsultaDTO consultaDTO) {
        
        Profissional profissional = profissionalRepository.findById(consultaDTO.getProfissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado com ID: " + consultaDTO.getProfissionalId()));

        Paciente paciente = pacienteRepository.findById(consultaDTO.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + consultaDTO.getPacienteId()));

        
        Consulta consulta = new Consulta();
        consulta.setProfissional(profissional); 
        consulta.setPaciente(paciente); 
        consulta.setDataConsulta(consultaDTO.getDataConsulta());
        consulta.setStatusConsulta(consultaDTO.getStatusConsulta());
        consulta.setQuantidadeHoras(consultaDTO.getQuantidadeHoras());
        consulta.setValorConsulta(consultaDTO.getValorConsulta());

        
        Consulta savedConsulta = consultaRepository.save(consulta);

       
        return new ConsultaDTO(
                savedConsulta.getId(),
                savedConsulta.getProfissional().getId(),
                savedConsulta.getPaciente().getId(),
                savedConsulta.getDataConsulta(),
                savedConsulta.getStatusConsulta(),
                savedConsulta.getQuantidadeHoras(),
                savedConsulta.getValorConsulta()
        );
    }

    public List<ConsultaDTO> getAllConsultas() {
        return consultaRepository.findAll()
                .stream()
                .map(consulta -> new ConsultaDTO(
                        consulta.getId(),
                        consulta.getProfissional().getId(),
                        consulta.getPaciente().getId(),
                        consulta.getDataConsulta(),
                        consulta.getStatusConsulta(),
                        consulta.getQuantidadeHoras(),
                        consulta.getValorConsulta()
                ))
                .collect(Collectors.toList());
    }

    public ConsultaDTO getConsultaById(Long id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return consulta.map(c -> new ConsultaDTO(
                c.getId(),
                c.getProfissional().getId(),
                c.getPaciente().getId(),
                c.getDataConsulta(),
                c.getStatusConsulta(),
                c.getQuantidadeHoras(),
                c.getValorConsulta()
        )).orElse(null);
    }

    public ConsultaDTO updateConsulta(Long id, ConsultaDTO consultaDTO) {
    
        Optional<Consulta> optionalConsulta = consultaRepository.findById(id);

        if (optionalConsulta.isEmpty()) {
            return null; 
        }

        Consulta consulta = optionalConsulta.get();

        
        Profissional profissional = profissionalRepository.findById(consultaDTO.getProfissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado com ID: " + consultaDTO.getProfissionalId()));

        Paciente paciente = pacienteRepository.findById(consultaDTO.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + consultaDTO.getPacienteId()));

        
        consulta.setProfissional(profissional);
        consulta.setPaciente(paciente);
        consulta.setDataConsulta(consultaDTO.getDataConsulta());
        consulta.setStatusConsulta(consultaDTO.getStatusConsulta());
        consulta.setQuantidadeHoras(consultaDTO.getQuantidadeHoras());
        consulta.setValorConsulta(consultaDTO.getValorConsulta());

        
        Consulta updatedConsulta = consultaRepository.save(consulta);

  
        return new ConsultaDTO(
                updatedConsulta.getId(),
                updatedConsulta.getProfissional().getId(),
                updatedConsulta.getPaciente().getId(),
                updatedConsulta.getDataConsulta(),
                updatedConsulta.getStatusConsulta(),
                updatedConsulta.getQuantidadeHoras(),
                updatedConsulta.getValorConsulta()
        );
    }

    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
