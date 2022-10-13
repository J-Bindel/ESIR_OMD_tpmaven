package fr.esir.omd.ci.tpmaven;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    /**
     * Test de la fonction multiplie de App
     * 2 - : Test 2*3
     */
    @Test
    public void multiplieBy3() {
    	App app = new App (2);
    	int test = app.multiplie(3);
    	int oracle = 6;
    	assertTrue(test == oracle);
    }
   
   	/**
   	 * Test de la fonction multiplie de App
     *  1 - : test avec 1
     */
    @Test
    public void multiplieBy1 () {
    	App app = new App (2);
    	int test = app.multiplie(1);
    	int oracle = 2; 
    	assertTrue (test == oracle);
    }
    
    
   /**
    * Test de la fonction statique max de App
    */
    @Test
    public void maxStatic () {
    	int test = App.max(2, 3);
    	int oracle = 3;
    	assertTrue (test == oracle);
    }
    
}
