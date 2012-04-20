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
package org.eclipse.papyrus.infra.extendedtypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.infra.extendedtypes.preferences.ExtendedTypesPreferences;
import org.eclipse.papyrus.infra.extendedtypes.types.ExtendedHintedTypeFactory;
import org.osgi.framework.Bundle;


/**
 * Registry for all extended types.
 */
public class ExtendedTypesRegistry {

	/** private singleton instance */
	private static ExtendedTypesRegistry registry;

	/** list of retrieved extended type sets */
	protected List<ExtendedElementTypeSet> extendedTypeSets = null;

	/** unique resource set to load all extended types models */
	protected ResourceSet extendedTypesResourceSet = null;

	/**
	 * Private constructor.
	 */
	private ExtendedTypesRegistry() {

	}

	/**
	 * returns the singleton instance of this registry
	 * 
	 * @return the singleton instance of this registry
	 */
	public static synchronized ExtendedTypesRegistry getInstance() {
		if(registry == null) {
			registry = new ExtendedTypesRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		// 0. Reset the values
		extendedTypesResourceSet = null;
		extendedTypeSets = null;

		// 1. create the resource set
		extendedTypesResourceSet = createResourceSet();
		// 2. create the list only when registry is acceded for the first time
		extendedTypeSets = loadExtendedTypeSets();
	}

	/**
	 * Retrieves and loads extended type sets registered in the platform. It should also load configuration sets from the workspace.
	 */
	protected List<ExtendedElementTypeSet> loadExtendedTypeSets() {
		List<ExtendedElementTypeSet> extendedElementTypeSets = new ArrayList<ExtendedElementTypeSet>();

		// 1. retrieve from the workspace
		// TODO implement retrieve from workspace

		// 2. retrieve from the platform.
		List<ExtendedElementTypeSet> registeredSets = loadExtendedTypeSetsFromPlatform();
		if(registeredSets != null && !registeredSets.isEmpty()) {
			extendedElementTypeSets.addAll(registeredSets);
		}

		return extendedElementTypeSets;
	}

	/**
	 * Creates the resource set that contains all models for extended types
	 * 
	 * @return the resource set newly created.
	 */
	protected ResourceSet createResourceSet() {
		ResourceSet set = new ResourceSetImpl();
		return set;
	}

	/**
	 * Loads the extensions in the platform
	 * 
	 * @return the list of extension registered in the platform
	 */
	protected List<ExtendedElementTypeSet> loadExtendedTypeSetsFromPlatform() {
		List<ExtendedElementTypeSet> platformElementTypeSets = new ArrayList<ExtendedElementTypeSet>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IExtendedTypeExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element 
		for(IConfigurationElement element : elements) {
			String modelPath = element.getAttribute(IExtendedTypeExtensionPoint.PATH);
			String extendedTypeSetId = element.getAttribute(IExtendedTypeExtensionPoint.ID);
			String contributorID = element.getContributor().getName();
			if(Platform.inDebugMode()) {
				Activator.log.debug("[Reading extension point]");
				Activator.log.debug("-  Path to the model: " + modelPath);
				Activator.log.debug("-  id of the container bundle: " + contributorID);
				Activator.log.debug("-  id of the extended type set: " + extendedTypeSetId);
			}
			ExtendedElementTypeSet set = getExtendedElementTypeSet(extendedTypeSetId, modelPath, contributorID);
			if(set != null) {
				platformElementTypeSets.add(set);
			}
		}

		return platformElementTypeSets;
	}

	/**
	 * <p>
	 * Loads the resource containing the extended element type set model.
	 * </p>
	 * <p>
	 * It looks the model file in the fragments first, then in the plugin itself.<BR>
	 * If this is already a fragment, it should look in the fragment only
	 * </p>
	 * 
	 * @param extendedTypesID
	 *        id of the extended type set to load
	 * @param modelPath
	 *        path of the model in the bundle
	 * @param bundleId
	 *        id of the bundle containing the model file
	 * @return the loaded file or <code>null</code> if some problem occured during loading
	 */
	protected ExtendedElementTypeSet getExtendedElementTypeSet(String extendedTypesID, String modelPath, String bundleId) {
		// 1. look in preferences.
		String filePath = ExtendedTypesPreferences.getExtendedTypesRedefinition(extendedTypesID);
		if(filePath != null) {
			getExtendedElementTypeSetInPluginStateArea(extendedTypesID);
		}

		// 2. no local redefinition. Load extended type set from plugin definition
		Bundle bundle = Platform.getBundle(bundleId);
		if(Platform.isFragment(bundle)) {
			return getExtendedElementTypeSetInBundle(modelPath, bundleId);
		} else { // this is a plugin. Search in sub fragments, then in the plugin
			Bundle[] fragments = Platform.getFragments(bundle);
			// no fragment, so the file should be in the plugin itself
			if(fragments == null) {
				return getExtendedElementTypeSetInBundle(modelPath, bundleId);
			} else {
				for(Bundle fragment : fragments) {
					ExtendedElementTypeSet extendedElementTypeSet = getExtendedElementTypeSetInBundle(modelPath, fragment.getSymbolicName());
					if(extendedElementTypeSet != null) {
						return extendedElementTypeSet;
					}
				}
				// not found in fragments. Look in the plugin itself
				return getExtendedElementTypeSetInBundle(modelPath, bundleId);
			}
		}
	}

	/**
	 * Retrieves the contribution in the plugin area
	 * 
	 * @param path
	 *        the path of the element type set to load in the plugin area
	 */
	protected ExtendedElementTypeSet getExtendedElementTypeSetInPluginStateArea(String path) {
		// read in preferences area
		IPath resourcePath = Activator.getDefault().getStateLocation().append(path);
		URI uri = URI.createFileURI(resourcePath.toOSString());
		if(uri != null && uri.isFile()) {
			Resource resource = extendedTypesResourceSet.createResource(uri);
			try {
				resource.load(null);
			} catch (IOException e) {
				return null;
			}
			EObject content = resource.getContents().get(0);
			if(content instanceof ExtendedElementTypeSet) {
				return (ExtendedElementTypeSet)content;
			}
			Activator.log.error("Impossible to cast the object into an ExtendedElementTypeSet: " + content, null);
			return null;
		}
		return null;
	}

	/**
	 * 
	 * @param modelPath
	 *        path of the model in the bundle
	 * @param bundleId
	 *        id of the bundle containing the model file
	 * @return the loaded file or <code>null</code> if some problem occured during loading
	 */
	protected ExtendedElementTypeSet getExtendedElementTypeSetInBundle(String modelPath, String bundleID) {
		Resource resource = extendedTypesResourceSet.createResource(URI.createPlatformPluginURI(bundleID + Path.SEPARATOR + modelPath, true));
		try {
			resource.load(null);
		} catch (IOException e) {
			return null;
		}
		EObject content = resource.getContents().get(0);
		if(content instanceof ExtendedElementTypeSet) {
			return (ExtendedElementTypeSet)content;
		}
		Activator.log.error("Impossible to cast the object into an ExtendedElementTypeSet: " + content, null);
		return null;
	}

	/**
	 * Gets the element type for <code>id</code>. May return <code>null</code> if this element is not registered.
	 * 
	 * @param id
	 *        the type ID
	 * @return the registered type with this ID, or <code>null</code> if there
	 *         is none.
	 */
	public IElementType getType(String id) {
		// 1. checks if the element already exists
		IElementType type = ElementTypeRegistry.getInstance().getType(id);

		// 2. If it exists, returns it as usual
		if(type != null) {
			return type;
		}

		// 3. It does not exists. It could be retrieve in the extended type sets
		for(ExtendedElementTypeSet set : extendedTypeSets) {
			for(ExtendedElementTypeConfiguration elementTypeConfiguration : set.getElementType()) {
				if(id.equals(elementTypeConfiguration.getId())) {
					// create and add in the standard registry the required element type from its configuration
					@SuppressWarnings("restriction")
					ISpecializationType createSpecializationType = ExtendedHintedTypeFactory.getInstance().createSpecializationType(new ExtendedSemanticTypeDescriptor(elementTypeConfiguration));
					// register it, so it should be accessible next time
					ElementTypeRegistry.getInstance().register(createSpecializationType);
					// retrieve papyrus client context and add the registered type to this context
					IClientContext papyrusContext = ClientContextManager.getInstance().getClientContext("org.eclipse.papyrus.infra.services.edit.TypeContext");
					if(papyrusContext != null) {
						papyrusContext.bindId(id);
					}
					return createSpecializationType;
				}
			}
		}
		return null;
	}

}
