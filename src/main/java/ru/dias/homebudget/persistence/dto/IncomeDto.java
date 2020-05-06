package ru.dias.homebudget.persistence.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.dias.homebudget.persistence.entities.Participant;
import ru.dias.homebudget.persistence.entities.TypeIncome;

import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IncomeDto {

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;

    private Double amount;
    private Participant participant;
    private TypeIncome typeIncome;

}
