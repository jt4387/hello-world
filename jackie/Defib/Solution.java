package com.jackie.Defib;

import java.util.Scanner;

/**
 * Created by jacqu on 6/5/2017.
 */
class Solution
{
    private static double calculateDistance(double longitudeA, double latitudeA, double longitudeB, double latitudeB)
    {
        double x, y, d;

        x = (longitudeB - longitudeA) * Math.cos((latitudeA + latitudeB) / 2);
        y = latitudeB - latitudeA;
        d = Math.sqrt((x * x) + (y * y)) * 6371;

        return d;
    }

    private static double[] parseStringForCoordinates(String stringToParse)
    {
        Double longitudeB, latitudeB;

        // Get latitude
        int latIndex = stringToParse.lastIndexOf(';');
        int defibCommaIndex = stringToParse.substring(latIndex + 1).indexOf(',') + latIndex + 1;
        latitudeB = new Double((stringToParse.substring(latIndex + 1, defibCommaIndex) + "." +
                stringToParse.substring(defibCommaIndex + 1) ));

        // Get longitude
        String newDEFIB = stringToParse.substring(0, latIndex);
        //System.out.println(newDEFIB);
        int lonIndex = newDEFIB.lastIndexOf(';');
        defibCommaIndex = newDEFIB.substring(lonIndex + 1).indexOf(',') + lonIndex + 1;
        longitudeB = new Double((newDEFIB.substring(lonIndex + 1, defibCommaIndex) + "." +
                newDEFIB.substring(defibCommaIndex + 1) ));

        double[] cords = new double[2];
        cords[0] = longitudeB;
        cords[1] = latitudeB;

        return cords;
    }
    public static void main(String args[])
    {
        Double longitudeA, latitudeA, longitudeB, latitudeB;
        int commaIndex;


        Scanner in = new Scanner(System.in);
        String LON = in.next();
        commaIndex = LON.indexOf(',');
        longitudeA = new Double(LON.substring(0, commaIndex) + "." + LON.substring(commaIndex + 1));
        String LAT = in.next();
        commaIndex = LAT.indexOf(',');
        latitudeA =  new Double(LAT.substring(0, commaIndex) + "." + LAT.substring(commaIndex + 1));
        int N = in.nextInt();
        String[] defibs = new String[N];

        if (in.hasNextLine())
        {
            in.nextLine();
        }

        String DEFIB0 = in.nextLine();
        defibs[0] = DEFIB0;
        double[] cords0 = parseStringForCoordinates(DEFIB0);
        double minDistance = calculateDistance(longitudeA, latitudeA, cords0[0], cords0[1]);
        int indexMin = 0;

        for (int i = 1; i < N; i++)
        {
            String DEFIB = in.nextLine();
            defibs[i] = DEFIB;

            //Get cords
            double cords[] = parseStringForCoordinates(DEFIB);

            // calculate distance
            double distance =calculateDistance(longitudeA, latitudeA, cords[0], cords[1]);

            if (distance < minDistance)
            {
                minDistance = distance;
                indexMin = i;
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        // Get name from string
        String firstString = defibs[indexMin];
        int firstSemiColon = firstString.indexOf(';');
        String secondString = firstString.substring(firstSemiColon + 1);
        int secondSemiColon = secondString.indexOf(';');
        String finalString = secondString.substring(0, secondSemiColon);
        System.out.println(finalString);
    }
}
