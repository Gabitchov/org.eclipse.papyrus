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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.command.MoveCommand;

import org.eclipse.uml2.uml.PartDecomposition;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Action;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class PartDecompositionBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private PartDecomposition partDecomposition;

	/**
	 * The Base part
	 */
	private PartDecompositionPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public PartDecompositionBasePropertiesEditionComponent(EObject partDecomposition, String editing_mode) {
		if (partDecomposition instanceof PartDecomposition) {
			this.partDecomposition = (PartDecomposition) partDecomposition;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.partDecomposition.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
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
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getComment())) {
					basePart.updateOwnedComment(partDecomposition);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(partDecomposition);
				if (UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(msg.getFeature()))
					basePart.updateCovered(partDecomposition);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getGeneralOrdering())) {
					basePart.updateGeneralOrdering(partDecomposition);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getInteractionUse_ActualGate() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getGate())) {
					basePart.updateActualGate(partDecomposition);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getInteractionUse_Argument() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getAction())) {
					basePart.updateArgument(partDecomposition);
				}

			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return UMLViewsRepository.PartDecomposition.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (partDecomposition != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (PartDecompositionPropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.PartDecomposition.class, kind, this);
					listeners.add(basePart);
				}
			}
			return (IPropertiesEditionPart) basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == UMLViewsRepository.PartDecomposition.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			PartDecomposition partDecomposition = (PartDecomposition) elt;
			basePart.initOwnedComment(partDecomposition, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (partDecomposition.getName() != null)
				basePart.setName(partDecomposition.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), partDecomposition.getVisibility());
			basePart.initClientDependency(partDecomposition, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initCovered(partDecomposition, null, UMLPackage.eINSTANCE.getInteractionFragment_Covered());
			basePart.initGeneralOrdering(partDecomposition, null, UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering());
			basePart.initActualGate(partDecomposition, null, UMLPackage.eINSTANCE.getInteractionUse_ActualGate());
			basePart.initArgument(partDecomposition, null, UMLPackage.eINSTANCE.getInteractionUse_Argument());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (partDecomposition != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
			for (Iterator iter = ownedCommentToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List coveredToAdd = basePart.getCoveredToAdd();
			for (Iterator iter = coveredToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), iter.next()));
			List coveredToRemove = basePart.getCoveredToRemove();
			for (Iterator iter = coveredToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), iter.next()));
			// List coveredToMove = basePart.getCoveredToMove();
			// for (Iterator iter = coveredToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getLifeline(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List generalOrderingToAdd = basePart.getGeneralOrderingToAdd();
			for (Iterator iter = generalOrderingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering(), iter.next()));
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
			for (Iterator iter = generalOrderingToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getGeneralOrdering(), moveElement.getElement(), moveElement.getIndex()));
			}
			List actualGateToAdd = basePart.getActualGateToAdd();
			for (Iterator iter = actualGateToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionUse_ActualGate(), iter.next()));
			Map actualGateToRefresh = basePart.getActualGateToEdit();
			for (Iterator iter = actualGateToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for actualGate reference refreshment

				Gate nextElement = (Gate) iter.next();
				Gate actualGate = (Gate) actualGateToRefresh.get(nextElement);

				// End of user code
			}
			List actualGateToRemove = basePart.getActualGateToRemove();
			for (Iterator iter = actualGateToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List actualGateToMove = basePart.getActualGateToMove();
			for (Iterator iter = actualGateToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getGate(), moveElement.getElement(), moveElement.getIndex()));
			}
			List argumentToAdd = basePart.getArgumentToAdd();
			for (Iterator iter = argumentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionUse_Argument(), iter.next()));
			Map argumentToRefresh = basePart.getArgumentToEdit();
			for (Iterator iter = argumentToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for argument reference refreshment

				Action nextElement = (Action) iter.next();
				Action argument = (Action) argumentToRefresh.get(nextElement);

				// End of user code
			}
			List argumentToRemove = basePart.getArgumentToRemove();
			for (Iterator iter = argumentToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List argumentToMove = basePart.getArgumentToMove();
			for (Iterator iter = argumentToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, partDecomposition, UMLPackage.eINSTANCE.getAction(), moveElement.getElement(), moveElement.getIndex()));
			}

		}
		if (!cc.isEmpty())
			return cc;
		cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof PartDecomposition) {
			PartDecomposition partDecompositionToUpdate = (PartDecomposition) source;
			partDecompositionToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			partDecompositionToUpdate.setName(basePart.getName());

			partDecompositionToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			partDecompositionToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			partDecompositionToUpdate.getCovereds().addAll(basePart.getCoveredToAdd());
			partDecompositionToUpdate.getGeneralOrderings().addAll(basePart.getGeneralOrderingToAdd());
			partDecompositionToUpdate.getActualGates().addAll(basePart.getActualGateToAdd());
			partDecompositionToUpdate.getArguments().addAll(basePart.getArgumentToAdd());

			return partDecompositionToUpdate;
		} else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if (UMLViewsRepository.PartDecomposition.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the partDecomposition update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.PartDecomposition.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.PartDecomposition.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.PartDecomposition.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.PartDecomposition.covered == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.PartDecomposition.generalOrdering == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					GeneralOrdering oldValue = (GeneralOrdering) event.getOldValue();
					GeneralOrdering newValue = (GeneralOrdering) event.getNewValue();

					// Start of user code for generalOrdering live update command
					// TODO: Complete the partDecomposition update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getGeneralOrdering(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.PartDecomposition.actualGate == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Gate oldValue = (Gate) event.getOldValue();
					Gate newValue = (Gate) event.getNewValue();

					// Start of user code for actualGate live update command
					// TODO: Complete the partDecomposition update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionUse_ActualGate(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getGate(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.PartDecomposition.argument == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Action oldValue = (Action) event.getOldValue();
					Action newValue = (Action) event.getNewValue();

					// Start of user code for argument live update command
					// TODO: Complete the partDecomposition update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getInteractionUse_Argument(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, partDecomposition, UMLPackage.eINSTANCE.getAction(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.PartDecomposition.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.PartDecomposition.name == event.getAffectedEditor())
					basePart.unsetMessageForName();

			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.PartDecomposition.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.PartDecomposition.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.PartDecomposition.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.PartDecomposition.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.PartDecomposition.covered)
			return "References the Lifelines that the InteractionFragment involves."; //$NON-NLS-1$
		if (key == UMLViewsRepository.PartDecomposition.generalOrdering)
			return "The general ordering relationships contained in this fragment."; //$NON-NLS-1$
		if (key == UMLViewsRepository.PartDecomposition.actualGate)
			return "The actual gates of the InteractionUse"; //$NON-NLS-1$
		if (key == UMLViewsRepository.PartDecomposition.argument)
			return "The actual arguments of the Interaction"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		Diagnostic ret = null;
		try {
			if (UMLViewsRepository.PartDecomposition.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.PartDecomposition.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
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
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			return Diagnostician.INSTANCE.validate(copy);
		} else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			return Diagnostician.INSTANCE.validate(partDecomposition);
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
			partDecomposition.eAdapters().remove(semanticAdapter);
	}

}
