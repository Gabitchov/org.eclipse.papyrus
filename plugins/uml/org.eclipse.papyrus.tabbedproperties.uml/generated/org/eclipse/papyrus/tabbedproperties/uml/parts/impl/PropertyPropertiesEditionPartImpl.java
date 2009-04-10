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
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFEnumViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class PropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PropertyPropertiesEditionPart {

	private Text name;
	private EMFEnumViewer visibility;
	private EMFEnumViewer aggregation;
	private AdvancedEObjectFlatComboViewer type;
	private Button isOrdered;
	private Button isUnique;
	private Button isStatic;
	private Button isReadOnly;
	private Button isLeaf;
	private Button isDerived;
	private Button isDerivedUnion;
	private Text lower;
	private Text upper;
	private EMFListEditUtil templateBindingEditUtil;
	private ReferencesTable<?> templateBinding;
	private EMFListEditUtil qualifierEditUtil;
	private ReferencesTable<?> qualifier;
	private EMFListEditUtil deploymentEditUtil;
	private ReferencesTable<?> deployment;
	private EMFListEditUtil redefinedPropertyEditUtil;
	private ReferencesTable<?> redefinedProperty;
	private EMFListEditUtil subsettedPropertyEditUtil;
	private ReferencesTable<?> subsettedProperty;




	
	public PropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createGeneralGroup(view);
		createOthersGroup(view);
		
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createGeneralGroup(Composite parent) {
		Group generalGroup = new Group(parent, SWT.NONE);
		generalGroup.setText(UMLMessages.PropertyPropertiesEditionPart_GeneralGroupLabel);
		GridData generalGroupData = new GridData(GridData.FILL_HORIZONTAL);
		generalGroupData.horizontalSpan = 3;
		generalGroup.setLayoutData(generalGroupData);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createNameText(generalGroup);
		createVisibilityEEnumViewer(generalGroup);
		createAggregationEEnumViewer(generalGroup);
		createTypeFlatComboViewer(generalGroup);
		createGeneralHBox1HBox(generalGroup);
		createGeneralHBox2HBox(generalGroup);
   	}
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.PropertyPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Property.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createVisibilityEEnumViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.PropertyPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Property.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFEnumViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createAggregationEEnumViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.PropertyPropertiesEditionPart_AggregationLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Property.aggregation, UMLViewsRepository.SWT_KIND));
		aggregation = new EMFEnumViewer(parent);
		aggregation.setContentProvider(new ArrayContentProvider());
		aggregation.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData aggregationData = new GridData(GridData.FILL_HORIZONTAL);
		aggregation.getCombo().setLayoutData(aggregationData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.aggregation, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param generalGroup
	 */
	protected void createTypeFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.PropertyPropertiesEditionPart_TypeLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Property.type, UMLViewsRepository.SWT_KIND));
		
		ViewerFilter typeFilter = new EObjectFilter(UMLPackage.eINSTANCE.getType());							
		type = new AdvancedEObjectFlatComboViewer<Type>(UMLMessages.PropertyPropertiesEditionPart_TypeLabel, 
			resourceSet, typeFilter, UMLPackage.eINSTANCE.getType(), new EObjectFlatComboViewerListener<Type>(){
			public void handleSet(Type element){
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.type, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(Type element){ System.out.println("NavigateTo"); }
		});
		type.createControls(parent);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);		
		type.setLayoutData(typeData);
		
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.type, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createGeneralHBox1HBox(Composite parent) {	
		Composite container = new Composite(parent, SWT.NONE);		
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan=2;
		container.setLayoutData(gridData);
		HorizontalBox generalHBox1HBox = new HorizontalBox(container);
		
		//Apply constraint for checkbox
		GridData constraint = new GridData(GridData.FILL_HORIZONTAL);		
		constraint.horizontalAlignment = GridData.BEGINNING;		
		generalHBox1HBox.setLayoutData(constraint);
		
		//create sub figures
			createIsOrderedCheckbox(generalHBox1HBox);
			createIsUniqueCheckbox(generalHBox1HBox);
			createIsStaticCheckbox(generalHBox1HBox);
			createIsReadOnlyCheckbox(generalHBox1HBox);
			createIsLeafCheckbox(generalHBox1HBox);
			createIsDerivedCheckbox(generalHBox1HBox);
			createIsDerivedUnionCheckbox(generalHBox1HBox);
		
		parent.pack();		
	}
	protected void createIsOrderedCheckbox(Composite parent) {
		isOrdered = new Button(parent, SWT.CHECK);
		isOrdered.setText(UMLMessages.PropertyPropertiesEditionPart_IsOrderedLabel);
		GridData isOrderedData = new GridData(GridData.FILL_HORIZONTAL);
		isOrderedData.horizontalSpan = 2;
		isOrdered.setLayoutData(isOrderedData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.isOrdered, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createIsUniqueCheckbox(Composite parent) {
		isUnique = new Button(parent, SWT.CHECK);
		isUnique.setText(UMLMessages.PropertyPropertiesEditionPart_IsUniqueLabel);
		GridData isUniqueData = new GridData(GridData.FILL_HORIZONTAL);
		isUniqueData.horizontalSpan = 2;
		isUnique.setLayoutData(isUniqueData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.isUnique, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createIsStaticCheckbox(Composite parent) {
		isStatic = new Button(parent, SWT.CHECK);
		isStatic.setText(UMLMessages.PropertyPropertiesEditionPart_IsStaticLabel);
		GridData isStaticData = new GridData(GridData.FILL_HORIZONTAL);
		isStaticData.horizontalSpan = 2;
		isStatic.setLayoutData(isStaticData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.isStatic, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createIsReadOnlyCheckbox(Composite parent) {
		isReadOnly = new Button(parent, SWT.CHECK);
		isReadOnly.setText(UMLMessages.PropertyPropertiesEditionPart_IsReadOnlyLabel);
		GridData isReadOnlyData = new GridData(GridData.FILL_HORIZONTAL);
		isReadOnlyData.horizontalSpan = 2;
		isReadOnly.setLayoutData(isReadOnlyData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.isReadOnly, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createIsLeafCheckbox(Composite parent) {
		isLeaf = new Button(parent, SWT.CHECK);
		isLeaf.setText(UMLMessages.PropertyPropertiesEditionPart_IsLeafLabel);
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.isLeaf, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createIsDerivedCheckbox(Composite parent) {
		isDerived = new Button(parent, SWT.CHECK);
		isDerived.setText(UMLMessages.PropertyPropertiesEditionPart_IsDerivedLabel);
		GridData isDerivedData = new GridData(GridData.FILL_HORIZONTAL);
		isDerivedData.horizontalSpan = 2;
		isDerived.setLayoutData(isDerivedData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.isDerived, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createIsDerivedUnionCheckbox(Composite parent) {
		isDerivedUnion = new Button(parent, SWT.CHECK);
		isDerivedUnion.setText(UMLMessages.PropertyPropertiesEditionPart_IsDerivedUnionLabel);
		GridData isDerivedUnionData = new GridData(GridData.FILL_HORIZONTAL);
		isDerivedUnionData.horizontalSpan = 2;
		isDerivedUnion.setLayoutData(isDerivedUnionData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.isDerivedUnion, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createGeneralHBox2HBox(Composite parent) {	
		Composite container = new Composite(parent, SWT.NONE);		
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan=2;
		container.setLayoutData(gridData);
		HorizontalBox generalHBox2HBox = new HorizontalBox(container);
		
		
		//create sub figures
				createLowerText(generalHBox2HBox);
				createUpperText(generalHBox2HBox);
		
		parent.pack();		
	}
	protected void createLowerText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.PropertyPropertiesEditionPart_LowerLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Property.lower, UMLViewsRepository.SWT_KIND));
		lower = new Text(parent, SWT.BORDER);
		GridData lowerData = new GridData(GridData.FILL_HORIZONTAL);
		lower.setLayoutData(lowerData);
		lower.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.lower, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, lower.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.lower, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createUpperText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.PropertyPropertiesEditionPart_UpperLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Property.upper, UMLViewsRepository.SWT_KIND));
		upper = new Text(parent, SWT.BORDER);
		GridData upperData = new GridData(GridData.FILL_HORIZONTAL);
		upper.setLayoutData(upperData);
		upper.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.upper, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, upper.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.upper, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createOthersGroup(Composite parent) {
		Group othersGroup = new Group(parent, SWT.NONE);
		othersGroup.setText(UMLMessages.PropertyPropertiesEditionPart_OthersGroupLabel);
		GridData othersGroupData = new GridData(GridData.FILL_HORIZONTAL);
		othersGroupData.horizontalSpan = 3;
		othersGroup.setLayoutData(othersGroupData);
		GridLayout othersGroupLayout = new GridLayout();
		othersGroupLayout.numColumns = 3;
		othersGroup.setLayout(othersGroupLayout);
		createOthersHBox1HBox(othersGroup);
		createOthersHBox2HBox(othersGroup);
   	}
	protected void createOthersHBox1HBox(Composite parent) {	
		Composite container = new Composite(parent, SWT.NONE);		
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan=2;
		container.setLayoutData(gridData);
		HorizontalBox othersHBox1HBox = new HorizontalBox(container);
		
		
		//create sub figures
				createTemplateBindingTableComposition(othersHBox1HBox);
				createQualifierTableComposition(othersHBox1HBox);
				createDeploymentTableComposition(othersHBox1HBox);
		
		parent.pack();		
	}
	/**
	 * @param container
	 */
	protected void createTemplateBindingTableComposition(Composite parent) {
		this.templateBinding = new ReferencesTable<TemplateBinding>(UMLMessages.PropertyPropertiesEditionPart_TemplateBindingLabel, new ReferencesTableListener<TemplateBinding>() {			
			public void handleAdd() { addToTemplateBinding();}
			public void handleEdit(TemplateBinding element) { editTemplateBinding(element); }
			public void handleMove(TemplateBinding element, int oldIndex, int newIndex) { moveTemplateBinding(element, oldIndex, newIndex); }			
			public void handleRemove(TemplateBinding element) { removeFromTemplateBinding(element); }
			public void navigateTo(TemplateBinding element) { System.out.println("---> navigateTo"); }
		});
		this.templateBinding.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.templateBinding, UMLViewsRepository.SWT_KIND));
		this.templateBinding.createControls(parent);
		GridData templateBindingData = new GridData(GridData.FILL_HORIZONTAL);
		templateBindingData.horizontalSpan = 3;
		this.templateBinding.setLayoutData(templateBindingData);
	}
		
	/**
	 * 
	 */
	private void moveTemplateBinding(TemplateBinding element, int oldIndex, int newIndex) {
				
		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		templateBindingEditUtil.moveElement(element, oldIndex, newIndex);
		templateBinding.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.templateBinding, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}	
	
	/**
	 * 
	 */
	private void addToTemplateBinding() {
	
		// Start of user code addToTemplateBinding() method body


		TemplateBinding eObject = UMLFactory.eINSTANCE.createTemplateBinding();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				templateBindingEditUtil.addElement(propertiesEditionObject);
				templateBinding.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.templateBinding, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		
		
		// End of user code		
	}

	/**
	 * 
	 */
	private void removeFromTemplateBinding(TemplateBinding element) {

		// Start of user code for the removeFromTemplateBinding() method body

		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		templateBindingEditUtil.removeElement(element);
		templateBinding.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.templateBinding, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editTemplateBinding(TemplateBinding element) {

		// Start of user code editTemplateBinding() method body
				 
		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				templateBindingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				templateBinding.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.templateBinding, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createQualifierTableComposition(Composite parent) {
		this.qualifier = new ReferencesTable<Property>(UMLMessages.PropertyPropertiesEditionPart_QualifierLabel, new ReferencesTableListener<Property>() {			
			public void handleAdd() { addToQualifier();}
			public void handleEdit(Property element) { editQualifier(element); }
			public void handleMove(Property element, int oldIndex, int newIndex) { moveQualifier(element, oldIndex, newIndex); }			
			public void handleRemove(Property element) { removeFromQualifier(element); }
			public void navigateTo(Property element) { System.out.println("---> navigateTo"); }
		});
		this.qualifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.qualifier, UMLViewsRepository.SWT_KIND));
		this.qualifier.createControls(parent);
		GridData qualifierData = new GridData(GridData.FILL_HORIZONTAL);
		qualifierData.horizontalSpan = 3;
		this.qualifier.setLayoutData(qualifierData);
	}
		
	/**
	 * 
	 */
	private void moveQualifier(Property element, int oldIndex, int newIndex) {
				
		EObject editedElement = qualifierEditUtil.foundCorrespondingEObject(element);
		qualifierEditUtil.moveElement(element, oldIndex, newIndex);
		qualifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.qualifier, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}	
	
	/**
	 * 
	 */
	private void addToQualifier() {
	
		// Start of user code addToQualifier() method body


		Property eObject = UMLFactory.eINSTANCE.createProperty();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				qualifierEditUtil.addElement(propertiesEditionObject);
				qualifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.qualifier, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		
		
		// End of user code		
	}

	/**
	 * 
	 */
	private void removeFromQualifier(Property element) {

		// Start of user code for the removeFromQualifier() method body

		EObject editedElement = qualifierEditUtil.foundCorrespondingEObject(element);
		qualifierEditUtil.removeElement(element);
		qualifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.qualifier, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editQualifier(Property element) {

		// Start of user code editQualifier() method body
				 
		EObject editedElement = qualifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				qualifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				qualifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.qualifier, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createDeploymentTableComposition(Composite parent) {
		this.deployment = new ReferencesTable<Deployment>(UMLMessages.PropertyPropertiesEditionPart_DeploymentLabel, new ReferencesTableListener<Deployment>() {			
			public void handleAdd() { addToDeployment();}
			public void handleEdit(Deployment element) { editDeployment(element); }
			public void handleMove(Deployment element, int oldIndex, int newIndex) { moveDeployment(element, oldIndex, newIndex); }			
			public void handleRemove(Deployment element) { removeFromDeployment(element); }
			public void navigateTo(Deployment element) { System.out.println("---> navigateTo"); }
		});
		this.deployment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.deployment, UMLViewsRepository.SWT_KIND));
		this.deployment.createControls(parent);
		GridData deploymentData = new GridData(GridData.FILL_HORIZONTAL);
		deploymentData.horizontalSpan = 3;
		this.deployment.setLayoutData(deploymentData);
	}
		
	/**
	 * 
	 */
	private void moveDeployment(Deployment element, int oldIndex, int newIndex) {
				
		EObject editedElement = deploymentEditUtil.foundCorrespondingEObject(element);
		deploymentEditUtil.moveElement(element, oldIndex, newIndex);
		deployment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.deployment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}	
	
	/**
	 * 
	 */
	private void addToDeployment() {
	
		// Start of user code addToDeployment() method body


		Deployment eObject = UMLFactory.eINSTANCE.createDeployment();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				deploymentEditUtil.addElement(propertiesEditionObject);
				deployment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.deployment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		
		
		// End of user code		
	}

	/**
	 * 
	 */
	private void removeFromDeployment(Deployment element) {

		// Start of user code for the removeFromDeployment() method body

		EObject editedElement = deploymentEditUtil.foundCorrespondingEObject(element);
		deploymentEditUtil.removeElement(element);
		deployment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.deployment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editDeployment(Deployment element) {

		// Start of user code editDeployment() method body
				 
		EObject editedElement = deploymentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				deploymentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				deployment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.deployment, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createOthersHBox2HBox(Composite parent) {	
		Composite container = new Composite(parent, SWT.NONE);		
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan=2;
		container.setLayoutData(gridData);
		HorizontalBox othersHBox2HBox = new HorizontalBox(container);
		
		
		//create sub figures
				createRedefinedPropertyReferencesTable(othersHBox2HBox);
				createSubsettedPropertyReferencesTable(othersHBox2HBox);
		
		parent.pack();		
	}
	protected void createRedefinedPropertyReferencesTable(Composite parent) {
		this.redefinedProperty = new ReferencesTable<Property>(UMLMessages.PropertyPropertiesEditionPart_RedefinedPropertyLabel, new ReferencesTableListener<Property>() {
			public void handleAdd() {				
				ViewerFilter redefinedPropertyFilter = new EObjectFilter(UMLPackage.eINSTANCE.getProperty());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!redefinedPropertyEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { redefinedPropertyFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Property> dialog = new TabElementTreeSelectionDialog<Property>(resourceSet, filters,
				"Property", UMLPackage.eINSTANCE.getProperty()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!redefinedPropertyEditUtil.getVirtualList().contains(elem))
								redefinedPropertyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.redefinedProperty,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						redefinedProperty.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(Property element) { editRedefinedProperty(element); }
			public void handleMove(Property element, int oldIndex, int newIndex) { moveRedefinedProperty(element, oldIndex, newIndex); }
			public void handleRemove(Property element) { removeFromRedefinedProperty(element); }
			public void navigateTo(Property element) { System.out.println("---> navigateTo"); }
		});
		this.redefinedProperty.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.redefinedProperty, UMLViewsRepository.SWT_KIND));
		this.redefinedProperty.createControls(parent);
		GridData redefinedPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		redefinedPropertyData.horizontalSpan = 3;
		this.redefinedProperty.setLayoutData(redefinedPropertyData);
		this.redefinedProperty.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveRedefinedProperty(Property element, int oldIndex, int newIndex) {
				
		EObject editedElement = redefinedPropertyEditUtil.foundCorrespondingEObject(element);
		redefinedPropertyEditUtil.moveElement(element, oldIndex, newIndex);
		redefinedProperty.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.redefinedProperty, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromRedefinedProperty(Property element) {

		// Start of user code for the removeFromRedefinedProperty() method body

		EObject editedElement = redefinedPropertyEditUtil.foundCorrespondingEObject(element);
		redefinedPropertyEditUtil.removeElement(element);
		redefinedProperty.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.redefinedProperty, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editRedefinedProperty(Property element) {

		// Start of user code editRedefinedProperty() method body
				 
		EObject editedElement = redefinedPropertyEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				redefinedPropertyEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				redefinedProperty.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.redefinedProperty, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createSubsettedPropertyReferencesTable(Composite parent) {
		this.subsettedProperty = new ReferencesTable<Property>(UMLMessages.PropertyPropertiesEditionPart_SubsettedPropertyLabel, new ReferencesTableListener<Property>() {
			public void handleAdd() {				
				ViewerFilter subsettedPropertyFilter = new EObjectFilter(UMLPackage.eINSTANCE.getProperty());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!subsettedPropertyEditUtil.contains((EObject)element));
						return false;					
					}
				};				
				ViewerFilter[] filters = { subsettedPropertyFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Property> dialog = new TabElementTreeSelectionDialog<Property>(resourceSet, filters,
				"Property", UMLPackage.eINSTANCE.getProperty()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!subsettedPropertyEditUtil.getVirtualList().contains(elem))
								subsettedPropertyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.subsettedProperty,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));	
						}
						subsettedProperty.refresh();											
					}
				};
				dialog.open();
			}
			public void handleEdit(Property element) { editSubsettedProperty(element); }
			public void handleMove(Property element, int oldIndex, int newIndex) { moveSubsettedProperty(element, oldIndex, newIndex); }
			public void handleRemove(Property element) { removeFromSubsettedProperty(element); }
			public void navigateTo(Property element) { System.out.println("---> navigateTo"); }
		});
		this.subsettedProperty.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Property.subsettedProperty, UMLViewsRepository.SWT_KIND));
		this.subsettedProperty.createControls(parent);
		GridData subsettedPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		subsettedPropertyData.horizontalSpan = 3;
		this.subsettedProperty.setLayoutData(subsettedPropertyData);
		this.subsettedProperty.disableMove();
	}
	
	/**
	 * 
	 */
	private void moveSubsettedProperty(Property element, int oldIndex, int newIndex) {
				
		EObject editedElement = subsettedPropertyEditUtil.foundCorrespondingEObject(element);
		subsettedPropertyEditUtil.moveElement(element, oldIndex, newIndex);
		subsettedProperty.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.subsettedProperty, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	private void removeFromSubsettedProperty(Property element) {

		// Start of user code for the removeFromSubsettedProperty() method body

		EObject editedElement = subsettedPropertyEditUtil.foundCorrespondingEObject(element);
		subsettedPropertyEditUtil.removeElement(element);
		subsettedProperty.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.subsettedProperty, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editSubsettedProperty(Property element) {

		// Start of user code editSubsettedProperty() method body
				 
		EObject editedElement = subsettedPropertyEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				subsettedPropertyEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				subsettedProperty.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertyPropertiesEditionPartImpl.this, UMLViewsRepository.Property.subsettedProperty, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.setSelection(new StructuredSelection(current));
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getAggregation()
	 */
	public Enumerator getAggregation() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) aggregation.getSelection()).getFirstElement();
		return selection.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#initAggregation(EEnum eenum, Enumerator current)
	 */
	public void initAggregation(EEnum eenum, Enumerator current) {
		aggregation.setInput(eenum.getELiterals());
		aggregation.setSelection(new StructuredSelection(current));
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setAggregation(Enumerator newValue)
	 */
	public void setAggregation(Enumerator newValue) {
		aggregation.modelUpdating(new StructuredSelection(newValue));
	}
	
	public void setMessageForAggregation (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForAggregation () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getType()
	 */
	public EObject getType() {		
		return type.getSelection();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#initType(ResourceSet allResources, EObject current)
	 */
	public void initType(ResourceSet allResources, EObject current) {
		type.setInput(allResources);
		if (current != null)
			type.setSelection(new StructuredSelection(current));
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setType(EObject newValue)
	 */
	public void setType(EObject newValue) {
		if (newValue != null){
			type.setSelection(newValue);
		}
	}
	
	public void setMessageForType (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForType () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getIsOrdered()
	 */
	public Boolean getIsOrdered() {
		return Boolean.valueOf(isOrdered.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setIsOrdered(Boolean newValue)
	 */
	public void setIsOrdered(Boolean newValue) {
		isOrdered.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForIsOrdered (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIsOrdered () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getIsUnique()
	 */
	public Boolean getIsUnique() {
		return Boolean.valueOf(isUnique.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setIsUnique(Boolean newValue)
	 */
	public void setIsUnique(Boolean newValue) {
		isUnique.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForIsUnique (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIsUnique () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getIsStatic()
	 */
	public Boolean getIsStatic() {
		return Boolean.valueOf(isStatic.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setIsStatic(Boolean newValue)
	 */
	public void setIsStatic(Boolean newValue) {
		isStatic.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForIsStatic (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIsStatic () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getIsReadOnly()
	 */
	public Boolean getIsReadOnly() {
		return Boolean.valueOf(isReadOnly.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setIsReadOnly(Boolean newValue)
	 */
	public void setIsReadOnly(Boolean newValue) {
		isReadOnly.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForIsReadOnly (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIsReadOnly () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setIsLeaf(Boolean newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getIsDerived()
	 */
	public Boolean getIsDerived() {
		return Boolean.valueOf(isDerived.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setIsDerived(Boolean newValue)
	 */
	public void setIsDerived(Boolean newValue) {
		isDerived.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForIsDerived (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIsDerived () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getIsDerivedUnion()
	 */
	public Boolean getIsDerivedUnion() {
		return Boolean.valueOf(isDerivedUnion.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setIsDerivedUnion(Boolean newValue)
	 */
	public void setIsDerivedUnion(Boolean newValue) {
		isDerivedUnion.setSelection(newValue.booleanValue());
	}
	
	public void setMessageForIsDerivedUnion (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForIsDerivedUnion () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getLower()
	 */
	public String getLower() {
		return lower.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setLower(String newValue)
	 */
	public void setLower(String newValue) {
		lower.setText(newValue);
	}
	
	public void setMessageForLower (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForLower () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getUpper()
	 */
	public String getUpper() {
		return upper.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#setUpper(String newValue)
	 */
	public void setUpper(String newValue) {
		upper.setText(newValue);
	}
	
	public void setMessageForUpper (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForUpper () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getTemplateBindingToAdd()
	 */
	public List getTemplateBindingToAdd() {
		return templateBindingEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getTemplateBindingToRemove()
	 */
	public List getTemplateBindingToRemove() {
		return templateBindingEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getTemplateBindingToEdit()
	 */
	public Map getTemplateBindingToEdit() {
		return templateBindingEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getTemplateBindingToMove()
	 */
	public List getTemplateBindingToMove() {
		return templateBindingEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getTemplateBindingTable()
	 */
	public List getTemplateBindingTable() {
		return templateBindingEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#initTemplateBinding(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTemplateBinding(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			templateBindingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			templateBindingEditUtil = new EMFListEditUtil(current, feature);	
		this.templateBinding.setInput(templateBindingEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#updateTemplateBinding(EObject newValue)
	 */
	public void updateTemplateBinding(EObject newValue) {
		if(templateBindingEditUtil!=null){
			templateBindingEditUtil.reinit(newValue);
			templateBinding.refresh();
		}		
	}
	
	public void setMessageForTemplateBinding (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForTemplateBinding () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getQualifierToAdd()
	 */
	public List getQualifierToAdd() {
		return qualifierEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getQualifierToRemove()
	 */
	public List getQualifierToRemove() {
		return qualifierEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getQualifierToEdit()
	 */
	public Map getQualifierToEdit() {
		return qualifierEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getQualifierToMove()
	 */
	public List getQualifierToMove() {
		return qualifierEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getQualifierTable()
	 */
	public List getQualifierTable() {
		return qualifierEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#initQualifier(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initQualifier(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			qualifierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			qualifierEditUtil = new EMFListEditUtil(current, feature);	
		this.qualifier.setInput(qualifierEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#updateQualifier(EObject newValue)
	 */
	public void updateQualifier(EObject newValue) {
		if(qualifierEditUtil!=null){
			qualifierEditUtil.reinit(newValue);
			qualifier.refresh();
		}		
	}
	
	public void setMessageForQualifier (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForQualifier () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getDeploymentToAdd()
	 */
	public List getDeploymentToAdd() {
		return deploymentEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getDeploymentToRemove()
	 */
	public List getDeploymentToRemove() {
		return deploymentEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getDeploymentToEdit()
	 */
	public Map getDeploymentToEdit() {
		return deploymentEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getDeploymentToMove()
	 */
	public List getDeploymentToMove() {
		return deploymentEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getDeploymentTable()
	 */
	public List getDeploymentTable() {
		return deploymentEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#initDeployment(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initDeployment(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			deploymentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			deploymentEditUtil = new EMFListEditUtil(current, feature);	
		this.deployment.setInput(deploymentEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#updateDeployment(EObject newValue)
	 */
	public void updateDeployment(EObject newValue) {
		if(deploymentEditUtil!=null){
			deploymentEditUtil.reinit(newValue);
			deployment.refresh();
		}		
	}
	
	public void setMessageForDeployment (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForDeployment () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getRedefinedPropertyToAdd()
	 */
	public List getRedefinedPropertyToAdd() {
		return redefinedPropertyEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getRedefinedPropertyToRemove()
	 */
	public List getRedefinedPropertyToRemove() {
		return redefinedPropertyEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#initRedefinedProperty(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRedefinedProperty(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			redefinedPropertyEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			redefinedPropertyEditUtil = new EMFListEditUtil(current, feature);	
		this.redefinedProperty.setInput(redefinedPropertyEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#updateRedefinedProperty(EObject newValue)
	 */
	public void updateRedefinedProperty(EObject newValue) {
		if(redefinedPropertyEditUtil!=null){
			redefinedPropertyEditUtil.reinit(newValue);
			redefinedProperty.refresh();
		}		
	}
	
	public void setMessageForRedefinedProperty (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForRedefinedProperty () {
	
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getSubsettedPropertyToAdd()
	 */
	public List getSubsettedPropertyToAdd() {
		return subsettedPropertyEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#getSubsettedPropertyToRemove()
	 */
	public List getSubsettedPropertyToRemove() {
		return subsettedPropertyEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#initSubsettedProperty(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSubsettedProperty(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			subsettedPropertyEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			subsettedPropertyEditUtil = new EMFListEditUtil(current, feature);	
		this.subsettedProperty.setInput(subsettedPropertyEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart#updateSubsettedProperty(EObject newValue)
	 */
	public void updateSubsettedProperty(EObject newValue) {
		if(subsettedPropertyEditUtil!=null){
			subsettedPropertyEditUtil.reinit(newValue);
			subsettedProperty.refresh();
		}		
	}
	
	public void setMessageForSubsettedProperty (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForSubsettedProperty () {
	
	}

	
	

	
	



	// Start of user code additional methods
 	
	// End of user code
}	
