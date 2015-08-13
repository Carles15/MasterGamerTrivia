package com.mastergamertrivia.game.persistencia;

import com.mastergamertrivia.game.dominio.Pregunta;
import java.util.List;


public interface PreguntaDAO extends GenericDAO <Pregunta>{
    public List<Pregunta> batteryGenerator();
}
