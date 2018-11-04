package com.example.myshop.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    //    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER) // Board엔티티의 필드명.
    @OneToMany(mappedBy = "category")
    private List<Board> boards;

    public List<Board> getBoards(){
        System.out.println("getBoards!!!!!!!!");
        return boards;
    }

    // helper
    /*public void addBoard(Board board){
        if(boards == null)
            boards = new ArrayList<>();
        board
        boards.add(board);
    }*/
}
