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
package org.eclipse.papyrus.properties.tabbed.core.provider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.properties.tabbed.core.Activator;
import org.eclipse.papyrus.properties.tabbed.core.view.PropertyServiceUtil;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistry;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistryFactory;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;


/**
 * Provider for {@link ITabDescriptor} published in the xml file for properties view.
 */
@SuppressWarnings("restriction")
public class XMLBasedTabDescriptorProvider implements ITabDescriptorProvider {

	/** list of available tab descriptors */
	protected ITabDescriptor[] descriptors = null;

	/**
	 * {@inheritDoc}
	 */
	public ITabDescriptor[] getTabDescriptors(IWorkbenchPart part, ISelection selection) {
		if(descriptors == null && part != null) {
			List<ITabDescriptor> descriptors = new ArrayList<ITabDescriptor>();

			List<List<ITabDescriptor>> list = PropertyServiceUtil.getTabDescriptors();
			for(List<ITabDescriptor> sub : list) {
				descriptors.addAll((List<ITabDescriptor>)sub);
			}
			// get all tab descriptors for the registered extension points
			TabbedPropertyRegistry registry = TabbedPropertyRegistryFactory.getInstance().createRegistry((CoreMultiDiagramEditor)EditorUtils.getMultiDiagramEditor());

			// invoke dynamically on the tab registry, as method is private :/
			// problem of implementation of tabbed properties tabbed registry. Either contribution using extension points, either a tabprovider
			// both contribution can not exist together, the only solution is to make a workaround.
			try {
				Method method = TabbedPropertyRegistry.class.getDeclaredMethod("getAllTabDescriptors");
				method.setAccessible(true);
				ITabDescriptor[] registeredTabDesriptors;

				registeredTabDesriptors = (ITabDescriptor[])method.invoke(registry);
				descriptors.addAll(Arrays.asList(registeredTabDesriptors));
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


			this.descriptors = descriptors.toArray(new ITabDescriptor[descriptors.size()]);
		}
		return (descriptors != null) ? descriptors : new ITabDescriptor[0];
	}
}
