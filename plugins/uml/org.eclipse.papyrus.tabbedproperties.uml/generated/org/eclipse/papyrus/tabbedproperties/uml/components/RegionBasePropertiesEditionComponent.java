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

import org.eclipse.uml2.uml.Region;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.Transition;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.RegionPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class RegionBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private Region region;

	/**
	 * The Base part
	 */
	private RegionPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public RegionBasePropertiesEditionComponent(EObject region, String editing_mode) {
		if (region instanceof Region) {
			this.region = (Region) region;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.region.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(region);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(region);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getElementImport())) {
					basePart.updateElementImport(region);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageImport())) {
					basePart.updatePackageImport(region);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateOwnedRule(region);
				}
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getRegion_Subvertex() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getVertex())) {
					basePart.updateSubvertex(region);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getRegion_Transition() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getTransition())) {
					basePart.updateTransition(region);
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
			return UMLViewsRepository.Region.class;
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
		if (region != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (RegionPropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.Region.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.Region.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			Region region = (Region) elt;
			basePart.initOwnedComment(region, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (region.getName() != null)
				basePart.setName(region.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), region.getVisibility());
			basePart.initClientDependency(region, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initElementImport(region, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(region, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(region, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.setIsLeaf(region.isLeaf());

			basePart.initSubvertex(region, null, UMLPackage.eINSTANCE.getRegion_Subvertex());
			basePart.initTransition(region, null, UMLPackage.eINSTANCE.getRegion_Transition());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (region != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List elementImportToAdd = basePart.getElementImportToAdd();
			for (Iterator iter = elementImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAdd = basePart.getPackageImportToAdd();
			for (Iterator iter = packageImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAdd = basePart.getOwnedRuleToAdd();
			for (Iterator iter = ownedRuleToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List subvertexToAdd = basePart.getSubvertexToAdd();
			for (Iterator iter = subvertexToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getRegion_Subvertex(), iter.next()));
			Map subvertexToRefresh = basePart.getSubvertexToEdit();
			for (Iterator iter = subvertexToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for subvertex reference refreshment

				Vertex nextElement = (Vertex) iter.next();
				Vertex subvertex = (Vertex) subvertexToRefresh.get(nextElement);

				// End of user code
			}
			List subvertexToRemove = basePart.getSubvertexToRemove();
			for (Iterator iter = subvertexToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List subvertexToMove = basePart.getSubvertexToMove();
			for (Iterator iter = subvertexToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getVertex(), moveElement.getElement(), moveElement.getIndex()));
			}
			List transitionToAdd = basePart.getTransitionToAdd();
			for (Iterator iter = transitionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getRegion_Transition(), iter.next()));
			Map transitionToRefresh = basePart.getTransitionToEdit();
			for (Iterator iter = transitionToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for transition reference refreshment

				Transition nextElement = (Transition) iter.next();
				Transition transition = (Transition) transitionToRefresh.get(nextElement);

				// End of user code
			}
			List transitionToRemove = basePart.getTransitionToRemove();
			for (Iterator iter = transitionToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List transitionToMove = basePart.getTransitionToMove();
			for (Iterator iter = transitionToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, region, UMLPackage.eINSTANCE.getTransition(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof Region) {
			Region regionToUpdate = (Region) source;
			regionToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			regionToUpdate.setName(basePart.getName());

			regionToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			regionToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			regionToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			regionToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			regionToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			regionToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			regionToUpdate.getSubvertices().addAll(basePart.getSubvertexToAdd());
			regionToUpdate.getTransitions().addAll(basePart.getTransitionToAdd());

			return regionToUpdate;
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
			if (UMLViewsRepository.Region.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the region update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Region.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.Region.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.Region.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Region.elementImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport) event.getOldValue();
					ElementImport newValue = (ElementImport) event.getNewValue();

					// Start of user code for elementImport live update command
					// TODO: Complete the region update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Region.packageImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport) event.getOldValue();
					PackageImport newValue = (PackageImport) event.getNewValue();

					// Start of user code for packageImport live update command
					// TODO: Complete the region update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Region.ownedRule == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for ownedRule live update command
					// TODO: Complete the region update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Region.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.Region.subvertex == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Vertex oldValue = (Vertex) event.getOldValue();
					Vertex newValue = (Vertex) event.getNewValue();

					// Start of user code for subvertex live update command
					// TODO: Complete the region update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getRegion_Subvertex(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getVertex(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Region.transition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Transition oldValue = (Transition) event.getOldValue();
					Transition newValue = (Transition) event.getNewValue();

					// Start of user code for transition live update command
					// TODO: Complete the region update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getRegion_Transition(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, region, UMLPackage.eINSTANCE.getTransition(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.Region.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.Region.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.Region.isLeaf;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.Region.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Region.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Region.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Region.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Region.elementImport)
			return "References the ElementImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Region.packageImport)
			return "References the PackageImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Region.ownedRule)
			return "Specifies a set of Constraints owned by this Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Region.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Region.subvertex)
			return "The set of vertices that are owned by this region."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Region.transition)
			return "The set of transitions owned by the region. Note that internal transitions are owned by a region, but applies to the source state."; //$NON-NLS-1$
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
			if (UMLViewsRepository.Region.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Region.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Region.isLeaf == event.getAffectedEditor()) {
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
			return Diagnostician.INSTANCE.validate(region);
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
			region.eAdapters().remove(semanticAdapter);
	}

}
