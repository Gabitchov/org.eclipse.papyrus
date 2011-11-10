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
package org.eclipse.papyrus.views.properties.runtime.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.ProviderChangeEvent;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorControllerService;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.dialogs.GetDialogDescriptorOperation;
import org.eclipse.papyrus.views.properties.runtime.dialogs.GetDialogDescriptorOperationById;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * Service to provide property views providers.
 */
public class PropertyViewService extends Service implements IPreferenceChangeListener {

	/** instance of this service */
	protected static PropertyViewService instance;

	/**
	 * Creates a new PropertyViewService. This constructor is not visible, using singleton pattern.
	 */
	protected PropertyViewService() {
		super();
		IEclipsePreferences prefs = new InstanceScope().getNode(org.eclipse.papyrus.views.properties.runtime.Activator.ID);
		prefs.addPreferenceChangeListener(this);
	}

	/**
	 * Returns the singleton instance of this service.
	 * 
	 * @return the singleton instance of this service
	 */
	/**
	 * Returns the singleton instance of this service
	 * 
	 * @return the singleton instance of this service
	 */
	public synchronized static PropertyViewService getInstance() {
		if(instance == null) {
			instance = new PropertyViewService();
			instance.configureProviders(org.eclipse.papyrus.views.properties.runtime.Activator.ID, "propertyViewProvider"); //$NON-NLS-1$
		}
		return instance;
	}

	/**
	 * Returns the list of property view Providers
	 * 
	 * @return the list of property view Providers
	 */
	@SuppressWarnings("unchecked")
	public List<PropertyViewService.ProviderDescriptor> getPropertyViewProviders() {
		return (List<PropertyViewService.ProviderDescriptor>)findAllProviders();
	}

	/**
	 * Creates a new Property editor controller given its configuration
	 * 
	 * @param objectsToEdit
	 *        the list of objects to display
	 * @param parent
	 *        the composite parent for the property view
	 * @param controllerDescriptor
	 *        the descriptor of the property editor controller
	 * @param widgetFactory
	 * @return the created controller for the property editor
	 */
	public PropertyEditorController createPropertyEditorController(List<Object> objectsToEdit, Composite parent, IPropertyEditorControllerDescriptor controllerDescriptor, TabbedPropertySheetWidgetFactory widgetFactory) {
		PropertyEditorController controller = PropertyEditorControllerService.getInstance().createPropertyEditorController(objectsToEdit, parent, controllerDescriptor);

		if(controller != null) {
			controller.createPropertyEditor(controllerDescriptor.getEditorDescriptor(), widgetFactory);
		}
		return controller;
	}

	/**
	 * Returns the dialog descriptor given the id of this dialog
	 * 
	 * @param dialogID
	 *        id of the dialog described by this element
	 * @return the configuration descriptor for the dialog
	 */
	public DialogDescriptor getDialogDescriptor(String dialogID) {
		DialogDescriptor descriptor = (DialogDescriptor)executeUnique(ExecutionStrategy.REVERSE, new GetDialogDescriptorOperationById(dialogID));
		return descriptor;
	}

	/**
	 * Returns the dialog descriptor that fits best to the list of given objects
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @return the best dialog found
	 */
	@SuppressWarnings("unchecked")
	public DialogDescriptor getDialogDescriptor(List<Object> objectsToEdit) {
		List<List<DialogDescriptor>> validDescriptors = (List<List<DialogDescriptor>>)execute(ExecutionStrategy.REVERSE, new GetDialogDescriptorOperation(objectsToEdit));
		List<DialogDescriptor> filteredDescriptors = new ArrayList<DialogDescriptor>();

		// filter this list using the replaced descriptors
		List<DialogDescriptor> subList = flattenList(validDescriptors);
		// check sub list is not empty
		if(subList.isEmpty()) {
			return null;
		}

		// the list of available descriptors is now available, now remove from the list the section descriptors which are erased by others
		for(DialogDescriptor currentDescriptor : subList) {
			boolean isRemoved = false;
			String currentId = currentDescriptor.getId();
			// is this descriptor removed by another one ?
			for(DialogDescriptor descriptor : subList) {
				if(descriptor.getReplacedDialogIds().contains(currentId)) {
					isRemoved = true;
				}
			}

			if(!isRemoved) {
				filteredDescriptors.add(currentDescriptor);
			}
		}

		// check the filtered descriptors is not an empty list.
		// Otherwise, it should take the first one from the available list as default
		// if the list has more that one available editors, take the first one also
		if(filteredDescriptors.isEmpty()) {
			return subList.get(0); // not empty because it has been checked before
		} else {
			return filteredDescriptors.get(0);
		}
	}

	/**
	 * Returns a fragment descriptor for its Id
	 * 
	 * @param id
	 *        the id of the fragment descriptor to retrieve
	 * @return the fragment descriptor found or <code>null</code>
	 */
	public FragmentDescriptor getFragmentDescriptor(String id) {
		FragmentDescriptor result = (FragmentDescriptor)executeUnique(ExecutionStrategy.REVERSE, new GetFragmentDescriptorOperation(id));
		return result;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.Service#newProviderDescriptor(org.eclipse.core.runtime.IConfigurationElement)
	 */
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		return new ProviderDescriptor(element);
	}

	/**
	 * returns all providers for this service. This is made to overpass the visibility of the final protected method {@link Service#getAllProviders()}
	 * <P>
	 * this method should not be used at runtime, it is available only for customization purpose.
	 * </P>
	 * 
	 * @return the list of all providers contributing to this service
	 */
	public List<?> findAllProviders() {
		return super.getAllProviders();
	}

	/**
	 * A descriptor for property views providers defined by a configuration element.
	 */
	public static class ProviderDescriptor extends ActivityFilterProviderDescriptor {

		/**
		 * Constructs a <code>ISemanticProvider</code> descriptor for
		 * the specified configuration element.
		 * 
		 * @param element
		 *        The configuration element describing the provider.
		 */
		public ProviderDescriptor(IConfigurationElement element) {
			super(element);
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
		 */
		public boolean provides(IOperation operation) {
			if(!super.provides(operation)) {
				return false;
			}
			if(operation instanceof IPropertyViewOperation) {
				// test if the configuration corresponds to the feature or the id of the operation
				return getProvider().provides(operation);
			}
			return false;
		}

		/**
		 * Resets the provider
		 */
		public void resetProvider() {
			provider = null;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IProvider getProvider() {
			if(provider == null) {
				IProvider newProvider = super.getProvider();
				if(provider instanceof IPropertyViewProvider) {
					((IPropertyViewProvider)newProvider).configure(getElement());
				}
				return newProvider;
			}
			return super.getProvider();
		}
	}

	/**
	 * Returns the list of all available fragment descriptors
	 * 
	 * @return the list of available fragment descriptors
	 */
	public Map<String, FragmentDescriptor> getAllFragmentDescriptors() {
		@SuppressWarnings("unchecked")
		List<Map<String, FragmentDescriptor>> fragmentDescriptors = execute(ExecutionStrategy.FORWARD, new GetAllFragmentDescriptorsOperation());
		return flattenMap(fragmentDescriptors);
	}

	/**
	 * Flattens the list, i.e. creates a list from the list of list
	 * 
	 * @param <T>
	 *        the type of elements in the list
	 * 
	 * @param descriptors
	 *        the list of list to flatten
	 * @return a flatten list of descriptors
	 */
	public <T> List<T> flattenList(List<List<T>> descriptors) {
		List<T> flattenList = new ArrayList<T>();
		for(List<T> list : descriptors) {
			flattenList.addAll(list);
		}
		return flattenList;
	}

	/**
	 * Flattens the list, i.e. creates a map from the list of maps
	 * 
	 * @param <T>
	 *        the type of the key for the map
	 * @param <V>
	 *        the type of the value in the map
	 * 
	 * @param descriptors
	 *        the list of list to flatten
	 * @return a flatten list of descriptors
	 */
	public <T, V> Map<T, V> flattenMap(List<Map<T, V>> descriptors) {
		Map<T, V> flattenMap = new HashMap<T, V>();
		for(Map<T, V> map : descriptors) {
			flattenMap.putAll(map);
		}
		return flattenMap;
	}

	/**
	 * {@inheritDoc}
	 */
	public void preferenceChange(PreferenceChangeEvent event) {
		if(XMLPropertyViewProvider.PROPERTY_VIEW_CUSTOMIZATIONS_ID.equals(event.getKey())) {
			for(Object descriptor : getAllProviders()) {
				if(descriptor instanceof ProviderDescriptor) {
					((ProviderDescriptor)descriptor).resetProvider();
				}
			}
			providerChanged(new ProviderChangeEvent(this));
		}
	}
}
