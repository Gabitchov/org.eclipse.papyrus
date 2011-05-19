/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.Tab;
import org.eclipse.papyrus.properties.environment.CompositeWidgetType;
import org.eclipse.papyrus.properties.environment.Environment;
import org.eclipse.papyrus.properties.environment.EnvironmentPackage;
import org.eclipse.papyrus.properties.environment.LayoutType;
import org.eclipse.papyrus.properties.environment.Namespace;
import org.eclipse.papyrus.properties.environment.PropertyEditorType;
import org.eclipse.papyrus.properties.environment.StandardWidgetType;
import org.eclipse.papyrus.properties.environment.Type;
import org.eclipse.papyrus.properties.environment.WidgetType;
import org.eclipse.papyrus.properties.extensions.ContextExtensionPoint;
import org.eclipse.papyrus.properties.extensions.EnvironmentExtensionPoint;
import org.eclipse.papyrus.properties.root.PropertiesRoot;
import org.eclipse.papyrus.properties.root.RootFactory;
import org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor;
import org.eclipse.papyrus.properties.runtime.preferences.Preferences;
import org.eclipse.papyrus.properties.runtime.preferences.PreferencesFactory;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.papyrus.properties.util.Util;

/**
 * Central class of the Property View framework. It lists the available environments and contexts,
 * and is responsible for Enabling or Disabling contexts programmatically.
 * 
 * All {@link Context}s should have unique names.
 * 
 * @see ContextExtensionPoint
 * @see EnvironmentExtensionPoint
 * @see Preferences
 * @see ConfigurationManager#instance
 * 
 * @author Camille Letavernier
 */
public class ConfigurationManager {

	private final Preferences preferences;

	private final PropertiesRoot root;

	private ResourceSet resourceSet = new ResourceSetImpl();

	private boolean started = false;

	/**
	 * All contexts (Whether they are applied or not)
	 */
	private Map<URI, Context> contexts = new LinkedHashMap<URI, Context>();

	private Set<Context> enabledContexts = new LinkedHashSet<Context>();

	/**
	 * The global constraint engine
	 */
	public ConstraintEngine constraintEngine;

	/**
	 * The DisplayEngine for the PropertyView
	 */
	public DisplayEngine display;

	/**
	 * The singleton instance
	 */
	public final static ConfigurationManager instance = new ConfigurationManager();

	private ConfigurationManager() {
		display = new DefaultDisplayEngine();
		constraintEngine = new DefaultConstraintEngine();
		enabledContexts = new HashSet<Context>();

		root = RootFactory.eINSTANCE.createPropertiesRoot();

		preferences = loadPreferences();
	}

	private void start() {
		if(started) {
			return;
		}

		started = true;

		new ContextExtensionPoint();
		new EnvironmentExtensionPoint();

		loadCustomContexts();
	}

	private EObject loadEMFModel(URI sourceURI) throws IOException {
		return EMFHelper.loadEMFModel(resourceSet, sourceURI);
	}

	private Preferences loadPreferences() {
		IPath path = Activator.getDefault().getPreferencesPath();
		String preferencesPath = path.toString() + "/preferences.xmi"; //$NON-NLS-1$
		URI preferencesURI = URI.createFileURI(preferencesPath);

		try {
			EObject model = loadEMFModel(preferencesURI);
			if(model != null && model instanceof Preferences) {
				return (Preferences)model;
			}
		} catch (Exception ex) {
			//File not found : we ignore the exception //TODO : improve the exceptions (FileNotFound is not the only one that can occur)
		}

		//If we're here, then the preferences.xmi doesn't exist or isn't valid : we create it

		return createPreferences(preferencesURI);
	}

	private Preferences createPreferences(URI preferencesURI) {
		Preferences preferencesStore = PreferencesFactory.eINSTANCE.createPreferences();

		Resource resource = resourceSet.createResource(preferencesURI);
		resource.getContents().add(preferencesStore);
		saveModel(preferencesStore);

		return preferencesStore;
	}

	private void loadCustomContexts() {
		IPath path = Activator.getDefault().getPreferencesPath();
		File preferencesDirectory = path.toFile();
		for(File contextDirectory : preferencesDirectory.listFiles()) {
			try {
				if(contextDirectory.isDirectory()) {
					loadCustomContext(contextDirectory);
				}
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}
	}

	/**
	 * Refresh the Context represented by the given File. The File should be
	 * a valid Context model. This method should be called when a model is edited
	 * at runtime.
	 * 
	 * @param contextFile
	 *        A File containing a valid Context model
	 */
	public void refresh(File contextFile) {
		URI contextURI = URI.createFileURI(contextFile.getAbsolutePath());

		if(contexts.containsKey(contextURI)) {
			//Unloads the previous objects corresponding to this context
			Context previousContext = contexts.get(contextURI);
			enabledContexts.remove(previousContext);
			previousContext.eResource().unload();

			//Adds the new object corresponding to this context
			try {
				addContext(contextURI);
				constraintEngine.contextChanged();
			} catch (IOException ex) {
				Activator.log.error(ex);
			}
		}
	}

	private void loadCustomContext(File contextDirectory) throws IOException {
		String contextPath = contextDirectory.getPath() + "/" + contextDirectory.getName() + ".ctx"; //$NON-NLS-1$ //$NON-NLS-2$
		URI contextURI = URI.createFileURI(contextPath);
		EObject model = loadEMFModel(contextURI);
		if(model instanceof Context) {
			Context context = (Context)model;
			addContext(context, isApplied(context));
		}
	}

	/**
	 * Tests if a Context is enabled.
	 * 
	 * @param context
	 * @return
	 *         true if the given context is enabled.
	 * 
	 * @see Preferences
	 */
	public boolean isApplied(Context context) {
		return findDescriptor(context).isApplied();
	}

	/**
	 * Retrieves the ContextDescriptor associated to the specified context.
	 * If a matching descriptor cannot be found, a new Descriptor is created
	 * in the preferences.
	 * 
	 * @param context
	 * @return
	 */
	private ContextDescriptor findDescriptor(Context context) {
		if(context.getName() == null || context.getName().equals("")) { //$NON-NLS-1$
			return null;
		}

		for(ContextDescriptor descriptor : preferences.getContexts()) {
			if(descriptor.getName().equals(context.getName())) {
				return descriptor;
			}
		}
		//The descriptor hasn't been found : We create it

		ContextDescriptor descriptor = PreferencesFactory.eINSTANCE.createContextDescriptor();
		descriptor.setName(context.getName());
		preferences.getContexts().add(descriptor);
		savePreferences();
		return descriptor;
	}

	/**
	 * Adds a context via its URI. The URI should represent a valid Context model.
	 * The model is loaded in the ConfigurationManager's resourceSet.
	 * 
	 * @param uri
	 *        The context's URI
	 * @throws IOException
	 *         If the model behind this URI is not a valid Context
	 */
	public void addContext(URI uri) throws IOException {
		Context context = (Context)loadEMFModel(uri);
		if(context != null) {
			addContext(context, isApplied(context));
		}
	}

	/**
	 * Programmatically register a new context to this ConfigurationManager.
	 * Most of the time, new contexts should be registered through {@link ContextExtensionPoint}.
	 * However, you can still call this method when creating a Context at runtime, programmatically
	 * (Wizards, ...)
	 * All {@link Context} should have unique names
	 * 
	 * @param context
	 *        The new context to register
	 * @param apply
	 *        Whether the context should be enabled or not
	 * 
	 * @see ConfigurationManager#addContext(URI)
	 */
	public void addContext(Context context, boolean apply) {
		contexts.put(context.eResource().getURI(), context);
		if(apply) {
			enableContext(context, true);
		} else {
			disableContext(context, true);
		}
	}

	/**
	 * @return the list of <strong>enabled</strong> contexts
	 */
	public Collection<Context> getEnabledContexts() {
		return enabledContexts;
	}

	/**
	 * Disable a Context.
	 * 
	 * @param context
	 *        The Context to disable
	 * @see Preferences
	 * @see #enableContext(Context)
	 */
	public void disableContext(Context context, boolean update) {
		update = enabledContexts.remove(context) && update;

		//Update the preferences
		ContextDescriptor descriptor = findDescriptor(context);
		if(descriptor.isApplied()) {
			descriptor.setApplied(false);
			savePreferences();
		}

		if(update) {
			//Update the Engine
			update();
		}
	}

	/**
	 * Enables a Context
	 * 
	 * @param context
	 *        The Context to enable
	 * 
	 * @see #disableContext(Context)
	 */
	public void enableContext(Context context, boolean update) {

		enabledContexts.add(context);
		//root.getContexts().add(context);

		//Update the preferences
		ContextDescriptor descriptor = findDescriptor(context);
		if(!descriptor.isApplied()) {
			descriptor.setApplied(true);
			savePreferences();
		}

		if(update) {
			//Update the Engine
			constraintEngine.addContext(context);
		}
	}

	/**
	 * Tests if a Context is a plugin context. plugin contexts
	 * are registered through {@link ContextExtensionPoint} and are
	 * read-only.
	 * 
	 * @param context
	 * @return
	 *         True if the context comes from a plugin, and is thus read-only
	 */
	public boolean isPlugin(Context context) {
		URI uri = context.eResource().getURI();
		boolean result = !(uri.isFile() || uri.isPlatformResource());
		return result;
	}

	/**
	 * Loads a Context from the given URI. The model is loaded in the {@link ConfigurationManager}'s resourceSet
	 * 
	 * @param uri
	 *        The URI from which the Context is loaded
	 * @return
	 *         The loaded context
	 * @throws IOException
	 *         If the URI doesn't represent a valid Context model
	 */
	public Context getContext(URI uri) throws IOException {
		return (Context)loadEMFModel(uri);
	}

	private void addEnvironment(Environment environment) {
		root.getEnvironments().add(environment);
	}

	/**
	 * Adds a new Environment from the given URI.
	 * 
	 * @param uri
	 *        The URI from which the Environment is retrieved.
	 * @throws IOException
	 *         if the URI doesn't represent a valid Environment model
	 */
	public void addEnvironment(URI uri) throws IOException {
		Environment environment = (Environment)loadEMFModel(uri);
		addEnvironment(environment);
	}

	/**
	 * @return
	 *         The PropertiesRoot for the Property view framework. The PropertiesRoot contains
	 *         all registered Environments and Contexts (Whether they are enabled or disabled)
	 */
	public PropertiesRoot getPropertiesRoot() {
		return root;
	}

	/**
	 * Returns the context from the given context name
	 * 
	 * @param contextName
	 *        The name of the context to retrieve
	 * @return
	 *         The context corresponding to the given name
	 */
	public Context getContext(String contextName) {
		for(Context context : contexts.values()) {
			if(context.getName().equals(contextName)) {
				return context;
			}
		}
		return null;
	}

	private void savePreferences() {
		saveModel(preferences);
	}

	private void saveModel(EObject eObject) {
		try {
			eObject.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * Returns all the known contexts, whether they are applied or not.
	 * To get only applied contexts, see {@link #getEnabledContexts()}
	 * 
	 * @return All known contexts
	 * 
	 * @see PropertiesRoot#getContexts()
	 */
	public Collection<Context> getContexts() {
		return contexts.values();
	}

	@SuppressWarnings("unchecked")
	private <T extends WidgetType> T getDefaultWidget(int featureID, Class<T> theClass, String widgetName, String namespacePrefix) {
		EStructuralFeature feature = EnvironmentPackage.Literals.ENVIRONMENT.getEStructuralFeature(featureID);
		for(Environment environment : root.getEnvironments()) {
			T widget = findWidgetTypeByClassName((EList<T>)environment.eGet(feature), widgetName, namespacePrefix);
			if(widget != null) {
				return widget;
			}
		}
		return null;
	}


	private <T extends WidgetType> T findWidgetTypeByClassName(Collection<T> types, String className, String namespacePrefix) {
		for(T widgetType : types) {
			if(widgetType.getWidgetClass().equals(className) && Util.namespaceEqualsByName(widgetType.getNamespace(), namespacePrefix)) {
				return widgetType;
			}
		}
		return null;
	}

	/**
	 * @return the default implementation of CompositeWidgetType
	 */
	public CompositeWidgetType getDefaultCompositeType() {
		return getDefaultWidget(EnvironmentPackage.ENVIRONMENT__COMPOSITE_WIDGET_TYPES, CompositeWidgetType.class, "Composite", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @return the default implementation of LayoutType
	 */
	public LayoutType getDefaultLayoutType() {
		return getDefaultWidget(EnvironmentPackage.ENVIRONMENT__LAYOUT_TYPES, LayoutType.class, "PropertiesLayout", "ppel"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @return the default implementation of StandardWidgetType
	 */
	public StandardWidgetType getDefaultWidgetType() {
		return getDefaultWidget(EnvironmentPackage.ENVIRONMENT__WIDGET_TYPES, StandardWidgetType.class, "Label", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @param propertyType
	 * @param multiple
	 * @return the default implementation of PropertyEditorType for the given property Type
	 *         and multiplicity
	 */
	public PropertyEditorType getDefaultEditorType(Type propertyType, boolean multiple) {
		String propertyEditorName = null;
		switch(propertyType) {
		case BOOLEAN:
			propertyEditorName = multiple ? "MultiBoolean" : "BooleanRadio"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case ENUMERATION:
			propertyEditorName = multiple ? "MultiEnum" : "EnumCombo"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case INTEGER:
			propertyEditorName = multiple ? "MultiInteger" : "IntegerEditor"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case REFERENCE:
			propertyEditorName = multiple ? "MultiReference" : "ReferenceDialog"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case STRING:
			propertyEditorName = multiple ? "MultiString" : "StringEditor"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		}

		if(propertyEditorName == null) {
			return null;
		}

		return getDefaultWidget(EnvironmentPackage.ENVIRONMENT__PROPERTY_EDITOR_TYPES, PropertyEditorType.class, propertyEditorName, "ppe"); //$NON-NLS-1$
	}

	/**
	 * Returns the default XWT namespaces
	 * 
	 * @return the default XWT namespaces
	 */
	public Set<Namespace> getBaseNamespaces() {
		Set<Namespace> result = new HashSet<Namespace>();
		result.add(getNamespaceByName("")); //$NON-NLS-1$
		result.add(getNamespaceByName("x")); //$NON-NLS-1$
		result.add(getNamespaceByName("j")); //$NON-NLS-1$
		return result;
	}

	/**
	 * @param name
	 * @return
	 *         The namespace corresponding to the given name
	 */
	public Namespace getNamespaceByName(String name) {
		for(Environment environment : root.getEnvironments()) {
			for(Namespace namespace : environment.getNamespaces()) {
				if(Util.namespaceEqualsByName(namespace, name)) {
					return namespace;
				}
			}
		}
		Activator.log.warn("Cannot find a registered namespace for '" + name + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		return null;
	}

	/**
	 * @param property
	 * @return
	 *         the default PropertyEditorType for the given Property
	 */
	public PropertyEditorType getDefaultEditorType(Property property) {
		return getDefaultEditorType(property.getType(), property.getMultiplicity() != 1);
	}

	/**
	 * Disable, then unregisters a Context. The Context won't be available anymore in the framework
	 * (not even in the Preferences page). This method <strong>won't</strong> delete the context's files
	 * on the file system.
	 * 
	 * @param context
	 *        The context to delete
	 */
	public void deleteContext(Context context) {
		contexts.remove(context.eResource().getURI());
		disableContext(context, true);
		root.getContexts().remove(context);
	}

	/**
	 * Initializes the ConfigurationManager instance. This method should be called only once
	 */
	public static void init() {
		instance.start();
	}

	/**
	 * Retrieves the Property object associated to the propertyPath in the given context
	 * 
	 * @param propertyPath
	 * @param context
	 * @return
	 *         The property associated to the given propertyPath
	 */
	public Property getProperty(String propertyPath, Context context) {
		String elementName = propertyPath.substring(0, propertyPath.lastIndexOf(":")); //$NON-NLS-1$
		String propertyName = propertyPath.substring(propertyPath.lastIndexOf(":") + 1, propertyPath.length()); //$NON-NLS-1$
		Set<DataContextElement> elements = new HashSet<DataContextElement>();

		Collection<Context> allContexts;

		if(context == null) {
			allContexts = getContexts();
		} else {
			allContexts = Util.getDependencies(context);
		}

		for(Context ctx : allContexts) {
			elements.addAll(ctx.getDataContexts());
		}

		DataContextElement element = Util.getContextElementByQualifiedName(elementName, elements);
		if(element != null) {
			for(Property property : element.getProperties()) {
				if(property.getName().equals(propertyName)) {
					return property;
				}
			}
		}

		return null;
	}

	/**
	 * Updates the constraint engine to handle changes in the contexts
	 * activation
	 */
	public void update() {
		constraintEngine.contextChanged();
	}

	/**
	 * Checks the conflicts between all applied configurations
	 * A Conflict may occur when two sections have the same ID : they can't
	 * be displayed at the same time
	 * 
	 * @return
	 *         The list of conflicts
	 */
	public Collection<ConfigurationConflict> checkConflicts() {
		Map<String, List<Context>> sections = new HashMap<String, List<Context>>();
		Map<String, ConfigurationConflict> conflicts = new HashMap<String, ConfigurationConflict>();

		for(Context context : getEnabledContexts()) {
			for(Tab tab : context.getTabs()) {
				for(Section section : tab.getSections()) {
					String sectionID = section.getName();
					List<Context> contexts = sections.get(sectionID);
					if(contexts == null) {
						contexts = new LinkedList<Context>();
						sections.put(sectionID, contexts);
					} else {
						ConfigurationConflict conflict = conflicts.get(sectionID);
						if(conflict == null) {
							conflict = new ConfigurationConflict(sectionID);
							conflicts.put(sectionID, conflict);

							conflict.addContext(contexts.get(0));
						}

						conflict.addContext(context);
					}

					contexts.add(context);
				}
			}
		}

		return conflicts.values();
	}
}
