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

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import org.eclipse.papyrus.xwt.IConstants;
import org.xml.sax.SAXException;

/**
 * @author yyang
 * @version 1.0
 */
public class DocumentObject extends Observable implements Cloneable {

	private String id;

	private String name;

	private String namespace;

	private String content;

	private List<DocumentObject> children;

	protected DocumentObject parent;

	/**
	 * @param manager
	 * @param namespace
	 * @param name
	 */
	public DocumentObject(String namespace, String name) {
		assert namespace != null;
		assert name != null;
		this.children = new LinkedList<DocumentObject>();
		setNamespace(namespace);
		setName(name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#addChild(org.soyatec.xaml.IDocumentObject )
	 */
	public void addChild(DocumentObject child) {
		assert child != null;

		if(children.add(child)) {
			DocumentObject oParent = (child).getParent();
			if(oParent != null) {
				oParent.delChild(child);
			}
			// Assign the new parent.
			child.setParent(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#getChildren()
	 */
	public DocumentObject[] getChildren() {
		return children.toArray(IConstants.EMPTY_DOCOBJ_ARRAY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#getContent()
	 */
	public String getContent() {
		return content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#getId()
	 */
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#getNamespace()
	 */
	public String getNamespace() {
		return namespace;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#hasCildren()
	 */
	public boolean hasChildren() {
		return !children.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#include(java.io.InputStream)
	 */
	public void include(ElementManager elementManager, InputStream input) throws IOException {
		try {
			elementManager.load(input, this);
		} catch (SAXException e) {
			throw new IOException(e.getLocalizedMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#include(java.lang.String)
	 */
	public void include(ElementManager elementManager, String path) throws IOException {
		InputStream input = elementManager.getDocumentRoot().openStream(path);
		if(input != null) {
			include(elementManager, input);
		}
		input.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IDocumentObject#setContent(java.lang.String)
	 */
	public void setContent(String text) {
		this.content = text;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		DocumentObject docobj = (DocumentObject)super.clone();

		// Clear object id.
		docobj.id = null;

		// Clone children.
		for(DocumentObject child : getChildren()) {
			DocumentObject nChild = (DocumentObject)child.clone();
			docobj.addChild(nChild);
		}

		return docobj;
	}

	/**
	 * @param id
	 *        the id to set
	 */
	protected void setId(String id) {
		if(this.id != null) {
			throw new IllegalStateException("Element id is already defined");
		}

		assert id != null;

		this.id = id;
	}

	/**
	 * @param namespace
	 *        the namespace to set
	 * @uml.property name="namespace"
	 */
	protected void setNamespace(String namespace) {
		assert namespace != null : "Element namespace is null";
		assert this.namespace == null : "Element namespace is defined";

		this.namespace = namespace;
	}

	/**
	 * @param name
	 *        the name to set
	 * @uml.property name="name"
	 */
	protected void setName(String name) {
		assert name != null : "Element name is null";
		assert this.name == null : "Element name is defined";

		this.name = name;
	}

	/**
	 * Remove child from parent.
	 * 
	 * @param child
	 *        the removed parent.
	 */
	protected void delChild(DocumentObject child) {
		assert child != null;

		if(child instanceof Element) {
			DocumentObject parent = ((Element)child).getParent();
			if(parent != null && parent.equals(this)) {
				children.remove(child);
				((Element)child).setParent(null);
			}
		}
	}

	public DocumentObject getParent() {
		return parent;
	}

	public void setParent(DocumentObject parent) {
		this.parent = parent;
	}
}
