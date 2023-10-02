package work_space.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import work_space.model.Magazine;
import work_space.model.Person;
import work_space.service.MagazineService;
import work_space.service.PersonService;

import java.util.Optional;

@Controller
@RequestMapping("/magazine")
public class MagazineController {
    private final MagazineService magazineService;
    private final PersonService personService;

    public MagazineController(MagazineService magazineService, PersonService personService) {
        this.magazineService = magazineService;
        this.personService = personService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("magazines", magazineService.findAll());
        return "magazine/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("magazine", magazineService.findOne(id));

        Optional<Person> magazineOwner = personService.getPersonByFullName(person.getFull_name());

        if (magazineOwner.isPresent())
            model.addAttribute("owner", magazineOwner.get());
        else
            model.addAttribute("people", personService.findAll());

        return "magazine/show";
    }

    @GetMapping("/new")
    public String newMagazine(@ModelAttribute("magazine") Magazine magazine) {
        return "magazine/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("magazine")  Magazine magazine,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "magazine/new";

        magazineService.save(magazine);
        return "redirect:/magazine";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("magazine", magazineService.findOne(id));
        return "magazine/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("magazine")  Magazine magazine, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "magazine/edit";

        magazineService.update(id, magazine);
        return "redirect:/magazine";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        magazineService.delete(id);
        return "redirect:/magazine";
    }
}