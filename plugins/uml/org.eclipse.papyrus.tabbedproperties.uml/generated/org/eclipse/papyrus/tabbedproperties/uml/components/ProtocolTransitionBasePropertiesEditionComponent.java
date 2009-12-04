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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ProtocolTransitionPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.ProtocolTransition;
import org.eclipse.uml2.uml.TransitionKind;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ProtocolTransitionBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private ProtocolTransition protocolTransition;

	/**
	 * The Base part
	 */
	private ProtocolTransitionPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public ProtocolTransitionBasePropertiesEditionComponent(EObject protocolTransition, String editing_mode) {
		if(protocolTransition instanceof ProtocolTransition) {
			this.protocolTransition = (ProtocolTransition)protocolTransition;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.protocolTransition.eAdapters().add(semanticAdapter);
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
					ProtocolTransitionBasePropertiesEditionComponent.this.dispose();
				else {
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getElement_OwnedComment())) {
						basePart.updateOwnedComment(protocolTransition);
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
						basePart.updateClientDependency(protocolTransition);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_ElementImport())) {
						basePart.updateElementImport(protocolTransition);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_PackageImport())) {
						basePart.updatePackageImport(protocolTransition);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_OwnedRule())) {
						basePart.updateOwnedRule(protocolTransition);
					}
					if(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
						basePart.setIsLeaf((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getTransition_Kind().equals(msg.getFeature()) && basePart != null)
						basePart.setKind((Enumerator)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getTransition_Trigger()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getTransition_Trigger())) {
						basePart.updateTrigger(protocolTransition);
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
			return UMLViewsRepository.ProtocolTransition.class;
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
		if(protocolTransition != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (ProtocolTransitionPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.ProtocolTransition.class, kind, this);
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
		if(key == UMLViewsRepository.ProtocolTransition.class)
			this.basePart = (ProtocolTransitionPropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.ProtocolTransition.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final ProtocolTransition protocolTransition = (ProtocolTransition)elt;
			// init values
			basePart.initOwnedComment(protocolTransition, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if(protocolTransition.getName() != null)
				basePart.setName(protocolTransition.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), protocolTransition.getVisibility());
			basePart.initClientDependency(protocolTransition, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initElementImport(protocolTransition, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(protocolTransition, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(protocolTransition, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.setIsLeaf(protocolTransition.isLeaf());

			basePart.initKind((EEnum)UMLPackage.eINSTANCE.getTransition_Kind().getEType(), protocolTransition.getKind());
			basePart.initTrigger(protocolTransition, null, UMLPackage.eINSTANCE.getTransition_Trigger());

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


			basePart.addFilterToTrigger(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Trigger); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for trigger

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
		if(protocolTransition != null) {
			List ownedCommentToAddFromOwnedComment = basePart.getOwnedCommentToAdd();
			for(Iterator iter = ownedCommentToAddFromOwnedComment.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAddFromClientDependency = basePart.getClientDependencyToAdd();
			for(Iterator iter = clientDependencyToAddFromClientDependency.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemoveFromClientDependency = basePart.getClientDependencyToRemove();
			for(Iterator iter = clientDependencyToRemoveFromClientDependency.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMoveFromClientDependency = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMoveFromClientDependency.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List elementImportToAddFromElementImport = basePart.getElementImportToAdd();
			for(Iterator iter = elementImportToAddFromElementImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAddFromPackageImport = basePart.getPackageImportToAdd();
			for(Iterator iter = packageImportToAddFromPackageImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAddFromOwnedRule = basePart.getOwnedRuleToAdd();
			for(Iterator iter = ownedRuleToAddFromOwnedRule.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			cc.append(SetCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getTransition_Kind(), basePart.getKind()));

			List triggerToAddFromTrigger = basePart.getTriggerToAdd();
			for(Iterator iter = triggerToAddFromTrigger.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getTransition_Trigger(), iter.next()));
			Map triggerToRefreshFromTrigger = basePart.getTriggerToEdit();
			for(Iterator iter = triggerToRefreshFromTrigger.keySet().iterator(); iter.hasNext();) {



				Trigger nextElement = (Trigger)iter.next();
				Trigger trigger = (Trigger)triggerToRefreshFromTrigger.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, trigger.eGet(feature)));
					}
				}



			}
			List triggerToRemoveFromTrigger = basePart.getTriggerToRemove();
			for(Iterator iter = triggerToRemoveFromTrigger.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List triggerToMoveFromTrigger = basePart.getTriggerToMove();
			for(Iterator iter = triggerToMoveFromTrigger.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, protocolTransition, UMLPackage.eINSTANCE.getTrigger(), moveElement.getElement(), moveElement.getIndex()));
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
		if(source instanceof ProtocolTransition) {
			ProtocolTransition protocolTransitionToUpdate = (ProtocolTransition)source;
			protocolTransitionToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			protocolTransitionToUpdate.setName(basePart.getName());

			protocolTransitionToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

			protocolTransitionToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			protocolTransitionToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			protocolTransitionToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			protocolTransitionToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			protocolTransitionToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			protocolTransitionToUpdate.setKind((TransitionKind)basePart.getKind());

			protocolTransitionToUpdate.getTriggers().addAll(basePart.getTriggerToAdd());


			return protocolTransitionToUpdate;
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
			if(UMLViewsRepository.ProtocolTransition.ownedComment == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();


					// TODO: Complete the protocolTransition update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ProtocolTransition.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.ProtocolTransition.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.ProtocolTransition.clientDependency == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ProtocolTransition.elementImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport)event.getOldValue();
					ElementImport newValue = (ElementImport)event.getNewValue();


					// TODO: Complete the protocolTransition update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ProtocolTransition.packageImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport)event.getOldValue();
					PackageImport newValue = (PackageImport)event.getNewValue();


					// TODO: Complete the protocolTransition update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ProtocolTransition.ownedRule == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();


					// TODO: Complete the protocolTransition update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ProtocolTransition.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if(UMLViewsRepository.ProtocolTransition.kind == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getTransition_Kind(), event.getNewValue()));

			if(UMLViewsRepository.ProtocolTransition.trigger == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Trigger oldValue = (Trigger)event.getOldValue();
					Trigger newValue = (Trigger)event.getNewValue();


					// TODO: Complete the protocolTransition update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getTransition_Trigger(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, protocolTransition, UMLPackage.eINSTANCE.getTrigger(), event.getNewValue(), event.getNewIndex()));
			}


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {

				if(UMLViewsRepository.ProtocolTransition.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





			} else {

				if(UMLViewsRepository.ProtocolTransition.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.ProtocolTransition.isLeaf || key == UMLViewsRepository.ProtocolTransition.kind;
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
				if(UMLViewsRepository.ProtocolTransition.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ProtocolTransition.visibility == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ProtocolTransition.isLeaf == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ProtocolTransition.kind == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getTransition_Kind().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getTransition_Kind().getEAttributeType(), newValue);
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
			validate = Diagnostician.INSTANCE.validate(protocolTransition);
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
			protocolTransition.eAdapters().remove(semanticAdapter);
	}

}
