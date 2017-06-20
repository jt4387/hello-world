/**
 * A small program that takes in String message and encodes the message as a unary String.
 * The String is first converted to binary (each char encoded into 7 bits and then added
 * to the full String).
 *
 * @Programmer: Jacqueline Turof
 */

package com.jackie.unary;

import java.util.*;

class Solution
{
    /**
     * Creates a 7 bit binary string
     * @param codePoint the unicode codepoint for the current char in the series
     * @return the 7 bit binary string
     */
    public static String createBinaryString(int codePoint)
    {
        String binaryString = Integer.toBinaryString(codePoint);

        while (binaryString.length() % 7 != 0)
        {
            binaryString = "0" + binaryString;
        }

        return binaryString;
    }

    /**
     * Creates part of a larger unary String
     * @param oneOrZero Specifies if the current section of the binary string were one(s) or zero(s)
     *                  thows IllegalArgumentException if passed anything other than a one or zero
     * @param count the number of 1s or 0s in the current series
     * @return the unary String
     */
    public static String addToString(int oneOrZero, int count)
    {
        String unaryString = "";
        if (oneOrZero == 1)
        {
            unaryString = unaryString +  "0 ";
            for (int j = 0; j < count; j++)
            {
                unaryString = unaryString + "0";
            }
        }
        else if (oneOrZero == 0)
        {
            unaryString = unaryString +  "00 ";
            for (int j = 0; j < count; j++)
            {
                unaryString = unaryString + "0";
            }
        }
        else
        {
            throw new IllegalArgumentException("Parameter oneOrZero must be either: one or zero");
        }
        return unaryString;
    }

    /**
     * Encodes the full unary String from a binary String
     * @param binaryString the binary String to be converted into a unary String
     * @return the complete message as a unary String
     */
    public static String createUnaryString(String binaryString)
    {
        String unaryString = "";
        int seriesCount = 1;
        for (int i = 0; i < binaryString.length(); i++)
        {
            char current = binaryString.charAt(i);

            // check for end of string
            if (i == binaryString.length() - 1)
            {
                if (current == binaryString.charAt(i - 1)) //series
                    unaryString = (current == '1' ? unaryString + addToString(1, seriesCount) :
                            unaryString + addToString(0,seriesCount));
                else // individual
                    unaryString = (current == '1' ? unaryString + "0 0" :
                            unaryString + "00 0");
            }
            else
            {
                if(binaryString.charAt(i) == binaryString.charAt(i + 1))
                {
                    seriesCount++;
                }
                else
                {
                    if (current == '1')
                    {
                        unaryString = unaryString + addToString(1, seriesCount);
                        unaryString = unaryString + " ";
                        seriesCount = 1;
                    }
                    else
                    {
                        unaryString = unaryString +  addToString(0, seriesCount);
                        unaryString = unaryString + " ";
                        seriesCount = 1;
                    }
                }
            }
        }
        return unaryString;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the message to be encoded as an unary String: ");
        String MESSAGE = in.nextLine();
        String binaryString = "";

        // Change String MESSAGE into a binary string
        for (int i = 0; i < MESSAGE.length(); i++)
        {
            binaryString = binaryString + createBinaryString(MESSAGE.codePointAt(i));
        }
        System.out.println(binaryString);
        String unaryString = createUnaryString(binaryString);
        System.out.println(unaryString);
    }
}
