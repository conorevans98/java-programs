import static org.junit.Assert.*;

import org.junit.Test;

public class EspaceTest {

	@Test
	public void testConstructors() {
		Espace e = new Espace();
		assertEquals("Testing constructor A",10,e.getLargeur());
		assertEquals("Testing constructor A",5,e.getChenilles().length);
		
		e = new Espace(5);
		assertEquals("Testing constructor B",5,e.getLargeur());
		assertEquals("Testing constructor B",5,e.getChenilles().length);
		
		e = new Espace(5,6);
		assertEquals("Testing constructor C",5,e.getLargeur());
		assertEquals("Testing constructor C",6,e.getHauteur());
		assertEquals("Testing constructor C",5,e.getChenilles().length);
		
	}
	
	@Test 
	public void testAddChenille() {
		Espace e = new Espace();
		Chenille ch = new Chenille(e);
		assertEquals("Testing addChenille()",0,e.getNbChenilles());
		e.addChenille(ch);
		assertEquals("Testing addChenille()",1,e.getNbChenilles());
		
		
	}
	
	@Test
	public void testContient() {
		Espace e = new Espace(2,2);
		Case c = new Case(1,1);
		Case c2 = new Case(5,5);
		assertEquals("Testing contient()",true,e.contient(c));
		assertEquals("Testing contient()",false,e.contient(c2));
		
	}
	
	@Test
	public void testCaseOccupee() {
		Espace e = new Espace(2,2);
		Case c = new Case(1,1);
		Chenille ch = new Chenille(e,c,1);
		e.addChenille(ch);
		assertEquals("Testing caseOccupee()",true,e.caseOccupee(c));
		assertEquals("Testing caseOccupee()",false,e.caseOccupee(new Case(1,2)));
		
	}
	
	@Test 
	public void testCaseLibreAuHasard() {
		Espace e = new Espace(2,2);
		Case c = new Case(1,1);
		Chenille ch = new Chenille(e,c,1);
		e.addChenille(ch);
		assertNotEquals("Testing caseLibreAuHasard()",c,e.caseLibreAuHasard());
	}
	
	public void testToString() {
		Espace e = new Espace(2,2);
		String s = ". ." +"\n" + ". .";
		assertEquals("Testing toString()",s,e.toString());
		Case c = new Case(0,0);
		Chenille ch = new Chenille(e,c,2);
		e.addChenille(ch);
		s = "A ." + "\n" + ". .";
		assertEquals("Testing toString()",s,e.toString());
		c = new Case(0,1);
		Chenille ch1 = new Chenille(e,c,2);
		e.addChenille(ch1);
		ch1.avance();
		s = "a B" + "\n" + "A .";
		assertEquals("Testing toString()",s,e.toString());
		
	}
	
	

}
