package ru.dias.homebudget.controlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dias.homebudget.action.ActionContext;
import ru.dias.homebudget.action.BudgetActionFactory;
import ru.dias.homebudget.persistence.dto.IncomeDto;
import ru.dias.homebudget.persistence.entities.Income;
import ru.dias.homebudget.services.IncomeService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Date;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(name = "/income")
public class IncomeController {

    private final BudgetActionFactory actionFactory;
    private final IncomeService incomeService;

    @PostMapping(value = "/add")
    public String addIncome(IncomeDto incomeDto, HttpSession session) {
        String message = actionFactory.createAction(BudgetActionFactory.BudgetActionType.INCOME)
                .action(new ActionContext()
                        .builder()
                        .date(incomeDto.getDate())
                        .amount(incomeDto.getAmount())
                        .participant(incomeDto.getParticipant())
                        .type(incomeDto.getTypeIncome().getName())
                        .build()
                );
        log.info(message);

        return "income";
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String showIncome(Model model) {
        model.addAttribute("listincome", incomeService.findAll());
        return "income";
    }

}
