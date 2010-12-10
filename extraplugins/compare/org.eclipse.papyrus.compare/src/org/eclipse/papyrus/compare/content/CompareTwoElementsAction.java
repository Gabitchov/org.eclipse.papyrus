/*******************************************************************************
 * Copyright (c) 2008, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.content;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.CompareUI;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.EMFCompareException;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.team.internal.ui.Utils;
import org.eclipse.team.internal.ui.actions.TeamAction;
import org.eclipse.team.internal.ui.history.CompareFileRevisionEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class CompareTwoElementsAction extends TeamAction {

	protected void execute(IAction action) throws InvocationTargetException, InterruptedException {

		Object[] selectedElements = getSelection().toArray();
		if(selectedElements.length != 2) {
			// log
			return;
		}

		EObject left = getElementFor(selectedElements[0]);
		EObject right = getElementFor(selectedElements[1]);
		if (left == null || right == null) {
			// log
			return;
		}

		ComparisonResourceSnapshot snapshot = doContentCompare(left, right);
		openInCompare(snapshot);
	}
	
	public boolean isEnabled() {
		//TODO
		return true;
	}

	private void openInCompare(ComparisonSnapshot snapshot) {
		IWorkbenchPage workBenchPage = getTargetPage();
		CompareEditorInput input = new ModelCompareEditorInput(snapshot);
		IEditorPart editor = Utils.findReusableCompareEditor(input, workBenchPage, new Class[]{ CompareFileRevisionEditorInput.class });
		if(editor != null) {
			IEditorInput otherInput = editor.getEditorInput();
			if(otherInput.equals(input)) {
				// simply provide focus to editor
				workBenchPage.activate(editor);
			} else {
				// if editor is currently not open on that input either re-use
				// existing
				CompareUI.reuseCompareEditor(input, (IReusableEditor)editor);
				workBenchPage.activate(editor);
			}
		} else {
			CompareUI.openCompareEditor(input);
		}
	}

	protected ComparisonResourceSnapshot doContentCompare(final EObject left, final EObject right) {
		// create snapshot
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();

		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InterruptedException {
					final MatchModel match = contentMatch(left, right, monitor);
					final DiffModel diff = contentDiff(left, right, match);

					snapshot.setDiff(diff);
					snapshot.setMatch(match);
				}

				protected DiffModel contentDiff(final EObject left, final EObject right, final MatchModel match) {
					ElementContentDiffEngine engine = new ElementContentDiffEngine(left, right);
					final DiffModel diff = engine.doDiff(match);
					return diff;
				}

				protected MatchModel contentMatch(final EObject left, final EObject right, IProgressMonitor monitor) throws InterruptedException {
					final Map<String, Object> options = new EMFCompareMap<String, Object>();
					options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
					options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left.eResource(), right.eResource()));
					options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
					options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);

					final IMatchEngine matchEngine = new ElementContentMatchEngine(left, right);
					final MatchModel match = matchEngine.contentMatch(left, right, options);
					return match;
				}
			});
		} catch (final InterruptedException e) {
			EMFComparePlugin.log(e, false);
		} catch (final EMFCompareException e) {
			EMFComparePlugin.log(e, false);
		} catch (final InvocationTargetException e) {
			EMFComparePlugin.log(e, true);
		}
		return snapshot;
	}
	
	private EObject getElementFor(Object object) {
		if(object instanceof IAdaptable) {
			return (EObject)((IAdaptable)object).getAdapter(EObject.class);
		}

		if(object instanceof EObject) {
			return (EObject)object;
		}
		return null;
	}


}
