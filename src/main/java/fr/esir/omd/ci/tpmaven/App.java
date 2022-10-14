package fr.esir.omd.ci.tpmaven;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;

/**
 *  Classe réalisant des actions arithmétiques
 *  	Détermine aussi le max entre this.opd_1 et un autre entier
 */

public class App 
{
	
	private int opd_1;
	private int opd_2;
	
	
	/**
	 * @param opd_1 : entier pivot de cette classe
	 */
	public App(int opd_1) {
		this.opd_1 = opd_1;
	}

	 /**
	 * @return the opd_1
	 */
	public int getOpd_1() {
		return opd_1;
	}

	/**
	 * @param opd_1 the opd_1 to set
	 */
	public void setOpd_1(int opd_1) {
		this.opd_1 = opd_1;
	}
	
	/**
	 * Implémentation de l'addition
	 * @param b
	 * @return : this.opd_1 + b
	 */
	public int add(int b) {
		return this.opd_1+b;
	}
	
	/**
	 * Implémentation de la multiplication
	 * @param multiplicator
	 */
	public int multiplie(int multiplicator) {
    	if (multiplicator == 0) {
    		return 0;
    	}
    	int i = 1 ;
    	while (i < multiplicator) {
    		this.opd_1 +=this.opd_1;
    		++i;
    	}
    	return this.opd_1;
    }
	
	/**
	 * Implémentation de la puissance
	 * @param exponent
	 * @return this.x power exponent
	 */
	public int pow (int exponent) {
		if (exponent == 0) {
			return 1 ;
		}
		int i = 0;
		while (i < exponent) {
			this.opd_1 *= this.opd_1;
			++i;
		}
		return this.opd_1;
	}
	
	/**
	 * Implémente la fonction max 
	 * @param y : entier à comparer 
	 * @return : this.x si x > y, y sinon
	 */
	public int max (int y) {
    	if (this.opd_1 > y) {
    		return this.opd_1;
    	}
    	return y;
    }
	
	/**
     *  Version flottante de max
     * 		fonctionne par le sous-typage entier --> double
     * @param y : double à tester 
     * @return : x si x > y, y sinon
     */
    public double max (double y) {
    	if (this.opd_1 > y) {
    		return this.opd_1;
    	}
    	return y;
    }
	
	/**
	 * Version statique de max
	 * @param x : premier entier à tester
	 * @param x : deuxième entier à tester
	 * @return : x si x > y, y sinon
	 */
    public static int max (int x, int y) {
    	if (x > y) {
    		return x;
    	}
    	return y;
    }
    
    /**
     * CPD : détection ? 
     */
    static Font catFont = null;
    static Font subFont = null;
    static void addContent(Document document) throws DocumentException {
		Anchor anchor = new Anchor("First Chapter", catFont);
        anchor.setName("First Chapter");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph("Subcategory 1", subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Hello"));

        subPara = new Paragraph("Subcategory 2", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Paragraph 1"));
        subCatPart.add(new Paragraph("Paragraph 2"));
        subCatPart.add(new Paragraph("Paragraph 3"));

        // add a list
        createList(subCatPart);
        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 5);
        subCatPart.add(paragraph);

        // add a table
        createTable(subCatPart);

        // now add all this to the document
        document.add(catPart);

        // Next section
        anchor = new Anchor("Second Chapter", catFont);
        anchor.setName("Second Chapter");

        // Second parameter is the number of the chapter
        catPart = new Chapter(new Paragraph(anchor), 1);

        subPara = new Paragraph("Subcategory", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("This is a very important message"));

        // now add all this to the document
        document.add(catPart);

    }
    
    private static void createTable(Section subCatPart) {
		// TODO Auto-generated method stub
		
	}

	private static void addEmptyLine(Paragraph paragraph, int i) {
		// TODO Auto-generated method stub
		
	}

	private static void createList(Section subCatPart) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Test : détection des boucles infinies ?
     * @return
     */
    public int inc() {
    	while (true) {
    		++this.opd_1;
    	}
    	//return this.opd_1;
    }

    /**
     * Test : détection de stackOverFlow ?
     * @param y à incrémenter 
     * @return y+1
     */
    public static int stackOverFlow(int y) {
    	if (false) {
    		return y;
    	}
    	return stackOverFlow(y+1);
    }
    
    /**
     * Test : détecte les conditions contradictoires ?
     * @param x
     * @param y
     * @return
     */
    public static int contradictiveStatement(int x, int y) {
    	if(x==y) {
    		if(y>x) {
    			return x;
    		}
    	}
    	return y;
    }
    
    /**
     * Test : détecte les conditions contradictoires ?
     * @param x
     * @param y
     * @return
     */
    public static int interweavingStatement(int x, int y) {
    	if(x==x) {
    		if(x == x) {
    			return x;
    		}
    	}
    	return y;
    }
    
    private int min() {
    	if(this.opd_1<this.opd_2 ) {
    		return this.opd_1;
    	}
    	return this.opd_2;
    }
    
    public static void main (String [] arg) {
    	App app = new App (2);
    	int mul2By3 = app.multiplie(3);
    	System.out.println(mul2By3);
    }
    
}
