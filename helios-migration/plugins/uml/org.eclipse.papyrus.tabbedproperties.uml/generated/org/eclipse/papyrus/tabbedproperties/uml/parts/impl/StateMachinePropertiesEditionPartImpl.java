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
import org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
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
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
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
public class StateMachinePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, StateMachinePropertiesEditionPart {

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

	protected EMFListEditUtil ownedAttributeEditUtil;

	protected ReferencesTable<? extends EObject> ownedAttribute;

	protected List<ViewerFilter> ownedAttributeBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedAttributeFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedConnectorEditUtil;

	protected ReferencesTable<? extends EObject> ownedConnector;

	protected List<ViewerFilter> ownedConnectorBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedConnectorFilters = new ArrayList<ViewerFilter>();

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

	protected EMFListEditUtil nestedClassifierEditUtil;

	protected ReferencesTable<? extends EObject> nestedClassifier;

	protected List<ViewerFilter> nestedClassifierBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> nestedClassifierFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedOperationEditUtil;

	protected ReferencesTable<? extends EObject> ownedOperation;

	protected List<ViewerFilter> ownedOperationBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedOperationFilters = new ArrayList<ViewerFilter>();

	protected Button isActive;

	protected EMFListEditUtil ownedReceptionEditUtil;

	protected ReferencesTable<? extends EObject> ownedReception;

	protected List<ViewerFilter> ownedReceptionBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedReceptionFilters = new ArrayList<ViewerFilter>();

	protected Button isReentrant;

	protected EMFListEditUtil redefinedBehaviorEditUtil;

	protected ReferencesTable<? extends EObject> redefinedBehavior;

	protected List<ViewerFilter> redefinedBehaviorBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> redefinedBehaviorFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedParameterEditUtil;

	protected ReferencesTable<? extends EObject> ownedParameter;

	protected List<ViewerFilter> ownedParameterBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedParameterFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil preconditionEditUtil;

	protected ReferencesTable<? extends EObject> precondition;

	protected List<ViewerFilter> preconditionBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> preconditionFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil postconditionEditUtil;

	protected ReferencesTable<? extends EObject> postcondition;

	protected List<ViewerFilter> postconditionBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> postconditionFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedParameterSetEditUtil;

	protected ReferencesTable<? extends EObject> ownedParameterSet;

	protected List<ViewerFilter> ownedParameterSetBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedParameterSetFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil regionEditUtil;

	protected ReferencesTable<? extends EObject> region;

	protected List<ViewerFilter> regionBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> regionFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil submachineStateEditUtil;

	protected ReferencesTable<? extends EObject> submachineState;

	protected List<ViewerFilter> submachineStateBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> submachineStateFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil connectionPointEditUtil;

	protected ReferencesTable<? extends EObject> connectionPoint;

	protected List<ViewerFilter> connectionPointBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> connectionPointFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil extendedStateMachineEditUtil;

	protected ReferencesTable<? extends EObject> extendedStateMachine;

	protected List<ViewerFilter> extendedStateMachineBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> extendedStateMachineFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public StateMachinePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(UMLMessages.StateMachinePropertiesEditionPart_PropertiesGroupLabel);
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
		createOwnedAttributeAdvancedTableComposition(propertiesGroup);
		createOwnedConnectorAdvancedTableComposition(propertiesGroup);
		createOwnedBehaviorAdvancedTableComposition(propertiesGroup);
		createInterfaceRealizationAdvancedTableComposition(propertiesGroup);
		createOwnedTriggerAdvancedTableComposition(propertiesGroup);
		createNestedClassifierAdvancedTableComposition(propertiesGroup);
		createOwnedOperationAdvancedTableComposition(propertiesGroup);
		createIsActiveCheckbox(propertiesGroup);
		createOwnedReceptionAdvancedTableComposition(propertiesGroup);
		createIsReentrantCheckbox(propertiesGroup);
		createRedefinedBehaviorAdvancedReferencesTable(propertiesGroup);
		createOwnedParameterAdvancedTableComposition(propertiesGroup);
		createPreconditionAdvancedReferencesTable(propertiesGroup);
		createPostconditionAdvancedReferencesTable(propertiesGroup);
		createOwnedParameterSetAdvancedTableComposition(propertiesGroup);
		createRegionAdvancedTableComposition(propertiesGroup);
		createSubmachineStateAdvancedReferencesTable(propertiesGroup);
		createConnectionPointAdvancedTableComposition(propertiesGroup);
		createExtendedStateMachineAdvancedReferencesTable(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentAdvancedTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.StateMachinePropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedComment, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedComment,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedComment,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedComment,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.StateMachinePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.StateMachine.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.StateMachinePropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.StateMachine.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createClientDependencyAdvancedReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.StateMachinePropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, clientDependencyFilters, clientDependencyBusinessFilters,
						"Dependency", UMLPackage.eINSTANCE.getDependency(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.clientDependency, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.clientDependency,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.clientDependency,
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
		this.elementImport = new ReferencesTable<ElementImport>(UMLMessages.StateMachinePropertiesEditionPart_ElementImportLabel, new ReferencesTableListener<ElementImport>() {

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
		this.elementImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.elementImport, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.elementImport, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.elementImport,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.elementImport,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.elementImport,
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
		this.packageImport = new ReferencesTable<PackageImport>(UMLMessages.StateMachinePropertiesEditionPart_PackageImportLabel, new ReferencesTableListener<PackageImport>() {

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
		this.packageImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.packageImport, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.packageImport, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.packageImport,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.packageImport,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.packageImport,
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
		this.ownedRule = new ReferencesTable<Constraint>(UMLMessages.StateMachinePropertiesEditionPart_OwnedRuleLabel, new ReferencesTableListener<Constraint>() {

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
		this.ownedRule.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedRule, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedRule, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedRule,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedRule,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedRule,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createIsLeafCheckbox(Composite parent) {
		isLeaf = new Button(parent, SWT.CHECK);
		isLeaf.setText(UMLMessages.StateMachinePropertiesEditionPart_IsLeafLabel);
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.isLeaf, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 */
	protected void createTemplateBindingAdvancedTableComposition(Composite parent) {
		this.templateBinding = new ReferencesTable<TemplateBinding>(UMLMessages.StateMachinePropertiesEditionPart_TemplateBindingLabel, new ReferencesTableListener<TemplateBinding>() {

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
		this.templateBinding.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.templateBinding, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.templateBinding, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.templateBinding,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.templateBinding,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.templateBinding,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createIsAbstractCheckbox(Composite parent) {
		isAbstract = new Button(parent, SWT.CHECK);
		isAbstract.setText(UMLMessages.StateMachinePropertiesEditionPart_IsAbstractLabel);
		GridData isAbstractData = new GridData(GridData.FILL_HORIZONTAL);
		isAbstractData.horizontalSpan = 2;
		isAbstract.setLayoutData(isAbstractData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.isAbstract, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 */
	protected void createGeneralizationAdvancedTableComposition(Composite parent) {
		this.generalization = new ReferencesTable<Generalization>(UMLMessages.StateMachinePropertiesEditionPart_GeneralizationLabel, new ReferencesTableListener<Generalization>() {

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
		this.generalization.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.generalization, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.generalization, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.generalization,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.generalization,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.generalization,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createPowertypeExtentAdvancedReferencesTable(Composite parent) {
		this.powertypeExtent = new ReferencesTable<GeneralizationSet>(UMLMessages.StateMachinePropertiesEditionPart_PowertypeExtentLabel, new ReferencesTableListener<GeneralizationSet>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<GeneralizationSet> dialog = new TabElementTreeSelectionDialog<GeneralizationSet>(resourceSet, powertypeExtentFilters, powertypeExtentBusinessFilters,
						"GeneralizationSet", UMLPackage.eINSTANCE.getGeneralizationSet(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!powertypeExtentEditUtil.getVirtualList().contains(elem))
								powertypeExtentEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.powertypeExtent,
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
		this.powertypeExtent.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.powertypeExtent, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.powertypeExtent, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.powertypeExtent,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.powertypeExtent,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createRedefinedClassifierAdvancedReferencesTable(Composite parent) {
		this.redefinedClassifier = new ReferencesTable<Classifier>(UMLMessages.StateMachinePropertiesEditionPart_RedefinedClassifierLabel, new ReferencesTableListener<Classifier>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, redefinedClassifierFilters, redefinedClassifierBusinessFilters,
						"Classifier", UMLPackage.eINSTANCE.getClassifier(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!redefinedClassifierEditUtil.getVirtualList().contains(elem))
								redefinedClassifierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.redefinedClassifier,
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
		this.redefinedClassifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.redefinedClassifier, UMLViewsRepository.SWT_KIND));
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.redefinedClassifier,
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
						StateMachinePropertiesEditionPartImpl.this,
						UMLViewsRepository.StateMachine.redefinedClassifier, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createSubstitutionAdvancedTableComposition(Composite parent) {
		this.substitution = new ReferencesTable<Substitution>(UMLMessages.StateMachinePropertiesEditionPart_SubstitutionLabel, new ReferencesTableListener<Substitution>() {

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
		this.substitution.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.substitution, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.substitution, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.substitution,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.substitution,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.substitution,
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
		this.collaborationUse = new ReferencesTable<CollaborationUse>(UMLMessages.StateMachinePropertiesEditionPart_CollaborationUseLabel, new ReferencesTableListener<CollaborationUse>() {

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
		this.collaborationUse.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.collaborationUse, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.collaborationUse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.collaborationUse,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.collaborationUse,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.collaborationUse,
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
		this.ownedUseCase = new ReferencesTable<UseCase>(UMLMessages.StateMachinePropertiesEditionPart_OwnedUseCaseLabel, new ReferencesTableListener<UseCase>() {

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
		this.ownedUseCase.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedUseCase, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedUseCase, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedUseCase,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedUseCase,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedUseCase,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createUseCaseAdvancedReferencesTable(Composite parent) {
		this.useCase = new ReferencesTable<UseCase>(UMLMessages.StateMachinePropertiesEditionPart_UseCaseLabel, new ReferencesTableListener<UseCase>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<UseCase> dialog = new TabElementTreeSelectionDialog<UseCase>(resourceSet, useCaseFilters, useCaseBusinessFilters,
						"UseCase", UMLPackage.eINSTANCE.getUseCase(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!useCaseEditUtil.getVirtualList().contains(elem))
								useCaseEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.useCase,
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
		this.useCase.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.useCase, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.useCase, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.useCase,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.useCase,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedAttributeAdvancedTableComposition(Composite parent) {
		this.ownedAttribute = new ReferencesTable<Property>(UMLMessages.StateMachinePropertiesEditionPart_OwnedAttributeLabel, new ReferencesTableListener<Property>() {

			public void handleAdd() {
				addToOwnedAttribute();
			}

			public void handleEdit(Property element) {
				editOwnedAttribute(element);
			}

			public void handleMove(Property element, int oldIndex, int newIndex) {
				moveOwnedAttribute(element, oldIndex, newIndex);
			}

			public void handleRemove(Property element) {
				removeFromOwnedAttribute(element);
			}

			public void navigateTo(Property element) {
			}
		});
		this.ownedAttribute.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedAttribute, UMLViewsRepository.SWT_KIND));
		this.ownedAttribute.createControls(parent);
		GridData ownedAttributeData = new GridData(GridData.FILL_HORIZONTAL);
		ownedAttributeData.horizontalSpan = 3;
		this.ownedAttribute.setLayoutData(ownedAttributeData);
	}

	/**
	 * 
	 */
	protected void moveOwnedAttribute(Property element, int oldIndex, int newIndex) {
		EObject editedElement = ownedAttributeEditUtil.foundCorrespondingEObject(element);
		ownedAttributeEditUtil.moveElement(element, oldIndex, newIndex);
		ownedAttribute.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedAttribute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedAttribute() {

		// Start of user code addToOwnedAttribute() method body
		Property eObject = UMLFactory.eINSTANCE.createProperty();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedAttributeEditUtil.addElement(propertiesEditionObject);
				ownedAttribute.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedAttribute,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedAttribute(Property element) {

		// Start of user code removeFromOwnedAttribute() method body
		EObject editedElement = ownedAttributeEditUtil.foundCorrespondingEObject(element);
		ownedAttributeEditUtil.removeElement(element);
		ownedAttribute.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedAttribute,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedAttribute(Property element) {

		// Start of user code editOwnedAttribute() method body
		EObject editedElement = ownedAttributeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedAttributeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedAttribute.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedAttribute,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedConnectorAdvancedTableComposition(Composite parent) {
		this.ownedConnector = new ReferencesTable<Connector>(UMLMessages.StateMachinePropertiesEditionPart_OwnedConnectorLabel, new ReferencesTableListener<Connector>() {

			public void handleAdd() {
				addToOwnedConnector();
			}

			public void handleEdit(Connector element) {
				editOwnedConnector(element);
			}

			public void handleMove(Connector element, int oldIndex, int newIndex) {
				moveOwnedConnector(element, oldIndex, newIndex);
			}

			public void handleRemove(Connector element) {
				removeFromOwnedConnector(element);
			}

			public void navigateTo(Connector element) {
			}
		});
		this.ownedConnector.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedConnector, UMLViewsRepository.SWT_KIND));
		this.ownedConnector.createControls(parent);
		GridData ownedConnectorData = new GridData(GridData.FILL_HORIZONTAL);
		ownedConnectorData.horizontalSpan = 3;
		this.ownedConnector.setLayoutData(ownedConnectorData);
	}

	/**
	 * 
	 */
	protected void moveOwnedConnector(Connector element, int oldIndex, int newIndex) {
		EObject editedElement = ownedConnectorEditUtil.foundCorrespondingEObject(element);
		ownedConnectorEditUtil.moveElement(element, oldIndex, newIndex);
		ownedConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedConnector() {

		// Start of user code addToOwnedConnector() method body
		Connector eObject = UMLFactory.eINSTANCE.createConnector();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedConnectorEditUtil.addElement(propertiesEditionObject);
				ownedConnector.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedConnector,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedConnector(Connector element) {

		// Start of user code removeFromOwnedConnector() method body
		EObject editedElement = ownedConnectorEditUtil.foundCorrespondingEObject(element);
		ownedConnectorEditUtil.removeElement(element);
		ownedConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedConnector,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedConnector(Connector element) {

		// Start of user code editOwnedConnector() method body
		EObject editedElement = ownedConnectorEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedConnectorEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedConnector.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedConnector,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedBehaviorAdvancedTableComposition(Composite parent) {
		this.ownedBehavior = new ReferencesTable<Behavior>(UMLMessages.StateMachinePropertiesEditionPart_OwnedBehaviorLabel, new ReferencesTableListener<Behavior>() {

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
		this.ownedBehavior.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedBehavior, UMLViewsRepository.SWT_KIND));
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedBehavior,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedBehavior,
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
		this.interfaceRealization = new ReferencesTable<InterfaceRealization>(UMLMessages.StateMachinePropertiesEditionPart_InterfaceRealizationLabel, new ReferencesTableListener<InterfaceRealization>() {

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
		this.interfaceRealization.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.interfaceRealization, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.interfaceRealization, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this,
						UMLViewsRepository.StateMachine.interfaceRealization, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.interfaceRealization,
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
						StateMachinePropertiesEditionPartImpl.this,
						UMLViewsRepository.StateMachine.interfaceRealization, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedTriggerAdvancedTableComposition(Composite parent) {
		this.ownedTrigger = new ReferencesTable<Trigger>(UMLMessages.StateMachinePropertiesEditionPart_OwnedTriggerLabel, new ReferencesTableListener<Trigger>() {

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
		this.ownedTrigger.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedTrigger, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedTrigger, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedTrigger,
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
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedTrigger,
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
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedTrigger,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createNestedClassifierAdvancedTableComposition(Composite parent) {
		this.nestedClassifier = new ReferencesTable<Classifier>(UMLMessages.StateMachinePropertiesEditionPart_NestedClassifierLabel, new ReferencesTableListener<Classifier>() {

			public void handleAdd() {
				addToNestedClassifier();
			}

			public void handleEdit(Classifier element) {
				editNestedClassifier(element);
			}

			public void handleMove(Classifier element, int oldIndex, int newIndex) {
				moveNestedClassifier(element, oldIndex, newIndex);
			}

			public void handleRemove(Classifier element) {
				removeFromNestedClassifier(element);
			}

			public void navigateTo(Classifier element) {
			}
		});
		this.nestedClassifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.nestedClassifier, UMLViewsRepository.SWT_KIND));
		this.nestedClassifier.createControls(parent);
		GridData nestedClassifierData = new GridData(GridData.FILL_HORIZONTAL);
		nestedClassifierData.horizontalSpan = 3;
		this.nestedClassifier.setLayoutData(nestedClassifierData);
	}

	/**
	 * 
	 */
	protected void moveNestedClassifier(Classifier element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void addToNestedClassifier() {

		// Start of user code addToNestedClassifier() method body
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromNestedClassifier(Classifier element) {

		// Start of user code removeFromNestedClassifier() method body
		EObject editedElement = nestedClassifierEditUtil.foundCorrespondingEObject(element);
		nestedClassifierEditUtil.removeElement(element);
		nestedClassifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.nestedClassifier,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editNestedClassifier(Classifier element) {

		// Start of user code editNestedClassifier() method body
		EObject editedElement = nestedClassifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				nestedClassifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				nestedClassifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.nestedClassifier,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedOperationAdvancedTableComposition(Composite parent) {
		this.ownedOperation = new ReferencesTable<Operation>(UMLMessages.StateMachinePropertiesEditionPart_OwnedOperationLabel, new ReferencesTableListener<Operation>() {

			public void handleAdd() {
				addToOwnedOperation();
			}

			public void handleEdit(Operation element) {
				editOwnedOperation(element);
			}

			public void handleMove(Operation element, int oldIndex, int newIndex) {
				moveOwnedOperation(element, oldIndex, newIndex);
			}

			public void handleRemove(Operation element) {
				removeFromOwnedOperation(element);
			}

			public void navigateTo(Operation element) {
			}
		});
		this.ownedOperation.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedOperation, UMLViewsRepository.SWT_KIND));
		this.ownedOperation.createControls(parent);
		GridData ownedOperationData = new GridData(GridData.FILL_HORIZONTAL);
		ownedOperationData.horizontalSpan = 3;
		this.ownedOperation.setLayoutData(ownedOperationData);
	}

	/**
	 * 
	 */
	protected void moveOwnedOperation(Operation element, int oldIndex, int newIndex) {
		EObject editedElement = ownedOperationEditUtil.foundCorrespondingEObject(element);
		ownedOperationEditUtil.moveElement(element, oldIndex, newIndex);
		ownedOperation.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedOperation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedOperation() {

		// Start of user code addToOwnedOperation() method body
		Operation eObject = UMLFactory.eINSTANCE.createOperation();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedOperationEditUtil.addElement(propertiesEditionObject);
				ownedOperation.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedOperation,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedOperation(Operation element) {

		// Start of user code removeFromOwnedOperation() method body
		EObject editedElement = ownedOperationEditUtil.foundCorrespondingEObject(element);
		ownedOperationEditUtil.removeElement(element);
		ownedOperation.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedOperation,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedOperation(Operation element) {

		// Start of user code editOwnedOperation() method body
		EObject editedElement = ownedOperationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedOperationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedOperation.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedOperation,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createIsActiveCheckbox(Composite parent) {
		isActive = new Button(parent, SWT.CHECK);
		isActive.setText(UMLMessages.StateMachinePropertiesEditionPart_IsActiveLabel);
		GridData isActiveData = new GridData(GridData.FILL_HORIZONTAL);
		isActiveData.horizontalSpan = 2;
		isActive.setLayoutData(isActiveData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.isActive, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 */
	protected void createOwnedReceptionAdvancedTableComposition(Composite parent) {
		this.ownedReception = new ReferencesTable<Reception>(UMLMessages.StateMachinePropertiesEditionPart_OwnedReceptionLabel, new ReferencesTableListener<Reception>() {

			public void handleAdd() {
				addToOwnedReception();
			}

			public void handleEdit(Reception element) {
				editOwnedReception(element);
			}

			public void handleMove(Reception element, int oldIndex, int newIndex) {
				moveOwnedReception(element, oldIndex, newIndex);
			}

			public void handleRemove(Reception element) {
				removeFromOwnedReception(element);
			}

			public void navigateTo(Reception element) {
			}
		});
		this.ownedReception.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedReception, UMLViewsRepository.SWT_KIND));
		this.ownedReception.createControls(parent);
		GridData ownedReceptionData = new GridData(GridData.FILL_HORIZONTAL);
		ownedReceptionData.horizontalSpan = 3;
		this.ownedReception.setLayoutData(ownedReceptionData);
	}

	/**
	 * 
	 */
	protected void moveOwnedReception(Reception element, int oldIndex, int newIndex) {
		EObject editedElement = ownedReceptionEditUtil.foundCorrespondingEObject(element);
		ownedReceptionEditUtil.moveElement(element, oldIndex, newIndex);
		ownedReception.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedReception, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedReception() {

		// Start of user code addToOwnedReception() method body
		Reception eObject = UMLFactory.eINSTANCE.createReception();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedReceptionEditUtil.addElement(propertiesEditionObject);
				ownedReception.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedReception,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedReception(Reception element) {

		// Start of user code removeFromOwnedReception() method body
		EObject editedElement = ownedReceptionEditUtil.foundCorrespondingEObject(element);
		ownedReceptionEditUtil.removeElement(element);
		ownedReception.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedReception,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedReception(Reception element) {

		// Start of user code editOwnedReception() method body
		EObject editedElement = ownedReceptionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedReceptionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedReception.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedReception,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createIsReentrantCheckbox(Composite parent) {
		isReentrant = new Button(parent, SWT.CHECK);
		isReentrant.setText(UMLMessages.StateMachinePropertiesEditionPart_IsReentrantLabel);
		GridData isReentrantData = new GridData(GridData.FILL_HORIZONTAL);
		isReentrantData.horizontalSpan = 2;
		isReentrant.setLayoutData(isReentrantData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.isReentrant, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createRedefinedBehaviorAdvancedReferencesTable(Composite parent) {
		this.redefinedBehavior = new ReferencesTable<Behavior>(UMLMessages.StateMachinePropertiesEditionPart_RedefinedBehaviorLabel, new ReferencesTableListener<Behavior>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Behavior> dialog = new TabElementTreeSelectionDialog<Behavior>(resourceSet, redefinedBehaviorFilters, redefinedBehaviorBusinessFilters,
						"Behavior", UMLPackage.eINSTANCE.getBehavior(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!redefinedBehaviorEditUtil.getVirtualList().contains(elem))
								redefinedBehaviorEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.redefinedBehavior,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						redefinedBehavior.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Behavior element) {
				editRedefinedBehavior(element);
			}

			public void handleMove(Behavior element, int oldIndex, int newIndex) {
				moveRedefinedBehavior(element, oldIndex, newIndex);
			}

			public void handleRemove(Behavior element) {
				removeFromRedefinedBehavior(element);
			}

			public void navigateTo(Behavior element) {
			}
		});
		this.redefinedBehavior.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.redefinedBehavior, UMLViewsRepository.SWT_KIND));
		this.redefinedBehavior.createControls(parent);
		GridData redefinedBehaviorData = new GridData(GridData.FILL_HORIZONTAL);
		redefinedBehaviorData.horizontalSpan = 3;
		this.redefinedBehavior.setLayoutData(redefinedBehaviorData);
		this.redefinedBehavior.disableMove();
	}

	/**
	 * 
	 */
	protected void moveRedefinedBehavior(Behavior element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromRedefinedBehavior(Behavior element) {

		// Start of user code removeFromRedefinedBehavior() method body
		EObject editedElement = redefinedBehaviorEditUtil.foundCorrespondingEObject(element);
		redefinedBehaviorEditUtil.removeElement(element);
		redefinedBehavior.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.redefinedBehavior,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRedefinedBehavior(Behavior element) {

		// Start of user code editRedefinedBehavior() method body
		EObject editedElement = redefinedBehaviorEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				redefinedBehaviorEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				redefinedBehavior.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.redefinedBehavior,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedParameterAdvancedTableComposition(Composite parent) {
		this.ownedParameter = new ReferencesTable<Parameter>(UMLMessages.StateMachinePropertiesEditionPart_OwnedParameterLabel, new ReferencesTableListener<Parameter>() {

			public void handleAdd() {
				addToOwnedParameter();
			}

			public void handleEdit(Parameter element) {
				editOwnedParameter(element);
			}

			public void handleMove(Parameter element, int oldIndex, int newIndex) {
				moveOwnedParameter(element, oldIndex, newIndex);
			}

			public void handleRemove(Parameter element) {
				removeFromOwnedParameter(element);
			}

			public void navigateTo(Parameter element) {
			}
		});
		this.ownedParameter.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedParameter, UMLViewsRepository.SWT_KIND));
		this.ownedParameter.createControls(parent);
		GridData ownedParameterData = new GridData(GridData.FILL_HORIZONTAL);
		ownedParameterData.horizontalSpan = 3;
		this.ownedParameter.setLayoutData(ownedParameterData);
	}

	/**
	 * 
	 */
	protected void moveOwnedParameter(Parameter element, int oldIndex, int newIndex) {
		EObject editedElement = ownedParameterEditUtil.foundCorrespondingEObject(element);
		ownedParameterEditUtil.moveElement(element, oldIndex, newIndex);
		ownedParameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedParameter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedParameter() {

		// Start of user code addToOwnedParameter() method body
		Parameter eObject = UMLFactory.eINSTANCE.createParameter();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedParameterEditUtil.addElement(propertiesEditionObject);
				ownedParameter.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedParameter,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedParameter(Parameter element) {

		// Start of user code removeFromOwnedParameter() method body
		EObject editedElement = ownedParameterEditUtil.foundCorrespondingEObject(element);
		ownedParameterEditUtil.removeElement(element);
		ownedParameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedParameter,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedParameter(Parameter element) {

		// Start of user code editOwnedParameter() method body
		EObject editedElement = ownedParameterEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedParameterEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedParameter.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedParameter,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createPreconditionAdvancedReferencesTable(Composite parent) {
		this.precondition = new ReferencesTable<Constraint>(UMLMessages.StateMachinePropertiesEditionPart_PreconditionLabel, new ReferencesTableListener<Constraint>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Constraint> dialog = new TabElementTreeSelectionDialog<Constraint>(resourceSet, preconditionFilters, preconditionBusinessFilters,
						"Constraint", UMLPackage.eINSTANCE.getConstraint(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!preconditionEditUtil.getVirtualList().contains(elem))
								preconditionEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.precondition,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						precondition.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Constraint element) {
				editPrecondition(element);
			}

			public void handleMove(Constraint element, int oldIndex, int newIndex) {
				movePrecondition(element, oldIndex, newIndex);
			}

			public void handleRemove(Constraint element) {
				removeFromPrecondition(element);
			}

			public void navigateTo(Constraint element) {
			}
		});
		this.precondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.precondition, UMLViewsRepository.SWT_KIND));
		this.precondition.createControls(parent);
		GridData preconditionData = new GridData(GridData.FILL_HORIZONTAL);
		preconditionData.horizontalSpan = 3;
		this.precondition.setLayoutData(preconditionData);
		this.precondition.disableMove();
	}

	/**
	 * 
	 */
	protected void movePrecondition(Constraint element, int oldIndex, int newIndex) {
		EObject editedElement = preconditionEditUtil.foundCorrespondingEObject(element);
		preconditionEditUtil.moveElement(element, oldIndex, newIndex);
		precondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.precondition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromPrecondition(Constraint element) {

		// Start of user code removeFromPrecondition() method body
		EObject editedElement = preconditionEditUtil.foundCorrespondingEObject(element);
		preconditionEditUtil.removeElement(element);
		precondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.precondition,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editPrecondition(Constraint element) {

		// Start of user code editPrecondition() method body
		EObject editedElement = preconditionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				preconditionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				precondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.precondition,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createPostconditionAdvancedReferencesTable(Composite parent) {
		this.postcondition = new ReferencesTable<Constraint>(UMLMessages.StateMachinePropertiesEditionPart_PostconditionLabel, new ReferencesTableListener<Constraint>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Constraint> dialog = new TabElementTreeSelectionDialog<Constraint>(resourceSet, postconditionFilters, postconditionBusinessFilters,
						"Constraint", UMLPackage.eINSTANCE.getConstraint(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!postconditionEditUtil.getVirtualList().contains(elem))
								postconditionEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.postcondition,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						postcondition.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Constraint element) {
				editPostcondition(element);
			}

			public void handleMove(Constraint element, int oldIndex, int newIndex) {
				movePostcondition(element, oldIndex, newIndex);
			}

			public void handleRemove(Constraint element) {
				removeFromPostcondition(element);
			}

			public void navigateTo(Constraint element) {
			}
		});
		this.postcondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.postcondition, UMLViewsRepository.SWT_KIND));
		this.postcondition.createControls(parent);
		GridData postconditionData = new GridData(GridData.FILL_HORIZONTAL);
		postconditionData.horizontalSpan = 3;
		this.postcondition.setLayoutData(postconditionData);
		this.postcondition.disableMove();
	}

	/**
	 * 
	 */
	protected void movePostcondition(Constraint element, int oldIndex, int newIndex) {
		EObject editedElement = postconditionEditUtil.foundCorrespondingEObject(element);
		postconditionEditUtil.moveElement(element, oldIndex, newIndex);
		postcondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.postcondition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromPostcondition(Constraint element) {

		// Start of user code removeFromPostcondition() method body
		EObject editedElement = postconditionEditUtil.foundCorrespondingEObject(element);
		postconditionEditUtil.removeElement(element);
		postcondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.postcondition,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editPostcondition(Constraint element) {

		// Start of user code editPostcondition() method body
		EObject editedElement = postconditionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				postconditionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				postcondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.postcondition,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedParameterSetAdvancedTableComposition(Composite parent) {
		this.ownedParameterSet = new ReferencesTable<ParameterSet>(UMLMessages.StateMachinePropertiesEditionPart_OwnedParameterSetLabel, new ReferencesTableListener<ParameterSet>() {

			public void handleAdd() {
				addToOwnedParameterSet();
			}

			public void handleEdit(ParameterSet element) {
				editOwnedParameterSet(element);
			}

			public void handleMove(ParameterSet element, int oldIndex, int newIndex) {
				moveOwnedParameterSet(element, oldIndex, newIndex);
			}

			public void handleRemove(ParameterSet element) {
				removeFromOwnedParameterSet(element);
			}

			public void navigateTo(ParameterSet element) {
			}
		});
		this.ownedParameterSet.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.ownedParameterSet, UMLViewsRepository.SWT_KIND));
		this.ownedParameterSet.createControls(parent);
		GridData ownedParameterSetData = new GridData(GridData.FILL_HORIZONTAL);
		ownedParameterSetData.horizontalSpan = 3;
		this.ownedParameterSet.setLayoutData(ownedParameterSetData);
	}

	/**
	 * 
	 */
	protected void moveOwnedParameterSet(ParameterSet element, int oldIndex, int newIndex) {
		EObject editedElement = ownedParameterSetEditUtil.foundCorrespondingEObject(element);
		ownedParameterSetEditUtil.moveElement(element, oldIndex, newIndex);
		ownedParameterSet.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedParameterSet, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedParameterSet() {

		// Start of user code addToOwnedParameterSet() method body
		ParameterSet eObject = UMLFactory.eINSTANCE.createParameterSet();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedParameterSetEditUtil.addElement(propertiesEditionObject);
				ownedParameterSet.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedParameterSet,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedParameterSet(ParameterSet element) {

		// Start of user code removeFromOwnedParameterSet() method body
		EObject editedElement = ownedParameterSetEditUtil.foundCorrespondingEObject(element);
		ownedParameterSetEditUtil.removeElement(element);
		ownedParameterSet.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedParameterSet,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedParameterSet(ParameterSet element) {

		// Start of user code editOwnedParameterSet() method body
		EObject editedElement = ownedParameterSetEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedParameterSetEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedParameterSet.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.ownedParameterSet,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createRegionAdvancedTableComposition(Composite parent) {
		this.region = new ReferencesTable<Region>(UMLMessages.StateMachinePropertiesEditionPart_RegionLabel, new ReferencesTableListener<Region>() {

			public void handleAdd() {
				addToRegion();
			}

			public void handleEdit(Region element) {
				editRegion(element);
			}

			public void handleMove(Region element, int oldIndex, int newIndex) {
				moveRegion(element, oldIndex, newIndex);
			}

			public void handleRemove(Region element) {
				removeFromRegion(element);
			}

			public void navigateTo(Region element) {
			}
		});
		this.region.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.region, UMLViewsRepository.SWT_KIND));
		this.region.createControls(parent);
		GridData regionData = new GridData(GridData.FILL_HORIZONTAL);
		regionData.horizontalSpan = 3;
		this.region.setLayoutData(regionData);
	}

	/**
	 * 
	 */
	protected void moveRegion(Region element, int oldIndex, int newIndex) {
		EObject editedElement = regionEditUtil.foundCorrespondingEObject(element);
		regionEditUtil.moveElement(element, oldIndex, newIndex);
		region.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.region, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToRegion() {

		// Start of user code addToRegion() method body
		Region eObject = UMLFactory.eINSTANCE.createRegion();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				regionEditUtil.addElement(propertiesEditionObject);
				region.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.region,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromRegion(Region element) {

		// Start of user code removeFromRegion() method body
		EObject editedElement = regionEditUtil.foundCorrespondingEObject(element);
		regionEditUtil.removeElement(element);
		region.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.region,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRegion(Region element) {

		// Start of user code editRegion() method body
		EObject editedElement = regionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				regionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				region.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.region,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createSubmachineStateAdvancedReferencesTable(Composite parent) {
		this.submachineState = new ReferencesTable<State>(UMLMessages.StateMachinePropertiesEditionPart_SubmachineStateLabel, new ReferencesTableListener<State>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<State> dialog = new TabElementTreeSelectionDialog<State>(resourceSet, submachineStateFilters, submachineStateBusinessFilters,
						"State", UMLPackage.eINSTANCE.getState(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!submachineStateEditUtil.getVirtualList().contains(elem))
								submachineStateEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.submachineState,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						submachineState.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(State element) {
				editSubmachineState(element);
			}

			public void handleMove(State element, int oldIndex, int newIndex) {
				moveSubmachineState(element, oldIndex, newIndex);
			}

			public void handleRemove(State element) {
				removeFromSubmachineState(element);
			}

			public void navigateTo(State element) {
			}
		});
		this.submachineState.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.submachineState, UMLViewsRepository.SWT_KIND));
		this.submachineState.createControls(parent);
		GridData submachineStateData = new GridData(GridData.FILL_HORIZONTAL);
		submachineStateData.horizontalSpan = 3;
		this.submachineState.setLayoutData(submachineStateData);
		this.submachineState.disableMove();
	}

	/**
	 * 
	 */
	protected void moveSubmachineState(State element, int oldIndex, int newIndex) {
		EObject editedElement = submachineStateEditUtil.foundCorrespondingEObject(element);
		submachineStateEditUtil.moveElement(element, oldIndex, newIndex);
		submachineState.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.submachineState, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromSubmachineState(State element) {

		// Start of user code removeFromSubmachineState() method body
		EObject editedElement = submachineStateEditUtil.foundCorrespondingEObject(element);
		submachineStateEditUtil.removeElement(element);
		submachineState.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.submachineState,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSubmachineState(State element) {

		// Start of user code editSubmachineState() method body
		EObject editedElement = submachineStateEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				submachineStateEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				submachineState.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.submachineState,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createConnectionPointAdvancedTableComposition(Composite parent) {
		this.connectionPoint = new ReferencesTable<Pseudostate>(UMLMessages.StateMachinePropertiesEditionPart_ConnectionPointLabel, new ReferencesTableListener<Pseudostate>() {

			public void handleAdd() {
				addToConnectionPoint();
			}

			public void handleEdit(Pseudostate element) {
				editConnectionPoint(element);
			}

			public void handleMove(Pseudostate element, int oldIndex, int newIndex) {
				moveConnectionPoint(element, oldIndex, newIndex);
			}

			public void handleRemove(Pseudostate element) {
				removeFromConnectionPoint(element);
			}

			public void navigateTo(Pseudostate element) {
			}
		});
		this.connectionPoint.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.connectionPoint, UMLViewsRepository.SWT_KIND));
		this.connectionPoint.createControls(parent);
		GridData connectionPointData = new GridData(GridData.FILL_HORIZONTAL);
		connectionPointData.horizontalSpan = 3;
		this.connectionPoint.setLayoutData(connectionPointData);
	}

	/**
	 * 
	 */
	protected void moveConnectionPoint(Pseudostate element, int oldIndex, int newIndex) {
		EObject editedElement = connectionPointEditUtil.foundCorrespondingEObject(element);
		connectionPointEditUtil.moveElement(element, oldIndex, newIndex);
		connectionPoint.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.connectionPoint, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToConnectionPoint() {

		// Start of user code addToConnectionPoint() method body
		Pseudostate eObject = UMLFactory.eINSTANCE.createPseudostate();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				connectionPointEditUtil.addElement(propertiesEditionObject);
				connectionPoint.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.connectionPoint,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromConnectionPoint(Pseudostate element) {

		// Start of user code removeFromConnectionPoint() method body
		EObject editedElement = connectionPointEditUtil.foundCorrespondingEObject(element);
		connectionPointEditUtil.removeElement(element);
		connectionPoint.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.connectionPoint,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editConnectionPoint(Pseudostate element) {

		// Start of user code editConnectionPoint() method body
		EObject editedElement = connectionPointEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				connectionPointEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				connectionPoint.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.connectionPoint,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createExtendedStateMachineAdvancedReferencesTable(Composite parent) {
		this.extendedStateMachine = new ReferencesTable<StateMachine>(UMLMessages.StateMachinePropertiesEditionPart_ExtendedStateMachineLabel, new ReferencesTableListener<StateMachine>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<StateMachine> dialog = new TabElementTreeSelectionDialog<StateMachine>(resourceSet, extendedStateMachineFilters, extendedStateMachineBusinessFilters,
						"StateMachine", UMLPackage.eINSTANCE.getStateMachine(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!extendedStateMachineEditUtil.getVirtualList().contains(elem))
								extendedStateMachineEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.extendedStateMachine,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						extendedStateMachine.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(StateMachine element) {
				editExtendedStateMachine(element);
			}

			public void handleMove(StateMachine element, int oldIndex, int newIndex) {
				moveExtendedStateMachine(element, oldIndex, newIndex);
			}

			public void handleRemove(StateMachine element) {
				removeFromExtendedStateMachine(element);
			}

			public void navigateTo(StateMachine element) {
			}
		});
		this.extendedStateMachine.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.StateMachine.extendedStateMachine, UMLViewsRepository.SWT_KIND));
		this.extendedStateMachine.createControls(parent);
		GridData extendedStateMachineData = new GridData(GridData.FILL_HORIZONTAL);
		extendedStateMachineData.horizontalSpan = 3;
		this.extendedStateMachine.setLayoutData(extendedStateMachineData);
		this.extendedStateMachine.disableMove();
	}

	/**
	 * 
	 */
	protected void moveExtendedStateMachine(StateMachine element, int oldIndex, int newIndex) {
		EObject editedElement = extendedStateMachineEditUtil.foundCorrespondingEObject(element);
		extendedStateMachineEditUtil.moveElement(element, oldIndex, newIndex);
		extendedStateMachine.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.extendedStateMachine, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromExtendedStateMachine(StateMachine element) {

		// Start of user code removeFromExtendedStateMachine() method body
		EObject editedElement = extendedStateMachineEditUtil.foundCorrespondingEObject(element);
		extendedStateMachineEditUtil.removeElement(element);
		extendedStateMachine.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				StateMachinePropertiesEditionPartImpl.this, UMLViewsRepository.StateMachine.extendedStateMachine,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editExtendedStateMachine(StateMachine element) {

		// Start of user code editExtendedStateMachine() method body
		EObject editedElement = extendedStateMachineEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				extendedStateMachineEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				extendedStateMachine.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						StateMachinePropertiesEditionPartImpl.this,
						UMLViewsRepository.StateMachine.extendedStateMachine, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedComment(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getClientDependencyTable()
	 */
	public List getClientDependencyTable() {
		return clientDependencyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initClientDependency(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateClientDependency(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterClientDependency(ViewerFilter filter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter filter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInClientDependencyTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getElementImportToAdd()
	 */
	public List getElementImportToAdd() {
		return elementImportEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getElementImportToRemove()
	 */
	public List getElementImportToRemove() {
		return elementImportEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getElementImportToEdit()
	 */
	public Map getElementImportToEdit() {
		return elementImportEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getElementImportToMove()
	 */
	public List getElementImportToMove() {
		return elementImportEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getElementImportTable()
	 */
	public List getElementImportTable() {
		return elementImportEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initElementImport(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateElementImport(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterElementImport(ViewerFilter filter)
	 */
	public void addFilterToElementImport(ViewerFilter filter) {
		elementImportFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterElementImport(ViewerFilter filter)
	 */
	public void addBusinessFilterToElementImport(ViewerFilter filter) {
		elementImportBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInElementImportTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPackageImportToAdd()
	 */
	public List getPackageImportToAdd() {
		return packageImportEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPackageImportToRemove()
	 */
	public List getPackageImportToRemove() {
		return packageImportEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPackageImportToEdit()
	 */
	public Map getPackageImportToEdit() {
		return packageImportEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPackageImportToMove()
	 */
	public List getPackageImportToMove() {
		return packageImportEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPackageImportTable()
	 */
	public List getPackageImportTable() {
		return packageImportEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initPackageImport(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updatePackageImport(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterPackageImport(ViewerFilter filter)
	 */
	public void addFilterToPackageImport(ViewerFilter filter) {
		packageImportFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterPackageImport(ViewerFilter filter)
	 */
	public void addBusinessFilterToPackageImport(ViewerFilter filter) {
		packageImportBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInPackageImportTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedRuleToAdd()
	 */
	public List getOwnedRuleToAdd() {
		return ownedRuleEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedRuleToRemove()
	 */
	public List getOwnedRuleToRemove() {
		return ownedRuleEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedRuleToEdit()
	 */
	public Map getOwnedRuleToEdit() {
		return ownedRuleEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedRuleToMove()
	 */
	public List getOwnedRuleToMove() {
		return ownedRuleEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedRuleTable()
	 */
	public List getOwnedRuleTable() {
		return ownedRuleEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedRule(EObject current, EReference
	 *      containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedRule(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedRule(ViewerFilter filter)
	 */
	public void addFilterToOwnedRule(ViewerFilter filter) {
		ownedRuleFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedRule(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedRule(ViewerFilter filter) {
		ownedRuleBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedRuleTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#setIsLeaf(Boolean newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getTemplateBindingToAdd()
	 */
	public List getTemplateBindingToAdd() {
		return templateBindingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getTemplateBindingToRemove()
	 */
	public List getTemplateBindingToRemove() {
		return templateBindingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getTemplateBindingToEdit()
	 */
	public Map getTemplateBindingToEdit() {
		return templateBindingEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getTemplateBindingToMove()
	 */
	public List getTemplateBindingToMove() {
		return templateBindingEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getTemplateBindingTable()
	 */
	public List getTemplateBindingTable() {
		return templateBindingEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initTemplateBinding(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateTemplateBinding(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterTemplateBinding(ViewerFilter filter)
	 */
	public void addFilterToTemplateBinding(ViewerFilter filter) {
		templateBindingFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterTemplateBinding(ViewerFilter filter)
	 */
	public void addBusinessFilterToTemplateBinding(ViewerFilter filter) {
		templateBindingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInTemplateBindingTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getIsAbstract()
	 */
	public Boolean getIsAbstract() {
		return Boolean.valueOf(isAbstract.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#setIsAbstract(Boolean newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getGeneralizationToAdd()
	 */
	public List getGeneralizationToAdd() {
		return generalizationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getGeneralizationToRemove()
	 */
	public List getGeneralizationToRemove() {
		return generalizationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getGeneralizationToEdit()
	 */
	public Map getGeneralizationToEdit() {
		return generalizationEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getGeneralizationToMove()
	 */
	public List getGeneralizationToMove() {
		return generalizationEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getGeneralizationTable()
	 */
	public List getGeneralizationTable() {
		return generalizationEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initGeneralization(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateGeneralization(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterGeneralization(ViewerFilter filter)
	 */
	public void addFilterToGeneralization(ViewerFilter filter) {
		generalizationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterGeneralization(ViewerFilter filter)
	 */
	public void addBusinessFilterToGeneralization(ViewerFilter filter) {
		generalizationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInGeneralizationTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPowertypeExtentToAdd()
	 */
	public List getPowertypeExtentToAdd() {
		return powertypeExtentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPowertypeExtentToRemove()
	 */
	public List getPowertypeExtentToRemove() {
		return powertypeExtentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPowertypeExtentTable()
	 */
	public List getPowertypeExtentTable() {
		return powertypeExtentEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initPowertypeExtent(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updatePowertypeExtent(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterPowertypeExtent(ViewerFilter filter)
	 */
	public void addFilterToPowertypeExtent(ViewerFilter filter) {
		powertypeExtentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterPowertypeExtent(ViewerFilter filter)
	 */
	public void addBusinessFilterToPowertypeExtent(ViewerFilter filter) {
		powertypeExtentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInPowertypeExtentTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRedefinedClassifierToAdd()
	 */
	public List getRedefinedClassifierToAdd() {
		return redefinedClassifierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRedefinedClassifierToRemove()
	 */
	public List getRedefinedClassifierToRemove() {
		return redefinedClassifierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRedefinedClassifierTable()
	 */
	public List getRedefinedClassifierTable() {
		return redefinedClassifierEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initRedefinedClassifier(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateRedefinedClassifier(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterRedefinedClassifier(ViewerFilter filter)
	 */
	public void addFilterToRedefinedClassifier(ViewerFilter filter) {
		redefinedClassifierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterRedefinedClassifier(ViewerFilter filter)
	 */
	public void addBusinessFilterToRedefinedClassifier(ViewerFilter filter) {
		redefinedClassifierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInRedefinedClassifierTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getSubstitutionToAdd()
	 */
	public List getSubstitutionToAdd() {
		return substitutionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getSubstitutionToRemove()
	 */
	public List getSubstitutionToRemove() {
		return substitutionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getSubstitutionToEdit()
	 */
	public Map getSubstitutionToEdit() {
		return substitutionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getSubstitutionToMove()
	 */
	public List getSubstitutionToMove() {
		return substitutionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getSubstitutionTable()
	 */
	public List getSubstitutionTable() {
		return substitutionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initSubstitution(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateSubstitution(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterSubstitution(ViewerFilter filter)
	 */
	public void addFilterToSubstitution(ViewerFilter filter) {
		substitutionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterSubstitution(ViewerFilter filter)
	 */
	public void addBusinessFilterToSubstitution(ViewerFilter filter) {
		substitutionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInSubstitutionTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getCollaborationUseToAdd()
	 */
	public List getCollaborationUseToAdd() {
		return collaborationUseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getCollaborationUseToRemove()
	 */
	public List getCollaborationUseToRemove() {
		return collaborationUseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getCollaborationUseToEdit()
	 */
	public Map getCollaborationUseToEdit() {
		return collaborationUseEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getCollaborationUseToMove()
	 */
	public List getCollaborationUseToMove() {
		return collaborationUseEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getCollaborationUseTable()
	 */
	public List getCollaborationUseTable() {
		return collaborationUseEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initCollaborationUse(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateCollaborationUse(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterCollaborationUse(ViewerFilter filter)
	 */
	public void addFilterToCollaborationUse(ViewerFilter filter) {
		collaborationUseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterCollaborationUse(ViewerFilter filter)
	 */
	public void addBusinessFilterToCollaborationUse(ViewerFilter filter) {
		collaborationUseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInCollaborationUseTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedUseCaseToAdd()
	 */
	public List getOwnedUseCaseToAdd() {
		return ownedUseCaseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedUseCaseToRemove()
	 */
	public List getOwnedUseCaseToRemove() {
		return ownedUseCaseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedUseCaseToEdit()
	 */
	public Map getOwnedUseCaseToEdit() {
		return ownedUseCaseEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedUseCaseToMove()
	 */
	public List getOwnedUseCaseToMove() {
		return ownedUseCaseEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedUseCaseTable()
	 */
	public List getOwnedUseCaseTable() {
		return ownedUseCaseEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedUseCase(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedUseCase(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedUseCase(ViewerFilter filter)
	 */
	public void addFilterToOwnedUseCase(ViewerFilter filter) {
		ownedUseCaseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedUseCase(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedUseCase(ViewerFilter filter) {
		ownedUseCaseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedUseCaseTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getUseCaseToAdd()
	 */
	public List getUseCaseToAdd() {
		return useCaseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getUseCaseToRemove()
	 */
	public List getUseCaseToRemove() {
		return useCaseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getUseCaseTable()
	 */
	public List getUseCaseTable() {
		return useCaseEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initUseCase(EObject current, EReference
	 *      containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateUseCase(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterUseCase(ViewerFilter filter)
	 */
	public void addFilterToUseCase(ViewerFilter filter) {
		useCaseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterUseCase(ViewerFilter filter)
	 */
	public void addBusinessFilterToUseCase(ViewerFilter filter) {
		useCaseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInUseCaseTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedAttributeToAdd()
	 */
	public List getOwnedAttributeToAdd() {
		return ownedAttributeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedAttributeToRemove()
	 */
	public List getOwnedAttributeToRemove() {
		return ownedAttributeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedAttributeToEdit()
	 */
	public Map getOwnedAttributeToEdit() {
		return ownedAttributeEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedAttributeToMove()
	 */
	public List getOwnedAttributeToMove() {
		return ownedAttributeEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedAttributeTable()
	 */
	public List getOwnedAttributeTable() {
		return ownedAttributeEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedAttribute(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedAttribute(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedAttributeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedAttributeEditUtil = new EMFListEditUtil(current, feature);
		this.ownedAttribute.setInput(ownedAttributeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedAttribute(EObject newValue)
	 */
	public void updateOwnedAttribute(EObject newValue) {
		if(ownedAttributeEditUtil != null) {
			ownedAttributeEditUtil.reinit(newValue);
			ownedAttribute.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedAttribute(ViewerFilter filter)
	 */
	public void addFilterToOwnedAttribute(ViewerFilter filter) {
		ownedAttributeFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedAttribute(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedAttribute(ViewerFilter filter) {
		ownedAttributeBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedAttributeTable(EObject element)
	 */
	public boolean isContainedInOwnedAttributeTable(EObject element) {
		return ownedAttributeEditUtil.contains(element);
	}

	public void setMessageForOwnedAttribute(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedAttribute() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedConnectorToAdd()
	 */
	public List getOwnedConnectorToAdd() {
		return ownedConnectorEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedConnectorToRemove()
	 */
	public List getOwnedConnectorToRemove() {
		return ownedConnectorEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedConnectorToEdit()
	 */
	public Map getOwnedConnectorToEdit() {
		return ownedConnectorEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedConnectorToMove()
	 */
	public List getOwnedConnectorToMove() {
		return ownedConnectorEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedConnectorTable()
	 */
	public List getOwnedConnectorTable() {
		return ownedConnectorEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedConnector(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedConnector(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedConnectorEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedConnectorEditUtil = new EMFListEditUtil(current, feature);
		this.ownedConnector.setInput(ownedConnectorEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedConnector(EObject newValue)
	 */
	public void updateOwnedConnector(EObject newValue) {
		if(ownedConnectorEditUtil != null) {
			ownedConnectorEditUtil.reinit(newValue);
			ownedConnector.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedConnector(ViewerFilter filter)
	 */
	public void addFilterToOwnedConnector(ViewerFilter filter) {
		ownedConnectorFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedConnector(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedConnector(ViewerFilter filter) {
		ownedConnectorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedConnectorTable(EObject element)
	 */
	public boolean isContainedInOwnedConnectorTable(EObject element) {
		return ownedConnectorEditUtil.contains(element);
	}

	public void setMessageForOwnedConnector(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedConnector() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedBehaviorToAdd()
	 */
	public List getOwnedBehaviorToAdd() {
		return ownedBehaviorEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedBehaviorToRemove()
	 */
	public List getOwnedBehaviorToRemove() {
		return ownedBehaviorEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedBehaviorToEdit()
	 */
	public Map getOwnedBehaviorToEdit() {
		return ownedBehaviorEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedBehaviorToMove()
	 */
	public List getOwnedBehaviorToMove() {
		return ownedBehaviorEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedBehaviorTable()
	 */
	public List getOwnedBehaviorTable() {
		return ownedBehaviorEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedBehavior(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedBehavior(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedBehavior(ViewerFilter filter)
	 */
	public void addFilterToOwnedBehavior(ViewerFilter filter) {
		ownedBehaviorFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedBehavior(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedBehavior(ViewerFilter filter) {
		ownedBehaviorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedBehaviorTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getInterfaceRealizationToAdd()
	 */
	public List getInterfaceRealizationToAdd() {
		return interfaceRealizationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getInterfaceRealizationToRemove()
	 */
	public List getInterfaceRealizationToRemove() {
		return interfaceRealizationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getInterfaceRealizationToEdit()
	 */
	public Map getInterfaceRealizationToEdit() {
		return interfaceRealizationEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getInterfaceRealizationToMove()
	 */
	public List getInterfaceRealizationToMove() {
		return interfaceRealizationEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getInterfaceRealizationTable()
	 */
	public List getInterfaceRealizationTable() {
		return interfaceRealizationEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initInterfaceRealization(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateInterfaceRealization(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterInterfaceRealization(ViewerFilter filter)
	 */
	public void addFilterToInterfaceRealization(ViewerFilter filter) {
		interfaceRealizationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterInterfaceRealization(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToInterfaceRealization(ViewerFilter filter) {
		interfaceRealizationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInInterfaceRealizationTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedTriggerToAdd()
	 */
	public List getOwnedTriggerToAdd() {
		return ownedTriggerEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedTriggerToRemove()
	 */
	public List getOwnedTriggerToRemove() {
		return ownedTriggerEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedTriggerToEdit()
	 */
	public Map getOwnedTriggerToEdit() {
		return ownedTriggerEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedTriggerToMove()
	 */
	public List getOwnedTriggerToMove() {
		return ownedTriggerEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedTriggerTable()
	 */
	public List getOwnedTriggerTable() {
		return ownedTriggerEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedTrigger(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedTrigger(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedTrigger(ViewerFilter filter)
	 */
	public void addFilterToOwnedTrigger(ViewerFilter filter) {
		ownedTriggerFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedTrigger(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedTrigger(ViewerFilter filter) {
		ownedTriggerBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedTriggerTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getNestedClassifierToAdd()
	 */
	public List getNestedClassifierToAdd() {
		return nestedClassifierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getNestedClassifierToRemove()
	 */
	public List getNestedClassifierToRemove() {
		return nestedClassifierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getNestedClassifierToEdit()
	 */
	public Map getNestedClassifierToEdit() {
		return nestedClassifierEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getNestedClassifierToMove()
	 */
	public List getNestedClassifierToMove() {
		return nestedClassifierEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getNestedClassifierTable()
	 */
	public List getNestedClassifierTable() {
		return nestedClassifierEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initNestedClassifier(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initNestedClassifier(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			nestedClassifierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			nestedClassifierEditUtil = new EMFListEditUtil(current, feature);
		this.nestedClassifier.setInput(nestedClassifierEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateNestedClassifier(EObject newValue)
	 */
	public void updateNestedClassifier(EObject newValue) {
		if(nestedClassifierEditUtil != null) {
			nestedClassifierEditUtil.reinit(newValue);
			nestedClassifier.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterNestedClassifier(ViewerFilter filter)
	 */
	public void addFilterToNestedClassifier(ViewerFilter filter) {
		nestedClassifierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterNestedClassifier(ViewerFilter filter)
	 */
	public void addBusinessFilterToNestedClassifier(ViewerFilter filter) {
		nestedClassifierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInNestedClassifierTable(EObject element)
	 */
	public boolean isContainedInNestedClassifierTable(EObject element) {
		return nestedClassifierEditUtil.contains(element);
	}

	public void setMessageForNestedClassifier(String msg, int msgLevel) {

	}

	public void unsetMessageForNestedClassifier() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedOperationToAdd()
	 */
	public List getOwnedOperationToAdd() {
		return ownedOperationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedOperationToRemove()
	 */
	public List getOwnedOperationToRemove() {
		return ownedOperationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedOperationToEdit()
	 */
	public Map getOwnedOperationToEdit() {
		return ownedOperationEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedOperationToMove()
	 */
	public List getOwnedOperationToMove() {
		return ownedOperationEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedOperationTable()
	 */
	public List getOwnedOperationTable() {
		return ownedOperationEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedOperation(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedOperation(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedOperationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedOperationEditUtil = new EMFListEditUtil(current, feature);
		this.ownedOperation.setInput(ownedOperationEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedOperation(EObject newValue)
	 */
	public void updateOwnedOperation(EObject newValue) {
		if(ownedOperationEditUtil != null) {
			ownedOperationEditUtil.reinit(newValue);
			ownedOperation.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedOperation(ViewerFilter filter)
	 */
	public void addFilterToOwnedOperation(ViewerFilter filter) {
		ownedOperationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedOperation(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedOperation(ViewerFilter filter) {
		ownedOperationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedOperationTable(EObject element)
	 */
	public boolean isContainedInOwnedOperationTable(EObject element) {
		return ownedOperationEditUtil.contains(element);
	}

	public void setMessageForOwnedOperation(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedOperation() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getIsActive()
	 */
	public Boolean getIsActive() {
		return Boolean.valueOf(isActive.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#setIsActive(Boolean newValue)
	 */
	public void setIsActive(Boolean newValue) {
		if(newValue != null) {
			isActive.setSelection(newValue.booleanValue());
		} else {
			isActive.setSelection(false);
		}
	}

	public void setMessageForIsActive(String msg, int msgLevel) {

	}

	public void unsetMessageForIsActive() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedReceptionToAdd()
	 */
	public List getOwnedReceptionToAdd() {
		return ownedReceptionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedReceptionToRemove()
	 */
	public List getOwnedReceptionToRemove() {
		return ownedReceptionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedReceptionToEdit()
	 */
	public Map getOwnedReceptionToEdit() {
		return ownedReceptionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedReceptionToMove()
	 */
	public List getOwnedReceptionToMove() {
		return ownedReceptionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedReceptionTable()
	 */
	public List getOwnedReceptionTable() {
		return ownedReceptionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedReception(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedReception(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedReceptionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedReceptionEditUtil = new EMFListEditUtil(current, feature);
		this.ownedReception.setInput(ownedReceptionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedReception(EObject newValue)
	 */
	public void updateOwnedReception(EObject newValue) {
		if(ownedReceptionEditUtil != null) {
			ownedReceptionEditUtil.reinit(newValue);
			ownedReception.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedReception(ViewerFilter filter)
	 */
	public void addFilterToOwnedReception(ViewerFilter filter) {
		ownedReceptionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedReception(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedReception(ViewerFilter filter) {
		ownedReceptionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedReceptionTable(EObject element)
	 */
	public boolean isContainedInOwnedReceptionTable(EObject element) {
		return ownedReceptionEditUtil.contains(element);
	}

	public void setMessageForOwnedReception(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedReception() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getIsReentrant()
	 */
	public Boolean getIsReentrant() {
		return Boolean.valueOf(isReentrant.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#setIsReentrant(Boolean newValue)
	 */
	public void setIsReentrant(Boolean newValue) {
		if(newValue != null) {
			isReentrant.setSelection(newValue.booleanValue());
		} else {
			isReentrant.setSelection(false);
		}
	}

	public void setMessageForIsReentrant(String msg, int msgLevel) {

	}

	public void unsetMessageForIsReentrant() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRedefinedBehaviorToAdd()
	 */
	public List getRedefinedBehaviorToAdd() {
		return redefinedBehaviorEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRedefinedBehaviorToRemove()
	 */
	public List getRedefinedBehaviorToRemove() {
		return redefinedBehaviorEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRedefinedBehaviorTable()
	 */
	public List getRedefinedBehaviorTable() {
		return redefinedBehaviorEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initRedefinedBehavior(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initRedefinedBehavior(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			redefinedBehaviorEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			redefinedBehaviorEditUtil = new EMFListEditUtil(current, feature);
		this.redefinedBehavior.setInput(redefinedBehaviorEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateRedefinedBehavior(EObject newValue)
	 */
	public void updateRedefinedBehavior(EObject newValue) {
		if(redefinedBehaviorEditUtil != null) {
			redefinedBehaviorEditUtil.reinit(newValue);
			redefinedBehavior.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterRedefinedBehavior(ViewerFilter filter)
	 */
	public void addFilterToRedefinedBehavior(ViewerFilter filter) {
		redefinedBehaviorFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterRedefinedBehavior(ViewerFilter filter)
	 */
	public void addBusinessFilterToRedefinedBehavior(ViewerFilter filter) {
		redefinedBehaviorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInRedefinedBehaviorTable(EObject element)
	 */
	public boolean isContainedInRedefinedBehaviorTable(EObject element) {
		return redefinedBehaviorEditUtil.contains(element);
	}

	public void setMessageForRedefinedBehavior(String msg, int msgLevel) {

	}

	public void unsetMessageForRedefinedBehavior() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterToAdd()
	 */
	public List getOwnedParameterToAdd() {
		return ownedParameterEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterToRemove()
	 */
	public List getOwnedParameterToRemove() {
		return ownedParameterEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterToEdit()
	 */
	public Map getOwnedParameterToEdit() {
		return ownedParameterEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterToMove()
	 */
	public List getOwnedParameterToMove() {
		return ownedParameterEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterTable()
	 */
	public List getOwnedParameterTable() {
		return ownedParameterEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedParameter(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedParameter(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedParameterEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedParameterEditUtil = new EMFListEditUtil(current, feature);
		this.ownedParameter.setInput(ownedParameterEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedParameter(EObject newValue)
	 */
	public void updateOwnedParameter(EObject newValue) {
		if(ownedParameterEditUtil != null) {
			ownedParameterEditUtil.reinit(newValue);
			ownedParameter.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedParameter(ViewerFilter filter)
	 */
	public void addFilterToOwnedParameter(ViewerFilter filter) {
		ownedParameterFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedParameter(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedParameter(ViewerFilter filter) {
		ownedParameterBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedParameterTable(EObject element)
	 */
	public boolean isContainedInOwnedParameterTable(EObject element) {
		return ownedParameterEditUtil.contains(element);
	}

	public void setMessageForOwnedParameter(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedParameter() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPreconditionToAdd()
	 */
	public List getPreconditionToAdd() {
		return preconditionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPreconditionToRemove()
	 */
	public List getPreconditionToRemove() {
		return preconditionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPreconditionTable()
	 */
	public List getPreconditionTable() {
		return preconditionEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initPrecondition(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initPrecondition(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			preconditionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			preconditionEditUtil = new EMFListEditUtil(current, feature);
		this.precondition.setInput(preconditionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updatePrecondition(EObject newValue)
	 */
	public void updatePrecondition(EObject newValue) {
		if(preconditionEditUtil != null) {
			preconditionEditUtil.reinit(newValue);
			precondition.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterPrecondition(ViewerFilter filter)
	 */
	public void addFilterToPrecondition(ViewerFilter filter) {
		preconditionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterPrecondition(ViewerFilter filter)
	 */
	public void addBusinessFilterToPrecondition(ViewerFilter filter) {
		preconditionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInPreconditionTable(EObject element)
	 */
	public boolean isContainedInPreconditionTable(EObject element) {
		return preconditionEditUtil.contains(element);
	}

	public void setMessageForPrecondition(String msg, int msgLevel) {

	}

	public void unsetMessageForPrecondition() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPostconditionToAdd()
	 */
	public List getPostconditionToAdd() {
		return postconditionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPostconditionToRemove()
	 */
	public List getPostconditionToRemove() {
		return postconditionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getPostconditionTable()
	 */
	public List getPostconditionTable() {
		return postconditionEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initPostcondition(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initPostcondition(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			postconditionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			postconditionEditUtil = new EMFListEditUtil(current, feature);
		this.postcondition.setInput(postconditionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updatePostcondition(EObject newValue)
	 */
	public void updatePostcondition(EObject newValue) {
		if(postconditionEditUtil != null) {
			postconditionEditUtil.reinit(newValue);
			postcondition.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterPostcondition(ViewerFilter filter)
	 */
	public void addFilterToPostcondition(ViewerFilter filter) {
		postconditionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterPostcondition(ViewerFilter filter)
	 */
	public void addBusinessFilterToPostcondition(ViewerFilter filter) {
		postconditionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInPostconditionTable(EObject element)
	 */
	public boolean isContainedInPostconditionTable(EObject element) {
		return postconditionEditUtil.contains(element);
	}

	public void setMessageForPostcondition(String msg, int msgLevel) {

	}

	public void unsetMessageForPostcondition() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterSetToAdd()
	 */
	public List getOwnedParameterSetToAdd() {
		return ownedParameterSetEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterSetToRemove()
	 */
	public List getOwnedParameterSetToRemove() {
		return ownedParameterSetEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterSetToEdit()
	 */
	public Map getOwnedParameterSetToEdit() {
		return ownedParameterSetEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterSetToMove()
	 */
	public List getOwnedParameterSetToMove() {
		return ownedParameterSetEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getOwnedParameterSetTable()
	 */
	public List getOwnedParameterSetTable() {
		return ownedParameterSetEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initOwnedParameterSet(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedParameterSet(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedParameterSetEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedParameterSetEditUtil = new EMFListEditUtil(current, feature);
		this.ownedParameterSet.setInput(ownedParameterSetEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateOwnedParameterSet(EObject newValue)
	 */
	public void updateOwnedParameterSet(EObject newValue) {
		if(ownedParameterSetEditUtil != null) {
			ownedParameterSetEditUtil.reinit(newValue);
			ownedParameterSet.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterOwnedParameterSet(ViewerFilter filter)
	 */
	public void addFilterToOwnedParameterSet(ViewerFilter filter) {
		ownedParameterSetFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterOwnedParameterSet(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedParameterSet(ViewerFilter filter) {
		ownedParameterSetBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInOwnedParameterSetTable(EObject element)
	 */
	public boolean isContainedInOwnedParameterSetTable(EObject element) {
		return ownedParameterSetEditUtil.contains(element);
	}

	public void setMessageForOwnedParameterSet(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedParameterSet() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRegionToAdd()
	 */
	public List getRegionToAdd() {
		return regionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRegionToRemove()
	 */
	public List getRegionToRemove() {
		return regionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRegionToEdit()
	 */
	public Map getRegionToEdit() {
		return regionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRegionToMove()
	 */
	public List getRegionToMove() {
		return regionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getRegionTable()
	 */
	public List getRegionTable() {
		return regionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initRegion(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initRegion(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			regionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			regionEditUtil = new EMFListEditUtil(current, feature);
		this.region.setInput(regionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateRegion(EObject newValue)
	 */
	public void updateRegion(EObject newValue) {
		if(regionEditUtil != null) {
			regionEditUtil.reinit(newValue);
			region.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterRegion(ViewerFilter filter)
	 */
	public void addFilterToRegion(ViewerFilter filter) {
		regionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterRegion(ViewerFilter filter)
	 */
	public void addBusinessFilterToRegion(ViewerFilter filter) {
		regionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInRegionTable(EObject element)
	 */
	public boolean isContainedInRegionTable(EObject element) {
		return regionEditUtil.contains(element);
	}

	public void setMessageForRegion(String msg, int msgLevel) {

	}

	public void unsetMessageForRegion() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getSubmachineStateToAdd()
	 */
	public List getSubmachineStateToAdd() {
		return submachineStateEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getSubmachineStateToRemove()
	 */
	public List getSubmachineStateToRemove() {
		return submachineStateEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getSubmachineStateTable()
	 */
	public List getSubmachineStateTable() {
		return submachineStateEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initSubmachineState(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initSubmachineState(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			submachineStateEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			submachineStateEditUtil = new EMFListEditUtil(current, feature);
		this.submachineState.setInput(submachineStateEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateSubmachineState(EObject newValue)
	 */
	public void updateSubmachineState(EObject newValue) {
		if(submachineStateEditUtil != null) {
			submachineStateEditUtil.reinit(newValue);
			submachineState.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterSubmachineState(ViewerFilter filter)
	 */
	public void addFilterToSubmachineState(ViewerFilter filter) {
		submachineStateFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterSubmachineState(ViewerFilter filter)
	 */
	public void addBusinessFilterToSubmachineState(ViewerFilter filter) {
		submachineStateBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInSubmachineStateTable(EObject element)
	 */
	public boolean isContainedInSubmachineStateTable(EObject element) {
		return submachineStateEditUtil.contains(element);
	}

	public void setMessageForSubmachineState(String msg, int msgLevel) {

	}

	public void unsetMessageForSubmachineState() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getConnectionPointToAdd()
	 */
	public List getConnectionPointToAdd() {
		return connectionPointEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getConnectionPointToRemove()
	 */
	public List getConnectionPointToRemove() {
		return connectionPointEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getConnectionPointToEdit()
	 */
	public Map getConnectionPointToEdit() {
		return connectionPointEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getConnectionPointToMove()
	 */
	public List getConnectionPointToMove() {
		return connectionPointEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getConnectionPointTable()
	 */
	public List getConnectionPointTable() {
		return connectionPointEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initConnectionPoint(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initConnectionPoint(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			connectionPointEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			connectionPointEditUtil = new EMFListEditUtil(current, feature);
		this.connectionPoint.setInput(connectionPointEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateConnectionPoint(EObject newValue)
	 */
	public void updateConnectionPoint(EObject newValue) {
		if(connectionPointEditUtil != null) {
			connectionPointEditUtil.reinit(newValue);
			connectionPoint.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterConnectionPoint(ViewerFilter filter)
	 */
	public void addFilterToConnectionPoint(ViewerFilter filter) {
		connectionPointFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterConnectionPoint(ViewerFilter filter)
	 */
	public void addBusinessFilterToConnectionPoint(ViewerFilter filter) {
		connectionPointBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInConnectionPointTable(EObject element)
	 */
	public boolean isContainedInConnectionPointTable(EObject element) {
		return connectionPointEditUtil.contains(element);
	}

	public void setMessageForConnectionPoint(String msg, int msgLevel) {

	}

	public void unsetMessageForConnectionPoint() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getExtendedStateMachineToAdd()
	 */
	public List getExtendedStateMachineToAdd() {
		return extendedStateMachineEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getExtendedStateMachineToRemove()
	 */
	public List getExtendedStateMachineToRemove() {
		return extendedStateMachineEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#getExtendedStateMachineTable()
	 */
	public List getExtendedStateMachineTable() {
		return extendedStateMachineEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#initExtendedStateMachine(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initExtendedStateMachine(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			extendedStateMachineEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			extendedStateMachineEditUtil = new EMFListEditUtil(current, feature);
		this.extendedStateMachine.setInput(extendedStateMachineEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#updateExtendedStateMachine(EObject newValue)
	 */
	public void updateExtendedStateMachine(EObject newValue) {
		if(extendedStateMachineEditUtil != null) {
			extendedStateMachineEditUtil.reinit(newValue);
			extendedStateMachine.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addFilterExtendedStateMachine(ViewerFilter filter)
	 */
	public void addFilterToExtendedStateMachine(ViewerFilter filter) {
		extendedStateMachineFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#addBusinessFilterExtendedStateMachine(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToExtendedStateMachine(ViewerFilter filter) {
		extendedStateMachineBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.StateMachinePropertiesEditionPart#isContainedInExtendedStateMachineTable(EObject element)
	 */
	public boolean isContainedInExtendedStateMachineTable(EObject element) {
		return extendedStateMachineEditUtil.contains(element);
	}

	public void setMessageForExtendedStateMachine(String msg, int msgLevel) {

	}

	public void unsetMessageForExtendedStateMachine() {

	}





	// Start of user code additional methods

	// End of user code

}
