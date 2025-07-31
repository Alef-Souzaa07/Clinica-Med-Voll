package br.com.alura.med_voll.api.domain.medico;

import br.com.alura.med_voll.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(@NotNull
                                     Long id,

                                     String nome,
                                     String telefne,
                                     DadosEndereco endereco) {
}
