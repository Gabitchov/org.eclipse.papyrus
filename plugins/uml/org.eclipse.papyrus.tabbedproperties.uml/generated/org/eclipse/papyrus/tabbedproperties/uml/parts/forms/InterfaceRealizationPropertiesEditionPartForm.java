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
package org.eclipse.papyrus.tabbedproperties.uml.parts.forms;

// Start of user code for imports

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
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFEnumViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InterfaceRealizationPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, InterfaceRealizationPropertiesEditionPart {

	private Text name;
	private EMFEnumViewer visibility;
	private EMFListEditUtil clientEditUtil;
	private ReferencesTable<?> client;
	private EMFListEditUtil supplierEditUtil;
	private ReferencesTable<?> supplier;




	
	public InterfaceRealizationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);		
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);	
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));		
		
		return scrolledForm;
	}
	
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) { 
		this.messageManager = messageManager;
		createGeneralGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createGeneralGroup(FormToolkit widgetFactory, final Composite view) {
		Section generalSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		generalSection.setText(UMLMessages.InterfaceRealizationPropertiesEditionPart_GeneralGroupLabel);
		GridData generalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		generalSectionData.horizontalSpan = 3;
		generalSection.setLayoutData(generalSectionData);
		Composite generalGroup = widgetFactory.createComposite(generalSection);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createNameText(widgetFactory, generalGroup);
		createVisibilityEEnumViewer(widgetFactory, generalGroup);
		createGenerelHBox1HBox(widgetFactory, generalGroup);
		generalSection.setClient(generalGroup);
	}   		
	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.InterfaceRealizationPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.InterfaceRealization.name, UMLViewsRepository.FORM_KIND));
		name = widgetFactory.createText(parent, "");  //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.name, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.name, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, name.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.InterfaceRealization.name, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createVisibilityEEnumViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.InterfaceRealizationPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.InterfaceRealization.visibility, UMLViewsRepository.FORM_KIND));
		visibility = new EMFEnumViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		visibility.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.visibility, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, getVisibility()));
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.InterfaceRealization.visibility, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createGenerelHBox1HBox(FormToolkit widgetFactory, Composite parent) {	
		Composite container = widgetFactory.createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan=3;
		container.setLayoutData(gridData);		
		HorizontalBox generelHBox1HBox = new HorizontalBox(container);
		
		
		//create sub figures
				createClientReferencesTable(widgetFactory, generelHBox1HBox);
				createSupplierReferencesTable(widgetFactory, generelHBox1HBox);
		
		container.pack();		
	}
	protected void createClientReferencesTable(FormToolkit widgetFactory, Composite parent) {	
		this.client = new ReferencesTable<NamedElement>(UMLMessages.InterfaceRealizationPropertiesEditionPart_ClientLabel, new ReferencesTableListener<NamedElement>() {
			public void handleAdd() {				
				ViewerFilter clientFilter = new EObjectFilter(UMLPackage.eINSTANCE.getNamedElement());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!clientEditUtil.contains((EObject)element));
						return false;				
					}
				};				
				ViewerFilter[] filters = { clientFilter, viewerFilter };		
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, filters, 
				"NamedElement", UMLPackage.eINSTANCE.getNamedElement()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!clientEditUtil.getVirtualList().contains(elem))
								clientEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.client,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));
						}
						client.refresh();												
					}
				};
				dialog.open();
			}
			public void handleEdit(NamedElement element) { editClient(element); }
			public void handleMove(NamedElement element, int oldIndex, int newIndex) { moveClient(element, oldIndex, newIndex); }
			public void handleRemove(NamedElement element) { removeFromClient(element); }
			public void navigateTo(NamedElement element) { System.out.println("---> navigateTo"); }
		});
		this.client.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InterfaceRealization.client, UMLViewsRepository.FORM_KIND));
		this.client.createControls(parent, widgetFactory);
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

		// Start of user code for the removeFromClient() method body

		EObject editedElement = clientEditUtil.foundCorrespondingEObject(element);
		clientEditUtil.removeElement(element);
		client.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.client, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editClient(NamedElement element) {

		// Start of user code editClient() method body
				 
		EObject editedElement = clientEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				clientEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				client.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.client, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createSupplierReferencesTable(FormToolkit widgetFactory, Composite parent) {	
		this.supplier = new ReferencesTable<NamedElement>(UMLMessages.InterfaceRealizationPropertiesEditionPart_SupplierLabel, new ReferencesTableListener<NamedElement>() {
			public void handleAdd() {				
				ViewerFilter supplierFilter = new EObjectFilter(UMLPackage.eINSTANCE.getNamedElement());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!supplierEditUtil.contains((EObject)element));
						return false;				
					}
				};				
				ViewerFilter[] filters = { supplierFilter, viewerFilter };		
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, filters, 
				"NamedElement", UMLPackage.eINSTANCE.getNamedElement()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!supplierEditUtil.getVirtualList().contains(elem))
								supplierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.supplier,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));
						}
						supplier.refresh();												
					}
				};
				dialog.open();
			}
			public void handleEdit(NamedElement element) { editSupplier(element); }
			public void handleMove(NamedElement element, int oldIndex, int newIndex) { moveSupplier(element, oldIndex, newIndex); }
			public void handleRemove(NamedElement element) { removeFromSupplier(element); }
			public void navigateTo(NamedElement element) { System.out.println("---> navigateTo"); }
		});
		this.supplier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InterfaceRealization.supplier, UMLViewsRepository.FORM_KIND));
		this.supplier.createControls(parent, widgetFactory);
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

		// Start of user code for the removeFromSupplier() method body

		EObject editedElement = supplierEditUtil.foundCorrespondingEObject(element);
		supplierEditUtil.removeElement(element);
		supplier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.supplier, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editSupplier(NamedElement element) {

		// Start of user code editSupplier() method body
				 
		EObject editedElement = supplierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				supplierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				supplier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(InterfaceRealizationPropertiesEditionPartForm.this, UMLViewsRepository.InterfaceRealization.supplier, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		name.setText(newValue);
	}
	
	public void setMessageForName (String msg, int msgLevel) {
	messageManager.addMessage("Name_key", msg, null, msgLevel, name);
}	
	
			public void unsetMessageForName () {
			messageManager.removeMessage("Name_key", name);
		}	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.setSelection(new StructuredSelection(current));
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#getClientToAdd()
	 */
	public List getClientToAdd() {
		return clientEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#getClientToRemove()
	 */
	public List getClientToRemove() {
		return clientEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#initClient(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initClient(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			clientEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			clientEditUtil = new EMFListEditUtil(current, feature);	
		this.client.setInput(clientEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#updateClient(EObject newValue)
	 */
	public void updateClient(EObject newValue) {
		if(clientEditUtil!=null){
			clientEditUtil.reinit(newValue);
			client.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#getSupplierToAdd()
	 */
	public List getSupplierToAdd() {
		return supplierEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#getSupplierToRemove()
	 */
	public List getSupplierToRemove() {
		return supplierEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#initSupplier(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSupplier(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			supplierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			supplierEditUtil = new EMFListEditUtil(current, feature);	
		this.supplier.setInput(supplierEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InterfaceRealizationPropertiesEditionPart#updateSupplier(EObject newValue)
	 */
	public void updateSupplier(EObject newValue) {
		if(supplierEditUtil!=null){
			supplierEditUtil.reinit(newValue);
			supplier.refresh();
		}		
	}
	
	
	
	







	
	// Start of user code additional methods
 	
	// End of user code
}	
