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

import org.eclipse.uml2.uml.DataType;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.VisibilityKind;
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
import org.eclipse.uml2.uml.Operation;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.DataTypePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DataTypeBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private DataType dataType;

	/**
	 * The Base part
	 */
	private DataTypePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public DataTypeBasePropertiesEditionComponent(EObject dataType, String editing_mode) {
		if (dataType instanceof DataType) {
			this.dataType = (DataType) dataType;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.dataType.eAdapters().add(semanticAdapter);
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
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getElementImport())) {
					basePart.updateElementImport(dataType);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageImport())) {
					basePart.updatePackageImport(dataType);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateOwnedRule(dataType);
				}
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getTemplateBinding())) {
					basePart.updateTemplateBinding(dataType);
				}
				if (UMLPackage.eINSTANCE.getClassifier_IsAbstract().equals(msg.getFeature()) && basePart != null)
					basePart.setIsAbstract((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Generalization() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getGeneralization())) {
					basePart.updateGeneralization(dataType);
				}
				if (UMLPackage.eINSTANCE.getClassifier_PowertypeExtent().equals(msg.getFeature()))
					basePart.updatePowertypeExtent(dataType);
				if (UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier().equals(msg.getFeature()))
					basePart.updateRedefinedClassifier(dataType);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Substitution() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getSubstitution())) {
					basePart.updateSubstitution(dataType);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_CollaborationUse() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getCollaborationUse())) {
					basePart.updateCollaborationUse(dataType);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_OwnedUseCase() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getUseCase())) {
					basePart.updateOwnedUseCase(dataType);
				}
				if (UMLPackage.eINSTANCE.getClassifier_UseCase().equals(msg.getFeature()))
					basePart.updateUseCase(dataType);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getDataType_OwnedAttribute() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getProperty())) {
					basePart.updateOwnedAttribute(dataType);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getDataType_OwnedOperation() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getOperation())) {
					basePart.updateOwnedOperation(dataType);
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
			return UMLViewsRepository.DataType.class;
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
		if (dataType != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (DataTypePropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.DataType.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.DataType.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			DataType dataType = (DataType) elt;
			if (dataType.getName() != null)
				basePart.setName(dataType.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), dataType.getVisibility());
			basePart.initElementImport(dataType, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(dataType, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(dataType, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.setIsLeaf(dataType.isLeaf());

			basePart.initTemplateBinding(dataType, null, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding());
			basePart.setIsAbstract(dataType.isAbstract());

			basePart.initGeneralization(dataType, null, UMLPackage.eINSTANCE.getClassifier_Generalization());
			basePart.initPowertypeExtent(dataType, null, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent());
			basePart.initRedefinedClassifier(dataType, null, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier());
			basePart.initSubstitution(dataType, null, UMLPackage.eINSTANCE.getClassifier_Substitution());
			basePart.initCollaborationUse(dataType, null, UMLPackage.eINSTANCE.getClassifier_CollaborationUse());
			basePart.initOwnedUseCase(dataType, null, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase());
			basePart.initUseCase(dataType, null, UMLPackage.eINSTANCE.getClassifier_UseCase());
			basePart.initOwnedAttribute(dataType, null, UMLPackage.eINSTANCE.getDataType_OwnedAttribute());
			basePart.initOwnedOperation(dataType, null, UMLPackage.eINSTANCE.getDataType_OwnedOperation());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (dataType != null) {
			cc.append(SetCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List elementImportToAdd = basePart.getElementImportToAdd();
			for (Iterator iter = elementImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAdd = basePart.getPackageImportToAdd();
			for (Iterator iter = packageImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAdd = basePart.getOwnedRuleToAdd();
			for (Iterator iter = ownedRuleToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List templateBindingToAdd = basePart.getTemplateBindingToAdd();
			for (Iterator iter = templateBindingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getTemplateBinding(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), basePart.getIsAbstract()));

			List generalizationToAdd = basePart.getGeneralizationToAdd();
			for (Iterator iter = generalizationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_Generalization(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getGeneralization(), moveElement.getElement(), moveElement.getIndex()));
			}
			List powertypeExtentToAdd = basePart.getPowertypeExtentToAdd();
			for (Iterator iter = powertypeExtentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			List powertypeExtentToRemove = basePart.getPowertypeExtentToRemove();
			for (Iterator iter = powertypeExtentToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			// List powertypeExtentToMove = basePart.getPowertypeExtentToMove();
			// for (Iterator iter = powertypeExtentToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getGeneralizationSet(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List redefinedClassifierToAdd = basePart.getRedefinedClassifierToAdd();
			for (Iterator iter = redefinedClassifierToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			List redefinedClassifierToRemove = basePart.getRedefinedClassifierToRemove();
			for (Iterator iter = redefinedClassifierToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			// List redefinedClassifierToMove = basePart.getRedefinedClassifierToMove();
			// for (Iterator iter = redefinedClassifierToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List substitutionToAdd = basePart.getSubstitutionToAdd();
			for (Iterator iter = substitutionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_Substitution(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getSubstitution(), moveElement.getElement(), moveElement.getIndex()));
			}
			List collaborationUseToAdd = basePart.getCollaborationUseToAdd();
			for (Iterator iter = collaborationUseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getCollaborationUse(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedUseCaseToAdd = basePart.getOwnedUseCaseToAdd();
			for (Iterator iter = ownedUseCaseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			}
			List useCaseToAdd = basePart.getUseCaseToAdd();
			for (Iterator iter = useCaseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			List useCaseToRemove = basePart.getUseCaseToRemove();
			for (Iterator iter = useCaseToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			// List useCaseToMove = basePart.getUseCaseToMove();
			// for (Iterator iter = useCaseToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List ownedAttributeToAdd = basePart.getOwnedAttributeToAdd();
			for (Iterator iter = ownedAttributeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getDataType_OwnedAttribute(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedOperationToAdd = basePart.getOwnedOperationToAdd();
			for (Iterator iter = ownedOperationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getDataType_OwnedOperation(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getOperation(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof DataType) {
			DataType dataTypeToUpdate = (DataType) source;
			dataTypeToUpdate.setName(basePart.getName());

			dataTypeToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			dataTypeToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			dataTypeToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			dataTypeToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			dataTypeToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			dataTypeToUpdate.getTemplateBindings().addAll(basePart.getTemplateBindingToAdd());
			dataTypeToUpdate.setIsAbstract(new Boolean(basePart.getIsAbstract()).booleanValue());

			dataTypeToUpdate.getGeneralizations().addAll(basePart.getGeneralizationToAdd());
			dataTypeToUpdate.getPowertypeExtents().addAll(basePart.getPowertypeExtentToAdd());
			dataTypeToUpdate.getRedefinedClassifiers().addAll(basePart.getRedefinedClassifierToAdd());
			dataTypeToUpdate.getSubstitutions().addAll(basePart.getSubstitutionToAdd());
			dataTypeToUpdate.getCollaborationUses().addAll(basePart.getCollaborationUseToAdd());
			dataTypeToUpdate.getOwnedUseCases().addAll(basePart.getOwnedUseCaseToAdd());
			dataTypeToUpdate.getUseCases().addAll(basePart.getUseCaseToAdd());
			dataTypeToUpdate.getOwnedAttributes().addAll(basePart.getOwnedAttributeToAdd());
			dataTypeToUpdate.getOwnedOperations().addAll(basePart.getOwnedOperationToAdd());

			return dataTypeToUpdate;
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
			if (UMLViewsRepository.DataType.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.DataType.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.DataType.elementImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport) event.getOldValue();
					ElementImport newValue = (ElementImport) event.getNewValue();

					// Start of user code for elementImport live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.packageImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport) event.getOldValue();
					PackageImport newValue = (PackageImport) event.getNewValue();

					// Start of user code for packageImport live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.ownedRule == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for ownedRule live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.DataType.templateBinding == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					TemplateBinding oldValue = (TemplateBinding) event.getOldValue();
					TemplateBinding newValue = (TemplateBinding) event.getNewValue();

					// Start of user code for templateBinding live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getTemplateBinding(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.isAbstract == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), event.getNewValue()));

			if (UMLViewsRepository.DataType.generalization == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Generalization oldValue = (Generalization) event.getOldValue();
					Generalization newValue = (Generalization) event.getNewValue();

					// Start of user code for generalization live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_Generalization(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getGeneralization(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.powertypeExtent == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.redefinedClassifier == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.substitution == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Substitution oldValue = (Substitution) event.getOldValue();
					Substitution newValue = (Substitution) event.getNewValue();

					// Start of user code for substitution live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_Substitution(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getSubstitution(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.collaborationUse == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					CollaborationUse oldValue = (CollaborationUse) event.getOldValue();
					CollaborationUse newValue = (CollaborationUse) event.getNewValue();

					// Start of user code for collaborationUse live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getCollaborationUse(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.ownedUseCase == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					UseCase oldValue = (UseCase) event.getOldValue();
					UseCase newValue = (UseCase) event.getNewValue();

					// Start of user code for ownedUseCase live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getUseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.useCase == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.ownedAttribute == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Property oldValue = (Property) event.getOldValue();
					Property newValue = (Property) event.getNewValue();

					// Start of user code for ownedAttribute live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getDataType_OwnedAttribute(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.DataType.ownedOperation == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Operation oldValue = (Operation) event.getOldValue();
					Operation newValue = (Operation) event.getNewValue();

					// Start of user code for ownedOperation live update command
					// TODO: Complete the dataType update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getDataType_OwnedOperation(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getOperation(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (UMLViewsRepository.DataType.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {
				if (UMLViewsRepository.DataType.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.DataType.isLeaf || key == UMLViewsRepository.DataType.isAbstract;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.DataType.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.elementImport)
			return "References the ElementImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.packageImport)
			return "References the PackageImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.ownedRule)
			return "Specifies a set of Constraints owned by this Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.templateBinding)
			return "The optional bindings from this element to templates."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.isAbstract)
			return "If true, the Classifier does not provide a complete declaration and can typically not be instantiated. An abstract classifier is intended to be used by other classifiers e.g. as the target of general metarelationships or generalization relationships."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.generalization)
			return "Specifies the Generalization relationships for this Classifier. These Generalizations navigaten to more general classifiers in the generalization hierarchy."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.powertypeExtent)
			return "Designates the GeneralizationSet of which the associated Classifier is a power type."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.redefinedClassifier)
			return "References the Classifiers that are redefined by this Classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.substitution)
			return "References the substitutions that are owned by this Classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.collaborationUse)
			return "References the collaboration uses owned by the classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.ownedUseCase)
			return "References the use cases owned by this classifier."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.useCase)
			return "The set of use cases for which this Classifier is the subject."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.ownedAttribute)
			return "The Attributes owned by the DataType."; //$NON-NLS-1$
		if (key == UMLViewsRepository.DataType.ownedOperation)
			return "The Operations owned by the DataType."; //$NON-NLS-1$
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
			if (UMLViewsRepository.DataType.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.DataType.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.DataType.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.DataType.isAbstract == event.getAffectedEditor()) {
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
			return Diagnostician.INSTANCE.validate(dataType);
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
			dataType.eAdapters().remove(semanticAdapter);
	}

}
