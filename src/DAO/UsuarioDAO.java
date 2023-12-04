package DAO;

import DTO.UsuarioDTO;
import View.CadastroView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * @author giovanna borges - cg3018334
 */

public class UsuarioDAO {

    Connection conn; // faz a conexão
    PreparedStatement pstm; // prepara a conexão
    String sql; // armazena o comando sql que será enviado para o banco
    ResultSet rs; // armazena o valor de pesquisa do banco

    public ResultSet autenticacaoUsuario(UsuarioDTO usuarioDto) throws SQLException {
        conn = new ConexaoDAO().conectaBD();

        try {
            sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?;";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuarioDto.getEmail());
            pstm.setString(2, usuarioDto.getSenha());

            rs = pstm.executeQuery();

            return rs;
            
        } catch (SQLException erro) {
            System.out.println("Autenticação de Usuário: " + erro);
            return null;
        }
    }

    public ResultSet autenticacaoCpf(UsuarioDTO usuarioDto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            sql = "SELECT cpf FROM usuario WHERE cpf = ?;";
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, usuarioDto.getCpf());

            rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            System.out.println("Autenticação de CPF: " + erro);
            return null;
        }
    }

    public void cadastrarUsuario(UsuarioDTO usuarioDto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            sql = "INSERT INTO usuario (cpf, nome, nascimento, sexo, email, senha) VALUES (?, ?, ?, ?, ?, ?);";
            
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, usuarioDto.getCpf());
            pstm.setString(2, usuarioDto.getNome());
            pstm.setObject(3, usuarioDto.getNascimentoLD());            
            pstm.setString(4, usuarioDto.getSexo());
            pstm.setString(5, usuarioDto.getEmail());
            pstm.setString(6, usuarioDto.getSenha());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            System.out.println("Cadastro de Usuário: " + erro);
        }
    }
    
    public void alterarPerfil(UsuarioDTO usuarioDto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            sql = "UPDATE usuario SET nome = ?, nascimento = ?, sexo = ?, email = ?, senha = ? WHERE cpf = ?;";

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuarioDto.getNome());
            pstm.setObject(2, usuarioDto.getNascimentoLD());
            pstm.setString(3, usuarioDto.getSexo());            
            pstm.setString(4, usuarioDto.getEmail());
            pstm.setString(5, usuarioDto.getSenha());
            pstm.setLong(6, usuarioDto.getCpf());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            System.out.println("Atualização de Perfil: " + erro);
        }
    }
    
    public void deletarPerfil(UsuarioDTO usuarioDto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            sql = "DELETE FROM usuario WHERE cpf = ?;";
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, usuarioDto.getCpf());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            System.out.println("Deletar Perfil: " + erro);
        }
    }
}
