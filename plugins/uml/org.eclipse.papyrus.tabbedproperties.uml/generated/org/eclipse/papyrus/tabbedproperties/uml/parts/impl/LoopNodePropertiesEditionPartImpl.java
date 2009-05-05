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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.jface.viewers.StructuredSelection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import java.util.Map;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.InputPin;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;

import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class LoopNodePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, LoopNodePropertiesEditionPart {

	private EMFListEditUtil ownedCommentEditUtil;

	private ReferencesTable<?> ownedComment;

	private Text name;

	private EMFComboViewer visibility;

	private EMFListEditUtil clientDependencyEditUtil;

	private ReferencesTable<?> clientDependency;

	private Button isLeaf;

	private EMFListEditUtil outgoingEditUtil;

	private ReferencesTable<?> outgoing;

	private EMFListEditUtil incomingEditUtil;

	private ReferencesTable<?> incoming;

	private EMFListEditUtil inPartitionEditUtil;

	private ReferencesTable<?> inPartition;

	private EMFListEditUtil inInterruptibleRegionEditUtil;

	private ReferencesTable<?> inInterruptibleRegion;

	private EMFListEditUtil redefinedNodeEditUtil;

	private ReferencesTable<?> redefinedNode;

	private EMFListEditUtil handlerEditUtil;

	private ReferencesTable<?> handler;

	private EMFListEditUtil localPreconditionEditUtil;

	private ReferencesTable<?> localPrecondition;

	private EMFListEditUtil localPostconditionEditUtil;

	private ReferencesTable<?> localPostcondition;

	private EMFListEditUtil elementImportEditUtil;

	private ReferencesTable<?> elementImport;

	private EMFListEditUtil packageImportEditUtil;

	private ReferencesTable<?> packageImport;

	private EMFListEditUtil ownedRuleEditUtil;

	private ReferencesTable<?> ownedRule;

	private EMFListEditUtil variableEditUtil;

	private ReferencesTable<?> variable;

	private EMFListEditUtil edgeEditUtil;

	private ReferencesTable<?> edge;

	private Button mustIsolate;

	private EMFListEditUtil nodeEditUtil;

	private ReferencesTable<?> node;

	private Button isTestedFirst;

	private EMFListEditUtil bodyPartEditUtil;

	private ReferencesTable<?> bodyPart;

	private EMFListEditUtil setupPartEditUtil;

	private ReferencesTable<?> setupPart;

	private EMFListEditUtil testEditUtil;

	private ReferencesTable<?> test;

	private EMFListEditUtil resultEditUtil;

	private ReferencesTable<?> result;

	private EMFListEditUtil loopVariableEditUtil;

	private ReferencesTable<?> loopVariable;

	private EMFListEditUtil bodyOutputEditUtil;

	private ReferencesTable<?> bodyOutput;

	private EMFListEditUtil loopVariableInputEditUtil;

	private ReferencesTable<?> loopVariableInput;

	public LoopNodePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);

		createControls(view);
		return view;
	}

	public void createControls(Composite view) {
		createPropertiesGroup(view);

		// Start of user code for additional ui definition

		// End of user code
	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(UMLMessages.LoopNodePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createOwnedCommentTableComposition(propertiesGroup);
		createNameText(propertiesGroup);
		createVisibilityEEnumViewer(propertiesGroup);
		createClientDependencyReferencesTable(propertiesGroup);
		createIsLeafCheckbox(propertiesGroup);
		createOutgoingReferencesTable(propertiesGroup);
		createIncomingReferencesTable(propertiesGroup);
		createInPartitionReferencesTable(propertiesGroup);
		createInInterruptibleRegionReferencesTable(propertiesGroup);
		createRedefinedNodeReferencesTable(propertiesGroup);
		createHandlerTableComposition(propertiesGroup);
		createLocalPreconditionTableComposition(propertiesGroup);
		createLocalPostconditionTableComposition(propertiesGroup);
		createElementImportTableComposition(propertiesGroup);
		createPackageImportTableComposition(propertiesGroup);
		createOwnedRuleTableComposition(propertiesGroup);
		createVariableTableComposition(propertiesGroup);
		createEdgeTableComposition(propertiesGroup);
		createMustIsolateCheckbox(propertiesGroup);
		createNodeTableComposition(propertiesGroup);
		createIsTestedFirstCheckbox(propertiesGroup);
		createBodyPartReferencesTable(propertiesGroup);
		createSetupPartReferencesTable(propertiesGroup);
		createTestReferencesTable(propertiesGroup);
		createResultTableComposition(propertiesGroup);
		createLoopVariableReferencesTable(propertiesGroup);
		createBodyOutputReferencesTable(propertiesGroup);
		createLoopVariableInputTableComposition(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.LoopNodePropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.ownedComment, UMLViewsRepository.SWT_KIND));
		this.ownedComment.createControls(parent);
		GridData ownedCommentData = new GridData(GridData.FILL_HORIZONTAL);
		ownedCommentData.horizontalSpan = 3;
		this.ownedComment.setLayoutData(ownedCommentData);
	}

	/**
	 * 
	 */
	private void moveOwnedComment(Comment element, int oldIndex, int newIndex) {

		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.moveElement(element, oldIndex, newIndex);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.ownedComment, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToOwnedComment() {

		// Start of user code addToOwnedComment() method body

		Comment eObject = UMLFactory.eINSTANCE.createComment();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.addElement(propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.ownedComment,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromOwnedComment(Comment element) {

		// Start of user code for the removeFromOwnedComment() method body

		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.removeElement(element);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.ownedComment, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editOwnedComment(Comment element) {

		// Start of user code editOwnedComment() method body

		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.ownedComment,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.LoopNodePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.LoopNode.name, UMLViewsRepository.SWT_KIND));
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
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.name,
							PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEEnumViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.LoopNodePropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.LoopNode.visibility,
				UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createClientDependencyReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.LoopNodePropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {

			public void handleAdd() {
				ViewerFilter clientDependencyFilter = new EObjectFilter(UMLPackage.eINSTANCE.getDependency());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!clientDependencyEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(clientDependencyFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, filters, "Dependency", UMLPackage.eINSTANCE.getDependency()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.clientDependency, UMLViewsRepository.SWT_KIND));
		this.clientDependency.createControls(parent);
		GridData clientDependencyData = new GridData(GridData.FILL_HORIZONTAL);
		clientDependencyData.horizontalSpan = 3;
		this.clientDependency.setLayoutData(clientDependencyData);
		this.clientDependency.disableMove();
	}

	/**
	 * 
	 */
	private void moveClientDependency(Dependency element, int oldIndex, int newIndex) {
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.moveElement(element, oldIndex, newIndex);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.clientDependency,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	private void removeFromClientDependency(Dependency element) {

		// Start of user code for the removeFromClientDependency() method body

		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.removeElement(element);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.clientDependency,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editClientDependency(Dependency element) {

		// Start of user code editClientDependency() method body

		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				clientDependencyEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				clientDependency.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.clientDependency,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createIsLeafCheckbox(Composite parent) {
		isLeaf = new Button(parent, SWT.CHECK);
		isLeaf.setText(UMLMessages.LoopNodePropertiesEditionPart_IsLeafLabel);
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.isLeaf, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createOutgoingReferencesTable(Composite parent) {
		this.outgoing = new ReferencesTable<ActivityEdge>(UMLMessages.LoopNodePropertiesEditionPart_OutgoingLabel, new ReferencesTableListener<ActivityEdge>() {

			public void handleAdd() {
				ViewerFilter outgoingFilter = new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!outgoingEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(outgoingFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<ActivityEdge> dialog = new TabElementTreeSelectionDialog<ActivityEdge>(resourceSet, filters, "ActivityEdge", UMLPackage.eINSTANCE.getActivityEdge()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!outgoingEditUtil.getVirtualList().contains(elem))
								outgoingEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.outgoing,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						outgoing.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(ActivityEdge element) {
				editOutgoing(element);
			}

			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) {
				moveOutgoing(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityEdge element) {
				removeFromOutgoing(element);
			}

			public void navigateTo(ActivityEdge element) {
			}
		});
		this.outgoing.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.outgoing, UMLViewsRepository.SWT_KIND));
		this.outgoing.createControls(parent);
		GridData outgoingData = new GridData(GridData.FILL_HORIZONTAL);
		outgoingData.horizontalSpan = 3;
		this.outgoing.setLayoutData(outgoingData);
		this.outgoing.disableMove();
	}

	/**
	 * 
	 */
	private void moveOutgoing(ActivityEdge element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void removeFromOutgoing(ActivityEdge element) {

		// Start of user code for the removeFromOutgoing() method body

		EObject editedElement = outgoingEditUtil.foundCorrespondingEObject(element);
		outgoingEditUtil.removeElement(element);
		outgoing.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.outgoing, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editOutgoing(ActivityEdge element) {

		// Start of user code editOutgoing() method body

		EObject editedElement = outgoingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				outgoingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				outgoing.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.outgoing,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createIncomingReferencesTable(Composite parent) {
		this.incoming = new ReferencesTable<ActivityEdge>(UMLMessages.LoopNodePropertiesEditionPart_IncomingLabel, new ReferencesTableListener<ActivityEdge>() {

			public void handleAdd() {
				ViewerFilter incomingFilter = new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!incomingEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(incomingFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<ActivityEdge> dialog = new TabElementTreeSelectionDialog<ActivityEdge>(resourceSet, filters, "ActivityEdge", UMLPackage.eINSTANCE.getActivityEdge()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!incomingEditUtil.getVirtualList().contains(elem))
								incomingEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.incoming,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						incoming.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(ActivityEdge element) {
				editIncoming(element);
			}

			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) {
				moveIncoming(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityEdge element) {
				removeFromIncoming(element);
			}

			public void navigateTo(ActivityEdge element) {
			}
		});
		this.incoming.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.incoming, UMLViewsRepository.SWT_KIND));
		this.incoming.createControls(parent);
		GridData incomingData = new GridData(GridData.FILL_HORIZONTAL);
		incomingData.horizontalSpan = 3;
		this.incoming.setLayoutData(incomingData);
		this.incoming.disableMove();
	}

	/**
	 * 
	 */
	private void moveIncoming(ActivityEdge element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void removeFromIncoming(ActivityEdge element) {

		// Start of user code for the removeFromIncoming() method body

		EObject editedElement = incomingEditUtil.foundCorrespondingEObject(element);
		incomingEditUtil.removeElement(element);
		incoming.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.incoming, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editIncoming(ActivityEdge element) {

		// Start of user code editIncoming() method body

		EObject editedElement = incomingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				incomingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				incoming.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.incoming,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createInPartitionReferencesTable(Composite parent) {
		this.inPartition = new ReferencesTable<ActivityPartition>(UMLMessages.LoopNodePropertiesEditionPart_InPartitionLabel, new ReferencesTableListener<ActivityPartition>() {

			public void handleAdd() {
				ViewerFilter inPartitionFilter = new EObjectFilter(UMLPackage.eINSTANCE.getActivityPartition());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!inPartitionEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(inPartitionFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<ActivityPartition> dialog = new TabElementTreeSelectionDialog<ActivityPartition>(resourceSet, filters, "ActivityPartition", UMLPackage.eINSTANCE
						.getActivityPartition()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!inPartitionEditUtil.getVirtualList().contains(elem))
								inPartitionEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.inPartition,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						inPartition.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(ActivityPartition element) {
				editInPartition(element);
			}

			public void handleMove(ActivityPartition element, int oldIndex, int newIndex) {
				moveInPartition(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityPartition element) {
				removeFromInPartition(element);
			}

			public void navigateTo(ActivityPartition element) {
			}
		});
		this.inPartition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.inPartition, UMLViewsRepository.SWT_KIND));
		this.inPartition.createControls(parent);
		GridData inPartitionData = new GridData(GridData.FILL_HORIZONTAL);
		inPartitionData.horizontalSpan = 3;
		this.inPartition.setLayoutData(inPartitionData);
		this.inPartition.disableMove();
	}

	/**
	 * 
	 */
	private void moveInPartition(ActivityPartition element, int oldIndex, int newIndex) {
		EObject editedElement = inPartitionEditUtil.foundCorrespondingEObject(element);
		inPartitionEditUtil.moveElement(element, oldIndex, newIndex);
		inPartition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.inPartition, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	private void removeFromInPartition(ActivityPartition element) {

		// Start of user code for the removeFromInPartition() method body

		EObject editedElement = inPartitionEditUtil.foundCorrespondingEObject(element);
		inPartitionEditUtil.removeElement(element);
		inPartition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.inPartition, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editInPartition(ActivityPartition element) {

		// Start of user code editInPartition() method body

		EObject editedElement = inPartitionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				inPartitionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				inPartition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.inPartition,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createInInterruptibleRegionReferencesTable(Composite parent) {
		this.inInterruptibleRegion = new ReferencesTable<InterruptibleActivityRegion>(UMLMessages.LoopNodePropertiesEditionPart_InInterruptibleRegionLabel,
				new ReferencesTableListener<InterruptibleActivityRegion>() {

					public void handleAdd() {
						ViewerFilter inInterruptibleRegionFilter = new EObjectFilter(UMLPackage.eINSTANCE.getInterruptibleActivityRegion());
						ViewerFilter viewerFilter = new ViewerFilter() {

							public boolean select(Viewer viewer, Object parentElement, Object element) {
								if (element instanceof EObject)
									return (!inInterruptibleRegionEditUtil.contains((EObject) element));
								return false;
							}

						};
						List filters = new ArrayList();
						filters.add(inInterruptibleRegionFilter);
						filters.add(viewerFilter);
						TabElementTreeSelectionDialog<InterruptibleActivityRegion> dialog = new TabElementTreeSelectionDialog<InterruptibleActivityRegion>(resourceSet, filters,
								"InterruptibleActivityRegion", UMLPackage.eINSTANCE.getInterruptibleActivityRegion()) {

							public void process(IStructuredSelection selection) {
								for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
									EObject elem = (EObject) iter.next();
									if (!inInterruptibleRegionEditUtil.getVirtualList().contains(elem))
										inInterruptibleRegionEditUtil.addElement(elem);
									propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this,
											UMLViewsRepository.LoopNode.inInterruptibleRegion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
								}
								inInterruptibleRegion.refresh();
							}

						};
						dialog.open();
					}

					public void handleEdit(InterruptibleActivityRegion element) {
						editInInterruptibleRegion(element);
					}

					public void handleMove(InterruptibleActivityRegion element, int oldIndex, int newIndex) {
						moveInInterruptibleRegion(element, oldIndex, newIndex);
					}

					public void handleRemove(InterruptibleActivityRegion element) {
						removeFromInInterruptibleRegion(element);
					}

					public void navigateTo(InterruptibleActivityRegion element) {
					}
				});
		this.inInterruptibleRegion.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.inInterruptibleRegion, UMLViewsRepository.SWT_KIND));
		this.inInterruptibleRegion.createControls(parent);
		GridData inInterruptibleRegionData = new GridData(GridData.FILL_HORIZONTAL);
		inInterruptibleRegionData.horizontalSpan = 3;
		this.inInterruptibleRegion.setLayoutData(inInterruptibleRegionData);
		this.inInterruptibleRegion.disableMove();
	}

	/**
	 * 
	 */
	private void moveInInterruptibleRegion(InterruptibleActivityRegion element, int oldIndex, int newIndex) {
		EObject editedElement = inInterruptibleRegionEditUtil.foundCorrespondingEObject(element);
		inInterruptibleRegionEditUtil.moveElement(element, oldIndex, newIndex);
		inInterruptibleRegion.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.inInterruptibleRegion,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	private void removeFromInInterruptibleRegion(InterruptibleActivityRegion element) {

		// Start of user code for the removeFromInInterruptibleRegion() method body

		EObject editedElement = inInterruptibleRegionEditUtil.foundCorrespondingEObject(element);
		inInterruptibleRegionEditUtil.removeElement(element);
		inInterruptibleRegion.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.inInterruptibleRegion,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editInInterruptibleRegion(InterruptibleActivityRegion element) {

		// Start of user code editInInterruptibleRegion() method body

		EObject editedElement = inInterruptibleRegionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				inInterruptibleRegionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				inInterruptibleRegion.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.inInterruptibleRegion,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createRedefinedNodeReferencesTable(Composite parent) {
		this.redefinedNode = new ReferencesTable<ActivityNode>(UMLMessages.LoopNodePropertiesEditionPart_RedefinedNodeLabel, new ReferencesTableListener<ActivityNode>() {

			public void handleAdd() {
				ViewerFilter redefinedNodeFilter = new EObjectFilter(UMLPackage.eINSTANCE.getActivityNode());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!redefinedNodeEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(redefinedNodeFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<ActivityNode> dialog = new TabElementTreeSelectionDialog<ActivityNode>(resourceSet, filters, "ActivityNode", UMLPackage.eINSTANCE.getActivityNode()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!redefinedNodeEditUtil.getVirtualList().contains(elem))
								redefinedNodeEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.redefinedNode,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						redefinedNode.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(ActivityNode element) {
				editRedefinedNode(element);
			}

			public void handleMove(ActivityNode element, int oldIndex, int newIndex) {
				moveRedefinedNode(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityNode element) {
				removeFromRedefinedNode(element);
			}

			public void navigateTo(ActivityNode element) {
			}
		});
		this.redefinedNode.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.redefinedNode, UMLViewsRepository.SWT_KIND));
		this.redefinedNode.createControls(parent);
		GridData redefinedNodeData = new GridData(GridData.FILL_HORIZONTAL);
		redefinedNodeData.horizontalSpan = 3;
		this.redefinedNode.setLayoutData(redefinedNodeData);
		this.redefinedNode.disableMove();
	}

	/**
	 * 
	 */
	private void moveRedefinedNode(ActivityNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void removeFromRedefinedNode(ActivityNode element) {

		// Start of user code for the removeFromRedefinedNode() method body

		EObject editedElement = redefinedNodeEditUtil.foundCorrespondingEObject(element);
		redefinedNodeEditUtil.removeElement(element);
		redefinedNode.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.redefinedNode, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editRedefinedNode(ActivityNode element) {

		// Start of user code editRedefinedNode() method body

		EObject editedElement = redefinedNodeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				redefinedNodeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				redefinedNode.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.redefinedNode,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createHandlerTableComposition(Composite parent) {
		this.handler = new ReferencesTable<ExceptionHandler>(UMLMessages.LoopNodePropertiesEditionPart_HandlerLabel, new ReferencesTableListener<ExceptionHandler>() {

			public void handleAdd() {
				addToHandler();
			}

			public void handleEdit(ExceptionHandler element) {
				editHandler(element);
			}

			public void handleMove(ExceptionHandler element, int oldIndex, int newIndex) {
				moveHandler(element, oldIndex, newIndex);
			}

			public void handleRemove(ExceptionHandler element) {
				removeFromHandler(element);
			}

			public void navigateTo(ExceptionHandler element) {
			}
		});
		this.handler.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.handler, UMLViewsRepository.SWT_KIND));
		this.handler.createControls(parent);
		GridData handlerData = new GridData(GridData.FILL_HORIZONTAL);
		handlerData.horizontalSpan = 3;
		this.handler.setLayoutData(handlerData);
	}

	/**
	 * 
	 */
	private void moveHandler(ExceptionHandler element, int oldIndex, int newIndex) {

		EObject editedElement = handlerEditUtil.foundCorrespondingEObject(element);
		handlerEditUtil.moveElement(element, oldIndex, newIndex);
		handler.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.handler, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToHandler() {

		// Start of user code addToHandler() method body

		ExceptionHandler eObject = UMLFactory.eINSTANCE.createExceptionHandler();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				handlerEditUtil.addElement(propertiesEditionObject);
				handler.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.handler, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromHandler(ExceptionHandler element) {

		// Start of user code for the removeFromHandler() method body

		EObject editedElement = handlerEditUtil.foundCorrespondingEObject(element);
		handlerEditUtil.removeElement(element);
		handler.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.handler, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editHandler(ExceptionHandler element) {

		// Start of user code editHandler() method body

		EObject editedElement = handlerEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				handlerEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				handler.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.handler, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createLocalPreconditionTableComposition(Composite parent) {
		this.localPrecondition = new ReferencesTable<Constraint>(UMLMessages.LoopNodePropertiesEditionPart_LocalPreconditionLabel, new ReferencesTableListener<Constraint>() {

			public void handleAdd() {
				addToLocalPrecondition();
			}

			public void handleEdit(Constraint element) {
				editLocalPrecondition(element);
			}

			public void handleMove(Constraint element, int oldIndex, int newIndex) {
				moveLocalPrecondition(element, oldIndex, newIndex);
			}

			public void handleRemove(Constraint element) {
				removeFromLocalPrecondition(element);
			}

			public void navigateTo(Constraint element) {
			}
		});
		this.localPrecondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.localPrecondition, UMLViewsRepository.SWT_KIND));
		this.localPrecondition.createControls(parent);
		GridData localPreconditionData = new GridData(GridData.FILL_HORIZONTAL);
		localPreconditionData.horizontalSpan = 3;
		this.localPrecondition.setLayoutData(localPreconditionData);
	}

	/**
	 * 
	 */
	private void moveLocalPrecondition(Constraint element, int oldIndex, int newIndex) {

		EObject editedElement = localPreconditionEditUtil.foundCorrespondingEObject(element);
		localPreconditionEditUtil.moveElement(element, oldIndex, newIndex);
		localPrecondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.localPrecondition,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToLocalPrecondition() {

		// Start of user code addToLocalPrecondition() method body

		Constraint eObject = UMLFactory.eINSTANCE.createConstraint();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				localPreconditionEditUtil.addElement(propertiesEditionObject);
				localPrecondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.localPrecondition,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromLocalPrecondition(Constraint element) {

		// Start of user code for the removeFromLocalPrecondition() method body

		EObject editedElement = localPreconditionEditUtil.foundCorrespondingEObject(element);
		localPreconditionEditUtil.removeElement(element);
		localPrecondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.localPrecondition,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editLocalPrecondition(Constraint element) {

		// Start of user code editLocalPrecondition() method body

		EObject editedElement = localPreconditionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				localPreconditionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				localPrecondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.localPrecondition,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createLocalPostconditionTableComposition(Composite parent) {
		this.localPostcondition = new ReferencesTable<Constraint>(UMLMessages.LoopNodePropertiesEditionPart_LocalPostconditionLabel, new ReferencesTableListener<Constraint>() {

			public void handleAdd() {
				addToLocalPostcondition();
			}

			public void handleEdit(Constraint element) {
				editLocalPostcondition(element);
			}

			public void handleMove(Constraint element, int oldIndex, int newIndex) {
				moveLocalPostcondition(element, oldIndex, newIndex);
			}

			public void handleRemove(Constraint element) {
				removeFromLocalPostcondition(element);
			}

			public void navigateTo(Constraint element) {
			}
		});
		this.localPostcondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.localPostcondition, UMLViewsRepository.SWT_KIND));
		this.localPostcondition.createControls(parent);
		GridData localPostconditionData = new GridData(GridData.FILL_HORIZONTAL);
		localPostconditionData.horizontalSpan = 3;
		this.localPostcondition.setLayoutData(localPostconditionData);
	}

	/**
	 * 
	 */
	private void moveLocalPostcondition(Constraint element, int oldIndex, int newIndex) {

		EObject editedElement = localPostconditionEditUtil.foundCorrespondingEObject(element);
		localPostconditionEditUtil.moveElement(element, oldIndex, newIndex);
		localPostcondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.localPostcondition,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToLocalPostcondition() {

		// Start of user code addToLocalPostcondition() method body

		Constraint eObject = UMLFactory.eINSTANCE.createConstraint();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				localPostconditionEditUtil.addElement(propertiesEditionObject);
				localPostcondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.localPostcondition,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromLocalPostcondition(Constraint element) {

		// Start of user code for the removeFromLocalPostcondition() method body

		EObject editedElement = localPostconditionEditUtil.foundCorrespondingEObject(element);
		localPostconditionEditUtil.removeElement(element);
		localPostcondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.localPostcondition,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editLocalPostcondition(Constraint element) {

		// Start of user code editLocalPostcondition() method body

		EObject editedElement = localPostconditionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				localPostconditionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				localPostcondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.localPostcondition,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createElementImportTableComposition(Composite parent) {
		this.elementImport = new ReferencesTable<ElementImport>(UMLMessages.LoopNodePropertiesEditionPart_ElementImportLabel, new ReferencesTableListener<ElementImport>() {

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
		this.elementImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.elementImport, UMLViewsRepository.SWT_KIND));
		this.elementImport.createControls(parent);
		GridData elementImportData = new GridData(GridData.FILL_HORIZONTAL);
		elementImportData.horizontalSpan = 3;
		this.elementImport.setLayoutData(elementImportData);
	}

	/**
	 * 
	 */
	private void moveElementImport(ElementImport element, int oldIndex, int newIndex) {

		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		elementImportEditUtil.moveElement(element, oldIndex, newIndex);
		elementImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.elementImport, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToElementImport() {

		// Start of user code addToElementImport() method body

		ElementImport eObject = UMLFactory.eINSTANCE.createElementImport();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				elementImportEditUtil.addElement(propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.elementImport,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromElementImport(ElementImport element) {

		// Start of user code for the removeFromElementImport() method body

		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		elementImportEditUtil.removeElement(element);
		elementImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.elementImport, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editElementImport(ElementImport element) {

		// Start of user code editElementImport() method body

		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				elementImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.elementImport,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createPackageImportTableComposition(Composite parent) {
		this.packageImport = new ReferencesTable<PackageImport>(UMLMessages.LoopNodePropertiesEditionPart_PackageImportLabel, new ReferencesTableListener<PackageImport>() {

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
		this.packageImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.packageImport, UMLViewsRepository.SWT_KIND));
		this.packageImport.createControls(parent);
		GridData packageImportData = new GridData(GridData.FILL_HORIZONTAL);
		packageImportData.horizontalSpan = 3;
		this.packageImport.setLayoutData(packageImportData);
	}

	/**
	 * 
	 */
	private void movePackageImport(PackageImport element, int oldIndex, int newIndex) {

		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		packageImportEditUtil.moveElement(element, oldIndex, newIndex);
		packageImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.packageImport, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToPackageImport() {

		// Start of user code addToPackageImport() method body

		PackageImport eObject = UMLFactory.eINSTANCE.createPackageImport();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				packageImportEditUtil.addElement(propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.packageImport,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromPackageImport(PackageImport element) {

		// Start of user code for the removeFromPackageImport() method body

		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		packageImportEditUtil.removeElement(element);
		packageImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.packageImport, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editPackageImport(PackageImport element) {

		// Start of user code editPackageImport() method body

		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				packageImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.packageImport,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createOwnedRuleTableComposition(Composite parent) {
		this.ownedRule = new ReferencesTable<Constraint>(UMLMessages.LoopNodePropertiesEditionPart_OwnedRuleLabel, new ReferencesTableListener<Constraint>() {

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
		this.ownedRule.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.ownedRule, UMLViewsRepository.SWT_KIND));
		this.ownedRule.createControls(parent);
		GridData ownedRuleData = new GridData(GridData.FILL_HORIZONTAL);
		ownedRuleData.horizontalSpan = 3;
		this.ownedRule.setLayoutData(ownedRuleData);
	}

	/**
	 * 
	 */
	private void moveOwnedRule(Constraint element, int oldIndex, int newIndex) {

		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		ownedRuleEditUtil.moveElement(element, oldIndex, newIndex);
		ownedRule.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.ownedRule, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToOwnedRule() {

		// Start of user code addToOwnedRule() method body

		Constraint eObject = UMLFactory.eINSTANCE.createConstraint();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				ownedRuleEditUtil.addElement(propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.ownedRule,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromOwnedRule(Constraint element) {

		// Start of user code for the removeFromOwnedRule() method body

		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		ownedRuleEditUtil.removeElement(element);
		ownedRule.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.ownedRule, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editOwnedRule(Constraint element) {

		// Start of user code editOwnedRule() method body

		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				ownedRuleEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.ownedRule,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createVariableTableComposition(Composite parent) {
		this.variable = new ReferencesTable<Variable>(UMLMessages.LoopNodePropertiesEditionPart_VariableLabel, new ReferencesTableListener<Variable>() {

			public void handleAdd() {
				addToVariable();
			}

			public void handleEdit(Variable element) {
				editVariable(element);
			}

			public void handleMove(Variable element, int oldIndex, int newIndex) {
				moveVariable(element, oldIndex, newIndex);
			}

			public void handleRemove(Variable element) {
				removeFromVariable(element);
			}

			public void navigateTo(Variable element) {
			}
		});
		this.variable.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.variable, UMLViewsRepository.SWT_KIND));
		this.variable.createControls(parent);
		GridData variableData = new GridData(GridData.FILL_HORIZONTAL);
		variableData.horizontalSpan = 3;
		this.variable.setLayoutData(variableData);
	}

	/**
	 * 
	 */
	private void moveVariable(Variable element, int oldIndex, int newIndex) {

		EObject editedElement = variableEditUtil.foundCorrespondingEObject(element);
		variableEditUtil.moveElement(element, oldIndex, newIndex);
		variable.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.variable, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToVariable() {

		// Start of user code addToVariable() method body

		Variable eObject = UMLFactory.eINSTANCE.createVariable();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				variableEditUtil.addElement(propertiesEditionObject);
				variable.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.variable,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromVariable(Variable element) {

		// Start of user code for the removeFromVariable() method body

		EObject editedElement = variableEditUtil.foundCorrespondingEObject(element);
		variableEditUtil.removeElement(element);
		variable.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.variable, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editVariable(Variable element) {

		// Start of user code editVariable() method body

		EObject editedElement = variableEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				variableEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				variable.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.variable,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createEdgeTableComposition(Composite parent) {
		this.edge = new ReferencesTable<ActivityEdge>(UMLMessages.LoopNodePropertiesEditionPart_EdgeLabel, new ReferencesTableListener<ActivityEdge>() {

			public void handleAdd() {
				addToEdge();
			}

			public void handleEdit(ActivityEdge element) {
				editEdge(element);
			}

			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) {
				moveEdge(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityEdge element) {
				removeFromEdge(element);
			}

			public void navigateTo(ActivityEdge element) {
			}
		});
		this.edge.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.edge, UMLViewsRepository.SWT_KIND));
		this.edge.createControls(parent);
		GridData edgeData = new GridData(GridData.FILL_HORIZONTAL);
		edgeData.horizontalSpan = 3;
		this.edge.setLayoutData(edgeData);
	}

	/**
	 * 
	 */
	private void moveEdge(ActivityEdge element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void addToEdge() {

		// Start of user code addToEdge() method body

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromEdge(ActivityEdge element) {

		// Start of user code for the removeFromEdge() method body

		EObject editedElement = edgeEditUtil.foundCorrespondingEObject(element);
		edgeEditUtil.removeElement(element);
		edge.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.edge, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editEdge(ActivityEdge element) {

		// Start of user code editEdge() method body

		EObject editedElement = edgeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				edgeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				edge.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.edge, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createMustIsolateCheckbox(Composite parent) {
		mustIsolate = new Button(parent, SWT.CHECK);
		mustIsolate.setText(UMLMessages.LoopNodePropertiesEditionPart_MustIsolateLabel);
		GridData mustIsolateData = new GridData(GridData.FILL_HORIZONTAL);
		mustIsolateData.horizontalSpan = 2;
		mustIsolate.setLayoutData(mustIsolateData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.mustIsolate, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param container
	 */
	protected void createNodeTableComposition(Composite parent) {
		this.node = new ReferencesTable<ActivityNode>(UMLMessages.LoopNodePropertiesEditionPart_NodeLabel, new ReferencesTableListener<ActivityNode>() {

			public void handleAdd() {
				addToNode();
			}

			public void handleEdit(ActivityNode element) {
				editNode(element);
			}

			public void handleMove(ActivityNode element, int oldIndex, int newIndex) {
				moveNode(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityNode element) {
				removeFromNode(element);
			}

			public void navigateTo(ActivityNode element) {
			}
		});
		this.node.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.node, UMLViewsRepository.SWT_KIND));
		this.node.createControls(parent);
		GridData nodeData = new GridData(GridData.FILL_HORIZONTAL);
		nodeData.horizontalSpan = 3;
		this.node.setLayoutData(nodeData);
	}

	/**
	 * 
	 */
	private void moveNode(ActivityNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void addToNode() {

		// Start of user code addToNode() method body

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromNode(ActivityNode element) {

		// Start of user code for the removeFromNode() method body

		EObject editedElement = nodeEditUtil.foundCorrespondingEObject(element);
		nodeEditUtil.removeElement(element);
		node.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.node, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editNode(ActivityNode element) {

		// Start of user code editNode() method body

		EObject editedElement = nodeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				nodeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				node.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.node, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createIsTestedFirstCheckbox(Composite parent) {
		isTestedFirst = new Button(parent, SWT.CHECK);
		isTestedFirst.setText(UMLMessages.LoopNodePropertiesEditionPart_IsTestedFirstLabel);
		GridData isTestedFirstData = new GridData(GridData.FILL_HORIZONTAL);
		isTestedFirstData.horizontalSpan = 2;
		isTestedFirst.setLayoutData(isTestedFirstData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.isTestedFirst, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createBodyPartReferencesTable(Composite parent) {
		this.bodyPart = new ReferencesTable<ExecutableNode>(UMLMessages.LoopNodePropertiesEditionPart_BodyPartLabel, new ReferencesTableListener<ExecutableNode>() {

			public void handleAdd() {
				ViewerFilter bodyPartFilter = new EObjectFilter(UMLPackage.eINSTANCE.getExecutableNode());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!bodyPartEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(bodyPartFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<ExecutableNode> dialog = new TabElementTreeSelectionDialog<ExecutableNode>(resourceSet, filters, "ExecutableNode", UMLPackage.eINSTANCE
						.getExecutableNode()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!bodyPartEditUtil.getVirtualList().contains(elem))
								bodyPartEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.bodyPart,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						bodyPart.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(ExecutableNode element) {
				editBodyPart(element);
			}

			public void handleMove(ExecutableNode element, int oldIndex, int newIndex) {
				moveBodyPart(element, oldIndex, newIndex);
			}

			public void handleRemove(ExecutableNode element) {
				removeFromBodyPart(element);
			}

			public void navigateTo(ExecutableNode element) {
			}
		});
		this.bodyPart.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.bodyPart, UMLViewsRepository.SWT_KIND));
		this.bodyPart.createControls(parent);
		GridData bodyPartData = new GridData(GridData.FILL_HORIZONTAL);
		bodyPartData.horizontalSpan = 3;
		this.bodyPart.setLayoutData(bodyPartData);
		this.bodyPart.disableMove();
	}

	/**
	 * 
	 */
	private void moveBodyPart(ExecutableNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void removeFromBodyPart(ExecutableNode element) {

		// Start of user code for the removeFromBodyPart() method body

		EObject editedElement = bodyPartEditUtil.foundCorrespondingEObject(element);
		bodyPartEditUtil.removeElement(element);
		bodyPart.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.bodyPart, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editBodyPart(ExecutableNode element) {

		// Start of user code editBodyPart() method body

		EObject editedElement = bodyPartEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				bodyPartEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				bodyPart.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.bodyPart,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createSetupPartReferencesTable(Composite parent) {
		this.setupPart = new ReferencesTable<ExecutableNode>(UMLMessages.LoopNodePropertiesEditionPart_SetupPartLabel, new ReferencesTableListener<ExecutableNode>() {

			public void handleAdd() {
				ViewerFilter setupPartFilter = new EObjectFilter(UMLPackage.eINSTANCE.getExecutableNode());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!setupPartEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(setupPartFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<ExecutableNode> dialog = new TabElementTreeSelectionDialog<ExecutableNode>(resourceSet, filters, "ExecutableNode", UMLPackage.eINSTANCE
						.getExecutableNode()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!setupPartEditUtil.getVirtualList().contains(elem))
								setupPartEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.setupPart,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						setupPart.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(ExecutableNode element) {
				editSetupPart(element);
			}

			public void handleMove(ExecutableNode element, int oldIndex, int newIndex) {
				moveSetupPart(element, oldIndex, newIndex);
			}

			public void handleRemove(ExecutableNode element) {
				removeFromSetupPart(element);
			}

			public void navigateTo(ExecutableNode element) {
			}
		});
		this.setupPart.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.setupPart, UMLViewsRepository.SWT_KIND));
		this.setupPart.createControls(parent);
		GridData setupPartData = new GridData(GridData.FILL_HORIZONTAL);
		setupPartData.horizontalSpan = 3;
		this.setupPart.setLayoutData(setupPartData);
		this.setupPart.disableMove();
	}

	/**
	 * 
	 */
	private void moveSetupPart(ExecutableNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void removeFromSetupPart(ExecutableNode element) {

		// Start of user code for the removeFromSetupPart() method body

		EObject editedElement = setupPartEditUtil.foundCorrespondingEObject(element);
		setupPartEditUtil.removeElement(element);
		setupPart.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.setupPart, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editSetupPart(ExecutableNode element) {

		// Start of user code editSetupPart() method body

		EObject editedElement = setupPartEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				setupPartEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				setupPart.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.setupPart,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createTestReferencesTable(Composite parent) {
		this.test = new ReferencesTable<ExecutableNode>(UMLMessages.LoopNodePropertiesEditionPart_TestLabel, new ReferencesTableListener<ExecutableNode>() {

			public void handleAdd() {
				ViewerFilter testFilter = new EObjectFilter(UMLPackage.eINSTANCE.getExecutableNode());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!testEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(testFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<ExecutableNode> dialog = new TabElementTreeSelectionDialog<ExecutableNode>(resourceSet, filters, "ExecutableNode", UMLPackage.eINSTANCE
						.getExecutableNode()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!testEditUtil.getVirtualList().contains(elem))
								testEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.test,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						test.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(ExecutableNode element) {
				editTest(element);
			}

			public void handleMove(ExecutableNode element, int oldIndex, int newIndex) {
				moveTest(element, oldIndex, newIndex);
			}

			public void handleRemove(ExecutableNode element) {
				removeFromTest(element);
			}

			public void navigateTo(ExecutableNode element) {
			}
		});
		this.test.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.test, UMLViewsRepository.SWT_KIND));
		this.test.createControls(parent);
		GridData testData = new GridData(GridData.FILL_HORIZONTAL);
		testData.horizontalSpan = 3;
		this.test.setLayoutData(testData);
		this.test.disableMove();
	}

	/**
	 * 
	 */
	private void moveTest(ExecutableNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void removeFromTest(ExecutableNode element) {

		// Start of user code for the removeFromTest() method body

		EObject editedElement = testEditUtil.foundCorrespondingEObject(element);
		testEditUtil.removeElement(element);
		test.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.test, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editTest(ExecutableNode element) {

		// Start of user code editTest() method body

		EObject editedElement = testEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				testEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				test.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.test, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createResultTableComposition(Composite parent) {
		this.result = new ReferencesTable<OutputPin>(UMLMessages.LoopNodePropertiesEditionPart_ResultLabel, new ReferencesTableListener<OutputPin>() {

			public void handleAdd() {
				addToResult();
			}

			public void handleEdit(OutputPin element) {
				editResult(element);
			}

			public void handleMove(OutputPin element, int oldIndex, int newIndex) {
				moveResult(element, oldIndex, newIndex);
			}

			public void handleRemove(OutputPin element) {
				removeFromResult(element);
			}

			public void navigateTo(OutputPin element) {
			}
		});
		this.result.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.result, UMLViewsRepository.SWT_KIND));
		this.result.createControls(parent);
		GridData resultData = new GridData(GridData.FILL_HORIZONTAL);
		resultData.horizontalSpan = 3;
		this.result.setLayoutData(resultData);
	}

	/**
	 * 
	 */
	private void moveResult(OutputPin element, int oldIndex, int newIndex) {

		EObject editedElement = resultEditUtil.foundCorrespondingEObject(element);
		resultEditUtil.moveElement(element, oldIndex, newIndex);
		result.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.result, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToResult() {

		// Start of user code addToResult() method body

		OutputPin eObject = UMLFactory.eINSTANCE.createOutputPin();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				resultEditUtil.addElement(propertiesEditionObject);
				result.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.result, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromResult(OutputPin element) {

		// Start of user code for the removeFromResult() method body

		EObject editedElement = resultEditUtil.foundCorrespondingEObject(element);
		resultEditUtil.removeElement(element);
		result.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.result, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editResult(OutputPin element) {

		// Start of user code editResult() method body

		EObject editedElement = resultEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				resultEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				result.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.result, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createLoopVariableReferencesTable(Composite parent) {
		this.loopVariable = new ReferencesTable<OutputPin>(UMLMessages.LoopNodePropertiesEditionPart_LoopVariableLabel, new ReferencesTableListener<OutputPin>() {

			public void handleAdd() {
				ViewerFilter loopVariableFilter = new EObjectFilter(UMLPackage.eINSTANCE.getOutputPin());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!loopVariableEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(loopVariableFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<OutputPin> dialog = new TabElementTreeSelectionDialog<OutputPin>(resourceSet, filters, "OutputPin", UMLPackage.eINSTANCE.getOutputPin()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!loopVariableEditUtil.getVirtualList().contains(elem))
								loopVariableEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.loopVariable,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						loopVariable.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(OutputPin element) {
				editLoopVariable(element);
			}

			public void handleMove(OutputPin element, int oldIndex, int newIndex) {
				moveLoopVariable(element, oldIndex, newIndex);
			}

			public void handleRemove(OutputPin element) {
				removeFromLoopVariable(element);
			}

			public void navigateTo(OutputPin element) {
			}
		});
		this.loopVariable.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.loopVariable, UMLViewsRepository.SWT_KIND));
		this.loopVariable.createControls(parent);
		GridData loopVariableData = new GridData(GridData.FILL_HORIZONTAL);
		loopVariableData.horizontalSpan = 3;
		this.loopVariable.setLayoutData(loopVariableData);
		this.loopVariable.disableMove();
	}

	/**
	 * 
	 */
	private void moveLoopVariable(OutputPin element, int oldIndex, int newIndex) {
		EObject editedElement = loopVariableEditUtil.foundCorrespondingEObject(element);
		loopVariableEditUtil.moveElement(element, oldIndex, newIndex);
		loopVariable.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.loopVariable, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	private void removeFromLoopVariable(OutputPin element) {

		// Start of user code for the removeFromLoopVariable() method body

		EObject editedElement = loopVariableEditUtil.foundCorrespondingEObject(element);
		loopVariableEditUtil.removeElement(element);
		loopVariable.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.loopVariable, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editLoopVariable(OutputPin element) {

		// Start of user code editLoopVariable() method body

		EObject editedElement = loopVariableEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				loopVariableEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				loopVariable.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.loopVariable,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createBodyOutputReferencesTable(Composite parent) {
		this.bodyOutput = new ReferencesTable<OutputPin>(UMLMessages.LoopNodePropertiesEditionPart_BodyOutputLabel, new ReferencesTableListener<OutputPin>() {

			public void handleAdd() {
				ViewerFilter bodyOutputFilter = new EObjectFilter(UMLPackage.eINSTANCE.getOutputPin());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!bodyOutputEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(bodyOutputFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<OutputPin> dialog = new TabElementTreeSelectionDialog<OutputPin>(resourceSet, filters, "OutputPin", UMLPackage.eINSTANCE.getOutputPin()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!bodyOutputEditUtil.getVirtualList().contains(elem))
								bodyOutputEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.bodyOutput,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						bodyOutput.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(OutputPin element) {
				editBodyOutput(element);
			}

			public void handleMove(OutputPin element, int oldIndex, int newIndex) {
				moveBodyOutput(element, oldIndex, newIndex);
			}

			public void handleRemove(OutputPin element) {
				removeFromBodyOutput(element);
			}

			public void navigateTo(OutputPin element) {
			}
		});
		this.bodyOutput.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.bodyOutput, UMLViewsRepository.SWT_KIND));
		this.bodyOutput.createControls(parent);
		GridData bodyOutputData = new GridData(GridData.FILL_HORIZONTAL);
		bodyOutputData.horizontalSpan = 3;
		this.bodyOutput.setLayoutData(bodyOutputData);
		this.bodyOutput.disableMove();
	}

	/**
	 * 
	 */
	private void moveBodyOutput(OutputPin element, int oldIndex, int newIndex) {
		EObject editedElement = bodyOutputEditUtil.foundCorrespondingEObject(element);
		bodyOutputEditUtil.moveElement(element, oldIndex, newIndex);
		bodyOutput.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.bodyOutput, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	private void removeFromBodyOutput(OutputPin element) {

		// Start of user code for the removeFromBodyOutput() method body

		EObject editedElement = bodyOutputEditUtil.foundCorrespondingEObject(element);
		bodyOutputEditUtil.removeElement(element);
		bodyOutput.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.bodyOutput, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editBodyOutput(OutputPin element) {

		// Start of user code editBodyOutput() method body

		EObject editedElement = bodyOutputEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				bodyOutputEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				bodyOutput.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.bodyOutput,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * @param container
	 */
	protected void createLoopVariableInputTableComposition(Composite parent) {
		this.loopVariableInput = new ReferencesTable<InputPin>(UMLMessages.LoopNodePropertiesEditionPart_LoopVariableInputLabel, new ReferencesTableListener<InputPin>() {

			public void handleAdd() {
				addToLoopVariableInput();
			}

			public void handleEdit(InputPin element) {
				editLoopVariableInput(element);
			}

			public void handleMove(InputPin element, int oldIndex, int newIndex) {
				moveLoopVariableInput(element, oldIndex, newIndex);
			}

			public void handleRemove(InputPin element) {
				removeFromLoopVariableInput(element);
			}

			public void navigateTo(InputPin element) {
			}
		});
		this.loopVariableInput.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.LoopNode.loopVariableInput, UMLViewsRepository.SWT_KIND));
		this.loopVariableInput.createControls(parent);
		GridData loopVariableInputData = new GridData(GridData.FILL_HORIZONTAL);
		loopVariableInputData.horizontalSpan = 3;
		this.loopVariableInput.setLayoutData(loopVariableInputData);
	}

	/**
	 * 
	 */
	private void moveLoopVariableInput(InputPin element, int oldIndex, int newIndex) {

		EObject editedElement = loopVariableInputEditUtil.foundCorrespondingEObject(element);
		loopVariableInputEditUtil.moveElement(element, oldIndex, newIndex);
		loopVariableInput.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.loopVariableInput,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToLoopVariableInput() {

		// Start of user code addToLoopVariableInput() method body

		InputPin eObject = UMLFactory.eINSTANCE.createInputPin();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				loopVariableInputEditUtil.addElement(propertiesEditionObject);
				loopVariableInput.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.loopVariableInput,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromLoopVariableInput(InputPin element) {

		// Start of user code for the removeFromLoopVariableInput() method body

		EObject editedElement = loopVariableInputEditUtil.foundCorrespondingEObject(element);
		loopVariableInputEditUtil.removeElement(element);
		loopVariableInput.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.loopVariableInput,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editLoopVariableInput(InputPin element) {

		// Start of user code editLoopVariableInput() method body

		EObject editedElement = loopVariableInputEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				loopVariableInputEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				loopVariableInput.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopNodePropertiesEditionPartImpl.this, UMLViewsRepository.LoopNode.loopVariableInput,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initOwnedComment(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			ownedCommentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedCommentEditUtil = new EMFListEditUtil(current, feature);
		this.ownedComment.setInput(ownedCommentEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateOwnedComment(EObject newValue)
	 */
	public void updateOwnedComment(EObject newValue) {
		if (ownedCommentEditUtil != null) {
			ownedCommentEditUtil.reinit(newValue);
			ownedComment.refresh();
		}
	}

	public void setMessageForOwnedComment(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedComment() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		name.setText(newValue);
	}

	public void setMessageForName(String msg, int msgLevel) {

	}

	public void unsetMessageForName() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.setSelection(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initClientDependency(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initClientDependency(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			clientDependencyEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			clientDependencyEditUtil = new EMFListEditUtil(current, feature);
		this.clientDependency.setInput(clientDependencyEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateClientDependency(EObject newValue)
	 */
	public void updateClientDependency(EObject newValue) {
		if (clientDependencyEditUtil != null) {
			clientDependencyEditUtil.reinit(newValue);
			clientDependency.refresh();
		}
	}

	public void setMessageForClientDependency(String msg, int msgLevel) {

	}

	public void unsetMessageForClientDependency() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#setIsLeaf(Boolean newValue)
	 */
	public void setIsLeaf(Boolean newValue) {
		if (newValue != null) {
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOutgoingToAdd()
	 */
	public List getOutgoingToAdd() {
		return outgoingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOutgoingToRemove()
	 */
	public List getOutgoingToRemove() {
		return outgoingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initOutgoing(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOutgoing(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			outgoingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			outgoingEditUtil = new EMFListEditUtil(current, feature);
		this.outgoing.setInput(outgoingEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateOutgoing(EObject newValue)
	 */
	public void updateOutgoing(EObject newValue) {
		if (outgoingEditUtil != null) {
			outgoingEditUtil.reinit(newValue);
			outgoing.refresh();
		}
	}

	public void setMessageForOutgoing(String msg, int msgLevel) {

	}

	public void unsetMessageForOutgoing() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getIncomingToAdd()
	 */
	public List getIncomingToAdd() {
		return incomingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getIncomingToRemove()
	 */
	public List getIncomingToRemove() {
		return incomingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initIncoming(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initIncoming(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			incomingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			incomingEditUtil = new EMFListEditUtil(current, feature);
		this.incoming.setInput(incomingEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateIncoming(EObject newValue)
	 */
	public void updateIncoming(EObject newValue) {
		if (incomingEditUtil != null) {
			incomingEditUtil.reinit(newValue);
			incoming.refresh();
		}
	}

	public void setMessageForIncoming(String msg, int msgLevel) {

	}

	public void unsetMessageForIncoming() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getInPartitionToAdd()
	 */
	public List getInPartitionToAdd() {
		return inPartitionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getInPartitionToRemove()
	 */
	public List getInPartitionToRemove() {
		return inPartitionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initInPartition(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initInPartition(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			inPartitionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			inPartitionEditUtil = new EMFListEditUtil(current, feature);
		this.inPartition.setInput(inPartitionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateInPartition(EObject newValue)
	 */
	public void updateInPartition(EObject newValue) {
		if (inPartitionEditUtil != null) {
			inPartitionEditUtil.reinit(newValue);
			inPartition.refresh();
		}
	}

	public void setMessageForInPartition(String msg, int msgLevel) {

	}

	public void unsetMessageForInPartition() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getInInterruptibleRegionToAdd()
	 */
	public List getInInterruptibleRegionToAdd() {
		return inInterruptibleRegionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getInInterruptibleRegionToRemove()
	 */
	public List getInInterruptibleRegionToRemove() {
		return inInterruptibleRegionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initInInterruptibleRegion(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initInInterruptibleRegion(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			inInterruptibleRegionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			inInterruptibleRegionEditUtil = new EMFListEditUtil(current, feature);
		this.inInterruptibleRegion.setInput(inInterruptibleRegionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateInInterruptibleRegion(EObject newValue)
	 */
	public void updateInInterruptibleRegion(EObject newValue) {
		if (inInterruptibleRegionEditUtil != null) {
			inInterruptibleRegionEditUtil.reinit(newValue);
			inInterruptibleRegion.refresh();
		}
	}

	public void setMessageForInInterruptibleRegion(String msg, int msgLevel) {

	}

	public void unsetMessageForInInterruptibleRegion() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getRedefinedNodeToAdd()
	 */
	public List getRedefinedNodeToAdd() {
		return redefinedNodeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getRedefinedNodeToRemove()
	 */
	public List getRedefinedNodeToRemove() {
		return redefinedNodeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initRedefinedNode(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRedefinedNode(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			redefinedNodeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			redefinedNodeEditUtil = new EMFListEditUtil(current, feature);
		this.redefinedNode.setInput(redefinedNodeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateRedefinedNode(EObject newValue)
	 */
	public void updateRedefinedNode(EObject newValue) {
		if (redefinedNodeEditUtil != null) {
			redefinedNodeEditUtil.reinit(newValue);
			redefinedNode.refresh();
		}
	}

	public void setMessageForRedefinedNode(String msg, int msgLevel) {

	}

	public void unsetMessageForRedefinedNode() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getHandlerToAdd()
	 */
	public List getHandlerToAdd() {
		return handlerEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getHandlerToRemove()
	 */
	public List getHandlerToRemove() {
		return handlerEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getHandlerToEdit()
	 */
	public Map getHandlerToEdit() {
		return handlerEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getHandlerToMove()
	 */
	public List getHandlerToMove() {
		return handlerEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getHandlerTable()
	 */
	public List getHandlerTable() {
		return handlerEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initHandler(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initHandler(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			handlerEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			handlerEditUtil = new EMFListEditUtil(current, feature);
		this.handler.setInput(handlerEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateHandler(EObject newValue)
	 */
	public void updateHandler(EObject newValue) {
		if (handlerEditUtil != null) {
			handlerEditUtil.reinit(newValue);
			handler.refresh();
		}
	}

	public void setMessageForHandler(String msg, int msgLevel) {

	}

	public void unsetMessageForHandler() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPreconditionToAdd()
	 */
	public List getLocalPreconditionToAdd() {
		return localPreconditionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPreconditionToRemove()
	 */
	public List getLocalPreconditionToRemove() {
		return localPreconditionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPreconditionToEdit()
	 */
	public Map getLocalPreconditionToEdit() {
		return localPreconditionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPreconditionToMove()
	 */
	public List getLocalPreconditionToMove() {
		return localPreconditionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPreconditionTable()
	 */
	public List getLocalPreconditionTable() {
		return localPreconditionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initLocalPrecondition(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initLocalPrecondition(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			localPreconditionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			localPreconditionEditUtil = new EMFListEditUtil(current, feature);
		this.localPrecondition.setInput(localPreconditionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateLocalPrecondition(EObject newValue)
	 */
	public void updateLocalPrecondition(EObject newValue) {
		if (localPreconditionEditUtil != null) {
			localPreconditionEditUtil.reinit(newValue);
			localPrecondition.refresh();
		}
	}

	public void setMessageForLocalPrecondition(String msg, int msgLevel) {

	}

	public void unsetMessageForLocalPrecondition() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPostconditionToAdd()
	 */
	public List getLocalPostconditionToAdd() {
		return localPostconditionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPostconditionToRemove()
	 */
	public List getLocalPostconditionToRemove() {
		return localPostconditionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPostconditionToEdit()
	 */
	public Map getLocalPostconditionToEdit() {
		return localPostconditionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPostconditionToMove()
	 */
	public List getLocalPostconditionToMove() {
		return localPostconditionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLocalPostconditionTable()
	 */
	public List getLocalPostconditionTable() {
		return localPostconditionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initLocalPostcondition(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initLocalPostcondition(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			localPostconditionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			localPostconditionEditUtil = new EMFListEditUtil(current, feature);
		this.localPostcondition.setInput(localPostconditionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateLocalPostcondition(EObject newValue)
	 */
	public void updateLocalPostcondition(EObject newValue) {
		if (localPostconditionEditUtil != null) {
			localPostconditionEditUtil.reinit(newValue);
			localPostcondition.refresh();
		}
	}

	public void setMessageForLocalPostcondition(String msg, int msgLevel) {

	}

	public void unsetMessageForLocalPostcondition() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getElementImportToAdd()
	 */
	public List getElementImportToAdd() {
		return elementImportEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getElementImportToRemove()
	 */
	public List getElementImportToRemove() {
		return elementImportEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getElementImportToEdit()
	 */
	public Map getElementImportToEdit() {
		return elementImportEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getElementImportToMove()
	 */
	public List getElementImportToMove() {
		return elementImportEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getElementImportTable()
	 */
	public List getElementImportTable() {
		return elementImportEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initElementImport(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initElementImport(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			elementImportEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			elementImportEditUtil = new EMFListEditUtil(current, feature);
		this.elementImport.setInput(elementImportEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateElementImport(EObject newValue)
	 */
	public void updateElementImport(EObject newValue) {
		if (elementImportEditUtil != null) {
			elementImportEditUtil.reinit(newValue);
			elementImport.refresh();
		}
	}

	public void setMessageForElementImport(String msg, int msgLevel) {

	}

	public void unsetMessageForElementImport() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getPackageImportToAdd()
	 */
	public List getPackageImportToAdd() {
		return packageImportEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getPackageImportToRemove()
	 */
	public List getPackageImportToRemove() {
		return packageImportEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getPackageImportToEdit()
	 */
	public Map getPackageImportToEdit() {
		return packageImportEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getPackageImportToMove()
	 */
	public List getPackageImportToMove() {
		return packageImportEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getPackageImportTable()
	 */
	public List getPackageImportTable() {
		return packageImportEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initPackageImport(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPackageImport(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			packageImportEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			packageImportEditUtil = new EMFListEditUtil(current, feature);
		this.packageImport.setInput(packageImportEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updatePackageImport(EObject newValue)
	 */
	public void updatePackageImport(EObject newValue) {
		if (packageImportEditUtil != null) {
			packageImportEditUtil.reinit(newValue);
			packageImport.refresh();
		}
	}

	public void setMessageForPackageImport(String msg, int msgLevel) {

	}

	public void unsetMessageForPackageImport() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedRuleToAdd()
	 */
	public List getOwnedRuleToAdd() {
		return ownedRuleEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedRuleToRemove()
	 */
	public List getOwnedRuleToRemove() {
		return ownedRuleEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedRuleToEdit()
	 */
	public Map getOwnedRuleToEdit() {
		return ownedRuleEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedRuleToMove()
	 */
	public List getOwnedRuleToMove() {
		return ownedRuleEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getOwnedRuleTable()
	 */
	public List getOwnedRuleTable() {
		return ownedRuleEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initOwnedRule(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedRule(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			ownedRuleEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedRuleEditUtil = new EMFListEditUtil(current, feature);
		this.ownedRule.setInput(ownedRuleEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateOwnedRule(EObject newValue)
	 */
	public void updateOwnedRule(EObject newValue) {
		if (ownedRuleEditUtil != null) {
			ownedRuleEditUtil.reinit(newValue);
			ownedRule.refresh();
		}
	}

	public void setMessageForOwnedRule(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedRule() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getVariableToAdd()
	 */
	public List getVariableToAdd() {
		return variableEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getVariableToRemove()
	 */
	public List getVariableToRemove() {
		return variableEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getVariableToEdit()
	 */
	public Map getVariableToEdit() {
		return variableEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getVariableToMove()
	 */
	public List getVariableToMove() {
		return variableEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getVariableTable()
	 */
	public List getVariableTable() {
		return variableEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initVariable(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initVariable(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			variableEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			variableEditUtil = new EMFListEditUtil(current, feature);
		this.variable.setInput(variableEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateVariable(EObject newValue)
	 */
	public void updateVariable(EObject newValue) {
		if (variableEditUtil != null) {
			variableEditUtil.reinit(newValue);
			variable.refresh();
		}
	}

	public void setMessageForVariable(String msg, int msgLevel) {

	}

	public void unsetMessageForVariable() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getEdgeToAdd()
	 */
	public List getEdgeToAdd() {
		return edgeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getEdgeToRemove()
	 */
	public List getEdgeToRemove() {
		return edgeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getEdgeToEdit()
	 */
	public Map getEdgeToEdit() {
		return edgeEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getEdgeToMove()
	 */
	public List getEdgeToMove() {
		return edgeEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getEdgeTable()
	 */
	public List getEdgeTable() {
		return edgeEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initEdge(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initEdge(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			edgeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			edgeEditUtil = new EMFListEditUtil(current, feature);
		this.edge.setInput(edgeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateEdge(EObject newValue)
	 */
	public void updateEdge(EObject newValue) {
		if (edgeEditUtil != null) {
			edgeEditUtil.reinit(newValue);
			edge.refresh();
		}
	}

	public void setMessageForEdge(String msg, int msgLevel) {

	}

	public void unsetMessageForEdge() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getMustIsolate()
	 */
	public Boolean getMustIsolate() {
		return Boolean.valueOf(mustIsolate.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#setMustIsolate(Boolean newValue)
	 */
	public void setMustIsolate(Boolean newValue) {
		if (newValue != null) {
			mustIsolate.setSelection(newValue.booleanValue());
		} else {
			mustIsolate.setSelection(false);
		}
	}

	public void setMessageForMustIsolate(String msg, int msgLevel) {

	}

	public void unsetMessageForMustIsolate() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getNodeToAdd()
	 */
	public List getNodeToAdd() {
		return nodeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getNodeToRemove()
	 */
	public List getNodeToRemove() {
		return nodeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getNodeToEdit()
	 */
	public Map getNodeToEdit() {
		return nodeEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getNodeToMove()
	 */
	public List getNodeToMove() {
		return nodeEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getNodeTable()
	 */
	public List getNodeTable() {
		return nodeEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initNode(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initNode(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			nodeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			nodeEditUtil = new EMFListEditUtil(current, feature);
		this.node.setInput(nodeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateNode(EObject newValue)
	 */
	public void updateNode(EObject newValue) {
		if (nodeEditUtil != null) {
			nodeEditUtil.reinit(newValue);
			node.refresh();
		}
	}

	public void setMessageForNode(String msg, int msgLevel) {

	}

	public void unsetMessageForNode() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getIsTestedFirst()
	 */
	public Boolean getIsTestedFirst() {
		return Boolean.valueOf(isTestedFirst.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#setIsTestedFirst(Boolean newValue)
	 */
	public void setIsTestedFirst(Boolean newValue) {
		if (newValue != null) {
			isTestedFirst.setSelection(newValue.booleanValue());
		} else {
			isTestedFirst.setSelection(false);
		}
	}

	public void setMessageForIsTestedFirst(String msg, int msgLevel) {

	}

	public void unsetMessageForIsTestedFirst() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getBodyPartToAdd()
	 */
	public List getBodyPartToAdd() {
		return bodyPartEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getBodyPartToRemove()
	 */
	public List getBodyPartToRemove() {
		return bodyPartEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initBodyPart(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initBodyPart(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			bodyPartEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			bodyPartEditUtil = new EMFListEditUtil(current, feature);
		this.bodyPart.setInput(bodyPartEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateBodyPart(EObject newValue)
	 */
	public void updateBodyPart(EObject newValue) {
		if (bodyPartEditUtil != null) {
			bodyPartEditUtil.reinit(newValue);
			bodyPart.refresh();
		}
	}

	public void setMessageForBodyPart(String msg, int msgLevel) {

	}

	public void unsetMessageForBodyPart() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getSetupPartToAdd()
	 */
	public List getSetupPartToAdd() {
		return setupPartEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getSetupPartToRemove()
	 */
	public List getSetupPartToRemove() {
		return setupPartEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initSetupPart(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSetupPart(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			setupPartEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			setupPartEditUtil = new EMFListEditUtil(current, feature);
		this.setupPart.setInput(setupPartEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateSetupPart(EObject newValue)
	 */
	public void updateSetupPart(EObject newValue) {
		if (setupPartEditUtil != null) {
			setupPartEditUtil.reinit(newValue);
			setupPart.refresh();
		}
	}

	public void setMessageForSetupPart(String msg, int msgLevel) {

	}

	public void unsetMessageForSetupPart() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getTestToAdd()
	 */
	public List getTestToAdd() {
		return testEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getTestToRemove()
	 */
	public List getTestToRemove() {
		return testEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initTest(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTest(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			testEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			testEditUtil = new EMFListEditUtil(current, feature);
		this.test.setInput(testEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateTest(EObject newValue)
	 */
	public void updateTest(EObject newValue) {
		if (testEditUtil != null) {
			testEditUtil.reinit(newValue);
			test.refresh();
		}
	}

	public void setMessageForTest(String msg, int msgLevel) {

	}

	public void unsetMessageForTest() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getResultToAdd()
	 */
	public List getResultToAdd() {
		return resultEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getResultToRemove()
	 */
	public List getResultToRemove() {
		return resultEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getResultToEdit()
	 */
	public Map getResultToEdit() {
		return resultEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getResultToMove()
	 */
	public List getResultToMove() {
		return resultEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getResultTable()
	 */
	public List getResultTable() {
		return resultEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initResult(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initResult(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			resultEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			resultEditUtil = new EMFListEditUtil(current, feature);
		this.result.setInput(resultEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateResult(EObject newValue)
	 */
	public void updateResult(EObject newValue) {
		if (resultEditUtil != null) {
			resultEditUtil.reinit(newValue);
			result.refresh();
		}
	}

	public void setMessageForResult(String msg, int msgLevel) {

	}

	public void unsetMessageForResult() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLoopVariableToAdd()
	 */
	public List getLoopVariableToAdd() {
		return loopVariableEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLoopVariableToRemove()
	 */
	public List getLoopVariableToRemove() {
		return loopVariableEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initLoopVariable(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initLoopVariable(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			loopVariableEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			loopVariableEditUtil = new EMFListEditUtil(current, feature);
		this.loopVariable.setInput(loopVariableEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateLoopVariable(EObject newValue)
	 */
	public void updateLoopVariable(EObject newValue) {
		if (loopVariableEditUtil != null) {
			loopVariableEditUtil.reinit(newValue);
			loopVariable.refresh();
		}
	}

	public void setMessageForLoopVariable(String msg, int msgLevel) {

	}

	public void unsetMessageForLoopVariable() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getBodyOutputToAdd()
	 */
	public List getBodyOutputToAdd() {
		return bodyOutputEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getBodyOutputToRemove()
	 */
	public List getBodyOutputToRemove() {
		return bodyOutputEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initBodyOutput(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initBodyOutput(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			bodyOutputEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			bodyOutputEditUtil = new EMFListEditUtil(current, feature);
		this.bodyOutput.setInput(bodyOutputEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateBodyOutput(EObject newValue)
	 */
	public void updateBodyOutput(EObject newValue) {
		if (bodyOutputEditUtil != null) {
			bodyOutputEditUtil.reinit(newValue);
			bodyOutput.refresh();
		}
	}

	public void setMessageForBodyOutput(String msg, int msgLevel) {

	}

	public void unsetMessageForBodyOutput() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLoopVariableInputToAdd()
	 */
	public List getLoopVariableInputToAdd() {
		return loopVariableInputEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLoopVariableInputToRemove()
	 */
	public List getLoopVariableInputToRemove() {
		return loopVariableInputEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLoopVariableInputToEdit()
	 */
	public Map getLoopVariableInputToEdit() {
		return loopVariableInputEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLoopVariableInputToMove()
	 */
	public List getLoopVariableInputToMove() {
		return loopVariableInputEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#getLoopVariableInputTable()
	 */
	public List getLoopVariableInputTable() {
		return loopVariableInputEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#initLoopVariableInput(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initLoopVariableInput(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			loopVariableInputEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			loopVariableInputEditUtil = new EMFListEditUtil(current, feature);
		this.loopVariableInput.setInput(loopVariableInputEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart#updateLoopVariableInput(EObject newValue)
	 */
	public void updateLoopVariableInput(EObject newValue) {
		if (loopVariableInputEditUtil != null) {
			loopVariableInputEditUtil.reinit(newValue);
			loopVariableInput.refresh();
		}
	}

	public void setMessageForLoopVariableInput(String msg, int msgLevel) {

	}

	public void unsetMessageForLoopVariableInput() {

	}

	// Start of user code additional methods

	// End of user code
}
