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

import org.eclipse.uml2.uml.Profile;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ProfilePropertiesEditionPart;
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
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ProfileBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private Profile profile;

	/**
	 * The Base part
	 */
	private ProfilePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public ProfileBasePropertiesEditionComponent(EObject profile, String editing_mode) {
		if (profile instanceof Profile) {
			this.profile = (Profile) profile;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.profile.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(profile);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(profile);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getElementImport())) {
					basePart.updateElementImport(profile);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageImport())) {
					basePart.updatePackageImport(profile);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateOwnedRule(profile);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getTemplateBinding())) {
					basePart.updateTemplateBinding(profile);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getPackage_PackageMerge() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageMerge())) {
					basePart.updatePackageMerge(profile);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getPackage_PackagedElement() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageableElement())) {
					basePart.updatePackagedElement(profile);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getPackage_ProfileApplication() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getProfileApplication())) {
					basePart.updateProfileApplication(profile);
				}
				if (UMLPackage.eINSTANCE.getProfile_MetaclassReference().equals(msg.getFeature()))
					basePart.updateMetaclassReference(profile);
				if (UMLPackage.eINSTANCE.getProfile_MetamodelReference().equals(msg.getFeature()))
					basePart.updateMetamodelReference(profile);

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
			return UMLViewsRepository.Profile.class;
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
		if (profile != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (ProfilePropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.Profile.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.Profile.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			Profile profile = (Profile) elt;
			basePart.initOwnedComment(profile, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (profile.getName() != null)
				basePart.setName(profile.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), profile.getVisibility());
			basePart.initClientDependency(profile, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initElementImport(profile, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(profile, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(profile, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.initTemplateBinding(profile, null, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding());
			basePart.initPackageMerge(profile, null, UMLPackage.eINSTANCE.getPackage_PackageMerge());
			basePart.initPackagedElement(profile, null, UMLPackage.eINSTANCE.getPackage_PackagedElement());
			basePart.initProfileApplication(profile, null, UMLPackage.eINSTANCE.getPackage_ProfileApplication());
			basePart.initMetaclassReference(profile, null, UMLPackage.eINSTANCE.getProfile_MetaclassReference());
			basePart.initMetamodelReference(profile, null, UMLPackage.eINSTANCE.getProfile_MetamodelReference());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (profile != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List elementImportToAdd = basePart.getElementImportToAdd();
			for (Iterator iter = elementImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAdd = basePart.getPackageImportToAdd();
			for (Iterator iter = packageImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAdd = basePart.getOwnedRuleToAdd();
			for (Iterator iter = ownedRuleToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List templateBindingToAdd = basePart.getTemplateBindingToAdd();
			for (Iterator iter = templateBindingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getTemplateBinding(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageMergeToAdd = basePart.getPackageMergeToAdd();
			for (Iterator iter = packageMergeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getPackage_PackageMerge(), iter.next()));
			Map packageMergeToRefresh = basePart.getPackageMergeToEdit();
			for (Iterator iter = packageMergeToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for packageMerge reference refreshment

				PackageMerge nextElement = (PackageMerge) iter.next();
				PackageMerge packageMerge = (PackageMerge) packageMergeToRefresh.get(nextElement);

				// End of user code
			}
			List packageMergeToRemove = basePart.getPackageMergeToRemove();
			for (Iterator iter = packageMergeToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List packageMergeToMove = basePart.getPackageMergeToMove();
			for (Iterator iter = packageMergeToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getPackageMerge(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packagedElementToAdd = basePart.getPackagedElementToAdd();
			for (Iterator iter = packagedElementToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getPackage_PackagedElement(), iter.next()));
			Map packagedElementToRefresh = basePart.getPackagedElementToEdit();
			for (Iterator iter = packagedElementToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for packagedElement reference refreshment

				PackageableElement nextElement = (PackageableElement) iter.next();
				PackageableElement packagedElement = (PackageableElement) packagedElementToRefresh.get(nextElement);

				// End of user code
			}
			List packagedElementToRemove = basePart.getPackagedElementToRemove();
			for (Iterator iter = packagedElementToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List packagedElementToMove = basePart.getPackagedElementToMove();
			for (Iterator iter = packagedElementToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getPackageableElement(), moveElement.getElement(), moveElement.getIndex()));
			}
			List profileApplicationToAdd = basePart.getProfileApplicationToAdd();
			for (Iterator iter = profileApplicationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getPackage_ProfileApplication(), iter.next()));
			Map profileApplicationToRefresh = basePart.getProfileApplicationToEdit();
			for (Iterator iter = profileApplicationToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for profileApplication reference refreshment

				ProfileApplication nextElement = (ProfileApplication) iter.next();
				ProfileApplication profileApplication = (ProfileApplication) profileApplicationToRefresh.get(nextElement);

				// End of user code
			}
			List profileApplicationToRemove = basePart.getProfileApplicationToRemove();
			for (Iterator iter = profileApplicationToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List profileApplicationToMove = basePart.getProfileApplicationToMove();
			for (Iterator iter = profileApplicationToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getProfileApplication(), moveElement.getElement(), moveElement.getIndex()));
			}
			List metaclassReferenceToAdd = basePart.getMetaclassReferenceToAdd();
			for (Iterator iter = metaclassReferenceToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetaclassReference(), iter.next()));
			List metaclassReferenceToRemove = basePart.getMetaclassReferenceToRemove();
			for (Iterator iter = metaclassReferenceToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetaclassReference(), iter.next()));
			// List metaclassReferenceToMove = basePart.getMetaclassReferenceToMove();
			// for (Iterator iter = metaclassReferenceToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List metamodelReferenceToAdd = basePart.getMetamodelReferenceToAdd();
			for (Iterator iter = metamodelReferenceToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetamodelReference(), iter.next()));
			List metamodelReferenceToRemove = basePart.getMetamodelReferenceToRemove();
			for (Iterator iter = metamodelReferenceToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetamodelReference(), iter.next()));
			// List metamodelReferenceToMove = basePart.getMetamodelReferenceToMove();
			// for (Iterator iter = metamodelReferenceToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, profile, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof Profile) {
			Profile profileToUpdate = (Profile) source;
			profileToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			profileToUpdate.setName(basePart.getName());

			profileToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			profileToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			profileToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			profileToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			profileToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			profileToUpdate.getTemplateBindings().addAll(basePart.getTemplateBindingToAdd());
			profileToUpdate.getPackageMerges().addAll(basePart.getPackageMergeToAdd());
			profileToUpdate.getPackagedElements().addAll(basePart.getPackagedElementToAdd());
			profileToUpdate.getProfileApplications().addAll(basePart.getProfileApplicationToAdd());
			profileToUpdate.getMetaclassReferences().addAll(basePart.getMetaclassReferenceToAdd());
			profileToUpdate.getMetamodelReferences().addAll(basePart.getMetamodelReferenceToAdd());

			return profileToUpdate;
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
			if (UMLViewsRepository.Profile.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the profile update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.Profile.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.Profile.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.elementImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport) event.getOldValue();
					ElementImport newValue = (ElementImport) event.getNewValue();

					// Start of user code for elementImport live update command
					// TODO: Complete the profile update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.packageImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport) event.getOldValue();
					PackageImport newValue = (PackageImport) event.getNewValue();

					// Start of user code for packageImport live update command
					// TODO: Complete the profile update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.ownedRule == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for ownedRule live update command
					// TODO: Complete the profile update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.templateBinding == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					TemplateBinding oldValue = (TemplateBinding) event.getOldValue();
					TemplateBinding newValue = (TemplateBinding) event.getNewValue();

					// Start of user code for templateBinding live update command
					// TODO: Complete the profile update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getTemplateBinding(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.packageMerge == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageMerge oldValue = (PackageMerge) event.getOldValue();
					PackageMerge newValue = (PackageMerge) event.getNewValue();

					// Start of user code for packageMerge live update command
					// TODO: Complete the profile update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getPackage_PackageMerge(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getPackageMerge(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.packagedElement == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageableElement oldValue = (PackageableElement) event.getOldValue();
					PackageableElement newValue = (PackageableElement) event.getNewValue();

					// Start of user code for packagedElement live update command
					// TODO: Complete the profile update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getPackage_PackagedElement(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getPackageableElement(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.profileApplication == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ProfileApplication oldValue = (ProfileApplication) event.getOldValue();
					ProfileApplication newValue = (ProfileApplication) event.getNewValue();

					// Start of user code for profileApplication live update command
					// TODO: Complete the profile update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getPackage_ProfileApplication(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getProfileApplication(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.metaclassReference == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetaclassReference(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetaclassReference(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetaclassReference(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Profile.metamodelReference == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetamodelReference(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetamodelReference(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, profile, UMLPackage.eINSTANCE.getProfile_MetamodelReference(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.Profile.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.Profile.name == event.getAffectedEditor())
					basePart.unsetMessageForName();

			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.Profile.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.elementImport)
			return "References the ElementImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.packageImport)
			return "References the PackageImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.ownedRule)
			return "Specifies a set of Constraints owned by this Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.templateBinding)
			return "The optional bindings from this element to templates."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.packageMerge)
			return "References the PackageMerges that are owned by this Package."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.packagedElement)
			return "Specifies the packageable elements that are owned by this Package."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.profileApplication)
			return "References the ProfileApplications that indicate which profiles have been applied to the Package."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.metaclassReference)
			return "References a metaclass that may be extended."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Profile.metamodelReference)
			return "References a package containing (directly or indirectly) metaclasses that may be extended."; //$NON-NLS-1$
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
			if (UMLViewsRepository.Profile.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Profile.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(profile);
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
			profile.eAdapters().remove(semanticAdapter);
	}

}
