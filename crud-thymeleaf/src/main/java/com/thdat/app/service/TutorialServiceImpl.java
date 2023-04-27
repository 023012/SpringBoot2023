package com.thdat.app.service;

import com.thdat.app.model.Tutorial;
import com.thdat.app.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService{

    @Autowired
    private TutorialRepository tutorialRepository;

    @Override
    public List<Tutorial> getAllTutorial() {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorialRepository.findAll().forEach(tutorials::add);
        return tutorials;
    }

    @Override
    public Tutorial findById(Long id) {

        Optional<Tutorial> optional = tutorialRepository.findById(id);
        Tutorial tutorial = null;
        if (optional.isPresent())
            tutorial = optional.get();
        else
            throw new RuntimeException(
                    "Tutorial not found for id:" +id);
        return tutorial;
    }

    @Override
    public void saveTutorial(Tutorial tutorial) {
        tutorialRepository.save(tutorial);
    }

    @Override
    public void deleteTutorial(long id) {
        tutorialRepository.deleteById(id);
    }
}
