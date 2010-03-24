/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Modification
 *  
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.util;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;


/**
 * Some utils extracted from org.eclipse.papyrus.profile.utils
 */
public class Util {



	/**
	 * Check if a type is a metaclass.
	 * 
	 * @param type
	 *        to check
	 * 
	 * @return true if type is metaclass, else false
	 */
	public static boolean isMetaclass(Type type) {
		boolean isMetaclass = false;

		if((type instanceof org.eclipse.uml2.uml.Class) && (type.getAppliedStereotypes() != null) && (type.getAppliedStereotypes().size() > 0)) {

			Stereotype firstStereotype = type.getAppliedStereotypes().get(0);

			if(firstStereotype.getName().equals("Metaclass")) {
				isMetaclass = true;
			}
		}
		return isMetaclass;
	}


	/**
	 * Retrieve an arraylist of all instances in the model that
	 * are instances of the java.lang.Class metaType or with a
	 * stereotype applied
	 * 
	 * @param metaType
	 *        selected classes
	 * @param model
	 *        to check
	 * @param appliedStereotype
	 *        may be null, metatype is ignored if not null
	 * @return an arraylist containing the selected instances
	 */
	public static ArrayList getInstancesFilteredByType(Package topPackage, Class metaType, Stereotype appliedStereotype) {
		// retrieve parent element
		//		Package topPackage = Util.topPackage(element);
		//		Assert.isNotNull(topPackage, "Top package should not be null for element " + element);
		Iterator iter = topPackage.eAllContents();
		ArrayList filteredElements = new ArrayList();

		while(iter.hasNext()) {
			Object currentElt = iter.next();

			// If currentElt is an ElementImport, it is replaced by the imported 
			// Element.
			if(currentElt instanceof ElementImport) {
				ElementImport elementImport = (ElementImport)currentElt;
				currentElt = elementImport.getImportedElement();
			}

			/* package imports treatment */
			else if(currentElt instanceof PackageImport) {
				Iterator piIter = ((PackageImport)currentElt).getImportedPackage().eAllContents();
				while(piIter.hasNext()) {
					Object piCurrentElt = piIter.next();
					if(piCurrentElt instanceof Element) {
						if(appliedStereotype != null) {


							Iterator appStIter = ((Element)piCurrentElt).getAppliedStereotypes().iterator();
							while(appStIter.hasNext()) {
								Stereotype currentSt = (Stereotype)appStIter.next();

								if(currentSt.conformsTo(appliedStereotype)) {
									filteredElements.add(piCurrentElt);
								}
							}

						} else { // if (appliedStereotype == null)
							if(metaType.isInstance(piCurrentElt)) {
								filteredElements.add(piCurrentElt);
							}

							/** add imported meta elements */
							else if(piCurrentElt instanceof ElementImport) {
								Iterator eIter = ((ElementImport)piCurrentElt).getImportedElement().eAllContents();
								while(eIter.hasNext()) {
									Object currentEIelt = eIter.next();
									if(metaType.isInstance(currentEIelt))
										filteredElements.add(currentEIelt);
								}
							}
						}
					}

				}
			}


			// Filtering elements
			if(currentElt instanceof Element) {

				if(appliedStereotype != null) {

					Iterator appStIter = ((Element)currentElt).getAppliedStereotypes().iterator();
					while(appStIter.hasNext()) {
						Stereotype currentSt = (Stereotype)appStIter.next();

						if(currentSt.conformsTo(appliedStereotype)) {
							filteredElements.add(currentElt);
						}
					}

				} else { // if (appliedStereotype == null)
					if(metaType.isInstance(currentElt)) {
						filteredElements.add(currentElt);
					}

					/** add imported meta elements */
					else if(currentElt instanceof ElementImport) {
						Iterator eIter = ((ElementImport)currentElt).getImportedElement().eAllContents();
						while(eIter.hasNext()) {
							Object currentEIelt = eIter.next();
							if(metaType.isInstance(currentEIelt))
								filteredElements.add(currentEIelt);
						}
					}
				}
			}
		}


		return filteredElements;
	}


	/**
	 * This method is used to look for the top package that contains this element.
	 * 
	 * @param element
	 *        the element for which top package must be returned
	 * @return the top package
	 */
	public static Package topPackage(Element element) {
		if(element.getOwner() == null) {
			return (Package)element;
		} else {
			return topPackage(element.getOwner());
		}
	}

}
