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
import org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart;
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
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class RedefinableTemplateSignaturePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, RedefinableTemplateSignaturePropertiesEditionPart {

	protected Text name;

	protected EMFComboViewer visibility;

	protected Button isLeaf;

	private EMFListEditUtil parameterEditUtil;

	protected ReferencesTable<? extends EObject> parameter;

	protected List<ViewerFilter> parameterBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> parameterFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedParameterEditUtil;

	protected ReferencesTable<? extends EObject> ownedParameter;

	protected List<ViewerFilter> ownedParameterBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedParameterFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil extendedSignatureEditUtil;

	protected ReferencesTable<? extends EObject> extendedSignature;

	protected List<ViewerFilter> extendedSignatureBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> extendedSignatureFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public RedefinableTemplateSignaturePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		generalSection.setText(UMLMessages.RedefinableTemplateSignaturePropertiesEditionPart_GeneralGroupLabel);
		GridData generalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		generalSectionData.horizontalSpan = 3;
		generalSection.setLayoutData(generalSectionData);
		Composite generalGroup = widgetFactory.createComposite(generalSection);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createNameText(widgetFactory, generalGroup);
		createVisibilityEMFComboViewer(widgetFactory, generalGroup);
		createIsLeafCheckbox(widgetFactory, generalGroup);
		createGeneralHBox1HBox(widgetFactory, generalGroup);
		generalSection.setClient(generalGroup);
	}

	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.RedefinableTemplateSignaturePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.RedefinableTemplateSignature.name, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.RedefinableTemplateSignature.name, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.RedefinableTemplateSignaturePropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.RedefinableTemplateSignature.visibility, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.visibility, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVisibility()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.RedefinableTemplateSignature.visibility, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createIsLeafCheckbox(FormToolkit widgetFactory, Composite parent) {
		isLeaf = widgetFactory.createButton(parent, UMLMessages.RedefinableTemplateSignaturePropertiesEditionPart_IsLeafLabel, SWT.CHECK);
		isLeaf.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.isLeaf, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isLeaf.getSelection())));
			}

		});
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.RedefinableTemplateSignature.isLeaf, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		createParameterReferencesTable(widgetFactory, generalHBox1HBox);
		createOwnedParameterTableComposition(widgetFactory, generalHBox1HBox);
		createExtendedSignatureReferencesTable(widgetFactory, generalHBox1HBox);
		container.pack();
	}

	protected void createParameterReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.parameter = new ReferencesTable<TemplateParameter>(UMLMessages.RedefinableTemplateSignaturePropertiesEditionPart_ParameterLabel, new ReferencesTableListener<TemplateParameter>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<TemplateParameter> dialog = new TabElementTreeSelectionDialog<TemplateParameter>(resourceSet, parameterFilters, parameterBusinessFilters,
						"TemplateParameter", UMLPackage.eINSTANCE.getTemplateParameter(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!parameterEditUtil.getVirtualList().contains(elem))
								parameterEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.parameter,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						parameter.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(TemplateParameter element) {
				editParameter(element);
			}

			public void handleMove(TemplateParameter element, int oldIndex, int newIndex) {
				moveParameter(element, oldIndex, newIndex);
			}

			public void handleRemove(TemplateParameter element) {
				removeFromParameter(element);
			}

			public void navigateTo(TemplateParameter element) {
			}
		});
		this.parameter.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.RedefinableTemplateSignature.parameter, UMLViewsRepository.FORM_KIND));
		this.parameter.createControls(parent, widgetFactory);
		GridData parameterData = new GridData(GridData.FILL_HORIZONTAL);
		parameterData.horizontalSpan = 3;
		this.parameter.setLayoutData(parameterData);
		this.parameter.disableMove();
	}

	/**
	 * 
	 */
	protected void moveParameter(TemplateParameter element, int oldIndex, int newIndex) {
		EObject editedElement = parameterEditUtil.foundCorrespondingEObject(element);
		parameterEditUtil.moveElement(element, oldIndex, newIndex);
		parameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.parameter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromParameter(TemplateParameter element) {
		// Start of user code for the removeFromParameter() method body
		EObject editedElement = parameterEditUtil.foundCorrespondingEObject(element);
		parameterEditUtil.removeElement(element);
		parameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				RedefinableTemplateSignaturePropertiesEditionPartForm.this,
				UMLViewsRepository.RedefinableTemplateSignature.parameter, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editParameter(TemplateParameter element) {
		// Start of user code editParameter() method body

		EObject editedElement = parameterEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				parameterEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				parameter.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						RedefinableTemplateSignaturePropertiesEditionPartForm.this,
						UMLViewsRepository.RedefinableTemplateSignature.parameter, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedParameterTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedParameter = new ReferencesTable<TemplateParameter>(UMLMessages.RedefinableTemplateSignaturePropertiesEditionPart_OwnedParameterLabel, new ReferencesTableListener<TemplateParameter>() {

			public void handleAdd() {
				addToOwnedParameter();
			}

			public void handleEdit(TemplateParameter element) {
				editOwnedParameter(element);
			}

			public void handleMove(TemplateParameter element, int oldIndex, int newIndex) {
				moveOwnedParameter(element, oldIndex, newIndex);
			}

			public void handleRemove(TemplateParameter element) {
				removeFromOwnedParameter(element);
			}

			public void navigateTo(TemplateParameter element) {
			}
		});
		this.ownedParameter.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.RedefinableTemplateSignature.ownedParameter, UMLViewsRepository.FORM_KIND));
		this.ownedParameter.createControls(parent, widgetFactory);
		GridData ownedParameterData = new GridData(GridData.FILL_HORIZONTAL);
		ownedParameterData.horizontalSpan = 3;
		this.ownedParameter.setLayoutData(ownedParameterData);
	}

	/**
	 * 
	 */
	protected void moveOwnedParameter(TemplateParameter element, int oldIndex, int newIndex) {
		EObject editedElement = ownedParameterEditUtil.foundCorrespondingEObject(element);
		ownedParameterEditUtil.moveElement(element, oldIndex, newIndex);
		ownedParameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.ownedParameter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedParameter() {
		// Start of user code addToOwnedParameter() method body
		TemplateParameter eObject = UMLFactory.eINSTANCE.createTemplateParameter();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedParameterEditUtil.addElement(propertiesEditionObject);
				ownedParameter.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						RedefinableTemplateSignaturePropertiesEditionPartForm.this,
						UMLViewsRepository.RedefinableTemplateSignature.ownedParameter, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedParameter(TemplateParameter element) {
		// Start of user code for the removeFromOwnedParameter() method body
		EObject editedElement = ownedParameterEditUtil.foundCorrespondingEObject(element);
		ownedParameterEditUtil.removeElement(element);
		ownedParameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				RedefinableTemplateSignaturePropertiesEditionPartForm.this,
				UMLViewsRepository.RedefinableTemplateSignature.ownedParameter, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedParameter(TemplateParameter element) {
		// Start of user code editOwnedParameter() method body
		EObject editedElement = ownedParameterEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedParameterEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedParameter.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						RedefinableTemplateSignaturePropertiesEditionPartForm.this,
						UMLViewsRepository.RedefinableTemplateSignature.ownedParameter, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createExtendedSignatureReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.extendedSignature = new ReferencesTable<RedefinableTemplateSignature>(UMLMessages.RedefinableTemplateSignaturePropertiesEditionPart_ExtendedSignatureLabel, new ReferencesTableListener<RedefinableTemplateSignature>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<RedefinableTemplateSignature> dialog = new TabElementTreeSelectionDialog<RedefinableTemplateSignature>(resourceSet, extendedSignatureFilters, extendedSignatureBusinessFilters,
						"RedefinableTemplateSignature", UMLPackage.eINSTANCE.getRedefinableTemplateSignature(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!extendedSignatureEditUtil.getVirtualList().contains(elem))
								extendedSignatureEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.extendedSignature,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						extendedSignature.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(RedefinableTemplateSignature element) {
				editExtendedSignature(element);
			}

			public void handleMove(RedefinableTemplateSignature element, int oldIndex, int newIndex) {
				moveExtendedSignature(element, oldIndex, newIndex);
			}

			public void handleRemove(RedefinableTemplateSignature element) {
				removeFromExtendedSignature(element);
			}

			public void navigateTo(RedefinableTemplateSignature element) {
			}
		});
		this.extendedSignature.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.RedefinableTemplateSignature.extendedSignature, UMLViewsRepository.FORM_KIND));
		this.extendedSignature.createControls(parent, widgetFactory);
		GridData extendedSignatureData = new GridData(GridData.FILL_HORIZONTAL);
		extendedSignatureData.horizontalSpan = 3;
		this.extendedSignature.setLayoutData(extendedSignatureData);
		this.extendedSignature.disableMove();
	}

	/**
	 * 
	 */
	protected void moveExtendedSignature(RedefinableTemplateSignature element, int oldIndex, int newIndex) {
		EObject editedElement = extendedSignatureEditUtil.foundCorrespondingEObject(element);
		extendedSignatureEditUtil.moveElement(element, oldIndex, newIndex);
		extendedSignature.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RedefinableTemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.RedefinableTemplateSignature.extendedSignature, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromExtendedSignature(RedefinableTemplateSignature element) {
		// Start of user code for the removeFromExtendedSignature() method body
		EObject editedElement = extendedSignatureEditUtil.foundCorrespondingEObject(element);
		extendedSignatureEditUtil.removeElement(element);
		extendedSignature.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				RedefinableTemplateSignaturePropertiesEditionPartForm.this,
				UMLViewsRepository.RedefinableTemplateSignature.extendedSignature, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editExtendedSignature(RedefinableTemplateSignature element) {
		// Start of user code editExtendedSignature() method body

		EObject editedElement = extendedSignatureEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				extendedSignatureEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				extendedSignature.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						RedefinableTemplateSignaturePropertiesEditionPartForm.this,
						UMLViewsRepository.RedefinableTemplateSignature.extendedSignature,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#initVisibility(EEnum eenum, Enumerator
	 *      current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#setIsLeaf(Boolean newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getParameterToAdd()
	 */
	public List getParameterToAdd() {
		return parameterEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getParameterToRemove()
	 */
	public List getParameterToRemove() {
		return parameterEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getParameterTable()
	 */
	public List getParameterTable() {
		return parameterEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#initParameter(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initParameter(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			parameterEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			parameterEditUtil = new EMFListEditUtil(current, feature);
		this.parameter.setInput(parameterEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#updateParameter(EObject newValue)
	 */
	public void updateParameter(EObject newValue) {
		if(parameterEditUtil != null) {
			parameterEditUtil.reinit(newValue);
			parameter.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#addFilterParameter(ViewerFilter filter)
	 */
	public void addFilterToParameter(ViewerFilter filter) {
		parameterFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#addBusinessFilterParameter(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToParameter(ViewerFilter filter) {
		parameterBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#isContainedInParameterTable(EObject
	 *      element)
	 */
	public boolean isContainedInParameterTable(EObject element) {
		return parameterEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getOwnedParameterToAdd()
	 */
	public List getOwnedParameterToAdd() {
		return ownedParameterEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getOwnedParameterToRemove()
	 */
	public List getOwnedParameterToRemove() {
		return ownedParameterEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getOwnedParameterToEdit()
	 */
	public Map getOwnedParameterToEdit() {
		return ownedParameterEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getOwnedParameterToMove()
	 */
	public List getOwnedParameterToMove() {
		return ownedParameterEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getOwnedParameterTable()
	 */
	public List getOwnedParameterTable() {
		return ownedParameterEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#initOwnedParameter(EObject current,
	 *      EReference containingFeature, EReference feature)
	 */
	public void initOwnedParameter(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedParameterEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedParameterEditUtil = new EMFListEditUtil(current, feature);
		this.ownedParameter.setInput(ownedParameterEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#updateOwnedParameter(EObject newValue)
	 */
	public void updateOwnedParameter(EObject newValue) {
		if(ownedParameterEditUtil != null) {
			ownedParameterEditUtil.reinit(newValue);
			ownedParameter.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#addFilterOwnedParameter(ViewerFilter
	 *      filter)
	 */
	public void addFilterToOwnedParameter(ViewerFilter filter) {
		ownedParameterFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#addBusinessFilterOwnedParameter(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToOwnedParameter(ViewerFilter filter) {
		ownedParameterBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#isContainedInOwnedParameterTable(EObject
	 *      element)
	 */
	public boolean isContainedInOwnedParameterTable(EObject element) {
		return ownedParameterEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getExtendedSignatureToAdd()
	 */
	public List getExtendedSignatureToAdd() {
		return extendedSignatureEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getExtendedSignatureToRemove()
	 */
	public List getExtendedSignatureToRemove() {
		return extendedSignatureEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#getExtendedSignatureTable()
	 */
	public List getExtendedSignatureTable() {
		return extendedSignatureEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#initExtendedSignature(EObject current,
	 *      EReference containingFeature, EReference feature)
	 */
	public void initExtendedSignature(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			extendedSignatureEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			extendedSignatureEditUtil = new EMFListEditUtil(current, feature);
		this.extendedSignature.setInput(extendedSignatureEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#updateExtendedSignature(EObject newValue)
	 */
	public void updateExtendedSignature(EObject newValue) {
		if(extendedSignatureEditUtil != null) {
			extendedSignatureEditUtil.reinit(newValue);
			extendedSignature.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#addFilterExtendedSignature(ViewerFilter
	 *      filter)
	 */
	public void addFilterToExtendedSignature(ViewerFilter filter) {
		extendedSignatureFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#addBusinessFilterExtendedSignature(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToExtendedSignature(ViewerFilter filter) {
		extendedSignatureBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart#isContainedInExtendedSignatureTable(EObject
	 *      element)
	 */
	public boolean isContainedInExtendedSignatureTable(EObject element) {
		return extendedSignatureEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
