import javax.xml.bind.JAXBContext
import java.io.StringWriter

fun marshal(students: Students): String 
{
    val jaxbContext = JAXBContext.newInstance(Students::class.java)
    val marshaller = jaxbContext.createMarshaller()
    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true)

    val sw = StringWriter()
    marshaller.marshal(students, sw)
    return sw.toString()
}
