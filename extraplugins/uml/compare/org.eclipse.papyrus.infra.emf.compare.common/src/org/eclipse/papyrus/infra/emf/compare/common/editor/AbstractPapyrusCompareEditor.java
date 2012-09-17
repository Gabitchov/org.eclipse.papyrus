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
package org.eclipse.papyrus.infra.emf.compare.common.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
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
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.emf.compare.common.Activator;
import org.eclipse.papyrus.infra.emf.compare.common.utils.ICompareViewerProvider;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.ICustomizableEditor;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.LabelProviderUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This abstract allows to regroup the configuration for the Papyrus nested compare editor
 * and the standalone Papyrus Compare Editor
 * 
 */
@SuppressWarnings("restriction")
//suppress restriction for CompareEditor
public abstract class AbstractPapyrusCompareEditor extends CompareEditor implements ICustomizableEditor {


	/**
	 * The listener on the operation history to catch the Undo/Redo and update the upper viewer
	 */
	private IOperationHistoryListener historyListener;


	/**
	 * The label provider for this editor
	 */
	private EMFCompareLabelProvider labelProvider;

	public AbstractPapyrusCompareEditor() {
		super();
	}

	protected final void addUndoRedoListeners() {
		final IOperationHistory operationHistory = getIOperationHistory();
		operationHistory.addOperationHistoryListener(getUndoRedoListener());
	}

	/**
	 * Remove the listener on the Undo/Redo
	 */
	protected void removeUndoRedoListener() {
		final IOperationHistory operationHistory = getIOperationHistory();
		operationHistory.removeOperationHistoryListener(getUndoRedoListener());
	}

	public EMFCompareLabelProvider getLabelProvider() {
		if(labelProvider == null) {
			labelProvider = LabelProviderUtil.createLabelProvider();
		}
		return labelProvider;
	}

	/**
	 * 
	 * @param monitor
	 *        the monitor
	 * @param left
	 *        the left object
	 * @param right
	 *        the right object
	 * @return
	 *         the options for the comparison
	 */
	//TODO : i'm not sure of these options for EMF, but this method is always overriden in Papyrus
	protected Map<String, Object> getCompareOptions(final IProgressMonitor monitor, final EObject left, final EObject right) {
		final Map<String, Object> options = new EMFCompareMap<String, Object>();
		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left.eResource(), right.eResource()));
		options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE); //TODO verify this parameter
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE); //TODO verify this parameter
		return options;
	}


	@Override
	public void setFocus() {
		//I refresh the viewer here, because the EMF queries for name, ... are called during the creation of the editor, and
		//it is not the correct Editor which is used by these queries to get the correct label provider
		//
		refreshViewers();
		super.setFocus();
	}

	/**
	 * 
	 * @param left
	 *        the left eobject
	 * @param right
	 *        the rihgt eobject
	 * @return
	 *         the ComparisinSnapshot
	 */
	protected ComparisonSnapshot doContentCompare(final EObject left, final EObject right) {
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();

		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {

				public void run(final IProgressMonitor monitor) throws InterruptedException {
					final Map<String, Object> options = getCompareOptions(monitor, left, right);
					final MatchModel match = doMatch(monitor, left, right, options);
					DiffModel diff = doDiff(match, options);
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
	 * @param monitor TODO
	 * @param left
	 * @param right
	 * @param options
	 * @return
	 *         the MatchModel for the comparison
	 * @throws InterruptedException
	 */
	protected MatchModel doMatch(IProgressMonitor monitor, final EObject left, final EObject right, final Map<String, Object> options) throws InterruptedException {
		return MatchService.doContentMatch(left, right, options);
	}

	/**
	 * 
	 * @param match
	 * @param options 
	 * @return
	 *         the DiffModel for the comparison
	 */
	protected DiffModel doDiff(final MatchModel match, Map<String, Object> options) {
		return DiffService.doDiff(match);
	}

	/**
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	protected final ModelCompareEditorInput getCompareInput(final EObject left, final EObject right) {
		final ComparisonSnapshot snapshot = doContentCompare(left, right);
		return getConfiguredModelCompareEditorInput(snapshot);
	}

	/**
	 * 
	 * @param snapshot
	 *        the ComparisonSnapshot
	 * @return
	 *         the ModelCompareEditorInput for this snapshot
	 */
	//TODO try to set this method in private
	private final ModelCompareEditorInput getConfiguredModelCompareEditorInput(final ComparisonSnapshot snapshot) {
		final ModelCompareEditorInput input = createModelCompareEditorInput(snapshot);
		configureInput((PapyrusModelCompareEditorInput)input);
		return input;
	}

	protected ModelCompareEditorInput createModelCompareEditorInput(final ComparisonSnapshot snapshot) {
		return new PapyrusModelCompareEditorInput(snapshot, this);
	}

	/**
	 * This method allows to set label and image to use for this input
	 * 
	 * @param input
	 *        the input
	 */
	protected abstract void configureInput(final PapyrusModelCompareEditorInput input);

	/**
	 * 
	 */
	protected void addListeners() {

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.ui.utils.ICustomizableEditor#refreshViewers()
	 * 
	 */
	public void refreshViewers() {
		final IEditorInput input = this.getEditorInput();
		if(input instanceof ICompareViewerProvider) {
			final Viewer contentViewer = ((ICompareViewerProvider)input).getContentMergeViewer();
			final Viewer structureViewer = ((ICompareViewerProvider)input).getStructureMergeViewer();
			if(contentViewer != null) {
				contentViewer.refresh();
			}
			if(structureViewer != null) {
				structureViewer.refresh();
			}
		}
	}

	protected IOperationHistoryListener getUndoRedoListener() {
		if(this.historyListener == null) {
			this.historyListener = new IOperationHistoryListener() {

				/** the last catched event */
				private OperationHistoryEvent lastEvent = null;

				/**
				 * 
				 * @see org.eclipse.core.commands.operations.IOperationHistoryListener#historyNotification(org.eclipse.core.commands.operations.OperationHistoryEvent)
				 * 
				 * @param event
				 */
				public void historyNotification(final OperationHistoryEvent event) {
					int eventType = event.getEventType();
					if(eventType == 10 || eventType == 9) {
						if(this.lastEvent != event) {
							this.lastEvent = event;
							if(!event.getOperation().getLabel().equals("Create CompareEditor")) {//TODO improve it!
								resetInput();
							}
						}
					}
				}

				private void resetInput() {
					AbstractPapyrusCompareEditor.this.resetInput();
				}
			};
		}
		return this.historyListener;
	}

	protected abstract IOperationHistory getIOperationHistory();

	/**
	 * reset the input in the viewer
	 */
	protected abstract void resetInput();
}
