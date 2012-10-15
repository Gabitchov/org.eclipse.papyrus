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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.modelexplorer.provider;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.providers.MoDiscoContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.uml.diagram.modelexplorer.Activator;

/**
 * 
 * this content provider is used to display diagrams and their contents
 * 
 */
//TODO : This ContentProvider should extend SemanticUMLContentProvider
public class DiagramContentProvider extends MoDiscoContentProvider {

	@Override
	public Object[] getChildren(final Object parentElement) {
		ArrayList<Object> result = new ArrayList<Object>();


		if(parentElement instanceof IAdaptable) {
			EObject eObject = (EObject)((IAdaptable)parentElement).getAdapter(EObject.class);
			if(eObject instanceof Diagram) {
				return result.toArray();
			}
		}

		Object[] arrayObject = super.getChildren(parentElement);
		if(arrayObject != null) {
			for(int i = 0; i < arrayObject.length; i++) {
				result.add(arrayObject[i]);
			}
		}
		return result.toArray();
	}

	@Override
	public Object[] getElements(final Object inputElement) {
		Object[] rootElements = getRootElements(inputElement);
		if(rootElements == null) {
			return null;
		}
		return rootElements;
	}

	@Override
	public EObject[] getRootElements(Object inputElement) {

		try {
			if(!(inputElement instanceof ServicesRegistry)) {
				return null;
			}

			ServicesRegistry servicesRegistry = (ServicesRegistry)inputElement;

			modelSet = ModelUtils.getModelSetChecked(servicesRegistry);
			pageMngr = servicesRegistry.getService(DiSashModelMngr.class).getIPageMngr();

			ArrayList<EObject> result = new ArrayList<EObject>();
			for(int i = 0; i < pageMngr.allPages().size(); i++) {
				if(pageMngr.allPages().get(i) instanceof EObject) {
					result.add((EObject)pageMngr.allPages().get(i));
				}
			}
			EObject[] eObject = new EObject[result.size()];
			return NotationUtils.getNotationModel().getResource().getContents().toArray(eObject);

		} catch (Exception e) {
			Activator.log.error(e);
		}

		return new EObject[0];
	}
}
