/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.components;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.papyrus.tabbedproperties.uml.parts.CombinedFragmentPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CombinedFragmentBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private CombinedFragment combinedFragment;
	
	/**
	 * The Base part
	 */
	private CombinedFragmentPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public CombinedFragmentBasePropertiesEditionComponent(EObject combinedFragment, String mode) {
		if (combinedFragment instanceof CombinedFragment) {
			this.combinedFragment = (CombinedFragment)combinedFragment;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.combinedFragment.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
		this.mode = mode;
	}
	
	/**
	 * Initialize the semantic model listener for live editing mode
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getComment())) {
					basePart.updateOwnedComment(combinedFragment);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature())) {
					basePart.updateClientDependency(combinedFragment);
				}
				if (UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(msg.getFeature())) {
					basePart.updateCovered(combinedFragment);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getGeneralOrdering())) {
					basePart.updateGeneralOrdering(combinedFragment);
				}
				if (UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator().equals(msg.getFeature()) && basePart != null)
					basePart.setInteractionOperator((Enumerator)msg.getNewValue());
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getCombinedFragment_Operand()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getInteractionOperand())) {
					basePart.updateOperand(combinedFragment);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getCombinedFragment_CfragmentGate()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getGate())) {
					basePart.updateCfragmentGate(combinedFragment);
				}


			}

		};
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return UMLViewsRepository.CombinedFragment.class;
		return super.translatePart(key);
	}
	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 * (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (combinedFragment != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (CombinedFragmentPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.CombinedFragment.class, kind, this);
					listeners.add(basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent
	 * 		#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 * 						org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == UMLViewsRepository.CombinedFragment.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			CombinedFragment combinedFragment = (CombinedFragment)elt;
			basePart.initOwnedComment(combinedFragment, null, UMLPackage.eINSTANCE.getElement_OwnedComment());				
			if (combinedFragment.getName() != null)
				basePart.setName(combinedFragment.getName());
				
			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), combinedFragment.getVisibility());				
			basePart.initClientDependency(combinedFragment, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());				
			basePart.initCovered(combinedFragment, null, UMLPackage.eINSTANCE.getInteractionFragment_Covered());				
			basePart.initGeneralOrdering(combinedFragment, null, UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering());				
			basePart.initInteractionOperator((EEnum) UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator().getEType(), combinedFragment.getInteractionOperator());				
			basePart.initOperand(combinedFragment, null, UMLPackage.eINSTANCE.getCombinedFragment_Operand());				
			basePart.initCfragmentGate(combinedFragment, null, UMLPackage.eINSTANCE.getCombinedFragment_CfragmentGate());				
		}

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 * (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (combinedFragment != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
			Map ownedCommentToRefresh = basePart.getOwnedCommentToEdit();
			for (Iterator iter = ownedCommentToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for ownedComment reference refreshment
				
				Comment nextElement = (Comment) iter.next();
				Comment ownedComment = (Comment) ownedCommentToRefresh.get(nextElement);
				
				// End of user code			
			}
			List ownedCommentToRemove = basePart.getOwnedCommentToRemove();
			for (Iterator iter = ownedCommentToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedCommentToMove = basePart.getOwnedCommentToMove();
			for (Iterator iter = ownedCommentToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));
			cc.append(SetCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));
			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMove = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List coveredToAdd = basePart.getCoveredToAdd();
			for (Iterator iter = coveredToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), iter.next()));
			List coveredToRemove = basePart.getCoveredToRemove();
			for (Iterator iter = coveredToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), iter.next()));
			//List coveredToMove = basePart.getCoveredToMove();
			//for (Iterator iter = coveredToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getLifeline(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List generalOrderingToAdd = basePart.getGeneralOrderingToAdd();
			for (Iterator iter = generalOrderingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering(), iter.next()));
			Map generalOrderingToRefresh = basePart.getGeneralOrderingToEdit();
			for (Iterator iter = generalOrderingToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for generalOrdering reference refreshment
				
				GeneralOrdering nextElement = (GeneralOrdering) iter.next();
				GeneralOrdering generalOrdering = (GeneralOrdering) generalOrderingToRefresh.get(nextElement);
				
				// End of user code			
			}
			List generalOrderingToRemove = basePart.getGeneralOrderingToRemove();
			for (Iterator iter = generalOrderingToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List generalOrderingToMove = basePart.getGeneralOrderingToMove();
			for (Iterator iter = generalOrderingToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getGeneralOrdering(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator(), basePart.getInteractionOperator()));
			List operandToAdd = basePart.getOperandToAdd();
			for (Iterator iter = operandToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getCombinedFragment_Operand(), iter.next()));
			Map operandToRefresh = basePart.getOperandToEdit();
			for (Iterator iter = operandToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for operand reference refreshment
				
				InteractionOperand nextElement = (InteractionOperand) iter.next();
				InteractionOperand operand = (InteractionOperand) operandToRefresh.get(nextElement);
				
				// End of user code			
			}
			List operandToRemove = basePart.getOperandToRemove();
			for (Iterator iter = operandToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List operandToMove = basePart.getOperandToMove();
			for (Iterator iter = operandToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getInteractionOperand(), moveElement.getElement(), moveElement.getIndex()));
			}
			List cfragmentGateToAdd = basePart.getCfragmentGateToAdd();
			for (Iterator iter = cfragmentGateToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getCombinedFragment_CfragmentGate(), iter.next()));
			Map cfragmentGateToRefresh = basePart.getCfragmentGateToEdit();
			for (Iterator iter = cfragmentGateToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for cfragmentGate reference refreshment
				
				Gate nextElement = (Gate) iter.next();
				Gate cfragmentGate = (Gate) cfragmentGateToRefresh.get(nextElement);
				
				// End of user code			
			}
			List cfragmentGateToRemove = basePart.getCfragmentGateToRemove();
			for (Iterator iter = cfragmentGateToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List cfragmentGateToMove = basePart.getCfragmentGateToMove();
			for (Iterator iter = cfragmentGateToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, combinedFragment, UMLPackage.eINSTANCE.getGate(), moveElement.getElement(), moveElement.getIndex()));
			}


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject
	 * ()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof CombinedFragment) {
			CombinedFragment combinedFragmentToUpdate = (CombinedFragment)source;
			combinedFragmentToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			combinedFragmentToUpdate.setName(basePart.getName());
			combinedFragmentToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());
			combinedFragmentToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			combinedFragmentToUpdate.getCovereds().addAll(basePart.getCoveredToAdd());
			combinedFragmentToUpdate.getGeneralOrderings().addAll(basePart.getGeneralOrderingToAdd());
			combinedFragmentToUpdate.setInteractionOperator((InteractionOperatorKind)basePart.getInteractionOperator());
			combinedFragmentToUpdate.getOperands().addAll(basePart.getOperandToAdd());
			combinedFragmentToUpdate.getCfragmentGates().addAll(basePart.getCfragmentGateToAdd());


			return combinedFragmentToUpdate;
		}
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PathedPropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
			CompoundCommand command = new CompoundCommand();
			if (UMLViewsRepository.CombinedFragment.ownedComment == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();
					// Start of user code for ownedComment live update command
					// TODO: Complete the combinedFragment update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CombinedFragment.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));	

			if (UMLViewsRepository.CombinedFragment.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.CombinedFragment.clientDependency == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CombinedFragment.covered == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CombinedFragment.generalOrdering == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					GeneralOrdering oldValue = (GeneralOrdering)event.getOldValue();
					GeneralOrdering newValue = (GeneralOrdering)event.getNewValue();
					// Start of user code for generalOrdering live update command
					// TODO: Complete the combinedFragment update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getGeneralOrdering(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CombinedFragment.interactionOperator == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator(), event.getNewValue()));

			if (UMLViewsRepository.CombinedFragment.operand == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					InteractionOperand oldValue = (InteractionOperand)event.getOldValue();
					InteractionOperand newValue = (InteractionOperand)event.getNewValue();
					// Start of user code for operand live update command
					// TODO: Complete the combinedFragment update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getCombinedFragment_Operand(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getInteractionOperand(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CombinedFragment.cfragmentGate == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Gate oldValue = (Gate)event.getOldValue();
					Gate newValue = (Gate)event.getNewValue();
					// Start of user code for cfragmentGate live update command
					// TODO: Complete the combinedFragment update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getCombinedFragment_CfragmentGate(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, combinedFragment, UMLPackage.eINSTANCE.getGate(), event.getNewValue(), event.getNewIndex()));
			}


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				
				if (UMLViewsRepository.CombinedFragment.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				
				
				
				
				
				


			} else {
				
				if (UMLViewsRepository.CombinedFragment.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				
				
				
				
				
				
				


			}
		}
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.CombinedFragment.interactionOperator || key == UMLViewsRepository.CombinedFragment.operand;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
			if (key == UMLViewsRepository.CombinedFragment.ownedComment)
				return "The Comments owned by this element."; //$NON-NLS-1$
			if (key == UMLViewsRepository.CombinedFragment.name)
				return "The name of the NamedElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.CombinedFragment.visibility)
				return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
			if (key == UMLViewsRepository.CombinedFragment.clientDependency)
				return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
			if (key == UMLViewsRepository.CombinedFragment.covered)
				return "References the Lifelines that the InteractionFragment involves."; //$NON-NLS-1$
			if (key == UMLViewsRepository.CombinedFragment.generalOrdering)
				return "The general ordering relationships contained in this fragment."; //$NON-NLS-1$
			if (key == UMLViewsRepository.CombinedFragment.interactionOperator)
				return "Specifies the operation which defines the semantics of this combination of InteractionFragments."; //$NON-NLS-1$
			if (key == UMLViewsRepository.CombinedFragment.operand)
				return "The set of operands of the combined fragment."; //$NON-NLS-1$
			if (key == UMLViewsRepository.CombinedFragment.cfragmentGate)
				return "Specifies the gates that form the interface between this CombinedFragment and its surroundings"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PathedPropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		Diagnostic ret = null;
		try {
			if (UMLViewsRepository.CombinedFragment.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.CombinedFragment.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.CombinedFragment.interactionOperator == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator().getEAttributeType(), newValue);
			}

		} catch (IllegalArgumentException iae) {
			ret = BasicDiagnostic.toDiagnostic(iae);
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		if (IPropertiesEditionComponent.BATCH_MODE.equals(mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			return Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(mode))
			return Diagnostician.INSTANCE.validate(combinedFragment);
		else
			return null;
	}
	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			combinedFragment.eAdapters().remove(semanticAdapter);
	}

}

