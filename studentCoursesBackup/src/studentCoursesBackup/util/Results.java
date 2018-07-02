/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *This class implements the results 
 * @author annse
 */
public class Results implements FileDisplayInterface,StdoutDisplayInterface{
    
    private String outputfile1;
    ArrayList<String> resultvalues=new ArrayList<String>();
    /**
     * This method is used to write values to the file
     * @param s 
     */
    @Override
    public void writeToFile(String s) {
        
        Writer filewrite=null;
        try {
            filewrite=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfile1),"utf-8"));

            //filewrite.write(outputfile1);
            
            for(int j=0;j<resultvalues.size();j++)
            {
                filewrite.write(resultvalues.get(j)+"\n");
            }
            filewrite.flush();
            }
        catch(IOException e)
        {
            System.out.println("Error in writing to File");
        }
//        finally{
//            try(filewrite.close();)
//                catch(Exception e)
//                        {
//                        
//                        }
//        }
        
        
    }
    /**
     * This is a constructor for Results
     * @param file 
     */
    public Results(String file)
    {
        this.outputfile1=file;
    }
    /**
     * This method is used to store the results in the array
     * @param result 
     */
    public void storeNewResult(String result)
    {
        this.resultvalues.add(result);
    }
     /**
     * This method is used to write to stdout
     * @param s 
     */
    
    @Override
    public void writeToStdout(String s){
        //String str=new String[10];
        resultvalues.add(s);
        for(int i=0;i<resultvalues.size();i++)
        {
            //str[i]=testvalues.get(i);
            //System.out.println(resultvalues.get(i));
        }
        
        
    }
    
}
