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
import org.eclipse.papyrus.tabbedproperties.uml.parts.DurationConstraintPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DurationConstraintBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private DurationConstraint durationConstraint;
	
	/**
	 * The Base part
	 */
	private DurationConstraintPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public DurationConstraintBasePropertiesEditionComponent(EObject durationConstraint, String mode) {
		if (durationConstraint instanceof DurationConstraint) {
			this.durationConstraint = (DurationConstraint)durationConstraint;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.durationConstraint.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(durationConstraint);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature())) {
					basePart.updateClientDependency(durationConstraint);
				}
				if (UMLPackage.eINSTANCE.getConstraint_ConstrainedElement().equals(msg.getFeature())) {
					basePart.updateConstrainedElement(durationConstraint);
				}
				//FIXME invalid case in liveUpdater(), Case : model = Attribute(*) - view = MultiValuedEditor


			}

		};
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return UMLViewsRepository.DurationConstraint.class;
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
		if (durationConstraint != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (DurationConstraintPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.DurationConstraint.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.DurationConstraint.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			DurationConstraint durationConstraint = (DurationConstraint)elt;
			basePart.initOwnedComment(durationConstraint, null, UMLPackage.eINSTANCE.getElement_OwnedComment());				
			if (durationConstraint.getName() != null)
				basePart.setName(durationConstraint.getName());
				
			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), durationConstraint.getVisibility());				
			basePart.initClientDependency(durationConstraint, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());				
			basePart.initConstrainedElement(durationConstraint, null, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());				
			//FIXME NO VALID CASE INTO template public updater(editor : PropertiesEditionElement, pec : PropertiesEditionComponent) in viewCommon.mtl module				
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
		if (durationConstraint != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));
			cc.append(SetCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));
			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMove = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List constrainedElementToAdd = basePart.getConstrainedElementToAdd();
			for (Iterator iter = constrainedElementToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement(), iter.next()));
			List constrainedElementToRemove = basePart.getConstrainedElementToRemove();
			for (Iterator iter = constrainedElementToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement(), iter.next()));
			//List constrainedElementToMove = basePart.getConstrainedElementToMove();
			//for (Iterator iter = constrainedElementToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, durationConstraint, UMLPackage.eINSTANCE.getElement(), moveElement.getElement(), moveElement.getIndex()));
			//}
			//FIXME invalid case in commandUpdater(), Case : model = Attribute(*) - view = MultiValuedEditor


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
		if (source instanceof DurationConstraint) {
			DurationConstraint durationConstraintToUpdate = (DurationConstraint)source;
			durationConstraintToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			durationConstraintToUpdate.setName(basePart.getName());
			durationConstraintToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());
			durationConstraintToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			durationConstraintToUpdate.getConstrainedElements().addAll(basePart.getConstrainedElementToAdd());
			//FIXME invalid case in partUpdater(), Case : model = Attribute(*) - view = MultiValuedEditor


			return durationConstraintToUpdate;
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
			if (UMLViewsRepository.DurationConstraint.ownedComment == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();
					// Start of user code for ownedComment live update command
					// TODO: Complete the durationConstraint update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DurationConstraint.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));	

			if (UMLViewsRepository.DurationConstraint.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.DurationConstraint.clientDependency == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DurationConstraint.constrainedElement == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, durationConstraint, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement(), event.getNewValue(), event.getNewIndex()));
			}
			//FIXME invalid case in liveCommandUpdater(), Case : model = Attribute(*) - view = MultiValuedEditor



			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				
				if (UMLViewsRepository.DurationConstraint.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				
				
				


			} else {
				
				if (UMLViewsRepository.DurationConstraint.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				
				
				
				


			}
		}
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
			if (key == UMLViewsRepository.DurationConstraint.ownedComment)
				return "The Comments owned by this element."; //$NON-NLS-1$
			if (key == UMLViewsRepository.DurationConstraint.name)
				return "The name of the NamedElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.DurationConstraint.visibility)
				return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
			if (key == UMLViewsRepository.DurationConstraint.clientDependency)
				return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
			if (key == UMLViewsRepository.DurationConstraint.constrainedElement)
				return "The ordered set of Elements referenced by this Constraint."; //$NON-NLS-1$
			if (key == UMLViewsRepository.DurationConstraint.firstEvent)
				return "The value of firstEvent[i] is related to constrainedElement[i] (where i is 1 or 2). If firstEvent[i] is true, then the corresponding observation event is the first time instant the execution enters constrainedElement[i]. If firstEvent[i] is false, then the corresponding observation event is the last time instant the execution is within constrainedElement[i]. Default value is true applied when constrainedElement[i] refers an element that represents only one time instant."; //$NON-NLS-1$
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
			if (UMLViewsRepository.DurationConstraint.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.DurationConstraint.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.DurationConstraint.firstEvent == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getDurationConstraint_FirstEvent().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getDurationConstraint_FirstEvent().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(durationConstraint);
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
			durationConstraint.eAdapters().remove(semanticAdapter);
	}

}

