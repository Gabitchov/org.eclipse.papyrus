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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.hyperlink.Activator;


/**
 * The Class EditorListContentProvider.
 */
//TODO why a tree content provider
public class EditorListContentProvider implements ITreeContentProvider {

	//The context of the ContentProvider
	private EObject model;

	@Deprecated
	// since february 2014
	public EditorListContentProvider(EObject model) {
		this(model, null);
	}

	/**
	 * This factory is used to know if represent a valid editor or not
	 */
	private IPageModelFactory pageFactory;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param model
	 *        the model
	 * @param pageModelFactory
	 *        the page factory used to know is an object can be a page or not
	 */
	public EditorListContentProvider(EObject model, IPageModelFactory pageModelFactory) {
		this.model = model;
		this.pageFactory = pageModelFactory;
	}


	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		try {
			List<Object> res = new ArrayList<Object>();
			if(pageFactory == null) {
				IPageManager iPageMngr = ServiceUtilsForEObject.getInstance().getIPageManager(model);
				Object[] result = iPageMngr.allPages().toArray();


				for(Object current : result) {
					if(current != null /* && current instanceof PapyrusTableInstance */) {
						//					 if the model is a little bit corrupted, we can have a null element in the list 
						res.add(current);
					}
				}
			} else {
				for(final Resource current : model.eResource().getResourceSet().getResources()) {
					for(final Object object : current.getContents()) {
						if(isAValidEditor(object)) {
							res.add(object);
						}
					}
				}
			}
			return res.toArray();

		} catch (Exception e) {
			Activator.log.error(e);
		}
		return null;
	}

	//duplicated code from EditorLookForEditorShell
	private boolean isAValidEditor(final Object object) {
		if(!(object instanceof EObject)) {
			return false;
		}
		EObject eobject = (EObject)object;
		try {
			final IPageManager pageMng = ServiceUtilsForEObject.getInstance().getIPageManager(eobject);
			if(pageMng.allPages().contains(eobject)) {
				return true;
			}
		} catch (ServiceException ex) {
			//nothing to do
		}

		//if we are here, there are 2 cases : 
		//1. the object is a valid editor but it is not in the page manager (imported file probably)
		//2. or the object is not a valid editor
		IPageModel pageModel = this.pageFactory.createIPageModel(eobject);
		if(pageModel != null) {
			pageModel = null;
			return true;
		}
		return false;
	}


	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		//nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//nothing to do
	}
}
