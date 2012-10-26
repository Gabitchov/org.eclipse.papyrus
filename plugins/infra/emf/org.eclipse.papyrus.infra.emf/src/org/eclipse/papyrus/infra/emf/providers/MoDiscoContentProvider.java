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
package org.eclipse.papyrus.infra.emf.providers;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelContentProvider;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.Activator;

/**
 * the content provider that inherits of modisco properties
 * 
 * @deprecated Use SemanticUMLContentProvider instead
 */
@Deprecated
public class MoDiscoContentProvider extends CustomizableModelContentProvider {

	/** The ModelSet containing all the models. This is the initial input. */
	protected ModelSet modelSet;

	/** The list of open pages (diagrams) */
	protected IPageMngr pageMngr;

	/**
	 * Creates a new MoDiscoContentProvider.
	 */
	public MoDiscoContentProvider() {
		super(Activator.getDefault().getCustomizationManager());
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	@Override
	public Object[] getChildren(final Object parentElement) {
		ArrayList<Object> result = new ArrayList<Object>();

		Object[] arrayObject = super.getChildren(parentElement);
		if(arrayObject != null) {
			for(int i = 0; i < arrayObject.length; i++) {
				result.add(arrayObject[i]);
			}
		}
		/**
		 * Refactoring with bug 358732
		 */
		//
		//		if (parentElement instanceof IAdaptable) {
		//			EObject eObject = (EObject)((IAdaptable)parentElement).getAdapter(EObject.class);
		//			if(eObject !=null) {
		//				List<Diagram> diagramList = findAllExistingDiagrams(eObject);
		//					Iterator<Diagram> iterator = diagramList.iterator();
		//					while (iterator.hasNext()) {
		//						result.add(iterator.next());
		//					}
		//			}
		//
		//		}

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

			modelSet = ModelUtils.getModelSetChecked(servicesRegistry);
			pageMngr = servicesRegistry.getService(DiSashModelMngr.class).getIPageMngr();

			return getRootElements(modelSet);
		} catch (Exception e) {
			Activator.log.error(e);
		}

		return new EObject[0];
	}

	/**
	 * Get the roots elements from the {@link ModelSet} provided as input.
	 * 
	 * @return
	 */
	protected EObject[] getRootElements(ModelSet modelSet) {
		//FIXME: Refactoring. Workaround to remove the explicit dependency to UMLModel in uml.tools. We should not depend on UML at all.
		IModel umlIModel = modelSet.getModel("org.eclipse.papyrus.infra.core.resource.uml.UmlModel");

		AbstractBaseModel umlModel = null;
		if(umlIModel instanceof AbstractBaseModel) {
			umlModel = (AbstractBaseModel)umlIModel;
		}

		if(umlModel == null) {
			return null;
		}

		EList<EObject> contents = umlModel.getResource().getContents();
		ArrayList<EObject> result = new ArrayList<EObject>();
		Iterator<EObject> iterator = contents.iterator();
		while(iterator.hasNext()) {
			EObject eObject = iterator.next();
			result.add(eObject);
		}
		return result.toArray(new EObject[result.size()]);
	}
}
