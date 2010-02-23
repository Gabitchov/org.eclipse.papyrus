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


package org.eclipse.papyrus.diagram.profile.custom.policies.itemsemantic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.profile.custom.helper.StereotypeHelper;
import org.eclipse.papyrus.diagram.profile.edit.policies.ExtensionItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Extension;


/**
 * This editPolicy removes the property matching to the extension in the stereotype
 * 
 * @author VL222926
 * 
 */
public class CustomExtensionItemSemanticEditPolicy extends ExtensionItemSemanticEditPolicy {

	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = new CompoundCommand("Destroy Extension"); //$NON-NLS-1$
		EObject elementToDestroy = req.getElementToDestroy();
		if(elementToDestroy instanceof Extension) {
			cc.add(StereotypeHelper.getRemovePropertyCommand((Extension)elementToDestroy));
		}
		return cc;
	}
}
