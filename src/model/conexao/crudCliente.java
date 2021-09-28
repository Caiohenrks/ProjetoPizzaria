package model.conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entities.Pessoa;

public class crudCliente {

    public void createCliente(model.entities.Pessoa p) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome, sexo, "
                    + "data_nascimento, cpf, email, telefone, celular, cep,"
                    + " logradouro, numero, bairro, localidade, uf, pontoReferencia) VALUES(?,?, ?, ?, ?, ?,"
                    + " ?, ?, ?, ?, ?, ? ,? ,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSexo());
            stmt.setString(3, p.getData_nascimento());
            stmt.setString(4, p.getCPF());
            stmt.setString(5, p.getEmail());
            stmt.setString(6, p.getTelefone());
            stmt.setString(7, p.getCelular());
            stmt.setString(8, p.getCep());
            stmt.setString(9, p.getLogradouro());
            stmt.setString(10, p.getNumero());
            stmt.setString(11, p.getBairro());
            stmt.setString(12, p.getLocalidade());
            stmt.setString(13, p.getUf());
            stmt.setString(14, p.getPontoReferencia());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar" + ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt);
        }
    }

    public List<model.entities.Pessoa> readCliente() {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<model.entities.Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {

                model.entities.Pessoa pessoa = new model.entities.Pessoa();

                pessoa.setCod_cli(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setData_nascimento(rs.getString("data_nascimento"));
                pessoa.setCPF(rs.getString("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setCep(rs.getString("cep"));
                pessoa.setLogradouro(rs.getString("logradouro"));
                pessoa.setNumero(rs.getString("numero"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setLocalidade(rs.getString("localidade"));
                pessoa.setUf(rs.getString("uf"));
                pessoa.setPontoReferencia(rs.getString("pontoReferencia"));
                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return pessoas;
    }

    public List<model.entities.Pessoa> buscarCliente(String nome) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<model.entities.Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                model.entities.Pessoa pessoa = new model.entities.Pessoa();

                pessoa.setCod_cli(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setData_nascimento(rs.getString("data_nascimento"));
                pessoa.setCPF(rs.getString("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setCep(rs.getString("cep"));
                pessoa.setLogradouro(rs.getString("logradouro"));
                pessoa.setNumero(rs.getString("numero"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setLocalidade(rs.getString("localidade"));
                pessoa.setUf(rs.getString("uf"));
                pessoa.setPontoReferencia(rs.getString("pontoReferencia"));
                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return pessoas;
    }

    public Pessoa buscarId(int id) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        //List<model.entities.Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE id LIKE ?");
            stmt.setString(1, "%" + id + "%");
            pessoa = new Pessoa();
            rs = stmt.executeQuery();

            while (rs.next()) {

                pessoa.setCod_cli(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setData_nascimento(rs.getString("data_nascimento"));
                pessoa.setCPF(rs.getString("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setCep(rs.getString("cep"));
                pessoa.setLogradouro(rs.getString("logradouro"));
                pessoa.setNumero(rs.getString("numero"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setLocalidade(rs.getString("localidade"));
                pessoa.setUf(rs.getString("uf"));
                pessoa.setPontoReferencia(rs.getString("pontoReferencia"));
                //pessoas.add(pessoa);    
            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return pessoa;
    }

    public List<model.entities.Pessoa> buscarClienteCelular(String celular) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<model.entities.Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE celular LIKE ?");
            stmt.setString(1, "%" + celular + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                model.entities.Pessoa pessoa = new model.entities.Pessoa();

                pessoa.setCod_cli(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setData_nascimento(rs.getString("data_nascimento"));
                pessoa.setCPF(rs.getString("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setCep(rs.getString("cep"));
                pessoa.setLogradouro(rs.getString("logradouro"));
                pessoa.setNumero(rs.getString("numero"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setLocalidade(rs.getString("localidade"));
                pessoa.setUf(rs.getString("uf"));
                pessoa.setPontoReferencia(rs.getString("pontoReferencia"));
                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return pessoas;
    }

    public void atualizarCliente(model.entities.Pessoa p) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome = ? ,sexo = ?,data_nascimento = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSexo());
            stmt.setString(3, p.getData_nascimento());
            stmt.setString(4, p.getCPF());
            stmt.setString(5, p.getEmail());
            stmt.setString(6, p.getTelefone());
            stmt.setString(7, p.getCelular());
            stmt.setString(8, p.getCep());
            stmt.setString(9, p.getLogradouro());
            stmt.setString(10, p.getNumero());
            stmt.setString(11, p.getBairro());
            stmt.setString(12, p.getLocalidade());
            stmt.setString(13, p.getUf());
            stmt.setString(14, p.getPontoReferencia());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt);
        }

    }

    public void deleteCliente(model.entities.Pessoa p) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
            stmt.setInt(1, p.getCod_cli());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt);
        }
    }

}
