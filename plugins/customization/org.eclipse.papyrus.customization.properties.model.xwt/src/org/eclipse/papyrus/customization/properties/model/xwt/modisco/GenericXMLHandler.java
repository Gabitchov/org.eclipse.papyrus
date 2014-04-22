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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Attribute;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Comment;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Element;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Namespace;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.ProcessingInstruction;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Text;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.XwtxmlFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

import com.ibm.icu.lang.UCharacter;

/**
 * A handler for reading xml files and instanciating a generic xml model.
 */
public class GenericXMLHandler extends DefaultHandler implements LexicalHandler {

	/**
	 * Prefix for namespace attributes.
	 */
	public static final String XMLNS = "xmlns"; //$NON-NLS-1$

	/** A parameter key for indicating to ignore whitespace in text portions. */
	public static final String OPTION_IGNORE_WHITESPACE = "OPTION_IGNORE_WHITESPACE"; //$NON-NLS-1$

	/**
	 * A parameter key for indicating to minimize the memory size of obtained
	 * model. If set to true : comments are ignored, text portions with only
	 * indentation and line delimiters are ignored.
	 */
	public static final String OPTION_LIGHTWEIGHT_MODEL = "OPTION_LIGHTWEIGHT_MODEL"; //$NON-NLS-1$

	private final Map<String, Object> parameters;

	private final Resource container;

	private Root root;

	private Element current;

	private DocumentTypeDeclaration dtd;

	private boolean nextIsCDATA = false;

	private List<ProcessingInstruction> leadingPIs = null;

	private Boolean ignoreWhiteSpace = null;

	private Boolean lightweightModel = null;

	/**
	 * Constructor for GenericXMLHandler.
	 *
	 * @param resource
	 *        the model container.
	 */
	public GenericXMLHandler(final Resource resource, final Map<String, Object> options) {
		this.container = resource;
		this.parameters = options;
	}

	@Override
	public final void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
		if(this.root == null) {
			this.root = XwtxmlFactory.eINSTANCE.createRoot();
			this.root.setName(qName);
			this.container.getContents().add(this.root);
			this.current = this.root;
			if(this.dtd != null) {
				this.root.setDtd(this.dtd);
			}
			if(this.leadingPIs != null) {
				this.root.getLeadingPIs().addAll(this.leadingPIs);
			}
		} else {
			Element newElement = XwtxmlFactory.eINSTANCE.createElement();
			newElement.setName(qName);

			this.current.getChildren().add(newElement);
			this.current = newElement;
		}

		for(int i = 0; i < attrs.getLength(); i++) {
			String name = attrs.getQName(i);
			if(this.current == this.root && name.startsWith(GenericXMLHandler.XMLNS)) {
				Namespace newNamespace = XwtxmlFactory.eINSTANCE.createNamespace();
				if(name.length() == GenericXMLHandler.XMLNS.length()) {
					newNamespace.setName(""); // xmlns= //$NON-NLS-1$
				} else {
					newNamespace.setName(name.substring(GenericXMLHandler.XMLNS.length() + 1));
					// xmlns:XX=
				}
				newNamespace.setValue(attrs.getValue(i));

				this.root.getNamespaces().add(newNamespace);
			} else {
				Attribute newAttribute = XwtxmlFactory.eINSTANCE.createAttribute();
				newAttribute.setName(name);
				newAttribute.setValue(attrs.getValue(i));

				this.current.getChildren().add(newAttribute);
			}
		}
	}

	@Override
	public final void endElement(final String uri, final String localName, final String qName) throws SAXException {
		this.current = this.current.getParent();
	}

	@Override
	public final void characters(final char[] ch, final int start, final int length) throws SAXException {
		if(this.current != null) {
			boolean hasContent = true;
			if(isLightweightModel()) {
				hasContent = false;
				int index = start;
				while(!hasContent && index < start + length) {
					hasContent = !UCharacter.isWhitespace(ch[index]);
					index++;
				}
			}

			if(hasContent) {
				String text = new String(ch, start, length);
				if(isIgnoreWhitespace()) {
					text = text.trim();
				}

				if(text.length() > 0) {
					Text newElement;
					if(this.nextIsCDATA) {
						newElement = XwtxmlFactory.eINSTANCE.createCDATA();
					} else {
						newElement = XwtxmlFactory.eINSTANCE.createText();
					}
					newElement.setName(text);
					this.current.getChildren().add(newElement);
				}
			}
		}
	}

	@Override
	public final void comment(final char[] ch, final int start, final int length) throws SAXException {
		if(this.current != null && !isLightweightModel()) {
			String text = new String(ch, start, length);

			if(text.length() > 0) {
				Comment newElement = XwtxmlFactory.eINSTANCE.createComment();
				newElement.setName(text);
				this.current.getChildren().add(newElement);
			}
		}
	}

	@Override
	public final void startDTD(final String name, final String publicId, final String systemId) throws SAXException {
		DocumentTypeDeclaration newDtd = XwtxmlFactory.eINSTANCE.createDocumentTypeDeclaration();
		newDtd.setName(name);
		newDtd.setPublicID(publicId);
		newDtd.setSystemID(systemId);
		this.dtd = newDtd;
		if(this.root != null) {
			this.root.setDtd(this.dtd);
		}
	}

	private boolean isIgnoreWhitespace() {
		if(this.ignoreWhiteSpace == null) {
			if(this.parameters != null && this.parameters.get(GenericXMLHandler.OPTION_IGNORE_WHITESPACE) != null) {
				this.ignoreWhiteSpace = (Boolean)this.parameters.get(GenericXMLHandler.OPTION_IGNORE_WHITESPACE);
			} else {
				this.ignoreWhiteSpace = false;
			}
		}

		return this.ignoreWhiteSpace;
	}

	private boolean isLightweightModel() {
		if(this.lightweightModel == null) {
			if(this.parameters != null && this.parameters.get(GenericXMLHandler.OPTION_LIGHTWEIGHT_MODEL) != null) {
				this.lightweightModel = (Boolean)this.parameters.get(GenericXMLHandler.OPTION_LIGHTWEIGHT_MODEL);
			} else {
				this.lightweightModel = false;
			}
		}

		return this.lightweightModel;
	}

	@Override
	public final void endCDATA() throws SAXException {
		this.nextIsCDATA = false;
	}

	@Override
	public final void processingInstruction(final String target, final String data) throws SAXException {
		ProcessingInstruction newElement = XwtxmlFactory.eINSTANCE.createProcessingInstruction();
		newElement.setName(target);
		newElement.setData(data);

		if(this.current != null) {
			this.current.getChildren().add(newElement);
		} else {
			if(this.leadingPIs == null) {
				this.leadingPIs = new ArrayList<ProcessingInstruction>();
			}
			this.leadingPIs.add(newElement);
		}

	}

	@Override
	public void endDTD() throws SAXException {
		// nothing
	}

	@Override
	public void endEntity(final String arg0) throws SAXException {
		// nothing
	}

	@Override
	public final void startCDATA() throws SAXException {
		this.nextIsCDATA = true;
	}

	@Override
	public void startEntity(final String arg0) throws SAXException {
		// nothing
	}

}
