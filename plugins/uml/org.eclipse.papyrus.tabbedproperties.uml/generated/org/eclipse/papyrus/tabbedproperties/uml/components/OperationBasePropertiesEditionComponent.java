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
import org.eclipse.papyrus.tabbedproperties.uml.parts.OperationPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.CallConcurrencyKind;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

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
		if(operation instanceof Operation) {
			this.operation = (Operation)operation;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.operation.eAdapters().add(semanticAdapter);
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
					OperationBasePropertiesEditionComponent.this.dispose();
				else {
					if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null) {
						if(msg.getNewValue() != null) {
							basePart.setName((String)msg.getNewValue());
						} else {
							basePart.setName("");
						}
					}
					if(UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
						basePart.setVisibility((Enumerator)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_ElementImport())) {
						basePart.updateElementImport(operation);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_PackageImport())) {
						basePart.updatePackageImport(operation);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_OwnedRule())) {
						basePart.updateOwnedRule(operation);
					}
					if(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
						basePart.setIsLeaf((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getFeature_IsStatic().equals(msg.getFeature()) && basePart != null)
						basePart.setIsStatic((Boolean)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter())) {
						basePart.updateOwnedParameter(operation);
					}
					if(UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract().equals(msg.getFeature()) && basePart != null)
						basePart.setIsAbstract((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getBehavioralFeature_Method().equals(msg.getFeature()))
						basePart.updateMethod(operation);
					if(UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency().equals(msg.getFeature()) && basePart != null)
						basePart.setConcurrency((Enumerator)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException().equals(msg.getFeature()))
						basePart.updateRaisedException(operation);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameterSet()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameterSet())) {
						basePart.updateOwnedParameterSet(operation);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding())) {
						basePart.updateTemplateBinding(operation);
					}
					if(UMLPackage.eINSTANCE.getOperation_IsQuery().equals(msg.getFeature()) && basePart != null)
						basePart.setIsQuery((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getOperation_Precondition().equals(msg.getFeature()))
						basePart.updatePrecondition(operation);
					if(UMLPackage.eINSTANCE.getOperation_Postcondition().equals(msg.getFeature()))
						basePart.updatePostcondition(operation);
					if(UMLPackage.eINSTANCE.getOperation_RedefinedOperation().equals(msg.getFeature()))
						basePart.updateRedefinedOperation(operation);


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
		if(operation != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (OperationPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.Operation.class, kind, this);
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
		if(key == UMLViewsRepository.Operation.class)
			this.basePart = (OperationPropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.Operation.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Operation operation = (Operation)elt;
			// init values
			if(operation.getName() != null)
				basePart.setName(operation.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), operation.getVisibility());
			basePart.initElementImport(operation, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(operation, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(operation, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.setIsLeaf(operation.isLeaf());

			basePart.setIsStatic(operation.isStatic());

			basePart.initOwnedParameter(operation, null, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter());
			basePart.setIsAbstract(operation.isAbstract());

			basePart.initMethod(operation, null, UMLPackage.eINSTANCE.getBehavioralFeature_Method());
			basePart.initConcurrency((EEnum)UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency().getEType(), operation.getConcurrency());
			basePart.initRaisedException(operation, null, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException());
			basePart.initOwnedParameterSet(operation, null, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameterSet());
			basePart.initTemplateBinding(operation, null, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding());
			basePart.setIsQuery(operation.isQuery());

			basePart.initPrecondition(operation, null, UMLPackage.eINSTANCE.getOperation_Precondition());
			basePart.initPostcondition(operation, null, UMLPackage.eINSTANCE.getOperation_Postcondition());
			basePart.initRedefinedOperation(operation, null, UMLPackage.eINSTANCE.getOperation_RedefinedOperation());

			// init filters


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

			basePart.addFilterToMethod(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInMethodTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToMethod(new EObjectFilter(UMLPackage.eINSTANCE.getBehavior()));
			// Start of user code for additional businessfilters for method

			// End of user code

			basePart.addFilterToRaisedException(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRaisedExceptionTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRaisedException(new EObjectFilter(UMLPackage.eINSTANCE.getType()));
			// Start of user code for additional businessfilters for raisedException

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
			basePart.addFilterToRedefinedOperation(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRedefinedOperationTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRedefinedOperation(new EObjectFilter(UMLPackage.eINSTANCE.getOperation()));
			// Start of user code for additional businessfilters for redefinedOperation

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
		if(operation != null) {
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List elementImportToAddFromElementImport = basePart.getElementImportToAdd();
			for(Iterator iter = elementImportToAddFromElementImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAddFromPackageImport = basePart.getPackageImportToAdd();
			for(Iterator iter = packageImportToAddFromPackageImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAddFromOwnedRule = basePart.getOwnedRuleToAdd();
			for(Iterator iter = ownedRuleToAddFromOwnedRule.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getFeature_IsStatic(), basePart.getIsStatic()));

			List ownedParameterToAddFromOwnedParameter = basePart.getOwnedParameterToAdd();
			for(Iterator iter = ownedParameterToAddFromOwnedParameter.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getParameter(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract(), basePart.getIsAbstract()));

			List methodToAddFromMethod = basePart.getMethodToAdd();
			for(Iterator iter = methodToAddFromMethod.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), iter.next()));
			List methodToRemoveFromMethod = basePart.getMethodToRemove();
			for(Iterator iter = methodToRemoveFromMethod.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), iter.next()));
			//List methodToMoveFromMethod = basePart.getMethodToMove();
			//for (Iterator iter = methodToMoveFromMethod.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavior(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency(), basePart.getConcurrency()));

			List raisedExceptionToAddFromRaisedException = basePart.getRaisedExceptionToAdd();
			for(Iterator iter = raisedExceptionToAddFromRaisedException.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), iter.next()));
			List raisedExceptionToRemoveFromRaisedException = basePart.getRaisedExceptionToRemove();
			for(Iterator iter = raisedExceptionToRemoveFromRaisedException.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), iter.next()));
			//List raisedExceptionToMoveFromRaisedException = basePart.getRaisedExceptionToMove();
			//for (Iterator iter = raisedExceptionToMoveFromRaisedException.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getType(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List ownedParameterSetToAddFromOwnedParameterSet = basePart.getOwnedParameterSetToAdd();
			for(Iterator iter = ownedParameterSetToAddFromOwnedParameterSet.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameterSet(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getParameterSet(), moveElement.getElement(), moveElement.getIndex()));
			}
			List templateBindingToAddFromTemplateBinding = basePart.getTemplateBindingToAdd();
			for(Iterator iter = templateBindingToAddFromTemplateBinding.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getTemplateBinding(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_IsQuery(), basePart.getIsQuery()));

			List preconditionToAddFromPrecondition = basePart.getPreconditionToAdd();
			for(Iterator iter = preconditionToAddFromPrecondition.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), iter.next()));
			List preconditionToRemoveFromPrecondition = basePart.getPreconditionToRemove();
			for(Iterator iter = preconditionToRemoveFromPrecondition.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), iter.next()));
			//List preconditionToMoveFromPrecondition = basePart.getPreconditionToMove();
			//for (Iterator iter = preconditionToMoveFromPrecondition.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List postconditionToAddFromPostcondition = basePart.getPostconditionToAdd();
			for(Iterator iter = postconditionToAddFromPostcondition.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), iter.next()));
			List postconditionToRemoveFromPostcondition = basePart.getPostconditionToRemove();
			for(Iterator iter = postconditionToRemoveFromPostcondition.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), iter.next()));
			//List postconditionToMoveFromPostcondition = basePart.getPostconditionToMove();
			//for (Iterator iter = postconditionToMoveFromPostcondition.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List redefinedOperationToAddFromRedefinedOperation = basePart.getRedefinedOperationToAdd();
			for(Iterator iter = redefinedOperationToAddFromRedefinedOperation.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), iter.next()));
			List redefinedOperationToRemoveFromRedefinedOperation = basePart.getRedefinedOperationToRemove();
			for(Iterator iter = redefinedOperationToRemoveFromRedefinedOperation.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), iter.next()));
			//List redefinedOperationToMoveFromRedefinedOperation = basePart.getRedefinedOperationToMove();
			//for (Iterator iter = redefinedOperationToMoveFromRedefinedOperation.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, operation, UMLPackage.eINSTANCE.getOperation(), moveElement.getElement(), moveElement.getIndex()));
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
		if(source instanceof Operation) {
			Operation operationToUpdate = (Operation)source;
			operationToUpdate.setName(basePart.getName());

			operationToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

			operationToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			operationToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			operationToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			operationToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			operationToUpdate.setIsStatic(new Boolean(basePart.getIsStatic()).booleanValue());

			operationToUpdate.getOwnedParameters().addAll(basePart.getOwnedParameterToAdd());
			operationToUpdate.setIsAbstract(new Boolean(basePart.getIsAbstract()).booleanValue());

			operationToUpdate.getMethods().addAll(basePart.getMethodToAdd());
			operationToUpdate.setConcurrency((CallConcurrencyKind)basePart.getConcurrency());

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
		if(PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if(UMLViewsRepository.Operation.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.Operation.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.Operation.elementImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport)event.getOldValue();
					ElementImport newValue = (ElementImport)event.getNewValue();


					// TODO: Complete the operation update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.packageImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport)event.getOldValue();
					PackageImport newValue = (PackageImport)event.getNewValue();


					// TODO: Complete the operation update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.ownedRule == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();


					// TODO: Complete the operation update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if(UMLViewsRepository.Operation.isStatic == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getFeature_IsStatic(), event.getNewValue()));

			if(UMLViewsRepository.Operation.ownedParameter == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Parameter oldValue = (Parameter)event.getOldValue();
					Parameter newValue = (Parameter)event.getNewValue();


					// TODO: Complete the operation update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getParameter(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.isAbstract == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract(), event.getNewValue()));

			if(UMLViewsRepository.Operation.method == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Method(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.concurrency == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency(), event.getNewValue()));

			if(UMLViewsRepository.Operation.raisedException == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.ownedParameterSet == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ParameterSet oldValue = (ParameterSet)event.getOldValue();
					ParameterSet newValue = (ParameterSet)event.getNewValue();


					// TODO: Complete the operation update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameterSet(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getParameterSet(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.templateBinding == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					TemplateBinding oldValue = (TemplateBinding)event.getOldValue();
					TemplateBinding newValue = (TemplateBinding)event.getNewValue();


					// TODO: Complete the operation update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getTemplateBinding(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.isQuery == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_IsQuery(), event.getNewValue()));

			if(UMLViewsRepository.Operation.precondition == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Precondition(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.postcondition == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_Postcondition(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Operation.redefinedOperation == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, operation, UMLPackage.eINSTANCE.getOperation_RedefinedOperation(), event.getNewValue(), event.getNewIndex()));
			}


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {
				if(UMLViewsRepository.Operation.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





			} else {
				if(UMLViewsRepository.Operation.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.Operation.isLeaf || key == UMLViewsRepository.Operation.isStatic || key == UMLViewsRepository.Operation.isAbstract || key == UMLViewsRepository.Operation.concurrency || key == UMLViewsRepository.Operation.isQuery;
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
				if(UMLViewsRepository.Operation.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Operation.visibility == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Operation.isLeaf == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Operation.isStatic == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Operation.isAbstract == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Operation.concurrency == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Operation.isQuery == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getOperation_IsQuery().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getOperation_IsQuery().getEAttributeType(), newValue);
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
			validate = Diagnostician.INSTANCE.validate(operation);
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
			operation.eAdapters().remove(semanticAdapter);
	}

}
