import java.io.File
import javax.xml.bind.JAXBContext

fun unmarshal(xmlFile: File): Students 
{
    val jaxbContext = JAXBContext.newInstance(Students::class.java)
    val unmarshaller = jaxbContext.createUnmarshaller()
    return unmarshaller.unmarshal(xmlFile) as Students
}
