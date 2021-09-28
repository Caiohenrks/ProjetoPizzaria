package model.conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entities.Pizza;

public class crudPizza {

    public void createPizza(model.entities.Pizza p) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pizza (nome, preco) VALUES(?,?)");
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

    public List<model.entities.Pizza> readPizza() {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<model.entities.Pizza> pizzas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pizza");
            rs = stmt.executeQuery();

            while (rs.next()) {

                model.entities.Pizza pizza = new model.entities.Pizza();

                pizza.setId(rs.getInt("id"));
                pizza.setNome(rs.getString("nome"));
                pizza.setPreco(rs.getDouble("preco"));
                pizzas.add(pizza);
            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return pizzas;
    }

    public List<model.entities.Pizza> buscarPizza(String nome) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<model.entities.Pizza> pizzas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pizza WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                model.entities.Pizza pizza = new model.entities.Pizza();

                pizza.setId(rs.getInt("id"));
                pizza.setNome(rs.getString("nome"));
                pizza.setPreco(rs.getDouble("preco"));
                pizzas.add(pizza);
            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return pizzas;
    }

    public Pizza buscarId(int id) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Pizza pizza = null ;
        try {
            stmt = con.prepareStatement("SELECT * FROM pizza WHERE id LIKE ?");
            stmt.setString(1, "%" + id + "%");
            pizza = new Pizza();
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                pizza.setId(rs.getInt("id"));
                pizza.setNome(rs.getString("nome"));
                pizza.setPreco(rs.getDouble("preco"));
  
            }

        } catch (SQLException ex) {
            Logger.getLogger(crudCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return pizza;
    }

    public void atualizarPizza(model.entities.Pizza p) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE pizza SET nome = ? ,preco = ? WHERE id = ?");
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

    public void deletePizza(model.entities.Pizza p) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM pizza WHERE id = ?");
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