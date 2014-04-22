/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Factor out workspace storage for pluggable storage providers (CDO)
 *  Christian W. Damus (CEA) - Support implicit enablement of prototypes of unavailable contexts (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.ContextsFactory;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.environment.CompositeWidgetType;
import org.eclipse.papyrus.views.properties.environment.Environment;
import org.eclipse.papyrus.views.properties.environment.EnvironmentPackage;
import org.eclipse.papyrus.views.properties.environment.LayoutType;
import org.eclipse.papyrus.views.properties.environment.Namespace;
import org.eclipse.papyrus.views.properties.environment.PropertyEditorType;
import org.eclipse.papyrus.views.properties.environment.StandardWidgetType;
import org.eclipse.papyrus.views.properties.environment.Type;
import org.eclipse.papyrus.views.properties.environment.WidgetType;
import org.eclipse.papyrus.views.properties.extensions.ContextExtensionPoint;
import org.eclipse.papyrus.views.properties.extensions.EnvironmentExtensionPoint;
import org.eclipse.papyrus.views.properties.root.PropertiesRoot;
import org.eclipse.papyrus.views.properties.root.RootFactory;
import org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor;
import org.eclipse.papyrus.views.properties.runtime.preferences.Preferences;
import org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesFactory;
import org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesPackage;
import org.eclipse.papyrus.views.properties.storage.ContextStorageRegistry;
import org.eclipse.papyrus.views.properties.storage.IContextStorageProvider;
import org.eclipse.papyrus.views.properties.storage.IContextStorageProviderListener;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;
import org.eclipse.swt.widgets.Display;

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

	private final ResourceSet resourceSet = new ResourceSetImpl();

	private boolean started = false;

	/**
	 * All contexts (Whether they are applied or not)
	 */
	private final Map<URI, Context> contexts;

	private final Set<Context> enabledContexts;

	private final Map<Context, Boolean> customizableContexts;

	private final ContextStorageRegistry contextStorageRegistry;

	private IContextStorageProviderListener contextStorageProviderListener;

	/**
	 * The global constraint engine
	 */
	private ViewConstraintEngine constraintEngine;

	/**
	 * The singleton instance
	 */
	private final static ConfigurationManager instance = new ConfigurationManager();

	public static ConfigurationManager getInstance() {
		synchronized(instance) {
			if(!instance.started) {
				instance.start();
			}
		}
		return instance;
	}

	private ConfigurationManager() {
		constraintEngine = new ViewConstraintEngineImpl();
		enabledContexts = new LinkedHashSet<Context>();
		customizableContexts = new HashMap<Context, Boolean>();
		contexts = new LinkedHashMap<URI, Context>();
		contextStorageRegistry = new ContextStorageRegistry(resourceSet);

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

		// now that we have loaded the custom contexts, we can migrate the preferences from a
		// previous version (if required)
		if(new PreferencesMigrator(this).process(preferences)) {
			savePreferences();
		}
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
		preferencesStore.setVersion(Preferences.CURRENT_VERSION);

		Resource resource = resourceSet.createResource(preferencesURI);
		resource.getContents().add(preferencesStore);
		saveModel(preferencesStore);

		return preferencesStore;
	}

	private void loadCustomContexts() {
		for(IContextStorageProvider provider : contextStorageRegistry.getStorageProviders()) {
			// discover initial contexts
			try {
				for(Context context : provider.loadContexts()) {
					addContext(context, findDescriptor(context).isApplied(), true);
				}
			} catch (CoreException ex) {
				//Silent : The file has been removed from the preferences, but the folder still exists
			}

			// listen for changes
			provider.addContextStorageProviderListener(getContextStorageProviderListener());
		}
	}

	private IContextStorageProviderListener getContextStorageProviderListener() {
		if(contextStorageProviderListener == null) {
			contextStorageProviderListener = new IContextStorageProviderListener() {

				public void contextsAdded(Collection<? extends Context> contexts) {
					List<Context> appliedContexts = new java.util.ArrayList<Context>(contexts.size());

					for(Context next : contexts) {
						boolean applied = findDescriptor(next).isApplied();

						addContext(next, applied, true);

						if(applied) {
							appliedContexts.add(next);
						}
					}

					if(!appliedContexts.isEmpty()) {
						notifyContextChanges(appliedContexts, ContextEventType.ADDED);
					}
				}

				public void contextsChanged(Collection<? extends Context> contexts) {
					List<Context> appliedContexts = new java.util.ArrayList<Context>(contexts.size());

					for(Context next : contexts) {
						boolean applied = findDescriptor(next).isApplied();

						reloadContext(next);

						if(applied) {
							appliedContexts.add(next);
						}
					}

					if(!appliedContexts.isEmpty()) {
						notifyContextChanges(appliedContexts, ContextEventType.CHANGED);
					}
				}

				public void contextsRemoved(Collection<? extends Context> contexts) {
					List<Context> appliedContexts = new java.util.ArrayList<Context>(contexts.size());

					for(Context next : contexts) {
						boolean wasApplied = findDescriptor(next).isApplied();

						// don't update the preferences on the expectation that this context
						// is only temporarily unavailable
						deleteContext(next, false);

						if(wasApplied) {
							appliedContexts.add(next);
						}
					}

					if(!appliedContexts.isEmpty()) {
						notifyContextChanges(appliedContexts, ContextEventType.REMOVED);
					}
				}
			};
		}

		return contextStorageProviderListener;
	}

	private void notifyContextChanges(Collection<Context> contexts, IContextStorageProviderListener.ContextEventType eventType) {
		if(contexts.size() == 0) {
			throw new IllegalArgumentException("Empty contexts collection");
		}

		StringBuilder list = new StringBuilder();
		Iterator<Context> iter = contexts.iterator();
		if(contexts.size() > 1) {
			list.append("\n");
		}
		list.append(iter.next().getName());
		while(iter.hasNext()) {
			list.append("\n");
			list.append(iter.next().getName());
		}

		String pattern;
		switch(eventType) {
		case ADDED:
			pattern = "New Properties View configurations have been applied: {0}";
			break;
		case REMOVED:
			pattern = "Properties View configurations are no longer available: {0}";
			break;
		default:
			pattern = "Properties View configurations have changed: {0}";
			break;
		}
		final String message = NLS.bind(pattern, list);

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				NotificationBuilder.createAsyncPopup(message).setType(org.eclipse.papyrus.infra.widgets.toolbox.notification.Type.INFO).setDelay(5000L).run();
			}
		});

	}

	/**
	 * Refresh the given Context. This method should be called when a model is edited
	 * at runtime, to re-load it from persistent storage.
	 *
	 * @param context
	 *        A Context model to re-load
	 */
	public void refresh(Context context) {
		IContextStorageProvider provider = contextStorageRegistry.getStorageProvider(context);
		if(provider != null) {
			try {
				provider.refreshContext(context);
				reloadContext(context);
			} catch (CoreException e) {
				Activator.getDefault().getLog().log(e.getStatus());
			}
		}
	}

	private void reloadContext(Context context) {
		// TODO : get the right URI from the context file :
		// ppe:/context/<plugin>/<path> if it is in the workspace,
		// ppe:/context/<preferences>/<path> if it is registered through
		// preferences

		URI contextURI = EcoreUtil.getURI(context);

		if(contexts.containsKey(contextURI)) {
			// Unloads the previous objects corresponding to this context
			Context previousContext = contexts.get(contextURI);
			enabledContexts.remove(previousContext);
			previousContext.eResource().unload();

			// Adds the new object corresponding to this context
			try {
				addContext(contextURI);
				constraintEngine.refresh();
			} catch (IOException ex) {
				Activator.log.error(ex);
			}
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
		boolean result = !isCustomizable(context) || findDescriptor(context).isApplied();

		if(!result) {
			// see whether perhaps there's an active descriptor for a missing context that
			// is based on this context
			@SuppressWarnings("serial")
			EcoreUtil.CrossReferencer xrefs = new EcoreUtil.CrossReferencer(preferences) {

				{
					crossReference();
					done();
				}

				@Override
				protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
					return eReference == PreferencesPackage.Literals.CONTEXT_DESCRIPTOR__PROTOTYPE;
				}
			};

			// breadth-first search for a copied context that is enabled but missing, where
			// no other traceable copy is enabled and accessible
			Queue<ContextDescriptor> queue = new java.util.LinkedList<ContextDescriptor>();
			Set<ContextDescriptor> cycleDetect = new java.util.HashSet<ContextDescriptor>();
			queue.offer(findDescriptor(context));
			out: while(!queue.isEmpty()) {
				ContextDescriptor desc = queue.remove();
				Collection<EStructuralFeature.Setting> refs = xrefs.get(desc);
				if((refs != null) && cycleDetect.add(desc)) {
					for(EStructuralFeature.Setting ref : refs) {
						ContextDescriptor copy = (ContextDescriptor)ref.getEObject();
						if(copy.isApplied()) {
							if(getContext(copy.getName()) == null) {
								// it's an applied context that is missing.  That's what we're looking for
								result = true;
							} else {
								// it's an applied context that is *not* missing.  So, it is in effect
								// and the prototype should not implicitly be enabled
								result = false;
								break out;
							}
						} else {
							// enqueue for searching further copies
							queue.offer(copy);
						}
					}
				}
			}
		}

		return result;
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
	public void addContext(URI uri, boolean customizable) throws IOException {
		EObject firstRootObject = loadEMFModel(uri);

		if(firstRootObject != null) {
			for(EObject rootObject : firstRootObject.eResource().getContents()) {
				if(rootObject instanceof Context) {
					Context context = (Context)rootObject;
					addContext(context, findDescriptor(context).isApplied(), customizable);
				}
			}
		}
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
		addContext(uri, true);
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
		addContext(context, apply, true);
	}

	/**
	 * Recalculates the cached preference descriptor prototype of the specified {@code context}.
	 * This ensures that if the {@code context} becomes unavailable, we will still know locally
	 * in this workspace what its prototype is.
	 *
	 * @param context
	 *        a context
	 */
	private void updatePrototype(Context context) {
		Context prototype = context.getPrototype();
		if((prototype == null) || !prototype.eIsProxy()) {
			// it has no prototype or the prototype is available?  Cache in the preferences
			ContextDescriptor desc = findDescriptor(context);
			ContextDescriptor oldPrototype = desc.getPrototype();

			desc.setPrototype((prototype == null) ? null : findDescriptor(prototype));

			if(desc.getPrototype() != oldPrototype) {
				savePreferences();
			}
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
	public void addContext(Context context, boolean apply, boolean isCustomizable) {

		URI contextURI = EcoreUtil.getURI(context);
		if(contexts.containsKey(contextURI)) {
			throw new IllegalArgumentException("This properties view configuration is already deployed");
		}

		customizableContexts.put(context, isCustomizable);
		contexts.put(contextURI, context);

		updatePrototype(context);

		ContextDescriptor desc = findDescriptor(context);
		if(desc.isDeleted()) {
			desc.setDeleted(false); // can't be deleted any longer
			savePreferences();
		}

		//If the context is not customizable, then it must always be applied
		if(apply || !isCustomizable) {
			enableContext(context, true);
		} else {
			disableContext(context, true);
		}

		// as we have added a new context, it may be an applied copy of some
		// other context that was implicitly enabled because of the missing copy
		reconcileEnabledContexts();
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
	 * @param update
	 *        If true, the constraint engine will be updated to handle the
	 *        modification
	 *        If false, you should call manually {@link #update()} to refresh
	 *        the constraint engine
	 * @see Preferences
	 * @see #enableContext(Context, boolean)
	 */
	public void disableContext(Context context, boolean update) {
		disableContext(context, update, true);
	}

	private void disableContext(Context context, boolean updateEngine, boolean updatePreferences) {
		final boolean missing = isMissing(context);

		if(!missing && !isCustomizable(context)) {
			throw new IllegalStateException("Non-customizable contexts cannot be disabled. Trying to disable " + context.getName());
		}

		// even if it's missing, make sure it's not in the enabledContexts set!
		updateEngine = enabledContexts.remove(context) && updateEngine;

		//Update the preferences if requested
		ContextDescriptor descriptor = findDescriptor(context);
		if(updatePreferences && descriptor.isApplied()) {
			descriptor.setApplied(false);
			savePreferences();
		}

		if(updateEngine) {
			//Update the Engine
			update();
		}
	}

	/**
	 * Enables a Context
	 *
	 * @param context
	 *        The Context to enable
	 * @param update
	 *        If true, the constraint engine will be updated to handle the
	 *        modification
	 *        If false, you should call manually {@link #update()} to refresh
	 *        the constraint engine
	 *
	 * @see #disableContext(Context, boolean)
	 */
	public void enableContext(Context context, boolean update) {
		enableContext(context, update, true);
	}

	private void enableContext(Context context, boolean updateEngine, boolean updatePreferences) {
		final boolean missing = isMissing(context);

		if(!missing) {
			enabledContexts.add(context);
		}

		//Update the preferences if requested
		ContextDescriptor descriptor = findDescriptor(context);
		if(updatePreferences && !descriptor.isApplied()) {
			descriptor.setApplied(true);
			savePreferences();
		}

		if(updateEngine && !missing) {
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
		// a missing context can't be a plug-in context because plug-ins can't go missing
		boolean result = !isMissing(context) && contextStorageRegistry.getStorageProvider(context) == IContextStorageProvider.NULL;
		return result;
	}

	/**
	 * Queries whether the specified {@code context} is a proxy for a missing context. That is a
	 * context that is expected to exist but is (temporarily) unavailable.
	 *
	 * @param context
	 *        a context
	 * @return whether it represents a missing context
	 */
	public boolean isMissing(Context context) {
		return !contexts.containsValue(context) && !findDescriptor(context).isDeleted();
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
		for(Context context : getContexts()) {
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
	 * Returns all the known contexts, even if they are not applied
	 * To get only applied contexts, see {@link #getEnabledContexts()}
	 *
	 * @return All known contexts
	 *
	 * @see PropertiesRoot#getContexts()
	 */
	public Collection<Context> getContexts() {
		return contexts.values();
	}

	/**
	 * Returns all the known customizable contexts.
	 *
	 * @return All known contexts
	 *
	 * @see PropertiesRoot#getContexts()
	 * @see {@link #getEnabledContexts()}
	 */
	public Collection<Context> getCustomizableContexts() {
		List<Context> result = new LinkedList<Context>();
		for(Context context : contexts.values()) {
			if(isCustomizable(context)) {
				result.add(context);
			}
		}
		return result;
	}

	/**
	 * Obtains proxies (not the EMF kind) for all contexts that the system knows about
	 * but are currently unavailable.
	 *
	 * @return the current collection of missing contexts
	 */
	public Collection<Context> getMissingContexts() {
		List<Context> result = new java.util.ArrayList<Context>();

		for(ContextDescriptor next : preferences.getContexts()) {
			if(!next.isDeleted() && (getContext(next.getName()) == null)) {
				Context missing = ContextsFactory.eINSTANCE.createContext();
				missing.setName(next.getName());
				result.add(missing);
			}
		}

		return result;
	}

	private <T extends WidgetType> T getDefaultWidget(int featureID, Class<T> theClass, String widgetName, String namespacePrefix) {
		EStructuralFeature feature = EnvironmentPackage.Literals.ENVIRONMENT.getEStructuralFeature(featureID);
		for(Environment environment : root.getEnvironments()) {
			@SuppressWarnings("unchecked")
			T widget = findWidgetTypeByClassName((EList<T>)environment.eGet(feature), widgetName, namespacePrefix);
			if(widget != null) {
				return widget;
			}
		}
		return null;
	}


	private <T extends WidgetType> T findWidgetTypeByClassName(Collection<T> types, String className, String namespacePrefix) {
		for(T widgetType : types) {
			if(widgetType.getWidgetClass().equals(className) && PropertiesUtil.namespaceEqualsByName(widgetType.getNamespace(), namespacePrefix)) {
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
		case DOUBLE:
			propertyEditorName = multiple ? "MultiDouble" : "DoubleEditor"; //$NON-NLS-1$ //$NON-NLS-2$
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
				if(PropertiesUtil.namespaceEqualsByName(namespace, name)) {
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
		deleteContext(context, true);
	}

	/**
	 * Disable, then unregisters a Context. The Context won't be available anymore in the framework
	 * (not even in the Preferences page). This method <strong>won't</strong> delete the context's files
	 * on the file system.
	 *
	 * @param context
	 *        The context to delete
	 * @param updateEngine
	 *        If set to true, the ConstraintEngine will be updated.
	 *        If set to false, you will need to call {@link #update()} manually
	 */
	public void deleteContext(Context context, boolean updateEngine) {
		findDescriptor(context).setDeleted(true); // explicitly deleted (not missing)
		deleteContext(context, updateEngine, true);
	}

	private void deleteContext(Context context, boolean updateEngine, boolean updatePreferences) {
		if(!isCustomizable(context)) {
			throw new IllegalStateException("Non-customizable contexts cannot be deleted. Trying to delete " + context.getName());
		}

		Resource resource = context.eResource();
		contexts.remove(EcoreUtil.getURI(context));
		disableContext(context, updateEngine, updatePreferences);
		root.getContexts().remove(context);

		resource.unload();
		resourceSet.getResources().remove(resource);

		// as we have deleted this context, it may have been a copy of
		// some other context that now should be implicitly enabled
		reconcileEnabledContexts();
	}

	private boolean reconcileEnabledContexts() {
		boolean result = false;

		for(Context next : contexts.values()) {
			if(!next.eIsProxy()) {
				boolean isApplied = isApplied(next);
				if(isApplied != enabledContexts.contains(next)) {
					// it is implicitly enabled?
					if(isApplied) {
						result = enabledContexts.add(next) || result;
					} else {
						result = enabledContexts.remove(next) || result;
					}
				}
			}
		}

		if(result) {
			update(); // update the engine
		}

		return result;
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
			allContexts = PropertiesUtil.getDependencies(context);
		}

		for(Context ctx : allContexts) {
			elements.addAll(ctx.getDataContexts());
		}

		DataContextElement element = PropertiesUtil.getContextElementByQualifiedName(elementName, elements);
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
		constraintEngine.refresh();
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

	/**
	 * Returns the ResourceSet associated to the ConfigurationManager,
	 * ie. the ResourceSet containing all Environments and Contexts
	 *
	 * @return
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public boolean isCustomizable(Context propertyViewConfiguration) {

		if(isMissing(propertyViewConfiguration)) {
			// missing contexts are implicitly customizable.  Only customizable
			// contexts can go missing in the first place
			return true;
		}

		if(customizableContexts.containsKey(propertyViewConfiguration)) {
			return customizableContexts.get(propertyViewConfiguration);
		}

		//Default value for isCustomizable is true. However, if the context is
		//not stored in customizableContexts, then it's an error. We should
		//disable customization tools for this one...
		return false;
	}

	public ViewConstraintEngine getConstraintEngine() {
		return constraintEngine;
	}
}
