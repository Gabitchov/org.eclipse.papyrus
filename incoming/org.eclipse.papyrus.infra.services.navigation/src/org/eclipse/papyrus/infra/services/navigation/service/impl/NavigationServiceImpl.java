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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.navigation.Activator;
import org.eclipse.papyrus.infra.services.navigation.service.NavigableElement;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationContributor;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationService;
import org.eclipse.papyrus.infra.widgets.editors.SelectionMenu;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
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

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		// Nothing
	}

	public void startService() throws ServiceException {
		createNavigationContributors();

	}

	protected void createNavigationContributors() {
		navigationContributors = new LinkedList<NavigationContributorWrapper>();

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			try {
				Object instance = e.createExecutableExtension("contributor");
				if(instance instanceof NavigationContributor) {
					NavigationContributorWrapper wrapper = new NavigationContributorWrapper((NavigationContributor)instance);
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

	public void disposeService() throws ServiceException {
		// Nothing
	}

	public List<NavigableElement> getNavigableElements(Object fromElement) {
		List<NavigableElement> navigableElements = new LinkedList<NavigableElement>();

		for(NavigationContributorWrapper contributor : navigationContributors) {
			if(contributor.isActive()) {
				navigableElements.addAll(contributor.getNavigableElements(fromElement));
			}
		}

		return navigableElements;
	}

	public static class NavigationContributorWrapper implements NavigationContributor {

		private final NavigationContributor contributor;

		private String label;

		private String description;

		private String id;

		private final IPreferenceStore preferences;

		public NavigationContributorWrapper(NavigationContributor contributor) {
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

		public static String getIsActiveKey(NavigationContributorWrapper strategy) {
			return strategy.getId() + "." + IS_ACTIVE_KEY;
		}

	}

	private List<NavigationContributorWrapper> navigationContributors;

	public List<NavigationContributorWrapper> getNavigationContributors() {
		return navigationContributors;
	}

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
}
