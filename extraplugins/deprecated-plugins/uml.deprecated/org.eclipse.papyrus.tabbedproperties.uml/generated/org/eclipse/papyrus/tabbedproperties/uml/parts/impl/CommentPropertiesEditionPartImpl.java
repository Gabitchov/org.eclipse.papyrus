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
package org.eclipse.papyrus.tabbedproperties.uml.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CommentPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CommentPropertiesEditionPart {

	protected Text body;

	protected EMFListEditUtil annotatedElementEditUtil;

	protected ReferencesTable<? extends EObject> annotatedElement;

	protected List<ViewerFilter> annotatedElementBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> annotatedElementFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public CommentPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart# createFigure(org.eclipse.swt.widgets.Composite)
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);

		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart# createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) {
		createGeneralGroup(view);

		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createGeneralGroup(Composite parent) {
		Group generalGroup = new Group(parent, SWT.NONE);
		generalGroup.setText(UMLMessages.CommentPropertiesEditionPart_GeneralGroupLabel);
		GridData generalGroupData = new GridData(GridData.FILL_HORIZONTAL);
		generalGroupData.horizontalSpan = 3;
		generalGroup.setLayoutData(generalGroupData);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createBodyTextarea(generalGroup);
		createAnnotatedElementAdvancedReferencesTable(generalGroup);
	}

	protected void createBodyTextarea(Composite parent) {
		Label bodyLabel = SWTUtils.createPartLabel(parent, UMLMessages.CommentPropertiesEditionPart_BodyLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.Comment.body, UMLViewsRepository.SWT_KIND));
		GridData bodyLabelData = new GridData(GridData.FILL_HORIZONTAL);
		bodyLabelData.horizontalSpan = 3;
		bodyLabel.setLayoutData(bodyLabelData);
		body = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData bodyData = new GridData(GridData.FILL_HORIZONTAL);
		bodyData.horizontalSpan = 2;
		bodyData.heightHint = 80;
		body.setLayoutData(bodyData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.Comment.body, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createAnnotatedElementAdvancedReferencesTable(Composite parent) {
		this.annotatedElement = new ReferencesTable<Element>(UMLMessages.CommentPropertiesEditionPart_AnnotatedElementLabel, new ReferencesTableListener<Element>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Element> dialog = new TabElementTreeSelectionDialog<Element>(resourceSet, annotatedElementFilters, annotatedElementBusinessFilters,
						"Element", UMLPackage.eINSTANCE.getElement(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!annotatedElementEditUtil.getVirtualList().contains(elem))
								annotatedElementEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommentPropertiesEditionPartImpl.this, UMLViewsRepository.Comment.annotatedElement,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						annotatedElement.refresh();
					}

				};
				dialog.open();
			}

			public void handleEdit(Element element) {
				editAnnotatedElement(element);
			}

			public void handleMove(Element element, int oldIndex, int newIndex) {
				moveAnnotatedElement(element, oldIndex, newIndex);
			}

			public void handleRemove(Element element) {
				removeFromAnnotatedElement(element);
			}

			public void navigateTo(Element element) {
			}
		});
		this.annotatedElement.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Comment.annotatedElement, UMLViewsRepository.SWT_KIND));
		this.annotatedElement.createControls(parent);
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

		// Start of user code removeFromAnnotatedElement() method body
		EObject editedElement = annotatedElementEditUtil.foundCorrespondingEObject(element);
		annotatedElementEditUtil.removeElement(element);
		annotatedElement.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				CommentPropertiesEditionPartImpl.this, UMLViewsRepository.Comment.annotatedElement,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editAnnotatedElement(Element element) {

		// Start of user code editAnnotatedElement() method body
		EObject editedElement = annotatedElementEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				annotatedElementEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				annotatedElement.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						CommentPropertiesEditionPartImpl.this, UMLViewsRepository.Comment.annotatedElement,
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
		if(newValue != null) {
			body.setText(newValue);
		} else {
			body.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForBody(String msg, int msgLevel) {

	}

	public void unsetMessageForBody() {

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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#getAnnotatedElementTable()
	 */
	public List getAnnotatedElementTable() {
		return annotatedElementEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#initAnnotatedElement(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initAnnotatedElement(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
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
		if(annotatedElementEditUtil != null) {
			annotatedElementEditUtil.reinit(newValue);
			annotatedElement.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#addFilterAnnotatedElement(ViewerFilter filter)
	 */
	public void addFilterToAnnotatedElement(ViewerFilter filter) {
		annotatedElementFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#addBusinessFilterAnnotatedElement(ViewerFilter filter)
	 */
	public void addBusinessFilterToAnnotatedElement(ViewerFilter filter) {
		annotatedElementBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.CommentPropertiesEditionPart#isContainedInAnnotatedElementTable(EObject element)
	 */
	public boolean isContainedInAnnotatedElementTable(EObject element) {
		return annotatedElementEditUtil.contains(element);
	}

	public void setMessageForAnnotatedElement(String msg, int msgLevel) {

	}

	public void unsetMessageForAnnotatedElement() {

	}





	// Start of user code additional methods

	// End of user code

}
