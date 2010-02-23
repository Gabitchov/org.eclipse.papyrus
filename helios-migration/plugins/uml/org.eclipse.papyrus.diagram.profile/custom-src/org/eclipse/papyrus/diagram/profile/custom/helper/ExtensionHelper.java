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

import java.util.ArrayList;

import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Extension;

/**
 * Helper for the Extensions
 */
public class ExtensionHelper extends ElementHelper {

	/**
	 * the extension's name begins by this string
	 */
	final static public String EXTENSION = "Extension_"; //$NON-NLS-1$

	/**
	 * the property's name in the stereotype begins by base_
	 */
	final static public String BASE = "base_"; //$NON-NLS-1$

	/**
	 * 
	 * 
	 * @param metaclass
	 * @return the command to destroy the metaclass, the metaclass's extension and the stereotype's property
	 */
	static public Command getDestroyExtensionCommand(Class metaclass) {
		CompoundCommand cc = new CompoundCommand("Destroy Extension"); //$NON-NLS-1$

		/**
		 * get all the extension of the metaclass
		 * /!\ some of them comes from the metamodel UML
		 */

		EList<Extension> extensionList = metaclass.getExtensions();


		/**
		 * get the extension to destroy
		 * 
		 * All the user's extension have this name : Extension_xxx
		 */
		ArrayList<Extension> extensionsToDestroy = new ArrayList<Extension>();
		for(Extension extension : extensionList) {
			if(extension.getName().contains(ExtensionHelper.EXTENSION)) {
				extensionsToDestroy.add(extension);

			}
		}

		/**
		 * Destroy the property in the stereotypes
		 */
		for(int iterExt = 0; iterExt < extensionsToDestroy.size(); iterExt++) {
			cc.add(StereotypeHelper.getRemovePropertyCommand(extensionsToDestroy.get(iterExt)));
		}
		/**
		 * Destroy the extensions
		 */
		for(Extension extension : extensionsToDestroy) {
			DestroyElementRequest destroyElementRequest = new DestroyElementRequest(extension, false);
			DestroyElementCommand destroyElementCommand = new DestroyElementCommand(destroyElementRequest);
			cc.add(new ICommandProxy(destroyElementCommand));

		}
		if(cc.isEmpty()) {
			//this command do nothing!
			cc.add(new EMFtoGEFCommandWrapper(new IdentityCommand()));
		}
		return cc;

	}
}
