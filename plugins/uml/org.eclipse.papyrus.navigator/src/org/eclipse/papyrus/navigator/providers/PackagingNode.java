/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial api implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An intermediate node for children grouping by type.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @see <a href=https://bugs.eclipse.org/bugs/show_bug.cgi?id=290422>Bug
 *      #290422</a>
 */
public class PackagingNode {
	private String name;
	private Object parent;
	private Collection<Object> containedNodes = null;

	public PackagingNode(String key, Object parent) {
		this.name = key;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addContainedNode(Object o) {
		getContainedNodes().add(o);
	}

	public Collection<Object> getContainedNodes() {
		if (containedNodes == null) {
			containedNodes = new ArrayList<Object>();
		}
		return containedNodes;
	}

	public Object getParent() {
		return parent;
	}

}