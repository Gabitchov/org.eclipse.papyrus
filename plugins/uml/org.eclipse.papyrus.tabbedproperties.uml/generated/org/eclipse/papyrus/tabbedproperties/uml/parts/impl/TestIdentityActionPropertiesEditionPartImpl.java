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
import org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class TestIdentityActionPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TestIdentityActionPropertiesEditionPart {

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




	
	public TestIdentityActionPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(UMLMessages.TestIdentityActionPropertiesEditionPart_PropertiesGroupLabel);
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
   	}
	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.TestIdentityActionPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {			
			public void handleAdd() { addToOwnedComment();}
			public void handleEdit(Comment element) { editOwnedComment(element); }
			public void handleMove(Comment element, int oldIndex, int newIndex) { moveOwnedComment(element, oldIndex, newIndex); }			
			public void handleRemove(Comment element) { removeFromOwnedComment(element); }
			public void navigateTo(Comment element) { System.out.println("---> navigateTo"); }
		});
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.ownedComment, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.ownedComment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.ownedComment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.ownedComment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.ownedComment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.TestIdentityActionPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.TestIdentityAction.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createVisibilityEEnumViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.TestIdentityActionPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.TestIdentityAction.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFEnumViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createClientDependencyReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.TestIdentityActionPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {
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
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.clientDependency, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromClientDependency(Dependency element) {

		// Start of user code for the removeFromClientDependency() method body

		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.removeElement(element);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createIsLeafCheckbox(Composite parent) {
		isLeaf = new Button(parent, SWT.CHECK);
		isLeaf.setText(UMLMessages.TestIdentityActionPropertiesEditionPart_IsLeafLabel);
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.isLeaf, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createOutgoingReferencesTable(Composite parent) {
		this.outgoing = new ReferencesTable<ActivityEdge>(UMLMessages.TestIdentityActionPropertiesEditionPart_OutgoingLabel, new ReferencesTableListener<ActivityEdge>() {
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
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.outgoing,
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
		this.outgoing.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.outgoing, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.outgoing, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.outgoing, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createIncomingReferencesTable(Composite parent) {
		this.incoming = new ReferencesTable<ActivityEdge>(UMLMessages.TestIdentityActionPropertiesEditionPart_IncomingLabel, new ReferencesTableListener<ActivityEdge>() {
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
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.incoming,
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
		this.incoming.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.incoming, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.incoming, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.incoming, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createInPartitionReferencesTable(Composite parent) {
		this.inPartition = new ReferencesTable<ActivityPartition>(UMLMessages.TestIdentityActionPropertiesEditionPart_InPartitionLabel, new ReferencesTableListener<ActivityPartition>() {
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
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.inPartition,
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
		this.inPartition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.inPartition, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.inPartition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromInPartition(ActivityPartition element) {

		// Start of user code for the removeFromInPartition() method body

		EObject editedElement = inPartitionEditUtil.foundCorrespondingEObject(element);
		inPartitionEditUtil.removeElement(element);
		inPartition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.inPartition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.inPartition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createInInterruptibleRegionReferencesTable(Composite parent) {
		this.inInterruptibleRegion = new ReferencesTable<InterruptibleActivityRegion>(UMLMessages.TestIdentityActionPropertiesEditionPart_InInterruptibleRegionLabel, new ReferencesTableListener<InterruptibleActivityRegion>() {
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
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.inInterruptibleRegion,
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
		this.inInterruptibleRegion.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.inInterruptibleRegion, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.inInterruptibleRegion, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromInInterruptibleRegion(InterruptibleActivityRegion element) {

		// Start of user code for the removeFromInInterruptibleRegion() method body

		EObject editedElement = inInterruptibleRegionEditUtil.foundCorrespondingEObject(element);
		inInterruptibleRegionEditUtil.removeElement(element);
		inInterruptibleRegion.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.inInterruptibleRegion, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.inInterruptibleRegion, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createRedefinedNodeReferencesTable(Composite parent) {
		this.redefinedNode = new ReferencesTable<ActivityNode>(UMLMessages.TestIdentityActionPropertiesEditionPart_RedefinedNodeLabel, new ReferencesTableListener<ActivityNode>() {
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
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.redefinedNode,
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
		this.redefinedNode.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.redefinedNode, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.redefinedNode, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.redefinedNode, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createHandlerTableComposition(Composite parent) {
		this.handler = new ReferencesTable<ExceptionHandler>(UMLMessages.TestIdentityActionPropertiesEditionPart_HandlerLabel, new ReferencesTableListener<ExceptionHandler>() {			
			public void handleAdd() { addToHandler();}
			public void handleEdit(ExceptionHandler element) { editHandler(element); }
			public void handleMove(ExceptionHandler element, int oldIndex, int newIndex) { moveHandler(element, oldIndex, newIndex); }			
			public void handleRemove(ExceptionHandler element) { removeFromHandler(element); }
			public void navigateTo(ExceptionHandler element) { System.out.println("---> navigateTo"); }
		});
		this.handler.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.handler, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.handler, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.handler, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.handler, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.handler, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createLocalPreconditionTableComposition(Composite parent) {
		this.localPrecondition = new ReferencesTable<Constraint>(UMLMessages.TestIdentityActionPropertiesEditionPart_LocalPreconditionLabel, new ReferencesTableListener<Constraint>() {			
			public void handleAdd() { addToLocalPrecondition();}
			public void handleEdit(Constraint element) { editLocalPrecondition(element); }
			public void handleMove(Constraint element, int oldIndex, int newIndex) { moveLocalPrecondition(element, oldIndex, newIndex); }			
			public void handleRemove(Constraint element) { removeFromLocalPrecondition(element); }
			public void navigateTo(Constraint element) { System.out.println("---> navigateTo"); }
		});
		this.localPrecondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.localPrecondition, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.localPrecondition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.localPrecondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.localPrecondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.localPrecondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createLocalPostconditionTableComposition(Composite parent) {
		this.localPostcondition = new ReferencesTable<Constraint>(UMLMessages.TestIdentityActionPropertiesEditionPart_LocalPostconditionLabel, new ReferencesTableListener<Constraint>() {			
			public void handleAdd() { addToLocalPostcondition();}
			public void handleEdit(Constraint element) { editLocalPostcondition(element); }
			public void handleMove(Constraint element, int oldIndex, int newIndex) { moveLocalPostcondition(element, oldIndex, newIndex); }			
			public void handleRemove(Constraint element) { removeFromLocalPostcondition(element); }
			public void navigateTo(Constraint element) { System.out.println("---> navigateTo"); }
		});
		this.localPostcondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TestIdentityAction.localPostcondition, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.localPostcondition, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.localPostcondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.localPostcondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(TestIdentityActionPropertiesEditionPartImpl.this, UMLViewsRepository.TestIdentityAction.localPostcondition, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initOwnedComment(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.setSelection(new StructuredSelection(current));
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initClientDependency(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateClientDependency(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#setIsLeaf(Boolean newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getOutgoingToAdd()
	 */
	public List getOutgoingToAdd() {
		return outgoingEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getOutgoingToRemove()
	 */
	public List getOutgoingToRemove() {
		return outgoingEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initOutgoing(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateOutgoing(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getIncomingToAdd()
	 */
	public List getIncomingToAdd() {
		return incomingEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getIncomingToRemove()
	 */
	public List getIncomingToRemove() {
		return incomingEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initIncoming(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateIncoming(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getInPartitionToAdd()
	 */
	public List getInPartitionToAdd() {
		return inPartitionEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getInPartitionToRemove()
	 */
	public List getInPartitionToRemove() {
		return inPartitionEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initInPartition(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateInPartition(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getInInterruptibleRegionToAdd()
	 */
	public List getInInterruptibleRegionToAdd() {
		return inInterruptibleRegionEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getInInterruptibleRegionToRemove()
	 */
	public List getInInterruptibleRegionToRemove() {
		return inInterruptibleRegionEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initInInterruptibleRegion(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateInInterruptibleRegion(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getRedefinedNodeToAdd()
	 */
	public List getRedefinedNodeToAdd() {
		return redefinedNodeEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getRedefinedNodeToRemove()
	 */
	public List getRedefinedNodeToRemove() {
		return redefinedNodeEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initRedefinedNode(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateRedefinedNode(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getHandlerToAdd()
	 */
	public List getHandlerToAdd() {
		return handlerEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getHandlerToRemove()
	 */
	public List getHandlerToRemove() {
		return handlerEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getHandlerToEdit()
	 */
	public Map getHandlerToEdit() {
		return handlerEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getHandlerToMove()
	 */
	public List getHandlerToMove() {
		return handlerEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getHandlerTable()
	 */
	public List getHandlerTable() {
		return handlerEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initHandler(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateHandler(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPreconditionToAdd()
	 */
	public List getLocalPreconditionToAdd() {
		return localPreconditionEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPreconditionToRemove()
	 */
	public List getLocalPreconditionToRemove() {
		return localPreconditionEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPreconditionToEdit()
	 */
	public Map getLocalPreconditionToEdit() {
		return localPreconditionEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPreconditionToMove()
	 */
	public List getLocalPreconditionToMove() {
		return localPreconditionEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPreconditionTable()
	 */
	public List getLocalPreconditionTable() {
		return localPreconditionEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initLocalPrecondition(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateLocalPrecondition(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPostconditionToAdd()
	 */
	public List getLocalPostconditionToAdd() {
		return localPostconditionEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPostconditionToRemove()
	 */
	public List getLocalPostconditionToRemove() {
		return localPostconditionEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPostconditionToEdit()
	 */
	public Map getLocalPostconditionToEdit() {
		return localPostconditionEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPostconditionToMove()
	 */
	public List getLocalPostconditionToMove() {
		return localPostconditionEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#getLocalPostconditionTable()
	 */
	public List getLocalPostconditionTable() {
		return localPostconditionEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#initLocalPostcondition(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TestIdentityActionPropertiesEditionPart#updateLocalPostcondition(EObject newValue)
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

	
	

	
	



	// Start of user code additional methods
 	
	// End of user code
}	
