/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.externalresource.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.AbstractModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.IModelSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.uml.profile.externalresource.Activator;
import org.eclipse.papyrus.uml.profile.externalresource.helper.IStereotypeApplicationLocationStrategy;
import org.eclipse.papyrus.uml.profile.externalresource.helper.PapyrusStereotypeApplicationHelper;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Model to manage stereotype applications in external resources.
 */
public class StereotypeApplicationExternalResourceModel extends AbstractModel implements IModel {

	/** identifier of this IModel */
	public static final String ID = "ExternalStereotypeApplicationModel";

	/** list of resources for stereotype applications */
	protected List<Resource> profileApplicationResources = new ArrayList<Resource>();

	/** stores the root URI that was used to load all the manage resources */
	protected URI rootURI;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getIdentifier() {
		return ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createModel(IPath fullPath) {
		// throw new UnsupportedOperationException("CreateModel_IPath is not supported for " + getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createModel(URI uri) {
		// throw new UnsupportedOperationException("CreateModel_URI is not supported for " + getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadModel(IPath path) {
		loadModel(getPlatformURI(path));
	}

	/**
	 * Returns a platform resource URI of the given path
	 * 
	 * @param path
	 *        the path
	 * @return the uri
	 */
	protected URI getPlatformURI(IPath path) {
		return URI.createPlatformResourceURI(path.toString(), true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadModel(URI uri) {
		rootURI = uri;
		List<Resource> resources = getResources(true);
		for(Resource resource : resources) {
			try {
				if(!resource.isLoaded()) {
					resource.load(null);
				}
				configureResource(resource);
				profileApplicationResources.add(resource);
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
		// call registered snippets
		snippets.performStart(this);
	}

	/**
	 * Returns the dynamically computed list of resources in which stereotype applications should be located
	 * 
	 * @return the list of resources in which stereotype applications should be located
	 */
	protected List<Resource> getResources(boolean loadOnDemand) {
		List<Resource> resources = new ArrayList<Resource>();
		// get all profile applications resource to load from the strategy. do not care of the URI ?
		UmlModel umlModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
		try {
			if(umlModel != null && umlModel.lookupRoot() != null) {
				EObject root = umlModel.lookupRoot();
				IStereotypeApplicationLocationStrategy strategy = PapyrusStereotypeApplicationHelper.getCurrentLocationStrategy(root);
				if(strategy != null) {
					Set<URI> profileApplicationResourceURIs = strategy.getProfileApplicationResourceURIs(root);
					for(URI resourceURI : profileApplicationResourceURIs) {
						Resource resource = ModelUtils.getOrCreateResource(modelSet, loadOnDemand, resourceURI, UMLResource.UML_CONTENT_TYPE_IDENTIFIER);
						resources.add(resource);
					}
				}
			}
		} catch (NotFoundException e) {
			Activator.log.debug(e.getMessage());
			return Collections.emptyList();
		}
		return resources;
	}

	protected void configureResource(Resource resource) {
		if(resource instanceof XMIResource) {
			((XMIResource)resource).getDefaultSaveOptions().putAll(getSaveOptions());
			((XMIResource)resource).setEncoding(AbstractBaseModel.ENCODING);
		}
	}

	protected Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		// default save options.
		saveOptions.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_PROCESS_DANGLING_HREF, XMIResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SKIP_ESCAPE_URI, Boolean.FALSE);
		saveOptions.put(XMIResource.OPTION_ENCODING, "UTF-8");
		//see bug 397987: [Core][Save] The referenced plugin models are saved using relative path
		saveOptions.put(XMIResource.OPTION_URI_HANDLER, new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.PlatformSchemeAware());
		return saveOptions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void importModel(IPath path) {
		throw new UnsupportedOperationException("ImportModel_IPath is not supported for " + getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void importModel(URI uri) {
		throw new UnsupportedOperationException("ImportModel_URI is not supported for " + getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveModel() throws IOException {
		List<Resource> resources = getResources(true);
		for(Resource resource : resources) {
			if(!getModelManager().getTransactionalEditingDomain().isReadOnly(resource) && !ModelUtils.resourceFailedOnLoad(resource)) {
				resource.save(getSaveOptions());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changeModelPath(IPath fullPath) {
		throw new UnsupportedOperationException("changeModelPath is not supported for " + getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModelURI(URI uri) {
		List<Resource> resources = getResources(true);
		for(Resource resource : resources) {
			if(!ModelUtils.resourceFailedOnLoad(resource)) {
				String fileExtension = resource.getURI().fileExtension();
				URI newURI = uri.appendFileExtension(fileExtension);
				resource.setURI(newURI);
			}
		}
		rootURI = uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void unload() {
		// call registered snippets
		snippets.performDispose(this);
		List<Resource> resources = getResources(false);
		for(Resource resource : resources) {
			resource.unload();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addModelSnippet(IModelSnippet snippet) {
		snippets.add(snippet);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<URI> getModifiedURIs() {
		return Collections.emptySet();
	}
}
