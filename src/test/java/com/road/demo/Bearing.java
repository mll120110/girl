package com.road.demo;

public class Bearing {

    public static double PI = Math.PI;

    /**
     * 计算两个经纬度之间的距离
     * 
     * @param long1
     *            第一点经度
     * @param lat1
     *            第一点纬度
     * @param long2
     *            第二点经度
     * @param lat2
     *            第二点纬度
     * @return
     */
    public static double distance(double long1, double lat1, double long2, double lat2) {
        double a, b, R;
        // 地球半径
        R = 6378137;
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;

        // 纬度之间的距离
        a = lat1 - lat2;
        // 经度之间的距离
        b = (long1 - long2) * Math.PI / 180.0;

        double d, sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
        return d;
    }

    /**
     * 计算两个经纬度之间的方位角
     * 
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static double complex(double lon1, double lat1, double lon2, double lat2) {
        double numerator = Math.sin(Math.toDegrees(lon2 - lon1)) * Math.cos(Math.toDegrees(lat2));
        double denominator = Math.cos(Math.toDegrees(lat1)) * Math.sin(Math.toDegrees(lat2))
            - Math.sin(Math.toDegrees(lat1)) * Math.cos(Math.toDegrees(lat2)) * Math.cos(Math.toDegrees(lon2 - lon1));

        double x = Math.atan2(Math.abs(numerator), Math.abs(denominator));
        double result = x;
        // right quadrant
        if (lon2 > lon1) {
            // first quadrant
            if (lat2 > lat1)
                result = x;
            // forth quadrant
            else if (lat2 < lat1)
                result = PI - x;
            else {
                // in positive-x axis
                result = PI / 2;
            }
            // left quadrant
        } else if (lon2 < lon1) {
            // second quadrant
            if (lat2 > lat1)
                result = 2 * PI - x;
            // third quadrant
            else if (lat2 < lat1)
                result = PI + x;
            else {
                // in negative-x axis
                result = PI * 3 / 2;
            }
            // same longitude
        } else {
            // in positive-y axis
            if (lat2 > lat1)
                result = 0;
            else if (lat2 < lat1)
                // in negative-y axis
                result = PI;
            else
                return 0.0;
        }
        System.out.println(result * 180 / PI);
        return result * 180 / PI;
    }
}
