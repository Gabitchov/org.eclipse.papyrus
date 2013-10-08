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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.transformations;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.FCM.DerivedElement;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Utility functions for the update derived elements, e.g. operations of a component
 * that depend on the operations of an interface that is offered by the component.
 */
public class UpdateUtils {

	public static EList<Element> getDerivedElements(Package pkg, NamedElement source) {
		EList<Element> list = new BasicEList<Element>();
		Iterator<NamedElement> members = pkg.getOwnedMembers().iterator();
		while(members.hasNext()) {
			NamedElement member = members.next();
			if(getSource(member) == source) {
				list.add(member);
			}
			if(member instanceof Package) {
				EList<Element> subList = getDerivedElements((Package)member, source);
				list.addAll(subList);
			}
		}
		return list;
	}

	public static Element getDerivedElement(EList<? extends Element> list, Element source) {
		Iterator<? extends Element> elements = list.iterator();
		while(elements.hasNext()) {
			Element element = elements.next();
			if(StereotypeUtil.isApplied(element, DerivedElement.class)) {
				DerivedElement de = UMLUtil.getStereotypeApplication(element, DerivedElement.class);
				if((de != null) && (de.getSource() == source)) {
					return element;
				}
			}
		}
		return null;
	}

	public static void setSource(Element derivedElement, Element source) {
		DerivedElement de = StereotypeUtil.applyApp(derivedElement, DerivedElement.class);
		de.setSource(source);
	}

	public static Element getSource(Element element) {
		if(StereotypeUtil.isApplied(element, DerivedElement.class)) {
			DerivedElement de = UMLUtil.getStereotypeApplication(element, DerivedElement.class);
			if(de != null) {
				return de.getSource();
			}
		}
		return null;
	}
}
