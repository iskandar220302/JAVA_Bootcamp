package org.example;

import static java.lang.Math.*;

public class Perimeter {
    public static double perimeterOfTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double AB = sqrt(pow((x2 - x1), 2) +  pow((y2 - y1), 2));
        double BC = sqrt(pow((x3 - x2), 2) +  pow((y3 - y2), 2));
        double CA = sqrt(pow((x3 - x1), 2) +  pow((y3 - y1), 2));

        return AB + BC + CA;
    }
}
