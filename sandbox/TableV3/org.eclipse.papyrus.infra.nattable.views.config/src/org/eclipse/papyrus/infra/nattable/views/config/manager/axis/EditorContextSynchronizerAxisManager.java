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
package org.eclipse.papyrus.infra.nattable.views.config.manager.axis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.views.config.utils.Utils;

/**
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EditorContextSynchronizerAxisManager extends AbstractSynchronizedOnFeatureAxisManager {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager#addContextFeatureValueListener()
	 * 
	 */
	@Override
	protected void addContextFeatureValueListener() {
		this.featureListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if(msg.getFeature() == DiPackage.eINSTANCE.getPageList_AvailablePage()) {
					getTableManager().updateAxisContents(getRepresentedContentProvider());
				}
			}
		};
		final PageList pageList = Utils.getPageList(getTableManager().getTable());
		pageList.eAdapters().add(this.featureListener);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager#verifyCoupleContextFeature()
	 * 
	 */
	@Override
	protected void verifyCoupleContextFeature() {
		//nothing to do
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
			final EObject tableContext = getTableContext();
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		final PageList pageList = Utils.getPageList(getTableManager().getTable());
		pageList.eAdapters().remove(this.featureListener);
		super.dispose();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAllManagedAxis()
	 * 
	 * @return
	 */
	@Override
	public Collection<Object> getAllManagedAxis() {
		final PageList pageList = Utils.getPageList(getTableManager().getTable());
		final List<Object> elements = new ArrayList<Object>();
		elements.clear();
		for(final PageRef ref : pageList.getAvailablePage()) {
			final Object page = ref.getPageIdentifier();
			if(mustBeDisplayedInThisTable(page)) {
				elements.add(page);
			}
		}
		return elements;
	}

}
