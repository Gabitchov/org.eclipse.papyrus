/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.tests.parser;

import junit.framework.TestCase;

import org.eclipse.papyrus.uml.diagram.common.parser.HTMLCleaner;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Case n°1 for HTML CLeaner class
 */
public class HTMLCleanerTestCase extends TestCase {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags1() {
		final String test = "This is a simple example (no html).";
		final String expectedResult = "This is a simple example (no html).";
		String result= null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags2() {
		final String test = "<strong>P0_a &lt; nnotateC0</strong>";
		final String expectedResult = "P0_a < nnotateC0";
		String result= null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags3() {
		final String test = "<h3>This is the title</h3><p>This is a part of the body.</p><p>This is the second part of the body.</p><br /><br />";
		final String expectedResult = "This is the title\nThis is a part of the body.\nThis is the second part of the body.\n";
		String result= null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags4() {
		final String test = "<h3>\r\n" + "    Houston\r\n" + "</h3>";
		final String expectedResult = " Houston\n";
		String result= null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags5() {
		final String test = "";
		final String expectedResult = "";
		String result= null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags6() {
		final String test = "\n";
		final String expectedResult = "";
		String result= null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags7() {
		final String test = "&";
		final String expectedResult = "&";
		String result= null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags8() {
		final String test = "Houston & Ariane";
		final String expectedResult = "Houston & Ariane";
		String result= null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags9() {
		final String test = "&<h3>\r\n" + "    Houston\r\n" + "</h3>";
		final String expectedResult = "& Houston\n";
		String result = null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}
	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags10() {
		final String test = "<";
		final String expectedResult = "<";
		String result = null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags11() {
		final String test = "< toto";
		final String expectedResult = "< toto";
		String result = null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}
	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testCleanHTMLTags12() {
		final String test = "< toto >";
		final String expectedResult = "< toto >";
		String result = null;
		try {
			result = HTMLCleaner.removeHTMLTags(HTMLCleaner.preClean(test));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(expectedResult, result);
	}
}
