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
package org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.preference.ProfilePreferenceConstants;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementContentProvider;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementTreeViewerFilter;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.profile.utils.Util;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.ChooseSetStereotypeDialog;
import org.eclipse.papyrus.uml.properties.profile.ui.panels.AppliedStereotypePanel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

// TODO: Auto-generated Javadoc
/**
 * This composite is used to display applied stereotype in the model. It allows applying or desapply a stereotype
 */
public class AppliedStereotypeCompositeOnModel extends DecoratedTreeComposite implements ISelectionChangedListener {

	/**
	 * Gets the domain.
	 * 
	 * @return the domain
	 */
	public TransactionalEditingDomain getEditingDomain(Element context) {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(context);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}

	/** The panel that display applied stereotypes. */
	private AppliedStereotypePanel appliedStereotypePanel;

	/** The label. */
	protected CLabel label;

	/**
	 * The default constructor.
	 * 
	 * @param parent
	 *        the parent Composite for this panel
	 */
	public AppliedStereotypeCompositeOnModel(AppliedStereotypePanel parent) {
		super(parent, SWT.NONE, "Applied stereotypes", true);

		appliedStereotypePanel = parent;
	}

	/**
	 * create a composite applied stereotype on model.
	 * 
	 * @param parent
	 *        the parent composite
	 */
	public AppliedStereotypeCompositeOnModel(Composite parent) {
		super(parent, SWT.NONE, "Applied stereotypes", true);
	}

	/**
	 * apply a stereotype on current selected element.
	 */
	protected void addAppliedStereotype() {

		// Open stereotype selection (may add or remove)
		ChooseSetStereotypeDialog dialog = new ChooseSetStereotypeDialog(this.getShell(), getElement());
		int result = dialog.open();

		if(result == ChooseSetStereotypeDialog.OK) {
			// Retrieve selected element
			Element element = getElement();

			// compare the 2 lists (present list and future list
			EList<Stereotype> oldStereotypeList = element.getAppliedStereotypes();
			ArrayList<Stereotype> newStereotypeList = dialog.getSelectedElements();

			// Keep newStereotype order (will be used at the end of the method)
			EList<Stereotype> newOrderList = new BasicEList<Stereotype>();
			newOrderList.addAll(newStereotypeList);

			// If the 2 lists differ, apply the new list of stereotypes
			if(!(newStereotypeList.equals(oldStereotypeList))) {

				// Parse old list :
				// if stereotype is in the new list : it is already applied
				// --> don't unapply it
				// --> remove it from new list
				Iterator<Stereotype> it = oldStereotypeList.iterator();
				while(it.hasNext()) {
					Stereotype currentStOld = it.next();
					if(newStereotypeList.contains(currentStOld)) {
						newStereotypeList.remove(currentStOld);
					} else {
						unapplyStereotype(element, currentStOld);
					}
				}

				// Already applied stereotype should have been removed
				// apply others
				Iterator<Stereotype> newApplyStereotypes = newStereotypeList.iterator();
				while(newApplyStereotypes.hasNext()) {
					Stereotype currentStereotype = newApplyStereotypes.next();
					applyStereotype(element, currentStereotype);
				}

				// Update Stereotype order
				// this.reorderStereotypeApplications(element, newOrderList);

				// checkSelection(null);
				selectionChanged(null);

				if(appliedStereotypePanel != null) {
					appliedStereotypePanel.refresh();
				}
			}
		}

	}

	/**
	 * Button action : open a selection dialog box that allow the user to choose stereotypes to apply (or unapply).
	 */
	@Override
	public void addButtonPressed() {
		addAppliedStereotype();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);
		createStereotypesTree();

		removeButton.setToolTipText("Remove stereotype");
		addButton.setToolTipText("Apply stereotype");

		return this;
	}

	/**
	 * Creates the stereotypes tree.
	 * 
	 * @return the tree of applied stereotypes and properties
	 */
	private void createStereotypesTree() {
		// Tree viewer shows applied stereotypes
		treeViewer.setContentProvider(new ProfileElementContentProvider());
		treeViewer.setLabelProvider(new ProfileElementLabelProvider());
		treeViewer.addFilter(new ProfileElementTreeViewerFilter());
		treeViewer.addSelectionChangedListener(this);
	}

	/**
	 * Button action : modify display order of stereotypes (selected elements are pushed down in the list).
	 */
	@Override
	public void downButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if(nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		int indexLast = getTree().indexOf(items[items.length - 1]);
		if(indexLast + 1 >= getElement().getAppliedStereotypes().size()) {
			// do nothing
			return;
		}

		for(int i = 0; i < nbrOfSelection; i++) {
			TreeItem item = items[nbrOfSelection - 1 - i];
			if(item.getData() instanceof AppliedStereotypeTreeObject) {
				AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject)item.getData();
				EList stereotypes = new BasicEList();
				stereotypes.addAll(element.getAppliedStereotypes());

				int index = stereotypes.indexOf(sTO.getStereotype());
				if((index == -1) || (index >= stereotypes.size() - 1)) {
					// Not found of already on top...
					return;
				}

				stereotypes.move(index + 1, sTO.getStereotype());
				this.reorderStereotypeApplications(element, stereotypes);
			}
		}
	}

	/**
	 * Edits the item.
	 * 
	 * @param item
	 *        the item
	 */
	@Override
	public void editItem(TreeItem item) {
		// do nothing
	}

	/**
	 * Gets the selected.
	 * 
	 * @return Returns the selected element.
	 */
	public Element getSelected() {
		return appliedStereotypePanel.getSelected();
	}

	/**
	 * Gets the tree.
	 * 
	 * @return the tree
	 */
	public Tree getTree() {
		return treeViewer.getTree();
	}

	/**
	 * Checks if is in stereotype display.
	 * 
	 * @param st
	 *        the stereotype
	 * 
	 * @return true, if checks if is in stereotype display
	 */
	protected Boolean isInStereotypeDisplay(Stereotype st) {
		return false;
	}

	/**
	 * Redraw the treeViewer while preserving selections and non-collapsed tree elements
	 * It is not sufficient to redraw only selected elements as an optimization, since
	 * derived stereotype attributes (that are not selected) might change in response to
	 * changing other attributes.
	 * 
	 * @param propertyView
	 */
	public void refreshTreeViewer() {
		treeViewer.refresh();
	}

	/**
	 * Refresh the content of applied the applied stereotype tree.
	 */
	@Override
	public void refresh() {
		super.refresh();
		
		if(treeViewer.getTree() != null && !(treeViewer.getTree().isDisposed())) {
			treeViewer.setInput(null);
			treeViewer.refresh();
			if(element != null) {
				treeViewer.setInput(new StereotypedElementTreeObject(element));
			}
			StereotypedElementTreeObject rTO = (StereotypedElementTreeObject)treeViewer.getInput();
			if(rTO == null) {
				return;
			}

			boolean isEditable = isEditable();
			
			// If the property is Multivalued show Up - Down
			if((rTO.getChildren() != null) && (rTO.getChildren().length > 1)) {
				upButton.setEnabled(isEditable);
				downButton.setEnabled(isEditable);
			} else {
				upButton.setEnabled(false);
				downButton.setEnabled(false);
			}

			if((rTO.getChildren() != null) && (rTO.getChildren().length == 0)) {
				removeButton.setEnabled(false);
			} else {
				removeButton.setEnabled(isEditable);
			}
		}
	}

	/**
	 * Button action : unapply the stereotypes selected by the user in the stereotype tree.
	 */
	@Override
	public void removeButtonPressed() {
		unapplyStereotype();
	}

	/**
	 * Selection changed.
	 * 
	 * @param event
	 *        the event
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		if(appliedStereotypePanel != null) {
			if(event == null) {
				appliedStereotypePanel.setSelectedProperty(null);
				return;
			}

			IStructuredSelection structSelection = (IStructuredSelection)event.getSelection();
			Object selection = structSelection.getFirstElement();
			if(selection instanceof AppliedStereotypePropertyTreeObject) {
				appliedStereotypePanel.setSelectedProperty((AppliedStereotypePropertyTreeObject)selection);
			} else {
				appliedStereotypePanel.setSelectedProperty(null);
			}

		}
	}

	/**
	 * Sets the input.
	 * 
	 * @param element
	 *        the element
	 */
	public void setInput(StereotypedElementTreeObject element) {
		treeViewer.setInput(element);
		if(Activator.getDefault().getPreferenceStore().getBoolean(ProfilePreferenceConstants.EXPAND_STEREOTYPES_TREE)) {
			treeViewer.expandAll();
		}
	}

	/**
	 * unapply stereotype on current selected element.
	 */
	protected void unapplyStereotype() {
		int nbrOfSelection = getTree().getSelectionCount();
		if(nbrOfSelection == 0) {
			return;
		}

		for(int i = 0; i < nbrOfSelection; i++) {
			TreeItem item = getTree().getSelection()[i];
			if(item.getData() instanceof AppliedStereotypeTreeObject) {
				AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject)item.getData();
				unapplyStereotype(element, sTO.getStereotype());
				sTO.removeMe();
			}
		}
		if(appliedStereotypePanel != null) {
			appliedStereotypePanel.refresh();
		} else {
			refresh();
		}
	}

	/**
	 * Button action : modify display order of stereotypes (selected elements are pushed up in the list).
	 */
	@Override
	public void upButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if(nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		int indexFirst = getTree().indexOf(items[0]);
		if(indexFirst == 0) {
			// do nothing
			return;
		}

		for(int i = 0; i < nbrOfSelection; i++) {
			TreeItem item = items[i];
			if(item.getData() instanceof AppliedStereotypeTreeObject) {
				AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject)item.getData();
				EList stereotypes = new BasicEList();
				stereotypes.addAll(element.getAppliedStereotypes());

				int index = stereotypes.indexOf(sTO.getStereotype());
				if(index < 1) {
					return;
				}

				stereotypes.move(index - 1, sTO.getStereotype());
				this.reorderStereotypeApplications(element, stereotypes);
			}
		}
		if(appliedStereotypePanel != null) {
			appliedStereotypePanel.refresh();
		} else {
			refresh();
		}
	}

	/**
	 * Apply stereotype.
	 * 
	 * @param elt
	 *        the elt
	 * @param st
	 *        the st
	 */
	public void applyStereotype(final Element elt, final Stereotype st) {
		try {
			final TransactionalEditingDomain domain = getEditingDomain(elt);
			domain.runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							domain.getCommandStack().execute(new RecordingCommand(domain) {

								@Override
								protected void doExecute() {
									elt.applyStereotype(st);
									refresh();
								}
							});
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.log.error(e);
		}

	}

	/**
	 * Unapply stereotype.
	 * 
	 * @param elt
	 *        the uml element
	 * @param st
	 *        the stereotype to unapply
	 */
	protected void unapplyStereotype(final Element elt, final Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		try {
			final TransactionalEditingDomain domain = getEditingDomain(elt);
			domain.runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							domain.getCommandStack().execute(new RecordingCommand(domain) {

								@Override
								protected void doExecute() {
									elt.unapplyStereotype(st);
									elt.eNotify(new NotificationImpl(Notification.SET, true, true, true));
									refresh();
								}
							});
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.log.error(e);
		}

	}

	/**
	 * change the order of applied stereotype
	 * 
	 * @param element
	 *        the UML element where stereotypes are applied
	 * @param stereotypes
	 *        the lis of applied stereotypes with the wanted order
	 */
	public void reorderStereotypeApplications(final Element element, final EList stereotypes) {
		try {
			final TransactionalEditingDomain domain = getEditingDomain(element);
			domain.runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							domain.getCommandStack().execute(new RecordingCommand(domain) {

								@Override
								protected void doExecute() {
									Util.reorderStereotypeApplications(element, stereotypes);
									refresh();
								}
							});
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.log.error(e);
		}

	}

}
