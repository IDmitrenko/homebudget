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

// Версия отбора через Репозиторий
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index(Model model) {
//        model.addAttribute("products", productService.findAll(category, minPrice, maxPrice, notAvailable));
        return "index";
    }

    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/";
        }

//        model.addAttribute("products", productService.findAll(null, null));

        return "admin";
    }

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
    @PostMapping("/purchase")
    public String finishOrderAndPay(String phone, String email, Principal principal, Model model) {

        Shopuser shopuser = shopuserService.findByPhone(principal.getName());

        Purchase purchase = Purchase.builder()
                .shopuser(shopuser)
                .products(cart.getCartRecords()
                        .stream()
                        .map(CartRecord::getProduct)
                        .collect(Collectors.toList())
                )
                .price(cart.getPrice() + cart.getPayment().getFee())
                .phone(phone)
                .email(email)
                .build();

        model.addAttribute("purchase", purchaseService.makePurchase(purchase));

        Mail mail = new Mail();
        mail.setMailFrom("Интернет-магазин Super Shop");
        mail.setMailTo(shopuser.getEmail());
        mail.setMailSubject("antonshu.pro - password recovery");
        String token = UUID.randomUUID().toString();
        String url = "/user/changePassword?id=" +
                shopuser.getId() + "&token=" + token;
        StringBuilder mailBody = new StringBuilder();
        mailBody.append("Learn How to reset password using Spring Boot!!!\n\n")
                .append("For reset you pass go to: https://antonshu.pro:8023/app")
                .append(url);
        mail.setMailContent(mailBody.toString());
        mailService.sendEmail(mail);

        return "orderdone";

    }
*/


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