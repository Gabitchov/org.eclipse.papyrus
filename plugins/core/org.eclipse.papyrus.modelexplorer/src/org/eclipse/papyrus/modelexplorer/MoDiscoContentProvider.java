/*******************************************************************************
 * Copyright (c) 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmt.modisco.infra.browser.uicore.CustomizableModelContentProvider;
import org.eclipse.gmt.modisco.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.papyrus.core.adaptor.gmf.DiagramsUtil;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.resource.uml.UmlModel;

/**
 * the content provider that inherits of modisco properties
 * 
 * The notation resource is now directly used to find associated diagrams isntead of IPageMngr
 * This is needed to handle correctly the display of diagrams in controlled resources
 */
@SuppressWarnings("restriction")
public class MoDiscoContentProvider extends CustomizableModelContentProvider {

	private DiResourceSet diResourceSet;

	public MoDiscoContentProvider() {
		super(Activator.getDefault().getCustomizationManager());
	}

	@Override
	public Object[] getChildren(final Object parentElement) {

		LinkedList<Object> result = new LinkedList<Object>();

		Object[] arrayObject = super.getChildren(parentElement);
		if(arrayObject != null) {
			for(int i = 0; i < arrayObject.length; i++) {
				result.add(arrayObject[i]);
			}
		}
		if(parentElement instanceof ModelElementItem && ((ModelElementItem)(parentElement)).getEObject() instanceof EObject) {
			List<Diagram> diagramList = DiagramsUtil.getAssociatedDiagrams(((EObject)((ModelElementItem)parentElement).getEObject()), diResourceSet);
			Iterator<Diagram> iterator = diagramList.iterator();
			while(iterator.hasNext()) {
				result.add(iterator.next());
			}
		}
		return result.toArray();
	}

	/**
	 * Return the initial values from the input.
	 * Input should be of type {@link UmlModel}.
	 * 
	 * @see org.eclipse.gmt.modisco.infra.browser.uicore.CustomizableModelContentProvider#getRootElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */
	@Override
	public EObject[] getRootElements(Object inputElement) {

		try {
			if(!(inputElement instanceof ServicesRegistry)) {
				return null;
			}

			ServicesRegistry servicesRegistry = (ServicesRegistry)inputElement;

			diResourceSet = servicesRegistry.getService(DiResourceSet.class);

			Resource modelResource = diResourceSet.getModelResource();

			if(modelResource != null) {
				return getRootElements(diResourceSet.getModelResource());
			}
		} catch (Exception e) {
			Activator.log.error(e);
		}

		return new EObject[0];
	}

	/**
	 * Get the roots elements from the model resource provided as input.
	 * 
	 * @return
	 */
	protected EObject[] getRootElements(Resource modelResource) {

		EList<EObject> contents = modelResource.getContents();
		LinkedList<EObject> result = new LinkedList<EObject>();
		Iterator<EObject> iterator = contents.iterator();
		while(iterator.hasNext()) {
			EObject eObject = (EObject)iterator.next();
			result.add(eObject);
		}
		return result.toArray(new EObject[result.size()]);
	}
}
