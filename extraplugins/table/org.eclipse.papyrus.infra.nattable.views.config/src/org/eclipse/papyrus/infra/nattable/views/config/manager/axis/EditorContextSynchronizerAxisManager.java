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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager;
import org.eclipse.papyrus.infra.nattable.views.config.utils.Utils;

/**
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EditorContextSynchronizerAxisManager extends AbstractSynchronizedOnFeatureAxisManager {

	/**
	 * we keep it to be able to remove the listener during the destruction of the table
	 */
	private PageList pageList;


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
		getPageList().eAdapters().add(this.featureListener);
	}

	private PageList getPageList() {
		if(this.pageList == null) {
			this.pageList = Utils.getPageList(getTableManager().getTable());
		}
		return this.pageList;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager#verifyValues()
	 * 
	 */
	@Override
	protected void verifyValues() {
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
		final Object value = Utils.getEditorContext(page);
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
		if(getPageList() != null) {
			getPageList().eAdapters().remove(this.featureListener);
		}
		this.pageList = null;
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

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canEditAxisHeader()
	 * 
	 * @return
	 */
	@Override
	public boolean canEditAxisHeader() {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDestroyAxisElement(java.lang.Integer)
	 * 
	 * @param axisPosition
	 * @return
	 */
	@Override
	public boolean canDestroyAxisElement(Integer axisPosition) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisElementCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Integer)
	 * 
	 * @param domain
	 * @param axisPosition
	 * @return
	 */
	@Override
	public Command getDestroyAxisElementCommand(EditingDomain domain, Integer axisPosition) {
		return UnexecutableCommand.INSTANCE;
	}

}
