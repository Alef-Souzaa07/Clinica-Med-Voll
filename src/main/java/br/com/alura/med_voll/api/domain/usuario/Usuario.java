package br.com.alura.med_voll.api.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter //Anotação lombok
@NoArgsConstructor //Anotação lombok
@AllArgsConstructor //Anotação lombok
@EqualsAndHashCode(of = "id") //Anotação lombok
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String senha;
}
