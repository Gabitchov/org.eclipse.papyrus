/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.compare.ui.viewer;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.EMFOperationCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.CustomizationAction;
import org.eclipse.papyrus.infra.emf.compare.utils.CompareEditorConfiguration;
import org.eclipse.papyrus.infra.emf.compare.utils.Utils;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class TransactionalModelContentMergeViewer extends ModelContentMergeViewer {

	/** the action to know if we use the Papyrus Edit Service or not for the merge action */
	private IAction useEditServiceAction;

	//FIXME : avoid to duplicate this string...
	private static final String SYNCHRONIZATION_IMAGE_PATH = "icons/PapyrusLogo16x16.gif";

	//FIXME
	private static final ImageDescriptor diagramSynchronizationImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, TransactionalModelContentMergeViewer.SYNCHRONIZATION_IMAGE_PATH);

	/** the list of the metamodels referenced in the compared files. this field is used by the Customization Manager */
	private Set<EPackage> metamodels;

	/** the configuration for the merge action using this viewer */
	private CompareEditorConfiguration configuration;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param config
	 */
	public TransactionalModelContentMergeViewer(final Composite parent, final CompareConfiguration config) {
		super(parent, config);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @param input
	 *        the input
	 */
	@Override
	public void setInput(final Object input) {
		super.setInput(input);
		createCompareConfiguration();
		initizalizeMetamodels();
		updateToolItems();
	}

	/**
	 * Create the configuration for the merge using this viewer. The configuration will be store in
	 * {@link org.eclipse.papyrus.infra.emf.compare.Activator}
	 */
	private void createCompareConfiguration() {
		final IMergeViewerContentProvider contentProvider = (IMergeViewerContentProvider)getContentProvider();

		//the left : 
		Object content = contentProvider.getLeftContent(getInput());
		Resource leftUMLResource = null;
		if(content instanceof Resource) {
			leftUMLResource = (Resource)content;
		}

		//the right
		content = contentProvider.getRightContent(getInput());
		Resource rightUMLResource = null;
		if(content instanceof Resource) {
			rightUMLResource = (Resource)content;
		}
		final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(rightUMLResource != null || leftUMLResource != null) {
			this.configuration = new CompareEditorConfiguration(editor, leftUMLResource, rightUMLResource);
			org.eclipse.papyrus.infra.emf.compare.Activator.getDefault().addConfiguration(editor, this.configuration);
		}
	}


	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param composite
	 * @param side
	 * @return
	 */
	@Override
	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(final Composite composite, final int side) {
		return new TransactionalModelContentMergeTabFolder(this, composite, side);
	}

	/**
	 * Undoes the changes implied by the currently selected {@link DiffElement diff}.
	 */
	@Override
	protected void copyDiffLeftToRight() {
		if(this.currentSelection != null) {
			doCopy(this.currentSelection, true);
		}
		this.currentSelection.clear();
		switchCopyState(false);
	}

	/**
	 * Applies the changes implied by the currently selected {@link DiffElement diff}.
	 */
	@Override
	protected void copyDiffRightToLeft() {
		if(this.currentSelection != null) {
			doCopy(this.currentSelection, false);
		}
		this.currentSelection.clear();
		switchCopyState(false);
	}


	protected void doCopy(final List<DiffElement> diffs, final boolean leftToRight) {
		//leftUMLResource.load(options) TODO!
		final TransactionalEditingDomain domain = this.configuration.getEditingDomain();

		final Map<?, ?> transactionOptions = Collections.EMPTY_MAP;
		final Runnable runnable = new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				TransactionalModelContentMergeViewer.this.copy(diffs, leftToRight);
			}
		};

		final IUndoableOperation operation = new AbstractEMFOperation(domain, "copy action", transactionOptions) {

			@Override
			protected IStatus doExecute(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				runnable.run();
				return Status.OK_STATUS;
			}


		};

		final Command command = new EMFOperationCommand(domain, operation);
		try {
			OperationHistoryFactory.getOperationHistory().execute(operation, new NullProgressMonitor(), null);
		} catch (final ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		domain.getCommandStack().execute(command);
	}

	/**
	 * 
	 * {@inheritDoc} Add a toogle button to the toolbar to do the synchronization with the diagram
	 * 
	 * @param tbm
	 *        the toolbar manager
	 */
	@Override
	protected void createToolItems(final ToolBarManager tbm) {
		//we add an action for the diagram synchronization
		this.useEditServiceAction = new Action("Diagram Synchronisation", IAction.AS_CHECK_BOX) {

			/**
			 * {@inheritDoc}
			 * 
			 */
			@Override
			public void run() {
				TransactionalModelContentMergeViewer.this.configuration.setUseEditService(isChecked());
			}
		};

		this.useEditServiceAction.setImageDescriptor(TransactionalModelContentMergeViewer.diagramSynchronizationImage);
		final ActionContributionItem actionContributionItem = new ActionContributionItem(this.useEditServiceAction);
		this.useEditServiceAction.setToolTipText("Remove the inconsistent views on the Papyrus Model");
		tbm.insert(0, actionContributionItem);

		//we add an action to change the applied customization
		final IAction customizationAction = new CustomizationAction(getMetamodels());
		final ActionContributionItem customizationContributionItem = new ActionContributionItem(customizationAction);
		tbm.insert(1, customizationContributionItem);
		super.createToolItems(tbm);

	}

	/**
	 * 
	 * {@inheritDoc} Update {@link #useEditServiceAction}
	 */
	@Override
	protected void updateToolItems() {
		super.updateToolItems();
		if(this.useEditServiceAction != null && this.configuration != null) {
			this.useEditServiceAction.setEnabled(this.configuration.manageDiResource());//null pointer
		}
	}

	/**
	 * initialize the list of the metamodel referenced in the compared files.
	 */
	private void initizalizeMetamodels() {
		getMetamodels().addAll(this.configuration.getMetamodels());
	}

	/**
	 * 
	 * @return
	 *         a set with the metamodels. This list will be used by the Customization Manager
	 */
	private Set<EPackage> getMetamodels() {
		if(this.metamodels == null) {
			this.metamodels = new HashSet<EPackage>();
		}
		return this.metamodels;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param event
	 */
	@Override
	protected void handleDispose(final DisposeEvent event) {
		final IEditorPart editor = Utils.getCurrentEditor();
		org.eclipse.papyrus.infra.emf.compare.Activator.getDefault().removeConfiguration(editor);
		this.configuration.dispose();
		super.handleDispose(event);
	}
}
