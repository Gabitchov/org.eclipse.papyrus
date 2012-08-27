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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart;
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
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ParameterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ParameterPropertiesEditionPart {

	protected Text name;

	protected EMFComboViewer visibility;

	private AdvancedEObjectFlatComboViewer<Type> type;

	protected ViewerFilter typeFilter;

	protected EMFComboViewer direction;

	protected EMFComboViewer effect;

	protected Button isOrdered;

	protected Button isUnique;

	protected Button isException;

	protected Button isStream;

	protected Text lower;

	protected Text upper;

	protected EMFListEditUtil parameterSetEditUtil;

	protected ReferencesTable<? extends EObject> parameterSet;

	protected List<ViewerFilter> parameterSetBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> parameterSetFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ParameterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		generalGroup.setText(UMLMessages.ParameterPropertiesEditionPart_GeneralGroupLabel);
		GridData generalGroupData = new GridData(GridData.FILL_HORIZONTAL);
		generalGroupData.horizontalSpan = 3;
		generalGroup.setLayoutData(generalGroupData);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createNameText(generalGroup);
		createVisibilityEMFComboViewer(generalGroup);
		createTypeAdvancedFlatComboViewer(generalGroup);
		createDirectionEMFComboViewer(generalGroup);
		createEffectEMFComboViewer(generalGroup);
		createGeneralHBox1HBox(generalGroup);
		createGeneralHBox2HBox(generalGroup);
		createParameterSetAdvancedReferencesTable(generalGroup);
	}

	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ParameterPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Parameter.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartImpl.this, UMLViewsRepository.Parameter.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ParameterPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Parameter.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param generalGroup
	 */
	protected void createTypeAdvancedFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ParameterPropertiesEditionPart_TypeLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Parameter.type, UMLViewsRepository.SWT_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<Type> listener = new EObjectFlatComboViewerListener<Type>() {

			public void handleSet(Type element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartImpl.this, UMLViewsRepository.Parameter.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element));
			}

			public void navigateTo(Type element) {
			}

			public Type handleCreate() {
				// TODO
				Type eObject = null;
				if(current != null && current instanceof TypedElement && ((TypedElement)current).getType() != null) {
					eObject = (Type)EcoreUtil.copy(((TypedElement)current).getType());
				}
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if(editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
					if(propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartImpl.this, UMLViewsRepository.Parameter.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
						return (Type)propertiesEditionObject;
					}
					if(current != null && current instanceof TypedElement && ((TypedElement)current).getType() != null)
						return eObject;
					return null;
				}
				return null;
			}
		};
		//create widget
		type = new AdvancedEObjectFlatComboViewer<Type>(UMLMessages.ParameterPropertiesEditionPart_TypeLabel,
				resourceSet, typeFilter, UMLPackage.eINSTANCE.getType(), listener);
		type.createControls(parent);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.setLayoutData(typeData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.type, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createDirectionEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ParameterPropertiesEditionPart_DirectionLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Parameter.direction, UMLViewsRepository.SWT_KIND));
		direction = new EMFComboViewer(parent);
		direction.setContentProvider(new ArrayContentProvider());
		direction.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData directionData = new GridData(GridData.FILL_HORIZONTAL);
		direction.getCombo().setLayoutData(directionData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.direction, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createEffectEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ParameterPropertiesEditionPart_EffectLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Parameter.effect, UMLViewsRepository.SWT_KIND));
		effect = new EMFComboViewer(parent);
		effect.setContentProvider(new ArrayContentProvider());
		effect.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData effectData = new GridData(GridData.FILL_HORIZONTAL);
		effect.getCombo().setLayoutData(effectData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.effect, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createGeneralHBox1HBox(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 2;
		container.setLayoutData(gridData);
		HorizontalBox generalHBox1HBox = new HorizontalBox(container);
		//Apply constraint for checkbox
		GridData constraint = new GridData(GridData.FILL_HORIZONTAL);
		constraint.horizontalAlignment = GridData.BEGINNING;
		generalHBox1HBox.setLayoutData(constraint);
		//create sub figures
		createIsOrderedCheckbox(generalHBox1HBox);
		createIsUniqueCheckbox(generalHBox1HBox);
		createIsExceptionCheckbox(generalHBox1HBox);
		createIsStreamCheckbox(generalHBox1HBox);
		parent.pack();
	}

	protected void createIsOrderedCheckbox(Composite parent) {
		isOrdered = new Button(parent, SWT.CHECK);
		isOrdered.setText(UMLMessages.ParameterPropertiesEditionPart_IsOrderedLabel);
		GridData isOrderedData = new GridData(GridData.FILL_HORIZONTAL);
		isOrderedData.horizontalSpan = 2;
		isOrdered.setLayoutData(isOrderedData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.isOrdered, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createIsUniqueCheckbox(Composite parent) {
		isUnique = new Button(parent, SWT.CHECK);
		isUnique.setText(UMLMessages.ParameterPropertiesEditionPart_IsUniqueLabel);
		GridData isUniqueData = new GridData(GridData.FILL_HORIZONTAL);
		isUniqueData.horizontalSpan = 2;
		isUnique.setLayoutData(isUniqueData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.isUnique, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createIsExceptionCheckbox(Composite parent) {
		isException = new Button(parent, SWT.CHECK);
		isException.setText(UMLMessages.ParameterPropertiesEditionPart_IsExceptionLabel);
		GridData isExceptionData = new GridData(GridData.FILL_HORIZONTAL);
		isExceptionData.horizontalSpan = 2;
		isException.setLayoutData(isExceptionData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.isException, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createIsStreamCheckbox(Composite parent) {
		isStream = new Button(parent, SWT.CHECK);
		isStream.setText(UMLMessages.ParameterPropertiesEditionPart_IsStreamLabel);
		GridData isStreamData = new GridData(GridData.FILL_HORIZONTAL);
		isStreamData.horizontalSpan = 2;
		isStream.setLayoutData(isStreamData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.isStream, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createGeneralHBox2HBox(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 2;
		container.setLayoutData(gridData);
		HorizontalBox generalHBox2HBox = new HorizontalBox(container);
		//create sub figures
		createLowerText(generalHBox2HBox);
		createUpperText(generalHBox2HBox);
		parent.pack();
	}

	protected void createLowerText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ParameterPropertiesEditionPart_LowerLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Parameter.lower, UMLViewsRepository.SWT_KIND));
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
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartImpl.this, UMLViewsRepository.Parameter.lower, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, lower.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.lower, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createUpperText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ParameterPropertiesEditionPart_UpperLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Parameter.upper, UMLViewsRepository.SWT_KIND));
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
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartImpl.this, UMLViewsRepository.Parameter.upper, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, upper.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.upper, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createParameterSetAdvancedReferencesTable(Composite parent) {
		this.parameterSet = new ReferencesTable<ParameterSet>(UMLMessages.ParameterPropertiesEditionPart_ParameterSetLabel, new ReferencesTableListener<ParameterSet>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<ParameterSet> dialog = new TabElementTreeSelectionDialog<ParameterSet>(resourceSet, parameterSetFilters, parameterSetBusinessFilters,
						"ParameterSet", UMLPackage.eINSTANCE.getParameterSet(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!parameterSetEditUtil.getVirtualList().contains(elem))
								parameterSetEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartImpl.this, UMLViewsRepository.Parameter.parameterSet,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						parameterSet.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(ParameterSet element) {
				editParameterSet(element);
			}

			public void handleMove(ParameterSet element, int oldIndex, int newIndex) {
				moveParameterSet(element, oldIndex, newIndex);
			}

			public void handleRemove(ParameterSet element) {
				removeFromParameterSet(element);
			}

			public void navigateTo(ParameterSet element) {
			}
		});
		this.parameterSet.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Parameter.parameterSet, UMLViewsRepository.SWT_KIND));
		this.parameterSet.createControls(parent);
		GridData parameterSetData = new GridData(GridData.FILL_HORIZONTAL);
		parameterSetData.horizontalSpan = 3;
		this.parameterSet.setLayoutData(parameterSetData);
		this.parameterSet.disableMove();
	}

	/**
	 * 
	 */
	protected void moveParameterSet(ParameterSet element, int oldIndex, int newIndex) {
		EObject editedElement = parameterSetEditUtil.foundCorrespondingEObject(element);
		parameterSetEditUtil.moveElement(element, oldIndex, newIndex);
		parameterSet.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartImpl.this, UMLViewsRepository.Parameter.parameterSet, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromParameterSet(ParameterSet element) {

		// Start of user code removeFromParameterSet() method body
		EObject editedElement = parameterSetEditUtil.foundCorrespondingEObject(element);
		parameterSetEditUtil.removeElement(element);
		parameterSet.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ParameterPropertiesEditionPartImpl.this, UMLViewsRepository.Parameter.parameterSet,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editParameterSet(ParameterSet element) {

		// Start of user code editParameterSet() method body
		EObject editedElement = parameterSetEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				parameterSetEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				parameterSet.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ParameterPropertiesEditionPartImpl.this, UMLViewsRepository.Parameter.parameterSet,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getType()
	 */
	public EObject getType() {
		return type.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#initType(ResourceSet allResources, EObject current)
	 */
	public void initType(ResourceSet allResources, EObject current) {
		type.setInput(allResources);
		if(current != null) {
			type.setSelection(new StructuredSelection(current));
			type.setMainResource(current.eResource());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setType(EObject newValue)
	 */
	public void setType(EObject newValue) {
		if(newValue != null) {
			type.setSelection(new StructuredSelection(newValue));
		} else {
			type.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setTypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTypeButtonMode(ButtonsModeEnum newValue) {
		type.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#addFilterType(ViewerFilter filter)
	 */
	public void addFilterToType(ViewerFilter filter) {
		type.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#addBusinessFilterType(ViewerFilter filter)
	 */
	public void addBusinessFilterToType(ViewerFilter filter) {
		type.addBusinessRuleFilter(filter);
	}

	public void setMessageForType(String msg, int msgLevel) {

	}

	public void unsetMessageForType() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getDirection()
	 */
	public Enumerator getDirection() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)direction.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#initDirection(EEnum eenum, Enumerator current)
	 */
	public void initDirection(EEnum eenum, Enumerator current) {
		direction.setInput(eenum.getELiterals());
		direction.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setDirection(Enumerator newValue)
	 */
	public void setDirection(Enumerator newValue) {
		direction.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForDirection(String msg, int msgLevel) {

	}

	public void unsetMessageForDirection() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getEffect()
	 */
	public Enumerator getEffect() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)effect.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#initEffect(EEnum eenum, Enumerator current)
	 */
	public void initEffect(EEnum eenum, Enumerator current) {
		effect.setInput(eenum.getELiterals());
		effect.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setEffect(Enumerator newValue)
	 */
	public void setEffect(Enumerator newValue) {
		effect.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForEffect(String msg, int msgLevel) {

	}

	public void unsetMessageForEffect() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getIsOrdered()
	 */
	public Boolean getIsOrdered() {
		return Boolean.valueOf(isOrdered.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setIsOrdered(Boolean newValue)
	 */
	public void setIsOrdered(Boolean newValue) {
		if(newValue != null) {
			isOrdered.setSelection(newValue.booleanValue());
		} else {
			isOrdered.setSelection(false);
		}
	}

	public void setMessageForIsOrdered(String msg, int msgLevel) {

	}

	public void unsetMessageForIsOrdered() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getIsUnique()
	 */
	public Boolean getIsUnique() {
		return Boolean.valueOf(isUnique.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setIsUnique(Boolean newValue)
	 */
	public void setIsUnique(Boolean newValue) {
		if(newValue != null) {
			isUnique.setSelection(newValue.booleanValue());
		} else {
			isUnique.setSelection(false);
		}
	}

	public void setMessageForIsUnique(String msg, int msgLevel) {

	}

	public void unsetMessageForIsUnique() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getIsException()
	 */
	public Boolean getIsException() {
		return Boolean.valueOf(isException.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setIsException(Boolean newValue)
	 */
	public void setIsException(Boolean newValue) {
		if(newValue != null) {
			isException.setSelection(newValue.booleanValue());
		} else {
			isException.setSelection(false);
		}
	}

	public void setMessageForIsException(String msg, int msgLevel) {

	}

	public void unsetMessageForIsException() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getIsStream()
	 */
	public Boolean getIsStream() {
		return Boolean.valueOf(isStream.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setIsStream(Boolean newValue)
	 */
	public void setIsStream(Boolean newValue) {
		if(newValue != null) {
			isStream.setSelection(newValue.booleanValue());
		} else {
			isStream.setSelection(false);
		}
	}

	public void setMessageForIsStream(String msg, int msgLevel) {

	}

	public void unsetMessageForIsStream() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getLower()
	 */
	public String getLower() {
		return lower.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setLower(String newValue)
	 */
	public void setLower(String newValue) {
		if(newValue != null) {
			lower.setText(newValue);
		} else {
			lower.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForLower(String msg, int msgLevel) {

	}

	public void unsetMessageForLower() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getUpper()
	 */
	public String getUpper() {
		return upper.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#setUpper(String newValue)
	 */
	public void setUpper(String newValue) {
		if(newValue != null) {
			upper.setText(newValue);
		} else {
			upper.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForUpper(String msg, int msgLevel) {

	}

	public void unsetMessageForUpper() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getParameterSetToAdd()
	 */
	public List getParameterSetToAdd() {
		return parameterSetEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getParameterSetToRemove()
	 */
	public List getParameterSetToRemove() {
		return parameterSetEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#getParameterSetTable()
	 */
	public List getParameterSetTable() {
		return parameterSetEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#initParameterSet(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initParameterSet(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			parameterSetEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			parameterSetEditUtil = new EMFListEditUtil(current, feature);
		this.parameterSet.setInput(parameterSetEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#updateParameterSet(EObject newValue)
	 */
	public void updateParameterSet(EObject newValue) {
		if(parameterSetEditUtil != null) {
			parameterSetEditUtil.reinit(newValue);
			parameterSet.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#addFilterParameterSet(ViewerFilter filter)
	 */
	public void addFilterToParameterSet(ViewerFilter filter) {
		parameterSetFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#addBusinessFilterParameterSet(ViewerFilter filter)
	 */
	public void addBusinessFilterToParameterSet(ViewerFilter filter) {
		parameterSetBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart#isContainedInParameterSetTable(EObject element)
	 */
	public boolean isContainedInParameterSetTable(EObject element) {
		return parameterSetEditUtil.contains(element);
	}

	public void setMessageForParameterSet(String msg, int msgLevel) {

	}

	public void unsetMessageForParameterSet() {

	}





	// Start of user code additional methods

	// End of user code

}
