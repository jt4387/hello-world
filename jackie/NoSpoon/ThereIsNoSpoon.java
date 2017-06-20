package com.jackie.NoSpoon;

import java.util.Scanner;

/**
 * Finding horizontal and vertical neighbors from a 2D array.
 * Input Looks Like:
 */
public class ThereIsNoSpoon
{
        public static boolean isNodeEmpty(char zeroOrDot)
        {
            if (zeroOrDot == '0') return false;
            else return true;
        }

        public static String getRightCoordinates(char[][] powerGrid, int i, int j,
                                                 int width)
        {
            // Check if we are at end of grid
            if(i + 1 == width) return " -1 -1";
                // Check if node directly to right is a power node
            else if(powerGrid[i + 1][j] == '0') return " " + (i + 1) + " " + j;
                // Find next right node
            else
            {
                for(i+=2 ; i < width; i++)
                {

                    if (powerGrid[i][j] == '0') return " " + i + " " + j;
                        // No node to the right found

                }

                return " -1 -1";
            }
        }

        public static String getBottomCoordinates(char[][] powerGrid, int i, int j,
                                                  int height)
        {
            // Check if we are at the end of the grid
            if(j + 1 == height) return " -1 -1";
                // Check if node is empty
            else if(powerGrid[i][j + 1] == '0') return " " + i + " " + (j + 1);
                // Get coordinates of bottom node
            else
            {
                for(j+=2 ; j < height; j++)
                {
                    if (powerGrid[i][j] == '0') return " " + i + " " + j;
                        // No node to the bottom found
                }

                return " -1 -1";
            }
        }

        public static void main(String args[])
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter number of cells on X Axis: ");
            int width = in.nextInt(); // the number of cells on the X axis
            System.out.println("Enter number of cells on Y Axis: ");
            int height = in.nextInt(); // the number of cells on the Y axis
            char[][] powerGrid = new char[width][height];
            if (in.hasNextLine())
            {
                in.nextLine();
            }
            System.out.println("Enter Grid: ");
            System.out.println("A node is represented with a 0 an empty node represented with a .");
            for (int i = 0; i < height; i++)
            {
                String line = in.nextLine(); // width characters, each either 0 or .

                for(int j = 0; j < line.length(); j++)
                {
                    powerGrid[j][i] = line.charAt(j);
                }
            }

            // Go through power grid
            String nodes = "";
            for (int i = 0; i < width; i++)
            {
                for (int j = 0; j < height; j++)
                {
                    // Check if node is empty
                    if (isNodeEmpty(powerGrid[i][j]))
                    {
                        continue;
                    }
                    else
                    {
                        // if node is not empty
                        // get cordinates of node
                        nodes = "" + i + " " + j;

                        // get coordinates of node to right
                        nodes += getRightCoordinates(powerGrid, i, j, width);

                        // get coordinates of node to bottom
                        nodes += getBottomCoordinates(powerGrid, i, j, height);

                        System.out.println(nodes);

                    }
                }
            }
        }
}

