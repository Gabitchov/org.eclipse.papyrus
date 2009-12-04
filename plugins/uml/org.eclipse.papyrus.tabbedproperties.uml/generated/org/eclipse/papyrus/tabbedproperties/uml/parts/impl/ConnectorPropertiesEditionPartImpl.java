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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ConnectorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ConnectorPropertiesEditionPart {

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

	protected Button isLeaf;

	protected Button isStatic;

	protected EMFListEditUtil redefinedConnectorEditUtil;

	protected ReferencesTable<? extends EObject> redefinedConnector;

	protected List<ViewerFilter> redefinedConnectorBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> redefinedConnectorFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil endEditUtil;

	protected ReferencesTable<? extends EObject> end;

	protected List<ViewerFilter> endBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> endFilters = new ArrayList<ViewerFilter>();

	protected EMFComboViewer kind;

	protected EMFListEditUtil contractEditUtil;

	protected ReferencesTable<? extends EObject> contract;

	protected List<ViewerFilter> contractBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> contractFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ConnectorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(UMLMessages.ConnectorPropertiesEditionPart_PropertiesGroupLabel);
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
		createIsLeafCheckbox(propertiesGroup);
		createIsStaticCheckbox(propertiesGroup);
		createRedefinedConnectorAdvancedReferencesTable(propertiesGroup);
		createEndAdvancedTableComposition(propertiesGroup);
		createKindEMFComboViewer(propertiesGroup);
		createContractAdvancedReferencesTable(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentAdvancedTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.ConnectorPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.ownedComment, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.ownedComment,
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
				ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.ownedComment,
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
						ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.ownedComment,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ConnectorPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Connector.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ConnectorPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Connector.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createClientDependencyAdvancedReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.ConnectorPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, clientDependencyFilters, clientDependencyBusinessFilters,
						"Dependency", UMLPackage.eINSTANCE.getDependency(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.clientDependency, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
				ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.clientDependency,
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
						ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.clientDependency,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createIsLeafCheckbox(Composite parent) {
		isLeaf = new Button(parent, SWT.CHECK);
		isLeaf.setText(UMLMessages.ConnectorPropertiesEditionPart_IsLeafLabel);
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.isLeaf, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createIsStaticCheckbox(Composite parent) {
		isStatic = new Button(parent, SWT.CHECK);
		isStatic.setText(UMLMessages.ConnectorPropertiesEditionPart_IsStaticLabel);
		GridData isStaticData = new GridData(GridData.FILL_HORIZONTAL);
		isStaticData.horizontalSpan = 2;
		isStatic.setLayoutData(isStaticData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.isStatic, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createRedefinedConnectorAdvancedReferencesTable(Composite parent) {
		this.redefinedConnector = new ReferencesTable<Connector>(UMLMessages.ConnectorPropertiesEditionPart_RedefinedConnectorLabel, new ReferencesTableListener<Connector>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Connector> dialog = new TabElementTreeSelectionDialog<Connector>(resourceSet, redefinedConnectorFilters, redefinedConnectorBusinessFilters,
						"Connector", UMLPackage.eINSTANCE.getConnector(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!redefinedConnectorEditUtil.getVirtualList().contains(elem))
								redefinedConnectorEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.redefinedConnector,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						redefinedConnector.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Connector element) {
				editRedefinedConnector(element);
			}

			public void handleMove(Connector element, int oldIndex, int newIndex) {
				moveRedefinedConnector(element, oldIndex, newIndex);
			}

			public void handleRemove(Connector element) {
				removeFromRedefinedConnector(element);
			}

			public void navigateTo(Connector element) {
			}
		});
		this.redefinedConnector.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.redefinedConnector, UMLViewsRepository.SWT_KIND));
		this.redefinedConnector.createControls(parent);
		GridData redefinedConnectorData = new GridData(GridData.FILL_HORIZONTAL);
		redefinedConnectorData.horizontalSpan = 3;
		this.redefinedConnector.setLayoutData(redefinedConnectorData);
		this.redefinedConnector.disableMove();
	}

	/**
	 * 
	 */
	protected void moveRedefinedConnector(Connector element, int oldIndex, int newIndex) {
		EObject editedElement = redefinedConnectorEditUtil.foundCorrespondingEObject(element);
		redefinedConnectorEditUtil.moveElement(element, oldIndex, newIndex);
		redefinedConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.redefinedConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromRedefinedConnector(Connector element) {

		// Start of user code removeFromRedefinedConnector() method body
		EObject editedElement = redefinedConnectorEditUtil.foundCorrespondingEObject(element);
		redefinedConnectorEditUtil.removeElement(element);
		redefinedConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.redefinedConnector,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRedefinedConnector(Connector element) {

		// Start of user code editRedefinedConnector() method body
		EObject editedElement = redefinedConnectorEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				redefinedConnectorEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				redefinedConnector.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.redefinedConnector,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createEndAdvancedTableComposition(Composite parent) {
		this.end = new ReferencesTable<ConnectorEnd>(UMLMessages.ConnectorPropertiesEditionPart_EndLabel, new ReferencesTableListener<ConnectorEnd>() {

			public void handleAdd() {
				addToEnd();
			}

			public void handleEdit(ConnectorEnd element) {
				editEnd(element);
			}

			public void handleMove(ConnectorEnd element, int oldIndex, int newIndex) {
				moveEnd(element, oldIndex, newIndex);
			}

			public void handleRemove(ConnectorEnd element) {
				removeFromEnd(element);
			}

			public void navigateTo(ConnectorEnd element) {
			}
		});
		this.end.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.end, UMLViewsRepository.SWT_KIND));
		this.end.createControls(parent);
		GridData endData = new GridData(GridData.FILL_HORIZONTAL);
		endData.horizontalSpan = 3;
		this.end.setLayoutData(endData);
	}

	/**
	 * 
	 */
	protected void moveEnd(ConnectorEnd element, int oldIndex, int newIndex) {
		EObject editedElement = endEditUtil.foundCorrespondingEObject(element);
		endEditUtil.moveElement(element, oldIndex, newIndex);
		end.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.end, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToEnd() {

		// Start of user code addToEnd() method body
		ConnectorEnd eObject = UMLFactory.eINSTANCE.createConnectorEnd();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				endEditUtil.addElement(propertiesEditionObject);
				end.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.end,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromEnd(ConnectorEnd element) {

		// Start of user code removeFromEnd() method body
		EObject editedElement = endEditUtil.foundCorrespondingEObject(element);
		endEditUtil.removeElement(element);
		end.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.end,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editEnd(ConnectorEnd element) {

		// Start of user code editEnd() method body
		EObject editedElement = endEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				endEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				end.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.end,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createKindEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ConnectorPropertiesEditionPart_KindLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Connector.kind, UMLViewsRepository.SWT_KIND));
		kind = new EMFComboViewer(parent);
		kind.setContentProvider(new ArrayContentProvider());
		kind.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData kindData = new GridData(GridData.FILL_HORIZONTAL);
		kind.getCombo().setLayoutData(kindData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.kind, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createContractAdvancedReferencesTable(Composite parent) {
		this.contract = new ReferencesTable<Behavior>(UMLMessages.ConnectorPropertiesEditionPart_ContractLabel, new ReferencesTableListener<Behavior>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Behavior> dialog = new TabElementTreeSelectionDialog<Behavior>(resourceSet, contractFilters, contractBusinessFilters,
						"Behavior", UMLPackage.eINSTANCE.getBehavior(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!contractEditUtil.getVirtualList().contains(elem))
								contractEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.contract,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						contract.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Behavior element) {
				editContract(element);
			}

			public void handleMove(Behavior element, int oldIndex, int newIndex) {
				moveContract(element, oldIndex, newIndex);
			}

			public void handleRemove(Behavior element) {
				removeFromContract(element);
			}

			public void navigateTo(Behavior element) {
			}
		});
		this.contract.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Connector.contract, UMLViewsRepository.SWT_KIND));
		this.contract.createControls(parent);
		GridData contractData = new GridData(GridData.FILL_HORIZONTAL);
		contractData.horizontalSpan = 3;
		this.contract.setLayoutData(contractData);
		this.contract.disableMove();
	}

	/**
	 * 
	 */
	protected void moveContract(Behavior element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromContract(Behavior element) {

		// Start of user code removeFromContract() method body
		EObject editedElement = contractEditUtil.foundCorrespondingEObject(element);
		contractEditUtil.removeElement(element);
		contract.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.contract,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editContract(Behavior element) {

		// Start of user code editContract() method body
		EObject editedElement = contractEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				contractEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				contract.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ConnectorPropertiesEditionPartImpl.this, UMLViewsRepository.Connector.contract,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#initOwnedComment(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getClientDependencyTable()
	 */
	public List getClientDependencyTable() {
		return clientDependencyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#initClientDependency(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#updateClientDependency(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addFilterClientDependency(ViewerFilter filter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter filter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#isContainedInClientDependencyTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#setIsLeaf(Boolean newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getIsStatic()
	 */
	public Boolean getIsStatic() {
		return Boolean.valueOf(isStatic.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#setIsStatic(Boolean newValue)
	 */
	public void setIsStatic(Boolean newValue) {
		if(newValue != null) {
			isStatic.setSelection(newValue.booleanValue());
		} else {
			isStatic.setSelection(false);
		}
	}

	public void setMessageForIsStatic(String msg, int msgLevel) {

	}

	public void unsetMessageForIsStatic() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getRedefinedConnectorToAdd()
	 */
	public List getRedefinedConnectorToAdd() {
		return redefinedConnectorEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getRedefinedConnectorToRemove()
	 */
	public List getRedefinedConnectorToRemove() {
		return redefinedConnectorEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getRedefinedConnectorTable()
	 */
	public List getRedefinedConnectorTable() {
		return redefinedConnectorEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#initRedefinedConnector(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initRedefinedConnector(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			redefinedConnectorEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			redefinedConnectorEditUtil = new EMFListEditUtil(current, feature);
		this.redefinedConnector.setInput(redefinedConnectorEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#updateRedefinedConnector(EObject newValue)
	 */
	public void updateRedefinedConnector(EObject newValue) {
		if(redefinedConnectorEditUtil != null) {
			redefinedConnectorEditUtil.reinit(newValue);
			redefinedConnector.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addFilterRedefinedConnector(ViewerFilter filter)
	 */
	public void addFilterToRedefinedConnector(ViewerFilter filter) {
		redefinedConnectorFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addBusinessFilterRedefinedConnector(ViewerFilter filter)
	 */
	public void addBusinessFilterToRedefinedConnector(ViewerFilter filter) {
		redefinedConnectorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#isContainedInRedefinedConnectorTable(EObject element)
	 */
	public boolean isContainedInRedefinedConnectorTable(EObject element) {
		return redefinedConnectorEditUtil.contains(element);
	}

	public void setMessageForRedefinedConnector(String msg, int msgLevel) {

	}

	public void unsetMessageForRedefinedConnector() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getEndToAdd()
	 */
	public List getEndToAdd() {
		return endEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getEndToRemove()
	 */
	public List getEndToRemove() {
		return endEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getEndToEdit()
	 */
	public Map getEndToEdit() {
		return endEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getEndToMove()
	 */
	public List getEndToMove() {
		return endEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getEndTable()
	 */
	public List getEndTable() {
		return endEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#initEnd(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initEnd(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			endEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			endEditUtil = new EMFListEditUtil(current, feature);
		this.end.setInput(endEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#updateEnd(EObject newValue)
	 */
	public void updateEnd(EObject newValue) {
		if(endEditUtil != null) {
			endEditUtil.reinit(newValue);
			end.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addFilterEnd(ViewerFilter filter)
	 */
	public void addFilterToEnd(ViewerFilter filter) {
		endFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addBusinessFilterEnd(ViewerFilter filter)
	 */
	public void addBusinessFilterToEnd(ViewerFilter filter) {
		endBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#isContainedInEndTable(EObject element)
	 */
	public boolean isContainedInEndTable(EObject element) {
		return endEditUtil.contains(element);
	}

	public void setMessageForEnd(String msg, int msgLevel) {

	}

	public void unsetMessageForEnd() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getKind()
	 */
	public Enumerator getKind() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)kind.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#initKind(EEnum eenum, Enumerator current)
	 */
	public void initKind(EEnum eenum, Enumerator current) {
		kind.setInput(eenum.getELiterals());
		kind.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#setKind(Enumerator newValue)
	 */
	public void setKind(Enumerator newValue) {
		kind.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForKind(String msg, int msgLevel) {

	}

	public void unsetMessageForKind() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getContractToAdd()
	 */
	public List getContractToAdd() {
		return contractEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getContractToRemove()
	 */
	public List getContractToRemove() {
		return contractEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#getContractTable()
	 */
	public List getContractTable() {
		return contractEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#initContract(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initContract(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			contractEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			contractEditUtil = new EMFListEditUtil(current, feature);
		this.contract.setInput(contractEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#updateContract(EObject newValue)
	 */
	public void updateContract(EObject newValue) {
		if(contractEditUtil != null) {
			contractEditUtil.reinit(newValue);
			contract.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addFilterContract(ViewerFilter filter)
	 */
	public void addFilterToContract(ViewerFilter filter) {
		contractFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#addBusinessFilterContract(ViewerFilter filter)
	 */
	public void addBusinessFilterToContract(ViewerFilter filter) {
		contractBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart#isContainedInContractTable(EObject element)
	 */
	public boolean isContainedInContractTable(EObject element) {
		return contractEditUtil.contains(element);
	}

	public void setMessageForContract(String msg, int msgLevel) {

	}

	public void unsetMessageForContract() {

	}





	// Start of user code additional methods

	// End of user code

}
