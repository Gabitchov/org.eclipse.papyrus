/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.customization.palette.handler;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.gmf.runtime.common.core.service.ProviderPriority;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;


/**
 * Handler to deploy new configuration 
 */
public class DeployPaletteConfigurationHandler extends AbstractHandler implements IHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if(!(currentSelection instanceof IStructuredSelection) || currentSelection.isEmpty()) {
			return null;
		}

		final IStructuredSelection selection = (IStructuredSelection)currentSelection;

		final Shell activeShell = HandlerUtil.getActiveShell(event);

		
		doExecute(selection, activeShell, new NullProgressMonitor());
		return null;
	
	}

	protected void doExecute(IStructuredSelection selection, Shell activeShell, IProgressMonitor monitor) {
		
		Iterator<?> selectionIterator = selection.iterator();

		MultiStatus result = new MultiStatus(Activator.ID, IStatus.OK, "The palette configuration has been successfully deployed and activated", null);

		while(selectionIterator.hasNext()) {
			Object selectedElement = selectionIterator.next();
			if(selectedElement instanceof IAdaptable) {
				IFile selectedFile = (IFile)((IAdaptable)selectedElement).getAdapter(IFile.class);
				if(selectedFile == null) {
					monitor.worked(1);
					result.add(new Status(IStatus.ERROR, Activator.ID, "The selected element is not a file"));
					continue;
				}

				
				String fileName = selectedFile.getFullPath().removeFileExtension().lastSegment();
				monitor.subTask("Deploy " + fileName);

				// retrieve info => open a dialog, filled by current opened editor ?
				ProviderPriority priority = PapyrusPalettePreferences.getWorkspacePalettePriority(fileName);
				String editorID = PapyrusPalettePreferences.getWorkspaceEditorID(fileName);
				String paletteName = PapyrusPalettePreferences.getWorkspacePaletteName(fileName);
				Set<String> requiredProfiles = PapyrusPalettePreferences.getRequiredProfiles(fileName); 
				String path = selectedFile.getFullPath().toString();
				
				
				UpdateContentDialog dialog = new UpdateContentDialog(activeShell, fileName, paletteName, priority, editorID, requiredProfiles);
				int returnCode = dialog.open();
				if(Dialog.OK==returnCode) {
					boolean validUpdate = true;
					boolean alreadyDeployed = false;
					
					// update values from the editor
					if(dialog.paletteName !=null && dialog.paletteName.length()>0) {
						paletteName = dialog.paletteName;	
						alreadyDeployed = true;
					} else {
						validUpdate = false;
					}
					
					if(dialog.priority !=null ) {
						priority = dialog.priority;	
						alreadyDeployed = true;
					}else {
						validUpdate = false;
					}
					
					if(dialog.editorID !=null && dialog.editorID.length()>0) {
						editorID = dialog.editorID;	
						alreadyDeployed = true;
					}else {
						validUpdate = false;
					}
					
					if(dialog.requiredProfiles !=null && dialog.requiredProfiles.length()>0) {
						requiredProfiles = PaletteUtil.getProfileSetFromString(dialog.requiredProfiles);
					}else {
						validUpdate = false;
					}
					
					if(validUpdate) {
						if(alreadyDeployed) {
							// update values and set visible again
							PapyrusPalettePreferences.addWorkspacePalette(fileName, paletteName, path, priority, editorID, requiredProfiles);
							PapyrusPalettePreferences.changePaletteVisibility(fileName, editorID, true);
							result.add(new Status(IStatus.OK, Activator.ID, "The palette configuration was already deployed, it has just been activated"));
						} else {
							// just add the palette
							PapyrusPalettePreferences.addWorkspacePalette(fileName, paletteName, path, priority, editorID, requiredProfiles);
							result.add(new Status(IStatus.OK, Activator.ID, "The palette configuration has been successfully deployed and activated"));
						}
					} else {
						result.add(new Status(IStatus.ERROR, Activator.ID, "The palette configuration was not deployed, because dialog content was not valid"));		
					}
				} else {
					result.add(new Status(IStatus.ERROR, Activator.ID, "The palette configuration was not deployed, because user did cancel the dialog"));
				}
				
			}
		}

		if(result.getChildren().length == 1) {
			if(result.isOK()) {
				MessageDialog.openInformation(activeShell, "Success", result.getMessage());
			} else if(result.getSeverity() < IStatus.ERROR) { //Errors are already logged
				StatusManager.getManager().handle(result, StatusManager.SHOW);
			}
		} else { //Merge the result and specify an appropriate message based on the result
			if(result.isOK()) {
				MessageDialog.openInformation(activeShell, "Success", result.getMessage());
			} else {
				MultiStatus actualResult = new MultiStatus(Activator.ID, result.getCode(), "Some errors occurred during the deployment", result.getException());
				actualResult.merge(result);
			}
		}
	}
	
	
	public static class UpdateContentDialog extends TrayDialog {
		public String paletteName;
		public ProviderPriority priority;
		public String editorID;
		public String requiredProfiles ;
		public String fileName;
		private Text nameText;
		private Text editorText;
		private Text profilesText;
		private CCombo priorityCombo; 
		
		
		/**
		 * @param shell
		 * @param priority 
		 * @param editorID 
		 * @param requiredProfiles 
		 */
		protected UpdateContentDialog(Shell shell, String fileName, String paletteName, ProviderPriority priority, String editorID, Set<String> requiredProfiles) {
			super(shell);
			this.fileName = fileName;
			this.paletteName = paletteName;
			this.priority = priority;
			this.editorID = editorID;
			if(requiredProfiles !=null) {
				this.requiredProfiles = PaletteUtil.getSerializedProfileList(requiredProfiles);	
			}
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void configureShell(Shell newShell) {
			super.configureShell(newShell);
			if(newShell!=null) {
				newShell.setText("Configure Deployment of the palette");
				newShell.setSize(600, 400);
			}
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Control createDialogArea(Composite parent) {
			Composite superComposite = (Composite) super.createDialogArea(parent);
			Composite composite = new Composite(superComposite, SWT.NONE);
			composite.setLayout(new GridLayout(2, false));
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			
			// new grid data will all necessary info
			Label nameLabel = new Label(composite, SWT.NONE);
			nameLabel.setText("Name:");
			nameText = new Text(composite, SWT.BORDER);
			if(paletteName == null) {
				paletteName = fileName;
			}
			nameText.setText(paletteName);
			nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			
			Label priorityLabel = new Label(composite, SWT.NONE);
			priorityLabel.setText("Priority:");
			priorityCombo = new CCombo(composite, SWT.BORDER);
			priorityCombo.setEditable(false);
			priorityCombo.setItems(new String[] {ProviderPriority.LOWEST.getName(), ProviderPriority.LOW.getName(), ProviderPriority.MEDIUM.getName(), ProviderPriority.HIGH.getName(), ProviderPriority.HIGHEST.getName()});
			if(ProviderPriority.LOWEST.equals(priority)) {
				priorityCombo.select(0);
			} else if(ProviderPriority.LOW.equals(priority)) {
				priorityCombo.select(1);
			} else if(ProviderPriority.MEDIUM.equals(priority)) {
				priorityCombo.select(2);
			} else if(ProviderPriority.HIGH.equals(priority)) {
				priorityCombo.select(3);
			} else if(ProviderPriority.HIGHEST.equals(priority)) {
				priorityCombo.select(4);
			}  else {
				priorityCombo.select(2); // default = medium
			}
			priorityCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			
			Label editorLabel = new Label(composite, SWT.NONE);
			editorLabel.setText("Editor:");
			editorText = new Text(composite, SWT.BORDER);
			if(editorID == null) {
				// TODO: try to see if a Papyrus editor is currently opened?
				editorID = "";
			}
			editorText.setText(editorID);
			editorText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			
			// list of profiles
			Label profilesLabel = new Label(composite, SWT.NONE);
			profilesLabel.setText("Profiles:");
			profilesText = new Text(composite, SWT.BORDER);
			if(requiredProfiles != null) {
				profilesText.setText(requiredProfiles);
			}
			profilesText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			
			return superComposite;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void okPressed() {
			// updates values
			if(nameText!=null && ! nameText.isDisposed()) {
				paletteName = nameText.getText();	
			}
			
			if(editorText!=null && ! editorText.isDisposed()) {
				editorID = editorText.getText();	
			}
			
			if(priorityCombo!=null && ! priorityCombo.isDisposed()) {
				priority = ProviderPriority.parse(priorityCombo.getText());
			}
			
			if(profilesText!=null && ! profilesText.isDisposed()) {
				requiredProfiles = profilesText.getText();	
			}
			
			super.okPressed();
		}
		
	}
}