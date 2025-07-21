package br.com.alura.med_voll.api.controller;

import br.com.alura.med_voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        System.out.println(dados);
    }

}
