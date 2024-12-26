package org.koreait.main.entitise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainGame {
    private String header;
    private String leftImageUrl;
    private List<GameCard> gameCards;
}