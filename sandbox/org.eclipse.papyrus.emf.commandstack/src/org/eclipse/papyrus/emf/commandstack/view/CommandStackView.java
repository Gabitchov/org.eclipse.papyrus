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
package org.eclipse.papyrus.emf.commandstack.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.facet.common.ui.internal.views.AbstractTreeView;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;

public class CommandStackView extends AbstractTreeView {

	private final int maxSize = 25;

	private final IOperationHistory history;

	private final List<IUndoableOperation> commandList = new ArrayList<IUndoableOperation>();

	private final Map<IUndoableOperation, String> dates = new HashMap<IUndoableOperation, String>();

	private final IOperationHistoryListener historyListener;

	public CommandStackView() {
		this.history = OperationHistoryFactory.getOperationHistory();
		this.history.addOperationHistoryListener(historyListener = new IOperationHistoryListener() {

			public void historyNotification(final OperationHistoryEvent event) {
				if(!CommandStackView.this.commandList.contains(event.getOperation())) {
					if(CommandStackView.this.commandList.size() == CommandStackView.this.maxSize) {
						IUndoableOperation removedOperation = CommandStackView.this.commandList.remove(CommandStackView.this.maxSize - 1);
						dates.remove(removedOperation);
					}

					CommandStackView.this.commandList.add(0, event.getOperation());
					final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
					final Calendar cal = Calendar.getInstance();
					CommandStackView.this.dates.put(event.getOperation(), dateFormat.format(cal.getTime()));
					refresh(true);
				}
			}
		});
	}

	private boolean isValidUndoContext(IUndoableOperation operation) {
		for(IUndoContext undoContext : operation.getContexts()) {
			if(undoContext instanceof EditingDomainUndoContext) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected void createColumns() {
		createNameColumn();
		createDescriptionColumn();
		createCommandTypeColumn();
		createTimeColumn();
		createUndoContextColumn();
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
				return "Clear the view";
			}

		});
	}

	private void createCommandTypeColumn() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(final Object element) {
				return element.getClass().getName();
			}
		};
		createColumn("Type", "TYPE_COLUMN_ID", 200, columnLabelProvider);
	}

	protected void createNameColumn() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(final Object element) {
				if(element instanceof AbstractOperation) {
					return ((AbstractOperation)element).getLabel();
				} else if(element instanceof AbstractCommand) {
					return ((AbstractCommand)element).getLabel();
				} else if(element instanceof org.eclipse.gef.commands.Command) {
					return ((org.eclipse.gef.commands.Command)element).getLabel();
				}
				return "no managed";
			}
		};
		createColumn("Name", "NAME_COLUMN_ID", 200, columnLabelProvider);
	}

	protected void createUndoContextColumn() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(final Object element) {
				if(element instanceof IUndoableOperation) {
					return Boolean.toString(isValidUndoContext((IUndoableOperation)element));
				}
				return "?";
			}
		};
		createColumn("EMF Command Stack", "UNDO_CONTEXT_COLUMN_ID", 100, columnLabelProvider);
	}

	protected void createDescriptionColumn() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(final Object element) {
				if(element instanceof AbstractCommand) {
					return ((AbstractCommand)element).getDescription();
				}
				return "no description";
			}
		};
		createColumn("Description", "DESCRIPTION_COLUMN_ID", 150, columnLabelProvider);
	}

	protected void createTimeColumn() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(final Object element) {
				if(CommandStackView.this.dates.containsKey(element)) {
					return CommandStackView.this.dates.get(element);
				}
				return "";
			}
		};
		createColumn("Time", "TIME_COLUMN_ID", 100, columnLabelProvider);
	}

	@Override
	protected IContentProvider getContentProvider() {
		return new ITreeContentProvider() {

			public Object[] getElements(final Object inputElement) {
				if(inputElement instanceof Command) {
					return new Object[]{ inputElement };
				} else if(inputElement instanceof Collection<?>) {
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
				return getChildren(element).length != 0;
			}

			public Object getParent(final Object element) {
				return null;
			}

			public Object[] getChildren(final Object parentElement) {
				if(parentElement instanceof CompoundCommand) {
					return ((CompoundCommand)parentElement).getCommandList().toArray();
				} else if(parentElement instanceof CompositeCommand) {
					final List<Object> children = new ArrayList<Object>();
					final ListIterator<Object> iter = ((CompositeCommand)parentElement).listIterator();
					while(iter.hasNext()) {
						children.add(iter.next());
					}
					return children.toArray();
				} else if(parentElement instanceof EMFCommandOperation) {
					final List<Object> children = new ArrayList<Object>();
					children.add(((EMFCommandOperation)parentElement).getCommand());
					return children.toArray();
				} else if(parentElement instanceof GMFtoEMFCommandWrapper) {
					return new Object[]{ ((GMFtoEMFCommandWrapper)parentElement).getGMFCommand() };
				} else if(parentElement instanceof GEFtoEMFCommandWrapper) {
					return new Object[]{ ((GEFtoEMFCommandWrapper)parentElement).getGEFCommand() };
				} else if(parentElement instanceof CommandProxy) {
					return new Object[]{ ((CommandProxy)parentElement).getCommand() };
				} else if(parentElement instanceof org.eclipse.gef.commands.CompoundCommand) {
					return ((org.eclipse.gef.commands.CompoundCommand)parentElement).getChildren();
				}
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
		return "Refresh CommandStack View";
	}

	private Object result[];// = new Object[1];

	@Override
	protected Object getInput() {
		return this.commandList;
	}

	@Override
	public void dispose() {
		super.dispose();
		history.removeOperationHistoryListener(historyListener);
		clear();
	}

	private void clear() {
		this.commandList.clear();
		this.dates.clear();
	}

}
