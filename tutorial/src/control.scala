import java.io.File

/**
  * Created by Tito Palacios on 19/09/16.
  * Date: 19/09/16
  * Time: 18:22
  * ........
  * ........
  */
object control {
  def main(args: Array[String]): Unit = {
    val t0 = System.nanoTime()
    println("Number of files: " + showFilesNoDir())
    val t1 = System.nanoTime()
    println("Elapsed time: "+(t1-t0)/1e9D+" sec.")
  }

  def showFiles(): Int = {
    val filesHere = new File(".").listFiles()
    for (file <- filesHere) {
      println(file.getName)
    }
    filesHere.length
  }

  def showFilesNoDir(): Int = {
    val files = for (file <- new File(".").listFiles() if file.isFile) yield println(file.getName)
    files.length
  }

}
