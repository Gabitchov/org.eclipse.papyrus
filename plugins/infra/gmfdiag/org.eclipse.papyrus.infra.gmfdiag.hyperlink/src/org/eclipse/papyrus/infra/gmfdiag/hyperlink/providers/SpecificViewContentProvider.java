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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.providers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.SemanticElementHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.hyperlink.Activator;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;


public class SpecificViewContentProvider implements IHierarchicContentProvider {

	private EObject[] roots;

	private EObject[] getRoots(ServicesRegistry context) {
		try {
			ModelSet modelSet = context.getService(ModelSet.class);
			IModel notationModel = modelSet.getModel(NotationModel.MODEL_ID);
			if(notationModel instanceof AbstractBaseModel) {
				Resource resource = ((AbstractBaseModel)notationModel).getResource();
				List<Diagram> result = new LinkedList<Diagram>();
				for(EObject rootElement : resource.getContents()) {
					if(rootElement instanceof Diagram) {
						result.add((Diagram)rootElement);
					}
				}
				return result.toArray(new Diagram[0]);
			}
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
		return new EObject[0];
	}

	public Object[] getElements(Object inputElement) {
		if(roots == null) {
			if(inputElement instanceof EObject) {
				try {
					ServicesRegistry registry = ServiceUtilsForEObject.getInstance().getServiceRegistry((EObject)inputElement);
					roots = getRoots(registry);
				} catch (ServiceException ex) {
					Activator.log.error(ex);
				}
			}
		}
		return roots == null ? new Object[0] : roots;
	}

	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof EObject) {
			List<Object> validChildren = new LinkedList<Object>();
			for(Object childElement : ((EObject)parentElement).eContents()) {
				if(isValidValue(childElement)) {
					validChildren.add(childElement);
				} else {
					//Go deeper, to find e.g. TopView(Class)::AttributeCompartment(Class)::TopView(Property)
					validChildren.addAll(Arrays.asList(getChildren(childElement)));
				}
			}
			return validChildren.toArray();

		}
		return new Object[0];
	}

	public Object getParent(Object element) {
		if(element instanceof EObject) {
			return ((EObject)element).eContainer();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	public void dispose() {
		//Nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//Ignored
	}

	public boolean isValidValue(Object element) {
		if(element instanceof View && ((View)element).getElement() == null) {
			return false;
		}
		return element instanceof View && SemanticElementHelper.findTopView((View)element) == element;
	}
}
