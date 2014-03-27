/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.pluginexplorer.Plugin;
import org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry;
import org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.PaletteRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder;

/**
 * The <code>PolicyChecker</code> enforces the viewpoints configuration as a policy in the user interface
 * 
 * @author Laurent Wouters
 */
public class PolicyChecker {
	/**
	 * ID of the extension point defining the configurations
	 */
	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.viewpoints.policy.custom";
	/**
	 * The cache of loaded configurations
	 */
	private static final Map<String, PapyrusConfiguration> CONFIGURATIONS_CACHE = new HashMap<String, PapyrusConfiguration>();
	/**
	 * The default built-in configuration
	 */
	private static final PapyrusConfiguration CONFIG_BUILTIN_DEFAULT = loadDefaultConfiguration("builtin/default.configuration");
	/**
	 * Default result when the current policy cannot determine whether an element can be added to a view
	 */
	private static final boolean DEFAULT_POLICY_UNKNOWN_CHILD = false;
	/**
	 * Default result when the current policy cannot determine whether a palette item should be exposed
	 */
	private static final boolean DEFAULT_POLICY_UNKNWON_PALETTE = true;


	/**
	 * Policy check result allowing an action
	 */
	private static final int RESULT_PERMIT = 1;
	/**
	 * Policy check result neither allowing not denying an action
	 */
	private static final int RESULT_UNKNOWN = 0;
	/**
	 * Policy check result denying an action
	 */
	private static final int RESULT_DENY = -1;

	/**
	 * Loads a built-in configuration
	 * 
	 * @param name
	 *            The name of the configuration
	 * @return The loaded configuration
	 */
	private static PapyrusConfiguration loadDefaultConfiguration(String name) {
		Plugin me = new Plugin(Activator.getDefault().getBundle());
		PluginEntry entry = me.getEntry(name);
		return loadConfigurationFrom(entry.getLogicalPath());
	}

	/**
	 * Loads a viewpoints configuration from the given location.
	 * 
	 * @param location
	 *            The location from where to load the configuration
	 * @return The loaded configuration, or <code>null</code> if the operation failed
	 */
	public static PapyrusConfiguration loadConfigurationFrom(String location) {
		try {
			if (location == null)
				return null;
			if (location.isEmpty())
				return null;
			URI uri = null;
			if (location.startsWith("platform:/")) {
				uri = URI.createURI(location);
			} else {
				uri = URI.createFileURI(location);
			}
			location = uri.toString();
			PapyrusConfiguration config = CONFIGURATIONS_CACHE.get(location);
			if (config != null)
				return config;
			ResourceSet set = new ResourceSetImpl();
			Resource res = set.getResource(uri, true);
			config = (PapyrusConfiguration) res.getContents().get(0);
			CONFIGURATIONS_CACHE.put(location, config);
			return config;
		} catch (NullPointerException e) {
		}
		return null;
	}

	/**
	 * Gets the default configuration
	 * 
	 * @return The default configuration
	 */
	public static PapyrusConfiguration getDefaultConfiguration() {
		return CONFIG_BUILTIN_DEFAULT;
	}


	private static Map<String, Collection<String>> CONTRIBUTIONS_DEFINITON = null;
	private static Map<PapyrusConfiguration, Collection<PapyrusConfiguration>> CONTRIBUTIONS_CACHE = null;

	/**
	 * Gets the viewpoints contributing to the given viewpoint
	 * 
	 * @param viewpoint
	 *            A viewpoint
	 * @return A collection of the other viewpoints contributing to the given one
	 */
	private static Collection<PapyrusViewpoint> getContributionsTo(PapyrusViewpoint viewpoint) {
		Collection<PapyrusViewpoint> result = new ArrayList<PapyrusViewpoint>();
		Collection<PapyrusConfiguration> contributions = getContributionsTo((PapyrusConfiguration) viewpoint.eContainer());
		for (PapyrusConfiguration contrib : contributions) {
			for (ArchitectureViewpoint vp : contrib.getViewpoints()) {
				if (vp instanceof PapyrusViewpoint && vp.getName().equals(viewpoint.getName())) {
					result.add((PapyrusViewpoint) vp);
				}
			}
		}
		return result;
	}

	/**
	 * Gets the configurations contributing to the given configuration
	 * 
	 * @param config
	 *            A configuration
	 * @return A collection of the contributing configurations
	 */
	private static Collection<PapyrusConfiguration> getContributionsTo(PapyrusConfiguration config) {
		if (CONTRIBUTIONS_CACHE == null)
			loadContributions();
		Collection<PapyrusConfiguration> result = CONTRIBUTIONS_CACHE.get(config);
		if (result != null)
			return result;
		result = new ArrayList<PapyrusConfiguration>();
		CONTRIBUTIONS_CACHE.put(config, result);
		for (Map.Entry<String, PapyrusConfiguration> entry : CONFIGURATIONS_CACHE.entrySet()) {
			if (entry.getValue() == config) {
				Collection<String> contribURIs = CONTRIBUTIONS_DEFINITON.get(entry.getKey());
				if (contribURIs != null)
					for (String uri : contribURIs)
						result.add(loadConfigurationFrom(uri));
				return result;
			}
		}
		return result;
	}

	/**
	 * Loads the viewpoints contribution data from the extension points
	 */
	private static void loadContributions() {
		CONTRIBUTIONS_DEFINITON = new HashMap<String, Collection<String>>();
		CONTRIBUTIONS_CACHE = new HashMap<PapyrusConfiguration, Collection<PapyrusConfiguration>>();

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(EXTENSION_ID);
		IExtension[] extensions = point.getExtensions();

		for (int i = 0; i != extensions.length; i++) {
			String plugin = extensions[i].getContributor().getName();
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j = 0; j != elements.length; j++) {
				if (elements[j].getName().equals("contribution")) {
					String uriOriginal = getCanonicalURI(plugin, elements[j].getAttribute("original"));
					String uriContrib = getCanonicalURI(plugin, elements[j].getAttribute("file"));
					Collection<String> list = CONTRIBUTIONS_DEFINITON.get(uriOriginal);
					if (list == null) {
						list = new ArrayList<String>();
						CONTRIBUTIONS_DEFINITON.put(uriOriginal, list);
					}
					list.add(uriContrib);
				}
			}
		}
	}

	/**
	 * Gets the canonical (absolute) URI from a potentially plugin-relative URI
	 * 
	 * @param plugin
	 *            The container plugin
	 * @param uri
	 *            The URI to canonicalize
	 * @return The canonical (absolute) URI
	 */
	private static String getCanonicalURI(String plugin, String uri) {
		if (uri.startsWith(PreferenceConstants.P_CONF_PATH_SCHEME_PLUGIN_VALUE))
			return uri;
		return PreferenceConstants.P_CONF_PATH_SCHEME_PLUGIN_VALUE + plugin + "/" + uri;
	}


	/**
	 * Gets the preference store for the viewpoints-related preferences
	 * 
	 * @return The preference store for the viewpoints-related preferences
	 */
	public static IPreferenceStore getPreferences() {
		return Activator.getDefault().getPreferenceStore();
	}


	/**
	 * The current (global) instance
	 */
	private static PolicyChecker currentPolicyChecker;

	/**
	 * Gets the policy checker currently enforcing the viewpoints configuration
	 * 
	 * @return The current policy checker
	 */
	public static PolicyChecker getCurrent() {
		if (currentPolicyChecker == null)
			currentPolicyChecker = new PolicyChecker();
		return currentPolicyChecker;
	}

	/**
	 * Sets the policy checker currently enforcing the viewpoints configuration
	 * 
	 * @param pc
	 *            The new policy checker
	 */
	public static void setCurrent(PolicyChecker pc) {
		currentPolicyChecker = pc;
	}


	/**
	 * The checker's configuration
	 */
	private PapyrusConfiguration configuration;

	/**
	 * Force only one type of view per model element
	 */
	private boolean oneViewPerElem;

	/**
	 * The current stakeholder
	 */
	private Stakeholder selectedStakeholder;

	/**
	 * The current viewpoint
	 */
	private PapyrusViewpoint selectedViewpoint;

	/**
	 * The cache of applicable viewpoints, with all contributing configurations taken into account
	 */
	private Collection<PapyrusViewpoint> applicableViewpoints;

	/**
	 * The current profile helper
	 */
	private IProfileHelper profileHelper;

	/**
	 * Gets the configuration enforced by this object
	 * 
	 * @return The configuration
	 */
	public PapyrusConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * Gets the stakeholder represented by this object
	 * 
	 * @return The stakeholder
	 */
	public Stakeholder getStakeholder() {
		return selectedStakeholder;
	}

	/**
	 * Gets the viewpoint enforced by this object
	 * 
	 * @return The enforced viewpoint
	 */
	public PapyrusViewpoint getViewpoint() {
		return selectedViewpoint;
	}

	/**
	 * Initializes this instance from the current preferences
	 */
	private PolicyChecker() {
		IPreferenceStore store = getPreferences();
		String prefType = store.getString(PreferenceConstants.P_CONF_TYPE);
		String prefForce = store.getString(PreferenceConstants.P_FORCE_MULTIPLICITY);
		String prefViewpoint = store.getString(PreferenceConstants.P_VIEWPOINT);

		this.profileHelper = ProfileUtils.getProfileHelper();
		this.oneViewPerElem = "true".equals(prefForce);
		if (PreferenceConstants.P_CONF_TYPE_DEFAULT_VALUE.equals(prefType)) {
			this.configuration = CONFIG_BUILTIN_DEFAULT;
		} else if (PreferenceConstants.P_CONF_TYPE_EXTENSION_VALUE.equals(prefType)) {
			WeightedConfiguration wc = WeightedConfiguration.getTopConfiguration();
			this.configuration = (wc != null ? wc.getConfiguration() : null);
		} else {
			String scheme = store.getString(PreferenceConstants.P_CONF_PATH_SCHEME);
			String path = store.getString(PreferenceConstants.P_CONF_PATH);
			if (PreferenceConstants.P_CONF_PATH_SCHEME_WORKSPACE_VALUE.equals(scheme))
				path = PreferenceConstants.P_CONF_PATH_SCHEME_WORKSPACE_VALUE + path;
			this.configuration = loadConfigurationFrom(path);
		}
		if (this.configuration == null)
			this.configuration = CONFIG_BUILTIN_DEFAULT;

		if (prefViewpoint != null && !prefViewpoint.isEmpty()) {
			for (Stakeholder stakeholder : this.configuration.getStakeholders()) {
				for (ArchitectureViewpoint vp : stakeholder.getViewpoints()) {
					if (prefViewpoint.equals(vp.getName())) {
						this.selectedStakeholder = stakeholder;
						this.selectedViewpoint = (PapyrusViewpoint) vp;
						buildApplicableViewpoints();
						return;
					}
				}
			}
		}
		this.selectedStakeholder = this.configuration.getDefaultStakeholder();
		this.selectedViewpoint = (PapyrusViewpoint) this.selectedStakeholder.getViewpoints().get(0);
		buildApplicableViewpoints();
	}

	/**
	 * Initializes this policy checker with the default configuration and viewpoint
	 * 
	 * @param oneViewPerElem
	 *            Force only one type of view per model element
	 */
	public PolicyChecker(boolean oneViewPerElem) {
		this.configuration = CONFIG_BUILTIN_DEFAULT;
		this.oneViewPerElem = oneViewPerElem;
		this.selectedStakeholder = this.configuration.getDefaultStakeholder();
		this.selectedViewpoint = (PapyrusViewpoint) this.selectedStakeholder.getViewpoints().get(0);
		this.profileHelper = ProfileUtils.getProfileHelper();
		buildApplicableViewpoints();
	}

	/**
	 * Initializes this policy checker with the given configuration and viewpoint
	 * 
	 * @param config
	 *            The configuration to enforce
	 * @param viewpoint
	 *            The viewpoint to enforce
	 * @param oneViewPerElem
	 *            Force only one type of view per model element
	 */
	public PolicyChecker(PapyrusConfiguration config, PapyrusViewpoint viewpoint, boolean oneViewPerElem) {
		this.configuration = config;
		this.oneViewPerElem = oneViewPerElem;
		this.selectedViewpoint = viewpoint;
		this.profileHelper = ProfileUtils.getProfileHelper();
		buildApplicableViewpoints();
		for (Stakeholder stakeholder : configuration.getStakeholders()) {
			if (stakeholder.getViewpoints().contains(viewpoint)) {
				this.selectedStakeholder = stakeholder;
				return;
			}
		}
	}


	/**
	 * Builds the <code>applicableViewpoints</code> member from the selected viewpoint and all its contribution
	 */
	private void buildApplicableViewpoints() {
		applicableViewpoints = new ArrayList<PapyrusViewpoint>();
		buildApplicableViewpoints(selectedViewpoint);
		for (PapyrusViewpoint vp : getContributionsTo(selectedViewpoint))
			buildApplicableViewpoints(vp);
	}

	/**
	 * Builds the <code>applicableViewpoints</code> member from the given viewpoint by adding it, as well as its parent
	 * 
	 * @param from
	 *            The top viewpoint
	 */
	private void buildApplicableViewpoints(PapyrusViewpoint from) {
		PapyrusViewpoint vp = from;
		while (vp != null) {
			applicableViewpoints.add(vp);
			vp = vp.getParent();
		}
	}


	/**
	 * Determines whether the given element can own the given view
	 * 
	 * @param element
	 *            The possible owner
	 * @param prototype
	 *            The view prototype
	 * @return <code>true</code> if the element can own the view
	 */
	public boolean canOwnNewView(EObject element, ViewPrototype prototype) {
		if (prototype == null)
			return false;
		if (!matchesProfiles(prototype.configuration, profileHelper.getAppliedProfiles(element)))
			return false;
		return (matchesOwnerMultiplicity(prototype.configuration, element.eClass(), profileHelper.getAppliedStereotypes(element), getOwnedViewCount(element, prototype)));
	}

	/**
	 * Determines whether the given element can be the root of a view owned by the given object
	 * 
	 * @param element
	 *            The possible root element
	 * @param owner
	 *            The possible owner
	 * @param prototype
	 *            The view prototype
	 * @return <code>true</code> if the element can be the root
	 */
	public boolean canHaveNewView(EObject element, EObject owner, ViewPrototype prototype) {
		if (prototype == null)
			return false;
		if (!matchesProfiles(prototype.configuration, profileHelper.getAppliedProfiles(owner)))
			return false;
		if (!matchesProfiles(prototype.configuration, profileHelper.getAppliedProfiles(element)))
			return false;
		if (!matchesOwnerMultiplicity(prototype.configuration, owner.eClass(), profileHelper.getAppliedStereotypes(owner), getOwnedViewCount(owner, prototype)))
			return false;
		if (!matchesRootMultiplicity(prototype.configuration, element.eClass(), profileHelper.getAppliedStereotypes(element), getViewCountOn(element, prototype)))
			return false;
		return true;
	}

	/**
	 * Gets the insertion data of the given element in the given diagram
	 * 
	 * @param diagram
	 *            The diagram
	 * @param parent
	 *            The element to be edited
	 * @param child
	 *            The element to be added through the diagram
	 * @return The insertion data
	 */
	public ModelAddData getChildAddData(Diagram diagram, EObject parent, EObject child) {
		ViewPrototype prototype = ViewPrototype.get(diagram);
		if (prototype == null)
			// This diagram is not in the current policy
			return new ModelAddData(false);

		PapyrusDiagram config = (PapyrusDiagram) prototype.configuration;
		Collection<EClass> stereotypes = profileHelper.getAppliedStereotypes(child);
		while (config != null) {
			for (ChildRule rule : config.getChildRules()) {
				int result = allows(rule, parent.eClass(), child.eClass(), stereotypes);
				if (result != RESULT_UNKNOWN)
					return new ModelAddData((result == RESULT_PERMIT), rule.getInsertionPath());
			}
			config = (PapyrusDiagram) config.getParent();
		}
		return new ModelAddData(DEFAULT_POLICY_UNKNOWN_CHILD);
	}

	/**
	 * Gets the insertion data of the given element in the given diagram
	 * 
	 * @param diagram
	 *            The diagram
	 * @param parentType
	 *            The type of the element to be edited
	 * @param childType
	 *            The type of element to be added through the diagram
	 * @return The insertion data
	 */
	public ModelAddData getChildAddData(Diagram diagram, EClass parentType, EClass childType) {
		ViewPrototype prototype = ViewPrototype.get(diagram);
		if (prototype == null)
			// This diagram is not in the current policy
			return new ModelAddData(false);

		PapyrusDiagram config = (PapyrusDiagram) prototype.configuration;
		while (config != null) {
			for (ChildRule rule : config.getChildRules()) {
				int result = allows(rule, parentType, childType, new ArrayList<EClass>(0));
				if (result != RESULT_UNKNOWN)
					return new ModelAddData((result == RESULT_PERMIT), rule.getInsertionPath());
			}
			config = (PapyrusDiagram) config.getParent();
		}
		return new ModelAddData(DEFAULT_POLICY_UNKNOWN_CHILD);
	}

	/**
	 * Determines whether the given diagram can have the palette element with the given entry ID
	 * 
	 * @param diagram
	 *            The diagram
	 * @param entryID
	 *            A palette element entry ID
	 * @return <code>true</code> if the palette element is allowed
	 */
	public boolean isInPalette(Diagram diagram, String entryID) {
		ViewPrototype prototype = ViewPrototype.get(diagram);
		if (prototype == null)
			// This diagram is not in the current policy
			return false;

		PapyrusDiagram config = (PapyrusDiagram) prototype.configuration;
		while (config != null) {
			for (PaletteRule rule : config.getPaletteRules()) {
				int result = allows(rule, entryID);
				if (result != RESULT_UNKNOWN)
					return (result == RESULT_PERMIT);
			}
			config = (PapyrusDiagram) config.getParent();
		}
		return DEFAULT_POLICY_UNKNWON_PALETTE;
	}

	/**
	 * Determines whether the given view configuration element is part of the current viewpoint
	 * 
	 * @param config
	 *            A view configuration element
	 * @return <code>true</code> if the element is part of the current viewpoint
	 */
	public boolean isInViewpoint(PapyrusView config) {
		for (PapyrusViewpoint viewpoint : applicableViewpoints) {
			for (ModelKind kind : viewpoint.getModelKinds()) {
				PapyrusView view = (PapyrusView) kind;
				if (EcoreUtil.equals(view, config))
					return true;
			}
		}
		return false;
	}

	/**
	 * Gets a collection of all the view prototypes allowed by the active policy
	 * 
	 * @return A collection of view prototypes
	 */
	public Collection<ViewPrototype> getAllPrototypes() {
		Collection<ViewPrototype> result = new ArrayList<ViewPrototype>();
		for (PapyrusViewpoint viewpoint : applicableViewpoints) {
			for (ModelKind kind : viewpoint.getModelKinds()) {
				PapyrusView view = (PapyrusView) kind;
				ViewPrototype proto = ViewPrototype.get(view);
				if (proto != null)
					result.add(proto);
			}
		}
		return result;
	}

	/**
	 * Gets a list of the prototypes that can be instantiated with the given element as owner according to the policy
	 * 
	 * @param element
	 *            The element to test
	 * @return A list of the prototypes that can be instantiated
	 */
	public Collection<ViewPrototype> getPrototypesFor(EObject element) {
		Collection<ViewPrototype> result = new ArrayList<ViewPrototype>();
		Collection<EPackage> profiles = profileHelper.getAppliedProfiles(element);
		Collection<EClass> stereotypes = profileHelper.getAppliedStereotypes(element);
		for (PapyrusViewpoint viewpoint : applicableViewpoints) {
			for (ModelKind kind : viewpoint.getModelKinds()) {
				PapyrusView view = (PapyrusView) kind;
				if (!matchesProfiles(view, profiles))
					continue;
				ViewPrototype proto = ViewPrototype.get(view);
				if (proto == null)
					continue;
				int count = getOwnedViewCount(element, proto);
				if (!matchesOwnerMultiplicity(view, element.eClass(), stereotypes, count))
					continue;
				count = getViewCountOn(element, proto);
				if (!matchesRootMultiplicity(view, element.eClass(), stereotypes, count))
					continue;
				result.add(proto);
			}
		}
		return result;
	}

	/**
	 * Gets the number of views of a given type owned by a given object
	 * 
	 * @param element
	 *            The object to count views for
	 * @param prototype
	 *            The prototype of view to counts
	 * @return The number of owned views
	 */
	private int getOwnedViewCount(EObject element, ViewPrototype prototype) {
		int count = 0;
		Iterator<EObject> roots = NotationUtils.getNotationRoots(element);
		if (roots == null)
			return count;
		while (roots.hasNext()) {
			EObject view = roots.next();
			ViewPrototype proto = ViewPrototype.get(view);
			if (prototype == proto) {
				EObject owner = proto.getOwnerOf(view);
				if (EcoreUtil.equals(owner, element))
					count++;
			}
		}
		return count;
	}

	/**
	 * Gets the number of views of a given type on a given object
	 * 
	 * @param element
	 *            The object to count views on
	 * @param prototype
	 *            The prototype of view to counts
	 * @return The number of views on the object
	 */
	private int getViewCountOn(EObject element, ViewPrototype prototype) {
		int count = 0;
		Iterator<EObject> roots = NotationUtils.getNotationRoots(element);
		if (roots == null)
			return count;
		while (roots.hasNext()) {
			EObject view = roots.next();
			ViewPrototype proto = ViewPrototype.get(view);
			if (prototype == proto) {
				EObject root = proto.getRootOf(view);
				if (EcoreUtil.equals(root, element))
					count++;
			}
		}
		return count;
	}

	/**
	 * Tries to match a view configuration from the given info
	 * 
	 * @param implem
	 *            The implementation ID
	 * @param owner
	 *            The owner
	 * @param root
	 *            The root element
	 * @return The matching view, or <code>null</code> if none was found
	 */
	protected PapyrusView getViewFrom(String implem, EObject owner, EObject root) {
		for (PapyrusViewpoint viewpoint : applicableViewpoints) {
			for (ModelKind kind : viewpoint.getModelKinds()) {
				PapyrusView view = (PapyrusView) kind;
				if (matches(view, implem, owner, root))
					return view;
			}
		}
		return null;
	}

	/**
	 * Tries to match a view configuration with the given info
	 * 
	 * @param view
	 *            A view configuration
	 * @param implem
	 *            The implementation ID
	 * @param owner
	 *            The owner
	 * @param root
	 *            The root element
	 * @return <code>true</code> if the configuration matches
	 */
	private boolean matches(PapyrusView view, String implem, EObject owner, EObject root) {
		if (!ViewPrototype.isNatural(view))
			return false;
		if (!view.getImplementationID().equals(implem))
			return false;
		if (owner != null) {
			if (!matchesProfiles(view, profileHelper.getAppliedProfiles(owner)))
				return false;
			if (!matchesOwner(view, owner.eClass(), profileHelper.getAppliedStereotypes(owner)))
				return false;
		}
		if (root != null) {
			if (!matchesProfiles(view, profileHelper.getAppliedProfiles(root)))
				return false;
			if (!matchesRoot(view, root.eClass(), profileHelper.getAppliedStereotypes(root)))
				return false;
		}
		return true;
	}

	/**
	 * Checks whether the given set of profiles matches the requirements of the given view
	 * 
	 * @param view
	 *            The view to check against
	 * @param profiles
	 *            The applied profiles
	 * @return <code>true</code> if the prototype is matching
	 */
	private boolean matchesProfiles(PapyrusView view, Collection<EPackage> profiles) {
		PapyrusView current = view;
		while (current != null) {
			for (EPackage profile : view.getProfiles())
				if (!profiles.contains(profile))
					return false;
			current = current.getParent();
		}
		return true;
	}

	/**
	 * Checks whether the given type of owning element with applied stereotypes is allowed for the given view
	 * 
	 * @param view
	 *            The view to check against
	 * @param type
	 *            The owning element's type
	 * @param stereotypes
	 *            The stereotypes applied on the owning element
	 * @return <code>true</code> if the prototype is matching
	 */
	private boolean matchesOwner(PapyrusView view, EClass type, Collection<EClass> stereotypes) {
		PapyrusView current = view;
		while (current != null) {
			for (OwningRule rule : current.getOwningRules()) {
				int result = allows(rule, type, stereotypes);
				if (result == RESULT_DENY)
					return false;
				if (result == RESULT_PERMIT)
					return true;
			}
			current = current.getParent();
		}
		return false;
	}

	/**
	 * Checks whether the given view can be owned by an element of the given type, applied with the given stereotypes if the cardinality is already the given amount
	 * 
	 * @param view
	 *            The view to check against
	 * @param type
	 *            The owning element's type
	 * @param stereotypes
	 *            The stereotypes applied on the owning element
	 * @param count
	 *            The current cardinality for the owning element
	 * @return <code>true</code> if the prototype is matching
	 */
	private boolean matchesOwnerMultiplicity(PapyrusView view, EClass type, Collection<EClass> stereotypes, int count) {
		PapyrusView current = view;
		while (current != null) {
			for (OwningRule rule : current.getOwningRules()) {
				int allow = allows(rule, type, stereotypes);
				if (allow == RESULT_DENY)
					return false;
				if (allow == RESULT_UNKNOWN)
					continue;
				int multiplicity = rule.getMultiplicity();
				if (multiplicity == -1)
					return true;
				return (count < multiplicity);
			}
			current = current.getParent();
		}
		return false;
	}

	/**
	 * Checks whether the given type of root element with applied stereotypes is allowed for the given view
	 * 
	 * @param view
	 *            The view to check against
	 * @param type
	 *            The root element's type
	 * @param stereotypes
	 *            The stereotypes applied on the root element
	 * @return <code>true</code> if the prototype is matching
	 */
	private boolean matchesRoot(PapyrusView view, EClass type, Collection<EClass> stereotypes) {
		PapyrusView current = view;
		while (current != null) {
			for (ModelRule rule : current.getModelRules()) {
				int result = allows(rule, type, stereotypes);
				if (result == RESULT_DENY)
					return false;
				if (result == RESULT_PERMIT)
					return true;
			}
			current = current.getParent();
		}
		return false;
	}

	/**
	 * Checks whether the given view can have the given root element of the given type, applied with the given stereotypes if the cardinality is already the given amount
	 * 
	 * @param view
	 *            The view to check against
	 * @param type
	 *            The root element's type
	 * @param stereotypes
	 *            The stereotypes applied on the root element
	 * @param count
	 *            The current cardinality for the root element
	 * @return <code>true</code> if the prototype is matching
	 */
	private boolean matchesRootMultiplicity(PapyrusView view, EClass type, Collection<EClass> stereotypes, int count) {
		PapyrusView current = view;
		while (current != null) {
			for (ModelRule rule : current.getModelRules()) {
				int allow = allows(rule, type, stereotypes);
				if (allow == RESULT_DENY)
					return false;
				if (allow == RESULT_UNKNOWN)
					continue;
				int multiplicity = (oneViewPerElem ? 1 : rule.getMultiplicity());
				if (multiplicity == -1)
					return true;
				return (count < multiplicity);
			}
			current = current.getParent();
		}
		return false;
	}

	/**
	 * Checks an owner's type against a rule
	 * 
	 * @param rule
	 *            The owning rule
	 * @param owner
	 *            The owner's type
	 * @param stereotypes
	 *            The stereotypes applied on <code>owner</code>
	 * @return The check result
	 */
	private int allows(OwningRule rule, EClass owner, Collection<EClass> stereotypes) {
		EClass c = rule.getElement();
		if (c == null || c.isSuperTypeOf(owner)) {
			// matching type => check the application of the required stereotypes
			for (EClass stereotype : rule.getStereotypes())
				if (!stereotypes.contains(stereotype))
					return RESULT_UNKNOWN;
			return rule.isPermit() ? RESULT_PERMIT : RESULT_DENY;
		} else {
			// type is not matching => unknown
			return RESULT_UNKNOWN;
		}
	}

	/**
	 * Checks a root element's type against a rule
	 * 
	 * @param rule
	 *            The modeling rule
	 * @param element
	 *            The root element's type
	 * @param stereotypes
	 *            The stereotypes applied on <code>element</code>
	 * @return The check result
	 */
	private int allows(ModelRule rule, EClass element, Collection<EClass> stereotypes) {
		EClass c = rule.getElement();
		if (c == null || c.isSuperTypeOf(element)) {
			// matching type => check the application of the required stereotypes
			for (EClass stereotype : rule.getStereotypes())
				if (!stereotypes.contains(stereotype))
					return RESULT_UNKNOWN;
			return rule.isPermit() ? RESULT_PERMIT : RESULT_DENY;
		} else {
			// type is not matching => unknown
			return RESULT_UNKNOWN;
		}
	}

	/**
	 * Checks a child insertion against a rule
	 * 
	 * @param rule
	 *            The insertion rule
	 * @param origin
	 *            The root element's type
	 * @param element
	 *            The child's type
	 * @param stereotypes
	 *            The stereotypes applied on <code>element</code>
	 * @return The check result
	 */
	private int allows(ChildRule rule, EClass origin, EClass element, Collection<EClass> stereotypes) {
		EClass ce = rule.getElement();
		EClass co = rule.getOrigin();
		if ((ce == null || ce.isSuperTypeOf(element))
				&& (co == null || co.isSuperTypeOf(origin))) {
			// matching type => check the application of the required stereotypes
			for (EClass stereotype : rule.getStereotypes())
				if (!stereotypes.contains(stereotype))
					return RESULT_UNKNOWN;
			return rule.isPermit() ? RESULT_PERMIT : RESULT_DENY;
		} else {
			// type is not matching => unknown
			return RESULT_UNKNOWN;
		}
	}

	/**
	 * Checks a palette element against a rule
	 * 
	 * @param rule
	 *            The palette rule
	 * @param toolID
	 *            The palette element's ID
	 * @return The check result
	 */
	private int allows(PaletteRule rule, String toolID) {
		String elem = rule.getElement();
		boolean applies = (elem == null);
		applies = applies || (elem.length() == 0);
		applies = applies || (elem != null && elem.equals(toolID));
		applies = applies || (elem != null && elem.endsWith("*") && toolID.startsWith(elem.substring(0, elem.length() - 1)));
		if (applies)
			return rule.isPermit() ? RESULT_PERMIT : RESULT_DENY;
		return RESULT_UNKNOWN;
	}
}
