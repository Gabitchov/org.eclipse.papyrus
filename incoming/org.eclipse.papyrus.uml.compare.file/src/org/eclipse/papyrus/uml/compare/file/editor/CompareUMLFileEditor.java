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
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.TransactionalEditingDomainManager;
import org.eclipse.papyrus.infra.emf.compare.common.utils.EMFCompareUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.compare.editor.UMLCompareEditor;
import org.eclipse.papyrus.uml.compare.file.Activator;
import org.eclipse.papyrus.uml.compare.file.handler.CompareUMLFileInput;
import org.eclipse.papyrus.uml.compare.file.messages.Messages;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

public class CompareUMLFileEditor extends UMLCompareEditor implements IEditingDomainProvider {//extends CompareEditor{

	/** the id of this editor (declared in the plugin.xml */
	public static final String COMPARE_UML_FILE_EDITOR_ID = "org.eclipse.papyrus.uml.compare.file.editor"; //$NON-NLS-1$

	private final TransactionalEditingDomain editingDomain;

	private final ResourceSet set;

	private ObjectUndoContext undoContext;

	private IOperationHistoryListener historyListener;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CompareUMLFileEditor() {
		super();
		set = new ResourceSetImpl();
		System.out.println(set);
		editingDomain = TransactionalEditingDomainManager.createDefaultTransactionalEditingDomain(set);
		undoContext = new ObjectUndoContext(this, "PayrusUMLFileCompareUndoContext"); //$NON-NLS-1$
		historyListener = new IOperationHistoryListener() {

			public void historyNotification(OperationHistoryEvent event) {
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
	}



	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// TODO save di and notation file
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

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if(input instanceof CompareUMLFileInput) {
			EObject roots[] = new EObject[2];

			for(int i = 0; i < 2; i++) {
				String filePath = ((CompareUMLFileInput)input).getComparedFiles().get(i).getFullPath().toString();
				URI uri = URI.createFileURI(filePath); //$NON-NLS-1$ //$NON-NLS-2$
				try {
					roots[i] = EMFHelper.loadEMFModel(set, uri);
					Assert.isNotNull(roots[i]);
				} catch (IOException e) {
					Activator.log.error(NLS.bind(Messages.CompareUMLFileEditor_ICantLoadTheModel, uri), e);
					return;
				};

				//we load the notation file
				int index = filePath.lastIndexOf("."); //$NON-NLS-1$
				String subString = filePath.substring(0, index);

				//we load the .di
				uri = URI.createFileURI(subString + ".di"); //$NON-NLS-1$
				Map<?, ?> options = null;
				if(set.getURIConverter().exists(uri, options)) {
					try {
						set.getResource(uri, true).load(options);
					} catch (IOException e) {
						Activator.log.error(NLS.bind(Messages.CompareUMLFileEditor_ICantLoadTheModel, uri), e);
					}
				}

				//we load the .notation
				uri = URI.createFileURI(subString + ".notation"); //$NON-NLS-1$
				if(set.getURIConverter().exists(uri, options)) {
					try {
						set.getResource(uri, true).load(options);
					} catch (IOException e) {
						Activator.log.error(NLS.bind(Messages.CompareUMLFileEditor_ICantLoadTheModel, uri), e);
					}
				}

				//TODO : and if there is other referenced files?

			}
			ComparisonSnapshot snapshot = EMFCompareUtils.doContentCompare(roots[0], roots[1]);
			IEditorInput newInput = EMFCompareUtils.createModelCompareEditorInput(snapshot, this);
			super.init(site, newInput);
		} else {
			super.init(site, input);
		}
	}

	@Override
	public void setInput(IEditorInput input) {
		//we create the real input for this editor
		if(input instanceof CompareUMLFileInput) {
			EObject roots[] = new EObject[2];
			//			ResourceSet set = new ResourceSetImpl();

			for(int i = 0; i < 2; i++) {
				URI uri = URI.createFileURI(((CompareUMLFileInput)input).getComparedFiles().get(i).getFullPath().toString()); //$NON-NLS-1$ //$NON-NLS-2$
				try {
					roots[i] = EMFHelper.loadEMFModel(set, uri);
					Assert.isNotNull(roots[i]);
				} catch (IOException e) {
					Activator.log.error(NLS.bind(Messages.CompareUMLFileEditor_ICantLoadTheModel, uri), e);
					return;
				};
			}
			ComparisonSnapshot snapshot = EMFCompareUtils.doContentCompare(roots[0], roots[1]);
			IEditorInput newInput = EMFCompareUtils.createModelCompareEditorInput(snapshot, this);
			super.setInput(newInput);
		} else {
			super.setInput(input);
		}
	}

	public Object getAdapter(Class key) {
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
		super.dispose();

	}


}
