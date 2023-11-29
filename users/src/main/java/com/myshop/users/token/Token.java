package com.myshop.users.token;

import com.myshop.users.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Token {
    @Id
    @SequenceGenerator(
            name =  "token_id_sequence",
            sequenceName = "token_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_id_sequence"
    )
    private Integer id;
    private  String token ;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType ;
    private boolean expired ;
    private boolean revoked ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;



}
