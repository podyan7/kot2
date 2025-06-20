fun main() 
{
    val xmlFile = File("students.xml") 
    val students = unmarshal(xmlFile)

    addSkillToStudents(students, "Kotlin Programming")

    val updatedXml = marshal(students)
    println(updatedXml) 
}
