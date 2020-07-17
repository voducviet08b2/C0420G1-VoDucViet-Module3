use student_manage;

select name_student from students
where name_student="Huong";

select name_student,sum(sotien) as tongtien from students
where name_student="Huong"
group by name_student;

select distinct name_student from students;  
