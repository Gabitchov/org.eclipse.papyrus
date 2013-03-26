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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractSynchronizedOnFeatureAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.views.editor.utils.Utils;

/**
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EditorContextSynchronizerAxisManager extends AbstractSynchronizedOnFeatureAxisManager {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractSynchronizedOnFeatureAxisManager#init(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager,
	 *      java.lang.String, org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider, boolean)
	 * 
	 * @param manager
	 * @param managerId
	 * @param table
	 * @param provider
	 * @param mustRefreshOnAxisChanges
	 */
	@Override
	public void init(final INattableModelManager manager, final String managerId, final Table table, final AbstractAxisProvider provider, boolean mustRefreshOnAxisChanges) {
		super.init(manager, managerId, table, provider, mustRefreshOnAxisChanges);
		final PageList pageList = Utils.getPageList(getTable());
		this.featureListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if(msg.getFeature() == DiPackage.eINSTANCE.getPageList_AvailablePage()) {
					updateAxisContents();
					((NattableModelManager)getTableManager()).refreshNattable();
				}
			};
		};
		pageList.eAdapters().add(this.featureListener);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractSynchronizedOnFeatureAxisManager#verifyCoupleContextFeature()
	 * 
	 */
	@Override
	protected void verifyCoupleContextFeature() {
		//nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#updateAxisContents()
	 * 
	 */
	@Override
	public synchronized void updateAxisContents() {
		final PageList pageList = Utils.getPageList(getTable());
		final List<Object> elements = getTableManager().getElementsList(getRepresentedContentProvider());
		elements.clear();//FIXME risk of blinking with the glazed list!
		for(final PageRef ref : pageList.getAvailablePage()) {
			final Object page = ref.getPageIdentifier();
			if(mustBeDisplayedInThisTable(page)) {
				elements.add(page);
			}
		}
	}


	/**
	 * 
	 * @param page
	 *        a page
	 * @return
	 *         <code>true</code> if the page is referenced by a child of the context of the table or by the context itself
	 */
	private boolean mustBeDisplayedInThisTable(final Object page) {
		final Object value = CellManagerFactory.INSTANCE.getCrossValue(page, Utils.NATTABLE_EDITOR_PAGE_ID + Utils.VIEW_CONTEXT);
		if(value instanceof EObject) {
			final EObject tableContext = getTable().getContext();
			EObject container = (EObject)value;
			while(container != null) {
				if(container == tableContext) {
					return true;
				}
				container = container.eContainer();
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		final PageList pageList = Utils.getPageList(getTable());
		pageList.eAdapters().remove(this.featureListener);
	}

}
