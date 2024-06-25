package com.taller;

import java.util.Hashtable;

import com.taller.Model.entity.Coach;
import com.taller.Model.entity.Doctor;
import com.taller.Model.entity.Player;
import com.taller.Model.entity.Team;

public class Controller {
    public Hashtable <String,Team> equipos = new Hashtable<>();
    public Hashtable <String,Player> jugadores = new Hashtable<>();
    public Hashtable <String,Coach> entrenadores = new Hashtable<>();
    public Hashtable <String,Doctor> doctores = new Hashtable<>();
}
