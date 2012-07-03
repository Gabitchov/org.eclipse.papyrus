/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.internal.l10n.DiagramCoreMessages;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

public class ChangeParentCommand extends AbstractTransactionalCommand {

	private IAdaptable parent;

	private IAdaptable child;

	private int index;

	/**
	 * Creates a new <code>AddCommand</code>
	 * 
	 * @param editingDomain
	 *        the editing domain through which model changes are made
	 * @param parent
	 *        The parent view adapter
	 * @param child
	 *        The child view adapter
	 */
	public ChangeParentCommand(TransactionalEditingDomain editingDomain, IAdaptable parent, IAdaptable child) {
		this(editingDomain, parent, child, ViewUtil.APPEND);
	}

	/**
	 * Creates a new <code>AddCommand</code>
	 * 
	 * @param editingDomain
	 *        the editing domain through which model changes are made
	 * @param parent
	 *        The parent view adapter
	 * @param child
	 *        The child view adapter
	 * @param index
	 *        the child insertion index
	 */
	public ChangeParentCommand(TransactionalEditingDomain editingDomain, IAdaptable parent, IAdaptable child, int index) {
		super(editingDomain, DiagramCoreMessages.AddCommand_Label, null);
		assert null != parent : "Null parent in AddCommand";//$NON-NLS-1$
		assert null != child : "Null child in AddCommand";//$NON-NLS-1$		
		this.parent = parent;
		this.child = child;
		this.index = index;
	}

	public List getAffectedFiles() {
		View view = (View)parent.getAdapter(View.class);
		if(view != null) {
			List result = new ArrayList();
			IFile file = WorkspaceSynchronizer.getFile(view.eResource());
			if(file != null) {
				result.add(file);
			}
			return result;
		}
		return super.getAffectedFiles();
	}

	/**
	 * executes the command; which will get the child and the containaer from
	 * the <code>IAdaptable<code> and then insert the child at the given index
	 * in the containers child list.
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		/**
		 * Change graphical parent
		 */
		View childView = (View)child.getAdapter(View.class);
		View parentView = (View)parent.getAdapter(View.class);
		EObject oldParent = childView.eContainer();
		if(oldParent instanceof View) {
			((View)oldParent).removeChild(childView);
		}
		if(index == ViewUtil.APPEND)
			parentView.insertChild(childView);
		else
			parentView.insertChildAt(childView, index);
		/**
		 * Change coordiante
		 */
		Point childViewCoordinate = getLocation(childView);
		Point parentViewCoordinate = getLocation(parentView);
		ViewUtil.setStructuralFeatureValue(childView, NotationPackage.eINSTANCE.getLocation_X(), Integer.valueOf(110));
		ViewUtil.setStructuralFeatureValue(childView, NotationPackage.eINSTANCE.getLocation_Y(), Integer.valueOf(110));
		return CommandResult.newOKCommandResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.command.ICommand#getLabel()
	 */
	public String getLabel() {
		return DiagramCoreMessages.AddCommand_Label;
	}

	protected Point getAbsoluteLocation(View v) {
		Point result = getLocation(v);
		EObject container = v.eContainer();
		while(container instanceof View) {
			View parentView = (View)container;
			Point parentCoordinate = getLocation(parentView);
			if(parentCoordinate != null) {
				result.translate(parentCoordinate);
			}
			container = parentView.eContainer();
		}
		return result;
	}

	protected Point getLocation(View v) {
		Integer x = (Integer)ViewUtil.getStructuralFeatureValue(v, NotationPackage.eINSTANCE.getLocation_X());
		Integer y = (Integer)ViewUtil.getStructuralFeatureValue(v, NotationPackage.eINSTANCE.getLocation_Y());
		return new Point(x, y);
	}
}
