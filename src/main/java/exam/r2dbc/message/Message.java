package exam.r2dbc.message;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class Message {
    private final Long chatId;
    private final Long userId;
    private final String text;
    private final ZonedDateTime createdAt;
}
