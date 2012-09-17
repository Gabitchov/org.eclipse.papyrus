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
package org.eclipse.papyrus.uml.diagram.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
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
	 * Retrieve an arraylist of all instances in the model that are instances of
	 * the java.lang.Class metaType or with a stereotype applied
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
		// Package topPackage = Util.topPackage(element);
		// Assert.isNotNull(topPackage,
		// "Top package should not be null for element " + element);
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
	 * This method is used to look for the top package that contains this
	 * element.
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

	/**
	 * This method is used to look for the nearest common parent of two
	 * elements.
	 * 
	 * @param element1
	 *        the first element to find a parent
	 * @param element2
	 *        the other element to find a parent
	 * @param parentClass
	 *        the class the common parent must be (otherwise, search in its
	 *        parents)
	 * @return the common parent (not element1 or element2 themselves) or null
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Element> T getCommonParent(Element element1, Element element2, Class<T> parentClass) {
		// compute depth of each element
		int depth1 = 0;
		Element ancestor1 = element1.getOwner();
		while(ancestor1 != null) {
			depth1++;
			ancestor1 = ancestor1.getOwner();
		}
		int depth2 = 0;
		Element ancestor2 = element2.getOwner();
		while(ancestor2 != null) {
			depth2++;
			ancestor2 = ancestor2.getOwner();
		}
		// reset to direct parents
		ancestor1 = element1.getOwner();
		ancestor2 = element2.getOwner();
		// explore owners from bottom to top to find common parent
		Element commonParent = null;
		while(depth1 > 0 && depth2 > 0 && commonParent == null) {
			if(depth1 > depth2) {
				ancestor1 = ancestor1.getOwner();
				depth1--;
			} else if(depth2 > depth1) {
				ancestor2 = ancestor2.getOwner();
				depth2--;
			} else {
				// depth1 == depth2
				if(ancestor1 == ancestor2) {
					commonParent = ancestor1;
				} else {
					ancestor1 = ancestor1.getOwner();
					depth1--;
					ancestor2 = ancestor2.getOwner();
					depth2--;
				}
			}
		}
		// find common parent with correct class
		while(commonParent != null && !parentClass.isInstance(commonParent)) {
			commonParent = commonParent.getOwner();
		}
		return (T)commonParent;
	}

	/**
	 * This function refind the value from a string for the following types :
	 * <ul>
	 * <li>Boolean</li>
	 * <li>Integer</li>
	 * <li>String</li>
	 * <li>UnlimitedNatural</li>
	 * <li>DataType</li>
	 * </ul>
	 * 
	 * @param property
	 *        : the property to edit
	 * @param propertyValue
	 *        : the value to find
	 * @return the set of value to apply to the property
	 * 
	 */
	public static Object getValueFromString(Property property, ArrayList<String> stringValues) {
		ArrayList returnedValue = new ArrayList();

		Type type = property.getType();
		if(type instanceof PrimitiveType) {
			if(type.getQualifiedName().equals("UMLPrimitiveTypes::Integer")) {
				for(int i = 0; i < stringValues.size(); i++) {
					returnedValue.add(Integer.valueOf(stringValues.get(i)));
				}
			} else if(type.getQualifiedName().equals("UMLPrimitiveTypes::UnlimitedNatural")) {
				for(int i = 0; i < stringValues.size(); i++) {
					returnedValue.add(Integer.valueOf(stringValues.get(i)));
				}
			} else if(type.getQualifiedName().equals("UMLPrimitiveTypes::String")) {
				for(int i = 0; i < stringValues.size(); i++) {
					returnedValue.add(stringValues.get(i));
				}
			} else if(type.getQualifiedName().equals("UMLPrimitiveTypes::Boolean")) {
				for(int i = 0; i < stringValues.size(); i++) {
					returnedValue.add(Boolean.valueOf(stringValues.get(i)));
				}
			} else { // user defined primitive type
				for(int i = 0; i < stringValues.size(); i++) {
					returnedValue.add(stringValues.get(i));
				}
			}
		} else if(type instanceof DataType) {
			for(int i = 0; i < stringValues.size(); i++) {
				returnedValue.add(stringValues.get(i));
			}
		}

		if(property.getUpper() == 1) {
			return returnedValue.get(0);
		}
		return returnedValue;
	}

	/**
	 * 
	 * @param property
	 *        : the property to edit
	 * @param propertyValue
	 *        : the value to find
	 * @param objectToEdit
	 * @return the set of the element representing the value to apply to the
	 *         property or <code>null</code>
	 * 
	 */
	public static Object retrievesMetaclassElementFromString(Property property, ArrayList<String> stringValues, org.eclipse.uml2.uml.Element packageContainer) {

		// the applied profiles
		EList<Profile> profiles = ((org.eclipse.uml2.uml.Package)packageContainer).getAllAppliedProfiles();
		ArrayList<Object> returnedValues = new ArrayList<Object>();
		ArrayList<Object> metaclassElement = new ArrayList<Object>();
		String metaclassName = ((org.eclipse.uml2.uml.Class)property.getType()).getName();

		/*
		 * we research all the representation of the metaclass in the Profiles
		 */
		// Try to retrieve type of the metaclass
		java.lang.Class metaType = null;
		try {
			metaType = java.lang.Class.forName("org.eclipse.uml2.uml." + metaclassName); //$NON-NLS-1$
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Profile profile : profiles) {
			metaclassElement.addAll(Util.getInstancesFilteredByType(profile, metaType, null));
		}

		/*
		 * we retrieve the element with its QualifiedName
		 */

		for(String valuesQualifiedName : stringValues) {
			for(Object metaclassRepresentation : metaclassElement) {
				if(metaclassRepresentation instanceof NamedElement) {
					if(((NamedElement)metaclassRepresentation).getQualifiedName().equals(valuesQualifiedName)) {
						((ArrayList)returnedValues).add(metaclassRepresentation);
					}
				}
			}

		}

		if(property.getUpper() != 1) {
			return returnedValues;
		} else if(returnedValues.size() > 0) {
			return returnedValues.get(0);
		}
		return null;
	}

	/**
	 * 
	 * @param property
	 *        : the property to edit
	 * @param propertyValue
	 *        : the value to find
	 * @return the set of the stereotyped element to apply to the property or <code>null</code>
	 * 
	 */
	public static Object retrievesStereotypedElementFromString(Property property, ArrayList<String> stringValues, org.eclipse.uml2.uml.Element packageContainer) {

		ArrayList<Object> returnedValues = new ArrayList<Object>();
		ArrayList<Object> stereotypedElement = new ArrayList<Object>();

		EList<Profile> profiles = ((org.eclipse.uml2.uml.Package)packageContainer).getAllAppliedProfiles();
		/*
		 * we research all the representation of the stereotype in the Profiles
		 */
		for(Profile profile : profiles) {
			stereotypedElement.addAll(Util.getInstancesFilteredByType(profile, null, (Stereotype)property.getType()));
		}

		/*
		 * we retrieve the element with its QualifiedName
		 */
		for(String valuesQualifiedName : stringValues) {
			for(Object element : stereotypedElement) {
				if(element instanceof NamedElement) {
					if(((NamedElement)element).getQualifiedName().equals(valuesQualifiedName)) {

						// Like in AppliedStereotypePropertyEditor
						EObject newValue = ((NamedElement)element).getStereotypeApplication((Stereotype)property.getType());
						if(newValue == null) {
							List<?> subStereotypes = ((NamedElement)element).getAppliedSubstereotypes((Stereotype)property.getType());
							if(!subStereotypes.isEmpty()) {
								newValue = ((NamedElement)element).getStereotypeApplication((Stereotype)subStereotypes.get(0));
							}
						}
						// Like in StereotypeValueTreeObject
						if(newValue != null) {

							returnedValues.add(newValue);

						}
						returnedValues.add(element);
						break;
					}
				} else {
					// TODO for the element which aren't NamedElement
				}
			}
		}

		if(property.getUpper() != 1) {
			return returnedValues;
		} else if(returnedValues.size() > 0) {
			return returnedValues.get(0);
		}
		return null;

	}

	/**
	 * 
	 * @param property
	 *        : the property to edit
	 * @param propertyValue
	 *        : the value to find
	 * @return the set of EnumerationLiteral to apply to the property
	 * 
	 */
	public static Object retrievesEnumerationLiteralFromString(Property property, ArrayList<String> stringValues, org.eclipse.uml2.uml.Element packageContainer) {
		Enumeration enume = null;
		
		Type type = property.getType();
		Assert.isTrue(type instanceof Enumeration);
		enume = (Enumeration) type;

		ArrayList<Object> returnedValues = new ArrayList<Object>();

		// we research the enumerationLiteral
		for(int i = 0; i < stringValues.size(); i++) {
			Object obj = enume.getOwnedLiteral(stringValues.get(i));
			returnedValues.add(obj);
		}

		if(property.getUpper() != 1) {
			return returnedValues;
		} else if(returnedValues.size() > 0) {
			return returnedValues.get(0);
		}
		return null;
	}

	/**
	 * Test if an EditPart is an Affixed Child Node or not
	 * 
	 * @param ep
	 *        an editpart
	 * @return <ul>
	 *         <li> <code>true</code> if the editpart is an Affixed Child Node</li>
	 *         <li> <code>false</code>if not</li>
	 *         </ul>
	 */
	public static boolean isAffixedChildNode(EditPart ep) {
		if(ep instanceof BorderedBorderItemEditPart) {
			if(ep.getParent() instanceof CompartmentEditPart) {
				return false;
			} else if(ep.getParent() instanceof DiagramEditPart) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Returns a {@link Set} owning all the level of super classes for the
	 * Classifier With this method we don't have loop problems with {@link Generalization}
	 * 
	 * @param visitedClassifier
	 *        the list of the visited Classifier (can be <code>null</code>)
	 * @param clazz
	 *        the classifier to visit
	 * @return a {@link Set} owning all the level of super classes for the
	 *         Classifier
	 */
	public static Set<Classifier> getAllSuperClasses(Set<Classifier> visitedClassifier, Classifier clazz) {
		Assert.isNotNull(clazz);
		if(visitedClassifier == null) {
			visitedClassifier = new HashSet<Classifier>();
		}
		for(Classifier classifier : clazz.getGenerals()) {
			if(!visitedClassifier.contains(classifier)) {
				visitedClassifier.add(classifier);
				visitedClassifier.addAll(getAllSuperClasses(visitedClassifier, classifier));
			}
		}
		return visitedClassifier;
	}
}
