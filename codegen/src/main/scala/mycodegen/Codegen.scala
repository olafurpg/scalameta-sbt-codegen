package mycodegen

import scala.meta._

import java.nio.file.Files
import java.nio.file.Paths

import caseapp._

case class CodegenOptions(
    in: String,
    out: String
)

object Codegen extends CaseApp[CodegenOptions] {
  override def exit(code: Int): Unit =
    if (code != 0) {
      throw new IllegalArgumentException(s"Non-zero exit status: $code ")
    }

  def run(options: CodegenOptions, ignored: RemainingArgs): Unit = {
    val out = Paths.get(options.out)
    
    println(s"Running! $options")
    out.toFile.getParentFile.mkdirs()
    Files.write(out, options.toString.getBytes())
  }
}
