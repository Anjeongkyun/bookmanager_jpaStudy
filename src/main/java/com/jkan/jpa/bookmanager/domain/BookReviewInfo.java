package com.jkan.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    private Long bookId;

    //1:1 연관관계 매핑 어노테이션
    @OneToOne(optional = false) // 반드시 존재하는 값으로 설정
    private Book book;

    private float averageReviewScore;

    private int reviewCount;
}
