package br.com.alura.med_voll.api.controller;

import br.com.alura.med_voll.api.medico.DadosCadastroMedico;
import br.com.alura.med_voll.api.medico.Medico;
import br.com.alura.med_voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;



    @PostMapping
    @Transactional // Utilizado pois é um metodo de insert, em que dados vao ser inseridos
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

}
