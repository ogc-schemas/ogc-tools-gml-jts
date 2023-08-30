lazy val root = (project in file("."))
  .settings(
    name                 := "ogc-tools-gml-jts",
    organization         := "org.ogc-schemas",
    managedScalaInstance := false,
    crossPaths           := false,
    version              := "3.0.1",
    versionScheme        := Some("semver-spec"),
    homepage             := Some(url("https://github.com/ogc-schemas/ogc-tools-gml-jts")),
    licenses             := Seq("BSD" -> url("https://directory.fsf.org/wiki/License:BSD-2-Clause")),
    fork                 := true,
    // The javaHome setting can be removed if building against the latest installed version of Java is acceptable.
    // Running the tests requires removing the setting.
    // It can also be changed to point to a different Java version.
    //javaHome             := Some(file("/home/soc/apps/zulu8.33.0.1-jdk8.0.192-linux_x64/")),
    libraryDependencies  += "jakarta.xml.bind"     % "jakarta.xml.bind-api" % "3.0.1",
    libraryDependencies  += "org.ogc-schemas"      % "gml-v_3_1_1"          % "5.0.0",
    libraryDependencies  += "org.locationtech.jts" % "jts-core"             % "1.19.0",
    // Only required for `GML311ToJTSCoordinateConverter` which uses `org.jvnet.jaxb2_commons.locator.ObjectLocator`
    // which extends `javax.xml.bind.ValidationEventLocator`. A new release of `jaxb2_commons` should fix this.
    libraryDependencies  += "javax.xml.bind"       % "jaxb-api"             % "2.3.1",
    Test / testOptions   := Seq(Tests.Argument(TestFrameworks.JUnit, "-a")),
    publish / skip       := true,
    publishTo            := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
      else Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    Compile / packageBin / packageOptions += {
      import java.util.jar.{Attributes, Manifest}
      val manifest = new Manifest
      manifest.getMainAttributes.put(new Attributes.Name("Automatic-Module-Name"), "ogc.tools.gml.jts")
      Package.JarManifest(manifest)
    },
    pomExtra             :=
      <scm>
        <url>git@github.com:ogc-schemas/ogc-tools-gml-jts.git</url>
        <connection>scm:git:git@github.com:ogc-schemas/ogc-tools-gml-jts.git</connection>
      </scm>
      <developers>
        <developer>
          <id>soc</id>
          <name>Simon Ochsenreither</name>
          <url>https://github.com/soc</url>
          <roles>
            <role>current maintainer</role>
          </roles>
        </developer>
        <developer>
          <id>lexi</id>
          <name>Aleksei Valikov</name>
          <email>valikov@gmx.net</email>
          <roles>
            <role>original author</role>
          </roles>
        </developer>
      </developers>
  )
