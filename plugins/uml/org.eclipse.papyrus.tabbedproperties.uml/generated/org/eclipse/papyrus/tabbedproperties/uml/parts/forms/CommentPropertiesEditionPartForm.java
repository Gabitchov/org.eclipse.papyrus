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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CommentPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, CommentPropertiesEditionPart {

	private Text body;
	private EMFListEditUtil annotatedElementEditUtil;
	private ReferencesTable<?> annotatedElement;




	
	public CommentPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		generalSection.setText(UMLMessages.CommentPropertiesEditionPart_GeneralGroupLabel);
		GridData generalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		generalSectionData.horizontalSpan = 3;
		generalSection.setLayoutData(generalSectionData);
		Composite generalGroup = widgetFactory.createComposite(generalSection);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createBodyTextarea(widgetFactory, generalGroup);
		createAnnotatedElementReferencesTable(widgetFactory, generalGroup);
		generalSection.setClient(generalGroup);
	}   		
	protected void createBodyTextarea(FormToolkit widgetFactory, Composite parent) {
		Label bodyLabel = FormUtils.createPartLabel(widgetFactory, parent, UMLMessages.CommentPropertiesEditionPart_BodyLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Comment.body, UMLViewsRepository.FORM_KIND));
		GridData bodyLabelData = new GridData(GridData.FILL_HORIZONTAL);
		bodyLabelData.horizontalSpan = 3;
		bodyLabel.setLayoutData(bodyLabelData);
		body = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI); //$NON-NLS-1$
		GridData bodyData = new GridData(GridData.FILL_HORIZONTAL);
		bodyData.horizontalSpan = 3;
		bodyData.heightHint = 80;
		body.setLayoutData(bodyData);		
		body.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(CommentPropertiesEditionPartForm.this, UMLViewsRepository.Comment.body, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, body.getText()));
			}
			
		});
		body.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(CommentPropertiesEditionPartForm.this, UMLViewsRepository.Comment.body, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, body.getText()));
				}
			}
			
		});
	}
	protected void createAnnotatedElementReferencesTable(FormToolkit widgetFactory, Composite parent) {	
		this.annotatedElement = new ReferencesTable<Element>(UMLMessages.CommentPropertiesEditionPart_AnnotatedElementLabel, new ReferencesTableListener<Element>() {
			public void handleAdd() {				
				ViewerFilter annotatedElementFilter = new EObjectFilter(UMLPackage.eINSTANCE.getElement());
				ViewerFilter viewerFilter = new ViewerFilter() {					
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!annotatedElementEditUtil.contains((EObject)element));
						return false;				
					}
				};				
				ViewerFilter[] filters = { annotatedElementFilter, viewerFilter };		
				TabElementTreeSelectionDialog<Element> dialog = new TabElementTreeSelectionDialog<Element>(resourceSet, filters, 
				"Element", UMLPackage.eINSTANCE.getElement()) {
					@Override
					public void process(IStructuredSelection selection) {						
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!annotatedElementEditUtil.getVirtualList().contains(elem))
								annotatedElementEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(CommentPropertiesEditionPartForm.this, UMLViewsRepository.Comment.annotatedElement,
								PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, elem));
						}
						annotatedElement.refresh();												
					}
				};
				dialog.open();
			}
			public void handleEdit(Element element) { editAnnotatedElement(element); }
			public void handleMove(Element element, int oldIndex, int newIndex) { moveAnnotatedElement(element, oldIndex, newIndex); }
			public void handleRemove(Element element) { removeFromAnnotatedElement(element); }
			public void navigateTo(Element element) { System.out.println("---> navigateTo"); }
		});
		this.annotatedElement.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Comment.annotatedElement, UMLViewsRepository.FORM_KIND));
		this.annotatedElement.createControls(parent, widgetFactory);
		GridData annotatedElementData = new GridData(GridData.FILL_HORIZONTAL);
		annotatedElementData.horizontalSpan = 3;
		this.annotatedElement.setLayoutData(annotatedElementData);
		this.annotatedElement.disableMove();
	}
	
	/**
	 * 
	 */
	protected void moveAnnotatedElement(Element element, int oldIndex, int newIndex) {
	}
	
	/**
	 * 
	 */
	protected void removeFromAnnotatedElement(Element element) {

		// Start of user code for the removeFromAnnotatedElement() method body

		EObject editedElement = annotatedElementEditUtil.foundCorrespondingEObject(element);
		annotatedElementEditUtil.removeElement(element);
		annotatedElement.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(CommentPropertiesEditionPartForm.this, UMLViewsRepository.Comment.annotatedElement, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	protected void editAnnotatedElement(Element element) {

		// Start of user code editAnnotatedElement() method body
				 
		EObject editedElement = annotatedElementEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				annotatedElementEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				annotatedElement.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(CommentPropertiesEditionPartForm.this, UMLViewsRepository.Comment.annotatedElement, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#getBody()
	 */
	public String getBody() {
		return body.getText();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#setBody(String newValue)
	 */
	public void setBody(String newValue) {
		body.setText(newValue);
	}
	
	public void setMessageForBody (String msg, int msgLevel) {
	messageManager.addMessage("Body_key", msg, null, msgLevel, body);
}	
	
			public void unsetMessageForBody () {
			messageManager.removeMessage("Body_key", body);
		}	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#getAnnotatedElementToAdd()
	 */
	public List getAnnotatedElementToAdd() {
		return annotatedElementEditUtil.getElementsToAdd();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#getAnnotatedElementToRemove()
	 */
	public List getAnnotatedElementToRemove() {
		return annotatedElementEditUtil.getElementsToRemove();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#initAnnotatedElement(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAnnotatedElement(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			annotatedElementEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else	
			annotatedElementEditUtil = new EMFListEditUtil(current, feature);	
		this.annotatedElement.setInput(annotatedElementEditUtil.getVirtualList());
	}

/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#updateAnnotatedElement(EObject newValue)
	 */
	public void updateAnnotatedElement(EObject newValue) {
		if(annotatedElementEditUtil!=null){
			annotatedElementEditUtil.reinit(newValue);
			annotatedElement.refresh();
		}		
	}
	
	
	
	







	
	// Start of user code additional methods
 	
	// End of user code
}	
