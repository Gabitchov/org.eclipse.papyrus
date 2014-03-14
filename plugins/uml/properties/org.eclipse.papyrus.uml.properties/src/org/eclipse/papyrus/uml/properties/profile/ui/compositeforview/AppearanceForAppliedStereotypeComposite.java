/*****************************************************************************
 * Copyright (c) 2008, 2014 CEA LIST and others.
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
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositeforview;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.papyrus.uml.profile.tree.DisplayedProfileElementLabelProvider;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.DecoratedTreeComposite;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener.StereotypeCustomNotification;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class AppearanceStereotypeComposite manages the display of stereotype properties from appearance tab.
 * 
 * when {@link TreeViewer#setSelection(ISelection)} runs the code could be changed
 */
public class AppearanceForAppliedStereotypeComposite extends org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppliedStereotypeDisplayComposite implements IViewComposite {

	DisplayedProfileElementLabelProvider displayedProfileElementLabelProvider = new DisplayedProfileElementLabelProvider();

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
		 *        the e
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 * Mouse down.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 * Mouse up.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseUp(MouseEvent e) {
			boolean withQualifiedName = false;
			if(e.getSource().equals(displayButtonQN)) {
				withQualifiedName = true;
			}
			TreeItem[] selectedTreeItems = getTree().getSelection();
			displayButtonPressed(withQualifiedName);
			// Keep selection
			if(!getTree().isDisposed()) {
				getTree().setSelection(selectedTreeItems);
			}

		}
	}

	/**
	 * The diagram element.
	 */
	protected EModelElement diagramElement = null;

	/**
	 * button that displays the element.
	 */
	protected Button displayButton;

	/**
	 * button that displays the element.
	 */
	protected Button displayButtonQN;

	/**
	 * Listener for the display button.
	 */
	protected MouseListener displayButtonListener;

	/**
	 * The selection.
	 */
	protected ISelection selection;

	private Adapter elementListener;

	/**
	 * The Constructor.
	 * 
	 * @param parent
	 *        the parent
	 */
	public AppearanceForAppliedStereotypeComposite(Composite parent) {
		super(parent);
		this.setBackground(JFaceColors.getBannerBackground(parent.getDisplay()));
		this.displayButtonListener = new DisplayButtonListener();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);

		FormData data;
		displayButton = factory.createButton(this, "", SWT.PUSH);
		displayButton.setVisible(true);
		displayButton.setImage(ImageManager.IMG_DISPLAY);
		displayButton.setToolTipText("Display selected stereotype for the element in the diagram");
		data = new FormData();
		// data.top = new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		displayButton.setLayoutData(data);
		displayButton.addMouseListener(displayButtonListener);

		// button for qualifiedName
		displayButtonQN = factory.createButton(this, "", SWT.PUSH);
		displayButtonQN.setVisible(true);
		displayButtonQN.setImage(ImageManager.IMG_CONSOLEVIEW_WITH_QN);
		displayButtonQN.setToolTipText("Display selected stereotypes with their qualified name for the element in the diagram");
		data = new FormData();
		// data.top = new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(displayButton, -ITabbedPropertyConstants.HSPACE);
		displayButtonQN.setLayoutData(data);
		displayButtonQN.addMouseListener(displayButtonListener);

		// Create label
		label = factory.createCLabel(this, name + ":", SWT.NONE);
		label.setLayout(new FormLayout());
		data = new FormData();
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(displayButtonQN, -ITabbedPropertyConstants.HSPACE - 30);
		data.top = new FormAttachment(0, 0);
		label.setLayoutData(data);

		// Create and place Table
		treeViewer.setLabelProvider(displayedProfileElementLabelProvider);
		tree = treeViewer.getTree();
		tree.setLayout(new FormLayout());
		tree.setVisible(true);

		data = new FormData(SWT.DEFAULT, 50);
		data.top = new FormAttachment(displayButton, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);

		tree.setLayoutData(data);

		// Replace label and content providers in treeViewers
		treeViewer.setContentProvider(new ProfileElementWithDisplayContentProvider(diagramElement));
		// treeViewer.setLabelProvider(new ProfileElementWithDisplayLabelProvider());

		refresh();
		//Update buttons
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				refreshButtons();
			}
		});
		return this;
	}
	
	@Override
	public boolean isReadOnly() {
		EModelElement element = getDiagramElement();
		return (element == null) || EMFHelper.isReadOnly(element);
	}

	/**
	 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417372
	 * Update buttons status when items have been selected from the tree.
	 * If no stereotype selected in Appearance, disable the buttons to apply.
	 */
	private void refreshButtons() {
		if(tree == null || tree.isDisposed()) {
			return;
		}
		boolean enabled = (getDiagramElement() != null && !treeViewer.getSelection().isEmpty()) && !isReadOnly();
		if(displayButton != null && !displayButton.isDisposed()) {
			displayButton.setEnabled(enabled);
		}
		if(displayButtonQN != null && !displayButtonQN.isDisposed()) {
			displayButtonQN.setEnabled(enabled);
		}
	}

	/**
	 * Display button pressed.
	 */
	public void displayButtonPressed(boolean withQualifiedName) {
		// If nothing selected : abort
		if(getTree().getSelection().length < 1) {
			return;
		}

		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if(getDiagramElement() == null) {
			return;
		}

		TreeItem[] treeSelection = getTree().getSelection();
		for(int i = 0; i < treeSelection.length; i++) {
			// stereotypesTree.getSelection()[0]
			if(treeSelection[i].getData() instanceof AppliedStereotypeTreeObject) {
				Stereotype stereo = ((AppliedStereotypeTreeObject)treeSelection[i].getData()).getStereotype();

				if(treeSelection[i].getImage().equals(ImageManager.IMG_STEREOTYPE)) {
					displayStereotype(stereo);
					treeSelection[i].setImage(ImageManager.IMG_STEREOTYPEDISPLAYED);
					if(withQualifiedName) {
						displayStereotypeWithQN(stereo);

						treeSelection[i].setImage(ImageManager.DISPLAYED_STEREOTYPE_QN);
					}

				} else {
					// if we remove the stereotype we have to remove its properties also
					removeDisplayStereotype(stereo);
					treeSelection[i].setImage(ImageManager.IMG_STEREOTYPE);
				}
			}

			else if(treeSelection[i].getData() instanceof AppliedStereotypePropertyTreeObject) {
				Property prop = ((AppliedStereotypePropertyTreeObject)treeSelection[i].getData()).getProperty();

				if(treeSelection[i].getImage().equals(ImageManager.IMG_DISPLAYEDPROPERTY)) {
					// removeStereotypePropertyDisplay(prop, ((StereotypeTreeObject) (treeSelection[i].getParentItem().getData())).getStereotype());
					removeStereotypeProperty(((AppliedStereotypeTreeObject)(treeSelection[i].getParentItem().getData())).getStereotype(), ((AppliedStereotypePropertyTreeObject)treeSelection[i].getData()).getProperty());
					treeSelection[i].setImage(ImageManager.IMG_PROPERTY);
				}

				else {
					// if the stereotype owning the property we want to display is not displayed, we display it!
					if(!isInStereotypeDisplay(((AppliedStereotypeTreeObject)(treeSelection[i].getParentItem().getData())).getStereotype())) {
						displayStereotype(((AppliedStereotypeTreeObject)(treeSelection[i].getParentItem().getData())).getStereotype());
					}
					addStereotypePropertyDisplay(prop, ((AppliedStereotypeTreeObject)(treeSelection[i].getParentItem().getData())).getStereotype());
					treeSelection[i].setImage(ImageManager.IMG_DISPLAYEDPROPERTY);
				}
			}

		}

	}

	protected void addStereotypePropertyDisplay(final Property prop, final Stereotype stereotype) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if(diagramElement == null) {
			return;
		}
		try {

			getDomain().runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {

							String appliedStereotypeListToAdd = stereotype.getQualifiedName() + "." + prop.getName();
							RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypePropertiesCommand(getDomain(), diagramElement, appliedStereotypeListToAdd);
							getDomain().getCommandStack().execute(command);
							// refresh();
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.logException(e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void disposeListeners() {
		if(displayButton != null && !displayButton.isDisposed()) {
			displayButton.removeMouseListener(displayButtonListener);
		}
	}

	/**
	 * returns the selected DiagramElement.
	 * 
	 * @return the diagram element
	 */
	public EModelElement getDiagramElement() {
		return diagramElement;
	}

	public TransactionalEditingDomain getDomain() {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(element);
		} catch (Exception ex) {
			Activator.log.error(ex);
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Element getSelected() {
		Object input = ((IStructuredSelection)selection).getFirstElement();
		return UMLUtil.resolveUMLElement(input);
	}


	/**
	 * {@inheritDoc}
	 */
	protected Boolean isInStereotypeDisplay(Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if(getDiagramElement() == null) {
			return false;
		}
		String stereotypeList = AppliedStereotypeHelper.getStereotypesToDisplay(getDiagramElement());
		if(stereotypeList.contains(st.getQualifiedName())) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refresh() {
		if(diagramElement != null) {
			displayedProfileElementLabelProvider.setDisplayedStereotype(AppliedStereotypeHelper.getStereotypesToDisplay(diagramElement));
			displayedProfileElementLabelProvider.setDisplayedStereotypeWithQN(AppliedStereotypeHelper.getStereotypesQNToDisplay(diagramElement));
			displayedProfileElementLabelProvider.setDisplayedProperty(AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay(diagramElement));
		}
		super.refresh();
		if((diagramElement == null) && (!displayButton.isDisposed())) {
			//			displayButton.setEnabled(false);
			displayButton.setToolTipText("Stereotypes can only be displayed for elements with graphical representation. " + "Currently edited element is a non graphical element. " + "(example: an element selected in the outline is not a graphical element)");
		} else if(!displayButton.isDisposed()) {
			// button should be enabled only if a stereotype is selected, but it requires a listener on the tree selection
			//			displayButton.setEnabled(true);
			displayButton.setToolTipText("Display selected stereotype for the currently selected element in the diagram");
		}
		refreshButtons();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void removeStereotypeDisplay(Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if(diagramElement == null) {
			return;
		}
		String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);
		RecordingCommand command = AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(getDomain(), diagramElement, st.getQualifiedName(), presentationKind);
		getDomain().getCommandStack().execute(command);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		if(event == null) {
			return;
		}
	}

	/** Stereotype display operations **********************/

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
	 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417372
	 * Add a listener for stereotypes changing.
	 * 
	 * @see org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppearanceDecoratedTreeComposite#setElement(org.eclipse.uml2.uml.Element)
	 * 
	 * @param element
	 */
	@Override
	public void setElement(Element element) {
		if(getElement() != null && elementListener != null) {
			getElement().eAdapters().remove(elementListener);
		}
		super.setElement(element);
		if(element != null) {
			if(elementListener == null) {
				elementListener = new AdapterImpl() {

					@Override
					public void notifyChanged(final Notification msg) {
						handleNotifyChanged(msg);
					}
				};
			}
			element.eAdapters().add(elementListener);
		}
	}

	/**
	 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417372
	 * Refresh if Stereotypes have been changed.
	 * 
	 * Stereotypes list is empty in the Appearance after the application of Stereotype in Profile.
	 */
	protected void handleNotifyChanged(Notification msg) {
		final int eventType = msg.getEventType();
		if(msg instanceof StereotypeCustomNotification && (eventType == PapyrusStereotypeListener.APPLIED_STEREOTYPE || eventType == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE)) {
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					if(tree != null && !tree.isDisposed() && treeViewer != null && getElement() != null) {
						treeViewer.setInput(new StereotypedElementTreeObject(getElement()));
					}
					refresh();
				}
			});
		}
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

	/**
	 * Display the stereotype once it is applied
	 * 
	 * @param st
	 *        the stereotype to add
	 */
	protected void displayStereotype(final Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if(diagramElement == null) {
			return;
		}
		try {

			getDomain().runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);
							RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypeCommand(getDomain(), diagramElement, st.getQualifiedName(), presentationKind);
							getDomain().getCommandStack().execute(command);
							// refresh();
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.logException(e);
		}

	}

	protected void removeStereotypeProperty(final Stereotype st, final Property property) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if(diagramElement == null) {
			return;
		}
		try {

			getDomain().runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							String stringToRemove = st.getQualifiedName() + "." + property.getName();
							RecordingCommand command = AppliedStereotypeHelper.getRemoveAppliedStereotypePropertiesCommand(getDomain(), diagramElement, stringToRemove);
							getDomain().getCommandStack().execute(command);
							// refresh();
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.logException(e);
		}

	}

	/**
	 * Display the stereotype once it is applied
	 * 
	 * @param st
	 *        the stereotype to add
	 */
	protected void displayStereotypeProperties(final Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if(diagramElement == null) {
			return;
		}
		try {

			getDomain().runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);
							RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypeCommand(getDomain(), diagramElement, st.getQualifiedName(), presentationKind);
							getDomain().getCommandStack().execute(command);
							// refresh();
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.logException(e);
		}

	}

	/**
	 * Display the stereotype once it is applied
	 * 
	 * @param st
	 *        the stereotype to add
	 */
	protected void displayStereotypeWithQN(final Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if(diagramElement == null) {
			return;
		}
		try {

			getDomain().runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypeToDisplayWithQNCommand(getDomain(), diagramElement, st.getQualifiedName());
							getDomain().getCommandStack().execute(command);
							// refresh();
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.logException(e);
		}

	}

	/**
	 * Remove a stereotype from the list of stereotypes to display.
	 * 
	 * @param st
	 *        the stereotype to remove
	 */
	protected void removeDisplayStereotype(final Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if(diagramElement == null) {
			return;
		}
		try {
			getDomain().runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);
							RecordingCommand command = AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(getDomain(), diagramElement, st.getQualifiedName(), presentationKind);

							getDomain().getCommandStack().execute(command);
							// refresh();
						}
					});
				}
			});
		} catch (Exception e) {
			Activator.logException(e);
		}

	}

}
