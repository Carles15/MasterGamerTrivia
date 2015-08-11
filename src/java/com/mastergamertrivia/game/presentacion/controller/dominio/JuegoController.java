package com.mastergamertrivia.game.presentacion.controller.dominio;

import com.mastergamertrivia.game.common.json.JsonConverter;
import com.mastergamertrivia.game.dominio.Juego;
import com.mastergamertrivia.game.persistencia.JuegoDAO;
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
public class JuegoController {
    
    @Autowired
    JsonConverter jsonConverter;
    
    @Autowired
    JuegoDAO juegoDAO;
    
    @RequestMapping(value = {"/juego/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        Juego juego = juegoDAO.get(id);
        httpServletResponse.setContentType("application/json");
        
        try {
            httpServletResponse.getWriter().println(jsonConverter.toJson(juego));
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
    
    @RequestMapping(value = {"/juego/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        try {
            juegoDAO.delete(id);
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
    
    @RequestMapping(value = {"/juego"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        httpServletResponse.setContentType("application/json");
        
        try {
            Juego juego = (Juego) jsonConverter.fromJson(jsonEntrada, Juego.class);
            juegoDAO.insert(juego);
            httpServletResponse.getWriter().println(jsonConverter.toJson(juegoDAO.get(juego.getId())));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = {"/juego"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        httpServletResponse.setContentType("application/json");
        try {
            Juego juego = (Juego) jsonConverter.fromJson(jsonEntrada, Juego.class);
            juegoDAO.update(juego);
            httpServletResponse.getWriter().println(jsonConverter.toJson(juegoDAO.get(juego.getId())));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = {"/juegos"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("application/json");
        try {
            List<Juego> preguntas = juegoDAO.findAll();
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
