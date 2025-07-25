package br.com.alura.med_voll.api.controller;

import br.com.alura.med_voll.api.medico.DadosCadastroMedico;
import br.com.alura.med_voll.api.medico.DadosListagemMedico;
import br.com.alura.med_voll.api.medico.Medico;
import br.com.alura.med_voll.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;



    @PostMapping
    @Transactional // Utilizado pois é um metodo de insert, em que dados vao ser inseridos
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedico> listar(){//Criar dto para devolver dados
        return repository.findAll().stream()
                .map(DadosListagemMedico::new ).toList();//É preciso converter de Medico para DadosListagemMedico
    }

}
