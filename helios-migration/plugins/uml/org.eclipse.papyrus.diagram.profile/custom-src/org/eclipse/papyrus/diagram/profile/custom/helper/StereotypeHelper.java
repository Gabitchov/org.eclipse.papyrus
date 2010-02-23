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


package org.eclipse.papyrus.diagram.profile.custom.helper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * Helper for the stereotypes
 * 
 * 
 */
public class StereotypeHelper extends ElementHelper {

	/**
	 * This method removes the property associated to the extension in the stereotype
	 * 
	 * @param extension
	 * @return
	 */
	static public Command getRemovePropertyCommand(Extension extension) {
		CompoundCommand cc = new CompoundCommand("Destroy StereotypeProperty"); //$NON-NLS-1$
		/**
		 * get the ownedEnd
		 */
		ExtensionEnd extEnd = null;
		if(extension.getOwnedEnds().size() > 0) {
			extEnd = (ExtensionEnd)extension.getOwnedEnds().get(0);
		}

		/**
		 * get the stereotype
		 */
		Stereotype ste = null;
		Type type = null;
		if(extEnd != null) {
			type = extEnd.getType();
		}

		/**
		 * Destroy the property in the stereotype
		 */
		if(type instanceof Stereotype) {
			String tmp = type.getQualifiedName();
			ste = (Stereotype)type;
			EList<Property> propertyList = ste.getOwnedAttributes();
			for(int iterProperty = 0; iterProperty < propertyList.size(); iterProperty++) {
				Association propAssoc = propertyList.get(iterProperty).getAssociation();
				if(extension == propAssoc) {
					//it's the good property, we need to destroy it!
					DestroyElementRequest destroyElementRequest = new DestroyElementRequest(propertyList.get(iterProperty), false);
					DestroyElementCommand destroyElementCommand = new DestroyElementCommand(destroyElementRequest);
					cc.add(new ICommandProxy(destroyElementCommand));
				}
			}
		}
		return cc;
	}
}
