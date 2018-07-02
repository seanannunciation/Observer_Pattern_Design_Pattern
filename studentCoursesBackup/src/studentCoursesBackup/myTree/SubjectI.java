/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.myTree;

/**
 *This interface is used to initialize the methods for registering,deleting and notifying the observers
 * @author annse
 */
public interface SubjectI {
    
    void registerobserver(ObserverI r);
    void deleteobserver(ObserverI d);
    void notifyallobservers(Node n, int bnumber, String course);
    
}
