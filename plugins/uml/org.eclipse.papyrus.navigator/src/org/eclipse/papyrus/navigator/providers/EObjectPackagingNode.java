/*******************************************************************************
 * Copyright (c) 2008, 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * A {@link PackagingNode} for {@link EObject}s. Children are obtained by looking {@link EObject}'s
 * contents and selecting those elements that match the {@link EClass}
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @see <a href=https://bugs.eclipse.org/bugs/show_bug.cgi?id=290422>Bug #290422</a>
 * 
 */
public class EObjectPackagingNode extends PackagingNode {

	/**
	 * {@link EClass} to filter children element in contents.
	 */
	private final EClass eClass;

	public EObjectPackagingNode(EClass eClass, EObject parent) {
		super(eClass.getName(), parent);
		if (eClass == null || parent == null) {
			throw new IllegalArgumentException("No EClass or EObject provided");
		}
		this.eClass = eClass;
	}

	/**
	 * Parent as {@link EObject}.
	 * 
	 * @return
	 */
	public EObject getEObjectParent() {
		if (getParent() instanceof EObject) {
			return (EObject) getParent();
		}
		return null;
	}

	/**
	 * The {@link EClass} to filter contents.
	 * 
	 * @return
	 */
	public EClass getEClass() {
		return eClass;
	}

	/**
	 * Adds an element to the contained collection.
	 */
	@Override
	public void addContainedNode(Object o) {
		super.getContainedNodes().add(o);
	}

	@Override
	public Collection<Object> getContainedNodes() {
		Collection<Object> elements = findContainedEClassElements();
		elements.addAll(super.getContainedNodes());
		return elements;
	}

	private Collection<Object> findContainedEClassElements() {
		EObject parent = getEObjectParent();
		if (parent == null) {
			return Collections.EMPTY_SET;
		}
		Collection<Object> elements = new ArrayList<Object>();
		for (EObject content : parent.eContents()) {
			if (content != null && content.eClass() != null && content.eClass().getName() != null) {
				if (content.eClass().getName().equals(getEClass().getName())) {
					elements.add(content);
				}
			}
		}
		return elements;
	}

	/**
	 * True if parent and eClass match.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EObjectPackagingNode) {
			EObjectPackagingNode other = (EObjectPackagingNode) obj;
			if (other.getEClass() != null && other.getEClass().equals(getEClass()) && other.getEObjectParent() != null
					&& other.getEObjectParent().equals(getEObjectParent())) {
				return true;
			}
		}
		return false;
	}

}
