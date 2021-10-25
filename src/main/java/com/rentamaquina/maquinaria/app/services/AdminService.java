/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Admin;
import com.rentamaquina.maquinaria.app.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pau8470
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;
    
    /** 
     * GET
     * @return
     */
    public List<Admin> getAll() {
        return  repository.getAll();
    }
    
    /** 
     * Buscar por ID
     * @param adminId
     * @return
     */
    public Optional<Admin> getAdmin(Integer adminId){
        return repository.getAdmin(adminId);
    
    }
    
     /**
     * POST
     * @param admin
     * @return 
     */
    public Admin save(Admin admin){
        if(admin.getIdAdmin()==null){
            return repository.save(admin);
        }else{
            Optional<Admin> resultado = repository.getAdmin(admin.getIdAdmin());
            if(resultado.isPresent()){
                return admin;
            }else{
                return repository.save(admin);
            }
        }
    }
    
     /**
     * UPDATE
     * @param admin
     * @return 
     */
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> resultado = repository.getAdmin(admin.getIdAdmin());
            if(resultado.isPresent()){
                if(admin.getEmail()!=null){
                    resultado.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    resultado.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    resultado.get().setName(admin.getName());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
      
    
    
    /** 
     * Delete
     * @param adminId
     */
    public boolean deleteAdmin(Integer adminId) {
        Boolean aBoolean = getAdmin(adminId).map(admin -> {
            repository.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
    
}
