package org.eclipse.papyrus.infra.emf.compare.ui.viewer;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.EMFOperationCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.ApplyCustomizationAction;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.CustomizationAction;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.Saveable;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;

public class TransactionalModelContentMergeViewer extends ModelContentMergeViewer {

	/**the editing domain for the merge action*/
	private TransactionalEditingDomain domain;

	private boolean isSynchronizedWithDiagram;

	private IAction diagramSynchronization;

	private Resource leftUMLResource;

	private Resource rightUMLResource;

	private Resource leftDiResource;

	private Resource rightDiResource;

	private static ImageDescriptor diagramSynchronizationImage;

	private static final String SYNCHRONIZATION_IMAGE_PATH = "icons/PapyrusLogo16x16.gif";

	//duplicate code from tatiana
	public TransactionalModelContentMergeViewer(Composite parent, CompareConfiguration config) {
		super(parent, config);
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor instanceof IEditingDomainProvider) {
			domain = (TransactionalEditingDomain)((IEditingDomainProvider)editor).getEditingDomain();
		}
		if(diagramSynchronizationImage == null) {
			this.diagramSynchronizationImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, SYNCHRONIZATION_IMAGE_PATH);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param input
	 *        the input
	 */
	@Override
	public void setInput(Object input) {
		super.setInput(input);
		initializeDiResource();
	}

	private void initializeDiResource() {
		URI uri;
		URI diURI;
		ResourceSet set;
		IMergeViewerContentProvider contentProvider = (IMergeViewerContentProvider)getContentProvider();

		//the left : 
		Object content = contentProvider.getLeftContent(getInput());
		if(content instanceof Resource) {
			leftUMLResource = (Resource)content;
			uri = leftUMLResource.getURI();
			diURI = URI.createPlatformResourceURI(uri.toPlatformString(false).replace("uml", "di"), true);
			set = leftUMLResource.getResourceSet();
			if(set.getURIConverter().exists(diURI, null)) {
				leftDiResource = set.getResource(diURI, true);
			}
		}

		//the right
		content = contentProvider.getRightContent(getInput());
		if(content instanceof Resource) {
			rightUMLResource = (Resource)content;
			uri = rightUMLResource.getURI();
			diURI = URI.createPlatformResourceURI(uri.toPlatformString(false).replace("uml", "di"), true);
			set = rightUMLResource.getResourceSet();
			if(set.getURIConverter().exists(diURI, null)) {
				rightDiResource = set.getResource(diURI, true);
			}
		}

		updateToolItems();
	}

	@Override
	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(Composite composite, int side) {
		// TODO Auto-generated method stub
		//		return super.createModelContentMergeTabFolder(composite, side);
		return new TransactionalModelContentMergeTabFolder(this, composite, side);
	}

	/**
	 * Undoes the changes implied by the currently selected {@link DiffElement diff}.
	 */
	protected void copyDiffLeftToRight() {
		if(currentSelection != null) {
			doCopy(currentSelection, true);
		}
		currentSelection.clear();
		switchCopyState(false);
	}

	/**
	 * Applies the changes implied by the currently selected {@link DiffElement diff}.
	 */
	protected void copyDiffRightToLeft() {
		if(currentSelection != null) {
			doCopy(currentSelection, false);
		}
		currentSelection.clear();
		switchCopyState(false);
	}


	protected void doCopy(final List<DiffElement> diffs, final boolean leftToRight) {
		//leftUMLResource.load(options) TODO!



		Map<?, ?> transactionOptions = Collections.EMPTY_MAP;
		final Runnable runnable = new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				TransactionalModelContentMergeViewer.this.copy(diffs, leftToRight);
			}
		};

		//		AbstractCommand cmd = new ChangeC(){
		//
		//			public void execute() {
		//				// TODO Auto-generated method stub
		//				
		//			}
		//
		//			public void redo() {
		//				// TODO Auto-generated method stub
		//				
		//			}
		//			
		//		}
		IUndoableOperation operation = new AbstractEMFOperation(domain, "copy action", transactionOptions) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				//				try {
				runnable.run();
				return Status.OK_STATUS;
				//				} catch (RuntimeException ex) {
				//					if (ex instanceof OperationCanceledException) {
				//						throw (OperationCanceledException) ex;
				//					} else {
				////						throw new ExecutionException(NLS.bind(Messages.problem_transactionFailed, operationLabel), ex);
				//					}
				//				}
				//				
			}

			//			@Override
			//			public boolean canUndo() {
			////				return transactionOptions.get(Transaction.OPTION_NO_UNDO) != Boolean.TRUE;
			//			}


		};

		Command command = new EMFOperationCommand(domain, operation);
		//		domain.getCommandStack().
		domain.getCommandStack().execute(command);

	}

	/**
	 * 
	 * {@inheritDoc} Add a toogle button to the toolbar to do the synchronization with the diagram
	 * 
	 * @param tbm
	 *        the toolbarmanager
	 */
	@Override
	protected void createToolItems(ToolBarManager tbm) {
		//we add an action for the diagram synchronization
		diagramSynchronization = new Action("Diagram Synchronisation", IAction.AS_CHECK_BOX) {

			/**
			 * {@inheritDoc}
			 * 
			 */
			@Override
			public void run() {
				//nothing to do
				isSynchronizedWithDiagram = this.isChecked();
			}
		};

		diagramSynchronization.setImageDescriptor(diagramSynchronizationImage);
		ActionContributionItem actionContributionItem = new ActionContributionItem(diagramSynchronization);
		diagramSynchronization.setToolTipText("Remove the inconsistent views on the Papyrus Model");
		tbm.insert(0, actionContributionItem);

		//we add an action to change the applied cuztomization
		IAction customizationAction = new CustomizationAction();
		ActionContributionItem customizationContributionItem = new ActionContributionItem(customizationAction);
		tbm.insert(1, customizationContributionItem);

		addSpecificActionForCustomization(tbm);
		super.createToolItems(tbm);

	}

	/**
	 * 
	 * @param tbm
	 *        the toolbar manager
	 */
	private void addSpecificActionForCustomization(ToolBarManager tbm) {
		//TODO create an extension point for that
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.infra.compare.ui.customization");


		//	for(IConfigurationElement current : config){
		for(int i = 0; i < config.length; i++) {
			IConfigurationElement current = config[i];
			String image = current.getAttribute("image");
			String fileName = current.getAttribute("file");
			String tooltip = current.getAttribute("tooltip");
			String text = current.getAttribute("name");
			//TODO, test with a path like this : platform:/  ....
			int index = fileName.lastIndexOf('/');
			if(index != -1) {
				fileName = fileName.substring(index + 1);
			}
			fileName = fileName.replace(".uiCustom", "");
			//			CustomizationsCatalog.getInstance().
			MetamodelView metamodelView = CustomizationsCatalog.getInstance().getCustomization(fileName);
			Action customization = new ApplyCustomizationAction(image, text, tooltip, metamodelView);
			ActionContributionItem customizationContributionItem = new ActionContributionItem(customization);
			tbm.insert(i + 2, customizationContributionItem); //TODO try to improve this i+2!
			//			tbm.appendToGroup("mode",customizationContributionItem );
		}




	}

	/**
	 * 
	 * {@inheritDoc} Update {@link #diagramSynchronization}
	 */
	@Override
	protected void updateToolItems() {
		super.updateToolItems();
		if(diagramSynchronization != null) {
			if(leftDiResource != null && rightDiResource != null) {//TODO one of them can be null, I think, so I should change this test!
				diagramSynchronization.setEnabled(true);
			} else {
				diagramSynchronization.setEnabled(false);
			}
		}
	}

	private String COMPARE_CUSTOMIZATION_ID = "org.eclipse.papyrus.compare.customization";

}
