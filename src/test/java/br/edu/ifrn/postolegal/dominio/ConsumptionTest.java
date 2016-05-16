/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.dominio;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renato
 */
public class ConsumptionTest {
    
    public ConsumptionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of builder method, of class Consumption.
     */
    @Test
    public void testBuilder() {
        System.out.println("builder");
        Consumption.ConsumptionBuilder expResult = null;
        Consumption.ConsumptionBuilder result = Consumption.builder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVehicle method, of class Consumption.
     */
    @Test
    public void testGetVehicle() {
        System.out.println("getVehicle");
        Consumption instance = null;
        Vehicle expResult = null;
        Vehicle result = instance.getVehicle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPaid method, of class Consumption.
     */
    @Test
    public void testGetTotalPaid() {
        System.out.println("getTotalPaid");
        Consumption instance = null;
        float expResult = 0.0F;
        float result = instance.getTotalPaid();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Consumption.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Consumption instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOdometer method, of class Consumption.
     */
    @Test
    public void testGetOdometer() {
        System.out.println("getOdometer");
        Consumption instance = null;
        int expResult = 0;
        int result = instance.getOdometer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class Consumption.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        Consumption instance = null;
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVehicle method, of class Consumption.
     */
    @Test
    public void testSetVehicle() {
        System.out.println("setVehicle");
        Vehicle vehicle = null;
        Consumption instance = null;
        instance.setVehicle(vehicle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalPaid method, of class Consumption.
     */
    @Test
    public void testSetTotalPaid() {
        System.out.println("setTotalPaid");
        float totalPaid = 0.0F;
        Consumption instance = null;
        instance.setTotalPaid(totalPaid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Consumption.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Consumption instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOdometer method, of class Consumption.
     */
    @Test
    public void testSetOdometer() {
        System.out.println("setOdometer");
        int odometer = 0;
        Consumption instance = null;
        instance.setOdometer(odometer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValid method, of class Consumption.
     */
    @Test
    public void testSetValid() {
        System.out.println("setValid");
        boolean valid = false;
        Consumption instance = null;
        instance.setValid(valid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Consumption.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Consumption instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Consumption.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Consumption instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canEqual method, of class Consumption.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        Consumption instance = null;
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Consumption.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Consumption instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
