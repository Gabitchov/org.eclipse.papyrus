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
package org.eclipse.papyrus.sasheditor.extension;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.sasheditor.Activator;
import org.eclipse.papyrus.sasheditor.gef.EditorNotFoundException;
import org.eclipse.papyrus.sasheditor.gef.IEditorFactoryRegistry;
import org.eclipse.ui.IEditorPart;

/**
 * A registry recording possible editor descriptors. This class use the eclipse extension mechanism.
 */
public class EditorFactoryRegistry implements IEditorFactoryRegistry {

	/** ID of the editor extension */
	public static final String EDITOR_EXTENSION_ID = "nestedEditor";

	/** Namespace where to look for the extension points. */
	protected String extensionPointNamespace;

	/** list of editor descriptors */
	protected List<NestedEditorDescriptor> editorDescriptors;

	/** indicates if extension is loaded or not */
	private boolean isExtensionLoaded = false;

	/**
	 * Create a new Registry reading extension from the specified namespace. The namespace is usually the name of the plugin owning the registry.
	 * 
	 * @param extensionPointNamespace
	 */
	public EditorFactoryRegistry(String extensionPointNamespace) {
		super();
		this.extensionPointNamespace = extensionPointNamespace;
		editorDescriptors = new ArrayList<NestedEditorDescriptor>();
	}

	/**
	 * Create a new editor for the specified diagram root.
	 * 
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	public IEditorPart createEditorFor(MultiDiagramSharedObjects sharedObjects, Object model) throws EditorNotFoundException {
		for (NestedEditorDescriptor desc : getEditorDescriptors()) {
			if (desc.isEditorFor(model)) {
				return desc.createEditor(sharedObjects, model);
			}
		}
		// no editor found !
		throw new EditorNotFoundException("No editor registered for '" + model + "'.");
	}

	/**
	 * Get the list of editor descriptor.
	 * 
	 * @return the list of editor descriptor.
	 */
	public List<NestedEditorDescriptor> getEditorDescriptors() {
		if (!isExtensionLoaded) {
			isExtensionLoaded = true;
			initializeEditorDescriptors();
		}
		return editorDescriptors;
	}

	/**
	 * Read editor descriptors from extension points.
	 */
	private void initializeEditorDescriptors() {
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, EDITOR_EXTENSION_ID);

		for (IConfigurationElement ele : configElements) {
			NestedEditorDescriptor desc;
			try {
				desc = ExtensionPointFactory.eINSTANCE.createNestedEditorDescriptor(ele);
			} catch (ExtensionException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, e.getMessage(), e));
				continue;
			}
			editorDescriptors.add(desc);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "EditorFactoryRegistry: " + editorDescriptors.toString();
	}

}
