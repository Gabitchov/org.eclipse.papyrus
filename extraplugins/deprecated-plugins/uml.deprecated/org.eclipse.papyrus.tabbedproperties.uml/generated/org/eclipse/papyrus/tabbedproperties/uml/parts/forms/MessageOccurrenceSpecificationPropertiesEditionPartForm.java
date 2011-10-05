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
import org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class MessageOccurrenceSpecificationPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, MessageOccurrenceSpecificationPropertiesEditionPart {

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

	private EMFListEditUtil coveredEditUtil;

	protected ReferencesTable<? extends EObject> covered;

	protected List<ViewerFilter> coveredBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> coveredFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil generalOrderingEditUtil;

	protected ReferencesTable<? extends EObject> generalOrdering;

	protected List<ViewerFilter> generalOrderingBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> generalOrderingFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil toBeforeEditUtil;

	protected ReferencesTable<? extends EObject> toBefore;

	protected List<ViewerFilter> toBeforeBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> toBeforeFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil toAfterEditUtil;

	protected ReferencesTable<? extends EObject> toAfter;

	protected List<ViewerFilter> toAfterBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> toAfterFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public MessageOccurrenceSpecificationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		propertiesSection.setText(UMLMessages.MessageOccurrenceSpecificationPropertiesEditionPart_PropertiesGroupLabel);
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
		createCoveredReferencesTable(widgetFactory, propertiesGroup);
		createGeneralOrderingTableComposition(widgetFactory, propertiesGroup);
		createToBeforeReferencesTable(widgetFactory, propertiesGroup);
		createToAfterReferencesTable(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.MessageOccurrenceSpecificationPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.MessageOccurrenceSpecification.ownedComment, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.MessageOccurrenceSpecification.ownedComment, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
				MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
				UMLViewsRepository.MessageOccurrenceSpecification.ownedComment, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
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
						MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.MessageOccurrenceSpecification.ownedComment, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.MessageOccurrenceSpecificationPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.MessageOccurrenceSpecification.name, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.MessageOccurrenceSpecification.name, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.MessageOccurrenceSpecificationPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.MessageOccurrenceSpecification.visibility, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.visibility, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVisibility()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.MessageOccurrenceSpecification.visibility, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createClientDependencyReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.MessageOccurrenceSpecificationPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, clientDependencyFilters, clientDependencyBusinessFilters,
						"Dependency", UMLPackage.eINSTANCE.getDependency(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.MessageOccurrenceSpecification.clientDependency, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
				MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
				UMLViewsRepository.MessageOccurrenceSpecification.clientDependency, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
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
						MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.MessageOccurrenceSpecification.clientDependency,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createCoveredReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.covered = new ReferencesTable<Lifeline>(UMLMessages.MessageOccurrenceSpecificationPropertiesEditionPart_CoveredLabel, new ReferencesTableListener<Lifeline>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Lifeline> dialog = new TabElementTreeSelectionDialog<Lifeline>(resourceSet, coveredFilters, coveredBusinessFilters,
						"Lifeline", UMLPackage.eINSTANCE.getLifeline(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!coveredEditUtil.getVirtualList().contains(elem))
								coveredEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.covered,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						covered.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Lifeline element) {
				editCovered(element);
			}

			public void handleMove(Lifeline element, int oldIndex, int newIndex) {
				moveCovered(element, oldIndex, newIndex);
			}

			public void handleRemove(Lifeline element) {
				removeFromCovered(element);
			}

			public void navigateTo(Lifeline element) {
			}
		});
		this.covered.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.MessageOccurrenceSpecification.covered, UMLViewsRepository.FORM_KIND));
		this.covered.createControls(parent, widgetFactory);
		GridData coveredData = new GridData(GridData.FILL_HORIZONTAL);
		coveredData.horizontalSpan = 3;
		this.covered.setLayoutData(coveredData);
		this.covered.disableMove();
	}

	/**
	 * 
	 */
	protected void moveCovered(Lifeline element, int oldIndex, int newIndex) {
		EObject editedElement = coveredEditUtil.foundCorrespondingEObject(element);
		coveredEditUtil.moveElement(element, oldIndex, newIndex);
		covered.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.covered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromCovered(Lifeline element) {
		// Start of user code for the removeFromCovered() method body
		EObject editedElement = coveredEditUtil.foundCorrespondingEObject(element);
		coveredEditUtil.removeElement(element);
		covered.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
				UMLViewsRepository.MessageOccurrenceSpecification.covered, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editCovered(Lifeline element) {
		// Start of user code editCovered() method body

		EObject editedElement = coveredEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				coveredEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				covered.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.MessageOccurrenceSpecification.covered, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createGeneralOrderingTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.generalOrdering = new ReferencesTable<GeneralOrdering>(UMLMessages.MessageOccurrenceSpecificationPropertiesEditionPart_GeneralOrderingLabel, new ReferencesTableListener<GeneralOrdering>() {

			public void handleAdd() {
				addToGeneralOrdering();
			}

			public void handleEdit(GeneralOrdering element) {
				editGeneralOrdering(element);
			}

			public void handleMove(GeneralOrdering element, int oldIndex, int newIndex) {
				moveGeneralOrdering(element, oldIndex, newIndex);
			}

			public void handleRemove(GeneralOrdering element) {
				removeFromGeneralOrdering(element);
			}

			public void navigateTo(GeneralOrdering element) {
			}
		});
		this.generalOrdering.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.MessageOccurrenceSpecification.generalOrdering, UMLViewsRepository.FORM_KIND));
		this.generalOrdering.createControls(parent, widgetFactory);
		GridData generalOrderingData = new GridData(GridData.FILL_HORIZONTAL);
		generalOrderingData.horizontalSpan = 3;
		this.generalOrdering.setLayoutData(generalOrderingData);
	}

	/**
	 * 
	 */
	protected void moveGeneralOrdering(GeneralOrdering element, int oldIndex, int newIndex) {
		EObject editedElement = generalOrderingEditUtil.foundCorrespondingEObject(element);
		generalOrderingEditUtil.moveElement(element, oldIndex, newIndex);
		generalOrdering.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.generalOrdering, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToGeneralOrdering() {
		// Start of user code addToGeneralOrdering() method body
		GeneralOrdering eObject = UMLFactory.eINSTANCE.createGeneralOrdering();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				generalOrderingEditUtil.addElement(propertiesEditionObject);
				generalOrdering.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.MessageOccurrenceSpecification.generalOrdering,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromGeneralOrdering(GeneralOrdering element) {
		// Start of user code for the removeFromGeneralOrdering() method body
		EObject editedElement = generalOrderingEditUtil.foundCorrespondingEObject(element);
		generalOrderingEditUtil.removeElement(element);
		generalOrdering.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
				UMLViewsRepository.MessageOccurrenceSpecification.generalOrdering, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editGeneralOrdering(GeneralOrdering element) {
		// Start of user code editGeneralOrdering() method body
		EObject editedElement = generalOrderingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				generalOrderingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				generalOrdering.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.MessageOccurrenceSpecification.generalOrdering,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createToBeforeReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.toBefore = new ReferencesTable<GeneralOrdering>(UMLMessages.MessageOccurrenceSpecificationPropertiesEditionPart_ToBeforeLabel, new ReferencesTableListener<GeneralOrdering>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<GeneralOrdering> dialog = new TabElementTreeSelectionDialog<GeneralOrdering>(resourceSet, toBeforeFilters, toBeforeBusinessFilters,
						"GeneralOrdering", UMLPackage.eINSTANCE.getGeneralOrdering(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!toBeforeEditUtil.getVirtualList().contains(elem))
								toBeforeEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.toBefore,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						toBefore.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(GeneralOrdering element) {
				editToBefore(element);
			}

			public void handleMove(GeneralOrdering element, int oldIndex, int newIndex) {
				moveToBefore(element, oldIndex, newIndex);
			}

			public void handleRemove(GeneralOrdering element) {
				removeFromToBefore(element);
			}

			public void navigateTo(GeneralOrdering element) {
			}
		});
		this.toBefore.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.MessageOccurrenceSpecification.toBefore, UMLViewsRepository.FORM_KIND));
		this.toBefore.createControls(parent, widgetFactory);
		GridData toBeforeData = new GridData(GridData.FILL_HORIZONTAL);
		toBeforeData.horizontalSpan = 3;
		this.toBefore.setLayoutData(toBeforeData);
		this.toBefore.disableMove();
	}

	/**
	 * 
	 */
	protected void moveToBefore(GeneralOrdering element, int oldIndex, int newIndex) {
		EObject editedElement = toBeforeEditUtil.foundCorrespondingEObject(element);
		toBeforeEditUtil.moveElement(element, oldIndex, newIndex);
		toBefore.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.toBefore, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromToBefore(GeneralOrdering element) {
		// Start of user code for the removeFromToBefore() method body
		EObject editedElement = toBeforeEditUtil.foundCorrespondingEObject(element);
		toBeforeEditUtil.removeElement(element);
		toBefore.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
				UMLViewsRepository.MessageOccurrenceSpecification.toBefore, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editToBefore(GeneralOrdering element) {
		// Start of user code editToBefore() method body

		EObject editedElement = toBeforeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				toBeforeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				toBefore.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.MessageOccurrenceSpecification.toBefore, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createToAfterReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.toAfter = new ReferencesTable<GeneralOrdering>(UMLMessages.MessageOccurrenceSpecificationPropertiesEditionPart_ToAfterLabel, new ReferencesTableListener<GeneralOrdering>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<GeneralOrdering> dialog = new TabElementTreeSelectionDialog<GeneralOrdering>(resourceSet, toAfterFilters, toAfterBusinessFilters,
						"GeneralOrdering", UMLPackage.eINSTANCE.getGeneralOrdering(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!toAfterEditUtil.getVirtualList().contains(elem))
								toAfterEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.toAfter,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						toAfter.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(GeneralOrdering element) {
				editToAfter(element);
			}

			public void handleMove(GeneralOrdering element, int oldIndex, int newIndex) {
				moveToAfter(element, oldIndex, newIndex);
			}

			public void handleRemove(GeneralOrdering element) {
				removeFromToAfter(element);
			}

			public void navigateTo(GeneralOrdering element) {
			}
		});
		this.toAfter.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.MessageOccurrenceSpecification.toAfter, UMLViewsRepository.FORM_KIND));
		this.toAfter.createControls(parent, widgetFactory);
		GridData toAfterData = new GridData(GridData.FILL_HORIZONTAL);
		toAfterData.horizontalSpan = 3;
		this.toAfter.setLayoutData(toAfterData);
		this.toAfter.disableMove();
	}

	/**
	 * 
	 */
	protected void moveToAfter(GeneralOrdering element, int oldIndex, int newIndex) {
		EObject editedElement = toAfterEditUtil.foundCorrespondingEObject(element);
		toAfterEditUtil.moveElement(element, oldIndex, newIndex);
		toAfter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageOccurrenceSpecificationPropertiesEditionPartForm.this, UMLViewsRepository.MessageOccurrenceSpecification.toAfter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromToAfter(GeneralOrdering element) {
		// Start of user code for the removeFromToAfter() method body
		EObject editedElement = toAfterEditUtil.foundCorrespondingEObject(element);
		toAfterEditUtil.removeElement(element);
		toAfter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
				UMLViewsRepository.MessageOccurrenceSpecification.toAfter, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editToAfter(GeneralOrdering element) {
		// Start of user code editToAfter() method body

		EObject editedElement = toAfterEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				toAfterEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				toAfter.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						MessageOccurrenceSpecificationPropertiesEditionPartForm.this,
						UMLViewsRepository.MessageOccurrenceSpecification.toAfter, PropertiesEditionEvent.COMMIT,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#initOwnedComment(EObject current,
	 *      EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addFilterOwnedComment(ViewerFilter
	 *      filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#isContainedInOwnedCommentTable(EObject
	 *      element)
	 */
	public boolean isContainedInOwnedCommentTable(EObject element) {
		return ownedCommentEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator
	 *      current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getClientDependencyTable()
	 */
	public List getClientDependencyTable() {
		return clientDependencyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#initClientDependency(EObject current,
	 *      EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#updateClientDependency(EObject
	 *      newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addFilterClientDependency(ViewerFilter
	 *      filter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#isContainedInClientDependencyTable(EObject
	 *      element)
	 */
	public boolean isContainedInClientDependencyTable(EObject element) {
		return clientDependencyEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getCoveredToAdd()
	 */
	public List getCoveredToAdd() {
		return coveredEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getCoveredToRemove()
	 */
	public List getCoveredToRemove() {
		return coveredEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getCoveredTable()
	 */
	public List getCoveredTable() {
		return coveredEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#initCovered(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initCovered(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			coveredEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			coveredEditUtil = new EMFListEditUtil(current, feature);
		this.covered.setInput(coveredEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#updateCovered(EObject newValue)
	 */
	public void updateCovered(EObject newValue) {
		if(coveredEditUtil != null) {
			coveredEditUtil.reinit(newValue);
			covered.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addFilterCovered(ViewerFilter filter)
	 */
	public void addFilterToCovered(ViewerFilter filter) {
		coveredFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addBusinessFilterCovered(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToCovered(ViewerFilter filter) {
		coveredBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#isContainedInCoveredTable(EObject
	 *      element)
	 */
	public boolean isContainedInCoveredTable(EObject element) {
		return coveredEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getGeneralOrderingToAdd()
	 */
	public List getGeneralOrderingToAdd() {
		return generalOrderingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getGeneralOrderingToRemove()
	 */
	public List getGeneralOrderingToRemove() {
		return generalOrderingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getGeneralOrderingToEdit()
	 */
	public Map getGeneralOrderingToEdit() {
		return generalOrderingEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getGeneralOrderingToMove()
	 */
	public List getGeneralOrderingToMove() {
		return generalOrderingEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getGeneralOrderingTable()
	 */
	public List getGeneralOrderingTable() {
		return generalOrderingEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#initGeneralOrdering(EObject current,
	 *      EReference containingFeature, EReference feature)
	 */
	public void initGeneralOrdering(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			generalOrderingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			generalOrderingEditUtil = new EMFListEditUtil(current, feature);
		this.generalOrdering.setInput(generalOrderingEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#updateGeneralOrdering(EObject newValue)
	 */
	public void updateGeneralOrdering(EObject newValue) {
		if(generalOrderingEditUtil != null) {
			generalOrderingEditUtil.reinit(newValue);
			generalOrdering.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addFilterGeneralOrdering(ViewerFilter
	 *      filter)
	 */
	public void addFilterToGeneralOrdering(ViewerFilter filter) {
		generalOrderingFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addBusinessFilterGeneralOrdering(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToGeneralOrdering(ViewerFilter filter) {
		generalOrderingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#isContainedInGeneralOrderingTable(EObject
	 *      element)
	 */
	public boolean isContainedInGeneralOrderingTable(EObject element) {
		return generalOrderingEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getToBeforeToAdd()
	 */
	public List getToBeforeToAdd() {
		return toBeforeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getToBeforeToRemove()
	 */
	public List getToBeforeToRemove() {
		return toBeforeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getToBeforeTable()
	 */
	public List getToBeforeTable() {
		return toBeforeEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#initToBefore(EObject current,
	 *      EReference containingFeature, EReference feature)
	 */
	public void initToBefore(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			toBeforeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			toBeforeEditUtil = new EMFListEditUtil(current, feature);
		this.toBefore.setInput(toBeforeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#updateToBefore(EObject newValue)
	 */
	public void updateToBefore(EObject newValue) {
		if(toBeforeEditUtil != null) {
			toBeforeEditUtil.reinit(newValue);
			toBefore.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addFilterToBefore(ViewerFilter filter)
	 */
	public void addFilterToToBefore(ViewerFilter filter) {
		toBeforeFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addBusinessFilterToBefore(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToToBefore(ViewerFilter filter) {
		toBeforeBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#isContainedInToBeforeTable(EObject
	 *      element)
	 */
	public boolean isContainedInToBeforeTable(EObject element) {
		return toBeforeEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getToAfterToAdd()
	 */
	public List getToAfterToAdd() {
		return toAfterEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getToAfterToRemove()
	 */
	public List getToAfterToRemove() {
		return toAfterEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#getToAfterTable()
	 */
	public List getToAfterTable() {
		return toAfterEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#initToAfter(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initToAfter(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			toAfterEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			toAfterEditUtil = new EMFListEditUtil(current, feature);
		this.toAfter.setInput(toAfterEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#updateToAfter(EObject newValue)
	 */
	public void updateToAfter(EObject newValue) {
		if(toAfterEditUtil != null) {
			toAfterEditUtil.reinit(newValue);
			toAfter.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addFilterToAfter(ViewerFilter filter)
	 */
	public void addFilterToToAfter(ViewerFilter filter) {
		toAfterFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#addBusinessFilterToAfter(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToToAfter(ViewerFilter filter) {
		toAfterBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.MessageOccurrenceSpecificationPropertiesEditionPart#isContainedInToAfterTable(EObject
	 *      element)
	 */
	public boolean isContainedInToAfterTable(EObject element) {
		return toAfterEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
