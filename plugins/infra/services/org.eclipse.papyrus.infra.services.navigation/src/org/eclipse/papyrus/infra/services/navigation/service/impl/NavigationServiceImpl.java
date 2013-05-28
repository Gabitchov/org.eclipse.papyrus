/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.navigation.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.navigation.Activator;
import org.eclipse.papyrus.infra.services.navigation.provider.NavigationTargetProvider;
import org.eclipse.papyrus.infra.services.navigation.service.NavigableElement;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationContributor;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationService;
import org.eclipse.papyrus.infra.widgets.editors.SelectionMenu;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;

/**
 * Base implementation of the NavigationService. It is based on the
 * navigationContributor extension point.
 * 
 * @author Camille Letavernier
 */
public class NavigationServiceImpl implements NavigationService {

	public static final String EXTENSION_ID = Activator.PLUGIN_ID + ".navigationContributor";

	/**
	 * The isActive property suffix (For preferences)
	 */
	public static final String IS_ACTIVE_KEY = "isActive"; //$NON-NLS-1$

	protected ServicesRegistry registry;

	/**
	 * {@inheritDoc}
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		// Nothing
		this.registry = servicesRegistry;
	}

	/**
	 * {@inheritDoc}
	 */
	public void startService() throws ServiceException {
		createNavigationContributors();
		createNavigationTargetProviders();
	}

	protected void createNavigationContributors() {
		navigationContributors = new LinkedList<NavigationContributorDescriptor>();

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			if(!"contributor".equals(e.getName())) {
				continue;
			}
			try {
				Object instance = e.createExecutableExtension("contributor");
				if(instance instanceof NavigationContributor) {
					NavigationContributorDescriptor wrapper = new NavigationContributorDescriptor((NavigationContributor)instance);
					wrapper.setId(e.getAttribute("id"));
					wrapper.setLabel(e.getAttribute("label"));
					wrapper.setDescription(e.getAttribute("description"));
					wrapper.init();
					navigationContributors.add(wrapper);
				}
			} catch (Exception ex) {
				Activator.log.warn("Invalid navigation contribution from: " + e.getContributor());
			}
		}
	}

	protected void createNavigationTargetProviders() {
		navigationTargetProviders = new TreeSet<NavigationTargetProvider>();

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			if(!"target".equals(e.getName())) {
				continue;
			}
			try {
				Object instance = e.createExecutableExtension("navigationTargetProvider");
				if(instance instanceof NavigationTargetProvider) {
					NavigationTargetProviderDescriptor descriptor = new NavigationTargetProviderDescriptor((NavigationTargetProvider)instance);
					descriptor.setId(e.getAttribute("id"));
					descriptor.setLabel(e.getAttribute("label"));
					descriptor.setDescription(e.getAttribute("description"));
					descriptor.setOrder(Integer.parseInt(e.getAttribute("order")));
					navigationTargetProviders.add(descriptor);
				}
			} catch (Exception ex) {
				Activator.log.warn("Invalid navigation target contribution from: " + e.getContributor());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void disposeService() throws ServiceException {
		this.registry = null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<NavigableElement> getNavigableElements(Object fromElement) {
		List<NavigableElement> navigableElements = new LinkedList<NavigableElement>();

		for(NavigationContributorDescriptor contributor : navigationContributors) {
			if(contributor.isActive()) {
				navigableElements.addAll(contributor.getNavigableElements(fromElement));
			}
		}

		return navigableElements;
	}

	public static class NavigationTargetProviderDescriptor implements NavigationTargetProvider, Comparable<NavigationTargetProviderDescriptor> {

		private NavigationTargetProvider provider;

		private int order;

		private String label;

		private String description;

		private String id;

		public NavigationTargetProviderDescriptor(NavigationTargetProvider provider) {
			this.provider = provider;
		}

		public NavigationTarget getNavigationTarget(ServicesRegistry registry) {
			return provider.getNavigationTarget(registry);
		}

		public int getOrder() {
			return order;
		}

		public String getLabel() {
			return label;
		}

		public String getDescription() {
			return description;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int compareTo(NavigationTargetProviderDescriptor o) {
			if(o == null) {
				return -1;
			}

			if(o.order == order) {
				return 0;
			}

			return o.order < order ? 1 : -1;
		}

	}

	public static class NavigationContributorDescriptor implements NavigationContributor {

		private final NavigationContributor contributor;

		private String label;

		private String description;

		private String id;

		private final IPreferenceStore preferences;

		public NavigationContributorDescriptor(NavigationContributor contributor) {
			this.contributor = contributor;

			preferences = Activator.getDefault().getPreferenceStore();
		}

		public void init() {
			String isActiveKey = getIsActiveKey(this);
			preferences.setDefault(isActiveKey, true);
		}

		public List<NavigableElement> getNavigableElements(Object fromElement) {
			if(isActive()) {
				return contributor.getNavigableElements(fromElement);
			} else {
				return Collections.emptyList();
			}
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public boolean isActive() { /* NavigationContributorWrapper strategy */
			String preferenceKey = getIsActiveKey(this);
			return preferences.getBoolean(preferenceKey);
		}

		public static String getIsActiveKey(NavigationContributorDescriptor strategy) {
			return strategy.getId() + "." + IS_ACTIVE_KEY;
		}

	}

	private List<NavigationContributorDescriptor> navigationContributors;

	private Collection<NavigationTargetProvider> navigationTargetProviders;

	public List<NavigationContributorDescriptor> getNavigationContributors() {
		return navigationContributors;
	}

	public Collection<NavigationTargetProvider> getNavigationTargetProviders() {
		return navigationTargetProviders;
	}

	/**
	 * {@inheritDoc}
	 */
	public SelectionMenu createNavigationList(Object fromElement, final Control parent) {
		List<NavigableElement> navigableElements = getNavigableElements(fromElement);
		if(navigableElements.isEmpty()) {
			return null;
		}

		SelectionMenu selectionMenu = new SelectionMenu(parent.getShell());
		selectionMenu.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if(element instanceof NavigableElement) {
					return ((NavigableElement)element).getLabel();
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element) {
				if(element instanceof NavigableElement) {
					return ((NavigableElement)element).getImage();
				}
				return super.getImage(element);
			}

			@Override
			public String getToolTipText(Object element) {
				if(element instanceof NavigableElement) {
					return ((NavigableElement)element).getDescription();
				}
				return super.getToolTipText(element);
			}

			@Override
			public Color getForeground(Object element) {
				if(element instanceof NavigableElement) {
					NavigableElement navigableElement = (NavigableElement)element;
					if(!navigableElement.isEnabled()) {
						return parent.getDisplay().getSystemColor(SWT.COLOR_GRAY);
					}
				}
				return super.getForeground(element);
			}
		});

		selectionMenu.setContentProvider(CollectionContentProvider.instance);
		selectionMenu.setInput(navigableElements);

		selectionMenu.open();

		return selectionMenu;
	}

	/**
	 * {@inheritDoc}
	 */
	public void navigate(NavigableElement navigableElement) {
		if(registry == null) {
			throw new IllegalStateException("The navigation service is not initialized");
		}

		for(NavigationTargetProvider provider : getNavigationTargetProviders()) {
			NavigationTarget target = provider.getNavigationTarget(registry);

			if(target == null) {
				continue;
			}

			if(navigableElement.navigate(target)) {
				return;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void navigate(Object element) {
		if(registry == null) {
			throw new IllegalStateException("The navigation service is not initialized");
		}

		for(NavigationTargetProvider provider : getNavigationTargetProviders()) {
			NavigationTarget target = provider.getNavigationTarget(registry);

			if(target == null) {
				continue;
			}

			if(target.revealElement(element)) {
				return;
			}
		}
	}
}
