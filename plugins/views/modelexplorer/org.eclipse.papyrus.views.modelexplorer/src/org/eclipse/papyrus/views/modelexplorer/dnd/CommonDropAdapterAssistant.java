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

package org.eclipse.papyrus.views.modelexplorer.dnd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.commands.MoveOpenableCommand;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;

/**
 * this class manage the drop inside the model explorer
 */
public class CommonDropAdapterAssistant extends org.eclipse.ui.navigator.CommonDropAdapterAssistant {

	public CommonDropAdapterAssistant() {
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter dropAdapter, DropTargetEvent dropTargetEvent, Object dropTarget) {
		EObject targetElement = EMFHelper.getEObject(dropTarget);

		execute(getEditingDomain(targetElement), getDrop(dropTarget));
		return null;
	}

	/**
	 * get the list of command to put an eobject into another EObject,
	 * if the parameter eref is null,It will look for the good role of the child eobject
	 * 
	 * @param domain
	 *        the Transactional Domain , cannot be null
	 * @param targetOwner
	 *        the eobject that will contain the drop object, cannot be null
	 * @param childElement
	 *        that we want to move, cannot be null
	 * @param the
	 *        EREFERENCE for the role of the child element, can be null
	 * @return the list of commands to to the drop
	 */
	protected List<Command> getDropIntoCommand(TransactionalEditingDomain domain, EObject targetOwner, EObject childElement, EReference eref) {
		ArrayList<Command> commandList = new ArrayList<Command>();
		MoveRequest moveRequest = new MoveRequest(targetOwner, childElement);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand command = provider.getEditCommand(moveRequest);

			if(command != null) {
				commandList.add(new GMFtoEMFCommandWrapper(command));
			}

		}
		return commandList;
	}

	/**
	 * Get the creation command registry to test when diagrams can be created
	 * 
	 * @return instance
	 */
	private static ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
	}

	/**
	 * get a list that contains command to move a view into a new element
	 * 
	 * @param domain
	 *        the transactionnal edit domain, cannot be null
	 * @param target
	 *        the target of the drop, cannot be null
	 * @param view
	 *        the diagram that will move, cannot be null
	 * @return a list that contains one command to move the diagram
	 */
	protected Command getDropViewCommands(TransactionalEditingDomain domain, EObject target, EObject view) {
		
		
		ViewPrototype proto = ViewPrototype.get(view);
		
		// check if diagram can exist in new location
		if (!proto.isOwnerReassignable() || !PolicyChecker.getCurrent().canOwnNewView(target, proto)) {
			// stop here with unexecutable command
			return UnexecutableCommand.INSTANCE;
		}
		
		// Retrieve reassignment command from the Element Edit service
		Command command = proto.getCommandChangeOwner(view, target);

		if(command != null) {
			Resource targetNotationResource = getTargetNotationResource(target);
			if(targetNotationResource != null) {
				if(!targetNotationResource.equals(view.eResource())) {
					List<Command> list = new ArrayList<Command>();
					list.add(command);
					list.add(new GMFtoEMFCommandWrapper(new MoveOpenableCommand(domain, "", view, targetNotationResource)));
					return new CompoundCommand(list);
				} else { // diagram stays in the same resource. Only execute the set command
					return command;
				}
			}
		}
		
		// Failed : stop here with unexecutable command
		return UnexecutableCommand.INSTANCE;
	}

	protected Resource getTargetNotationResource(EObject targetOwner) {
		if(targetOwner.eResource() != null && targetOwner.eResource().getResourceSet() instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)targetOwner.eResource().getResourceSet();
			return modelSet.getAssociatedResource(targetOwner, NotationModel.NOTATION_FILE_EXTENSION);
		}
		return null;
	}

	/**
	 * get the list of command to put an eobject before or after another EObject
	 * It will look for the good role of the child eobject
	 * 
	 * @param domain
	 *        the Transactional Domain, cannot be null
	 * @param targetOwner
	 *        the eobject that will contain the drop object , cannot be null
	 * @param objectLocation
	 *        the object where we want to drop the object
	 * @param newElement
	 *        that we want to move, cannot be null
	 * @return the list of commands to to the drop
	 */
	protected List<Command> getOrderChangeCommand(TransactionalEditingDomain domain, EObject targetOwner, EObject objectLocation, EObject newElement, boolean before) {
		ArrayList<Command> commandList = new ArrayList<Command>();
		ArrayList<EStructuralFeature> possibleEFeatures = new ArrayList<EStructuralFeature>();
		EList<EStructuralFeature> featureList = targetOwner.eClass().getEAllStructuralFeatures();

		// Abort when trying to change order moving the element in one of its children
		if(EcoreUtil.isAncestor(newElement, targetOwner)) {
			return Collections.emptyList();
		}

		//find the feature between childreen and owner
		Iterator<EStructuralFeature> iterator = featureList.iterator();
		while(iterator.hasNext()) {
			EStructuralFeature eStructuralFeature = iterator.next();

			if(eStructuralFeature instanceof EReference) {
				EReference ref = (EReference)eStructuralFeature;

				if(ref.isContainment()) {

					if(isSubClass(ref.getEType(), newElement.eClass())) {
						possibleEFeatures.add(eStructuralFeature);
					}

				}
			}
		}

		//create the command
		Iterator<EStructuralFeature> iteratorFeature = possibleEFeatures.iterator();
		while(iteratorFeature.hasNext()) {
			EStructuralFeature eStructuralFeature = iteratorFeature.next();
			ArrayList<EObject> tmp = new ArrayList<EObject>();
			if(targetOwner.eGet(eStructuralFeature) instanceof Collection<?>) {
				//get all element of this efeature
				tmp.addAll((Collection<EObject>)targetOwner.eGet(eStructuralFeature));

				if(!newElement.equals(objectLocation)) {
					tmp.remove(newElement);
					//normally tmp.indexOf(objectLocation)!= -1
					//if this the case objectlocation=new element and
					//it has been removed
					int indexObject = tmp.indexOf(objectLocation);
					if(before && indexObject != -1) {
						tmp.add(tmp.indexOf(objectLocation), newElement);
					} else if(!before && indexObject != -1) {
						tmp.add(tmp.indexOf(objectLocation) + 1, newElement);
					}
				}
			} else {
				tmp.add(newElement);
			}

			SetRequest setRequest = new SetRequest(targetOwner, eStructuralFeature, tmp);
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
			if(provider != null) {
				// Retrieve delete command from the Element Edit service
				ICommand command = provider.getEditCommand(setRequest);

				if(command != null) {
					commandList.add(new GMFtoEMFCommandWrapper(command));
				}
			}
		}
		return commandList;
	}

	protected void execute(EditingDomain domain, Command dropCommand) {
		domain.getCommandStack().execute(dropCommand);
	}

	/**
	 * get the list of good command by taking in account if this is a change order or a drop into
	 * 
	 * @param target
	 *        the target object of the drop
	 * @return the list of command
	 */
	public CompoundCommand getDrop(Object target) {
		CommonDropAdapter dropAdapter = getCommonDropAdapter();
		List<Command> commandList = new ArrayList<Command>();
		switch(dropAdapter.getCurrentOperation()) {
		case DND.DROP_MOVE:
			if(dropAdapter.getCurrentLocation() == ViewerDropAdapter.LOCATION_BEFORE) {
				if(target instanceof EObjectTreeElement) {
					commandList = getOrderChangeCommand(target, true);
				}
			} else if(dropAdapter.getCurrentLocation() == ViewerDropAdapter.LOCATION_AFTER) {
				if(target instanceof EObjectTreeElement) {
					commandList = getOrderChangeCommand(target, false);
				}
			} else if(dropAdapter.getCurrentLocation() == ViewerDropAdapter.LOCATION_ON) {
				if(target instanceof EObjectTreeElement) {
					commandList = getDropIntoCommand(target, null);
				}
				if(target instanceof EReferenceTreeElement) {
					commandList = getDropIntoCommand(((EReferenceTreeElement)target).getParent(), ((EReferenceTreeElement)target).getEReference());
				}
			}

			else if(dropAdapter.getCurrentLocation() == ViewerDropAdapter.LOCATION_NONE) {
			}
			break;
		}
		return new CompoundCommand(commandList);
	}

	/**
	 * Test if a possibleSub eclass is a sub eclass
	 * 
	 * @param aclass
	 *        , cannot be null
	 * @param possibleSubClasse
	 *        , cannot be null
	 * @return true if possible eclass is a subtype of a eclass or false
	 */
	public boolean isSubClass(EClassifier aclass, EClass possibleSubClasse) {
		if(aclass.equals(possibleSubClasse)) {
			return true;
		}
		EList<EClass> superTypeList = possibleSubClasse.getEAllSuperTypes();
		if(superTypeList.contains(aclass)) {
			return true;
		}
		return false;
	}

	@Override
	public IStatus validateDrop(Object target, int operation, TransferData transferType) {
		Command dropCommand = getDrop(target);
		if(dropCommand.canExecute()) {
			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}

	/**
	 * get the list of commands to drop an element
	 * 
	 * @param target
	 *        , can be null but do nothing
	 * @param the
	 *        role where there is a drop ( can be null)
	 * @return the list of the commands
	 */
	protected List<Command> getDropIntoCommand(final Object target, EReference eref) {

		//init
		ArrayList<Command> result = new ArrayList<Command>();
		EObject targetEObject = null;

		targetEObject = EMFHelper.getEObject(target);
		if(targetEObject == null) {
			return result;
		}

		//get Command from the selection
		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
		if(selection instanceof IStructuredSelection) {
			List<?> selectedElements = ((IStructuredSelection)selection).toList();
			Iterator<?> it = selectedElements.iterator();
			while(it.hasNext()) {
				Object object = it.next();
				EObject eObjectchild =  EMFHelper.getEObject(object);
				
				if (ViewPrototype.isViewObject(eObjectchild) && getEditors(targetEObject).contains(eObjectchild)) {
					result.add(getDropViewCommands(getEditingDomain(targetEObject), targetEObject, eObjectchild));
				}
				//test if object is an eobject
				else if(eObjectchild != null) {
					result.addAll(getDropIntoCommand(getEditingDomain(targetEObject), targetEObject, eObjectchild, eref));
				}

			}
		}

		return result;
	}

	/**
	 * 
	 * @return
	 *         the list of the editors
	 */
	private List<Object> getEditors(EObject context) {
		try {
			return ServiceUtilsForEObject.getInstance().getIPageMngr(context).allPages();
		} catch (ServiceException ex) {
			return Collections.emptyList();
		}
	}

	/**
	 * get the list of commands to drop an element
	 * 
	 * @param target
	 *        , can be null but do nothing
	 * @return the list of the commands
	 */
	protected List<Command> getOrderChangeCommand(final Object target, boolean before) {

		//init
		ArrayList<Command> result = new ArrayList<Command>();
		EObject objectLocation = null;
		EObject objectOwner = null;

		objectLocation = EMFHelper.getEObject(target);
		if(objectLocation == null) {
			return result;
		}

		objectOwner = objectLocation.eContainer();

		//get Command from the selection
		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
		if(selection instanceof IStructuredSelection) {
			List<?> selectedElements = ((IStructuredSelection)selection).toList();
			Iterator<?> it = selectedElements.iterator();
			while(it.hasNext()) {
				Object object = it.next();
					EObject eObjectchild = EMFHelper.getEObject(object);
					//test if object is an eobject
					if(eObjectchild != null && objectOwner != null) {

						result.addAll(getOrderChangeCommand(getEditingDomain(eObjectchild), objectOwner, objectLocation, eObjectchild, before));
					}
			}
		}
		return result;
	}

	/**
	 * get the editing domain
	 * 
	 * @return get the Transaction Editing Domain
	 */
	protected TransactionalEditingDomain getEditingDomain(EObject context) {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(context);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}
}
