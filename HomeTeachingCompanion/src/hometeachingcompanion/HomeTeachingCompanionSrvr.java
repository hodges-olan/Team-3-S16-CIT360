/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometeachingcompanion;

import Control.FamiliesController;
import Model.Families;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author co075oh
 */
public class HomeTeachingCompanionSrvr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            
            FamiliesController familiesController = new FamiliesController();
            // Test FamiliesController - Add a family
            Families testFamily1 = new Families(1, "Smith", "50 N West Temple", "Salt Lake City", "Utah", "84150");
            familiesController.addFamily(sessionFactory, testFamily1);
            
            // Test FamiliesController - Update a family
            Families testFamily2 = new Families(6, "Yandle", "953 5th Street South", "New Valdosta", "GA", "31601");
            familiesController.updateFamily(sessionFactory, testFamily2);
            
            // Test FamiliesController - Delete a family
            Families testFamily3 = new Families(5, "Smith", "187 5th Avenue", "Yonkers", "NY", "10701");
            familiesController.deleteFamily(sessionFactory, testFamily3);
            
            // Test FamiliesController - View all families
            List families = familiesController.viewFamilies(sessionFactory);
            for (Object family : families) {
                Families currentFamily = (Families) family;
                System.out.println("Family");
                System.out.println("-----------------------");
                System.out.println("Name: " + currentFamily.getFamilyName());
                System.out.println("Address: " + currentFamily.getAddress());
                System.out.println("City: " + currentFamily.getCity());
                System.out.println("State: " + currentFamily.getSt());
                System.out.println("Zip: " + currentFamily.getZip());
                System.out.println("\n");
            }
        }
        
    }
    
}