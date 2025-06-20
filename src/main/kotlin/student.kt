import javax.xml.bind.annotation.*

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
data class Students(
    @field:XmlElement(name = "student")
    var studentList: List<Student> = emptyList()
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Student(
    var name: String = "",
    var age: Int = 0,
    var skill: String = "" 
)
