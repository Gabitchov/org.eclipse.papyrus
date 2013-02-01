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
package org.eclipse.papyrus.uml.compare.subelement.viewer;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.uml.compare.content.viewer.UMLTransactionalModelContentMergeViewer;
import org.eclipse.papyrus.uml.compare.utils.RootObject;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


public class UMLTransactionalModelContentMergeViewerWithTwoEditingDomain extends UMLTransactionalModelContentMergeViewer {

	/**
	 * the command stack used by the left object
	 */
	private CommandStack leftStack;

	/**
	 * the command stack used by the right object
	 */
	private CommandStack rightStack;

	/**
	 * the fifo storing the calls to the commandstack
	 */
	private final List<CommandStack> executedCommandStackFifo;

	/**
	 * the fifo storing the calls to the undo action
	 */
	private final List<CommandStack> undoneCommandStackFifo;

	/**
	 * the undo action
	 */
	private RedoAction redoAction;

	/**
	 * the redo action
	 */
	private UndoAction undoAction;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param config
	 * @param editor
	 */
	public UMLTransactionalModelContentMergeViewerWithTwoEditingDomain(Composite parent, CompareConfiguration config, IEditorPart editor) {
		super(parent, config, editor);
		executedCommandStackFifo = new ArrayList<CommandStack>();
		undoneCommandStackFifo = new ArrayList<CommandStack>();
		final Object left = configuration.getProperty(RootObject.LEFT_OBJECT_KEY);
		assert left instanceof EObject;
		leftStack = TransactionUtil.getEditingDomain((EObject)left).getCommandStack();

		final Object right = configuration.getProperty(RootObject.RIGHT_OBJECT_KEY);
		assert right instanceof EObject;
		rightStack = TransactionUtil.getEditingDomain((EObject)right).getCommandStack();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.ui.content.viewer.PapyrusCustomizableModelContentMergeViewer#handleDispose(org.eclipse.swt.events.DisposeEvent)
	 * 
	 * @param event
	 */
	@Override
	protected void handleDispose(DisposeEvent event) {
		super.handleDispose(event);
		executedCommandStackFifo.clear();
		undoneCommandStackFifo.clear();
		leftStack = null;
		rightStack = null;
	}



	protected Action getUndoAction() {
		undoAction = new CustomUndoAction();
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
		undoAction.update();
		return undoAction;
	}

	@Override
	protected void copyDiffLeftToRight() {
		super.copyDiffLeftToRight();
		executedCommandStackFifo.add(0, rightStack);
		undoneCommandStackFifo.clear();
		redoAction.update();
		undoAction.update();

	}

	@Override
	protected void copyDiffRightToLeft() {
		super.copyDiffRightToLeft();
		executedCommandStackFifo.add(0, leftStack);
		undoneCommandStackFifo.clear();
		redoAction.update();
		undoAction.update();
	}




	@Override
	protected Action getRedoAction() {
		redoAction = new CustomRedoAction();
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
		redoAction.update();
		return redoAction;
	};


	/**
	 * 
	 * the custom undo action to manage 2 editing domain
	 * 
	 */
	public class CustomUndoAction extends UndoAction {

		@Override
		public void run() {
			if(executedCommandStackFifo.size() != 0) {
				final CommandStack cmd = executedCommandStackFifo.remove(0);
				cmd.undo();
				undoneCommandStackFifo.add(0, cmd);
				redoAction.update();
				undoAction.update();

			}
		}

		@Override
		public void update() {
			boolean value = false;
			if(executedCommandStackFifo != null) {
				value = !executedCommandStackFifo.isEmpty();
			}
			setEnabled(value);
		}


	}

	/**
	 * 
	 * The custom redo action to manage 2 editing domains
	 * 
	 */
	public class CustomRedoAction extends RedoAction {

		@Override
		public void run() {
			if(undoneCommandStackFifo.size() != 0) {
				final CommandStack cmd = undoneCommandStackFifo.remove(0);
				cmd.redo();
				executedCommandStackFifo.add(0, cmd);
				redoAction.update();
				undoAction.update();

			}
		}

		@Override
		public void update() {
			boolean value = false;
			if(undoneCommandStackFifo != null) {
				value = !undoneCommandStackFifo.isEmpty();
			}
			setEnabled(value);
		}

	}


}
