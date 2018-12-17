package de.allmaennitta.profileservice.domain;

import de.allmaennitta.profileservice.model.Category;
import de.allmaennitta.profileservice.model.Domain;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomainController {
  private static final Logger LOG = LoggerFactory.getLogger(DomainController.class);

  @Autowired
  DomainRepository domainRepository;

  @Value("${app.version}")
  private String version;

//  String root_redirect = "/profiles";

  @RequestMapping(value = "/version", method = RequestMethod.GET)
  public Map<String, String> getAppVersion() {
    return Collections.singletonMap("version", version);
  }


  @RequestMapping(value = "/domains/{id}", method = RequestMethod.GET)
  public List<Category> byName(@PathVariable("id") String id) {
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
//  @RequestMapping(value = "/")
//  public void handleRootRequest(HttpServletResponse response) {
//    try {
//      response.sendRedirect(root_redirect);
//    } catch (IOException e) {
//      throw new IllegalStateException(
//          String.format("There is an error redirecting to URL %s", root_redirect));
//    }
//  }
