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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.customization.messages.Messages;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;
import org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate;
import org.eclipse.papyrus.customization.plugin.PluginEditor;
import org.w3c.dom.Element;


public class ModelTemplateExtensionFactory extends FileBasedExtensionFactory {

	public ModelTemplateExtensionFactory() {
		super(Messages.ModelTemplateExtensionFactory_ModelTemplate, "org.eclipse.papyrus.uml.diagram.wizards.templates", "file", "template", true); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public void addElement(CustomizableElement element, PluginEditor editor) {
		super.addElement(element, editor);

		editor.getManifestEditor().addDependency("org.eclipse.papyrus.uml.diagram.wizards"); //$NON-NLS-1$
	}

	@Override
	protected Element createExtension(FileBasedCustomizableElement customizableElement, PluginEditor editor) {
		Element extension = super.createExtension(customizableElement, editor);
		if(customizableElement instanceof ModelTemplate) {
			ModelTemplate element = (ModelTemplate)customizableElement;

			extension.setAttribute("id", element.getId()); //$NON-NLS-1$

			if(element.getName() != null) {
				extension.setAttribute("name", element.getName()); //$NON-NLS-1$
			}

			if(element.getLanguage() != null) {
				extension.setAttribute("language", element.getLanguage()); //$NON-NLS-1$
			}

			//TODO: Papyrus now handles *.di and *.notation files
		}

		return extension;
	}

	@Override
	protected String getTargetPath(FileBasedCustomizableElement element) {
		return "/modelTemplate/" + getFileName(element); //$NON-NLS-1$
	}

	public EClass getCustomizableElementClass() {
		return CustomizationPluginPackage.eINSTANCE.getModelTemplate();
	}
}
