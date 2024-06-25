package com.taller.Model.entity;

public class Coach extends Person {
    private int idFederacion;
    private String idEquipo;

    public Coach(){
        super();
    }

    public Coach(int idFederacion, String idEquipo) {
        this.idFederacion = idFederacion;
        this.idEquipo = idEquipo;
    }

    public Coach(String nombre, String apellido, int edad, int idFederacion, String idEquipo) {
        super(nombre, apellido, edad);
        this.idFederacion = idFederacion;
        this.idEquipo = idEquipo;
    }

    public int getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(int idFederacion) {
        this.idFederacion = idFederacion;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public String toString() {
        return "Coach [idFederacion=" + idFederacion + ", idEquipo=" + idEquipo + "]";
    }

    
    
}