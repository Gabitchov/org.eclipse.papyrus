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
package org.eclipse.papyrus.customization.generator;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.customization.Activator;
import org.eclipse.papyrus.customization.factory.ExtensionFactory;
import org.eclipse.papyrus.customization.messages.Messages;
import org.eclipse.papyrus.customization.model.customization.CustomizableElement;
import org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration;
import org.eclipse.papyrus.customization.plugin.PluginEditor;
import org.xml.sax.SAXException;

public class PluginGenerator {

	public static PluginGenerator instance = new PluginGenerator();

	private final static String PLUGIN_NATURE_ID = "org.eclipse.pde.PluginNature"; //$NON-NLS-1$

	public void generate(IProject project, CustomizationConfiguration configuration) throws CoreException, IOException, SAXException, ParserConfigurationException {
		PluginEditor editor;

		editor = new PluginEditor(project);

		//editor.addNature("org.eclipse.jdt.core.javanature");

		Set<String> natures = new HashSet<String>();
		natures.add(PLUGIN_NATURE_ID);
		editor.addNatures(natures);

		for(CustomizableElement element : configuration.getElements()) {
			ExtensionFactory factory = getFactory(element);
			if(factory != null) {
				factory.addElement(element, editor);
			} else {
				Activator.log.warn(Messages.PluginGenerator_factoryNotFound + element.eClass());
			}
		}

		try {
			editor.save();
		} catch (Throwable ex) {
			Activator.log.error(ex);
			return;
		}

		String pluginId = configuration.getPlugin();
		Resource resource = configuration.eResource();
		URI uri = URI.createPlatformResourceURI(pluginId + "/customizationConfiguration.xmi", true); //$NON-NLS-1$
		if(resource == null) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resource = resourceSet.createResource(uri);
			resource.getContents().add(configuration);
		} else {
			configuration.eResource().setURI(uri);
		}

		configuration.eResource().save(Collections.EMPTY_MAP);

		editor.getProject().refreshLocal(0, null);
	}

	private ExtensionFactory getFactory(CustomizableElement element) {
		ExtensionFactory factory = ExtensionFactory.registry.getFactory(element.eClass());
		return factory;
	}

	private PluginGenerator() {
	}
}
