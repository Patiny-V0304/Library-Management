use library_management;


desc publisher;

INSERT INTO publisher (name, location, phone, email) VALUES
                                                         ('Sunrise Books', 'Hanoi', '0987654321', 'contact@sunrisebooks.com'),
                                                         ('Oceanic Publishing', 'Ho Chi Minh', '0912345678', 'info@oceanicpub.vn'),
                                                         ('GreenLeaf Press', 'Da Nang', '0978123456', 'support@greenleafpress.com'),
                                                         ('Silverline Media', 'Hai Phong', '0909123456', 'sales@silverlinemedia.vn'),
                                                         ('GoldenGate Publishing', 'Can Tho', '0932123456', 'hello@goldengatepub.com'),
                                                         ('BlueSky Books', 'Hue', '0967123456', 'contact@blueskybooks.vn'),
                                                         ('Maple Tree Press', 'Vung Tau', '0928123456', 'info@mapletreepress.com'),
                                                         ('RiverStone Publishing', 'Nha Trang', '0945123456', 'support@riverstonepub.vn'),
                                                         ('BrightStar Media', 'Da Lat', '0956123456', 'hello@brightstarmedia.com'),
                                                         ('RedBrick Press', 'Hai Duong', '0981123456', 'contact@redbrickpress.vn'),
                                                         ('Evergreen Books', 'Quang Ninh', '0979123456', 'info@evergreenbooks.com'),
                                                         ('Moonlight Publishing', 'Thai Binh', '0908123456', 'support@moonlightpub.vn'),
                                                         ('Starlight Press', 'Bac Ninh', '0917123456', 'hello@starlightpress.com'),
                                                         ('Aurora Media', 'Vinh', '0938123456', 'contact@auroramedia.vn'),
                                                         ('Crystal Books', 'Nam Dinh', '0961123456', 'info@crystalbooks.com'),
                                                         ('Harmony Publishing', 'Thanh Hoa', '0927123456', 'support@harmonypub.vn'),
                                                         ('Sunset Press', 'Phu Tho', '0958123456', 'hello@sunsetpress.com'),
                                                         ('Pinnacle Media', 'Hai Phong', '0973123456', 'contact@pinnaclemedia.vn'),
                                                         ('MapleLeaf Books', 'Hue', '0948123456', 'info@mapleleafbooks.com'),
                                                         ('Skyline Publishing', 'Ho Chi Minh', '0937123456', 'support@skylinepub.vn');


INSERT INTO author (first_name, last_name, gender, year_of_birth, description) VALUES
                                                                                 ('John', 'Smith', true, 1975, 'Author of technical books.'),
                                                                                 ('Mary', 'Johnson', false, 1980, 'Fiction writer and novelist.'),
                                                                                 ('Robert', 'Brown', true, 1968, 'Specializes in history books.'),
                                                                                 ('Linda', 'Davis', false, 1972, 'Poet and short story writer.'),
                                                                                 ('Michael', 'Miller', true, 1985, 'Science fiction author.'),
                                                                                 ('Elizabeth', 'Wilson', false, 1978, 'Writes children books.'),
                                                                                 ('William', 'Moore', true, 1965, 'Expert in philosophy.'),
                                                                                 ('Patricia', 'Taylor', false, 1982, 'Romance novels writer.'),
                                                                                 ('David', 'Anderson', true, 1970, 'Non-fiction and biography.'),
                                                                                 ('Jennifer', 'Thomas', false, 1976, 'Writes educational books.'),
                                                                                 ('James', 'Jackson', true, 1981, 'Thriller and mystery writer.'),
                                                                                 ('Barbara', 'White', false, 1969, 'Travel books and guides.'),
                                                                                 ('Richard', 'Harris', true, 1974, 'Science and technology author.'),
                                                                                 ('Susan', 'Martin', false, 1983, 'Historical fiction novelist.'),
                                                                                 ('Charles', 'Thompson', true, 1967, 'Political analysis and commentary.'),
                                                                                 ('Jessica', 'Garcia', false, 1979, 'Self-help and motivational books.'),
                                                                                 ('Thomas', 'Martinez', true, 1984, 'Fantasy and adventure stories.'),
                                                                                 ('Sarah', 'Robinson', false, 1971, 'Health and wellness author.'),
                                                                                 ('Christopher', 'Clark', true, 1966, 'Art and design books.'),
                                                                                 ('Karen', 'Rodriguez', false, 1986, 'Cookbooks and culinary guides.'),
                                                                                 ('Daniel', 'Lewis', true, 1973, 'Academic and research publications.'),
                                                                                 ('Nancy', 'Lee', false, 1977, 'Children literature specialist.'),
                                                                                 ('Matthew', 'Walker', true, 1982, 'Biographies and memoirs.'),
                                                                                 ('Sandra', 'Hall', false, 1970, 'Social science books.'),
                                                                                 ('Anthony', 'Allen', true, 1969, 'Classic literature writer.'),
                                                                                 ('Laura', 'Young', false, 1985, 'Poetry and creative writing.'),
                                                                                 ('Mark', 'Hernandez', true, 1978, 'Adventure novels author.'),
                                                                                 ('Emily', 'King', false, 1981, 'Romantic fiction specialist.'),
                                                                                 ('Steven', 'Wright', true, 1975, 'Technology and computing books.'),
                                                                                 ('Michelle', 'Lopez', false, 1980, 'Lifestyle and self-improvement.');





select * from shelf;


use library_management;

desc shelf;

select * from shelf;

INSERT INTO shelf (shelf_name, location) VALUES
                                               ('Kệ A3', 'Tầng 1 - Khu A'),
                                               ('Kệ A4', 'Tầng 1 - Khu A'),
                                               ('Kệ A5', 'Tầng 1 - Khu A'),
                                               ('Kệ A6', 'Tầng 1 - Khu A'),
                                               ('Kệ B3', 'Tầng 1 - Khu B'),
                                               ('Kệ B4', 'Tầng 1 - Khu B'),
                                               ('Kệ B5', 'Tầng 1 - Khu B'),
                                               ('Kệ B6', 'Tầng 1 - Khu B'),
                                               ('Kệ C3', 'Tầng 2 - Khu C'),
                                               ('Kệ C4', 'Tầng 2 - Khu C'),
                                               ('Kệ C5', 'Tầng 2 - Khu C'),
                                               ('Kệ C6', 'Tầng 2 - Khu C'),
                                               ('Kệ D3', 'Tầng 2 - Khu D'),
                                               ('Kệ D4', 'Tầng 2 - Khu D'),
                                               ('Kệ D5', 'Tầng 2 - Khu D'),
                                               ('Kệ D6', 'Tầng 2 - Khu D'),
                                               ('Kệ E1', 'Tầng 3 - Khu E'),
                                               ('Kệ E2', 'Tầng 3 - Khu E'),
                                               ('Kệ E3', 'Tầng 3 - Khu E'),
                                               ('Kệ E4', 'Tầng 3 - Khu E');

show tables;

select * from book_author ba join author a on ba.author_id = a.id where ba.book_id in (select id from book);




use library_management;


select id from book;

select * from book_author ba join author on ba.author_id = author.id where book_id in (select id from book);

select * from category_book cb join category on cb.category_id = category.id where book_id in (select id from book);





select * from book
join publisher on book.publisher_id = publisher.id
join shelf on book.shelf_id = shelf.id
where book.delete = ?

desc book;

desc publisher;

desc shelf;


select * from category join category_book on category.id = category_book.category_id where category_book.book_id in (1, 2, 3, 4, 5, 25, 29, 6, 30, 7, 8, 9, 11, 12, 31);

desc category;


select * from author join book_author on author.id = book_author.author_id where book_author.book_id in ();

desc author;

select count(*) from book;




show tables;


desc book;
-- tìm theo id, tiêu đề , nhà xuất bản, kệ,

use library_management;

select * from book
join publisher on book.publisher_id = publisher.id
 join shelf on book.shelf_id = shelf.id
where (id = ? or ? is null) and (title like concat('%',?, '%') or ? is null) and delete = ?
limit ? offset ?;

use library_management;


select * from book;

desc category;


select * from category;



select * from category where (`id` = ? or ? = null) and (`name` = ? or name = null)


select * from category where (`id` = ? or ? is null) and (`name` like concat('%', ?, '%') or ? is null)


desc book;

select * from author where (id = ? or ? is null) and (concat(first_name, ' ', last_name) like concat('%', ?, '%')  or ? is null)



select * from reader;
select * from borrow_card;



select * from account;

delete from account where id = 7;

desc staff;

select  * from staff;

update reader set birth ='2000-11-23'

select *
from borrow_card;


select * from borrow_card
join reader on borrow_card.reader_id = reader.id
join staff on borrow_card.staff_create_id = staff.i;

desc reader;

desc book;

select * from borrow_card
join reader on borrow_card.reader_id = reader.id
join book_borrow_card on borrow_card.id = book_borrow_card.borrow_id
join book on book_borrow_card.book_id = book.id
where borrow_card.state != 'Đã trả' and reader.id = ?;

select * from reader where (id = ? or ? is null) and (concat(first_name,' ', last_name) like concat('%', ?, '%') or ? is null)


select * from staff join account on staff.account_id = account.id
where (staff.id = ? or ? is null)
and (concat(staff.first_name, ' ', staff.last_name) like concat('%' ,? , '%')  or ? is null)
and (account.user_name like concat('%' ,? , '%') or ? is null)

select *
from account;

select * from account join staff on account.id = staff.account_id;
select * from staff;
delete
from account
where id = 1;

select * from borrow_card
join reader on borrow_card.reader_id = reader.id
where (borrow_card.id = ? or ? is null)
and (concat(reader.first_name, ' ', reader.last_name) like concat('%', ?, '%') or  ? is null);

delete from book_borrow_card where borrow_id = ?;




insert into borrow_card (start_date, return_date, reader_id, punishment) value (?,?,?,?);

insert into book_borrow_card (borrow_id, book_id) VALUE (?, ?);


select * from borrow_card join reader on borrow_card.reader_id = reader.id where borrow_card.state = ?;

select * from book where id = 15;

select * from `book` where `title` like concat('%', ?, '%') and `delete` = ? limit ? offset ?;

update staff set birth = '2000/1/1';

select * from role;;
select * from account;

update account set role_id = 2 where  id = 21;

select * from book join publisher on book.publisher_id = publisher.id
join shelf on book.shelf_id = shelf.id
where (book.id = ? or ? is null)
and (book.title like concat('%',?,'%') or ? is null)
and book.`delete` = ?;


-- 11 record
select * from book
                  join publisher on book.publisher_id = publisher.id
                  join shelf on book.shelf_id = shelf.id
where
    (book.title like concat('%','h','%'))
  and book.`delete` = false;

select * from book
                  join publisher on book.publisher_id = publisher.id
                  join shelf on book.shelf_id = shelf.id
where (book.id = NULL or NULL is null)
  and (book.title like concat('%','h','%') or NULL is null)
  and book.`delete` = false
limit 5 offset 1;


update borrow_card set state = 'Quá hạn' where id in (15,17,18,20);

select * from borrow_card;

select * from staff;

select * from account join staff join library_management.role r on account.role_id = r.id
where staff.email = ?;

update borrow_card set state = 'Quá hạn' where return_date < CURDATE();

select *
from category;

SHOW CREATE TABLE category;

CREATE TABLE `category` (
                                                       `id` int NOT NULL AUTO_INCREMENT,
                                                       `name` varchar(50) NOT NULL,
                                                       PRIMARY KEY (`id`),
                                                       UNIQUE KEY `name` (`name`)
                           ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

SHOW CREATE TABLE account;
CREATE TABLE `account` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `user_name` varchar(50) NOT NULL,
                           `password` varchar(60) NOT NULL,
                           `role_id` int NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `user_name` (`user_name`),
                           KEY `fk_account_role` (`role_id`),
                           CONSTRAINT `fk_account_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE staff
    ADD CONSTRAINT unique_phone UNIQUE (phone),
    ADD CONSTRAINT unique_email UNIQUE (email);
SHOW CREATE TABLE staff;
