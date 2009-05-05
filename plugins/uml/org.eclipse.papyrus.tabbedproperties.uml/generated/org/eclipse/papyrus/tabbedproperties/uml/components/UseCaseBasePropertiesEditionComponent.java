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

import org.eclipse.uml2.uml.UseCase;

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
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.Classifier;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart;
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
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class UseCaseBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private UseCase useCase;

	/**
	 * The Base part
	 */
	private UseCasePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public UseCaseBasePropertiesEditionComponent(EObject useCase, String editing_mode) {
		if (useCase instanceof UseCase) {
			this.useCase = (UseCase) useCase;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.useCase.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(useCase);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(useCase);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getElementImport())) {
					basePart.updateElementImport(useCase);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageImport())) {
					basePart.updatePackageImport(useCase);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateOwnedRule(useCase);
				}
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getTemplateBinding())) {
					basePart.updateTemplateBinding(useCase);
				}
				if (UMLPackage.eINSTANCE.getClassifier_IsAbstract().equals(msg.getFeature()) && basePart != null)
					basePart.setIsAbstract((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Generalization() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getGeneralization())) {
					basePart.updateGeneralization(useCase);
				}
				if (UMLPackage.eINSTANCE.getClassifier_PowertypeExtent().equals(msg.getFeature()))
					basePart.updatePowertypeExtent(useCase);
				if (UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier().equals(msg.getFeature()))
					basePart.updateRedefinedClassifier(useCase);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Substitution() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getSubstitution())) {
					basePart.updateSubstitution(useCase);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_CollaborationUse() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getCollaborationUse())) {
					basePart.updateCollaborationUse(useCase);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_OwnedUseCase() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getUseCase())) {
					basePart.updateOwnedUseCase(useCase);
				}
				if (UMLPackage.eINSTANCE.getClassifier_UseCase().equals(msg.getFeature()))
					basePart.updateUseCase(useCase);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getBehavior())) {
					basePart.updateOwnedBehavior(useCase);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization() || ((EStructuralFeature) msg.getFeature())
								.getEContainingClass() == UMLPackage.eINSTANCE.getInterfaceRealization())) {
					basePart.updateInterfaceRealization(useCase);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getTrigger())) {
					basePart.updateOwnedTrigger(useCase);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getUseCase_Include() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getInclude())) {
					basePart.updateInclude(useCase);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getUseCase_Extend() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getExtend())) {
					basePart.updateExtend(useCase);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getUseCase_ExtensionPoint() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getExtensionPoint())) {
					basePart.updateExtensionPoint(useCase);
				}
				if (UMLPackage.eINSTANCE.getUseCase_Subject().equals(msg.getFeature()))
					basePart.updateSubject(useCase);

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
			return UMLViewsRepository.UseCase.class;
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
		if (useCase != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (UseCasePropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.UseCase.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.UseCase.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			UseCase useCase = (UseCase) elt;
			basePart.initOwnedComment(useCase, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (useCase.getName() != null)
				basePart.setName(useCase.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), useCase.getVisibility());
			basePart.initClientDependency(useCase, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initElementImport(useCase, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(useCase, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(useCase, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.setIsLeaf(useCase.isLeaf());

			basePart.initTemplateBinding(useCase, null, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding());
			basePart.setIsAbstract(useCase.isAbstract());

			basePart.initGeneralization(useCase, null, UMLPackage.eINSTANCE.getClassifier_Generalization());
			basePart.initPowertypeExtent(useCase, null, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent());
			basePart.initRedefinedClassifier(useCase, null, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier());
			basePart.initSubstitution(useCase, null, UMLPackage.eINSTANCE.getClassifier_Substitution());
			basePart.initCollaborationUse(useCase, null, UMLPackage.eINSTANCE.getClassifier_CollaborationUse());
			basePart.initOwnedUseCase(useCase, null, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase());
			basePart.initUseCase(useCase, null, UMLPackage.eINSTANCE.getClassifier_UseCase());
			basePart.initOwnedBehavior(useCase, null, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior());
			basePart.initInterfaceRealization(useCase, null, UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization());
			basePart.initOwnedTrigger(useCase, null, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger());
			basePart.initInclude(useCase, null, UMLPackage.eINSTANCE.getUseCase_Include());
			basePart.initExtend(useCase, null, UMLPackage.eINSTANCE.getUseCase_Extend());
			basePart.initExtensionPoint(useCase, null, UMLPackage.eINSTANCE.getUseCase_ExtensionPoint());
			basePart.initSubject(useCase, null, UMLPackage.eINSTANCE.getUseCase_Subject());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (useCase != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List elementImportToAdd = basePart.getElementImportToAdd();
			for (Iterator iter = elementImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAdd = basePart.getPackageImportToAdd();
			for (Iterator iter = packageImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAdd = basePart.getOwnedRuleToAdd();
			for (Iterator iter = ownedRuleToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List templateBindingToAdd = basePart.getTemplateBindingToAdd();
			for (Iterator iter = templateBindingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getTemplateBinding(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), basePart.getIsAbstract()));

			List generalizationToAdd = basePart.getGeneralizationToAdd();
			for (Iterator iter = generalizationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_Generalization(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getGeneralization(), moveElement.getElement(), moveElement.getIndex()));
			}
			List powertypeExtentToAdd = basePart.getPowertypeExtentToAdd();
			for (Iterator iter = powertypeExtentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			List powertypeExtentToRemove = basePart.getPowertypeExtentToRemove();
			for (Iterator iter = powertypeExtentToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			// List powertypeExtentToMove = basePart.getPowertypeExtentToMove();
			// for (Iterator iter = powertypeExtentToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getGeneralizationSet(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List redefinedClassifierToAdd = basePart.getRedefinedClassifierToAdd();
			for (Iterator iter = redefinedClassifierToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			List redefinedClassifierToRemove = basePart.getRedefinedClassifierToRemove();
			for (Iterator iter = redefinedClassifierToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			// List redefinedClassifierToMove = basePart.getRedefinedClassifierToMove();
			// for (Iterator iter = redefinedClassifierToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List substitutionToAdd = basePart.getSubstitutionToAdd();
			for (Iterator iter = substitutionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_Substitution(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getSubstitution(), moveElement.getElement(), moveElement.getIndex()));
			}
			List collaborationUseToAdd = basePart.getCollaborationUseToAdd();
			for (Iterator iter = collaborationUseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getCollaborationUse(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedUseCaseToAdd = basePart.getOwnedUseCaseToAdd();
			for (Iterator iter = ownedUseCaseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			}
			List useCaseToAdd = basePart.getUseCaseToAdd();
			for (Iterator iter = useCaseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			List useCaseToRemove = basePart.getUseCaseToRemove();
			for (Iterator iter = useCaseToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			// List useCaseToMove = basePart.getUseCaseToMove();
			// for (Iterator iter = useCaseToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List ownedBehaviorToAdd = basePart.getOwnedBehaviorToAdd();
			for (Iterator iter = ownedBehaviorToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getBehavior(), moveElement.getElement(), moveElement.getIndex()));
			}
			List interfaceRealizationToAdd = basePart.getInterfaceRealizationToAdd();
			for (Iterator iter = interfaceRealizationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getInterfaceRealization(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedTriggerToAdd = basePart.getOwnedTriggerToAdd();
			for (Iterator iter = ownedTriggerToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getTrigger(), moveElement.getElement(), moveElement.getIndex()));
			}
			List includeToAdd = basePart.getIncludeToAdd();
			for (Iterator iter = includeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_Include(), iter.next()));
			Map includeToRefresh = basePart.getIncludeToEdit();
			for (Iterator iter = includeToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for include reference refreshment

				Include nextElement = (Include) iter.next();
				Include include = (Include) includeToRefresh.get(nextElement);

				// End of user code
			}
			List includeToRemove = basePart.getIncludeToRemove();
			for (Iterator iter = includeToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List includeToMove = basePart.getIncludeToMove();
			for (Iterator iter = includeToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getInclude(), moveElement.getElement(), moveElement.getIndex()));
			}
			List extendToAdd = basePart.getExtendToAdd();
			for (Iterator iter = extendToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_Extend(), iter.next()));
			Map extendToRefresh = basePart.getExtendToEdit();
			for (Iterator iter = extendToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for extend reference refreshment

				Extend nextElement = (Extend) iter.next();
				Extend extend = (Extend) extendToRefresh.get(nextElement);

				// End of user code
			}
			List extendToRemove = basePart.getExtendToRemove();
			for (Iterator iter = extendToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List extendToMove = basePart.getExtendToMove();
			for (Iterator iter = extendToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getExtend(), moveElement.getElement(), moveElement.getIndex()));
			}
			List extensionPointToAdd = basePart.getExtensionPointToAdd();
			for (Iterator iter = extensionPointToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_ExtensionPoint(), iter.next()));
			Map extensionPointToRefresh = basePart.getExtensionPointToEdit();
			for (Iterator iter = extensionPointToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for extensionPoint reference refreshment

				ExtensionPoint nextElement = (ExtensionPoint) iter.next();
				ExtensionPoint extensionPoint = (ExtensionPoint) extensionPointToRefresh.get(nextElement);

				// End of user code
			}
			List extensionPointToRemove = basePart.getExtensionPointToRemove();
			for (Iterator iter = extensionPointToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List extensionPointToMove = basePart.getExtensionPointToMove();
			for (Iterator iter = extensionPointToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getExtensionPoint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List subjectToAdd = basePart.getSubjectToAdd();
			for (Iterator iter = subjectToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_Subject(), iter.next()));
			List subjectToRemove = basePart.getSubjectToRemove();
			for (Iterator iter = subjectToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_Subject(), iter.next()));
			// List subjectToMove = basePart.getSubjectToMove();
			// for (Iterator iter = subjectToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, useCase, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof UseCase) {
			UseCase useCaseToUpdate = (UseCase) source;
			useCaseToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			useCaseToUpdate.setName(basePart.getName());

			useCaseToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			useCaseToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			useCaseToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			useCaseToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			useCaseToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			useCaseToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			useCaseToUpdate.getTemplateBindings().addAll(basePart.getTemplateBindingToAdd());
			useCaseToUpdate.setIsAbstract(new Boolean(basePart.getIsAbstract()).booleanValue());

			useCaseToUpdate.getGeneralizations().addAll(basePart.getGeneralizationToAdd());
			useCaseToUpdate.getPowertypeExtents().addAll(basePart.getPowertypeExtentToAdd());
			useCaseToUpdate.getRedefinedClassifiers().addAll(basePart.getRedefinedClassifierToAdd());
			useCaseToUpdate.getSubstitutions().addAll(basePart.getSubstitutionToAdd());
			useCaseToUpdate.getCollaborationUses().addAll(basePart.getCollaborationUseToAdd());
			useCaseToUpdate.getOwnedUseCases().addAll(basePart.getOwnedUseCaseToAdd());
			useCaseToUpdate.getUseCases().addAll(basePart.getUseCaseToAdd());
			useCaseToUpdate.getOwnedBehaviors().addAll(basePart.getOwnedBehaviorToAdd());
			useCaseToUpdate.getInterfaceRealizations().addAll(basePart.getInterfaceRealizationToAdd());
			useCaseToUpdate.getOwnedTriggers().addAll(basePart.getOwnedTriggerToAdd());
			useCaseToUpdate.getIncludes().addAll(basePart.getIncludeToAdd());
			useCaseToUpdate.getExtends().addAll(basePart.getExtendToAdd());
			useCaseToUpdate.getExtensionPoints().addAll(basePart.getExtensionPointToAdd());
			useCaseToUpdate.getSubjects().addAll(basePart.getSubjectToAdd());

			return useCaseToUpdate;
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
			if (UMLViewsRepository.UseCase.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.UseCase.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.UseCase.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.elementImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport) event.getOldValue();
					ElementImport newValue = (ElementImport) event.getNewValue();

					// Start of user code for elementImport live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.packageImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport) event.getOldValue();
					PackageImport newValue = (PackageImport) event.getNewValue();

					// Start of user code for packageImport live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.ownedRule == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for ownedRule live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.UseCase.templateBinding == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					TemplateBinding oldValue = (TemplateBinding) event.getOldValue();
					TemplateBinding newValue = (TemplateBinding) event.getNewValue();

					// Start of user code for templateBinding live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getTemplateBinding(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.isAbstract == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), event.getNewValue()));

			if (UMLViewsRepository.UseCase.generalization == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Generalization oldValue = (Generalization) event.getOldValue();
					Generalization newValue = (Generalization) event.getNewValue();

					// Start of user code for generalization live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_Generalization(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getGeneralization(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.powertypeExtent == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.redefinedClassifier == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.substitution == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Substitution oldValue = (Substitution) event.getOldValue();
					Substitution newValue = (Substitution) event.getNewValue();

					// Start of user code for substitution live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_Substitution(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getSubstitution(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.collaborationUse == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					CollaborationUse oldValue = (CollaborationUse) event.getOldValue();
					CollaborationUse newValue = (CollaborationUse) event.getNewValue();

					// Start of user code for collaborationUse live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getCollaborationUse(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.ownedUseCase == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					UseCase oldValue = (UseCase) event.getOldValue();
					UseCase newValue = (UseCase) event.getNewValue();

					// Start of user code for ownedUseCase live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getUseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.useCase == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.ownedBehavior == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Behavior oldValue = (Behavior) event.getOldValue();
					Behavior newValue = (Behavior) event.getNewValue();

					// Start of user code for ownedBehavior live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getBehavior(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.interfaceRealization == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					InterfaceRealization oldValue = (InterfaceRealization) event.getOldValue();
					InterfaceRealization newValue = (InterfaceRealization) event.getNewValue();

					// Start of user code for interfaceRealization live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getInterfaceRealization(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.ownedTrigger == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Trigger oldValue = (Trigger) event.getOldValue();
					Trigger newValue = (Trigger) event.getNewValue();

					// Start of user code for ownedTrigger live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedTrigger(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getTrigger(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.include == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Include oldValue = (Include) event.getOldValue();
					Include newValue = (Include) event.getNewValue();

					// Start of user code for include live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_Include(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getInclude(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.extend == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Extend oldValue = (Extend) event.getOldValue();
					Extend newValue = (Extend) event.getNewValue();

					// Start of user code for extend live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_Extend(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getExtend(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.extensionPoint == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ExtensionPoint oldValue = (ExtensionPoint) event.getOldValue();
					ExtensionPoint newValue = (ExtensionPoint) event.getNewValue();

					// Start of user code for extensionPoint live update command
					// TODO: Complete the useCase update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_ExtensionPoint(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getExtensionPoint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.UseCase.subject == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_Subject(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_Subject(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, useCase, UMLPackage.eINSTANCE.getUseCase_Subject(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.UseCase.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.UseCase.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.UseCase.isLeaf || key == UMLViewsRepository.UseCase.isAbstract;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.UseCase.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.elementImport)
			return "References the ElementImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.packageImport)
			return "References the PackageImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.ownedRule)
			return "Specifies a set of Constraints owned by this Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.templateBinding)
			return "The optional bindings from this element to templates."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.isAbstract)
			return "If true, the Classifier does not provide a complete declaration and can typically not be instantiated. An abstract classifier is intended to be used by other classifiers e.g. as the target of general metarelationships or generalization relationships."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.generalization)
			return "Specifies the Generalization relationships for this Classifier. These Generalizations navigaten to more general classifiers in the generalization hierarchy."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.powertypeExtent)
			return "Designates the GeneralizationSet of which the associated Classifier is a power type."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.redefinedClassifier)
			return "References the Classifiers that are redefined by this Classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.substitution)
			return "References the substitutions that are owned by this Classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.collaborationUse)
			return "References the collaboration uses owned by the classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.ownedUseCase)
			return "References the use cases owned by this classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.useCase)
			return "The set of use cases for which this Classifier is the subject."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.ownedBehavior)
			return "References behavior specifications owned by a classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.interfaceRealization)
			return "The set of InterfaceRealizations owned by the BehavioredClassifier. Interface realizations reference the Interfaces of which the BehavioredClassifier is an implementation."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.ownedTrigger)
			return "References Trigger descriptions owned by a Classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.include)
			return "References the Include relationships owned by this use case."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.extend)
			return "References the Extend relationships owned by this use case."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.extensionPoint)
			return "References the ExtensionPoints owned by the use case."; //$NON-NLS-1$
		if (key == UMLViewsRepository.UseCase.subject)
			return "References the subjects to which this use case applies. The subject or its parts realize all the use cases that apply to this subject. Use cases need not be attached to any specific subject, however. The subject may, but need not, own the use cases that apply to it."; //$NON-NLS-1$
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
			if (UMLViewsRepository.UseCase.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.UseCase.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.UseCase.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.UseCase.isAbstract == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getClassifier_IsAbstract().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getClassifier_IsAbstract().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(useCase);
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
			useCase.eAdapters().remove(semanticAdapter);
	}

}
