package ru.dias.homebudget.persistence.dto;

import lombok.Builder;
import lombok.Data;
import ru.dias.homebudget.persistence.entities.Participant;
import ru.dias.homebudget.persistence.entities.TypeIncome;

import java.util.Date;

@Data
@Builder
public class IncomeDto {

    private TypeIncome typeIncome;
    private Date date;
    private Participant participant;
    private Double amount;

}
