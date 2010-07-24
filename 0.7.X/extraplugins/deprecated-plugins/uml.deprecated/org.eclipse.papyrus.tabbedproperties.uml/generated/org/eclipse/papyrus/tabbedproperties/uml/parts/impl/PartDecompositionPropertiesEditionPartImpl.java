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
import org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class PartDecompositionPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PartDecompositionPropertiesEditionPart {

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

	protected EMFListEditUtil coveredEditUtil;

	protected ReferencesTable<? extends EObject> covered;

	protected List<ViewerFilter> coveredBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> coveredFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil generalOrderingEditUtil;

	protected ReferencesTable<? extends EObject> generalOrdering;

	protected List<ViewerFilter> generalOrderingBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> generalOrderingFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil actualGateEditUtil;

	protected ReferencesTable<? extends EObject> actualGate;

	protected List<ViewerFilter> actualGateBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> actualGateFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil argumentEditUtil;

	protected ReferencesTable<? extends EObject> argument;

	protected List<ViewerFilter> argumentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> argumentFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public PartDecompositionPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(UMLMessages.PartDecompositionPropertiesEditionPart_PropertiesGroupLabel);
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
		createCoveredAdvancedReferencesTable(propertiesGroup);
		createGeneralOrderingAdvancedTableComposition(propertiesGroup);
		createActualGateAdvancedTableComposition(propertiesGroup);
		createArgumentAdvancedTableComposition(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentAdvancedTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.PartDecompositionPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.PartDecomposition.ownedComment, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						PartDecompositionPropertiesEditionPartImpl.this,
						UMLViewsRepository.PartDecomposition.ownedComment, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
				PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.ownedComment,
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
						PartDecompositionPropertiesEditionPartImpl.this,
						UMLViewsRepository.PartDecomposition.ownedComment, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.PartDecompositionPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.PartDecomposition.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.PartDecomposition.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.PartDecompositionPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.PartDecomposition.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.PartDecomposition.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createClientDependencyAdvancedReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.PartDecompositionPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, clientDependencyFilters, clientDependencyBusinessFilters,
						"Dependency", UMLPackage.eINSTANCE.getDependency(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.PartDecomposition.clientDependency, UMLViewsRepository.SWT_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
				PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.clientDependency,
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
						PartDecompositionPropertiesEditionPartImpl.this,
						UMLViewsRepository.PartDecomposition.clientDependency, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createCoveredAdvancedReferencesTable(Composite parent) {
		this.covered = new ReferencesTable<Lifeline>(UMLMessages.PartDecompositionPropertiesEditionPart_CoveredLabel, new ReferencesTableListener<Lifeline>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Lifeline> dialog = new TabElementTreeSelectionDialog<Lifeline>(resourceSet, coveredFilters, coveredBusinessFilters,
						"Lifeline", UMLPackage.eINSTANCE.getLifeline(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!coveredEditUtil.getVirtualList().contains(elem))
								coveredEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.covered,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						covered.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Lifeline element) {
				editCovered(element);
			}

			public void handleMove(Lifeline element, int oldIndex, int newIndex) {
				moveCovered(element, oldIndex, newIndex);
			}

			public void handleRemove(Lifeline element) {
				removeFromCovered(element);
			}

			public void navigateTo(Lifeline element) {
			}
		});
		this.covered.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.PartDecomposition.covered, UMLViewsRepository.SWT_KIND));
		this.covered.createControls(parent);
		GridData coveredData = new GridData(GridData.FILL_HORIZONTAL);
		coveredData.horizontalSpan = 3;
		this.covered.setLayoutData(coveredData);
		this.covered.disableMove();
	}

	/**
	 * 
	 */
	protected void moveCovered(Lifeline element, int oldIndex, int newIndex) {
		EObject editedElement = coveredEditUtil.foundCorrespondingEObject(element);
		coveredEditUtil.moveElement(element, oldIndex, newIndex);
		covered.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.covered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromCovered(Lifeline element) {

		// Start of user code removeFromCovered() method body
		EObject editedElement = coveredEditUtil.foundCorrespondingEObject(element);
		coveredEditUtil.removeElement(element);
		covered.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.covered,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editCovered(Lifeline element) {

		// Start of user code editCovered() method body
		EObject editedElement = coveredEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				coveredEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				covered.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.covered,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createGeneralOrderingAdvancedTableComposition(Composite parent) {
		this.generalOrdering = new ReferencesTable<GeneralOrdering>(UMLMessages.PartDecompositionPropertiesEditionPart_GeneralOrderingLabel, new ReferencesTableListener<GeneralOrdering>() {

			public void handleAdd() {
				addToGeneralOrdering();
			}

			public void handleEdit(GeneralOrdering element) {
				editGeneralOrdering(element);
			}

			public void handleMove(GeneralOrdering element, int oldIndex, int newIndex) {
				moveGeneralOrdering(element, oldIndex, newIndex);
			}

			public void handleRemove(GeneralOrdering element) {
				removeFromGeneralOrdering(element);
			}

			public void navigateTo(GeneralOrdering element) {
			}
		});
		this.generalOrdering.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.PartDecomposition.generalOrdering, UMLViewsRepository.SWT_KIND));
		this.generalOrdering.createControls(parent);
		GridData generalOrderingData = new GridData(GridData.FILL_HORIZONTAL);
		generalOrderingData.horizontalSpan = 3;
		this.generalOrdering.setLayoutData(generalOrderingData);
	}

	/**
	 * 
	 */
	protected void moveGeneralOrdering(GeneralOrdering element, int oldIndex, int newIndex) {
		EObject editedElement = generalOrderingEditUtil.foundCorrespondingEObject(element);
		generalOrderingEditUtil.moveElement(element, oldIndex, newIndex);
		generalOrdering.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.generalOrdering, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToGeneralOrdering() {

		// Start of user code addToGeneralOrdering() method body
		GeneralOrdering eObject = UMLFactory.eINSTANCE.createGeneralOrdering();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				generalOrderingEditUtil.addElement(propertiesEditionObject);
				generalOrdering.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						PartDecompositionPropertiesEditionPartImpl.this,
						UMLViewsRepository.PartDecomposition.generalOrdering, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromGeneralOrdering(GeneralOrdering element) {

		// Start of user code removeFromGeneralOrdering() method body
		EObject editedElement = generalOrderingEditUtil.foundCorrespondingEObject(element);
		generalOrderingEditUtil.removeElement(element);
		generalOrdering.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.generalOrdering,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editGeneralOrdering(GeneralOrdering element) {

		// Start of user code editGeneralOrdering() method body
		EObject editedElement = generalOrderingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				generalOrderingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				generalOrdering.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						PartDecompositionPropertiesEditionPartImpl.this,
						UMLViewsRepository.PartDecomposition.generalOrdering, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createActualGateAdvancedTableComposition(Composite parent) {
		this.actualGate = new ReferencesTable<Gate>(UMLMessages.PartDecompositionPropertiesEditionPart_ActualGateLabel, new ReferencesTableListener<Gate>() {

			public void handleAdd() {
				addToActualGate();
			}

			public void handleEdit(Gate element) {
				editActualGate(element);
			}

			public void handleMove(Gate element, int oldIndex, int newIndex) {
				moveActualGate(element, oldIndex, newIndex);
			}

			public void handleRemove(Gate element) {
				removeFromActualGate(element);
			}

			public void navigateTo(Gate element) {
			}
		});
		this.actualGate.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.PartDecomposition.actualGate, UMLViewsRepository.SWT_KIND));
		this.actualGate.createControls(parent);
		GridData actualGateData = new GridData(GridData.FILL_HORIZONTAL);
		actualGateData.horizontalSpan = 3;
		this.actualGate.setLayoutData(actualGateData);
	}

	/**
	 * 
	 */
	protected void moveActualGate(Gate element, int oldIndex, int newIndex) {
		EObject editedElement = actualGateEditUtil.foundCorrespondingEObject(element);
		actualGateEditUtil.moveElement(element, oldIndex, newIndex);
		actualGate.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.actualGate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToActualGate() {

		// Start of user code addToActualGate() method body
		Gate eObject = UMLFactory.eINSTANCE.createGate();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				actualGateEditUtil.addElement(propertiesEditionObject);
				actualGate.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						PartDecompositionPropertiesEditionPartImpl.this,
						UMLViewsRepository.PartDecomposition.actualGate, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromActualGate(Gate element) {

		// Start of user code removeFromActualGate() method body
		EObject editedElement = actualGateEditUtil.foundCorrespondingEObject(element);
		actualGateEditUtil.removeElement(element);
		actualGate.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.actualGate,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editActualGate(Gate element) {

		// Start of user code editActualGate() method body
		EObject editedElement = actualGateEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				actualGateEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				actualGate.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						PartDecompositionPropertiesEditionPartImpl.this,
						UMLViewsRepository.PartDecomposition.actualGate, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createArgumentAdvancedTableComposition(Composite parent) {
		this.argument = new ReferencesTable<Action>(UMLMessages.PartDecompositionPropertiesEditionPart_ArgumentLabel, new ReferencesTableListener<Action>() {

			public void handleAdd() {
				addToArgument();
			}

			public void handleEdit(Action element) {
				editArgument(element);
			}

			public void handleMove(Action element, int oldIndex, int newIndex) {
				moveArgument(element, oldIndex, newIndex);
			}

			public void handleRemove(Action element) {
				removeFromArgument(element);
			}

			public void navigateTo(Action element) {
			}
		});
		this.argument.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.PartDecomposition.argument, UMLViewsRepository.SWT_KIND));
		this.argument.createControls(parent);
		GridData argumentData = new GridData(GridData.FILL_HORIZONTAL);
		argumentData.horizontalSpan = 3;
		this.argument.setLayoutData(argumentData);
	}

	/**
	 * 
	 */
	protected void moveArgument(Action element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void addToArgument() {

		// Start of user code addToArgument() method body
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromArgument(Action element) {

		// Start of user code removeFromArgument() method body
		EObject editedElement = argumentEditUtil.foundCorrespondingEObject(element);
		argumentEditUtil.removeElement(element);
		argument.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.argument,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editArgument(Action element) {

		// Start of user code editArgument() method body
		EObject editedElement = argumentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				argumentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				argument.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						PartDecompositionPropertiesEditionPartImpl.this, UMLViewsRepository.PartDecomposition.argument,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#initOwnedComment(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getClientDependencyTable()
	 */
	public List getClientDependencyTable() {
		return clientDependencyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#initClientDependency(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#updateClientDependency(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addFilterClientDependency(ViewerFilter filter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#isContainedInClientDependencyTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getCoveredToAdd()
	 */
	public List getCoveredToAdd() {
		return coveredEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getCoveredToRemove()
	 */
	public List getCoveredToRemove() {
		return coveredEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getCoveredTable()
	 */
	public List getCoveredTable() {
		return coveredEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#initCovered(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initCovered(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			coveredEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			coveredEditUtil = new EMFListEditUtil(current, feature);
		this.covered.setInput(coveredEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#updateCovered(EObject newValue)
	 */
	public void updateCovered(EObject newValue) {
		if(coveredEditUtil != null) {
			coveredEditUtil.reinit(newValue);
			covered.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addFilterCovered(ViewerFilter filter)
	 */
	public void addFilterToCovered(ViewerFilter filter) {
		coveredFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addBusinessFilterCovered(ViewerFilter filter)
	 */
	public void addBusinessFilterToCovered(ViewerFilter filter) {
		coveredBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#isContainedInCoveredTable(EObject element)
	 */
	public boolean isContainedInCoveredTable(EObject element) {
		return coveredEditUtil.contains(element);
	}

	public void setMessageForCovered(String msg, int msgLevel) {

	}

	public void unsetMessageForCovered() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getGeneralOrderingToAdd()
	 */
	public List getGeneralOrderingToAdd() {
		return generalOrderingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getGeneralOrderingToRemove()
	 */
	public List getGeneralOrderingToRemove() {
		return generalOrderingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getGeneralOrderingToEdit()
	 */
	public Map getGeneralOrderingToEdit() {
		return generalOrderingEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getGeneralOrderingToMove()
	 */
	public List getGeneralOrderingToMove() {
		return generalOrderingEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getGeneralOrderingTable()
	 */
	public List getGeneralOrderingTable() {
		return generalOrderingEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#initGeneralOrdering(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initGeneralOrdering(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			generalOrderingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			generalOrderingEditUtil = new EMFListEditUtil(current, feature);
		this.generalOrdering.setInput(generalOrderingEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#updateGeneralOrdering(EObject newValue)
	 */
	public void updateGeneralOrdering(EObject newValue) {
		if(generalOrderingEditUtil != null) {
			generalOrderingEditUtil.reinit(newValue);
			generalOrdering.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addFilterGeneralOrdering(ViewerFilter filter)
	 */
	public void addFilterToGeneralOrdering(ViewerFilter filter) {
		generalOrderingFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addBusinessFilterGeneralOrdering(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToGeneralOrdering(ViewerFilter filter) {
		generalOrderingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#isContainedInGeneralOrderingTable(EObject element)
	 */
	public boolean isContainedInGeneralOrderingTable(EObject element) {
		return generalOrderingEditUtil.contains(element);
	}

	public void setMessageForGeneralOrdering(String msg, int msgLevel) {

	}

	public void unsetMessageForGeneralOrdering() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getActualGateToAdd()
	 */
	public List getActualGateToAdd() {
		return actualGateEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getActualGateToRemove()
	 */
	public List getActualGateToRemove() {
		return actualGateEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getActualGateToEdit()
	 */
	public Map getActualGateToEdit() {
		return actualGateEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getActualGateToMove()
	 */
	public List getActualGateToMove() {
		return actualGateEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getActualGateTable()
	 */
	public List getActualGateTable() {
		return actualGateEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#initActualGate(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initActualGate(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			actualGateEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			actualGateEditUtil = new EMFListEditUtil(current, feature);
		this.actualGate.setInput(actualGateEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#updateActualGate(EObject newValue)
	 */
	public void updateActualGate(EObject newValue) {
		if(actualGateEditUtil != null) {
			actualGateEditUtil.reinit(newValue);
			actualGate.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addFilterActualGate(ViewerFilter filter)
	 */
	public void addFilterToActualGate(ViewerFilter filter) {
		actualGateFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addBusinessFilterActualGate(ViewerFilter filter)
	 */
	public void addBusinessFilterToActualGate(ViewerFilter filter) {
		actualGateBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#isContainedInActualGateTable(EObject element)
	 */
	public boolean isContainedInActualGateTable(EObject element) {
		return actualGateEditUtil.contains(element);
	}

	public void setMessageForActualGate(String msg, int msgLevel) {

	}

	public void unsetMessageForActualGate() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getArgumentToAdd()
	 */
	public List getArgumentToAdd() {
		return argumentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getArgumentToRemove()
	 */
	public List getArgumentToRemove() {
		return argumentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getArgumentToEdit()
	 */
	public Map getArgumentToEdit() {
		return argumentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getArgumentToMove()
	 */
	public List getArgumentToMove() {
		return argumentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#getArgumentTable()
	 */
	public List getArgumentTable() {
		return argumentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#initArgument(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initArgument(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			argumentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			argumentEditUtil = new EMFListEditUtil(current, feature);
		this.argument.setInput(argumentEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#updateArgument(EObject newValue)
	 */
	public void updateArgument(EObject newValue) {
		if(argumentEditUtil != null) {
			argumentEditUtil.reinit(newValue);
			argument.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addFilterArgument(ViewerFilter filter)
	 */
	public void addFilterToArgument(ViewerFilter filter) {
		argumentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#addBusinessFilterArgument(ViewerFilter filter)
	 */
	public void addBusinessFilterToArgument(ViewerFilter filter) {
		argumentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PartDecompositionPropertiesEditionPart#isContainedInArgumentTable(EObject element)
	 */
	public boolean isContainedInArgumentTable(EObject element) {
		return argumentEditUtil.contains(element);
	}

	public void setMessageForArgument(String msg, int msgLevel) {

	}

	public void unsetMessageForArgument() {

	}





	// Start of user code additional methods

	// End of user code

}
