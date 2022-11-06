package com.code.hibernateOneToOneBi.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernateOneToOneBi.demo2.entity.Instructor;
import com.code.hibernateOneToOneBi.demo2.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate2.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
           
            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int theId = 2;
            InstructorDetail tempInstructorDetail =
                                session.get(InstructorDetail.class, theId);
            // print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            // print the associated instructor
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

            // now let's delete the instructor detail
            System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
            session.delete(tempInstructorDetail);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch(Exception exc) {
            exc.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();

            factory.close();
        }
    }
}
