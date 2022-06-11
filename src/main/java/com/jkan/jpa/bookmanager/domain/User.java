package com.jkan.jpa.bookmanager.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
//nonnull or final이 없으면 noArg와 똑같다.
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    //nonnull이 되어있는 생성자를 만들 수있따.
    @NonNull
    private String name;
    @NonNull
    private String email;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;


}
