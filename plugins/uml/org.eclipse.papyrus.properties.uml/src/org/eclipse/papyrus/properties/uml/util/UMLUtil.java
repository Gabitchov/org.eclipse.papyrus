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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.uml2.uml.Element;

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

	private static EPackage umlMetamodel = EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/uml2/3.0.0/UML"); //$NON-NLS-1$
}
