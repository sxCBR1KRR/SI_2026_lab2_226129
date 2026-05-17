# SI_2026_lab2_226129
# Втора лабораториска вежба по Софтверско инженерство

Милош Пајкоски
226129

Control Flow Graph

searchBookByTitle
<img width="497" height="664" alt="image" src="https://github.com/user-attachments/assets/8480d5d0-1142-49fa-ac2d-70c32c2041b2" />

borrowBook
<img width="485" height="711" alt="image" src="https://github.com/user-attachments/assets/7cd7a95a-b083-43d0-825a-c04d175c4524" />

Цикломатска комплексност

Цикломатската комплексност за searchBookByTitle е 4, истата ја добив преку формулата P+1P+1, каде што PP е бројот на предикатни јазли. Во овој случај P=3P=3, па цикломатската комплексност изнесува 4.

Цикломатската комплексност за borrowBook е 5, истата ја добив преку формулата P+1P+1, каде што PP е бројот на предикатни јазли. Во овој случај P=4P=4, па цикломатската комплексност изнесува 5.

Тест случаи според критериумот Every statement
Test case	searchBookByTitle	borrowBook
test 1	*	*
test 2	*	
test 3		*
Минимален број на тест случаи за оваа функција според Every statement критериумот е 3.

Тест случаи според критериумот Every branch
Branch	searchBookByTitle	borrowBook
branch 1	*	*
branch 2	*	*
branch 3	*	*
branch 4		*
Минимален број на тест случаи за оваа функција според Every branch критериумот е 4.

Тест случаи според критериумот Multiple condition
searchBookByTitle
Оваа функција има еден compound услов:

if (title.isEmpty())

borrowBook
Оваа функција има compound услов:

if (title.isEmpty() || author.isEmpty())

Condition	TT	TF	FT	FF
test за title.isEmpty() || author.isEmpty()	*	*	*	*
Минимален број на тест случаи за оваа функција според Multiple condition критериумот е 4.
