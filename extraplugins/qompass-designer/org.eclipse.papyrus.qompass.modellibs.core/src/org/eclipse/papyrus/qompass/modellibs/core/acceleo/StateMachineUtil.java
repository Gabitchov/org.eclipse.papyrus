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

package org.eclipse.papyrus.qompass.modellibs.core.acceleo;

import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.UMLTool;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Type;


public class StateMachineUtil {

	/**
	 * Return the bound package in the context of template instantiation for a given actual.
	 * 
	 * This is required by the state machine template which needs to access operation IDs
	 * provided by the call interceptor.
	 * 
	 * @param actual The actual for template binding
	 * @return
	 */
	public static Package boundPackageRef(Type actual) {
		for(Package nestedPkg : Utils.getTop(actual).getNestedPackages()) {
			if(nestedPkg.getTemplateBindings().size() > 0) {
				TemplateBinding binding = nestedPkg.getTemplateBindings().get(0);
				if (actual == TemplateUtils.getFirstActualFromBinding(binding)) {
					return nestedPkg;
				}
			}
		}
		return null;
	}
	
	/**
	 * Declares a dependency from the current classifier which is produced by template instantiation
	 * to the element (enum) "OperationIDs", if found within the passed package.
	 * Called by Acceleo script "acceptableEvents.mtl".
	 * @param pkg
	 * @return
	 */
	public static void declareDependencyToOperationIDs(Package pkg) {
		PackageableElement type = pkg.getPackagedElement("OperationIDs"); //$NON-NLS-1$
		if(type instanceof Type) {
			UMLTool.declareDependency(TransformationContext.classifier, (Type)type);
		}
	}
	
	/**
	 * Declares a dependency from the current classifier which is produced by template instantiation
	 * to the element (enum) "SignalIDs", if found within the passed package.
	 * Called by Acceleo script "acceptableEvents.mtl".
	 * @param pkg the package in which an enumeration is looked up
	 * @return
	 */
	public static void declareDependencyToSignalIDs(Package pkg) {
		PackageableElement type = pkg.getPackagedElement("SignalIDs"); //$NON-NLS-1$
		if(type instanceof Type) {
			UMLTool.declareDependency(TransformationContext.classifier, (Type)type);
		}
	}
}
