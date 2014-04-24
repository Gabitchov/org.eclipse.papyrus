/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.tests.parser;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.papyrus.junit.utils.classification.ClassificationRunner;
import org.eclipse.papyrus.uml.diagram.common.figure.node.HTMLCornerBentFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Test Case for the class {@link HTMLCornerBentFigure}
 */
@RunWith(ClassificationRunner.class)
public class HTMLCornerBentFigureTestCase extends HTMLCornerBentFigure {

	public final String TEST_CASE_1 = "not a html text";

	public final String TEST_CASE_1_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : not a html text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";

	public final String TEST_CASE_2 = "text <strong>strong</strong> text";

	public final String TEST_CASE_2_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : strong; Font : name=Arial; size=8; bold=true; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text :  text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";

	public final String TEST_CASE_3 = "text <u>underline</u> text";

	public final String TEST_CASE_3_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : underline; Font : name=Arial; size=8; bold=false; italic=false; underline= true}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text :  text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";

	public final String TEST_CASE_4 = "text <strong><em><u>bold-underline</u></em></strong> text";

	public final String TEST_CASE_4_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : bold-underline; Font : name=Arial; size=8; bold=true; italic=true; underline= true}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text :  text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";;

	public final String TEST_CASE_5 = "text <p>new paragraph</p> text";

	public final String TEST_CASE_5_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.draw2d.text.BlockFlow]\n" + "      [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : new paragraph; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text :  text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";

	public final String TEST_CASE_6 = "text <p>1st paragraph</p><p>2nd paragraph</p>";

	public final String TEST_CASE_6_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.draw2d.text.BlockFlow]\n" + "      [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : 1st paragraph; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.draw2d.text.BlockFlow]\n" + "      [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : 2nd paragraph; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";

	public final String TEST_CASE_7 = "text <p class=\"codeSample\">code sample</p> text";

	public final String TEST_CASE_7_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.draw2d.text.BlockFlow]\n" + "      [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : code sample; Font : name=Lucida Console; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text :  text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";

	public final String TEST_CASE_8 = "text <p class=\"quote\">quote</p> text";

	public final String TEST_CASE_8_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.draw2d.text.BlockFlow]\n" + "      [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : quote; Font : name=Monotype Corsiva; size=10; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text :  text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";

	public final String TEST_CASE_9 = "text <font face=\"Times New Roman\">specific font</font> text";

	public final String TEST_CASE_9_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : specific font; Font : name=Times New Roman; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text :  text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";

	public final String TEST_CASE_10 = "text <font size=\"6\">specific font size</font> text";

	public final String TEST_CASE_10_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : specific font size; Font : name=Arial; size=16; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text :  text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";

	public final String TEST_CASE_11 = "text <font face=\"Lucida Console\" size=\"5\">specific font size/kind</font> text";

	public final String TEST_CASE_11_EXPECTED = "[org.eclipse.draw2d.text.FlowPage]\n" + "  [org.eclipse.draw2d.text.BlockFlow]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : text ; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text : specific font size/kind; Font : name=Lucida Console; size=14; bold=false; italic=false; underline= false}]\n" + "    [org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx {Text :  text; Font : name=Arial; size=8; bold=false; italic=false; underline= false}]\n";


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText1() {
		testGenerateBlockForText("No html test", TEST_CASE_1, TEST_CASE_1_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText2() {
		testGenerateBlockForText("test for strong text", TEST_CASE_2, TEST_CASE_2_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText3() {
		testGenerateBlockForText("test for underlined text", TEST_CASE_3, TEST_CASE_3_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText4() {
		testGenerateBlockForText("test for emphasised text", TEST_CASE_4, TEST_CASE_4_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText5() {
		testGenerateBlockForText("test for paragraph", TEST_CASE_5, TEST_CASE_5_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText6() {
		testGenerateBlockForText("test for double paragraph", TEST_CASE_6, TEST_CASE_6_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText7() {
		testGenerateBlockForText("test for code Sample paragraph", TEST_CASE_7, TEST_CASE_7_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText8() {
		testGenerateBlockForText("test for quote paragraph", TEST_CASE_8, TEST_CASE_8_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText9() {
		testGenerateBlockForText("test for font kind change", TEST_CASE_9, TEST_CASE_9_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText10() {
		testGenerateBlockForText("test for font height change", TEST_CASE_10, TEST_CASE_10_EXPECTED);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure#generateBlockForText(java.lang.String)}.
	 */
	@Test
	public void testGenerateBlockForText11() {
		testGenerateBlockForText("test for font height and kind", TEST_CASE_11, TEST_CASE_11_EXPECTED);
	}

	public void testGenerateBlockForText(String testName, String testString, String expectedString) {
		// launch the method that should parse the element
		FlowPage resultPage = new FlowPage();
		this.generateBlockForText(testString, resultPage);
		String resultPageString = generateTree(resultPage, "");

		// test the differences
		org.junit.Assert.assertEquals("\"" + testName + "\" did not match!", expectedString, resultPageString);

	}

	/**
	 * Generates the result string from a Block Flow
	 *
	 * @param expectedResult
	 *        the block flow to display
	 * @return the result string from a Block Flow
	 */
	private String generateTree(Figure flow, String indent) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(indent);
		buffer.append('[');
		buffer.append(flow.getClass().getName());
		if(flow instanceof TextFlowEx) {
			buffer.append(" {");

			buffer.append("Text : ");
			buffer.append(((TextFlowEx)flow).getText());
			buffer.append("; Font : ");
			buffer.append(prettyPrint(((TextFlowEx)flow).getFont()));
			buffer.append("; underline= ");
			buffer.append(((TextFlowEx)flow).isTextUnderlined());
			buffer.append("}");

		}

		buffer.append(']');
		buffer.append('\n');

		for(Object child : flow.getChildren()) {
			// child should always be a figure
			if(child instanceof Figure) {
				buffer.append(generateTree((Figure)child, indent + "  "));
			} else {
				buffer.append(generateTree(child, indent + "  "));
			}
		}
		return buffer.toString();
	}

	/**
	 * @param font
	 * @return
	 */
	private String prettyPrint(Font font) {
		FontData data = font.getFontData()[0];
		StringBuffer buffer = new StringBuffer();
		buffer.append("name=");
		buffer.append(data.getName());
		buffer.append("; size=");
		buffer.append(data.getHeight());
		int style = data.getStyle();
		buffer.append("; bold=");
		buffer.append((style & SWT.BOLD) > 0);
		buffer.append("; italic=");
		buffer.append((style & SWT.ITALIC) > 0);
		return buffer.toString();
	}

	/**
	 * Generates the result string from a Block Flow
	 *
	 * @param expectedResult
	 *        the block flow to display
	 * @return the result string from a Block Flow
	 */
	private String generateTree(Object flow, String indent) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(indent);
		buffer.append('[');
		buffer.append(flow.toString());
		buffer.append(']');
		buffer.append('\n');
		return buffer.toString();
	}

}
