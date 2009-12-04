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
import org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart;
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
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class RealizationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RealizationPropertiesEditionPart {

	protected Text name;

	protected EMFComboViewer visibility;

	protected EMFListEditUtil clientEditUtil;

	protected ReferencesTable<? extends EObject> client;

	protected List<ViewerFilter> clientBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> clientFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil supplierEditUtil;

	protected ReferencesTable<? extends EObject> supplier;

	protected List<ViewerFilter> supplierBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> supplierFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public RealizationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		generalGroup.setText(UMLMessages.RealizationPropertiesEditionPart_GeneralGroupLabel);
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
		SWTUtils.createPartLabel(parent, UMLMessages.RealizationPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Realization.name, UMLViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RealizationPropertiesEditionPartImpl.this, UMLViewsRepository.Realization.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Realization.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.RealizationPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Realization.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Realization.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
		createClientAdvancedReferencesTable(generalHBox1HBox);
		createSupplierAdvancedReferencesTable(generalHBox1HBox);
		parent.pack();
	}

	protected void createClientAdvancedReferencesTable(Composite parent) {
		this.client = new ReferencesTable<NamedElement>(UMLMessages.RealizationPropertiesEditionPart_ClientLabel, new ReferencesTableListener<NamedElement>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, clientFilters, clientBusinessFilters,
						"NamedElement", UMLPackage.eINSTANCE.getNamedElement(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientEditUtil.getVirtualList().contains(elem))
								clientEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RealizationPropertiesEditionPartImpl.this, UMLViewsRepository.Realization.client,
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
		this.client.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Realization.client, UMLViewsRepository.SWT_KIND));
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
				RealizationPropertiesEditionPartImpl.this, UMLViewsRepository.Realization.client,
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
						RealizationPropertiesEditionPartImpl.this, UMLViewsRepository.Realization.client,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createSupplierAdvancedReferencesTable(Composite parent) {
		this.supplier = new ReferencesTable<NamedElement>(UMLMessages.RealizationPropertiesEditionPart_SupplierLabel, new ReferencesTableListener<NamedElement>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, supplierFilters, supplierBusinessFilters,
						"NamedElement", UMLPackage.eINSTANCE.getNamedElement(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!supplierEditUtil.getVirtualList().contains(elem))
								supplierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RealizationPropertiesEditionPartImpl.this, UMLViewsRepository.Realization.supplier,
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
		this.supplier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Realization.supplier, UMLViewsRepository.SWT_KIND));
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
				RealizationPropertiesEditionPartImpl.this, UMLViewsRepository.Realization.supplier,
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
						RealizationPropertiesEditionPartImpl.this, UMLViewsRepository.Realization.supplier,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#setVisibility(Enumerator newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#getClientToAdd()
	 */
	public List getClientToAdd() {
		return clientEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#getClientToRemove()
	 */
	public List getClientToRemove() {
		return clientEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#getClientTable()
	 */
	public List getClientTable() {
		return clientEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#initClient(EObject current, EReference containingFeature,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#updateClient(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#addFilterClient(ViewerFilter filter)
	 */
	public void addFilterToClient(ViewerFilter filter) {
		clientFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#addBusinessFilterClient(ViewerFilter filter)
	 */
	public void addBusinessFilterToClient(ViewerFilter filter) {
		clientBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#isContainedInClientTable(EObject element)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#getSupplierToAdd()
	 */
	public List getSupplierToAdd() {
		return supplierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#getSupplierToRemove()
	 */
	public List getSupplierToRemove() {
		return supplierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#getSupplierTable()
	 */
	public List getSupplierTable() {
		return supplierEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#initSupplier(EObject current, EReference
	 *      containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#updateSupplier(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#addFilterSupplier(ViewerFilter filter)
	 */
	public void addFilterToSupplier(ViewerFilter filter) {
		supplierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#addBusinessFilterSupplier(ViewerFilter filter)
	 */
	public void addBusinessFilterToSupplier(ViewerFilter filter) {
		supplierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RealizationPropertiesEditionPart#isContainedInSupplierTable(EObject element)
	 */
	public boolean isContainedInSupplierTable(EObject element) {
		return supplierEditUtil.contains(element);
	}

	public void setMessageForSupplier(String msg, int msgLevel) {

	}

	public void unsetMessageForSupplier() {

	}





	// Start of user code additional methods

	// End of user code

}
