package exam.r2dbc.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class MessageId implements Serializable {
    private Long chatId;
    private Long userId;
    private ZonedDateTime createdAt;
}
