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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.propertylabel;

import java.io.IOException;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.papyrus.parsers.PapyrusParsersPlugin;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Template management for the text editor.
 */
public class PropertyLabelTemplateUI {

	/**
	 * Key to store custom templates.
	 */
	private static final String CUSTOM_TEMPLATES_KEY = "com.cea.accorduml.view.rtaction.texteditor.customtemplates";

	/**
	 * The shared instance.
	 */
	private static PropertyLabelTemplateUI fInstance;

	/**
	 * The template store.
	 */
	private TemplateStore fStore;

	/**
	 * The context type registry.
	 */
	private ContributionContextTypeRegistry fRegistry;

	/**
	 * 
	 */
	private PropertyLabelTemplateUI() {
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static PropertyLabelTemplateUI getDefault() {
		if(fInstance == null) {
			fInstance = new PropertyLabelTemplateUI();
		}
		return fInstance;
	}

	/**
	 * Returns this plug-in's template store.
	 * 
	 * @return the template store of this plug-in instance
	 */
	public TemplateStore getTemplateStore() {
		if(fStore == null) {
			fStore = new ContributionTemplateStore(getContextTypeRegistry(), PapyrusParsersPlugin.getDefault()
					.getPreferenceStore(), CUSTOM_TEMPLATES_KEY);
			try {
				fStore.load();
			} catch (IOException e) {
				PapyrusParsersPlugin.logException(e);
			}
		}
		return fStore;
	}

	/**
	 * Returns this plug-in's context type registry.
	 * 
	 * @return the context type registry for this plug-in instance
	 */
	public ContextTypeRegistry getContextTypeRegistry() {
		if(fRegistry == null) {
			// create an configure the contexts available in the template editor
			fRegistry = new ContributionContextTypeRegistry();
			fRegistry.addContextType(PropertyLabelContextType.PROPERTYLABEL_CONTEXT_TYPE);
		}
		return fRegistry;
	}

	/* Forward plug-in methods to javaeditor example plugin default instance */
	/**
	 * 
	 * 
	 * @return
	 */
	public ImageRegistry getImageRegistry() {
		return PapyrusParsersPlugin.getDefault().getImageRegistry();
	}

	/**
	 * Creates and returns the <code>ImageDescriptor</code> for an image from a plugin.
	 * 
	 * @param imageFilePath
	 *        relative path to the file that stores the image
	 * @param pluginId
	 *        the identifier of the plugin
	 * 
	 * @return the image descriptor
	 * 
	 * @see AbstractUIPlugin#imageDescriptorFromPlugin(java.lang.String, java.lang.String)
	 */
	public static ImageDescriptor imageDescriptorFromPlugin(String pluginId, String imageFilePath) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, imageFilePath);
	}

	/**
	 * Returns the preference store of the plugin.
	 * 
	 * @return the preference store of the plugin
	 * 
	 * @see AbstractUIPlugin#getPreferenceStore()
	 */
	public IPreferenceStore getPreferenceStore() {
		return PapyrusParsersPlugin.getDefault().getPreferenceStore();
	}

	/**
	 * Save plugin preferences.
	 * 
	 * @see org.eclipse.core.runtime.Plugin#savePluginPreferences()
	 */
	public void savePluginPreferences() {
		PapyrusParsersPlugin.getDefault().savePluginPreferences();
	}

}
