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
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFEnumViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart;
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
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Variable;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ConditionalNodePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ConditionalNodePropertiesEditionPart {

	private EMFListEditUtil ownedCommentEditUtil;
	private ReferencesTable<?> ownedComment;
	private Text name;
	private EMFEnumViewer visibility;
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
	private Button isDeterminate;
	private Button isAssured;
	private EMFListEditUtil clauseEditUtil;
	private ReferencesTable<?> clause;
	private EMFListEditUtil resultEditUtil;
	private ReferencesTable<?> result;




	
	public ConditionalNodePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(UMLMessages.ConditionalNodePropertiesEditionPart_PropertiesGroupLabel);
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
		createIsDeterminateCheckbox(propertiesGroup);
		createIsAssuredCheckbox(propertiesGroup);
		createClauseTableComposition(propertiesGroup);
		createResultTableComposition(propertiesGroup);
   	}
	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.ConditionalNodePropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {			
			public void handleAdd() { addToOwnedComment();}
			public void handleEdit(Comment element) { editOwnedComment(element); }
			public void handleMove(Comment element, int oldIndex, int newIndex) { moveOwnedComment(element, oldIndex, newIndex); }			
			public void handleRemove(Comment element) { removeFromOwnedComment(element); }
			public void navigateTo(Comment element) { System.out.println("---> navigateTo"); }
		});
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.ownedComment, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.ownedComment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.addElement(propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.ownedComment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.ownedComment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editOwnedComment(Comment element) {

		// Start of user code editOwnedComment() method body
				 
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.ownedComment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ConditionalNodePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.ConditionalNode.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createVisibilityEEnumViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ConditionalNodePropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.ConditionalNode.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFEnumViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createClientDependencyReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.ConditionalNodePropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {
			public void handleAdd() {				
				ViewerFilter clientDependencyFilter = new EObjectFilter(UMLPackage.eINSTANCE.getDependency());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!clientDependencyEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { clientDependencyFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, filters,
				"Dependency", UMLPackage.eINSTANCE.getDependency()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.clientDependency,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						clientDependency.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(Dependency element) { editClientDependency(element); }
			public void handleMove(Dependency element, int oldIndex, int newIndex) { moveClientDependency(element, oldIndex, newIndex); }
			public void handleRemove(Dependency element) { removeFromClientDependency(element); }
			public void navigateTo(Dependency element) { System.out.println("---> navigateTo"); }
		});
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.clientDependency, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromClientDependency(Dependency element) {

		// Start of user code for the removeFromClientDependency() method body

		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.removeElement(element);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editClientDependency(Dependency element) {

		// Start of user code editClientDependency() method body
				 
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				clientDependencyEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				clientDependency.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createIsLeafCheckbox(Composite parent) {
		isLeaf = new Button(parent, SWT.CHECK);
		isLeaf.setText(UMLMessages.ConditionalNodePropertiesEditionPart_IsLeafLabel);
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.isLeaf, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createOutgoingReferencesTable(Composite parent) {
		this.outgoing = new ReferencesTable<ActivityEdge>(UMLMessages.ConditionalNodePropertiesEditionPart_OutgoingLabel, new ReferencesTableListener<ActivityEdge>() {
			public void handleAdd() {				
				ViewerFilter outgoingFilter = new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!outgoingEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { outgoingFilter, viewerFilter };		
				TabElementTreeSelectionDialog<ActivityEdge> dialog = new TabElementTreeSelectionDialog<ActivityEdge>(resourceSet, filters,
				"ActivityEdge", UMLPackage.eINSTANCE.getActivityEdge()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!outgoingEditUtil.getVirtualList().contains(elem))
								outgoingEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.outgoing,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						outgoing.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(ActivityEdge element) { editOutgoing(element); }
			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) { moveOutgoing(element, oldIndex, newIndex); }
			public void handleRemove(ActivityEdge element) { removeFromOutgoing(element); }
			public void navigateTo(ActivityEdge element) { System.out.println("---> navigateTo"); }
		});
		this.outgoing.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.outgoing, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.outgoing, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editOutgoing(ActivityEdge element) {

		// Start of user code editOutgoing() method body
				 
		EObject editedElement = outgoingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				outgoingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				outgoing.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.outgoing, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createIncomingReferencesTable(Composite parent) {
		this.incoming = new ReferencesTable<ActivityEdge>(UMLMessages.ConditionalNodePropertiesEditionPart_IncomingLabel, new ReferencesTableListener<ActivityEdge>() {
			public void handleAdd() {				
				ViewerFilter incomingFilter = new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!incomingEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { incomingFilter, viewerFilter };		
				TabElementTreeSelectionDialog<ActivityEdge> dialog = new TabElementTreeSelectionDialog<ActivityEdge>(resourceSet, filters,
				"ActivityEdge", UMLPackage.eINSTANCE.getActivityEdge()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!incomingEditUtil.getVirtualList().contains(elem))
								incomingEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.incoming,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						incoming.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(ActivityEdge element) { editIncoming(element); }
			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) { moveIncoming(element, oldIndex, newIndex); }
			public void handleRemove(ActivityEdge element) { removeFromIncoming(element); }
			public void navigateTo(ActivityEdge element) { System.out.println("---> navigateTo"); }
		});
		this.incoming.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.incoming, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.incoming, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editIncoming(ActivityEdge element) {

		// Start of user code editIncoming() method body
				 
		EObject editedElement = incomingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				incomingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				incoming.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.incoming, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createInPartitionReferencesTable(Composite parent) {
		this.inPartition = new ReferencesTable<ActivityPartition>(UMLMessages.ConditionalNodePropertiesEditionPart_InPartitionLabel, new ReferencesTableListener<ActivityPartition>() {
			public void handleAdd() {				
				ViewerFilter inPartitionFilter = new EObjectFilter(UMLPackage.eINSTANCE.getActivityPartition());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!inPartitionEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { inPartitionFilter, viewerFilter };		
				TabElementTreeSelectionDialog<ActivityPartition> dialog = new TabElementTreeSelectionDialog<ActivityPartition>(resourceSet, filters,
				"ActivityPartition", UMLPackage.eINSTANCE.getActivityPartition()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!inPartitionEditUtil.getVirtualList().contains(elem))
								inPartitionEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.inPartition,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						inPartition.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(ActivityPartition element) { editInPartition(element); }
			public void handleMove(ActivityPartition element, int oldIndex, int newIndex) { moveInPartition(element, oldIndex, newIndex); }
			public void handleRemove(ActivityPartition element) { removeFromInPartition(element); }
			public void navigateTo(ActivityPartition element) { System.out.println("---> navigateTo"); }
		});
		this.inPartition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.inPartition, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.inPartition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromInPartition(ActivityPartition element) {

		// Start of user code for the removeFromInPartition() method body

		EObject editedElement = inPartitionEditUtil.foundCorrespondingEObject(element);
		inPartitionEditUtil.removeElement(element);
		inPartition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.inPartition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editInPartition(ActivityPartition element) {

		// Start of user code editInPartition() method body
				 
		EObject editedElement = inPartitionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				inPartitionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				inPartition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.inPartition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createInInterruptibleRegionReferencesTable(Composite parent) {
		this.inInterruptibleRegion = new ReferencesTable<InterruptibleActivityRegion>(UMLMessages.ConditionalNodePropertiesEditionPart_InInterruptibleRegionLabel, new ReferencesTableListener<InterruptibleActivityRegion>() {
			public void handleAdd() {				
				ViewerFilter inInterruptibleRegionFilter = new EObjectFilter(UMLPackage.eINSTANCE.getInterruptibleActivityRegion());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!inInterruptibleRegionEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { inInterruptibleRegionFilter, viewerFilter };		
				TabElementTreeSelectionDialog<InterruptibleActivityRegion> dialog = new TabElementTreeSelectionDialog<InterruptibleActivityRegion>(resourceSet, filters,
				"InterruptibleActivityRegion", UMLPackage.eINSTANCE.getInterruptibleActivityRegion()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!inInterruptibleRegionEditUtil.getVirtualList().contains(elem))
								inInterruptibleRegionEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.inInterruptibleRegion,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						inInterruptibleRegion.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(InterruptibleActivityRegion element) { editInInterruptibleRegion(element); }
			public void handleMove(InterruptibleActivityRegion element, int oldIndex, int newIndex) { moveInInterruptibleRegion(element, oldIndex, newIndex); }
			public void handleRemove(InterruptibleActivityRegion element) { removeFromInInterruptibleRegion(element); }
			public void navigateTo(InterruptibleActivityRegion element) { System.out.println("---> navigateTo"); }
		});
		this.inInterruptibleRegion.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.inInterruptibleRegion, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.inInterruptibleRegion, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromInInterruptibleRegion(InterruptibleActivityRegion element) {

		// Start of user code for the removeFromInInterruptibleRegion() method body

		EObject editedElement = inInterruptibleRegionEditUtil.foundCorrespondingEObject(element);
		inInterruptibleRegionEditUtil.removeElement(element);
		inInterruptibleRegion.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.inInterruptibleRegion, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editInInterruptibleRegion(InterruptibleActivityRegion element) {

		// Start of user code editInInterruptibleRegion() method body
				 
		EObject editedElement = inInterruptibleRegionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				inInterruptibleRegionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				inInterruptibleRegion.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.inInterruptibleRegion, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createRedefinedNodeReferencesTable(Composite parent) {
		this.redefinedNode = new ReferencesTable<ActivityNode>(UMLMessages.ConditionalNodePropertiesEditionPart_RedefinedNodeLabel, new ReferencesTableListener<ActivityNode>() {
			public void handleAdd() {				
				ViewerFilter redefinedNodeFilter = new EObjectFilter(UMLPackage.eINSTANCE.getActivityNode());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!redefinedNodeEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { redefinedNodeFilter, viewerFilter };		
				TabElementTreeSelectionDialog<ActivityNode> dialog = new TabElementTreeSelectionDialog<ActivityNode>(resourceSet, filters,
				"ActivityNode", UMLPackage.eINSTANCE.getActivityNode()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!redefinedNodeEditUtil.getVirtualList().contains(elem))
								redefinedNodeEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.redefinedNode,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						redefinedNode.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(ActivityNode element) { editRedefinedNode(element); }
			public void handleMove(ActivityNode element, int oldIndex, int newIndex) { moveRedefinedNode(element, oldIndex, newIndex); }
			public void handleRemove(ActivityNode element) { removeFromRedefinedNode(element); }
			public void navigateTo(ActivityNode element) { System.out.println("---> navigateTo"); }
		});
		this.redefinedNode.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.redefinedNode, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.redefinedNode, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editRedefinedNode(ActivityNode element) {

		// Start of user code editRedefinedNode() method body
				 
		EObject editedElement = redefinedNodeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				redefinedNodeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				redefinedNode.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.redefinedNode, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createHandlerTableComposition(Composite parent) {
		this.handler = new ReferencesTable<ExceptionHandler>(UMLMessages.ConditionalNodePropertiesEditionPart_HandlerLabel, new ReferencesTableListener<ExceptionHandler>() {			
			public void handleAdd() { addToHandler();}
			public void handleEdit(ExceptionHandler element) { editHandler(element); }
			public void handleMove(ExceptionHandler element, int oldIndex, int newIndex) { moveHandler(element, oldIndex, newIndex); }			
			public void handleRemove(ExceptionHandler element) { removeFromHandler(element); }
			public void navigateTo(ExceptionHandler element) { System.out.println("---> navigateTo"); }
		});
		this.handler.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.handler, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.handler, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				handlerEditUtil.addElement(propertiesEditionObject);
				handler.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.handler, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.handler, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editHandler(ExceptionHandler element) {

		// Start of user code editHandler() method body
				 
		EObject editedElement = handlerEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				handlerEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				handler.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.handler, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createLocalPreconditionTableComposition(Composite parent) {
		this.localPrecondition = new ReferencesTable<Constraint>(UMLMessages.ConditionalNodePropertiesEditionPart_LocalPreconditionLabel, new ReferencesTableListener<Constraint>() {			
			public void handleAdd() { addToLocalPrecondition();}
			public void handleEdit(Constraint element) { editLocalPrecondition(element); }
			public void handleMove(Constraint element, int oldIndex, int newIndex) { moveLocalPrecondition(element, oldIndex, newIndex); }			
			public void handleRemove(Constraint element) { removeFromLocalPrecondition(element); }
			public void navigateTo(Constraint element) { System.out.println("---> navigateTo"); }
		});
		this.localPrecondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.localPrecondition, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.localPrecondition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				localPreconditionEditUtil.addElement(propertiesEditionObject);
				localPrecondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.localPrecondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.localPrecondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editLocalPrecondition(Constraint element) {

		// Start of user code editLocalPrecondition() method body
				 
		EObject editedElement = localPreconditionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				localPreconditionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				localPrecondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.localPrecondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createLocalPostconditionTableComposition(Composite parent) {
		this.localPostcondition = new ReferencesTable<Constraint>(UMLMessages.ConditionalNodePropertiesEditionPart_LocalPostconditionLabel, new ReferencesTableListener<Constraint>() {			
			public void handleAdd() { addToLocalPostcondition();}
			public void handleEdit(Constraint element) { editLocalPostcondition(element); }
			public void handleMove(Constraint element, int oldIndex, int newIndex) { moveLocalPostcondition(element, oldIndex, newIndex); }			
			public void handleRemove(Constraint element) { removeFromLocalPostcondition(element); }
			public void navigateTo(Constraint element) { System.out.println("---> navigateTo"); }
		});
		this.localPostcondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.localPostcondition, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.localPostcondition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				localPostconditionEditUtil.addElement(propertiesEditionObject);
				localPostcondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.localPostcondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.localPostcondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editLocalPostcondition(Constraint element) {

		// Start of user code editLocalPostcondition() method body
				 
		EObject editedElement = localPostconditionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				localPostconditionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				localPostcondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.localPostcondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createElementImportTableComposition(Composite parent) {
		this.elementImport = new ReferencesTable<ElementImport>(UMLMessages.ConditionalNodePropertiesEditionPart_ElementImportLabel, new ReferencesTableListener<ElementImport>() {			
			public void handleAdd() { addToElementImport();}
			public void handleEdit(ElementImport element) { editElementImport(element); }
			public void handleMove(ElementImport element, int oldIndex, int newIndex) { moveElementImport(element, oldIndex, newIndex); }			
			public void handleRemove(ElementImport element) { removeFromElementImport(element); }
			public void navigateTo(ElementImport element) { System.out.println("---> navigateTo"); }
		});
		this.elementImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.elementImport, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.elementImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				elementImportEditUtil.addElement(propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.elementImport, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.elementImport, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editElementImport(ElementImport element) {

		// Start of user code editElementImport() method body
				 
		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				elementImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.elementImport, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createPackageImportTableComposition(Composite parent) {
		this.packageImport = new ReferencesTable<PackageImport>(UMLMessages.ConditionalNodePropertiesEditionPart_PackageImportLabel, new ReferencesTableListener<PackageImport>() {			
			public void handleAdd() { addToPackageImport();}
			public void handleEdit(PackageImport element) { editPackageImport(element); }
			public void handleMove(PackageImport element, int oldIndex, int newIndex) { movePackageImport(element, oldIndex, newIndex); }			
			public void handleRemove(PackageImport element) { removeFromPackageImport(element); }
			public void navigateTo(PackageImport element) { System.out.println("---> navigateTo"); }
		});
		this.packageImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.packageImport, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.packageImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				packageImportEditUtil.addElement(propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.packageImport, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.packageImport, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editPackageImport(PackageImport element) {

		// Start of user code editPackageImport() method body
				 
		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				packageImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.packageImport, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createOwnedRuleTableComposition(Composite parent) {
		this.ownedRule = new ReferencesTable<Constraint>(UMLMessages.ConditionalNodePropertiesEditionPart_OwnedRuleLabel, new ReferencesTableListener<Constraint>() {			
			public void handleAdd() { addToOwnedRule();}
			public void handleEdit(Constraint element) { editOwnedRule(element); }
			public void handleMove(Constraint element, int oldIndex, int newIndex) { moveOwnedRule(element, oldIndex, newIndex); }			
			public void handleRemove(Constraint element) { removeFromOwnedRule(element); }
			public void navigateTo(Constraint element) { System.out.println("---> navigateTo"); }
		});
		this.ownedRule.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.ownedRule, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.ownedRule, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				ownedRuleEditUtil.addElement(propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.ownedRule, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.ownedRule, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editOwnedRule(Constraint element) {

		// Start of user code editOwnedRule() method body
				 
		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				ownedRuleEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.ownedRule, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createVariableTableComposition(Composite parent) {
		this.variable = new ReferencesTable<Variable>(UMLMessages.ConditionalNodePropertiesEditionPart_VariableLabel, new ReferencesTableListener<Variable>() {			
			public void handleAdd() { addToVariable();}
			public void handleEdit(Variable element) { editVariable(element); }
			public void handleMove(Variable element, int oldIndex, int newIndex) { moveVariable(element, oldIndex, newIndex); }			
			public void handleRemove(Variable element) { removeFromVariable(element); }
			public void navigateTo(Variable element) { System.out.println("---> navigateTo"); }
		});
		this.variable.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.variable, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.variable, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				variableEditUtil.addElement(propertiesEditionObject);
				variable.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.variable, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.variable, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editVariable(Variable element) {

		// Start of user code editVariable() method body
				 
		EObject editedElement = variableEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				variableEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				variable.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.variable, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createEdgeTableComposition(Composite parent) {
		this.edge = new ReferencesTable<ActivityEdge>(UMLMessages.ConditionalNodePropertiesEditionPart_EdgeLabel, new ReferencesTableListener<ActivityEdge>() {			
			public void handleAdd() { addToEdge();}
			public void handleEdit(ActivityEdge element) { editEdge(element); }
			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) { moveEdge(element, oldIndex, newIndex); }			
			public void handleRemove(ActivityEdge element) { removeFromEdge(element); }
			public void navigateTo(ActivityEdge element) { System.out.println("---> navigateTo"); }
		});
		this.edge.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.edge, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.edge, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editEdge(ActivityEdge element) {

		// Start of user code editEdge() method body
				 
		EObject editedElement = edgeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				edgeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				edge.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.edge, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createMustIsolateCheckbox(Composite parent) {
		mustIsolate = new Button(parent, SWT.CHECK);
		mustIsolate.setText(UMLMessages.ConditionalNodePropertiesEditionPart_MustIsolateLabel);
		GridData mustIsolateData = new GridData(GridData.FILL_HORIZONTAL);
		mustIsolateData.horizontalSpan = 2;
		mustIsolate.setLayoutData(mustIsolateData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.mustIsolate, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param container
	 */
	protected void createNodeTableComposition(Composite parent) {
		this.node = new ReferencesTable<ActivityNode>(UMLMessages.ConditionalNodePropertiesEditionPart_NodeLabel, new ReferencesTableListener<ActivityNode>() {			
			public void handleAdd() { addToNode();}
			public void handleEdit(ActivityNode element) { editNode(element); }
			public void handleMove(ActivityNode element, int oldIndex, int newIndex) { moveNode(element, oldIndex, newIndex); }			
			public void handleRemove(ActivityNode element) { removeFromNode(element); }
			public void navigateTo(ActivityNode element) { System.out.println("---> navigateTo"); }
		});
		this.node.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.node, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.node, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editNode(ActivityNode element) {

		// Start of user code editNode() method body
				 
		EObject editedElement = nodeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				nodeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				node.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.node, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createIsDeterminateCheckbox(Composite parent) {
		isDeterminate = new Button(parent, SWT.CHECK);
		isDeterminate.setText(UMLMessages.ConditionalNodePropertiesEditionPart_IsDeterminateLabel);
		GridData isDeterminateData = new GridData(GridData.FILL_HORIZONTAL);
		isDeterminateData.horizontalSpan = 2;
		isDeterminate.setLayoutData(isDeterminateData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.isDeterminate, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createIsAssuredCheckbox(Composite parent) {
		isAssured = new Button(parent, SWT.CHECK);
		isAssured.setText(UMLMessages.ConditionalNodePropertiesEditionPart_IsAssuredLabel);
		GridData isAssuredData = new GridData(GridData.FILL_HORIZONTAL);
		isAssuredData.horizontalSpan = 2;
		isAssured.setLayoutData(isAssuredData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.isAssured, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param container
	 */
	protected void createClauseTableComposition(Composite parent) {
		this.clause = new ReferencesTable<Clause>(UMLMessages.ConditionalNodePropertiesEditionPart_ClauseLabel, new ReferencesTableListener<Clause>() {			
			public void handleAdd() { addToClause();}
			public void handleEdit(Clause element) { editClause(element); }
			public void handleMove(Clause element, int oldIndex, int newIndex) { moveClause(element, oldIndex, newIndex); }			
			public void handleRemove(Clause element) { removeFromClause(element); }
			public void navigateTo(Clause element) { System.out.println("---> navigateTo"); }
		});
		this.clause.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.clause, UMLViewsRepository.SWT_KIND));
		this.clause.createControls(parent);
		GridData clauseData = new GridData(GridData.FILL_HORIZONTAL);
		clauseData.horizontalSpan = 3;
		this.clause.setLayoutData(clauseData);
	}
		
	/**
	 * 
	 */
	private void moveClause(Clause element, int oldIndex, int newIndex) {
				
		EObject editedElement = clauseEditUtil.foundCorrespondingEObject(element);
		clauseEditUtil.moveElement(element, oldIndex, newIndex);
		clause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.clause, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}	
	
	/**
	 * 
	 */
	private void addToClause() {
	
		// Start of user code addToClause() method body


		Clause eObject = UMLFactory.eINSTANCE.createClause();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				clauseEditUtil.addElement(propertiesEditionObject);
				clause.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.clause, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		
		
		// End of user code		
	}

	/**
	 * 
	 */
	private void removeFromClause(Clause element) {

		// Start of user code for the removeFromClause() method body

		EObject editedElement = clauseEditUtil.foundCorrespondingEObject(element);
		clauseEditUtil.removeElement(element);
		clause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.clause, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editClause(Clause element) {

		// Start of user code editClause() method body
				 
		EObject editedElement = clauseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				clauseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				clause.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.clause, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createResultTableComposition(Composite parent) {
		this.result = new ReferencesTable<OutputPin>(UMLMessages.ConditionalNodePropertiesEditionPart_ResultLabel, new ReferencesTableListener<OutputPin>() {			
			public void handleAdd() { addToResult();}
			public void handleEdit(OutputPin element) { editResult(element); }
			public void handleMove(OutputPin element, int oldIndex, int newIndex) { moveResult(element, oldIndex, newIndex); }			
			public void handleRemove(OutputPin element) { removeFromResult(element); }
			public void navigateTo(OutputPin element) { System.out.println("---> navigateTo"); }
		});
		this.result.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ConditionalNode.result, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.result, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				resultEditUtil.addElement(propertiesEditionObject);
				result.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.result, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.result, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editResult(OutputPin element) {

		// Start of user code editResult() method body
				 
		EObject editedElement = resultEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				resultEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				result.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ConditionalNodePropertiesEditionPartImpl.this, UMLViewsRepository.ConditionalNode.result, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initOwnedComment(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateOwnedComment(EObject newValue)
	 */
	public void updateOwnedComment(EObject newValue) {
		if(ownedCommentEditUtil!=null){
			ownedCommentEditUtil.reinit(newValue);
			ownedComment.refresh();
		}		
	}
	
	public void setMessageForOwnedComment (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForOwnedComment () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		name.setText(newValue);
	}
	
	public void setMessageForName (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForName () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.setSelection(new StructuredSelection(current));
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}
	
	public void setMessageForVisibility (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForVisibility () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initClientDependency(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateClientDependency(EObject newValue)
	 */
	public void updateClientDependency(EObject newValue) {
		if(clientDependencyEditUtil!=null){
			clientDependencyEditUtil.reinit(newValue);
			clientDependency.refresh();
		}		
	}
	
	public void setMessageForClientDependency (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForClientDependency () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#setIsLeaf(Boolean newValue)
	 */
	public void setIsLeaf(Boolean newValue) {
		isLeaf.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForIsLeaf (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIsLeaf () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOutgoingToAdd()
	 */
	public List getOutgoingToAdd() {
		return outgoingEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOutgoingToRemove()
	 */
	public List getOutgoingToRemove() {
		return outgoingEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initOutgoing(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateOutgoing(EObject newValue)
	 */
	public void updateOutgoing(EObject newValue) {
		if(outgoingEditUtil!=null){
			outgoingEditUtil.reinit(newValue);
			outgoing.refresh();
		}		
	}
	
	public void setMessageForOutgoing (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForOutgoing () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getIncomingToAdd()
	 */
	public List getIncomingToAdd() {
		return incomingEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getIncomingToRemove()
	 */
	public List getIncomingToRemove() {
		return incomingEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initIncoming(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateIncoming(EObject newValue)
	 */
	public void updateIncoming(EObject newValue) {
		if(incomingEditUtil!=null){
			incomingEditUtil.reinit(newValue);
			incoming.refresh();
		}		
	}
	
	public void setMessageForIncoming (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIncoming () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getInPartitionToAdd()
	 */
	public List getInPartitionToAdd() {
		return inPartitionEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getInPartitionToRemove()
	 */
	public List getInPartitionToRemove() {
		return inPartitionEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initInPartition(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateInPartition(EObject newValue)
	 */
	public void updateInPartition(EObject newValue) {
		if(inPartitionEditUtil!=null){
			inPartitionEditUtil.reinit(newValue);
			inPartition.refresh();
		}		
	}
	
	public void setMessageForInPartition (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForInPartition () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getInInterruptibleRegionToAdd()
	 */
	public List getInInterruptibleRegionToAdd() {
		return inInterruptibleRegionEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getInInterruptibleRegionToRemove()
	 */
	public List getInInterruptibleRegionToRemove() {
		return inInterruptibleRegionEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initInInterruptibleRegion(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateInInterruptibleRegion(EObject newValue)
	 */
	public void updateInInterruptibleRegion(EObject newValue) {
		if(inInterruptibleRegionEditUtil!=null){
			inInterruptibleRegionEditUtil.reinit(newValue);
			inInterruptibleRegion.refresh();
		}		
	}
	
	public void setMessageForInInterruptibleRegion (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForInInterruptibleRegion () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getRedefinedNodeToAdd()
	 */
	public List getRedefinedNodeToAdd() {
		return redefinedNodeEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getRedefinedNodeToRemove()
	 */
	public List getRedefinedNodeToRemove() {
		return redefinedNodeEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initRedefinedNode(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateRedefinedNode(EObject newValue)
	 */
	public void updateRedefinedNode(EObject newValue) {
		if(redefinedNodeEditUtil!=null){
			redefinedNodeEditUtil.reinit(newValue);
			redefinedNode.refresh();
		}		
	}
	
	public void setMessageForRedefinedNode (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForRedefinedNode () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getHandlerToAdd()
	 */
	public List getHandlerToAdd() {
		return handlerEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getHandlerToRemove()
	 */
	public List getHandlerToRemove() {
		return handlerEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getHandlerToEdit()
	 */
	public Map getHandlerToEdit() {
		return handlerEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getHandlerToMove()
	 */
	public List getHandlerToMove() {
		return handlerEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getHandlerTable()
	 */
	public List getHandlerTable() {
		return handlerEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initHandler(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateHandler(EObject newValue)
	 */
	public void updateHandler(EObject newValue) {
		if(handlerEditUtil!=null){
			handlerEditUtil.reinit(newValue);
			handler.refresh();
		}		
	}
	
	public void setMessageForHandler (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForHandler () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPreconditionToAdd()
	 */
	public List getLocalPreconditionToAdd() {
		return localPreconditionEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPreconditionToRemove()
	 */
	public List getLocalPreconditionToRemove() {
		return localPreconditionEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPreconditionToEdit()
	 */
	public Map getLocalPreconditionToEdit() {
		return localPreconditionEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPreconditionToMove()
	 */
	public List getLocalPreconditionToMove() {
		return localPreconditionEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPreconditionTable()
	 */
	public List getLocalPreconditionTable() {
		return localPreconditionEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initLocalPrecondition(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateLocalPrecondition(EObject newValue)
	 */
	public void updateLocalPrecondition(EObject newValue) {
		if(localPreconditionEditUtil!=null){
			localPreconditionEditUtil.reinit(newValue);
			localPrecondition.refresh();
		}		
	}
	
	public void setMessageForLocalPrecondition (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForLocalPrecondition () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPostconditionToAdd()
	 */
	public List getLocalPostconditionToAdd() {
		return localPostconditionEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPostconditionToRemove()
	 */
	public List getLocalPostconditionToRemove() {
		return localPostconditionEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPostconditionToEdit()
	 */
	public Map getLocalPostconditionToEdit() {
		return localPostconditionEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPostconditionToMove()
	 */
	public List getLocalPostconditionToMove() {
		return localPostconditionEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getLocalPostconditionTable()
	 */
	public List getLocalPostconditionTable() {
		return localPostconditionEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initLocalPostcondition(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateLocalPostcondition(EObject newValue)
	 */
	public void updateLocalPostcondition(EObject newValue) {
		if(localPostconditionEditUtil!=null){
			localPostconditionEditUtil.reinit(newValue);
			localPostcondition.refresh();
		}		
	}
	
	public void setMessageForLocalPostcondition (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForLocalPostcondition () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getElementImportToAdd()
	 */
	public List getElementImportToAdd() {
		return elementImportEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getElementImportToRemove()
	 */
	public List getElementImportToRemove() {
		return elementImportEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getElementImportToEdit()
	 */
	public Map getElementImportToEdit() {
		return elementImportEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getElementImportToMove()
	 */
	public List getElementImportToMove() {
		return elementImportEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getElementImportTable()
	 */
	public List getElementImportTable() {
		return elementImportEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initElementImport(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateElementImport(EObject newValue)
	 */
	public void updateElementImport(EObject newValue) {
		if(elementImportEditUtil!=null){
			elementImportEditUtil.reinit(newValue);
			elementImport.refresh();
		}		
	}
	
	public void setMessageForElementImport (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForElementImport () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getPackageImportToAdd()
	 */
	public List getPackageImportToAdd() {
		return packageImportEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getPackageImportToRemove()
	 */
	public List getPackageImportToRemove() {
		return packageImportEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getPackageImportToEdit()
	 */
	public Map getPackageImportToEdit() {
		return packageImportEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getPackageImportToMove()
	 */
	public List getPackageImportToMove() {
		return packageImportEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getPackageImportTable()
	 */
	public List getPackageImportTable() {
		return packageImportEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initPackageImport(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updatePackageImport(EObject newValue)
	 */
	public void updatePackageImport(EObject newValue) {
		if(packageImportEditUtil!=null){
			packageImportEditUtil.reinit(newValue);
			packageImport.refresh();
		}		
	}
	
	public void setMessageForPackageImport (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForPackageImport () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedRuleToAdd()
	 */
	public List getOwnedRuleToAdd() {
		return ownedRuleEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedRuleToRemove()
	 */
	public List getOwnedRuleToRemove() {
		return ownedRuleEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedRuleToEdit()
	 */
	public Map getOwnedRuleToEdit() {
		return ownedRuleEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedRuleToMove()
	 */
	public List getOwnedRuleToMove() {
		return ownedRuleEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getOwnedRuleTable()
	 */
	public List getOwnedRuleTable() {
		return ownedRuleEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initOwnedRule(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateOwnedRule(EObject newValue)
	 */
	public void updateOwnedRule(EObject newValue) {
		if(ownedRuleEditUtil!=null){
			ownedRuleEditUtil.reinit(newValue);
			ownedRule.refresh();
		}		
	}
	
	public void setMessageForOwnedRule (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForOwnedRule () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getVariableToAdd()
	 */
	public List getVariableToAdd() {
		return variableEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getVariableToRemove()
	 */
	public List getVariableToRemove() {
		return variableEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getVariableToEdit()
	 */
	public Map getVariableToEdit() {
		return variableEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getVariableToMove()
	 */
	public List getVariableToMove() {
		return variableEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getVariableTable()
	 */
	public List getVariableTable() {
		return variableEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initVariable(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateVariable(EObject newValue)
	 */
	public void updateVariable(EObject newValue) {
		if(variableEditUtil!=null){
			variableEditUtil.reinit(newValue);
			variable.refresh();
		}		
	}
	
	public void setMessageForVariable (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForVariable () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getEdgeToAdd()
	 */
	public List getEdgeToAdd() {
		return edgeEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getEdgeToRemove()
	 */
	public List getEdgeToRemove() {
		return edgeEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getEdgeToEdit()
	 */
	public Map getEdgeToEdit() {
		return edgeEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getEdgeToMove()
	 */
	public List getEdgeToMove() {
		return edgeEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getEdgeTable()
	 */
	public List getEdgeTable() {
		return edgeEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initEdge(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateEdge(EObject newValue)
	 */
	public void updateEdge(EObject newValue) {
		if(edgeEditUtil!=null){
			edgeEditUtil.reinit(newValue);
			edge.refresh();
		}		
	}
	
	public void setMessageForEdge (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForEdge () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getMustIsolate()
	 */
	public Boolean getMustIsolate() {
		return Boolean.valueOf(mustIsolate.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#setMustIsolate(Boolean newValue)
	 */
	public void setMustIsolate(Boolean newValue) {
		mustIsolate.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForMustIsolate (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForMustIsolate () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getNodeToAdd()
	 */
	public List getNodeToAdd() {
		return nodeEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getNodeToRemove()
	 */
	public List getNodeToRemove() {
		return nodeEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getNodeToEdit()
	 */
	public Map getNodeToEdit() {
		return nodeEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getNodeToMove()
	 */
	public List getNodeToMove() {
		return nodeEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getNodeTable()
	 */
	public List getNodeTable() {
		return nodeEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initNode(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateNode(EObject newValue)
	 */
	public void updateNode(EObject newValue) {
		if(nodeEditUtil!=null){
			nodeEditUtil.reinit(newValue);
			node.refresh();
		}		
	}
	
	public void setMessageForNode (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForNode () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getIsDeterminate()
	 */
	public Boolean getIsDeterminate() {
		return Boolean.valueOf(isDeterminate.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#setIsDeterminate(Boolean newValue)
	 */
	public void setIsDeterminate(Boolean newValue) {
		isDeterminate.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForIsDeterminate (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIsDeterminate () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getIsAssured()
	 */
	public Boolean getIsAssured() {
		return Boolean.valueOf(isAssured.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#setIsAssured(Boolean newValue)
	 */
	public void setIsAssured(Boolean newValue) {
		isAssured.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForIsAssured (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIsAssured () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getClauseToAdd()
	 */
	public List getClauseToAdd() {
		return clauseEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getClauseToRemove()
	 */
	public List getClauseToRemove() {
		return clauseEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getClauseToEdit()
	 */
	public Map getClauseToEdit() {
		return clauseEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getClauseToMove()
	 */
	public List getClauseToMove() {
		return clauseEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getClauseTable()
	 */
	public List getClauseTable() {
		return clauseEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initClause(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initClause(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			clauseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			clauseEditUtil = new EMFListEditUtil(current, feature);	
		this.clause.setInput(clauseEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateClause(EObject newValue)
	 */
	public void updateClause(EObject newValue) {
		if(clauseEditUtil!=null){
			clauseEditUtil.reinit(newValue);
			clause.refresh();
		}		
	}
	
	public void setMessageForClause (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForClause () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getResultToAdd()
	 */
	public List getResultToAdd() {
		return resultEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getResultToRemove()
	 */
	public List getResultToRemove() {
		return resultEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getResultToEdit()
	 */
	public Map getResultToEdit() {
		return resultEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getResultToMove()
	 */
	public List getResultToMove() {
		return resultEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#getResultTable()
	 */
	public List getResultTable() {
		return resultEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#initResult(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConditionalNodePropertiesEditionPart#updateResult(EObject newValue)
	 */
	public void updateResult(EObject newValue) {
		if(resultEditUtil!=null){
			resultEditUtil.reinit(newValue);
			result.refresh();
		}		
	}
	
	public void setMessageForResult (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForResult () {
	
	}

	
	

	
	



	// Start of user code additional methods
 	
	// End of user code
}	
