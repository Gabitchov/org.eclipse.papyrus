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
package org.eclipse.papyrus.infra.emf.compare.ui.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareUI;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.EMFCompareException;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.content.transactional.viewer.PapyrusTransactionalModelContentMergeViewer;
import org.eclipse.ui.PlatformUI;
//import org.eclipse.papyrus.compare.diff.extension.UMLStyledStructureLabelProvider;
//import org.eclipse.papyrus.compare.element.ElementContentDiffEngine;
//import org.eclipse.papyrus.compare.element.ElementContentMatchEngine;
//import org.eclipse.papyrus.compare.ui.Messages;
//import org.eclipse.papyrus.compare.ui.PapyrusLabelProvider;
//import org.eclipse.papyrus.compare.ui.viewer.content.ElementContentMergeContentProvider;
//import org.eclipse.papyrus.compare.ui.viewer.content.UMLModelContentMergeViewer;

/**
 * Action to compare two arbitrary elements.
 * Available in the context menu of the model explorer.
 */
//TODO : not used, remove it!
public class CompareTwoElementsAction extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.team.internal.ui.actions.TeamAction#execute(org.eclipse.jface.action.IAction)
	 */
	protected void execute(IAction action) throws InvocationTargetException, InterruptedException {
		Object[] selectedElements = getSelection().toArray();
		if(selectedElements.length != 2) {
			Activator.log.info("Two elements should be selected.");
		} else {
			EObject left = getElementFor(selectedElements[0]);
			EObject right = getElementFor(selectedElements[1]);
			if(left == null) {
				Activator.log.info("The left element is null. I can't do the comparison");
			} else if(right == null) {
				Activator.log.info("The right element is null. I can't do the comparison");
			} else {
				ComparisonResourceSnapshot snapshot = doContentCompare(left, right);
				openInCompare(snapshot);
			}
		}
	}

	private Collection<Object> getSelection() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		Collection<Object> currentSelection = new ArrayList<Object>();
		Iterator<?> iter = ((IStructuredSelection)selection).iterator();
		while(iter.hasNext()) {
			currentSelection.add(iter.next());
		}
		return currentSelection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 */
	public boolean isEnabled() {
		Object[] selectedElements = getSelection().toArray();
		if(selectedElements.length != 2) {
			return false;
		}
		EObject left = getElementFor(selectedElements[0]);
		EObject right = getElementFor(selectedElements[1]);
		return left != null && right != null;
	}

	/**
	 * Open in compare.
	 * 
	 * @param snapshot
	 *        the snapshot
	 */
	private void openInCompare(ComparisonSnapshot snapshot) {
		ModelCompareEditorInput model = null;

		CompareUI.openCompareEditor(new ModelCompareEditorInput(snapshot) {

			@Override
			protected ModelContentMergeViewer createMergeViewer(CompareViewerPane pane, CompareConfiguration config) {
				return new PapyrusTransactionalModelContentMergeViewer(pane, config);
			}
			//TODO : uncomment.
			//			@Override
			//			protected ModelContentMergeViewer createMergeViewer(CompareViewerPane pane, CompareConfiguration config) {
			//				return new PapyrusCustomizableModelContentMergeViewer(pane, config) {
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

		});
	}

	/**
	 * Do content compare.
	 * 
	 * @param left
	 *        the left
	 * @param right
	 *        the right
	 * @return the comparison resource snapshot
	 */
	protected ComparisonResourceSnapshot doContentCompare(final EObject left, final EObject right) {
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();

		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InterruptedException {
					//					final MatchModel match = MatchService.doContentMatch(left, right, options);
					//					DiffModel diff = DiffService.doDiff(match);
					final MatchModel match = contentMatch(left, right, monitor);
					final DiffModel diff = contentDiff(left, right, match);

					snapshot.setDiff(diff);
					snapshot.setMatch(match);

				}

			});
		} catch (final InterruptedException e) {
			Activator.log.error(e);
		} catch (final EMFCompareException e) {
			Activator.log.error(e);
		} catch (final InvocationTargetException e) {
			Activator.log.error(e);
		}

		return snapshot;
	}

	/**
	 * Content diff.
	 * 
	 * @param left
	 *        the left
	 * @param right
	 *        the right
	 * @param match
	 *        the match
	 * @return the diff model
	 */
	protected DiffModel contentDiff(final EObject left, final EObject right, final MatchModel match) {
		//TODO
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
		return null;
	}

	/**
	 * Content match.
	 * 
	 * @param left
	 *        the left
	 * @param right
	 *        the right
	 * @param monitor
	 *        the monitor
	 * @return the match model
	 * @throws InterruptedException
	 *         the interrupted exception
	 */
	protected MatchModel contentMatch(final EObject left, final EObject right, IProgressMonitor monitor) throws InterruptedException {
		//		final Map<String, Object> options = new EMFCompareMap<String, Object>();
		//		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		//		options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left.eResource(), right.eResource()));
		//		options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
		//		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
		//
		//		final IMatchEngine matchEngine = new ElementContentMatchEngine(left, right);
		//		final MatchModel match = matchEngine.contentMatch(left, right, options);
		//		return match;
		//TODO
		return null;
	}

	/**
	 * Gets the element for.
	 * 
	 * @param object
	 *        the object
	 * @return the element for
	 */
	protected EObject getElementFor(Object object) {
		if(object instanceof IAdaptable) {
			return (EObject)((IAdaptable)object).getAdapter(EObject.class);
		}

		if(object instanceof EObject) {
			return (EObject)object;
		}
		return null;
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object[] selectedElements = getSelection().toArray();
		if(selectedElements.length != 2) {
			//TODO
			//			Activator.logInfo(Messages.bind(Messages.CompareTwoElementsAction_only_only_element_is_selected, selectedElements.length));
			return null;
		}

		EObject left = getElementFor(selectedElements[0]);
		EObject right = getElementFor(selectedElements[1]);
		if(left == null) {
			//TODO
			//			Activator.logInfo(Messages.CompareTwoElementsAction_left_element_is_null);
			return null;
		}

		if(right == null) {
			//TODO
			//			Activator.logInfo(Messages.CompareTwoElementsAction_right_element_is_null);
			return null;
		}

		ComparisonResourceSnapshot snapshot = doContentCompare(left, right);
		openInCompare(snapshot);
		return null;
	}

}
