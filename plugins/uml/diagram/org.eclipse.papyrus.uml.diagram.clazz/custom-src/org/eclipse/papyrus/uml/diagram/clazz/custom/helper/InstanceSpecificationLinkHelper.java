/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.uml2.uml.InstanceSpecification;

public class InstanceSpecificationLinkHelper {

	protected static final String INSTANCE_END = "InstanceEnd";////$NON-NLS-N$

	/**
	 * 
	 * @param instance
	 *        link where instance end end are look for
	 * @return a arrayList of two elements that are instance specfication : ends of this instance Link
	 *         if this is not an instance link : the size of the array list is 0
	 */
	public static ArrayList<InstanceSpecification> getEnds(InstanceSpecification instance) {
		ArrayList<InstanceSpecification> array = new ArrayList<InstanceSpecification>();
		EAnnotation endtypes = instance.getEAnnotation(INSTANCE_END);
		if(endtypes != null) {
			assert (endtypes.getReferences().size() == 2);
			array.add((InstanceSpecification)endtypes.getReferences().get(0));
			array.add((InstanceSpecification)endtypes.getReferences().get(1));
		}
		return array;
	}

	/**
	 * add an end in the instancespecification link by adding a eannotation if not exist
	 * 
	 * @param instanceLink
	 * @param end
	 *        to add
	 */
	public static void addEnd(InstanceSpecification instanceLink, InstanceSpecification end) {
		EAnnotation endtypes = instanceLink.getEAnnotation(INSTANCE_END);
		if(endtypes == null) {
			endtypes = instanceLink.createEAnnotation(INSTANCE_END);
		}
		endtypes.getReferences().add(end);
	}

	/**
	 * remove an end in the instancespecification link by adding a eannotation if not exist
	 * 
	 * @param instanceLink
	 * @param end
	 *        to add
	 */
	public static void removeEnd(InstanceSpecification instanceLink, InstanceSpecification end) {
		EAnnotation endtypes = instanceLink.getEAnnotation(INSTANCE_END);
		if(endtypes == null) {
			endtypes = instanceLink.createEAnnotation(INSTANCE_END);
		}
		endtypes.getReferences().remove(end);
	}
}
