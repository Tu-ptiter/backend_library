package com.backend.management.repository;

import com.backend.management.model.Member;
import com.backend.management.model.TransactionHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionHistoryRepo extends MongoRepository<TransactionHistory, String> {
    // Tìm tất cả các giao dịch của một thành viên cụ thể
    List<TransactionHistory> findByMemberId(String memberId);

    // Tìm tất cả các giao dịch theo loại giao dịch (mượn, trả, gia hạn, quá hạn)
    List<TransactionHistory> findByTransactionType(String transactionType);

    // tim cac giao dic
    List<TransactionHistory> findByTransactionTypeAndStatus(String transactionType, String status) ;

    // Tìm tất cả các giao dịch của một cuốn sách cụ thể
    List<TransactionHistory> findByBookId(String bookId);


    List<TransactionHistory> findByMemberIdAndBookIdAndTransactionTypeAndStatus(
            String memberId, String bookId, String transactionType, String status);

    List<TransactionHistory> findByMemberIdAndStatusAndDueDateBefore(String memberId, String status, LocalDateTime dueDate);


    List<TransactionHistory> findByPhoneNumberAndStatusAndDueDateBefore(String phoneNumber, String status, LocalDateTime dueDate);

    List<TransactionHistory> findByStatus(String status);

    List<TransactionHistory> findByMemberIdAndBookIdAndStatus(String memberId, String bookId, String status);

    List<TransactionHistory> findByMemberIdAndStatus(String memberId,  String status);
    long countByTransactionTypeAndStatus(String transactionType, String status);
    long countByTransactionTypeAndTransactionDateBetween(
            String transactionType,
            LocalDateTime startDate,
            LocalDateTime endDate
    );

}
