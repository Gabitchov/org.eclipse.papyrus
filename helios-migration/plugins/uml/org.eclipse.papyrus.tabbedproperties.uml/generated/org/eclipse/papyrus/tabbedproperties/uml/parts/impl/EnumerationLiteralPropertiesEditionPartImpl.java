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
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class EnumerationLiteralPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EnumerationLiteralPropertiesEditionPart {

	protected Text name;

	protected EMFComboViewer visibility;

	protected EMFListEditUtil deploymentEditUtil;

	protected ReferencesTable<? extends EObject> deployment;

	protected List<ViewerFilter> deploymentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> deploymentFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil slotEditUtil;

	protected ReferencesTable<? extends EObject> slot;

	protected List<ViewerFilter> slotBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> slotFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil classifierEditUtil;

	protected ReferencesTable<? extends EObject> classifier;

	protected List<ViewerFilter> classifierBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> classifierFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public EnumerationLiteralPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createGeneralGroup(view);

		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createGeneralGroup(Composite parent) {
		Group generalGroup = new Group(parent, SWT.NONE);
		generalGroup.setText(UMLMessages.EnumerationLiteralPropertiesEditionPart_GeneralGroupLabel);
		GridData generalGroupData = new GridData(GridData.FILL_HORIZONTAL);
		generalGroupData.horizontalSpan = 3;
		generalGroup.setLayoutData(generalGroupData);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createNameText(generalGroup);
		createVisibilityEMFComboViewer(generalGroup);
		createGeneralHBox1HBox(generalGroup);
	}

	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.EnumerationLiteralPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.EnumerationLiteral.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartImpl.this, UMLViewsRepository.EnumerationLiteral.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.EnumerationLiteralPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.EnumerationLiteral.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createGeneralHBox1HBox(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 2;
		container.setLayoutData(gridData);
		HorizontalBox generalHBox1HBox = new HorizontalBox(container);
		//create sub figures
		createDeploymentAdvancedTableComposition(generalHBox1HBox);
		createSlotAdvancedTableComposition(generalHBox1HBox);
		createClassifierAdvancedReferencesTable(generalHBox1HBox);
		parent.pack();
	}

	/**
	 * @param container
	 */
	protected void createDeploymentAdvancedTableComposition(Composite parent) {
		this.deployment = new ReferencesTable<Deployment>(UMLMessages.EnumerationLiteralPropertiesEditionPart_DeploymentLabel, new ReferencesTableListener<Deployment>() {

			public void handleAdd() {
				addToDeployment();
			}

			public void handleEdit(Deployment element) {
				editDeployment(element);
			}

			public void handleMove(Deployment element, int oldIndex, int newIndex) {
				moveDeployment(element, oldIndex, newIndex);
			}

			public void handleRemove(Deployment element) {
				removeFromDeployment(element);
			}

			public void navigateTo(Deployment element) {
			}
		});
		this.deployment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.deployment, UMLViewsRepository.SWT_KIND));
		this.deployment.createControls(parent);
		GridData deploymentData = new GridData(GridData.FILL_HORIZONTAL);
		deploymentData.horizontalSpan = 3;
		this.deployment.setLayoutData(deploymentData);
	}

	/**
	 * 
	 */
	protected void moveDeployment(Deployment element, int oldIndex, int newIndex) {
		EObject editedElement = deploymentEditUtil.foundCorrespondingEObject(element);
		deploymentEditUtil.moveElement(element, oldIndex, newIndex);
		deployment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartImpl.this, UMLViewsRepository.EnumerationLiteral.deployment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToDeployment() {

		// Start of user code addToDeployment() method body
		Deployment eObject = UMLFactory.eINSTANCE.createDeployment();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				deploymentEditUtil.addElement(propertiesEditionObject);
				deployment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						EnumerationLiteralPropertiesEditionPartImpl.this,
						UMLViewsRepository.EnumerationLiteral.deployment, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromDeployment(Deployment element) {

		// Start of user code removeFromDeployment() method body
		EObject editedElement = deploymentEditUtil.foundCorrespondingEObject(element);
		deploymentEditUtil.removeElement(element);
		deployment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				EnumerationLiteralPropertiesEditionPartImpl.this, UMLViewsRepository.EnumerationLiteral.deployment,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editDeployment(Deployment element) {

		// Start of user code editDeployment() method body
		EObject editedElement = deploymentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				deploymentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				deployment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						EnumerationLiteralPropertiesEditionPartImpl.this,
						UMLViewsRepository.EnumerationLiteral.deployment, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createSlotAdvancedTableComposition(Composite parent) {
		this.slot = new ReferencesTable<Slot>(UMLMessages.EnumerationLiteralPropertiesEditionPart_SlotLabel, new ReferencesTableListener<Slot>() {

			public void handleAdd() {
				addToSlot();
			}

			public void handleEdit(Slot element) {
				editSlot(element);
			}

			public void handleMove(Slot element, int oldIndex, int newIndex) {
				moveSlot(element, oldIndex, newIndex);
			}

			public void handleRemove(Slot element) {
				removeFromSlot(element);
			}

			public void navigateTo(Slot element) {
			}
		});
		this.slot.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.slot, UMLViewsRepository.SWT_KIND));
		this.slot.createControls(parent);
		GridData slotData = new GridData(GridData.FILL_HORIZONTAL);
		slotData.horizontalSpan = 3;
		this.slot.setLayoutData(slotData);
	}

	/**
	 * 
	 */
	protected void moveSlot(Slot element, int oldIndex, int newIndex) {
		EObject editedElement = slotEditUtil.foundCorrespondingEObject(element);
		slotEditUtil.moveElement(element, oldIndex, newIndex);
		slot.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartImpl.this, UMLViewsRepository.EnumerationLiteral.slot, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToSlot() {

		// Start of user code addToSlot() method body
		Slot eObject = UMLFactory.eINSTANCE.createSlot();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				slotEditUtil.addElement(propertiesEditionObject);
				slot.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						EnumerationLiteralPropertiesEditionPartImpl.this, UMLViewsRepository.EnumerationLiteral.slot,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromSlot(Slot element) {

		// Start of user code removeFromSlot() method body
		EObject editedElement = slotEditUtil.foundCorrespondingEObject(element);
		slotEditUtil.removeElement(element);
		slot.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				EnumerationLiteralPropertiesEditionPartImpl.this, UMLViewsRepository.EnumerationLiteral.slot,
				PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSlot(Slot element) {

		// Start of user code editSlot() method body
		EObject editedElement = slotEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				slotEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				slot.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						EnumerationLiteralPropertiesEditionPartImpl.this, UMLViewsRepository.EnumerationLiteral.slot,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createClassifierAdvancedReferencesTable(Composite parent) {
		this.classifier = new ReferencesTable<Classifier>(UMLMessages.EnumerationLiteralPropertiesEditionPart_ClassifierLabel, new ReferencesTableListener<Classifier>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, classifierFilters, classifierBusinessFilters,
						"Classifier", UMLPackage.eINSTANCE.getClassifier(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!classifierEditUtil.getVirtualList().contains(elem))
								classifierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartImpl.this, UMLViewsRepository.EnumerationLiteral.classifier,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						classifier.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Classifier element) {
				editClassifier(element);
			}

			public void handleMove(Classifier element, int oldIndex, int newIndex) {
				moveClassifier(element, oldIndex, newIndex);
			}

			public void handleRemove(Classifier element) {
				removeFromClassifier(element);
			}

			public void navigateTo(Classifier element) {
			}
		});
		this.classifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.classifier, UMLViewsRepository.SWT_KIND));
		this.classifier.createControls(parent);
		GridData classifierData = new GridData(GridData.FILL_HORIZONTAL);
		classifierData.horizontalSpan = 3;
		this.classifier.setLayoutData(classifierData);
		this.classifier.disableMove();
	}

	/**
	 * 
	 */
	protected void moveClassifier(Classifier element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromClassifier(Classifier element) {

		// Start of user code removeFromClassifier() method body
		EObject editedElement = classifierEditUtil.foundCorrespondingEObject(element);
		classifierEditUtil.removeElement(element);
		classifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				EnumerationLiteralPropertiesEditionPartImpl.this, UMLViewsRepository.EnumerationLiteral.classifier,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editClassifier(Classifier element) {

		// Start of user code editClassifier() method body
		EObject editedElement = classifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				classifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				classifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						EnumerationLiteralPropertiesEditionPartImpl.this,
						UMLViewsRepository.EnumerationLiteral.classifier, PropertiesEditionEvent.COMMIT,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getDeploymentToAdd()
	 */
	public List getDeploymentToAdd() {
		return deploymentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getDeploymentToRemove()
	 */
	public List getDeploymentToRemove() {
		return deploymentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getDeploymentToEdit()
	 */
	public Map getDeploymentToEdit() {
		return deploymentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getDeploymentToMove()
	 */
	public List getDeploymentToMove() {
		return deploymentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getDeploymentTable()
	 */
	public List getDeploymentTable() {
		return deploymentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#initDeployment(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initDeployment(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			deploymentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			deploymentEditUtil = new EMFListEditUtil(current, feature);
		this.deployment.setInput(deploymentEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#updateDeployment(EObject newValue)
	 */
	public void updateDeployment(EObject newValue) {
		if(deploymentEditUtil != null) {
			deploymentEditUtil.reinit(newValue);
			deployment.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#addFilterDeployment(ViewerFilter filter)
	 */
	public void addFilterToDeployment(ViewerFilter filter) {
		deploymentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#addBusinessFilterDeployment(ViewerFilter filter)
	 */
	public void addBusinessFilterToDeployment(ViewerFilter filter) {
		deploymentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#isContainedInDeploymentTable(EObject element)
	 */
	public boolean isContainedInDeploymentTable(EObject element) {
		return deploymentEditUtil.contains(element);
	}

	public void setMessageForDeployment(String msg, int msgLevel) {

	}

	public void unsetMessageForDeployment() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getSlotToAdd()
	 */
	public List getSlotToAdd() {
		return slotEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getSlotToRemove()
	 */
	public List getSlotToRemove() {
		return slotEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getSlotToEdit()
	 */
	public Map getSlotToEdit() {
		return slotEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getSlotToMove()
	 */
	public List getSlotToMove() {
		return slotEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getSlotTable()
	 */
	public List getSlotTable() {
		return slotEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#initSlot(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initSlot(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			slotEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			slotEditUtil = new EMFListEditUtil(current, feature);
		this.slot.setInput(slotEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#updateSlot(EObject newValue)
	 */
	public void updateSlot(EObject newValue) {
		if(slotEditUtil != null) {
			slotEditUtil.reinit(newValue);
			slot.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#addFilterSlot(ViewerFilter filter)
	 */
	public void addFilterToSlot(ViewerFilter filter) {
		slotFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#addBusinessFilterSlot(ViewerFilter filter)
	 */
	public void addBusinessFilterToSlot(ViewerFilter filter) {
		slotBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#isContainedInSlotTable(EObject element)
	 */
	public boolean isContainedInSlotTable(EObject element) {
		return slotEditUtil.contains(element);
	}

	public void setMessageForSlot(String msg, int msgLevel) {

	}

	public void unsetMessageForSlot() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getClassifierToAdd()
	 */
	public List getClassifierToAdd() {
		return classifierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getClassifierToRemove()
	 */
	public List getClassifierToRemove() {
		return classifierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getClassifierTable()
	 */
	public List getClassifierTable() {
		return classifierEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#initClassifier(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initClassifier(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			classifierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			classifierEditUtil = new EMFListEditUtil(current, feature);
		this.classifier.setInput(classifierEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#updateClassifier(EObject newValue)
	 */
	public void updateClassifier(EObject newValue) {
		if(classifierEditUtil != null) {
			classifierEditUtil.reinit(newValue);
			classifier.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#addFilterClassifier(ViewerFilter filter)
	 */
	public void addFilterToClassifier(ViewerFilter filter) {
		classifierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#addBusinessFilterClassifier(ViewerFilter filter)
	 */
	public void addBusinessFilterToClassifier(ViewerFilter filter) {
		classifierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#isContainedInClassifierTable(EObject element)
	 */
	public boolean isContainedInClassifierTable(EObject element) {
		return classifierEditUtil.contains(element);
	}

	public void setMessageForClassifier(String msg, int msgLevel) {

	}

	public void unsetMessageForClassifier() {

	}





	// Start of user code additional methods

	// End of user code

}
