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
package org.eclipse.papyrus.views.properties.tabbed.core.provider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.views.properties.tabbed.core.Activator;
import org.eclipse.papyrus.views.properties.tabbed.core.view.PropertyServiceUtil;
import org.eclipse.papyrus.views.properties.tabbed.core.view.XMLPropertyTabViewProvider;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistry;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistryFactory;
import org.eclipse.ui.views.properties.tabbed.AbstractTabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;


/**
 * Provider for {@link ITabDescriptor} published in the xml file for properties view.
 */
@SuppressWarnings("restriction")
public class XMLBasedTabDescriptorProvider implements ITabDescriptorProvider, IPreferenceChangeListener {

	/**
	 * Creates a new XMLBasedTabDescriptorProvider.
	 * 
	 */
	public XMLBasedTabDescriptorProvider() {
		// register listener on preferences for the proeprties runtime plugin
		IEclipsePreferences prefs = new InstanceScope().getNode(org.eclipse.papyrus.views.properties.runtime.Activator.ID);
		prefs.addPreferenceChangeListener(this);
	}

	/** list of available tab descriptors */
	protected ITabDescriptor[] descriptors = null;

	/**
	 * {@inheritDoc}
	 */
	public ITabDescriptor[] getTabDescriptors(IWorkbenchPart part, ISelection selection) {
		if(descriptors == null && part instanceof CoreMultiDiagramEditor && selection != null) {
			List<ITabDescriptor> descriptors = new ArrayList<ITabDescriptor>();

			List<List<ITabDescriptor>> list = PropertyServiceUtil.getTabDescriptors();
			for(List<ITabDescriptor> sub : list) {
				descriptors.addAll((List<ITabDescriptor>)sub);
			}
			// get all tab descriptors for the registered extension points
			TabbedPropertyRegistry registry = TabbedPropertyRegistryFactory.getInstance().createRegistry((CoreMultiDiagramEditor)part);

			// invoke dynamically on the tab registry, as method is private
			// problem of implementation of tabbed properties tabbed registry. Either contribution using extension points, either a tabprovider
			// both contribution can not exist together, the only solution is to make a workaround.
			try {
				Method method = TabbedPropertyRegistry.class.getDeclaredMethod("getAllTabDescriptors");
				method.setAccessible(true);
				ITabDescriptor[] registeredTabDesriptors;

				registeredTabDesriptors = (ITabDescriptor[])method.invoke(registry);
				if(registeredTabDesriptors != null) {
					descriptors.addAll(Arrays.asList(registeredTabDesriptors));
				}
			} catch (IllegalArgumentException e) {
				Activator.log.error(e);
			} catch (IllegalAccessException e) {
				Activator.log.error(e);
			} catch (InvocationTargetException e) {
				Activator.log.error(e);
			} catch (SecurityException e) {
				Activator.log.error(e);
			} catch (NoSuchMethodException e) {
				Activator.log.error(e);
			}


			// for all descriptors, section should be ordered at this time... Could be time consuming!
			for(ITabDescriptor descriptor : descriptors) {
				orderSectionInTabDescriptor(descriptor);
			}

			this.descriptors = descriptors.toArray(new ITabDescriptor[descriptors.size()]);
		}
		return (descriptors != null) ? descriptors : new ITabDescriptor[0];
	}

	/**
	 * Orders the section descriptors present in the specified tab descriptor
	 * 
	 * @param tabDescriptor
	 *        the descriptor to order
	 */
	@SuppressWarnings("unchecked")
	protected void orderSectionInTabDescriptor(ITabDescriptor tabDescriptor) {
		// generates the map (id, sectiondescriptor) to speed up the search
		final Map<String, ISectionDescriptor> map = new HashMap<String, ISectionDescriptor>();
		for(ISectionDescriptor descriptor : (List<ISectionDescriptor>)tabDescriptor.getSectionDescriptors()) {
			map.put(descriptor.getId(), descriptor);
		}

		Collections.sort(tabDescriptor.getSectionDescriptors(), new Comparator<ISectionDescriptor>() {

			/**
			 * @param section0
			 *        the first section descriptor to compare
			 * @param section1
			 *        the second section descriptor to compare
			 * @return an integer greater than 1 if the first section should be placed before the second
			 */
			public int compare(ISectionDescriptor section0, ISectionDescriptor section1) {
				// retrieve the list of previous section for first section
				int delta = 0;
				ISectionDescriptor previousSection0 = getPreviousSection(section0);
				while(previousSection0 != null) {
					delta++;
					if(section1.equals(previousSection0)) {
						return delta;
					}
					previousSection0 = getPreviousSection(previousSection0);
				}
				delta = 0;
				ISectionDescriptor previousSection1 = getPreviousSection(section1);
				while(previousSection1 != null) {
					delta--;
					if(section0.equals(previousSection1)) {
						return delta;
					}
					previousSection1 = getPreviousSection(previousSection1);

				}
				return 0;
			}

			/**
			 * Returns the list of sections which are before section0
			 * 
			 * @param section
			 *        the section to test
			 * @return the list of sections which are before section0
			 */
			public ISectionDescriptor getPreviousSection(ISectionDescriptor section) {
				String afterId = section.getAfterSection();
				if(afterId == AbstractTabDescriptor.TOP) {
					return null;
				} else {
					return map.get(afterId);
				}
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public void preferenceChange(PreferenceChangeEvent event) {
		if(XMLPropertyTabViewProvider.PROPERTY_VIEW_CUSTOMIZATIONS_ID.equals(event.getKey())) {
			// reset cache
			descriptors = null;
		}
	}
}
