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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

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
		if(stateMachine instanceof StateMachine) {
			this.stateMachine = (StateMachine)stateMachine;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.stateMachine.eAdapters().add(semanticAdapter);
			}
		}
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
				if(basePart == null)
					StateMachineBasePropertiesEditionComponent.this.dispose();
				else {
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getElement_OwnedComment())) {
						basePart.updateOwnedComment(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null) {
						if(msg.getNewValue() != null) {
							basePart.setName((String)msg.getNewValue());
						} else {
							basePart.setName("");
						}
					}
					if(UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
						basePart.setVisibility((Enumerator)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
						basePart.updateClientDependency(stateMachine);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_ElementImport())) {
						basePart.updateElementImport(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_PackageImport())) {
						basePart.updatePackageImport(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_OwnedRule())) {
						basePart.updateOwnedRule(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
						basePart.setIsLeaf((Boolean)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding())) {
						basePart.updateTemplateBinding(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getClassifier_IsAbstract().equals(msg.getFeature()) && basePart != null)
						basePart.setIsAbstract((Boolean)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Generalization()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClassifier_Generalization())) {
						basePart.updateGeneralization(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getClassifier_PowertypeExtent().equals(msg.getFeature()))
						basePart.updatePowertypeExtent(stateMachine);
					if(UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier().equals(msg.getFeature()))
						basePart.updateRedefinedClassifier(stateMachine);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Substitution()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClassifier_Substitution())) {
						basePart.updateSubstitution(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_CollaborationUse()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClassifier_CollaborationUse())) {
						basePart.updateCollaborationUse(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_OwnedUseCase()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClassifier_OwnedUseCase())) {
						basePart.updateOwnedUseCase(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getClassifier_UseCase().equals(msg.getFeature()))
						basePart.updateUseCase(stateMachine);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute())) {
						basePart.updateOwnedAttribute(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredClassifier_OwnedConnector()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getStructuredClassifier_OwnedConnector())) {
						basePart.updateOwnedConnector(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior())) {
						basePart.updateOwnedBehavior(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization())) {
						basePart.updateInterfaceRealization(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger())) {
						basePart.updateOwnedTrigger(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClass_NestedClassifier()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClass_NestedClassifier())) {
						basePart.updateNestedClassifier(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClass_OwnedOperation()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClass_OwnedOperation())) {
						basePart.updateOwnedOperation(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getClass_IsActive().equals(msg.getFeature()) && basePart != null)
						basePart.setIsActive((Boolean)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClass_OwnedReception()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClass_OwnedReception())) {
						basePart.updateOwnedReception(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getBehavior_IsReentrant().equals(msg.getFeature()) && basePart != null)
						basePart.setIsReentrant((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior().equals(msg.getFeature()))
						basePart.updateRedefinedBehavior(stateMachine);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getBehavior_OwnedParameter()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getBehavior_OwnedParameter())) {
						basePart.updateOwnedParameter(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getBehavior_Precondition().equals(msg.getFeature()))
						basePart.updatePrecondition(stateMachine);
					if(UMLPackage.eINSTANCE.getBehavior_Postcondition().equals(msg.getFeature()))
						basePart.updatePostcondition(stateMachine);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getBehavior_OwnedParameterSet()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getBehavior_OwnedParameterSet())) {
						basePart.updateOwnedParameterSet(stateMachine);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStateMachine_Region()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getStateMachine_Region())) {
						basePart.updateRegion(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getStateMachine_SubmachineState().equals(msg.getFeature()))
						basePart.updateSubmachineState(stateMachine);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint())) {
						basePart.updateConnectionPoint(stateMachine);
					}
					if(UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine().equals(msg.getFeature()))
						basePart.updateExtendedStateMachine(stateMachine);


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
		if(BASE_PART.equals(key))
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
		if(stateMachine != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (StateMachinePropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.StateMachine.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent# setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if(key == UMLViewsRepository.StateMachine.class)
			this.basePart = (StateMachinePropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.StateMachine.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final StateMachine stateMachine = (StateMachine)elt;
			// init values
			basePart.initOwnedComment(stateMachine, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if(stateMachine.getName() != null)
				basePart.setName(stateMachine.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), stateMachine.getVisibility());
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

			// init filters
			basePart.addFilterToOwnedComment(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Comment); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedComment

			// End of user code


			basePart.addFilterToClientDependency(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInClientDependencyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToClientDependency(new EObjectFilter(UMLPackage.eINSTANCE.getDependency()));
			// Start of user code for additional businessfilters for clientDependency

			// End of user code
			basePart.addFilterToElementImport(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof ElementImport); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for elementImport

			// End of user code
			basePart.addFilterToPackageImport(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof PackageImport); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for packageImport

			// End of user code
			basePart.addFilterToOwnedRule(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Constraint); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedRule

			// End of user code

			basePart.addFilterToTemplateBinding(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof TemplateBinding); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for templateBinding

			// End of user code

			basePart.addFilterToGeneralization(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Generalization); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for generalization

			// End of user code
			basePart.addFilterToPowertypeExtent(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInPowertypeExtentTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToPowertypeExtent(new EObjectFilter(UMLPackage.eINSTANCE.getGeneralizationSet()));
			// Start of user code for additional businessfilters for powertypeExtent

			// End of user code
			basePart.addFilterToRedefinedClassifier(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRedefinedClassifierTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRedefinedClassifier(new EObjectFilter(UMLPackage.eINSTANCE.getClassifier()));
			// Start of user code for additional businessfilters for redefinedClassifier

			// End of user code
			basePart.addFilterToSubstitution(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Substitution); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for substitution

			// End of user code
			basePart.addFilterToCollaborationUse(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof CollaborationUse); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for collaborationUse

			// End of user code
			basePart.addFilterToOwnedUseCase(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof UseCase); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedUseCase

			// End of user code
			basePart.addFilterToUseCase(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInUseCaseTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToUseCase(new EObjectFilter(UMLPackage.eINSTANCE.getUseCase()));
			// Start of user code for additional businessfilters for useCase

			// End of user code
			basePart.addFilterToOwnedAttribute(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Property); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedAttribute

			// End of user code
			basePart.addFilterToOwnedConnector(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Connector); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedConnector

			// End of user code
			basePart.addFilterToOwnedBehavior(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Behavior); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedBehavior

			// End of user code
			basePart.addFilterToInterfaceRealization(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof InterfaceRealization); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for interfaceRealization

			// End of user code
			basePart.addFilterToOwnedTrigger(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Trigger); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedTrigger

			// End of user code
			basePart.addFilterToNestedClassifier(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Classifier); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for nestedClassifier

			// End of user code
			basePart.addFilterToOwnedOperation(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Operation); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedOperation

			// End of user code

			basePart.addFilterToOwnedReception(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Reception); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedReception

			// End of user code

			basePart.addFilterToRedefinedBehavior(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRedefinedBehaviorTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRedefinedBehavior(new EObjectFilter(UMLPackage.eINSTANCE.getBehavior()));
			// Start of user code for additional businessfilters for redefinedBehavior

			// End of user code
			basePart.addFilterToOwnedParameter(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Parameter); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedParameter

			// End of user code
			basePart.addFilterToPrecondition(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInPreconditionTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToPrecondition(new EObjectFilter(UMLPackage.eINSTANCE.getConstraint()));
			// Start of user code for additional businessfilters for precondition

			// End of user code
			basePart.addFilterToPostcondition(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInPostconditionTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToPostcondition(new EObjectFilter(UMLPackage.eINSTANCE.getConstraint()));
			// Start of user code for additional businessfilters for postcondition

			// End of user code
			basePart.addFilterToOwnedParameterSet(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof ParameterSet); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedParameterSet

			// End of user code
			basePart.addFilterToRegion(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Region);

				}

			});
			// Start of user code for additional businessfilters for region

			// End of user code
			basePart.addFilterToSubmachineState(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInSubmachineStateTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToSubmachineState(new EObjectFilter(UMLPackage.eINSTANCE.getState()));
			// Start of user code for additional businessfilters for submachineState

			// End of user code
			basePart.addFilterToConnectionPoint(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Pseudostate); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for connectionPoint

			// End of user code
			basePart.addFilterToExtendedStateMachine(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInExtendedStateMachineTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToExtendedStateMachine(new EObjectFilter(UMLPackage.eINSTANCE.getStateMachine()));
			// Start of user code for additional businessfilters for extendedStateMachine

			// End of user code
		}
		// init values for referenced views

		// init filters for referenced views

	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *      (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if(stateMachine != null) {
			List ownedCommentToAddFromOwnedComment = basePart.getOwnedCommentToAdd();
			for(Iterator iter = ownedCommentToAddFromOwnedComment.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
			Map ownedCommentToRefreshFromOwnedComment = basePart.getOwnedCommentToEdit();
			for(Iterator iter = ownedCommentToRefreshFromOwnedComment.keySet().iterator(); iter.hasNext();) {



				Comment nextElement = (Comment)iter.next();
				Comment ownedComment = (Comment)ownedCommentToRefreshFromOwnedComment.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedComment.eGet(feature)));
					}
				}



			}
			List ownedCommentToRemoveFromOwnedComment = basePart.getOwnedCommentToRemove();
			for(Iterator iter = ownedCommentToRemoveFromOwnedComment.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedCommentToMoveFromOwnedComment = basePart.getOwnedCommentToMove();
			for(Iterator iter = ownedCommentToMoveFromOwnedComment.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAddFromClientDependency = basePart.getClientDependencyToAdd();
			for(Iterator iter = clientDependencyToAddFromClientDependency.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemoveFromClientDependency = basePart.getClientDependencyToRemove();
			for(Iterator iter = clientDependencyToRemoveFromClientDependency.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMoveFromClientDependency = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMoveFromClientDependency.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List elementImportToAddFromElementImport = basePart.getElementImportToAdd();
			for(Iterator iter = elementImportToAddFromElementImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
			Map elementImportToRefreshFromElementImport = basePart.getElementImportToEdit();
			for(Iterator iter = elementImportToRefreshFromElementImport.keySet().iterator(); iter.hasNext();) {



				ElementImport nextElement = (ElementImport)iter.next();
				ElementImport elementImport = (ElementImport)elementImportToRefreshFromElementImport.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, elementImport.eGet(feature)));
					}
				}



			}
			List elementImportToRemoveFromElementImport = basePart.getElementImportToRemove();
			for(Iterator iter = elementImportToRemoveFromElementImport.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List elementImportToMoveFromElementImport = basePart.getElementImportToMove();
			for(Iterator iter = elementImportToMoveFromElementImport.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAddFromPackageImport = basePart.getPackageImportToAdd();
			for(Iterator iter = packageImportToAddFromPackageImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
			Map packageImportToRefreshFromPackageImport = basePart.getPackageImportToEdit();
			for(Iterator iter = packageImportToRefreshFromPackageImport.keySet().iterator(); iter.hasNext();) {



				PackageImport nextElement = (PackageImport)iter.next();
				PackageImport packageImport = (PackageImport)packageImportToRefreshFromPackageImport.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, packageImport.eGet(feature)));
					}
				}



			}
			List packageImportToRemoveFromPackageImport = basePart.getPackageImportToRemove();
			for(Iterator iter = packageImportToRemoveFromPackageImport.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List packageImportToMoveFromPackageImport = basePart.getPackageImportToMove();
			for(Iterator iter = packageImportToMoveFromPackageImport.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAddFromOwnedRule = basePart.getOwnedRuleToAdd();
			for(Iterator iter = ownedRuleToAddFromOwnedRule.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
			Map ownedRuleToRefreshFromOwnedRule = basePart.getOwnedRuleToEdit();
			for(Iterator iter = ownedRuleToRefreshFromOwnedRule.keySet().iterator(); iter.hasNext();) {



				Constraint nextElement = (Constraint)iter.next();
				Constraint ownedRule = (Constraint)ownedRuleToRefreshFromOwnedRule.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedRule.eGet(feature)));
					}
				}



			}
			List ownedRuleToRemoveFromOwnedRule = basePart.getOwnedRuleToRemove();
			for(Iterator iter = ownedRuleToRemoveFromOwnedRule.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedRuleToMoveFromOwnedRule = basePart.getOwnedRuleToMove();
			for(Iterator iter = ownedRuleToMoveFromOwnedRule.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List templateBindingToAddFromTemplateBinding = basePart.getTemplateBindingToAdd();
			for(Iterator iter = templateBindingToAddFromTemplateBinding.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), iter.next()));
			Map templateBindingToRefreshFromTemplateBinding = basePart.getTemplateBindingToEdit();
			for(Iterator iter = templateBindingToRefreshFromTemplateBinding.keySet().iterator(); iter.hasNext();) {



				TemplateBinding nextElement = (TemplateBinding)iter.next();
				TemplateBinding templateBinding = (TemplateBinding)templateBindingToRefreshFromTemplateBinding.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, templateBinding.eGet(feature)));
					}
				}



			}
			List templateBindingToRemoveFromTemplateBinding = basePart.getTemplateBindingToRemove();
			for(Iterator iter = templateBindingToRemoveFromTemplateBinding.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List templateBindingToMoveFromTemplateBinding = basePart.getTemplateBindingToMove();
			for(Iterator iter = templateBindingToMoveFromTemplateBinding.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getTemplateBinding(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), basePart.getIsAbstract()));

			List generalizationToAddFromGeneralization = basePart.getGeneralizationToAdd();
			for(Iterator iter = generalizationToAddFromGeneralization.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_Generalization(), iter.next()));
			Map generalizationToRefreshFromGeneralization = basePart.getGeneralizationToEdit();
			for(Iterator iter = generalizationToRefreshFromGeneralization.keySet().iterator(); iter.hasNext();) {



				Generalization nextElement = (Generalization)iter.next();
				Generalization generalization = (Generalization)generalizationToRefreshFromGeneralization.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, generalization.eGet(feature)));
					}
				}



			}
			List generalizationToRemoveFromGeneralization = basePart.getGeneralizationToRemove();
			for(Iterator iter = generalizationToRemoveFromGeneralization.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List generalizationToMoveFromGeneralization = basePart.getGeneralizationToMove();
			for(Iterator iter = generalizationToMoveFromGeneralization.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getGeneralization(), moveElement.getElement(), moveElement.getIndex()));
			}
			List powertypeExtentToAddFromPowertypeExtent = basePart.getPowertypeExtentToAdd();
			for(Iterator iter = powertypeExtentToAddFromPowertypeExtent.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			List powertypeExtentToRemoveFromPowertypeExtent = basePart.getPowertypeExtentToRemove();
			for(Iterator iter = powertypeExtentToRemoveFromPowertypeExtent.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			//List powertypeExtentToMoveFromPowertypeExtent = basePart.getPowertypeExtentToMove();
			//for (Iterator iter = powertypeExtentToMoveFromPowertypeExtent.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getGeneralizationSet(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List redefinedClassifierToAddFromRedefinedClassifier = basePart.getRedefinedClassifierToAdd();
			for(Iterator iter = redefinedClassifierToAddFromRedefinedClassifier.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			List redefinedClassifierToRemoveFromRedefinedClassifier = basePart.getRedefinedClassifierToRemove();
			for(Iterator iter = redefinedClassifierToRemoveFromRedefinedClassifier.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			//List redefinedClassifierToMoveFromRedefinedClassifier = basePart.getRedefinedClassifierToMove();
			//for (Iterator iter = redefinedClassifierToMoveFromRedefinedClassifier.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List substitutionToAddFromSubstitution = basePart.getSubstitutionToAdd();
			for(Iterator iter = substitutionToAddFromSubstitution.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_Substitution(), iter.next()));
			Map substitutionToRefreshFromSubstitution = basePart.getSubstitutionToEdit();
			for(Iterator iter = substitutionToRefreshFromSubstitution.keySet().iterator(); iter.hasNext();) {



				Substitution nextElement = (Substitution)iter.next();
				Substitution substitution = (Substitution)substitutionToRefreshFromSubstitution.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, substitution.eGet(feature)));
					}
				}



			}
			List substitutionToRemoveFromSubstitution = basePart.getSubstitutionToRemove();
			for(Iterator iter = substitutionToRemoveFromSubstitution.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List substitutionToMoveFromSubstitution = basePart.getSubstitutionToMove();
			for(Iterator iter = substitutionToMoveFromSubstitution.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getSubstitution(), moveElement.getElement(), moveElement.getIndex()));
			}
			List collaborationUseToAddFromCollaborationUse = basePart.getCollaborationUseToAdd();
			for(Iterator iter = collaborationUseToAddFromCollaborationUse.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), iter.next()));
			Map collaborationUseToRefreshFromCollaborationUse = basePart.getCollaborationUseToEdit();
			for(Iterator iter = collaborationUseToRefreshFromCollaborationUse.keySet().iterator(); iter.hasNext();) {



				CollaborationUse nextElement = (CollaborationUse)iter.next();
				CollaborationUse collaborationUse = (CollaborationUse)collaborationUseToRefreshFromCollaborationUse.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, collaborationUse.eGet(feature)));
					}
				}



			}
			List collaborationUseToRemoveFromCollaborationUse = basePart.getCollaborationUseToRemove();
			for(Iterator iter = collaborationUseToRemoveFromCollaborationUse.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List collaborationUseToMoveFromCollaborationUse = basePart.getCollaborationUseToMove();
			for(Iterator iter = collaborationUseToMoveFromCollaborationUse.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getCollaborationUse(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedUseCaseToAddFromOwnedUseCase = basePart.getOwnedUseCaseToAdd();
			for(Iterator iter = ownedUseCaseToAddFromOwnedUseCase.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), iter.next()));
			Map ownedUseCaseToRefreshFromOwnedUseCase = basePart.getOwnedUseCaseToEdit();
			for(Iterator iter = ownedUseCaseToRefreshFromOwnedUseCase.keySet().iterator(); iter.hasNext();) {



				UseCase nextElement = (UseCase)iter.next();
				UseCase ownedUseCase = (UseCase)ownedUseCaseToRefreshFromOwnedUseCase.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedUseCase.eGet(feature)));
					}
				}



			}
			List ownedUseCaseToRemoveFromOwnedUseCase = basePart.getOwnedUseCaseToRemove();
			for(Iterator iter = ownedUseCaseToRemoveFromOwnedUseCase.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedUseCaseToMoveFromOwnedUseCase = basePart.getOwnedUseCaseToMove();
			for(Iterator iter = ownedUseCaseToMoveFromOwnedUseCase.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			}
			List useCaseToAddFromUseCase = basePart.getUseCaseToAdd();
			for(Iterator iter = useCaseToAddFromUseCase.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			List useCaseToRemoveFromUseCase = basePart.getUseCaseToRemove();
			for(Iterator iter = useCaseToRemoveFromUseCase.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			//List useCaseToMoveFromUseCase = basePart.getUseCaseToMove();
			//for (Iterator iter = useCaseToMoveFromUseCase.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List ownedAttributeToAddFromOwnedAttribute = basePart.getOwnedAttributeToAdd();
			for(Iterator iter = ownedAttributeToAddFromOwnedAttribute.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute(), iter.next()));
			Map ownedAttributeToRefreshFromOwnedAttribute = basePart.getOwnedAttributeToEdit();
			for(Iterator iter = ownedAttributeToRefreshFromOwnedAttribute.keySet().iterator(); iter.hasNext();) {



				Property nextElement = (Property)iter.next();
				Property ownedAttribute = (Property)ownedAttributeToRefreshFromOwnedAttribute.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedAttribute.eGet(feature)));
					}
				}



			}
			List ownedAttributeToRemoveFromOwnedAttribute = basePart.getOwnedAttributeToRemove();
			for(Iterator iter = ownedAttributeToRemoveFromOwnedAttribute.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedAttributeToMoveFromOwnedAttribute = basePart.getOwnedAttributeToMove();
			for(Iterator iter = ownedAttributeToMoveFromOwnedAttribute.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedConnectorToAddFromOwnedConnector = basePart.getOwnedConnectorToAdd();
			for(Iterator iter = ownedConnectorToAddFromOwnedConnector.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedConnector(), iter.next()));
			Map ownedConnectorToRefreshFromOwnedConnector = basePart.getOwnedConnectorToEdit();
			for(Iterator iter = ownedConnectorToRefreshFromOwnedConnector.keySet().iterator(); iter.hasNext();) {



				Connector nextElement = (Connector)iter.next();
				Connector ownedConnector = (Connector)ownedConnectorToRefreshFromOwnedConnector.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedConnector.eGet(feature)));
					}
				}



			}
			List ownedConnectorToRemoveFromOwnedConnector = basePart.getOwnedConnectorToRemove();
			for(Iterator iter = ownedConnectorToRemoveFromOwnedConnector.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedConnectorToMoveFromOwnedConnector = basePart.getOwnedConnectorToMove();
			for(Iterator iter = ownedConnectorToMoveFromOwnedConnector.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getConnector(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedBehaviorToAddFromOwnedBehavior = basePart.getOwnedBehaviorToAdd();
			for(Iterator iter = ownedBehaviorToAddFromOwnedBehavior.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior(), iter.next()));
			Map ownedBehaviorToRefreshFromOwnedBehavior = basePart.getOwnedBehaviorToEdit();
			for(Iterator iter = ownedBehaviorToRefreshFromOwnedBehavior.keySet().iterator(); iter.hasNext();) {



				Behavior nextElement = (Behavior)iter.next();
				Behavior ownedBehavior = (Behavior)ownedBehaviorToRefreshFromOwnedBehavior.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedBehavior.eGet(feature)));
					}
				}



			}
			List ownedBehaviorToRemoveFromOwnedBehavior = basePart.getOwnedBehaviorToRemove();
			for(Iterator iter = ownedBehaviorToRemoveFromOwnedBehavior.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedBehaviorToMoveFromOwnedBehavior = basePart.getOwnedBehaviorToMove();
			for(Iterator iter = ownedBehaviorToMoveFromOwnedBehavior.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior(), moveElement.getElement(), moveElement.getIndex()));
			}
			List interfaceRealizationToAddFromInterfaceRealization = basePart.getInterfaceRealizationToAdd();
			for(Iterator iter = interfaceRealizationToAddFromInterfaceRealization.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(), iter.next()));
			Map interfaceRealizationToRefreshFromInterfaceRealization = basePart.getInterfaceRealizationToEdit();
			for(Iterator iter = interfaceRealizationToRefreshFromInterfaceRealization.keySet().iterator(); iter.hasNext();) {



				InterfaceRealization nextElement = (InterfaceRealization)iter.next();
				InterfaceRealization interfaceRealization = (InterfaceRealization)interfaceRealizationToRefreshFromInterfaceRealization.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, interfaceRealization.eGet(feature)));
					}
				}



			}
			List interfaceRealizationToRemoveFromInterfaceRealization = basePart.getInterfaceRealizationToRemove();
			for(Iterator iter = interfaceRealizationToRemoveFromInterfaceRealization.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List interfaceRealizationToMoveFromInterfaceRealization = basePart.getInterfaceRealizationToMove();
			for(Iterator iter = interfaceRealizationToMoveFromInterfaceRealization.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getInterfaceRealization(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedTriggerToAddFromOwnedTrigger = basePart.getOwnedTriggerToAdd();
			for(Iterator iter = ownedTriggerToAddFromOwnedTrigger.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger(), iter.next()));
			Map ownedTriggerToRefreshFromOwnedTrigger = basePart.getOwnedTriggerToEdit();
			for(Iterator iter = ownedTriggerToRefreshFromOwnedTrigger.keySet().iterator(); iter.hasNext();) {



				Trigger nextElement = (Trigger)iter.next();
				Trigger ownedTrigger = (Trigger)ownedTriggerToRefreshFromOwnedTrigger.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedTrigger.eGet(feature)));
					}
				}



			}
			List ownedTriggerToRemoveFromOwnedTrigger = basePart.getOwnedTriggerToRemove();
			for(Iterator iter = ownedTriggerToRemoveFromOwnedTrigger.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedTriggerToMoveFromOwnedTrigger = basePart.getOwnedTriggerToMove();
			for(Iterator iter = ownedTriggerToMoveFromOwnedTrigger.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getTrigger(), moveElement.getElement(), moveElement.getIndex()));
			}
			List nestedClassifierToAddFromNestedClassifier = basePart.getNestedClassifierToAdd();
			for(Iterator iter = nestedClassifierToAddFromNestedClassifier.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_NestedClassifier(), iter.next()));
			Map nestedClassifierToRefreshFromNestedClassifier = basePart.getNestedClassifierToEdit();
			for(Iterator iter = nestedClassifierToRefreshFromNestedClassifier.keySet().iterator(); iter.hasNext();) {



				Classifier nextElement = (Classifier)iter.next();
				Classifier nestedClassifier = (Classifier)nestedClassifierToRefreshFromNestedClassifier.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, nestedClassifier.eGet(feature)));
					}
				}



			}
			List nestedClassifierToRemoveFromNestedClassifier = basePart.getNestedClassifierToRemove();
			for(Iterator iter = nestedClassifierToRemoveFromNestedClassifier.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List nestedClassifierToMoveFromNestedClassifier = basePart.getNestedClassifierToMove();
			for(Iterator iter = nestedClassifierToMoveFromNestedClassifier.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedOperationToAddFromOwnedOperation = basePart.getOwnedOperationToAdd();
			for(Iterator iter = ownedOperationToAddFromOwnedOperation.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_OwnedOperation(), iter.next()));
			Map ownedOperationToRefreshFromOwnedOperation = basePart.getOwnedOperationToEdit();
			for(Iterator iter = ownedOperationToRefreshFromOwnedOperation.keySet().iterator(); iter.hasNext();) {



				Operation nextElement = (Operation)iter.next();
				Operation ownedOperation = (Operation)ownedOperationToRefreshFromOwnedOperation.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedOperation.eGet(feature)));
					}
				}



			}
			List ownedOperationToRemoveFromOwnedOperation = basePart.getOwnedOperationToRemove();
			for(Iterator iter = ownedOperationToRemoveFromOwnedOperation.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedOperationToMoveFromOwnedOperation = basePart.getOwnedOperationToMove();
			for(Iterator iter = ownedOperationToMoveFromOwnedOperation.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getOperation(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_IsActive(), basePart.getIsActive()));

			List ownedReceptionToAddFromOwnedReception = basePart.getOwnedReceptionToAdd();
			for(Iterator iter = ownedReceptionToAddFromOwnedReception.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_OwnedReception(), iter.next()));
			Map ownedReceptionToRefreshFromOwnedReception = basePart.getOwnedReceptionToEdit();
			for(Iterator iter = ownedReceptionToRefreshFromOwnedReception.keySet().iterator(); iter.hasNext();) {



				Reception nextElement = (Reception)iter.next();
				Reception ownedReception = (Reception)ownedReceptionToRefreshFromOwnedReception.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedReception.eGet(feature)));
					}
				}



			}
			List ownedReceptionToRemoveFromOwnedReception = basePart.getOwnedReceptionToRemove();
			for(Iterator iter = ownedReceptionToRemoveFromOwnedReception.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedReceptionToMoveFromOwnedReception = basePart.getOwnedReceptionToMove();
			for(Iterator iter = ownedReceptionToMoveFromOwnedReception.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getReception(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_IsReentrant(), basePart.getIsReentrant()));

			List redefinedBehaviorToAddFromRedefinedBehavior = basePart.getRedefinedBehaviorToAdd();
			for(Iterator iter = redefinedBehaviorToAddFromRedefinedBehavior.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), iter.next()));
			List redefinedBehaviorToRemoveFromRedefinedBehavior = basePart.getRedefinedBehaviorToRemove();
			for(Iterator iter = redefinedBehaviorToRemoveFromRedefinedBehavior.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), iter.next()));
			//List redefinedBehaviorToMoveFromRedefinedBehavior = basePart.getRedefinedBehaviorToMove();
			//for (Iterator iter = redefinedBehaviorToMoveFromRedefinedBehavior.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List ownedParameterToAddFromOwnedParameter = basePart.getOwnedParameterToAdd();
			for(Iterator iter = ownedParameterToAddFromOwnedParameter.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_OwnedParameter(), iter.next()));
			Map ownedParameterToRefreshFromOwnedParameter = basePart.getOwnedParameterToEdit();
			for(Iterator iter = ownedParameterToRefreshFromOwnedParameter.keySet().iterator(); iter.hasNext();) {



				Parameter nextElement = (Parameter)iter.next();
				Parameter ownedParameter = (Parameter)ownedParameterToRefreshFromOwnedParameter.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedParameter.eGet(feature)));
					}
				}



			}
			List ownedParameterToRemoveFromOwnedParameter = basePart.getOwnedParameterToRemove();
			for(Iterator iter = ownedParameterToRemoveFromOwnedParameter.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedParameterToMoveFromOwnedParameter = basePart.getOwnedParameterToMove();
			for(Iterator iter = ownedParameterToMoveFromOwnedParameter.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getParameter(), moveElement.getElement(), moveElement.getIndex()));
			}
			List preconditionToAddFromPrecondition = basePart.getPreconditionToAdd();
			for(Iterator iter = preconditionToAddFromPrecondition.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), iter.next()));
			List preconditionToRemoveFromPrecondition = basePart.getPreconditionToRemove();
			for(Iterator iter = preconditionToRemoveFromPrecondition.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), iter.next()));
			//List preconditionToMoveFromPrecondition = basePart.getPreconditionToMove();
			//for (Iterator iter = preconditionToMoveFromPrecondition.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List postconditionToAddFromPostcondition = basePart.getPostconditionToAdd();
			for(Iterator iter = postconditionToAddFromPostcondition.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), iter.next()));
			List postconditionToRemoveFromPostcondition = basePart.getPostconditionToRemove();
			for(Iterator iter = postconditionToRemoveFromPostcondition.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), iter.next()));
			//List postconditionToMoveFromPostcondition = basePart.getPostconditionToMove();
			//for (Iterator iter = postconditionToMoveFromPostcondition.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List ownedParameterSetToAddFromOwnedParameterSet = basePart.getOwnedParameterSetToAdd();
			for(Iterator iter = ownedParameterSetToAddFromOwnedParameterSet.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_OwnedParameterSet(), iter.next()));
			Map ownedParameterSetToRefreshFromOwnedParameterSet = basePart.getOwnedParameterSetToEdit();
			for(Iterator iter = ownedParameterSetToRefreshFromOwnedParameterSet.keySet().iterator(); iter.hasNext();) {



				ParameterSet nextElement = (ParameterSet)iter.next();
				ParameterSet ownedParameterSet = (ParameterSet)ownedParameterSetToRefreshFromOwnedParameterSet.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedParameterSet.eGet(feature)));
					}
				}



			}
			List ownedParameterSetToRemoveFromOwnedParameterSet = basePart.getOwnedParameterSetToRemove();
			for(Iterator iter = ownedParameterSetToRemoveFromOwnedParameterSet.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedParameterSetToMoveFromOwnedParameterSet = basePart.getOwnedParameterSetToMove();
			for(Iterator iter = ownedParameterSetToMoveFromOwnedParameterSet.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getParameterSet(), moveElement.getElement(), moveElement.getIndex()));
			}
			List regionToAddFromRegion = basePart.getRegionToAdd();
			for(Iterator iter = regionToAddFromRegion.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_Region(), iter.next()));
			Map regionToRefreshFromRegion = basePart.getRegionToEdit();
			for(Iterator iter = regionToRefreshFromRegion.keySet().iterator(); iter.hasNext();) {



				Region nextElement = (Region)iter.next();
				Region region = (Region)regionToRefreshFromRegion.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, region.eGet(feature)));
					}
				}



			}
			List regionToRemoveFromRegion = basePart.getRegionToRemove();
			for(Iterator iter = regionToRemoveFromRegion.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List regionToMoveFromRegion = basePart.getRegionToMove();
			for(Iterator iter = regionToMoveFromRegion.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getRegion(), moveElement.getElement(), moveElement.getIndex()));
			}
			List submachineStateToAddFromSubmachineState = basePart.getSubmachineStateToAdd();
			for(Iterator iter = submachineStateToAddFromSubmachineState.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), iter.next()));
			List submachineStateToRemoveFromSubmachineState = basePart.getSubmachineStateToRemove();
			for(Iterator iter = submachineStateToRemoveFromSubmachineState.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), iter.next()));
			//List submachineStateToMoveFromSubmachineState = basePart.getSubmachineStateToMove();
			//for (Iterator iter = submachineStateToMoveFromSubmachineState.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getState(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List connectionPointToAddFromConnectionPoint = basePart.getConnectionPointToAdd();
			for(Iterator iter = connectionPointToAddFromConnectionPoint.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint(), iter.next()));
			Map connectionPointToRefreshFromConnectionPoint = basePart.getConnectionPointToEdit();
			for(Iterator iter = connectionPointToRefreshFromConnectionPoint.keySet().iterator(); iter.hasNext();) {



				Pseudostate nextElement = (Pseudostate)iter.next();
				Pseudostate connectionPoint = (Pseudostate)connectionPointToRefreshFromConnectionPoint.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, connectionPoint.eGet(feature)));
					}
				}



			}
			List connectionPointToRemoveFromConnectionPoint = basePart.getConnectionPointToRemove();
			for(Iterator iter = connectionPointToRemoveFromConnectionPoint.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List connectionPointToMoveFromConnectionPoint = basePart.getConnectionPointToMove();
			for(Iterator iter = connectionPointToMoveFromConnectionPoint.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getPseudostate(), moveElement.getElement(), moveElement.getIndex()));
			}
			List extendedStateMachineToAddFromExtendedStateMachine = basePart.getExtendedStateMachineToAdd();
			for(Iterator iter = extendedStateMachineToAddFromExtendedStateMachine.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), iter.next()));
			List extendedStateMachineToRemoveFromExtendedStateMachine = basePart.getExtendedStateMachineToRemove();
			for(Iterator iter = extendedStateMachineToRemoveFromExtendedStateMachine.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), iter.next()));
			//List extendedStateMachineToMoveFromExtendedStateMachine = basePart.getExtendedStateMachineToMove();
			//for (Iterator iter = extendedStateMachineToMoveFromExtendedStateMachine.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine(), moveElement.getElement(), moveElement.getIndex()));
			//}


		}
		if(!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if(source instanceof StateMachine) {
			StateMachine stateMachineToUpdate = (StateMachine)source;
			stateMachineToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			stateMachineToUpdate.setName(basePart.getName());

			stateMachineToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

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
		if(PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if(UMLViewsRepository.StateMachine.ownedComment == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.StateMachine.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.StateMachine.clientDependency == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.elementImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport)event.getOldValue();
					ElementImport newValue = (ElementImport)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.packageImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport)event.getOldValue();
					PackageImport newValue = (PackageImport)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.ownedRule == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if(UMLViewsRepository.StateMachine.templateBinding == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					TemplateBinding oldValue = (TemplateBinding)event.getOldValue();
					TemplateBinding newValue = (TemplateBinding)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getTemplateBinding(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.isAbstract == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), event.getNewValue()));

			if(UMLViewsRepository.StateMachine.generalization == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Generalization oldValue = (Generalization)event.getOldValue();
					Generalization newValue = (Generalization)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_Generalization(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getGeneralization(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.powertypeExtent == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.redefinedClassifier == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.substitution == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Substitution oldValue = (Substitution)event.getOldValue();
					Substitution newValue = (Substitution)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_Substitution(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getSubstitution(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.collaborationUse == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					CollaborationUse oldValue = (CollaborationUse)event.getOldValue();
					CollaborationUse newValue = (CollaborationUse)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getCollaborationUse(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.ownedUseCase == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					UseCase oldValue = (UseCase)event.getOldValue();
					UseCase newValue = (UseCase)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getUseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.useCase == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.ownedAttribute == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Property oldValue = (Property)event.getOldValue();
					Property newValue = (Property)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.ownedConnector == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Connector oldValue = (Connector)event.getOldValue();
					Connector newValue = (Connector)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedConnector(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getConnector(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.ownedBehavior == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Behavior oldValue = (Behavior)event.getOldValue();
					Behavior newValue = (Behavior)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.interfaceRealization == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					InterfaceRealization oldValue = (InterfaceRealization)event.getOldValue();
					InterfaceRealization newValue = (InterfaceRealization)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getInterfaceRealization(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.ownedTrigger == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Trigger oldValue = (Trigger)event.getOldValue();
					Trigger newValue = (Trigger)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getTrigger(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.nestedClassifier == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Classifier oldValue = (Classifier)event.getOldValue();
					Classifier newValue = (Classifier)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_NestedClassifier(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClassifier(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.ownedOperation == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Operation oldValue = (Operation)event.getOldValue();
					Operation newValue = (Operation)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_OwnedOperation(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getOperation(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.isActive == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_IsActive(), event.getNewValue()));

			if(UMLViewsRepository.StateMachine.ownedReception == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Reception oldValue = (Reception)event.getOldValue();
					Reception newValue = (Reception)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getClass_OwnedReception(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getReception(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.isReentrant == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_IsReentrant(), event.getNewValue()));

			if(UMLViewsRepository.StateMachine.redefinedBehavior == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_RedefinedBehavior(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.ownedParameter == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Parameter oldValue = (Parameter)event.getOldValue();
					Parameter newValue = (Parameter)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_OwnedParameter(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getParameter(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.precondition == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Precondition(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.postcondition == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_Postcondition(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.ownedParameterSet == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ParameterSet oldValue = (ParameterSet)event.getOldValue();
					ParameterSet newValue = (ParameterSet)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getBehavior_OwnedParameterSet(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getParameterSet(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.region == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Region oldValue = (Region)event.getOldValue();
					Region newValue = (Region)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_Region(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getRegion(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.submachineState == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_SubmachineState(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.connectionPoint == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Pseudostate oldValue = (Pseudostate)event.getOldValue();
					Pseudostate newValue = (Pseudostate)event.getNewValue();


					// TODO: Complete the stateMachine update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ConnectionPoint(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getPseudostate(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.StateMachine.extendedStateMachine == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, stateMachine, UMLPackage.eINSTANCE.getStateMachine_ExtendedStateMachine(), event.getNewValue(), event.getNewIndex()));
			}


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {

				if(UMLViewsRepository.StateMachine.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





			} else {

				if(UMLViewsRepository.StateMachine.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.StateMachine.isLeaf || key == UMLViewsRepository.StateMachine.isAbstract || key == UMLViewsRepository.StateMachine.isActive || key == UMLViewsRepository.StateMachine.isReentrant || key == UMLViewsRepository.StateMachine.region;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if(event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if(UMLViewsRepository.StateMachine.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.StateMachine.visibility == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.StateMachine.isLeaf == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.StateMachine.isAbstract == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getClassifier_IsAbstract().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getClassifier_IsAbstract().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.StateMachine.isActive == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getClass_IsActive().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getClass_IsActive().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.StateMachine.isReentrant == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getBehavior_IsReentrant().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getBehavior_IsReentrant().getEAttributeType(), newValue);
				}

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = null;
		if(IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			validate = Diagnostician.INSTANCE.validate(copy);
		} else if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = Diagnostician.INSTANCE.validate(stateMachine);
		// Start of user code for custom validation check

		// End of user code

		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if(semanticAdapter != null)
			stateMachine.eAdapters().remove(semanticAdapter);
	}

}
