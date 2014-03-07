/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429242
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import static org.eclipse.papyrus.infra.core.Activator.log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.extension.ExtensionException;
import org.eclipse.papyrus.infra.core.extension.ExtensionUtils;

import com.google.common.collect.Sets;

/**
 * A reader to read model from Eclipse extension and register them to the
 * specified ModelManager.
 * 
 * @author cedric dumoulin
 * 
 */
public class ModelsReader extends ExtensionUtils {

	/** name for the element "loadAfter" */
	public static final String LOAD_AFTER_ELEMENT_NAME = "loadAfter";
	
	/** name for the element "unloadBefore" */
	public static final String UNLOAD_BEFORE_ELEMENT_NAME = "unloadBefore";

	/** name for the element "dependency" */
	public static final String DEPENDENCY_ELEMENT_NAME = "dependency";

	/**
	 * Name of the extension (as declared in 'plugin.xml->extension
	 * point->xxx->ID')
	 */
	public static final String EXTENSION_POINT_NAME = "model";

	/** Name for the element "model" */
	public static final String MODEL_ELEMENT_NAME = "model";

	/** Name for the element "modelSnippet" */
	public static final String MODEL_SNIPPET_ELEMENT_NAME = "modelSnippet";

	/** Name for the element "modelSetSnippet" */
	public static final String MODEL_SET_SNIPPET_ELEMENT_NAME = "modelSetSnippet";

	/**
	 * Name of attribute used to set class name.
	 */
	private static final String CLASSNAME_ATTRIBUTE = "classname";

	/** name of the attribute "identifier"*/
	public static final String IDENTIFIER_ATTRIBUTE_NAME = "identifier";
	
	/** Name of the extension indicating the model's canonical file extension. */
	private static final String EXTENSION_ATTRIBUTE = "fileExtension"; //$NON-NLS-1$

	/** Namespace where to look for the extension points. */
	protected String extensionPointNamespace;

	/**
	 * Create a ModelReader reading extension from the core namespace.
	 * 
	 * @param extensionPointNamespace
	 */
	public ModelsReader() {
		// Use this plugin namespace.
		this(Activator.PLUGIN_ID);
	}

	/**
	 * Create a ModelReader reading extension from the specified namespace. The
	 * namespace is usually the name of the plugin owning the {@link ModelSet}.
	 * 
	 * @param extensionPointNamespace
	 */
	public ModelsReader(String extensionPointNamespace) {
		super();
		this.extensionPointNamespace = extensionPointNamespace;
	}

	/**
	 * Populate the manager with models found in Eclipse extensions.
	 * 
	 * @param modelSet
	 */
	public void readModel(ModelSet modelSet) {
		// Actually, we register model manually.
		// TODO: read from Eclipse extension.
		// modelSet.registerModel( new SashModel() );
		// modelSet.registerModel( new NotationModel() );
		// // uml model
		// UmlModel umlModel = new ExtendedUmlModel();
		// umlModel.addModelSnippet(new UmlSnippet());
		// modelSet.registerModel(umlModel);
		// // global snippets
		// modelSet.addModelSetSnippet(new TypeCacheInitializer());
		// Reading data from plugins
		IConfigurationElement[] configElements = getExtensions();
		addDeclaredModels(configElements, modelSet);
		addDeclaredModelSetSnippets(configElements, modelSet);
	}

	private IConfigurationElement[] getExtensions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, EXTENSION_POINT_NAME);
	}

	/**
	 * Queries whether there is a registered model correlating to the specified URI.
	 * 
	 * @param uri
	 *        a resource URI (including the file extension, if there is one)
	 * 
	 * @return {@code true} if the URI has a file extension and that extension is associated with any registered {@link IModel}; {@code false},
	 *         otherwise
	 */
	public boolean hasAssociatedModel(URI uri) {
		boolean result = false;

		String extension = uri.fileExtension();
		if(extension != null) {
			IConfigurationElement[] configs = getExtensions();
			for(int i = 0; !result && (i < configs.length); i++) {
				String modelExtension = configs[i].getAttribute(EXTENSION_ATTRIBUTE);
				result = (modelExtension != null) && modelExtension.equals(extension);
			}
		}

		return result;
	}
	
	/**
	 * Queries the collection of distinct resource URIs that are recognized by Papyrus as model resources, based on the specified prototype.
	 * 
	 * @param prototypeURI
	 *        an example of a URI of a component resource of a Papyrus model; it may be but is not required to be a *.di URI, but it must have a file
	 *        extension
	 * 
	 * @return the collection of known model resource URIs that are related to the given prototype
	 */
	public Collection<URI> getKnownModelURIs(URI prototypeURI) {
		Set<URI> result = Sets.newHashSet();

		final URI uriWithoutExtension = prototypeURI.trimFileExtension();

		IConfigurationElement[] configs = getExtensions();
		for(int i = 0; i < configs.length; i++) {
			String modelExtension = configs[i].getAttribute(EXTENSION_ATTRIBUTE);
			if(modelExtension != null) {
				result.add(uriWithoutExtension.appendFileExtension(modelExtension));
			}
		}

		return result;
	}
	
	/**
	 * Read and instanciate declared models
	 * 
	 * @param modelSet
	 */
	private void addDeclaredModels(IConfigurationElement[] configElements, ModelSet modelSet) {
		for(IConfigurationElement ele : configElements) {
			// Check if it is a Model
			try {
				if(MODEL_ELEMENT_NAME.equals(ele.getName())) {
					IModel model = instanciateModel(ele);
					modelSet.registerModel(model);
					addDeclaredModelSnippet(ele, model);
					addDeclaredDependencies(ele, model);
					log.debug("model loaded: '" + model.getClass().getName() + "'");
				}
			} catch (ExtensionException e) {
				log.error("Problems occur while instanciating model", e);
			}
		}
	}

	/**
	 * Add ModelSet snippet
	 * 
	 * @param modelSet
	 */
	private void addDeclaredModelSetSnippets(IConfigurationElement[] configElements, ModelSet modelSet) {
		for(IConfigurationElement ele : configElements) {
			// Check if it is a Model
			try {
				if(MODEL_SET_SNIPPET_ELEMENT_NAME.equals(ele.getName())) {
					IModelSetSnippet snippet = instanciateModelSetSnippet(ele);
					modelSet.addModelSetSnippet(snippet);
					log.debug("modelSet snippet added: '" + modelSet.getClass().getName() + "().add(" + snippet.getClass().getName() + ")'");
				}
			} catch (ExtensionException e) {
				log.error("Problems occur while instanciating snippet", e);
			}
		}
	}

	/**
	 * Instanciate model declared in the configuration element.
	 * 
	 * @param ele
	 * @return
	 * @throws ExtensionException
	 */
	private IModel instanciateModel(IConfigurationElement ele) throws ExtensionException {
		@SuppressWarnings("unchecked")
		Class<IModel> modelInstance = (Class<IModel>)parseClass(ele, CLASSNAME_ATTRIBUTE, MODEL_ELEMENT_NAME);
		IModel model;
		try {
			model = modelInstance.newInstance();
		} catch (InstantiationException e) {
			throw new ExtensionException(e);
		} catch (IllegalAccessException e) {
			throw new ExtensionException(e);
		}
		return model;
	}

	/**
	 * Instanciate model snippet declared in the configuration element.
	 * 
	 * @param ele
	 * @return
	 * @throws ExtensionException
	 */
	private IModelSnippet instanciateModelSnippet(IConfigurationElement ele) throws ExtensionException {
		@SuppressWarnings("unchecked")
		Class<IModelSnippet> modelInstance = (Class<IModelSnippet>)parseClass(ele, CLASSNAME_ATTRIBUTE, MODEL_SNIPPET_ELEMENT_NAME);
		IModelSnippet snippet;
		try {
			snippet = modelInstance.newInstance();
		} catch (InstantiationException e) {
			throw new ExtensionException(e);
		} catch (IllegalAccessException e) {
			throw new ExtensionException(e);
		}
		return snippet;
	}

	/**
	 * Instanciate modelSet snippet declared in the configuration element.
	 * 
	 * @param ele
	 * @return
	 * @throws ExtensionException
	 */
	private IModelSetSnippet instanciateModelSetSnippet(IConfigurationElement ele) throws ExtensionException {
		@SuppressWarnings("unchecked")
		Class<IModelSetSnippet> modelInstance = (Class<IModelSetSnippet>)parseClass(ele, CLASSNAME_ATTRIBUTE, MODEL_SET_SNIPPET_ELEMENT_NAME);
		IModelSetSnippet snippet;
		try {
			snippet = modelInstance.newInstance();
		} catch (InstantiationException e) {
			throw new ExtensionException(e);
		} catch (IllegalAccessException e) {
			throw new ExtensionException(e);
		}
		return snippet;
	}

	/**
	 * Add associated snippets to the model.
	 * 
	 * @param parentElement
	 * @param model
	 */
	private void addDeclaredModelSnippet(IConfigurationElement parentElement, IModel model) {
		// Get children
		IConfigurationElement[] configElements = parentElement.getChildren(MODEL_SNIPPET_ELEMENT_NAME);
		for(IConfigurationElement ele : configElements) {
			try {
				IModelSnippet snippet = instanciateModelSnippet(ele);
				model.addModelSnippet(snippet);
				log.debug("model snippet added: '" + model.getClass().getName() + "().add(" + snippet.getClass().getName() + ")'");
			} catch (ExtensionException e) {
				log.error("Problems occur while instanciating model snippet", e);
			}
		}
	}

	/**
	 * Sets the declared dependencies on the Model
	 * 
	 * @param modelConfigurationElement
	 *        the configuration element of the model
	 * @param model
	 *        the Model to configure
	 */
	protected void addDeclaredDependencies(IConfigurationElement modelConfigurationElement, IModel model) {
		// Get children
		IConfigurationElement[] dependencyElements = modelConfigurationElement.getChildren(DEPENDENCY_ELEMENT_NAME);
		List<String> afterLoadModelIdentifiers = null;
		List<String> unloadBeforeModelIdentifiers = null;
		
		for(IConfigurationElement dependencyElement : dependencyElements) {
			
				// init load after and unloadBefore
				IConfigurationElement[] loadAfterElements = dependencyElement.getChildren(LOAD_AFTER_ELEMENT_NAME);
				IConfigurationElement[] unloadBeforeElements = dependencyElement.getChildren(UNLOAD_BEFORE_ELEMENT_NAME);
				
				for(IConfigurationElement loadAfterElement : loadAfterElements) {
					String identifier = loadAfterElement.getAttribute(IDENTIFIER_ATTRIBUTE_NAME);
					if(identifier != null && identifier.length() > 0) {
						if(afterLoadModelIdentifiers ==null) {
							afterLoadModelIdentifiers = new ArrayList<String>();
						}
						afterLoadModelIdentifiers.add(identifier);
					}
				}
				
				for(IConfigurationElement unloadBeforeElement : unloadBeforeElements) {
					String identifier = unloadBeforeElement.getAttribute(IDENTIFIER_ATTRIBUTE_NAME);
					if(identifier != null && identifier.length() > 0) {
						if(unloadBeforeModelIdentifiers ==null) {
							unloadBeforeModelIdentifiers = new ArrayList<String>();
						}
						unloadBeforeModelIdentifiers.add(identifier);
					}
				}
		}
		
		// all config elements have been parsed. sets the dependencies in the model
		model.setAfterLoadModelDependencies(afterLoadModelIdentifiers);
		model.setBeforeUnloadDependencies(unloadBeforeModelIdentifiers);
	}
}
