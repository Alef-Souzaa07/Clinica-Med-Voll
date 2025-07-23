package br.com.alura.med_voll.api.controller;

import br.com.alura.med_voll.api.medico.DadosCadastroMedico;
import br.com.alura.med_voll.api.medico.Medico;
import br.com.alura.med_voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;



    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

}
