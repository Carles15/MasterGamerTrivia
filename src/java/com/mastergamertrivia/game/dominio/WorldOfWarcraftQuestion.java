package com.mastergamertrivia.game.dominio;


public class WorldOfWarcraftQuestion {
    private int id;
    private String enunciado;
    private String respuestaFalsa1;
    private String respuestaFalsa2;
    private String respuestaFalsa3;
    private String respuestaCorrecta;
    private int juegoPertenece;
    private int idDificultad;

    public WorldOfWarcraftQuestion() {
    }

    public WorldOfWarcraftQuestion(int id, String enunciado, String respuestaFalsa1, String respuestaFalsa2, String respuestaFalsa3, String respuestaCorrecta, int juegoPertenece, int idDificultad) {
        this.id = id;
        this.enunciado = enunciado;
        this.respuestaFalsa1 = respuestaFalsa1;
        this.respuestaFalsa2 = respuestaFalsa2;
        this.respuestaFalsa3 = respuestaFalsa3;
        this.respuestaCorrecta = respuestaCorrecta;
        this.juegoPertenece = juegoPertenece;
        this.idDificultad = idDificultad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespuestaFalsa1() {
        return respuestaFalsa1;
    }

    public void setRespuestaFalsa1(String respuestaFalsa1) {
        this.respuestaFalsa1 = respuestaFalsa1;
    }

    public String getRespuestaFalsa2() {
        return respuestaFalsa2;
    }

    public void setRespuestaFalsa2(String respuestaFalsa2) {
        this.respuestaFalsa2 = respuestaFalsa2;
    }

    public String getRespuestaFalsa3() {
        return respuestaFalsa3;
    }

    public void setRespuestaFalsa3(String respuestaFalsa3) {
        this.respuestaFalsa3 = respuestaFalsa3;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getJuegoPertenece() {
        return juegoPertenece;
    }

    public void setJuegoPertenece(int juegoPertenece) {
        this.juegoPertenece = juegoPertenece;
    }

    public int getIdDificultad() {
        return idDificultad;
    }

    public void setIdDificultad(int idDificultad) {
        this.idDificultad = idDificultad;
    }
    
    
}
