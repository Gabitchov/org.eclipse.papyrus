/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.modelexplorer.dnd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonDropAdapter;

/**
 * this class manage the drop inside the model explorer
 */
public class CommonDropAdapterAssistant extends org.eclipse.ui.navigator.CommonDropAdapterAssistant {

	public CommonDropAdapterAssistant() {

	}

	@Override
	public IStatus handleDrop(CommonDropAdapter dropAdapter,
			DropTargetEvent dropTargetEvent, Object dropTarget) {
		Object targetElement = (Object) dropTarget;
		if (org.eclipse.jface.util.LocalSelectionTransfer.getTransfer().isSupportedType(
				dropAdapter.getCurrentTransfer())) {
			switch (dropAdapter.getCurrentOperation()) {
			case DND.DROP_MOVE:
				execute(getDropCommand(targetElement));
				break;
				// case DND.DROP_COPY:
				// break;
			}

		}
		return null;
	}
/**
 * get he list of command to put an eobject into another EObject
 * It will look for the good role of the child eobject
 * @param domain the Transactional Domain
 * @param targetOwner the eobject that will contain the drop object
 * @param childElement that we want to move
 * @return the list of commands to to teh drop
 */
	@SuppressWarnings("unchecked")
	protected List<Command> getDropCommand(TransactionalEditingDomain domain,EObject targetOwner, EObject childElement){
		ArrayList<Command> commandList= new ArrayList<Command>();
		ArrayList<EStructuralFeature> possibleEFeatures= new ArrayList<EStructuralFeature>();
		EList<EStructuralFeature> featureList=targetOwner.eClass().getEAllStructuralFeatures();
		Iterator<EStructuralFeature> iterator= featureList.iterator();
		while (iterator.hasNext()) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) iterator.next();

			if( eStructuralFeature instanceof EReference){
				EReference ref= (EReference)eStructuralFeature;

				if( ref.isContainment()){

					if( isSubClass(ref.getEType(),childElement.eClass() )){
						possibleEFeatures.add(eStructuralFeature);
					}

				}
			}
		}
		Iterator<EStructuralFeature> iteratorFeature= possibleEFeatures.iterator();
		while (iteratorFeature.hasNext()) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) iteratorFeature
			.next();
			ArrayList<EObject> tmp=new ArrayList<EObject>();
			tmp.add(childElement);
			if(targetOwner.eGet(eStructuralFeature) instanceof Collection<?>){
				tmp.addAll((Collection<EObject>)targetOwner.eGet(eStructuralFeature));
			}
			commandList.add( SetCommand.create(domain, targetOwner, eStructuralFeature, tmp));

		}
		return commandList;
	}

	/**
	 * verify from a list of command if it can be dropped
	 * @param commandList
	 * 
	 * @return true or false
	 */
	protected boolean canDrop(List<Command> commandList){
		Iterator<Command> iterator= commandList.iterator();
		while (iterator.hasNext()) {
			Command abstractCommand = (Command) iterator.next();
			if(abstractCommand.canExecute()){
				return true;
			}
		}
		return false;
	}  

	/**
	 * execute command for the drop
	 * @param commandList
	 * 
	 * @return true or false
	 */
	protected void execute(List<Command> commandList){
		Iterator<Command> iterator= commandList.iterator();
		while (iterator.hasNext()) {
			Command abstractCommand = (Command) iterator.next();
			if(abstractCommand.canExecute()){
				getEditingDomain().getCommandStack().execute(abstractCommand);
			}
		}
	}  
	/**
	 *  Testi if a possibleSub eclass is a sub eclass
	 * @param aclass
	 * @param possibleSubClasse
	 * @return true if possible eclas is a subtype of a eclass or false
	 */
	public boolean isSubClass(EClassifier aclass, EClass possibleSubClasse){
		if(aclass.equals(possibleSubClasse)){
			return true;
		}
		EList<EClass> superTypeList=possibleSubClasse.getEAllSuperTypes();
		if(superTypeList.contains(aclass)){
			return true;
		}
		return false;
	}

	@Override
	public IStatus validateDrop(Object target, int operation,
			TransferData transferType) {
		List<Command> commandList=getDropCommand(target);
		if(canDrop(commandList)){

			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}
/**
 * get the list of commands to drop an element 
 * @param target
 * @return the list of the commands
 */
	protected List<Command> getDropCommand(final Object target) {

		//init
		ArrayList<Command> result= new ArrayList<Command>();
		EObject targetEObject=null;

		//target is an EObject?
		if(target instanceof IAdaptable){
			targetEObject= ((EObject)((IAdaptable)target).getAdapter(EObject.class));
		}
		if(targetEObject==null){
			return result;
		}

		//get Command from the selection
		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
		if (selection instanceof IStructuredSelection) {
			List<?> selectedElements = ((IStructuredSelection) selection).toList();
			Iterator<?> it=selectedElements.iterator();
			while (it.hasNext()) {
				Object object =  it.next();
				if (object instanceof IAdaptable) {
					EObject eObjectchild = (EObject) ((IAdaptable) object).getAdapter(EObject.class);
					//test if object is an eobject
					if(eObjectchild!=null){

						result.addAll(getDropCommand(getEditingDomain(), targetEObject, eObjectchild));
					}
				}
			}
		}
		return result;
	}

/**
 * get the editing domain
 * @return  get the Transaction Editing Domain
 */
	protected TransactionalEditingDomain getEditingDomain() {
		return EditorUtils.getTransactionalEditingDomain();
	}
	
/**
 * 
 * @return multiDiagramEditor
 */
	protected IMultiDiagramEditor getMultiDiagramEditor() {
		IEditorPart editorPart = PlatformUI.getWorkbench()
		.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editorPart instanceof IMultiDiagramEditor) {
			return (IMultiDiagramEditor) editorPart;
		}
		return null;
	}
}
