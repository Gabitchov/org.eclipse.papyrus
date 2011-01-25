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
package org.eclipse.papyrus.properties.util;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.uml2.uml.Element;

public class UMLUtil {

	public static Element resolveUMLElement(Object source) {
		EObject eElement = null;
		if(source instanceof EObject) {
			eElement = (EObject)source;
		}
		if(source instanceof IAdaptable) {
			eElement = (EObject)((IAdaptable)source).getAdapter(EObject.class);
		}

		if(EMFHelper.isSubclass(eElement, "Element", umlMetamodel)) { //$NON-NLS-1$
			return (Element)eElement;
		}

		return null;
	}

	public static boolean isSubClass(String className, String superclassName) {
		EClass eClass = (EClass)umlMetamodel.getEClassifier(className);
		EClass superClass = (EClass)umlMetamodel.getEClassifier(superclassName);
		return superClass.isSuperTypeOf(eClass);
	}

	public static IGraphicalEditPart resolveEditPart(Object source) {
		if(source instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart)source;
		}

		if(source instanceof IAdaptable) {
			return (IGraphicalEditPart)((IAdaptable)source).getAdapter(IGraphicalEditPart.class);
		}

		return null;
	}

	public static EditingDomain resolveEditingDomain(Object source) {
		return AdapterFactoryEditingDomain.getEditingDomainFor(resolveUMLElement(source));
	}

	public static EPackage getUMLMetamodel() {
		return umlMetamodel;
	}

	private static EPackage umlMetamodel = EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/uml2/3.0.0/UML"); //$NON-NLS-1$
}
