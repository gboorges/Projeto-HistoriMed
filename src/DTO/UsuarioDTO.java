package DTO;

import java.time.LocalDate;

/**
 * @author giovanna borges - cg3018334
 */

public class UsuarioDTO {
    private String nome;
    private long cpf;
    private LocalDate nascimentoLD;
    private String nascimentoS;
    private String sexo;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimentoLD() {
        return nascimentoLD;
    }

    public void setNascimentoLD(LocalDate nascimentoLD) {
        this.nascimentoLD = nascimentoLD;
    }
    
    public String getNascimentoS() {
        return nascimentoS;
    }

    public void setNascimentoS(String nascimentoS) {
        this.nascimentoS = nascimentoS;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UsuarioDTO{");
        sb.append("nome=").append(nome);
        sb.append(", cpf=").append(cpf);
        sb.append(", nascimentoLD=").append(nascimentoLD);
        sb.append(", nascimentoS=").append(nascimentoS);
        sb.append(", sexo=").append(sexo);
        sb.append(", email=").append(email);
        sb.append(", senha=").append(senha);
        sb.append('}');
        return sb.toString();
    }    
}
