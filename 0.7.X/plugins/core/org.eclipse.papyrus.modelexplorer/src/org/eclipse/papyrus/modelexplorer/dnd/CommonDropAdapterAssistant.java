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
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmt.modisco.infra.browser.core.LinkItemEx;
import org.eclipse.gmt.modisco.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.gmt.modisco.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.navigator.NavigatorContentService;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonViewer;

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
		execute(getDrop(targetElement));
		return null;
	}

	/**
	 * get the list of command to put an eobject into another EObject,
	 * if the parameter eref is null,It will look for the good role of the child eobject
	 * @param domain the Transactional Domain , cannot be null
	 * @param targetOwner the eobject that will contain the drop object, cannot be null
	 * @param childElement that we want to move, cannot be null
	 * @param the EREFERENCE for the role of the child element, can be null
	 * @return the list of commands to to the drop
	 */
	@SuppressWarnings("unchecked")
	protected List<Command> getDropIntoCommand(TransactionalEditingDomain domain,EObject targetOwner, EObject childElement,EReference eref){
		ArrayList<Command> commandList= new ArrayList<Command>();
		
		//try to crete a command on for this reference
		if(eref!=null){
			ArrayList<EObject> tmp=new ArrayList<EObject>();
			tmp.add(childElement);
			if(targetOwner.eGet(eref) instanceof Collection<?>){
				tmp.addAll((Collection<EObject>)targetOwner.eGet(eref));}
			commandList.add( SetCommand.create(domain, targetOwner, eref, tmp));
		}

		else{
			//ref is null
			ArrayList<EStructuralFeature> possibleEFeatures= new ArrayList<EStructuralFeature>();
			EList<EStructuralFeature> featureList=targetOwner.eClass().getEAllStructuralFeatures();
			
			//look for all possible feature betwen the owner and the child element
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
			//for each feature create a  set command 
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
		}
		return commandList;
	}

	/**
	 * get a list that contains command to move a diagram into a new element
	 * @param domain the transactionnal edit domain, cannot be null
	 * @param targetOwner the target of the drop, cannot be null
	 * @param childElement the diagram that will move, cannot be null
	 * @return a list that contains one command to move the diagram
	 */
	protected List<Command> getDropDiagramIntoCommand(TransactionalEditingDomain domain,EObject targetOwner, Diagram childElement){
		ArrayList<Command> commandList= new ArrayList<Command>();
		EReference eref= NotationPackage.eINSTANCE.getView_Element();
		if(eref!=null){
			ArrayList<EObject> tmp=new ArrayList<EObject>();
			tmp.add(childElement);
			if(targetOwner.eGet(eref) instanceof Collection<?>){
				tmp.addAll((Collection<EObject>)targetOwner.eGet(eref));}

			commandList.add( SetCommand.create(domain, childElement, eref, targetOwner));
		}


		return commandList;
	}
	/**
	 * get the list of command to put an eobject before or after another EObject
	 * It will look for the good role of the child eobject
	 * @param domain the Transactional Domain, cannot be null
	 * @param targetOwner the eobject that will contain the drop object , cannot be null
	 * @param objectLocation the object where we want to drop the object
	 * @param newElement that we want to move, cannot be null
	 * @return the list of commands to to the drop
	 */
	protected List<Command> getOrderChangeCommand(TransactionalEditingDomain domain,EObject targetOwner,EObject objectLocation, EObject newElement, boolean before){
		ArrayList<Command> commandList= new ArrayList<Command>();
		ArrayList<EStructuralFeature> possibleEFeatures= new ArrayList<EStructuralFeature>();
		EList<EStructuralFeature> featureList=targetOwner.eClass().getEAllStructuralFeatures();
		
		//find the feature between childreen and owner
		Iterator<EStructuralFeature> iterator= featureList.iterator();
		while (iterator.hasNext()) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) iterator.next();

			if( eStructuralFeature instanceof EReference){
				EReference ref= (EReference)eStructuralFeature;

				if( ref.isContainment()){

					if( isSubClass(ref.getEType(),newElement.eClass() )){
						possibleEFeatures.add(eStructuralFeature);
					}

				}
			}
		}
		
		//create the command
		Iterator<EStructuralFeature> iteratorFeature= possibleEFeatures.iterator();
		while (iteratorFeature.hasNext()) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) iteratorFeature
			.next();
			ArrayList<EObject> tmp=new ArrayList<EObject>();
			if(targetOwner.eGet(eStructuralFeature) instanceof Collection<?>){
				//get all element of this efeature
				tmp.addAll((Collection<EObject>)targetOwner.eGet(eStructuralFeature));

				if(!newElement.equals(objectLocation)){
					tmp.remove(newElement);
					//normally tmp.indexOf(objectLocation)!= -1 
					//if this the case objectlocation=new element and
					//it has been removed
					int indexObject=tmp.indexOf(objectLocation);
					if( before&& indexObject!=-1){
						tmp.add(tmp.indexOf(objectLocation), newElement);
					}
					else if( !before&& indexObject!=-1){
						tmp.add(tmp.indexOf(objectLocation)+1, newElement);
					}
				}
			}
			else{tmp.add(newElement);
			}
			commandList.add( SetCommand.create(domain, targetOwner, eStructuralFeature, tmp));

		}
		return commandList;
	}


	/**
	 * verify from a list of command if it can be dropped
	 * @param commandList, cannot be null but can be an empty list
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
	 * get the list of good command by taking in account if this is a change order or a drop into
	 * @param target the target object of the drop
	 * @return the list of command
	 */
	public List<Command> getDrop (Object target) {
		CommonDropAdapter dropAdapter =getCommonDropAdapter();
		List<Command> commandList=new ArrayList<Command>();
		switch (dropAdapter.getCurrentOperation()) {
		case DND.DROP_MOVE:
			if(dropAdapter.getCurrentLocation()==ViewerDropAdapter.LOCATION_BEFORE){
				if(target instanceof ModelElementItem){
					commandList=getOrderChangeCommand(target, true);
				}
			}
			else if(dropAdapter.getCurrentLocation()==ViewerDropAdapter.LOCATION_AFTER){
				if(target instanceof ModelElementItem){
					commandList=getOrderChangeCommand(target, false);
				}
			}
			else if(dropAdapter.getCurrentLocation()==ViewerDropAdapter.LOCATION_ON){
				if(target instanceof ModelElementItem){
					commandList=getDropIntoCommand(target, null);}
				if(target instanceof LinkItem){
					commandList=getDropIntoCommand(((LinkItem)target).getParent(),((LinkItem)target).getReference() );}
			}

			else if(dropAdapter.getCurrentLocation()==ViewerDropAdapter.LOCATION_NONE){
			}
			break;
		}
		return commandList;
	}
	/**
	 *  Test if a possibleSub eclass is a sub eclass
	 * @param aclass, cannot be null
	 * @param possibleSubClasse, cannot be null
	 * @return true if possible eclass is a subtype of a eclass or false
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
		List<Command> commandList=getDrop(target);
		//List<Command> commandList=getDropCommand(target);
		if(canDrop(commandList)){
			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}

	/**
	 * get the list of commands to drop an element 
	 * @param target, can be null but do nothing
	 * @param the role where there is a drop ( can be null)
	 * @return the list of the commands
	 */
	protected List<Command> getDropIntoCommand(final Object target, EReference eref) {

		//init
		ArrayList<Command> result= new ArrayList<Command>();
		EObject targetEObject=null;

		//target is an EObject?
		if(target instanceof EObject){
			targetEObject= ((EObject)target);
		}
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
				EObject eObjectchild=null;
				if (object instanceof IAdaptable) {
					eObjectchild = (EObject) ((IAdaptable) object).getAdapter(EObject.class);
				}
				else if(object instanceof EObject){
					eObjectchild=(EObject)object;
				}

				if(eObjectchild instanceof Diagram){
					result.addAll(getDropDiagramIntoCommand(getEditingDomain(), targetEObject,(Diagram) eObjectchild));
				}
				//test if object is an eobject
				else if(eObjectchild!=null){

					result.addAll(getDropIntoCommand(getEditingDomain(), targetEObject, eObjectchild, eref));
				}

			}
		}

		return result;
	}

	/**
	 * get the list of commands to drop an element 
	 * @param target, can be null but do nothing
	 * @return the list of the commands
	 */
	protected List<Command> getOrderChangeCommand(final Object target, boolean before) {

		//init
		ArrayList<Command> result= new ArrayList<Command>();
		EObject objectLocation=null;
		EObject objectOwner=null;

		//target is an EObject?
		if(target instanceof IAdaptable){
			objectLocation= ((EObject)((IAdaptable)target).getAdapter(EObject.class));
			objectOwner=objectLocation.eContainer();
		}
		if(objectLocation==null){
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
					if(eObjectchild!=null&& objectOwner!=null){

						result.addAll(getOrderChangeCommand(getEditingDomain(), objectOwner, objectLocation, eObjectchild, before));
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
