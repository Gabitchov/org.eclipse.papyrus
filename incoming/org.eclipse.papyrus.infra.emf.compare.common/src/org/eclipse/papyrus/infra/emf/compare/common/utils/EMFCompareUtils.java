/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.compare.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.compare.Splitter;
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
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.infra.emf.compare.common.Activator;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.papyrus.infra.emf.compare.ui.content.transactional.viewer.PapyrusTransactionalModelContentMergeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.structural.viewer.PapyrusCustomizableParameterizedStructureMergeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.LabelProviderUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class EMFCompareUtils {

	private EMFCompareUtils() {
		//nothing to do
	}

	public static ComparisonResourceSnapshot doContentCompare(final EObject left, final EObject right) {
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();

		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InterruptedException {
					final Map<String, Object> options = new EMFCompareMap<String, Object>();
					options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
					options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left.eResource(), right.eResource()));
					options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
					options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);

					final MatchModel match = MatchService.doContentMatch(left, right, options);
					DiffModel diff = DiffService.doDiff(match);
					//						final MatchModel match = contentMatch(left, right, monitor);
					//						final DiffModel diff = contentDiff(left, right, match);

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
	 * 
	 * @param editor
	 *        the editor
	 * @param rawModel
	 *        the raw model
	 * @return
	 *         the name for the editor
	 */
	public static String getCompareEditorTitle(final IEditorPart editor, final PapyrusEMFCompareInstance rawModel) {
		String title = "Compare";
		if(editor != null) {
			EMFCompareLabelProvider labelProvider = (EMFCompareLabelProvider)LabelProviderUtil.INSTANCE.getLabelProviderFor(editor);
			title += " " + labelProvider.getText(rawModel.getLeft());
			title += " /" + labelProvider.getText(rawModel.getRight());
		}

		return title;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.common.editor.EMFCompareEditor#createModelCompareEditorInput(org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot)
	 * 
	 * @param snapshot
	 * @return
	 */
	public static ModelCompareEditorInput createModelCompareEditorInput(ComparisonSnapshot snapshot, final IEditorPart editor) {
		//TODO : test on Editor
		return new ModelCompareEditorInput(snapshot) {

			@Override
			protected ModelContentMergeViewer createMergeViewer(CompareViewerPane pane, CompareConfiguration config) {
				return new PapyrusTransactionalModelContentMergeViewer(pane, config, editor);
			}

			/**
			 * {@inheritDoc}
			 * 
			 * @see CompareEditorInput#createOutlineContents(Composite, int)
			 */
			@Override
			public Control createOutlineContents(Composite parent, int direction) {
				final Splitter splitter = new Splitter(parent, direction);

				final CompareViewerPane pane = new CompareViewerPane(splitter, SWT.NONE);

				//structureMergeViewer = new ModelStructureMergeViewer(pane, getCompareConfiguration());
				structureMergeViewer = new PapyrusCustomizableParameterizedStructureMergeViewer(pane, getCompareConfiguration(), editor);
				pane.setContent(structureMergeViewer.getTree());

				structureMergeViewer.setInput(preparedInput);

				return splitter;
			}

			/**
			 * 
			 * @see org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput#saveChanges(org.eclipse.core.runtime.IProgressMonitor)
			 * 
			 * @param monitor
			 */
			@Override
			public void saveChanges(IProgressMonitor monitor) {
				//normally it ok, there is nothing to do to save notation and di files
				super.saveChanges(monitor);
			}

		};
	}
}
