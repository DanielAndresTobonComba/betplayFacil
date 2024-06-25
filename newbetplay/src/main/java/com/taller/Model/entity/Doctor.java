package com.taller.Model.entity;

public class Doctor extends Person {
    private String titulo;
    private int expYear;
    private String IdEquipo;

    public Doctor () {
        
    }


    public Doctor(String titulo, int expYear, String idEquipo) {
        this.titulo = titulo;
        this.expYear = expYear;
        IdEquipo = idEquipo;
    }



    public Doctor(String nombre, String apellido, int edad, String titulo, int expYear, String idEquipo) {
        super(nombre, apellido, edad);
        this.titulo = titulo;
        this.expYear = expYear;
        IdEquipo = idEquipo;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public String getIdEquipo() {
        return IdEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        IdEquipo = idEquipo;
    }


    @Override
    public String toString() {
        return "Doctor [titulo=" + titulo + ", expYear=" + expYear + ", IdEquipo=" + IdEquipo + "]";
    }

    
}