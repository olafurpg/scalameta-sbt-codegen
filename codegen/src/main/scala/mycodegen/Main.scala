package mycodegen

import java.io.File
import java.nio.file.Files
import scala.meta._

object Main {
  def main(args: Array[String]): Unit = {
    args.toList match {
      case path :: Nil if path.endsWith(".scala") =>
        val jfile = new File(path)
        jfile.getParentFile.mkdirs()
        // Do scala.meta code generation here.
        Files.write(
          jfile.toPath,
          source"""package mycodegen
                   object Generated {
                     val msg = "Hello world!"
                   }
                   """.syntax.getBytes("UTF-8")
        )
    }
  }
}
