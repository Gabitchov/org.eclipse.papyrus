/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ElementUtil {


	/**
	 * Check if the StereotypedElement has the given stereotype, or if one of
	 * its stereotype is inherits from the stereotype passed in parameter. This
	 * method currently exists in UMLUtils, this one is a copy created to avoid
	 * some dependencies propagated by UMLUtils (jface...). Current UMLUtils
	 * plug-in should probably be separated into two parts one depending on UML2
	 * plug-in only, and the other bringing ui related features;
	 * 
	 * @deprecated prefer using {@link UMLUtil#getStereotypeApplication(Element, Class)}
	 */
	@Deprecated
	public static EObject hasStereotype(Element elt, EClass stereotypeClass) {
		return UMLUtil.getStereotypeApplication(elt, stereotypeClass.getClass());
	}

	/**
	 * Convenient method to retrieve the StereotypeApplication by passing an
	 * element of the static profile.
	 * 
	 * @deprecated prefer using {@link UMLUtil#getStereotypeApplication(Element, Class)}
	 */
	@Deprecated
	public static <T extends EObject> T getStereotypeApplication(Element element, java.lang.Class<T> clazz) {
		return UMLUtil.getStereotypeApplication(element, clazz);
	}

	/**
	 * Getter to select an image for a stereotyped element (based on 1st applied stereotype)
	 * 
	 * @param element
	 *        the element for which we are looking the icon
	 * @param stereotype
	 *        the stereotype that should have the icon
	 * @param kind
	 *        kind of display, should be <code>"icon"</code> or <code>"shape"</code>
	 * @return the image corresponding to the stereotype or <code>null</code> if no image can be
	 *         found
	 */
	public static Image getStereotypeImage(Element element, Stereotype stereotype, String kind) {
		if(stereotype == null || element.getAppliedStereotypes() == null) {
			return null;
		}

		Image image = null;

		// Try to retrieve image based on getter implemented in static profile
		image = ElementUtil.getStereotypeImageFromGetter(element, stereotype, kind);

		if(image == null) {
			// No image found by getters
			// Search for the image verifying expressions
			EList<Image> availableImages = new BasicEList<Image>();
			if("icon".equals(kind)) {
				availableImages = StereotypeUtil.getIcons(stereotype);
			} else if("shape".equals(kind)) {
				availableImages = StereotypeUtil.getShapes(stereotype);
			}

			if(!(availableImages).isEmpty()) {
				// Retrieve first image verifying expression or
				// first image if no expression is verified
				image = ImageUtil.findImageVerifyingExpression(element, availableImages);

				if(image == null) {
					image = availableImages.get(0);
				}
			}
		}

		return image;
	}

	/**
	 * Getter to select an image for a stereotyped element (based on 1st applied stereotype)
	 * 
	 * @param element
	 *        to check
	 * @param kind
	 *        of image ("icon" | "shape")
	 * @return {@link Image} or null
	 */
	public static Image getStereotypeImage(Element element, String kind) {
		// Get first stereotype
		if(element.getAppliedStereotypes() == null || element.getAppliedStereotypes().isEmpty()) {
			return null; // null
		}

		// The image is one of the 1st stereotype
		Stereotype stereotype = element.getAppliedStereotypes().get(0);

		return getStereotypeImage(element, stereotype, kind);
	}

	/**
	 * Find the image using a getter implemented in a static profile
	 * 
	 * @param element
	 *        the stereotyped element
	 * @param stereotype
	 *        the applied stereotype
	 * @param kind
	 *        the kind of searched image ("icon" | "shape")
	 * @return {@link Image} or null
	 */
	public static Image getStereotypeImageFromGetter(Element element, Stereotype stereotype, String kind) {

		// Prepare getter method name
		String getterName = "";
		if("icon".equals(kind)) {
			getterName += "getIcon";

		} else if("shape".equals(kind)) {
			getterName += "getShape";

		} else {
			// Unknown kind : abort and return null (no image)
			return null;
		}

		// If the getter is implemented, it is implemented by the
		// StereotypeApplication class
		EObject stApp = element.getStereotypeApplication(stereotype);
		Method getter = null;
		try {
			getter = stApp.getClass().getDeclaredMethod(getterName);
		} catch (Exception e) {
			// Implementation not found
		}

		// If the getter exists, invoke
		if(getter != null) {
			try {

				// Retrieve image via getter in static profile
				Image image = (Image)getter.invoke(stApp);

				return image;

			} catch (Exception e) {
				// Invoke getter has failed
				return null;
			}
		}

		return null;
	}

	/**
	 * Test if the element has stereotype icons to display
	 * 
	 * @param element
	 *        the element for which icon are searched
	 * @return <code>true</code> if icons were found
	 */
	public static boolean hasIcons(Element element) {
		if(!element.getAppliedStereotypes().isEmpty()) {
			return hasIcons(element, element.getAppliedStereotypes().get(0));
		}
		return false;
	}

	/**
	 * Test if the element has icons for the given stereotype
	 * 
	 * @param stereotype
	 *        the stereotype we check to see if it has icon or not
	 * @param element
	 *        the stereotyped element
	 * @return <code>true</code> if icons were found
	 */
	public static boolean hasIcons(Element element, Stereotype stereotype) {
		return stereotype != null && !StereotypeUtil.getIcons(stereotype).isEmpty();
	}

	/**
	 * Test if the element has stereotype shape to display
	 * 
	 * @param element
	 *        the element for which shape are searched
	 * @return <code>true</code> if shape were found
	 */
	// @unused
	public static boolean hasShapes(Element element) {
		if(!element.getAppliedStereotypes().isEmpty()) {
			return hasShapes(element, element.getAppliedStereotypes().get(0));
		}
		return false;
	}

	/**
	 * Test if the stereotype has shapes
	 * 
	 * @param stereotype
	 * @return true if shapes were found
	 */
	public static boolean hasShapes(Element element, Stereotype stereotype) {
		return stereotype != null && !StereotypeUtil.getShapes(stereotype).isEmpty();
	}

	/**
	 * look for all metaclasses of the meta model UML2 for a profile.
	 * 
	 * @param element
	 *        the profile which needs the metaclasses list
	 * @return the possible metaclasses
	 */
	// @unused
	public static List<org.eclipse.uml2.uml.Class> getPossibleMetaclasses(Element element) {
		List<org.eclipse.uml2.uml.Class> metaList = new ArrayList<org.eclipse.uml2.uml.Class>();
		List<Type> metaclasses = getMetaclasses(element); // get all type of the
		// metaclass

		for(int i = 0; i < metaclasses.size(); i++) {
			if(metaclasses.get(i) instanceof org.eclipse.uml2.uml.Class) {
				metaList.add((org.eclipse.uml2.uml.Class)metaclasses.get(i));
			}
		}

		return metaList;
	}

	/**
	 * return all type contained in the metamodel UML2. Elements in the list are the UML2
	 * representation of the concepts of the metamodel. each element of the list must be casted with
	 * org.eclipse.uml2.Classifier
	 * 
	 * @return list of metaclasses of the metamodel UML2
	 */
	public static List<Type> getMetaclasses(Element element) {
		if(element == null) {
			System.err.println("element should not be null to retrieve metaclasses");
		}
		org.eclipse.uml2.uml.Package uml2Metamodel = contentload(URI.createURI(UMLResource.UML_METAMODEL_URI), element);

		return uml2Metamodel.getOwnedTypes();
	}

	/**
	 * Loads content for the given URI, and returns the top package of this content.
	 * 
	 * @param uri
	 *        the uri of the content to load
	 * @param element
	 *        the Element used to retrieve ResourceSet
	 * @return the top package of the loaded content
	 */
	public static org.eclipse.uml2.uml.Package contentload(URI uri, Element element) {
		ResourceSet resourceSet = element.eResource().getResourceSet();
		org.eclipse.uml2.uml.Package package_ = null;
		try {
			Resource resource = resourceSet.getResource(uri, true);

			package_ = (org.eclipse.uml2.uml.Package)EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.eINSTANCE.getPackage());
		} catch (WrappedException we) {
			Activator.logError("impossible to load content for URI: " + uri);
		}

		return package_;
	}

	/**
	 * Retrieve an list of all instances in the model that are instances of
	 * the java.lang.Class metaType or with a stereotype applied
	 * 
	 * @param <T>
	 * 
	 * @param metaType
	 *        selected classes
	 * @param model
	 *        to check
	 * @param appliedStereotype
	 *        may be null, metatype is ignored if not null
	 * @return a list containing the selected instances
	 */
	//duplicated code from /org.eclipse.papyrus.uml.diagram.common/src/org/eclipse/papyrus/uml/diagram/common/util/Util.java
	//+add template to this method
	@SuppressWarnings("unchecked")
	public static final <T extends EObject> List<T> getInstancesFilteredByType(final Package topPackage, final java.lang.Class<T> metaType, final Stereotype appliedStereotype) {
		// retrieve parent element
		// Package topPackage = Util.topPackage(element);
		// Assert.isNotNull(topPackage,
		// "Top package should not be null for element " + element);
		Iterator<EObject> iter = topPackage.eAllContents();
		List<T> filteredElements = new ArrayList<T>();

		while(iter.hasNext()) {
			EObject currentElt = iter.next();

			// If currentElt is an ElementImport, it is replaced by the imported
			// Element.
			if(currentElt instanceof ElementImport) {
				ElementImport elementImport = (ElementImport)currentElt;
				currentElt = elementImport.getImportedElement();
			}

			/* package imports treatment */
			else if(currentElt instanceof PackageImport) {
				Package importedPackage = ((PackageImport)currentElt).getImportedPackage();
				if(importedPackage != null) {
					Iterator<EObject> piIter = importedPackage.eAllContents();
					while(piIter.hasNext()) {
						EObject piCurrentElt = piIter.next();
						if(piCurrentElt instanceof Element) {
							if(appliedStereotype != null) {

								Iterator<Stereotype> appStIter = ((Element)piCurrentElt).getAppliedStereotypes().iterator();
								while(appStIter.hasNext()) {
									Stereotype currentSt = appStIter.next();

									if(currentSt.conformsTo(appliedStereotype)) {
										filteredElements.add((T)piCurrentElt);
									}
								}

							} else { // if (appliedStereotype == null)
								if(metaType.isInstance(piCurrentElt)) {
									filteredElements.add((T)piCurrentElt);
								}

								/** add imported meta elements */
								else if(piCurrentElt instanceof ElementImport) {
									Element importedElement = ((ElementImport)piCurrentElt).getImportedElement();
									if(importedElement != null) {
										Iterator<EObject> eIter = importedElement.eAllContents();
										while(eIter.hasNext()) {
											EObject currentEIelt = eIter.next();
											if(metaType.isInstance(currentEIelt)) {
												filteredElements.add((T)currentEIelt);
											}
										}
									}
								}
							}
						}

					}
				}
			}

			// Filtering elements
			if(currentElt instanceof Element) {

				if(appliedStereotype != null) {

					Iterator<Stereotype> appStIter = ((Element)currentElt).getAppliedStereotypes().iterator();
					while(appStIter.hasNext()) {
						Stereotype currentSt = appStIter.next();

						if(currentSt.conformsTo(appliedStereotype)) {
							filteredElements.add((T)currentElt);
						}
					}

				} else { // if (appliedStereotype == null)
					if(metaType.isInstance(currentElt)) {
						filteredElements.add((T)currentElt);
					}

					/** add imported meta elements */
					else if(currentElt instanceof ElementImport) {
						Iterator<EObject> eIter = ((ElementImport)currentElt).getImportedElement().eAllContents();
						while(eIter.hasNext()) {
							EObject currentEIelt = eIter.next();
							if(metaType.isInstance(currentEIelt)) {
								filteredElements.add((T)currentEIelt);
							}
						}
					}
				}
			}
		}

		return filteredElements;
	}

}
