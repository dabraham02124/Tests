package org.sweatshop.tests;

//import com.sun.management.OperatingSystemMXBean;
//
//import oshi.SystemInfo;
//import oshi.hardware.CentralProcessor;
//import oshi.hardware.HardwareAbstractionLayer;
//
import java.io.IOException;
//import java.lang.management.ManagementFactory;
//
//import javax.management.MBeanServerConnection;

public class CpuGetter {

    public static void main(String[] args) throws IOException {
//        one();
//        System.out.println("-----------");
//        two();
//        System.out.println("-----------");
//        three();
    }

//    private static void one() throws IOException {
//        MBeanServerConnection mbsc = ManagementFactory.getPlatformMBeanServer();
//
//        OperatingSystemMXBean osMBean = ManagementFactory.newPlatformMXBeanProxy(
//                mbsc, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);
//
//        long nanoBefore = System.nanoTime();
//        long cpuBefore = osMBean.getProcessCpuTime();
//
//        // Call an expensive task, or sleep if you are monitoring a remote process
//
//        long cpuAfter = osMBean.getProcessCpuTime();
//        long nanoAfter = System.nanoTime();
//
//        long percent;
//        if (nanoAfter > nanoBefore)
//            percent = ((cpuAfter-cpuBefore)*100L)/
//            (nanoAfter-nanoBefore);
//        else percent = 0;
//
//        System.out.println("Cpu usage: "+percent+"%");
//    }

//    private static void two() {
//        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//        // What % CPU load this current JVM is taking, from 0.0-1.0
//        double load = osBean.getProcessCpuLoad();
//        System.out.println(load);
//
//        // What % load the overall system is at, from 0.0-1.0
//        double systemLoad = osBean.getSystemCpuLoad();
//        System.out.println(systemLoad);
//    }

//    private static void three() {
//        SystemInfo si = new SystemInfo();
//        HardwareAbstractionLayer hal = si.getHardware();
//        CentralProcessor processor = hal.getProcessor();
//
//        System.out.format("CPU load: %.1f%% (counting ticks)%n", processor.getSystemCpuLoadBetweenTicks() * 100);
//        System.out.format("CPU load: %.1f%% (OS MXBean)%n", processor.getSystemCpuLoad() * 100);
//        double[] loadAverage = processor.getSystemLoadAverage(3);
//        System.out.println("CPU load averages:" + (loadAverage[0] < 0 ? " N/A" : String.format(" %.2f", loadAverage[0]))
//                + (loadAverage[1] < 0 ? " N/A" : String.format(" %.2f", loadAverage[1]))
//                + (loadAverage[2] < 0 ? " N/A" : String.format(" %.2f", loadAverage[2])));
//    }


}
