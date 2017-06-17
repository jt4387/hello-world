package com.jackie.mimeType;

/**
 * A small program to determine the file type from the name of a file.
 * The table of file types is determined by input from the user.
 * If the user does not provide a specified file type the type will
 * be left as UNKNOWN.
 *
 * @Programmer: Jacqueline Turof
 *
 */

import java.util.*;

public class MimeType
{
    public static String getFileType(String FNAME, Map<String, String> extensionMap)
    {
        String mimeType = "";
        String extension;

        // find last (.) occurrence
        for (int i = FNAME.length() - 1; i >= 0; i--)
        {
            if (FNAME.charAt(i) == '.') // get last occurrence of . character
            {
                extension = FNAME.substring(i + 1);
                if (extensionMap.containsKey(extension))
                {
                    mimeType = extensionMap.get(extension);
                    break;
                }
                else
                {
                    mimeType = "UNKNOWN";
                    break;
                }
            }
            mimeType = "UNKNOWN";
        }

        return mimeType;
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number of file types to add to table: ");
        int N = in.nextInt(); // Number of elements which make up the association table.
        Map<String, String> extensionMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Please enter the number of file names to be analyzed: ");
        int Q = in.nextInt(); // Number Q of file names to be analyzed.

        for (int i = 0; i < N; i++)
        {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            extensionMap.put(EXT, MT);
        }

        in.nextLine();
        String mimeType;

        for (int i = 0; i < Q; i++)
        {
            String FNAME = in.nextLine(); // One file name per line.
            mimeType = getFileType(FNAME, extensionMap);

            System.out.println(mimeType);
        }
    }
}
