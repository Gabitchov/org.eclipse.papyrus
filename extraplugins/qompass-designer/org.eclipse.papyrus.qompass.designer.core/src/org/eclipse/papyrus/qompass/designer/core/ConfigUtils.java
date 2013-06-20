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

package org.eclipse.papyrus.qompass.designer.core;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.FCM.ConfigurationProperty;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class ConfigUtils {

	/**
	 * Get the configuration properties of a class
	 * 
	 * @param component
	 * @return
	 */
	public static EList<Property> getConfigAttributes(Classifier component) {

		EList<Property> list = new BasicEList<Property>();

		for(Property part : component.getAllAttributes()) {
			if(part instanceof Port) {
				continue;
			}
			Element owner = part.getOwner();

			if(Utils.allAttributesAreConfigAttributs()) {
				// return all attributes
				list.add(part);
			}
			// add all attributes of component types
			else if(owner instanceof Class && Utils.isCompType((Class)owner)) {
				list.add(part);
			}
			// otherwise add only attributes tagged as configuration properties
			else if(StUtils.isApplied(part, ConfigurationProperty.class)) {
				list.add(part);
			}
		}
		return list;
	}

	/**
	 * Get the configuration attributes behind a container rule
	 * TODO: rule might not be active - should we still configure it??
	 * 
	 * @param aRule
	 * @return
	 * @throws TransformationException
	 */
	public static EList<Property> getConfigAttributes(ContainerRule rule) throws TransformationException {
		EList<Property> list = new BasicEList<Property>();
		Class composite = rule.getBase_Class(); // a rule should always have a base class, unless malformed
		if(composite == null) {
			throw new TransformationException("A container rule has no base class (broken model library?)");
		}
		for(Property part : composite.getAttributes()) {
			if(part instanceof Port) {
				continue;
			}
			Type type = part.getType();
			if(StUtils.isApplied(part, ConfigurationProperty.class)) {
				list.add(part);
			}
			if(type instanceof Class) {
				list.addAll(getConfigAttributes((Class)type));
			}
		}

		return list;
	}
}
