package com.mintgestao.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mintgestao.Domain.Enums.EnumStatusFilial;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.TenantId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String razaosocial;
    private String nomefantasia;
    private String apelido;
    private String email;
    private String telefone;
    private String ddd;
    private String endereco;
    private String numEndereco;
    private String cnpj;
    private Integer im;
    private Integer ie;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
    private EnumStatusFilial status;
    private Boolean padrao;
    private Date datahoracad;

    @JsonIgnore
    @ManyToMany(mappedBy = "filiais")
    private List<Usuario> usuarios = new ArrayList<>();

    @TenantId
    private Integer idtenant;
}