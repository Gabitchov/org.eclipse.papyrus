/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A Helper class for UML
 * 
 * @author Camille Letavernier
 */
public class UMLUtil {

	/**
	 * Retrieve the UML semantic element from the given Object
	 * 
	 * @param source
	 *        The Object to resolve
	 * @return
	 *         The UML semantic element, or null if it couldn't be resolved
	 */
	public static Element resolveUMLElement(Object source) {
		EObject eElement = null;
		if(source instanceof EObject) {
			eElement = (EObject)source;
		}
		if(source instanceof IAdaptable) {
			eElement = (EObject)((IAdaptable)source).getAdapter(EObject.class);
		}

		if(EMFHelper.isInstance(eElement, "Element", umlMetamodel)) { //$NON-NLS-1$
			return (Element)eElement;
		}

		return null;
	}

	/**
	 * Tests if a class is a subclass of another class. The classes are described
	 * by their className, in the UML Metamodel.
	 * 
	 * @param className
	 * @param superclassName
	 * @return
	 *         True if the class className is a subclass of the class superclassName
	 */
	public static boolean isSubClass(String className, String superclassName) {
		EClass eClass = (EClass)umlMetamodel.getEClassifier(className);
		EClass superClass = (EClass)umlMetamodel.getEClassifier(superclassName);
		return superClass.isSuperTypeOf(eClass);
	}

	/**
	 * Retrieve the IGraphicalEditPart from the given Object
	 * 
	 * @param source
	 *        The object to resolve
	 * @return
	 *         The IGraphicalEditPart, or null if it couldn't be resolved
	 */
	public static IGraphicalEditPart resolveEditPart(Object source) {
		if(source instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart)source;
		}

		if(source instanceof IAdaptable) {
			return (IGraphicalEditPart)((IAdaptable)source).getAdapter(IGraphicalEditPart.class);
		}

		return null;
	}

	/**
	 * Retrieve the EditingDomain for the given source object
	 * 
	 * @param source
	 * @return
	 *         The source object's editing domain, or null if it couldn't be found
	 */
	public static EditingDomain resolveEditingDomain(Object source) {
		return AdapterFactoryEditingDomain.getEditingDomainFor(resolveUMLElement(source));
	}

	/**
	 * @return the UML EPackage
	 */
	public static EPackage getUMLMetamodel() {
		return umlMetamodel;
	}

	/**
	 * Search the given stereotype (By name) on the given UML Element.
	 * If the search is not strict, the name may be the qualified name of a
	 * sub-stereotype of an applied stereotype
	 * 
	 * @param umlElement
	 *        The UML Element on which the stereotype is applied
	 * @param stereotypeName
	 *        The qualified name of the stereotype
	 * @param strict
	 *        If set to true, only a stereotype matching the exact qualified name
	 *        will be returned. Otherwise, any subtype of the given stereotype may be
	 *        returned. Note that if more than one stereotype is a substype of the
	 *        given stereotype, the first matching stereotype is returned.
	 * @return
	 *         The first matching stereotype, or null if none was found
	 */
	public static Stereotype getAppliedStereotype(Element umlElement, String stereotypeName, boolean strict) {
		Stereotype stereotype = umlElement.getAppliedStereotype(stereotypeName);
		if(strict || stereotype != null)
			return stereotype;

		stereotype = umlElement.getApplicableStereotype(stereotypeName);
		if(stereotype == null) {
			return null;
		}

		for(Stereotype appliedStereotype : umlElement.getAppliedStereotypes()) {
			if(getAllSuperStereotypes(appliedStereotype).contains(stereotype)) {
				return appliedStereotype;
			}
		}

		return null;
	}

	public static Collection<Stereotype> getAllSuperStereotypes(Stereotype stereotype) {
		Set<Stereotype> result = new HashSet<Stereotype>();
		if(stereotype != null)
			getAllSuperStereotypes(stereotype, result);
		return result;
	}

	private static void getAllSuperStereotypes(Stereotype stereotype, Set<Stereotype> result) {
		result.add(stereotype);
		for(Classifier superClassifier : stereotype.getGenerals()) {
			if(superClassifier instanceof Stereotype && !result.contains(superClassifier)) {
				getAllSuperStereotypes((Stereotype)superClassifier, result);
			}
		}
	}

	private static EPackage umlMetamodel = EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/uml2/3.0.0/UML"); //$NON-NLS-1$
}
