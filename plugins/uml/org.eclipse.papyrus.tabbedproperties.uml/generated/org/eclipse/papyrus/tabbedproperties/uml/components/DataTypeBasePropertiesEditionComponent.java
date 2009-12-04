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
import org.eclipse.papyrus.tabbedproperties.uml.parts.DataTypePropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

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
		if(dataType instanceof DataType) {
			this.dataType = (DataType)dataType;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.dataType.eAdapters().add(semanticAdapter);
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
					DataTypeBasePropertiesEditionComponent.this.dispose();
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
						basePart.updateElementImport(dataType);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_PackageImport())) {
						basePart.updatePackageImport(dataType);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_OwnedRule())) {
						basePart.updateOwnedRule(dataType);
					}
					if(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
						basePart.setIsLeaf((Boolean)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding())) {
						basePart.updateTemplateBinding(dataType);
					}
					if(UMLPackage.eINSTANCE.getClassifier_IsAbstract().equals(msg.getFeature()) && basePart != null)
						basePart.setIsAbstract((Boolean)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Generalization()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClassifier_Generalization())) {
						basePart.updateGeneralization(dataType);
					}
					if(UMLPackage.eINSTANCE.getClassifier_PowertypeExtent().equals(msg.getFeature()))
						basePart.updatePowertypeExtent(dataType);
					if(UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier().equals(msg.getFeature()))
						basePart.updateRedefinedClassifier(dataType);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_Substitution()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClassifier_Substitution())) {
						basePart.updateSubstitution(dataType);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_CollaborationUse()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClassifier_CollaborationUse())) {
						basePart.updateCollaborationUse(dataType);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getClassifier_OwnedUseCase()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getClassifier_OwnedUseCase())) {
						basePart.updateOwnedUseCase(dataType);
					}
					if(UMLPackage.eINSTANCE.getClassifier_UseCase().equals(msg.getFeature()))
						basePart.updateUseCase(dataType);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getDataType_OwnedAttribute()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getDataType_OwnedAttribute())) {
						basePart.updateOwnedAttribute(dataType);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getDataType_OwnedOperation()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getDataType_OwnedOperation())) {
						basePart.updateOwnedOperation(dataType);
					}


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
		if(dataType != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (DataTypePropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.DataType.class, kind, this);
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
		if(key == UMLViewsRepository.DataType.class)
			this.basePart = (DataTypePropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.DataType.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final DataType dataType = (DataType)elt;
			// init values
			if(dataType.getName() != null)
				basePart.setName(dataType.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), dataType.getVisibility());
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
		if(dataType != null) {
			cc.append(SetCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List elementImportToAddFromElementImport = basePart.getElementImportToAdd();
			for(Iterator iter = elementImportToAddFromElementImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAddFromPackageImport = basePart.getPackageImportToAdd();
			for(Iterator iter = packageImportToAddFromPackageImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAddFromOwnedRule = basePart.getOwnedRuleToAdd();
			for(Iterator iter = ownedRuleToAddFromOwnedRule.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List templateBindingToAddFromTemplateBinding = basePart.getTemplateBindingToAdd();
			for(Iterator iter = templateBindingToAddFromTemplateBinding.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getTemplateBinding(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), basePart.getIsAbstract()));

			List generalizationToAddFromGeneralization = basePart.getGeneralizationToAdd();
			for(Iterator iter = generalizationToAddFromGeneralization.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_Generalization(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getGeneralization(), moveElement.getElement(), moveElement.getIndex()));
			}
			List powertypeExtentToAddFromPowertypeExtent = basePart.getPowertypeExtentToAdd();
			for(Iterator iter = powertypeExtentToAddFromPowertypeExtent.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			List powertypeExtentToRemoveFromPowertypeExtent = basePart.getPowertypeExtentToRemove();
			for(Iterator iter = powertypeExtentToRemoveFromPowertypeExtent.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), iter.next()));
			//List powertypeExtentToMoveFromPowertypeExtent = basePart.getPowertypeExtentToMove();
			//for (Iterator iter = powertypeExtentToMoveFromPowertypeExtent.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getGeneralizationSet(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List redefinedClassifierToAddFromRedefinedClassifier = basePart.getRedefinedClassifierToAdd();
			for(Iterator iter = redefinedClassifierToAddFromRedefinedClassifier.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			List redefinedClassifierToRemoveFromRedefinedClassifier = basePart.getRedefinedClassifierToRemove();
			for(Iterator iter = redefinedClassifierToRemoveFromRedefinedClassifier.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), iter.next()));
			//List redefinedClassifierToMoveFromRedefinedClassifier = basePart.getRedefinedClassifierToMove();
			//for (Iterator iter = redefinedClassifierToMoveFromRedefinedClassifier.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List substitutionToAddFromSubstitution = basePart.getSubstitutionToAdd();
			for(Iterator iter = substitutionToAddFromSubstitution.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_Substitution(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getSubstitution(), moveElement.getElement(), moveElement.getIndex()));
			}
			List collaborationUseToAddFromCollaborationUse = basePart.getCollaborationUseToAdd();
			for(Iterator iter = collaborationUseToAddFromCollaborationUse.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getCollaborationUse(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedUseCaseToAddFromOwnedUseCase = basePart.getOwnedUseCaseToAdd();
			for(Iterator iter = ownedUseCaseToAddFromOwnedUseCase.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			}
			List useCaseToAddFromUseCase = basePart.getUseCaseToAdd();
			for(Iterator iter = useCaseToAddFromUseCase.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			List useCaseToRemoveFromUseCase = basePart.getUseCaseToRemove();
			for(Iterator iter = useCaseToRemoveFromUseCase.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), iter.next()));
			//List useCaseToMoveFromUseCase = basePart.getUseCaseToMove();
			//for (Iterator iter = useCaseToMoveFromUseCase.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getUseCase(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List ownedAttributeToAddFromOwnedAttribute = basePart.getOwnedAttributeToAdd();
			for(Iterator iter = ownedAttributeToAddFromOwnedAttribute.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getDataType_OwnedAttribute(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedOperationToAddFromOwnedOperation = basePart.getOwnedOperationToAdd();
			for(Iterator iter = ownedOperationToAddFromOwnedOperation.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getDataType_OwnedOperation(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, dataType, UMLPackage.eINSTANCE.getOperation(), moveElement.getElement(), moveElement.getIndex()));
			}


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
		if(source instanceof DataType) {
			DataType dataTypeToUpdate = (DataType)source;
			dataTypeToUpdate.setName(basePart.getName());

			dataTypeToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

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
		if(PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if(UMLViewsRepository.DataType.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.DataType.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.DataType.elementImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport)event.getOldValue();
					ElementImport newValue = (ElementImport)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.packageImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport)event.getOldValue();
					PackageImport newValue = (PackageImport)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.ownedRule == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if(UMLViewsRepository.DataType.templateBinding == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					TemplateBinding oldValue = (TemplateBinding)event.getOldValue();
					TemplateBinding newValue = (TemplateBinding)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getTemplateBinding(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.isAbstract == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_IsAbstract(), event.getNewValue()));

			if(UMLViewsRepository.DataType.generalization == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Generalization oldValue = (Generalization)event.getOldValue();
					Generalization newValue = (Generalization)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_Generalization(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getGeneralization(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.powertypeExtent == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_PowertypeExtent(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.redefinedClassifier == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.substitution == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Substitution oldValue = (Substitution)event.getOldValue();
					Substitution newValue = (Substitution)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_Substitution(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getSubstitution(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.collaborationUse == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					CollaborationUse oldValue = (CollaborationUse)event.getOldValue();
					CollaborationUse newValue = (CollaborationUse)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_CollaborationUse(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getCollaborationUse(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.ownedUseCase == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					UseCase oldValue = (UseCase)event.getOldValue();
					UseCase newValue = (UseCase)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getUseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.useCase == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getClassifier_UseCase(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.ownedAttribute == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Property oldValue = (Property)event.getOldValue();
					Property newValue = (Property)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getDataType_OwnedAttribute(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.DataType.ownedOperation == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Operation oldValue = (Operation)event.getOldValue();
					Operation newValue = (Operation)event.getNewValue();


					// TODO: Complete the dataType update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getDataType_OwnedOperation(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, dataType, UMLPackage.eINSTANCE.getOperation(), event.getNewValue(), event.getNewIndex()));
			}


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {
				if(UMLViewsRepository.DataType.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





			} else {
				if(UMLViewsRepository.DataType.name == event.getAffectedEditor())
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
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if(event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if(UMLViewsRepository.DataType.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.DataType.visibility == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.DataType.isLeaf == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.DataType.isAbstract == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getClassifier_IsAbstract().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getClassifier_IsAbstract().getEAttributeType(), newValue);
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
			validate = Diagnostician.INSTANCE.validate(dataType);
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
			dataType.eAdapters().remove(semanticAdapter);
	}

}
