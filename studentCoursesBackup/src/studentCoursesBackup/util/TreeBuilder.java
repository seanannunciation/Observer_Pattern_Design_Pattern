/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Reference-http://www.newthinktank.com/2013/03/binary-tree-in-java/
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

/**
 *This class contains the code to create the node and its clones
 * @author annse
 */
public class TreeBuilder {
    
    public Node root;
    public Node clone1,clone2;
    Results r=new Results("");
    /**
     * This method is used to insert a node in the tree
     * @param bnumber
     * @param course
     * @throws CloneNotSupportedException 
     */
    public void insertNode(int bnumber, String course) throws CloneNotSupportedException
    {
        
        Node insnode=new Node(bnumber,course);
               
        if(root==null)
        {
           root = insnode;
           clone1=(Node) root.clone();
           //clone1=insnode;
           clone2=(Node) root.clone();
           clone2=insnode;
           root.registerobserver(clone1);
           root.registerobserver(clone2);
        }
        Node rootnode=root;
        Node parent;
        Node crnode1=clone1;
        Node crnode2=clone2;
        Node cparent1;
        Node cparent2;
              
        Node checknode=searchnode(root,bnumber);
        
          if(checknode!=null)
            {
                if(checknode.courselist.contains(course)){}
                else
                    checknode.courselist.add(course);
            }
          
                                
        else
        {
            
 
            while(true)
            {
                parent=rootnode;
                cparent1=crnode1;
                cparent2=crnode2;
                
                if(bnumber<rootnode.bno)
                {
                    Node clone3=(Node) rootnode.clone();
                    Node clone4=(Node) rootnode.clone();

                     
                    rootnode=rootnode.lchild;
                    crnode1=crnode1.lchild;
                    crnode2=crnode2.lchild;
                    clone1.registerobserver(clone3);
                    clone2.registerobserver(clone4);
                  
                    if(rootnode==null)
                    {
                        parent.lchild=insnode;
                        cparent1.lchild=insnode;
                        cparent2.lchild=insnode;
                        return;
                    } 

                }
                else{
                    Node clone5=(Node) rootnode.clone();
                    Node clone6=(Node) rootnode.clone();

                    rootnode=rootnode.rchild;
                    crnode1=crnode1.rchild;
                    crnode2=crnode2.rchild;

                    //clone5=clone5.rchild;
                    //clone6=clone6.rchild;
                    clone1.registerobserver(clone5);
                    clone2.registerobserver(clone6);
                    
                    if(rootnode==null)
                    {
                        parent.rchild=insnode;
                        cparent1.rchild=insnode;
                        cparent2.rchild=insnode;
                        return;
                    }
                                      
                   
                }
            }
                       
        }
        
          }
    
    
      
       
    /**
     * This method is used to delete a node
     * @param bnumber
     * @param course 
     */   
   
    
    
    public void deletenode(int bnumber, String course){
        
        Node delnode=searchnode(root,bnumber);
        
        if(delnode!=null){
                delnode.courselist.remove(course);  
        }
          
        
    }
    
    
    /**
     * This method is used to to display the root node and the clone node values
     * @param rootnode
     * @param r 
     */
    public void display(Node rootnode, Results r)
    {
        //String coursedisplay=rootnode.displaycourse();
        if(rootnode!=null)
        {
            display(rootnode.lchild,r);
            String coursedisplay=rootnode.displaycourse();
            //System.out.println(rootnode.bno+":"+coursedisplay);
            r.storeNewResult(rootnode.bno+":"+coursedisplay);    
            //r.storeNewResult(rootnode.bno+":"+coursedisplay); 
            display(rootnode.rchild,r);
            
        }
        
    }
    
      
    /**
     * This method is used to search a particular node
     * @param root
     * @param bnumber
     * @return 
     */
    
    
    public Node searchnode(Node root,int bnumber){
        
        
        Node rootnode=root;
               
        while(rootnode.bno!=bnumber)
        {
            if(bnumber<rootnode.bno)
            {
                rootnode=rootnode.lchild;
            }
            else
            {
                rootnode=rootnode.rchild;
                
            }
            if(rootnode==null)
            return null;
        }
        return rootnode;
            
        }
    }
    
    
    

