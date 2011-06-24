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
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
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
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class AssociationClassPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, AssociationClassPropertiesEditionPart {

	protected Text name;

	protected EMFComboViewer visibility;

	protected Button isLeaf;

	protected Button isAbstract;

	protected Button isActive;

	protected Button isDerived;

	protected EMFListEditUtil ownedEndEditUtil;

	protected ReferencesTable<? extends EObject> ownedEnd;

	protected List<ViewerFilter> ownedEndBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedEndFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil memberEndEditUtil;

	protected ReferencesTable<? extends EObject> memberEnd;

	protected List<ViewerFilter> memberEndBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> memberEndFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil navigableOwnedEndEditUtil;

	protected ReferencesTable<? extends EObject> navigableOwnedEnd;

	protected List<ViewerFilter> navigableOwnedEndBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> navigableOwnedEndFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedReceptionEditUtil;

	protected ReferencesTable<? extends EObject> ownedReception;

	protected List<ViewerFilter> ownedReceptionBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedReceptionFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil interfaceRealizationEditUtil;

	protected ReferencesTable<? extends EObject> interfaceRealization;

	protected List<ViewerFilter> interfaceRealizationBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> interfaceRealizationFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedOperationEditUtil;

	protected ReferencesTable<? extends EObject> ownedOperation;

	protected List<ViewerFilter> ownedOperationBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedOperationFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil nestedClassifierEditUtil;

	protected ReferencesTable<? extends EObject> nestedClassifier;

	protected List<ViewerFilter> nestedClassifierBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> nestedClassifierFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedTriggerEditUtil;

	protected ReferencesTable<? extends EObject> ownedTrigger;

	protected List<ViewerFilter> ownedTriggerBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedTriggerFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedBehaviorEditUtil;

	protected ReferencesTable<? extends EObject> ownedBehavior;

	protected List<ViewerFilter> ownedBehaviorBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedBehaviorFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedConnectorEditUtil;

	protected ReferencesTable<? extends EObject> ownedConnector;

	protected List<ViewerFilter> ownedConnectorBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedConnectorFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedAttributeEditUtil;

	protected ReferencesTable<? extends EObject> ownedAttribute;

	protected List<ViewerFilter> ownedAttributeBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedAttributeFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil useCaseEditUtil;

	protected ReferencesTable<? extends EObject> useCase;

	protected List<ViewerFilter> useCaseBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> useCaseFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedUseCaseEditUtil;

	protected ReferencesTable<? extends EObject> ownedUseCase;

	protected List<ViewerFilter> ownedUseCaseBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedUseCaseFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil collaborationUseEditUtil;

	protected ReferencesTable<? extends EObject> collaborationUse;

	protected List<ViewerFilter> collaborationUseBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> collaborationUseFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil redefinedClassifierEditUtil;

	protected ReferencesTable<? extends EObject> redefinedClassifier;

	protected List<ViewerFilter> redefinedClassifierBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> redefinedClassifierFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil generalizationEditUtil;

	protected ReferencesTable<? extends EObject> generalization;

	protected List<ViewerFilter> generalizationBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> generalizationFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil templateBindingEditUtil;

	protected ReferencesTable<? extends EObject> templateBinding;

	protected List<ViewerFilter> templateBindingBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> templateBindingFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil substitutionEditUtil;

	protected ReferencesTable<? extends EObject> substitution;

	protected List<ViewerFilter> substitutionBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> substitutionFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil packageImportEditUtil;

	protected ReferencesTable<? extends EObject> packageImport;

	protected List<ViewerFilter> packageImportBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> packageImportFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil elementImportEditUtil;

	protected ReferencesTable<? extends EObject> elementImport;

	protected List<ViewerFilter> elementImportBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> elementImportFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil powertypeExtentEditUtil;

	protected ReferencesTable<? extends EObject> powertypeExtent;

	protected List<ViewerFilter> powertypeExtentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> powertypeExtentFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedRuleEditUtil;

	protected ReferencesTable<? extends EObject> ownedRule;

	protected List<ViewerFilter> ownedRuleBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedRuleFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public AssociationClassPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart# createFigure(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.forms.widgets.FormToolkit)
	 */
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart# createControls(org.eclipse.ui.forms.widgets.FormToolkit,
	 *      org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createGeneralGroup(widgetFactory, view);
		createOthersGroup(widgetFactory, view);
		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createGeneralGroup(FormToolkit widgetFactory, final Composite view) {
		Section generalSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		generalSection.setText(UMLMessages.AssociationClassPropertiesEditionPart_GeneralGroupLabel);
		GridData generalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		generalSectionData.horizontalSpan = 3;
		generalSection.setLayoutData(generalSectionData);
		Composite generalGroup = widgetFactory.createComposite(generalSection);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createNameText(widgetFactory, generalGroup);
		createVisibilityEMFComboViewer(widgetFactory, generalGroup);
		createGeneralHBox1HBox(widgetFactory, generalGroup);
		createGeneralHBox2HBox(widgetFactory, generalGroup);
		generalSection.setClient(generalGroup);
	}

	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.AssociationClassPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.AssociationClass.name, UMLViewsRepository.FORM_KIND));
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
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
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if(e.character == SWT.CR) {
					if(propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.name, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.AssociationClassPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.AssociationClass.visibility, UMLViewsRepository.FORM_KIND));
		visibility = new EMFComboViewer(parent);
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
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.visibility, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVisibility()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.visibility, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createGeneralHBox1HBox(FormToolkit widgetFactory, Composite parent) {
		Composite container = widgetFactory.createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox generalHBox1HBox = new HorizontalBox(container);
		//Apply constraint for checkbox
		GridData constraint = new GridData(GridData.FILL_HORIZONTAL);
		constraint.horizontalAlignment = GridData.BEGINNING;
		generalHBox1HBox.setLayoutData(constraint);
		//create sub figures
		createIsLeafCheckbox(widgetFactory, generalHBox1HBox);
		createIsAbstractCheckbox(widgetFactory, generalHBox1HBox);
		createIsActiveCheckbox(widgetFactory, generalHBox1HBox);
		createIsDerivedCheckbox(widgetFactory, generalHBox1HBox);
		container.pack();
	}

	protected void createIsLeafCheckbox(FormToolkit widgetFactory, Composite parent) {
		isLeaf = widgetFactory.createButton(parent, UMLMessages.AssociationClassPropertiesEditionPart_IsLeafLabel, SWT.CHECK);
		isLeaf.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.isLeaf, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isLeaf.getSelection())));
			}

		});
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.isLeaf, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createIsAbstractCheckbox(FormToolkit widgetFactory, Composite parent) {
		isAbstract = widgetFactory.createButton(parent, UMLMessages.AssociationClassPropertiesEditionPart_IsAbstractLabel, SWT.CHECK);
		isAbstract.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.isAbstract, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isAbstract.getSelection())));
			}

		});
		GridData isAbstractData = new GridData(GridData.FILL_HORIZONTAL);
		isAbstractData.horizontalSpan = 2;
		isAbstract.setLayoutData(isAbstractData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.isAbstract, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createIsActiveCheckbox(FormToolkit widgetFactory, Composite parent) {
		isActive = widgetFactory.createButton(parent, UMLMessages.AssociationClassPropertiesEditionPart_IsActiveLabel, SWT.CHECK);
		isActive.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.isActive, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isActive.getSelection())));
			}

		});
		GridData isActiveData = new GridData(GridData.FILL_HORIZONTAL);
		isActiveData.horizontalSpan = 2;
		isActive.setLayoutData(isActiveData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.isActive, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createIsDerivedCheckbox(FormToolkit widgetFactory, Composite parent) {
		isDerived = widgetFactory.createButton(parent, UMLMessages.AssociationClassPropertiesEditionPart_IsDerivedLabel, SWT.CHECK);
		isDerived.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.isDerived, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isDerived.getSelection())));
			}

		});
		GridData isDerivedData = new GridData(GridData.FILL_HORIZONTAL);
		isDerivedData.horizontalSpan = 2;
		isDerived.setLayoutData(isDerivedData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.isDerived, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createGeneralHBox2HBox(FormToolkit widgetFactory, Composite parent) {
		Composite container = widgetFactory.createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox generalHBox2HBox = new HorizontalBox(container);
		//create sub figures
		createOwnedEndTableComposition(widgetFactory, generalHBox2HBox);
		createMemberEndReferencesTable(widgetFactory, generalHBox2HBox);
		createNavigableOwnedEndReferencesTable(widgetFactory, generalHBox2HBox);
		container.pack();
	}

	/**
	 * @param container
	 */
	protected void createOwnedEndTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedEnd = new ReferencesTable<Property>(UMLMessages.AssociationClassPropertiesEditionPart_OwnedEndLabel, new ReferencesTableListener<Property>() {

			public void handleAdd() {
				addToOwnedEnd();
			}

			public void handleEdit(Property element) {
				editOwnedEnd(element);
			}

			public void handleMove(Property element, int oldIndex, int newIndex) {
				moveOwnedEnd(element, oldIndex, newIndex);
			}

			public void handleRemove(Property element) {
				removeFromOwnedEnd(element);
			}

			public void navigateTo(Property element) {
			}
		});
		this.ownedEnd.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.ownedEnd, UMLViewsRepository.FORM_KIND));
		this.ownedEnd.createControls(parent, widgetFactory);
		GridData ownedEndData = new GridData(GridData.FILL_HORIZONTAL);
		ownedEndData.horizontalSpan = 3;
		this.ownedEnd.setLayoutData(ownedEndData);
	}

	/**
	 * 
	 */
	protected void moveOwnedEnd(Property element, int oldIndex, int newIndex) {
		EObject editedElement = ownedEndEditUtil.foundCorrespondingEObject(element);
		ownedEndEditUtil.moveElement(element, oldIndex, newIndex);
		ownedEnd.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedEnd, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedEnd() {
		// Start of user code addToOwnedEnd() method body
		Property eObject = UMLFactory.eINSTANCE.createProperty();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedEndEditUtil.addElement(propertiesEditionObject);
				ownedEnd.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedEnd,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedEnd(Property element) {
		// Start of user code for the removeFromOwnedEnd() method body
		EObject editedElement = ownedEndEditUtil.foundCorrespondingEObject(element);
		ownedEndEditUtil.removeElement(element);
		ownedEnd.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedEnd,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedEnd(Property element) {
		// Start of user code editOwnedEnd() method body
		EObject editedElement = ownedEndEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedEndEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedEnd.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedEnd,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createMemberEndReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.memberEnd = new ReferencesTable<Property>(UMLMessages.AssociationClassPropertiesEditionPart_MemberEndLabel, new ReferencesTableListener<Property>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Property> dialog = new TabElementTreeSelectionDialog<Property>(resourceSet, memberEndFilters, memberEndBusinessFilters,
						"Property", UMLPackage.eINSTANCE.getProperty(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!memberEndEditUtil.getVirtualList().contains(elem))
								memberEndEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.memberEnd,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						memberEnd.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Property element) {
				editMemberEnd(element);
			}

			public void handleMove(Property element, int oldIndex, int newIndex) {
				moveMemberEnd(element, oldIndex, newIndex);
			}

			public void handleRemove(Property element) {
				removeFromMemberEnd(element);
			}

			public void navigateTo(Property element) {
			}
		});
		this.memberEnd.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.memberEnd, UMLViewsRepository.FORM_KIND));
		this.memberEnd.createControls(parent, widgetFactory);
		GridData memberEndData = new GridData(GridData.FILL_HORIZONTAL);
		memberEndData.horizontalSpan = 3;
		this.memberEnd.setLayoutData(memberEndData);
		this.memberEnd.disableMove();
	}

	/**
	 * 
	 */
	protected void moveMemberEnd(Property element, int oldIndex, int newIndex) {
		EObject editedElement = memberEndEditUtil.foundCorrespondingEObject(element);
		memberEndEditUtil.moveElement(element, oldIndex, newIndex);
		memberEnd.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.memberEnd, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromMemberEnd(Property element) {
		// Start of user code for the removeFromMemberEnd() method body
		EObject editedElement = memberEndEditUtil.foundCorrespondingEObject(element);
		memberEndEditUtil.removeElement(element);
		memberEnd.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.memberEnd,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editMemberEnd(Property element) {
		// Start of user code editMemberEnd() method body

		EObject editedElement = memberEndEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				memberEndEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				memberEnd.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.memberEnd,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createNavigableOwnedEndReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.navigableOwnedEnd = new ReferencesTable<Property>(UMLMessages.AssociationClassPropertiesEditionPart_NavigableOwnedEndLabel, new ReferencesTableListener<Property>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Property> dialog = new TabElementTreeSelectionDialog<Property>(resourceSet, navigableOwnedEndFilters, navigableOwnedEndBusinessFilters,
						"Property", UMLPackage.eINSTANCE.getProperty(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!navigableOwnedEndEditUtil.getVirtualList().contains(elem))
								navigableOwnedEndEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.navigableOwnedEnd,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						navigableOwnedEnd.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Property element) {
				editNavigableOwnedEnd(element);
			}

			public void handleMove(Property element, int oldIndex, int newIndex) {
				moveNavigableOwnedEnd(element, oldIndex, newIndex);
			}

			public void handleRemove(Property element) {
				removeFromNavigableOwnedEnd(element);
			}

			public void navigateTo(Property element) {
			}
		});
		this.navigableOwnedEnd.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.navigableOwnedEnd, UMLViewsRepository.FORM_KIND));
		this.navigableOwnedEnd.createControls(parent, widgetFactory);
		GridData navigableOwnedEndData = new GridData(GridData.FILL_HORIZONTAL);
		navigableOwnedEndData.horizontalSpan = 3;
		this.navigableOwnedEnd.setLayoutData(navigableOwnedEndData);
		this.navigableOwnedEnd.disableMove();
	}

	/**
	 * 
	 */
	protected void moveNavigableOwnedEnd(Property element, int oldIndex, int newIndex) {
		EObject editedElement = navigableOwnedEndEditUtil.foundCorrespondingEObject(element);
		navigableOwnedEndEditUtil.moveElement(element, oldIndex, newIndex);
		navigableOwnedEnd.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.navigableOwnedEnd, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromNavigableOwnedEnd(Property element) {
		// Start of user code for the removeFromNavigableOwnedEnd() method body
		EObject editedElement = navigableOwnedEndEditUtil.foundCorrespondingEObject(element);
		navigableOwnedEndEditUtil.removeElement(element);
		navigableOwnedEnd.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.navigableOwnedEnd,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editNavigableOwnedEnd(Property element) {
		// Start of user code editNavigableOwnedEnd() method body

		EObject editedElement = navigableOwnedEndEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				navigableOwnedEndEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				navigableOwnedEnd.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.navigableOwnedEnd, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createOthersGroup(FormToolkit widgetFactory, final Composite view) {
		Section othersSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		othersSection.setText(UMLMessages.AssociationClassPropertiesEditionPart_OthersGroupLabel);
		GridData othersSectionData = new GridData(GridData.FILL_HORIZONTAL);
		othersSectionData.horizontalSpan = 3;
		othersSection.setLayoutData(othersSectionData);
		Composite othersGroup = widgetFactory.createComposite(othersSection);
		GridLayout othersGroupLayout = new GridLayout();
		othersGroupLayout.numColumns = 3;
		othersGroup.setLayout(othersGroupLayout);
		createOthersHBox1HBox(widgetFactory, othersGroup);
		othersSection.setClient(othersGroup);
	}

	protected void createOthersHBox1HBox(FormToolkit widgetFactory, Composite parent) {
		Composite container = widgetFactory.createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox othersHBox1HBox = new HorizontalBox(container);
		//create sub figures
		createOwnedReceptionTableComposition(widgetFactory, othersHBox1HBox);
		createInterfaceRealizationTableComposition(widgetFactory, othersHBox1HBox);
		createOwnedOperationTableComposition(widgetFactory, othersHBox1HBox);
		createNestedClassifierTableComposition(widgetFactory, othersHBox1HBox);
		createOwnedTriggerTableComposition(widgetFactory, othersHBox1HBox);
		createOwnedBehaviorTableComposition(widgetFactory, othersHBox1HBox);
		createOwnedConnectorTableComposition(widgetFactory, othersHBox1HBox);
		createOwnedAttributeTableComposition(widgetFactory, othersHBox1HBox);
		createUseCaseReferencesTable(widgetFactory, othersHBox1HBox);
		createOwnedUseCaseTableComposition(widgetFactory, othersHBox1HBox);
		createCollaborationUseTableComposition(widgetFactory, othersHBox1HBox);
		createRedefinedClassifierReferencesTable(widgetFactory, othersHBox1HBox);
		createGeneralizationTableComposition(widgetFactory, othersHBox1HBox);
		createTemplateBindingTableComposition(widgetFactory, othersHBox1HBox);
		createSubstitutionTableComposition(widgetFactory, othersHBox1HBox);
		createPackageImportTableComposition(widgetFactory, othersHBox1HBox);
		createElementImportTableComposition(widgetFactory, othersHBox1HBox);
		createPowertypeExtentReferencesTable(widgetFactory, othersHBox1HBox);
		createOwnedRuleTableComposition(widgetFactory, othersHBox1HBox);
		container.pack();
	}

	/**
	 * @param container
	 */
	protected void createOwnedReceptionTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedReception = new ReferencesTable<Reception>(UMLMessages.AssociationClassPropertiesEditionPart_OwnedReceptionLabel, new ReferencesTableListener<Reception>() {

			public void handleAdd() {
				addToOwnedReception();
			}

			public void handleEdit(Reception element) {
				editOwnedReception(element);
			}

			public void handleMove(Reception element, int oldIndex, int newIndex) {
				moveOwnedReception(element, oldIndex, newIndex);
			}

			public void handleRemove(Reception element) {
				removeFromOwnedReception(element);
			}

			public void navigateTo(Reception element) {
			}
		});
		this.ownedReception.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.ownedReception, UMLViewsRepository.FORM_KIND));
		this.ownedReception.createControls(parent, widgetFactory);
		GridData ownedReceptionData = new GridData(GridData.FILL_HORIZONTAL);
		ownedReceptionData.horizontalSpan = 3;
		this.ownedReception.setLayoutData(ownedReceptionData);
	}

	/**
	 * 
	 */
	protected void moveOwnedReception(Reception element, int oldIndex, int newIndex) {
		EObject editedElement = ownedReceptionEditUtil.foundCorrespondingEObject(element);
		ownedReceptionEditUtil.moveElement(element, oldIndex, newIndex);
		ownedReception.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedReception, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedReception() {
		// Start of user code addToOwnedReception() method body
		Reception eObject = UMLFactory.eINSTANCE.createReception();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedReceptionEditUtil.addElement(propertiesEditionObject);
				ownedReception.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedReception, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedReception(Reception element) {
		// Start of user code for the removeFromOwnedReception() method body
		EObject editedElement = ownedReceptionEditUtil.foundCorrespondingEObject(element);
		ownedReceptionEditUtil.removeElement(element);
		ownedReception.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedReception,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedReception(Reception element) {
		// Start of user code editOwnedReception() method body
		EObject editedElement = ownedReceptionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedReceptionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedReception.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedReception, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createInterfaceRealizationTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.interfaceRealization = new ReferencesTable<InterfaceRealization>(UMLMessages.AssociationClassPropertiesEditionPart_InterfaceRealizationLabel, new ReferencesTableListener<InterfaceRealization>() {

			public void handleAdd() {
				addToInterfaceRealization();
			}

			public void handleEdit(InterfaceRealization element) {
				editInterfaceRealization(element);
			}

			public void handleMove(InterfaceRealization element, int oldIndex, int newIndex) {
				moveInterfaceRealization(element, oldIndex, newIndex);
			}

			public void handleRemove(InterfaceRealization element) {
				removeFromInterfaceRealization(element);
			}

			public void navigateTo(InterfaceRealization element) {
			}
		});
		this.interfaceRealization.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.interfaceRealization, UMLViewsRepository.FORM_KIND));
		this.interfaceRealization.createControls(parent, widgetFactory);
		GridData interfaceRealizationData = new GridData(GridData.FILL_HORIZONTAL);
		interfaceRealizationData.horizontalSpan = 3;
		this.interfaceRealization.setLayoutData(interfaceRealizationData);
	}

	/**
	 * 
	 */
	protected void moveInterfaceRealization(InterfaceRealization element, int oldIndex, int newIndex) {
		EObject editedElement = interfaceRealizationEditUtil.foundCorrespondingEObject(element);
		interfaceRealizationEditUtil.moveElement(element, oldIndex, newIndex);
		interfaceRealization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.interfaceRealization, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToInterfaceRealization() {
		// Start of user code addToInterfaceRealization() method body
		InterfaceRealization eObject = UMLFactory.eINSTANCE.createInterfaceRealization();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				interfaceRealizationEditUtil.addElement(propertiesEditionObject);
				interfaceRealization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.interfaceRealization, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromInterfaceRealization(InterfaceRealization element) {
		// Start of user code for the removeFromInterfaceRealization() method body
		EObject editedElement = interfaceRealizationEditUtil.foundCorrespondingEObject(element);
		interfaceRealizationEditUtil.removeElement(element);
		interfaceRealization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this,
				UMLViewsRepository.AssociationClass.interfaceRealization, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editInterfaceRealization(InterfaceRealization element) {
		// Start of user code editInterfaceRealization() method body
		EObject editedElement = interfaceRealizationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				interfaceRealizationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				interfaceRealization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.interfaceRealization, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedOperationTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedOperation = new ReferencesTable<Operation>(UMLMessages.AssociationClassPropertiesEditionPart_OwnedOperationLabel, new ReferencesTableListener<Operation>() {

			public void handleAdd() {
				addToOwnedOperation();
			}

			public void handleEdit(Operation element) {
				editOwnedOperation(element);
			}

			public void handleMove(Operation element, int oldIndex, int newIndex) {
				moveOwnedOperation(element, oldIndex, newIndex);
			}

			public void handleRemove(Operation element) {
				removeFromOwnedOperation(element);
			}

			public void navigateTo(Operation element) {
			}
		});
		this.ownedOperation.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.ownedOperation, UMLViewsRepository.FORM_KIND));
		this.ownedOperation.createControls(parent, widgetFactory);
		GridData ownedOperationData = new GridData(GridData.FILL_HORIZONTAL);
		ownedOperationData.horizontalSpan = 3;
		this.ownedOperation.setLayoutData(ownedOperationData);
	}

	/**
	 * 
	 */
	protected void moveOwnedOperation(Operation element, int oldIndex, int newIndex) {
		EObject editedElement = ownedOperationEditUtil.foundCorrespondingEObject(element);
		ownedOperationEditUtil.moveElement(element, oldIndex, newIndex);
		ownedOperation.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedOperation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedOperation() {
		// Start of user code addToOwnedOperation() method body
		Operation eObject = UMLFactory.eINSTANCE.createOperation();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedOperationEditUtil.addElement(propertiesEditionObject);
				ownedOperation.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedOperation, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedOperation(Operation element) {
		// Start of user code for the removeFromOwnedOperation() method body
		EObject editedElement = ownedOperationEditUtil.foundCorrespondingEObject(element);
		ownedOperationEditUtil.removeElement(element);
		ownedOperation.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedOperation,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedOperation(Operation element) {
		// Start of user code editOwnedOperation() method body
		EObject editedElement = ownedOperationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedOperationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedOperation.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedOperation, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createNestedClassifierTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.nestedClassifier = new ReferencesTable<Classifier>(UMLMessages.AssociationClassPropertiesEditionPart_NestedClassifierLabel, new ReferencesTableListener<Classifier>() {

			public void handleAdd() {
				addToNestedClassifier();
			}

			public void handleEdit(Classifier element) {
				editNestedClassifier(element);
			}

			public void handleMove(Classifier element, int oldIndex, int newIndex) {
				moveNestedClassifier(element, oldIndex, newIndex);
			}

			public void handleRemove(Classifier element) {
				removeFromNestedClassifier(element);
			}

			public void navigateTo(Classifier element) {
			}
		});
		this.nestedClassifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.nestedClassifier, UMLViewsRepository.FORM_KIND));
		this.nestedClassifier.createControls(parent, widgetFactory);
		GridData nestedClassifierData = new GridData(GridData.FILL_HORIZONTAL);
		nestedClassifierData.horizontalSpan = 3;
		this.nestedClassifier.setLayoutData(nestedClassifierData);
	}

	/**
	 * 
	 */
	protected void moveNestedClassifier(Classifier element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void addToNestedClassifier() {
		// Start of user code addToNestedClassifier() method body
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromNestedClassifier(Classifier element) {
		// Start of user code for the removeFromNestedClassifier() method body
		EObject editedElement = nestedClassifierEditUtil.foundCorrespondingEObject(element);
		nestedClassifierEditUtil.removeElement(element);
		nestedClassifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.nestedClassifier,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editNestedClassifier(Classifier element) {
		// Start of user code editNestedClassifier() method body
		EObject editedElement = nestedClassifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				nestedClassifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				nestedClassifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.nestedClassifier, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedTriggerTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedTrigger = new ReferencesTable<Trigger>(UMLMessages.AssociationClassPropertiesEditionPart_OwnedTriggerLabel, new ReferencesTableListener<Trigger>() {

			public void handleAdd() {
				addToOwnedTrigger();
			}

			public void handleEdit(Trigger element) {
				editOwnedTrigger(element);
			}

			public void handleMove(Trigger element, int oldIndex, int newIndex) {
				moveOwnedTrigger(element, oldIndex, newIndex);
			}

			public void handleRemove(Trigger element) {
				removeFromOwnedTrigger(element);
			}

			public void navigateTo(Trigger element) {
			}
		});
		this.ownedTrigger.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.ownedTrigger, UMLViewsRepository.FORM_KIND));
		this.ownedTrigger.createControls(parent, widgetFactory);
		GridData ownedTriggerData = new GridData(GridData.FILL_HORIZONTAL);
		ownedTriggerData.horizontalSpan = 3;
		this.ownedTrigger.setLayoutData(ownedTriggerData);
	}

	/**
	 * 
	 */
	protected void moveOwnedTrigger(Trigger element, int oldIndex, int newIndex) {
		EObject editedElement = ownedTriggerEditUtil.foundCorrespondingEObject(element);
		ownedTriggerEditUtil.moveElement(element, oldIndex, newIndex);
		ownedTrigger.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedTrigger, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedTrigger() {
		// Start of user code addToOwnedTrigger() method body
		Trigger eObject = UMLFactory.eINSTANCE.createTrigger();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedTriggerEditUtil.addElement(propertiesEditionObject);
				ownedTrigger.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedTrigger, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedTrigger(Trigger element) {
		// Start of user code for the removeFromOwnedTrigger() method body
		EObject editedElement = ownedTriggerEditUtil.foundCorrespondingEObject(element);
		ownedTriggerEditUtil.removeElement(element);
		ownedTrigger.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedTrigger,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedTrigger(Trigger element) {
		// Start of user code editOwnedTrigger() method body
		EObject editedElement = ownedTriggerEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedTriggerEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedTrigger.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedTrigger, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedBehaviorTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedBehavior = new ReferencesTable<Behavior>(UMLMessages.AssociationClassPropertiesEditionPart_OwnedBehaviorLabel, new ReferencesTableListener<Behavior>() {

			public void handleAdd() {
				addToOwnedBehavior();
			}

			public void handleEdit(Behavior element) {
				editOwnedBehavior(element);
			}

			public void handleMove(Behavior element, int oldIndex, int newIndex) {
				moveOwnedBehavior(element, oldIndex, newIndex);
			}

			public void handleRemove(Behavior element) {
				removeFromOwnedBehavior(element);
			}

			public void navigateTo(Behavior element) {
			}
		});
		this.ownedBehavior.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.ownedBehavior, UMLViewsRepository.FORM_KIND));
		this.ownedBehavior.createControls(parent, widgetFactory);
		GridData ownedBehaviorData = new GridData(GridData.FILL_HORIZONTAL);
		ownedBehaviorData.horizontalSpan = 3;
		this.ownedBehavior.setLayoutData(ownedBehaviorData);
	}

	/**
	 * 
	 */
	protected void moveOwnedBehavior(Behavior element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void addToOwnedBehavior() {
		// Start of user code addToOwnedBehavior() method body
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedBehavior(Behavior element) {
		// Start of user code for the removeFromOwnedBehavior() method body
		EObject editedElement = ownedBehaviorEditUtil.foundCorrespondingEObject(element);
		ownedBehaviorEditUtil.removeElement(element);
		ownedBehavior.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedBehavior,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedBehavior(Behavior element) {
		// Start of user code editOwnedBehavior() method body
		EObject editedElement = ownedBehaviorEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedBehaviorEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedBehavior.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedBehavior, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedConnectorTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedConnector = new ReferencesTable<Connector>(UMLMessages.AssociationClassPropertiesEditionPart_OwnedConnectorLabel, new ReferencesTableListener<Connector>() {

			public void handleAdd() {
				addToOwnedConnector();
			}

			public void handleEdit(Connector element) {
				editOwnedConnector(element);
			}

			public void handleMove(Connector element, int oldIndex, int newIndex) {
				moveOwnedConnector(element, oldIndex, newIndex);
			}

			public void handleRemove(Connector element) {
				removeFromOwnedConnector(element);
			}

			public void navigateTo(Connector element) {
			}
		});
		this.ownedConnector.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.ownedConnector, UMLViewsRepository.FORM_KIND));
		this.ownedConnector.createControls(parent, widgetFactory);
		GridData ownedConnectorData = new GridData(GridData.FILL_HORIZONTAL);
		ownedConnectorData.horizontalSpan = 3;
		this.ownedConnector.setLayoutData(ownedConnectorData);
	}

	/**
	 * 
	 */
	protected void moveOwnedConnector(Connector element, int oldIndex, int newIndex) {
		EObject editedElement = ownedConnectorEditUtil.foundCorrespondingEObject(element);
		ownedConnectorEditUtil.moveElement(element, oldIndex, newIndex);
		ownedConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedConnector() {
		// Start of user code addToOwnedConnector() method body
		Connector eObject = UMLFactory.eINSTANCE.createConnector();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedConnectorEditUtil.addElement(propertiesEditionObject);
				ownedConnector.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedConnector, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedConnector(Connector element) {
		// Start of user code for the removeFromOwnedConnector() method body
		EObject editedElement = ownedConnectorEditUtil.foundCorrespondingEObject(element);
		ownedConnectorEditUtil.removeElement(element);
		ownedConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedConnector,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedConnector(Connector element) {
		// Start of user code editOwnedConnector() method body
		EObject editedElement = ownedConnectorEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedConnectorEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedConnector.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedConnector, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedAttributeTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedAttribute = new ReferencesTable<Property>(UMLMessages.AssociationClassPropertiesEditionPart_OwnedAttributeLabel, new ReferencesTableListener<Property>() {

			public void handleAdd() {
				addToOwnedAttribute();
			}

			public void handleEdit(Property element) {
				editOwnedAttribute(element);
			}

			public void handleMove(Property element, int oldIndex, int newIndex) {
				moveOwnedAttribute(element, oldIndex, newIndex);
			}

			public void handleRemove(Property element) {
				removeFromOwnedAttribute(element);
			}

			public void navigateTo(Property element) {
			}
		});
		this.ownedAttribute.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.ownedAttribute, UMLViewsRepository.FORM_KIND));
		this.ownedAttribute.createControls(parent, widgetFactory);
		GridData ownedAttributeData = new GridData(GridData.FILL_HORIZONTAL);
		ownedAttributeData.horizontalSpan = 3;
		this.ownedAttribute.setLayoutData(ownedAttributeData);
	}

	/**
	 * 
	 */
	protected void moveOwnedAttribute(Property element, int oldIndex, int newIndex) {
		EObject editedElement = ownedAttributeEditUtil.foundCorrespondingEObject(element);
		ownedAttributeEditUtil.moveElement(element, oldIndex, newIndex);
		ownedAttribute.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedAttribute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedAttribute() {
		// Start of user code addToOwnedAttribute() method body
		Property eObject = UMLFactory.eINSTANCE.createProperty();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedAttributeEditUtil.addElement(propertiesEditionObject);
				ownedAttribute.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedAttribute, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedAttribute(Property element) {
		// Start of user code for the removeFromOwnedAttribute() method body
		EObject editedElement = ownedAttributeEditUtil.foundCorrespondingEObject(element);
		ownedAttributeEditUtil.removeElement(element);
		ownedAttribute.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedAttribute,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedAttribute(Property element) {
		// Start of user code editOwnedAttribute() method body
		EObject editedElement = ownedAttributeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedAttributeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedAttribute.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedAttribute, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createUseCaseReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.useCase = new ReferencesTable<UseCase>(UMLMessages.AssociationClassPropertiesEditionPart_UseCaseLabel, new ReferencesTableListener<UseCase>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<UseCase> dialog = new TabElementTreeSelectionDialog<UseCase>(resourceSet, useCaseFilters, useCaseBusinessFilters,
						"UseCase", UMLPackage.eINSTANCE.getUseCase(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!useCaseEditUtil.getVirtualList().contains(elem))
								useCaseEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.useCase,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						useCase.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(UseCase element) {
				editUseCase(element);
			}

			public void handleMove(UseCase element, int oldIndex, int newIndex) {
				moveUseCase(element, oldIndex, newIndex);
			}

			public void handleRemove(UseCase element) {
				removeFromUseCase(element);
			}

			public void navigateTo(UseCase element) {
			}
		});
		this.useCase.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.useCase, UMLViewsRepository.FORM_KIND));
		this.useCase.createControls(parent, widgetFactory);
		GridData useCaseData = new GridData(GridData.FILL_HORIZONTAL);
		useCaseData.horizontalSpan = 3;
		this.useCase.setLayoutData(useCaseData);
		this.useCase.disableMove();
	}

	/**
	 * 
	 */
	protected void moveUseCase(UseCase element, int oldIndex, int newIndex) {
		EObject editedElement = useCaseEditUtil.foundCorrespondingEObject(element);
		useCaseEditUtil.moveElement(element, oldIndex, newIndex);
		useCase.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.useCase, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromUseCase(UseCase element) {
		// Start of user code for the removeFromUseCase() method body
		EObject editedElement = useCaseEditUtil.foundCorrespondingEObject(element);
		useCaseEditUtil.removeElement(element);
		useCase.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.useCase,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editUseCase(UseCase element) {
		// Start of user code editUseCase() method body

		EObject editedElement = useCaseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				useCaseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				useCase.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.useCase,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedUseCaseTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedUseCase = new ReferencesTable<UseCase>(UMLMessages.AssociationClassPropertiesEditionPart_OwnedUseCaseLabel, new ReferencesTableListener<UseCase>() {

			public void handleAdd() {
				addToOwnedUseCase();
			}

			public void handleEdit(UseCase element) {
				editOwnedUseCase(element);
			}

			public void handleMove(UseCase element, int oldIndex, int newIndex) {
				moveOwnedUseCase(element, oldIndex, newIndex);
			}

			public void handleRemove(UseCase element) {
				removeFromOwnedUseCase(element);
			}

			public void navigateTo(UseCase element) {
			}
		});
		this.ownedUseCase.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.ownedUseCase, UMLViewsRepository.FORM_KIND));
		this.ownedUseCase.createControls(parent, widgetFactory);
		GridData ownedUseCaseData = new GridData(GridData.FILL_HORIZONTAL);
		ownedUseCaseData.horizontalSpan = 3;
		this.ownedUseCase.setLayoutData(ownedUseCaseData);
	}

	/**
	 * 
	 */
	protected void moveOwnedUseCase(UseCase element, int oldIndex, int newIndex) {
		EObject editedElement = ownedUseCaseEditUtil.foundCorrespondingEObject(element);
		ownedUseCaseEditUtil.moveElement(element, oldIndex, newIndex);
		ownedUseCase.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedUseCase, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedUseCase() {
		// Start of user code addToOwnedUseCase() method body
		UseCase eObject = UMLFactory.eINSTANCE.createUseCase();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedUseCaseEditUtil.addElement(propertiesEditionObject);
				ownedUseCase.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedUseCase, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedUseCase(UseCase element) {
		// Start of user code for the removeFromOwnedUseCase() method body
		EObject editedElement = ownedUseCaseEditUtil.foundCorrespondingEObject(element);
		ownedUseCaseEditUtil.removeElement(element);
		ownedUseCase.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedUseCase,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedUseCase(UseCase element) {
		// Start of user code editOwnedUseCase() method body
		EObject editedElement = ownedUseCaseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedUseCaseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedUseCase.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.ownedUseCase, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createCollaborationUseTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.collaborationUse = new ReferencesTable<CollaborationUse>(UMLMessages.AssociationClassPropertiesEditionPart_CollaborationUseLabel, new ReferencesTableListener<CollaborationUse>() {

			public void handleAdd() {
				addToCollaborationUse();
			}

			public void handleEdit(CollaborationUse element) {
				editCollaborationUse(element);
			}

			public void handleMove(CollaborationUse element, int oldIndex, int newIndex) {
				moveCollaborationUse(element, oldIndex, newIndex);
			}

			public void handleRemove(CollaborationUse element) {
				removeFromCollaborationUse(element);
			}

			public void navigateTo(CollaborationUse element) {
			}
		});
		this.collaborationUse.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.collaborationUse, UMLViewsRepository.FORM_KIND));
		this.collaborationUse.createControls(parent, widgetFactory);
		GridData collaborationUseData = new GridData(GridData.FILL_HORIZONTAL);
		collaborationUseData.horizontalSpan = 3;
		this.collaborationUse.setLayoutData(collaborationUseData);
	}

	/**
	 * 
	 */
	protected void moveCollaborationUse(CollaborationUse element, int oldIndex, int newIndex) {
		EObject editedElement = collaborationUseEditUtil.foundCorrespondingEObject(element);
		collaborationUseEditUtil.moveElement(element, oldIndex, newIndex);
		collaborationUse.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.collaborationUse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToCollaborationUse() {
		// Start of user code addToCollaborationUse() method body
		CollaborationUse eObject = UMLFactory.eINSTANCE.createCollaborationUse();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				collaborationUseEditUtil.addElement(propertiesEditionObject);
				collaborationUse.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.collaborationUse, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromCollaborationUse(CollaborationUse element) {
		// Start of user code for the removeFromCollaborationUse() method body
		EObject editedElement = collaborationUseEditUtil.foundCorrespondingEObject(element);
		collaborationUseEditUtil.removeElement(element);
		collaborationUse.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.collaborationUse,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editCollaborationUse(CollaborationUse element) {
		// Start of user code editCollaborationUse() method body
		EObject editedElement = collaborationUseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				collaborationUseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				collaborationUse.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.collaborationUse, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createRedefinedClassifierReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.redefinedClassifier = new ReferencesTable<Classifier>(UMLMessages.AssociationClassPropertiesEditionPart_RedefinedClassifierLabel, new ReferencesTableListener<Classifier>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, redefinedClassifierFilters, redefinedClassifierBusinessFilters,
						"Classifier", UMLPackage.eINSTANCE.getClassifier(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!redefinedClassifierEditUtil.getVirtualList().contains(elem))
								redefinedClassifierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.redefinedClassifier,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						redefinedClassifier.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Classifier element) {
				editRedefinedClassifier(element);
			}

			public void handleMove(Classifier element, int oldIndex, int newIndex) {
				moveRedefinedClassifier(element, oldIndex, newIndex);
			}

			public void handleRemove(Classifier element) {
				removeFromRedefinedClassifier(element);
			}

			public void navigateTo(Classifier element) {
			}
		});
		this.redefinedClassifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.redefinedClassifier, UMLViewsRepository.FORM_KIND));
		this.redefinedClassifier.createControls(parent, widgetFactory);
		GridData redefinedClassifierData = new GridData(GridData.FILL_HORIZONTAL);
		redefinedClassifierData.horizontalSpan = 3;
		this.redefinedClassifier.setLayoutData(redefinedClassifierData);
		this.redefinedClassifier.disableMove();
	}

	/**
	 * 
	 */
	protected void moveRedefinedClassifier(Classifier element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromRedefinedClassifier(Classifier element) {
		// Start of user code for the removeFromRedefinedClassifier() method body
		EObject editedElement = redefinedClassifierEditUtil.foundCorrespondingEObject(element);
		redefinedClassifierEditUtil.removeElement(element);
		redefinedClassifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this,
				UMLViewsRepository.AssociationClass.redefinedClassifier, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRedefinedClassifier(Classifier element) {
		// Start of user code editRedefinedClassifier() method body

		EObject editedElement = redefinedClassifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				redefinedClassifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				redefinedClassifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.redefinedClassifier, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createGeneralizationTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.generalization = new ReferencesTable<Generalization>(UMLMessages.AssociationClassPropertiesEditionPart_GeneralizationLabel, new ReferencesTableListener<Generalization>() {

			public void handleAdd() {
				addToGeneralization();
			}

			public void handleEdit(Generalization element) {
				editGeneralization(element);
			}

			public void handleMove(Generalization element, int oldIndex, int newIndex) {
				moveGeneralization(element, oldIndex, newIndex);
			}

			public void handleRemove(Generalization element) {
				removeFromGeneralization(element);
			}

			public void navigateTo(Generalization element) {
			}
		});
		this.generalization.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.generalization, UMLViewsRepository.FORM_KIND));
		this.generalization.createControls(parent, widgetFactory);
		GridData generalizationData = new GridData(GridData.FILL_HORIZONTAL);
		generalizationData.horizontalSpan = 3;
		this.generalization.setLayoutData(generalizationData);
	}

	/**
	 * 
	 */
	protected void moveGeneralization(Generalization element, int oldIndex, int newIndex) {
		EObject editedElement = generalizationEditUtil.foundCorrespondingEObject(element);
		generalizationEditUtil.moveElement(element, oldIndex, newIndex);
		generalization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.generalization, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToGeneralization() {
		// Start of user code addToGeneralization() method body
		Generalization eObject = UMLFactory.eINSTANCE.createGeneralization();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				generalizationEditUtil.addElement(propertiesEditionObject);
				generalization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.generalization, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromGeneralization(Generalization element) {
		// Start of user code for the removeFromGeneralization() method body
		EObject editedElement = generalizationEditUtil.foundCorrespondingEObject(element);
		generalizationEditUtil.removeElement(element);
		generalization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.generalization,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editGeneralization(Generalization element) {
		// Start of user code editGeneralization() method body
		EObject editedElement = generalizationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				generalizationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				generalization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.generalization, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createTemplateBindingTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.templateBinding = new ReferencesTable<TemplateBinding>(UMLMessages.AssociationClassPropertiesEditionPart_TemplateBindingLabel, new ReferencesTableListener<TemplateBinding>() {

			public void handleAdd() {
				addToTemplateBinding();
			}

			public void handleEdit(TemplateBinding element) {
				editTemplateBinding(element);
			}

			public void handleMove(TemplateBinding element, int oldIndex, int newIndex) {
				moveTemplateBinding(element, oldIndex, newIndex);
			}

			public void handleRemove(TemplateBinding element) {
				removeFromTemplateBinding(element);
			}

			public void navigateTo(TemplateBinding element) {
			}
		});
		this.templateBinding.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.templateBinding, UMLViewsRepository.FORM_KIND));
		this.templateBinding.createControls(parent, widgetFactory);
		GridData templateBindingData = new GridData(GridData.FILL_HORIZONTAL);
		templateBindingData.horizontalSpan = 3;
		this.templateBinding.setLayoutData(templateBindingData);
	}

	/**
	 * 
	 */
	protected void moveTemplateBinding(TemplateBinding element, int oldIndex, int newIndex) {
		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		templateBindingEditUtil.moveElement(element, oldIndex, newIndex);
		templateBinding.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.templateBinding, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToTemplateBinding() {
		// Start of user code addToTemplateBinding() method body
		TemplateBinding eObject = UMLFactory.eINSTANCE.createTemplateBinding();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				templateBindingEditUtil.addElement(propertiesEditionObject);
				templateBinding.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.templateBinding, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromTemplateBinding(TemplateBinding element) {
		// Start of user code for the removeFromTemplateBinding() method body
		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		templateBindingEditUtil.removeElement(element);
		templateBinding.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.templateBinding,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editTemplateBinding(TemplateBinding element) {
		// Start of user code editTemplateBinding() method body
		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				templateBindingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				templateBinding.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.templateBinding, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createSubstitutionTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.substitution = new ReferencesTable<Substitution>(UMLMessages.AssociationClassPropertiesEditionPart_SubstitutionLabel, new ReferencesTableListener<Substitution>() {

			public void handleAdd() {
				addToSubstitution();
			}

			public void handleEdit(Substitution element) {
				editSubstitution(element);
			}

			public void handleMove(Substitution element, int oldIndex, int newIndex) {
				moveSubstitution(element, oldIndex, newIndex);
			}

			public void handleRemove(Substitution element) {
				removeFromSubstitution(element);
			}

			public void navigateTo(Substitution element) {
			}
		});
		this.substitution.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.substitution, UMLViewsRepository.FORM_KIND));
		this.substitution.createControls(parent, widgetFactory);
		GridData substitutionData = new GridData(GridData.FILL_HORIZONTAL);
		substitutionData.horizontalSpan = 3;
		this.substitution.setLayoutData(substitutionData);
	}

	/**
	 * 
	 */
	protected void moveSubstitution(Substitution element, int oldIndex, int newIndex) {
		EObject editedElement = substitutionEditUtil.foundCorrespondingEObject(element);
		substitutionEditUtil.moveElement(element, oldIndex, newIndex);
		substitution.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.substitution, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToSubstitution() {
		// Start of user code addToSubstitution() method body
		Substitution eObject = UMLFactory.eINSTANCE.createSubstitution();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				substitutionEditUtil.addElement(propertiesEditionObject);
				substitution.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.substitution, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromSubstitution(Substitution element) {
		// Start of user code for the removeFromSubstitution() method body
		EObject editedElement = substitutionEditUtil.foundCorrespondingEObject(element);
		substitutionEditUtil.removeElement(element);
		substitution.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.substitution,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSubstitution(Substitution element) {
		// Start of user code editSubstitution() method body
		EObject editedElement = substitutionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				substitutionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				substitution.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.substitution, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createPackageImportTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.packageImport = new ReferencesTable<PackageImport>(UMLMessages.AssociationClassPropertiesEditionPart_PackageImportLabel, new ReferencesTableListener<PackageImport>() {

			public void handleAdd() {
				addToPackageImport();
			}

			public void handleEdit(PackageImport element) {
				editPackageImport(element);
			}

			public void handleMove(PackageImport element, int oldIndex, int newIndex) {
				movePackageImport(element, oldIndex, newIndex);
			}

			public void handleRemove(PackageImport element) {
				removeFromPackageImport(element);
			}

			public void navigateTo(PackageImport element) {
			}
		});
		this.packageImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.packageImport, UMLViewsRepository.FORM_KIND));
		this.packageImport.createControls(parent, widgetFactory);
		GridData packageImportData = new GridData(GridData.FILL_HORIZONTAL);
		packageImportData.horizontalSpan = 3;
		this.packageImport.setLayoutData(packageImportData);
	}

	/**
	 * 
	 */
	protected void movePackageImport(PackageImport element, int oldIndex, int newIndex) {
		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		packageImportEditUtil.moveElement(element, oldIndex, newIndex);
		packageImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.packageImport, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToPackageImport() {
		// Start of user code addToPackageImport() method body
		PackageImport eObject = UMLFactory.eINSTANCE.createPackageImport();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				packageImportEditUtil.addElement(propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.packageImport, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromPackageImport(PackageImport element) {
		// Start of user code for the removeFromPackageImport() method body
		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		packageImportEditUtil.removeElement(element);
		packageImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.packageImport,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editPackageImport(PackageImport element) {
		// Start of user code editPackageImport() method body
		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				packageImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.packageImport, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createElementImportTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.elementImport = new ReferencesTable<ElementImport>(UMLMessages.AssociationClassPropertiesEditionPart_ElementImportLabel, new ReferencesTableListener<ElementImport>() {

			public void handleAdd() {
				addToElementImport();
			}

			public void handleEdit(ElementImport element) {
				editElementImport(element);
			}

			public void handleMove(ElementImport element, int oldIndex, int newIndex) {
				moveElementImport(element, oldIndex, newIndex);
			}

			public void handleRemove(ElementImport element) {
				removeFromElementImport(element);
			}

			public void navigateTo(ElementImport element) {
			}
		});
		this.elementImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.elementImport, UMLViewsRepository.FORM_KIND));
		this.elementImport.createControls(parent, widgetFactory);
		GridData elementImportData = new GridData(GridData.FILL_HORIZONTAL);
		elementImportData.horizontalSpan = 3;
		this.elementImport.setLayoutData(elementImportData);
	}

	/**
	 * 
	 */
	protected void moveElementImport(ElementImport element, int oldIndex, int newIndex) {
		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		elementImportEditUtil.moveElement(element, oldIndex, newIndex);
		elementImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.elementImport, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToElementImport() {
		// Start of user code addToElementImport() method body
		ElementImport eObject = UMLFactory.eINSTANCE.createElementImport();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				elementImportEditUtil.addElement(propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.elementImport, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromElementImport(ElementImport element) {
		// Start of user code for the removeFromElementImport() method body
		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		elementImportEditUtil.removeElement(element);
		elementImport.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.elementImport,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editElementImport(ElementImport element) {
		// Start of user code editElementImport() method body
		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				elementImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.elementImport, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createPowertypeExtentReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.powertypeExtent = new ReferencesTable<GeneralizationSet>(UMLMessages.AssociationClassPropertiesEditionPart_PowertypeExtentLabel, new ReferencesTableListener<GeneralizationSet>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<GeneralizationSet> dialog = new TabElementTreeSelectionDialog<GeneralizationSet>(resourceSet, powertypeExtentFilters, powertypeExtentBusinessFilters,
						"GeneralizationSet", UMLPackage.eINSTANCE.getGeneralizationSet(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!powertypeExtentEditUtil.getVirtualList().contains(elem))
								powertypeExtentEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.powertypeExtent,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						powertypeExtent.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(GeneralizationSet element) {
				editPowertypeExtent(element);
			}

			public void handleMove(GeneralizationSet element, int oldIndex, int newIndex) {
				movePowertypeExtent(element, oldIndex, newIndex);
			}

			public void handleRemove(GeneralizationSet element) {
				removeFromPowertypeExtent(element);
			}

			public void navigateTo(GeneralizationSet element) {
			}
		});
		this.powertypeExtent.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.powertypeExtent, UMLViewsRepository.FORM_KIND));
		this.powertypeExtent.createControls(parent, widgetFactory);
		GridData powertypeExtentData = new GridData(GridData.FILL_HORIZONTAL);
		powertypeExtentData.horizontalSpan = 3;
		this.powertypeExtent.setLayoutData(powertypeExtentData);
		this.powertypeExtent.disableMove();
	}

	/**
	 * 
	 */
	protected void movePowertypeExtent(GeneralizationSet element, int oldIndex, int newIndex) {
		EObject editedElement = powertypeExtentEditUtil.foundCorrespondingEObject(element);
		powertypeExtentEditUtil.moveElement(element, oldIndex, newIndex);
		powertypeExtent.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.powertypeExtent, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromPowertypeExtent(GeneralizationSet element) {
		// Start of user code for the removeFromPowertypeExtent() method body
		EObject editedElement = powertypeExtentEditUtil.foundCorrespondingEObject(element);
		powertypeExtentEditUtil.removeElement(element);
		powertypeExtent.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.powertypeExtent,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editPowertypeExtent(GeneralizationSet element) {
		// Start of user code editPowertypeExtent() method body

		EObject editedElement = powertypeExtentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				powertypeExtentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				powertypeExtent.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this,
						UMLViewsRepository.AssociationClass.powertypeExtent, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedRuleTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedRule = new ReferencesTable<Constraint>(UMLMessages.AssociationClassPropertiesEditionPart_OwnedRuleLabel, new ReferencesTableListener<Constraint>() {

			public void handleAdd() {
				addToOwnedRule();
			}

			public void handleEdit(Constraint element) {
				editOwnedRule(element);
			}

			public void handleMove(Constraint element, int oldIndex, int newIndex) {
				moveOwnedRule(element, oldIndex, newIndex);
			}

			public void handleRemove(Constraint element) {
				removeFromOwnedRule(element);
			}

			public void navigateTo(Constraint element) {
			}
		});
		this.ownedRule.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.AssociationClass.ownedRule, UMLViewsRepository.FORM_KIND));
		this.ownedRule.createControls(parent, widgetFactory);
		GridData ownedRuleData = new GridData(GridData.FILL_HORIZONTAL);
		ownedRuleData.horizontalSpan = 3;
		this.ownedRule.setLayoutData(ownedRuleData);
	}

	/**
	 * 
	 */
	protected void moveOwnedRule(Constraint element, int oldIndex, int newIndex) {
		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		ownedRuleEditUtil.moveElement(element, oldIndex, newIndex);
		ownedRule.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedRule, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedRule() {
		// Start of user code addToOwnedRule() method body
		Constraint eObject = UMLFactory.eINSTANCE.createConstraint();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedRuleEditUtil.addElement(propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedRule,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedRule(Constraint element) {
		// Start of user code for the removeFromOwnedRule() method body
		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		ownedRuleEditUtil.removeElement(element);
		ownedRule.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedRule,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedRule(Constraint element) {
		// Start of user code editOwnedRule() method body
		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedRuleEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AssociationClassPropertiesEditionPartForm.this, UMLViewsRepository.AssociationClass.ownedRule,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		if(newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForName(String msg, int msgLevel) {
		messageManager.addMessage("Name_key", msg, null, msgLevel, name);
	}

	public void unsetMessageForName() {
		messageManager.removeMessage("Name_key", name);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#setIsLeaf(Boolean newValue)
	 */
	public void setIsLeaf(Boolean newValue) {
		if(newValue != null) {
			isLeaf.setSelection(newValue.booleanValue());
		} else {
			isLeaf.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getIsAbstract()
	 */
	public Boolean getIsAbstract() {
		return Boolean.valueOf(isAbstract.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#setIsAbstract(Boolean newValue)
	 */
	public void setIsAbstract(Boolean newValue) {
		if(newValue != null) {
			isAbstract.setSelection(newValue.booleanValue());
		} else {
			isAbstract.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getIsActive()
	 */
	public Boolean getIsActive() {
		return Boolean.valueOf(isActive.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#setIsActive(Boolean newValue)
	 */
	public void setIsActive(Boolean newValue) {
		if(newValue != null) {
			isActive.setSelection(newValue.booleanValue());
		} else {
			isActive.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getIsDerived()
	 */
	public Boolean getIsDerived() {
		return Boolean.valueOf(isDerived.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#setIsDerived(Boolean newValue)
	 */
	public void setIsDerived(Boolean newValue) {
		if(newValue != null) {
			isDerived.setSelection(newValue.booleanValue());
		} else {
			isDerived.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedEndToAdd()
	 */
	public List getOwnedEndToAdd() {
		return ownedEndEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedEndToRemove()
	 */
	public List getOwnedEndToRemove() {
		return ownedEndEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedEndToEdit()
	 */
	public Map getOwnedEndToEdit() {
		return ownedEndEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedEndToMove()
	 */
	public List getOwnedEndToMove() {
		return ownedEndEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedEndTable()
	 */
	public List getOwnedEndTable() {
		return ownedEndEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initOwnedEnd(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedEnd(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedEndEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedEndEditUtil = new EMFListEditUtil(current, feature);
		this.ownedEnd.setInput(ownedEndEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateOwnedEnd(EObject newValue)
	 */
	public void updateOwnedEnd(EObject newValue) {
		if(ownedEndEditUtil != null) {
			ownedEndEditUtil.reinit(newValue);
			ownedEnd.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterOwnedEnd(ViewerFilter filter)
	 */
	public void addFilterToOwnedEnd(ViewerFilter filter) {
		ownedEndFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterOwnedEnd(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedEnd(ViewerFilter filter) {
		ownedEndBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInOwnedEndTable(EObject element)
	 */
	public boolean isContainedInOwnedEndTable(EObject element) {
		return ownedEndEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getMemberEndToAdd()
	 */
	public List getMemberEndToAdd() {
		return memberEndEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getMemberEndToRemove()
	 */
	public List getMemberEndToRemove() {
		return memberEndEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getMemberEndTable()
	 */
	public List getMemberEndTable() {
		return memberEndEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initMemberEnd(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initMemberEnd(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			memberEndEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			memberEndEditUtil = new EMFListEditUtil(current, feature);
		this.memberEnd.setInput(memberEndEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateMemberEnd(EObject newValue)
	 */
	public void updateMemberEnd(EObject newValue) {
		if(memberEndEditUtil != null) {
			memberEndEditUtil.reinit(newValue);
			memberEnd.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterMemberEnd(ViewerFilter filter)
	 */
	public void addFilterToMemberEnd(ViewerFilter filter) {
		memberEndFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterMemberEnd(ViewerFilter filter)
	 */
	public void addBusinessFilterToMemberEnd(ViewerFilter filter) {
		memberEndBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInMemberEndTable(EObject element)
	 */
	public boolean isContainedInMemberEndTable(EObject element) {
		return memberEndEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getNavigableOwnedEndToAdd()
	 */
	public List getNavigableOwnedEndToAdd() {
		return navigableOwnedEndEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getNavigableOwnedEndToRemove()
	 */
	public List getNavigableOwnedEndToRemove() {
		return navigableOwnedEndEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getNavigableOwnedEndTable()
	 */
	public List getNavigableOwnedEndTable() {
		return navigableOwnedEndEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initNavigableOwnedEnd(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initNavigableOwnedEnd(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			navigableOwnedEndEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			navigableOwnedEndEditUtil = new EMFListEditUtil(current, feature);
		this.navigableOwnedEnd.setInput(navigableOwnedEndEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateNavigableOwnedEnd(EObject newValue)
	 */
	public void updateNavigableOwnedEnd(EObject newValue) {
		if(navigableOwnedEndEditUtil != null) {
			navigableOwnedEndEditUtil.reinit(newValue);
			navigableOwnedEnd.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterNavigableOwnedEnd(ViewerFilter filter)
	 */
	public void addFilterToNavigableOwnedEnd(ViewerFilter filter) {
		navigableOwnedEndFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterNavigableOwnedEnd(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToNavigableOwnedEnd(ViewerFilter filter) {
		navigableOwnedEndBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInNavigableOwnedEndTable(EObject element)
	 */
	public boolean isContainedInNavigableOwnedEndTable(EObject element) {
		return navigableOwnedEndEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedReceptionToAdd()
	 */
	public List getOwnedReceptionToAdd() {
		return ownedReceptionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedReceptionToRemove()
	 */
	public List getOwnedReceptionToRemove() {
		return ownedReceptionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedReceptionToEdit()
	 */
	public Map getOwnedReceptionToEdit() {
		return ownedReceptionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedReceptionToMove()
	 */
	public List getOwnedReceptionToMove() {
		return ownedReceptionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedReceptionTable()
	 */
	public List getOwnedReceptionTable() {
		return ownedReceptionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initOwnedReception(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedReception(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedReceptionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedReceptionEditUtil = new EMFListEditUtil(current, feature);
		this.ownedReception.setInput(ownedReceptionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateOwnedReception(EObject newValue)
	 */
	public void updateOwnedReception(EObject newValue) {
		if(ownedReceptionEditUtil != null) {
			ownedReceptionEditUtil.reinit(newValue);
			ownedReception.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterOwnedReception(ViewerFilter filter)
	 */
	public void addFilterToOwnedReception(ViewerFilter filter) {
		ownedReceptionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterOwnedReception(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedReception(ViewerFilter filter) {
		ownedReceptionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInOwnedReceptionTable(EObject element)
	 */
	public boolean isContainedInOwnedReceptionTable(EObject element) {
		return ownedReceptionEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getInterfaceRealizationToAdd()
	 */
	public List getInterfaceRealizationToAdd() {
		return interfaceRealizationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getInterfaceRealizationToRemove()
	 */
	public List getInterfaceRealizationToRemove() {
		return interfaceRealizationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getInterfaceRealizationToEdit()
	 */
	public Map getInterfaceRealizationToEdit() {
		return interfaceRealizationEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getInterfaceRealizationToMove()
	 */
	public List getInterfaceRealizationToMove() {
		return interfaceRealizationEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getInterfaceRealizationTable()
	 */
	public List getInterfaceRealizationTable() {
		return interfaceRealizationEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initInterfaceRealization(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initInterfaceRealization(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			interfaceRealizationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			interfaceRealizationEditUtil = new EMFListEditUtil(current, feature);
		this.interfaceRealization.setInput(interfaceRealizationEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateInterfaceRealization(EObject newValue)
	 */
	public void updateInterfaceRealization(EObject newValue) {
		if(interfaceRealizationEditUtil != null) {
			interfaceRealizationEditUtil.reinit(newValue);
			interfaceRealization.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterInterfaceRealization(ViewerFilter filter)
	 */
	public void addFilterToInterfaceRealization(ViewerFilter filter) {
		interfaceRealizationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterInterfaceRealization(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToInterfaceRealization(ViewerFilter filter) {
		interfaceRealizationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInInterfaceRealizationTable(EObject
	 *      element)
	 */
	public boolean isContainedInInterfaceRealizationTable(EObject element) {
		return interfaceRealizationEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedOperationToAdd()
	 */
	public List getOwnedOperationToAdd() {
		return ownedOperationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedOperationToRemove()
	 */
	public List getOwnedOperationToRemove() {
		return ownedOperationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedOperationToEdit()
	 */
	public Map getOwnedOperationToEdit() {
		return ownedOperationEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedOperationToMove()
	 */
	public List getOwnedOperationToMove() {
		return ownedOperationEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedOperationTable()
	 */
	public List getOwnedOperationTable() {
		return ownedOperationEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initOwnedOperation(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedOperation(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedOperationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedOperationEditUtil = new EMFListEditUtil(current, feature);
		this.ownedOperation.setInput(ownedOperationEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateOwnedOperation(EObject newValue)
	 */
	public void updateOwnedOperation(EObject newValue) {
		if(ownedOperationEditUtil != null) {
			ownedOperationEditUtil.reinit(newValue);
			ownedOperation.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterOwnedOperation(ViewerFilter filter)
	 */
	public void addFilterToOwnedOperation(ViewerFilter filter) {
		ownedOperationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterOwnedOperation(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedOperation(ViewerFilter filter) {
		ownedOperationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInOwnedOperationTable(EObject element)
	 */
	public boolean isContainedInOwnedOperationTable(EObject element) {
		return ownedOperationEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getNestedClassifierToAdd()
	 */
	public List getNestedClassifierToAdd() {
		return nestedClassifierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getNestedClassifierToRemove()
	 */
	public List getNestedClassifierToRemove() {
		return nestedClassifierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getNestedClassifierToEdit()
	 */
	public Map getNestedClassifierToEdit() {
		return nestedClassifierEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getNestedClassifierToMove()
	 */
	public List getNestedClassifierToMove() {
		return nestedClassifierEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getNestedClassifierTable()
	 */
	public List getNestedClassifierTable() {
		return nestedClassifierEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initNestedClassifier(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initNestedClassifier(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			nestedClassifierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			nestedClassifierEditUtil = new EMFListEditUtil(current, feature);
		this.nestedClassifier.setInput(nestedClassifierEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateNestedClassifier(EObject newValue)
	 */
	public void updateNestedClassifier(EObject newValue) {
		if(nestedClassifierEditUtil != null) {
			nestedClassifierEditUtil.reinit(newValue);
			nestedClassifier.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterNestedClassifier(ViewerFilter filter)
	 */
	public void addFilterToNestedClassifier(ViewerFilter filter) {
		nestedClassifierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterNestedClassifier(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToNestedClassifier(ViewerFilter filter) {
		nestedClassifierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInNestedClassifierTable(EObject element)
	 */
	public boolean isContainedInNestedClassifierTable(EObject element) {
		return nestedClassifierEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedTriggerToAdd()
	 */
	public List getOwnedTriggerToAdd() {
		return ownedTriggerEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedTriggerToRemove()
	 */
	public List getOwnedTriggerToRemove() {
		return ownedTriggerEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedTriggerToEdit()
	 */
	public Map getOwnedTriggerToEdit() {
		return ownedTriggerEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedTriggerToMove()
	 */
	public List getOwnedTriggerToMove() {
		return ownedTriggerEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedTriggerTable()
	 */
	public List getOwnedTriggerTable() {
		return ownedTriggerEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initOwnedTrigger(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedTrigger(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedTriggerEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedTriggerEditUtil = new EMFListEditUtil(current, feature);
		this.ownedTrigger.setInput(ownedTriggerEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateOwnedTrigger(EObject newValue)
	 */
	public void updateOwnedTrigger(EObject newValue) {
		if(ownedTriggerEditUtil != null) {
			ownedTriggerEditUtil.reinit(newValue);
			ownedTrigger.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterOwnedTrigger(ViewerFilter filter)
	 */
	public void addFilterToOwnedTrigger(ViewerFilter filter) {
		ownedTriggerFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterOwnedTrigger(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedTrigger(ViewerFilter filter) {
		ownedTriggerBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInOwnedTriggerTable(EObject element)
	 */
	public boolean isContainedInOwnedTriggerTable(EObject element) {
		return ownedTriggerEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedBehaviorToAdd()
	 */
	public List getOwnedBehaviorToAdd() {
		return ownedBehaviorEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedBehaviorToRemove()
	 */
	public List getOwnedBehaviorToRemove() {
		return ownedBehaviorEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedBehaviorToEdit()
	 */
	public Map getOwnedBehaviorToEdit() {
		return ownedBehaviorEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedBehaviorToMove()
	 */
	public List getOwnedBehaviorToMove() {
		return ownedBehaviorEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedBehaviorTable()
	 */
	public List getOwnedBehaviorTable() {
		return ownedBehaviorEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initOwnedBehavior(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedBehavior(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedBehaviorEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedBehaviorEditUtil = new EMFListEditUtil(current, feature);
		this.ownedBehavior.setInput(ownedBehaviorEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateOwnedBehavior(EObject newValue)
	 */
	public void updateOwnedBehavior(EObject newValue) {
		if(ownedBehaviorEditUtil != null) {
			ownedBehaviorEditUtil.reinit(newValue);
			ownedBehavior.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterOwnedBehavior(ViewerFilter filter)
	 */
	public void addFilterToOwnedBehavior(ViewerFilter filter) {
		ownedBehaviorFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterOwnedBehavior(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedBehavior(ViewerFilter filter) {
		ownedBehaviorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInOwnedBehaviorTable(EObject element)
	 */
	public boolean isContainedInOwnedBehaviorTable(EObject element) {
		return ownedBehaviorEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedConnectorToAdd()
	 */
	public List getOwnedConnectorToAdd() {
		return ownedConnectorEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedConnectorToRemove()
	 */
	public List getOwnedConnectorToRemove() {
		return ownedConnectorEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedConnectorToEdit()
	 */
	public Map getOwnedConnectorToEdit() {
		return ownedConnectorEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedConnectorToMove()
	 */
	public List getOwnedConnectorToMove() {
		return ownedConnectorEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedConnectorTable()
	 */
	public List getOwnedConnectorTable() {
		return ownedConnectorEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initOwnedConnector(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedConnector(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedConnectorEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedConnectorEditUtil = new EMFListEditUtil(current, feature);
		this.ownedConnector.setInput(ownedConnectorEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateOwnedConnector(EObject newValue)
	 */
	public void updateOwnedConnector(EObject newValue) {
		if(ownedConnectorEditUtil != null) {
			ownedConnectorEditUtil.reinit(newValue);
			ownedConnector.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterOwnedConnector(ViewerFilter filter)
	 */
	public void addFilterToOwnedConnector(ViewerFilter filter) {
		ownedConnectorFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterOwnedConnector(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedConnector(ViewerFilter filter) {
		ownedConnectorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInOwnedConnectorTable(EObject element)
	 */
	public boolean isContainedInOwnedConnectorTable(EObject element) {
		return ownedConnectorEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedAttributeToAdd()
	 */
	public List getOwnedAttributeToAdd() {
		return ownedAttributeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedAttributeToRemove()
	 */
	public List getOwnedAttributeToRemove() {
		return ownedAttributeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedAttributeToEdit()
	 */
	public Map getOwnedAttributeToEdit() {
		return ownedAttributeEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedAttributeToMove()
	 */
	public List getOwnedAttributeToMove() {
		return ownedAttributeEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedAttributeTable()
	 */
	public List getOwnedAttributeTable() {
		return ownedAttributeEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initOwnedAttribute(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedAttribute(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedAttributeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedAttributeEditUtil = new EMFListEditUtil(current, feature);
		this.ownedAttribute.setInput(ownedAttributeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateOwnedAttribute(EObject newValue)
	 */
	public void updateOwnedAttribute(EObject newValue) {
		if(ownedAttributeEditUtil != null) {
			ownedAttributeEditUtil.reinit(newValue);
			ownedAttribute.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterOwnedAttribute(ViewerFilter filter)
	 */
	public void addFilterToOwnedAttribute(ViewerFilter filter) {
		ownedAttributeFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterOwnedAttribute(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedAttribute(ViewerFilter filter) {
		ownedAttributeBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInOwnedAttributeTable(EObject element)
	 */
	public boolean isContainedInOwnedAttributeTable(EObject element) {
		return ownedAttributeEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getUseCaseToAdd()
	 */
	public List getUseCaseToAdd() {
		return useCaseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getUseCaseToRemove()
	 */
	public List getUseCaseToRemove() {
		return useCaseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getUseCaseTable()
	 */
	public List getUseCaseTable() {
		return useCaseEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initUseCase(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initUseCase(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			useCaseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			useCaseEditUtil = new EMFListEditUtil(current, feature);
		this.useCase.setInput(useCaseEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateUseCase(EObject newValue)
	 */
	public void updateUseCase(EObject newValue) {
		if(useCaseEditUtil != null) {
			useCaseEditUtil.reinit(newValue);
			useCase.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterUseCase(ViewerFilter filter)
	 */
	public void addFilterToUseCase(ViewerFilter filter) {
		useCaseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterUseCase(ViewerFilter filter)
	 */
	public void addBusinessFilterToUseCase(ViewerFilter filter) {
		useCaseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInUseCaseTable(EObject element)
	 */
	public boolean isContainedInUseCaseTable(EObject element) {
		return useCaseEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedUseCaseToAdd()
	 */
	public List getOwnedUseCaseToAdd() {
		return ownedUseCaseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedUseCaseToRemove()
	 */
	public List getOwnedUseCaseToRemove() {
		return ownedUseCaseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedUseCaseToEdit()
	 */
	public Map getOwnedUseCaseToEdit() {
		return ownedUseCaseEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedUseCaseToMove()
	 */
	public List getOwnedUseCaseToMove() {
		return ownedUseCaseEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedUseCaseTable()
	 */
	public List getOwnedUseCaseTable() {
		return ownedUseCaseEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initOwnedUseCase(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedUseCase(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedUseCaseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedUseCaseEditUtil = new EMFListEditUtil(current, feature);
		this.ownedUseCase.setInput(ownedUseCaseEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateOwnedUseCase(EObject newValue)
	 */
	public void updateOwnedUseCase(EObject newValue) {
		if(ownedUseCaseEditUtil != null) {
			ownedUseCaseEditUtil.reinit(newValue);
			ownedUseCase.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterOwnedUseCase(ViewerFilter filter)
	 */
	public void addFilterToOwnedUseCase(ViewerFilter filter) {
		ownedUseCaseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterOwnedUseCase(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedUseCase(ViewerFilter filter) {
		ownedUseCaseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInOwnedUseCaseTable(EObject element)
	 */
	public boolean isContainedInOwnedUseCaseTable(EObject element) {
		return ownedUseCaseEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getCollaborationUseToAdd()
	 */
	public List getCollaborationUseToAdd() {
		return collaborationUseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getCollaborationUseToRemove()
	 */
	public List getCollaborationUseToRemove() {
		return collaborationUseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getCollaborationUseToEdit()
	 */
	public Map getCollaborationUseToEdit() {
		return collaborationUseEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getCollaborationUseToMove()
	 */
	public List getCollaborationUseToMove() {
		return collaborationUseEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getCollaborationUseTable()
	 */
	public List getCollaborationUseTable() {
		return collaborationUseEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initCollaborationUse(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initCollaborationUse(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			collaborationUseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			collaborationUseEditUtil = new EMFListEditUtil(current, feature);
		this.collaborationUse.setInput(collaborationUseEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateCollaborationUse(EObject newValue)
	 */
	public void updateCollaborationUse(EObject newValue) {
		if(collaborationUseEditUtil != null) {
			collaborationUseEditUtil.reinit(newValue);
			collaborationUse.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterCollaborationUse(ViewerFilter filter)
	 */
	public void addFilterToCollaborationUse(ViewerFilter filter) {
		collaborationUseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterCollaborationUse(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToCollaborationUse(ViewerFilter filter) {
		collaborationUseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInCollaborationUseTable(EObject element)
	 */
	public boolean isContainedInCollaborationUseTable(EObject element) {
		return collaborationUseEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getRedefinedClassifierToAdd()
	 */
	public List getRedefinedClassifierToAdd() {
		return redefinedClassifierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getRedefinedClassifierToRemove()
	 */
	public List getRedefinedClassifierToRemove() {
		return redefinedClassifierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getRedefinedClassifierTable()
	 */
	public List getRedefinedClassifierTable() {
		return redefinedClassifierEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initRedefinedClassifier(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initRedefinedClassifier(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			redefinedClassifierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			redefinedClassifierEditUtil = new EMFListEditUtil(current, feature);
		this.redefinedClassifier.setInput(redefinedClassifierEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateRedefinedClassifier(EObject newValue)
	 */
	public void updateRedefinedClassifier(EObject newValue) {
		if(redefinedClassifierEditUtil != null) {
			redefinedClassifierEditUtil.reinit(newValue);
			redefinedClassifier.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterRedefinedClassifier(ViewerFilter filter)
	 */
	public void addFilterToRedefinedClassifier(ViewerFilter filter) {
		redefinedClassifierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterRedefinedClassifier(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToRedefinedClassifier(ViewerFilter filter) {
		redefinedClassifierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInRedefinedClassifierTable(EObject
	 *      element)
	 */
	public boolean isContainedInRedefinedClassifierTable(EObject element) {
		return redefinedClassifierEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getGeneralizationToAdd()
	 */
	public List getGeneralizationToAdd() {
		return generalizationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getGeneralizationToRemove()
	 */
	public List getGeneralizationToRemove() {
		return generalizationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getGeneralizationToEdit()
	 */
	public Map getGeneralizationToEdit() {
		return generalizationEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getGeneralizationToMove()
	 */
	public List getGeneralizationToMove() {
		return generalizationEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getGeneralizationTable()
	 */
	public List getGeneralizationTable() {
		return generalizationEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initGeneralization(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initGeneralization(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			generalizationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			generalizationEditUtil = new EMFListEditUtil(current, feature);
		this.generalization.setInput(generalizationEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateGeneralization(EObject newValue)
	 */
	public void updateGeneralization(EObject newValue) {
		if(generalizationEditUtil != null) {
			generalizationEditUtil.reinit(newValue);
			generalization.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterGeneralization(ViewerFilter filter)
	 */
	public void addFilterToGeneralization(ViewerFilter filter) {
		generalizationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterGeneralization(ViewerFilter filter)
	 */
	public void addBusinessFilterToGeneralization(ViewerFilter filter) {
		generalizationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInGeneralizationTable(EObject element)
	 */
	public boolean isContainedInGeneralizationTable(EObject element) {
		return generalizationEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getTemplateBindingToAdd()
	 */
	public List getTemplateBindingToAdd() {
		return templateBindingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getTemplateBindingToRemove()
	 */
	public List getTemplateBindingToRemove() {
		return templateBindingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getTemplateBindingToEdit()
	 */
	public Map getTemplateBindingToEdit() {
		return templateBindingEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getTemplateBindingToMove()
	 */
	public List getTemplateBindingToMove() {
		return templateBindingEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getTemplateBindingTable()
	 */
	public List getTemplateBindingTable() {
		return templateBindingEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initTemplateBinding(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initTemplateBinding(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			templateBindingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			templateBindingEditUtil = new EMFListEditUtil(current, feature);
		this.templateBinding.setInput(templateBindingEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateTemplateBinding(EObject newValue)
	 */
	public void updateTemplateBinding(EObject newValue) {
		if(templateBindingEditUtil != null) {
			templateBindingEditUtil.reinit(newValue);
			templateBinding.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterTemplateBinding(ViewerFilter filter)
	 */
	public void addFilterToTemplateBinding(ViewerFilter filter) {
		templateBindingFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterTemplateBinding(ViewerFilter filter)
	 */
	public void addBusinessFilterToTemplateBinding(ViewerFilter filter) {
		templateBindingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInTemplateBindingTable(EObject element)
	 */
	public boolean isContainedInTemplateBindingTable(EObject element) {
		return templateBindingEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getSubstitutionToAdd()
	 */
	public List getSubstitutionToAdd() {
		return substitutionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getSubstitutionToRemove()
	 */
	public List getSubstitutionToRemove() {
		return substitutionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getSubstitutionToEdit()
	 */
	public Map getSubstitutionToEdit() {
		return substitutionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getSubstitutionToMove()
	 */
	public List getSubstitutionToMove() {
		return substitutionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getSubstitutionTable()
	 */
	public List getSubstitutionTable() {
		return substitutionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initSubstitution(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initSubstitution(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			substitutionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			substitutionEditUtil = new EMFListEditUtil(current, feature);
		this.substitution.setInput(substitutionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateSubstitution(EObject newValue)
	 */
	public void updateSubstitution(EObject newValue) {
		if(substitutionEditUtil != null) {
			substitutionEditUtil.reinit(newValue);
			substitution.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterSubstitution(ViewerFilter filter)
	 */
	public void addFilterToSubstitution(ViewerFilter filter) {
		substitutionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterSubstitution(ViewerFilter filter)
	 */
	public void addBusinessFilterToSubstitution(ViewerFilter filter) {
		substitutionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInSubstitutionTable(EObject element)
	 */
	public boolean isContainedInSubstitutionTable(EObject element) {
		return substitutionEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getPackageImportToAdd()
	 */
	public List getPackageImportToAdd() {
		return packageImportEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getPackageImportToRemove()
	 */
	public List getPackageImportToRemove() {
		return packageImportEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getPackageImportToEdit()
	 */
	public Map getPackageImportToEdit() {
		return packageImportEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getPackageImportToMove()
	 */
	public List getPackageImportToMove() {
		return packageImportEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getPackageImportTable()
	 */
	public List getPackageImportTable() {
		return packageImportEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initPackageImport(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initPackageImport(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			packageImportEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			packageImportEditUtil = new EMFListEditUtil(current, feature);
		this.packageImport.setInput(packageImportEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updatePackageImport(EObject newValue)
	 */
	public void updatePackageImport(EObject newValue) {
		if(packageImportEditUtil != null) {
			packageImportEditUtil.reinit(newValue);
			packageImport.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterPackageImport(ViewerFilter filter)
	 */
	public void addFilterToPackageImport(ViewerFilter filter) {
		packageImportFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterPackageImport(ViewerFilter filter)
	 */
	public void addBusinessFilterToPackageImport(ViewerFilter filter) {
		packageImportBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInPackageImportTable(EObject element)
	 */
	public boolean isContainedInPackageImportTable(EObject element) {
		return packageImportEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getElementImportToAdd()
	 */
	public List getElementImportToAdd() {
		return elementImportEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getElementImportToRemove()
	 */
	public List getElementImportToRemove() {
		return elementImportEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getElementImportToEdit()
	 */
	public Map getElementImportToEdit() {
		return elementImportEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getElementImportToMove()
	 */
	public List getElementImportToMove() {
		return elementImportEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getElementImportTable()
	 */
	public List getElementImportTable() {
		return elementImportEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initElementImport(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initElementImport(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			elementImportEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			elementImportEditUtil = new EMFListEditUtil(current, feature);
		this.elementImport.setInput(elementImportEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateElementImport(EObject newValue)
	 */
	public void updateElementImport(EObject newValue) {
		if(elementImportEditUtil != null) {
			elementImportEditUtil.reinit(newValue);
			elementImport.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterElementImport(ViewerFilter filter)
	 */
	public void addFilterToElementImport(ViewerFilter filter) {
		elementImportFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterElementImport(ViewerFilter filter)
	 */
	public void addBusinessFilterToElementImport(ViewerFilter filter) {
		elementImportBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInElementImportTable(EObject element)
	 */
	public boolean isContainedInElementImportTable(EObject element) {
		return elementImportEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getPowertypeExtentToAdd()
	 */
	public List getPowertypeExtentToAdd() {
		return powertypeExtentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getPowertypeExtentToRemove()
	 */
	public List getPowertypeExtentToRemove() {
		return powertypeExtentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getPowertypeExtentTable()
	 */
	public List getPowertypeExtentTable() {
		return powertypeExtentEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initPowertypeExtent(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initPowertypeExtent(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			powertypeExtentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			powertypeExtentEditUtil = new EMFListEditUtil(current, feature);
		this.powertypeExtent.setInput(powertypeExtentEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updatePowertypeExtent(EObject newValue)
	 */
	public void updatePowertypeExtent(EObject newValue) {
		if(powertypeExtentEditUtil != null) {
			powertypeExtentEditUtil.reinit(newValue);
			powertypeExtent.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterPowertypeExtent(ViewerFilter filter)
	 */
	public void addFilterToPowertypeExtent(ViewerFilter filter) {
		powertypeExtentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterPowertypeExtent(ViewerFilter filter)
	 */
	public void addBusinessFilterToPowertypeExtent(ViewerFilter filter) {
		powertypeExtentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInPowertypeExtentTable(EObject element)
	 */
	public boolean isContainedInPowertypeExtentTable(EObject element) {
		return powertypeExtentEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedRuleToAdd()
	 */
	public List getOwnedRuleToAdd() {
		return ownedRuleEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedRuleToRemove()
	 */
	public List getOwnedRuleToRemove() {
		return ownedRuleEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedRuleToEdit()
	 */
	public Map getOwnedRuleToEdit() {
		return ownedRuleEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedRuleToMove()
	 */
	public List getOwnedRuleToMove() {
		return ownedRuleEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#getOwnedRuleTable()
	 */
	public List getOwnedRuleTable() {
		return ownedRuleEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#initOwnedRule(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedRule(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedRuleEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedRuleEditUtil = new EMFListEditUtil(current, feature);
		this.ownedRule.setInput(ownedRuleEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#updateOwnedRule(EObject newValue)
	 */
	public void updateOwnedRule(EObject newValue) {
		if(ownedRuleEditUtil != null) {
			ownedRuleEditUtil.reinit(newValue);
			ownedRule.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addFilterOwnedRule(ViewerFilter filter)
	 */
	public void addFilterToOwnedRule(ViewerFilter filter) {
		ownedRuleFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#addBusinessFilterOwnedRule(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedRule(ViewerFilter filter) {
		ownedRuleBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.AssociationClassPropertiesEditionPart#isContainedInOwnedRuleTable(EObject element)
	 */
	public boolean isContainedInOwnedRuleTable(EObject element) {
		return ownedRuleEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
