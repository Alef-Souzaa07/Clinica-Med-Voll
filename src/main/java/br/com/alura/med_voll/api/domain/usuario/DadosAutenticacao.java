package br.com.alura.med_voll.api.domain.usuario;

import jakarta.validation.constraints.Email;

public record DadosAutenticacao(@Email String login,
                                String senha) {
}
