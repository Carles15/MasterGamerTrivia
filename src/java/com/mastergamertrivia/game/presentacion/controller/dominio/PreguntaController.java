package com.mastergamertrivia.game.presentacion.controller.dominio;

import com.mastergamertrivia.game.common.json.JsonConverter;
import com.mastergamertrivia.game.dominio.Pregunta;
import com.mastergamertrivia.game.persistencia.PreguntaDAO;
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
public class PreguntaController {
    
    @Autowired
    JsonConverter jsonConverter;
    
    @Autowired
    PreguntaDAO preguntaDAO;
    
    @RequestMapping(value = {"/pregunta/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        Pregunta pregunta = preguntaDAO.get(id);
        httpServletResponse.setContentType("application/json");
        
        try {
            httpServletResponse.getWriter().println(jsonConverter.toJson(pregunta));
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
    
    @RequestMapping(value = {"/pregunta/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        try {
            preguntaDAO.delete(id);
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
    
    @RequestMapping(value = {"/pregunta"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        httpServletResponse.setContentType("application/json");
        
        try {
            Pregunta pregunta = (Pregunta) jsonConverter.fromJson(jsonEntrada, Pregunta.class);
            preguntaDAO.insert(pregunta);
            httpServletResponse.getWriter().println(jsonConverter.toJson(preguntaDAO.get(pregunta.getId())));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = {"/pregunta"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        httpServletResponse.setContentType("application/json");
        try {
            Pregunta pregunta = (Pregunta) jsonConverter.fromJson(jsonEntrada, Pregunta.class);
            preguntaDAO.update(pregunta);
            httpServletResponse.getWriter().println(jsonConverter.toJson(preguntaDAO.get(pregunta.getId())));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = {"/preguntas"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("application/json");
        try {
            List<Pregunta> preguntas = preguntaDAO.findAll();
            System.out.println(preguntaDAO.findAll());
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
    
    @RequestMapping(value = {"/preguntas/bateria"}, method = RequestMethod.GET)
    public void batteryGenerator(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("application/json");
        try {
            List<Pregunta> questionsBattery = preguntaDAO.findAll();
            System.out.println(preguntaDAO.findAll());
            httpServletResponse.getWriter().println(jsonConverter.toJson(questionsBattery));
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
