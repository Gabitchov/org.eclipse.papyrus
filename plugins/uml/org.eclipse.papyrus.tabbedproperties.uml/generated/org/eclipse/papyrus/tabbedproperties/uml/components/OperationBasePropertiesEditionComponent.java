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

import org.eclipse.uml2.uml.Operation;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallConcurrencyKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Constraint;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.OperationPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.CallConcurrencyKind;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class OperationBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private Operation operation;

	/**
	 * The Base part
	 */
	private OperationPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public OperationBasePropertiesEditionComponent(EObject operation, String editing_mode) {
		if (operation instanceof Operation) {
			this.operation = (Operation) operation;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.operation.eAdapters().add(semanticAdapter);
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
					basePart.updateElementImport(operation);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageImport())) {
					basePart.updatePackageImport(operation);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateOwnedRule(operation);
				}
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getFeature_IsStatic().equals(msg.getFeature()) && basePart != null)
					basePart.setIsStatic((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getParameter())) {
					basePart.updateOwnedParameter(operation);
				}
				if (UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract().equals(msg.getFeature()) && basePart != null)
					basePart.setIsAbstract((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getBehavioralFeature_Method().equals(msg.getFeature()))
					basePart.updateMethod(operation);
				if (UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency().equals(msg.getFeature()) && basePart != null)
					basePart.setConcurrency((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException().equals(msg.getFeature()))
					basePart.updateRaisedException(operation);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameterSet() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getParameterSet())) {
					basePart.updateOwnedParameterSet(operation);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getTemplateBinding())) {
					basePart.updateTemplateBinding(operation);
				}
				if (UMLPackage.eINSTANCE.getOperation_IsQuery().equals(msg.getFeature()) && basePart != null)
					basePart.setIsQuery((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getOperation_Precondition().equals(msg.getFeature()))
					basePart.updatePrecondition(operation);
				if (UMLPackage.eINSTANCE.getOperation_Postcondition().equals(msg.getFeature()))
					basePart.updatePostcondition(operation);
				if (UMLPackage.eINSTANCE.getOperation_RedefinedOperation().equals(msg.getFeature()))
					basePart.updateRedefinedOperation(operation);

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
			return UMLViewsRepository.Operation.class;
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
		if (operation != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (OperationPropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.Operation.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.Operation.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			Operation operation = (Operation) elt;
			if (operation.getName() != null)
				basePart.setName(operation.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), operation.getVisibility());
			basePart.initElementImport(operation, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(operation, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(operation, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.setIsLeaf(operation.isLeaf());

			basePart.setIsStatic(operation.isStatic());

			basePart.initOwnedParameter(operation, null, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter());
			basePart.setIsAbstract(operation.isAbstract());

			basePart.initMethod(operation, null, UMLPackage.eINSTANCE.getBehavioralFeature_Method());
			basePart.initConcurrency((EEnum) UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency().getEType(), operation.getConcurrency());
			basePart.initRaisedException(operation, null, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException());
			basePart.initOwnedParameterSet(operation, null, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameterSet());
			basePart.initTemplateBinding(operation, null, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding());
			basePart.setIsQuery(operation.isQuery());

			basePart.initPrecondition(operation, null, UMLPackage.eINSTANCE.getOperation_Precondition());
			basePart.initPostcondition(operation, null, UMLPackage.eINSTANCE.getOperation_Postcondition());
			basePart.initRedefinedOperation(operation, null, UMLPackage.eINSTANCE.getOperation_RedefinedOperation());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (operation != null) {
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List elementImportToAdd = basePart.getElementImportToAdd();
			for (Iterator iter = elementImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAdd = basePart.getPackageImportToAdd();
			for (Iterator iter = packageImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAdd = basePart.getOwnedRuleToAdd();
			for (Iterator iter = ownedRuleToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getFeature_IsStatic(), basePart.getIsStatic()));

			List ownedParameterToAdd = basePart.getOwnedParameterToAdd();
			for (Iterator iter = ownedParameterToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getParameter(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract(), basePart.getIsAbstract()));

			List methodToAdd = basePart.getMethodToAdd();
			for (Iterator iter = methodToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), iter.next()));
			List methodToRemove = basePart.getMethodToRemove();
			for (Iterator iter = methodToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), iter.next()));
			// List methodToMove = basePart.getMethodToMove();
			// for (Iterator iter = methodToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavior(), moveElement.getElement(), moveElement.getIndex()));
			// }
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency(), basePart.getConcurrency()));

			List raisedExceptionToAdd = basePart.getRaisedExceptionToAdd();
			for (Iterator iter = raisedExceptionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), iter.next()));
			List raisedExceptionToRemove = basePart.getRaisedExceptionToRemove();
			for (Iterator iter = raisedExceptionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), iter.next()));
			// List raisedExceptionToMove = basePart.getRaisedExceptionToMove();
			// for (Iterator iter = raisedExceptionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getType(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List ownedParameterSetToAdd = basePart.getOwnedParameterSetToAdd();
			for (Iterator iter = ownedParameterSetToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameterSet(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getParameterSet(), moveElement.getElement(), moveElement.getIndex()));
			}
			List templateBindingToAdd = basePart.getTemplateBindingToAdd();
			for (Iterator iter = templateBindingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getTemplateBinding(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_IsQuery(), basePart.getIsQuery()));

			List preconditionToAdd = basePart.getPreconditionToAdd();
			for (Iterator iter = preconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), iter.next()));
			List preconditionToRemove = basePart.getPreconditionToRemove();
			for (Iterator iter = preconditionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), iter.next()));
			// List preconditionToMove = basePart.getPreconditionToMove();
			// for (Iterator iter = preconditionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List postconditionToAdd = basePart.getPostconditionToAdd();
			for (Iterator iter = postconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), iter.next()));
			List postconditionToRemove = basePart.getPostconditionToRemove();
			for (Iterator iter = postconditionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), iter.next()));
			// List postconditionToMove = basePart.getPostconditionToMove();
			// for (Iterator iter = postconditionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List redefinedOperationToAdd = basePart.getRedefinedOperationToAdd();
			for (Iterator iter = redefinedOperationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), iter.next()));
			List redefinedOperationToRemove = basePart.getRedefinedOperationToRemove();
			for (Iterator iter = redefinedOperationToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), iter.next()));
			// List redefinedOperationToMove = basePart.getRedefinedOperationToMove();
			// for (Iterator iter = redefinedOperationToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof Operation) {
			Operation operationToUpdate = (Operation) source;
			operationToUpdate.setName(basePart.getName());

			operationToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			operationToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			operationToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			operationToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			operationToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			operationToUpdate.setIsStatic(new Boolean(basePart.getIsStatic()).booleanValue());

			operationToUpdate.getOwnedParameters().addAll(basePart.getOwnedParameterToAdd());
			operationToUpdate.setIsAbstract(new Boolean(basePart.getIsAbstract()).booleanValue());

			operationToUpdate.getMethods().addAll(basePart.getMethodToAdd());
			operationToUpdate.setConcurrency((CallConcurrencyKind) basePart.getConcurrency());

			operationToUpdate.getRaisedExceptions().addAll(basePart.getRaisedExceptionToAdd());
			operationToUpdate.getOwnedParameterSets().addAll(basePart.getOwnedParameterSetToAdd());
			operationToUpdate.getTemplateBindings().addAll(basePart.getTemplateBindingToAdd());
			operationToUpdate.setIsQuery(new Boolean(basePart.getIsQuery()).booleanValue());

			operationToUpdate.getPreconditions().addAll(basePart.getPreconditionToAdd());
			operationToUpdate.getPostconditions().addAll(basePart.getPostconditionToAdd());
			operationToUpdate.getRedefinedOperations().addAll(basePart.getRedefinedOperationToAdd());

			return operationToUpdate;
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
			if (UMLViewsRepository.Operation.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.Operation.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.Operation.elementImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport) event.getOldValue();
					ElementImport newValue = (ElementImport) event.getNewValue();

					// Start of user code for elementImport live update command
					// TODO: Complete the operation update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.packageImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport) event.getOldValue();
					PackageImport newValue = (PackageImport) event.getNewValue();

					// Start of user code for packageImport live update command
					// TODO: Complete the operation update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.ownedRule == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for ownedRule live update command
					// TODO: Complete the operation update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.Operation.isStatic == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getFeature_IsStatic(), event.getNewValue()));

			if (UMLViewsRepository.Operation.ownedParameter == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Parameter oldValue = (Parameter) event.getOldValue();
					Parameter newValue = (Parameter) event.getNewValue();

					// Start of user code for ownedParameter live update command
					// TODO: Complete the operation update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getParameter(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.isAbstract == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract(), event.getNewValue()));

			if (UMLViewsRepository.Operation.method == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.concurrency == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency(), event.getNewValue()));

			if (UMLViewsRepository.Operation.raisedException == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.ownedParameterSet == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ParameterSet oldValue = (ParameterSet) event.getOldValue();
					ParameterSet newValue = (ParameterSet) event.getNewValue();

					// Start of user code for ownedParameterSet live update command
					// TODO: Complete the operation update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameterSet(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getParameterSet(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.templateBinding == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					TemplateBinding oldValue = (TemplateBinding) event.getOldValue();
					TemplateBinding newValue = (TemplateBinding) event.getNewValue();

					// Start of user code for templateBinding live update command
					// TODO: Complete the operation update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getTemplateBinding(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.isQuery == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_IsQuery(), event.getNewValue()));

			if (UMLViewsRepository.Operation.precondition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.postcondition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Operation.redefinedOperation == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (UMLViewsRepository.Operation.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {
				if (UMLViewsRepository.Operation.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.Operation.isLeaf || key == UMLViewsRepository.Operation.isStatic || key == UMLViewsRepository.Operation.isAbstract
				|| key == UMLViewsRepository.Operation.concurrency || key == UMLViewsRepository.Operation.isQuery;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.Operation.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.elementImport)
			return "References the ElementImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.packageImport)
			return "References the PackageImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.ownedRule)
			return "Specifies a set of Constraints owned by this Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.isStatic)
			return "Specifies whether this feature characterizes individual instances classified by the classifier (false) or the classifier itself (true)."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.ownedParameter)
			return "Specifies the ordered set of formal parameters of this BehavioralFeature."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.isAbstract)
			return "If true, then the behavioral feature does not have an implementation, and one must be supplied by a more specific element. If false, the behavioral feature must have an implementation in the classifier or one must be inherited from a more general element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.method)
			return "A behavioral description that implements the behavioral feature. There may be at most one behavior for a particular pairing of a classifier (as owner of the behavior) and a behavioral feature (as specification of the behavior)."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.concurrency)
			return "Specifies the semantics of concurrent calls to the same passive instance (i.e., an instance originating from a class with isActive being false). Active instances control access to their own behavioral features."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.raisedException)
			return "References the Types representing exceptions that may be raised during an invocation of this feature.The signals that the behavioral feature raises as exceptions."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.ownedParameterSet)
			return "The ParameterSets owned by this BehavioralFeature."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.templateBinding)
			return "The optional bindings from this element to templates."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.isQuery)
			return "Specifies whether an execution of the BehavioralFeature leaves the state of the system unchanged (isQuery=true) or whether side effects may occur (isQuery=false)."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.precondition)
			return "An optional set of Constraints on the state of the system when the Operation is invoked."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.postcondition)
			return "An optional set of Constraints specifying the state of the system when the Operation is completed."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Operation.redefinedOperation)
			return "References the Operations that are redefined by this Operation."; //$NON-NLS-1$
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
			if (UMLViewsRepository.Operation.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Operation.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Operation.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Operation.isStatic == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Operation.isAbstract == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Operation.concurrency == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Operation.isQuery == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getOperation_IsQuery().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getOperation_IsQuery().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(operation);
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
			operation.eAdapters().remove(semanticAdapter);
	}

}
