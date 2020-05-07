package ru.dias.homebudget.controlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dias.homebudget.action.ActionContext;
import ru.dias.homebudget.action.BudgetActionFactory;
import ru.dias.homebudget.persistence.dto.IncomeDto;
import ru.dias.homebudget.services.IncomeService;
import ru.dias.homebudget.services.ParticipantService;
import ru.dias.homebudget.services.TypeIncomeService;

import java.security.Principal;
import java.util.Date;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/income")
public class IncomeController {

    private final BudgetActionFactory actionFactory;
    private final IncomeService incomeService;
    private final ParticipantService participantService;
    private final TypeIncomeService typeIncomeService;
    private final String oType = "Заработная плата";

    @GetMapping(value = "/add")
    public String showAddIncome(Model model, Principal principal) {
        IncomeDto incomeDto = new IncomeDto();
        incomeDto.setDate(new Date());
        incomeDto.setParticipant(participantService.findByLogin(principal.getName()));
        incomeDto.setTypeIncome(typeIncomeService.findOneByName(oType));
        model.addAttribute("income", incomeDto);
        return "add-income";
    }

    @PostMapping(value = "/add")
    public String addIncome(IncomeDto incomeDto,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "income";
        }
        String message = actionFactory.createAction(BudgetActionFactory.BudgetActionType.INCOME)
                .action(new ActionContext()
                        .builder()
                        .date(incomeDto.getDate())
                        .amount(incomeDto.getAmount())
                        .participant(incomeDto.getParticipant().getLogin())
                        .type(incomeDto.getTypeIncome().getName())
                        .build()
                );

        log.info(message);
        return "redirect:/income";
    }

    @GetMapping
    public String showIncome(Model model) {
        model.addAttribute("listincome", incomeService.findAll());
        return "income";
    }

}

