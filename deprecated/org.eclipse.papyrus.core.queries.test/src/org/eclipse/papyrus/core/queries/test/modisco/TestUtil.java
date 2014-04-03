/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.core.queries.test.modisco;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration;


/**
 * Utility class for tests
 */
public class TestUtil {

	/**
	 * Loads a model and returns the main element
	 * 
	 * @param pluginPath
	 *        the identifier of the test plugin
	 * @param localPath
	 *        the path to the file
	 * @return the model loaded
	 */
	public static EObject loadModel(String pluginPath, String localPath) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createPlatformPluginURI("/" + pluginPath + localPath, true));
		try {
			resource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resource.getContents().get(0);
	}

	/**
	 * Loads a model and returns the contained model configuration element
	 * 
	 * @param pluginPath
	 *        the identifier of the test plugin
	 * @param localPath
	 *        the path to the file
	 * @return the model loaded
	 */
	public static ModiscoQueryConfiguration loadQueryConfiguration(String pluginPath, String localPath) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createPlatformPluginURI("/" + pluginPath + localPath, true));
		try {
			resource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (ModiscoQueryConfiguration)resource.getContents().get(0);
	}
}
