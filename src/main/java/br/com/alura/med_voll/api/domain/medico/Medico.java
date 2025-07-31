package br.com.alura.med_voll.api.domain.medico;

import br.com.alura.med_voll.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter //Anotação lombok
@NoArgsConstructor //Anotação lombok
@AllArgsConstructor //Anotação lombok
@EqualsAndHashCode(of = "id") //Anotação lombok
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded // quando tem um grupo de campos que se repetem em várias entidades
    private Endereco endereco;

    private boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefne() != null){
            this.telefone = dados.telefne();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
