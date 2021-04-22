package org.sweatshop.tests;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.validator.routines.InetAddressValidator;
import com.google.common.net.InetAddresses;

import javaslang.collection.List;

@SuppressWarnings("unused")
public class RegexpTester {

    private static List<String> stringList = createStringList(10);

    public static void main(String[] args) {
        java.util.List<String> list = new ArrayList<>(0);
        System.out.println( list.stream()
                .map(s -> String.format("[%s=%s]", s, s))
                .collect(java.util.stream.Collectors.joining()));

//        check("\\d{1,20}","1234"
//                ,"12345678901234567890"
//                ,"123456789012345678901"
//                ,"1"
//                ,"");
//
//        check("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"
//                , "255.255.255.255"
//                , "256.255.255.255"
//                , "0012.2.2.2");
//
//        check("^([A-Fa-f0-9]{0,4}::?){1,7}[A-Fa-f0-9]{0,4}$"
//                , "2001:0db8:0a0b:12f0:0000:0000:0000:0001"
//                , "2001:db8:a0b:12f0::::1"
//                , "2001:db8:a0b:12f0::::"
//                , ":db8:a0b:12f0::::1"
//                , "ABCD:ABCD:ABCD:ABCD:ABCD:ABCD:192.168.158.190"
//                );

        check("^([A-Fa-f0-9.:]){0,45}$"
                , "2001:0db8:0a0b:12f0:0000:0000:0000:0001"
                , "2001:db8:a0b:12f0:0:0:0:1"
                , "2001:db8:a0b:12f0:0:0:0:0"
                , "2001:db8::1"
                , "2001:0db8:0000::"
                , "2001:DB8::1:0:0:1"
                , "0:0:0:0:0:0:0:1"
                , "0:0:0:0:0:0:0:0"
                , "2600:1403:11:0:0:0:0:83"
                , "2600:1408:1c:0:0:0:0:80"
                , "2600:1406:32:0:0:0:0:20"
                , "2600:1406:32:0:0:0:0:82"
                , "2600:1406:32:0:0:0:0:c1"
                , "2600:1406:32:0:0:0:0:c2"
                , "2600:1480:1:0:0:0:0:c1"
                , "2600:1480:4800:0:0:0:0:20"
                , "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"
                , "2001:DB8::1::0:1"
                , "2001:db8:a0b:12f0::::1"
                , "2001:db8::1/48"
                , ":db8:a0b:12f0::::1"
                , "2001:0db8:0a0b:12f0:0000:0000:0000:0001/25"
                , "2001:db8:a0b:12f0::::1/25"
                , "2001:db8:a0b:12f0::::/25"
                , ":db8:a0b:12f0::::1/25"
                , "ABCD:ABCD:ABCD:ABCD:ABCD:ABCD:192.168.158.190"
                , "ABCD:ABCD:ABCD:ABCD:ACD:ABCDE:192.168.158.190"
                );

//        Pattern p4 = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", Pattern.DOTALL);
//        System.out.println(p4.matcher("").matches());
//
//        badIps();

//        check("\\d+","1234");
//        check("\\d+","1");
//        check("\\d+","");
//        check("\\d+"," ");
//        check("\\d+","1 ");
//        check("\\d+","1,");
//        check("\\d+","1,2");
//        check("\\d+","1, 2");
//
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "0.0.0.0");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "0.0.0.0.0");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "0.0.0");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "0.0.0.");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "0.0.0.0.");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "257.0.0.0");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "300.0.0.0");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "001.0.0.0");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "256.0.0.0");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "256.0.0.0,0.0.0.0");
//        check("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", "256.0.0.0,");
//
//        System.out.println("\n\n\n\n");
//
//        check("search", "search");
//        check("search", "searchh");
//        check("search?", "search");
//        check("search?", "searchh");
//        check("search?\\w+", "searchhhh");
////        check("search?\\w+", (String)null);  //throws an NPE in java.util.regex.Matcher.getTextLength(Matcher.java:1234)
//        check("/v\\d+.\\d+/foo/\\*/bar", "/v0.3/foo/*/bar");


        perfCheckIp();

        System.out.println(ValidatedKey.IP_KEY.getKeyName()+" ip_key");
        System.out.println(ValidatedKey.IP_KEY.getNonKeyName()+" ip");
        System.out.println(ValidatedKey.ECOR_KEY.getKeyName()+" ecor_key");
        System.out.println(ValidatedKey.ECOR_KEY.getNonKeyName()+" ecor");
        System.out.println(ValidatedKey.REGION_KEY.getKeyName()+" region_key");
        System.out.println(ValidatedKey.REGION_KEY.getNonKeyName()+" region");
        System.out.println(ValidatedKey.getRenamedKey("ip_key")+" ip_alt_key");
        System.out.println(ValidatedKey.getRenamedKey("ip_alt_key")+" ip_alt_key");
        System.out.println(ValidatedKey.getRenamedKey("ipp_key")+" ipp_key");
        System.out.println(ValidatedKey.getRenamedKey("ip")+" ip_alt");
        System.out.println(ValidatedKey.getRenamedKey("ip_alt")+" ip_alt");
        System.out.println(ValidatedKey.getRenamedKey("ipp")+" ipp");

        System.out.println(ValidatedKey.keysToAltKeys);
    }

    public enum ValidatedKey {
        IP_KEY, REGION_KEY, ECOR_KEY;

        public String getKeyName() { return keyName; }
        public String getNonKeyName() { return nonKeyName; }
        public String getAltKeyName() { return altKeyName; }
        public String getAltNonKeyName() { return altNonKeyName; }

        public boolean matches(String in) {
            return in.equalsIgnoreCase(keyName) || in.equalsIgnoreCase(nonKeyName);
        }

        public static String getRenamedKey(String key) {
            String altKey = keysToAltKeys.get(key);
            return (altKey == null) ? key : altKey;
        }

        private static final String underbarKey = "_key";
        private static final String underbarAlt = "_alt";
        private static final String altKey = "_alt_key";
        private final String keyName = this.toString().toLowerCase();
        private final String nonKeyName = innerGetNonKeyName();
        private final String altKeyName = innerGetNonKeyName() + altKey;
        private final String altNonKeyName = innerGetNonKeyName() + underbarAlt;

        private String innerGetNonKeyName() {
            String start = this.toString().toLowerCase();
            return start.substring(0, start.indexOf(underbarKey));
        }

        private final static Map<String, String> keysToAltKeys = getKeysToAltKeys();
        private static Map<String, String> getKeysToAltKeys() {
            Map<String, String> m = new HashMap<>();
            Arrays.asList(values()).stream()
            .peek(vk -> m.put(vk.getNonKeyName(), vk.getAltNonKeyName()))
            .forEach(vk -> m.put(vk.getKeyName(), vk.getAltKeyName()));
            return Collections.unmodifiableMap(m);
        }
    }

    private static void badIps() {
        badIp(
                ""
                , null
                ,"127.0.0."
                , "127.0.0..1"
                , "127.0.0.1."
                , ".0.0..1"
                , "127.0.0..1"
                , "127.0.0..1"
                , "127.0.0..1"
                );

    }

    private static void badIp(String... strings) {
        for (String s : strings) {
            if (validIp(s)) {
                System.out.println(format("%s should not be valid", s));
            }
        }
    }

    private static List<String> createStringList(int iIn) {
        java.util.List<String> tmpList = new ArrayList<>(iIn);
        for (int i = 0; i < iIn; i++) {
            tmpList.add(format("%s.%s.%s.%s",getRandomIpChunk(), getRandomIpChunk(), getRandomIpChunk(), getRandomIpChunk()));
        }
        return List.ofAll(tmpList);
    }

    private static String getRandomIpChunk() {
        return Integer.toString(new Double(Math.random() * 256).intValue());
    }

    private static void perfCheckIp() {

        Pattern p1 = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", Pattern.DOTALL);
        Pattern p2 = Pattern.compile("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$", Pattern.DOTALL);
        Pattern p3 = Pattern.compile("^[\\d\\.]+$", Pattern.DOTALL);
        Pattern p4 = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", Pattern.DOTALL);
        boolean b = true;

        Date d1 = new Date();
        b = b ^ runPattern(p1);
        Date d2 = new Date();
        b = b ^ runPattern(p2);
        Date d3 = new Date();
        b = b ^ runPattern(p3);
        Date d4 = new Date();
        b = b ^ runPattern(p4);
        Date d5 = new Date();
        b = b ^ runIps();
        Date d6 = new Date();
        b = b ^ runIps2();
        Date d7 = new Date();

        if (b) { System.out.println("foo"); }
        System.out.println(format("1 took %s, 2 took %s, 3 took %s, 4 took %s, hand coded took %s, apache took %s"
                , d2.getTime() - d1.getTime(), d3.getTime() - d2.getTime(), d4.getTime() - d3.getTime(), d5.getTime() - d4.getTime(), d6.getTime() - d5.getTime(), d7.getTime() - d6.getTime()));

    }

    private static boolean runIps2() {
        boolean b = true;
        for (String s : stringList) {
            boolean x = InetAddressValidator.getInstance().isValidInet4Address(s);
            if (!x) { System.out.println(format("%s doesn't match for apache commons", s)); }
            b = b ^ x;

        }
        return b;
    }

    private static boolean runIps() {
        boolean b = true;
        for (String s : stringList) {
            boolean x = validIp(s);
            if (!x) { System.out.println(format("%s doesn't match for hand coded", s)); }
            b = b ^ x;
        }
        return b;
    }

    private static boolean validIp(String s) {
        int[] ss = new int[4];
        int i = 0;
        String tmp = "";

        if (null == s || 7 > s.length() || 15 < s.length()) { return fail(); }

        for (char c : s.toCharArray()) {
            if (!isLegalChar(c)) { return fail(); }
            if (c =='.') {
                ss[i] = safeToInt(tmp);
                if (0 > ss[i] || 255 < ss[i]) { return fail(); }
                tmp = "";
                if (4 <= ++i) { return fail(); }
            } else {
                tmp += c;
            }
        }
        ss[i] = safeToInt(tmp);
        if (0 > ss[i] || 255 < ss[i]) { return fail(); }
        if (3 != i) { return fail(); }

        return true;
    }

    private static int safeToInt(String tmp) {
        if (null == tmp || 0 == tmp.length()) {
            return -1;
        }
        return Integer.parseInt(tmp); //can't be invalid, it's between 1 & 3 digits
    }

    private static boolean fail() {
        return false;
    }

    private static boolean isLegalChar(char c) {
        switch (c) {
            case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '.' : return true;
        }
        return false;
    }

    private static boolean runPattern(Pattern p) {
        boolean b = true;
        for (String s : stringList) {
            boolean x = p.matcher(s).matches();
            if (!x) { System.out.println(format("%s doesn't match for %s", s, p.pattern())); }
            b = b ^ x;
        }
        return b;
    }

    private static void check(String s1, String... s2s) {
        Pattern p = Pattern.compile(s1, Pattern.DOTALL);
        for (String s2 : s2s) {
//            boolean matches = p.matcher(s2).matches();

//            System.out.println(String.format("%s \"%s\" %s \"%s\""
//                    , (matches ? "yes" : "no"), s1, (matches ? "matches" : "does not match"), s2));
            boolean b = InetAddresses.isInetAddress(s2);
            System.out.println(String.format("%s %s is %svalid per google"
                    , (b ? "yes" : "no"), s2, (b ? "" : "not ")));
//            System.out.println("--------");

        }
    }

}
