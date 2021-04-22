package org.sweatshop.tests;

import static java.lang.String.format;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

public class MavenReaderTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, XmlPullParserException {
        readMavenFile();
    }

    public static void readMavenFile() throws FileNotFoundException, IOException, XmlPullParserException {
        MavenXpp3Reader mavenReader = new MavenXpp3Reader();

        File pomFile = new File("/Users/abrahamd/git/mbs/pom.xml");
        Model model = mavenReader.read(new FileReader(pomFile));

        System.out.println(format("%s:%s:%s:%s, id = %s"
                , model.getGroupId(), model.getArtifactId(), model.getPackaging(), model.getVersion(), model.getId()));

        List<Dependency> deps = model.getDependencies();

        for (Dependency d: deps) {
            System.out.println(format("%s:%s:%s",d.getGroupId(), d.getArtifactId(), d.getVersion()));
        }

    }
}
