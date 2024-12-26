package org.koreait.main.entitise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewCard {
    private String imageUrl;
    private String title;
    private String category;
    private String dateText;
    private String buttonText;
    private String pageUrl;
}