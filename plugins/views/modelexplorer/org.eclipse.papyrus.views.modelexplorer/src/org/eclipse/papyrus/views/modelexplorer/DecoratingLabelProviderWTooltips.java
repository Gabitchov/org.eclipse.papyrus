/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  
 * History:
 *  Renamed from MoDiscoLabelProviderWTooltips - fix for bug 371905
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ModelExplorerDecorationAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.internal.navigator.NavigatorDecoratingLabelProvider;

/**
 * A LabelProvider with support for decorations
 */
public class DecoratingLabelProviderWTooltips extends NavigatorDecoratingLabelProvider {

	private DecorationService decorationService;

	public DecoratingLabelProviderWTooltips(ILabelProvider labelProvider, ServicesRegistry servicesRegistry) {
		super(labelProvider);
		try {
			this.decorationService = servicesRegistry.getService(DecorationService.class);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public String getToolTipText(Object element) {
		if(decorationService == null) {
			return null;
		}

		List<IPapyrusDecoration> decorations = decorationService.getDecorations(element, true);
		return Decoration.getMessageFromDecorations(decorations);
	}

	@Override
	public Image getImage(Object element) {
		Image baseImage = super.getImage(element);

		if(decorationService == null) {
			return baseImage;
		}
		// Get the Model Explorer Adapter
		ModelExplorerDecorationAdapter adapter = new ModelExplorerDecorationAdapter(baseImage);


		//Set the adapter decoration with position as indicated by decoration (from decoration service)
		if(element != null) {
			if(element instanceof EObject || (element instanceof IAdaptable && ((IAdaptable)element).getAdapter(EObject.class) != null)) {
				List<IPapyrusDecoration> decorations = decorationService.getDecorations(element, true);
				if(decorations != null) {
					adapter.setDecorations(decorations);
				}
			}
		}

		//return the target decorated
		return adapter.getDecoratedImage();

	}

	@Override
	public Point getToolTipShift(Object object) {
		return new Point(5, 5);
	}

	@Override
	public int getToolTipDisplayDelayTime(Object object) {
		return 1000;
	}

	@Override
	public int getToolTipTimeDisplayed(Object object) {
		return 10000;
	}
}
