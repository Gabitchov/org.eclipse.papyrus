package org.eclipse.papyrus.cpp.profile;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Some functions around stereotype usage.
 * TODO: originally developed without use of static profile. It thus contains many functions
 * that are no longer needed (e.g. getBoolean) => needs some cleanup
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
	 * Return the stereotype application. Like getStereotypeApplication, except
	 * that the passed stereotype is a string.
	 * 
	 * @param element
	 * @param stereo_name
	 * @return
	 */
	public static EObject getApplication(Element element, String stereo_name) {

		Stereotype stereotype = element.getApplicableStereotype(stereo_name);
		if(stereotype != null) {
			return element.getStereotypeApplication(stereotype);
		}
		return null;

	}

	/**
	 * Return the stereotype application by passing an element of the static profile
	 * 
	 * @param element
	 *        the UML model element
	 * @param clazz
	 *        the class of an element of a static profile. Compatible sub-types will be returned as well
	 * @return the stereotype application or null
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getApplication(Element element, java.lang.Class<T> clazz) {
		for(EObject stereoApplication : element.getStereotypeApplications()) {
			// check whether the stereotype is an instance of the passed parameter clazz
			if(clazz.isInstance(stereoApplication)) {
				return (T)stereoApplication;
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
			return getApplication(element, clazz);
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
		return apply(element, getStereoName(clazz));
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
		unapply(element, getStereoName(clazz));
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
		return applyExact(element, getStereoName(clazz));
	}

	public static Stereotype getStereo(Element element, java.lang.Class<? extends EObject> clazz) {
		return element.getAppliedStereotype(getStereoName(clazz));
	}

	public static String getStereoName(java.lang.Class<? extends EObject> clazz) {
		String name = clazz.getName();
		if(name.startsWith("org.eclipse.papyrus.MARTE")) {
			// MARTE classes are prefixed with "org.eclipse.papyrus" which does not belong
			// to the stereotype name
			name = name.substring("org.eclipse.papyrus.".length());
		}
		return name.replace(".", "::");
	}
}
