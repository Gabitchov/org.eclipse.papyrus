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
package org.eclipse.papyrus.uml.compare.file.editor;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelException;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.TransactionalEditingDomainManager;
import org.eclipse.papyrus.infra.emf.compare.common.editor.AbstractPapyrusCompareEditor;
import org.eclipse.papyrus.infra.emf.compare.common.internal.utils.PapyrusFileLoader;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.compare.file.Activator;
import org.eclipse.papyrus.uml.compare.file.handler.CompareUMLFileInput;
import org.eclipse.papyrus.uml.compare.file.messages.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class CompareUMLFileEditor extends /* EMFCompareEditor */AbstractPapyrusCompareEditor {//extends CompareEditor{

	/** the id of this editor (declared in the plugin.xml */
	public static final String COMPARE_UML_FILE_EDITOR_ID = "org.eclipse.papyrus.uml.compare.file.editor"; //$NON-NLS-1$

	private final TransactionalEditingDomain editingDomain;

	private final ResourceSet set;

	private final ObjectUndoContext undoContext;

	private final IOperationHistoryListener historyListener;

	/** the compared root object */
	private EObject roots[];


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CompareUMLFileEditor() {
		super();
		set = new ResourceSetImpl();
		editingDomain = TransactionalEditingDomainManager.createDefaultTransactionalEditingDomain(set);
		undoContext = new ObjectUndoContext(this, "PayrusUMLFileCompareUndoContext"); //$NON-NLS-1$
		historyListener = new IOperationHistoryListener() {

			public void historyNotification(final OperationHistoryEvent event) {
				if(event.getEventType() == OperationHistoryEvent.DONE) {
					Set<Resource> affectedResources = ResourceUndoContext.getAffectedResources(event.getOperation());
					if(isConcerned(Collections.unmodifiableSet(affectedResources))) {
						final IUndoableOperation operation = event.getOperation();

						// remove the default undo context so that we can have
						//     independent undo/redo of independent resource changes
						operation.removeContext(((IWorkspaceCommandStack)getEditingDomain().getCommandStack()).getDefaultUndoContext());

						// add our undo context to populate our undo menu
						operation.addContext(undoContext);

						getSite().getShell().getDisplay().asyncExec(new Runnable() {

							public void run() {
								//			                  dirty = true;
								firePropertyChange(IEditorPart.PROP_DIRTY);
								//	TODO?
								// Try to select the affected objects.
								//
								//			                  if (operation instanceof EMFCommandOperation) {
								//			                     Command command = ((EMFCommandOperation) operation).getCommand();
								//			                     
								//			                     if (command != null) {
								//			                        setSelectionToViewer(command
								//			                              .getAffectedObjects());
								//			                     }
								//			                  }
								//			                  
								//			                  if (propertySheetPage != null) {
								//			                     propertySheetPage.refresh();
								//			                  }
							}
						});
					}
				}
			}
		};
		getOperationHistory().addOperationHistoryListener(historyListener);
		addUndoRedoListeners();
	}



	@Override
	public void doSave(final IProgressMonitor progressMonitor) {
		super.doSave(progressMonitor);
	}

	private boolean isConcerned(final Set affectedResources) {
		Iterator<?> iter = affectedResources.iterator();
		while(iter.hasNext()) {
			if(this.set.getResources().contains(iter.next())) {
				return true;
			}
		}
		return false;
	}

	private IOperationHistory getOperationHistory() {
		if(editingDomain != null) {
			CommandStack commandStack = editingDomain.getCommandStack();
			if(commandStack instanceof IWorkspaceCommandStack) {
				return ((IWorkspaceCommandStack)commandStack).getOperationHistory();
			}
		}
		return null;
	}

	//always null, maybe, excepted when we are in the init method
	private CompareUMLFileInput tmpInput;

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		if(input instanceof CompareUMLFileInput) {
			this.tmpInput = (CompareUMLFileInput)input;
			roots = PapyrusFileLoader.loadPapyrusFiles(set, ((CompareUMLFileInput)input).getComparedFiles(), false);
			ModelCompareEditorInput newInput = getCompareInput(roots[0], roots[1]);
			this.tmpInput = null;
			super.init(site, newInput);
		} else {
			super.init(site, input);
		}
	}

	@Override
	protected ModelCompareEditorInput createModelCompareEditorInput(final ComparisonSnapshot snapshot) {
		return new PapyrusModelCompareEditorInput(snapshot, this) {

			@Override
			public Image getTitleImage() {
				return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/papyrus_compare_editor.gif").createImage();
			}

			protected ModelCompareInput createModelCompareInput(final ComparisonSnapshot snap) {
				if(snap instanceof ComparisonResourceSetSnapshot) {
					return new PapyrusModelCompareInput(((ComparisonResourceSetSnapshot)snap).getMatchResourceSet(), ((ComparisonResourceSetSnapshot)snap).getDiffResourceSet(), editingDomain);
				}
				return new PapyrusModelCompareInput(((ComparisonResourceSnapshot)snap).getMatch(), ((ComparisonResourceSnapshot)snap).getDiff(), editingDomain);
			}
		};
	}

	@Override
	protected void configureInput(final PapyrusModelCompareEditorInput input) {
		if(this.tmpInput != null) {//null, when are in the Undo/Redo
			String leftLabel = this.tmpInput.getComparedFiles().get(0).getFullPath().makeRelative().toString();;
			String rightLabel = this.tmpInput.getComparedFiles().get(1).getFullPath().makeRelative().toString();;
			Image im = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/UMLModelFile.gif").createImage();
			input.initLabels(leftLabel, im, rightLabel, im);
		}

	}

	@Override
	public Object getAdapter(final Class key) {
		if(key.equals(IUndoContext.class)) {
			// used by undo/redo actions to get their undo context
			return undoContext;
		}
		return super.getAdapter(key);
	}


	/**
	 * 
	 * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
	 * 
	 * @return
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return this.editingDomain;
	}

	@Override
	public void dispose() {
		getOperationHistory().removeOperationHistoryListener(historyListener);
		removeUndoRedoListener();
		super.dispose();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.common.editor.AbstractPapyrusCompareEditor#getIOperationHistory()
	 * 
	 * @return
	 */
	@Override
	protected IOperationHistory getIOperationHistory() {
		return getOperationHistory();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.common.editor.AbstractPapyrusCompareEditor#resetInput()
	 * 
	 */
	@Override
	protected void resetInput() {
		IEditorInput input = getEditorInput();
		assert (input instanceof PapyrusModelCompareEditorInput);
		final TreeViewer viewer = ((PapyrusModelCompareEditorInput)input).getStructureMergeViewer();
		final PapyrusModelCompareEditorInput newInput = (PapyrusModelCompareEditorInput)getCompareInput(roots[0], roots[1]);
		final ModelCompareInput input2 = newInput.getpreparedModelCompareInput();
		viewer.setInput(input2);
	}


}
