package org.sweatshop.tests;

public class TrailingSlashEnsurer {

    /**
     * given any non-null, non-empty string, That string will be returned with a trailing slash at the 
     * end.  If there is already one there, this will not duplicate it. 
     * @param sIn
     * @return
     */
    public static String ensureTrailingSlash(String sIn) {
        if (null == sIn || "".equals(sIn) || "/".equals(sIn.substring(sIn.length()-1))) {
            return sIn;
        } else {
            return sIn+"/";
        }
    }

    public static void main(String[] args) {
        System.out.println(ensureTrailingSlash(null));
        System.out.println(ensureTrailingSlash(""));
        System.out.println(ensureTrailingSlash("/"));
        System.out.println(ensureTrailingSlash("f"));
        System.out.println(ensureTrailingSlash(" "));;
        System.out.println(ensureTrailingSlash("foo"));
        System.out.println(ensureTrailingSlash("foo/"));
        System.out.println(ensureTrailingSlash("foo/bar"));
        System.out.println(ensureTrailingSlash("foo/bar/"));
    }

}
