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
package org.eclipse.papyrus.infra.emf.compare.ui.content.transactional.viewer;


import org.eclipse.compare.CompareConfiguration;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.ui.internal.ModelComparator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.ui.actions.RedoActionWrapper;
import org.eclipse.emf.workspace.ui.actions.UndoActionWrapper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.papyrus.infra.emf.compare.diff.merge.ITransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeFactory;
import org.eclipse.papyrus.infra.emf.compare.ui.content.viewer.PapyrusCustomizableModelContentMergeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This viewer adds the Undo/Redo after a merge action
 * 
 * 
 */
public class PapyrusTransactionalModelContentMergeViewer extends PapyrusCustomizableModelContentMergeViewer {

	private IAction _copyDiffLeftToRight;

	private IAction _copyDiffRightToLeft;

	private IAction _copyAllLeftToRight;

	private IAction _copyAllRightToLeft;

	private static final String COPY_ALL_RIGHT_TO_LEFT = "org.eclipse.compare.copyAllRightToLeft";

	private static final String COPY_ALL_LEFT_TO_RIGHT = "org.eclipse.compare.copyAllLeftToRight";

	private static final String COPY_CURRENT_SELECTION_LEFT_TO_RIGHT = "Copy Current Change to Right";

	private static final String COPY_CURRENT_SELECTION_RIGHT_TO_LEFT = "Copy Current Change to Left";

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param config
	 */
	public PapyrusTransactionalModelContentMergeViewer(final Composite parent, final CompareConfiguration config, final IEditorPart editor) {
		super(parent, config, editor);
	}

	/**
	 * 
	 * {@inheritDoc} Add a toogle button to the toolbar to do the synchronization with the diagram
	 * 
	 * @param tbm
	 *        the toolbar manager
	 */
	@Override
	protected void createToolItems(final ToolBarManager tbm) {
		super.createToolItems(tbm);
		final Action undoAction = getUndoAction();
		final Action redoAction = getRedoAction();
		tbm.insert(0, new ActionContributionItem(undoAction));
		tbm.insert(1, new ActionContributionItem(redoAction));

		tbm.insert(2, new Separator("undo_redo_group")); //$NON-NLS-1$

		initializeIActionField(tbm);
	}

	protected Action getUndoAction() {
		final UndoActionWrapper undoAction = new UndoActionWrapper();

		//we need that the editor will be created to get it and initialize the actions
		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				undoAction.setActiveWorkbenchPart(editorPart);

			}
		});

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));

		return undoAction;
	}

	protected Action getRedoAction() {
		final RedoActionWrapper redoAction = new RedoActionWrapper();

		//we need that the editor will be created to get it and initialize the actions
		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				redoAction.setActiveWorkbenchPart(editorPart);
			}
		});

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
		return redoAction;
	}



	private void initializeIActionField(final ToolBarManager tbm) {
		for(IContributionItem item : tbm.getItems()) {
			if(item instanceof ActionContributionItem) {
				IAction action = ((ActionContributionItem)item).getAction();
				final String id = action.getActionDefinitionId();
				final String txt = action.getText();
				if(COPY_ALL_LEFT_TO_RIGHT.equals(id)) {
					_copyAllLeftToRight = action;
					continue;
				} else if(COPY_ALL_RIGHT_TO_LEFT.equals(id)) {
					_copyAllRightToLeft = action;
					continue;
				}
				//TODO post a bug to EMF-Compare in order to have an id for these actions
				if(COPY_CURRENT_SELECTION_LEFT_TO_RIGHT.equals(txt)) {
					_copyDiffLeftToRight = action;
					continue;
				} else if(COPY_CURRENT_SELECTION_RIGHT_TO_LEFT.equals(txt)) {
					_copyDiffRightToLeft = action;
					continue;
				}
			}
			if(_copyAllLeftToRight != null && _copyAllRightToLeft != null && _copyDiffLeftToRight != null && _copyDiffRightToLeft != null) {
				break;
			}
		}
	}

	@Override
	protected void switchCopyState(boolean enabled) {
		final ModelComparator comparator = ModelComparator.getComparator(configuration);

		boolean leftEditable = configuration.isLeftEditable();
		if(comparator != null)
			leftEditable = leftEditable && !comparator.isLeftRemote();
		boolean rightEditable = configuration.isRightEditable();
		if(comparator != null)
			rightEditable = rightEditable && !comparator.isRightRemote();

		boolean canCopyLeftToRight = false;
		boolean canCopyRightToLeft = false;

		boolean canAllCopyLeftToRight = true;
		boolean canAllCopyRightToLeft = true;

		if(currentSelection.size() == 1) {
			final ITransactionalMerger merger = TransactionalMergeFactory.createMerger(currentSelection.get(0));
			canCopyLeftToRight = merger.canUndoInTarget();
			canCopyRightToLeft = merger.canApplyInOrigin();
		}

		if(currentSelection.size() > 0) {
			EObject diffModel = currentSelection.get(0);
			while(!(diffModel instanceof DiffModel)) {
				diffModel = diffModel.eContainer();
			}
			Assert.isNotNull(diffModel);

			for(DiffElement current : ((DiffModel)diffModel).getDifferences()) {
				final ITransactionalMerger merger = TransactionalMergeFactory.createMerger(current);
				canAllCopyLeftToRight = canAllCopyLeftToRight && merger.canUndoInTarget();
				canAllCopyRightToLeft = canAllCopyRightToLeft && merger.canApplyInOrigin();
			}
		}

		if(_copyAllLeftToRight != null) {
			_copyAllLeftToRight.setEnabled(rightEditable && enabled && canAllCopyLeftToRight);
		}
		if(_copyAllRightToLeft != null) {
			_copyAllRightToLeft.setEnabled(leftEditable && enabled && canAllCopyRightToLeft);
		}
		if(_copyDiffLeftToRight != null) {
			_copyDiffLeftToRight.setEnabled(rightEditable && enabled && canCopyLeftToRight);
		}
		if(_copyDiffRightToLeft != null) {
			_copyDiffRightToLeft.setEnabled(leftEditable && enabled && canCopyRightToLeft);
		}
	}
}
