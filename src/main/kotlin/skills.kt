fun addSkillToStudents(students: Students, skill: String) 
{
    students.studentList.forEach { student ->
        student.skill = skill
    }
}
