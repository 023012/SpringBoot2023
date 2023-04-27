package com.thdat.app.service;


import com.thdat.app.model.Tutorial;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TutorialService {

    //    List Tutorial
    List<Tutorial> getAllTutorial();

    //    get tutorial by id
    Tutorial findById(Long id);

    //    Save Tutorial
    void saveTutorial(Tutorial tutorial);

    //    Update Tutorial


    //    Delete course
    void deleteTutorial(long id);

    //    search course by name
}
