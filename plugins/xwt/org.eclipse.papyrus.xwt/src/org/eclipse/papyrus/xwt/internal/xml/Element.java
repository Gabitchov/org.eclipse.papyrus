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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.internal.core.Core;

/**
 * @since 1.0
 * @author yyang
 */
public class Element extends DocumentObject {

	private static final String[] EMPTY_STRING_ARRAY = new String[0];

	private String path;

	private Map<String, Attribute> originalAttributes;

	private Map<String, Map<String, Attribute>> externalAttributes;

	private String[] xmlnsMapping;

	/**
	 * @return the path of this element, i.e. indexes of this element and its parents in XML.
	 */
	public String getPath() {
		return path;
	}

	public String getXmlns(String prefix) {
		if(prefix == null) {
			prefix = "";
		}
		if(xmlnsMapping != null) {
			for(int i = 0; i < xmlnsMapping.length; i++) {
				if(prefix.equals(xmlnsMapping[i++])) {
					return xmlnsMapping[i];
				}
			}
		}
		return null;
	}

	/**
	 * Default constructor
	 * 
	 * @param context
	 *        bundle context
	 * @param namespace
	 *        element namespace
	 * @param name
	 *        element name
	 * @param originalAttributes
	 *        element arributes
	 */
	public Element(String namespace, String name, Map<String, String> xmlnsMapping) {
		this(namespace, name, null, null, xmlnsMapping);
	}

	public Element(String namespace, String name, String path, Collection<Attribute> attributes, Map<String, String> xmlnsMapping) {
		super(namespace, name);
		this.path = path;
		if(xmlnsMapping != null) {
			this.xmlnsMapping = new String[xmlnsMapping.size() * 2];
			int i = 0;
			for(Map.Entry<String, String> entry : xmlnsMapping.entrySet()) {
				String key = entry.getKey();
				if(key == null) {
					key = "";
				}
				this.xmlnsMapping[i++] = key;
				this.xmlnsMapping[i++] = entry.getValue();
			}
		}

		this.originalAttributes = Collections.emptyMap();
		this.externalAttributes = Collections.emptyMap();

		if(attributes != null) {
			for(Attribute attribute : attributes) {
				setInternalAttribute(attribute);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soyatec.eface.core.IElement#attributeNames()
	 */
	public String[] attributeNames() {
		return originalAttributes.keySet().toArray(EMPTY_STRING_ARRAY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soyatec.eface.core.IElement#attributeNamespaces()
	 */
	public String[] attributeNamespaces() {
		return externalAttributes.keySet().toArray(EMPTY_STRING_ARRAY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.soyatec.eface.core.IElement#setAttribute(com.soyatec.eface.core. IAttribute)
	 */
	public void setAttribute(Attribute attribute) {
		setInternalAttribute(attribute);
		firePropertyChanged(attribute);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soyatec.eface.IElement#attributeNames(java.lang.String)
	 */
	public String[] attributeNames(String namespace) {
		if(getNamespace().equals(namespace)) {
			return attributeNames();
		}
		Map<String, Attribute> externalAttribute = externalAttributes.get(namespace);
		if(externalAttribute != null) {
			return externalAttribute.keySet().toArray(EMPTY_STRING_ARRAY);
		} else {
			return Core.EMPTY_STRING_ARRAY;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soyatec.eface.core.IElement#getAttribute(java.lang.String)
	 */
	public Attribute getAttribute(String name) {
		assert name != null;
		return originalAttributes.get(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soyatec.eface.core.IElement#getAttribute(java.lang.String, java.lang.String)
	 */
	public Attribute getAttribute(String namespace, String name) {
		Map<String, Attribute> externalAttribute = externalAttributes.get(namespace);
		if(externalAttribute != null) {
			return externalAttribute.get(name);
		} else {
			return null;
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Element element = (Element)super.clone();

		element.parent = null;

		if(originalAttributes.isEmpty()) {
			originalAttributes = Collections.emptyMap();
		} else {
			element.originalAttributes = new LinkedHashMap<String, Attribute>(originalAttributes.size());
			for(String attrName : originalAttributes.keySet()) {
				Attribute attrValue = (Attribute)originalAttributes.get(attrName).clone();
				element.originalAttributes.put(attrName, attrValue);
			}
		}

		if(externalAttributes.isEmpty()) {
			element.originalAttributes = Collections.emptyMap();
		} else {
			element.externalAttributes = new LinkedHashMap<String, Map<String, Attribute>>(externalAttributes.size());
			for(String ns : externalAttributes.keySet()) {
				Map<String, Attribute> oAttributes = externalAttributes.get(ns);
				Map<String, Attribute> nAttributes = new LinkedHashMap<String, Attribute>(oAttributes.size());
				for(Map.Entry<String, Attribute> entry : oAttributes.entrySet()) {
					String attrName = entry.getKey();
					Attribute attrValue = (Attribute)entry.getValue().clone();
					nAttributes.put(attrName, attrValue);
				}
				element.externalAttributes.put(ns, nAttributes);
			}
		}

		return element;
	}

	protected void setAttributes(Collection<Attribute> attributes) {
		for(Attribute attribute : attributes) {
			setInternalAttribute(attribute);
		}
		firePropertyChanged(attributes);
	}

	private void firePropertyChanged(Attribute attribute) {
		notifyObservers(attribute);
	}

	private void firePropertyChanged(Collection<Attribute> attributes) {
		notifyObservers(attributes);
	}

	private boolean isXWTNamespace(String namespace) {
		String scopeNamespace = getNamespace();
		if(namespace == null || "".equals(namespace)) {
			return true;
		}
		if(scopeNamespace.startsWith(IConstants.XAML_CLR_NAMESPACE_PROTO) || scopeNamespace.equals(IConstants.XWT_NAMESPACE)) {
			return namespace.equalsIgnoreCase(scopeNamespace) || namespace.equals(IConstants.XWT_NAMESPACE);
		}
		return false;
	}

	/**
	 * Set attribute without notifying event.
	 * 
	 * @param attribute
	 *        the modified attribute.
	 */
	private void setInternalAttribute(Attribute attribute) {
		assert attribute != null;

		String namespace = attribute.getNamespace();
		String name = attribute.getName();

		if(isXWTNamespace(namespace)) {
			if(originalAttributes == Collections.EMPTY_MAP) {
				originalAttributes = new LinkedHashMap<String, Attribute>();
			}
			originalAttributes.put(name, attribute);
		} else {
			Map<String, Attribute> externalAttribute = externalAttributes.get(namespace);
			if(externalAttribute == null) {
				externalAttribute = new HashMap<String, Attribute>();
			}
			if(externalAttributes == Collections.EMPTY_MAP) {
				externalAttributes = new LinkedHashMap<String, Map<String, Attribute>>();
			}
			externalAttribute.put(name, attribute);
			externalAttributes.put(namespace, externalAttribute);
		}
		((DocumentObject)attribute).setParent(this);
	}
}
