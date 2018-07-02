/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.Observer;


/**
 *This method implements the observer,subject and cloneable
 * @author annse
 */
public class Node implements ObserverI,SubjectI,Cloneable{
    
    public ArrayList<String> courselist=null;
    public int bno;
    public String coursename;
    //String course[]= new String[10000];
    public Node lchild;
    public Node rchild;
    public ArrayList<Node> reglist=new ArrayList<Node>();
    /**
     * Creating a clone object
     * @return
     * @throws CloneNotSupportedException 
     */
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    /**
     * Initializing the Node
     * @param bnumber
     * @param course 
     */
    public Node(int bnumber, String course){
        bno=bnumber;
        coursename=course;
        courselist=new ArrayList<String>();
        courselist.add(course);
    }
    /**
     * This is used to display the course
     * @return 
     */
    public String displaycourse(){
        String cvalue="";
        for(int i=0;i<courselist.size();i++)
        {
          cvalue=cvalue+courselist.get(i);   
        }
        return cvalue;
    }
    
    /**
     * This is used to register the observer
     * @param r 
     */
    
    @Override
    public void registerobserver(ObserverI r){
        
        reglist.add((Node) r);
        
    }
    /**
     * This is used to delete the observer
     * @param d 
     */
    @Override
    public void deleteobserver(ObserverI d){
        reglist.remove(d);
    }
    /**
     * This updates all the node values 
     * @param n
     * @param bnumber
     * @param course 
     */
    @Override
    public void update(Node n, int bnumber, String course){
        
        n.courselist.remove(course);
        
    }
    
/**
     * This method is used to notify all the observer
     * @param n
     * @param bnumber
     * @param course 
     */    
    @Override
   public void notifyallobservers(Node n, int bnumber, String course){
       for(int i=0;i<reglist.size();i++)
           reglist.get(i).update(n, bnumber, course);
   }
     
}
