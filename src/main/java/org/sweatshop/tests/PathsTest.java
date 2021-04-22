package org.sweatshop.tests;

import static java.lang.String.format;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {

    private static final Path AF_CERTS = Paths.get("af_certs/");
    private static final Path ROOT_WITH = Paths.get("/root/");
    private static final Path ROOT_WITHOUT = Paths.get("/root");
    private static final Path INNER_AF_CERTS = Paths.get("/root/").resolve(AF_CERTS);
    private static final Path INNER_AF_CERTS_WITH = ROOT_WITH.resolve(AF_CERTS);
    private static final Path INNER_AF_CERTS_WITHOUT = ROOT_WITHOUT.resolve(AF_CERTS);

    public static void main(String[] args) {
        s2(ROOT_WITH);

        s(AF_CERTS);
        s(ROOT_WITH);
        s(ROOT_WITHOUT);
        s(INNER_AF_CERTS);
        s(INNER_AF_CERTS_WITH);
        s(INNER_AF_CERTS_WITHOUT);
    }

    private static void s2(Path p) {
        Path p2 = p;
        try {
            while (true) {
                System.out.println(format("%s %s", p, p2));
                p2 = p2.getParent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final void s(Path p) {
        System.out.println(p.toString());
    }


}
