CREATE TABLE `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '아이디',
    `email` varchar(100) DEFAULT NULL COMMENT '이메일',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `chat` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '아이디',
    `name` varchar(100) DEFAULT NULL COMMENT '채팅 이름',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `chat_user` (
    `chat_id` int(11) NOT NULL COMMENT '채팅 아이디',
    `user_id` int(11) NOT NULL COMMENT '사용자 아이디',
    UNIQUE KEY `uk_access_token_id` (`chat_id`, `user_id`),
    KEY `fk_chat_user_chat_id` (`chat_id`),
    KEY `fk_chat_user_user_id` (`user_id`),
    CONSTRAINT `fk_chat_user_chat_id` FOREIGN KEY (`chat_id`) REFERENCES `chat` (`id`),
    CONSTRAINT `fk_chat_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `message` (
   `chat_id` int(11) NOT NULL COMMENT '채팅 아이디',
   `user_id` int(11) NOT NULL COMMENT '사용자 아이디',
   `text` text NOT NULL COMMENT '메세지 내용',
   `created_at` timestamp NOT NULL COMMENT '생성일시',
   KEY `fk_message_chat_id` (`chat_id`),
   KEY `fk_message_user_id` (`user_id`),
   CONSTRAINT `fk_message_chat_id` FOREIGN KEY (`chat_id`) REFERENCES `chat` (`id`),
   CONSTRAINT `fk_message_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
