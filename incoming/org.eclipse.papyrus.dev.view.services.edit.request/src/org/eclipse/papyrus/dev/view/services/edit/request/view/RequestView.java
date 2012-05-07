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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.dev.view.services.edit.request.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.facet.common.ui.internal.views.AbstractTreeView;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.dev.view.services.edit.request.messages.Messages;

public class RequestView extends AbstractTreeView {

	private final List<IEditCommandRequest> requestList;

	private final Map<IEditCommandRequest, String> dates;

	public static RequestView INSTANCE = null;

	public RequestView() {
		RequestView.INSTANCE = this;
		this.requestList = new ArrayList<IEditCommandRequest>();
		this.dates = new HashMap<IEditCommandRequest, String>();
	};

	@Override
	protected void createColumns() {
		createNameRequestColumn();
		createTimeColumn();
	}

	public void addRequest(final IEditCommandRequest request) {
		if(!this.requestList.contains(request)) {
			this.requestList.add(request);
			final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss"); //$NON-NLS-1$
			final Calendar cal = Calendar.getInstance();
			this.dates.put(request, dateFormat.format(cal.getTime()));
			this.refresh(true);
		}
	}

	@Override
	public void createPartControl(final org.eclipse.swt.widgets.Composite parent) {
		super.createPartControl(parent);
		final IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
		tbm.add(new Action() {

			@Override
			public void run() {
				clear();
				refresh(true);
			}

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public String getToolTipText() {
				return getText();
			}

			@Override
			public String getText() {
				return Messages.RequestView_ClearTheView;
			}

		});
	}

	protected void createNameRequestColumn() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(final Object element) {
				if(element instanceof IEditCommandRequest) {
					return element.getClass().getSimpleName();
				}
				if(element instanceof AbstractOperation) {
					return ((AbstractOperation)element).getLabel();
				} else if(element instanceof AbstractCommand) {
					return ((AbstractCommand)element).getLabel();
				}
				return "no managed"; //$NON-NLS-1$
			}
		};
		createColumn(Messages.RequestView_Name, "NAME_COLUMN_ID", 200, columnLabelProvider); //$NON-NLS-2$
	}

	protected void createTimeColumn() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(final Object element) {
				if(RequestView.this.dates.containsKey(element)) {
					return RequestView.this.dates.get(element);
				}
				return ""; //$NON-NLS-1$
			}
		};
		createColumn(Messages.RequestView_Time, "TIME_COLUMN_ID", 100, columnLabelProvider); //$NON-NLS-2$
	}

	@Override
	protected IContentProvider getContentProvider() {
		return new ITreeContentProvider() {

			public Object[] getElements(final Object inputElement) {
				if(inputElement instanceof Collection<?>) {
					return ((Collection<?>)inputElement).toArray();
				}
				return new Object[0];

			}

			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
				// nothing
			}

			public void dispose() {
				// nothing
			}

			public boolean hasChildren(final Object element) {
				return false;
			}

			public Object getParent(final Object element) {
				return null;
			}

			public Object[] getChildren(final Object parentElement) {
				return new Object[0];
			}
		};
	}

	@Override
	protected void openElement(final Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getRefreshMessage() {
		return "Refresh Requests View"; //$NON-NLS-1$
	}


	@Override
	protected Object getInput() {
		return this.requestList;
	}

	@Override
	public void dispose() {
		super.dispose();
		clear();
		RequestView.INSTANCE = null;
	}

	private void clear() {
		this.requestList.clear();
		this.dates.clear();
	}

}
