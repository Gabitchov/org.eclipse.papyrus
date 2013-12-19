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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.compare.ui.provider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.eclipse.uml2.uml.Element;



public class SampleUMLProvider extends AdapterFactoryImpl {

	/**
	 * The instance of the actual label provider
	 */
	private LabelProviderAdapter instance = new LabelProviderAdapter();
	
	/**
	 * The UMLItemProviderAdapterFactory to which production of IItemLabelProvider
	 * is delegated 
	 */
	private AdapterFactory delegate = new UMLItemProviderAdapterFactory();
	
	/** 
	 * Overrides AdapatFactoryImple.adapt so that, if the target element is an Element,
	 * and if the requested adaptation type is IItemLabelProvider,
	 * the production of the adapter is delegated to delegate.
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#adapt(org.eclipse.emf.common.notify.Notifier, java.lang.Object)
	 */
	@Override
	public Adapter adapt(Notifier target, Object type) {
		// Test on instance.isRunning to avoid a stack overflow
		// Delegate to UML Item Label Provider
		if (target instanceof Element && type == IItemLabelProvider.class){
			if (! instance.isRunning){
				return instance;
			} else {
				return delegate.adapt(target, type);
			}
		}
		// FIXME Propose a more generic solution? (not bound directly to UML)
		return super.adapt(target, type);
	}
	
	private class LabelProviderAdapter extends AdapterImpl implements IItemLabelProvider {

		private boolean isRunning = false;
		
		private LabelProviderService service = new LabelProviderServiceImpl();
		
		public String getText(Object object) {
			isRunning = true;
			String result = service.getLabelProvider().getText(object);
			isRunning = false;
			return result;
		}

		public Object getImage(Object object) {
			isRunning = true;
			Object result = service.getLabelProvider().getImage(object);
			isRunning = false;
			return result;
		}
		
	};
}
