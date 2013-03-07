/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.configuration;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.solver.PathResolverFactory;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.swt.graphics.GC;
import org.eclipse.ui.internal.SharedImages;


public class CustomizedCellPainter extends TextPainter {

	private static final String BEGIN_OF_LIST = "["; //$NON-NLS-1$

	private static final String END_OF_LIST = "]"; //$NON-NLS-1$

	private static final String VALUE_SEPARATOR = ", "; //$NON-NLS-1$

	//FIXME currently the service registry can't be obtained for features, because their resources are not included in the resourceSet
	public static LabelProviderService serv;

	//FIXME : we must have an EObject (the context of the table) to find the service registry
	public CustomizedCellPainter() {
		if(serv == null) {
			serv = new LabelProviderServiceImpl();
			try {
				serv.startService();
			} catch (final ServiceException e) {
				Activator.log.error(e);
			}
		}
	}


	@Override
	protected String convertDataType(final ILayerCell cell, final IConfigRegistry configRegistry) {
		final Object value = cell.getDataValue();
		//		if(value instanceof EStructuralFeature) {
		//			LabelProviderService service = getLabelProviderService((EObject)value);
		//			if(service == null) {
		//				service = serv;
		//			}
		//			ILabelProvider provider = service.getLabelProvider("org.eclipse.papyrus.infra.nattable.header.labelprovider");
		//			String txt = provider.getText(value);
		//			int i = 0;
		//			i++;
		//		}
		if(value != null) {
			if(value instanceof EObject) {
				return getLabelForEObject((EObject)value);
				//				if(value instanceof EStructuralFeature && ((EStructuralFeature)value).isDerived()) {//FIXME : not yet done for the list of structural feature!
				//					return "/" + str; //FIXME : must probably be done with a customization.
				//				}
				//				return str;
			} else if(value instanceof Collection<?>) {
				final Iterator<Object> iter = ((Collection)value).iterator();
				String text = BEGIN_OF_LIST;
				while(iter.hasNext()) {
					final Object current = iter.next();
					if(current instanceof EObject) {
						text += getLabelForEObject((EObject)current);
						if(iter.hasNext()) {
							text += VALUE_SEPARATOR;
						}
					} else {
						text+=current;
						if(iter.hasNext()) {
							text += VALUE_SEPARATOR;
						}
					}
				}
				text += END_OF_LIST;
				return text;
			}
			//			//stereotype management
			//			else if(value instanceof String){
			//
			//			}



		}
		return super.convertDataType(cell, configRegistry);
	}


	protected String getLabelForEObject(final EObject object) {
		LabelProviderService service = getLabelProviderService(object);
		if(service == null) {
			service = serv;
		}
		if(service != null) {
			final ILabelProvider provider = service.getLabelProvider();
			return provider.getText(object);
		}
		return ""; //$NON-NLS-1$
	}

	protected LabelProviderService getLabelProviderService(final EObject eobject) {
		final ServicesRegistry registry = getServiceRegistry(eobject);
		if(registry != null) {
			try {
				return registry.getService(LabelProviderService.class);
			} catch (final ServiceException e) {
				Activator.log.error(e);
			}
		}
		return null;
	}

	protected ServicesRegistry getServiceRegistry(final EObject object) {
		try {
			return ServiceUtilsForResource.getInstance().getServiceRegistry(object.eResource());
		} catch (final ServiceException e) {
			//			Activator.log.error("ServiceRegistry not found", e);
		}
		return null;
	}

}
