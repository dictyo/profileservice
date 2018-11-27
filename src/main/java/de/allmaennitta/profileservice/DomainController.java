package de.allmaennitta.profileservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import de.allmaennitta.model.generated.Domain;
import de.allmaennitta.model.generated.ProfileSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
class DomainController {
  private static final Logger LOG = LoggerFactory.getLogger(DomainController.class);

  @Value("${app.version}")
  String version;

  DomainRepository domainRepository;
  String root_redirect = "/profiles";

  public DomainController(DomainRepository domainRepository) {
    this.domainRepository = domainRepository;
  }

//  @RequestMapping(value = "/")
//  public void handleRootRequest(HttpServletResponse response) {
//    try {
//      response.sendRedirect(root_redirect);
//    } catch (IOException e) {
//      throw new IllegalStateException(
//          String.format("There is an error redirecting to URL %s", root_redirect));
//    }
//  }

  @RequestMapping(value = "/domains/{id}", method = RequestMethod.GET)
  @ResponseBody
  Domain byName(@PathVariable("id") String id) {
    return domainRepository.findById(id);
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
