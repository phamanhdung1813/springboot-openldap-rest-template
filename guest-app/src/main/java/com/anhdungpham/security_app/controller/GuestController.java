package com.anhdungpham.security_app.controller;

import com.anhdungpham.security_app.domain.Guest;
import com.anhdungpham.security_app.domain.GuestModel;
import com.anhdungpham.security_app.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping(value={"/", "/index"})
    public String getHomePage(Model model){
        return "index";
    }

    @GetMapping(value="/guests")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getGuests(Model model){
        List<Guest> guests = this.guestService.getAllGuests();
        model.addAttribute("guests", guests);
        return "guests-view";
    }

    @GetMapping(value="/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping(value="/logout-success")
    public String logout(Model model) {
        return "logout";
    }

    @GetMapping(value="/guests/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddGuestForm(Model model){
        return "guest-view";
    }

    @PostMapping(value="/guests")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView addGuest(HttpServletRequest request, Model model, @ModelAttribute GuestModel guestModel){
        Guest guest = this.guestService.addGuest(guestModel);
        model.addAttribute("guest", guest);
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView("redirect:/guests/" + guest.getId());
    }

    @GetMapping(value="/guests/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getGuest(Model model, @PathVariable long id){
        Guest guest = this.guestService.getGuest(id);
        model.addAttribute("guest", guest);
        return "guest-view";
    }

    @PostMapping(value="/guests/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateGuest(Model model, @PathVariable long id, @ModelAttribute GuestModel guestModel){
        Guest guest = this.guestService.updateGuest(id, guestModel);
        model.addAttribute("guest", guest);
        model.addAttribute("guestModel", new GuestModel());
        return "guest-view";
    }
}
