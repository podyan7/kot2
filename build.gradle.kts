import javax.xml.bind.annotation.*
import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller
import javax.xml.bind.Unmarshaller

@XmlRootElement(name = "Students")
@XmlAccessorType(XmlAccessType.FIELD)
data class Students(
    @field:XmlElement(name = "Student")
    val students: List<Student> = emptyList()
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Student(
    @field:XmlElement
    val id: Int = 0,
    @field:XmlElement
    val name: String = "",
    @field:XmlElement
    val age: Int = 0
)

fun unmarshalStudents(filePath: String): Students
{
    val context = JAXBContext.newInstance(Students::class.java)
    val unmarshaller: Unmarshaller = context.createUnmarshaller()
    return unmarshaller.unmarshal(File(filePath)) as Students
}

fun marshalStudents(students: Students, filePath: String)
{
    val context = JAXBContext.newInstance(Students::class.java)
    val marshaller: Marshaller = context.createMarshaller()
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
    marshaller.marshal(students, File(filePath))
}

fun main()
{
    val students = unmarshalStudents("students.xml")
    println("Полученные студенты: $students")

    val newStudents = Students(
        listOf(
            Student(3, "Alex Ivanov", 23),
            Student(4, "Elena Petrova", 24)
        )
    )
    marshalStudents(newStudents, "new_students.xml")
    println("Новый файл создан")
}