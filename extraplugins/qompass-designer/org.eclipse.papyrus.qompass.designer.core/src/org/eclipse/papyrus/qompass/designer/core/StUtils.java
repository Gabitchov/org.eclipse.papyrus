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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Some functions around stereotype usage.
 * 
 * @author ansgar
 * 
 */
public class StUtils {

	/**
	 * Copy the stereotype application from a source to a destination element. The
	 * function will also copy the stereotype attributes.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public static void copyStereotypes(Copy copy, Element source, Element destination) {
		for(Stereotype stereotype : source.getAppliedStereotypes()) {
			copyAttributes(copy, stereotype.getQualifiedName(), source, destination);
		}
	}

	public static void copyStereotypes(Element source, Element destination) {
		copyStereotypes(null, source, destination);
	}

	/**
	 * copy stereotype attributes.
	 * 
	 * TODO: verify if it is necessary to distinguish between stereoSource and stereoDest
	 * (they should be identical, if the resource sets are).
	 * => simplify code
	 * 
	 * @param stereotypeName
	 * @param source
	 * @param destination
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public static boolean copyAttributes(Copy copy, String stereotypeName, Element source, Element destination) {
		Stereotype stereoSource = source.getAppliedStereotype(stereotypeName);
		Stereotype stereoDest = destination.getApplicableStereotype(stereotypeName);

		if((stereoSource == null) || (stereoDest == null)) {
			return false;
		}
		Stereotype alreadyApplied = destination.getAppliedStereotype(stereotypeName);
		if(alreadyApplied == null) {
			// only apply stereotype, if not already applied
			destination.applyStereotype(stereoDest);
		}

		// getAllAttributes? (but have to avoid attribute base_Class which resets stereotype application)
		for(Property attribute : stereoSource.getAllAttributes()) {
			String attrName = attribute.getName();

			if(attrName.length() >= 5) {
				// do not copy base_ stereotypes (base_class, base_package and base_PackageImport)
				if(attrName.startsWith(Extension.METACLASS_ROLE_PREFIX)) {
					continue;
				}
			}
			// do not copy derived attributes
			if(attribute.isDerived()) {
				continue;
			}

			Object value = source.getValue(stereoSource, attrName);
			// handle specific case: need to copy referenced containerExt, since it points to element
			// in the original model.
			/*
			 * if ((value instanceof EObject) && (attrName.equals ("containerExt"))) {
			 * continue;
			 * }
			 */

			if(value instanceof EList) {
				// copy list
				EList<Object> newList = new BasicEList<Object>();
				for(Object valueEl : (EList<Object>)value) {
					if((copy != null) && (valueEl instanceof Element)) {
						newList.add(copy.getCopy((Element)valueEl));
					} else {
						newList.add(valueEl);
					}
				}
				if(newList.size() > 0) {
					destination.setValue(stereoDest, attrName, newList);
				}
			} else if((copy != null) && (value instanceof EObject)) {
				if (value instanceof Element) {
					destination.setValue(stereoDest, attrName, copy.getCopy((Element)value));
				}
				// TODO: remove hack: the template port references directly an element of a package template
				//   the package template should not be copied, but instantiated as done in class TemplatePort
				else if (!stereotypeName.endsWith("TemplatePort")) { //$NON-NLS-1$
					// value is likely a stereotype application. If copy does a package-template instantiation, it would
					// check whether the passed element is within the package template. This would fail if we pass
					// a stereotype application. (could also do check within copy??)
					EObject eValue = (EObject) value;
					Element base = UMLUtil.getBaseElement(eValue);
					EClass eClass = eValue.eClass();
					Element newBase =  copy.getCopy(base);
					for (EObject stereoApp : newBase.getStereotypeApplications()) {
						if (stereoApp.eClass() == eClass) {
							destination.setValue(stereoDest, attrName, stereoApp);
							break;
						}
					}
				}
				else {
					destination.setValue(stereoDest, attrName, value);
				}
			}
			else {
				destination.setValue(stereoDest, attrName, value);
			}
		}

		return true;
	}

	public static boolean copyAttribute(String stereotypeName, String attribute, Element source, Element destination) {
		Stereotype stereotype = source.getAppliedStereotype(stereotypeName);
		if(stereotype == null) {
			return false;
		}
		Object value = source.getValue(stereotype, attribute);
		destination.applyStereotype(stereotype);
		destination.setValue(stereotype, attribute, value);
		return true;
	}

	public static org.eclipse.papyrus.FCM.Connector getConnector(Connector connector) {
		return UMLUtil.getStereotypeApplication(connector, org.eclipse.papyrus.FCM.Connector.class);
	}

	public static boolean isConnector(Connector candidate) {
		return StereotypeUtil.isApplied(candidate, org.eclipse.papyrus.FCM.Connector.class);
	}
}
