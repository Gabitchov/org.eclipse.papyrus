/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * This content providers is used to get the properties of stereotypes
 * 
 */
public class UMLStereotypePropertyContentProvider implements IHierarchicContentProvider {

	/**
	 * the profiles
	 */
	private List<Profile> profiles;

	/**
	 * this boolean is used to know if we should returns the Property base_EXTENDED_METACLASS or not
	 */
	private boolean baseProperty;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param profiles
	 *        the profiles to navigate
	 */
	public UMLStereotypePropertyContentProvider(final List<Profile> profiles) {
		this(profiles, false);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param profiles
	 *        the profiles to navigate
	 * @param baseProperty
	 */
	public UMLStereotypePropertyContentProvider(final List<Profile> profiles, final boolean baseProperty) {
		this.profiles = profiles;
		this.baseProperty = baseProperty;
	}

	/**
	 * 
	 * @return
	 */
	public Object[] getElements() {
		return this.profiles.toArray();
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */
	public Object[] getElements(Object inputElement) {
		return getElements();
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 * 
	 * @param parentElement
	 * @return
	 */
	public Object[] getChildren(Object parentElement) {
		List<Object> children = new ArrayList<Object>();
		if(hasChildren(parentElement)) {
			if(parentElement instanceof Package) {
				for(final EObject current : ((Package)parentElement).getOwnedMembers()) {
					if(hasChildren(current)) {
						children.add(current);
					}
				}
			} else if(parentElement instanceof Stereotype) {
				if(this.baseProperty) {
					children.addAll((((Stereotype)parentElement).getOwnedAttributes()));
				} else {
					children.addAll(StereotypeUtil.getStereotypePropertiesWithoutBaseProperties((Stereotype)parentElement));
				}
			}
		}
		return children.toArray();
	}



	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public Object getParent(Object element) {
		if(element instanceof EObject) {
			return ((EObject)element).eContainer();
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public boolean hasChildren(Object element) {
		if(element instanceof Element) {
			final TreeIterator<EObject> iter = ((EObject)element).eAllContents();
			while(iter.hasNext()) {
				if(isValidValue(iter.next())) {
					return true;
				}
			}
		}
		return false;
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider#isValidValue(java.lang.Object)
	 * 
	 * @param element
	 *        an element
	 * @return
	 *         <code>true</code> if the element is a Property owned by a Stereotype
	 */
	public boolean isValidValue(Object element) {
		if(element instanceof Element) {
			boolean result = element instanceof Property && ((Element)element).eContainer() instanceof Stereotype;
			if(result && !baseProperty) {
				return StereotypeUtil.isValidStereotypeProperty((Property)element);
			}
			return result;
		}
		return false;
	}

}
