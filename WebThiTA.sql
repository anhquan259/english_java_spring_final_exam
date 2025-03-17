REM INSERTING into HR.ACCOUNTS
SET DEFINE OFF;
Insert into HR.ACCOUNTS (FULLNAME, DIEMTB, PASSWORD, ROLE, USERNAME)
values ('B�i Ho�i Nam', 3.3333333333333335, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 1, 'hoainam@gmail.com');
Insert into HR.ACCOUNTS (FULLNAME, DIEMTB, PASSWORD, ROLE, USERNAME)
values ('Dang Minh Dat', 7.083333333333333, '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 1, 'dat@gmail.com');
Insert into HR.ACCOUNTS (FULLNAME, DIEMTB, PASSWORD, ROLE, USERNAME)
values ('Nguyen Thi A', 2.5, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 1, 'a@gmail.com');
Insert into HR.ACCOUNTS (FULLNAME, DIEMTB, PASSWORD, ROLE, USERNAME)
values ('Nguyen Thi Nhay Cau', 8.0, '7110eda4d09e062aa5e4a390b0a572ac0d2c0221', 1, 'nhaycau@gmail.com');
Insert into HR.ACCOUNTS (FULLNAME, DIEMTB, PASSWORD, ROLE, USERNAME)
values ('Tran Thi Tron No', 9.0, '7110eda4d09e062aa5e4a390b0a572ac0d2c0222', 1, 'tronno@gmail.com');
Insert into HR.ACCOUNTS (FULLNAME, DIEMTB, PASSWORD, ROLE, USERNAME)
values ('Tran Thi Tron No', 9.5, '7110eda4d09e062aa5e4a390b0a572ac0d2c0222', 1, 'tronno@gmail.com');
REM INSERTING into HR.BAI_HOC
SET DEFINE OFF;
Insert into HR.BAI_HOC (CONTENT1, CONTENT2, CONTENT3, CONTENT4, TITLE, TITLE1, TITLE2, TITLE3, TITLE4, VIDEO)
values ('Some adjectives go with certain prepositions. There are no grammatical rules for which preposition is used with which adjective, so it''s a good idea to try to learn them together. To help you do this, write new vocabulary in your notebook in a sentence or phrase.

However, there are some patterns that can help you. Let''s look at them first. Remember that a preposition is followed by a noun or a gerund (-ing form).', 'We use at with adjectives like good/bad/amazing/brilliant/terrible, etc. to talk about skills and abilities.

He''s really good at English.
She''s amazing at the piano.
They''re terrible at organising anything.
I''m not very good at drawing.', 'We often use about with adjectives of feelings like angry/excited/happy/nervous/sad/stressed/worried, etc. to explain what is causing that feeling.

I''m angry about the decision.
He''s nervous about the presentation.
She''s excited about the new job.
They were worried about the exam.', 'However, sometimes we use of with feelings.

She was afraid of telling her mum.
I''m frightened of having an accident.
He''s scared of flying.
You should be proud of your progress.', 'Adjectives and prepositions', 'Grammar explanation', 'With at', 'With about',
        'With of', 'http://www.youtube.com/embed/X5n2-fA0RI0');
Insert into HR.BAI_HOC (CONTENT1, CONTENT2, CONTENT3, CONTENT4, TITLE, TITLE1, TITLE2, TITLE3, TITLE4, VIDEO)
values ('Adjectives that end in -ed (e.g. bored, interested) and adjectives that end in -ing (e.g. boring, interesting) are often confused.', 'Adjectives that end in -ed generally describe emotions � they tell us how people feel.

I was so bored in that lesson, I almost fell asleep.
He was surprised to see Helen after all those years.
She was really tired and went to bed early.', 'Adjectives that end in -ing generally describe the thing that causes the emotion � a boring lesson makes you feel bored.

Have you seen that film? It''s really frightening.
I could listen to her for hours. She''s so interesting.
I can''t sleep! That noise is really annoying!', null, 'Adjectives ending in ''-ed'' and ''-ing''',
        'Grammar explanation', '-ed adjectives', '-ing adjectives', null, 'http://www.youtube.com/embed/wqxIXkax9-c');
REM INSERTING into HR.BAI_THI
SET DEFINE OFF;
Insert into HR.BAI_THI (EXAM_NAME, CONTENT)
values ('Question Response - skill test 1', 'Due to rapid growth, Plainview Distributors is seeking applications for a Supply Chain Manager. This is a career advancement opportunity open to current employees only. The Supply Chain Manager will oversee all aspects of warehouse storage and transportation for product deliveries in the southwestern United States. The Supply Chain Manager will be required to work out of the Phoenix office, and frequent movement within the region to check on branch operations (approximately ten trips per year) will be expected.

The successful candidate will be an experienced professional, familiar with the company and its clients, who can manage a complex network and succeed under pressure. Preferred qualifications include experience in one of our warehouses or truck depots, familiarity with the Southwest, and experience in personnel management');
Insert into HR.BAI_THI (EXAM_NAME, CONTENT)
values ('Question Response - skill test 2', 'Due to rapid growth, Plainview Distributors is seeking applications for a Supply Chain Manager. This is a career advancement opportunity open to current employees only. The Supply Chain Manager will oversee all aspects of warehouse storage and transportation for product deliveries in the southwestern United States. The Supply Chain Manager will be required to work out of the Phoenix office, and frequent movement within the region to check on branch operations (approximately ten trips per year) will be expected.

The successful candidate will be an experienced professional, familiar with the company and its clients, who can manage a complex network and succeed under pressure. Preferred qualifications include experience in one of our warehouses or truck depots, familiarity with the Southwest, and experience in personnel management');
Insert into HR.BAI_THI (EXAM_NAME, CONTENT)
values ('Question Response - skill test 3', 'Due to rapid growth, Plainview Distributors is seeking applications for a Supply Chain Manager. This is a career advancement opportunity open to current employees only. The Supply Chain Manager will oversee all aspects of warehouse storage and transportation for product deliveries in the southwestern United States. The Supply Chain Manager will be required to work out of the Phoenix office, and frequent movement within the region to check on branch operations (approximately ten trips per year) will be expected.

The successful candidate will be an experienced professional, familiar with the company and its clients, who can manage a complex network and succeed under pressure. Preferred qualifications include experience in one of our warehouses or truck depots, familiarity with the Southwest, and experience in personnel management');
Insert into HR.BAI_THI (EXAM_NAME, CONTENT)
values ('Question Response - skill test 4', 'Due to rapid growth, Plainview Distributors is seeking applications for a Supply Chain Manager. This is a career advancement opportunity open to current employees only. The Supply Chain Manager will oversee all aspects of warehouse storage and transportation for product deliveries in the southwestern United States. The Supply Chain Manager will be required to work out of the Phoenix office, and frequent movement within the region to check on branch operations (approximately ten trips per year) will be expected.

The successful candidate will be an experienced professional, familiar with the company and its clients, who can manage a complex network and succeed under pressure. Preferred qualifications include experience in one of our warehouses or truck depots, familiarity with the Southwest, and experience in personnel management');
REM INSERTING into HR.CAU_HOI
SET DEFINE OFF;
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('Submit an application via Internet', 'Fax a resume and list of references',
        'Call to request a personal interview', 'Submit an application via Internet',
        'Put an application package in the mail', 'What should interested people do?', 1);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('The monthly pay rate for the job', 'The monthly pay rate for the job', 'The number of employees supervised',
        'The amount of business travel required', 'The type of products being distributed.',
        'Which of the following topics is mentioned in the announcement?', 1);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('A call for applications for new product suppliers', 'A career opportunity for staff members of the company',
        'A call for applications for new product suppliers', 'A job competition open to external candidates only',
        'A change in company benefits affecting some workers', 'What is the announcement about?', 1);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('7:06 pm', '6:06 pm', '6:51 pm', '7:51 pm.', '7:06 pm', 'When does the last northbound run pass Lark Road?', 1);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('Submit an application via Internet', 'Fax a resume and list of references',
        'Call to request a personal interview', 'Submit an application via Internet',
        'Put an application package in the mail', 'What should interested people do?', 1);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('The monthly pay rate for the job', 'The monthly pay rate for the job', 'The number of employees supervised',
        'The amount of business travel required', 'The type of products being distributed.',
        'Which of the following topics is mentioned in the announcement?', 1);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('A call for applications for new product suppliers', 'A career opportunity for staff members of the company',
        'A call for applications for new product suppliers', 'A job competition open to external candidates only',
        'A change in company benefits affecting some workers', 'What is the announcement about?', 1);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('7:06 pm', '6:06 pm', '6:51 pm', '7:51 pm.', '7:06 pm', 'When does the last northbound run pass Lark Road?', 1);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('Submit an application via Internet', 'Fax a resume and list of references',
        'Call to request a personal interview', 'Submit an application via Internet',
        'Put an application package in the mail', 'What should interested people do?', 2);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('The monthly pay rate for the job', 'The monthly pay rate for the job', 'The number of employees supervised',
        'The amount of business travel required', 'The type of products being distributed.',
        'Which of the following topics is mentioned in the announcement?', 2);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('A call for applications for new product suppliers', 'A career opportunity for staff members of the company',
        'A call for applications for new product suppliers', 'A job competition open to external candidates only',
        'A change in company benefits affecting some workers', 'What is the announcement about?', 2);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('7:06 pm', '6:06 pm', '6:51 pm', '7:51 pm.', '7:06 pm', 'When does the last northbound run pass Lark Road?', 2);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('Submit an application via Internet', 'Fax a resume and list of references',
        'Call to request a personal interview', 'Submit an application via Internet',
        'Put an application package in the mail', 'What should interested people do?', 2);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('The monthly pay rate for the job', 'The monthly pay rate for the job', 'The number of employees supervised',
        'The amount of business travel required', 'The type of products being distributed.',
        'Which of the following topics is mentioned in the announcement?', 2);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('A call for applications for new product suppliers', 'A career opportunity for staff members of the company',
        'A call for applications for new product suppliers', 'A job competition open to external candidates only',
        'A change in company benefits affecting some workers', 'What is the announcement about?', 2);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('7:06 pm', '6:06 pm', '6:51 pm', '7:51 pm.', '7:06 pm', 'When does the last northbound run pass Lark Road?', 2);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('Submit an application via Internet', 'Fax a resume and list of references',
        'Call to request a personal interview', 'Submit an application via Internet',
        'Put an application package in the mail', 'What should interested people do?', 3);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('The monthly pay rate for the job', 'The monthly pay rate for the job', 'The number of employees supervised',
        'The amount of business travel required', 'The type of products being distributed.',
        'Which of the following topics is mentioned in the announcement?', 3);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('A call for applications for new product suppliers', 'A career opportunity for staff members of the company',
        'A call for applications for new product suppliers', 'A job competition open to external candidates only',
        'A change in company benefits affecting some workers', 'What is the announcement about?', 3);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('7:06 pm', '6:06 pm', '6:51 pm', '7:51 pm.', '7:06 pm', 'When does the last northbound run pass Lark Road?', 3);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('Submit an application via Internet', 'Fax a resume and list of references',
        'Call to request a personal interview', 'Submit an application via Internet',
        'Put an application package in the mail', 'What should interested people do?', 3);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('The monthly pay rate for the job', 'The monthly pay rate for the job', 'The number of employees supervised',
        'The amount of business travel required', 'The type of products being distributed.',
        'Which of the following topics is mentioned in the announcement?', 3);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('A call for applications for new product suppliers', 'A career opportunity for staff members of the company',
        'A call for applications for new product suppliers', 'A job competition open to external candidates only',
        'A change in company benefits affecting some workers', 'What is the announcement about?', 3);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('7:06 pm', '6:06 pm', '6:51 pm', '7:51 pm.', '7:06 pm', 'When does the last northbound run pass Lark Road?', 3);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('Submit an application via Internet', 'Fax a resume and list of references',
        'Call to request a personal interview', 'Submit an application via Internet',
        'Put an application package in the mail', 'What should interested people do?', 4);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('The monthly pay rate for the job', 'The monthly pay rate for the job', 'The number of employees supervised',
        'The amount of business travel required', 'The type of products being distributed.',
        'Which of the following topics is mentioned in the announcement?', 4);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('A call for applications for new product suppliers', 'A career opportunity for staff members of the company',
        'A call for applications for new product suppliers', 'A job competition open to external candidates only',
        'A change in company benefits affecting some workers', 'What is the announcement about?', 4);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('7:06 pm', '6:06 pm', '6:51 pm', '7:51 pm.', '7:06 pm', 'When does the last northbound run pass Lark Road?', 4);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('Submit an application via Internet', 'Fax a resume and list of references',
        'Call to request a personal interview', 'Submit an application via Internet',
        'Put an application package in the mail', 'What should interested people do?', 4);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('The monthly pay rate for the job', 'The monthly pay rate for the job', 'The number of employees supervised',
        'The amount of business travel required', 'The type of products being distributed.',
        'Which of the following topics is mentioned in the announcement?', 4);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('A call for applications for new product suppliers', 'A career opportunity for staff members of the company',
        'A call for applications for new product suppliers', 'A job competition open to external candidates only',
        'A change in company benefits affecting some workers', 'What is the announcement about?', 4);
Insert into HR.CAU_HOI (CORRECTANSWER, OPTION1, OPTION2, OPTION3, OPTION4, QUESTION, EXAM_ID)
values ('7:06 pm', '6:06 pm', '6:51 pm', '7:51 pm.', '7:06 pm', 'When does the last northbound run pass Lark Road?', 4);
REM INSERTING into HR.DIEM
SET DEFINE OFF;
Insert into HR.DIEM (POINT, TEST_DAY, USER_ID, EXAM_ID)
values (2.5, 'Fri Oct 21 17:01:43 ICT 2022', 1, 1);
Insert into HR.DIEM (POINT, TEST_DAY, USER_ID, EXAM_ID)
values (1.25, 'Fri Oct 21 17:10:15 ICT 2022', 1, 2);
Insert into HR.DIEM (POINT, TEST_DAY, USER_ID, EXAM_ID)
values (6.25, 'Fri Oct 21 17:11:01 ICT 2022', 1, 3);
Insert into HR.DIEM (POINT, TEST_DAY, USER_ID, EXAM_ID)
values (7.5, 'Fri Oct 21 17:14:34 ICT 2022', 2, 1);
Insert into HR.DIEM (POINT, TEST_DAY, USER_ID, EXAM_ID)
values (6.25, 'Fri Oct 21 17:15:04 ICT 2022', 2, 2);
Insert into HR.DIEM (POINT, TEST_DAY, USER_ID, EXAM_ID)
values (7.5, 'Fri Oct 21 17:21:01 ICT 2022', 2, 3);
Insert into HR.DIEM (POINT, TEST_DAY, USER_ID, EXAM_ID)
values (2.5, 'Fri Oct 21 17:48:18 ICT 2022', 3, 1);