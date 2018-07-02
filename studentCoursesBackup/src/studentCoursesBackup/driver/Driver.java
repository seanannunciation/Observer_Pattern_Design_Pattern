/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

/**
 *This method is the main which implements and creates the node and its clones
 * @author annse
 */
public class Driver {
    public static void main(String args[]) throws FileNotFoundException, CloneNotSupportedException
    {
        String filename1 =args[0];
        String filename2 =args[1];
        FileReader fr=new FileReader(filename1);
        FileReader fr2=new FileReader(filename2);
        BufferedReader br=new BufferedReader(fr);
        String outputfile1=args[2];
        String outputfile2=args[3];
        String outputfile3=args[4];
        FileProcessor fp1=new FileProcessor(filename1);
        FileProcessor fp2=new FileProcessor(filename2);
        Results r1=new Results(outputfile1);
        Results r2=new Results(outputfile2);
        Results r3=new Results(outputfile3);
        //Node n=new Node();
        TreeBuilder tree=new TreeBuilder();
        for(int i=0;i<fp1.list.size();i++)
        {
            String temp[]=fp1.list.get(i).split(":");
            int bnumber=Integer.parseInt(temp[0]);
            String course=temp[1];
            tree.insertNode(bnumber,course);
        }
        
        for(int i=0;i<fp2.list.size();i++)
        {
            String temp[]=fp2.list.get(i).split(":");
            int bnumber=Integer.parseInt(temp[0]);
            String course=temp[1];
            tree.deletenode(bnumber,course);
        }
               
        tree.display(tree.root,r1);
	r1.writeToFile("");
        tree.display(tree.clone1,r2);
	r2.writeToFile("");
        tree.display(tree.clone2,r3);
	r3.writeToFile("");
       
        
        
    }
    
}
