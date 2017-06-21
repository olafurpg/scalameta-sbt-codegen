scalaVersion in ThisBuild := "2.11.11"

lazy val codegen = project.settings(
  libraryDependencies += "org.scalameta" %% "scalameta" % "1.8.0"
)

lazy val app = project.settings(
  sourceGenerators in Compile += Def.taskDyn {
    val outFile = sourceManaged.value / "mycodegen" / "Generated.scala"
    Def.task {
      (run in codegen in Compile)
        .toTask(" " + outFile.getAbsolutePath)
        .value
      Seq(outFile)
    }
  }.taskValue
)
