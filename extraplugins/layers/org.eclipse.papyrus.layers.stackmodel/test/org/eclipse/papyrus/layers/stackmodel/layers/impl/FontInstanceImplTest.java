/**
 * 
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import static org.junit.Assert.*;

import org.eclipse.papyrus.layers.stackmodel.layers.FontInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author dumoulin
 *
 */
public class FontInstanceImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.FontInstanceImpl#setValueFromString(java.lang.String)}.
	 */
	@Test
	public void testSetValueFromString() {
		FontInstance instance = LayersFactory.eINSTANCE.createFontInstance();
		
		instance.setValueFromString("MySegoe UI, 111, 123, false"); // "FontName, FontHeight, FontColor, Bold"	
//		instance.setValueFromString("Segoe UI, 9, 0, false"); // "FontName, FontHeight, FontColor, Bold"	
		
		// Check values
		assertEquals("name", "MySegoe UI", instance.getFontName());
		assertEquals("heigt", 111, instance.getFontHeigh());
		assertEquals("color", 123, instance.getFontColor());
		assertEquals("bold", false, instance.isBold());
		
		instance.setValueFromString("MySegoe UI, 111, 123, true"); // "FontName, FontHeight, FontColor, Bold"	
		assertEquals("bold", true, instance.isBold());

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.FontInstanceImpl#setValueFromInstance(org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance)}.
	 */
	@Test
	@Ignore
	public void testSetValueFromInstance() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.FontInstanceImpl#FontInstanceImpl()}.
	 */
	@Test
	public void testFontInstanceImpl() {
		FontInstance instance = LayersFactory.eINSTANCE.createFontInstance();
		
		assertNotNull("object created", instance);
	}

}
