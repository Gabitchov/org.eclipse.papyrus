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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.XWT;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.Locator2;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XAML-DOM handler.
 * 
 * @author yyang
 * @version 1.0
 */
class ElementHandler extends DefaultHandler implements ContentHandler {

	private Stack<StringBuffer> bufferStack = new Stack<StringBuffer>();

	private static final String[] BINDING_PROPERTIES = new String[]{ "path", "validationRule", "converter" };


	/**
	 * Temporary element hierarchy
	 */
	private Stack<DocumentObject> elementStack = new Stack<DocumentObject>();

	private Stack<Integer> elementIndexStack;

	private Stack<Boolean> switchStack;

	private StringBuffer textBuffer = null;

	private Locator locator;

	private boolean ignoreSystemProcession;

	private boolean hasSetDefaultEncoding;

	private ElementManager elementManager;

	private String defaultNamespace;

	private ExtensionParser extensionParser = new ExtensionParser();

	private HashMap<String, String> namespaceMapping = new HashMap<String, String>();

	private boolean needNormalizeName = true;

	/**
	 * Parse the XAML extension Markup: {StaticResource test} {StaticResource RessourceKey=test} {DynamicResource {x:Static
	 * SystemColors.ControlBrushKey}}
	 * 
	 * @author yyang
	 * 
	 */
	private class ExtensionParser {

		private Element root;

		private DocumentObject current;

		public void parse(DocumentObject element, String text) {
			if(root != null) {
				ExtensionParser parser = new ExtensionParser();
				parser.parse(element, text);
				return;
			}

			StringTokenizer stringTokenizer = new StringTokenizer(text, "{}", true);
			String previous = null;
			String nextPrevious = null;
			while(stringTokenizer.hasMoreTokens()) {
				String token = stringTokenizer.nextToken();

				if(previous != null) {
					if(previous.equals("{")) {
						if(token.equals("}")) {
							// escape sequence
							if(stringTokenizer.hasMoreTokens()) {
								handleBlock(stringTokenizer.nextToken(" \t\n\r\f"), false);
							}
						} else {
							startBlock();
						}
					} else if(previous.equals("}")) {
						endBlock();
					} else {
						StringBuilder builder = new StringBuilder();
						builder.append(previous);
						if(token.equals("{")) {
							int level = 1;
							builder.append(token);
							while(stringTokenizer.hasMoreTokens() && level >= 0) {
								String value = stringTokenizer.nextToken();
								if(value.equals("{")) {
									level++;
								} else if(value.equals("}")) {
									level--;
								}
								if(level >= 0) {
									builder.append(value);
								}
							}
						}
						handleBlock(builder.toString(), (nextPrevious == null || !nextPrevious.equals("}")));
					}
				}
				nextPrevious = previous;
				previous = token;
			}
			element.addChild(root);
			root = null;
			current = null;
		}

		protected void startBlock() {
		}

		protected void endBlock() {
			if(current != null) {
				current = current.getParent().getParent();
			}
		}

		protected Element createElement(String token) {
			int index = token.indexOf(':');
			String namespace = null;
			String name = token;
			if(index != -1) {
				String prefix = token.substring(0, index);
				name = token.substring(index + 1);
				namespace = namespaceMapping.get(prefix);
			}
			if(namespace == null) {
				namespace = defaultNamespace;
			}
			Element element = new Element(namespace, name, namespaceMapping);
			element.setId(ElementManager.generateID(name));
			if(current != null) {
				current.addChild(element);
			} else {
				if(root == null) {
					root = element;
				}
			}
			current = element;
			return element;
		}

		protected void handleBlock(String content, boolean newElement) {
			String rootPattern = " \t\n\r\f=,";
			StringTokenizer tokenizer = new StringTokenizer(content, rootPattern, true);
			String attributeName = null;
			String attributeValue = null;
			boolean equals = false;
			Element element = null;
			if(!newElement && current instanceof Element) {
				element = (Element)current;
			}

			boolean skip = false;
			String token = null;
			while(skip || tokenizer.hasMoreTokens()) {
				if(!skip) {
					token = tokenizer.nextToken(rootPattern).trim();
				}
				skip = false;
				if(token.length() == 0) {
					continue;
				}
				if(element == null) {
					element = createElement(token);
				} else {
					if(token.equals("=")) {
						equals = true;
						if("xpath".equalsIgnoreCase(attributeName)) {
							attributeValue = tokenizer.nextToken(",");
						}
						continue;
					}
					if(token.equals(",")) {
						if(attributeName != null) {
							if(attributeValue != null) {
								Attribute attribute = new Attribute(normalizeAttrNamespace(current.getNamespace()), attributeName, ElementManager.generateID(current.getName()));
								if(isExpendedProperty(attributeName) && "Binding".equalsIgnoreCase(element.getName())) {
									attributeValue = expandNamespaces(element, attributeValue);
								}
								handleContent(attribute, attributeValue);
								element.setAttribute(attribute);
								current = attribute;
							} else {
								element.setContent(attributeName);
							}
							attributeName = null;
							attributeValue = null;
							equals = false;
						}
					} else {
						if(attributeName == null) {
							attributeName = token;
						} else {
							StringBuilder builder = new StringBuilder();
							builder.append(token);
							if(token.startsWith("{")) {
								int level = 1;
								while(tokenizer.hasMoreTokens() && level > 0) {
									String value = tokenizer.nextToken("{}");
									if(value.equals("{")) {
										level++;
									} else if(value.equals("}")) {
										level--;
									}
									builder.append(value);
								}
							}
							attributeValue = builder.toString();

							try {
								token = tokenizer.nextToken(rootPattern).trim();
								skip = true;
								continue;
							} catch (NoSuchElementException e) {
							}
						}
					}
				}
				skip = false;
			}

			if(equals) {
				Attribute attribute = new Attribute(normalizeAttrNamespace(current.getNamespace()), attributeName, ElementManager.generateID(current.getName()));
				if(isExpendedProperty(attributeName) && "Binding".equalsIgnoreCase(element.getName())) {
					attributeValue = expandNamespaces(element, attributeValue);
				}

				if(attributeValue != null) {
					handleContent(attribute, attributeValue);
					element.setAttribute(attribute);
				} else {
					element.setAttribute(attribute);
					current = attribute;
				}
			} else if(attributeName != null) {
				int index = attributeName.indexOf(":");
				if(index != -1) {
					element = createElement(attributeName);
					current = current.getParent();
				} else {
					current.setContent(attributeName);
				}
			}
		}
	};

	static boolean isExpendedProperty(String name) {
		// TODO need a generic solution for each property of Binding 
		for(String propertyName : BINDING_PROPERTIES) {
			if(propertyName.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	protected String expandNamespaces(DocumentObject element, String value) {
		if(value.startsWith("{") || (value.indexOf(':') == -1)) {
			return value;
		}
		int length = IConstants.XAML_CLR_NAMESPACE_PROTO.length();
		for(String prefix : namespaceMapping.keySet()) {
			String namespace = namespaceMapping.get(prefix);
			if(namespace.startsWith(IConstants.XAML_CLR_NAMESPACE_PROTO)) {
				String packageName = namespace.substring(length);
				value = value.replace(prefix + ":", packageName + '.');
			}
		}
		return value;
	}

	/**
	 * Default constructor.
	 * 
	 * @param manager
	 *        loader instance.
	 */
	public ElementHandler(ElementManager elementManager) {
		this.ignoreSystemProcession = false;
		this.hasSetDefaultEncoding = false;
		this.elementManager = elementManager;
	}

	/**
	 * Internal constructor.
	 * 
	 * @param loader
	 *        loader instance.
	 * @param parent
	 *        the parent element of loading stream.
	 */
	public ElementHandler(DocumentObject parent, ElementManager elementManager) {
		if(parent != null) {
			elementStack.push(parent);
			bufferStack.push(textBuffer);
		}
		ignoreSystemProcession = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#setDocumentLocator(org.xml.sax.Locator)
	 */
	@Override
	public void setDocumentLocator(Locator locator) {
		this.locator = locator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		elementIndexStack = new Stack<Integer>();
		elementIndexStack.push(0);
		switchStack = new Stack<Boolean>();
		defaultNamespace = IConstants.XWT_NAMESPACE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startPrefixMapping(java.lang.String, java.lang.String)
	 */
	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		if(prefix.length() == 0 && !ignoreSystemProcession) {
			defaultNamespace = uri;
		}
		namespaceMapping.put(prefix, uri);
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		namespaceMapping.remove(prefix);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		elementStack.clear();
		bufferStack.clear();
		switchStack.clear();
		switchStack = null;
		defaultNamespace = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {

		if(!switchStack.isEmpty() && !switchStack.peek()) {
			return;
		}

		String string = new String(arg0, arg1, arg2);
		if(string.length() > 0) {
			if(textBuffer == null) {
				textBuffer = new StringBuffer(string);
			} else {
				textBuffer.append(string);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#skippedEntity(java.lang.String)
	 */
	@Override
	public void skippedEntity(String name) throws SAXException {
		super.skippedEntity(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {

		// Set xml's encoding to default.
		if(!ignoreSystemProcession && !hasSetDefaultEncoding) {
			if(locator instanceof Locator2) {
				Locator2 locator2 = (Locator2)locator;
				String encoding = locator2.getEncoding();
				if(encoding != null && encoding.length() > 0) {
					elementManager.setEncoding(encoding);
				}
			}
			hasSetDefaultEncoding = true;
		}

		uri = normalizeNamespace(uri);

		// If super condition does not allow parse children, ignore it.
		if(!switchStack.isEmpty() && !switchStack.peek()) {
			if(uri.equalsIgnoreCase(IConstants.XWT_NAMESPACE)) {
				if("Switch".equals(localName)) {
					// If children is switch element, than set false to it.
					switchStack.push(false);
				}
			}
			return;
		}

		if(localName.indexOf('.') > 0) {
			preProperty(uri, localName, attrs);
		} else {
			preElement(uri, localName, attrs);
		}

		elementIndexStack.push(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		elementIndexStack.pop();
		if(!elementIndexStack.isEmpty()) {
			int nextIndex = elementIndexStack.pop();
			elementIndexStack.push(nextIndex + 1);
		}

		uri = normalizeNamespace(uri);

		// If super condition does not allow parse children, ignore it.
		if(!switchStack.isEmpty() && !switchStack.peek()) {
			if(uri.equalsIgnoreCase(IConstants.XWT_NAMESPACE)) {
				if("Switch".equals(localName)) {
					switchStack.pop();
				}
			}
			return;
		}

		if(!elementStack.isEmpty()) {
			// remove current node from stack
			DocumentObject element = elementStack.peek();

			if(element instanceof Attribute) {
				postProperty(uri, localName);
			} else {
				postElement(uri, localName);
			}
		}
	}

	private void preElement(String namespace, String name, Attributes attrs) throws SAXException {

		// Process element ID

		namespace = normalizeNamespace(namespace);
		name = normalizeName(name);
		if(name.equalsIgnoreCase("xdata")) {
			needNormalizeName = false;
		}
		// Check the reference element.
		String id = ElementManager.generateID(name);

		// Check the same id elements.
		if(elementManager.hasElement(id)) {
			throw new SAXException(getFormattedMessage("Element already exists: ", id));
		}

		// Process attributes: original, external
		Set<Attribute> attributes = new HashSet<Attribute>();
		for(int i = 0, len = attrs.getLength(); i < len; i++) {
			String attrUri = normalizeAttrNamespace(attrs.getURI(i));
			String attrName = attrs.getLocalName(i);

			Attribute attribute;
			int index = attrName.lastIndexOf('.');
			if(index != -1) {
				String prefix = normalizeName(attrName.substring(0, index));
				String attributeName = (XWT.isXWTNamespace(attrUri) ? normalizeName(attrName.substring(index + 1)) : attrName);

				attribute = new Attribute(attrUri, attributeName, id);
				attribute.setNamePrefix(prefix);
			} else {
				attribute = new Attribute(attrUri, (XWT.isXWTNamespace(attrUri) ? normalizeName(attrName) : attrName), id);
			}
			handleContent(attribute, attrs.getValue(i));
			attributes.add(attribute);
		}

		// Create or reference element.
		Element element = new Element(namespace, name, getIndexPath(), attributes, namespaceMapping);
		element.setId(id);

		// Add current node to stack
		if(!elementStack.isEmpty()) {
			elementStack.peek().addChild(element);
		}

		elementStack.push(element);
		bufferStack.push(textBuffer);
		textBuffer = null;

		// Register to the element registry
		elementManager.preElement(element);
	}

	private void postElement(String namespace, String name) throws SAXException {

		// : The same as postReference : //

		if(!elementStack.isEmpty()) {
			// remove current node from stack
			DocumentObject element = elementStack.pop();

			// Setting element text content
			if(textBuffer != null) {
				String text = textBuffer.toString().trim();
				if(text.length() > 0) {
					handleContent(element, text);
				}
			}
			textBuffer = bufferStack.pop();

			// Post the element registration.
			elementManager.postElement((Element)element);
		}

		if(name.equalsIgnoreCase("xdata")) {
			needNormalizeName = true;
		}
	}

	protected void handleContent(DocumentObject element, String text) {
		if(text.startsWith("{") && text.endsWith("}")) {
			extensionParser.parse(element, text);
			return;
		} else {
			// handle the case: <x:Array Type="ns:Type" >
			if(IConstants.XAML_X_TYPE.equals(element.getName()) || IConstants.XAML_X_STATIC.equals(element.getName())) {
				int index = text.indexOf(':');
				if(index != -1) {
					String ns = text.substring(0, index);
					String content = text.substring(index + 1);
					String namespace = namespaceMapping.get(ns);
					if(namespace != null) {
						Element childElement = new Element(namespace, content, namespaceMapping);
						childElement.setId(ElementManager.generateID(element.getName()));
						element.addChild(childElement);
						return;
					}
				}
			}
		}
		if(element instanceof Attribute && IConstants.XWT_X_NAMESPACE.equals(element.getNamespace())) {
			if(IConstants.XAML_STYLE.equalsIgnoreCase(element.getName()) || IConstants.XAML_X_CLASS.equalsIgnoreCase(element.getName()) || IConstants.XAML_X_CLASS_FACTORY.equalsIgnoreCase(element.getName())) {
				// handle the expansion of x:Style = "(j:class).variable"
				// and handle the expansion of x:Class = "(j:class).variable"
				text = expandNamespaces(element, text);
			}
		}
		element.setContent(text);
	}

	/**
	 * It is compatible with XAML.
	 * <p>
	 * It must support the following features:
	 * 
	 * 1. <Panel> <Button> <Button.Content>Hello World</Button.Content> </Button> </Panel>
	 * 
	 * 2. <Panel> <Panel.Composite> <Button Content="Hello World" /> </Panel.Composite> </Panel>
	 * 
	 * 3. <Panel> <Panel.Composite> <Button> <Button.Content>Hello World</Button.Content> </Button> </Panel.Composite> </Panel>
	 * 
	 * 4. <Panel> <Panel.Composite> <Button> <Button.Content>Hello</Button.Content> </Button> <Button> <Button.Content>World</Button.Content>
	 * </Button> </Panel.Composite> </Panel>
	 * </p>
	 * 
	 * @param namespace
	 *        attribute namespace
	 * @param name
	 *        attribute full name. like: Button.Content
	 */
	private void preProperty(String namespace, String name, Attributes attrs) throws SAXException {
		String elementTag = normalizeName(name.substring(0, name.indexOf('.')));
		String attributeName = (XWT.isXWTNamespace(namespace) ? normalizeName(name.substring(name.indexOf('.') + 1)) : name);
		String elementId = null;

		// Search the owner element and get the ID.
		for(int i = elementStack.size() - 1; i >= 0; i--) {
			DocumentObject element = elementStack.get(i);
			if(element instanceof Element && element.getName().equals(elementTag)) {
				elementId = element.getId();
				break;
			}
		}

		if(elementId == null) {
			preElement(namespace, name, attrs);
		} else {
			namespace = normalizeNamespace(namespace);
			// Process attributes: original, external
			Collection<Attribute> collection = new ArrayList<Attribute>();
			for(int i = 0, len = attrs.getLength(); i < len; i++) {

				String attrUri = normalizeNamespace(attrs.getURI(i));
				String attrName = attrs.getLocalName(i);

				Attribute attr;
				int index = attrName.lastIndexOf('.');
				if(index != -1) {
					String prefix = normalizeName(attrName.substring(0, index));
					String aName = (XWT.isXWTNamespace(namespace) ? normalizeName(attrName.substring(index + 1)) : attrName);
					attr = new Attribute(attrUri, aName, elementId);
					attr.setNamePrefix(prefix);
				} else {
					attr = new Attribute(attrUri, (XWT.isXWTNamespace(namespace) ? normalizeName(attrName) : attrName), elementId);
				}
				handleContent(attr, attrs.getValue(i));
				collection.add(attr);
			}

			Attribute attribute = new Attribute(normalizeAttrNamespace(namespace), attributeName, getIndexPath(), elementId, collection);
			elementStack.push(attribute);
			bufferStack.push(textBuffer);
			textBuffer = null;
		}
	}

	/**
	 * @see #preProperty(String, String)
	 */
	private void postProperty(String namespace, String name) throws SAXException {
		if(!elementStack.isEmpty()) {
			// remove current node from stack
			Attribute attribute = (Attribute)elementStack.pop();

			// Setting attribute content
			if(textBuffer != null) {
				String text = textBuffer.toString().trim();
				if(text.length() > 0) {
					handleContent(attribute, text);
				}
			}
			textBuffer = bufferStack.pop();

			Element element = elementManager.getElement(attribute.getId());
			element.setAttribute(attribute);
		}
	}

	/**
	 * Normalize the namespace string. If uri is null or length is zero, returns default namespace.
	 * 
	 * @param uri
	 *        The namespace which to normalize.
	 * @return Returns the normalized namespace.
	 */
	private String normalizeNamespace(String uri) {
		if(uri == null || uri.length() == 0) {
			uri = defaultNamespace;
		}
		if(uri.startsWith(IConstants.XAML_CLR_NAMESPACE_PROTO)) {
			return uri;
		}
		return uri.toLowerCase();
	}

	/**
	 * Normalize the namespace string. If uri is null or length is zero, returns default namespace.
	 * 
	 * @param uri
	 *        The namespace which to normalize.
	 * @return Returns the normalized namespace.
	 */
	private String normalizeAttrNamespace(String uri) {
		if(uri == null || uri.length() == 0) {
			uri = defaultNamespace;
		}
		if(uri.startsWith(IConstants.XAML_CLR_NAMESPACE_PROTO)) {
			uri = defaultNamespace;
		}
		return uri.toLowerCase();
	}

	/**
	 * <p>
	 * Normalize the tag name to class-formal format.
	 * </p>
	 * <p>
	 * e.g. Normalize &quot;font-face-name&quot; to &quot;FontFaceName&quot;
	 * </p>
	 * 
	 * @param tagName
	 *        The tag name which to normalize.
	 * @return the normalized tag name.
	 */
	private String normalizeName(String tagName) {
		if(!needNormalizeName) {
			return tagName;
		}
		StringBuffer buffer = new StringBuffer();

		boolean isH = false;
		for(int i = 0, len = tagName.length(); i < len; i++) {
			char c = tagName.charAt(i);
			if(i == 0) {
				buffer.append(Character.toUpperCase(c));
			} else {
				switch(c) {
				case '-':
					isH = true;
					break;
				case '.':
					isH = true;
					buffer.append(c);
					break;
				default:
					if(isH) {
						buffer.append(Character.toUpperCase(c));
						isH = false;
					} else {
						buffer.append(c);
					}
					break;
				}
			}
		}
		return buffer.toString();
	}

	private String getFormattedMessage(String msg, Object... args) {
		StringBuffer buffer = new StringBuffer("[" + locator.getLineNumber() + "," + locator.getColumnNumber() + "] ");
		buffer.append(msg);
		return MessageFormat.format(buffer.toString(), args);
	}

	/**
	 * @return the '/' separated, zero based, path of current {@link Element}.
	 */
	private String getIndexPath() {
		StringBuilder sb = new StringBuilder();
		for(Integer index : elementIndexStack) {
			if(sb.length() != 0) {
				sb.append('/');
			}
			sb.append(index.intValue());
		}
		return sb.toString();
	}
}
