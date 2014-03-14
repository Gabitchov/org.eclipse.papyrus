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
package org.eclipse.papyrus.infra.nattable.views.config.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.views.config.Activator;

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
	 * the type of the table views
	 */
	public static final String TABLE_VIEW_TYPE_VALUE = "PapyrusViewsTable";

	/**
	 * the name of the feature which references the context of a diagram
	 */
	private static final String DIAGRAM_CONTEXT_FEATURE_NAME = "element"; //$NON-NLS-1$

	/**
	 * the name of the feature which references the EMF-Facet table in the PapyrusTableInstance
	 */
	private static final String PAPYRUS_TABLE_INSTANCE__TABLE_INSTANCE2_FEATURE_NAME = "table"; //$NON-NLS-1$

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

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the Context of this editor, or <code>null</code> if not found
	 */
	public static final Object getEditorContext(final Object editor) {
		if(editor instanceof EObject) {
			EObject eobject = (EObject)editor;
			EStructuralFeature feature = eobject.eClass().getEStructuralFeature(Utils.VIEW_CONTEXT);
			if(feature == null) {//it is maybe a diagram
				//workaround for the diagram
				feature = eobject.eClass().getEStructuralFeature(DIAGRAM_CONTEXT_FEATURE_NAME);
			}
			if(feature != null) {
				return eobject.eGet(feature);
			}
			//its maybe an old table
			EStructuralFeature tmp = eobject.eClass().getEStructuralFeature(PAPYRUS_TABLE_INSTANCE__TABLE_INSTANCE2_FEATURE_NAME);
			if(tmp != null) {
				final EObject tableinstance2 = (EObject)eobject.eGet(tmp);
				if(tableinstance2 != null) {
					feature = tableinstance2.eClass().getEStructuralFeature(Utils.VIEW_CONTEXT);
					return tableinstance2.eGet(feature);
				}

			}
		}
		return null;
	}

}
