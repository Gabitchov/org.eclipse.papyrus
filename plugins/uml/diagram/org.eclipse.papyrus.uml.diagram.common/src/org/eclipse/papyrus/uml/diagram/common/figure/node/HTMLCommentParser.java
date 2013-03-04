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
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.parser.HTMLCleaner;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Parser for simple html comments
 */
public class HTMLCommentParser {

	/**
	 * Parse the given text
	 * 
	 * @param text
	 *        the string to parse
	 * 
	 * @return the nodes result of the parsing of the text
	 */
	public static NodeList parse(String text) {
		NodeList nodelist = null;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			String cleandText = HTMLCleaner.preClean(text);
			Document document = documentBuilder.parse(new InputSource(new StringReader(cleandText)));
			nodelist = document.getChildNodes();
		} catch (ParserConfigurationException e) {
			Activator.log.error(e);
			nodelist = new EmptyNodeList();
		} catch (IOException e) {
			Activator.log.error(e);
			nodelist = new EmptyNodeList();
		} catch (SAXException e) {
			// Activator.log.error(e);
			nodelist = new EmptyNodeList();
		}  catch (Exception e) {
			Activator.log.error(e);
			nodelist = new EmptyNodeList();
		}
		return nodelist;
	}

	/**
	 * empty node list implementation
	 */
	public static class EmptyNodeList implements NodeList {

		/**
		 * {@inheritDoc}
		 */
		public int getLength() {
			return 0;
		}

		/**
		 * {@inheritDoc}
		 */
		public Node item(int index) {
			return null;
		}

	}

}
