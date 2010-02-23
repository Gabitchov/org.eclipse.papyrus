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
import org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InstanceSpecificationPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, InstanceSpecificationPropertiesEditionPart {

	protected Text name;

	protected EMFComboViewer visibility;

	protected EMFListEditUtil slotEditUtil;

	protected ReferencesTable<? extends EObject> slot;

	protected List<ViewerFilter> slotBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> slotFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil classifierEditUtil;

	protected ReferencesTable<? extends EObject> classifier;

	protected List<ViewerFilter> classifierBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> classifierFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil deploymentEditUtil;

	protected ReferencesTable<? extends EObject> deployment;

	protected List<ViewerFilter> deploymentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> deploymentFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public InstanceSpecificationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createGeneralGroup(FormToolkit widgetFactory, final Composite view) {
		Section generalSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		generalSection.setText(UMLMessages.InstanceSpecificationPropertiesEditionPart_GeneralGroupLabel);
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
		generalSection.setClient(generalGroup);
	}

	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.InstanceSpecificationPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.InstanceSpecification.name, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InstanceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.InstanceSpecification.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InstanceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.InstanceSpecification.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InstanceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.InstanceSpecification.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.InstanceSpecification.name, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.InstanceSpecificationPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.InstanceSpecification.visibility, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InstanceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.InstanceSpecification.visibility, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVisibility()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.InstanceSpecification.visibility, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createGeneralHBox1HBox(FormToolkit widgetFactory, Composite parent) {
		Composite container = widgetFactory.createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox generalHBox1HBox = new HorizontalBox(container);
		//create sub figures
		createSlotTableComposition(widgetFactory, generalHBox1HBox);
		createClassifierReferencesTable(widgetFactory, generalHBox1HBox);
		createDeploymentTableComposition(widgetFactory, generalHBox1HBox);
		container.pack();
	}

	/**
	 * @param container
	 */
	protected void createSlotTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.slot = new ReferencesTable<Slot>(UMLMessages.InstanceSpecificationPropertiesEditionPart_SlotLabel, new ReferencesTableListener<Slot>() {

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
		this.slot.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InstanceSpecification.slot, UMLViewsRepository.FORM_KIND));
		this.slot.createControls(parent, widgetFactory);
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InstanceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.InstanceSpecification.slot, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						InstanceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.InstanceSpecification.slot, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromSlot(Slot element) {
		// Start of user code for the removeFromSlot() method body
		EObject editedElement = slotEditUtil.foundCorrespondingEObject(element);
		slotEditUtil.removeElement(element);
		slot.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InstanceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.InstanceSpecification.slot,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
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
						InstanceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.InstanceSpecification.slot, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createClassifierReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.classifier = new ReferencesTable<Classifier>(UMLMessages.InstanceSpecificationPropertiesEditionPart_ClassifierLabel, new ReferencesTableListener<Classifier>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, classifierFilters, classifierBusinessFilters,
						"Classifier", UMLPackage.eINSTANCE.getClassifier(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!classifierEditUtil.getVirtualList().contains(elem))
								classifierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InstanceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.InstanceSpecification.classifier,
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
		this.classifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InstanceSpecification.classifier, UMLViewsRepository.FORM_KIND));
		this.classifier.createControls(parent, widgetFactory);
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
		// Start of user code for the removeFromClassifier() method body
		EObject editedElement = classifierEditUtil.foundCorrespondingEObject(element);
		classifierEditUtil.removeElement(element);
		classifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InstanceSpecificationPropertiesEditionPartForm.this,
				UMLViewsRepository.InstanceSpecification.classifier, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
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
						InstanceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.InstanceSpecification.classifier, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createDeploymentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.deployment = new ReferencesTable<Deployment>(UMLMessages.InstanceSpecificationPropertiesEditionPart_DeploymentLabel, new ReferencesTableListener<Deployment>() {

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
		this.deployment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InstanceSpecification.deployment, UMLViewsRepository.FORM_KIND));
		this.deployment.createControls(parent, widgetFactory);
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InstanceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.InstanceSpecification.deployment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						InstanceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.InstanceSpecification.deployment, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromDeployment(Deployment element) {
		// Start of user code for the removeFromDeployment() method body
		EObject editedElement = deploymentEditUtil.foundCorrespondingEObject(element);
		deploymentEditUtil.removeElement(element);
		deployment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InstanceSpecificationPropertiesEditionPartForm.this,
				UMLViewsRepository.InstanceSpecification.deployment, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
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
						InstanceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.InstanceSpecification.deployment, PropertiesEditionEvent.COMMIT,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getSlotToAdd()
	 */
	public List getSlotToAdd() {
		return slotEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getSlotToRemove()
	 */
	public List getSlotToRemove() {
		return slotEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getSlotToEdit()
	 */
	public Map getSlotToEdit() {
		return slotEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getSlotToMove()
	 */
	public List getSlotToMove() {
		return slotEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getSlotTable()
	 */
	public List getSlotTable() {
		return slotEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#initSlot(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#updateSlot(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#addFilterSlot(ViewerFilter filter)
	 */
	public void addFilterToSlot(ViewerFilter filter) {
		slotFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#addBusinessFilterSlot(ViewerFilter filter)
	 */
	public void addBusinessFilterToSlot(ViewerFilter filter) {
		slotBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#isContainedInSlotTable(EObject element)
	 */
	public boolean isContainedInSlotTable(EObject element) {
		return slotEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getClassifierToAdd()
	 */
	public List getClassifierToAdd() {
		return classifierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getClassifierToRemove()
	 */
	public List getClassifierToRemove() {
		return classifierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getClassifierTable()
	 */
	public List getClassifierTable() {
		return classifierEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#initClassifier(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#updateClassifier(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#addFilterClassifier(ViewerFilter filter)
	 */
	public void addFilterToClassifier(ViewerFilter filter) {
		classifierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#addBusinessFilterClassifier(ViewerFilter filter)
	 */
	public void addBusinessFilterToClassifier(ViewerFilter filter) {
		classifierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#isContainedInClassifierTable(EObject element)
	 */
	public boolean isContainedInClassifierTable(EObject element) {
		return classifierEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getDeploymentToAdd()
	 */
	public List getDeploymentToAdd() {
		return deploymentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getDeploymentToRemove()
	 */
	public List getDeploymentToRemove() {
		return deploymentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getDeploymentToEdit()
	 */
	public Map getDeploymentToEdit() {
		return deploymentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getDeploymentToMove()
	 */
	public List getDeploymentToMove() {
		return deploymentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#getDeploymentTable()
	 */
	public List getDeploymentTable() {
		return deploymentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#initDeployment(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#updateDeployment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#addFilterDeployment(ViewerFilter filter)
	 */
	public void addFilterToDeployment(ViewerFilter filter) {
		deploymentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#addBusinessFilterDeployment(ViewerFilter filter)
	 */
	public void addBusinessFilterToDeployment(ViewerFilter filter) {
		deploymentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart#isContainedInDeploymentTable(EObject element)
	 */
	public boolean isContainedInDeploymentTable(EObject element) {
		return deploymentEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
