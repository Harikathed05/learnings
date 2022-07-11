package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GetEntitiesList {
    public String readEntities(final String filePath) {
        StringBuffer sb=new StringBuffer();
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
               //constructs a string buffer with no characters
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
            }
            fr.close();    //closes the stream and release the resources
            System.out.println("Contents of File: ");
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public List<String> getAllEntities(final String fileData) {
        Pattern MY_PATTERN = Pattern.compile("pm_entity::'\\w+/[a-z]+[:0-9./]+[a-zA-z:0-9.']+");
        Matcher m = MY_PATTERN.matcher(fileData);
        List<String> allEntities = new ArrayList<>();
        while (m.find()) {
            String s = m.group(0);
            //System.out.println("matched entity " + s.split("pm_entity::")[1].replace("::",""));
            allEntities.add(s.split("pm_entity::")[1].replace("::",""));
        }
        System.out.println("allEntities size " + allEntities.size());
        return allEntities;
    }

    public static void main(String [] args) {
        GetEntitiesList getEntitiesList = new GetEntitiesList();
        //List<String> gdsAlc_entties = getEntitiesList.getAllEntities(getEntitiesList
        //        .readEntities("/Users/harikath/Downloads/gdsAlc_order_doc"));
        List<String> gdsAlc_entties = getEntitiesList.getAllEntities(getEntitiesList
                .readEntities("/Users/harikath/Downloads/new_order_doc.txt"));
        List<String> preorder_entties = getEntitiesList.getAllEntities(getEntitiesList
                .readEntities("/Users/harikath/Downloads/Preorder_order_doc"));
        List<String> sdocSubscription_orderdoc_entities = getEntitiesList.getAllEntities(getEntitiesList
                .readEntities("/Users/harikath/Downloads/sdocSubscription_orderdoc"));
        Collection<String> similarEntities = new HashSet<String>(preorder_entties);
        Collection<String> differentEntities = new HashSet<String>();
        similarEntities.retainAll(gdsAlc_entties);
        differentEntities.addAll(preorder_entties);
        differentEntities.addAll(gdsAlc_entties);
        System.out.println("Size of differentEntities hashset " + differentEntities.size());
        System.out.println("Size of similarEntities hashset " + similarEntities.size());
        System.out.println("Size of sdocSubscription_orderdoc_entities hashset " + sdocSubscription_orderdoc_entities.size());
        //differentEntities.forEach(entity -> System.out.println("differentEntities entities " + entity));
        similarEntities.forEach(entity -> System.out.println("similarEntities entities " + entity));

        List<String> commonEntities = preorder_entties.stream()
                .filter(entity -> !gdsAlc_entties.contains(entity))
                .collect(Collectors.toList());
        System.out.println("Common entities in total " + commonEntities.size());
        commonEntities.forEach(entity -> System.out.println("Uncommon entities " + entity));
        differentEntities.removeAll(gdsAlc_entties);
        System.out.println("The new entities to be added in gdsALc order doc " + differentEntities.size());
        differentEntities.forEach(entity -> System.out.println("differentEntities entities after gdsAlc_entties removed  " + entity));
    }

}
