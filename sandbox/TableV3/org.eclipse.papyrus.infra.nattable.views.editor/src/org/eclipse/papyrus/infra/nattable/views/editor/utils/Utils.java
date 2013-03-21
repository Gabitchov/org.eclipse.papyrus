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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.views.editor.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.views.editor.Activator;

/**
 * 
 * @author Vincent Lorenzo
 * 
 */
public class Utils {

	private Utils() {
		//to prevent instanciation
	}

	/**
	 * the prefix used for the editor
	 */
	public static final String NATTABLE_EDITOR_PAGE_ID = "nattable_editor_pages:/"; //$NON-NLS-1$

	/**
	 * the name column
	 */
	public static final String VIEW_NAME = "name"; //$NON-NLS-1$

	/**
	 * the context column
	 */
	public static final String VIEW_CONTEXT = "context"; //$NON-NLS-1$

	/**
	 * the isOpen column
	 */
	public static final String VIEW_IS_OPEN = "isOpen"; //$NON-NLS-1$

	/**
	 * the type column
	 */
	public static final String VIEW_EDITOR_TYPE = "type"; //$NON-NLS-1$

	/**
	 * 
	 * @return
	 *         the page list used for this model
	 */
	public static final PageList getPageList(final Table table) {
		final Resource resource = table.eResource();
		final ModelSet modelSet = (ModelSet)resource.getResourceSet();
		final Resource diResource = modelSet.getAssociatedResource(resource, DiModel.DI_FILE_EXTENSION, false);
		final SashWindowsMngr windowMngr = DiUtils.lookupSashWindowsMngr(diResource);
		final PageList pageList = windowMngr.getPageList();
		assert pageList != null;
		return pageList;
	}

	/**
	 * 
	 * @param eobject
	 *        an eobject
	 * @return
	 *         the IPageMngr found thanks to this eobject or <code>null</code> if not found
	 */
	public static final IPageManager getIPagneManager(final EObject eobject) {
		IPageManager mngr = null;
		try {
			mngr = ServiceUtilsForResource.getInstance().getIPageManager(eobject.eResource());
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return mngr;
	}


}
