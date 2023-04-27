package com.thdat.app.controller;

import com.thdat.app.model.Tutorial;
import com.thdat.app.repository.TutorialRepository;
import com.thdat.app.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TutorialController {

    @Autowired
    private TutorialRepository tutorialRepository;
    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/tutorials")
    public String getAllTutorial(Model model, @Param("keyword") String keyword){

        try{
            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            if(keyword ==  null){
//                tutorialRepository.findAll().forEach(tutorials::add);
                tutorials = tutorialService.getAllTutorial();
            }else{
                tutorialRepository.findByTitleContainingIgnoreCase(keyword).forEach(tutorials::add);
                model.addAttribute("keyword", keyword);
            }

            model.addAttribute("tutorials", tutorials);
        }catch (Exception e){
            model.addAttribute("message", e.getMessage());
        }
        return "tutorials";
    }

    @GetMapping("/tutorials/new")
    public String addTutorial(Model model) {

        Tutorial tutorial = new Tutorial();
        tutorial.setPublished(true);

        model.addAttribute("tutorial", tutorial);
        model.addAttribute("pageTitle", "Create new Tutorial");
        return "tutorial-form";
    }

    @PostMapping("/tutorials/save")
    public String saveTutorial(Tutorial tutorial, RedirectAttributes redirectAttributes) {

        try{
            tutorialService.saveTutorial(tutorial);
            redirectAttributes.addFlashAttribute("massage",
                    "The tutorial has been saved successfully");
        }catch (Exception e){
            redirectAttributes.addAttribute("message", e.getMessage());
        }
        return "redirect:/tutorials";
    }

    @GetMapping("/tutorials/{id}")
    public String editTutorial(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {

        try{
            Tutorial tutorial = tutorialService.findById(id);

            model.addAttribute("tutorial",tutorial);
            model.addAttribute("pageTitle","Edit Tutorial(ID: " + id + ")");

            return "tutorial-form";
        }catch (Exception e){
            redirectAttributes.addAttribute("message", e.getMessage());
        }
        return "redirect:/tutorials";
    }

    @GetMapping("/tutorials/{id}/published/{status}")
    public String updateTutorialPublishedStatus(@PathVariable("id") Long id, @PathVariable("status") boolean published,
                                                Model model, RedirectAttributes redirectAttributes) {

        try{
            tutorialRepository.updatePublishedStatus(id, published);

            String status = published ? "published" : "disabled";
            String message = "The tutorial id=" + id + "has been" + status;

            redirectAttributes.addFlashAttribute("message", message);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/tutorials";
    }

    @GetMapping("/tutorials/delete/{id}")
    public String deleteTutorial(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {

        try{
            tutorialService.deleteTutorial(id);

            redirectAttributes.addFlashAttribute("message",
                    "The Tutorial with id =" + id +"has been deleted successfully!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/tutorials";
    }
}
