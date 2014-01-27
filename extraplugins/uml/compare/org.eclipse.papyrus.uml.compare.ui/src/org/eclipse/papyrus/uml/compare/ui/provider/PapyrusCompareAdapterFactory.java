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
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.uml2.uml.Element;



public class PapyrusCompareAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The instance of the actual label provider
	 */
	private LabelProviderAdapter instance = new LabelProviderAdapter();
	
	/** 
	 * Overrides AdapatFactoryImple.adapt so that, if the target element is an Element,
	 * and if the requested adaptation type is IItemLabelProvider,
	 * the production of the adapter is delegated to delegate.
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#adapt(org.eclipse.emf.common.notify.Notifier, java.lang.Object)
	 */
	@Override
	public Adapter adapt(Notifier target, Object type) {
		if (target instanceof Element && type == IItemLabelProvider.class) {
			return instance;
		}
		return super.adapt(target, type);
	}
	
	private class LabelProviderAdapter extends AdapterImpl implements IItemLabelProvider {
		
		/**
		 * An instance of the Papyrus label provider service
		 */
		private LabelProviderService service = new LabelProviderServiceImpl();
		
		/**
		 * Delegates production of the text label to the
		 * label provider associated with the Papyrus label provider service
		 */
		public String getText(Object object) {
			String result = service.getLabelProvider().getText(object);
			return result;
		}

		/**
		 * Delegates production of the image to the
		 * label provider associated with the Papyrus label provider service
		 */
		public Object getImage(Object object) {
			Object result = service.getLabelProvider().getImage(object);
			return result;
		}
		
	};
}
