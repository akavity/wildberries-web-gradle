package org.akavity.models.faqTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaqData {
    String serviceMenuItem;
    String faqMenuItem;
    String title;
    String content;
}
