/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *This method is used to read the file and store the values
 * @author annse
 */
public class FileProcessor {
    
    private int count=0;
    public ArrayList<String> list;
    private String filename="";
    String line;
    FileReader fr;
    BufferedReader br;
/**
     * This method is used to read the input file
     * @param Filename 
     */
    public FileProcessor(String Filename)
    {
        list=new ArrayList<String>();
        try
        {
        fr = new FileReader(Filename);
        br =new BufferedReader(fr);
         while ((line=br.readLine())!=null)
		{
                    list.add(line);
		} 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
/**
     * This method is used to get the line values
     * @return 
     */    
    public String readLine() 
    {
        String lineread=null;
        try
        {
	lineread=list.get(count);
        
        count++;
        //return lineread;

	}
        catch(Exception e)
    {
        e.printStackTrace();
    }
        //return "";
        return lineread;
    }
    
}
    

