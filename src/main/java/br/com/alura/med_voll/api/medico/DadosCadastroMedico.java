package br.com.alura.med_voll.api.medico;

import br.com.alura.med_voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome,
                                  String email,
                                  String crm,
                                  Especialidade especialidade,
                                  DadosEndereco endereco) {
}//Vou utilizar o enum nas "especialidades", por que dentro de especialodades, os valores sao fixos.