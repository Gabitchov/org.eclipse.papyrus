package org.eclipse.papyrus.emf.compare.transactional.editor;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.papyrus.emf.compare.transactional.editor.sphinx.WorkspaceEditingDomainUtil;
import org.eclipse.sphinx.emf.workspace.ui.saving.BasicModelSaveablesProvider.SiteNotifyingSaveablesLifecycleListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISaveablesLifecycleListener;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.SaveablesLifecycleEvent;


/**
 * 
 * Duplicate code from ModelCompareEditor
 *
 */
@SuppressWarnings("restriction")//we suppres the warning for CompareEditor
public class PapyrusCompareEditor extends CompareEditor implements IEditingDomainProvider{

	/**
	 * The identifier of this editor (as contributed).
	 */
	public static String ID = "org.eclipse.papyrus.emf.compare.editor"; //$NON-NLS-1$

	/**
	 * The undo context for this compare editor.
	 */
	protected IUndoContext undoContext;

	private IOperationHistoryListener affectedObjectsListener;

	/**
	 * Default constructor.
	 */
	public PapyrusCompareEditor() {
		// Create undo context
		undoContext = new ObjectUndoContext(this, ID);
	
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);

		// First do not keep duplicated editing domain entries
		Set<TransactionalEditingDomain> editingDomains = new HashSet<TransactionalEditingDomain>();
		for (TransactionalEditingDomain editingDomain : getEditingDomains()) {
			if (editingDomain != null) {
				editingDomains.add(editingDomain);
			}
		}
		if (editingDomains.isEmpty()) {
			Activator.log.error(new RuntimeException("Editing domain not found"));
//			PlatformLogUtil.logAsError(Activator.getPlugin(), new RuntimeException(EMFMessages.error_notFound_editingDomain));
		}
		// Then creates and registers listeners on resulting editing domains
		for (TransactionalEditingDomain editingDomain : editingDomains) {
			addTransactionalEditingDomainListeners(editingDomain);
		}
	}

	@Override
	public void dispose() {
		for (TransactionalEditingDomain editingDomain : getEditingDomains()) {
			if (editingDomain != null) {
				removeTransactionalEditingDomainListeners(editingDomain);
			}
		}

		for (IOperationHistory operationHistory : getOperationHistories()) {
			if (operationHistory != null) {
				operationHistory.dispose(getUndoContext(), true, true, true);
			}
		}
		super.dispose();
	}

	protected void addTransactionalEditingDomainListeners(TransactionalEditingDomain editingDomain) {
		if (editingDomain != null) {
			// Create and register IOperationHistoryListener that detects changed objects
			affectedObjectsListener = createAffectedObjectsListener();
			Assert.isNotNull(affectedObjectsListener);
			((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory().addOperationHistoryListener(affectedObjectsListener);
		}
	}

	protected void removeTransactionalEditingDomainListeners(TransactionalEditingDomain editingDomain) {
		if (editingDomain != null) {
			if (affectedObjectsListener != null) {
				IOperationHistory operationHistory = ((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory();
				operationHistory.removeOperationHistoryListener(affectedObjectsListener);
			}
		}
	}

	/**
	 * Creates and returns the {@linkplain IOperationHistoryListener listener} to add on the
	 * {@linkplain IOperationHistory operation history} of {@linkplain TransactionalEditingDomain editing domain}'s
	 * {@linkplain IWorkspaceCommandStack command stack}.
	 * <p>
	 * The listener's implementation that is provided here aims at updating {@linkplain IUndoableOperation operation}'s
	 * context by first removing default {@linkplain IUndoContext undo context} and second by adding
	 * {@linkplain IUndoContext undo context} encapsulated by this editor.
	 * <p>
	 * Clients may override this default implementation.
	 * 
	 * @return The {@linkplain IOperationHistoryListener operation history listener} to register on the command stack of
	 *         the concerned editing domain.
	 */
	protected IOperationHistoryListener createAffectedObjectsListener() {
		return new IOperationHistoryListener() {

			public void historyNotification(final OperationHistoryEvent event) {
				IUndoableOperation operation = event.getOperation();
				if (event.getEventType() == OperationHistoryEvent.ABOUT_TO_EXECUTE) {
					handleOperationAboutToExecute(operation);
				} else if (event.getEventType() == OperationHistoryEvent.DONE || event.getEventType() == OperationHistoryEvent.UNDONE
						|| event.getEventType() == OperationHistoryEvent.REDONE) {
					Set<?> affectedResources = ResourceUndoContext.getAffectedResources(operation);
					Resource[] resources = getModelRootsResources();
					boolean isLeftResourceAffected = resources[0] != null ? affectedResources.contains(resources[0]) : false;
					boolean isRightResourceAffected = resources[1] != null ? affectedResources.contains(resources[1]) : false;
					if (isLeftResourceAffected || isRightResourceAffected) {
						handleOperationFinished(operation);
					}
				}
			}

			private void handleOperationAboutToExecute(final IUndoableOperation operation) {
				if (operation.canUndo()) {
					IWorkbenchPartSite site = getSite();
					if (site != null) {
						site.getShell().getDisplay().syncExec(new Runnable() {
							public void run() {
								if (isActivePart()) {
									Resource[] resources = getModelRootsResources();
									for (Resource resource : resources) {
										TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resource);
										if (editingDomain != null && editingDomain.getCommandStack() instanceof IWorkspaceCommandStack) {
											IWorkspaceCommandStack cmdStack = (IWorkspaceCommandStack) editingDomain.getCommandStack();
											IUndoContext defaultUndoContext = cmdStack.getDefaultUndoContext();
											if (defaultUndoContext != null) {
												// Remove default undo context and this editor's undo context
												operation.removeContext(defaultUndoContext);
											}
										}
									}
									operation.addContext(getUndoContext());
								}
							}
						});
					}
				}
			}

			private void handleOperationFinished(final IUndoableOperation operation) {
				getSite().getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						// Update editor part name
						// FIXME Not needed for the moment.
						// setPartName(getModelRootsNames());
					}
				});
			}
		};
	}

	/**
	 * @return
	 */
	public ISaveablesLifecycleListener createModelSaveablesLifecycleListener() {
		return new SiteNotifyingSaveablesLifecycleListener(this) {
			@Override
			public void handleLifecycleEvent(SaveablesLifecycleEvent event) {
				super.handleLifecycleEvent(event);

				if (event.getEventType() == SaveablesLifecycleEvent.DIRTY_CHANGED) {
					firePropertyChange(PROP_DIRTY);
				}
			}
		};
	}

	@Override
	public boolean isSaveOnCloseNeeded() {
		// Model-based editors don't need to be saved when being closed even if the model is dirty, because they don't
		// own the model. The model is loaded, managed, and saved globally, i.e. it is not destroyed but stays there
		// when editors are being closed.
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Modify implementation as soon as saving as diff model would be available.
		return false;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if (key.equals(IUndoContext.class)) {
			// Used by undo/redo actions to get their undo context
			return getUndoContext();
		} else {
			return super.getAdapter(key);
		}
	}

	/**
	 * @return The {@linkplain IUndoContext undo context} associated to this compare editor.
	 */
	public IUndoContext getUndoContext() {
		return undoContext;
	}

	/**
	 * @return An array of {@linkplain TransactionalEditingDomain editing domain}s which size is 2 and where at index 0
	 *         is editing domain from left, at index 1 is editing domain from right.
	 */
	public TransactionalEditingDomain[] getEditingDomains() {
		TransactionalEditingDomain[] editingDomains = new TransactionalEditingDomain[2];
		EObject[] modelRoots = getModelRoots();
		if (modelRoots[0] != null) {
			editingDomains[0] = WorkspaceEditingDomainUtil.getEditingDomain(modelRoots[0]);
		}
		if (modelRoots[1] != null) {
			editingDomains[1] = WorkspaceEditingDomainUtil.getEditingDomain(modelRoots[1]);
		}
		if (editingDomains[0] == null && editingDomains[1] == null) {
			Activator.log.error(new RuntimeException("No editing domain found")); //$NON-NLS-1$
//			PlatformLogUtil.logAsError(Activator.getPlugin(), new RuntimeException("No editing domain found")); //$NON-NLS-1$
		}
		return editingDomains;
	}

	protected IOperationHistory[] getOperationHistories() {
		IOperationHistory[] operationHistories = new IOperationHistory[2];
		TransactionalEditingDomain[] editingDomains = getEditingDomains();
		for (int i = 0; i < 2; i++) {
			if (editingDomains[i] != null) {
				operationHistories[i] = ((IWorkspaceCommandStack) editingDomains[i].getCommandStack()).getOperationHistory();
			}
		}
		return operationHistories;
	}

	/**
	 * @return The root objects of the model part that are currently being compared in this editor or an empty array if
	 *         no such objects are available. Anyway, always returns an array of {@linkplain EObject}s which size is 2
	 *         and where at index 0 is the left root and at index 1 is the right root.
	 */
	public EObject[] getModelRoots() {
		EObject[] modelRoots = new EObject[2];
		IEditorInput editorInput = getEditorInput();
		if (editorInput instanceof PapyrusModelElementCompareEditorInput) {
			modelRoots = ((PapyrusModelElementCompareEditorInput) editorInput).getModelRoots();
		}
		return modelRoots;
	}

	/**
	 * <p>
	 * <table>
	 * <tr valign=top>
	 * <td><b>Note</b>&nbsp;&nbsp;</td>
	 * <td>Whatever the model roots are (i.e. if <code>null</code> or not), this method returns an array of
	 * {@linkplain Resource}s whose size is 2.</td>
	 * </tr>
	 * </table>
	 * 
	 * @return
	 */
	protected Resource[] getModelRootsResources() {
		Resource[] resources = new Resource[2];
		EObject[] modelRoots = getModelRoots();
		for (int i = 0; i < 2; i++) {
			EObject modelRoot = modelRoots[i];
			if (modelRoot != null) {
				resources[i] = modelRoot.eResource();
			}
		}
		return resources;
	}

	protected String getModelRootsNames() {
		String[] labels = new String[2];
		EObject[] modelRoots = getModelRoots();
		AdapterFactoryItemDelegator[] itemDelegators = getItemDelegators();
		for (int i = 0; i < 2; i++) {
			if (modelRoots[i] != null && itemDelegators[i] != null) {
				// Label of model root
				labels[i] = itemDelegators[i].getText(modelRoots[i]);
			}
		}
		if (labels[0] != null && labels[1] != null) {
			return labels[0] + " <---> " + labels[1]; //$NON-NLS-1$
		} else {
			return ((CompareEditorInput) getEditorInput()).getTitle();
		}
	}

	protected AdapterFactory[] getAdapterFactories() {
		AdapterFactory[] adapterFactories = new AdapterFactory[2];
		TransactionalEditingDomain[] editingDomains = getEditingDomains();
		for (int i = 0; i < 2; i++) {
			TransactionalEditingDomain editingDomain = editingDomains[i];
			if (editingDomain != null) {
				adapterFactories[i] = ((AdapterFactoryEditingDomain) editingDomain).getAdapterFactory();
			}
		}
		return adapterFactories;
	}

	protected AdapterFactoryItemDelegator[] getItemDelegators() {
		AdapterFactoryItemDelegator[] itemDelegators = new AdapterFactoryItemDelegator[2];
		AdapterFactory[] adapterFactories = getAdapterFactories();
		for (int i = 0; i < 2; i++) {
			AdapterFactory adapterFactory = adapterFactories[i];
			if (adapterFactory != null) {
				itemDelegators[i] = new AdapterFactoryItemDelegator(adapterFactory);
			}
		}
		return itemDelegators;
	}

	protected boolean isActivePart() {
		return this == getSite().getWorkbenchWindow().getPartService().getActivePart();
	}

	@Override
	public void setInput(IEditorInput input) {
		if (input instanceof PapyrusModelElementCompareEditorInput) {
			super.setInput(input);
		} else {
			Activator.log.error(new RuntimeException("Invalid editor input (must be an instance of ModelElementCompareEditorInput)"));
//			PlatformLogUtil.logAsError(Activator.getPlugin(), new RuntimeException(Messages.error_invalidEditorInput));
		}
	Image im = org.eclipse.papyrus.emf.compare.transactional.editor.Activator.getImage("/icons/PapyrusLogo16x16.gif");
		//TODO
		setTitleImage(im);
		setPartName("Papyrus Compare");
	}

	public TransactionalEditingDomain getEditingDomain() {
		return getEditingDomains()[0];
	}

}
