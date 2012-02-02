/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.action.IAction;
import org.eclipse.team.internal.ui.actions.TeamAction;

/**
 * Action to compare two arbitrary elements.
 * Availbale in the context menu of the model explorer.
 */
public class CompareTwoElementsAction extends TeamAction {

	@Override
	protected void execute(IAction action) throws InvocationTargetException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

//	/* (non-Javadoc)
//	 * @see org.eclipse.team.internal.ui.actions.TeamAction#execute(org.eclipse.jface.action.IAction)
//	 */
//	protected void execute(IAction action) throws InvocationTargetException, InterruptedException {
//
//		Object[] selectedElements = getSelection().toArray();
//		if(selectedElements.length != 2) {
////			Activator.logInfo(Messages.bind(Messages.CompareTwoElementsAction_only_only_element_is_selected, selectedElements.length));
//			return;
//		}
//
//		EObject left = getElementFor(selectedElements[0]);
//		EObject right = getElementFor(selectedElements[1]);
//		if(left == null) {
////			Activator.logInfo(Messages.CompareTwoElementsAction_left_element_is_null);
//			return;
//		}
//
//		if(right == null) {
////			Activator.logInfo(Messages.CompareTwoElementsAction_right_element_is_null);
//			return;
//		}
//
//		ComparisonResourceSnapshot snapshot = doContentCompare(left, right);
//		openInCompare(snapshot);
//	}
//
//	/* (non-Javadoc)
//	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
//	 */
//	public boolean isEnabled() {
//		Object[] selectedElements = getSelection().toArray();
//		if(selectedElements.length != 2) {
//			return false;
//		}
//		EObject left = getElementFor(selectedElements[0]);
//		EObject right = getElementFor(selectedElements[1]);
//		return left != null && right != null;
//	}
//
//	/**
//	 * Open in compare.
//	 *
//	 * @param snapshot the snapshot
//	 */
//	private void openInCompare(ComparisonSnapshot snapshot) {
//		CompareUI.openCompareEditor(new ModelCompareEditorInput(snapshot) {
//
//			@Override
//			protected ModelContentMergeViewer createMergeViewer(CompareViewerPane pane, CompareConfiguration config) {
//				return new UMLModelContentMergeViewer(pane, config) {
//					@Override
//					protected IMergeViewerContentProvider createMergeViewerContentProvider() {
//						return new ElementContentMergeContentProvider(configuration);
//					}
//				};
//			}
//
//			@Override
//			public Control createOutlineContents(Composite parent, int direction) {
//				Control result = super.createOutlineContents(parent, direction);
//				structureMergeViewer.setLabelProvider(new UMLStyledStructureLabelProvider(new PapyrusLabelProvider()));
//				return result;
//			}
//
//		});
//	}
//
//	/**
//	 * Do content compare.
//	 *
//	 * @param left the left
//	 * @param right the right
//	 * @return the comparison resource snapshot
//	 */
//	protected ComparisonResourceSnapshot doContentCompare(final EObject left, final EObject right) {
//		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();
//
//		try {
//			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {
//
//				public void run(IProgressMonitor monitor) throws InterruptedException {
//					final MatchModel match = contentMatch(left, right, monitor);
//					final DiffModel diff = contentDiff(left, right, match);
//
//					snapshot.setDiff(diff);
//					snapshot.setMatch(match);
//				}
//
//			});
//		} catch (final InterruptedException e) {
//			Activator.logError(e);
//		} catch (final EMFCompareException e) {
//			Activator.logError(e);
//		} catch (final InvocationTargetException e) {
//			Activator.logError(e);
//		}
//		return snapshot;
//	}
//
//	/**
//	 * Content diff.
//	 *
//	 * @param left the left
//	 * @param right the right
//	 * @param match the match
//	 * @return the diff model
//	 */
//	protected DiffModel contentDiff(final EObject left, final EObject right, final MatchModel match) {
//		ElementContentDiffEngine engine = new ElementContentDiffEngine(left, right);
//		final DiffModel diff = engine.doDiff(match);
//		final Collection<AbstractDiffExtension> extensions = DiffService.getCorrespondingDiffExtensions(match);
//		for(final AbstractDiffExtension ext : extensions) {
//			if(ext != null) {
//				ext.visit(diff);
//			}
//		}
//
//		engine.reset();
//		return diff;
//	}
//
//	/**
//	 * Content match.
//	 *
//	 * @param left the left
//	 * @param right the right
//	 * @param monitor the monitor
//	 * @return the match model
//	 * @throws InterruptedException the interrupted exception
//	 */
//	protected MatchModel contentMatch(final EObject left, final EObject right, IProgressMonitor monitor) throws InterruptedException {
//		final Map<String, Object> options = new EMFCompareMap<String, Object>();
//		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
//		options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left.eResource(), right.eResource()));
//		options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
//		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
//
//		final IMatchEngine matchEngine = new ElementContentMatchEngine(left, right);
//		final MatchModel match = matchEngine.contentMatch(left, right, options);
//		return match;
//	}
//
//	/**
//	 * Gets the element for.
//	 *
//	 * @param object the object
//	 * @return the element for
//	 */
//	protected EObject getElementFor(Object object) {
//		if(object instanceof IAdaptable) {
//			return (EObject)((IAdaptable)object).getAdapter(EObject.class);
//		}
//
//		if(object instanceof EObject) {
//			return (EObject)object;
//		}
//		return null;
//	}

}
