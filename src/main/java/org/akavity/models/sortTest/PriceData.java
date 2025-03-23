package org.akavity.models.sortTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceData {
    String mainListItem;
    String firstDropListItem;
    String secondDropListItem;
    String button;
    String minPrice;
    String maxPrice;
}
