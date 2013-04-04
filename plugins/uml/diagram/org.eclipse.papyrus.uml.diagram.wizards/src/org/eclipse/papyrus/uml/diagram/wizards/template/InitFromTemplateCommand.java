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
 *	Saadia Dhouib (CEA LIST) - Implementation of loading diagrams from template files  (.uml, .di , .notation)
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.template;

import java.io.IOException;
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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;


/**
 * The Class InitFromTemplateCommand.
 */
public class InitFromTemplateCommand extends RecordingCommand {

	/** The my model resource. */
	private final Resource myModelUMLResource;

	/** The my model di resource. */
	private final Resource myModelDiResource;

	/** The my model notation resource. */
	private final Resource myModelNotationResource;

	/** The my template path. */
	private final String myUmlTemplatePath;

	/** The my di template path. */
	private final String myDiTemplatePath;

	/** The my notation template path. */
	private final String myNotationTemplatePath;

	/** The my plugin id. */
	private final String myPluginId;

	/**
	 * Instantiates a new inits the from template command.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param diResouceSet
	 *        the di resouce set
	 * @param pluginId
	 *        the plugin id
	 * @param umlTemplatePath
	 *        the uml template path
	 * @param notationTemplatePath
	 *        the notation template path
	 * @param diTemplatePath
	 *        the di template path
	 */
	public InitFromTemplateCommand(TransactionalEditingDomain editingDomain, ModelSet modelSet, String pluginId, String umlTemplatePath, String notationTemplatePath, String diTemplatePath) {
		super(editingDomain);
		myModelUMLResource = UmlUtils.getUmlResource(modelSet);
		myModelDiResource = DiModelUtils.getDiResource(modelSet);
		myModelNotationResource = NotationUtils.getNotationResource(modelSet);
		myPluginId = pluginId;
		myUmlTemplatePath = umlTemplatePath;
		myDiTemplatePath = diTemplatePath;
		myNotationTemplatePath = notationTemplatePath;

	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		try {
			initializeFromTemplate();
			//verify if .di file and .notation file were filled in the org.eclipse.papyrus.uml.diagram.wizards.templates extension

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	/**
	 * Initialize from template.
	 * 
	 * 
	 * @throws IOException
	 *         Signals that an I/O exception has occurred.
	 */
	private void initializeFromTemplate() throws IOException {
		Resource templateDiResource = null;
		Resource templateNotationResource = null;
		Resource templateUmlResource = null;


		//0. initalization of the UML object
		ResourceSet resourceSet = new ResourceSetImpl();
		templateUmlResource = loadTemplateResource(myUmlTemplatePath, resourceSet);


		//1. prepare the copy of UML element
		List<EObject> eObjectsToAdd = new ArrayList<EObject>();
		eObjectsToAdd = (templateUmlResource.getContents());


		//2. test if di and notation exist
		//verify if .di file and .notation file were filled in the org.eclipse.papyrus.uml.diagram.wizards.templates extension
		if((myDiTemplatePath != null) && (myNotationTemplatePath != null)) {
			//2.1 verify if the .di , .notation and .uml files have the same name
			String diFileName = WizardsHelper.getFileNameWithoutExtension(myDiTemplatePath);
			String umlFileName = WizardsHelper.getFileNameWithoutExtension(myUmlTemplatePath);
			String notationFileName = WizardsHelper.getFileNameWithoutExtension(myNotationTemplatePath);

			if(diFileName.contentEquals(umlFileName) && diFileName.contentEquals(notationFileName)) {

				//2.2 load  di resource
				if(myDiTemplatePath != null) {
					templateDiResource = loadTemplateResource(myDiTemplatePath, resourceSet);
				}

				//2.3 load notation resource
				if(myNotationTemplatePath != null) {
					templateNotationResource = loadTemplateResource(myNotationTemplatePath, resourceSet);
				}

				//Visits all proxies in the resource set and tries to resolve them.
				EcoreUtil.resolveAll(resourceSet);

				//2.4 prepare the copy of di and notation elements
				if(templateNotationResource != null) {
					eObjectsToAdd.addAll(templateNotationResource.getContents());
				}
				if(templateDiResource != null) {
					eObjectsToAdd.addAll(templateDiResource.getContents());
				}
			}
		}
		//3. copy all element into eObjectResult
		List<EObject> eObjectsResult = new ArrayList<EObject>();
		eObjectsResult.addAll(EcoreUtil.copyAll(eObjectsToAdd));


		//4. set copied elements in goods resources
		for(EObject eObject : eObjectsResult) {
			if(eObject.eContainer() == null) {
				if(eObject instanceof Diagram) {
					myModelNotationResource.getContents().add(eObject);
				} else if(eObject instanceof SashWindowsMngr) {
					myModelDiResource.getContents().clear();
					myModelDiResource.getContents().add(eObject);
				} else {
					myModelUMLResource.getContents().add(eObject);
				}
			}
		}
	}



	/**
	 * Load template resource.
	 * 
	 * @param path
	 *        the path
	 * @return the resource
	 */
	private Resource loadTemplateResource(String path, ResourceSet resourceSet) {
		java.net.URL templateURL = Platform.getBundle(myPluginId).getResource(path);
		String fullUri = templateURL.getPath();
		URI uri = URI.createPlatformPluginURI(myPluginId + fullUri, true);
		Resource resource = resourceSet.getResource(uri, true);
		if(resource.isLoaded()) {
			return resource;
		}
		return null;
	}




}
