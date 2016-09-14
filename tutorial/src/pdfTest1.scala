/**
  * Created by Tito Palacios on 14/09/16.
  * Date: 14/09/16
  * Time: 19:19
  * ........
  * ........
  */
import java.io.FileOutputStream

import com.itextpdf.text.Document
import com.itextpdf.text.DocumentException
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream

object pdfTest1 {
  def main(args: Array[String]): Unit = {
    println("First example using PDF libraries... ")
    val sFilePDF  =   "/tmp/pdfTest1.pdf"
    createPDF (sFilePDF)
  }

  def createPDF(sFilePDF: String): Unit = {
    println("...Generating file"+sFilePDF)
    val document = new Document()
    PdfWriter.getInstance(document, new FileOutputStream(sFilePDF))
    document.open()
    document.add(new Paragraph("Hello World !!!"))
    document.close()
  }
}

