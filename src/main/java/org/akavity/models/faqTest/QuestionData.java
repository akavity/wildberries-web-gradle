package org.akavity.models.faqTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionData {
    String menuItem;
    String searchField;
    String title;
}
