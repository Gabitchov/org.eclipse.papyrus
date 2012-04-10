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

/**
 * @author yyang
 * @version 1.0
 */
public class Attribute extends Element {

	protected String namePrefix;

	/**
	 * @param manager
	 * @param namespace
	 * @param name
	 * @param id
	 */
	public Attribute(String namespace, String name, String id) {
		super(namespace, name, null);
		assert id != null;
		setId(id);
	}

	public Attribute(String namespace, String name, String path, String id, Collection<Attribute> attributes) {
		super(namespace, name, path, attributes, null);
		assert id != null;
		setId(id);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Attribute attribute = (Attribute)super.clone();
		attribute.setId(getId());
		return attribute;
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}
}
