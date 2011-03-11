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
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * The Class InitFromTemplateCommand.
 */
public class InitFromTemplateCommand extends RecordingCommand {

	/** The my model resource. */
	private final Resource myModelResource;

	/** The my template path. */
	private final String myTemplatePath;

	/** The my plugin id. */
	private final String myPluginId;

	/**
	 * Instantiates a new inits the from template command.
	 *
	 * @param editingDomain the editing domain
	 * @param modelResource the model resource
	 * @param pluginId the plugin id
	 * @param templatePath the template path
	 */
	public InitFromTemplateCommand(TransactionalEditingDomain editingDomain, Resource modelResource, String pluginId, String templatePath) {
		super(editingDomain);
		myModelResource = modelResource;
		myPluginId = pluginId;
		myTemplatePath = templatePath;

	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		initializeFromTemplate();
	}

	/**
	 * Initialize from template.
	 *
	 */
	private void initializeFromTemplate() {
		Resource templateResource = loadTemplateResource();
		List<EObject> eObjectsToAdd = new ArrayList<EObject>();
		for(EObject eObject : templateResource.getContents()) {
			eObjectsToAdd.add(EcoreUtil.copy(eObject));
		}
		for(EObject eObject : eObjectsToAdd) {
			myModelResource.getContents().add(eObject);
		}
	}


	/**
	 * Load template resource.
	 *
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
