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
import java.util.LinkedHashMap;
import java.util.Map;

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
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.environment.CompositeWidgetType;
import org.eclipse.papyrus.properties.environment.Environment;
import org.eclipse.papyrus.properties.environment.EnvironmentPackage;
import org.eclipse.papyrus.properties.environment.LayoutType;
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

public class ConfigurationManager {

	private final Preferences preferences;

	private final PropertiesRoot root;

	private ResourceSet resourceSet = new ResourceSetImpl();

	private boolean started = false;

	/**
	 * All contexts (Whether they are applied or not)
	 */
	private Map<URI, Context> contexts = new LinkedHashMap<URI, Context>();

	public ConstraintEngine constraintEngine;

	public DisplayEngine display;

	public final static ConfigurationManager instance = new ConfigurationManager();

	private ConfigurationManager() {
		display = new DefaultDisplayEngine();
		constraintEngine = new DefaultConstraintEngine();

		root = RootFactory.eINSTANCE.createPropertiesRoot();

		preferences = loadPreferences();
	}

	private void start() {
		if(started)
			return;

		started = true;

		new ContextExtensionPoint();
		new EnvironmentExtensionPoint();

		loadCustomContexts();
	}

	private EObject loadEMFModel(URI uri) throws IOException {
		try {
			Resource resource = resourceSet.getResource(uri, true);
			if(resource != null) {
				if(!resource.getContents().isEmpty()) {
					return resource.getContents().get(0);
				}
			}
		} catch (Exception ex) {
			throw new IOException(ex.toString());
		}

		return null;
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
			//File not found : we ignore the exception //@TODO : improve the exceptions (FileNotFound is not the only one that can occur)
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

	public void refresh(File contextFile) {
		URI contextURI = URI.createFileURI(contextFile.getAbsolutePath());

		if(contexts.containsKey(contextURI)) {
			//Unloads the previous objects corresponding to this context
			Context previousContext = contexts.get(contextURI);
			root.getContexts().remove(previousContext);
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
		if(context.getName() == null || context.getName().equals("")) //$NON-NLS-1$
			return null;

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

	public void addContext(Context context, boolean apply) {
		contexts.put(context.eResource().getURI(), context);
		if(apply) {
			enableContext(context);
		}
	}

	//	public void disableContext(String context) {
	//		Iterator<Context> iterator = environment.getContexts().iterator();
	//		while(iterator.hasNext()) {
	//			Context c = iterator.next();
	//			if(c.getName().equals(context)) {
	//				disableContext(c);
	//				return;
	//			}
	//		}
	//	}

	public void disableContext(Context context) {
		root.getContexts().remove(context);

		//Update the preferences
		ContextDescriptor descriptor = findDescriptor(context);
		if(descriptor.isApplied()) {
			descriptor.setApplied(false);
			savePreferences();
		}

		//Update the Engine
		constraintEngine.contextChanged();
	}

	//	public void enableContext(String contextName) {
	//		Context context = getContext(contextName);
	//		if(context != null)
	//			enableContext(context);
	//	}

	public void enableContext(Context context) {

		root.getContexts().add(context);

		//Update the preferences
		ContextDescriptor descriptor = findDescriptor(context);
		if(!descriptor.isApplied()) {
			descriptor.setApplied(true);
			savePreferences();
		}

		//Update the Engine
		constraintEngine.addContext(context);
	}

	public boolean isPlugin(Context context) {
		return !context.eResource().getURI().isFile();
	}

	/**
	 * Adds a context via extension point (The source is a plugin)
	 * 
	 * @param uri
	 *        The context's URI
	 */
	public void addContext(URI uri) throws IOException {
		Context context = (Context)loadEMFModel(uri);
		if(context != null)
			addContext(context, isApplied(context));
	}

	public Context getContext(URI uri) throws IOException {
		return (Context)loadEMFModel(uri);
	}

	public void addEnvironment(Environment environment) {
		root.getEnvironments().add(environment);
	}

	public void addEnvironment(URI uri) throws IOException {
		Environment environment = (Environment)loadEMFModel(uri);
		addEnvironment(environment);
	}

	public PropertiesRoot getPropertiesRoot() {
		return root;
	}

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
	 * Returns all the known contexts, whether they are applied or not
	 * To get only applied contexts, see {@link PropertyEditor#getPropertiesRoot()#getContexts()}
	 * 
	 * @return All known contexts
	 * @see PropertyEditor#getPropertiesRoot()#getContexts()
	 */
	public Collection<Context> getContexts() {
		return contexts.values();
	}

	@SuppressWarnings("unchecked")
	public <T extends WidgetType> T getDefaultWidget(int featureID, Class<T> theClass, String widgetName) {
		EStructuralFeature feature = EnvironmentPackage.Literals.ENVIRONMENT.getEStructuralFeature(featureID);
		for(Environment environment : root.getEnvironments()) {
			T widget = findWidgetTypeByClassName((EList<T>)environment.eGet(feature), widgetName);
			if(widget != null) {
				return widget;
			}
		}
		return null;
	}

	public <T extends WidgetType> T findWidgetTypeByClassName(Collection<T> types, String className) {
		for(T widgetType : types) {
			if(widgetType.getWidgetClass().equals(className)) {
				return widgetType;
			}
		}
		return null;
	}

	public CompositeWidgetType getDefaultCompositeType() {
		return getDefaultWidget(EnvironmentPackage.ENVIRONMENT__COMPOSITE_WIDGET_TYPES, CompositeWidgetType.class, "Composite"); //$NON-NLS-1$
	}

	public LayoutType getDefaultLayoutType() {
		return getDefaultWidget(EnvironmentPackage.ENVIRONMENT__LAYOUT_TYPES, LayoutType.class, "ppel:PropertiesLayout"); //$NON-NLS-1$
	}

	public StandardWidgetType getDefaultWidgetType() {
		return getDefaultWidget(EnvironmentPackage.ENVIRONMENT__WIDGET_TYPES, StandardWidgetType.class, "Label"); //$NON-NLS-1$
	}

	public PropertyEditorType getDefaultEditorType(Type propertyType, boolean multiple) {
		String propertyEditorName = null;
		switch(propertyType) {
		case BOOLEAN:
			propertyEditorName = multiple ? "ppe:MultiBoolean" : "ppe:BooleanRadio"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case ENUMERATION:
			propertyEditorName = multiple ? "ppe:MultiEnum" : "ppe:EnumCombo"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case INTEGER:
			propertyEditorName = multiple ? "ppe:MultiInteger" : "ppe:IntegerEditor"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case REFERENCE:
			propertyEditorName = multiple ? "ppe:MultiReference" : "ppe:ReferenceCombo"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case STRING:
			propertyEditorName = multiple ? "ppe:MultiString" : "ppe:StringEditor"; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		}

		if(propertyEditorName == null)
			return null;

		return getDefaultWidget(EnvironmentPackage.ENVIRONMENT__PROPERTY_EDITOR_TYPES, PropertyEditorType.class, propertyEditorName);
	}

	public PropertyEditorType getDefaultEditorType(Property property) {
		return getDefaultEditorType(property.getType(), property.getMultiplicity() != 1);
	}

	public static void init() {
		instance.start();
	}
}
