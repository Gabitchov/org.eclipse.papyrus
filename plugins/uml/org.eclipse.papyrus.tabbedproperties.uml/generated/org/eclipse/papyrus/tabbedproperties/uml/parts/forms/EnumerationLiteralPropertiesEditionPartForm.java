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
import org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart;
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
public class EnumerationLiteralPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, EnumerationLiteralPropertiesEditionPart {

	private Text name;
	private EMFEnumViewer visibility;
	private EMFListEditUtil deploymentEditUtil;
	private ReferencesTable<?> deployment;
	private EMFListEditUtil slotEditUtil;
	private ReferencesTable<?> slot;
	private EMFListEditUtil classifierEditUtil;
	private ReferencesTable<?> classifier;




	
	public EnumerationLiteralPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		generalSection.setText(UMLMessages.EnumerationLiteralPropertiesEditionPart_GeneralGroupLabel);
		GridData generalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		generalSectionData.horizontalSpan = 3;
		generalSection.setLayoutData(generalSectionData);
		Composite generalGroup = widgetFactory.createComposite(generalSection);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createNameText(widgetFactory, generalGroup);
		createVisibilityEEnumViewer(widgetFactory, generalGroup);
		createGeneralHBox1HBox(widgetFactory, generalGroup);
		generalSection.setClient(generalGroup);
	}   		
	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.EnumerationLiteralPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.EnumerationLiteral.name, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.name, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.name, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, name.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.name, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createVisibilityEEnumViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.EnumerationLiteralPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.EnumerationLiteral.visibility, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.visibility, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, getVisibility()));
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.visibility, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createGeneralHBox1HBox(FormToolkit widgetFactory, Composite parent) {	
		Composite container = widgetFactory.createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan=3;
		container.setLayoutData(gridData);		
		HorizontalBox generalHBox1HBox = new HorizontalBox(container);
		
		
		//create sub figures
				createDeploymentTableComposition(widgetFactory, generalHBox1HBox);	
				createSlotTableComposition(widgetFactory, generalHBox1HBox);	
				createClassifierReferencesTable(widgetFactory, generalHBox1HBox);
		
		container.pack();		
	}
	/**
	 * @param container
	 */
	protected void createDeploymentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.deployment = new ReferencesTable<Deployment>(UMLMessages.EnumerationLiteralPropertiesEditionPart_DeploymentLabel, new ReferencesTableListener<Deployment>() {			
			public void handleAdd() { addToDeployment();}
			public void handleEdit(Deployment element) { editDeployment(element); }
			public void handleMove(Deployment element, int oldIndex, int newIndex) { moveDeployment(element, oldIndex, newIndex); }			
			public void handleRemove(Deployment element) { removeFromDeployment(element); }
			public void navigateTo(Deployment element) { System.out.println("---> navigateTo"); }
		});
		this.deployment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.deployment, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.deployment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToDeployment() {
	
		// Start of user code addToDeployment() method body
		
		
		Deployment eObject = UMLFactory.eINSTANCE.createDeployment();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				deploymentEditUtil.addElement(propertiesEditionObject);
				deployment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.deployment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.deployment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editDeployment(Deployment element) {

		// Start of user code editDeployment() method body
				 
		EObject editedElement = deploymentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				deploymentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				deployment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.deployment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createSlotTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.slot = new ReferencesTable<Slot>(UMLMessages.EnumerationLiteralPropertiesEditionPart_SlotLabel, new ReferencesTableListener<Slot>() {			
			public void handleAdd() { addToSlot();}
			public void handleEdit(Slot element) { editSlot(element); }
			public void handleMove(Slot element, int oldIndex, int newIndex) { moveSlot(element, oldIndex, newIndex); }			
			public void handleRemove(Slot element) { removeFromSlot(element); }
			public void navigateTo(Slot element) { System.out.println("---> navigateTo"); }
		});
		this.slot.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.slot, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.slot, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToSlot() {
	
		// Start of user code addToSlot() method body
		
		
		Slot eObject = UMLFactory.eINSTANCE.createSlot();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				slotEditUtil.addElement(propertiesEditionObject);
				slot.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.slot, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.slot, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editSlot(Slot element) {

		// Start of user code editSlot() method body
				 
		EObject editedElement = slotEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				slotEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				slot.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.slot, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createClassifierReferencesTable(FormToolkit widgetFactory, Composite parent) {	
		this.classifier = new ReferencesTable<Classifier>(UMLMessages.EnumerationLiteralPropertiesEditionPart_ClassifierLabel, new ReferencesTableListener<Classifier>() {
			public void handleAdd() {				
				ViewerFilter classifierFilter = new EObjectFilter(UMLPackage.eINSTANCE.getClassifier());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!classifierEditUtil.contains((EObject)element));
						return false;				
					}
				};				
				ViewerFilter[] filters = { classifierFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, filters, 
				"Classifier", UMLPackage.eINSTANCE.getClassifier()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!classifierEditUtil.getVirtualList().contains(elem))
								classifierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.classifier,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));
						}
						classifier.refresh();												
					}
				};
				dialog.open();
			}
			public void handleEdit(Classifier element) { editClassifier(element); }
			public void handleMove(Classifier element, int oldIndex, int newIndex) { moveClassifier(element, oldIndex, newIndex); }
			public void handleRemove(Classifier element) { removeFromClassifier(element); }
			public void navigateTo(Classifier element) { System.out.println("---> navigateTo"); }
		});
		this.classifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.EnumerationLiteral.classifier, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.classifier, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editClassifier(Classifier element) {

		// Start of user code editClassifier() method body
				 
		EObject editedElement = classifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				classifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				classifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(EnumerationLiteralPropertiesEditionPartForm.this, UMLViewsRepository.EnumerationLiteral.classifier, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.setSelection(new StructuredSelection(current));
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
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
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getDeploymentToMove()
	 */
	public List getDeploymentToMove() {
		return deploymentEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getDeploymentTable()
	 */
	public List getDeploymentTable() {
		return deploymentEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#initDeployment(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#updateDeployment(EObject newValue)
	 */
	public void updateDeployment(EObject newValue) {
		if(deploymentEditUtil!=null){
			deploymentEditUtil.reinit(newValue);
			deployment.refresh();
		}		
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
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getSlotToMove()
	 */
	public List getSlotToMove() {
		return slotEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#getSlotTable()
	 */
	public List getSlotTable() {
		return slotEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#initSlot(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSlot(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
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
		if(slotEditUtil!=null){
			slotEditUtil.reinit(newValue);
			slot.refresh();
		}		
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.EnumerationLiteralPropertiesEditionPart#initClassifier(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initClassifier(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
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
		if(classifierEditUtil!=null){
			classifierEditUtil.reinit(newValue);
			classifier.refresh();
		}		
	}
	
	
	
	







	
	// Start of user code additional methods
 	
	// End of user code
}	
