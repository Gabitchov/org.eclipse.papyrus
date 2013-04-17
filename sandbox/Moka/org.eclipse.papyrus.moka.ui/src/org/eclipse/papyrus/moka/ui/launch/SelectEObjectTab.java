/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.providers.strategy.SemanticEMFContentProvider;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.moka.launch.MokaLaunchDelegate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchLabelProvider;


/**
 * A tab used as part of a MokaLaunchConfigurationTabGroup.
 * It enables to select a resource, a model element in this 
 * resource (this is the root element for the execution),
 * and to specify arguments for the execution.
 *
 */
public class SelectEObjectTab extends AbstractLaunchConfigurationTab {

	protected String labelText = "EObject selection" ;
	protected Label selectedResourceLabel ;
	protected Label selectedEObjectLabel ;
	protected Text selectedResourceText ;
	protected Text selectedEObjectText ;
	protected Button browseButton ;
	protected Button browseEObjectButton ;
	protected Label argsLabel ;
	protected Text argsText ;
	protected IFile currentFile = null ;
	protected EObject currentEObject = null ;
	protected ResourceSet resourceSet = null ;
	
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.BORDER);
		setControl(comp) ;
		comp.setLayout(new GridLayout(3, false)) ;
		this.createSelectedResourceText(comp) ;
		this.createBrowseWorkspaceButton(comp, "Browse", null, false, 1) ;
		this.createSelectedEObjectText(comp) ;
		this.createBrowseResourceButton(comp, "Browse", null, false, 1) ;
		this.createArgsText(comp) ;
	}

	protected void createSelectedResourceText(Composite parent) {
		selectedResourceLabel = new Label(parent, SWT.NONE);
		selectedResourceLabel.setText("Selected resource:");
		selectedResourceLabel.setToolTipText("Press Browse to selecte a new resource");
		selectedResourceText = new Text(parent, SWT.BORDER) ;
		selectedResourceText.setEditable(false) ;
		//selectedResourceText.setText("No resource selected") ;
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		selectedResourceText.setLayoutData(gd) ;
		selectedResourceText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
	}
	
	protected void createBrowseWorkspaceButton(Composite parent, String label, Image image, boolean checked, int hspan) {
		browseButton = new Button(parent, SWT.BORDER);
		browseButton.setFont(parent.getFont());
		browseButton.setSelection(checked);
		if(image != null) {
			browseButton.setImage(image);
		}
		if(label != null) {
			browseButton.setText(label);
		}
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = hspan;
		browseButton.setLayoutData(gd) ;
		
		browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
				if(labelText != null) {
					dialog.setTitle(labelText);
				}
				dialog.setContentProvider(new WorkspaceContentProvider());
				dialog.setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());

				if(currentFile != null && currentFile.exists()) {
					dialog.setInitialSelections(new IFile[]{ currentFile });
				}
				
				dialog.open() ;
				Object[] selection = dialog.getResult() ;
				if (dialog.getReturnCode() == Dialog.OK && selection.length > 0 && (selection[0] instanceof IFile)) {
					currentFile = (IFile)selection[0] ;
					URI fileURI = URI.createPlatformResourceURI(currentFile.getFullPath().toString(), true) ;
					selectedResourceText.setText(fileURI.toString()) ;
				}
			}
		});
	}

	protected void createSelectedEObjectText(Composite parent) {
		selectedEObjectLabel = new Label(parent, SWT.NONE);
		selectedEObjectLabel.setText("Selected eObject:");
		selectedEObjectLabel.setToolTipText("Press Browse to select the EObject to execute");
		selectedEObjectText = new Text(parent, SWT.BORDER) ;
		selectedEObjectText.setEditable(false) ;
		//selectedEObjectText.setText("No eObject selected") ;
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		selectedEObjectText.setLayoutData(gd) ;
		selectedEObjectText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
	}
	
	protected void createBrowseResourceButton(Composite parent, String label, Image image, boolean checked, int hspan) {
		browseEObjectButton = new Button(parent, SWT.BORDER);
		browseEObjectButton.setFont(parent.getFont());
		browseEObjectButton.setSelection(checked);
		if(image != null) {
			browseEObjectButton.setImage(image);
		}
		if(label != null) {
			browseEObjectButton.setText(label);
		}
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = hspan;
		browseEObjectButton.setLayoutData(gd) ;
		
		browseEObjectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				if (selectedResourceText == null || selectedResourceText.isDisposed())
					return ;
				String resourcePath = selectedResourceText.getText() ;
				if (resourceSet == null) ;
					resourceSet = new ResourceSetImpl() ;
				@SuppressWarnings("unused")
				Resource resource = resourceSet.getResource(URI.createURI(resourcePath), true) ;

				TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
				if(labelText != null) {
					dialog.setTitle(labelText);
				}
				dialog.setContentProvider(new SemanticEMFContentProvider(resourceSet));
				dialog.setLabelProvider(new EMFLabelProvider());

				if(currentEObject != null) {
					dialog.setInitialSelections(new EObject[]{currentEObject});
				}
				
				dialog.open() ;
				Object[] selection = dialog.getResult() ;
				if (dialog.getReturnCode() == Dialog.OK && selection.length > 0 && (selection[0] instanceof EObject)) {
					currentEObject = (EObject)selection[0] ;
					selectedEObjectText.setText(new EMFLabelProvider().getText(currentEObject)) ; 
				}
			}
		});
	}
	
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	public void initializeFrom(ILaunchConfiguration configuration) {		
		try {
			String init_uri = configuration.getAttribute(MokaLaunchDelegate.URI_ATTRIBUTE_NAME, "") ;
			selectedResourceText.setText(init_uri) ;
			if (! init_uri.equals("")) {
				currentFile = (IFile)ResourcesPlugin.getWorkspace().getRoot().findMember(init_uri);
				URI uri = URI.createURI(init_uri) ;
				if (resourceSet == null)
					resourceSet = new ResourceSetImpl() ;
				Resource resource = resourceSet.getResource(uri, true) ;
				if (resource != null) {
					String init_fragment = configuration.getAttribute(MokaLaunchDelegate.FRAGMENT_ATTRIBUTE_NAME, "") ;
					currentEObject = resource.getEObject(init_fragment) ;
					selectedEObjectText.setText(new EMFLabelProvider().getText(currentEObject)) ;
				}
				else {
					resourceSet = null ;
				}
			}
			String init_args = configuration.getAttribute(MokaLaunchDelegate.ARGS_ATTRIBUTE_NAME, "") ;
			argsText.setText(init_args) ;
		} catch (CoreException e) {
			Activator.log.error(e);
		}
	}

	protected void createArgsText(Composite parent) {
		argsLabel = new Label(parent, SWT.NONE) ;
		argsLabel.setText("Args:") ;
		argsLabel.setToolTipText("Specify arguments for the execution of the EObject") ;
		GridData gdLabel = new GridData(SWT.FILL, SWT.FILL, true, false);
		gdLabel.horizontalSpan = 3 ;
		gdLabel.verticalSpan = 1 ;
		argsLabel.setLayoutData(gdLabel) ;
		
		argsText = new Text(parent, SWT.BORDER) ;
		argsText.setEditable(true) ;
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.horizontalSpan = 3 ;
		gd.verticalSpan = 3 ;
		argsText.setLayoutData(gd) ;
		argsText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
	}
	
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(MokaLaunchDelegate.URI_ATTRIBUTE_NAME, selectedResourceText.getText()) ;
		if (currentEObject != null) {
			configuration.setAttribute(MokaLaunchDelegate.FRAGMENT_ATTRIBUTE_NAME, currentEObject.eResource().getURIFragment(currentEObject)) ;
		}
		configuration.setAttribute(MokaLaunchDelegate.ARGS_ATTRIBUTE_NAME, argsText.getText()) ;
	}
	
	public String getName() {
		return "EObject selection";
	}
}
