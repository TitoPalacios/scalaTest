/**
  * Created by Tito Palacios
  * Date: 14/09/16
  * Sandbox to play with iText and Scala
  */
import java.io.{FileOutputStream, IOException}
import java.util

import com.itextpdf.text.Font.FontFamily
import com.itextpdf.text._
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.PdfFont


object pdfTest1 {
  @throws(classOf[DocumentException])
  @throws(classOf[IOException])
  def main(args: Array[String]): Unit = {
    val t0 = System.nanoTime()
    println("Working with PDF libraries... ")
    createPDFFirstTable()
    val t1 = System.nanoTime()
    println("Elapsed time: "+(t1-t0)/1e9D+" sec.")
  }

  @throws(classOf[DocumentException])
  @throws(classOf[IOException])
  def createPDFFirstTable(): Unit = {
    // Using a custom page size
    val sFilePDF = "tutorial/data/TestFirstTable.pdf"
    val document = new Document()
    PdfWriter.getInstance(document, new FileOutputStream(sFilePDF))
    println("...Generating file "+sFilePDF)

    val table = new PdfPTable(3)
    val cell1 = new PdfPCell(new Phrase("Cell with colspan 3"))
    cell1.setColspan(3)
    cell1.setBorderWidth(0)
    cell1.setBorderWidthBottom(2)
    table.addCell(cell1)
    val cell2 = new PdfPCell(new Phrase("Cell with rowspan 2"))
    cell2.setRowspan(2)
    cell2.setBorder(0)
    table.addCell(cell2)

    table.addCell("row 1; cell 1")
    table.addCell("row 1; cell 2")
    table.addCell("row 2; cell 1")
    table.addCell("row 2; cell 2")

    val columnWidths = Array[Float](5,10,50,35)
    val table2 = new PdfPTable(columnWidths)
    table2.setWidthPercentage(100)

    val myFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE)
    val text = new Chunk("100", myFont)

    val cell31 = new PdfPCell(new Phrase(text))
    cell31.setBorder(3)
    cell31.setPadding(5)
    cell31.setBorderColor(BaseColor.RED)
    cell31.setBackgroundColor(BaseColor.BLUE)
    cell31.setHorizontalAlignment(Element.ALIGN_CENTER)
    cell31.setVerticalAlignment(Element.ALIGN_MIDDLE)
    val cell32 = new PdfPCell(new Phrase(" "))
    cell32.setBorder(0)
    val cell33 = new PdfPCell(new Phrase(" This is another text "))
    cell33.setBorder(0)
    val cell34 = new PdfPCell(new Phrase(" But the end "))
    cell34.setBorder(0)

    table2.addCell(cell32)
    table2.addCell(cell31)
    table2.addCell(cell33)
    table2.addCell(cell34)

    val cell4 = new PdfPCell(table2)
    cell4.setBorder(0)
    cell4.setColspan(3)
    table.addCell(cell4)

    table.addCell("Another Cell")
    table.addCell("...and other")
    table.addCell(" one more")


    document.open()

    document.add(table)

    document.close()
  }

  @throws(classOf[DocumentException])
  @throws(classOf[IOException])
  def createPDFMirroredMargins(): Unit = {
    // Using a custom page size
    val sFilePDF = "tutorial/data/TestMirroredMargins.pdf"
    val document = new Document(PageSize.A5)
    PdfWriter.getInstance(document, new FileOutputStream(sFilePDF))
    document.setMargins(36, 72,108,180)
    document.setMarginMirroring(true)
    println("...Generating file "+sFilePDF)
    document.open()
    document.add(new Paragraph("The left margin of this odd page is 36pt (0.5 inch); " +
      "the right margin 72pt (1 inch); " +
      "the top margin 108pt (1.5 inch); " +
      "the bottom margin 180pt (2.5 inch)."))
    val paragraph = new Paragraph()
    paragraph.setAlignment(Element.ALIGN_JUSTIFIED)
    for (i<- 0 to 20) {
      paragraph.add("Hello World! Hello People!" +
                    "Hello Sky! Hello Sun! Hello Moon! Hello Stars!!")
    }
    document.add(paragraph)
    document.add(new Paragraph(
      "The right margin of this even page is 36pt;" +
      "the left margin 72pt"
    ))
    document.close()
  }

  @throws(classOf[DocumentException])
  @throws(classOf[IOException])
  def createPDFLandscape(): Unit = {
    // Using a custom page size
    val sFilePDF = "tutorial/data/TestLandscape.pdf"
    val document = new Document(PageSize.A4.rotate())
    PdfWriter.getInstance(document, new FileOutputStream(sFilePDF))
    println("...Generating file "+sFilePDF)
    document.open()
    document.add(new Paragraph("Hello in a Landscape World !!!"))
    document.close()
  }

  @throws(classOf[DocumentException])
  @throws(classOf[IOException])
  def createPDFSpecialSize(): Unit = {
    // Using a custom page size
    val sFilePDF = "tutorial/data/TestSpecialSize.pdf"
    val pagesize = new Rectangle(216f, 720f)
    val document = new Document(pagesize, 36f, 72f, 108f, 180f)
    PdfWriter.getInstance(document, new FileOutputStream(sFilePDF))
    println("...Generating file "+sFilePDF)
    document.open()
    document.add(new Paragraph("Hello World !!!"+"Hello Sky! Hello stars!! Hello everybody"))
    document.close()
  }

  @throws(classOf[DocumentException])
  @throws(classOf[IOException])
  def createPDF1(sFilePDF: String): Unit = {
    println("...Generating file "+sFilePDF)
    val document = new Document()
    PdfWriter.getInstance(document, new FileOutputStream(sFilePDF))
    document.open()
    document.add(new Paragraph("Hello World !!!"))
    document.close()
  }
}

