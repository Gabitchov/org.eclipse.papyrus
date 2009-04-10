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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart;
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
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ArtifactPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ArtifactPropertiesEditionPart {

	private EMFListEditUtil ownedCommentEditUtil;
	private ReferencesTable<?> ownedComment;
	private Text name;
	private EMFEnumViewer visibility;
	private EMFListEditUtil clientDependencyEditUtil;
	private ReferencesTable<?> clientDependency;
	private EMFListEditUtil elementImportEditUtil;
	private ReferencesTable<?> elementImport;
	private EMFListEditUtil packageImportEditUtil;
	private ReferencesTable<?> packageImport;
	private EMFListEditUtil ownedRuleEditUtil;
	private ReferencesTable<?> ownedRule;
	private Button isLeaf;
	private EMFListEditUtil templateBindingEditUtil;
	private ReferencesTable<?> templateBinding;
	private Button isAbstract;
	private EMFListEditUtil generalizationEditUtil;
	private ReferencesTable<?> generalization;
	private EMFListEditUtil powertypeExtentEditUtil;
	private ReferencesTable<?> powertypeExtent;
	private EMFListEditUtil redefinedClassifierEditUtil;
	private ReferencesTable<?> redefinedClassifier;
	private EMFListEditUtil substitutionEditUtil;
	private ReferencesTable<?> substitution;
	private EMFListEditUtil collaborationUseEditUtil;
	private ReferencesTable<?> collaborationUse;
	private EMFListEditUtil ownedUseCaseEditUtil;
	private ReferencesTable<?> ownedUseCase;
	private EMFListEditUtil useCaseEditUtil;
	private ReferencesTable<?> useCase;
	private Text fileName;
	private EMFListEditUtil nestedArtifactEditUtil;
	private ReferencesTable<?> nestedArtifact;
	private EMFListEditUtil manifestationEditUtil;
	private ReferencesTable<?> manifestation;
	private EMFListEditUtil ownedOperationEditUtil;
	private ReferencesTable<?> ownedOperation;
	private EMFListEditUtil ownedAttributeEditUtil;
	private ReferencesTable<?> ownedAttribute;




	
	public ArtifactPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPropertiesGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(UMLMessages.ArtifactPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createOwnedCommentTableComposition(widgetFactory, propertiesGroup);
		createNameText(widgetFactory, propertiesGroup);
		createVisibilityEEnumViewer(widgetFactory, propertiesGroup);
		createClientDependencyReferencesTable(widgetFactory, propertiesGroup);
		createElementImportTableComposition(widgetFactory, propertiesGroup);
		createPackageImportTableComposition(widgetFactory, propertiesGroup);
		createOwnedRuleTableComposition(widgetFactory, propertiesGroup);
		createIsLeafCheckbox(widgetFactory, propertiesGroup);
		createTemplateBindingTableComposition(widgetFactory, propertiesGroup);
		createIsAbstractCheckbox(widgetFactory, propertiesGroup);
		createGeneralizationTableComposition(widgetFactory, propertiesGroup);
		createPowertypeExtentReferencesTable(widgetFactory, propertiesGroup);
		createRedefinedClassifierReferencesTable(widgetFactory, propertiesGroup);
		createSubstitutionTableComposition(widgetFactory, propertiesGroup);
		createCollaborationUseTableComposition(widgetFactory, propertiesGroup);
		createOwnedUseCaseTableComposition(widgetFactory, propertiesGroup);
		createUseCaseReferencesTable(widgetFactory, propertiesGroup);
		createFileNameText(widgetFactory, propertiesGroup);
		createNestedArtifactTableComposition(widgetFactory, propertiesGroup);
		createManifestationTableComposition(widgetFactory, propertiesGroup);
		createOwnedOperationTableComposition(widgetFactory, propertiesGroup);
		createOwnedAttributeTableComposition(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}   		
	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.ArtifactPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {			
			public void handleAdd() { addToOwnedComment();}
			public void handleEdit(Comment element) { editOwnedComment(element); }
			public void handleMove(Comment element, int oldIndex, int newIndex) { moveOwnedComment(element, oldIndex, newIndex); }			
			public void handleRemove(Comment element) { removeFromOwnedComment(element); }
			public void navigateTo(Comment element) { System.out.println("---> navigateTo"); }
		});
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.ownedComment, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedComment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToOwnedComment() {
	
		// Start of user code addToOwnedComment() method body
		
		
		Comment eObject = UMLFactory.eINSTANCE.createComment();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.addElement(propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedComment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedComment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editOwnedComment(Comment element) {

		// Start of user code editOwnedComment() method body
				 
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedComment, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.ArtifactPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Artifact.name, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.name, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.name, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, name.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.name, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createVisibilityEEnumViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.ArtifactPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Artifact.visibility, UMLViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.visibility, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, getVisibility()));
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.visibility, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createClientDependencyReferencesTable(FormToolkit widgetFactory, Composite parent) {	
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.ArtifactPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {
			public void handleAdd() {				
				ViewerFilter clientDependencyFilter = new EObjectFilter(UMLPackage.eINSTANCE.getDependency());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!clientDependencyEditUtil.contains((EObject)element));
						return false;				
					}
				};				
				ViewerFilter[] filters = { clientDependencyFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, filters, 
				"Dependency", UMLPackage.eINSTANCE.getDependency()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.clientDependency,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));
						}
						clientDependency.refresh();												
					}
				};
				dialog.open();
			}
			public void handleEdit(Dependency element) { editClientDependency(element); }
			public void handleMove(Dependency element, int oldIndex, int newIndex) { moveClientDependency(element, oldIndex, newIndex); }
			public void handleRemove(Dependency element) { removeFromClientDependency(element); }
			public void navigateTo(Dependency element) { System.out.println("---> navigateTo"); }
		});
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.clientDependency, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));
	
		
	}
	
	/**
	 * 
	 */
	protected void removeFromClientDependency(Dependency element) {

		// Start of user code for the removeFromClientDependency() method body

		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.removeElement(element);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editClientDependency(Dependency element) {

		// Start of user code editClientDependency() method body
				 
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				clientDependencyEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				clientDependency.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.clientDependency, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createElementImportTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.elementImport = new ReferencesTable<ElementImport>(UMLMessages.ArtifactPropertiesEditionPart_ElementImportLabel, new ReferencesTableListener<ElementImport>() {			
			public void handleAdd() { addToElementImport();}
			public void handleEdit(ElementImport element) { editElementImport(element); }
			public void handleMove(ElementImport element, int oldIndex, int newIndex) { moveElementImport(element, oldIndex, newIndex); }			
			public void handleRemove(ElementImport element) { removeFromElementImport(element); }
			public void navigateTo(ElementImport element) { System.out.println("---> navigateTo"); }
		});
		this.elementImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.elementImport, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.elementImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToElementImport() {
	
		// Start of user code addToElementImport() method body
		
		
		ElementImport eObject = UMLFactory.eINSTANCE.createElementImport();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				elementImportEditUtil.addElement(propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.elementImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.elementImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editElementImport(ElementImport element) {

		// Start of user code editElementImport() method body
				 
		EObject editedElement = elementImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				elementImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				elementImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.elementImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createPackageImportTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.packageImport = new ReferencesTable<PackageImport>(UMLMessages.ArtifactPropertiesEditionPart_PackageImportLabel, new ReferencesTableListener<PackageImport>() {			
			public void handleAdd() { addToPackageImport();}
			public void handleEdit(PackageImport element) { editPackageImport(element); }
			public void handleMove(PackageImport element, int oldIndex, int newIndex) { movePackageImport(element, oldIndex, newIndex); }			
			public void handleRemove(PackageImport element) { removeFromPackageImport(element); }
			public void navigateTo(PackageImport element) { System.out.println("---> navigateTo"); }
		});
		this.packageImport.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.packageImport, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.packageImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToPackageImport() {
	
		// Start of user code addToPackageImport() method body
		
		
		PackageImport eObject = UMLFactory.eINSTANCE.createPackageImport();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				packageImportEditUtil.addElement(propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.packageImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.packageImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editPackageImport(PackageImport element) {

		// Start of user code editPackageImport() method body
				 
		EObject editedElement = packageImportEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				packageImportEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				packageImport.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.packageImport, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createOwnedRuleTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedRule = new ReferencesTable<Constraint>(UMLMessages.ArtifactPropertiesEditionPart_OwnedRuleLabel, new ReferencesTableListener<Constraint>() {			
			public void handleAdd() { addToOwnedRule();}
			public void handleEdit(Constraint element) { editOwnedRule(element); }
			public void handleMove(Constraint element, int oldIndex, int newIndex) { moveOwnedRule(element, oldIndex, newIndex); }			
			public void handleRemove(Constraint element) { removeFromOwnedRule(element); }
			public void navigateTo(Constraint element) { System.out.println("---> navigateTo"); }
		});
		this.ownedRule.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.ownedRule, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedRule, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToOwnedRule() {
	
		// Start of user code addToOwnedRule() method body
		
		
		Constraint eObject = UMLFactory.eINSTANCE.createConstraint();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				ownedRuleEditUtil.addElement(propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedRule, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedRule, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editOwnedRule(Constraint element) {

		// Start of user code editOwnedRule() method body
				 
		EObject editedElement = ownedRuleEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				ownedRuleEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedRule.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedRule, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createIsLeafCheckbox(FormToolkit widgetFactory, Composite parent) {
		isLeaf = widgetFactory.createButton(parent, UMLMessages.ArtifactPropertiesEditionPart_IsLeafLabel, SWT.CHECK);
   		isLeaf.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.isLeaf, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, new Boolean(isLeaf.getSelection())));
			}
   			
   			
   		});
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.isLeaf, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param container
	 */
	protected void createTemplateBindingTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.templateBinding = new ReferencesTable<TemplateBinding>(UMLMessages.ArtifactPropertiesEditionPart_TemplateBindingLabel, new ReferencesTableListener<TemplateBinding>() {			
			public void handleAdd() { addToTemplateBinding();}
			public void handleEdit(TemplateBinding element) { editTemplateBinding(element); }
			public void handleMove(TemplateBinding element, int oldIndex, int newIndex) { moveTemplateBinding(element, oldIndex, newIndex); }			
			public void handleRemove(TemplateBinding element) { removeFromTemplateBinding(element); }
			public void navigateTo(TemplateBinding element) { System.out.println("---> navigateTo"); }
		});
		this.templateBinding.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.templateBinding, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.templateBinding, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToTemplateBinding() {
	
		// Start of user code addToTemplateBinding() method body
		
		
		TemplateBinding eObject = UMLFactory.eINSTANCE.createTemplateBinding();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				templateBindingEditUtil.addElement(propertiesEditionObject);
				templateBinding.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.templateBinding, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.templateBinding, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editTemplateBinding(TemplateBinding element) {

		// Start of user code editTemplateBinding() method body
				 
		EObject editedElement = templateBindingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				templateBindingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				templateBinding.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.templateBinding, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createIsAbstractCheckbox(FormToolkit widgetFactory, Composite parent) {
		isAbstract = widgetFactory.createButton(parent, UMLMessages.ArtifactPropertiesEditionPart_IsAbstractLabel, SWT.CHECK);
   		isAbstract.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.isAbstract, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, new Boolean(isAbstract.getSelection())));
			}
   			
   			
   		});
		GridData isAbstractData = new GridData(GridData.FILL_HORIZONTAL);
		isAbstractData.horizontalSpan = 2;
		isAbstract.setLayoutData(isAbstractData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.isAbstract, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param container
	 */
	protected void createGeneralizationTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.generalization = new ReferencesTable<Generalization>(UMLMessages.ArtifactPropertiesEditionPart_GeneralizationLabel, new ReferencesTableListener<Generalization>() {			
			public void handleAdd() { addToGeneralization();}
			public void handleEdit(Generalization element) { editGeneralization(element); }
			public void handleMove(Generalization element, int oldIndex, int newIndex) { moveGeneralization(element, oldIndex, newIndex); }			
			public void handleRemove(Generalization element) { removeFromGeneralization(element); }
			public void navigateTo(Generalization element) { System.out.println("---> navigateTo"); }
		});
		this.generalization.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.generalization, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.generalization, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToGeneralization() {
	
		// Start of user code addToGeneralization() method body
		
		
		Generalization eObject = UMLFactory.eINSTANCE.createGeneralization();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				generalizationEditUtil.addElement(propertiesEditionObject);
				generalization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.generalization, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.generalization, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editGeneralization(Generalization element) {

		// Start of user code editGeneralization() method body
				 
		EObject editedElement = generalizationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				generalizationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				generalization.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.generalization, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createPowertypeExtentReferencesTable(FormToolkit widgetFactory, Composite parent) {	
		this.powertypeExtent = new ReferencesTable<GeneralizationSet>(UMLMessages.ArtifactPropertiesEditionPart_PowertypeExtentLabel, new ReferencesTableListener<GeneralizationSet>() {
			public void handleAdd() {				
				ViewerFilter powertypeExtentFilter = new EObjectFilter(UMLPackage.eINSTANCE.getGeneralizationSet());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!powertypeExtentEditUtil.contains((EObject)element));
						return false;				
					}
				};				
				ViewerFilter[] filters = { powertypeExtentFilter, viewerFilter };		
				TabElementTreeSelectionDialog<GeneralizationSet> dialog = new TabElementTreeSelectionDialog<GeneralizationSet>(resourceSet, filters, 
				"GeneralizationSet", UMLPackage.eINSTANCE.getGeneralizationSet()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!powertypeExtentEditUtil.getVirtualList().contains(elem))
								powertypeExtentEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.powertypeExtent,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));
						}
						powertypeExtent.refresh();												
					}
				};
				dialog.open();
			}
			public void handleEdit(GeneralizationSet element) { editPowertypeExtent(element); }
			public void handleMove(GeneralizationSet element, int oldIndex, int newIndex) { movePowertypeExtent(element, oldIndex, newIndex); }
			public void handleRemove(GeneralizationSet element) { removeFromPowertypeExtent(element); }
			public void navigateTo(GeneralizationSet element) { System.out.println("---> navigateTo"); }
		});
		this.powertypeExtent.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.powertypeExtent, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.powertypeExtent, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));
	
		
	}
	
	/**
	 * 
	 */
	protected void removeFromPowertypeExtent(GeneralizationSet element) {

		// Start of user code for the removeFromPowertypeExtent() method body

		EObject editedElement = powertypeExtentEditUtil.foundCorrespondingEObject(element);
		powertypeExtentEditUtil.removeElement(element);
		powertypeExtent.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.powertypeExtent, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editPowertypeExtent(GeneralizationSet element) {

		// Start of user code editPowertypeExtent() method body
				 
		EObject editedElement = powertypeExtentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				powertypeExtentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				powertypeExtent.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.powertypeExtent, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createRedefinedClassifierReferencesTable(FormToolkit widgetFactory, Composite parent) {	
		this.redefinedClassifier = new ReferencesTable<Classifier>(UMLMessages.ArtifactPropertiesEditionPart_RedefinedClassifierLabel, new ReferencesTableListener<Classifier>() {
			public void handleAdd() {				
				ViewerFilter redefinedClassifierFilter = new EObjectFilter(UMLPackage.eINSTANCE.getClassifier());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!redefinedClassifierEditUtil.contains((EObject)element));
						return false;				
					}
				};				
				ViewerFilter[] filters = { redefinedClassifierFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, filters, 
				"Classifier", UMLPackage.eINSTANCE.getClassifier()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!redefinedClassifierEditUtil.getVirtualList().contains(elem))
								redefinedClassifierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.redefinedClassifier,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));
						}
						redefinedClassifier.refresh();												
					}
				};
				dialog.open();
			}
			public void handleEdit(Classifier element) { editRedefinedClassifier(element); }
			public void handleMove(Classifier element, int oldIndex, int newIndex) { moveRedefinedClassifier(element, oldIndex, newIndex); }
			public void handleRemove(Classifier element) { removeFromRedefinedClassifier(element); }
			public void navigateTo(Classifier element) { System.out.println("---> navigateTo"); }
		});
		this.redefinedClassifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.redefinedClassifier, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.redefinedClassifier, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editRedefinedClassifier(Classifier element) {

		// Start of user code editRedefinedClassifier() method body
				 
		EObject editedElement = redefinedClassifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				redefinedClassifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				redefinedClassifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.redefinedClassifier, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createSubstitutionTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.substitution = new ReferencesTable<Substitution>(UMLMessages.ArtifactPropertiesEditionPart_SubstitutionLabel, new ReferencesTableListener<Substitution>() {			
			public void handleAdd() { addToSubstitution();}
			public void handleEdit(Substitution element) { editSubstitution(element); }
			public void handleMove(Substitution element, int oldIndex, int newIndex) { moveSubstitution(element, oldIndex, newIndex); }			
			public void handleRemove(Substitution element) { removeFromSubstitution(element); }
			public void navigateTo(Substitution element) { System.out.println("---> navigateTo"); }
		});
		this.substitution.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.substitution, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.substitution, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToSubstitution() {
	
		// Start of user code addToSubstitution() method body
		
		
		Substitution eObject = UMLFactory.eINSTANCE.createSubstitution();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				substitutionEditUtil.addElement(propertiesEditionObject);
				substitution.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.substitution, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.substitution, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editSubstitution(Substitution element) {

		// Start of user code editSubstitution() method body
				 
		EObject editedElement = substitutionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				substitutionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				substitution.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.substitution, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createCollaborationUseTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.collaborationUse = new ReferencesTable<CollaborationUse>(UMLMessages.ArtifactPropertiesEditionPart_CollaborationUseLabel, new ReferencesTableListener<CollaborationUse>() {			
			public void handleAdd() { addToCollaborationUse();}
			public void handleEdit(CollaborationUse element) { editCollaborationUse(element); }
			public void handleMove(CollaborationUse element, int oldIndex, int newIndex) { moveCollaborationUse(element, oldIndex, newIndex); }			
			public void handleRemove(CollaborationUse element) { removeFromCollaborationUse(element); }
			public void navigateTo(CollaborationUse element) { System.out.println("---> navigateTo"); }
		});
		this.collaborationUse.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.collaborationUse, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.collaborationUse, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToCollaborationUse() {
	
		// Start of user code addToCollaborationUse() method body
		
		
		CollaborationUse eObject = UMLFactory.eINSTANCE.createCollaborationUse();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				collaborationUseEditUtil.addElement(propertiesEditionObject);
				collaborationUse.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.collaborationUse, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.collaborationUse, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editCollaborationUse(CollaborationUse element) {

		// Start of user code editCollaborationUse() method body
				 
		EObject editedElement = collaborationUseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				collaborationUseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				collaborationUse.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.collaborationUse, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createOwnedUseCaseTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedUseCase = new ReferencesTable<UseCase>(UMLMessages.ArtifactPropertiesEditionPart_OwnedUseCaseLabel, new ReferencesTableListener<UseCase>() {			
			public void handleAdd() { addToOwnedUseCase();}
			public void handleEdit(UseCase element) { editOwnedUseCase(element); }
			public void handleMove(UseCase element, int oldIndex, int newIndex) { moveOwnedUseCase(element, oldIndex, newIndex); }			
			public void handleRemove(UseCase element) { removeFromOwnedUseCase(element); }
			public void navigateTo(UseCase element) { System.out.println("---> navigateTo"); }
		});
		this.ownedUseCase.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.ownedUseCase, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedUseCase, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToOwnedUseCase() {
	
		// Start of user code addToOwnedUseCase() method body
		
		
		UseCase eObject = UMLFactory.eINSTANCE.createUseCase();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				ownedUseCaseEditUtil.addElement(propertiesEditionObject);
				ownedUseCase.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedUseCase, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedUseCase, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editOwnedUseCase(UseCase element) {

		// Start of user code editOwnedUseCase() method body
				 
		EObject editedElement = ownedUseCaseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				ownedUseCaseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedUseCase.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedUseCase, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createUseCaseReferencesTable(FormToolkit widgetFactory, Composite parent) {	
		this.useCase = new ReferencesTable<UseCase>(UMLMessages.ArtifactPropertiesEditionPart_UseCaseLabel, new ReferencesTableListener<UseCase>() {
			public void handleAdd() {				
				ViewerFilter useCaseFilter = new EObjectFilter(UMLPackage.eINSTANCE.getUseCase());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!useCaseEditUtil.contains((EObject)element));
						return false;				
					}
				};				
				ViewerFilter[] filters = { useCaseFilter, viewerFilter };		
				TabElementTreeSelectionDialog<UseCase> dialog = new TabElementTreeSelectionDialog<UseCase>(resourceSet, filters, 
				"UseCase", UMLPackage.eINSTANCE.getUseCase()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!useCaseEditUtil.getVirtualList().contains(elem))
								useCaseEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.useCase,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));
						}
						useCase.refresh();												
					}
				};
				dialog.open();
			}
			public void handleEdit(UseCase element) { editUseCase(element); }
			public void handleMove(UseCase element, int oldIndex, int newIndex) { moveUseCase(element, oldIndex, newIndex); }
			public void handleRemove(UseCase element) { removeFromUseCase(element); }
			public void navigateTo(UseCase element) { System.out.println("---> navigateTo"); }
		});
		this.useCase.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.useCase, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.useCase, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));
	
		
	}
	
	/**
	 * 
	 */
	protected void removeFromUseCase(UseCase element) {

		// Start of user code for the removeFromUseCase() method body

		EObject editedElement = useCaseEditUtil.foundCorrespondingEObject(element);
		useCaseEditUtil.removeElement(element);
		useCase.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.useCase, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editUseCase(UseCase element) {

		// Start of user code editUseCase() method body
				 
		EObject editedElement = useCaseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				useCaseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				useCase.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.useCase, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	protected void createFileNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.ArtifactPropertiesEditionPart_FileNameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Artifact.fileName, UMLViewsRepository.FORM_KIND));
		fileName = widgetFactory.createText(parent, "");  //$NON-NLS-1$
		fileName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData fileNameData = new GridData(GridData.FILL_HORIZONTAL);
		fileName.setLayoutData(fileNameData);
		fileName.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.fileName, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, fileName.getText()));
			}
			
		});
		fileName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.fileName, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, fileName.getText()));
			}
			
		});
		fileName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.fileName, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, fileName.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.fileName, UMLViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param container
	 */
	protected void createNestedArtifactTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.nestedArtifact = new ReferencesTable<Artifact>(UMLMessages.ArtifactPropertiesEditionPart_NestedArtifactLabel, new ReferencesTableListener<Artifact>() {			
			public void handleAdd() { addToNestedArtifact();}
			public void handleEdit(Artifact element) { editNestedArtifact(element); }
			public void handleMove(Artifact element, int oldIndex, int newIndex) { moveNestedArtifact(element, oldIndex, newIndex); }			
			public void handleRemove(Artifact element) { removeFromNestedArtifact(element); }
			public void navigateTo(Artifact element) { System.out.println("---> navigateTo"); }
		});
		this.nestedArtifact.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.nestedArtifact, UMLViewsRepository.FORM_KIND));
		this.nestedArtifact.createControls(parent, widgetFactory);
		GridData nestedArtifactData = new GridData(GridData.FILL_HORIZONTAL);
		nestedArtifactData.horizontalSpan = 3;
		this.nestedArtifact.setLayoutData(nestedArtifactData);
	}
	
	/**
	 * 
	 */
	protected void moveNestedArtifact(Artifact element, int oldIndex, int newIndex) {
				
		EObject editedElement = nestedArtifactEditUtil.foundCorrespondingEObject(element);
		nestedArtifactEditUtil.moveElement(element, oldIndex, newIndex);
		nestedArtifact.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.nestedArtifact, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToNestedArtifact() {
	
		// Start of user code addToNestedArtifact() method body
		
		
		Artifact eObject = UMLFactory.eINSTANCE.createArtifact();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				nestedArtifactEditUtil.addElement(propertiesEditionObject);
				nestedArtifact.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.nestedArtifact, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		
			
		// End of user code		
	}

	/**
	 * 
	 */
	protected void removeFromNestedArtifact(Artifact element) {

		// Start of user code for the removeFromNestedArtifact() method body

		EObject editedElement = nestedArtifactEditUtil.foundCorrespondingEObject(element);
		nestedArtifactEditUtil.removeElement(element);
		nestedArtifact.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.nestedArtifact, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editNestedArtifact(Artifact element) {

		// Start of user code editNestedArtifact() method body
				 
		EObject editedElement = nestedArtifactEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				nestedArtifactEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				nestedArtifact.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.nestedArtifact, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createManifestationTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.manifestation = new ReferencesTable<Manifestation>(UMLMessages.ArtifactPropertiesEditionPart_ManifestationLabel, new ReferencesTableListener<Manifestation>() {			
			public void handleAdd() { addToManifestation();}
			public void handleEdit(Manifestation element) { editManifestation(element); }
			public void handleMove(Manifestation element, int oldIndex, int newIndex) { moveManifestation(element, oldIndex, newIndex); }			
			public void handleRemove(Manifestation element) { removeFromManifestation(element); }
			public void navigateTo(Manifestation element) { System.out.println("---> navigateTo"); }
		});
		this.manifestation.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.manifestation, UMLViewsRepository.FORM_KIND));
		this.manifestation.createControls(parent, widgetFactory);
		GridData manifestationData = new GridData(GridData.FILL_HORIZONTAL);
		manifestationData.horizontalSpan = 3;
		this.manifestation.setLayoutData(manifestationData);
	}
	
	/**
	 * 
	 */
	protected void moveManifestation(Manifestation element, int oldIndex, int newIndex) {
				
		EObject editedElement = manifestationEditUtil.foundCorrespondingEObject(element);
		manifestationEditUtil.moveElement(element, oldIndex, newIndex);
		manifestation.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.manifestation, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToManifestation() {
	
		// Start of user code addToManifestation() method body
		
		
		Manifestation eObject = UMLFactory.eINSTANCE.createManifestation();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				manifestationEditUtil.addElement(propertiesEditionObject);
				manifestation.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.manifestation, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		
			
		// End of user code		
	}

	/**
	 * 
	 */
	protected void removeFromManifestation(Manifestation element) {

		// Start of user code for the removeFromManifestation() method body

		EObject editedElement = manifestationEditUtil.foundCorrespondingEObject(element);
		manifestationEditUtil.removeElement(element);
		manifestation.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.manifestation, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editManifestation(Manifestation element) {

		// Start of user code editManifestation() method body
				 
		EObject editedElement = manifestationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				manifestationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				manifestation.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.manifestation, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createOwnedOperationTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedOperation = new ReferencesTable<Operation>(UMLMessages.ArtifactPropertiesEditionPart_OwnedOperationLabel, new ReferencesTableListener<Operation>() {			
			public void handleAdd() { addToOwnedOperation();}
			public void handleEdit(Operation element) { editOwnedOperation(element); }
			public void handleMove(Operation element, int oldIndex, int newIndex) { moveOwnedOperation(element, oldIndex, newIndex); }			
			public void handleRemove(Operation element) { removeFromOwnedOperation(element); }
			public void navigateTo(Operation element) { System.out.println("---> navigateTo"); }
		});
		this.ownedOperation.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.ownedOperation, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedOperation, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToOwnedOperation() {
	
		// Start of user code addToOwnedOperation() method body
		
		
		Operation eObject = UMLFactory.eINSTANCE.createOperation();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				ownedOperationEditUtil.addElement(propertiesEditionObject);
				ownedOperation.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedOperation, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedOperation, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editOwnedOperation(Operation element) {

		// Start of user code editOwnedOperation() method body
				 
		EObject editedElement = ownedOperationEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				ownedOperationEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedOperation.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedOperation, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createOwnedAttributeTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedAttribute = new ReferencesTable<Property>(UMLMessages.ArtifactPropertiesEditionPart_OwnedAttributeLabel, new ReferencesTableListener<Property>() {			
			public void handleAdd() { addToOwnedAttribute();}
			public void handleEdit(Property element) { editOwnedAttribute(element); }
			public void handleMove(Property element, int oldIndex, int newIndex) { moveOwnedAttribute(element, oldIndex, newIndex); }			
			public void handleRemove(Property element) { removeFromOwnedAttribute(element); }
			public void navigateTo(Property element) { System.out.println("---> navigateTo"); }
		});
		this.ownedAttribute.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Artifact.ownedAttribute, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedAttribute, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.MOVE, editedElement, newIndex));	
		
	}
	
	/**
	 * 
	 */
	protected void addToOwnedAttribute() {
	
		// Start of user code addToOwnedAttribute() method body
		
		
		Property eObject = UMLFactory.eINSTANCE.createProperty();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
			if (propertiesEditionObject != null) {
				ownedAttributeEditUtil.addElement(propertiesEditionObject);
				ownedAttribute.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedAttribute, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedAttribute, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editOwnedAttribute(Property element) {

		// Start of user code editOwnedAttribute() method body
				 
		EObject editedElement = ownedAttributeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				ownedAttributeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedAttribute.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(ArtifactPropertiesEditionPartForm.this, UMLViewsRepository.Artifact.ownedAttribute, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initOwnedComment(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			ownedCommentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			ownedCommentEditUtil = new EMFListEditUtil(current, feature);	
		this.ownedComment.setInput(ownedCommentEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateOwnedComment(EObject newValue)
	 */
	public void updateOwnedComment(EObject newValue) {
		if(ownedCommentEditUtil!=null){
			ownedCommentEditUtil.reinit(newValue);
			ownedComment.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.setSelection(new StructuredSelection(current));
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initClientDependency(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initClientDependency(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			clientDependencyEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			clientDependencyEditUtil = new EMFListEditUtil(current, feature);	
		this.clientDependency.setInput(clientDependencyEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateClientDependency(EObject newValue)
	 */
	public void updateClientDependency(EObject newValue) {
		if(clientDependencyEditUtil!=null){
			clientDependencyEditUtil.reinit(newValue);
			clientDependency.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getElementImportToAdd()
	 */
	public List getElementImportToAdd() {
		return elementImportEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getElementImportToRemove()
	 */
	public List getElementImportToRemove() {
		return elementImportEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getElementImportToEdit()
	 */
	public Map getElementImportToEdit() {
		return elementImportEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getElementImportToMove()
	 */
	public List getElementImportToMove() {
		return elementImportEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getElementImportTable()
	 */
	public List getElementImportTable() {
		return elementImportEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initElementImport(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initElementImport(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			elementImportEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			elementImportEditUtil = new EMFListEditUtil(current, feature);	
		this.elementImport.setInput(elementImportEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateElementImport(EObject newValue)
	 */
	public void updateElementImport(EObject newValue) {
		if(elementImportEditUtil!=null){
			elementImportEditUtil.reinit(newValue);
			elementImport.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getPackageImportToAdd()
	 */
	public List getPackageImportToAdd() {
		return packageImportEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getPackageImportToRemove()
	 */
	public List getPackageImportToRemove() {
		return packageImportEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getPackageImportToEdit()
	 */
	public Map getPackageImportToEdit() {
		return packageImportEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getPackageImportToMove()
	 */
	public List getPackageImportToMove() {
		return packageImportEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getPackageImportTable()
	 */
	public List getPackageImportTable() {
		return packageImportEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initPackageImport(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPackageImport(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			packageImportEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			packageImportEditUtil = new EMFListEditUtil(current, feature);	
		this.packageImport.setInput(packageImportEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updatePackageImport(EObject newValue)
	 */
	public void updatePackageImport(EObject newValue) {
		if(packageImportEditUtil!=null){
			packageImportEditUtil.reinit(newValue);
			packageImport.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedRuleToAdd()
	 */
	public List getOwnedRuleToAdd() {
		return ownedRuleEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedRuleToRemove()
	 */
	public List getOwnedRuleToRemove() {
		return ownedRuleEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedRuleToEdit()
	 */
	public Map getOwnedRuleToEdit() {
		return ownedRuleEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedRuleToMove()
	 */
	public List getOwnedRuleToMove() {
		return ownedRuleEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedRuleTable()
	 */
	public List getOwnedRuleTable() {
		return ownedRuleEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initOwnedRule(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedRule(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			ownedRuleEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			ownedRuleEditUtil = new EMFListEditUtil(current, feature);	
		this.ownedRule.setInput(ownedRuleEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateOwnedRule(EObject newValue)
	 */
	public void updateOwnedRule(EObject newValue) {
		if(ownedRuleEditUtil!=null){
			ownedRuleEditUtil.reinit(newValue);
			ownedRule.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#setIsLeaf(Boolean newValue)
	 */
	public void setIsLeaf(Boolean newValue) {
		isLeaf.setSelection(newValue.booleanValue());
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getTemplateBindingToAdd()
	 */
	public List getTemplateBindingToAdd() {
		return templateBindingEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getTemplateBindingToRemove()
	 */
	public List getTemplateBindingToRemove() {
		return templateBindingEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getTemplateBindingToEdit()
	 */
	public Map getTemplateBindingToEdit() {
		return templateBindingEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getTemplateBindingToMove()
	 */
	public List getTemplateBindingToMove() {
		return templateBindingEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getTemplateBindingTable()
	 */
	public List getTemplateBindingTable() {
		return templateBindingEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initTemplateBinding(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTemplateBinding(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			templateBindingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			templateBindingEditUtil = new EMFListEditUtil(current, feature);	
		this.templateBinding.setInput(templateBindingEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateTemplateBinding(EObject newValue)
	 */
	public void updateTemplateBinding(EObject newValue) {
		if(templateBindingEditUtil!=null){
			templateBindingEditUtil.reinit(newValue);
			templateBinding.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getIsAbstract()
	 */
	public Boolean getIsAbstract() {
		return Boolean.valueOf(isAbstract.getSelection());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#setIsAbstract(Boolean newValue)
	 */
	public void setIsAbstract(Boolean newValue) {
		isAbstract.setSelection(newValue.booleanValue());
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getGeneralizationToAdd()
	 */
	public List getGeneralizationToAdd() {
		return generalizationEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getGeneralizationToRemove()
	 */
	public List getGeneralizationToRemove() {
		return generalizationEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getGeneralizationToEdit()
	 */
	public Map getGeneralizationToEdit() {
		return generalizationEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getGeneralizationToMove()
	 */
	public List getGeneralizationToMove() {
		return generalizationEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getGeneralizationTable()
	 */
	public List getGeneralizationTable() {
		return generalizationEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initGeneralization(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initGeneralization(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			generalizationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			generalizationEditUtil = new EMFListEditUtil(current, feature);	
		this.generalization.setInput(generalizationEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateGeneralization(EObject newValue)
	 */
	public void updateGeneralization(EObject newValue) {
		if(generalizationEditUtil!=null){
			generalizationEditUtil.reinit(newValue);
			generalization.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getPowertypeExtentToAdd()
	 */
	public List getPowertypeExtentToAdd() {
		return powertypeExtentEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getPowertypeExtentToRemove()
	 */
	public List getPowertypeExtentToRemove() {
		return powertypeExtentEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initPowertypeExtent(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPowertypeExtent(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			powertypeExtentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			powertypeExtentEditUtil = new EMFListEditUtil(current, feature);	
		this.powertypeExtent.setInput(powertypeExtentEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updatePowertypeExtent(EObject newValue)
	 */
	public void updatePowertypeExtent(EObject newValue) {
		if(powertypeExtentEditUtil!=null){
			powertypeExtentEditUtil.reinit(newValue);
			powertypeExtent.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getRedefinedClassifierToAdd()
	 */
	public List getRedefinedClassifierToAdd() {
		return redefinedClassifierEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getRedefinedClassifierToRemove()
	 */
	public List getRedefinedClassifierToRemove() {
		return redefinedClassifierEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initRedefinedClassifier(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRedefinedClassifier(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			redefinedClassifierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			redefinedClassifierEditUtil = new EMFListEditUtil(current, feature);	
		this.redefinedClassifier.setInput(redefinedClassifierEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateRedefinedClassifier(EObject newValue)
	 */
	public void updateRedefinedClassifier(EObject newValue) {
		if(redefinedClassifierEditUtil!=null){
			redefinedClassifierEditUtil.reinit(newValue);
			redefinedClassifier.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getSubstitutionToAdd()
	 */
	public List getSubstitutionToAdd() {
		return substitutionEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getSubstitutionToRemove()
	 */
	public List getSubstitutionToRemove() {
		return substitutionEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getSubstitutionToEdit()
	 */
	public Map getSubstitutionToEdit() {
		return substitutionEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getSubstitutionToMove()
	 */
	public List getSubstitutionToMove() {
		return substitutionEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getSubstitutionTable()
	 */
	public List getSubstitutionTable() {
		return substitutionEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initSubstitution(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSubstitution(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			substitutionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			substitutionEditUtil = new EMFListEditUtil(current, feature);	
		this.substitution.setInput(substitutionEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateSubstitution(EObject newValue)
	 */
	public void updateSubstitution(EObject newValue) {
		if(substitutionEditUtil!=null){
			substitutionEditUtil.reinit(newValue);
			substitution.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getCollaborationUseToAdd()
	 */
	public List getCollaborationUseToAdd() {
		return collaborationUseEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getCollaborationUseToRemove()
	 */
	public List getCollaborationUseToRemove() {
		return collaborationUseEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getCollaborationUseToEdit()
	 */
	public Map getCollaborationUseToEdit() {
		return collaborationUseEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getCollaborationUseToMove()
	 */
	public List getCollaborationUseToMove() {
		return collaborationUseEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getCollaborationUseTable()
	 */
	public List getCollaborationUseTable() {
		return collaborationUseEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initCollaborationUse(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initCollaborationUse(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			collaborationUseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			collaborationUseEditUtil = new EMFListEditUtil(current, feature);	
		this.collaborationUse.setInput(collaborationUseEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateCollaborationUse(EObject newValue)
	 */
	public void updateCollaborationUse(EObject newValue) {
		if(collaborationUseEditUtil!=null){
			collaborationUseEditUtil.reinit(newValue);
			collaborationUse.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedUseCaseToAdd()
	 */
	public List getOwnedUseCaseToAdd() {
		return ownedUseCaseEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedUseCaseToRemove()
	 */
	public List getOwnedUseCaseToRemove() {
		return ownedUseCaseEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedUseCaseToEdit()
	 */
	public Map getOwnedUseCaseToEdit() {
		return ownedUseCaseEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedUseCaseToMove()
	 */
	public List getOwnedUseCaseToMove() {
		return ownedUseCaseEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedUseCaseTable()
	 */
	public List getOwnedUseCaseTable() {
		return ownedUseCaseEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initOwnedUseCase(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedUseCase(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			ownedUseCaseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			ownedUseCaseEditUtil = new EMFListEditUtil(current, feature);	
		this.ownedUseCase.setInput(ownedUseCaseEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateOwnedUseCase(EObject newValue)
	 */
	public void updateOwnedUseCase(EObject newValue) {
		if(ownedUseCaseEditUtil!=null){
			ownedUseCaseEditUtil.reinit(newValue);
			ownedUseCase.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getUseCaseToAdd()
	 */
	public List getUseCaseToAdd() {
		return useCaseEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getUseCaseToRemove()
	 */
	public List getUseCaseToRemove() {
		return useCaseEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initUseCase(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initUseCase(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			useCaseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			useCaseEditUtil = new EMFListEditUtil(current, feature);	
		this.useCase.setInput(useCaseEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateUseCase(EObject newValue)
	 */
	public void updateUseCase(EObject newValue) {
		if(useCaseEditUtil!=null){
			useCaseEditUtil.reinit(newValue);
			useCase.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getFileName()
	 */
	public String getFileName() {
		return fileName.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#setFileName(String newValue)
	 */
	public void setFileName(String newValue) {
		fileName.setText(newValue);
	}
	
	public void setMessageForFileName (String msg, int msgLevel) {
	messageManager.addMessage("FileName_key", msg, null, msgLevel, fileName);
}	
	
			public void unsetMessageForFileName () {
			messageManager.removeMessage("FileName_key", fileName);
		}	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getNestedArtifactToAdd()
	 */
	public List getNestedArtifactToAdd() {
		return nestedArtifactEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getNestedArtifactToRemove()
	 */
	public List getNestedArtifactToRemove() {
		return nestedArtifactEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getNestedArtifactToEdit()
	 */
	public Map getNestedArtifactToEdit() {
		return nestedArtifactEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getNestedArtifactToMove()
	 */
	public List getNestedArtifactToMove() {
		return nestedArtifactEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getNestedArtifactTable()
	 */
	public List getNestedArtifactTable() {
		return nestedArtifactEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initNestedArtifact(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initNestedArtifact(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			nestedArtifactEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			nestedArtifactEditUtil = new EMFListEditUtil(current, feature);	
		this.nestedArtifact.setInput(nestedArtifactEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateNestedArtifact(EObject newValue)
	 */
	public void updateNestedArtifact(EObject newValue) {
		if(nestedArtifactEditUtil!=null){
			nestedArtifactEditUtil.reinit(newValue);
			nestedArtifact.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getManifestationToAdd()
	 */
	public List getManifestationToAdd() {
		return manifestationEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getManifestationToRemove()
	 */
	public List getManifestationToRemove() {
		return manifestationEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getManifestationToEdit()
	 */
	public Map getManifestationToEdit() {
		return manifestationEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getManifestationToMove()
	 */
	public List getManifestationToMove() {
		return manifestationEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getManifestationTable()
	 */
	public List getManifestationTable() {
		return manifestationEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initManifestation(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initManifestation(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			manifestationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			manifestationEditUtil = new EMFListEditUtil(current, feature);	
		this.manifestation.setInput(manifestationEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateManifestation(EObject newValue)
	 */
	public void updateManifestation(EObject newValue) {
		if(manifestationEditUtil!=null){
			manifestationEditUtil.reinit(newValue);
			manifestation.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedOperationToAdd()
	 */
	public List getOwnedOperationToAdd() {
		return ownedOperationEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedOperationToRemove()
	 */
	public List getOwnedOperationToRemove() {
		return ownedOperationEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedOperationToEdit()
	 */
	public Map getOwnedOperationToEdit() {
		return ownedOperationEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedOperationToMove()
	 */
	public List getOwnedOperationToMove() {
		return ownedOperationEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedOperationTable()
	 */
	public List getOwnedOperationTable() {
		return ownedOperationEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initOwnedOperation(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedOperation(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			ownedOperationEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			ownedOperationEditUtil = new EMFListEditUtil(current, feature);	
		this.ownedOperation.setInput(ownedOperationEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateOwnedOperation(EObject newValue)
	 */
	public void updateOwnedOperation(EObject newValue) {
		if(ownedOperationEditUtil!=null){
			ownedOperationEditUtil.reinit(newValue);
			ownedOperation.refresh();
		}		
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedAttributeToAdd()
	 */
	public List getOwnedAttributeToAdd() {
		return ownedAttributeEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedAttributeToRemove()
	 */
	public List getOwnedAttributeToRemove() {
		return ownedAttributeEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedAttributeToEdit()
	 */
	public Map getOwnedAttributeToEdit() {
		return ownedAttributeEditUtil.getElementsToRefresh();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedAttributeToMove()
	 */
	public List getOwnedAttributeToMove() {
		return ownedAttributeEditUtil.getElementsToMove();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#getOwnedAttributeTable()
	 */
	public List getOwnedAttributeTable() {
		return ownedAttributeEditUtil.getVirtualList();
	};
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#initOwnedAttribute(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedAttribute(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			ownedAttributeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			ownedAttributeEditUtil = new EMFListEditUtil(current, feature);	
		this.ownedAttribute.setInput(ownedAttributeEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ArtifactPropertiesEditionPart#updateOwnedAttribute(EObject newValue)
	 */
	public void updateOwnedAttribute(EObject newValue) {
		if(ownedAttributeEditUtil!=null){
			ownedAttributeEditUtil.reinit(newValue);
			ownedAttribute.refresh();
		}		
	}
	
	
	
	







	
	// Start of user code additional methods
 	
	// End of user code
}	
