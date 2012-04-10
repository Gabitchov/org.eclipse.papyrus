/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.internal.xml;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author jliu jin.liu@soyatec.com
 */
public class XDataHandler extends DefaultHandler implements ContentHandler {

	private boolean namespaceBegin = false;

	private String currentNamespace;

	private String currentNamespaceUri;

	private StringBuilder out;

	private boolean started;

	public XDataHandler(StringBuilder out) {
		this.out = out;
	}

	public void startPrefixMapping(String prefix, String uri) {
		namespaceBegin = true;
		currentNamespace = prefix;
		currentNamespaceUri = uri;
	}

	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
		if(started) {
			out.append("<" + qName);
			if(namespaceBegin) {
				out.append(" xmlns:" + currentNamespace + "=\"" + currentNamespaceUri + "\"");
				namespaceBegin = false;
			}
			for(int i = 0; i < atts.getLength(); i++) {
				out.append(" " + atts.getQName(i) + "=\"" + atts.getValue(i) + "\"");
			}
			out.append(">");
		}
		if(localName.equalsIgnoreCase("xdata")) {
			started = true;
		}
	}

	public void endElement(String namespaceURI, String localName, String qName) {
		if(localName.equalsIgnoreCase("xdata")) {
			started = false;
		}
		if(started) {
			out.append("</" + qName + ">");
		}
	}

	public void characters(char[] ch, int start, int length) {
		if(started) {
			for(int i = start; i < start + length; i++) {
				out.append(ch[i]);
			}
		}
	}

	public void ignorableWhitespace(char[] ch, int start, int length) {
		if(started) {
			for(int i = start; i < start + length; i++) {
				out.append(ch[i]);
			}
		}
	}

	public void processingInstruction(String target, String data) {
		if(started) {
			out.append("<?" + target + " " + data + "?>");
		}
	}

	public void skippedEntity(String name) {
		if(started) {
			out.append("&" + name + ";");
		}
	}
}
