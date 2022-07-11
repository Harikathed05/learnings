package com.company;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static void main(String[] args) {
	// write your code here
      /*  List<Integer> source = Arrays.asList(1,2,3);
        List<Integer> dest = Arrays.asList(4,5,6);
        dest.addAll(source);
        dest.forEach(e -> System.out.println(e));*/

        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> number1 = new ArrayList<>();
        ArrayList<String> number2 = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
       // System.out.println(numbers);        // [1, 2, 3]
        //System.out.println(numbers .size());    // prints: 3
        ArrayList<String> letters = new ArrayList<>();

        number1.addAll( letters);
        number1.addAll( number2);
        number1.forEach(System.out::println);
        String path1 = "/Users/harikath/Downloads";
        String path2 = "Futur_dec.pdf";
        final File file = new File(Paths.get(path1, path2).toString());
        System.out.println("file exists "+ file.isFile());
        final String relativeFilePath = path1 + "/" + path2;
        final File file2 = new File(relativeFilePath);
        System.out.println("file2 exists "+ file.isFile());


        HashMap<Integer, Integer> hashmapDupcheck = new HashMap<>();
        numbers.forEach(num -> hashmapDupcheck.put(Integer.valueOf(num), Integer.valueOf(num)+100));

        hashmapDupcheck.forEach(((integer, integer2) -> System.out.println("Key :"+ integer + ", value :" + integer2)));

        numbers.forEach(num -> hashmapDupcheck.putIfAbsent(Integer.valueOf(num), Integer.valueOf(num)+1000));
               // hashmapDupcheck.put(Integer.valueOf(num), Integer.valueOf(num)+1000));
        hashmapDupcheck.forEach(((integer, integer2) -> System.out.println("Key :"+ integer + ", value :" + integer2)));

        String s3Path = "s3://gds-files/workflow-CreateALCGDS_Legacy/FE";
        System.out.println("print s3 path " + s3Path.split("/")[0]+""+s3Path.split("/")[1]+s3Path.split("/")[2]);

        List<String> paymentInstrumentTypes = Arrays.asList("GIFT_CARD".split(","));
        System.out.println("paymentInstrumentTypes " + paymentInstrumentTypes.get(0));
        System.out.println("paymentInstrumentTypes " + Arrays.asList("GIFT_CARD".split(",")).stream().toString());
       // System.out.println("paymentInstrumentTypes " + paymentInstrumentTypes.get(1));
        char c = '1';
    }


}
