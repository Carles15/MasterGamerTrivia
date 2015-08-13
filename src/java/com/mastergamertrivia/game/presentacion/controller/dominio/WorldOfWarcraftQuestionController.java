package com.mastergamertrivia.game.presentacion.controller.dominio;

import com.mastergamertrivia.game.common.json.JsonConverter;
import com.mastergamertrivia.game.dominio.WorldOfWarcraftQuestion;
import com.mastergamertrivia.game.persistencia.WorldOfWarcraftQuestionDAO;
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
public class WorldOfWarcraftQuestionController {
    
    @Autowired
    JsonConverter jsonConverter;
    
    @Autowired
    WorldOfWarcraftQuestionDAO worldOfWarcraftQuestionDAO;
    
    @RequestMapping(value = {"/question/worldofwarcraft/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        WorldOfWarcraftQuestion worldOfWarcraftQuestion = worldOfWarcraftQuestionDAO.get(id);
        httpServletResponse.setContentType("application/json");
        
        try {
            httpServletResponse.getWriter().println(jsonConverter.toJson(worldOfWarcraftQuestion));
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
    
    @RequestMapping(value = {"/question/worldofwarcraft/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        try {
            worldOfWarcraftQuestionDAO.delete(id);
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
    
    @RequestMapping(value = {"/question/worldofwarcraft"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        httpServletResponse.setContentType("application/json");
        
        try {
            WorldOfWarcraftQuestion worldOfWarcraftQuestion = (WorldOfWarcraftQuestion) jsonConverter.fromJson(jsonEntrada, WorldOfWarcraftQuestion.class);
            worldOfWarcraftQuestionDAO.insert(worldOfWarcraftQuestion);
            httpServletResponse.getWriter().println(jsonConverter.toJson(worldOfWarcraftQuestionDAO.get(worldOfWarcraftQuestion.getId())));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = {"/question/worldofwarcraft"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        httpServletResponse.setContentType("application/json");
        try {
            WorldOfWarcraftQuestion worldOfWarcraftQuestion = (WorldOfWarcraftQuestion) jsonConverter.fromJson(jsonEntrada, WorldOfWarcraftQuestion.class);
            worldOfWarcraftQuestionDAO.update(worldOfWarcraftQuestion);
            httpServletResponse.getWriter().println(jsonConverter.toJson(worldOfWarcraftQuestionDAO.get(worldOfWarcraftQuestion.getId())));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = {"/question/worldofwarcraft/all"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("application/json");
        try {
            List<WorldOfWarcraftQuestion> worldOfWarcraftQuestions = worldOfWarcraftQuestionDAO.findAll();
            httpServletResponse.getWriter().println(jsonConverter.toJson(worldOfWarcraftQuestions));
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
    
    @RequestMapping(value = {"/question/worldofwarcraft/quantity"}, method = RequestMethod.GET)
    public void getQuantity(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("application/json");
        try {
            Long worldOFWarcraftQuestionsQuantity = worldOfWarcraftQuestionDAO.getTotalQuestions();
            httpServletResponse.getWriter().println(jsonConverter.toJson(worldOFWarcraftQuestionsQuantity));
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
