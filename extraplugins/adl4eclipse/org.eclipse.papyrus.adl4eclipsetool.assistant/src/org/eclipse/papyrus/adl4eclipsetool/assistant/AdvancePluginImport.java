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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipsetool.assistant;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.adltool.command.CompletePluginsArchitectureSnapshotCommand;
import org.eclipse.papyrus.adltool.command.SimplePluginsArchitectureSnapshotCommand;
import org.eclipse.papyrus.adltool.designer.ArchitectureSnapshotDesigner;
import org.eclipse.papyrus.adltool.designer.wizard.BundleSelectionPage;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForSelection;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * this class is used to do the retro engineering from workspaceplugin. It adds only in the platform dependencies.
 *
 */
public class AdvancePluginImport extends Wizard implements IImportWizard {

	protected BundleSelectionPage bundleSelectionPage;
	protected TransactionalEditingDomain transactionalEditingDomain=null;
	protected PapyrusMultiDiagramEditor papyrusEditor;
	protected ModelSet modelSet;

	/**
	 * 
	 * Constructor.
	 *
	 */
	public AdvancePluginImport() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		//look for all plugins from the workspace
		ArrayList<Object> bundleList= new ArrayList<Object>();
		bundleList.addAll(ArchitectureSnapshotDesigner.getLoadedBundles());
		bundleSelectionPage = new BundleSelectionPage(bundleList);
		addPage(bundleSelectionPage);
	}

	/**
	 * 
	 * @return the list of selected bundle from the page
	 */
	public ArrayList<Object> getSelectedBundle(){
		return bundleSelectionPage.getResult();
	}
	@Override
	public boolean performFinish() {
		
		// one bundle must be selected
		if(getSelectedBundle().size()>0){
			// get the domain in order to launche the command
			TransactionalEditingDomain dom = modelSet.getTransactionalEditingDomain();
			ArrayList<Element> selection=getSelectionSet();
			
			if( (selection.size()==1) &&(selection.get(0)instanceof Package)){
				//launch the simple retro engineering
				CompletePluginsArchitectureSnapshotCommand comd= new CompletePluginsArchitectureSnapshotCommand(dom, (Package)selection.get(0), getSelectedBundle());
				dom.getCommandStack().execute(comd);
			}
			return true;
		}
		return false;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
		//get the service registry of papyrus from the selection
		ServicesRegistry registry=null;
		try {
			registry = ServiceUtilsForSelection.getInstance().getServiceRegistry(selection);
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
		try {
			modelSet = registry.getService(ModelSet.class);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * getSelected element in the diagram or in the model explorer
	 * @return Element or null
	 */
	protected ArrayList<Element> getSelectionSet(){
		ArrayList<Element> selectedSet =new ArrayList<Element>();
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();


		if(selection instanceof IStructuredSelection) {
			@SuppressWarnings("rawtypes")
			Iterator selectedobjectIteractor = ((IStructuredSelection)selection).iterator();
			while (selectedobjectIteractor.hasNext()) {
				Object currentSelection = selectedobjectIteractor.next();
				EObject selectedEObject = EMFHelper.getEObject(currentSelection);
				if (selectedEObject instanceof org.eclipse.uml2.uml.Element){
					selectedSet.add((Element)selectedEObject);
				}
			}

		}
		return selectedSet;
	}

}
