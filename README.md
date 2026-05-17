# SI_2026_lab2_226129
# Втора лабораториска вежба по Софтверско инженерство

Милош Пајкоски
226129

## Control Flow Graph

### searchBookByTitle
<img width="497" height="664" alt="image" src="https://github.com/user-attachments/assets/8480d5d0-1142-49fa-ac2d-70c32c2041b2" />

### borrowBook
<img width="485" height="711" alt="image" src="https://github.com/user-attachments/assets/7cd7a95a-b083-43d0-825a-c04d175c4524" />

## Цикломатска комплексност

Цикломатската комплексност за `searchBookByTitle` е 4, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во овој случај P=3, па цикломатската комплексност изнесува 4.

Цикломатската комплексност за `borrowBook` е 5, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во овој случај P=4, па цикломатската комплексност изнесува 5.

## Тест случаи според критериумот Every statement

| Test case | searchBookByTitle (Lines) | borrowBook (Lines) |
| --- | --- | --- |
| test 1 | 58-63, 67 | 74-78, 82 |
| test 2 | 64-66 |  |
| test 3 | 55-57 | 71-73 |

Минимален број на тест случаи за оваа функција според Every statement критериумот е 3.

## Тест случаи според критериумот Every branch

| Test case | searchBookByTitle (Branches) | borrowBook (Branches) |
| --- | --- | --- |
| test 1 | Title Match=T, Borrowed=F | Valid, Found, Not Borrowed |
| test 2 | Title Match=F or Borrowed=T | Valid, Not Found |
| test 3 | Results Not Empty=F | Valid, Found, Borrowed |
| test 4 |  | Invalid Query (Empty title/author) |

Минимален број на тест случаи за оваа функција според Every branch критериумот е 4.

## Тест случаи според критериумот Multiple condition

### borrowBook: `title.isEmpty() || author.isEmpty()`
| Condition | TT | TF | FT | FF |
| --- | --- | --- | --- | --- |
| `title.isEmpty() || author.isEmpty()` | * | * | * | * |

Минимален број на тест случаи за оваа функција според Multiple condition критериумот е 4.

### searchBookByTitle: `book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()`
| Condition | TT | TF | FT | FF |
| --- | --- | --- | --- | --- |
| `title match && !borrowed` | * | * | * | * |

Минимален број на тест случаи за оваа функција според Multiple condition критериумот е 4.
