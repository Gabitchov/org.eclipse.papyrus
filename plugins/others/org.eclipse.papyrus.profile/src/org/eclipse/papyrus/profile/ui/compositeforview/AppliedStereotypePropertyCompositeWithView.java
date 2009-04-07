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
package org.eclipse.papyrus.profile.ui.compositeforview;

import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.papyrus.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyComposite.
 */
public class AppliedStereotypePropertyCompositeWithView extends org.eclipse.papyrus.profile.ui.compositesformodel.PropertyComposite {

	/**
	 * The stereotype composite.
	 */
	protected AppliedStereotypeCompositeWithView stereotypeComposite;

	/**
	 * The Constructor.
	 * 
	 * @param stereotypeComposite
	 *            the stereotype composite
	 * @param parent
	 *            the parent
	 */
	public AppliedStereotypePropertyCompositeWithView(Composite parent, AppliedStereotypeCompositeWithView stereotypeComposite) {
		super(parent);

		this.setBackground(JFaceColors.getBannerBackground(parent.getDisplay()));
		this.stereotypeComposite = stereotypeComposite;
	}

	/**
	 * Touch model.
	 */
	protected void touchModel() {
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) treeViewer.getInput();
		Element stereotypedElement = pTO.getParent().getParent().getElement();
		if (stereotypedElement instanceof NamedElement) {
			((NamedElement) stereotypedElement).setName(((NamedElement) stereotypedElement).getName());
		}
	}

	/**
	 * Adds the button pressed.
	 */
	@Override
	public void addButtonPressed() {
		super.addButtonPressed();
		stereotypeComposite.refresh();
		touchModel();
	}

	/**
	 * Removes the button pressed.
	 */
	@Override
	public void removeButtonPressed() {
		super.removeButtonPressed();
		stereotypeComposite.refresh();
		touchModel();
	}

	/**
	 * Up button pressed.
	 */
	@Override
	public void upButtonPressed() {
		super.upButtonPressed();
		stereotypeComposite.refresh();
		touchModel();
	}

	/**
	 * Down button pressed.
	 */
	@Override
	public void downButtonPressed() {
		super.downButtonPressed();
		stereotypeComposite.refresh();
		touchModel();
	}

	/**
	 * Creates the prop tree.
	 */
	@Override
	protected void createPropTree() {
		super.createPropTree();
		getTree().addListener(SWT.MouseDoubleClick, new StereotypePropertiesDoubleClickListener(getParent(), treeViewer, stereotypeComposite, this));
	}

	/**
	 * Sets the stereotype composite.
	 * 
	 * @param stereotypeComposite
	 *            the stereotype composite
	 */
	public void setStereotypeComposite(AppliedStereotypeCompositeWithView stereotypeComposite) {
		this.stereotypeComposite = stereotypeComposite;
	}

	/**
	 * 
	 */
	public void disposeListeners() {
		super.disposeListeners();
		stereotypeComposite.disposeListeners();
	}
}
