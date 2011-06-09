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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart;
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
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InformationFlowPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, InformationFlowPropertiesEditionPart {

	protected EMFListEditUtil ownedCommentEditUtil;

	protected ReferencesTable<? extends EObject> ownedComment;

	protected List<ViewerFilter> ownedCommentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedCommentFilters = new ArrayList<ViewerFilter>();

	protected Text name;

	protected EMFComboViewer visibility;

	private EMFListEditUtil clientDependencyEditUtil;

	protected ReferencesTable<? extends EObject> clientDependency;

	protected List<ViewerFilter> clientDependencyBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> clientDependencyFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil realizationEditUtil;

	protected ReferencesTable<? extends EObject> realization;

	protected List<ViewerFilter> realizationBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> realizationFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil conveyedEditUtil;

	protected ReferencesTable<? extends EObject> conveyed;

	protected List<ViewerFilter> conveyedBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> conveyedFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil informationSourceEditUtil;

	protected ReferencesTable<? extends EObject> informationSource;

	protected List<ViewerFilter> informationSourceBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> informationSourceFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil informationTargetEditUtil;

	protected ReferencesTable<? extends EObject> informationTarget;

	protected List<ViewerFilter> informationTargetBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> informationTargetFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil realizingActivityEdgeEditUtil;

	protected ReferencesTable<? extends EObject> realizingActivityEdge;

	protected List<ViewerFilter> realizingActivityEdgeBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> realizingActivityEdgeFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil realizingConnectorEditUtil;

	protected ReferencesTable<? extends EObject> realizingConnector;

	protected List<ViewerFilter> realizingConnectorBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> realizingConnectorFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil realizingMessageEditUtil;

	protected ReferencesTable<? extends EObject> realizingMessage;

	protected List<ViewerFilter> realizingMessageBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> realizingMessageFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public InformationFlowPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPropertiesGroup(widgetFactory, view);
		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(UMLMessages.InformationFlowPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createOwnedCommentTableComposition(widgetFactory, propertiesGroup);
		createNameText(widgetFactory, propertiesGroup);
		createVisibilityEMFComboViewer(widgetFactory, propertiesGroup);
		createClientDependencyReferencesTable(widgetFactory, propertiesGroup);
		createRealizationReferencesTable(widgetFactory, propertiesGroup);
		createConveyedReferencesTable(widgetFactory, propertiesGroup);
		createInformationSourceReferencesTable(widgetFactory, propertiesGroup);
		createInformationTargetReferencesTable(widgetFactory, propertiesGroup);
		createRealizingActivityEdgeReferencesTable(widgetFactory, propertiesGroup);
		createRealizingConnectorReferencesTable(widgetFactory, propertiesGroup);
		createRealizingMessageReferencesTable(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.InformationFlowPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.ownedComment, UMLViewsRepository.FORM_KIND));
		this.ownedComment.createControls(parent, widgetFactory);
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.ownedComment,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedComment(Comment element) {
		// Start of user code for the removeFromOwnedComment() method body
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.removeElement(element);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.ownedComment,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
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
						InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.ownedComment,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.InformationFlowPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.InformationFlow.name, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.name, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.InformationFlowPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.InformationFlow.visibility, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.visibility, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVisibility()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.visibility, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createClientDependencyReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.InformationFlowPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, clientDependencyFilters, clientDependencyBusinessFilters,
						"Dependency", UMLPackage.eINSTANCE.getDependency(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.clientDependency, UMLViewsRepository.FORM_KIND));
		this.clientDependency.createControls(parent, widgetFactory);
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromClientDependency(Dependency element) {
		// Start of user code for the removeFromClientDependency() method body
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.removeElement(element);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.clientDependency,
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
						InformationFlowPropertiesEditionPartForm.this,
						UMLViewsRepository.InformationFlow.clientDependency, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createRealizationReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.realization = new ReferencesTable<Relationship>(UMLMessages.InformationFlowPropertiesEditionPart_RealizationLabel, new ReferencesTableListener<Relationship>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Relationship> dialog = new TabElementTreeSelectionDialog<Relationship>(resourceSet, realizationFilters, realizationBusinessFilters,
						"Relationship", UMLPackage.eINSTANCE.getRelationship(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!realizationEditUtil.getVirtualList().contains(elem))
								realizationEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realization,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						realization.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Relationship element) {
				editRealization(element);
			}

			public void handleMove(Relationship element, int oldIndex, int newIndex) {
				moveRealization(element, oldIndex, newIndex);
			}

			public void handleRemove(Relationship element) {
				removeFromRealization(element);
			}

			public void navigateTo(Relationship element) {
			}
		});
		this.realization.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.realization, UMLViewsRepository.FORM_KIND));
		this.realization.createControls(parent, widgetFactory);
		GridData realizationData = new GridData(GridData.FILL_HORIZONTAL);
		realizationData.horizontalSpan = 3;
		this.realization.setLayoutData(realizationData);
		this.realization.disableMove();
	}

	/**
	 * 
	 */
	protected void moveRealization(Relationship element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromRealization(Relationship element) {
		// Start of user code for the removeFromRealization() method body
		EObject editedElement = realizationEditUtil.foundCorrespondingEObject(element);
		realizationEditUtil.removeElement(element);
		realization.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realization,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRealization(Relationship element) {
		// Start of user code editRealization() method body

		EObject editedElement = realizationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				realizationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				realization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realization,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createConveyedReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.conveyed = new ReferencesTable<Classifier>(UMLMessages.InformationFlowPropertiesEditionPart_ConveyedLabel, new ReferencesTableListener<Classifier>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, conveyedFilters, conveyedBusinessFilters,
						"Classifier", UMLPackage.eINSTANCE.getClassifier(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!conveyedEditUtil.getVirtualList().contains(elem))
								conveyedEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.conveyed,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						conveyed.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Classifier element) {
				editConveyed(element);
			}

			public void handleMove(Classifier element, int oldIndex, int newIndex) {
				moveConveyed(element, oldIndex, newIndex);
			}

			public void handleRemove(Classifier element) {
				removeFromConveyed(element);
			}

			public void navigateTo(Classifier element) {
			}
		});
		this.conveyed.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.conveyed, UMLViewsRepository.FORM_KIND));
		this.conveyed.createControls(parent, widgetFactory);
		GridData conveyedData = new GridData(GridData.FILL_HORIZONTAL);
		conveyedData.horizontalSpan = 3;
		this.conveyed.setLayoutData(conveyedData);
		this.conveyed.disableMove();
	}

	/**
	 * 
	 */
	protected void moveConveyed(Classifier element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromConveyed(Classifier element) {
		// Start of user code for the removeFromConveyed() method body
		EObject editedElement = conveyedEditUtil.foundCorrespondingEObject(element);
		conveyedEditUtil.removeElement(element);
		conveyed.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.conveyed,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editConveyed(Classifier element) {
		// Start of user code editConveyed() method body

		EObject editedElement = conveyedEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				conveyedEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				conveyed.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.conveyed,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createInformationSourceReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.informationSource = new ReferencesTable<NamedElement>(UMLMessages.InformationFlowPropertiesEditionPart_InformationSourceLabel, new ReferencesTableListener<NamedElement>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, informationSourceFilters, informationSourceBusinessFilters,
						"NamedElement", UMLPackage.eINSTANCE.getNamedElement(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!informationSourceEditUtil.getVirtualList().contains(elem))
								informationSourceEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.informationSource,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						informationSource.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(NamedElement element) {
				editInformationSource(element);
			}

			public void handleMove(NamedElement element, int oldIndex, int newIndex) {
				moveInformationSource(element, oldIndex, newIndex);
			}

			public void handleRemove(NamedElement element) {
				removeFromInformationSource(element);
			}

			public void navigateTo(NamedElement element) {
			}
		});
		this.informationSource.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.informationSource, UMLViewsRepository.FORM_KIND));
		this.informationSource.createControls(parent, widgetFactory);
		GridData informationSourceData = new GridData(GridData.FILL_HORIZONTAL);
		informationSourceData.horizontalSpan = 3;
		this.informationSource.setLayoutData(informationSourceData);
		this.informationSource.disableMove();
	}

	/**
	 * 
	 */
	protected void moveInformationSource(NamedElement element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromInformationSource(NamedElement element) {
		// Start of user code for the removeFromInformationSource() method body
		EObject editedElement = informationSourceEditUtil.foundCorrespondingEObject(element);
		informationSourceEditUtil.removeElement(element);
		informationSource.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.informationSource,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editInformationSource(NamedElement element) {
		// Start of user code editInformationSource() method body

		EObject editedElement = informationSourceEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				informationSourceEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				informationSource.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						InformationFlowPropertiesEditionPartForm.this,
						UMLViewsRepository.InformationFlow.informationSource, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createInformationTargetReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.informationTarget = new ReferencesTable<NamedElement>(UMLMessages.InformationFlowPropertiesEditionPart_InformationTargetLabel, new ReferencesTableListener<NamedElement>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<NamedElement> dialog = new TabElementTreeSelectionDialog<NamedElement>(resourceSet, informationTargetFilters, informationTargetBusinessFilters,
						"NamedElement", UMLPackage.eINSTANCE.getNamedElement(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!informationTargetEditUtil.getVirtualList().contains(elem))
								informationTargetEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.informationTarget,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						informationTarget.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(NamedElement element) {
				editInformationTarget(element);
			}

			public void handleMove(NamedElement element, int oldIndex, int newIndex) {
				moveInformationTarget(element, oldIndex, newIndex);
			}

			public void handleRemove(NamedElement element) {
				removeFromInformationTarget(element);
			}

			public void navigateTo(NamedElement element) {
			}
		});
		this.informationTarget.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.informationTarget, UMLViewsRepository.FORM_KIND));
		this.informationTarget.createControls(parent, widgetFactory);
		GridData informationTargetData = new GridData(GridData.FILL_HORIZONTAL);
		informationTargetData.horizontalSpan = 3;
		this.informationTarget.setLayoutData(informationTargetData);
		this.informationTarget.disableMove();
	}

	/**
	 * 
	 */
	protected void moveInformationTarget(NamedElement element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromInformationTarget(NamedElement element) {
		// Start of user code for the removeFromInformationTarget() method body
		EObject editedElement = informationTargetEditUtil.foundCorrespondingEObject(element);
		informationTargetEditUtil.removeElement(element);
		informationTarget.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.informationTarget,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editInformationTarget(NamedElement element) {
		// Start of user code editInformationTarget() method body

		EObject editedElement = informationTargetEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				informationTargetEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				informationTarget.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						InformationFlowPropertiesEditionPartForm.this,
						UMLViewsRepository.InformationFlow.informationTarget, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createRealizingActivityEdgeReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.realizingActivityEdge = new ReferencesTable<ActivityEdge>(UMLMessages.InformationFlowPropertiesEditionPart_RealizingActivityEdgeLabel, new ReferencesTableListener<ActivityEdge>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<ActivityEdge> dialog = new TabElementTreeSelectionDialog<ActivityEdge>(resourceSet, realizingActivityEdgeFilters, realizingActivityEdgeBusinessFilters,
						"ActivityEdge", UMLPackage.eINSTANCE.getActivityEdge(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!realizingActivityEdgeEditUtil.getVirtualList().contains(elem))
								realizingActivityEdgeEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realizingActivityEdge,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						realizingActivityEdge.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(ActivityEdge element) {
				editRealizingActivityEdge(element);
			}

			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) {
				moveRealizingActivityEdge(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityEdge element) {
				removeFromRealizingActivityEdge(element);
			}

			public void navigateTo(ActivityEdge element) {
			}
		});
		this.realizingActivityEdge.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.realizingActivityEdge, UMLViewsRepository.FORM_KIND));
		this.realizingActivityEdge.createControls(parent, widgetFactory);
		GridData realizingActivityEdgeData = new GridData(GridData.FILL_HORIZONTAL);
		realizingActivityEdgeData.horizontalSpan = 3;
		this.realizingActivityEdge.setLayoutData(realizingActivityEdgeData);
		this.realizingActivityEdge.disableMove();
	}

	/**
	 * 
	 */
	protected void moveRealizingActivityEdge(ActivityEdge element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromRealizingActivityEdge(ActivityEdge element) {
		// Start of user code for the removeFromRealizingActivityEdge() method body
		EObject editedElement = realizingActivityEdgeEditUtil.foundCorrespondingEObject(element);
		realizingActivityEdgeEditUtil.removeElement(element);
		realizingActivityEdge.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InformationFlowPropertiesEditionPartForm.this,
				UMLViewsRepository.InformationFlow.realizingActivityEdge, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRealizingActivityEdge(ActivityEdge element) {
		// Start of user code editRealizingActivityEdge() method body

		EObject editedElement = realizingActivityEdgeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				realizingActivityEdgeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				realizingActivityEdge.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						InformationFlowPropertiesEditionPartForm.this,
						UMLViewsRepository.InformationFlow.realizingActivityEdge, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createRealizingConnectorReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.realizingConnector = new ReferencesTable<Connector>(UMLMessages.InformationFlowPropertiesEditionPart_RealizingConnectorLabel, new ReferencesTableListener<Connector>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Connector> dialog = new TabElementTreeSelectionDialog<Connector>(resourceSet, realizingConnectorFilters, realizingConnectorBusinessFilters,
						"Connector", UMLPackage.eINSTANCE.getConnector(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!realizingConnectorEditUtil.getVirtualList().contains(elem))
								realizingConnectorEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realizingConnector,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						realizingConnector.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Connector element) {
				editRealizingConnector(element);
			}

			public void handleMove(Connector element, int oldIndex, int newIndex) {
				moveRealizingConnector(element, oldIndex, newIndex);
			}

			public void handleRemove(Connector element) {
				removeFromRealizingConnector(element);
			}

			public void navigateTo(Connector element) {
			}
		});
		this.realizingConnector.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.realizingConnector, UMLViewsRepository.FORM_KIND));
		this.realizingConnector.createControls(parent, widgetFactory);
		GridData realizingConnectorData = new GridData(GridData.FILL_HORIZONTAL);
		realizingConnectorData.horizontalSpan = 3;
		this.realizingConnector.setLayoutData(realizingConnectorData);
		this.realizingConnector.disableMove();
	}

	/**
	 * 
	 */
	protected void moveRealizingConnector(Connector element, int oldIndex, int newIndex) {
		EObject editedElement = realizingConnectorEditUtil.foundCorrespondingEObject(element);
		realizingConnectorEditUtil.moveElement(element, oldIndex, newIndex);
		realizingConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realizingConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromRealizingConnector(Connector element) {
		// Start of user code for the removeFromRealizingConnector() method body
		EObject editedElement = realizingConnectorEditUtil.foundCorrespondingEObject(element);
		realizingConnectorEditUtil.removeElement(element);
		realizingConnector.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realizingConnector,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRealizingConnector(Connector element) {
		// Start of user code editRealizingConnector() method body

		EObject editedElement = realizingConnectorEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				realizingConnectorEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				realizingConnector.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						InformationFlowPropertiesEditionPartForm.this,
						UMLViewsRepository.InformationFlow.realizingConnector, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createRealizingMessageReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.realizingMessage = new ReferencesTable<Message>(UMLMessages.InformationFlowPropertiesEditionPart_RealizingMessageLabel, new ReferencesTableListener<Message>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Message> dialog = new TabElementTreeSelectionDialog<Message>(resourceSet, realizingMessageFilters, realizingMessageBusinessFilters,
						"Message", UMLPackage.eINSTANCE.getMessage(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!realizingMessageEditUtil.getVirtualList().contains(elem))
								realizingMessageEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realizingMessage,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						realizingMessage.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Message element) {
				editRealizingMessage(element);
			}

			public void handleMove(Message element, int oldIndex, int newIndex) {
				moveRealizingMessage(element, oldIndex, newIndex);
			}

			public void handleRemove(Message element) {
				removeFromRealizingMessage(element);
			}

			public void navigateTo(Message element) {
			}
		});
		this.realizingMessage.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.InformationFlow.realizingMessage, UMLViewsRepository.FORM_KIND));
		this.realizingMessage.createControls(parent, widgetFactory);
		GridData realizingMessageData = new GridData(GridData.FILL_HORIZONTAL);
		realizingMessageData.horizontalSpan = 3;
		this.realizingMessage.setLayoutData(realizingMessageData);
		this.realizingMessage.disableMove();
	}

	/**
	 * 
	 */
	protected void moveRealizingMessage(Message element, int oldIndex, int newIndex) {
		EObject editedElement = realizingMessageEditUtil.foundCorrespondingEObject(element);
		realizingMessageEditUtil.moveElement(element, oldIndex, newIndex);
		realizingMessage.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realizingMessage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromRealizingMessage(Message element) {
		// Start of user code for the removeFromRealizingMessage() method body
		EObject editedElement = realizingMessageEditUtil.foundCorrespondingEObject(element);
		realizingMessageEditUtil.removeElement(element);
		realizingMessage.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				InformationFlowPropertiesEditionPartForm.this, UMLViewsRepository.InformationFlow.realizingMessage,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRealizingMessage(Message element) {
		// Start of user code editRealizingMessage() method body

		EObject editedElement = realizingMessageEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				realizingMessageEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				realizingMessage.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						InformationFlowPropertiesEditionPartForm.this,
						UMLViewsRepository.InformationFlow.realizingMessage, PropertiesEditionEvent.COMMIT,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initOwnedComment(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
	 */
	public boolean isContainedInOwnedCommentTable(EObject element) {
		return ownedCommentEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getClientDependencyTable()
	 */
	public List getClientDependencyTable() {
		return clientDependencyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initClientDependency(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateClientDependency(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addFilterClientDependency(ViewerFilter filter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter filter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#isContainedInClientDependencyTable(EObject element)
	 */
	public boolean isContainedInClientDependencyTable(EObject element) {
		return clientDependencyEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizationToAdd()
	 */
	public List getRealizationToAdd() {
		return realizationEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizationToRemove()
	 */
	public List getRealizationToRemove() {
		return realizationEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizationTable()
	 */
	public List getRealizationTable() {
		return realizationEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initRealization(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initRealization(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			realizationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			realizationEditUtil = new EMFListEditUtil(current, feature);
		this.realization.setInput(realizationEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateRealization(EObject newValue)
	 */
	public void updateRealization(EObject newValue) {
		if(realizationEditUtil != null) {
			realizationEditUtil.reinit(newValue);
			realization.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addFilterRealization(ViewerFilter filter)
	 */
	public void addFilterToRealization(ViewerFilter filter) {
		realizationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addBusinessFilterRealization(ViewerFilter filter)
	 */
	public void addBusinessFilterToRealization(ViewerFilter filter) {
		realizationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#isContainedInRealizationTable(EObject element)
	 */
	public boolean isContainedInRealizationTable(EObject element) {
		return realizationEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getConveyedToAdd()
	 */
	public List getConveyedToAdd() {
		return conveyedEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getConveyedToRemove()
	 */
	public List getConveyedToRemove() {
		return conveyedEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getConveyedTable()
	 */
	public List getConveyedTable() {
		return conveyedEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initConveyed(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initConveyed(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			conveyedEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			conveyedEditUtil = new EMFListEditUtil(current, feature);
		this.conveyed.setInput(conveyedEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateConveyed(EObject newValue)
	 */
	public void updateConveyed(EObject newValue) {
		if(conveyedEditUtil != null) {
			conveyedEditUtil.reinit(newValue);
			conveyed.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addFilterConveyed(ViewerFilter filter)
	 */
	public void addFilterToConveyed(ViewerFilter filter) {
		conveyedFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addBusinessFilterConveyed(ViewerFilter filter)
	 */
	public void addBusinessFilterToConveyed(ViewerFilter filter) {
		conveyedBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#isContainedInConveyedTable(EObject element)
	 */
	public boolean isContainedInConveyedTable(EObject element) {
		return conveyedEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationSourceToAdd()
	 */
	public List getInformationSourceToAdd() {
		return informationSourceEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationSourceToRemove()
	 */
	public List getInformationSourceToRemove() {
		return informationSourceEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationSourceTable()
	 */
	public List getInformationSourceTable() {
		return informationSourceEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initInformationSource(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initInformationSource(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			informationSourceEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			informationSourceEditUtil = new EMFListEditUtil(current, feature);
		this.informationSource.setInput(informationSourceEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateInformationSource(EObject newValue)
	 */
	public void updateInformationSource(EObject newValue) {
		if(informationSourceEditUtil != null) {
			informationSourceEditUtil.reinit(newValue);
			informationSource.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addFilterInformationSource(ViewerFilter filter)
	 */
	public void addFilterToInformationSource(ViewerFilter filter) {
		informationSourceFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addBusinessFilterInformationSource(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToInformationSource(ViewerFilter filter) {
		informationSourceBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#isContainedInInformationSourceTable(EObject element)
	 */
	public boolean isContainedInInformationSourceTable(EObject element) {
		return informationSourceEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationTargetToAdd()
	 */
	public List getInformationTargetToAdd() {
		return informationTargetEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationTargetToRemove()
	 */
	public List getInformationTargetToRemove() {
		return informationTargetEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getInformationTargetTable()
	 */
	public List getInformationTargetTable() {
		return informationTargetEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initInformationTarget(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initInformationTarget(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			informationTargetEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			informationTargetEditUtil = new EMFListEditUtil(current, feature);
		this.informationTarget.setInput(informationTargetEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateInformationTarget(EObject newValue)
	 */
	public void updateInformationTarget(EObject newValue) {
		if(informationTargetEditUtil != null) {
			informationTargetEditUtil.reinit(newValue);
			informationTarget.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addFilterInformationTarget(ViewerFilter filter)
	 */
	public void addFilterToInformationTarget(ViewerFilter filter) {
		informationTargetFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addBusinessFilterInformationTarget(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToInformationTarget(ViewerFilter filter) {
		informationTargetBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#isContainedInInformationTargetTable(EObject element)
	 */
	public boolean isContainedInInformationTargetTable(EObject element) {
		return informationTargetEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingActivityEdgeToAdd()
	 */
	public List getRealizingActivityEdgeToAdd() {
		return realizingActivityEdgeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingActivityEdgeToRemove()
	 */
	public List getRealizingActivityEdgeToRemove() {
		return realizingActivityEdgeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingActivityEdgeTable()
	 */
	public List getRealizingActivityEdgeTable() {
		return realizingActivityEdgeEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initRealizingActivityEdge(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initRealizingActivityEdge(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			realizingActivityEdgeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			realizingActivityEdgeEditUtil = new EMFListEditUtil(current, feature);
		this.realizingActivityEdge.setInput(realizingActivityEdgeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateRealizingActivityEdge(EObject newValue)
	 */
	public void updateRealizingActivityEdge(EObject newValue) {
		if(realizingActivityEdgeEditUtil != null) {
			realizingActivityEdgeEditUtil.reinit(newValue);
			realizingActivityEdge.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addFilterRealizingActivityEdge(ViewerFilter filter)
	 */
	public void addFilterToRealizingActivityEdge(ViewerFilter filter) {
		realizingActivityEdgeFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addBusinessFilterRealizingActivityEdge(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToRealizingActivityEdge(ViewerFilter filter) {
		realizingActivityEdgeBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#isContainedInRealizingActivityEdgeTable(EObject
	 *      element)
	 */
	public boolean isContainedInRealizingActivityEdgeTable(EObject element) {
		return realizingActivityEdgeEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingConnectorToAdd()
	 */
	public List getRealizingConnectorToAdd() {
		return realizingConnectorEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingConnectorToRemove()
	 */
	public List getRealizingConnectorToRemove() {
		return realizingConnectorEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingConnectorTable()
	 */
	public List getRealizingConnectorTable() {
		return realizingConnectorEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initRealizingConnector(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initRealizingConnector(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			realizingConnectorEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			realizingConnectorEditUtil = new EMFListEditUtil(current, feature);
		this.realizingConnector.setInput(realizingConnectorEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateRealizingConnector(EObject newValue)
	 */
	public void updateRealizingConnector(EObject newValue) {
		if(realizingConnectorEditUtil != null) {
			realizingConnectorEditUtil.reinit(newValue);
			realizingConnector.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addFilterRealizingConnector(ViewerFilter filter)
	 */
	public void addFilterToRealizingConnector(ViewerFilter filter) {
		realizingConnectorFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addBusinessFilterRealizingConnector(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToRealizingConnector(ViewerFilter filter) {
		realizingConnectorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#isContainedInRealizingConnectorTable(EObject element)
	 */
	public boolean isContainedInRealizingConnectorTable(EObject element) {
		return realizingConnectorEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingMessageToAdd()
	 */
	public List getRealizingMessageToAdd() {
		return realizingMessageEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingMessageToRemove()
	 */
	public List getRealizingMessageToRemove() {
		return realizingMessageEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#getRealizingMessageTable()
	 */
	public List getRealizingMessageTable() {
		return realizingMessageEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#initRealizingMessage(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initRealizingMessage(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			realizingMessageEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			realizingMessageEditUtil = new EMFListEditUtil(current, feature);
		this.realizingMessage.setInput(realizingMessageEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#updateRealizingMessage(EObject newValue)
	 */
	public void updateRealizingMessage(EObject newValue) {
		if(realizingMessageEditUtil != null) {
			realizingMessageEditUtil.reinit(newValue);
			realizingMessage.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addFilterRealizingMessage(ViewerFilter filter)
	 */
	public void addFilterToRealizingMessage(ViewerFilter filter) {
		realizingMessageFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#addBusinessFilterRealizingMessage(ViewerFilter filter)
	 */
	public void addBusinessFilterToRealizingMessage(ViewerFilter filter) {
		realizingMessageBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart#isContainedInRealizingMessageTable(EObject element)
	 */
	public boolean isContainedInRealizingMessageTable(EObject element) {
		return realizingMessageEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
