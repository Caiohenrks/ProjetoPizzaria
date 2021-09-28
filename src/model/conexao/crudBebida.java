package model.conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entities.Bebida;

public class crudBebida {

    public void createBebida(Bebida p) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO bebida (nome, preco) VALUES(?,?)");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar" + ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt);
        }
    }

    public List<Bebida> readBebida() {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Bebida> bebidas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM bebida");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Bebida bebida = new Bebida();

                bebida.setId(rs.getInt("id"));
                bebida.setNome(rs.getString("nome"));
                bebida.setPreco(rs.getDouble("preco"));
                bebidas.add(bebida);
            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return bebidas;
    }

    public List<Bebida> buscarBebida(String nome) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Bebida> bebidas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM bebida WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Bebida bebida = new Bebida();

                bebida.setId(rs.getInt("id"));
                bebida.setNome(rs.getString("nome"));
                bebida.setPreco(rs.getDouble("preco"));
                bebidas.add(bebida);
            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return bebidas;
    }

    public Bebida buscarId(int id) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Bebida bebida = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM bebida WHERE id LIKE ?");
            stmt.setString(1, "%" + id + "%");
            bebida = new Bebida();
            rs = stmt.executeQuery();

            while (rs.next()) {

                bebida.setId(rs.getInt("id"));
                bebida.setNome(rs.getString("nome"));
                bebida.setPreco(rs.getDouble("preco"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return bebida;
    }

    public void atualizarBebida(Bebida p) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE bebida SET nome = ? ,preco = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt);
        }

    }

    public void deleteBebida(Bebida p) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM bebida WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt);
        }
    }

}
