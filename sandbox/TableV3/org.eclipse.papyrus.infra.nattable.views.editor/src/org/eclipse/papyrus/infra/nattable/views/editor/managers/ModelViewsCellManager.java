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
package org.eclipse.papyrus.infra.nattable.views.editor.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.manager.ICellManager;
import org.eclipse.papyrus.infra.nattable.views.editor.utils.Utils;

public class ModelViewsCellManager implements ICellManager {



	/**
	 *
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	protected List<Object> organizeObject(final Object obj1, final Object obj2) {
		final List<Object> objects = new ArrayList<Object>();
		if(obj1 instanceof String && ((String)obj1).startsWith(Utils.NATTABLE_EDITOR_PAGE_ID)) {
			objects.add(obj2);
			objects.add(obj1);
		} else if(obj2 instanceof String && ((String)obj2).startsWith(Utils.NATTABLE_EDITOR_PAGE_ID)) {
			objects.add(obj1);
			objects.add(obj2);
		}
		if(objects.size() == 2) {
			final Object first = objects.get(0);
			if(first instanceof EObject) {
				IPageManager mngr = null;
				try {
					mngr = ServiceUtilsForResource.getInstance().getIPageManager(((EObject)first).eResource());
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(mngr != null && !mngr.allPages().contains(first)) {
					return Collections.emptyList();
				}
			}
		}

		return objects;
	}

	public boolean handles(Object obj1, Object obj2) {
		return organizeObject(obj1, obj2).size() == 2;
	}

	public boolean handlersAxisElement(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getValue(Object obj1, Object obj2) {
		final List<Object> objects = organizeObject(obj1, obj2);
		final String featureName = ((String)objects.get(1)).replace(Utils.NATTABLE_EDITOR_PAGE_ID, "");
		if(featureName.equals("isOpen")) {
			IPageManager mngr = null;
			try {
				mngr = ServiceUtilsForResource.getInstance().getIPageManager(((EObject)objects.get(0)).eResource());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mngr.isOpen(objects.get(0));
		}
		return getFeatureValue((EObject)objects.get(0), featureName);
	}

	public void setValue(EditingDomain domain, Object obj1, Object obj2, Object newValue) {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.ICellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 *
	 * @param obj1
	 * @param obj2
	 * @return
	 *         <code>true</code> excepted if the edited feature is isOpen
	 */
	public boolean isCellEditable(Object obj1, Object obj2) {
		final List<Object> objects = organizeObject(obj1, obj2);
		final String featureName = ((String)objects.get(1)).replace(Utils.NATTABLE_EDITOR_PAGE_ID, "");
		return !featureName.equals(Utils.VIEW_IS_OPEN);
	}

	public Command getSetValueCommand(EditingDomain domain, Object obj1, Object obj2, Object newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 * @param eobject
	 *        the eobject
	 * @param featureName
	 *        the name of the featuer
	 * @return
	 *         the value for the couple EObject/featureName
	 */
	protected Object getFeatureValue(final EObject eobject, final String featureName) {
		String DIAGRAM_CONTEXT_NAME = "element";
		EStructuralFeature feature = eobject.eClass().getEStructuralFeature(featureName);
		if(feature == null && Utils.VIEW_CONTEXT.equals(featureName)) {
			//workaround for the diagram
			feature = eobject.eClass().getEStructuralFeature(DIAGRAM_CONTEXT_NAME);

			if(feature == null) {
				//workaround for the old table
				final EStructuralFeature tmpFeature = eobject.eClass().getEStructuralFeature("table");
				if(tmpFeature != null) {
					EObject tableinstance2 = (EObject)eobject.eGet(tmpFeature);
					if(tableinstance2 != null) {
						feature = tableinstance2.eClass().getEStructuralFeature(featureName);
						if(feature != null) {
							return tableinstance2.eGet(feature);
						}
					}
				}
			}
		}
		if(feature != null) {
			return eobject.eGet(feature);
		}
		return NOT_AVALAIBLE;
	}

}
