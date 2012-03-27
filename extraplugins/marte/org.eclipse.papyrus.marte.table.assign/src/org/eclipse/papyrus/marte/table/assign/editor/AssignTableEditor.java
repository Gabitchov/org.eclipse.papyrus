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

package org.eclipse.papyrus.marte.table.assign.editor;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Column;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.DefaultLabelColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.EContainerColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.MetaClassColumn;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.table.common.editor.AbstractNattableEditor;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * The assignment table editor
 * 
 */
public class AssignTableEditor extends AbstractNattableEditor {
	
	public static final String EDITOR_TYPE = "PapyrusAssignTable"; //$NON-NLS-1$

	public static final String DEFAULT_NAME = "AssignTable"; //$NON-NLS-1$
	
	public AssignTableEditor(ServicesRegistry servicesRegistry, PapyrusTableInstance rawModel) {
		super(servicesRegistry, rawModel);
	}
	
	/**
	 * Override to add the already existing comments.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		//Adding all the comments that have the "assign" stereotype to the table.
		EObject eContainer = rawModel.getTable().getContext();
		Package pack = (Package)eContainer;
		EList<Comment> comments = pack.getOwnedComments();
		
		//Filtering the comments that have the assign stereotype.
		Predicate<Comment> filterAssign = new Predicate<Comment>() {
			public boolean apply(Comment comment) {
				Stereotype stereotype = comment.getAppliedStereotype("MARTE::MARTE_Foundations::Alloc::Assign"); //$NON-NLS-1$
				return stereotype != null;
			};
		};
		Iterable<Comment> sortedComments = Iterables.filter(comments, filterAssign);
		List sortedCommentsList = Lists.newArrayList(sortedComments);
		this.addRows(sortedCommentsList);
		
		
		//Hiding useless columns.
		final EList<Column> columns = this.rawModel.getTable().getColumns();
		EditingDomain domain = getEditingDomain();
		//Command used to change the model (here used to hide the columns not needed for the assign table)
		AbstractTransactionalCommand modifyAttribute = new AbstractTransactionalCommand((TransactionalEditingDomain)domain, "Hide columns", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				int toColumnIndex = -1;
				int fromColumnIndex = -1;
				Column toColumn = null;
				Column fromColumn = null;
				for(int index = 0; index <columns.size();index++) {
					Column current = columns.get(index);
					if(current instanceof DefaultLabelColumn || current instanceof MetaClassColumn || current instanceof EContainerColumn){
						current.setIsHidden(true);
					}
					if (current instanceof FacetReferenceColumn){
						FacetReferenceColumn facetReferenceColumn = (FacetReferenceColumn) current;
						String columnName = facetReferenceColumn.getReference().getName();
						if (columnName.equals("to")){ //$NON-NLS-1$
							toColumnIndex = index;
							toColumn = current;
						}
						if (columnName.equals("from")){
							fromColumnIndex = index;
							fromColumn = current;
						}
					}
				}
				//Switching "from" and "to" if needed.
				if (toColumnIndex < fromColumnIndex && toColumn != null && fromColumn != null){
					columns.move(toColumnIndex, fromColumn);
				}
				
				return CommandResult.newOKCommandResult();
			}
		};
		//Command execution
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(modifyAttribute));
		
	}

	
}
