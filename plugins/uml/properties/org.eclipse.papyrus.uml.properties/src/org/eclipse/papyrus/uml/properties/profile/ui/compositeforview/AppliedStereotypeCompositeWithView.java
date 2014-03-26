/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositeforview;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.infra.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This Composite allows displaying applied stereotypes from the model, but allows also displaying it in the associated view.
 */
public class AppliedStereotypeCompositeWithView extends org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppliedStereotypeCompositeOnModel implements IViewComposite {

	/**
	 * The selection.
	 */
	protected ISelection selection;

	/**
	 * The property composite.
	 */
	protected MultipleReferenceEditor propertyComposite;

	private EModelElement diagramElement;

	private ISelectionChangedListener propertySelectionChangeListener;

	/**
	 * The Constructor.
	 *
	 * @param parent
	 *        the parent
	 */
	public AppliedStereotypeCompositeWithView(Composite parent) {
		super(parent);
		this.setBackground(JFaceColors.getBannerBackground(parent.getDisplay()));
	}

	/**
	 * Creates the content.
	 *
	 * @param parent
	 *        the parent
	 * @param factory
	 *        the factory
	 *
	 * @return the composite
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);

		// Replace label and content providers in treeViewers
		treeViewer.setContentProvider(new ProfileElementWithDisplayContentProvider(diagramElement));
		treeViewer.setLabelProvider(new ProfileElementWithDisplayLabelProvider());

		refresh();
		return this;
	}

	/**
	 * Sets the selection.
	 *
	 * @param selection
	 *        the selection
	 */
	public void setSelection(ISelection selection) {
		this.selection = selection;
	}

	/**
	 * Sets the diagram element.
	 *
	 * @param diagramElement
	 *        the diagram element
	 */
	public void setDiagramElement(EModelElement diagramElement) {
		this.diagramElement = diagramElement;
		((ProfileElementWithDisplayContentProvider)treeViewer.getContentProvider()).setDiagramElement(diagramElement);
	}

	/**
	 * Sets the property composite associated to this stereotype composite
	 *
	 * @param propertyComposite
	 *        the composite associated to this stereotype composite used for stereotype property display.
	 */
	public void setPropertySelectionChangeListener(ISelectionChangedListener propertySelectionChangeListener) {
		this.propertySelectionChangeListener = propertySelectionChangeListener;
	}

	/**
	 * Gets the selected.
	 *
	 * @return the selected
	 * @deprecated
	 */
	@Deprecated
	@Override
	public Element getSelected() {
		return getElement();
	}

	/**
	 * Adds the button pressed.
	 */
	@Override
	public void addButtonPressed() {
		super.addButtonPressed();
	}





	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.papyrus.profile.ui.composites.StereotypeComposite#removeButtonPressed()
	 */
	@Override
	public void removeButtonPressed() {
		superRemoveButton();
	}

	/**
	 * Calls super method
	 */
	private void superRemoveButton() {
		super.removeButtonPressed();
	}

	/**
	 * Selection changed.
	 *
	 * @param event
	 *        the event
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		propertySelectionChangeListener.selectionChanged(event);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppliedStereotypeCompositeOnModel#getApplyStereotypeCommmand(org.eclipse.uml2.uml.Element,
	 *      org.eclipse.uml2.uml.Stereotype, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 *
	 * @param elt
	 * @param st
	 * @param domain
	 * @return
	 */
	@Override
	protected Command getApplyStereotypeCommmand(Element elt, Stereotype st, TransactionalEditingDomain domain) {
		CompoundCommand compoundCommand = new CompoundCommand("applyStereotypeCommand");

		Command parentCommmand = super.getApplyStereotypeCommmand(elt, st, domain);
		compoundCommand.append(parentCommmand);

		//Fix regression / Bug 431258
		//The graphical element is not necessarily available (e.g. Selection in ModelExplorer)
		if(diagramElement != null) {
			String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);
			RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypeCommand(domain, diagramElement, st.getQualifiedName(), presentationKind);

			compoundCommand.append(command);
		}

		return parentCommmand;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppliedStereotypeCompositeOnModel#getUnapplyStereotypeCommand(org.eclipse.uml2.uml.Element,
	 *      org.eclipse.uml2.uml.Stereotype, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 *
	 * @param elt
	 * @param st
	 * @param domain
	 * @return
	 */
	@Override
	protected Command getUnapplyStereotypeCommand(Element elt, Stereotype st, TransactionalEditingDomain domain) {
		CompoundCommand compoundCommand = new CompoundCommand("UnapplyStereotypeCommand");

		Command parentCommand = super.getUnapplyStereotypeCommand(elt, st, domain);
		compoundCommand.append(parentCommand);

		//Fix regression / Bug 431258
		//The graphical element is not necessarily available (e.g. Selection in ModelExplorer)
		if(diagramElement != null) {
			String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);
			RecordingCommand command = AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(domain, diagramElement, st.getQualifiedName(), presentationKind);
			compoundCommand.append(command);
		}

		return compoundCommand;
	}
}
