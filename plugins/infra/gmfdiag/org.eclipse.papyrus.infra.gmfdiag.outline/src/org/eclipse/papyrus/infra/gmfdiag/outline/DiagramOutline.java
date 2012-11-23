/***********************************************************************
 * Copyright (c) 2008, 2009 Anyware Technologies, Obeo, CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *    Obeo
 *    CEA LIST - synchronization between selection and outline content
 *
 **********************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.outline;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.papyrus.infra.core.contentoutline.IPapyrusContentOutlinePage;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.outline.internal.Activator;
import org.eclipse.papyrus.infra.gmfdiag.outline.internal.Messages;
import org.eclipse.papyrus.infra.gmfdiag.outline.overview.OverviewComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * An outline in order to navigate in current diagram.
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:yann.tanguy@cea.fr">Yann Tanguy</a>
 */
//FIXME: The outline is broken in Eclipse 4.2. #createControl(Composite) is never called.
//See #refresh()
public class DiagramOutline extends Page implements IPapyrusContentOutlinePage, ISelectionListener {

	protected EditingDomain editingDomain;

	private IMultiDiagramEditor multiEditor;

	private SashForm sashComp;

	private DiagramNavigator navigator;

	/** Current selection */
	private RenderedDiagramRootEditPart root = null;

	private Diagram diagram = null;

	/** Outline mode */
	public final static int SHOW_TREE = 1;

	public final static int SHOW_OVERVIEW = 2;

	public final static int SHOW_BOTH = 0;

	private Composite overview;

	/** Actions */
	private IAction showTreeAction;

	private IAction showOverviewAction;

	private IAction showAllAction;

	public DiagramOutline() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(IMultiDiagramEditor multiEditor) throws BackboneException {

		// Get TransactionalEditingDomain
		try {
			this.editingDomain = multiEditor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		} catch (ServiceException e) {
			throw new BackboneException("Can't get TransactionalEditingDomain", e);
		}

		// Set multieditor.
		this.multiEditor = multiEditor;

		// Add listener to detect selection change
		multiEditor.getSite().getPage().addPostSelectionListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	//FIXME: In Eclipse 4.2, this method is never called. This results in sashComp being null,
	//and a NPE being thrown after each selectionChangedEvent
	@Override
	public void createControl(Composite parent) {

		// Create SashForm
		sashComp = new SashForm(parent, SWT.VERTICAL);
		sashComp.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Update selection (diagram and root edit part in active EditorTile)
		refreshSelection();

		// Create Overview
		if(root != null) {
			overview = createOverview(sashComp, root);
			overview.setLayoutData(new GridData(GridData.FILL_BOTH));
		}

		// Create Navigator
		navigator = createNavigator(sashComp, getSite());
		if(diagram != null) {
			navigator.getTreeViewer().setInput(diagram);
		}

		// Slip SashForm in two sections
		if(overview != null) {
			sashComp.setWeights(new int[]{ 30, 70 });
		}

		createActions();
	}

	/**
	 * Create the composite that shows an overview of the model
	 * 
	 * @param parent
	 *        the parent
	 * @param rootEditPart
	 *        the root edit part
	 * @return the overview composite
	 */
	protected Composite createOverview(Composite parent, ScalableFreeformRootEditPart rootEditPart) {
		return new OverviewComposite(parent, rootEditPart);
	}

	/**
	 * Add the actions to the view toolbar
	 */
	protected void createActions() {
		IToolBarManager tbm = getSite().getActionBars().getToolBarManager();
		tbm.add(new Separator());
		createShowOutlineActions(tbm);
	}

	/**
	 * Create the show outline actions in the given tool bar manager.
	 * 
	 * @param tbm
	 *        the outline tool bar manager
	 */
	private void createShowOutlineActions(IToolBarManager tbm) {

		// Show Tree action
		showTreeAction = new Action(Messages.DiagramOutline_ShowNavigator, IAction.AS_RADIO_BUTTON) {

			@Override
			public void run() {
				if(navigator != null && !navigator.isDisposed()) {
					performShowAction();
				}
			}
		};
		showTreeAction.setToolTipText(showTreeAction.getText());
		showTreeAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/tree_co.gif")); //$NON-NLS-1$
		tbm.add(showTreeAction);

		// Show overview action
		showOverviewAction = new Action(Messages.DiagramOutline_ShowOverview, IAction.AS_RADIO_BUTTON) {

			@Override
			public void run() {
				if(overview != null && !overview.isDisposed()) {
					performShowAction();
				}
			}
		};
		showOverviewAction.setToolTipText(showOverviewAction.getText());
		showOverviewAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/overview_co.gif")); //$NON-NLS-1$
		tbm.add(showOverviewAction);

		// Show All (Tree and Overview) action
		showAllAction = new Action(Messages.DiagramOutline_ShowBoth, IAction.AS_RADIO_BUTTON) {

			@Override
			public void run() {
				if(sashComp != null && !sashComp.isDisposed()) {
					performShowAction();
				}
			}
		};
		showAllAction.setToolTipText(showAllAction.getText());
		showAllAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/all_co.gif")); //$NON-NLS-1$
		tbm.add(showAllAction);

		// Set overview as default choice
		showOverviewAction.setChecked(true);
		performShowAction();
	}

	private DiagramNavigator createNavigator(Composite parent, IPageSite pageSite) {
		return new DiagramNavigator(parent, pageSite, multiEditor.getServicesRegistry());
	}

	@Override
	public Control getControl() {
		return sashComp;
	}

	@Override
	public void setFocus() {
		getControl().setFocus();
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		if(navigator != null && !navigator.isDisposed()) {
			navigator.getTreeViewer().addSelectionChangedListener(listener);
		}
	}

	public ISelection getSelection() {
		return navigator.getTreeViewer().getSelection();
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		if(navigator != null && !navigator.isDisposed()) {
			navigator.getTreeViewer().removeSelectionChangedListener(listener);
		}
	}

	public void setSelection(ISelection selection) {
		navigator.getTreeViewer().setSelection(selection);
	}

	@Override
	public void dispose() {
		super.dispose();
		// Navigator, overview... can be null
		if(navigator != null) {
			navigator.dispose();
		}
		if(overview != null) {
			overview.dispose();
		}

		if(multiEditor != null) {
			// Remove selection change listener
			multiEditor.getSite().getPage().removePostSelectionListener(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		// Update selection (diagram and root edit part in active EditorTile)
		refreshSelection();

		// Refresh outline contents content with the new selection
		try {
			refresh(); //When outline breaks, the selectionChangeEvent is borken too. It may prevent the others views from receiving it...
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * Refresh the selected root edit part and diagram
	 */
	private void refreshSelection() {

		if(multiEditor.getActiveEditor() != null) {
			GraphicalViewer viewer = (GraphicalViewer)multiEditor.getAdapter(GraphicalViewer.class);
			if(viewer == null) { // In case of an editor that is not GEF based.
				root = null;
				diagram = null;
				return;
			}

			RootEditPart rootEditPart = viewer.getRootEditPart();

			if(rootEditPart instanceof RenderedDiagramRootEditPart) {
				root = (RenderedDiagramRootEditPart)rootEditPart;
				if(rootEditPart.getContents() != null) {
					diagram = (Diagram)rootEditPart.getContents().getModel();
				} else {
					diagram = null;
				}

			} else {
				root = null;
				diagram = null;
			}

		} else {
			root = null;
			diagram = null;
		}
	}

	/**
	 * Refresh the outline view
	 */
	//FIXME: Sometimes, this method is called before #createControl(), which results in a NPE with sashComp
	//Temporary fix : A non-null test has been added to avoid breaking the view
	private void refresh() {
		// Trash and re-Create Overview
		if((overview != null) && !(overview.isDisposed())) {
			overview.dispose();
		}

		//If the view hasn't been created for any reason, we shouldn't do anything. 
		//However, this is still a (minor) problem.
		if(sashComp == null) {
			Activator.log.warn("Trying to refresh the Outline view before it is initialized");
			return;
		}

		if(root != null) {
			overview = createOverview(sashComp, root);
			overview.setLayoutData(new GridData(GridData.FILL_BOTH));
		}

		// Update navigator content
		if(diagram != null) {
			navigator.getTreeViewer().setInput(diagram);
		}

		// Slip SashForm in two sections
		if((overview != null) && !(overview.isDisposed())) {
			sashComp.setWeights(new int[]{ 30, 70 });
		}

		// Refresh outline without changing mode
		performShowAction();
	}

	/**
	 * Show outline in selected mode
	 */
	private void performShowAction() {

		// Select the kind of outline to show content
		Control control = null;
		control = null;
		switch(getShowActionMode()) {
		case SHOW_TREE:
			control = navigator;
			break;
		case SHOW_OVERVIEW:
			control = overview;
			break;
		case SHOW_BOTH:
			control = null;
			break;
		default:
			control = overview;
		}

		// Update outline view
		if(sashComp != null && !sashComp.isDisposed()) {
			sashComp.setMaximizedControl(control);
		}
	}

	/**
	 * Get current contents representation of the outline
	 * 
	 * @return current Outline show mode
	 */
	private int getShowActionMode() {
		int showActionMode = -1;

		if(showTreeAction.isChecked()) {
			showActionMode = SHOW_TREE;
		}
		if(showOverviewAction.isChecked()) {
			showActionMode = SHOW_OVERVIEW;
		}
		if(showAllAction.isChecked()) {
			showActionMode = SHOW_BOTH;
		}

		return showActionMode;
	}
}
