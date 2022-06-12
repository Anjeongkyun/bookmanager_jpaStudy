package com.jkan.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

//nonnull or final이 없으면 noArg와 똑같다.
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;


}
