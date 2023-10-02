package work_space.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import work_space.model.Person;
import work_space.service.PersonService;


@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("person", personService.findAll());
        return "person/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Person person = personService.findOne(id);
        model.addAttribute("person", person);
        model.addAttribute("magazines", personService.getMagazinesByPersonId(id));
        return "person/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "person/new";
    }

    @PostMapping()
    public String create(@Validated @ModelAttribute("person") Person person) {
        personService.save(person);
        return "redirect:/person";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("person", personService.findOne(id));
        return "person/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Validated Person person, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "person/edit";

        personService.update(id, person);
        return "redirect:/person";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        personService.deleted(id);
        return "redirect:/person";
    }
}
