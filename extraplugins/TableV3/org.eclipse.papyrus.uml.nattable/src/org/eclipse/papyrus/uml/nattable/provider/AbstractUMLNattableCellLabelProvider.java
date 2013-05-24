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
package org.eclipse.papyrus.uml.nattable.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.provider.GenericCellLabelProvider;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Abstract Class for UML Cell provider
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractUMLNattableCellLabelProvider extends GenericCellLabelProvider {


	/**
	 * 
	 * @param obj1
	 *        the first Object
	 * @param obj2
	 *        the second Obejct
	 * @return
	 *         a list of 2 elements when
	 *         <ul>
	 *         <li>the first obejct is an instanceof Element</li>
	 *         <li>the second object is an UML EstructuralFeature or the real property if we are working with a property of steretoype</li>
	 *         </ul>
	 *         or <code>null</code> if the conditions are not satisfied
	 */
	protected List<Object> getUMLObjects(final Object obj1, final Object obj2) {//FIXME do a util method for that?
		List<Object> objects = new ArrayList<Object>();
		if(obj1 instanceof Element) {
			objects.add(obj1);
			objects.add(obj2);
		} else if(obj2 instanceof Element) {
			objects.add(obj2);
			objects.add(obj1);
		}
		if(objects.size() == 2) {
			Object feature = objects.get(1);
			String id = AxisUtils.getPropertyId(feature);
			if(id != null) {
				if(id.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX)) {
					Property prop = UMLTableUtils.getRealStereotypeProperty((EObject)objects.get(0), id);
					if(prop != null) {
						objects.remove(1);
						objects.add(prop);
					} else {
						objects = Collections.emptyList();
					}
				}
			} else if(feature instanceof EStructuralFeature) {
				final EObject featureContainer = ((EStructuralFeature)feature).eContainer();
				if(!UMLPackage.eINSTANCE.eContents().contains(featureContainer)) {
					objects = Collections.emptyList();
				}
			}
		} else {
			objects = Collections.emptyList();
		}
		return objects;

	}
}
