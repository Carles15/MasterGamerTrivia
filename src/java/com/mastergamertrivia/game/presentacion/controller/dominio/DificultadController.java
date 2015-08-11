package com.mastergamertrivia.game.presentacion.controller.dominio;

import com.mastergamertrivia.game.common.json.JsonConverter;
import com.mastergamertrivia.game.dominio.Dificultad;
import com.mastergamertrivia.game.persistencia.DificultadDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DificultadController {
    
    @Autowired
    JsonConverter jsonConverter;
    
    @Autowired
    DificultadDAO dificultadDAO;
    
    
    @RequestMapping(value = {"/dificultad/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        Dificultad dificultad = dificultadDAO.get(id);
        httpServletResponse.setContentType("application/json");
        
        try {
            httpServletResponse.getWriter().println(jsonConverter.toJson(dificultad));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
                httpServletResponse.setContentType("text/plain");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (IOException ex1) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    @RequestMapping(value = {"/dificultad/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        try {
            dificultadDAO.delete(id);
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
                httpServletResponse.setContentType("text/plain");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (IOException ex1) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    @RequestMapping(value = {"/dificultad"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        httpServletResponse.setContentType("application/json");
        
        try {
            Dificultad dificultad = (Dificultad) jsonConverter.fromJson(jsonEntrada, Dificultad.class);
            dificultadDAO.insert(dificultad);
            httpServletResponse.getWriter().println(jsonConverter.toJson(dificultadDAO.get(dificultad.getId())));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = {"/dificultad"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        httpServletResponse.setContentType("application/json");
        try {
            Dificultad juego = (Dificultad) jsonConverter.fromJson(jsonEntrada, Dificultad.class);
            dificultadDAO.update(juego);
            httpServletResponse.getWriter().println(jsonConverter.toJson(dificultadDAO.get(juego.getId())));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = {"/dificultades"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("application/json");
        try {
            List<Dificultad> preguntas = dificultadDAO.findAll();
            httpServletResponse.getWriter().println(jsonConverter.toJson(preguntas));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
                httpServletResponse.setContentType("text/plain");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (IOException ex1) {
                throw new RuntimeException(ex);
            }
        }
    }
}
