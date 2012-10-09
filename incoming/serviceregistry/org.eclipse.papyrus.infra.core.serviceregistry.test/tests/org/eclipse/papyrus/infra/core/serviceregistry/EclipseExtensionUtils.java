/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.serviceregistry;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.core.runtime.spi.RegistryContributor;


/**
 * Set of utilities helping to load eclipse extensions from predefined files.
 * 
 * @author cedric dumoulin
 *
 * TODO This class is dedicated to the servicesREgistry.tests plugin. Can we make it more generic ?
 * 
 */
public class EclipseExtensionUtils {

	/**
	 * Unique instance.
	 */
	static final EclipseExtensionUtils instance = new EclipseExtensionUtils();
	
	/**
	 * Create a new {@link IExtensionRegistry} and initialize it with the plugin.xml file found in the specified directory.
	 * Also add required plugin.xml files
	 * 
	 * @param localfilepath
	 * @return
	 * @throws IOException 
	 */
	public IExtensionRegistry createRegistry( String localfilepath ) throws IOException {
				
		// Create the registry
		IExtensionRegistry registry = RegistryFactory.createRegistry(null, this, this);
		
		// Load specified file
		loadTestExtensionFile(registry, localfilepath);	
		// load regular plugin.xml in order to have the extension point definition
		loadExtensionFile(registry, "org.eclipse.papyrus.infra.core.serviceregistry", "plugin.xml");
		return registry;
	}

	/**
		 * Load the specified file (extension and extension points) into the registry.
		 * The file is located in the specified plugin.
		 * 
		 * @param localfilepath
		 * @return
		 * @throws IOException 
		 */
		protected void loadExtensionFile( IExtensionRegistry registry, String pluginID, String localfilepath ) throws IOException {
			
			InputStream inputStream;
	
			if( Platform.isRunning()) {
				// Load the specified plugin.xml file
				URL url = new URL("platform:/plugin/" + pluginID + "/" + localfilepath);
	
				//		URL url = new URL("platform", PLUGIN_ID, localfilepath );
				inputStream = url.openConnection().getInputStream();
			}
			else {
				// try to read locally
	//			System.out.println("platform not running !!");
				
				URL url = new URL("file:" + "../" + pluginID + "/" + localfilepath);
				//		URL url = new URL("platform", PLUGIN_ID, localfilepath );
				inputStream = url.openConnection().getInputStream();
			}
			
			// Create a point contributor with fake ID
			RegistryContributor pointContributor = new RegistryContributor(pluginID, pluginID, null, null);
	
			registry.addContribution( inputStream, pointContributor, false, null, null, this);
		}

	/**
		 * Load the specified file (containing extension declarations) into the provided registry.
		 * The file is located in the same plugin as this class.
		 * 
		 * @param localfilepath
		 * @return
		 * @throws IOException 
		 */
		public void loadTestExtensionFile( IExtensionRegistry registry, String localfilepath ) throws IOException {
			
			String PLUGIN_ID = "org.eclipse.papyrus.infra.core.serviceregistry.test";
			InputStream inputStream;
	
			if( Platform.isRunning()) {
				// Load the specified plugin.xml file
				URL url = new URL("platform:/plugin/" + PLUGIN_ID + "/" + localfilepath);
	
				//		URL url = new URL("platform", PLUGIN_ID, localfilepath );
				inputStream = url.openConnection().getInputStream();
			}
			else {
				// try to read locally
	//			System.out.println("platform not running !!");
				URL url = new URL("file:" + localfilepath);
				//		URL url = new URL("platform", PLUGIN_ID, localfilepath );
				inputStream = url.openConnection().getInputStream();
			}
	
			// Create a point contributor with fake ID
			RegistryContributor pointContributor = new RegistryContributor(PLUGIN_ID, PLUGIN_ID, null, null);
			registry.addContribution( inputStream, pointContributor, false, null, null, this);
		}

}
