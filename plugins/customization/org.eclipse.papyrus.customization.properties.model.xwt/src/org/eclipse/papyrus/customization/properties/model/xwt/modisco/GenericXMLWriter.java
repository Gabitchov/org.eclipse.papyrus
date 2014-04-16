/**
 * *******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *     Fabien Giquel (Mia-Software) - initial API and implementation
 * *******************************************************************************
 *
 */
package org.eclipse.papyrus.customization.properties.model.xwt.modisco;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Attribute;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.CDATA;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Comment;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Element;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Namespace;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Node;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.ProcessingInstruction;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Text;

/**
 *
 * A XML writer dedicated to MoDisco Generic XML models.
 *
 */
public class GenericXMLWriter extends PrintWriter {

	protected static final String XML_VERSION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"; //$NON-NLS-1$

	private static final int STRING_BUFFER_OFFSET = 10;

	/**
	 * The constructor wraps an outputStream.
	 *
	 * @param output
	 * @throws UnsupportedEncodingException
	 */
	public GenericXMLWriter(final OutputStream output) throws UnsupportedEncodingException {
		super(new OutputStreamWriter(output, "UTF8")); //$NON-NLS-1$
		println(GenericXMLWriter.XML_VERSION);
	}

	/**
	 * Serializes the element and its sub-elements.
	 *
	 * @param element
	 */
	public final void serialize(final Element element) {
		startTag(element);

		if(element.getChildren() != null) {
			for(Node child : element.getChildren()) {
				if(child instanceof Element) {
					serialize((Element)child);
				} else if(child instanceof CDATA) {
					String text = ((CDATA)child).getName();
					print("<![CDATA[" + text + "]]>"); //$NON-NLS-1$ //$NON-NLS-2$
				} else if(child instanceof Text) {
					String text = ((Text)child).getName();
					print(GenericXMLWriter.getEscaped(text));
				} else if(child instanceof Comment) {
					String text = "<!--" + ((Comment)child).getName() + "-->"; //$NON-NLS-1$ //$NON-NLS-2$
					print(text);
				} else if(child instanceof ProcessingInstruction) {
					printPI(((ProcessingInstruction)child));
				}
			}
		}

		endTag(element);
	}

	private void startTag(final Element element) {
		if(element instanceof Root) {
			Root root = (Root)element;
			if(root.getDtd() != null) {
				printDTD(root.getDtd());
			}
			if(root.getLeadingPIs() != null) {
				for(ProcessingInstruction pi : root.getLeadingPIs()) {
					printPI(pi);
					println();
				}
			}
		}
		print("<"); //$NON-NLS-1$
		print(element.getName());
		if(element instanceof Root) {
			Root root = (Root)element;
			if(root.getNamespaces() != null) {
				for(Namespace ns : root.getNamespaces()) {
					if(ns.getName().length() > 0) {
						printAttribute(GenericXMLHandler.XMLNS + ":" + ns.getName(), //$NON-NLS-1$
							ns.getValue());
					} else {
						printAttribute(GenericXMLHandler.XMLNS, ns.getValue());
					}
				}
			}
		}
		if(element.getChildren() != null) {
			for(Node child : element.getChildren()) {
				if(child instanceof Attribute) {
					Attribute attr = (Attribute)child;
					printAttribute(attr.getName(), attr.getValue());
				}
			}
		}
		print(">"); //$NON-NLS-1$
	}

	private void endTag(final Element element) {
		print("</" + element.getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private void printAttribute(final String key, final String value) {
		print(" "); //$NON-NLS-1$
		print(key);
		print("=\""); //$NON-NLS-1$
		print(GenericXMLWriter.getEscaped(value));
		print("\""); //$NON-NLS-1$
	}

	private void printDTD(final DocumentTypeDeclaration dtd) {
		print("\n<!DOCTYPE "); //$NON-NLS-1$
		print(dtd.getName());
		print("\n\t\""); //$NON-NLS-1$
		print(dtd.getPublicID());
		print("\"\n\t\""); //$NON-NLS-1$
		print(dtd.getSystemID());
		print("\">"); //$NON-NLS-1$
	}

	private void printPI(final ProcessingInstruction pi) {
		print("<?"); //$NON-NLS-1$
		print(pi.getName());
		print(" "); //$NON-NLS-1$
		print(pi.getData());
		print("?>"); //$NON-NLS-1$
	}

	private static void appendEscapedChar(final StringBuffer buffer, final char c) {
		String replacement = GenericXMLWriter.getReplacement(c);
		if(replacement != null) {
			buffer.append('&');
			buffer.append(replacement);
			buffer.append(';');
		} else {
			buffer.append(c);
		}
	}

	private static String getEscaped(final String s) {
		StringBuffer result = new StringBuffer(s.length() + GenericXMLWriter.STRING_BUFFER_OFFSET);
		for(int i = 0; i < s.length(); ++i) {
			GenericXMLWriter.appendEscapedChar(result, s.charAt(i));
		}
		return result.toString();
	}

	private static String getReplacement(final char c) {
		// Encode special XML characters into the equivalent character
		// references.
		// These five are defined by default for all XML documents.
		switch(c) {
		case '<':
			return "lt"; //$NON-NLS-1$
		case '>':
			return "gt"; //$NON-NLS-1$
		case '"':
			return "quot"; //$NON-NLS-1$
		case '\'':
			return "apos"; //$NON-NLS-1$
		case '&':
			return "amp"; //$NON-NLS-1$
		default:
			return null;
		}
	}

}
