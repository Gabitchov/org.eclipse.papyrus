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
package org.eclipse.papyrus.properties.xwt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.runtime.ConstraintEngine;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistry;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistryFactory;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

public class XWTTabDescriptorProvider implements ITabDescriptorProvider {

	public XWTTabDescriptorProvider() {
	}

	public ITabDescriptor[] getTabDescriptors(final IWorkbenchPart part, final ISelection selection) {
		ConstraintEngine constraintEngine = ConfigurationManager.instance.constraintEngine;

		constraintEngine.setSelection(selection);
		List<ITabDescriptor> descriptors = new LinkedList<ITabDescriptor>();

		if(constraintEngine.match()) {
			Set<View> views = constraintEngine.getViews();

			descriptors.addAll(ConfigurationManager.instance.display.getTabDescriptors(views));
		}


		// get all tab descriptors for the registered extension points
		TabbedPropertyRegistry registry = TabbedPropertyRegistryFactory.getInstance().createRegistry((ITabbedPropertySheetPageContributor)part);

		// invoke dynamically on the tab registry, as method is private
		// problem of implementation of tabbed properties tabbed registry. Either contribution using extension points, either a tabprovider
		// both contribution can not exist together, the only solution is to make a workaround.
		try {
			Method method = TabbedPropertyRegistry.class.getDeclaredMethod("getAllTabDescriptors"); //$NON-NLS-1$
			method.setAccessible(true);
			ITabDescriptor[] registeredTabDesriptors;

			registeredTabDesriptors = (ITabDescriptor[])method.invoke(registry);

			if(registeredTabDesriptors != null) {
				for(ITabDescriptor descriptor : registeredTabDesriptors) {
					if(descriptor.getSectionDescriptors().size() > 0) {
						descriptors.add(descriptor);
					}
				}
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
		
		orderTabDescriptors(descriptors);

		return descriptors.toArray(new ITabDescriptor[descriptors.size()]);
	}
	
	/**
	 * Order the tab descriptors in the given list, given the afterTab comparator
	 * 
	 * @param descriptors
	 *        tab descriptor list to order
	 */
	protected void orderTabDescriptors(final List<ITabDescriptor> descriptors) {
		Collections.sort(descriptors, new Comparator<ITabDescriptor>() {

			/**
			 * compares two tab descriptors each other
			 * 
			 * @param tabDescriptor1
			 *        first tab to compare
			 * @param tabDescriptor2
			 *        second tab to compare
			 * @return an integer greater than 1 if the first tab should be placed before the second tab
			 */
			public int compare(ITabDescriptor tabDescriptor1, ITabDescriptor tabDescriptor2) {
				int delta = 0;
				ITabDescriptor previousTab0 = getPreviousTab(tabDescriptor1);
				while(previousTab0 != null) {
					delta++;
					if(tabDescriptor2.equals(previousTab0)) {
						return delta;
					}
					previousTab0 = getPreviousTab(previousTab0);
				}
				delta = 0;
				ITabDescriptor previousTab1 = getPreviousTab(tabDescriptor2);
				while(previousTab1 != null) {
					delta--;
					if(tabDescriptor1.equals(previousTab1)) {
						return delta;
					}
					previousTab1 = getPreviousTab(previousTab1);

				}
				return 0;
			}

			/**
			 * Returns the tab descriptor before tab
			 * 
			 * @param tab
			 *        the tab to test
			 * @return the tab descriptor before tab
			 */
			public ITabDescriptor getPreviousTab(ITabDescriptor tab) {
				String afterId = tab.getAfterTab();
				if(!(ITabDescriptor.TOP.equals(afterId))) {
					for(ITabDescriptor descriptor : descriptors) {
						String id = descriptor.getId();
						if(id != null && id.equals(afterId)) {
							return descriptor;
						}
					}

				}
				// not found. Return null
				return null;
			}


		});
	}
}
