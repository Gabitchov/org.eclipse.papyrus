/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.BlockFlow;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.papyrus.uml.diagram.common.parser.HTMLCleaner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Corner bend figure able to display styled text formatted in html
 */
public class HTMLCornerBentFigure extends CornerBentFigure implements ILabelFigure, IMultilineEditableFigure {

	/** indicates if the figure should use local coordinates or not */
	protected boolean useLocalCoordinates = false;

	/** background color for this figure */
	static final Color THIS_BACK = new Color(null, 248, 249, 214);

	/** font used by default by this figure */
	static final Font FCORNERBENTCONTENTLABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.NORMAL);

	/** key for the font style, corresponding to the type of font */
	private static final String FONT_NAME = "face";

	/** key for the font style, corresponding to the type of font */
	private static final String FONT_SIZE = "size";

	/** main flow page */
	protected FlowPage page;

	/** properties stack to store which format to apply */
	protected Stack<Styles> textProperties = new Stack<Styles>();

	/** font used for the figure */
	private FontData currentFontData;

	private String text = ""; //Used as the default text (instead of null)

	/**
	 * set of font datas used by this comment. It will be cleaned juste after
	 * the creation of the comment
	 */
	private Set<FontData> cachedFontDatas = new HashSet<FontData>();

	/**
	 * Creates a new HTMLCornerBentFigure.
	 */
	public HTMLCornerBentFigure() {
		super();
		this.setBackgroundColor(THIS_BACK);
		createContents();

	}

	/**
	 * return the label thath contains the icon.
	 * 
	 * @return the label that contains the icon
	 */
	public Label getIconLabel() {
		return this.iconLabel;
	}

	/**
	 * Generates the basic contents for this figure
	 */
	protected void createContents() {
		// simply creates a Flow page, that will contains BlockFlows
		// representing the html content
		page = new FlowPage();
		page.setForegroundColor(getForegroundColor());
		this.add(page);
	}

	/**
	 * @see org.eclipse.draw2d.Figure#useLocalCoordinates()
	 * 
	 * @return <code>true</code> if this Figure uses local coordinates
	 */
	@Override
	protected boolean useLocalCoordinates() {
		return useLocalCoordinates;
	}

	/**
	 * Returns the current instance of this class
	 * 
	 * @return the current instance of this class
	 */
	public HTMLCornerBentFigure getCornerBentFigure() {
		return this;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getIcon()
	 * 
	 * @return
	 */

	public Image getIcon() {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getText()
	 * 
	 * @return
	 */

	public String getText() {
		return text;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setIcon(org.eclipse.swt.graphics.Image)
	 * 
	 * @param icon
	 */

	public void setIcon(Image icon) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setText(java.lang.String)
	 * 
	 * @param text
	 */

	public void setText(String text) {
		if(equals(text, this.text)) {
			return;
		}

		this.text = text;

		// remove all children from page.
		page.removeAll();

		// init the first font data
		currentFontData = new FontData("Wingdings", 8, SWT.NORMAL);

		// generates new ones
		generateBlockForText(text, page);
	}

	private static boolean equals(String s1, String s2) {
		if(s1 == null && s2 == null) {
			return true;
		}

		if(s1 != null) {
			return s1.equals(s2);
		} else {
			return s2.equals(s1);
		}
	}

	/**
	 * Generates block list for the given text, and adds it to the root flow
	 * page
	 * 
	 * @param text
	 *        the string to display
	 */
	protected void generateBlockForText(String text, FlowPage page) {
		// parse the HMTL text and transforms it into a tree. "Body" tags
		// enforce the character chain to be a valid xml chain
		NodeList nodeList = generateNodeList("<body>" + text + "</body>");

		// generate blocks from this list and adds it to the flow page children
		if(nodeList.getLength() > 0) {
			generateBlocksFromNodeList(nodeList, page);
		} else {
			// problem during parsing
			// return only one text flow with the content of the text
			TextFlowEx textFlow = new TextFlowEx(text);
			page.add(textFlow);
		}

	}

	/**
	 * Builds the structure and content of block flows for a given list of nodes
	 * 
	 * @param nodeList
	 *        the list of nodes from which to generates the blockflows
	 */
	protected void generateBlocksFromNodeList(NodeList nodeList, BlockFlow parentFlow) {
		// for each element in the list, generates the corresponding blocks
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			String nodeName = node.getNodeName();

			short nodeType = node.getNodeType();
			if(nodeType == Node.TEXT_NODE) {
				generateTextFromTextNode(node, parentFlow);
			} else {
				switch(HTMLTags.valueOf(nodeName)) {
				case body: // main tag for the comment body
					// create a block for the body
					generateBlocksFromBodyNode(node, parentFlow);
					break;
				case h3:
					generateBlocksFromH3Node(node, parentFlow);
					break;
				case h4: // sub section heading
					generateBlocksFromH4Node(node, parentFlow);
					break;
				case h5: // sub sub section heading
					generateBlocksFromH5Node(node, parentFlow);
					break;
				case strong: // bold character
					generateBlocksFromStrongNode(node, parentFlow);
					break;
				case em: // italic
					generateBlocksFromItalicNode(node, parentFlow);
					break;
				case u: // underline
					generateBlocksFromUnderlineNode(node, parentFlow);
					break;
				case sub: // subscript
					break;
				case sup: // superscript
					break;
				case blockquote: // indent left or right
					break;
				case table: // table
					break;
				case p: // paragraph
					generateBlocksFromParagraphNode(node, parentFlow);
					break;
				case br:
					generateBlocksFromBRNode(node, parentFlow);
					break;
				case font:
					generateBlocksForFontNode(node, parentFlow);
				default:
					break;
				}
			}
		}

	}

	/**
	 * Generates code from a node representing an underlined text.
	 * 
	 * @param node
	 *        the node from which to generate belowk flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksFromUnderlineNode(Node node, BlockFlow parentFlow) {
		NodeList childrenNodes = node.getChildNodes();

		textProperties.push(Styles.underline);
		generateBlocksFromNodeList(childrenNodes, parentFlow);
		textProperties.pop();
	}

	/**
	 * Generates code from a node representing a text.
	 * 
	 * @param node
	 *        the node from which to generate belowk flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateTextFromTextNode(Node node, BlockFlow parentFlow) {
		// node has type: TEXT_NODE
		String text = HTMLCleaner.cleanHTMLTags(node.getNodeValue());
		TextFlowEx textFlow = new TextFlowEx(text);
		textFlow.setTextUnderline(false);

		boolean italic = false;
		boolean strong = false;
		boolean quote = false;
		boolean codeSample = false;
		String fontName = "Arial";
		int fontSize = 2;

		// calculate the font to apply
		for(Styles style : textProperties) {
			switch(style) {
			case italic:
				italic = true;
				break;
			case strong:
				strong = true;
				break;
			case underline:
				textFlow.setTextUnderline(true);
				break;
			case quote:
				quote = true;
				break;
			case code:
				codeSample = true;
				break;
			case font:
				fontName = (Styles.font.getData().get(FONT_NAME) != null) ? (String)Styles.font.getData().get(FONT_NAME) : "Arial";
				fontSize = (Styles.font.getData().get(FONT_SIZE) != null) ? ((Integer)Styles.font.getData().get(FONT_SIZE)) : 2;
				break;
			default:
				break;
			}

		}

		int style = SWT.NORMAL;

		if(italic) {
			style = style | SWT.ITALIC;
		}

		if(strong) {
			style = style | SWT.BOLD;
		}

		FontData fontData;
		if(codeSample) {
			fontData = new FontData("Lucida Console", 8, style);
		} else if(quote) {
			fontData = new FontData("Monotype Corsiva", 10, style);
			textFlow.setBackgroundColor(DisplayUtils.getDisplay().getSystemColor(SWT.COLOR_RED));
		} else {
			// font size = [1..7] in html, but does not correspond to system
			// size... 2 by default => 8 in real size.
			// so: real size = (html font size)+6
			fontData = new FontData(fontName, 2 * fontSize + 4, style);
		}

		Font font = (Font)JFaceResources.getResources().get(FontDescriptor.createFrom(fontData));
		textFlow.setFont(font);

		parentFlow.add(textFlow);
	}

	/**
	 * Generates code from a node representing a bolded text.
	 * 
	 * @param node
	 *        the node from which to generate block flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksFromStrongNode(Node node, BlockFlow parentFlow) {
		NodeList childrenNodes = node.getChildNodes();

		textProperties.push(Styles.strong);
		generateBlocksFromNodeList(childrenNodes, parentFlow);
		textProperties.pop();
	}

	/**
	 * Generates code from a node representing an italic styled text.
	 * 
	 * @param node
	 *        the node from which to generate belowk flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksFromItalicNode(Node node, BlockFlow parentFlow) {
		NodeList childrenNodes = node.getChildNodes();

		textProperties.push(Styles.italic);
		generateBlocksFromNodeList(childrenNodes, parentFlow);
		textProperties.pop();
	}

	/**
	 * Generates code from a node with new Font.
	 * 
	 * @param node
	 *        the node from which to generate belowk flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksForFontNode(Node node, BlockFlow parentFlow) {
		// retrieves the font to apply
		Node fontNameNode = node.getAttributes().getNamedItem("face");
		Node fontSizeNode = node.getAttributes().getNamedItem("size");
		String oldFont = "";
		int oldSize = 8;

		if(fontNameNode != null) {
			String fontName = fontNameNode.getNodeValue();
			oldFont = (Styles.font.getData().get(FONT_NAME) != null) ? (String)Styles.font.getData().get(FONT_NAME) : "Arial";
			Styles.font.getData().put(FONT_NAME, fontName);
			textProperties.push(Styles.font);
		}
		if(fontSizeNode != null) {
			int fontSize = Integer.parseInt(fontSizeNode.getNodeValue());
			oldSize = (Styles.font.getData().get(FONT_SIZE) != null) ? ((Integer)Styles.font.getData().get(FONT_SIZE)) : 2;
			Styles.font.getData().put(FONT_SIZE, fontSize);
			textProperties.push(Styles.font);
		}

		NodeList childrenNodes = node.getChildNodes();

		generateBlocksFromNodeList(childrenNodes, parentFlow);

		if(fontNameNode != null) {
			Styles.font.getData().put(FONT_NAME, oldFont);
			textProperties.pop();
		}
		if(fontSizeNode != null) {
			Styles.font.getData().put(FONT_SIZE, oldSize);
			textProperties.pop();
		}
	}

	/**
	 * Generates code from a node representing a H3 section (header section).
	 * 
	 * @param node
	 *        the node from which to generate belowk flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksFromH3Node(Node node, BlockFlow parentFlow) {
		BlockFlow blockFlow = new BlockFlow();
		NodeList childrenNodes = node.getChildNodes();

		textProperties.push(Styles.header3);
		generateBlocksFromNodeList(childrenNodes, blockFlow);
		textProperties.pop();
		parentFlow.add(blockFlow);
	}

	/**
	 * Generates code from a node representing a H3 section (header section).
	 * 
	 * @param node
	 *        the node from which to generate belowk flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksFromH4Node(Node node, BlockFlow parentFlow) {
		BlockFlow blockFlow = new BlockFlow();
		NodeList childrenNodes = node.getChildNodes();

		textProperties.push(Styles.header4);
		generateBlocksFromNodeList(childrenNodes, blockFlow);
		textProperties.pop();
		parentFlow.add(blockFlow);
	}

	/**
	 * Generates code from a node representing a H3 section (header section).
	 * 
	 * @param node
	 *        the node from which to generate belowk flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksFromH5Node(Node node, BlockFlow parentFlow) {
		BlockFlow blockFlow = new BlockFlow();
		NodeList childrenNodes = node.getChildNodes();

		textProperties.push(Styles.header5);
		generateBlocksFromNodeList(childrenNodes, blockFlow);
		textProperties.pop();
		parentFlow.add(blockFlow);
	}

	/**
	 * Pretty prints the list of child nodes
	 * 
	 * @param childNodes
	 */
	@SuppressWarnings("unused")
	private void debug(NodeList childNodes) {
		for(int i = 0; i < childNodes.getLength(); i++) {
			System.err.println("[" + i + "] " + childNodes.item(i).getNodeName());
		}
	}

	/**
	 * Generates code from a node representing a body.
	 * 
	 * @param node
	 *        the node from which to generate block flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksFromBodyNode(Node node, BlockFlow parentFlow) {
		BlockFlow blockFlow = new BlockFlow();
		NodeList childrenNodes = node.getChildNodes();

		generateBlocksFromNodeList(childrenNodes, blockFlow);

		parentFlow.add(blockFlow);
	}

	/**
	 * Generates code from a node representing a paragraph.
	 * 
	 * @param node
	 *        the node from which to generate block flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksFromParagraphNode(Node node, BlockFlow parentFlow) {
		BlockFlow blockFlow = new BlockFlow();

		// perhaps a style is associated to the paragraph (class="code sample"
		// for example)
		NamedNodeMap attributes = node.getAttributes();
		Node classNode = attributes.getNamedItem("class");
		boolean hasToPop = false;
		if(classNode != null) {
			String classNodeValue = classNode.getNodeValue();

			if("codeSample".equals(classNodeValue)) {
				hasToPop = true;
				textProperties.push(Styles.code);
			} else if("quote".equals(classNodeValue)) {
				textProperties.push(Styles.quote);
				hasToPop = true;
			}
		}

		NodeList childrenNodes = node.getChildNodes();

		generateBlocksFromNodeList(childrenNodes, blockFlow);

		if(hasToPop) {
			textProperties.pop();
		}
		parentFlow.add(blockFlow);
	}

	/**
	 * Generates code from a node representing a carraige return.
	 * 
	 * @param node
	 *        the node from which to generate block flows
	 * @param parentFlow
	 *        the parent block flow which will contain the block created
	 */
	protected void generateBlocksFromBRNode(Node node, BlockFlow parentFlow) {
		BlockFlow blockFlow = new BlockFlow();
		parentFlow.add(blockFlow);
	}

	/**
	 * Generates a list of nodes from the parse of an html text
	 * 
	 * @param text
	 *        the text to parse
	 * @return the parsed text under the form of a list of nodes
	 */
	protected NodeList generateNodeList(String text) {
		return HTMLCommentParser.parse(text);
	}

	/**
	 * Valid HTML tags enumeration
	 */
	protected enum HTMLTags {

		body(""), // main tag for the comment body
		h3(""), // section heading
		h4(""), // sub section heading
		h5(""), // sub sub section heading
		strong(""), // bold character
		em(""), // italic
		u(""), // underline
		sub(""), // subscript
		sup(""), // superscript
		blockquote(""), // indent left or right
		table(""), // table
		p(""), // paragraph
		br(""), // new line
		font(""); // specific font

		/** additional data for this enum */
		protected String data;

		HTMLTags(String data) {
			this.data = data;
		}

		/**
		 * Sets the data for this enum
		 * 
		 * @param data
		 *        the data to set
		 */
		public void setData(String data) {
			this.data = data;
		}

		/**
		 * Returns the data associated to this enum
		 * 
		 * @return the data associated to this enum
		 */
		public String getData() {
			return data;
		}

	}

	/**
	 * Styles to apply to the text
	 */
	protected enum Styles {
		strong, header3, header4, header5, underline, italic, code, subscript, supscript, quote, font(new HashMap<String, Object>());

		/** additional data */
		private Map<String, Object> data;

		Styles() {
			this.data = null;
		}

		Styles(Map<String, Object> data) {
			this.data = data;
		}

		/**
		 * sets the data associated to this enum
		 * 
		 * @param data
		 *        the data to set
		 */
		public void setData(Map<String, Object> data) {
			this.data = data;
		}

		/**
		 * Returns the data for this enum
		 * 
		 * @return the data for this enum
		 */
		public Map<String, Object> getData() {
			return data;
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure#getEditionLocation()
	 * 
	 */
	public Point getEditionLocation() {
		return getBounds().getTopLeft();
	}
}
