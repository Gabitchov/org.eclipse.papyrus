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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards.template;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;

/**
 * The Class InitFromTemplateCommand.
 */
public class InitFromTemplateCommand extends RecordingCommand {

	private final Resource myModelResource;

	private final String myTemplatePath;

	private final String myPluginId;

	/**
	 * Instantiates a new inits the from template command.
	 *
	 * @param diResourceSet the di resource set
	 * @param pluginId the plugin id
	 * @param templatePath the template path
	 */
	public InitFromTemplateCommand(DiResourceSet diResourceSet, String pluginId, String templatePath) {
		super(diResourceSet.getTransactionalEditingDomain());
		myModelResource = diResourceSet.getModelResource();
		myPluginId = pluginId;
		myTemplatePath = templatePath;

	}

	@Override
	protected void doExecute() {
		initializeFromTemplate();
	}

	/**
	 * Initialize from template.
	 * 
	 * @param resource
	 *        the resource
	 * @param rootElementName
	 *        the root element name
	 * @param templatePath
	 *        the template path
	 */
	private void initializeFromTemplate() {
		Resource templateResource = loadTemplateResource();
		List<EObject> eObjectsToAdd = new ArrayList<EObject>();
		eObjectsToAdd = (List<EObject>)EcoreUtil.copyAll(templateResource.getContents());
		myModelResource.getContents().addAll(eObjectsToAdd);
	}


	/**
	 * Load template resource.
	 * 
	 * @param templatePath
	 *        the template path
	 * @return the resource
	 */
	private Resource loadTemplateResource() {
		java.net.URL templateURL = Platform.getBundle(myPluginId).getResource(myTemplatePath);
		String fullUri = templateURL.getPath();
		URI uri = URI.createPlatformPluginURI(myPluginId + fullUri, true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		if(resource.isLoaded()) {
			return resource;
		}
		return null;
	}


}
