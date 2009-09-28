/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.multidiagram.actionbarcontributor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.ExtensionException;
import org.eclipse.papyrus.core.extension.NotFoundException;
import org.eclipse.papyrus.core.services.IService;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.IDebugChannel;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.sasheditor.Activator;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * A factory managing ActionBarContributor creation.
 * The factory is loaded from ActionBarContributor declared in Eclipse extension mechanism.
 * @author dumoulin
 *
 */
public class ActionBarContributorRegistry implements IActionBarContributorFactory, IService {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** ID of the editor extension (schema filename) */
	public static final String EDITOR_EXTENSION_ID = "papyrusDiagram";

	/** Namespace where to look for the extension points. */
	protected String extensionPointNamespace;

	/**
	 * Registered context descriptors.
	 */
	private Map<Object, ActionBarContributorDescriptor> editorContextDescriptors;

	/**
	 * Constructor. defaultContext, input and site are explicitly required in order be sure that they are initialized. The multiEditor should be initialized. In particular, getEditorSite(),
	 * getEditorInput() and getDefaultContext() should return initialized values.
	 * 
	 *@param multiEditor
	 *            the multieditor
	 *@param extensionPointNamespace
	 */
	public ActionBarContributorRegistry( String extensionPointNamespace) {


		this.extensionPointNamespace = extensionPointNamespace;
		initializeEditorContextDescriptors();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public EditorActionBarContributor getActionBarContributor(Object key) throws BackboneException {
		try {
			ActionBarContributorDescriptor desc = editorContextDescriptors.get(key);
			return desc.getActionBarContributor();
		} catch (NullPointerException e) {
			// no context found.
			throw new NotFoundException("No ActionBarContributor registered under id '" + key + "'.");
		}
	}

	/**
	 * Get the list of descriptors.
	 * @return
	 * @throws BackboneException  If a contributor fail to be loaded.
	 */
	public List<EditorActionBarContributor> getActionBarContributors() throws BackboneException 
	{
		List<EditorActionBarContributor> res = new ArrayList<EditorActionBarContributor>();
		for( ActionBarContributorDescriptor desc : editorContextDescriptors.values())
		{
			res.add(desc.getActionBarContributor());
		}
		return res;
	}
	
	/**
	 * 
	 * {@inheritDoc}
	 */
	public void registerActionBarContributor(String contextKey, EditorActionBarContributor contributor) {
		ActionBarContributorDescriptor desc = new ActionBarContributorDescriptor();
		desc.contextId = contextKey;
		desc.instance = contributor;
		desc.contextClass = contributor.getClass();

		editorContextDescriptors.put(contextKey, desc);
	}

	/**
	 * Read context descriptors from extension points.
	 */
	private void initializeEditorContextDescriptors() {

		editorContextDescriptors = new HashMap<Object, ActionBarContributorDescriptor>();
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, EDITOR_EXTENSION_ID);

		ActionBarContributorExtensionFactory extensionReader = new ActionBarContributorExtensionFactory();

		for (IConfigurationElement ele : configElements) {
			ActionBarContributorDescriptor desc;
			try {
				if (ActionBarContributorExtensionFactory.EDITOR_ACTIONBARCONTRIBUTOR_EXTENSIONPOINT.equals(ele.getName())) {
					desc = extensionReader.createActionBarContributorDescriptor(ele);
					// Check double
					if( editorContextDescriptors.get(desc.contextId) != null)
					{
						// Already exists. Check if it is the same
						ActionBarContributorDescriptor existingDesc = editorContextDescriptors.get(desc.contextId);
						if(desc.equals(existingDesc))
							log.warning("More than one ActionBarContributor is registered under the name '"
									+ desc.contextId 
									+"', with different parameters. Extra declaration are disguarded. ");
					}
					else
					  editorContextDescriptors.put(desc.contextId, desc);
				}
			} catch (ExtensionException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, e.getMessage(), e));
				PapyrusTrace.error(IDebugChannel.PAPYRUS_EXTENSIONPOINT_LOADING, this, "Initialization editor problem " + e);
			}
		}
		
		if(log.isLoggable(Level.WARNING))
		  log.warning(this.getClass().getSimpleName() + " : contributors desc loaded  [" + editorContextDescriptors.size() + "]");
		PapyrusTrace.trace(IDebugChannel.PAPYRUS_EXTENSIONPOINT_LOADING, this, "" + editorContextDescriptors.size() + " editorContextDescriptors loaded");

	}

	/**
	 * Do nothing in this implementation.
	 * {@inheritDoc}
	 * @see org.eclipse.papyrus.core.services.IService#initService(org.eclipse.papyrus.core.services.ServicesRegistry)
	 */
	public void initService(ServicesRegistry servicesRegistry) {
	}

	/**
	 * Do nothing in this implementation.
	 * {@inheritDoc}
	 * @see org.eclipse.papyrus.core.services.IService#startService()
	 */
	public void startService() {
	}

	/*
	 * Do nothing in this implementation.
	 */
	public void disposeService() {
	}

}
