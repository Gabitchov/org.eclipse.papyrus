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
import org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InformationFlowPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, InformationFlowPropertiesEditionPart {

	private EMFListEditUtil ownedCommentEditUtil;
	private ReferencesTable<?> ownedComment;
	private Text name;
	private EMFEnumViewer visibility;
	private EMFListEditUtil clientDependencyEditUtil;
	private ReferencesTable<?> clientDependency;
	private EMFListEditUtil realizationEditUtil;
	private ReferencesTable<?> realization;
	private EMFListEditUtil conveyedEditUtil;
	private ReferencesTable<?> conveyed;
	private EMFListEditUtil informationSourceEditUtil;
	private ReferencesTable<?> informationSource;
	private EMFListEditUtil informationTargetEditUtil;
	private ReferencesTable<?> informationTarget;
	private EMFListEditUtil realizingActivityEdgeEditUtil;
	private ReferencesTable<?> realizingActivityEdge;
	private EMFListEditUtil realizingConnectorEditUtil;
	private ReferencesTable<?> realizingConnector;
	private EMFListEditUtil realizingMessageEditUtil;
	private ReferencesTable<?> realizingMessage;




	
	public InformationFlowPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(UMLMessages.InformationFlowPropertiesEditionPart_PropertiesGroupLabel);
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
		createRealizationReferencesTable(propertiesGroup);
		createConveyedReferencesTable(propertiesGroup);
		createInformationSourceReferencesTable(propertiesGroup);
		createInformationTargetReferencesTable(propertiesGroup);
		createRealizingActivityEdgeReferencesTable(propertiesGroup);
		createRealizingConnectorReferencesTable(propertiesGroup);
		createRealizingMessageReferencesTable(propertiesGroup);
   	}
	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.InformationFlowPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {			
			public void handleAdd() { addToOwnedComment();}
			public void handleEdit(Comment element) { editOwnedComment(element); }
			public void handleMove(Comment element, int oldIndex, int newIndex) { moveOwnedComment(element, oldIndex, newIndex); }			
			public void handleRemove(Comment element) { removeFromOwnedComment(element); }
			public void navigateTo(Comment element) { System.out.println("---> navigateTo"); }
		});
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.ownedComment, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.ownedComment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.ownedComment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.ownedComment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.ownedComment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.InformationFlowPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.InformationFlow.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createVisibilityEEnumViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.InformationFlowPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.InformationFlow.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFEnumViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createClientDependencyReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.InformationFlowPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {
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
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.clientDependency, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromClientDependency(Dependency element) {

		// Start of user code for the removeFromClientDependency() method body

		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.removeElement(element);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

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
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createRealizationReferencesTable(Composite parent) {
		this.realization = new ReferencesTable<Relationship>(UMLMessages.InformationFlowPropertiesEditionPart_RealizationLabel, new ReferencesTableListener<Relationship>() {
			public void handleAdd() {				
				ViewerFilter realizationFilter = new EObjectFilter(UMLPackage.eINSTANCE.getRelationship());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!realizationEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { realizationFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Relationship> dialog = new TabElementTreeSelectionDialog<Relationship>(resourceSet, filters,
				"Relationship", UMLPackage.eINSTANCE.getRelationship()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!realizationEditUtil.getVirtualList().contains(elem))
								realizationEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realization,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						realization.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(Relationship element) { editRealization(element); }
			public void handleMove(Relationship element, int oldIndex, int newIndex) { moveRealization(element, oldIndex, newIndex); }
			public void handleRemove(Relationship element) { removeFromRealization(element); }
			public void navigateTo(Relationship element) { System.out.println("---> navigateTo"); }
		});
		this.realization.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.realization, UMLViewsRepository.SWT_KIND));
		this.realization.createControls(parent);
		GridData realizationData = new GridData(GridData.FILL_HORIZONTAL);
		realizationData.horizontalSpan = 3;
		this.realization.setLayoutData(realizationData);
		this.realization.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveRealization(Relationship element, int oldIndex, int newIndex) {
	}
	
	/**
	 * 
	 */
	private void removeFromRealization(Relationship element) {

		// Start of user code for the removeFromRealization() method body

		EObject editedElement = realizationEditUtil.foundCorrespondingEObject(element);
		realizationEditUtil.removeElement(element);
		realization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realization, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editRealization(Relationship element) {

		// Start of user code editRealization() method body
				 
		EObject editedElement = realizationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				realizationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				realization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realization, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createConveyedReferencesTable(Composite parent) {
		this.conveyed = new ReferencesTable<Classifier>(UMLMessages.InformationFlowPropertiesEditionPart_ConveyedLabel, new ReferencesTableListener<Classifier>() {
			public void handleAdd() {				
				ViewerFilter conveyedFilter = new EObjectFilter(UMLPackage.eINSTANCE.getClassifier());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!conveyedEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { conveyedFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, filters,
				"Classifier", UMLPackage.eINSTANCE.getClassifier()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!conveyedEditUtil.getVirtualList().contains(elem))
								conveyedEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.conveyed,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						conveyed.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(Classifier element) { editConveyed(element); }
			public void handleMove(Classifier element, int oldIndex, int newIndex) { moveConveyed(element, oldIndex, newIndex); }
			public void handleRemove(Classifier element) { removeFromConveyed(element); }
			public void navigateTo(Classifier element) { System.out.println("---> navigateTo"); }
		});
		this.conveyed.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.conveyed, UMLViewsRepository.SWT_KIND));
		this.conveyed.createControls(parent);
		GridData conveyedData = new GridData(GridData.FILL_HORIZONTAL);
		conveyedData.horizontalSpan = 3;
		this.conveyed.setLayoutData(conveyedData);
		this.conveyed.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveConveyed(Classifier element, int oldIndex, int newIndex) {
	}
	
	/**
	 * 
	 */
	private void removeFromConveyed(Classifier element) {

		// Start of user code for the removeFromConveyed() method body

		EObject editedElement = conveyedEditUtil.foundCorrespondingEObject(element);
		conveyedEditUtil.removeElement(element);
		conveyed.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.conveyed, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editConveyed(Classifier element) {

		// Start of user code editConveyed() method body
				 
		EObject editedElement = conveyedEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				conveyedEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				conveyed.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.conveyed, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createInformationSourceReferencesTable(Composite parent) {
		this.informationSource = new ReferencesTable<NamedElement>(UMLMessages.InformationFlowPropertiesEditionPart_InformationSourceLabel, new ReferencesTableListener<NamedElement>() {
			public void handleAdd() {				
				ViewerFilter informationSourceFilter = new EObjectFilter(UMLPackage.eINSTANCE.getNamedElement());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!informationSourceEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { informationSourceFilter, viewerFilter };		
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, filters,
				"NamedElement", UMLPackage.eINSTANCE.getNamedElement()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!informationSourceEditUtil.getVirtualList().contains(elem))
								informationSourceEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.informationSource,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						informationSource.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(NamedElement element) { editInformationSource(element); }
			public void handleMove(NamedElement element, int oldIndex, int newIndex) { moveInformationSource(element, oldIndex, newIndex); }
			public void handleRemove(NamedElement element) { removeFromInformationSource(element); }
			public void navigateTo(NamedElement element) { System.out.println("---> navigateTo"); }
		});
		this.informationSource.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.informationSource, UMLViewsRepository.SWT_KIND));
		this.informationSource.createControls(parent);
		GridData informationSourceData = new GridData(GridData.FILL_HORIZONTAL);
		informationSourceData.horizontalSpan = 3;
		this.informationSource.setLayoutData(informationSourceData);
		this.informationSource.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveInformationSource(NamedElement element, int oldIndex, int newIndex) {
	}
	
	/**
	 * 
	 */
	private void removeFromInformationSource(NamedElement element) {

		// Start of user code for the removeFromInformationSource() method body

		EObject editedElement = informationSourceEditUtil.foundCorrespondingEObject(element);
		informationSourceEditUtil.removeElement(element);
		informationSource.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.informationSource, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editInformationSource(NamedElement element) {

		// Start of user code editInformationSource() method body
				 
		EObject editedElement = informationSourceEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				informationSourceEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				informationSource.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.informationSource, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createInformationTargetReferencesTable(Composite parent) {
		this.informationTarget = new ReferencesTable<NamedElement>(UMLMessages.InformationFlowPropertiesEditionPart_InformationTargetLabel, new ReferencesTableListener<NamedElement>() {
			public void handleAdd() {				
				ViewerFilter informationTargetFilter = new EObjectFilter(UMLPackage.eINSTANCE.getNamedElement());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!informationTargetEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { informationTargetFilter, viewerFilter };		
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, filters,
				"NamedElement", UMLPackage.eINSTANCE.getNamedElement()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!informationTargetEditUtil.getVirtualList().contains(elem))
								informationTargetEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.informationTarget,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						informationTarget.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(NamedElement element) { editInformationTarget(element); }
			public void handleMove(NamedElement element, int oldIndex, int newIndex) { moveInformationTarget(element, oldIndex, newIndex); }
			public void handleRemove(NamedElement element) { removeFromInformationTarget(element); }
			public void navigateTo(NamedElement element) { System.out.println("---> navigateTo"); }
		});
		this.informationTarget.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.informationTarget, UMLViewsRepository.SWT_KIND));
		this.informationTarget.createControls(parent);
		GridData informationTargetData = new GridData(GridData.FILL_HORIZONTAL);
		informationTargetData.horizontalSpan = 3;
		this.informationTarget.setLayoutData(informationTargetData);
		this.informationTarget.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveInformationTarget(NamedElement element, int oldIndex, int newIndex) {
	}
	
	/**
	 * 
	 */
	private void removeFromInformationTarget(NamedElement element) {

		// Start of user code for the removeFromInformationTarget() method body

		EObject editedElement = informationTargetEditUtil.foundCorrespondingEObject(element);
		informationTargetEditUtil.removeElement(element);
		informationTarget.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.informationTarget, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editInformationTarget(NamedElement element) {

		// Start of user code editInformationTarget() method body
				 
		EObject editedElement = informationTargetEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				informationTargetEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				informationTarget.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.informationTarget, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createRealizingActivityEdgeReferencesTable(Composite parent) {
		this.realizingActivityEdge = new ReferencesTable<ActivityEdge>(UMLMessages.InformationFlowPropertiesEditionPart_RealizingActivityEdgeLabel, new ReferencesTableListener<ActivityEdge>() {
			public void handleAdd() {				
				ViewerFilter realizingActivityEdgeFilter = new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!realizingActivityEdgeEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { realizingActivityEdgeFilter, viewerFilter };		
				TabElementTreeSelectionDialog<ActivityEdge> dialog = new TabElementTreeSelectionDialog<ActivityEdge>(resourceSet, filters,
				"ActivityEdge", UMLPackage.eINSTANCE.getActivityEdge()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!realizingActivityEdgeEditUtil.getVirtualList().contains(elem))
								realizingActivityEdgeEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingActivityEdge,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						realizingActivityEdge.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(ActivityEdge element) { editRealizingActivityEdge(element); }
			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) { moveRealizingActivityEdge(element, oldIndex, newIndex); }
			public void handleRemove(ActivityEdge element) { removeFromRealizingActivityEdge(element); }
			public void navigateTo(ActivityEdge element) { System.out.println("---> navigateTo"); }
		});
		this.realizingActivityEdge.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.realizingActivityEdge, UMLViewsRepository.SWT_KIND));
		this.realizingActivityEdge.createControls(parent);
		GridData realizingActivityEdgeData = new GridData(GridData.FILL_HORIZONTAL);
		realizingActivityEdgeData.horizontalSpan = 3;
		this.realizingActivityEdge.setLayoutData(realizingActivityEdgeData);
		this.realizingActivityEdge.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveRealizingActivityEdge(ActivityEdge element, int oldIndex, int newIndex) {
	}
	
	/**
	 * 
	 */
	private void removeFromRealizingActivityEdge(ActivityEdge element) {

		// Start of user code for the removeFromRealizingActivityEdge() method body

		EObject editedElement = realizingActivityEdgeEditUtil.foundCorrespondingEObject(element);
		realizingActivityEdgeEditUtil.removeElement(element);
		realizingActivityEdge.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingActivityEdge, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editRealizingActivityEdge(ActivityEdge element) {

		// Start of user code editRealizingActivityEdge() method body
				 
		EObject editedElement = realizingActivityEdgeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				realizingActivityEdgeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				realizingActivityEdge.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingActivityEdge, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createRealizingConnectorReferencesTable(Composite parent) {
		this.realizingConnector = new ReferencesTable<Connector>(UMLMessages.InformationFlowPropertiesEditionPart_RealizingConnectorLabel, new ReferencesTableListener<Connector>() {
			public void handleAdd() {				
				ViewerFilter realizingConnectorFilter = new EObjectFilter(UMLPackage.eINSTANCE.getConnector());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!realizingConnectorEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { realizingConnectorFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Connector> dialog = new TabElementTreeSelectionDialog<Connector>(resourceSet, filters,
				"Connector", UMLPackage.eINSTANCE.getConnector()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!realizingConnectorEditUtil.getVirtualList().contains(elem))
								realizingConnectorEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingConnector,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						realizingConnector.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(Connector element) { editRealizingConnector(element); }
			public void handleMove(Connector element, int oldIndex, int newIndex) { moveRealizingConnector(element, oldIndex, newIndex); }
			public void handleRemove(Connector element) { removeFromRealizingConnector(element); }
			public void navigateTo(Connector element) { System.out.println("---> navigateTo"); }
		});
		this.realizingConnector.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.realizingConnector, UMLViewsRepository.SWT_KIND));
		this.realizingConnector.createControls(parent);
		GridData realizingConnectorData = new GridData(GridData.FILL_HORIZONTAL);
		realizingConnectorData.horizontalSpan = 3;
		this.realizingConnector.setLayoutData(realizingConnectorData);
		this.realizingConnector.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveRealizingConnector(Connector element, int oldIndex, int newIndex) {
				
		EObject editedElement = realizingConnectorEditUtil.foundCorrespondingEObject(element);
		realizingConnectorEditUtil.moveElement(element, oldIndex, newIndex);
		realizingConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingConnector, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromRealizingConnector(Connector element) {

		// Start of user code for the removeFromRealizingConnector() method body

		EObject editedElement = realizingConnectorEditUtil.foundCorrespondingEObject(element);
		realizingConnectorEditUtil.removeElement(element);
		realizingConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingConnector, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editRealizingConnector(Connector element) {

		// Start of user code editRealizingConnector() method body
				 
		EObject editedElement = realizingConnectorEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				realizingConnectorEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				realizingConnector.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingConnector, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createRealizingMessageReferencesTable(Composite parent) {
		this.realizingMessage = new ReferencesTable<Message>(UMLMessages.InformationFlowPropertiesEditionPart_RealizingMessageLabel, new ReferencesTableListener<Message>() {
			public void handleAdd() {				
				ViewerFilter realizingMessageFilter = new EObjectFilter(UMLPackage.eINSTANCE.getMessage());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!realizingMessageEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { realizingMessageFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Message> dialog = new TabElementTreeSelectionDialog<Message>(resourceSet, filters,
				"Message", UMLPackage.eINSTANCE.getMessage()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!realizingMessageEditUtil.getVirtualList().contains(elem))
								realizingMessageEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingMessage,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						realizingMessage.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(Message element) { editRealizingMessage(element); }
			public void handleMove(Message element, int oldIndex, int newIndex) { moveRealizingMessage(element, oldIndex, newIndex); }
			public void handleRemove(Message element) { removeFromRealizingMessage(element); }
			public void navigateTo(Message element) { System.out.println("---> navigateTo"); }
		});
		this.realizingMessage.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.realizingMessage, UMLViewsRepository.SWT_KIND));
		this.realizingMessage.createControls(parent);
		GridData realizingMessageData = new GridData(GridData.FILL_HORIZONTAL);
		realizingMessageData.horizontalSpan = 3;
		this.realizingMessage.setLayoutData(realizingMessageData);
		this.realizingMessage.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveRealizingMessage(Message element, int oldIndex, int newIndex) {
				
		EObject editedElement = realizingMessageEditUtil.foundCorrespondingEObject(element);
		realizingMessageEditUtil.moveElement(element, oldIndex, newIndex);
		realizingMessage.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingMessage, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromRealizingMessage(Message element) {

		// Start of user code for the removeFromRealizingMessage() method body

		EObject editedElement = realizingMessageEditUtil.foundCorrespondingEObject(element);
		realizingMessageEditUtil.removeElement(element);
		realizingMessage.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingMessage, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editRealizingMessage(Message element) {

		// Start of user code editRealizingMessage() method body
				 
		EObject editedElement = realizingMessageEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				realizingMessageEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				realizingMessage.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InformationFlowPropertiesEditionPartImpl.this, UMLViewsRepository.InformationFlow.realizingMessage, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initOwnedComment(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.setSelection(new StructuredSelection(current));
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initClientDependency(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateClientDependency(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizationToAdd()
	 */
	public List getRealizationToAdd() {
		return realizationEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizationToRemove()
	 */
	public List getRealizationToRemove() {
		return realizationEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initRealization(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRealization(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			realizationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			realizationEditUtil = new EMFListEditUtil(current, feature);	
		this.realization.setInput(realizationEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateRealization(EObject newValue)
	 */
	public void updateRealization(EObject newValue) {
		if(realizationEditUtil!=null){
			realizationEditUtil.reinit(newValue);
			realization.refresh();
		}		
	}
	
	public void setMessageForRealization (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForRealization () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getConveyedToAdd()
	 */
	public List getConveyedToAdd() {
		return conveyedEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getConveyedToRemove()
	 */
	public List getConveyedToRemove() {
		return conveyedEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initConveyed(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initConveyed(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			conveyedEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			conveyedEditUtil = new EMFListEditUtil(current, feature);	
		this.conveyed.setInput(conveyedEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateConveyed(EObject newValue)
	 */
	public void updateConveyed(EObject newValue) {
		if(conveyedEditUtil!=null){
			conveyedEditUtil.reinit(newValue);
			conveyed.refresh();
		}		
	}
	
	public void setMessageForConveyed (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForConveyed () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationSourceToAdd()
	 */
	public List getInformationSourceToAdd() {
		return informationSourceEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationSourceToRemove()
	 */
	public List getInformationSourceToRemove() {
		return informationSourceEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initInformationSource(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initInformationSource(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			informationSourceEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			informationSourceEditUtil = new EMFListEditUtil(current, feature);	
		this.informationSource.setInput(informationSourceEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateInformationSource(EObject newValue)
	 */
	public void updateInformationSource(EObject newValue) {
		if(informationSourceEditUtil!=null){
			informationSourceEditUtil.reinit(newValue);
			informationSource.refresh();
		}		
	}
	
	public void setMessageForInformationSource (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForInformationSource () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationTargetToAdd()
	 */
	public List getInformationTargetToAdd() {
		return informationTargetEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationTargetToRemove()
	 */
	public List getInformationTargetToRemove() {
		return informationTargetEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initInformationTarget(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initInformationTarget(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			informationTargetEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			informationTargetEditUtil = new EMFListEditUtil(current, feature);	
		this.informationTarget.setInput(informationTargetEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateInformationTarget(EObject newValue)
	 */
	public void updateInformationTarget(EObject newValue) {
		if(informationTargetEditUtil!=null){
			informationTargetEditUtil.reinit(newValue);
			informationTarget.refresh();
		}		
	}
	
	public void setMessageForInformationTarget (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForInformationTarget () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingActivityEdgeToAdd()
	 */
	public List getRealizingActivityEdgeToAdd() {
		return realizingActivityEdgeEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingActivityEdgeToRemove()
	 */
	public List getRealizingActivityEdgeToRemove() {
		return realizingActivityEdgeEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initRealizingActivityEdge(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRealizingActivityEdge(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			realizingActivityEdgeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			realizingActivityEdgeEditUtil = new EMFListEditUtil(current, feature);	
		this.realizingActivityEdge.setInput(realizingActivityEdgeEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateRealizingActivityEdge(EObject newValue)
	 */
	public void updateRealizingActivityEdge(EObject newValue) {
		if(realizingActivityEdgeEditUtil!=null){
			realizingActivityEdgeEditUtil.reinit(newValue);
			realizingActivityEdge.refresh();
		}		
	}
	
	public void setMessageForRealizingActivityEdge (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForRealizingActivityEdge () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingConnectorToAdd()
	 */
	public List getRealizingConnectorToAdd() {
		return realizingConnectorEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingConnectorToRemove()
	 */
	public List getRealizingConnectorToRemove() {
		return realizingConnectorEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initRealizingConnector(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRealizingConnector(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			realizingConnectorEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			realizingConnectorEditUtil = new EMFListEditUtil(current, feature);	
		this.realizingConnector.setInput(realizingConnectorEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateRealizingConnector(EObject newValue)
	 */
	public void updateRealizingConnector(EObject newValue) {
		if(realizingConnectorEditUtil!=null){
			realizingConnectorEditUtil.reinit(newValue);
			realizingConnector.refresh();
		}		
	}
	
	public void setMessageForRealizingConnector (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForRealizingConnector () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingMessageToAdd()
	 */
	public List getRealizingMessageToAdd() {
		return realizingMessageEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingMessageToRemove()
	 */
	public List getRealizingMessageToRemove() {
		return realizingMessageEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initRealizingMessage(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRealizingMessage(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			realizingMessageEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			realizingMessageEditUtil = new EMFListEditUtil(current, feature);	
		this.realizingMessage.setInput(realizingMessageEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateRealizingMessage(EObject newValue)
	 */
	public void updateRealizingMessage(EObject newValue) {
		if(realizingMessageEditUtil!=null){
			realizingMessageEditUtil.reinit(newValue);
			realizingMessage.refresh();
		}		
	}
	
	public void setMessageForRealizingMessage (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForRealizingMessage () {
	
	}

	
	

	
	



	// Start of user code additional methods
 	
	// End of user code
}	
