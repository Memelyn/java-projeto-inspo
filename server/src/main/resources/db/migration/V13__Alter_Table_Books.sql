ALTER TABLE `books`
ADD COLUMN `user_id` BIGINT(20),
ADD CONSTRAINT `fk_books_user`
FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
