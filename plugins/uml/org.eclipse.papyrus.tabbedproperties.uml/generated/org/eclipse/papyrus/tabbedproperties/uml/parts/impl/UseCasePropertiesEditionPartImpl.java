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
package org.eclipse.papyrus.tabbedproperties.uml.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class UseCasePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, UseCasePropertiesEditionPart {

	protected EMFListEditUtil ownedCommentEditUtil;

	protected ReferencesTable<? extends EObject> ownedComment;

	protected List<ViewerFilter> ownedCommentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedCommentFilters = new ArrayList<ViewerFilter>();

	protected Text name;

	protected EMFComboViewer visibility;

	protected EMFListEditUtil clientDependencyEditUtil;

	protected ReferencesTable<? extends EObject> clientDependency;

	protected List<ViewerFilter> clientDependencyBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> clientDependencyFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil elementImportEditUtil;

	protected ReferencesTable<? extends EObject> elementImport;

	protected List<ViewerFilter> elementImportBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> elementImportFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil packageImportEditUtil;

	protected ReferencesTable<? extends EObject> packageImport;

	protected List<ViewerFilter> packageImportBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> packageImportFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedRuleEditUtil;

	protected ReferencesTable<? extends EObject> ownedRule;

	protected List<ViewerFilter> ownedRuleBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedRuleFilters = new ArrayList<ViewerFilter>();

	protected Button isLeaf;

	protected EMFListEditUtil templateBindingEditUtil;

	protected ReferencesTable<? extends EObject> templateBinding;

	protected List<ViewerFilter> templateBindingBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> templateBindingFilters = new ArrayList<ViewerFilter>();

	protected Button isAbstract;

	protected EMFListEditUtil generalizationEditUtil;

	protected ReferencesTable<? extends EObject> generalization;

	protected List<ViewerFilter> generalizationBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> generalizationFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil powertypeExtentEditUtil;

	protected ReferencesTable<? extends EObject> powertypeExtent;

	protected List<ViewerFilter> powertypeExtentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> powertypeExtentFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil redefinedClassifierEditUtil;

	protected ReferencesTable<? extends EObject> redefinedClassifier;

	protected List<ViewerFilter> redefinedClassifierBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> redefinedClassifierFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil substitutionEditUtil;

	protected ReferencesTable<? extends EObject> substitution;

	protected List<ViewerFilter> substitutionBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> substitutionFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil collaborationUseEditUtil;

	protected ReferencesTable<? extends EObject> collaborationUse;

	protected List<ViewerFilter> collaborationUseBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> collaborationUseFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedUseCaseEditUtil;

	protected ReferencesTable<? extends EObject> ownedUseCase;

	protected List<ViewerFilter> ownedUseCaseBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedUseCaseFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil useCaseEditUtil;

	protected ReferencesTable<? extends EObject> useCase;

	protected List<ViewerFilter> useCaseBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> useCaseFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedBehaviorEditUtil;

	protected ReferencesTable<? extends EObject> ownedBehavior;

	protected List<ViewerFilter> ownedBehaviorBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedBehaviorFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil interfaceRealizationEditUtil;

	protected ReferencesTable<? extends EObject> interfaceRealization;

	protected List<ViewerFilter> interfaceRealizationBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> interfaceRealizationFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedTriggerEditUtil;

	protected ReferencesTable<? extends EObject> ownedTrigger;

	protected List<ViewerFilter> ownedTriggerBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedTriggerFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil includeEditUtil;

	protected ReferencesTable<? extends EObject> include;

	protected List<ViewerFilter> includeBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> includeFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil extendEditUtil;

	protected ReferencesTable<? extends EObject> extend;

	protected List<ViewerFilter> extendBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> extendFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil extensionPointEditUtil;

	protected ReferencesTable<? extends EObject> extensionPoint;

	protected List<ViewerFilter> extensionPointBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> extensionPointFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil subjectEditUtil;

	protected ReferencesTable<? extends EObject> subject;

	protected List<ViewerFilter> subjectBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> subjectFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public UseCasePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart# createFigure(org.eclipse.swt.widgets.Composite)
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);

		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart# createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) {
		createPropertiesGroup(view);

		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(UMLMessages.UseCasePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createOwnedCommentAdvancedTableComposition(propertiesGroup);
		createNameText(propertiesGroup);
		createVisibilityEMFComboViewer(propertiesGroup);
		createClientDependencyAdvancedReferencesTable(propertiesGroup);
		createElementImportAdvancedTableComposition(propertiesGroup);
		createPackageImportAdvancedTableComposition(propertiesGroup);
		createOwnedRuleAdvancedTableComposition(propertiesGroup);
		createIsLeafCheckbox(propertiesGroup);
		createTemplateBindingAdvancedTableComposition(propertiesGroup);
		createIsAbstractCheckbox(propertiesGroup);
		createGeneralizationAdvancedTableComposition(propertiesGroup);
		createPowertypeExtentAdvancedReferencesTable(propertiesGroup);
		createRedefinedClassifierAdvancedReferencesTable(propertiesGroup);
		createSubstitutionAdvancedTableComposition(propertiesGroup);
		createCollaborationUseAdvancedTableComposition(propertiesGroup);
		createOwnedUseCaseAdvancedTableComposition(propertiesGroup);
		createUseCaseAdvancedReferencesTable(propertiesGroup);
		createOwnedBehaviorAdvancedTableComposition(propertiesGroup);
		createInterfaceRealizationAdvancedTableComposition(propertiesGroup);
		createOwnedTriggerAdvancedTableComposition(propertiesGroup);
		createIncludeAdvancedTableComposition(propertiesGroup);
		createExtendAdvancedTableComposition(propertiesGroup);
		createExtensionPointAdvancedTableComposition(propertiesGroup);
		createSubjectAdvancedReferencesTable(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentAdvancedTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.UseCasePropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

			public void handleAdd() {
				addToOwnedComment();
			}

			public void handleEdit(Comment element) {
				editOwnedComment(element);
			}

			public void handleMove(Comment element, int oldIndex, int newIndex) {
				moveOwnedComment(element, oldIndex, newIndex);
			}

			public void handleRemove(Comment element) {
				removeFromOwnedComment(element);
			}

			public void navigateTo(Comment element) {
			}
		});
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.ownedComment, UMLViewsRepository.SWT_KIND));
		this.ownedComment.createControls(parent);
		GridData ownedCommentData = new GridData(GridData.FILL_HORIZONTAL);
		ownedCommentData.horizontalSpan = 3;
		this.ownedComment.setLayoutData(ownedCommentData);
	}

	/**
	 * 
	 */
	protected void moveOwnedComment(Comment element, int oldIndex, int newIndex) {
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.moveElement(element, oldIndex, newIndex);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedComment() {

		// Start of user code addToOwnedComment() method body
		Comment eObject = UMLFactory.eINSTANCE.createComment();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedCommentEditUtil.addElement(propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedComment,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedComment(Comment element) {

		// Start of user code removeFromOwnedComment() method body
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.removeElement(element);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedComment,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedComment(Comment element) {

		// Start of user code editOwnedComment() method body
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedCommentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedComment,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.UseCasePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.UseCase.name, UMLViewsRepository.SWT_KIND));
		name = new Text(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.UseCasePropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.UseCase.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createClientDependencyAdvancedReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.UseCasePropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, clientDependencyFilters, clientDependencyBusinessFilters,
						"Dependency", UMLPackage.eINSTANCE.getDependency(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.clientDependency,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						clientDependency.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Dependency element) {
				editClientDependency(element);
			}

			public void handleMove(Dependency element, int oldIndex, int newIndex) {
				moveClientDependency(element, oldIndex, newIndex);
			}

			public void handleRemove(Dependency element) {
				removeFromClientDependency(element);
			}

			public void navigateTo(Dependency element) {
			}
		});
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.clientDependency, UMLViewsRepository.SWT_KIND));
		this.clientDependency.createControls(parent);
		GridData clientDependencyData = new GridData(GridData.FILL_HORIZONTAL);
		clientDependencyData.horizontalSpan = 3;
		this.clientDependency.setLayoutData(clientDependencyData);
		this.clientDependency.disableMove();
	}

	/**
	 * 
	 */
	protected void moveClientDependency(Dependency element, int oldIndex, int newIndex) {
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.moveElement(element, oldIndex, newIndex);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromClientDependency(Dependency element) {

		// Start of user code removeFromClientDependency() method body
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.removeElement(element);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.clientDependency,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editClientDependency(Dependency element) {

		// Start of user code editClientDependency() method body
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				clientDependencyEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				clientDependency.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.clientDependency,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createElementImportAdvancedTableComposition(Composite parent) {
		this.elementImport = new ReferencesTable<ElementImport>(UMLMessages.UseCasePropertiesEditionPart_ElementImportLabel, new ReferencesTableListener<ElementImport>() {

			public void handleAdd() {
				addToElementImport();
			}

			public void handleEdit(ElementImport element) {
				editElementImport(element);
			}

			public void handleMove(ElementImport element, int oldIndex, int newIndex) {
				moveElementImport(element, oldIndex, newIndex);
			}

			public void handleRemove(ElementImport element) {
				removeFromElementImport(element);
			}

			public void navigateTo(ElementImport element) {
			}
		});
		this.elementImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.elementImport, UMLViewsRepository.SWT_KIND));
		this.elementImport.createControls(parent);
		GridData elementImportData = new GridData(GridData.FILL_HORIZONTAL);
		elementImportData.horizontalSpan = 3;
		this.elementImport.setLayoutData(elementImportData);
	}

	/**
	 * 
	 */
	protected void moveElementImport(ElementImport element, int oldIndex, int newIndex) {
		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		elementImportEditUtil.moveElement(element, oldIndex, newIndex);
		elementImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.elementImport, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToElementImport() {

		// Start of user code addToElementImport() method body
		ElementImport eObject = UMLFactory.eINSTANCE.createElementImport();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				elementImportEditUtil.addElement(propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.elementImport,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromElementImport(ElementImport element) {

		// Start of user code removeFromElementImport() method body
		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		elementImportEditUtil.removeElement(element);
		elementImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.elementImport,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editElementImport(ElementImport element) {

		// Start of user code editElementImport() method body
		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				elementImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.elementImport,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createPackageImportAdvancedTableComposition(Composite parent) {
		this.packageImport = new ReferencesTable<PackageImport>(UMLMessages.UseCasePropertiesEditionPart_PackageImportLabel, new ReferencesTableListener<PackageImport>() {

			public void handleAdd() {
				addToPackageImport();
			}

			public void handleEdit(PackageImport element) {
				editPackageImport(element);
			}

			public void handleMove(PackageImport element, int oldIndex, int newIndex) {
				movePackageImport(element, oldIndex, newIndex);
			}

			public void handleRemove(PackageImport element) {
				removeFromPackageImport(element);
			}

			public void navigateTo(PackageImport element) {
			}
		});
		this.packageImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.packageImport, UMLViewsRepository.SWT_KIND));
		this.packageImport.createControls(parent);
		GridData packageImportData = new GridData(GridData.FILL_HORIZONTAL);
		packageImportData.horizontalSpan = 3;
		this.packageImport.setLayoutData(packageImportData);
	}

	/**
	 * 
	 */
	protected void movePackageImport(PackageImport element, int oldIndex, int newIndex) {
		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		packageImportEditUtil.moveElement(element, oldIndex, newIndex);
		packageImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.packageImport, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToPackageImport() {

		// Start of user code addToPackageImport() method body
		PackageImport eObject = UMLFactory.eINSTANCE.createPackageImport();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				packageImportEditUtil.addElement(propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.packageImport,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromPackageImport(PackageImport element) {

		// Start of user code removeFromPackageImport() method body
		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		packageImportEditUtil.removeElement(element);
		packageImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.packageImport,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editPackageImport(PackageImport element) {

		// Start of user code editPackageImport() method body
		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				packageImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.packageImport,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedRuleAdvancedTableComposition(Composite parent) {
		this.ownedRule = new ReferencesTable<Constraint>(UMLMessages.UseCasePropertiesEditionPart_OwnedRuleLabel, new ReferencesTableListener<Constraint>() {

			public void handleAdd() {
				addToOwnedRule();
			}

			public void handleEdit(Constraint element) {
				editOwnedRule(element);
			}

			public void handleMove(Constraint element, int oldIndex, int newIndex) {
				moveOwnedRule(element, oldIndex, newIndex);
			}

			public void handleRemove(Constraint element) {
				removeFromOwnedRule(element);
			}

			public void navigateTo(Constraint element) {
			}
		});
		this.ownedRule.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.ownedRule, UMLViewsRepository.SWT_KIND));
		this.ownedRule.createControls(parent);
		GridData ownedRuleData = new GridData(GridData.FILL_HORIZONTAL);
		ownedRuleData.horizontalSpan = 3;
		this.ownedRule.setLayoutData(ownedRuleData);
	}

	/**
	 * 
	 */
	protected void moveOwnedRule(Constraint element, int oldIndex, int newIndex) {
		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		ownedRuleEditUtil.moveElement(element, oldIndex, newIndex);
		ownedRule.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedRule, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedRule() {

		// Start of user code addToOwnedRule() method body
		Constraint eObject = UMLFactory.eINSTANCE.createConstraint();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedRuleEditUtil.addElement(propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedRule,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedRule(Constraint element) {

		// Start of user code removeFromOwnedRule() method body
		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		ownedRuleEditUtil.removeElement(element);
		ownedRule.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedRule,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedRule(Constraint element) {

		// Start of user code editOwnedRule() method body
		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedRuleEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedRule,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createIsLeafCheckbox(Composite parent) {
		isLeaf = new Button(parent, SWT.CHECK);
		isLeaf.setText(UMLMessages.UseCasePropertiesEditionPart_IsLeafLabel);
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.isLeaf, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 */
	protected void createTemplateBindingAdvancedTableComposition(Composite parent) {
		this.templateBinding = new ReferencesTable<TemplateBinding>(UMLMessages.UseCasePropertiesEditionPart_TemplateBindingLabel, new ReferencesTableListener<TemplateBinding>() {

			public void handleAdd() {
				addToTemplateBinding();
			}

			public void handleEdit(TemplateBinding element) {
				editTemplateBinding(element);
			}

			public void handleMove(TemplateBinding element, int oldIndex, int newIndex) {
				moveTemplateBinding(element, oldIndex, newIndex);
			}

			public void handleRemove(TemplateBinding element) {
				removeFromTemplateBinding(element);
			}

			public void navigateTo(TemplateBinding element) {
			}
		});
		this.templateBinding.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.templateBinding, UMLViewsRepository.SWT_KIND));
		this.templateBinding.createControls(parent);
		GridData templateBindingData = new GridData(GridData.FILL_HORIZONTAL);
		templateBindingData.horizontalSpan = 3;
		this.templateBinding.setLayoutData(templateBindingData);
	}

	/**
	 * 
	 */
	protected void moveTemplateBinding(TemplateBinding element, int oldIndex, int newIndex) {
		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		templateBindingEditUtil.moveElement(element, oldIndex, newIndex);
		templateBinding.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.templateBinding, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToTemplateBinding() {

		// Start of user code addToTemplateBinding() method body
		TemplateBinding eObject = UMLFactory.eINSTANCE.createTemplateBinding();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				templateBindingEditUtil.addElement(propertiesEditionObject);
				templateBinding.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.templateBinding,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromTemplateBinding(TemplateBinding element) {

		// Start of user code removeFromTemplateBinding() method body
		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		templateBindingEditUtil.removeElement(element);
		templateBinding.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.templateBinding,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editTemplateBinding(TemplateBinding element) {

		// Start of user code editTemplateBinding() method body
		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				templateBindingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				templateBinding.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.templateBinding,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createIsAbstractCheckbox(Composite parent) {
		isAbstract = new Button(parent, SWT.CHECK);
		isAbstract.setText(UMLMessages.UseCasePropertiesEditionPart_IsAbstractLabel);
		GridData isAbstractData = new GridData(GridData.FILL_HORIZONTAL);
		isAbstractData.horizontalSpan = 2;
		isAbstract.setLayoutData(isAbstractData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.isAbstract, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 */
	protected void createGeneralizationAdvancedTableComposition(Composite parent) {
		this.generalization = new ReferencesTable<Generalization>(UMLMessages.UseCasePropertiesEditionPart_GeneralizationLabel, new ReferencesTableListener<Generalization>() {

			public void handleAdd() {
				addToGeneralization();
			}

			public void handleEdit(Generalization element) {
				editGeneralization(element);
			}

			public void handleMove(Generalization element, int oldIndex, int newIndex) {
				moveGeneralization(element, oldIndex, newIndex);
			}

			public void handleRemove(Generalization element) {
				removeFromGeneralization(element);
			}

			public void navigateTo(Generalization element) {
			}
		});
		this.generalization.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.generalization, UMLViewsRepository.SWT_KIND));
		this.generalization.createControls(parent);
		GridData generalizationData = new GridData(GridData.FILL_HORIZONTAL);
		generalizationData.horizontalSpan = 3;
		this.generalization.setLayoutData(generalizationData);
	}

	/**
	 * 
	 */
	protected void moveGeneralization(Generalization element, int oldIndex, int newIndex) {
		EObject editedElement = generalizationEditUtil.foundCorrespondingEObject(element);
		generalizationEditUtil.moveElement(element, oldIndex, newIndex);
		generalization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.generalization, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToGeneralization() {

		// Start of user code addToGeneralization() method body
		Generalization eObject = UMLFactory.eINSTANCE.createGeneralization();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				generalizationEditUtil.addElement(propertiesEditionObject);
				generalization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.generalization,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromGeneralization(Generalization element) {

		// Start of user code removeFromGeneralization() method body
		EObject editedElement = generalizationEditUtil.foundCorrespondingEObject(element);
		generalizationEditUtil.removeElement(element);
		generalization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.generalization,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editGeneralization(Generalization element) {

		// Start of user code editGeneralization() method body
		EObject editedElement = generalizationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				generalizationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				generalization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.generalization,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createPowertypeExtentAdvancedReferencesTable(Composite parent) {
		this.powertypeExtent = new ReferencesTable<GeneralizationSet>(UMLMessages.UseCasePropertiesEditionPart_PowertypeExtentLabel, new ReferencesTableListener<GeneralizationSet>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<GeneralizationSet> dialog = new TabElementTreeSelectionDialog<GeneralizationSet>(resourceSet, powertypeExtentFilters, powertypeExtentBusinessFilters,
						"GeneralizationSet", UMLPackage.eINSTANCE.getGeneralizationSet(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!powertypeExtentEditUtil.getVirtualList().contains(elem))
								powertypeExtentEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.powertypeExtent,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						powertypeExtent.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(GeneralizationSet element) {
				editPowertypeExtent(element);
			}

			public void handleMove(GeneralizationSet element, int oldIndex, int newIndex) {
				movePowertypeExtent(element, oldIndex, newIndex);
			}

			public void handleRemove(GeneralizationSet element) {
				removeFromPowertypeExtent(element);
			}

			public void navigateTo(GeneralizationSet element) {
			}
		});
		this.powertypeExtent.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.powertypeExtent, UMLViewsRepository.SWT_KIND));
		this.powertypeExtent.createControls(parent);
		GridData powertypeExtentData = new GridData(GridData.FILL_HORIZONTAL);
		powertypeExtentData.horizontalSpan = 3;
		this.powertypeExtent.setLayoutData(powertypeExtentData);
		this.powertypeExtent.disableMove();
	}

	/**
	 * 
	 */
	protected void movePowertypeExtent(GeneralizationSet element, int oldIndex, int newIndex) {
		EObject editedElement = powertypeExtentEditUtil.foundCorrespondingEObject(element);
		powertypeExtentEditUtil.moveElement(element, oldIndex, newIndex);
		powertypeExtent.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.powertypeExtent, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromPowertypeExtent(GeneralizationSet element) {

		// Start of user code removeFromPowertypeExtent() method body
		EObject editedElement = powertypeExtentEditUtil.foundCorrespondingEObject(element);
		powertypeExtentEditUtil.removeElement(element);
		powertypeExtent.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.powertypeExtent,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editPowertypeExtent(GeneralizationSet element) {

		// Start of user code editPowertypeExtent() method body
		EObject editedElement = powertypeExtentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				powertypeExtentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				powertypeExtent.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.powertypeExtent,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createRedefinedClassifierAdvancedReferencesTable(Composite parent) {
		this.redefinedClassifier = new ReferencesTable<Classifier>(UMLMessages.UseCasePropertiesEditionPart_RedefinedClassifierLabel, new ReferencesTableListener<Classifier>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, redefinedClassifierFilters, redefinedClassifierBusinessFilters,
						"Classifier", UMLPackage.eINSTANCE.getClassifier(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!redefinedClassifierEditUtil.getVirtualList().contains(elem))
								redefinedClassifierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.redefinedClassifier,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						redefinedClassifier.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Classifier element) {
				editRedefinedClassifier(element);
			}

			public void handleMove(Classifier element, int oldIndex, int newIndex) {
				moveRedefinedClassifier(element, oldIndex, newIndex);
			}

			public void handleRemove(Classifier element) {
				removeFromRedefinedClassifier(element);
			}

			public void navigateTo(Classifier element) {
			}
		});
		this.redefinedClassifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.redefinedClassifier, UMLViewsRepository.SWT_KIND));
		this.redefinedClassifier.createControls(parent);
		GridData redefinedClassifierData = new GridData(GridData.FILL_HORIZONTAL);
		redefinedClassifierData.horizontalSpan = 3;
		this.redefinedClassifier.setLayoutData(redefinedClassifierData);
		this.redefinedClassifier.disableMove();
	}

	/**
	 * 
	 */
	protected void moveRedefinedClassifier(Classifier element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromRedefinedClassifier(Classifier element) {

		// Start of user code removeFromRedefinedClassifier() method body
		EObject editedElement = redefinedClassifierEditUtil.foundCorrespondingEObject(element);
		redefinedClassifierEditUtil.removeElement(element);
		redefinedClassifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.redefinedClassifier,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRedefinedClassifier(Classifier element) {

		// Start of user code editRedefinedClassifier() method body
		EObject editedElement = redefinedClassifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				redefinedClassifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				redefinedClassifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.redefinedClassifier,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createSubstitutionAdvancedTableComposition(Composite parent) {
		this.substitution = new ReferencesTable<Substitution>(UMLMessages.UseCasePropertiesEditionPart_SubstitutionLabel, new ReferencesTableListener<Substitution>() {

			public void handleAdd() {
				addToSubstitution();
			}

			public void handleEdit(Substitution element) {
				editSubstitution(element);
			}

			public void handleMove(Substitution element, int oldIndex, int newIndex) {
				moveSubstitution(element, oldIndex, newIndex);
			}

			public void handleRemove(Substitution element) {
				removeFromSubstitution(element);
			}

			public void navigateTo(Substitution element) {
			}
		});
		this.substitution.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.substitution, UMLViewsRepository.SWT_KIND));
		this.substitution.createControls(parent);
		GridData substitutionData = new GridData(GridData.FILL_HORIZONTAL);
		substitutionData.horizontalSpan = 3;
		this.substitution.setLayoutData(substitutionData);
	}

	/**
	 * 
	 */
	protected void moveSubstitution(Substitution element, int oldIndex, int newIndex) {
		EObject editedElement = substitutionEditUtil.foundCorrespondingEObject(element);
		substitutionEditUtil.moveElement(element, oldIndex, newIndex);
		substitution.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.substitution, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToSubstitution() {

		// Start of user code addToSubstitution() method body
		Substitution eObject = UMLFactory.eINSTANCE.createSubstitution();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				substitutionEditUtil.addElement(propertiesEditionObject);
				substitution.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.substitution,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromSubstitution(Substitution element) {

		// Start of user code removeFromSubstitution() method body
		EObject editedElement = substitutionEditUtil.foundCorrespondingEObject(element);
		substitutionEditUtil.removeElement(element);
		substitution.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.substitution,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSubstitution(Substitution element) {

		// Start of user code editSubstitution() method body
		EObject editedElement = substitutionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				substitutionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				substitution.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.substitution,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createCollaborationUseAdvancedTableComposition(Composite parent) {
		this.collaborationUse = new ReferencesTable<CollaborationUse>(UMLMessages.UseCasePropertiesEditionPart_CollaborationUseLabel, new ReferencesTableListener<CollaborationUse>() {

			public void handleAdd() {
				addToCollaborationUse();
			}

			public void handleEdit(CollaborationUse element) {
				editCollaborationUse(element);
			}

			public void handleMove(CollaborationUse element, int oldIndex, int newIndex) {
				moveCollaborationUse(element, oldIndex, newIndex);
			}

			public void handleRemove(CollaborationUse element) {
				removeFromCollaborationUse(element);
			}

			public void navigateTo(CollaborationUse element) {
			}
		});
		this.collaborationUse.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.collaborationUse, UMLViewsRepository.SWT_KIND));
		this.collaborationUse.createControls(parent);
		GridData collaborationUseData = new GridData(GridData.FILL_HORIZONTAL);
		collaborationUseData.horizontalSpan = 3;
		this.collaborationUse.setLayoutData(collaborationUseData);
	}

	/**
	 * 
	 */
	protected void moveCollaborationUse(CollaborationUse element, int oldIndex, int newIndex) {
		EObject editedElement = collaborationUseEditUtil.foundCorrespondingEObject(element);
		collaborationUseEditUtil.moveElement(element, oldIndex, newIndex);
		collaborationUse.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.collaborationUse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToCollaborationUse() {

		// Start of user code addToCollaborationUse() method body
		CollaborationUse eObject = UMLFactory.eINSTANCE.createCollaborationUse();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				collaborationUseEditUtil.addElement(propertiesEditionObject);
				collaborationUse.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.collaborationUse,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromCollaborationUse(CollaborationUse element) {

		// Start of user code removeFromCollaborationUse() method body
		EObject editedElement = collaborationUseEditUtil.foundCorrespondingEObject(element);
		collaborationUseEditUtil.removeElement(element);
		collaborationUse.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.collaborationUse,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editCollaborationUse(CollaborationUse element) {

		// Start of user code editCollaborationUse() method body
		EObject editedElement = collaborationUseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				collaborationUseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				collaborationUse.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.collaborationUse,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedUseCaseAdvancedTableComposition(Composite parent) {
		this.ownedUseCase = new ReferencesTable<UseCase>(UMLMessages.UseCasePropertiesEditionPart_OwnedUseCaseLabel, new ReferencesTableListener<UseCase>() {

			public void handleAdd() {
				addToOwnedUseCase();
			}

			public void handleEdit(UseCase element) {
				editOwnedUseCase(element);
			}

			public void handleMove(UseCase element, int oldIndex, int newIndex) {
				moveOwnedUseCase(element, oldIndex, newIndex);
			}

			public void handleRemove(UseCase element) {
				removeFromOwnedUseCase(element);
			}

			public void navigateTo(UseCase element) {
			}
		});
		this.ownedUseCase.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.ownedUseCase, UMLViewsRepository.SWT_KIND));
		this.ownedUseCase.createControls(parent);
		GridData ownedUseCaseData = new GridData(GridData.FILL_HORIZONTAL);
		ownedUseCaseData.horizontalSpan = 3;
		this.ownedUseCase.setLayoutData(ownedUseCaseData);
	}

	/**
	 * 
	 */
	protected void moveOwnedUseCase(UseCase element, int oldIndex, int newIndex) {
		EObject editedElement = ownedUseCaseEditUtil.foundCorrespondingEObject(element);
		ownedUseCaseEditUtil.moveElement(element, oldIndex, newIndex);
		ownedUseCase.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedUseCase, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedUseCase() {

		// Start of user code addToOwnedUseCase() method body
		UseCase eObject = UMLFactory.eINSTANCE.createUseCase();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedUseCaseEditUtil.addElement(propertiesEditionObject);
				ownedUseCase.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedUseCase,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedUseCase(UseCase element) {

		// Start of user code removeFromOwnedUseCase() method body
		EObject editedElement = ownedUseCaseEditUtil.foundCorrespondingEObject(element);
		ownedUseCaseEditUtil.removeElement(element);
		ownedUseCase.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedUseCase,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedUseCase(UseCase element) {

		// Start of user code editOwnedUseCase() method body
		EObject editedElement = ownedUseCaseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedUseCaseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedUseCase.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedUseCase,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createUseCaseAdvancedReferencesTable(Composite parent) {
		this.useCase = new ReferencesTable<UseCase>(UMLMessages.UseCasePropertiesEditionPart_UseCaseLabel, new ReferencesTableListener<UseCase>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<UseCase> dialog = new TabElementTreeSelectionDialog<UseCase>(resourceSet, useCaseFilters, useCaseBusinessFilters,
						"UseCase", UMLPackage.eINSTANCE.getUseCase(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!useCaseEditUtil.getVirtualList().contains(elem))
								useCaseEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.useCase,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						useCase.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(UseCase element) {
				editUseCase(element);
			}

			public void handleMove(UseCase element, int oldIndex, int newIndex) {
				moveUseCase(element, oldIndex, newIndex);
			}

			public void handleRemove(UseCase element) {
				removeFromUseCase(element);
			}

			public void navigateTo(UseCase element) {
			}
		});
		this.useCase.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.useCase, UMLViewsRepository.SWT_KIND));
		this.useCase.createControls(parent);
		GridData useCaseData = new GridData(GridData.FILL_HORIZONTAL);
		useCaseData.horizontalSpan = 3;
		this.useCase.setLayoutData(useCaseData);
		this.useCase.disableMove();
	}

	/**
	 * 
	 */
	protected void moveUseCase(UseCase element, int oldIndex, int newIndex) {
		EObject editedElement = useCaseEditUtil.foundCorrespondingEObject(element);
		useCaseEditUtil.moveElement(element, oldIndex, newIndex);
		useCase.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.useCase, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromUseCase(UseCase element) {

		// Start of user code removeFromUseCase() method body
		EObject editedElement = useCaseEditUtil.foundCorrespondingEObject(element);
		useCaseEditUtil.removeElement(element);
		useCase.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.useCase,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editUseCase(UseCase element) {

		// Start of user code editUseCase() method body
		EObject editedElement = useCaseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				useCaseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				useCase.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.useCase,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedBehaviorAdvancedTableComposition(Composite parent) {
		this.ownedBehavior = new ReferencesTable<Behavior>(UMLMessages.UseCasePropertiesEditionPart_OwnedBehaviorLabel, new ReferencesTableListener<Behavior>() {

			public void handleAdd() {
				addToOwnedBehavior();
			}

			public void handleEdit(Behavior element) {
				editOwnedBehavior(element);
			}

			public void handleMove(Behavior element, int oldIndex, int newIndex) {
				moveOwnedBehavior(element, oldIndex, newIndex);
			}

			public void handleRemove(Behavior element) {
				removeFromOwnedBehavior(element);
			}

			public void navigateTo(Behavior element) {
			}
		});
		this.ownedBehavior.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.ownedBehavior, UMLViewsRepository.SWT_KIND));
		this.ownedBehavior.createControls(parent);
		GridData ownedBehaviorData = new GridData(GridData.FILL_HORIZONTAL);
		ownedBehaviorData.horizontalSpan = 3;
		this.ownedBehavior.setLayoutData(ownedBehaviorData);
	}

	/**
	 * 
	 */
	protected void moveOwnedBehavior(Behavior element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void addToOwnedBehavior() {

		// Start of user code addToOwnedBehavior() method body
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedBehavior(Behavior element) {

		// Start of user code removeFromOwnedBehavior() method body
		EObject editedElement = ownedBehaviorEditUtil.foundCorrespondingEObject(element);
		ownedBehaviorEditUtil.removeElement(element);
		ownedBehavior.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedBehavior,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedBehavior(Behavior element) {

		// Start of user code editOwnedBehavior() method body
		EObject editedElement = ownedBehaviorEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedBehaviorEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedBehavior.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedBehavior,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createInterfaceRealizationAdvancedTableComposition(Composite parent) {
		this.interfaceRealization = new ReferencesTable<InterfaceRealization>(UMLMessages.UseCasePropertiesEditionPart_InterfaceRealizationLabel, new ReferencesTableListener<InterfaceRealization>() {

			public void handleAdd() {
				addToInterfaceRealization();
			}

			public void handleEdit(InterfaceRealization element) {
				editInterfaceRealization(element);
			}

			public void handleMove(InterfaceRealization element, int oldIndex, int newIndex) {
				moveInterfaceRealization(element, oldIndex, newIndex);
			}

			public void handleRemove(InterfaceRealization element) {
				removeFromInterfaceRealization(element);
			}

			public void navigateTo(InterfaceRealization element) {
			}
		});
		this.interfaceRealization.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.interfaceRealization, UMLViewsRepository.SWT_KIND));
		this.interfaceRealization.createControls(parent);
		GridData interfaceRealizationData = new GridData(GridData.FILL_HORIZONTAL);
		interfaceRealizationData.horizontalSpan = 3;
		this.interfaceRealization.setLayoutData(interfaceRealizationData);
	}

	/**
	 * 
	 */
	protected void moveInterfaceRealization(InterfaceRealization element, int oldIndex, int newIndex) {
		EObject editedElement = interfaceRealizationEditUtil.foundCorrespondingEObject(element);
		interfaceRealizationEditUtil.moveElement(element, oldIndex, newIndex);
		interfaceRealization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.interfaceRealization, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToInterfaceRealization() {

		// Start of user code addToInterfaceRealization() method body
		InterfaceRealization eObject = UMLFactory.eINSTANCE.createInterfaceRealization();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				interfaceRealizationEditUtil.addElement(propertiesEditionObject);
				interfaceRealization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.interfaceRealization,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromInterfaceRealization(InterfaceRealization element) {

		// Start of user code removeFromInterfaceRealization() method body
		EObject editedElement = interfaceRealizationEditUtil.foundCorrespondingEObject(element);
		interfaceRealizationEditUtil.removeElement(element);
		interfaceRealization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.interfaceRealization,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editInterfaceRealization(InterfaceRealization element) {

		// Start of user code editInterfaceRealization() method body
		EObject editedElement = interfaceRealizationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				interfaceRealizationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				interfaceRealization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.interfaceRealization,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedTriggerAdvancedTableComposition(Composite parent) {
		this.ownedTrigger = new ReferencesTable<Trigger>(UMLMessages.UseCasePropertiesEditionPart_OwnedTriggerLabel, new ReferencesTableListener<Trigger>() {

			public void handleAdd() {
				addToOwnedTrigger();
			}

			public void handleEdit(Trigger element) {
				editOwnedTrigger(element);
			}

			public void handleMove(Trigger element, int oldIndex, int newIndex) {
				moveOwnedTrigger(element, oldIndex, newIndex);
			}

			public void handleRemove(Trigger element) {
				removeFromOwnedTrigger(element);
			}

			public void navigateTo(Trigger element) {
			}
		});
		this.ownedTrigger.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.ownedTrigger, UMLViewsRepository.SWT_KIND));
		this.ownedTrigger.createControls(parent);
		GridData ownedTriggerData = new GridData(GridData.FILL_HORIZONTAL);
		ownedTriggerData.horizontalSpan = 3;
		this.ownedTrigger.setLayoutData(ownedTriggerData);
	}

	/**
	 * 
	 */
	protected void moveOwnedTrigger(Trigger element, int oldIndex, int newIndex) {
		EObject editedElement = ownedTriggerEditUtil.foundCorrespondingEObject(element);
		ownedTriggerEditUtil.moveElement(element, oldIndex, newIndex);
		ownedTrigger.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedTrigger, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedTrigger() {

		// Start of user code addToOwnedTrigger() method body
		Trigger eObject = UMLFactory.eINSTANCE.createTrigger();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedTriggerEditUtil.addElement(propertiesEditionObject);
				ownedTrigger.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedTrigger,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedTrigger(Trigger element) {

		// Start of user code removeFromOwnedTrigger() method body
		EObject editedElement = ownedTriggerEditUtil.foundCorrespondingEObject(element);
		ownedTriggerEditUtil.removeElement(element);
		ownedTrigger.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedTrigger,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedTrigger(Trigger element) {

		// Start of user code editOwnedTrigger() method body
		EObject editedElement = ownedTriggerEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedTriggerEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedTrigger.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.ownedTrigger,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createIncludeAdvancedTableComposition(Composite parent) {
		this.include = new ReferencesTable<Include>(UMLMessages.UseCasePropertiesEditionPart_IncludeLabel, new ReferencesTableListener<Include>() {

			public void handleAdd() {
				addToInclude();
			}

			public void handleEdit(Include element) {
				editInclude(element);
			}

			public void handleMove(Include element, int oldIndex, int newIndex) {
				moveInclude(element, oldIndex, newIndex);
			}

			public void handleRemove(Include element) {
				removeFromInclude(element);
			}

			public void navigateTo(Include element) {
			}
		});
		this.include.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.include, UMLViewsRepository.SWT_KIND));
		this.include.createControls(parent);
		GridData includeData = new GridData(GridData.FILL_HORIZONTAL);
		includeData.horizontalSpan = 3;
		this.include.setLayoutData(includeData);
	}

	/**
	 * 
	 */
	protected void moveInclude(Include element, int oldIndex, int newIndex) {
		EObject editedElement = includeEditUtil.foundCorrespondingEObject(element);
		includeEditUtil.moveElement(element, oldIndex, newIndex);
		include.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.include, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToInclude() {

		// Start of user code addToInclude() method body
		Include eObject = UMLFactory.eINSTANCE.createInclude();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				includeEditUtil.addElement(propertiesEditionObject);
				include.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.include,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromInclude(Include element) {

		// Start of user code removeFromInclude() method body
		EObject editedElement = includeEditUtil.foundCorrespondingEObject(element);
		includeEditUtil.removeElement(element);
		include.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.include,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editInclude(Include element) {

		// Start of user code editInclude() method body
		EObject editedElement = includeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				includeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				include.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.include,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createExtendAdvancedTableComposition(Composite parent) {
		this.extend = new ReferencesTable<Extend>(UMLMessages.UseCasePropertiesEditionPart_ExtendLabel, new ReferencesTableListener<Extend>() {

			public void handleAdd() {
				addToExtend();
			}

			public void handleEdit(Extend element) {
				editExtend(element);
			}

			public void handleMove(Extend element, int oldIndex, int newIndex) {
				moveExtend(element, oldIndex, newIndex);
			}

			public void handleRemove(Extend element) {
				removeFromExtend(element);
			}

			public void navigateTo(Extend element) {
			}
		});
		this.extend.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.extend, UMLViewsRepository.SWT_KIND));
		this.extend.createControls(parent);
		GridData extendData = new GridData(GridData.FILL_HORIZONTAL);
		extendData.horizontalSpan = 3;
		this.extend.setLayoutData(extendData);
	}

	/**
	 * 
	 */
	protected void moveExtend(Extend element, int oldIndex, int newIndex) {
		EObject editedElement = extendEditUtil.foundCorrespondingEObject(element);
		extendEditUtil.moveElement(element, oldIndex, newIndex);
		extend.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.extend, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToExtend() {

		// Start of user code addToExtend() method body
		Extend eObject = UMLFactory.eINSTANCE.createExtend();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				extendEditUtil.addElement(propertiesEditionObject);
				extend.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.extend,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromExtend(Extend element) {

		// Start of user code removeFromExtend() method body
		EObject editedElement = extendEditUtil.foundCorrespondingEObject(element);
		extendEditUtil.removeElement(element);
		extend.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.extend,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editExtend(Extend element) {

		// Start of user code editExtend() method body
		EObject editedElement = extendEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				extendEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				extend.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.extend,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createExtensionPointAdvancedTableComposition(Composite parent) {
		this.extensionPoint = new ReferencesTable<ExtensionPoint>(UMLMessages.UseCasePropertiesEditionPart_ExtensionPointLabel, new ReferencesTableListener<ExtensionPoint>() {

			public void handleAdd() {
				addToExtensionPoint();
			}

			public void handleEdit(ExtensionPoint element) {
				editExtensionPoint(element);
			}

			public void handleMove(ExtensionPoint element, int oldIndex, int newIndex) {
				moveExtensionPoint(element, oldIndex, newIndex);
			}

			public void handleRemove(ExtensionPoint element) {
				removeFromExtensionPoint(element);
			}

			public void navigateTo(ExtensionPoint element) {
			}
		});
		this.extensionPoint.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.extensionPoint, UMLViewsRepository.SWT_KIND));
		this.extensionPoint.createControls(parent);
		GridData extensionPointData = new GridData(GridData.FILL_HORIZONTAL);
		extensionPointData.horizontalSpan = 3;
		this.extensionPoint.setLayoutData(extensionPointData);
	}

	/**
	 * 
	 */
	protected void moveExtensionPoint(ExtensionPoint element, int oldIndex, int newIndex) {
		EObject editedElement = extensionPointEditUtil.foundCorrespondingEObject(element);
		extensionPointEditUtil.moveElement(element, oldIndex, newIndex);
		extensionPoint.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.extensionPoint, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToExtensionPoint() {

		// Start of user code addToExtensionPoint() method body
		ExtensionPoint eObject = UMLFactory.eINSTANCE.createExtensionPoint();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				extensionPointEditUtil.addElement(propertiesEditionObject);
				extensionPoint.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.extensionPoint,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromExtensionPoint(ExtensionPoint element) {

		// Start of user code removeFromExtensionPoint() method body
		EObject editedElement = extensionPointEditUtil.foundCorrespondingEObject(element);
		extensionPointEditUtil.removeElement(element);
		extensionPoint.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.extensionPoint,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editExtensionPoint(ExtensionPoint element) {

		// Start of user code editExtensionPoint() method body
		EObject editedElement = extensionPointEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				extensionPointEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				extensionPoint.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.extensionPoint,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createSubjectAdvancedReferencesTable(Composite parent) {
		this.subject = new ReferencesTable<Classifier>(UMLMessages.UseCasePropertiesEditionPart_SubjectLabel, new ReferencesTableListener<Classifier>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, subjectFilters, subjectBusinessFilters,
						"Classifier", UMLPackage.eINSTANCE.getClassifier(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!subjectEditUtil.getVirtualList().contains(elem))
								subjectEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.subject,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						subject.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Classifier element) {
				editSubject(element);
			}

			public void handleMove(Classifier element, int oldIndex, int newIndex) {
				moveSubject(element, oldIndex, newIndex);
			}

			public void handleRemove(Classifier element) {
				removeFromSubject(element);
			}

			public void navigateTo(Classifier element) {
			}
		});
		this.subject.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.UseCase.subject, UMLViewsRepository.SWT_KIND));
		this.subject.createControls(parent);
		GridData subjectData = new GridData(GridData.FILL_HORIZONTAL);
		subjectData.horizontalSpan = 3;
		this.subject.setLayoutData(subjectData);
		this.subject.disableMove();
	}

	/**
	 * 
	 */
	protected void moveSubject(Classifier element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromSubject(Classifier element) {

		// Start of user code removeFromSubject() method body
		EObject editedElement = subjectEditUtil.foundCorrespondingEObject(element);
		subjectEditUtil.removeElement(element);
		subject.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.subject,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSubject(Classifier element) {

		// Start of user code editSubject() method body
		EObject editedElement = subjectEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				subjectEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				subject.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						UseCasePropertiesEditionPartImpl.this, UMLViewsRepository.UseCase.subject,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization

		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initOwnedComment(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedCommentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedCommentEditUtil = new EMFListEditUtil(current, feature);
		this.ownedComment.setInput(ownedCommentEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateOwnedComment(EObject newValue)
	 */
	public void updateOwnedComment(EObject newValue) {
		if(ownedCommentEditUtil != null) {
			ownedCommentEditUtil.reinit(newValue);
			ownedComment.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
	 */
	public boolean isContainedInOwnedCommentTable(EObject element) {
		return ownedCommentEditUtil.contains(element);
	}

	public void setMessageForOwnedComment(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedComment() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		if(newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForName(String msg, int msgLevel) {

	}

	public void unsetMessageForName() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForVisibility(String msg, int msgLevel) {

	}

	public void unsetMessageForVisibility() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getClientDependencyTable()
	 */
	public List getClientDependencyTable() {
		return clientDependencyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initClientDependency(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initClientDependency(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			clientDependencyEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			clientDependencyEditUtil = new EMFListEditUtil(current, feature);
		this.clientDependency.setInput(clientDependencyEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateClientDependency(EObject newValue)
	 */
	public void updateClientDependency(EObject newValue) {
		if(clientDependencyEditUtil != null) {
			clientDependencyEditUtil.reinit(newValue);
			clientDependency.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterClientDependency(ViewerFilter filter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter filter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInClientDependencyTable(EObject element)
	 */
	public boolean isContainedInClientDependencyTable(EObject element) {
		return clientDependencyEditUtil.contains(element);
	}

	public void setMessageForClientDependency(String msg, int msgLevel) {

	}

	public void unsetMessageForClientDependency() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getElementImportToAdd()
	 */
	public List getElementImportToAdd() {
		return elementImportEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getElementImportToRemove()
	 */
	public List getElementImportToRemove() {
		return elementImportEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getElementImportToEdit()
	 */
	public Map getElementImportToEdit() {
		return elementImportEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getElementImportToMove()
	 */
	public List getElementImportToMove() {
		return elementImportEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getElementImportTable()
	 */
	public List getElementImportTable() {
		return elementImportEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initElementImport(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initElementImport(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			elementImportEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			elementImportEditUtil = new EMFListEditUtil(current, feature);
		this.elementImport.setInput(elementImportEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateElementImport(EObject newValue)
	 */
	public void updateElementImport(EObject newValue) {
		if(elementImportEditUtil != null) {
			elementImportEditUtil.reinit(newValue);
			elementImport.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterElementImport(ViewerFilter filter)
	 */
	public void addFilterToElementImport(ViewerFilter filter) {
		elementImportFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterElementImport(ViewerFilter filter)
	 */
	public void addBusinessFilterToElementImport(ViewerFilter filter) {
		elementImportBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInElementImportTable(EObject element)
	 */
	public boolean isContainedInElementImportTable(EObject element) {
		return elementImportEditUtil.contains(element);
	}

	public void setMessageForElementImport(String msg, int msgLevel) {

	}

	public void unsetMessageForElementImport() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getPackageImportToAdd()
	 */
	public List getPackageImportToAdd() {
		return packageImportEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getPackageImportToRemove()
	 */
	public List getPackageImportToRemove() {
		return packageImportEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getPackageImportToEdit()
	 */
	public Map getPackageImportToEdit() {
		return packageImportEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getPackageImportToMove()
	 */
	public List getPackageImportToMove() {
		return packageImportEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getPackageImportTable()
	 */
	public List getPackageImportTable() {
		return packageImportEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initPackageImport(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initPackageImport(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			packageImportEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			packageImportEditUtil = new EMFListEditUtil(current, feature);
		this.packageImport.setInput(packageImportEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updatePackageImport(EObject newValue)
	 */
	public void updatePackageImport(EObject newValue) {
		if(packageImportEditUtil != null) {
			packageImportEditUtil.reinit(newValue);
			packageImport.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterPackageImport(ViewerFilter filter)
	 */
	public void addFilterToPackageImport(ViewerFilter filter) {
		packageImportFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterPackageImport(ViewerFilter filter)
	 */
	public void addBusinessFilterToPackageImport(ViewerFilter filter) {
		packageImportBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInPackageImportTable(EObject element)
	 */
	public boolean isContainedInPackageImportTable(EObject element) {
		return packageImportEditUtil.contains(element);
	}

	public void setMessageForPackageImport(String msg, int msgLevel) {

	}

	public void unsetMessageForPackageImport() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedRuleToAdd()
	 */
	public List getOwnedRuleToAdd() {
		return ownedRuleEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedRuleToRemove()
	 */
	public List getOwnedRuleToRemove() {
		return ownedRuleEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedRuleToEdit()
	 */
	public Map getOwnedRuleToEdit() {
		return ownedRuleEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedRuleToMove()
	 */
	public List getOwnedRuleToMove() {
		return ownedRuleEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedRuleTable()
	 */
	public List getOwnedRuleTable() {
		return ownedRuleEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initOwnedRule(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initOwnedRule(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedRuleEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedRuleEditUtil = new EMFListEditUtil(current, feature);
		this.ownedRule.setInput(ownedRuleEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateOwnedRule(EObject newValue)
	 */
	public void updateOwnedRule(EObject newValue) {
		if(ownedRuleEditUtil != null) {
			ownedRuleEditUtil.reinit(newValue);
			ownedRule.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterOwnedRule(ViewerFilter filter)
	 */
	public void addFilterToOwnedRule(ViewerFilter filter) {
		ownedRuleFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterOwnedRule(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedRule(ViewerFilter filter) {
		ownedRuleBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInOwnedRuleTable(EObject element)
	 */
	public boolean isContainedInOwnedRuleTable(EObject element) {
		return ownedRuleEditUtil.contains(element);
	}

	public void setMessageForOwnedRule(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedRule() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#setIsLeaf(Boolean newValue)
	 */
	public void setIsLeaf(Boolean newValue) {
		if(newValue != null) {
			isLeaf.setSelection(newValue.booleanValue());
		} else {
			isLeaf.setSelection(false);
		}
	}

	public void setMessageForIsLeaf(String msg, int msgLevel) {

	}

	public void unsetMessageForIsLeaf() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getTemplateBindingToAdd()
	 */
	public List getTemplateBindingToAdd() {
		return templateBindingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getTemplateBindingToRemove()
	 */
	public List getTemplateBindingToRemove() {
		return templateBindingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getTemplateBindingToEdit()
	 */
	public Map getTemplateBindingToEdit() {
		return templateBindingEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getTemplateBindingToMove()
	 */
	public List getTemplateBindingToMove() {
		return templateBindingEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getTemplateBindingTable()
	 */
	public List getTemplateBindingTable() {
		return templateBindingEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initTemplateBinding(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initTemplateBinding(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			templateBindingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			templateBindingEditUtil = new EMFListEditUtil(current, feature);
		this.templateBinding.setInput(templateBindingEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateTemplateBinding(EObject newValue)
	 */
	public void updateTemplateBinding(EObject newValue) {
		if(templateBindingEditUtil != null) {
			templateBindingEditUtil.reinit(newValue);
			templateBinding.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterTemplateBinding(ViewerFilter filter)
	 */
	public void addFilterToTemplateBinding(ViewerFilter filter) {
		templateBindingFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterTemplateBinding(ViewerFilter filter)
	 */
	public void addBusinessFilterToTemplateBinding(ViewerFilter filter) {
		templateBindingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInTemplateBindingTable(EObject element)
	 */
	public boolean isContainedInTemplateBindingTable(EObject element) {
		return templateBindingEditUtil.contains(element);
	}

	public void setMessageForTemplateBinding(String msg, int msgLevel) {

	}

	public void unsetMessageForTemplateBinding() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getIsAbstract()
	 */
	public Boolean getIsAbstract() {
		return Boolean.valueOf(isAbstract.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#setIsAbstract(Boolean newValue)
	 */
	public void setIsAbstract(Boolean newValue) {
		if(newValue != null) {
			isAbstract.setSelection(newValue.booleanValue());
		} else {
			isAbstract.setSelection(false);
		}
	}

	public void setMessageForIsAbstract(String msg, int msgLevel) {

	}

	public void unsetMessageForIsAbstract() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getGeneralizationToAdd()
	 */
	public List getGeneralizationToAdd() {
		return generalizationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getGeneralizationToRemove()
	 */
	public List getGeneralizationToRemove() {
		return generalizationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getGeneralizationToEdit()
	 */
	public Map getGeneralizationToEdit() {
		return generalizationEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getGeneralizationToMove()
	 */
	public List getGeneralizationToMove() {
		return generalizationEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getGeneralizationTable()
	 */
	public List getGeneralizationTable() {
		return generalizationEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initGeneralization(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initGeneralization(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			generalizationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			generalizationEditUtil = new EMFListEditUtil(current, feature);
		this.generalization.setInput(generalizationEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateGeneralization(EObject newValue)
	 */
	public void updateGeneralization(EObject newValue) {
		if(generalizationEditUtil != null) {
			generalizationEditUtil.reinit(newValue);
			generalization.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterGeneralization(ViewerFilter filter)
	 */
	public void addFilterToGeneralization(ViewerFilter filter) {
		generalizationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterGeneralization(ViewerFilter filter)
	 */
	public void addBusinessFilterToGeneralization(ViewerFilter filter) {
		generalizationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInGeneralizationTable(EObject element)
	 */
	public boolean isContainedInGeneralizationTable(EObject element) {
		return generalizationEditUtil.contains(element);
	}

	public void setMessageForGeneralization(String msg, int msgLevel) {

	}

	public void unsetMessageForGeneralization() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getPowertypeExtentToAdd()
	 */
	public List getPowertypeExtentToAdd() {
		return powertypeExtentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getPowertypeExtentToRemove()
	 */
	public List getPowertypeExtentToRemove() {
		return powertypeExtentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getPowertypeExtentTable()
	 */
	public List getPowertypeExtentTable() {
		return powertypeExtentEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initPowertypeExtent(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initPowertypeExtent(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			powertypeExtentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			powertypeExtentEditUtil = new EMFListEditUtil(current, feature);
		this.powertypeExtent.setInput(powertypeExtentEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updatePowertypeExtent(EObject newValue)
	 */
	public void updatePowertypeExtent(EObject newValue) {
		if(powertypeExtentEditUtil != null) {
			powertypeExtentEditUtil.reinit(newValue);
			powertypeExtent.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterPowertypeExtent(ViewerFilter filter)
	 */
	public void addFilterToPowertypeExtent(ViewerFilter filter) {
		powertypeExtentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterPowertypeExtent(ViewerFilter filter)
	 */
	public void addBusinessFilterToPowertypeExtent(ViewerFilter filter) {
		powertypeExtentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInPowertypeExtentTable(EObject element)
	 */
	public boolean isContainedInPowertypeExtentTable(EObject element) {
		return powertypeExtentEditUtil.contains(element);
	}

	public void setMessageForPowertypeExtent(String msg, int msgLevel) {

	}

	public void unsetMessageForPowertypeExtent() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getRedefinedClassifierToAdd()
	 */
	public List getRedefinedClassifierToAdd() {
		return redefinedClassifierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getRedefinedClassifierToRemove()
	 */
	public List getRedefinedClassifierToRemove() {
		return redefinedClassifierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getRedefinedClassifierTable()
	 */
	public List getRedefinedClassifierTable() {
		return redefinedClassifierEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initRedefinedClassifier(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initRedefinedClassifier(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			redefinedClassifierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			redefinedClassifierEditUtil = new EMFListEditUtil(current, feature);
		this.redefinedClassifier.setInput(redefinedClassifierEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateRedefinedClassifier(EObject newValue)
	 */
	public void updateRedefinedClassifier(EObject newValue) {
		if(redefinedClassifierEditUtil != null) {
			redefinedClassifierEditUtil.reinit(newValue);
			redefinedClassifier.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterRedefinedClassifier(ViewerFilter filter)
	 */
	public void addFilterToRedefinedClassifier(ViewerFilter filter) {
		redefinedClassifierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterRedefinedClassifier(ViewerFilter filter)
	 */
	public void addBusinessFilterToRedefinedClassifier(ViewerFilter filter) {
		redefinedClassifierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInRedefinedClassifierTable(EObject element)
	 */
	public boolean isContainedInRedefinedClassifierTable(EObject element) {
		return redefinedClassifierEditUtil.contains(element);
	}

	public void setMessageForRedefinedClassifier(String msg, int msgLevel) {

	}

	public void unsetMessageForRedefinedClassifier() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getSubstitutionToAdd()
	 */
	public List getSubstitutionToAdd() {
		return substitutionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getSubstitutionToRemove()
	 */
	public List getSubstitutionToRemove() {
		return substitutionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getSubstitutionToEdit()
	 */
	public Map getSubstitutionToEdit() {
		return substitutionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getSubstitutionToMove()
	 */
	public List getSubstitutionToMove() {
		return substitutionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getSubstitutionTable()
	 */
	public List getSubstitutionTable() {
		return substitutionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initSubstitution(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initSubstitution(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			substitutionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			substitutionEditUtil = new EMFListEditUtil(current, feature);
		this.substitution.setInput(substitutionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateSubstitution(EObject newValue)
	 */
	public void updateSubstitution(EObject newValue) {
		if(substitutionEditUtil != null) {
			substitutionEditUtil.reinit(newValue);
			substitution.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterSubstitution(ViewerFilter filter)
	 */
	public void addFilterToSubstitution(ViewerFilter filter) {
		substitutionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterSubstitution(ViewerFilter filter)
	 */
	public void addBusinessFilterToSubstitution(ViewerFilter filter) {
		substitutionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInSubstitutionTable(EObject element)
	 */
	public boolean isContainedInSubstitutionTable(EObject element) {
		return substitutionEditUtil.contains(element);
	}

	public void setMessageForSubstitution(String msg, int msgLevel) {

	}

	public void unsetMessageForSubstitution() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getCollaborationUseToAdd()
	 */
	public List getCollaborationUseToAdd() {
		return collaborationUseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getCollaborationUseToRemove()
	 */
	public List getCollaborationUseToRemove() {
		return collaborationUseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getCollaborationUseToEdit()
	 */
	public Map getCollaborationUseToEdit() {
		return collaborationUseEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getCollaborationUseToMove()
	 */
	public List getCollaborationUseToMove() {
		return collaborationUseEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getCollaborationUseTable()
	 */
	public List getCollaborationUseTable() {
		return collaborationUseEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initCollaborationUse(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initCollaborationUse(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			collaborationUseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			collaborationUseEditUtil = new EMFListEditUtil(current, feature);
		this.collaborationUse.setInput(collaborationUseEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateCollaborationUse(EObject newValue)
	 */
	public void updateCollaborationUse(EObject newValue) {
		if(collaborationUseEditUtil != null) {
			collaborationUseEditUtil.reinit(newValue);
			collaborationUse.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterCollaborationUse(ViewerFilter filter)
	 */
	public void addFilterToCollaborationUse(ViewerFilter filter) {
		collaborationUseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterCollaborationUse(ViewerFilter filter)
	 */
	public void addBusinessFilterToCollaborationUse(ViewerFilter filter) {
		collaborationUseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInCollaborationUseTable(EObject element)
	 */
	public boolean isContainedInCollaborationUseTable(EObject element) {
		return collaborationUseEditUtil.contains(element);
	}

	public void setMessageForCollaborationUse(String msg, int msgLevel) {

	}

	public void unsetMessageForCollaborationUse() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedUseCaseToAdd()
	 */
	public List getOwnedUseCaseToAdd() {
		return ownedUseCaseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedUseCaseToRemove()
	 */
	public List getOwnedUseCaseToRemove() {
		return ownedUseCaseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedUseCaseToEdit()
	 */
	public Map getOwnedUseCaseToEdit() {
		return ownedUseCaseEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedUseCaseToMove()
	 */
	public List getOwnedUseCaseToMove() {
		return ownedUseCaseEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedUseCaseTable()
	 */
	public List getOwnedUseCaseTable() {
		return ownedUseCaseEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initOwnedUseCase(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedUseCase(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedUseCaseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedUseCaseEditUtil = new EMFListEditUtil(current, feature);
		this.ownedUseCase.setInput(ownedUseCaseEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateOwnedUseCase(EObject newValue)
	 */
	public void updateOwnedUseCase(EObject newValue) {
		if(ownedUseCaseEditUtil != null) {
			ownedUseCaseEditUtil.reinit(newValue);
			ownedUseCase.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterOwnedUseCase(ViewerFilter filter)
	 */
	public void addFilterToOwnedUseCase(ViewerFilter filter) {
		ownedUseCaseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterOwnedUseCase(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedUseCase(ViewerFilter filter) {
		ownedUseCaseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInOwnedUseCaseTable(EObject element)
	 */
	public boolean isContainedInOwnedUseCaseTable(EObject element) {
		return ownedUseCaseEditUtil.contains(element);
	}

	public void setMessageForOwnedUseCase(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedUseCase() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getUseCaseToAdd()
	 */
	public List getUseCaseToAdd() {
		return useCaseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getUseCaseToRemove()
	 */
	public List getUseCaseToRemove() {
		return useCaseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getUseCaseTable()
	 */
	public List getUseCaseTable() {
		return useCaseEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initUseCase(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initUseCase(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			useCaseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			useCaseEditUtil = new EMFListEditUtil(current, feature);
		this.useCase.setInput(useCaseEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateUseCase(EObject newValue)
	 */
	public void updateUseCase(EObject newValue) {
		if(useCaseEditUtil != null) {
			useCaseEditUtil.reinit(newValue);
			useCase.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterUseCase(ViewerFilter filter)
	 */
	public void addFilterToUseCase(ViewerFilter filter) {
		useCaseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterUseCase(ViewerFilter filter)
	 */
	public void addBusinessFilterToUseCase(ViewerFilter filter) {
		useCaseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInUseCaseTable(EObject element)
	 */
	public boolean isContainedInUseCaseTable(EObject element) {
		return useCaseEditUtil.contains(element);
	}

	public void setMessageForUseCase(String msg, int msgLevel) {

	}

	public void unsetMessageForUseCase() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedBehaviorToAdd()
	 */
	public List getOwnedBehaviorToAdd() {
		return ownedBehaviorEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedBehaviorToRemove()
	 */
	public List getOwnedBehaviorToRemove() {
		return ownedBehaviorEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedBehaviorToEdit()
	 */
	public Map getOwnedBehaviorToEdit() {
		return ownedBehaviorEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedBehaviorToMove()
	 */
	public List getOwnedBehaviorToMove() {
		return ownedBehaviorEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedBehaviorTable()
	 */
	public List getOwnedBehaviorTable() {
		return ownedBehaviorEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initOwnedBehavior(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedBehavior(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedBehaviorEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedBehaviorEditUtil = new EMFListEditUtil(current, feature);
		this.ownedBehavior.setInput(ownedBehaviorEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateOwnedBehavior(EObject newValue)
	 */
	public void updateOwnedBehavior(EObject newValue) {
		if(ownedBehaviorEditUtil != null) {
			ownedBehaviorEditUtil.reinit(newValue);
			ownedBehavior.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterOwnedBehavior(ViewerFilter filter)
	 */
	public void addFilterToOwnedBehavior(ViewerFilter filter) {
		ownedBehaviorFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterOwnedBehavior(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedBehavior(ViewerFilter filter) {
		ownedBehaviorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInOwnedBehaviorTable(EObject element)
	 */
	public boolean isContainedInOwnedBehaviorTable(EObject element) {
		return ownedBehaviorEditUtil.contains(element);
	}

	public void setMessageForOwnedBehavior(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedBehavior() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getInterfaceRealizationToAdd()
	 */
	public List getInterfaceRealizationToAdd() {
		return interfaceRealizationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getInterfaceRealizationToRemove()
	 */
	public List getInterfaceRealizationToRemove() {
		return interfaceRealizationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getInterfaceRealizationToEdit()
	 */
	public Map getInterfaceRealizationToEdit() {
		return interfaceRealizationEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getInterfaceRealizationToMove()
	 */
	public List getInterfaceRealizationToMove() {
		return interfaceRealizationEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getInterfaceRealizationTable()
	 */
	public List getInterfaceRealizationTable() {
		return interfaceRealizationEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initInterfaceRealization(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initInterfaceRealization(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			interfaceRealizationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			interfaceRealizationEditUtil = new EMFListEditUtil(current, feature);
		this.interfaceRealization.setInput(interfaceRealizationEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateInterfaceRealization(EObject newValue)
	 */
	public void updateInterfaceRealization(EObject newValue) {
		if(interfaceRealizationEditUtil != null) {
			interfaceRealizationEditUtil.reinit(newValue);
			interfaceRealization.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterInterfaceRealization(ViewerFilter filter)
	 */
	public void addFilterToInterfaceRealization(ViewerFilter filter) {
		interfaceRealizationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterInterfaceRealization(ViewerFilter filter)
	 */
	public void addBusinessFilterToInterfaceRealization(ViewerFilter filter) {
		interfaceRealizationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInInterfaceRealizationTable(EObject element)
	 */
	public boolean isContainedInInterfaceRealizationTable(EObject element) {
		return interfaceRealizationEditUtil.contains(element);
	}

	public void setMessageForInterfaceRealization(String msg, int msgLevel) {

	}

	public void unsetMessageForInterfaceRealization() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedTriggerToAdd()
	 */
	public List getOwnedTriggerToAdd() {
		return ownedTriggerEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedTriggerToRemove()
	 */
	public List getOwnedTriggerToRemove() {
		return ownedTriggerEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedTriggerToEdit()
	 */
	public Map getOwnedTriggerToEdit() {
		return ownedTriggerEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedTriggerToMove()
	 */
	public List getOwnedTriggerToMove() {
		return ownedTriggerEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getOwnedTriggerTable()
	 */
	public List getOwnedTriggerTable() {
		return ownedTriggerEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initOwnedTrigger(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedTrigger(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedTriggerEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedTriggerEditUtil = new EMFListEditUtil(current, feature);
		this.ownedTrigger.setInput(ownedTriggerEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateOwnedTrigger(EObject newValue)
	 */
	public void updateOwnedTrigger(EObject newValue) {
		if(ownedTriggerEditUtil != null) {
			ownedTriggerEditUtil.reinit(newValue);
			ownedTrigger.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterOwnedTrigger(ViewerFilter filter)
	 */
	public void addFilterToOwnedTrigger(ViewerFilter filter) {
		ownedTriggerFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterOwnedTrigger(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedTrigger(ViewerFilter filter) {
		ownedTriggerBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInOwnedTriggerTable(EObject element)
	 */
	public boolean isContainedInOwnedTriggerTable(EObject element) {
		return ownedTriggerEditUtil.contains(element);
	}

	public void setMessageForOwnedTrigger(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedTrigger() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getIncludeToAdd()
	 */
	public List getIncludeToAdd() {
		return includeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getIncludeToRemove()
	 */
	public List getIncludeToRemove() {
		return includeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getIncludeToEdit()
	 */
	public Map getIncludeToEdit() {
		return includeEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getIncludeToMove()
	 */
	public List getIncludeToMove() {
		return includeEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getIncludeTable()
	 */
	public List getIncludeTable() {
		return includeEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initInclude(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initInclude(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			includeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			includeEditUtil = new EMFListEditUtil(current, feature);
		this.include.setInput(includeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateInclude(EObject newValue)
	 */
	public void updateInclude(EObject newValue) {
		if(includeEditUtil != null) {
			includeEditUtil.reinit(newValue);
			include.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterInclude(ViewerFilter filter)
	 */
	public void addFilterToInclude(ViewerFilter filter) {
		includeFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterInclude(ViewerFilter filter)
	 */
	public void addBusinessFilterToInclude(ViewerFilter filter) {
		includeBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInIncludeTable(EObject element)
	 */
	public boolean isContainedInIncludeTable(EObject element) {
		return includeEditUtil.contains(element);
	}

	public void setMessageForInclude(String msg, int msgLevel) {

	}

	public void unsetMessageForInclude() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtendToAdd()
	 */
	public List getExtendToAdd() {
		return extendEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtendToRemove()
	 */
	public List getExtendToRemove() {
		return extendEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtendToEdit()
	 */
	public Map getExtendToEdit() {
		return extendEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtendToMove()
	 */
	public List getExtendToMove() {
		return extendEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtendTable()
	 */
	public List getExtendTable() {
		return extendEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initExtend(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initExtend(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			extendEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			extendEditUtil = new EMFListEditUtil(current, feature);
		this.extend.setInput(extendEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateExtend(EObject newValue)
	 */
	public void updateExtend(EObject newValue) {
		if(extendEditUtil != null) {
			extendEditUtil.reinit(newValue);
			extend.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterExtend(ViewerFilter filter)
	 */
	public void addFilterToExtend(ViewerFilter filter) {
		extendFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterExtend(ViewerFilter filter)
	 */
	public void addBusinessFilterToExtend(ViewerFilter filter) {
		extendBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInExtendTable(EObject element)
	 */
	public boolean isContainedInExtendTable(EObject element) {
		return extendEditUtil.contains(element);
	}

	public void setMessageForExtend(String msg, int msgLevel) {

	}

	public void unsetMessageForExtend() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtensionPointToAdd()
	 */
	public List getExtensionPointToAdd() {
		return extensionPointEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtensionPointToRemove()
	 */
	public List getExtensionPointToRemove() {
		return extensionPointEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtensionPointToEdit()
	 */
	public Map getExtensionPointToEdit() {
		return extensionPointEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtensionPointToMove()
	 */
	public List getExtensionPointToMove() {
		return extensionPointEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getExtensionPointTable()
	 */
	public List getExtensionPointTable() {
		return extensionPointEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initExtensionPoint(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initExtensionPoint(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			extensionPointEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			extensionPointEditUtil = new EMFListEditUtil(current, feature);
		this.extensionPoint.setInput(extensionPointEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateExtensionPoint(EObject newValue)
	 */
	public void updateExtensionPoint(EObject newValue) {
		if(extensionPointEditUtil != null) {
			extensionPointEditUtil.reinit(newValue);
			extensionPoint.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterExtensionPoint(ViewerFilter filter)
	 */
	public void addFilterToExtensionPoint(ViewerFilter filter) {
		extensionPointFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterExtensionPoint(ViewerFilter filter)
	 */
	public void addBusinessFilterToExtensionPoint(ViewerFilter filter) {
		extensionPointBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInExtensionPointTable(EObject element)
	 */
	public boolean isContainedInExtensionPointTable(EObject element) {
		return extensionPointEditUtil.contains(element);
	}

	public void setMessageForExtensionPoint(String msg, int msgLevel) {

	}

	public void unsetMessageForExtensionPoint() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getSubjectToAdd()
	 */
	public List getSubjectToAdd() {
		return subjectEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getSubjectToRemove()
	 */
	public List getSubjectToRemove() {
		return subjectEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#getSubjectTable()
	 */
	public List getSubjectTable() {
		return subjectEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#initSubject(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initSubject(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			subjectEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			subjectEditUtil = new EMFListEditUtil(current, feature);
		this.subject.setInput(subjectEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#updateSubject(EObject newValue)
	 */
	public void updateSubject(EObject newValue) {
		if(subjectEditUtil != null) {
			subjectEditUtil.reinit(newValue);
			subject.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addFilterSubject(ViewerFilter filter)
	 */
	public void addFilterToSubject(ViewerFilter filter) {
		subjectFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#addBusinessFilterSubject(ViewerFilter filter)
	 */
	public void addBusinessFilterToSubject(ViewerFilter filter) {
		subjectBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.UseCasePropertiesEditionPart#isContainedInSubjectTable(EObject element)
	 */
	public boolean isContainedInSubjectTable(EObject element) {
		return subjectEditUtil.contains(element);
	}

	public void setMessageForSubject(String msg, int msgLevel) {

	}

	public void unsetMessageForSubject() {

	}





	// Start of user code additional methods

	// End of user code

}
