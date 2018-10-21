package examples.boot.myshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String content;
    private int readCount;
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "category_id") //실제 FK의 컬럼명이 된다.
    private Category category; // 이 보드가 어떤 카테고리에 속해 있는지를 식별해주는 FK

}
