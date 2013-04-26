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
package org.eclipse.papyrus.infra.nattable.views.config.manager.cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.views.config.Activator;
import org.eclipse.papyrus.infra.nattable.views.config.utils.Utils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * The Cell manager for the ModelViews table
 * 
 * @author Vincent Lorenzo
 * 
 */
public class ModelViewsCellManager extends AbstractCellManager {

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
				final IPageManager mngr = Utils.getIPagneManager((EObject)first);
				if(mngr != null && !mngr.allPages().contains(first)) {
					return Collections.emptyList();
				}
			}
		}

		return objects;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public boolean handles(Object obj1, Object obj2) {
		return organizeObject(obj1, obj2).size() == 2;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#handlersAxisElement(java.lang.Object)
	 * 
	 * @param obj
	 * @return
	 */
	public boolean handlersAxisElement(Object obj) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getValue(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public Object getValue(Object obj1, Object obj2) {
		final List<Object> objects = organizeObject(obj1, obj2);
		final String featureName = ((String)objects.get(1)).replace(Utils.NATTABLE_EDITOR_PAGE_ID, ""); //$NON-NLS-1$
		final Object editor = objects.get(0);
		if(Utils.VIEW_NAME.equals(featureName)) {
			return getEditorName(editor);
		}
		if(Utils.VIEW_CONTEXT.equals(featureName)) {
			return getEditorContext(editor);
		}
		if(Utils.VIEW_IS_OPEN.equals(featureName)) {
			return getEditorIsOpen(editor);
		}
		if(Utils.VIEW_EDITOR_TYPE.equals(featureName)) {
			return getEditorType(editor);
		}
		return NOT_AVALAIBLE;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 *         <code>true</code> excepted if the edited feature is isOpen
	 */
	public boolean isCellEditable(Object obj1, Object obj2) {
		final List<Object> objects = organizeObject(obj1, obj2);
		final String featureName = ((String)objects.get(1)).replace(Utils.NATTABLE_EDITOR_PAGE_ID, ""); //$NON-NLS-1$
		return featureName.equals(Utils.VIEW_NAME);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getSetValueCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object)
	 * 
	 * @param domain
	 * @param obj1
	 * @param obj2
	 * @param newValue
	 * @return
	 */
	public Command getSetValueCommand(EditingDomain domain, Object obj1, Object obj2, Object newValue) {
		final List<Object> objects = organizeObject(obj1, obj2);
		if(objects.get(0) instanceof EObject) {
			final EObject editor = (EObject)objects.get(0);
			final String featureName = ((String)objects.get(1)).replace(Utils.NATTABLE_EDITOR_PAGE_ID, ""); //$NON-NLS-1$
			if(Utils.VIEW_NAME.equals(featureName)) {
				EStructuralFeature feature = editor.eClass().getEStructuralFeature(Utils.VIEW_NAME);
				final AbstractEditCommandRequest request = new SetRequest((TransactionalEditingDomain)domain, editor, feature, newValue);
				final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(editor);
				return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
			}
		}
		return null;
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the type of the editor
	 */
	protected Object getEditorType(final Object editor) {
		if(editor instanceof EObject) {
			if(editor instanceof Table) {
				return ((Table)editor).getTableConfiguration().getType();
			} else {
				EStructuralFeature feature = ((EObject)editor).eClass().getEStructuralFeature(Utils.VIEW_EDITOR_TYPE);
				if(feature != null) {
					return ((EObject)editor).eGet(feature);
				}
			}
		}
		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @param editor
	 *        the editor
	 * @return
	 *         <code>true</code> if the current editor is open
	 */
	protected Object getEditorIsOpen(final Object editor) {
		if(editor instanceof EObject) {
			IPageManager mngr = null;
			try {
				mngr = ServiceUtilsForResource.getInstance().getIPageManager(((EObject)editor).eResource());
				return mngr.isOpen(editor);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}

		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the name of the editor
	 */
	protected Object getEditorName(final Object editor) {
		if(editor instanceof EObject) {
			if(editor instanceof EObject) {
				final EObject eobject = (EObject)editor;
				EStructuralFeature feature = eobject.eClass().getEStructuralFeature(Utils.VIEW_NAME);
				if(feature != null) {
					return eobject.eGet(feature);
				}
			}
		}
		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @param editor
	 *        the editor
	 * @return
	 *         the context of this editor
	 */
	protected Object getEditorContext(final Object editor) {
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
		return NOT_AVALAIBLE;
	}

}
