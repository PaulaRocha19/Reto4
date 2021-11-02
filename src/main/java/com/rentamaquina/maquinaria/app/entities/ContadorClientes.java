/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentamaquina.maquinaria.app.entities;

/**
 *
 * @author pau84
 */
public class ContadorClientes {
    private long total;
    private Client cliente;

    public ContadorClientes(long total, Client cliente) {
        this.total = total;
        this.cliente = cliente;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
    
    
}