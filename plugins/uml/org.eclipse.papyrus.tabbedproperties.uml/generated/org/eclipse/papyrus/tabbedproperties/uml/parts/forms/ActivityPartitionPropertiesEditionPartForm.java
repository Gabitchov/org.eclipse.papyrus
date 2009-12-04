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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart;
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
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ActivityPartitionPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ActivityPartitionPropertiesEditionPart {

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

	protected Button isDimension;

	protected Button isExternal;

	private EMFListEditUtil nodeEditUtil;

	protected ReferencesTable<? extends EObject> node;

	protected List<ViewerFilter> nodeBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> nodeFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil subpartitionEditUtil;

	protected ReferencesTable<? extends EObject> subpartition;

	protected List<ViewerFilter> subpartitionBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> subpartitionFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil edgeEditUtil;

	protected ReferencesTable<? extends EObject> edge;

	protected List<ViewerFilter> edgeBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> edgeFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ActivityPartitionPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		propertiesSection.setText(UMLMessages.ActivityPartitionPropertiesEditionPart_PropertiesGroupLabel);
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
		createIsDimensionCheckbox(widgetFactory, propertiesGroup);
		createIsExternalCheckbox(widgetFactory, propertiesGroup);
		createNodeReferencesTable(widgetFactory, propertiesGroup);
		createSubpartitionTableComposition(widgetFactory, propertiesGroup);
		createEdgeReferencesTable(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.ActivityPartitionPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ActivityPartition.ownedComment, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						ActivityPartitionPropertiesEditionPartForm.this,
						UMLViewsRepository.ActivityPartition.ownedComment, PropertiesEditionEvent.COMMIT,
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
				ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.ownedComment,
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
						ActivityPartitionPropertiesEditionPartForm.this,
						UMLViewsRepository.ActivityPartition.ownedComment, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.ActivityPartitionPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.ActivityPartition.name, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ActivityPartition.name, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createVisibilityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.ActivityPartitionPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.ActivityPartition.visibility, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.visibility, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVisibility()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ActivityPartition.visibility, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createClientDependencyReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.ActivityPartitionPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, clientDependencyFilters, clientDependencyBusinessFilters,
						"Dependency", UMLPackage.eINSTANCE.getDependency(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.clientDependency,
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
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ActivityPartition.clientDependency, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
				ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.clientDependency,
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
						ActivityPartitionPropertiesEditionPartForm.this,
						UMLViewsRepository.ActivityPartition.clientDependency, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createIsDimensionCheckbox(FormToolkit widgetFactory, Composite parent) {
		isDimension = widgetFactory.createButton(parent, UMLMessages.ActivityPartitionPropertiesEditionPart_IsDimensionLabel, SWT.CHECK);
		isDimension.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.isDimension, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isDimension.getSelection())));
			}

		});
		GridData isDimensionData = new GridData(GridData.FILL_HORIZONTAL);
		isDimensionData.horizontalSpan = 2;
		isDimension.setLayoutData(isDimensionData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ActivityPartition.isDimension, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createIsExternalCheckbox(FormToolkit widgetFactory, Composite parent) {
		isExternal = widgetFactory.createButton(parent, UMLMessages.ActivityPartitionPropertiesEditionPart_IsExternalLabel, SWT.CHECK);
		isExternal.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if(propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.isExternal, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isExternal.getSelection())));
			}

		});
		GridData isExternalData = new GridData(GridData.FILL_HORIZONTAL);
		isExternalData.horizontalSpan = 2;
		isExternal.setLayoutData(isExternalData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ActivityPartition.isExternal, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createNodeReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.node = new ReferencesTable<ActivityNode>(UMLMessages.ActivityPartitionPropertiesEditionPart_NodeLabel, new ReferencesTableListener<ActivityNode>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<ActivityNode> dialog = new TabElementTreeSelectionDialog<ActivityNode>(resourceSet, nodeFilters, nodeBusinessFilters,
						"ActivityNode", UMLPackage.eINSTANCE.getActivityNode(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!nodeEditUtil.getVirtualList().contains(elem))
								nodeEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.node,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						node.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(ActivityNode element) {
				editNode(element);
			}

			public void handleMove(ActivityNode element, int oldIndex, int newIndex) {
				moveNode(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityNode element) {
				removeFromNode(element);
			}

			public void navigateTo(ActivityNode element) {
			}
		});
		this.node.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ActivityPartition.node, UMLViewsRepository.FORM_KIND));
		this.node.createControls(parent, widgetFactory);
		GridData nodeData = new GridData(GridData.FILL_HORIZONTAL);
		nodeData.horizontalSpan = 3;
		this.node.setLayoutData(nodeData);
		this.node.disableMove();
	}

	/**
	 * 
	 */
	protected void moveNode(ActivityNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromNode(ActivityNode element) {
		// Start of user code for the removeFromNode() method body
		EObject editedElement = nodeEditUtil.foundCorrespondingEObject(element);
		nodeEditUtil.removeElement(element);
		node.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.node,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editNode(ActivityNode element) {
		// Start of user code editNode() method body

		EObject editedElement = nodeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				nodeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				node.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.node,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createSubpartitionTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.subpartition = new ReferencesTable<ActivityPartition>(UMLMessages.ActivityPartitionPropertiesEditionPart_SubpartitionLabel, new ReferencesTableListener<ActivityPartition>() {

			public void handleAdd() {
				addToSubpartition();
			}

			public void handleEdit(ActivityPartition element) {
				editSubpartition(element);
			}

			public void handleMove(ActivityPartition element, int oldIndex, int newIndex) {
				moveSubpartition(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityPartition element) {
				removeFromSubpartition(element);
			}

			public void navigateTo(ActivityPartition element) {
			}
		});
		this.subpartition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ActivityPartition.subpartition, UMLViewsRepository.FORM_KIND));
		this.subpartition.createControls(parent, widgetFactory);
		GridData subpartitionData = new GridData(GridData.FILL_HORIZONTAL);
		subpartitionData.horizontalSpan = 3;
		this.subpartition.setLayoutData(subpartitionData);
	}

	/**
	 * 
	 */
	protected void moveSubpartition(ActivityPartition element, int oldIndex, int newIndex) {
		EObject editedElement = subpartitionEditUtil.foundCorrespondingEObject(element);
		subpartitionEditUtil.moveElement(element, oldIndex, newIndex);
		subpartition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.subpartition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToSubpartition() {
		// Start of user code addToSubpartition() method body
		ActivityPartition eObject = UMLFactory.eINSTANCE.createActivityPartition();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				subpartitionEditUtil.addElement(propertiesEditionObject);
				subpartition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ActivityPartitionPropertiesEditionPartForm.this,
						UMLViewsRepository.ActivityPartition.subpartition, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromSubpartition(ActivityPartition element) {
		// Start of user code for the removeFromSubpartition() method body
		EObject editedElement = subpartitionEditUtil.foundCorrespondingEObject(element);
		subpartitionEditUtil.removeElement(element);
		subpartition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.subpartition,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSubpartition(ActivityPartition element) {
		// Start of user code editSubpartition() method body
		EObject editedElement = subpartitionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				subpartitionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				subpartition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ActivityPartitionPropertiesEditionPartForm.this,
						UMLViewsRepository.ActivityPartition.subpartition, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createEdgeReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.edge = new ReferencesTable<ActivityEdge>(UMLMessages.ActivityPartitionPropertiesEditionPart_EdgeLabel, new ReferencesTableListener<ActivityEdge>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<ActivityEdge> dialog = new TabElementTreeSelectionDialog<ActivityEdge>(resourceSet, edgeFilters, edgeBusinessFilters,
						"ActivityEdge", UMLPackage.eINSTANCE.getActivityEdge(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!edgeEditUtil.getVirtualList().contains(elem))
								edgeEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.edge,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						edge.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(ActivityEdge element) {
				editEdge(element);
			}

			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) {
				moveEdge(element, oldIndex, newIndex);
			}

			public void handleRemove(ActivityEdge element) {
				removeFromEdge(element);
			}

			public void navigateTo(ActivityEdge element) {
			}
		});
		this.edge.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ActivityPartition.edge, UMLViewsRepository.FORM_KIND));
		this.edge.createControls(parent, widgetFactory);
		GridData edgeData = new GridData(GridData.FILL_HORIZONTAL);
		edgeData.horizontalSpan = 3;
		this.edge.setLayoutData(edgeData);
		this.edge.disableMove();
	}

	/**
	 * 
	 */
	protected void moveEdge(ActivityEdge element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromEdge(ActivityEdge element) {
		// Start of user code for the removeFromEdge() method body
		EObject editedElement = edgeEditUtil.foundCorrespondingEObject(element);
		edgeEditUtil.removeElement(element);
		edge.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.edge,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editEdge(ActivityEdge element) {
		// Start of user code editEdge() method body

		EObject editedElement = edgeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				edgeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				edge.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ActivityPartitionPropertiesEditionPartForm.this, UMLViewsRepository.ActivityPartition.edge,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#initOwnedComment(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
	 */
	public boolean isContainedInOwnedCommentTable(EObject element) {
		return ownedCommentEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral)((StructuredSelection)visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getClientDependencyTable()
	 */
	public List getClientDependencyTable() {
		return clientDependencyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#initClientDependency(EObject current, EReference
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#updateClientDependency(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addFilterClientDependency(ViewerFilter filter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#isContainedInClientDependencyTable(EObject element)
	 */
	public boolean isContainedInClientDependencyTable(EObject element) {
		return clientDependencyEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getIsDimension()
	 */
	public Boolean getIsDimension() {
		return Boolean.valueOf(isDimension.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#setIsDimension(Boolean newValue)
	 */
	public void setIsDimension(Boolean newValue) {
		if(newValue != null) {
			isDimension.setSelection(newValue.booleanValue());
		} else {
			isDimension.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getIsExternal()
	 */
	public Boolean getIsExternal() {
		return Boolean.valueOf(isExternal.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#setIsExternal(Boolean newValue)
	 */
	public void setIsExternal(Boolean newValue) {
		if(newValue != null) {
			isExternal.setSelection(newValue.booleanValue());
		} else {
			isExternal.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getNodeToAdd()
	 */
	public List getNodeToAdd() {
		return nodeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getNodeToRemove()
	 */
	public List getNodeToRemove() {
		return nodeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getNodeTable()
	 */
	public List getNodeTable() {
		return nodeEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#initNode(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initNode(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			nodeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			nodeEditUtil = new EMFListEditUtil(current, feature);
		this.node.setInput(nodeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#updateNode(EObject newValue)
	 */
	public void updateNode(EObject newValue) {
		if(nodeEditUtil != null) {
			nodeEditUtil.reinit(newValue);
			node.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addFilterNode(ViewerFilter filter)
	 */
	public void addFilterToNode(ViewerFilter filter) {
		nodeFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addBusinessFilterNode(ViewerFilter filter)
	 */
	public void addBusinessFilterToNode(ViewerFilter filter) {
		nodeBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#isContainedInNodeTable(EObject element)
	 */
	public boolean isContainedInNodeTable(EObject element) {
		return nodeEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getSubpartitionToAdd()
	 */
	public List getSubpartitionToAdd() {
		return subpartitionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getSubpartitionToRemove()
	 */
	public List getSubpartitionToRemove() {
		return subpartitionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getSubpartitionToEdit()
	 */
	public Map getSubpartitionToEdit() {
		return subpartitionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getSubpartitionToMove()
	 */
	public List getSubpartitionToMove() {
		return subpartitionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getSubpartitionTable()
	 */
	public List getSubpartitionTable() {
		return subpartitionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#initSubpartition(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initSubpartition(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			subpartitionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			subpartitionEditUtil = new EMFListEditUtil(current, feature);
		this.subpartition.setInput(subpartitionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#updateSubpartition(EObject newValue)
	 */
	public void updateSubpartition(EObject newValue) {
		if(subpartitionEditUtil != null) {
			subpartitionEditUtil.reinit(newValue);
			subpartition.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addFilterSubpartition(ViewerFilter filter)
	 */
	public void addFilterToSubpartition(ViewerFilter filter) {
		subpartitionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addBusinessFilterSubpartition(ViewerFilter filter)
	 */
	public void addBusinessFilterToSubpartition(ViewerFilter filter) {
		subpartitionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#isContainedInSubpartitionTable(EObject element)
	 */
	public boolean isContainedInSubpartitionTable(EObject element) {
		return subpartitionEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getEdgeToAdd()
	 */
	public List getEdgeToAdd() {
		return edgeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getEdgeToRemove()
	 */
	public List getEdgeToRemove() {
		return edgeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#getEdgeTable()
	 */
	public List getEdgeTable() {
		return edgeEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#initEdge(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initEdge(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			edgeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			edgeEditUtil = new EMFListEditUtil(current, feature);
		this.edge.setInput(edgeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#updateEdge(EObject newValue)
	 */
	public void updateEdge(EObject newValue) {
		if(edgeEditUtil != null) {
			edgeEditUtil.reinit(newValue);
			edge.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addFilterEdge(ViewerFilter filter)
	 */
	public void addFilterToEdge(ViewerFilter filter) {
		edgeFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#addBusinessFilterEdge(ViewerFilter filter)
	 */
	public void addBusinessFilterToEdge(ViewerFilter filter) {
		edgeBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityPartitionPropertiesEditionPart#isContainedInEdgeTable(EObject element)
	 */
	public boolean isContainedInEdgeTable(EObject element) {
		return edgeEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
