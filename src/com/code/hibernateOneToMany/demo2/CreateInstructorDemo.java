package com.code.hibernateOneToMany.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernateOneToMany.demo2.entity.Course;
import com.code.hibernateOneToOneBi.demo2.entity.Instructor;
import com.code.hibernateOneToOneBi.demo2.entity.InstructorDetail;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate2.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            
            Instructor tempInstructor =
                        new Instructor("Susan", "Public", "susan@luv2code.com");

            InstructorDetail tempInstructorDetail =
                        new InstructorDetail("http://www.youtube.com", "Video Games");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();
            
            // save the instructor
            //
            // Note: this will ALSO save the details object
            // because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            
            factory.close();
        }
    }
}
