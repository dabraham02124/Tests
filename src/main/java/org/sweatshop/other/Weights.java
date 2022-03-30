package org.sweatshop.other;

import static org.sweatshop.other.Weights.Plate.Measure.KGS;
import static org.sweatshop.other.Weights.Plate.Measure.LBS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import lombok.Value;

public class Weights {
    final static DecimalFormat df = new DecimalFormat("0.##");
    final static float KG_TO_LBS = 2.204623f;
    @Value
    public static class Plate {
        Float lbs;
        float numberOfUnits;
        Measure measure;
        public static enum Measure {
            LBS(1f), KGS(KG_TO_LBS),;
            private final float mult;
            private Measure(float mult) { this.mult = mult; }
            public float getLbs(float units) { System.out.println(units +" " + this + " = " +units * mult);return units * mult; }
        }

        public Plate(float numberOfUnits, Measure measure) {
            this.numberOfUnits = numberOfUnits;
            this.measure = measure;
            lbs = measure.getLbs(numberOfUnits);
        }

        public List<Plate> plates(int n) {
            return List.fill(n, () -> this);
        }

        public String readable() {
            return String.format("%s%s", df.format(numberOfUnits), (KGS == measure ? " K" : "#"));
        }
    }

    @Value
    public static class LoadedBar {
        List<Plate> plates;
        boolean clip;

        float getTotal() {
            return (plates.map(p -> p.getLbs() * 2). sum().floatValue()) + 45 + (clip ? 1 : 0);
        }

        public String readable() {
            return String.format("%s %s clip", plates.map(p -> p.readable()).mkString(", "), clip ? "and a" : "no");
        }
    }


    public static void main(String[] args) throws IOException {
        List<Plate> plates = List.of(
                new Plate(45, LBS), new Plate(20, KGS), new Plate(15, KGS), new Plate(10, KGS), new Plate(5, KGS))
                .prependAll(new Plate(35, LBS).plates(4))
                .prependAll(new Plate(2.5f, KGS).plates(2))
                .prependAll(new Plate(1.25f, KGS).plates(2));

        System.out.println("enter a goal weight");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int goalWeight = Integer.parseInt(reader.readLine());
        System.out.println("clip? y/n/e");
        String clip = reader.readLine();

        List<List<Plate>> allSubsets = createAllSubLists(plates);
        allSubsets = allSubsets.map(l -> l.sortBy(p -> p.getLbs()).reverse());
        allSubsets = List.ofAll(HashSet.ofAll(allSubsets));
        // Float goalWeight = Float.parseFloat(args[0]);
        List<LoadedBar> bars = allSubsets.flatMap(s -> List.of(new LoadedBar(s, true), new LoadedBar(s, false)))
                .sortBy(bar -> bar.getTotal())
                .filter(bar -> near(bar.getTotal(), goalWeight, 5) && validClip(bar.isClip(), clip))
                .sortBy(bar -> Math.abs(bar.getTotal() - goalWeight));
        bars.forEach(bar -> System.out.format("%-8s %s %s%n", df.format(bar.getTotal()), bar.readable(), bar.getTotal()));
        System.out.println();
    }

    private static boolean validClip(boolean clip, String string) {
        boolean parseable = "y".equalsIgnoreCase(string) || "n".equalsIgnoreCase(string);
        return !parseable || (("y".equalsIgnoreCase(string) && clip) || ("n".equalsIgnoreCase(string) && !clip));
    }

    public static boolean near(float num, float near, int delta) {
        return num > near-delta && num < near + delta;
    }

    private static List<List<Plate>> createAllSubLists(List<Plate> plates) {
        if (plates.isEmpty()) {
            return List.of(List.empty());
        } else {
            List<List<Plate>> allSoFar = createAllSubLists(plates.slice(1, plates.size()));
            return allSoFar.prependAll(allSoFar.map(l -> l.prepend(plates.get())));
        }
    }
}
