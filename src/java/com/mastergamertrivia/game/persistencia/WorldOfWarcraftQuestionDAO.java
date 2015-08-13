package com.mastergamertrivia.game.persistencia;

import com.mastergamertrivia.game.dominio.WorldOfWarcraftQuestion;

public interface WorldOfWarcraftQuestionDAO extends GenericDAO<WorldOfWarcraftQuestion>{
    public Long getTotalQuestions();
}
