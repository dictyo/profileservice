package de.allmaennitta.profileservice.skill;

import de.allmaennitta.profileservice.EntityNotFoundException;
import de.allmaennitta.profileservice.model.Category;
import de.allmaennitta.profileservice.model.Skill;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/skills")
public class SkillController {
  private static final Logger LOG = LoggerFactory.getLogger(SkillController.class);

  @Autowired
  JpaSkillRepository skillRepository;

  @GetMapping(value = "/{name}")
  public Skill byName(@PathVariable("name") String name) {
    return skillRepository.findById(name).orElseThrow(
        ()->new EntityNotFoundException(String.format("Skill '%s' could not be found.",name)));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Skill create(@RequestBody Skill skill) {
//    if (bindingResult.hasErrors()) { throw new InvalidSkillException(bindingResult);}
    return skillRepository.save(skill);
  }

  @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public void delete(@RequestBody Skill skill) {
    skillRepository.delete(skill);
  }
}

//
//    @GetMapping
//    def list(model: Model) = {
//        val hotels = hotelRepository.findAll()
//        model.addAttribute("hotels", hotels)
//        "hotels/list"
//        }
//
//@GetMapping(Array("/edit/{id}"))
//  def edit(@PathVariable("id") id: Long, model: Model) =
//        model.addAttribute("hotel", hotelRepository.findOne(id))
//        "hotels/edit"
//        }
//
//@GetMapping(params = Array("form"))
//  def createForm(model: Model) = {
//          model.addAttribute("hotel", new Hotel())
//          "hotels/create"
//          }
//
//@PostMapping
//  def create(@Valid hotel: Hotel, bindingResult: BindingResult) =
//        if (bindingResult.hasErrors()) {
//        "hotels/create"
//        } else {
//        hotelRepository.save(hotel)
//        "redirect:/hotels"
//        }
//
//
//@PostMapping(value = Array("/update"))
//  def update(@Valid hotel: Hotel, bindingResult: BindingResult) =
//        if (bindingResult.hasErrors()) {
//        "hotels/edit"
//        } else {
//        hotelRepository.save(hotel)
//        "redirect:/hotels"
//        }
//
//
//@GetMapping(value = Array("/delete/{id}"))
//  def delete(@PathVariable("id") id: Long) = {
//        hotelRepository.delete(id)
//        "redirect:/hotels"
//        }
//  @RequestMapping(value = "/")
//  public void handleRootRequest(HttpServletResponse response) {
//    try {
//      response.sendRedirect(root_redirect);
//    } catch (IOException e) {
//      throw new IllegalStateException(
//          String.format("There is an error redirecting to URL %s", root_redirect));
//    }
//  }
