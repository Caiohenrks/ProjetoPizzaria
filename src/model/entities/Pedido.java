package model.entities;

import java.util.Date;

public class Pedido {

    private int idPedido;
    private String produtos;
    private double valor;
    private Date data;
    private Pessoa pessoa;

    public Pedido() {
    }

    public Pedido(String produtos, double valor, Date data, Pessoa pessoa) {

        this.produtos = produtos;
        this.valor = valor;
        this.data = data;
        this.pessoa = pessoa;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    

}
