package com.example.Online.Banking.System.account;

import com.example.Online.Banking.System.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Account {
    @Id
    @SequenceGenerator(
            name = "acc_sequence",
            sequenceName = "acc_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "acc_sequence"
    )

    private Long id;

    private Long accountNumber;
    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
