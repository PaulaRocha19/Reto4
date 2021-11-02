/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentamaquina.maquinaria.app.entities;

/**
 *
 * @author pau84
 */
public class StatusReservas {
   private int complete;
   private int cancelled;

    public StatusReservas(int complete, int cancelled) {
        this.complete = complete;
        this.cancelled = cancelled;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }  
}