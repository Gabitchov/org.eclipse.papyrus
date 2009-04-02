/*******************************************************************************
 * Copyright (c) 2008 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.ui.compositeforview;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.editparts.IUMLEditPart;
import org.eclipse.papyrus.profile.ImageManager;
import org.eclipse.papyrus.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.profile.ui.compositesformodel.DecoratedTreeComposite;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class AppearanceStereotypeComposite manages the display of stereotype properties from appearance tab.
 */
public class AppearanceForAppliedStereotypeComposite extends org.eclipse.papyrus.profile.ui.compositesformodel.AppearanceStereotypeComposite {

	/**
	 * The selection.
	 */
	protected ISelection selection;

	/**
	 * The diagram element.
	 */
	protected EModelElement diagramElement = null;

	/**
	 * button that displays the element.
	 */
	protected Button displayButton;

	/**
	 * Listener for the display button.
	 */
	protected MouseListener displayButtonListener;

	private TransactionalEditingDomain domain;

	/**
	 * The Constant IMG_DISPLAY.
	 */
	private static final Image IMG_DISPLAY = Activator.getImage(Activator.DEFAULT_IMAGE + "ConsoleView_16x16.gif");

	/**
	 * The Constructor.
	 * 
	 * @param parent
	 *            the parent
	 */
	public AppearanceForAppliedStereotypeComposite(Composite parent, TransactionalEditingDomain domain) {
		super(parent);
		this.setBackground(JFaceColors.getBannerBackground(parent.getDisplay()));
		this.displayButtonListener = new DisplayButtonListener();
		this.domain = domain;
	}

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *            the parent
	 * @param factory
	 *            the factory
	 * 
	 * @return the composite
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);

		FormData data;
		displayButton = factory.createButton(this, "", SWT.PUSH);
		displayButton.setVisible(true);
		displayButton.setImage(IMG_DISPLAY);
		displayButton.setToolTipText("Display selected stereotype for the element in the diagram");
		data = new FormData();
		// data.top = new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		displayButton.setLayoutData(data);
		displayButton.addMouseListener(displayButtonListener);

		// Create label
		label = factory.createCLabel(this, name + ":", SWT.NONE);
		label.setLayout(new FormLayout());
		data = new FormData();
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(displayButton, -ITabbedPropertyConstants.HSPACE - 30);
		data.top = new FormAttachment(0, 0);
		label.setLayoutData(data);

		// Create and place Table
		tree = treeViewer.getTree();
		tree.setLayout(new FormLayout());
		tree.setVisible(true);

		data = new FormData();
		data.top = new FormAttachment(displayButton, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);

		tree.setLayoutData(data);

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
	 *            the selection
	 */
	public void setSelection(ISelection selection) {
		this.selection = selection;
	}

	/**
	 * Sets the diagram element.
	 * 
	 * @param diagramElement
	 *            the diagram element
	 */
	public void setDiagramElement(EModelElement diagramElement) {
		this.diagramElement = diagramElement;
		((ProfileElementWithDisplayContentProvider) treeViewer.getContentProvider()).setDiagramElement(diagramElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public void refresh() {
		super.refresh();
		if ((diagramElement == null) && (!displayButton.isDisposed())) {
			displayButton.setEnabled(false);
			displayButton.setToolTipText("Stereotypes can only be displayed for elements with graphical representation. " + "Currently edited element is a non graphical element. "
					+ "(example: an element selected in the outline is not a graphical element)");
		} else {
			// button should be enabled only if a stereotype is selected, but it requires a listener on the tree selection
			displayButton.setEnabled(true);
			displayButton.setToolTipText("Display selected stereotype for the currently selected element in the diagram");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Element getSelected() {
		Object input = ((IStructuredSelection) selection).getFirstElement();
		if (input instanceof IUMLEditPart) {
			return ((IUMLEditPart) input).getUMLElement();
		} else {
			return null;
		}
	}

	private IUMLEditPart getSelectedEditPart() {
		Object input = ((IStructuredSelection) selection).getFirstElement();
		if (input instanceof IUMLEditPart) {
			return (IUMLEditPart) input;

		} else {
			return null;
		}
	}

	/**
	 * Touch model.
	 * 
	 * @param elt
	 *            the elt
	 */
	protected void touchModel(Element elt) {
		if (elt instanceof NamedElement) {
			((NamedElement) elt).setName(((NamedElement) elt).getName());
		} else {
			if (elt.getNearestPackage() != null) {
				elt.getNearestPackage().setName(elt.getNearestPackage().getName());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		if (event == null) {
			return;
		}
	}

	/**
	 * Display button pressed.
	 */
	public void displayButtonPressed() {
		// If nothing selected : abort
		if (getTree().getSelection().length < 1) {
			return;
		}

		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (getDiagramElement() == null) {
			return;
		}

		TreeItem[] treeSelection = getTree().getSelection();
		for (int i = 0; i < treeSelection.length; i++) {
			// stereotypesTree.getSelection()[0]
			if (treeSelection[i].getData() instanceof AppliedStereotypeTreeObject) {
				Stereotype stereo = ((AppliedStereotypeTreeObject) treeSelection[i].getData()).getStereotype();

				if (treeSelection[i].getImage().equals(ImageManager.IMG_STEREOTYPE)) {
					addStereotypeDisplay(stereo);
				} else {
					// if we remove the stereotype we have to remove its properties also
					removeStereotypePropertiesDisplay(stereo);
					removeStereotypeDisplay(stereo);
				}
			}

			else if (treeSelection[i].getData() instanceof AppliedStereotypePropertyTreeObject) {
				Property prop = ((AppliedStereotypePropertyTreeObject) treeSelection[i].getData()).getProperty();

				if (treeSelection[i].getImage().equals(ImageManager.IMG_STEREOTYPEDISPLAYED)) {
					// removeStereotypePropertyDisplay(prop, ((StereotypeTreeObject) (treeSelection[i].getParentItem().getData())).getStereotype());
				}

				else {
					// if the stereotype owning the property we want to display is not displayed, we display it!
					if (!isInStereotypeDisplay(((AppliedStereotypeTreeObject) (treeSelection[i].getParentItem().getData())).getStereotype())) {
						addStereotypeDisplay(((AppliedStereotypeTreeObject) (treeSelection[i].getParentItem().getData())).getStereotype());
					}
					// addStereotypePropertyDisplay(prop, ((StereotypeTreeObject) (treeSelection[i].getParentItem().getData())).getStereotype());
				}
			}

		}

		// Refresh
		buildStereotypeDisplay(getElement().getAppliedStereotypes());
		refresh();
		touchModel(getSelected());
	}

	/**
	 * {@inheritDoc}
	 */
	public void disposeListeners() {
		if (displayButton != null && !displayButton.isDisposed())
			displayButton.removeMouseListener(displayButtonListener);
	}

	/**
	 * Listener for the Display Button Specific behavior is implemented in {@link DecoratedTreeComposite#downButtonPressed()}.
	 * 
	 * @author Chokri Mraidha
	 */
	private class DisplayButtonListener implements MouseListener {

		/**
		 * Mouse double click.
		 * 
		 * @param e
		 *            the e
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 * Mouse down.
		 * 
		 * @param e
		 *            the e
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 * Mouse up.
		 * 
		 * @param e
		 *            the e
		 */
		public void mouseUp(MouseEvent e) {
			TreeItem[] treeItems = getTree().getSelection();
			displayButtonPressed();
			refresh();
			// Keep selection
			if (!getTree().isDisposed()) {
				getTree().setSelection(treeItems);
			}
		}
	}

	/** Stereotype display operations **********************/

	/**
	 * returns the selected DiagramElement.
	 * 
	 * @return the diagram element
	 */
	public EModelElement getDiagramElement() {
		return diagramElement;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void addStereotypeDisplay(Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (diagramElement == null) {
			return;
		}
		String presentationKind = AppliedStereotypeHelper.getAppliedSterotypePresentationKind(diagramElement);
		RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypeCommand(domain, diagramElement, st.getQualifiedName(), presentationKind);
		domain.getCommandStack().execute(command);

	}

	/**
	 * {@inheritDoc}
	 */
	protected void removeStereotypeDisplay(Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (diagramElement == null) {
			return;
		}
		String presentationKind = AppliedStereotypeHelper.getAppliedSterotypePresentationKind(diagramElement);
		RecordingCommand command = AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(domain, diagramElement, st.getQualifiedName(), presentationKind);
		domain.getCommandStack().execute(command);

		// // set of diagrams
		// Iterator<Diagram> diagramIter = modelManager.getDiagrams().iterator();
		//
		// // set of graphElements associated to the uml element we unapply stereotype from
		// ArrayList<GraphElement> filteredGraphElements = new ArrayList<GraphElement>();
		//
		// while (diagramIter.hasNext()) {
		// Diagram diag = diagramIter.next();
		//
		// // list of graphElements of a diagram
		// ArrayList<GraphElement> diagramGraphElements = new ArrayList<GraphElement>();
		// diagramGraphElements = LookForElement.getAllGraphElements(diag, diagramGraphElements);
		//
		// // filter diagramsGraphElements in order to hold graphElements associated to the uml element
		// // we unapply the stereotype from
		// Iterator<GraphElement> geIter = diagramGraphElements.iterator();
		// while (geIter.hasNext()) {
		// GraphElement ge = geIter.next();
		//
		// // if the diagram element property list is empty, it has not have any stereotype
		// if (ge.getProperty().size() != 0) {
		// if (getElement().equals(((Uml1SemanticModelBridge) ge.getSemanticModel()).getElement())) {
		// filteredGraphElements.add(ge);
		// }
		// }
		// }
		// }
		//
		// Iterator<GraphElement> stIter = filteredGraphElements.iterator();
		// while (stIter.hasNext()) {
		// DiagramElement currentDE = (DiagramElement) stIter.next();
		// EList<com.cea.papyrus.diagraminterchange2.di2.Property> propList = currentDE.getProperty();
		// ArrayList<com.cea.papyrus.diagraminterchange2.di2.Property> tempPropList = new ArrayList<com.cea.papyrus.diagraminterchange2.di2.Property>();
		// for (int i = 0; i < propList.size(); i++) {
		// tempPropList.add(i, ((com.cea.papyrus.diagraminterchange2.di2.Property) propList.get(i)));
		// }
		//
		// Iterator<com.cea.papyrus.diagraminterchange2.di2.Property> iter = tempPropList.iterator();
		//
		// while (iter.hasNext()) {
		// com.cea.papyrus.diagraminterchange2.di2.Property prop = (com.cea.papyrus.diagraminterchange2.di2.Property) iter.next();
		// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_DISPLAY)) {
		// if (prop.getValue().equals(st.getQualifiedName())) {
		// propList.remove(prop);
		// }
		// }
		// }
		// }
	}

	/**
	 * {@inheritDoc}
	 */
	protected Boolean isInStereotypeDisplay(Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (getDiagramElement() == null) {
			return false;
		}
		String stereotypeList = AppliedStereotypeHelper.getStereotypesToDisplay(getDiagramElement());
		if (stereotypeList.contains(st.getQualifiedName())) {
			return true;
		}
		return false;
	}

	// /**
	// * {@inheritDoc}
	// */
	// protected void buildStereotypeDisplay(EList appliedStereotypes) {
	// // bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
	// if (getDiagramElement() == null) {
	// return;
	// }
	//
	// EList propList = getDiagramElement().getProperty();
	//
	// // temporary list to avoid concurrent access to propList
	// ArrayList tempPropList = new ArrayList();
	//
	// // list containing stereotype display properties of the current graphElement
	// ArrayList<com.cea.papyrus.diagraminterchange2.di2.Property> stereoDiplayList = new ArrayList<com.cea.papyrus.diagraminterchange2.di2.Property>();
	//
	// // copy propList to tempPropList
	// for (int i = 0; i < propList.size(); i++) {
	// tempPropList.add(propList.get(i));
	// }
	//
	// // build stereoDiplayList and remove stereotype display properties form propList
	// Iterator<com.cea.papyrus.diagraminterchange2.di2.Property> iter = tempPropList.iterator();
	// while (iter.hasNext()) {
	// com.cea.papyrus.diagraminterchange2.di2.Property prop = iter.next();
	// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_DISPLAY)) {
	// stereoDiplayList.add(prop);
	// propList.remove(prop);
	// }
	// }
	//
	// // add stereotype display properties in the appropriate order
	// Iterator<Stereotype> stereoIter = appliedStereotypes.iterator();
	// while (stereoIter.hasNext()) {
	// String stereoName = stereoIter.next().getQualifiedName();
	// Iterator<com.cea.papyrus.diagraminterchange2.di2.Property> propIter = stereoDiplayList.iterator();
	// while (propIter.hasNext()) {
	// com.cea.papyrus.diagraminterchange2.di2.Property prop = propIter.next();
	// if (prop.getValue().equals(stereoName)) {
	// propList.add(prop);
	// }
	// }
	// }
	// }
	//
	// /** Stereotype properties values display operations **********************/
	//
	// /**
	// * Adds a stereotype property to the list of properties to display for a diagram element.
	// *
	// * @param owner
	// * the owner
	// * @param prop
	// * the stereotype property to add
	// */
	// private void addStereotypePropertyDisplay(Property prop, Stereotype owner) {
	// // bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
	// if (getDiagramElement() == null) {
	// return;
	// }
	//
	// // property to add creation
	// com.cea.papyrus.diagraminterchange2.di2.Property property = Di2Factory.eINSTANCE.createProperty();
	// property.setKey(ModelerHelper.PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY);
	// property.setValue(owner.getQualifiedName() + "::" + prop.getName());
	//
	// // add the property
	// getDiagramElement().getProperty().add(property);
	//
	// // command creation: display stereotype properties in active diagram
	// Command command = new StereotypePropertiesDisplayCreateCommand(getSelectedEditPart(), getDiagramElement(), (DiagramElement) getDiagramElement().getContainer());
	// CommandStack stack = CommandStackUtils.getCommandStack();
	//
	// Assert.isNotNull(stack, "Impossible to adapt current editor into a CommandStackUtils");
	// stack.execute(command);
	//
	// }
	//
	// /**
	// * Removes a stereotype property from the list of properties to display for a diagram element.
	// *
	// * @param owner
	// * the owner
	// * @param property
	// * the stereotype property to remove
	// */
	// protected void removeStereotypePropertyDisplay(Property property, Stereotype owner) {
	// // bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
	// if (getDiagramElement() == null) {
	// return;
	// }
	//
	// EList propList = getDiagramElement().getProperty();
	// ArrayList<com.cea.papyrus.diagraminterchange2.di2.Property> tempPropList = new ArrayList<com.cea.papyrus.diagraminterchange2.di2.Property>();
	// for (int i = 0; i < propList.size(); i++) {
	// tempPropList.add(i, ((com.cea.papyrus.diagraminterchange2.di2.Property) propList.get(i)));
	// }
	//
	// Iterator iter = tempPropList.iterator();
	//
	// while (iter.hasNext()) {
	// com.cea.papyrus.diagraminterchange2.di2.Property prop = (com.cea.papyrus.diagraminterchange2.di2.Property) iter.next();
	// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY)) {
	// if (prop.getValue().equals(owner.getQualifiedName() + "::" + property.getName())) {
	// propList.remove(prop);
	// }
	// }
	// }
	//
	// // count the number of stereotype properties to display
	// Iterator<com.cea.papyrus.diagraminterchange2.di2.Property> iterProp = getDiagramElement().getProperty().iterator();
	// int count = 0;
	// while (iterProp.hasNext()) {
	// com.cea.papyrus.diagraminterchange2.di2.Property diProp = iterProp.next();
	// if (diProp.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY)) {
	// count++;
	// }
	// }
	//
	// if (count == 0) {
	// Command command;
	//
	// CommandStack stack = CommandStackUtils.getCommandStack();
	//
	// command = DiagramElementDeleteCommandFactory.eINSTANCE.createCommand((GraphNode) LookForElement.getSemanticChildWithoutUmlSemanticAndNoContent(getDiagramElement()));
	//
	// Assert.isNotNull(stack, "Impossible to adapt current editor into a CommandStackUtils");
	// stack.execute(command);
	// }
	// }
	//
	// /**
	// * Checks wether the stereotype property is in the display list or not.
	// *
	// * @param owner
	// * the owner
	// * @param property
	// * to check out
	// *
	// * @return true if the stereotype property is in the display list, false otherwise
	// */
	// private Boolean isInStereoPropertyDisplay(Property property, Stereotype owner) {
	// // bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
	// if (getDiagramElement() == null) {
	// return false;
	// }
	//
	// EList propList = getDiagramElement().getProperty();
	// Iterator iter = propList.iterator();
	// while (iter.hasNext()) {
	// com.cea.papyrus.diagraminterchange2.di2.Property prop = (com.cea.papyrus.diagraminterchange2.di2.Property) iter.next();
	// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY)) {
	// if (prop.getValue().equals(owner.getQualifiedName() + "::" + property.getName())) {
	// return true;
	// }
	// }
	// }
	// return false;
	// }
	//
	// /**
	// * {@inheritDoc}
	// */
	// protected void removeStereotypePropertiesDisplay(Stereotype stereotype) {
	// Iterator<Property> stereoPropIter = stereotype.getAllAttributes().iterator();
	// while (stereoPropIter.hasNext()) {
	// Property currentProp = stereoPropIter.next();
	// if (isInStereoPropertyDisplay(currentProp, stereotype)) {
	// removeStereotypePropertyDisplay(currentProp, stereotype);
	// }
	// }
	// }

}
