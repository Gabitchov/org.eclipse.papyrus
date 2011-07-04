/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.factory;

import org.eclipse.papyrus.customization.messages.Messages;
import org.eclipse.papyrus.customization.model.customization.CustomizableElement;
import org.eclipse.papyrus.customization.model.customization.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.model.customization.Profile;
import org.eclipse.papyrus.customization.plugin.ProjectEditor;
import org.w3c.dom.Element;


public class ProfileExtensionFactory extends FileBasedExtensionFactory {

	public ProfileExtensionFactory() {
		super(Messages.ProfileExtensionFactory_Profile, "org.eclipse.papyrus.extensionpoints.uml2.UMLProfile", "path", "profile", true); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public void addElement(CustomizableElement element, ProjectEditor editor) {
		super.addElement(element, editor);

		editor.getManifestEditor().addDependency("org.eclipse.papyrus.extensionpoints.uml2"); //$NON-NLS-1$
	}

	@Override
	protected Element createExtension(FileBasedCustomizableElement element, ProjectEditor editor) {
		Element extension = super.createExtension(element, editor);
		Profile profile = (Profile)element;

		extension.setAttribute("name", profile.getName()); //$NON-NLS-1$

		if(profile.getDescription() != null) {
			extension.setAttribute("description", profile.getDescription()); //$NON-NLS-1$
		}

		if(profile.getIconpath() != null) {
			extension.setAttribute("iconpath", profile.getIconpath()); //$NON-NLS-1$
		}

		if(profile.getProvider() != null) {
			extension.setAttribute("provider", profile.getProvider()); //$NON-NLS-1$
		}

		return extension;
	}

	@Override
	protected String getTargetPath(FileBasedCustomizableElement element) {
		return "/umlProfile/" + getFileName(element); //$NON-NLS-1$
	}

}
