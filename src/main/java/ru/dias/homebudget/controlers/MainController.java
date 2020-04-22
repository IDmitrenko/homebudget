package ru.dias.homebudget.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dias.homebudget.persistence.entities.Participant;
import ru.dias.homebudget.services.ParticipantService;
import ru.dias.homebudget.services.RemainsService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ParticipantService participantService;
    private final RemainsService remainsService;

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index(Model model) {
        model.addAttribute("listremains", remainsService.findAll());
        return "index";
    }

/*
    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/";
        }

        model.addAttribute("listremains", remainsService.findAll());

        return "admin";
    }
*/

    @GetMapping("/profile")
    public String profilePage(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/";
        }

        Participant participant = participantService.findByLogin(principal.getName());

//        model.addAttribute("reviews", reviewService.getReviewsByShopuser(shopuser).orElse(new ArrayList<>()));
        model.addAttribute("participant", participant);

        return "profile";
    }

/*
    @GetMapping(value = "/rev/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Review>> getReviews(@PathVariable String phone ) {
        return new ResponseEntity<>(reviewService.getReviews(phone, null), HttpStatus.OK);
    }

    @GetMapping(value = "/reviewp/{phone}/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Review>> getReviewsProduct(@PathVariable String phone,
                                                          @PathVariable String title) {
        return new ResponseEntity<>(reviewService.getReviewsProduct(phone, title), HttpStatus.OK);
    }
*/
}