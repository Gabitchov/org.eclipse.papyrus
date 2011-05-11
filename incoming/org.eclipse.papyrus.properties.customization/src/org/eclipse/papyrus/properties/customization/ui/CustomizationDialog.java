/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.customization.ui;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.customization.Activator;
import org.eclipse.papyrus.properties.customization.messages.Messages;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.widgets.editors.InputDialog;
import org.eclipse.papyrus.widgets.providers.CollectionContentProvider;
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

	private List availableContexts;

	private ListViewer availableContextsViewer;

	private Button copyContext;

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

		Collection<Context> contexts = ConfigurationManager.instance.getContexts();

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

		copyContext = new Button(controls, SWT.PUSH);
		copyContext.setText(Messages.CustomizationDialog_copy);
		copyContext.setToolTipText(Messages.CustomizationDialog_createNewCopyByCopy);
		copyContext.setEnabled(false);
		copyContext.addSelectionListener(this);

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


				if(!selection.isEmpty()) {
					Context context = (Context)selection.getFirstElement();
					activate = !ConfigurationManager.instance.isPlugin(context);
				}

				editContext.setEnabled(activate);
				copyContext.setEnabled(!selection.isEmpty());
				removeContext.setEnabled(activate);
			}

		});

		//		generateContext = new Button(controls, SWT.PUSH);
		//		generateContext.setText("Generate");
		//		generateContext.setToolTipText("Generates a new Context from a Metamodel");
		//		generateContext.setEnabled(false);

		getShell().pack();
	}

	protected void editAction() {
		EditContextAction action = new EditContextAction();
		IStructuredSelection selection = (IStructuredSelection)availableContextsViewer.getSelection();
		if(selection.isEmpty()) {
			return;
		}

		Object element = selection.getFirstElement();
		if(element instanceof Context) {
			Context sourceContext = (Context)element;
			try {
				action.openEditor(sourceContext);
				close();
			} catch (Exception ex) {
				Activator.log.error("An error occured while initializing the customization editor", ex); //$NON-NLS-1$
				return;
			}
		}
	}

	protected void copyAction() {
		CopyContextAction action = new CopyContextAction();
		IStructuredSelection selection = (IStructuredSelection)availableContextsViewer.getSelection();
		if(selection.isEmpty()) {
			return;
		}

		Object element = selection.getFirstElement();
		if(element instanceof Context) {
			Context sourceContext = (Context)element;
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
					action.copy(sourceContext, targetName, false);
					availableContextsViewer.setInput(ConfigurationManager.instance.getContexts());
				}
			} catch (IOException ex) {
				Activator.log.error(ex);
			}
		}
	}

	protected void deleteAction() {
		RemoveContextAction action = new RemoveContextAction();
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

			MessageDialog dialog = new MessageDialog(getShell(), Messages.CustomizationDialog_deleteContext, null, Messages.CustomizationDialog_deleteContextConfirmation1 + sourceContext.getName() + Messages.CustomizationDialog_deleteContextConfirmation2, MessageDialog.CONFIRM, new String[]{ Messages.CustomizationDialog_yes, Messages.CustomizationDialog_no, Messages.CustomizationDialog_cancel }, 2);
			int result = dialog.open();
			if(result == 0) { //0 is "Yes" (It is *not* the same 0 as Window.OK)
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
		} else if(e.widget == copyContext) {
			copyAction();
		}
	}

	public void widgetDefaultSelected(final SelectionEvent e) {
		if(e.widget == availableContexts) {
			IStructuredSelection selection = (IStructuredSelection)availableContextsViewer.getSelection();
			if(!selection.isEmpty()) {
				Context context = (Context)selection.getFirstElement();
				if(ConfigurationManager.instance.isPlugin(context)) {
					copyAction();
				} else {
					editAction();
				}
			}
		}
	}
}
