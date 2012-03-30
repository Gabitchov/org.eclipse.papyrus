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
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.core.adaptor.gmf.MoveOpenableCommand;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.notation.NotationModel;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
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
	protected Command getDropIntoCommand(TransactionalEditingDomain domain,EObject targetOwner, EObject childElement,EReference eref){
		MoveRequest moveRequest= new MoveRequest(targetOwner, childElement);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand command = provider.getEditCommand(moveRequest);

			if(command != null) {
				return new GMFtoEMFCommandWrapper(command);
			}

		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the creation command registry to test when diagrams can be created
	 * @return instance
	 */
	private static ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
	}

	/**
	 * get a list that contains command to move a diagram into a new element
	 * @param domain the transactionnal edit domain, cannot be null
	 * @param targetOwner the target of the drop, cannot be null
	 * @param childElement the diagram that will move, cannot be null
	 * @return a list that contains one command to move the diagram
	 */
	protected Command getDropDiagramIntoCommand(TransactionalEditingDomain domain,EObject targetOwner, Diagram childElement){
		EReference eref = NotationPackage.eINSTANCE.getView_Element();
		if(eref != null) {
			String diagType = childElement.getType();
			ICreationCommand correctCommandDescription = null;
			// check if diagram can exist in new location
			for(CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
				if(desc.getCondition() == null || desc.getCondition().create(targetOwner)) {
					try {
						ICreationCommand cmd = desc.getCommand();
						String type = cmd.getCreatedDiagramType();
						if(diagType == null || diagType.equals(type)) {
							// the descriptor correspond to existing diagram's type
							correctCommandDescription = cmd;
							break;
						}
					} catch (BackboneException e) {
						Activator.log.error(e);
						// stop here with unexecutable command
						return UnexecutableCommand.INSTANCE;
					}
				}
			}
			// check if diagram can be moved
			if(correctCommandDescription != null && correctCommandDescription.isParentReassignable()) {
				SetRequest setRequest = new SetRequest(childElement, eref, targetOwner);
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(childElement);
				if(provider != null) {
					// Retrieve reassignment command from the Element Edit service
					ICommand command = provider.getEditCommand(setRequest);

					if(command != null) {
						Resource targetNotationResource = getTargetNotationResource(targetOwner);
						if (targetNotationResource != null && !targetNotationResource.equals(childElement.eResource())) {
							// move diagram in the correct resource
							command = CompositeCommand.compose(command, new MoveOpenableCommand(domain, "", childElement, targetNotationResource));
						}

						return new GMFtoEMFCommandWrapper(command);
					}
				}
			}
		}
		// Failed : stop here with unexecutable command
		return UnexecutableCommand.INSTANCE;
	}

	protected Resource getTargetNotationResource(EObject targetOwner) {
		if (targetOwner.eResource() != null && targetOwner.eResource().getResourceSet() instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)targetOwner.eResource().getResourceSet();
			return modelSet.getAssociatedResource(targetOwner, NotationModel.NOTATION_FILE_EXTENSION);
		}
		return null;
	}

	/**
	 * get the SetRequest to put an eobject before or after another EObject
	 * It will look for the good role of the child eobject, the field set is not complete
	 * @param domain the Transactional Domain, cannot be null
	 * @param targetOwner the eobject that will contain the drop object , cannot be null
	 * @param objectLocation the object where we want to drop the object
	 * @param newElement that we want to move, cannot be null
	 * @return the request to to the drop
	 */
	protected SetRequest getOrderChangeCommand(TransactionalEditingDomain domain,EObject targetOwner,EObject objectLocation, EObject newElement, boolean before){
		SetRequest setRequest=null;
		ArrayList<Command> commandList= new ArrayList<Command>();
		ArrayList<EStructuralFeature> possibleEFeatures= new ArrayList<EStructuralFeature>();
		EList<EStructuralFeature> featureList=targetOwner.eClass().getEAllStructuralFeatures();

		// Abort when trying to change order moving the element in one of its children
		if (EcoreUtil.isAncestor(newElement, targetOwner)) {
			return null;
		}

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

			tmp.add(newElement);
			setRequest= new SetRequest(targetOwner, eStructuralFeature, tmp);
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
			if(provider != null) {
				// Retrieve delete command from the Element Edit service
				ICommand command = provider.getEditCommand(setRequest);

				if(command != null) {
					commandList.add( new GMFtoEMFCommandWrapper(command));
				}
			}
		}
		return setRequest;
	}

	protected void execute(Command dropCommand){
		getEditingDomain().getCommandStack().execute(dropCommand);
	}

	/**
	 * get the list of good command by taking in account if this is a change order or a drop into
	 * @param target the target object of the drop
	 * @return the list of command
	 */
	public CompoundCommand getDrop (Object target) {
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
		return new CompoundCommand(commandList);
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
		Command dropCommand = getDrop(target);
		if(dropCommand.canExecute()){
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
		CompoundCommand cc= new CompoundCommand();
		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
		if (selection instanceof IStructuredSelection) {
			List<?> selectedElements = ((IStructuredSelection) selection).toList();
			ArrayList<EObject> elementsToMove= new ArrayList<EObject>();
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
					cc.append(getDropDiagramIntoCommand(getEditingDomain(), targetEObject,(Diagram) eObjectchild));
				}
				//test if object is an eobject
				else if(eObjectchild!=null){
					elementsToMove.add(eObjectchild);		
				}

			}
			if( elementsToMove.size()!=0){
				MoveRequest moveRequest= new MoveRequest(targetEObject, elementsToMove);
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetEObject);
				if(provider != null) {
					// Retrieve delete command from the Element Edit service
					ICommand command = provider.getEditCommand(moveRequest);

					if(command != null) {
						cc.append( new GMFtoEMFCommandWrapper(command));
					}

				}
				else{
					cc.append(UnexecutableCommand.INSTANCE);}
			}
		}
		result.add(cc);
		return result;
	}

	/**
	 * get the list of commands to drop an element 
	 * @param target, can be null but do nothing
	 * @return the list of the commands
	 */
	@SuppressWarnings("unchecked")
	protected List<Command> getOrderChangeCommand(final Object target, boolean before) {
		ArrayList<Command> result= new ArrayList<Command>();//resulted commands
		CompoundCommand cc= new CompoundCommand();
		ArrayList<EObject> objectToMove= new ArrayList<EObject>(); //object to move
		boolean moveNeeded=false; // if this not the same owner the move command is needed

		//init
		ArrayList<SetRequest> monoRequestList= new ArrayList<SetRequest>();
		EObject objectLocation=null; 
		EObject objectOwner=null; //next container

		//target is an EObject?
		if(target instanceof IAdaptable){
			objectLocation= ((EObject)((IAdaptable)target).getAdapter(EObject.class));
			objectOwner=objectLocation.eContainer();
		}
		if(objectLocation==null){
			return result;
		}

		//get request for each selection
		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
		if (selection instanceof IStructuredSelection) {
			List<?> selectedElements = ((IStructuredSelection) selection).toList();
			Iterator<?> it=selectedElements.iterator();
			while (it.hasNext()) {
				Object object =  it.next();

				if (object instanceof IAdaptable) {
					EObject eObjectchild = (EObject) ((IAdaptable) object).getAdapter(EObject.class);
					//test if object is an eobject
					if(eObjectchild!=null&& objectOwner!=null && eObjectchild.eContainer()!= null){
						if(!eObjectchild.eContainer().equals(objectOwner)){
							moveNeeded=true;
						}
						objectToMove.add(eObjectchild);

					}
				}
			}
		}

		if (!objectToMove.isEmpty()) {
			SetRequest monoRequest=getOrderChangeCommand(getEditingDomain(), objectOwner, objectLocation, objectToMove.get(0), before);
			if( monoRequest!=null){
				monoRequestList.add(monoRequest);


				if( moveNeeded){
					MoveRequest moveRequest= new MoveRequest(objectOwner, objectToMove);
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(moveRequest.getTargetContainer());
					if(provider != null) {
						// Retrieve delete command from the Element Edit service
						ICommand command = provider.getEditCommand(moveRequest);
						cc.append(new GMFtoEMFCommandWrapper(command));
					}
				}

				ArrayList<EObject>values= new ArrayList<EObject>();
				if(objectOwner.eGet(monoRequest.getFeature()) instanceof Collection<?>){
					//get all element of this efeature
					values.addAll((Collection<EObject>)objectOwner.eGet(monoRequest.getFeature()));
				}
				Iterator<EObject>itetToMove= objectToMove.iterator();
				int nextIndex=1;
				while(itetToMove.hasNext()) {
					EObject currentObject = (EObject)itetToMove.next();

					if(objectToMove instanceof List){
						values.remove(currentObject);
						if( values.indexOf(objectLocation)==-1||(values.indexOf(objectLocation)+nextIndex)>values.size()){
							values.add(currentObject);
						}
						else if (before){
							values.add(values.indexOf(objectLocation), currentObject);
						}
						else{
							values.add(values.indexOf(objectLocation)+nextIndex, currentObject);
							nextIndex++;
						}

					}
				}

				//the request is ready to be constructed
				monoRequest= new SetRequest(monoRequest.getElementToEdit(), monoRequest.getFeature(), values);
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(monoRequest.getElementToEdit());
				if(provider != null) {
					// Retrieve delete command from the Element Edit service
					ICommand command = provider.getEditCommand(monoRequest);
					cc.append(new GMFtoEMFCommandWrapper(command));
				}


				result.add(cc);
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
