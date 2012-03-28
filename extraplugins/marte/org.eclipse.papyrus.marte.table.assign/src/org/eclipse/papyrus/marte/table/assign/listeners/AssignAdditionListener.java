/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.marte.table.assign.listeners;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Column;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.DefaultLabelColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.EContainerColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.MetaClassColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Row;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.diagram.common.listeners.AbstractPapyrusModifcationTriggerListener;
import org.eclipse.uml2.uml.Comment;

/**
 * Class used to hide useless columns in the assign table.
 * 
 * @author omelois
 * 
 */
public class AssignAdditionListener extends AbstractPapyrusModifcationTriggerListener {

	@Override
	public NotificationFilter getFilter() {
		return NotificationFilter.createEventTypeFilter(Notification.ADD).and(new NotificationFilter.Custom() {

			@Override
			public boolean matches(Notification notification) {
				Object newValue = notification.getNewValue();
				if(newValue instanceof Row) {
					Row row = (Row)newValue;
					if(row.getElement() instanceof Comment) {
						Comment c = (Comment)row.getElement();
						return c.isStereotypeApplied(c.getApplicableStereotype("MARTE::MARTE_Foundations::Alloc::Assign"));
					}
				}
				return false;
			}
		}).and(NotificationFilter.createFeatureFilter(TableinstancePackage.Literals.TABLE_INSTANCE__ROWS));
	}

	@Override
	protected CompositeCommand getModificationCommand(Notification notification) {
		CompositeCommand cc = new CompositeCommand("Hide useless columns composite command");
		final Object newValue = notification.getNewValue();
		//BEGINNING OF HIDE_COLUMNS_COMMAND
		AbstractTransactionalCommand hideColumnsCommand = new AbstractTransactionalCommand(getTarget(), "Hide useless columns", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				//Getting the columns of the tables that the row is taken from.
				//Irrelevant columns will be hidden. In addition, the "to" and "from" columns 
				//might switch places.
				if(newValue instanceof Row) {
					Row row = (Row)newValue;
					if(row.eContainer() instanceof TableInstance) {
						TableInstance tableInstance = (TableInstance)row.eContainer();
						EList<Column> columns = tableInstance.getColumns();

						//The "from" and the "to" columns are switched if "to" appears before "from"
						int toColumnIndex = -1;
						int fromColumnIndex = -1;
						Column fromColumn = null;

						for(int index = 0; index < columns.size(); index++) {
							Column current = columns.get(index);
							//These three are the columns that cannot be hidden with the customUI configuration file.
							if(current instanceof DefaultLabelColumn || current instanceof MetaClassColumn || current instanceof EContainerColumn) {
								current.setIsHidden(true);
							}
							if(current instanceof FacetReferenceColumn) {
								FacetReferenceColumn facetReferenceColumn = (FacetReferenceColumn)current;
								String columnName = facetReferenceColumn.getReference().getName();
								if(columnName.equals("to")) { //$NON-NLS-1$
									toColumnIndex = index;
								}
								if(columnName.equals("from")) { //$NON-NLS-1$
									fromColumnIndex = index;
									fromColumn = current;
								}
							}
						}
						//Switching "from" and "to" if needed.
						if(toColumnIndex < fromColumnIndex && fromColumn != null) {
							columns.move(toColumnIndex, fromColumn);
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
		//END OF HIDE_COLUMNS_COMMAND

		cc.compose(hideColumnsCommand);
		return cc;
	}


}
