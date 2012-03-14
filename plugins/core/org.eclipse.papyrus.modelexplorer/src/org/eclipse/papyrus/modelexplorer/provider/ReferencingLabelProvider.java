/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (Atos) tristan.faure@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.modelexplorer.MoDiscoLabelProvider;
import org.eclipse.papyrus.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IOpenable;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IOpenableWithContainer;
import org.eclipse.swt.graphics.Image;


/**
 * A modisco label provider for {@link IOpenable} which display the eobject containing it
 * @author tfaure
 *
 */
public class ReferencingLabelProvider implements ILabelProvider {

	MoDiscoLabelProvider delegated = new MoDiscoLabelProvider();
	
	public void addListener(ILabelProviderListener listener) {
		delegated.addListener(listener);
	}

	public void dispose() {
		delegated.dispose();
	}

	public boolean isLabelProperty(Object element, String property) {
		return delegated.isLabelProperty(element,property);
	}

	public void removeListener(ILabelProviderListener listener) {
		delegated.removeListener(listener);
	}

	public Image getImage(Object element) {
		return delegated.getImage(element);
	}

	public String getText(Object element) {
		EObject e = get(element,EObject.class);
		IOpenable openable = NavigatorUtils.getElement(e, IOpenable.class);
		String toSuffix = new String("");
		if (e != null && openable instanceof IOpenableWithContainer){
			IOpenableWithContainer iwc = (IOpenableWithContainer)openable;
			EObject container = get(iwc.getContainer(),EObject.class);
			ComposedAdapterFactory fac = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			toSuffix = " - from " + new ReflectiveItemProvider(fac).getText(container);
		}
		return delegated.getText(element) + toSuffix;
	}

	@SuppressWarnings("unchecked")
	public <T> T get (Object o, Class<T> aClass)
	{
		if (aClass.isInstance(o)) {
			return (T)o ;
		}
		T element = NavigatorUtils.getElement(o, aClass);
		if (element != null) {
			return element ;
		}
		return null ;
			
	}
	
}
