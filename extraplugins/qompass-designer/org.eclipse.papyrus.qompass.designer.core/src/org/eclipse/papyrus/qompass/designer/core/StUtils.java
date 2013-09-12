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
import org.eclipse.papyrus.FCM.DerivedElement;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
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
	 * This method verifies if a stereotype is applied on an UML element
	 * 
	 * @param element
	 *        A UML element
	 * @param str_name
	 *        a qualified stereotype name
	 */
	public static boolean isApplied(Element element, String str_name) {
		return (element.getAppliedStereotype(str_name) != null);
	}

	/**
	 * This method verifies if a stereotype is applied on an UML element
	 * 
	 * @param element
	 *        A UML element
	 * @param the
	 *        class of an element of a static profile
	 */
	public static boolean isApplied(Element element, java.lang.Class<? extends EObject> clazz) {
		for(EObject stereoApplication : element.getStereotypeApplications()) {
			// check whether the stereotype is a subclass of the passed parameter clazz
			if(clazz.isAssignableFrom(stereoApplication.getClass())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method verifies if a stereotype is applicable on an UML element
	 * 
	 * @param element
	 *        A UML element
	 * @param the
	 *        class of an element of a static profile
	 */
	public static boolean isApplicable(Element element, java.lang.Class<? extends EObject> clazz) {
		return StUtils.getStereoName(element,  clazz) != null;
	}
	
	/**
	 * Return the attribute of a stereotype. If the attribute type is a model reference,
	 * use the function getAttributeBase instead.
	 * 
	 * @param element
	 *        the element which holds the stereotype
	 * @param stereo_name
	 *        the name of the stereotype
	 * @param attrib_name
	 *        the name of an attribute of this stereotype
	 * @return The value that is associated with the stereotype attribute
	 */
	public static Object getAttribute(Element element, String stereo_name, String attrib_name) {
		Stereotype stereotype = element.getAppliedStereotype(stereo_name);
		if(stereotype == null) {
			return null;
		}
		return element.getValue(stereotype, attrib_name);
	}

	/**
	 * Set the value of a stereotype attribute
	 * 
	 * @param element
	 *        the element which holds the stereotype
	 * @param stereo_name
	 *        the name of the stereotype
	 * @param attrib_name
	 *        the name of an attribute of this stereotype
	 * @param value
	 *        the value that is associated with the stereotype attribute
	 */
	public static void setAttribute(Element element, String stereo_name, String attr_name, Object value) {
		Stereotype st = apply(element, stereo_name);
		if(st != null) {
			element.setValue(st, attr_name, value);
		}
	}

	/**
	 * Return the stereotype application. Like getApplication below, except
	 * that the passed stereotype is a string.
	 * 
	 * @param element
	 * @param stereo_name
	 *        the qualified name of a stereotype. Applications of compatible sub-types will be returned as well (if exact stereotype is not applied)
	 * @return
	 */
	public static EObject getApplication(Element element, String stereo_name) {

		Stereotype stereotype = element.getApplicableStereotype(stereo_name);
		if(stereotype != null) {
			EObject application = element.getStereotypeApplication(stereotype);
			if(application != null) {
				return application;
			}
			// not found, now try sub-stereotypes 
			for(Stereotype subStereo : element.getAppliedSubstereotypes(stereotype)) {
				application = element.getStereotypeApplication(subStereo);
				if(application != null) {
					return application;
				}
			}
		}
		return null;

	}

	/**
	 * Apply a stereotype. The stereotype is not applied, if already a sub-stereotype is applied.
	 * If you want to apply the new stereotype also in this case, use applyExact instead.
	 * 
	 * @param element
	 *        the element
	 * @param stereo_name
	 *        the stereotype name
	 * @return
	 */
	public static Stereotype apply(Element element, String stereo_name) {
		Stereotype stereotype = element.getApplicableStereotype(stereo_name);
		if(stereotype != null) {
			EList<Stereotype> subStereos = element.getAppliedSubstereotypes(stereotype);
			boolean alreadyApplied = (subStereos.size() > 0);
			if(!alreadyApplied) {
				// it seems that subSterotypes do not include the stereotype itself
				if(element.getStereotypeApplication(stereotype) == null) {
					element.applyStereotype(stereotype);
				}
			}
		}
		return stereotype;
	}

	/**
	 * unapply a stereotype when the name of the stereotype is given.
	 * 
	 * @param element
	 *        the element
	 * @param stereo_name
	 *        the stereotype name
	 * @return
	 */
	public static void unapply(Element element, String stereo_name) {
		Stereotype stereotype = element.getApplicableStereotype(stereo_name);
		if(stereotype != null) {
			if(element.getStereotypeApplication(stereotype) != null) {
				element.unapplyStereotype(stereotype);
			}
		}
	}

	/**
	 * Apply a stereotype and return the stereotype application (if successful).
	 * The stereotype is not applied, if already a sub-stereotype is applied.
	 * If you want to apply the new stereotype also in this case, use applyExact instead.
	 * 
	 * @param element
	 *        the element
	 * @param stereo_name
	 *        the stereotype name
	 * @return
	 */
	public static <T extends EObject> T applyApp(Element element, java.lang.Class<T> clazz) {
		if(apply(element, clazz) != null) {
			return UMLUtil.getStereotypeApplication(element, clazz);
		}
		return null;
	}

	/**
	 * @param element
	 * @param stereo_name
	 * @return
	 */
	public static Stereotype applyExact(Element element, String stereo_name) {
		Stereotype stereotype = element.getApplicableStereotype(stereo_name);
		if(stereotype != null) {
			Stereotype alreadyApplied = element.getAppliedSubstereotype(stereotype, stereo_name);
			if(alreadyApplied == null) {
				element.applyStereotype(stereotype);
			}
		}
		return stereotype;
	}

	/**
	 * Apply a stereotype.
	 * Caveat: the function relies on the correspondence between the fully qualified
	 * stereotype name and the package name within the static profile. The latter may
	 * use a different prefix (as it is the case with the MARTE analysis & design profile).
	 * 
	 * @param element
	 *        the element
	 * @param class a class of a static profile
	 * @return
	 */
	public static Stereotype apply(Element element, java.lang.Class<? extends EObject> clazz) {
		return apply(element, getStereoName(element, clazz));
	}

	/**
	 * Unapply a stereotype.
	 * Caveat: the function relies on the correspondence between the fully qualified
	 * stereotype name and the package name within the static profile. The latter may
	 * use a different prefix (as it is the case with the MARTE analysis & design profile).
	 * 
	 * @param element
	 *        the element
	 * @param stereo_name
	 *        the stereotype name
	 * @return
	 */
	public static void unapply(Element element, java.lang.Class<? extends EObject> clazz) {
		unapply(element, getStereoName(element, clazz));
	}

	/**
	 * Apply a stereotype.
	 * Caveat: the function relies on the correspondence between the fully qualified
	 * stereotype name and the package name within the static profile. The latter may
	 * use a different prefix (as it is the case with the MARTE analysis & design profile).
	 * 
	 * @param element
	 *        the element
	 * @param stereo_name
	 *        the stereotype name
	 * @return
	 */
	public static Stereotype applyExact(Element element, java.lang.Class<? extends EObject> clazz) {
		return applyExact(element, getStereoName(element, clazz));
	}

	/**
	 * This function should be used if stereotype attributes are in turn typed by stereotyped
	 * elements and the user wants to retrieve the underlying base elements (instead of the stereotype application)
	 * The function applies the getBaseElement operation to the result of the
	 * getStereotypeAttribute function above.
	 * 
	 * @param element
	 *        the element while holds the stereotype
	 * @param stereo_name
	 *        the name of the stereotype
	 * @param attrib_name
	 *        the name of an attribute of this stereotype
	 * @return The value that is associated with the stereotype attribute
	 */
	public static Element getAttributeBase(Element element, String stereo_name, String attrib_name) {
		Object obj = getAttribute(element, stereo_name, attrib_name);
		if(obj instanceof EObject) {
			return UMLUtil.getBaseElement((EObject)obj);
		} else {
			return null;
		}
	}

	/**
	 * Copy the stereotype application from a source to a destination element. The
	 * function will also copy the stereotype attributes.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public static void copyStereotypes(Copy copy, Element source, Element destination) {
		final String derivedElement = DerivedElement.class.getName().replace(".", "::");
		for(Stereotype stereotype : source.getAppliedStereotypes()) {
			String stereoName = stereotype.getQualifiedName();
			if(!stereoName.equals(derivedElement)) {
				// Hack: do not copy derived element stereotype. Problem: when templates are instantiated,
				//   some operations are derived from interface operations which in turn are derived from the
				//   formal template parameter (e.g. FIFO). Since interface derived from ports are put into a
				//   top-level directory "derived elements", they may be outside the package template and do not
				//   get replaced.
				copyAttributes(copy, stereotype.getQualifiedName(), source, destination);
			}
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
				if(attrName.startsWith("base_")) {
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
				else if (!stereotypeName.endsWith("TemplatePort")) { // (copy.withinTemplate((EObject) value)) {
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
		return StUtils.isApplied(candidate, org.eclipse.papyrus.FCM.Connector.class);
	}

	public static Stereotype getStereo(Element element, java.lang.Class<? extends EObject> clazz) {
		return element.getAppliedStereotype(getStereoName(element, clazz));
	}

	/**
	 * Get the stereotype-name that may relate to the name of an interface within a static profile.
	 * Note that the class name within a static profile might have a prefix, such as org.eclipse.papyrus. This
	 * functions tries to remove prefixes iteratively, if a stereotype is not applicable.
	 *
	 * @param clazz
	 * @return
	 */
	public static String getStereoName(Element element, java.lang.Class<? extends EObject> clazz) {
		String name = clazz.getName().replace(".", "::"); //$NON-NLS-1$ //$NON-NLS-2$;
		while (element.getApplicableStereotype(name) == null) {
			int index = name.indexOf("::"); //$NON-NLS-1$
			if (index == -1) {
				return null;
			}
			name = name.substring(index + 2);
		}
		return name;
	}

}
