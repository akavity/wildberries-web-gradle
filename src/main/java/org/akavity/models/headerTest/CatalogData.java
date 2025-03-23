package org.akavity.models.headerTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogData {
    String mainListItem;
    String firstDropListItem;
    String secondDropListItem;
    String title;
}
