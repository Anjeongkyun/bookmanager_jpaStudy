package com.jkan.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//nonnull or final이 없으면 noArg와 똑같다.
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@EntityListeners(value = {MyEntityListener.class, UserEntityListener.class})
public class Users implements Auditable{

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;

}
