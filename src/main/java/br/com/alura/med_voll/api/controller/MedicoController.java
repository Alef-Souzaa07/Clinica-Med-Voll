package br.com.alura.med_voll.api.controller;

import br.com.alura.med_voll.api.domain.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;



    @PostMapping
    @Transactional // Utilizado pois é um metodo de insert, em que dados vao ser inseridos
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(Pageable paginacao){//Criar dto para devolver dados
        var page = repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedico::new );//É preciso converter de Medico para DadosListagemMedico
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());//Carregou os dados do medico pelo id
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")//Vai receber o id do medico
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);//Carregou os dados do medico pelo id
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")//Vai receber o id do medico
    public ResponseEntity Detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);//Carregou os dados do medico pelo id

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

}
