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

import org.eclipse.uml2.uml.FinalState;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Region;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.FinalStatePropertiesEditionPart;
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
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Region;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class FinalStateBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private FinalState finalState;

	/**
	 * The Base part
	 */
	private FinalStatePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public FinalStateBasePropertiesEditionComponent(EObject finalState, String editing_mode) {
		if (finalState instanceof FinalState) {
			this.finalState = (FinalState) finalState;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.finalState.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(finalState);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(finalState);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getElementImport())) {
					basePart.updateElementImport(finalState);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageImport())) {
					basePart.updatePackageImport(finalState);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateOwnedRule(finalState);
				}
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getState_Connection() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConnectionPointReference())) {
					basePart.updateConnection(finalState);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getState_ConnectionPoint() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPseudostate())) {
					basePart.updateConnectionPoint(finalState);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getState_DeferrableTrigger() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getTrigger())) {
					basePart.updateDeferrableTrigger(finalState);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getState_Region() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getRegion())) {
					basePart.updateRegion(finalState);
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
			return UMLViewsRepository.FinalState.class;
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
		if (finalState != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (FinalStatePropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.FinalState.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.FinalState.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			FinalState finalState = (FinalState) elt;
			basePart.initOwnedComment(finalState, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (finalState.getName() != null)
				basePart.setName(finalState.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), finalState.getVisibility());
			basePart.initClientDependency(finalState, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initElementImport(finalState, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(finalState, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(finalState, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.setIsLeaf(finalState.isLeaf());

			basePart.initConnection(finalState, null, UMLPackage.eINSTANCE.getState_Connection());
			basePart.initConnectionPoint(finalState, null, UMLPackage.eINSTANCE.getState_ConnectionPoint());
			basePart.initDeferrableTrigger(finalState, null, UMLPackage.eINSTANCE.getState_DeferrableTrigger());
			basePart.initRegion(finalState, null, UMLPackage.eINSTANCE.getState_Region());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (finalState != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List elementImportToAdd = basePart.getElementImportToAdd();
			for (Iterator iter = elementImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAdd = basePart.getPackageImportToAdd();
			for (Iterator iter = packageImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAdd = basePart.getOwnedRuleToAdd();
			for (Iterator iter = ownedRuleToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List connectionToAdd = basePart.getConnectionToAdd();
			for (Iterator iter = connectionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getState_Connection(), iter.next()));
			Map connectionToRefresh = basePart.getConnectionToEdit();
			for (Iterator iter = connectionToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for connection reference refreshment

				ConnectionPointReference nextElement = (ConnectionPointReference) iter.next();
				ConnectionPointReference connection = (ConnectionPointReference) connectionToRefresh.get(nextElement);

				// End of user code
			}
			List connectionToRemove = basePart.getConnectionToRemove();
			for (Iterator iter = connectionToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List connectionToMove = basePart.getConnectionToMove();
			for (Iterator iter = connectionToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getConnectionPointReference(), moveElement.getElement(), moveElement.getIndex()));
			}
			List connectionPointToAdd = basePart.getConnectionPointToAdd();
			for (Iterator iter = connectionPointToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getState_ConnectionPoint(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getPseudostate(), moveElement.getElement(), moveElement.getIndex()));
			}
			List deferrableTriggerToAdd = basePart.getDeferrableTriggerToAdd();
			for (Iterator iter = deferrableTriggerToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getState_DeferrableTrigger(), iter.next()));
			Map deferrableTriggerToRefresh = basePart.getDeferrableTriggerToEdit();
			for (Iterator iter = deferrableTriggerToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for deferrableTrigger reference refreshment

				Trigger nextElement = (Trigger) iter.next();
				Trigger deferrableTrigger = (Trigger) deferrableTriggerToRefresh.get(nextElement);

				// End of user code
			}
			List deferrableTriggerToRemove = basePart.getDeferrableTriggerToRemove();
			for (Iterator iter = deferrableTriggerToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List deferrableTriggerToMove = basePart.getDeferrableTriggerToMove();
			for (Iterator iter = deferrableTriggerToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getTrigger(), moveElement.getElement(), moveElement.getIndex()));
			}
			List regionToAdd = basePart.getRegionToAdd();
			for (Iterator iter = regionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getState_Region(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, finalState, UMLPackage.eINSTANCE.getRegion(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof FinalState) {
			FinalState finalStateToUpdate = (FinalState) source;
			finalStateToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			finalStateToUpdate.setName(basePart.getName());

			finalStateToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			finalStateToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			finalStateToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			finalStateToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			finalStateToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			finalStateToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			finalStateToUpdate.getConnections().addAll(basePart.getConnectionToAdd());
			finalStateToUpdate.getConnectionPoints().addAll(basePart.getConnectionPointToAdd());
			finalStateToUpdate.getDeferrableTriggers().addAll(basePart.getDeferrableTriggerToAdd());
			finalStateToUpdate.getRegions().addAll(basePart.getRegionToAdd());

			return finalStateToUpdate;
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
			if (UMLViewsRepository.FinalState.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the finalState update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.FinalState.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.FinalState.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.FinalState.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.FinalState.elementImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport) event.getOldValue();
					ElementImport newValue = (ElementImport) event.getNewValue();

					// Start of user code for elementImport live update command
					// TODO: Complete the finalState update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.FinalState.packageImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport) event.getOldValue();
					PackageImport newValue = (PackageImport) event.getNewValue();

					// Start of user code for packageImport live update command
					// TODO: Complete the finalState update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.FinalState.ownedRule == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for ownedRule live update command
					// TODO: Complete the finalState update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.FinalState.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.FinalState.connection == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ConnectionPointReference oldValue = (ConnectionPointReference) event.getOldValue();
					ConnectionPointReference newValue = (ConnectionPointReference) event.getNewValue();

					// Start of user code for connection live update command
					// TODO: Complete the finalState update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getState_Connection(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getConnectionPointReference(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.FinalState.connectionPoint == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Pseudostate oldValue = (Pseudostate) event.getOldValue();
					Pseudostate newValue = (Pseudostate) event.getNewValue();

					// Start of user code for connectionPoint live update command
					// TODO: Complete the finalState update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getState_ConnectionPoint(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getPseudostate(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.FinalState.deferrableTrigger == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Trigger oldValue = (Trigger) event.getOldValue();
					Trigger newValue = (Trigger) event.getNewValue();

					// Start of user code for deferrableTrigger live update command
					// TODO: Complete the finalState update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getState_DeferrableTrigger(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getTrigger(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.FinalState.region == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Region oldValue = (Region) event.getOldValue();
					Region newValue = (Region) event.getNewValue();

					// Start of user code for region live update command
					// TODO: Complete the finalState update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getState_Region(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, finalState, UMLPackage.eINSTANCE.getRegion(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.FinalState.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.FinalState.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.FinalState.isLeaf;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.FinalState.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.elementImport)
			return "References the ElementImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.packageImport)
			return "References the PackageImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.ownedRule)
			return "Specifies a set of Constraints owned by this Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.connection)
			return "The entry and exit connection points used in conjunction with this (submachine) state, i.e. as targets and sources, respectively, in the region with the submachine state. A connection point reference references the corresponding definition of a connection point pseudostate in the statemachine referenced by the submachinestate."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.connectionPoint)
			return "The entry and exit pseudostates of a composite state. These can only be entry or exit Pseudostates, and they must have different names. They can only be defined for composite states."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.deferrableTrigger)
			return "A list of triggers that are candidates to be retained by the state machine if they trigger no transitions out of the state (not consumed). A deferred trigger is retained until the state machine reaches a state configuration where it is no longer deferred."; //$NON-NLS-1$
		if (key == UMLViewsRepository.FinalState.region)
			return "The regions owned directly by the state."; //$NON-NLS-1$
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
			if (UMLViewsRepository.FinalState.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.FinalState.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.FinalState.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(finalState);
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
			finalState.eAdapters().remove(semanticAdapter);
	}

}
