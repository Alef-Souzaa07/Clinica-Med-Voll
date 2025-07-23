package br.com.alura.med_voll.api.medico;

import br.com.alura.med_voll.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,//Padrao crm tem que ter de 4 a 6 digitos

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco) {

}//Vou utilizar o enum nas "especialidades", por que dentro de especialodades, os valores sao fixos.