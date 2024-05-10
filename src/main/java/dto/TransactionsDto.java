package dto;

import lombok.Builder;

import java.text.DecimalFormat;
import java.time.LocalDate;

@Builder
public record TransactionsDto(int TransactionId, int ReservationId, double amount, LocalDate transactionDate, String PaymentMethod) {
}
