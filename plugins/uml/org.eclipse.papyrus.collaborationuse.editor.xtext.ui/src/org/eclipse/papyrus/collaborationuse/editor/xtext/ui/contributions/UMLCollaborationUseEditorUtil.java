/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.collaborationuse.editor.xtext.validation.UmlCollaborationUseJavaValidator;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.papyrus.umlutils.TypeUtil;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;

/**
 * 
 * This class provides method to manipulate {@link CollaborationUse}
 * 
 */
public class UMLCollaborationUseEditorUtil {

	/**
	 * Returns a String representing the {@link CollaborationUse}
	 * 
	 * @param collaborationUse
	 *        the {@link CollaborationUse}
	 * @return
	 *         A String representing the {@link CollaborationUse}
	 */
	public static String getLabel(CollaborationUse collaborationUse) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" "); //$NON-NLS-1$
		buffer.append(NamedElementUtil.getVisibilityAsSign(collaborationUse));

		// name
		buffer.append(" "); //$NON-NLS-1$
		buffer.append(getName(collaborationUse));

		// type
		if(collaborationUse.getType() != null) {
			buffer.append(" : " + getTypeLabel(collaborationUse.getType())); //$NON-NLS-1$
		} else {
			buffer.append(" : " + TypeUtil.UNDEFINED_TYPE_NAME); //$NON-NLS-1$
		}
		return buffer.toString();
	}

	/**
	 * Returns the name of the {@link CollaborationUse}
	 * 
	 * @param collaborationUse
	 *        the {@link CollaborationUse}
	 * @return
	 *         The name of the {@link CollaborationUse}
	 */
	public static String getName(CollaborationUse collaborationUse) {
		if(collaborationUse.getName() != null) {
			return collaborationUse.getName();
		} else {
			return (NamedElementUtil.getDefaultNameWithIncrement(collaborationUse));
		}
	}

	/**
	 * Returns a string representing the Type of the {@link CollaborationUse}
	 * 
	 * @param type
	 *        the type of the CollaborationUse
	 * @return
	 *         A string representing the Type of the {@link CollaborationUse}
	 */
	public static String getTypeLabel(Type type) {
		String label = ""; //$NON-NLS-1$

		Namespace model = UmlCollaborationUseJavaValidator.getInstance().getModel();
		List<Package> importedPackages = new ArrayList<Package>(model.getImportedPackages());

		List<Package> visitedPackages = new ArrayList<Package>();
		Package currentPackage = type.getNearestPackage();

		boolean rootFound = false;

		while(currentPackage != null && !rootFound) {
			visitedPackages.add(currentPackage);
			if(importedPackages.contains(currentPackage) || currentPackage == model) {
				rootFound = true;
			}
			Element owner = currentPackage.getOwner();
			while(owner != null && !(owner instanceof Package))
				owner = owner.getOwner();

			currentPackage = owner != null ? (Package)owner : null;
		}

		for(int i = visitedPackages.size() - 1; i >= 0; i--) {
			label += visitedPackages.get(i).getName() + "::"; //$NON-NLS-1$
		}

		return label + type.getName();
	}
}
