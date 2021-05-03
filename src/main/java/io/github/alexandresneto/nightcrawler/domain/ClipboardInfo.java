package io.github.alexandresneto.nightcrawler.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClipboardInfo {

    private String username;

    private String hostname;

    private String content;

}
