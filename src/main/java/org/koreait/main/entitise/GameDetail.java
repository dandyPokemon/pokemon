package org.koreait.main.entitise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDetail {
    private String imageUrl;
    private String title;
    private String subtitle;
    private String moreLink;
}