/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alexia Allanic (Atos Origin) alexia.allanic@atosorigin.com - LayoutToolExtensionPointManager Implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layouttool;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.layouttool.utils.Constants;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * The Class LayoutToolExtensionPointManager.
 */
public class LayoutToolExtensionPointManager {

	/** The instance. */
	private static LayoutToolExtensionPointManager instance = new LayoutToolExtensionPointManager();

	/** The configuration elements layout tools. */
	private IConfigurationElement[] configurationElementsLayoutTools = Platform.getExtensionRegistry()
			.getConfigurationElementsFor(Constants.EXTENSION_POINT_ID);

	/**
	 * Instantiates a new layout tool extension point manager.
	 */
	private LayoutToolExtensionPointManager() {
	}

	/**
	 * Gets the single instance of LayoutToolExtensionPointManager.
	 * 
	 * @return single instance of LayoutToolExtensionPointManager
	 */
	public static LayoutToolExtensionPointManager getInstance() {
		return instance;
	}

	/**
	 * Gets the layout area creator.
	 * 
	 * @return layout area creator
	 */
	public LayoutToolAreaInterface getLayoutAreaCreator() {
		try {
			for(IConfigurationElement e : configurationElementsLayoutTools) {

				Class<?> o;
				LayouttoolInterface interfaceL = (LayouttoolInterface)Platform.getBundle(e.getContributor().getName())
						.loadClass(e.getAttribute(Constants.EXTENSION_INTERFACE)).newInstance();
				o = interfaceL.getEditorClass();
				IWorkbenchPart activeEditor = getActiveEditor();
				if(activeEditor != null) {
					if(o.isAssignableFrom(activeEditor.getClass())) {
						if(e.getAttribute(Constants.EXTENSION_INTERFACE_LAYOUT_AREA) != null) {
							return (LayoutToolAreaInterface)e
									.createExecutableExtension(Constants.EXTENSION_INTERFACE_LAYOUT_AREA);
						}
					}
				}
			}
		} catch (InvalidRegistryObjectException e1) {
			Activator.getDefault().log(e1.getMessage(), e1);
		} catch (CoreException e) {
			Activator.getDefault().log(e.getMessage(), e);
		} catch (InstantiationException e) {
			Activator.getDefault().log(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			Activator.getDefault().log(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			Activator.getDefault().log(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Gets the sub editor.
	 * 
	 * @param part
	 *        the part
	 * 
	 * @return subEditor class
	 */
	public LayouttoolInterface getSubEditor(IWorkbenchPart part) {
		try {
			for(IConfigurationElement e : configurationElementsLayoutTools) {
				Class<?> o;
				LayouttoolInterface interfaceL = (LayouttoolInterface)Platform.getBundle(e.getContributor().getName())
						.loadClass(e.getAttribute(Constants.EXTENSION_INTERFACE)).newInstance();
				o = interfaceL.getEditorClass();
				IWorkbenchPart activeEditor = null;
				if(part != null) {
					activeEditor = part;
				} else {
					activeEditor = getActiveEditor();
				}
				if(activeEditor != null) {
					if(o.isAssignableFrom(activeEditor.getClass())) {
						return (LayouttoolInterface)e.createExecutableExtension(Constants.EXTENSION_INTERFACE);
					}
				}
			}
		} catch (InvalidRegistryObjectException e1) {
			e1.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the sub editor.
	 * 
	 * @return subEditor class
	 */
	public LayouttoolInterface getSubEditor() {
		return getSubEditor(null);
	}

	/**
	 * Gets the active editor.
	 * 
	 * @return active editor
	 */
	public IEditorPart getActiveEditor() {
		IEditorPart editor = null;
		if(PlatformUI.getWorkbench() != null) {
			if(PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
				if(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
					if(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() != null) {
						editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					}
				}
			}
		}
		return editor;
	}
}
