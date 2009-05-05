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

import org.eclipse.uml2.uml.OccurrenceSpecification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.GeneralOrdering;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.OccurrenceSpecificationPropertiesEditionPart;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class OccurrenceSpecificationBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private OccurrenceSpecification occurrenceSpecification;

	/**
	 * The Base part
	 */
	private OccurrenceSpecificationPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public OccurrenceSpecificationBasePropertiesEditionComponent(EObject occurrenceSpecification, String editing_mode) {
		if (occurrenceSpecification instanceof OccurrenceSpecification) {
			this.occurrenceSpecification = (OccurrenceSpecification) occurrenceSpecification;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.occurrenceSpecification.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(occurrenceSpecification);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(occurrenceSpecification);
				if (UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(msg.getFeature()))
					basePart.updateCovered(occurrenceSpecification);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getGeneralOrdering())) {
					basePart.updateGeneralOrdering(occurrenceSpecification);
				}
				if (UMLPackage.eINSTANCE.getOccurrenceSpecification_ToBefore().equals(msg.getFeature()))
					basePart.updateToBefore(occurrenceSpecification);
				if (UMLPackage.eINSTANCE.getOccurrenceSpecification_ToAfter().equals(msg.getFeature()))
					basePart.updateToAfter(occurrenceSpecification);

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
			return UMLViewsRepository.OccurrenceSpecification.class;
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
		if (occurrenceSpecification != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (OccurrenceSpecificationPropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.OccurrenceSpecification.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.OccurrenceSpecification.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification) elt;
			basePart.initOwnedComment(occurrenceSpecification, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (occurrenceSpecification.getName() != null)
				basePart.setName(occurrenceSpecification.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), occurrenceSpecification.getVisibility());
			basePart.initClientDependency(occurrenceSpecification, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initCovered(occurrenceSpecification, null, UMLPackage.eINSTANCE.getInteractionFragment_Covered());
			basePart.initGeneralOrdering(occurrenceSpecification, null, UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering());
			basePart.initToBefore(occurrenceSpecification, null, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToBefore());
			basePart.initToAfter(occurrenceSpecification, null, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToAfter());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (occurrenceSpecification != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List coveredToAdd = basePart.getCoveredToAdd();
			for (Iterator iter = coveredToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), iter.next()));
			List coveredToRemove = basePart.getCoveredToRemove();
			for (Iterator iter = coveredToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), iter.next()));
			// List coveredToMove = basePart.getCoveredToMove();
			// for (Iterator iter = coveredToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getLifeline(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List generalOrderingToAdd = basePart.getGeneralOrderingToAdd();
			for (Iterator iter = generalOrderingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getGeneralOrdering(), moveElement.getElement(), moveElement.getIndex()));
			}
			List toBeforeToAdd = basePart.getToBeforeToAdd();
			for (Iterator iter = toBeforeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToBefore(), iter.next()));
			List toBeforeToRemove = basePart.getToBeforeToRemove();
			for (Iterator iter = toBeforeToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToBefore(), iter.next()));
			// List toBeforeToMove = basePart.getToBeforeToMove();
			// for (Iterator iter = toBeforeToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getGeneralOrdering(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List toAfterToAdd = basePart.getToAfterToAdd();
			for (Iterator iter = toAfterToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToAfter(), iter.next()));
			List toAfterToRemove = basePart.getToAfterToRemove();
			for (Iterator iter = toAfterToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToAfter(), iter.next()));
			// List toAfterToMove = basePart.getToAfterToMove();
			// for (Iterator iter = toAfterToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getGeneralOrdering(), moveElement.getElement(), moveElement.getIndex()));
			// }

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
		if (source instanceof OccurrenceSpecification) {
			OccurrenceSpecification occurrenceSpecificationToUpdate = (OccurrenceSpecification) source;
			occurrenceSpecificationToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			occurrenceSpecificationToUpdate.setName(basePart.getName());

			occurrenceSpecificationToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			occurrenceSpecificationToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			occurrenceSpecificationToUpdate.getCovereds().addAll(basePart.getCoveredToAdd());
			occurrenceSpecificationToUpdate.getGeneralOrderings().addAll(basePart.getGeneralOrderingToAdd());
			occurrenceSpecificationToUpdate.getToBefores().addAll(basePart.getToBeforeToAdd());
			occurrenceSpecificationToUpdate.getToAfters().addAll(basePart.getToAfterToAdd());

			return occurrenceSpecificationToUpdate;
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
			if (UMLViewsRepository.OccurrenceSpecification.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the occurrenceSpecification update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.OccurrenceSpecification.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.OccurrenceSpecification.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.OccurrenceSpecification.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.OccurrenceSpecification.covered == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.OccurrenceSpecification.generalOrdering == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					GeneralOrdering oldValue = (GeneralOrdering) event.getOldValue();
					GeneralOrdering newValue = (GeneralOrdering) event.getNewValue();

					// Start of user code for generalOrdering live update command
					// TODO: Complete the occurrenceSpecification update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getInteractionFragment_GeneralOrdering(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getGeneralOrdering(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.OccurrenceSpecification.toBefore == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToBefore(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToBefore(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command
							.append(MoveCommand
									.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToBefore(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.OccurrenceSpecification.toAfter == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToAfter(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToAfter(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, occurrenceSpecification, UMLPackage.eINSTANCE.getOccurrenceSpecification_ToAfter(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.OccurrenceSpecification.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.OccurrenceSpecification.name == event.getAffectedEditor())
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
		if (key == UMLViewsRepository.OccurrenceSpecification.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.OccurrenceSpecification.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.OccurrenceSpecification.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.OccurrenceSpecification.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.OccurrenceSpecification.covered)
			return "References the Lifelines that the InteractionFragment involves."; //$NON-NLS-1$
		if (key == UMLViewsRepository.OccurrenceSpecification.generalOrdering)
			return "The general ordering relationships contained in this fragment."; //$NON-NLS-1$
		if (key == UMLViewsRepository.OccurrenceSpecification.toBefore)
			return "References the GeneralOrderings that specify EventOcurrences that must occur before this OccurrenceSpecification"; //$NON-NLS-1$
		if (key == UMLViewsRepository.OccurrenceSpecification.toAfter)
			return "References the GeneralOrderings that specify EventOcurrences that must occur after this OccurrenceSpecification"; //$NON-NLS-1$
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
			if (UMLViewsRepository.OccurrenceSpecification.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.OccurrenceSpecification.visibility == event.getAffectedEditor()) {
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
			return Diagnostician.INSTANCE.validate(occurrenceSpecification);
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
			occurrenceSpecification.eAdapters().remove(semanticAdapter);
	}

}
