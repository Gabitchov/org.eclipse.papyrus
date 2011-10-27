/**
 * <copyright>
 * 
 * Copyright (c) 2008-2010 See4sys and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     See4sys - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.papyrus.emf.compare.transactional.editor;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.internal.ComparePreferencePage;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.emf.compare.transactional.editor.sphinx.EcorePlatformUtil;
import org.eclipse.sphinx.emf.metamodel.MetaModelDescriptorRegistry;

import org.eclipse.sphinx.platform.ui.util.ExtendedPlatformUI;
import org.eclipse.sphinx.platform.util.PlatformLogUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.sphinx.emf.compare.ui.internal.messages.Messages;

/**
 * Duplicate code from Sphinx
 */
@SuppressWarnings("restriction")
public class BasicCompareAction extends BaseSelectionListenerAction implements ISelectionChangedListener {

	/**
	 * The comparison snapshot owning the match and diff models. This snapshot is needed in order to create the compare
	 * editor input.
	 */
	protected ComparisonSnapshot comparisonSnapshot;

	/**
	 * The selected objects that must be compared.
	 */
	protected List<WeakReference<EObject>> selectedObjects = null;
	/**
	 * The selected files that must be compared.
	 */
	protected List<WeakReference<IFile>> selectedFiles = null;

	/**
	 * Constructor.
	 */
	public BasicCompareAction() {
		//super(Messages.action_compareWithEachOther);
		 super("With Each Other");
		// TODO Add action description
		// setDescription(TO BE DEFINED);
	}

	/**
	 * @param selection
	 *            The selection in the viewer onto which this action should perform an operation.
	 * @return <ul>
	 *         <li><tt><b>true</b>&nbsp;&nbsp;</tt> if compare action is available (i.e. if {@link IStructuredSelection
	 *         selection} matches enablement criteria);</li>
	 *         <li><tt><b>false</b>&nbsp;</tt> otherwise.</li>
	 *         </ul>
	 */
	@Override
	public boolean updateSelection(IStructuredSelection selection) {
		Assert.isNotNull(selection);

		if (selection.size() != 2) {
			return false;
		}

		// Reset attributes
		comparisonSnapshot = null;
		selectedFiles = null;
		selectedObjects = null;

		for (Iterator<?> it = selection.iterator(); it.hasNext();) {
			Object obj = it.next();

			if (obj instanceof EObject) {
				if (selectedObjects == null) {
					selectedObjects = new ArrayList<WeakReference<EObject>>();
				}
				selectedObjects.add(new WeakReference<EObject>((EObject) obj));
			} else if (obj instanceof IFile) {
				IFile file = (IFile) obj;
				if (MetaModelDescriptorRegistry.INSTANCE.getDescriptor(file) != null) {
					if (selectedFiles == null) {
						selectedFiles = new ArrayList<WeakReference<IFile>>();
					}
					selectedFiles.add(new WeakReference<IFile>(file));
				}
			}
		}
		return selectedFiles != null ? selectedFiles.size() == 2 : false ^ selectedObjects != null ? selectedObjects.size() == 2 : false;
	}

	@Override
	public void run() {
		EObject leftObject = null;
		EObject rightObject = null;
		if (selectedObjects != null && selectedObjects.size() == 2) {
			leftObject = selectedObjects.get(0).get();
			rightObject = selectedObjects.get(1).get();
		} else if (selectedFiles != null && selectedFiles.size() == 2) {
			leftObject = getModelRoot(selectedFiles.get(0).get());
			rightObject = getModelRoot(selectedFiles.get(1).get());
		}
		if (leftObject == null || rightObject == null) {
			return;
		}
		try {
			MatchModel matchModel = MatchService.doContentMatch(leftObject, rightObject, Collections.EMPTY_MAP);
			DiffModel diffModel = DiffService.doDiff(matchModel);

			comparisonSnapshot = createComparisonSnapshot(matchModel, diffModel);

			CompareEditorInput input = getCompareEditorInput();
			IWorkbenchPage page = ExtendedPlatformUI.getActivePage();
			IReusableEditor editor = getReusableEditor();

			openCompareEditor(input, page, editor);

		} catch (InterruptedException ex) {
			Activator.log.error(ex);//PlatformLogUtil.logAsError(Activator.getPlugin(), ex);
		} finally {
		}
	}

	/**
	 * @param file
	 *            The file whose root model object must be returned.
	 * @return The root object of the model contained in the specified {@link IFile file}.
	 */
	protected EObject getModelRoot(IFile file) {
		Assert.isNotNull(file);

		// Get model from workspace file and force it to be loaded in case that this has not been done yet
		return EcorePlatformUtil.loadModelRoot(file);
	}

	protected ComparisonSnapshot createComparisonSnapshot(MatchModel matchModel, DiffModel diffModel) {
		ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();
		snapshot.setDate(Calendar.getInstance().getTime());
		snapshot.setDiff(diffModel);
		snapshot.setMatch(matchModel);
		return snapshot;
	}

	protected CompareEditorInput getCompareEditorInput() {
		CompareEditorInput input = new PapyrusModelElementCompareEditorInput(comparisonSnapshot);

		CompareConfiguration configuration = input.getCompareConfiguration();
		if (configuration != null) {
			IPreferenceStore ps = configuration.getPreferenceStore();
			if (ps != null) {
				configuration.setProperty(CompareConfiguration.USE_OUTLINE_VIEW, Boolean.valueOf(ps
						.getBoolean(ComparePreferencePage.USE_OUTLINE_VIEW)));
			}
		}
		return input;
	}

	protected IReusableEditor getReusableEditor() {
		return null;
	}

	/**
	 * Performs the comparison described by the given input and opens a compare editor on the result.
	 * 
	 * @param input
	 *            the input on which to open the compare editor
	 * @param page
	 *            the workbench page on which to create a new compare editor
	 * @param editor
	 *            if not null the input is opened in this editor
	 * @see CompareEditorInput
	 */
	protected void openCompareEditor(final CompareEditorInput input, final IWorkbenchPage page, final IReusableEditor editor) {
		Runnable runnable = new Runnable() {
			public void run() {
				if (editor != null && !editor.getSite().getShell().isDisposed()) {
					// Reuse the given editor
					editor.setInput(input);
					return;
				}
				if (page != null) {
					// Open new CompareEditor on page
					try {
						page.openEditor(input, getCompareEditorId(input));
					} catch (PartInitException e) {
						Activator.log.error(e);
//						PlatformLogUtil.logAsError(Activator.getPlugin(), e);
						MessageDialog.openError(ExtendedPlatformUI.getActiveShell(), Messages.error_openEditorError, e.getMessage());
					}
				} else {
					String msg = Messages.error_noActiveWorkbenchPage;
					Activator.log.error(new NullPointerException(msg));//TODO bad, no?
					//PlatformLogUtil.logAsError(Activator.getPlugin(), new NullPointerException(msg));
					MessageDialog.openError(ExtendedPlatformUI.getActiveShell(), Messages.error_openEditorError, msg);
				}
			}
		};

		Display display = ExtendedPlatformUI.getDisplay();
		if (display != null) {
			display.syncExec(runnable);
		} else {
			runnable.run();
		}
	}

	/**
	 * Returns the identifier of the compare editor to open.
	 * <p>
	 * Inheriting clients may override this method in order to specify the identifier of another compare editor (e.g.
	 * according to the type of the specified input).
	 * 
	 * @param input
	 *            The {@linkplain CompareEditorInput editor input} for which a compare editor is supposed to be opened.
	 * @return The identifier of the compare editor to open.
	 */
	protected String getCompareEditorId(CompareEditorInput input) {
		// Use our own ModelCompareEditor rather than Eclipse's org.eclipse.compare.CompareEditor
		return PapyrusCompareEditor.ID;
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		super.setEnabled(enabled);
	}
}
