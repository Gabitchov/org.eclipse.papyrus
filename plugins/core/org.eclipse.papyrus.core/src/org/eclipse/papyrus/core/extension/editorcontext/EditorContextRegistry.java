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
package org.eclipse.papyrus.core.extension.editorcontext;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.extension.ExtensionException;
import org.eclipse.papyrus.core.extension.NotFoundException;
import org.eclipse.papyrus.core.services.IService;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.IDebugChannel;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.sasheditor.Activator;

/**
 * Registry containing registered EditorContext. EditorContexts can be registered by using Eclipse extension.
 * 
 *@author Cedric Dumoulin
 *@author Patrick Tessier
 */
public class EditorContextRegistry implements IEditorContextRegistry, IService {

	/** ID of the editor extension (schema filename) */
	public static final String EDITOR_EXTENSION_ID = "papyrusDiagram";

	/** Namespace where to look for the extension points. */
	protected String extensionPointNamespace;

	/**
	 * Registered context descriptors.
	 */
	private Map<Object, ContextDescriptor> editorContextDescriptors;

	/** The multi editor */
	private IMultiDiagramEditor multiEditor;

	/**
	 * Constructor. defaultContext, input and site are explicitly required in order be sure that they are initialized. The multiEditor should be initialized. In particular, getEditorSite(),
	 * getEditorInput() and getDefaultContext() should return initialized values.
	 * 
	 *@param multiEditor
	 *            the multieditor
	 *@param extensionPointNamespace
	 */
	public EditorContextRegistry(IMultiDiagramEditor multiEditor, String extensionPointNamespace) {

		// Check parameters
		assert (multiEditor.getEditorInput() != null);
		assert (multiEditor.getEditorSite() != null);
		assert (multiEditor.getDefaultContext() != null);
		// Check parameters. To be removed later
		if (multiEditor.getEditorInput() == null || multiEditor.getEditorSite() == null || multiEditor.getDefaultContext() == null) {
			throw new IllegalArgumentException("IMultiDiagramEditor should be initialized before calling constructor " + getClass().getSimpleName() + "(IMultiDiagramEditor multiEditor)");
		}

		this.extensionPointNamespace = extensionPointNamespace;
		this.multiEditor = multiEditor;
		initializeEditorContextDescriptors();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public IEditorContext getContext(Object key) throws BackboneException {
		try {
			ContextDescriptor desc = editorContextDescriptors.get(key);
			return desc.getContext(multiEditor);
		} catch (NullPointerException e) {
			// no context found.
			throw new NotFoundException("No context registered under id '" + key + "'.");
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void registerContext(String contextKey, IEditorContext context) {
		ContextDescriptor contextDesc = new ContextDescriptor();
		contextDesc.contextId = contextKey;
		contextDesc.instance = context;
		contextDesc.contextClass = context.getClass();

		editorContextDescriptors.put(contextKey, contextDesc);
	}

	/**
	 * Read context descriptors from extension points.
	 */
	private void initializeEditorContextDescriptors() {

		editorContextDescriptors = new HashMap<Object, ContextDescriptor>();
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, EDITOR_EXTENSION_ID);

		ContextDescriptorExtensionFactory extensionReader = new ContextDescriptorExtensionFactory();

		for (IConfigurationElement ele : configElements) {
			ContextDescriptor desc;
			try {
				if (ContextDescriptorExtensionFactory.EDITOR_CONTEXT_EXTENSIONPOINT.equals(ele.getName())) {
					desc = extensionReader.createContextDescriptor(ele);
					editorContextDescriptors.put(desc.contextId, desc);
				}
			} catch (ExtensionException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, e.getMessage(), e));
				PapyrusTrace.error(IDebugChannel.PAPYRUS_EXTENSIONPOINT_LOADING, this, "Initialization editor problem " + e);
			}
		}
		PapyrusTrace.trace(IDebugChannel.PAPYRUS_EXTENSIONPOINT_LOADING, this, "" + editorContextDescriptors.size() + " editorContexts loaded");

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
