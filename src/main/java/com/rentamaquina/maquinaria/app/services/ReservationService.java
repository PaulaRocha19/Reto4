/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.repositories.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pau8470
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;
    
    /** 
     * GET
     * @return
     */
    public List<Reservation> getAll() {
        return  repository.getAll();
    }
    
    /** 
     * Buscar por ID
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservation(Integer reservationId){
        return repository.getReservation(reservationId);
    
    }
    
     /**
     * POST
     * @param reservation
     * @return 
     */
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return repository.save(reservation);
        }else{
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                return reservation;
            }else{
                return repository.save(reservation);
            }
        }
    }
    
     /**
     * UPDATE
     * @param reservation
     * @return 
     */
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                if(reservation.getStartDate()!=null){
                    resultado.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()==null){
                    resultado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()==null){
                    resultado.get().setStatus(reservation.getStatus());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
      
    
    
    /** 
     * Delete
     * @param reservationId
     */
    public boolean deleteReservation(Integer reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
