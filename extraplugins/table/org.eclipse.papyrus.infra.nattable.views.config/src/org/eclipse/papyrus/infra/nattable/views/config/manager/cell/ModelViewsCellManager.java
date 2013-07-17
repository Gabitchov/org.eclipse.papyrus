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
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
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
	 * 
	 * @param columnElement
	 *        the column element
	 * @param rowElement
	 *        the row element
	 * @return <code>null</code> or a list of 2 objects.
	 *         <ul>
	 *         <li>the first element is the edited EObject</li>
	 *         <li>the second one is the edited feature</li>
	 *         </ul>
	 * 
	 */
	protected List<Object> organizeAndResolvedObjects(final Object columnElement, final Object rowElement) {
		final List<Object> objects = new ArrayList<Object>();
		Object row = AxisUtils.getRepresentedElement(rowElement);
		Object column = AxisUtils.getRepresentedElement(columnElement);
		if(row instanceof String && ((String)row).startsWith(Utils.NATTABLE_EDITOR_PAGE_ID) && column instanceof EObject) {
			objects.add(column);
			objects.add(row);
		} else if(column instanceof String && ((String)column).startsWith(Utils.NATTABLE_EDITOR_PAGE_ID) && row instanceof EObject) {
			objects.add(row);
			objects.add(column);
		}

		if(objects.size() == 2) {
			final EObject first = (EObject)objects.get(0);
			final IPageManager mngr = Utils.getIPagneManager(first);
			if((mngr != null && !mngr.allPages().contains(first)) || mngr == null) {
				return null;
			}
		}

		if(objects.size() == 2) {
			return objects;
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param rowElement
	 * @param columnElement
	 * @return
	 */
	public boolean handles(Object rowElement, Object columnElement) {
		return organizeAndResolvedObjects(columnElement, rowElement) != null;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager#doGetValue(java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 * @return
	 */
	@Override
	protected Object doGetValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement);
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
	 * @param rowElement
	 * @param columnElement
	 * @return
	 *         <code>true</code> excepted if the edited feature is isOpen
	 */
	public boolean isCellEditable(Object rowElement, Object columnElement) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement);
		final String featureName = ((String)objects.get(1)).replace(Utils.NATTABLE_EDITOR_PAGE_ID, ""); //$NON-NLS-1$
		return featureName.equals(Utils.VIEW_NAME);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager#getSetValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param manager
	 * @return
	 */
	@Override
	public Command getSetValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager manager) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement);
		final EObject editor = (EObject)objects.get(0);
		final String featureName = ((String)objects.get(1)).replace(Utils.NATTABLE_EDITOR_PAGE_ID, ""); //$NON-NLS-1$
		if(Utils.VIEW_NAME.equals(featureName)) {
			final EStructuralFeature feature = editor.eClass().getEStructuralFeature(Utils.VIEW_NAME);
			final AbstractEditCommandRequest request = new SetRequest((TransactionalEditingDomain)domain, editor, feature, newValue);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(editor);
			return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
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
				//				Activator.log.error(e);
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
		final Object result = Utils.getEditorContext(editor);
		if(result == null) {
			return NOT_AVALAIBLE;
		}
		return result;
	}

}
