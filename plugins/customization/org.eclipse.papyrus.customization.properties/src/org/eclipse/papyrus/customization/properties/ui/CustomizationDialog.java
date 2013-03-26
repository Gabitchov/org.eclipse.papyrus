/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Factor out workspace storage for pluggable storage providers (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.ui;

import java.util.Collection;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.customization.properties.messages.Messages;
import org.eclipse.papyrus.customization.properties.storage.actions.ContextStorageActionRegistry;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextCopyAction;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextDeleteAction;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextEditAction;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextStorageActionProvider;
import org.eclipse.papyrus.infra.widgets.editors.InputDialog;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * A Dialog to display the operations available to customize
 * the property view, such as "Copy", "Edit" or "Delete" an
 * existing configuration.
 * 
 * @author Camille Letavernier
 */
public class CustomizationDialog extends TrayDialog implements SelectionListener {

	private final ContextStorageActionRegistry actionRegistry;

	private List availableContexts;

	private ListViewer availableContextsViewer;

	private java.util.List<Button> copyContextButtons;

	private Button editContext;

	private Button removeContext;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param shell
	 *        The shell in which the dialog will be opened
	 */
	public CustomizationDialog(final Shell shell) {
		super(shell);

		this.actionRegistry = new ContextStorageActionRegistry();
	}

	@Override
	public void create() {
		super.create();
		super.getShell().setText(Messages.CustomizationDialog_customization);
		super.getShell().setImage(Activator.getDefault().getImage("/icons/papyrus.png")); //$NON-NLS-1$

		Composite contents = new Composite(getDialogArea(), SWT.NONE);
		contents.setLayout(new GridLayout(2, false));
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label label = new Label(contents, SWT.NONE);
		label.setText(Messages.CustomizationDialog_selectContextToEdit);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		Collection<Context> contexts = ConfigurationManager.instance.getCustomizableContexts();

		availableContexts = new List(contents, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		availableContexts.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		availableContextsViewer = new ListViewer(availableContexts);
		availableContextsViewer.setContentProvider(CollectionContentProvider.instance);
		availableContextsViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(final Object element) {
				if(element != null && element instanceof Context) {
					Context context = (Context)element;
					return context.getName() + (ConfigurationManager.instance.isPlugin(context) ? Messages.CustomizationDialog_plugin : ""); //$NON-NLS-1$
				}
				return super.getText(element);
			}
		});
		availableContextsViewer.setInput(contexts);
		availableContexts.addSelectionListener(this);

		Composite controls = new Composite(contents, SWT.NONE);
		controls.setLayout(new FillLayout(SWT.VERTICAL));

		Collection<IContextStorageActionProvider> providers = actionRegistry.getStorageActionProviders();
		copyContextButtons = new java.util.ArrayList<Button>(providers.size());
		for(IContextStorageActionProvider next : providers) {
			IContextCopyAction copyAction = next.getContextCopyAction();
			if(copyAction != null) {
				Button copyContext = new Button(controls, SWT.PUSH);
				copyContext.setText(copyAction.getLabel());
				copyContext.setToolTipText(copyAction.getToolTip());
				copyContext.setData(copyAction);
				copyContext.setEnabled(false);
				copyContext.addSelectionListener(this);
				
				copyContextButtons.add(copyContext);
			}
		}
		if (copyContextButtons.size() == 1) {
			// special case:  use a simpler label than "Copy to Workspace..."
			copyContextButtons.get(0).setText(Messages.CustomizationDialog_copy);
		}

		editContext = new Button(controls, SWT.PUSH);
		editContext.setText(Messages.CustomizationDialog_edit);
		editContext.setToolTipText(Messages.CustomizationDialog_editSelectedContext);
		editContext.setEnabled(false);
		editContext.addSelectionListener(this);

		removeContext = new Button(controls, SWT.PUSH);
		removeContext.setText(Messages.CustomizationDialog_delete);
		removeContext.setToolTipText(Messages.CustomizationDialog_removeSelectedContext);
		removeContext.setEnabled(false);
		removeContext.addSelectionListener(this);

		availableContextsViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(final SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();
				boolean activate = false;

				IContextStorageActionProvider provider = null;
				if(!selection.isEmpty()) {
					Context context = (Context)selection.getFirstElement();
					activate = !ConfigurationManager.instance.isPlugin(context);
					provider = actionRegistry.getStorageActionProvider(context);
				}

				editContext.setEnabled(activate);
				IContextEditAction editAction = provider.getContextEditAction();
				editContext.setToolTipText((editAction == null) ? null : editAction.getToolTip());
				for(Button next : copyContextButtons) {
					next.setEnabled(!selection.isEmpty());
				}
				removeContext.setEnabled(activate);
				IContextDeleteAction deleteAction = provider.getContextDeleteAction();
				removeContext.setToolTipText((deleteAction == null) ? null : deleteAction.getToolTip());
			}

		});

		//		generateContext = new Button(controls, SWT.PUSH);
		//		generateContext.setText("Generate");
		//		generateContext.setToolTipText("Generates a new Context from a Metamodel");
		//		generateContext.setEnabled(false);

		getShell().pack();
	}

	protected void editAction() {
		IStructuredSelection selection = (IStructuredSelection)availableContextsViewer.getSelection();
		if(selection.isEmpty()) {
			return;
		}

		Object element = selection.getFirstElement();
		if(element instanceof Context) {
			Context sourceContext = (Context)element;

			IContextEditAction editAction = actionRegistry.getContextEditAction(sourceContext);
			if(editAction == null) {
				MessageDialog.openError(getShell(), Messages.CustomizationDialog_0, Messages.CustomizationDialog_1);
				return;
			}

			try {
				EditContextAction action = new EditContextAction(editAction);
				action.openEditor(sourceContext);
				close();
			} catch (Exception ex) {
				Activator.log.error("An error occured while initializing the customization editor", ex); //$NON-NLS-1$
				return;
			}
		}
	}

	protected void copyAction(IContextCopyAction copyAction) {
		IStructuredSelection selection = (IStructuredSelection)availableContextsViewer.getSelection();
		if(selection.isEmpty()) {
			return;
		}

		Object element = selection.getFirstElement();
		if(element instanceof Context) {
			Context sourceContext = (Context)element;
			CopyContextAction action = new CopyContextAction(copyAction);

			try {
				InputDialog dialog = new InputDialog(getShell(), Messages.CustomizationDialog_enterConfigurationName, Messages.CustomizationDialog_enterConfigurationName, Messages.CustomizationDialog_copyOf + sourceContext.getName(), new IInputValidator() {

					public String isValid(final String newText) {
						if(newText.trim().equals("")) { //$NON-NLS-1$
							return Messages.CustomizationDialog_configurationNameNotEmpty;
						}
						if(ConfigurationManager.instance.getContext(newText) != null) {
							return Messages.CustomizationDialog_configurationWithSameNameExists;
						}
						return null;
					}

				});
				dialog.setTitle(Messages.CustomizationDialog_configurationName);
				int result = dialog.open();
				if(result == Window.OK) {
					String targetName = dialog.getText();
					Context newContext = action.copy(sourceContext, targetName, false);
					if (newContext != null) {
						availableContextsViewer.setInput(ConfigurationManager.instance.getContexts());
						availableContextsViewer.setSelection(new StructuredSelection(newContext), true);
					}
				}
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}
	}

	protected void deleteAction() {
		IStructuredSelection selection = (IStructuredSelection)availableContextsViewer.getSelection();
		if(selection.isEmpty()) {
			return;
		}

		Object element = selection.getFirstElement();
		if(element instanceof Context) {
			Context sourceContext = (Context)element;
			if(ConfigurationManager.instance.isPlugin(sourceContext)) {
				Activator.log.warn(Messages.CustomizationDialog_cannotDeletePluginContext);
				//Plugin context cannot be deleted
				return;
			}

			IContextDeleteAction deleteAction = actionRegistry.getContextDeleteAction(sourceContext);
			if(deleteAction == null) {
				MessageDialog.openError(getShell(), Messages.CustomizationDialog_deleteContext, Messages.CustomizationDialog_2);
				return;
			}

			MessageDialog dialog = new MessageDialog(getShell(), Messages.CustomizationDialog_deleteContext, null, Messages.CustomizationDialog_deleteContextConfirmation1 + sourceContext.getName() + Messages.CustomizationDialog_deleteContextConfirmation2, MessageDialog.CONFIRM, new String[]{ IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, IDialogConstants.CANCEL_LABEL }, 2);
			int result = dialog.open();
			if(result == 0) { //0 is "Yes" (It is *not* the same 0 as Window.OK)
				RemoveContextAction action = new RemoveContextAction(deleteAction);
				action.removeContext(sourceContext);
				availableContextsViewer.setInput(ConfigurationManager.instance.getContexts());
			}
		}
	}

	@Override
	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE;
	}

	@Override
	protected Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}


	public void widgetSelected(final SelectionEvent e) {
		if(e.widget == editContext) {
			editAction();
		} else if(e.widget == removeContext) {
			deleteAction();
		} else if(e.widget.getData() instanceof IContextCopyAction) {
			copyAction((IContextCopyAction)e.widget.getData());
		}
	}

	public void widgetDefaultSelected(final SelectionEvent e) {
		if(e.widget == availableContexts) {
			IStructuredSelection selection = (IStructuredSelection)availableContextsViewer.getSelection();
			if(!selection.isEmpty()) {
				Context context = (Context)selection.getFirstElement();
				if(ConfigurationManager.instance.isPlugin(context)) {
					if(copyContextButtons.size() == 1) {
						copyAction((IContextCopyAction)copyContextButtons.get(0).getData());
					}
				} else {
					editAction();
				}
			}
		}
	}

	@Override
	public boolean isResizable() {
		return true;
	}
}
