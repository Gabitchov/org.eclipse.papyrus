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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.viewpoints.configuration.Category;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusSyncTable;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusTable;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusViewpoint;
import org.eclipse.papyrus.infra.viewpoints.configuration.PathElement;
import org.eclipse.swt.graphics.Image;


/**
 * Represents a prototype of view in Papyrus
 * 
 * @author Laurent Wouters
 */
public abstract class ViewPrototype {
	/**
	 * Singleton for unavailable views
	 */
	public static final ViewPrototype UNAVAILABLE_VIEW = new UnavailableViewPrototype("View", "View");
	/**
	 * Singleton for unavailable views (diagrams)
	 */
	public static final ViewPrototype UNAVAILABLE_DIAGRAM = new UnavailableViewPrototype("Diagram", "Diagram");

	/**
	 * Singleton for unavailable views (tables)
	 */
	public static final ViewPrototype UNAVAILABLE_TABLE = new UnavailableViewPrototype("Table", "Table");

	/**
	 * ID of the extension point for Papyrus diagrams
	 */
	protected static final String EXTENSION_ID = "org.eclipse.papyrus.infra.viewpoints.policy.viewType";

	/**
	 * The collection of helpers
	 */
	private static final Collection<IViewTypeHelper> HELPERS = getCommandHelpers();

	/**
	 * Retrieves the helpers from the extensions
	 * 
	 * @return The helpers
	 */
	private static Collection<IViewTypeHelper> getCommandHelpers() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(EXTENSION_ID);
		IExtension[] extensions = point.getExtensions();

		Collection<IViewTypeHelper> result = new ArrayList<IViewTypeHelper>();
		for (int i = 0; i != extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j = 0; j != elements.length; j++) {
				try {
					IViewTypeHelper instance = (IViewTypeHelper) elements[j].createExecutableExtension("class");
					if (instance != null)
						result.add(instance);
				} catch (CoreException e) {
				}
			}
		}
		return result;
	}

	/**
	 * Determines whether the given configuration element applies on a natural view
	 * 
	 * @param config
	 *            The configuration element
	 * @return <code>true</code> if the configuration applies on a natural view
	 */
	public static boolean isNatural(PapyrusView config) {
		return config.getName() == null && config.getIcon() == null;
	}

	/**
	 * Determines whether the given object is a supported view object
	 * 
	 * @param object
	 *            The object to inspect
	 * @return <code>true</code> if the object is a supported view
	 */
	public static boolean isViewObject(EObject object) {
		for (IViewTypeHelper helper : HELPERS)
			if (helper.isSupported(object))
				return true;
		return false;
	}

	/**
	 * Gets the prototype for the given configuration element
	 * 
	 * @param config
	 *            The configuration element
	 * @return The prototype
	 */
	public static ViewPrototype get(PapyrusView config) {
		for (IViewTypeHelper helper : HELPERS) {
			if (helper.isSupported(config.eClass())) {
				ViewPrototype proto = helper.getPrototypeFor(config);
				if (proto != null)
					return proto;
			}
		}
		if (config instanceof PapyrusDiagram)
			return UNAVAILABLE_DIAGRAM;
		else if (config instanceof PapyrusTable)
			return UNAVAILABLE_TABLE;
		else if (config instanceof PapyrusSyncTable)
			return UNAVAILABLE_TABLE;
		else
			return UNAVAILABLE_VIEW;
	}

	/**
	 * Gets the prototype for the the given object representing a view
	 * 
	 * @param view
	 *            The view for which a prototype is expected
	 * @return The view's prototype
	 */
	public static ViewPrototype get(EObject view) {
		for (IViewTypeHelper helper : HELPERS) {
			if (helper.isSupported(view)) {
				ViewPrototype proto = helper.getPrototypeOf(view);
				if (proto != null)
					return proto;
			}
		}
		return UNAVAILABLE_VIEW;
	}

	/**
	 * Gets the prototype for the given implementation identifier
	 * 
	 * @param implem
	 *            The implementation ID
	 * @param owner
	 *            The owner
	 * @param root
	 *            The root element
	 * @return The prototype
	 */
	public static ViewPrototype get(String implem, EObject owner, EObject root) {
		PapyrusView view = PolicyChecker.getCurrent().getViewFrom(implem, owner, root);
		if (view == null)
			// The given implementation has been inhibited by the current viewpoint configuration
			return UNAVAILABLE_VIEW;
		return get(view);
	}


	/**
	 * The configuration element of this view
	 */
	protected final PapyrusView configuration;

	/**
	 * Constructor.
	 * 
	 * @param configuration
	 *            The configuration element
	 */
	protected ViewPrototype(PapyrusView configuration) {
		this.configuration = configuration;
	}

	/**
	 * Gets the configuration element for this view prototype
	 * 
	 * @return The configuration element
	 */
	public PapyrusView getConfiguration() {
		return configuration;
	}

	/**
	 * Gets whether the represented view is the raw implementation
	 * 
	 * @return <code>true</code> if this is a natural view
	 */
	public boolean isNatural() {
		return isNatural(configuration);
	}

	/**
	 * Gets the ID of the implementation of this prototype
	 * 
	 * @return The implementation ID
	 */
	public String getImplementation() {
		return configuration.getImplementationID();
	}

	/**
	 * Gets the label
	 * 
	 * @return The label
	 */
	public String getLabel() {
		return configuration.getName();
	}

	/**
	 * Gets the full label that is qualified with its possible root elements
	 * 
	 * @return The full label
	 */
	public String getFullLabel() {
		StringBuilder builder = new StringBuilder(getLabel());
		builder.append(" for ");
		boolean first = true;
		for (ModelRule rule : configuration.getModelRules()) {
			if (rule.getStereotypes() != null && rule.getStereotypes().size() > 0) {
				for (EClass stereotype : rule.getStereotypes()) {
					if (!first) {
						builder.append(", ");
						first = false;
					}
					builder.append(stereotype.getName());
				}
			} else if (rule.getElement() != null) {
				if (!first) {
					builder.append(", ");
					first = false;
				}
				builder.append(rule.getElement().getName());
			} else {
				continue;
			}
		}
		return builder.toString();
	}

	/**
	 * Gets the qualified name of this prototype
	 * 
	 * @return The qualified name
	 */
	public String getQualifiedName() {
		PapyrusViewpoint vp = (PapyrusViewpoint) configuration.eContainer();
		return vp.getName() + " :: " + getLabel();
	}

	/**
	 * Gets the URI of this prototype's icon
	 * 
	 * @return The icon's URI
	 */
	public String getIconURI() {
		return configuration.getIcon();
	}

	/**
	 * Gets the image descriptor of this prototype's icon
	 * 
	 * @return The icon's descriptor
	 */
	public ImageDescriptor getIconDescriptor() {
		URL url = null;
		try {
			url = new URL(getIconURI());
		} catch (MalformedURLException e) {
			Activator.getDefault().getPapyrusLog().error("Cannot load icon at URI " + getIconURI(), e);
		}
		return ImageDescriptor.createFromURL(url);
	}

	/**
	 * Gets the image of this prototype's icon
	 * 
	 * @return The icon's image
	 */
	public Image getIcon() {
		return getIconDescriptor().createImage();
	}

	/**
	 * Gets the categories of this view prototype
	 * 
	 * @return The prototype's categories
	 */
	public Collection<Category> getCategories() {
		return configuration.getCategories();
	}

	/**
	 * Gets the initial view's root from the owner
	 * 
	 * @param owner
	 *            The initial view's owner
	 * @return The initial root
	 */
	public EObject getRootFor(EObject owner) {
		for (ModelRule rule : configuration.getModelRules()) {
			if (rule.getAutoSelectPath() != null && rule.getAutoSelectPath().size() > 0) {
				EObject result = traverse(owner, rule.getAutoSelectPath());
				if (result != null)
					return result;
			}
		}
		return owner;
	}

	private EObject traverse(EObject from, EList<PathElement> path) {
		EObject current = from;
		for (PathElement elem : path) {
			EReference feature = elem.getFeature();
			if (current.eIsSet(feature)) {
				Object temp = current.eGet(feature);
				if (temp instanceof EList) {
					current = ((EList<? extends EObject>) temp).get(0);
				} else if (temp instanceof EObject) {
					current = (EObject) temp;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
		return current;
	}

	/**
	 * Determines whether the instances of this prototype can change owners
	 * 
	 * @return <code>true</code> if the owner is reassignable
	 */
	public abstract boolean isOwnerReassignable();

	/**
	 * Create a new view from this prototype with the given owner
	 * 
	 * @param owner
	 *            The new view's owner
	 * @return <code>true</code> if the instantiation succeeded
	 */
	public abstract boolean instantiateOn(EObject owner);

	/**
	 * Create a new view from this prototype with the given owner and name
	 * 
	 * @param owner
	 *            The new view's owner
	 * @param name
	 *            The new view's name
	 * @return <code>true</code> if the instantiation succeeded
	 */
	public abstract boolean instantiateOn(EObject owner, String name);

	/**
	 * Gets the command for moving the given view to a new owner (target)
	 * 
	 * @param view
	 *            The view to be moved
	 * @param target
	 *            The target owner
	 * @return The command, or <code>null</code> if the change is not allowed
	 */
	public abstract Command getCommandChangeOwner(EObject view, EObject target);

	/**
	 * Gets the command for changing the root element of the given view to a new element (target)
	 * 
	 * @param view
	 *            The view to change root
	 * @param target
	 *            The target element
	 * @return The command, or <code>null</code> if the change is not allowed
	 */
	public abstract Command getCommandChangeRoot(EObject view, EObject target);

	/**
	 * Gets the object owning the given view
	 * 
	 * @param view
	 *            The view
	 * @return The view's owner
	 */
	public abstract EObject getOwnerOf(EObject view);

	/**
	 * Gets the object which is the root element of the given view
	 * 
	 * @param view
	 *            The view
	 * @return The views's root element
	 */
	public abstract EObject getRootOf(EObject view);

	/**
	 * Represents a comparator of prototypes
	 * 
	 * @author Laurent Wouters
	 */
	public static class Comp implements Comparator<ViewPrototype> {
		private static final Map<Class<? extends PapyrusView>, Integer> priorities = new HashMap<Class<? extends PapyrusView>, Integer>();
		{
			priorities.put(PapyrusDiagram.class, 1);
			priorities.put(PapyrusTable.class, 2);
			priorities.put(PapyrusSyncTable.class, 3);
		}

		private static Integer getPriority(ViewPrototype proto) {
			for (Map.Entry<Class<? extends PapyrusView>, Integer> entry : priorities.entrySet()) {
				if (entry.getKey().isAssignableFrom(proto.configuration.getClass())) {
					return entry.getValue();
				}
			}
			return 0;
		}

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(ViewPrototype proto1, ViewPrototype proto2) {
			Integer p1 = getPriority(proto1);
			Integer p2 = getPriority(proto2);
			if (p1 == p2) {
				return (proto1.getLabel().compareTo(proto2.getLabel()));
			} else {
				return p1.compareTo(p2);
			}
		}
	}
}
