package org.akavity.models.sortTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingData {
    String mainListItem;
    String firstDropListItem;
    String secondDropListItem;
    String sortType;
    int elements;
    double minRating;
}
