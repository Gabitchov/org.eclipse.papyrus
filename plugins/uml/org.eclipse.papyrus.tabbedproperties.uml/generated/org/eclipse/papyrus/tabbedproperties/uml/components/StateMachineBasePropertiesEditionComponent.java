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

import org.eclipse.uml2.uml.StateMachine;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.StateMachine;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart;
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
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class StateMachineBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private StateMachine stateMachine;

	/**
	 * The Base part
	 */
	private StateMachinePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public StateMachineBasePropertiesEditionComponent(EObject stateMachine, String editing_mode) {
		if (stateMachine instanceof StateMachine) {
			this.stateMachine = (StateMachine) stateMachine;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.stateMachine.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(stateMachine);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getElementImport())) {
					basePart.updateElementImport(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageImport())) {
					basePart.updatePackageImport(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateOwnedRule(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getTemplateBinding())) {
					basePart.updateTemplateBinding(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getClassifier_IsAbstract().equals(msg.getFeature()) && basePart != null)
					basePart.setIsAbstract((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Generalization() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getGeneralization())) {
					basePart.updateGeneralization(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getClassifier_PowertypeExtent().equals(msg.getFeature()))
					basePart.updatePowertypeExtent(stateMachine);
				if (UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier().equals(msg.getFeature()))
					basePart.updateRedefinedClassifier(stateMachine);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Substitution() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getSubstitution())) {
					basePart.updateSubstitution(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_CollaborationUse() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getCollaborationUse())) {
					basePart.updateCollaborationUse(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_OwnedUseCase() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getUseCase())) {
					basePart.updateOwnedUseCase(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getClassifier_UseCase().equals(msg.getFeature()))
					basePart.updateUseCase(stateMachine);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getProperty())) {
					basePart.updateOwnedAttribute(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredClassifier_OwnedConnector() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConnector())) {
					basePart.updateOwnedConnector(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getBehavior())) {
					basePart.updateOwnedBehavior(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization() || ((EStructuralFeature) msg.getFeature())
								.getEContainingClass() == UMLPackage.eINSTANCE.getInterfaceRealization())) {
					basePart.updateInterfaceRealization(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getTrigger())) {
					basePart.updateOwnedTrigger(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClass_NestedClassifier() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getClassifier())) {
					basePart.updateNestedClassifier(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClass_OwnedOperation() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getOperation())) {
					basePart.updateOwnedOperation(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getClass_IsActive().equals(msg.getFeature()) && basePart != null)
					basePart.setIsActive((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClass_OwnedReception() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getReception())) {
					basePart.updateOwnedReception(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getBehavior_IsReentrant().equals(msg.getFeature()) && basePart != null)
					basePart.setIsReentrant((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior().equals(msg.getFeature()))
					basePart.updateRedefinedBehavior(stateMachine);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavior_OwnedParameter() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getParameter())) {
					basePart.updateOwnedParameter(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getBehavior_Precondition().equals(msg.getFeature()))
					basePart.updatePrecondition(stateMachine);
				if (UMLPackage.eINSTANCE.getBehavior_Postcondition().equals(msg.getFeature()))
					basePart.updatePostcondition(stateMachine);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavior_OwnedParameterSet() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getParameterSet())) {
					basePart.updateOwnedParameterSet(stateMachine);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getStateMachine_Region() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getRegion())) {
					basePart.updateRegion(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getStateMachine_SubmachineState().equals(msg.getFeature()))
					basePart.updateSubmachineState(stateMachine);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPseudostate())) {
					basePart.updateConnectionPoint(stateMachine);
				}
				if (UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine().equals(msg.getFeature()))
					basePart.updateExtendedStateMachine(stateMachine);

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
			return UMLViewsRepository.StateMachine.class;
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
		if (stateMachine != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (StateMachinePropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.StateMachine.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.StateMachine.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			StateMachine stateMachine = (StateMachine) elt;
			basePart.initOwnedComment(stateMachine, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (stateMachine.getName() != null)
				basePart.setName(stateMachine.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), stateMachine.getVisibility());
			basePart.initClientDependency(stateMachine, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initElementImport(stateMachine, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(stateMachine, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(stateMachine, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.setIsLeaf(stateMachine.isLeaf());

			basePart.initTemplateBinding(stateMachine, null, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding());
			basePart.setIsAbstract(stateMachine.isAbstract());

			basePart.initGeneralization(stateMachine, null, UMLPackage.eINSTANCE.getClassifier_Generalization());
			basePart.initPowertypeExtent(stateMachine, null, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent());
			basePart.initRedefinedClassifier(stateMachine, null, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier());
			basePart.initSubstitution(stateMachine, null, UMLPackage.eINSTANCE.getClassifier_Substitution());
			basePart.initCollaborationUse(stateMachine, null, UMLPackage.eINSTANCE.getClassifier_CollaborationUse());
			basePart.initOwnedUseCase(stateMachine, null, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase());
			basePart.initUseCase(stateMachine, null, UMLPackage.eINSTANCE.getClassifier_UseCase());
			basePart.initOwnedAttribute(stateMachine, null, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute());
			basePart.initOwnedConnector(stateMachine, null, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedConnector());
			basePart.initOwnedBehavior(stateMachine, null, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior());
			basePart.initInterfaceRealization(stateMachine, null, UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization());
			basePart.initOwnedTrigger(stateMachine, null, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger());
			basePart.initNestedClassifier(stateMachine, null, UMLPackage.eINSTANCE.getClass_NestedClassifier());
			basePart.initOwnedOperation(stateMachine, null, UMLPackage.eINSTANCE.getClass_OwnedOperation());
			basePart.setIsActive(stateMachine.isActive());

			basePart.initOwnedReception(stateMachine, null, UMLPackage.eINSTANCE.getClass_OwnedReception());
			basePart.setIsReentrant(stateMachine.isReentrant());

			basePart.initRedefinedBehavior(stateMachine, null, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior());
			basePart.initOwnedParameter(stateMachine, null, UMLPackage.eINSTANCE.getBehavior_OwnedParameter());
			basePart.initPrecondition(stateMachine, null, UMLPackage.eINSTANCE.getBehavior_Precondition());
			basePart.initPostcondition(stateMachine, null, UMLPackage.eINSTANCE.getBehavior_Postcondition());
			basePart.initOwnedParameterSet(stateMachine, null, UMLPackage.eINSTANCE.getBehavior_OwnedParameterSet());
			basePart.initRegion(stateMachine, null, UMLPackage.eINSTANCE.getStateMachine_Region());
			basePart.initSubmachineState(stateMachine, null, UMLPackage.eINSTANCE.getStateMachine_SubmachineState());
			basePart.initConnectionPoint(stateMachine, null, UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint());
			basePart.initExtendedStateMachine(stateMachine, null, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (stateMachine != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List elementImportToAdd = basePart.getElementImportToAdd();
			for (Iterator iter = elementImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
			Map elementImportToRefresh = basePart.getElementImportToEdit();
			for (Iterator iter = elementImportToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for elementImport reference refreshment

				ElementImport nextElement = (ElementImport) iter.next();
				ElementImport elementImport = (ElementImport) elementImportToRefresh.get(nextElement);

				// End of user code
			}
			List elementImportToRemove = basePart.getElementImportToRemove();
			for (Iterator iter = elementImportToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List elementImportToMove = basePart.getElementImportToMove();
			for (Iterator iter = elementImportToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAdd = basePart.getPackageImportToAdd();
			for (Iterator iter = packageImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
			Map packageImportToRefresh = basePart.getPackageImportToEdit();
			for (Iterator iter = packageImportToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for packageImport reference refreshment

				PackageImport nextElement = (PackageImport) iter.next();
				PackageImport packageImport = (PackageImport) packageImportToRefresh.get(nextElement);

				// End of user code
			}
			List packageImportToRemove = basePart.getPackageImportToRemove();
			for (Iterator iter = packageImportToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List packageImportToMove = basePart.getPackageImportToMove();
			for (Iterator iter = packageImportToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAdd = basePart.getOwnedRuleToAdd();
			for (Iterator iter = ownedRuleToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
			Map ownedRuleToRefresh = basePart.getOwnedRuleToEdit();
			for (Iterator iter = ownedRuleToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedRule reference refreshment

				Constraint nextElement = (Constraint) iter.next();
				Constraint ownedRule = (Constraint) ownedRuleToRefresh.get(nextElement);

				// End of user code
			}
			List ownedRuleToRemove = basePart.getOwnedRuleToRemove();
			for (Iterator iter = ownedRuleToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedRuleToMove = basePart.getOwnedRuleToMove();
			for (Iterator iter = ownedRuleToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List templateBindingToAdd = basePart.getTemplateBindingToAdd();
			for (Iterator iter = templateBindingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), iter.next()));
			Map templateBindingToRefresh = basePart.getTemplateBindingToEdit();
			for (Iterator iter = templateBindingToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for templateBinding reference refreshment

				TemplateBinding nextElement = (TemplateBinding) iter.next();
				TemplateBinding templateBinding = (TemplateBinding) templateBindingToRefresh.get(nextElement);

				// End of user code
			}
			List templateBindingToRemove = basePart.getTemplateBindingToRemove();
			for (Iterator iter = templateBindingToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List templateBindingToMove = basePart.getTemplateBindingToMove();
			for (Iterator iter = templateBindingToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getTemplateBinding(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), basePart.getIsAbstract()));

			List generalizationToAdd = basePart.getGeneralizationToAdd();
			for (Iterator iter = generalizationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_Generalization(), iter.next()));
			Map generalizationToRefresh = basePart.getGeneralizationToEdit();
			for (Iterator iter = generalizationToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for generalization reference refreshment

				Generalization nextElement = (Generalization) iter.next();
				Generalization generalization = (Generalization) generalizationToRefresh.get(nextElement);

				// End of user code
			}
			List generalizationToRemove = basePart.getGeneralizationToRemove();
			for (Iterator iter = generalizationToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List generalizationToMove = basePart.getGeneralizationToMove();
			for (Iterator iter = generalizationToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getGeneralization(), moveElement.getElement(), moveElement.getIndex()));
			}
			List powertypeExtentToAdd = basePart.getPowertypeExtentToAdd();
			for (Iterator iter = powertypeExtentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			List powertypeExtentToRemove = basePart.getPowertypeExtentToRemove();
			for (Iterator iter = powertypeExtentToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			// List powertypeExtentToMove = basePart.getPowertypeExtentToMove();
			// for (Iterator iter = powertypeExtentToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getGeneralizationSet(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List redefinedClassifierToAdd = basePart.getRedefinedClassifierToAdd();
			for (Iterator iter = redefinedClassifierToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			List redefinedClassifierToRemove = basePart.getRedefinedClassifierToRemove();
			for (Iterator iter = redefinedClassifierToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			// List redefinedClassifierToMove = basePart.getRedefinedClassifierToMove();
			// for (Iterator iter = redefinedClassifierToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List substitutionToAdd = basePart.getSubstitutionToAdd();
			for (Iterator iter = substitutionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_Substitution(), iter.next()));
			Map substitutionToRefresh = basePart.getSubstitutionToEdit();
			for (Iterator iter = substitutionToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for substitution reference refreshment

				Substitution nextElement = (Substitution) iter.next();
				Substitution substitution = (Substitution) substitutionToRefresh.get(nextElement);

				// End of user code
			}
			List substitutionToRemove = basePart.getSubstitutionToRemove();
			for (Iterator iter = substitutionToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List substitutionToMove = basePart.getSubstitutionToMove();
			for (Iterator iter = substitutionToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getSubstitution(), moveElement.getElement(), moveElement.getIndex()));
			}
			List collaborationUseToAdd = basePart.getCollaborationUseToAdd();
			for (Iterator iter = collaborationUseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), iter.next()));
			Map collaborationUseToRefresh = basePart.getCollaborationUseToEdit();
			for (Iterator iter = collaborationUseToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for collaborationUse reference refreshment

				CollaborationUse nextElement = (CollaborationUse) iter.next();
				CollaborationUse collaborationUse = (CollaborationUse) collaborationUseToRefresh.get(nextElement);

				// End of user code
			}
			List collaborationUseToRemove = basePart.getCollaborationUseToRemove();
			for (Iterator iter = collaborationUseToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List collaborationUseToMove = basePart.getCollaborationUseToMove();
			for (Iterator iter = collaborationUseToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getCollaborationUse(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedUseCaseToAdd = basePart.getOwnedUseCaseToAdd();
			for (Iterator iter = ownedUseCaseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), iter.next()));
			Map ownedUseCaseToRefresh = basePart.getOwnedUseCaseToEdit();
			for (Iterator iter = ownedUseCaseToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedUseCase reference refreshment

				UseCase nextElement = (UseCase) iter.next();
				UseCase ownedUseCase = (UseCase) ownedUseCaseToRefresh.get(nextElement);

				// End of user code
			}
			List ownedUseCaseToRemove = basePart.getOwnedUseCaseToRemove();
			for (Iterator iter = ownedUseCaseToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedUseCaseToMove = basePart.getOwnedUseCaseToMove();
			for (Iterator iter = ownedUseCaseToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			}
			List useCaseToAdd = basePart.getUseCaseToAdd();
			for (Iterator iter = useCaseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			List useCaseToRemove = basePart.getUseCaseToRemove();
			for (Iterator iter = useCaseToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			// List useCaseToMove = basePart.getUseCaseToMove();
			// for (Iterator iter = useCaseToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List ownedAttributeToAdd = basePart.getOwnedAttributeToAdd();
			for (Iterator iter = ownedAttributeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute(), iter.next()));
			Map ownedAttributeToRefresh = basePart.getOwnedAttributeToEdit();
			for (Iterator iter = ownedAttributeToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedAttribute reference refreshment

				Property nextElement = (Property) iter.next();
				Property ownedAttribute = (Property) ownedAttributeToRefresh.get(nextElement);

				// End of user code
			}
			List ownedAttributeToRemove = basePart.getOwnedAttributeToRemove();
			for (Iterator iter = ownedAttributeToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedAttributeToMove = basePart.getOwnedAttributeToMove();
			for (Iterator iter = ownedAttributeToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedConnectorToAdd = basePart.getOwnedConnectorToAdd();
			for (Iterator iter = ownedConnectorToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedConnector(), iter.next()));
			Map ownedConnectorToRefresh = basePart.getOwnedConnectorToEdit();
			for (Iterator iter = ownedConnectorToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedConnector reference refreshment

				Connector nextElement = (Connector) iter.next();
				Connector ownedConnector = (Connector) ownedConnectorToRefresh.get(nextElement);

				// End of user code
			}
			List ownedConnectorToRemove = basePart.getOwnedConnectorToRemove();
			for (Iterator iter = ownedConnectorToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedConnectorToMove = basePart.getOwnedConnectorToMove();
			for (Iterator iter = ownedConnectorToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getConnector(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedBehaviorToAdd = basePart.getOwnedBehaviorToAdd();
			for (Iterator iter = ownedBehaviorToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior(), iter.next()));
			Map ownedBehaviorToRefresh = basePart.getOwnedBehaviorToEdit();
			for (Iterator iter = ownedBehaviorToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedBehavior reference refreshment

				Behavior nextElement = (Behavior) iter.next();
				Behavior ownedBehavior = (Behavior) ownedBehaviorToRefresh.get(nextElement);

				// End of user code
			}
			List ownedBehaviorToRemove = basePart.getOwnedBehaviorToRemove();
			for (Iterator iter = ownedBehaviorToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedBehaviorToMove = basePart.getOwnedBehaviorToMove();
			for (Iterator iter = ownedBehaviorToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior(), moveElement.getElement(), moveElement.getIndex()));
			}
			List interfaceRealizationToAdd = basePart.getInterfaceRealizationToAdd();
			for (Iterator iter = interfaceRealizationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(), iter.next()));
			Map interfaceRealizationToRefresh = basePart.getInterfaceRealizationToEdit();
			for (Iterator iter = interfaceRealizationToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for interfaceRealization reference refreshment

				InterfaceRealization nextElement = (InterfaceRealization) iter.next();
				InterfaceRealization interfaceRealization = (InterfaceRealization) interfaceRealizationToRefresh.get(nextElement);

				// End of user code
			}
			List interfaceRealizationToRemove = basePart.getInterfaceRealizationToRemove();
			for (Iterator iter = interfaceRealizationToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List interfaceRealizationToMove = basePart.getInterfaceRealizationToMove();
			for (Iterator iter = interfaceRealizationToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getInterfaceRealization(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedTriggerToAdd = basePart.getOwnedTriggerToAdd();
			for (Iterator iter = ownedTriggerToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger(), iter.next()));
			Map ownedTriggerToRefresh = basePart.getOwnedTriggerToEdit();
			for (Iterator iter = ownedTriggerToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedTrigger reference refreshment

				Trigger nextElement = (Trigger) iter.next();
				Trigger ownedTrigger = (Trigger) ownedTriggerToRefresh.get(nextElement);

				// End of user code
			}
			List ownedTriggerToRemove = basePart.getOwnedTriggerToRemove();
			for (Iterator iter = ownedTriggerToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedTriggerToMove = basePart.getOwnedTriggerToMove();
			for (Iterator iter = ownedTriggerToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getTrigger(), moveElement.getElement(), moveElement.getIndex()));
			}
			List nestedClassifierToAdd = basePart.getNestedClassifierToAdd();
			for (Iterator iter = nestedClassifierToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_NestedClassifier(), iter.next()));
			Map nestedClassifierToRefresh = basePart.getNestedClassifierToEdit();
			for (Iterator iter = nestedClassifierToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for nestedClassifier reference refreshment

				Classifier nextElement = (Classifier) iter.next();
				Classifier nestedClassifier = (Classifier) nestedClassifierToRefresh.get(nextElement);

				// End of user code
			}
			List nestedClassifierToRemove = basePart.getNestedClassifierToRemove();
			for (Iterator iter = nestedClassifierToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List nestedClassifierToMove = basePart.getNestedClassifierToMove();
			for (Iterator iter = nestedClassifierToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedOperationToAdd = basePart.getOwnedOperationToAdd();
			for (Iterator iter = ownedOperationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_OwnedOperation(), iter.next()));
			Map ownedOperationToRefresh = basePart.getOwnedOperationToEdit();
			for (Iterator iter = ownedOperationToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedOperation reference refreshment

				Operation nextElement = (Operation) iter.next();
				Operation ownedOperation = (Operation) ownedOperationToRefresh.get(nextElement);

				// End of user code
			}
			List ownedOperationToRemove = basePart.getOwnedOperationToRemove();
			for (Iterator iter = ownedOperationToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedOperationToMove = basePart.getOwnedOperationToMove();
			for (Iterator iter = ownedOperationToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getOperation(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_IsActive(), basePart.getIsActive()));

			List ownedReceptionToAdd = basePart.getOwnedReceptionToAdd();
			for (Iterator iter = ownedReceptionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_OwnedReception(), iter.next()));
			Map ownedReceptionToRefresh = basePart.getOwnedReceptionToEdit();
			for (Iterator iter = ownedReceptionToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedReception reference refreshment

				Reception nextElement = (Reception) iter.next();
				Reception ownedReception = (Reception) ownedReceptionToRefresh.get(nextElement);

				// End of user code
			}
			List ownedReceptionToRemove = basePart.getOwnedReceptionToRemove();
			for (Iterator iter = ownedReceptionToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedReceptionToMove = basePart.getOwnedReceptionToMove();
			for (Iterator iter = ownedReceptionToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getReception(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_IsReentrant(), basePart.getIsReentrant()));

			List redefinedBehaviorToAdd = basePart.getRedefinedBehaviorToAdd();
			for (Iterator iter = redefinedBehaviorToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), iter.next()));
			List redefinedBehaviorToRemove = basePart.getRedefinedBehaviorToRemove();
			for (Iterator iter = redefinedBehaviorToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), iter.next()));
			// List redefinedBehaviorToMove = basePart.getRedefinedBehaviorToMove();
			// for (Iterator iter = redefinedBehaviorToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List ownedParameterToAdd = basePart.getOwnedParameterToAdd();
			for (Iterator iter = ownedParameterToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_OwnedParameter(), iter.next()));
			Map ownedParameterToRefresh = basePart.getOwnedParameterToEdit();
			for (Iterator iter = ownedParameterToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedParameter reference refreshment

				Parameter nextElement = (Parameter) iter.next();
				Parameter ownedParameter = (Parameter) ownedParameterToRefresh.get(nextElement);

				// End of user code
			}
			List ownedParameterToRemove = basePart.getOwnedParameterToRemove();
			for (Iterator iter = ownedParameterToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedParameterToMove = basePart.getOwnedParameterToMove();
			for (Iterator iter = ownedParameterToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getParameter(), moveElement.getElement(), moveElement.getIndex()));
			}
			List preconditionToAdd = basePart.getPreconditionToAdd();
			for (Iterator iter = preconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), iter.next()));
			List preconditionToRemove = basePart.getPreconditionToRemove();
			for (Iterator iter = preconditionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), iter.next()));
			// List preconditionToMove = basePart.getPreconditionToMove();
			// for (Iterator iter = preconditionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List postconditionToAdd = basePart.getPostconditionToAdd();
			for (Iterator iter = postconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), iter.next()));
			List postconditionToRemove = basePart.getPostconditionToRemove();
			for (Iterator iter = postconditionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), iter.next()));
			// List postconditionToMove = basePart.getPostconditionToMove();
			// for (Iterator iter = postconditionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List ownedParameterSetToAdd = basePart.getOwnedParameterSetToAdd();
			for (Iterator iter = ownedParameterSetToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_OwnedParameterSet(), iter.next()));
			Map ownedParameterSetToRefresh = basePart.getOwnedParameterSetToEdit();
			for (Iterator iter = ownedParameterSetToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedParameterSet reference refreshment

				ParameterSet nextElement = (ParameterSet) iter.next();
				ParameterSet ownedParameterSet = (ParameterSet) ownedParameterSetToRefresh.get(nextElement);

				// End of user code
			}
			List ownedParameterSetToRemove = basePart.getOwnedParameterSetToRemove();
			for (Iterator iter = ownedParameterSetToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedParameterSetToMove = basePart.getOwnedParameterSetToMove();
			for (Iterator iter = ownedParameterSetToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getParameterSet(), moveElement.getElement(), moveElement.getIndex()));
			}
			List regionToAdd = basePart.getRegionToAdd();
			for (Iterator iter = regionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_Region(), iter.next()));
			Map regionToRefresh = basePart.getRegionToEdit();
			for (Iterator iter = regionToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for region reference refreshment

				Region nextElement = (Region) iter.next();
				Region region = (Region) regionToRefresh.get(nextElement);

				// End of user code
			}
			List regionToRemove = basePart.getRegionToRemove();
			for (Iterator iter = regionToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List regionToMove = basePart.getRegionToMove();
			for (Iterator iter = regionToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getRegion(), moveElement.getElement(), moveElement.getIndex()));
			}
			List submachineStateToAdd = basePart.getSubmachineStateToAdd();
			for (Iterator iter = submachineStateToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), iter.next()));
			List submachineStateToRemove = basePart.getSubmachineStateToRemove();
			for (Iterator iter = submachineStateToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), iter.next()));
			// List submachineStateToMove = basePart.getSubmachineStateToMove();
			// for (Iterator iter = submachineStateToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getState(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List connectionPointToAdd = basePart.getConnectionPointToAdd();
			for (Iterator iter = connectionPointToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint(), iter.next()));
			Map connectionPointToRefresh = basePart.getConnectionPointToEdit();
			for (Iterator iter = connectionPointToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for connectionPoint reference refreshment

				Pseudostate nextElement = (Pseudostate) iter.next();
				Pseudostate connectionPoint = (Pseudostate) connectionPointToRefresh.get(nextElement);

				// End of user code
			}
			List connectionPointToRemove = basePart.getConnectionPointToRemove();
			for (Iterator iter = connectionPointToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List connectionPointToMove = basePart.getConnectionPointToMove();
			for (Iterator iter = connectionPointToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getPseudostate(), moveElement.getElement(), moveElement.getIndex()));
			}
			List extendedStateMachineToAdd = basePart.getExtendedStateMachineToAdd();
			for (Iterator iter = extendedStateMachineToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), iter.next()));
			List extendedStateMachineToRemove = basePart.getExtendedStateMachineToRemove();
			for (Iterator iter = extendedStateMachineToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), iter.next()));
			// List extendedStateMachineToMove = basePart.getExtendedStateMachineToMove();
			// for (Iterator iter = extendedStateMachineToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof StateMachine) {
			StateMachine stateMachineToUpdate = (StateMachine) source;
			stateMachineToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			stateMachineToUpdate.setName(basePart.getName());

			stateMachineToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			stateMachineToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			stateMachineToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			stateMachineToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			stateMachineToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			stateMachineToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			stateMachineToUpdate.getTemplateBindings().addAll(basePart.getTemplateBindingToAdd());
			stateMachineToUpdate.setIsAbstract(new Boolean(basePart.getIsAbstract()).booleanValue());

			stateMachineToUpdate.getGeneralizations().addAll(basePart.getGeneralizationToAdd());
			stateMachineToUpdate.getPowertypeExtents().addAll(basePart.getPowertypeExtentToAdd());
			stateMachineToUpdate.getRedefinedClassifiers().addAll(basePart.getRedefinedClassifierToAdd());
			stateMachineToUpdate.getSubstitutions().addAll(basePart.getSubstitutionToAdd());
			stateMachineToUpdate.getCollaborationUses().addAll(basePart.getCollaborationUseToAdd());
			stateMachineToUpdate.getOwnedUseCases().addAll(basePart.getOwnedUseCaseToAdd());
			stateMachineToUpdate.getUseCases().addAll(basePart.getUseCaseToAdd());
			stateMachineToUpdate.getOwnedAttributes().addAll(basePart.getOwnedAttributeToAdd());
			stateMachineToUpdate.getOwnedConnectors().addAll(basePart.getOwnedConnectorToAdd());
			stateMachineToUpdate.getOwnedBehaviors().addAll(basePart.getOwnedBehaviorToAdd());
			stateMachineToUpdate.getInterfaceRealizations().addAll(basePart.getInterfaceRealizationToAdd());
			stateMachineToUpdate.getOwnedTriggers().addAll(basePart.getOwnedTriggerToAdd());
			stateMachineToUpdate.getNestedClassifiers().addAll(basePart.getNestedClassifierToAdd());
			stateMachineToUpdate.getOwnedOperations().addAll(basePart.getOwnedOperationToAdd());
			stateMachineToUpdate.setIsActive(new Boolean(basePart.getIsActive()).booleanValue());

			stateMachineToUpdate.getOwnedReceptions().addAll(basePart.getOwnedReceptionToAdd());
			stateMachineToUpdate.setIsReentrant(new Boolean(basePart.getIsReentrant()).booleanValue());

			stateMachineToUpdate.getRedefinedBehaviors().addAll(basePart.getRedefinedBehaviorToAdd());
			stateMachineToUpdate.getOwnedParameters().addAll(basePart.getOwnedParameterToAdd());
			stateMachineToUpdate.getPreconditions().addAll(basePart.getPreconditionToAdd());
			stateMachineToUpdate.getPostconditions().addAll(basePart.getPostconditionToAdd());
			stateMachineToUpdate.getOwnedParameterSets().addAll(basePart.getOwnedParameterSetToAdd());
			stateMachineToUpdate.getRegions().addAll(basePart.getRegionToAdd());
			stateMachineToUpdate.getSubmachineStates().addAll(basePart.getSubmachineStateToAdd());
			stateMachineToUpdate.getConnectionPoints().addAll(basePart.getConnectionPointToAdd());
			stateMachineToUpdate.getExtendedStateMachines().addAll(basePart.getExtendedStateMachineToAdd());

			return stateMachineToUpdate;
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
			if (UMLViewsRepository.StateMachine.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.StateMachine.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.StateMachine.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.elementImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport) event.getOldValue();
					ElementImport newValue = (ElementImport) event.getNewValue();

					// Start of user code for elementImport live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.packageImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport) event.getOldValue();
					PackageImport newValue = (PackageImport) event.getNewValue();

					// Start of user code for packageImport live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.ownedRule == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for ownedRule live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.StateMachine.templateBinding == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					TemplateBinding oldValue = (TemplateBinding) event.getOldValue();
					TemplateBinding newValue = (TemplateBinding) event.getNewValue();

					// Start of user code for templateBinding live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getTemplateBinding(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.isAbstract == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), event.getNewValue()));

			if (UMLViewsRepository.StateMachine.generalization == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Generalization oldValue = (Generalization) event.getOldValue();
					Generalization newValue = (Generalization) event.getNewValue();

					// Start of user code for generalization live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_Generalization(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getGeneralization(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.powertypeExtent == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.redefinedClassifier == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.substitution == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Substitution oldValue = (Substitution) event.getOldValue();
					Substitution newValue = (Substitution) event.getNewValue();

					// Start of user code for substitution live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_Substitution(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getSubstitution(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.collaborationUse == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					CollaborationUse oldValue = (CollaborationUse) event.getOldValue();
					CollaborationUse newValue = (CollaborationUse) event.getNewValue();

					// Start of user code for collaborationUse live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getCollaborationUse(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.ownedUseCase == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					UseCase oldValue = (UseCase) event.getOldValue();
					UseCase newValue = (UseCase) event.getNewValue();

					// Start of user code for ownedUseCase live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getUseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.useCase == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.ownedAttribute == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Property oldValue = (Property) event.getOldValue();
					Property newValue = (Property) event.getNewValue();

					// Start of user code for ownedAttribute live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.ownedConnector == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Connector oldValue = (Connector) event.getOldValue();
					Connector newValue = (Connector) event.getNewValue();

					// Start of user code for ownedConnector live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedConnector(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getConnector(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.ownedBehavior == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Behavior oldValue = (Behavior) event.getOldValue();
					Behavior newValue = (Behavior) event.getNewValue();

					// Start of user code for ownedBehavior live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.interfaceRealization == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					InterfaceRealization oldValue = (InterfaceRealization) event.getOldValue();
					InterfaceRealization newValue = (InterfaceRealization) event.getNewValue();

					// Start of user code for interfaceRealization live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getInterfaceRealization(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.ownedTrigger == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Trigger oldValue = (Trigger) event.getOldValue();
					Trigger newValue = (Trigger) event.getNewValue();

					// Start of user code for ownedTrigger live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getTrigger(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.nestedClassifier == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Classifier oldValue = (Classifier) event.getOldValue();
					Classifier newValue = (Classifier) event.getNewValue();

					// Start of user code for nestedClassifier live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_NestedClassifier(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.ownedOperation == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Operation oldValue = (Operation) event.getOldValue();
					Operation newValue = (Operation) event.getNewValue();

					// Start of user code for ownedOperation live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_OwnedOperation(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getOperation(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.isActive == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_IsActive(), event.getNewValue()));

			if (UMLViewsRepository.StateMachine.ownedReception == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Reception oldValue = (Reception) event.getOldValue();
					Reception newValue = (Reception) event.getNewValue();

					// Start of user code for ownedReception live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_OwnedReception(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getReception(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.isReentrant == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_IsReentrant(), event.getNewValue()));

			if (UMLViewsRepository.StateMachine.redefinedBehavior == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.ownedParameter == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Parameter oldValue = (Parameter) event.getOldValue();
					Parameter newValue = (Parameter) event.getNewValue();

					// Start of user code for ownedParameter live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_OwnedParameter(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getParameter(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.precondition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.postcondition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.ownedParameterSet == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ParameterSet oldValue = (ParameterSet) event.getOldValue();
					ParameterSet newValue = (ParameterSet) event.getNewValue();

					// Start of user code for ownedParameterSet live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_OwnedParameterSet(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getParameterSet(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.region == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Region oldValue = (Region) event.getOldValue();
					Region newValue = (Region) event.getNewValue();

					// Start of user code for region live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_Region(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getRegion(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.submachineState == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.connectionPoint == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Pseudostate oldValue = (Pseudostate) event.getOldValue();
					Pseudostate newValue = (Pseudostate) event.getNewValue();

					// Start of user code for connectionPoint live update command
					// TODO: Complete the stateMachine update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getPseudostate(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.StateMachine.extendedStateMachine == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.StateMachine.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.StateMachine.name == event.getAffectedEditor())
					basePart.unsetMessageForName();

			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.StateMachine.isLeaf || key == UMLViewsRepository.StateMachine.isAbstract || key == UMLViewsRepository.StateMachine.isActive
				|| key == UMLViewsRepository.StateMachine.isReentrant || key == UMLViewsRepository.StateMachine.region;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.StateMachine.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.elementImport)
			return "References the ElementImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.packageImport)
			return "References the PackageImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedRule)
			return "Specifies a set of Constraints owned by this Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.templateBinding)
			return "The optional bindings from this element to templates."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.isAbstract)
			return "If true, the Classifier does not provide a complete declaration and can typically not be instantiated. An abstract classifier is intended to be used by other classifiers e.g. as the target of general metarelationships or generalization relationships."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.generalization)
			return "Specifies the Generalization relationships for this Classifier. These Generalizations navigaten to more general classifiers in the generalization hierarchy."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.powertypeExtent)
			return "Designates the GeneralizationSet of which the associated Classifier is a power type."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.redefinedClassifier)
			return "References the Classifiers that are redefined by this Classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.substitution)
			return "References the substitutions that are owned by this Classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.collaborationUse)
			return "References the collaboration uses owned by the classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedUseCase)
			return "References the use cases owned by this classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.useCase)
			return "The set of use cases for which this Classifier is the subject."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedAttribute)
			return "References the properties owned by the classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedConnector)
			return "References the connectors owned by the classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedBehavior)
			return "References behavior specifications owned by a classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.interfaceRealization)
			return "The set of InterfaceRealizations owned by the BehavioredClassifier. Interface realizations reference the Interfaces of which the BehavioredClassifier is an implementation."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedTrigger)
			return "References Trigger descriptions owned by a Classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.nestedClassifier)
			return "References all the Classifiers that are defined (nested) within the Class."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedOperation)
			return "The operations owned by the class."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.isActive)
			return "Determines whether an object specified by this class is active or not. If true, then the owning class is referred to as an active class. If false, then such a class is referred to as a passive class."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedReception)
			return "Receptions that objects of this class are willing to accept."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.isReentrant)
			return "Tells whether the behavior can be invoked while it is still executing from a previous invocation."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.redefinedBehavior)
			return "References a behavior that this behavior redefines. A subtype of Behavior may redefine any other subtype of Behavior. If the behavior implements a behavioral feature, it replaces the redefined behavior. If the behavior is a classifier behavior, it extends the redefined behavior."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedParameter)
			return "References a list of parameters to the behavior which describes the order and type of arguments that can be given when the behavior is invoked and of the values which will be returned when the behavior completes its execution."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.precondition)
			return "An optional set of Constraints specifying what must be fulfilled when the behavior is invoked."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.postcondition)
			return "An optional set of Constraints specifying what is fulfilled after the execution of the behavior is completed, if its precondition was fulfilled before its invocation."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.ownedParameterSet)
			return "The ParameterSets owned by this Behavior."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.region)
			return "The regions owned directly by the state machine."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.submachineState)
			return "References the submachine(s) in case of a submachine state. Multiple machines are referenced in case of a concurrent state."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.connectionPoint)
			return "The connection points defined for this state machine. They represent the interface of the state machine when used as part of submachine state."; //$NON-NLS-1$
		if (key == UMLViewsRepository.StateMachine.extendedStateMachine)
			return "The state machines of which this is an extension."; //$NON-NLS-1$
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
			if (UMLViewsRepository.StateMachine.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.StateMachine.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.StateMachine.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.StateMachine.isAbstract == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getClassifier_IsAbstract().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getClassifier_IsAbstract().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.StateMachine.isActive == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getClass_IsActive().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getClass_IsActive().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.StateMachine.isReentrant == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getBehavior_IsReentrant().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getBehavior_IsReentrant().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(stateMachine);
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
			stateMachine.eAdapters().remove(semanticAdapter);
	}

}
