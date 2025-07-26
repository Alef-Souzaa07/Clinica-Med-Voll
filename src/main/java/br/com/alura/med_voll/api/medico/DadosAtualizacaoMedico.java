package br.com.alura.med_voll.api.medico;

import br.com.alura.med_voll.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(@NotNull
                                     Long id,

                                     String nome,
                                     String telefne,
                                     DadosEndereco endereco) {
}
