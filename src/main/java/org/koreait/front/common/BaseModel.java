package org.koreait.front.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    private String title;
    private String sub_title;
    private String imageUrl;
    private String pageUrl;
}
