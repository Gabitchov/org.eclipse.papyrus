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
import org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DeployedArtifact;
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DeploymentPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DeploymentPropertiesEditionPart {

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

	protected EMFListEditUtil supplierEditUtil;

	protected ReferencesTable<? extends EObject> supplier;

	protected List<ViewerFilter> supplierBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> supplierFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil clientEditUtil;

	protected ReferencesTable<? extends EObject> client;

	protected List<ViewerFilter> clientBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> clientFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil deployedArtifactEditUtil;

	protected ReferencesTable<? extends EObject> deployedArtifact;

	protected List<ViewerFilter> deployedArtifactBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> deployedArtifactFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil configurationEditUtil;

	protected ReferencesTable<? extends EObject> configuration;

	protected List<ViewerFilter> configurationBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> configurationFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public DeploymentPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(UMLMessages.DeploymentPropertiesEditionPart_PropertiesGroupLabel);
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
		createSupplierAdvancedReferencesTable(propertiesGroup);
		createClientAdvancedReferencesTable(propertiesGroup);
		createDeployedArtifactAdvancedReferencesTable(propertiesGroup);
		createConfigurationAdvancedTableComposition(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentAdvancedTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.DeploymentPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Deployment.ownedComment, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.ownedComment,
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
				DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.ownedComment,
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
						DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.ownedComment,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.DeploymentPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Deployment.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Deployment.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.DeploymentPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Deployment.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Deployment.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createClientDependencyAdvancedReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.DeploymentPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, clientDependencyFilters, clientDependencyBusinessFilters,
						"Dependency", UMLPackage.eINSTANCE.getDependency(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Deployment.clientDependency, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
				DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.clientDependency,
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
						DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.clientDependency,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createSupplierAdvancedReferencesTable(Composite parent) {
		this.supplier = new ReferencesTable<NamedElement>(UMLMessages.DeploymentPropertiesEditionPart_SupplierLabel, new ReferencesTableListener<NamedElement>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, supplierFilters, supplierBusinessFilters,
						"NamedElement", UMLPackage.eINSTANCE.getNamedElement(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!supplierEditUtil.getVirtualList().contains(elem))
								supplierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.supplier,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						supplier.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(NamedElement element) {
				editSupplier(element);
			}

			public void handleMove(NamedElement element, int oldIndex, int newIndex) {
				moveSupplier(element, oldIndex, newIndex);
			}

			public void handleRemove(NamedElement element) {
				removeFromSupplier(element);
			}

			public void navigateTo(NamedElement element) {
			}
		});
		this.supplier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Deployment.supplier, UMLViewsRepository.SWT_KIND));
		this.supplier.createControls(parent);
		GridData supplierData = new GridData(GridData.FILL_HORIZONTAL);
		supplierData.horizontalSpan = 3;
		this.supplier.setLayoutData(supplierData);
		this.supplier.disableMove();
	}

	/**
	 * 
	 */
	protected void moveSupplier(NamedElement element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromSupplier(NamedElement element) {

		// Start of user code removeFromSupplier() method body
		EObject editedElement = supplierEditUtil.foundCorrespondingEObject(element);
		supplierEditUtil.removeElement(element);
		supplier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.supplier,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSupplier(NamedElement element) {

		// Start of user code editSupplier() method body
		EObject editedElement = supplierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				supplierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				supplier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.supplier,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createClientAdvancedReferencesTable(Composite parent) {
		this.client = new ReferencesTable<NamedElement>(UMLMessages.DeploymentPropertiesEditionPart_ClientLabel, new ReferencesTableListener<NamedElement>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, clientFilters, clientBusinessFilters,
						"NamedElement", UMLPackage.eINSTANCE.getNamedElement(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientEditUtil.getVirtualList().contains(elem))
								clientEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.client,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						client.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(NamedElement element) {
				editClient(element);
			}

			public void handleMove(NamedElement element, int oldIndex, int newIndex) {
				moveClient(element, oldIndex, newIndex);
			}

			public void handleRemove(NamedElement element) {
				removeFromClient(element);
			}

			public void navigateTo(NamedElement element) {
			}
		});
		this.client.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Deployment.client, UMLViewsRepository.SWT_KIND));
		this.client.createControls(parent);
		GridData clientData = new GridData(GridData.FILL_HORIZONTAL);
		clientData.horizontalSpan = 3;
		this.client.setLayoutData(clientData);
		this.client.disableMove();
	}

	/**
	 * 
	 */
	protected void moveClient(NamedElement element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromClient(NamedElement element) {

		// Start of user code removeFromClient() method body
		EObject editedElement = clientEditUtil.foundCorrespondingEObject(element);
		clientEditUtil.removeElement(element);
		client.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.client,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editClient(NamedElement element) {

		// Start of user code editClient() method body
		EObject editedElement = clientEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				clientEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				client.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.client,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createDeployedArtifactAdvancedReferencesTable(Composite parent) {
		this.deployedArtifact = new ReferencesTable<DeployedArtifact>(UMLMessages.DeploymentPropertiesEditionPart_DeployedArtifactLabel, new ReferencesTableListener<DeployedArtifact>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<DeployedArtifact> dialog = new TabElementTreeSelectionDialog<DeployedArtifact>(resourceSet, deployedArtifactFilters, deployedArtifactBusinessFilters,
						"DeployedArtifact", UMLPackage.eINSTANCE.getDeployedArtifact(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!deployedArtifactEditUtil.getVirtualList().contains(elem))
								deployedArtifactEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.deployedArtifact,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						deployedArtifact.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(DeployedArtifact element) {
				editDeployedArtifact(element);
			}

			public void handleMove(DeployedArtifact element, int oldIndex, int newIndex) {
				moveDeployedArtifact(element, oldIndex, newIndex);
			}

			public void handleRemove(DeployedArtifact element) {
				removeFromDeployedArtifact(element);
			}

			public void navigateTo(DeployedArtifact element) {
			}
		});
		this.deployedArtifact.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Deployment.deployedArtifact, UMLViewsRepository.SWT_KIND));
		this.deployedArtifact.createControls(parent);
		GridData deployedArtifactData = new GridData(GridData.FILL_HORIZONTAL);
		deployedArtifactData.horizontalSpan = 3;
		this.deployedArtifact.setLayoutData(deployedArtifactData);
		this.deployedArtifact.disableMove();
	}

	/**
	 * 
	 */
	protected void moveDeployedArtifact(DeployedArtifact element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromDeployedArtifact(DeployedArtifact element) {

		// Start of user code removeFromDeployedArtifact() method body
		EObject editedElement = deployedArtifactEditUtil.foundCorrespondingEObject(element);
		deployedArtifactEditUtil.removeElement(element);
		deployedArtifact.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.deployedArtifact,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editDeployedArtifact(DeployedArtifact element) {

		// Start of user code editDeployedArtifact() method body
		EObject editedElement = deployedArtifactEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				deployedArtifactEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				deployedArtifact.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.deployedArtifact,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createConfigurationAdvancedTableComposition(Composite parent) {
		this.configuration = new ReferencesTable<DeploymentSpecification>(UMLMessages.DeploymentPropertiesEditionPart_ConfigurationLabel, new ReferencesTableListener<DeploymentSpecification>() {

			public void handleAdd() {
				addToConfiguration();
			}

			public void handleEdit(DeploymentSpecification element) {
				editConfiguration(element);
			}

			public void handleMove(DeploymentSpecification element, int oldIndex, int newIndex) {
				moveConfiguration(element, oldIndex, newIndex);
			}

			public void handleRemove(DeploymentSpecification element) {
				removeFromConfiguration(element);
			}

			public void navigateTo(DeploymentSpecification element) {
			}
		});
		this.configuration.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Deployment.configuration, UMLViewsRepository.SWT_KIND));
		this.configuration.createControls(parent);
		GridData configurationData = new GridData(GridData.FILL_HORIZONTAL);
		configurationData.horizontalSpan = 3;
		this.configuration.setLayoutData(configurationData);
	}

	/**
	 * 
	 */
	protected void moveConfiguration(DeploymentSpecification element, int oldIndex, int newIndex) {
		EObject editedElement = configurationEditUtil.foundCorrespondingEObject(element);
		configurationEditUtil.moveElement(element, oldIndex, newIndex);
		configuration.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.configuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToConfiguration() {

		// Start of user code addToConfiguration() method body
		DeploymentSpecification eObject = UMLFactory.eINSTANCE.createDeploymentSpecification();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				configurationEditUtil.addElement(propertiesEditionObject);
				configuration.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.configuration,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromConfiguration(DeploymentSpecification element) {

		// Start of user code removeFromConfiguration() method body
		EObject editedElement = configurationEditUtil.foundCorrespondingEObject(element);
		configurationEditUtil.removeElement(element);
		configuration.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.configuration,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editConfiguration(DeploymentSpecification element) {

		// Start of user code editConfiguration() method body
		EObject editedElement = configurationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				configurationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				configuration.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						DeploymentPropertiesEditionPartImpl.this, UMLViewsRepository.Deployment.configuration,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#initOwnedComment(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getClientDependencyTable()
	 */
	public List getClientDependencyTable() {
		return clientDependencyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#initClientDependency(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#updateClientDependency(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addFilterClientDependency(ViewerFilter filter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter filter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#isContainedInClientDependencyTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getSupplierToAdd()
	 */
	public List getSupplierToAdd() {
		return supplierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getSupplierToRemove()
	 */
	public List getSupplierToRemove() {
		return supplierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getSupplierTable()
	 */
	public List getSupplierTable() {
		return supplierEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#initSupplier(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initSupplier(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			supplierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			supplierEditUtil = new EMFListEditUtil(current, feature);
		this.supplier.setInput(supplierEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#updateSupplier(EObject newValue)
	 */
	public void updateSupplier(EObject newValue) {
		if(supplierEditUtil != null) {
			supplierEditUtil.reinit(newValue);
			supplier.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addFilterSupplier(ViewerFilter filter)
	 */
	public void addFilterToSupplier(ViewerFilter filter) {
		supplierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addBusinessFilterSupplier(ViewerFilter filter)
	 */
	public void addBusinessFilterToSupplier(ViewerFilter filter) {
		supplierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#isContainedInSupplierTable(EObject element)
	 */
	public boolean isContainedInSupplierTable(EObject element) {
		return supplierEditUtil.contains(element);
	}

	public void setMessageForSupplier(String msg, int msgLevel) {

	}

	public void unsetMessageForSupplier() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getClientToAdd()
	 */
	public List getClientToAdd() {
		return clientEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getClientToRemove()
	 */
	public List getClientToRemove() {
		return clientEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getClientTable()
	 */
	public List getClientTable() {
		return clientEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#initClient(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initClient(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			clientEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			clientEditUtil = new EMFListEditUtil(current, feature);
		this.client.setInput(clientEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#updateClient(EObject newValue)
	 */
	public void updateClient(EObject newValue) {
		if(clientEditUtil != null) {
			clientEditUtil.reinit(newValue);
			client.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addFilterClient(ViewerFilter filter)
	 */
	public void addFilterToClient(ViewerFilter filter) {
		clientFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addBusinessFilterClient(ViewerFilter filter)
	 */
	public void addBusinessFilterToClient(ViewerFilter filter) {
		clientBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#isContainedInClientTable(EObject element)
	 */
	public boolean isContainedInClientTable(EObject element) {
		return clientEditUtil.contains(element);
	}

	public void setMessageForClient(String msg, int msgLevel) {

	}

	public void unsetMessageForClient() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getDeployedArtifactToAdd()
	 */
	public List getDeployedArtifactToAdd() {
		return deployedArtifactEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getDeployedArtifactToRemove()
	 */
	public List getDeployedArtifactToRemove() {
		return deployedArtifactEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getDeployedArtifactTable()
	 */
	public List getDeployedArtifactTable() {
		return deployedArtifactEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#initDeployedArtifact(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initDeployedArtifact(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			deployedArtifactEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			deployedArtifactEditUtil = new EMFListEditUtil(current, feature);
		this.deployedArtifact.setInput(deployedArtifactEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#updateDeployedArtifact(EObject newValue)
	 */
	public void updateDeployedArtifact(EObject newValue) {
		if(deployedArtifactEditUtil != null) {
			deployedArtifactEditUtil.reinit(newValue);
			deployedArtifact.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addFilterDeployedArtifact(ViewerFilter filter)
	 */
	public void addFilterToDeployedArtifact(ViewerFilter filter) {
		deployedArtifactFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addBusinessFilterDeployedArtifact(ViewerFilter filter)
	 */
	public void addBusinessFilterToDeployedArtifact(ViewerFilter filter) {
		deployedArtifactBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#isContainedInDeployedArtifactTable(EObject element)
	 */
	public boolean isContainedInDeployedArtifactTable(EObject element) {
		return deployedArtifactEditUtil.contains(element);
	}

	public void setMessageForDeployedArtifact(String msg, int msgLevel) {

	}

	public void unsetMessageForDeployedArtifact() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getConfigurationToAdd()
	 */
	public List getConfigurationToAdd() {
		return configurationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getConfigurationToRemove()
	 */
	public List getConfigurationToRemove() {
		return configurationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getConfigurationToEdit()
	 */
	public Map getConfigurationToEdit() {
		return configurationEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getConfigurationToMove()
	 */
	public List getConfigurationToMove() {
		return configurationEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#getConfigurationTable()
	 */
	public List getConfigurationTable() {
		return configurationEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#initConfiguration(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initConfiguration(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			configurationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			configurationEditUtil = new EMFListEditUtil(current, feature);
		this.configuration.setInput(configurationEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#updateConfiguration(EObject newValue)
	 */
	public void updateConfiguration(EObject newValue) {
		if(configurationEditUtil != null) {
			configurationEditUtil.reinit(newValue);
			configuration.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addFilterConfiguration(ViewerFilter filter)
	 */
	public void addFilterToConfiguration(ViewerFilter filter) {
		configurationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#addBusinessFilterConfiguration(ViewerFilter filter)
	 */
	public void addBusinessFilterToConfiguration(ViewerFilter filter) {
		configurationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart#isContainedInConfigurationTable(EObject element)
	 */
	public boolean isContainedInConfigurationTable(EObject element) {
		return configurationEditUtil.contains(element);
	}

	public void setMessageForConfiguration(String msg, int msgLevel) {

	}

	public void unsetMessageForConfiguration() {

	}





	// Start of user code additional methods

	// End of user code

}
