package mapper;

import dto.ReservationDto;
import dto.TransactionsDto;
import dto.UsersDto;
import dto.VehicleDto;
import model.Reservation;
import model.Transaction;
import model.Users;
import model.Vehicle;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class TransactionsMapper {
    public static TransactionsDto mapFrom(Transaction transaction){
        return new TransactionsDto(transaction.getTransactionId(),transaction.getReservationId(),transaction.getAmount(),transaction.getTransactionDate(),transaction.getPaymentMethod());
    }
    public static Transaction mapFromDto(TransactionsDto transaction){
        return Transaction.builder()
                .TransactionId(transaction.TransactionId())
                .ReservationId(transaction.ReservationId())
                .amount(transaction.amount())
                .TransactionDate(transaction.transactionDate())
                .PaymentMethod(transaction.PaymentMethod())
                .build();
    }
}
