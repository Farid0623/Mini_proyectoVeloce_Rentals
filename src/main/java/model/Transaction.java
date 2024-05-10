package model;

import lombok.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Transaction {
    private int TransactionId;
    private int ReservationId;
    private double amount;
    private LocalDate TransactionDate;
    private String PaymentMethod;
}
