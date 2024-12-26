package org.koreait.main.entitise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCard {
    private String imageUrl;
    private String description;
    private String link;
}