/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.newchild;

import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.framework.Bundle;

import ElementCreationMenuModel.ElementCreationMenuModelPackage;
import ElementCreationMenuModel.Folder;
/**
 * This class is used to load all extension point call org.eclipse.papyrus.infra.newchild
 * It gives the set of all Folder that has to be displayed
 */
public class CreationMenuRegistry {

	private final String MENU_CREATION_MODEL_EXTENSION_ID = "org.eclipse.papyrus.infra.newchild"; //$NON-NLS-1$
	private final String MODEL_ID = "model"; //$NON-NLS-1$
	private  ArrayList<Folder> rootFolders= new ArrayList<Folder>();


	/**
	 * 
	 * Constructor.
	 *
	 */
	public CreationMenuRegistry(){
		init();
	}
	/**
	 * this method load the extension points
	 */
	public void init(){
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(MENU_CREATION_MODEL_EXTENSION_ID);
		for(int i = 0; i < configElements.length; i++) {
			rootFolders.add(inializeOneModel(configElements[i]));
		}

	}

	/**
	 * 
	 * @return the set of root folders
	 */
	public  ArrayList<Folder> getRootFolder(){
		return rootFolders;
	}



	/**
	 * Load one model
	 * 
	 * @param element
	 *        the extension point
	 */
	private Folder inializeOneModel(IConfigurationElement element) {
		try {
			return (Folder)createExtension(element, element.getAttribute(MODEL_ID));

		} catch (Exception e) {
			System.err.println("model of new child can not be loaded: " + e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Load a resource instanceof  ElementCreationMenuModel
	 * 
	 * @param element
	 *        the extension point
	 * @param classAttribute
	 *        the name of the resource to load
	 * @return the loaded Folder
	 * @throws Exception
	 *         if the resource is not loaded
	 */
	private static Folder createExtension(final IConfigurationElement element, final String classAttribute) throws Exception {
		try {
			Bundle extensionBundle = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier());
			URL url = extensionBundle.getResource(classAttribute);

			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(	Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl()); 
			if(url!=null){
				URI uri=URI.createURI(url.toURI().toASCIIString());

				// Obtain a new resource set
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getPackageRegistry().put(ElementCreationMenuModelPackage.eINSTANCE.getNsURI(), ElementCreationMenuModelPackage.eINSTANCE);
				// Get the resource
				Resource resource = resourceSet.getResource(uri, true);
				if(resource.getContents().get(0) instanceof Folder ){
					return 	(Folder)resource.getContents().get(0);
				}
			}
			return null;
		} catch (Exception e) {
			throw new Exception("unable to create Extension" + e); //$NON-NLS-1$
		}
	}


}