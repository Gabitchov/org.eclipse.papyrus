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
import org.eclipse.emf.facet.custom.ui.internal.CustomizedTreeContentProvider;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.Activator;

/**
 * the content provider that inherits of modisco properties
 * 
 * @deprecated Use SemanticUMLContentProvider instead
 */
@Deprecated
public class MoDiscoContentProvider extends CustomizedTreeContentProvider {

	/** The ModelSet containing all the models. This is the initial input. */
	protected ModelSet modelSet;

	/** The list of open pages (diagrams) */
	protected IPageManager pageMngr;

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
		Object[] children = super.getChildren(parentElement);
		if(children == null) {
			return new Object[0];
		}
		return children;
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
	protected EObject[] getRootElements(Object inputElement) {

		try {
			if(!(inputElement instanceof ServicesRegistry)) {
				return null;
			}

			ServicesRegistry servicesRegistry = (ServicesRegistry)inputElement;

			modelSet = ModelUtils.getModelSetChecked(servicesRegistry);
			pageMngr = servicesRegistry.getService(IPageManager.class);

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
