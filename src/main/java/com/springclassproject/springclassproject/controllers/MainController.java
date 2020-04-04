package com.springclassproject.springclassproject.controllers;
import com.springclassproject.springclassproject.Models.Employees;
import com.springclassproject.springclassproject.Models.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    EmployeesRepo employeesRepo;

    @RequestMapping("/")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("employeelist", employeesRepo.findAll());
        return mv;
    }

    @RequestMapping( value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("view");
        Optional<Employees> person = employeesRepo.findById(id);
        Employees personToMap = person.get();
        mv.addObject("selectedItem", personToMap);
        return mv;
    }

    @RequestMapping( value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("edit");
        Optional<Employees> person = employeesRepo.findById(id);
        Employees personToMap = person.get();
        mv.addObject("selectedItem", personToMap);
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("id") String id, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        ModelAndView mv = new ModelAndView("redirect:/");
        Employees personToSave ;
        if(!id.isEmpty())
        {
            Optional<Employees> users = employeesRepo.findById(id);
            personToSave = users.get();
        }
        else
        {
            personToSave = new Employees();
            personToSave.setId(UUID.randomUUID().toString());
        }
        personToSave.setFirstName(firstName);
        personToSave.setLastName(lastName);
        employeesRepo.save(personToSave);
        mv.addObject("employeelist", employeesRepo.findAll());
        return mv;
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("redirect:/");
        employeesRepo.deleteById(id);
        return mv;
    }
}
