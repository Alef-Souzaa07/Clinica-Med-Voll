package br.com.alura.med_voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Embeddable
@Getter //Anotação lombok
@NoArgsConstructor //Anotação lombok
@AllArgsConstructor //Anotação lombok
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        Optional.ofNullable(dados.bairro()).ifPresent(b -> this.bairro = b);//É a mesma coisa que o if acima
        Optional.ofNullable(dados.cep()).ifPresent(cep -> this.cep = cep);
        Optional.ofNullable(dados.cidade()).ifPresent(c -> this.cidade = c);
        Optional.ofNullable(dados.uf()).ifPresent(u -> this.uf = u);
        Optional.ofNullable(dados.numero()).ifPresent(n -> this.numero = n);
        Optional.ofNullable(dados.complemento()).ifPresent(comp -> this.complemento = comp);

    }
}
