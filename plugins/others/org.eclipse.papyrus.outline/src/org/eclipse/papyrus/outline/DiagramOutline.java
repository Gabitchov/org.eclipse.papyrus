/***********************************************************************
 * Copyright (c) 2008, 2009 Anyware Technologies, Obeo
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *    Obeo
 *
 **********************************************************************/
package org.eclipse.papyrus.outline;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.papyrus.core.contentoutline.IPapyrusContentOutlinePage;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.outline.internal.Activator;
import org.eclipse.papyrus.outline.internal.Messages;
import org.eclipse.papyrus.outline.overview.OverviewComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * An outline in order to navigate in current diagram.
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DiagramOutline extends Page implements IPapyrusContentOutlinePage {

	private Diagram diagram;

	protected EditingDomain editingDomain;

	protected IEditorPart editorPart;

	private SashForm sashComp;

	private DiagramNavigator navigator;

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
		this.editingDomain = multiEditor.getDefaultContext().getTransactionalEditingDomain();
		this.diagram = multiEditor.getDefaultContext().getDiagramEditDomain().getDiagramEditorPart().getDiagram();
		this.editorPart = multiEditor.getActiveEditor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		// SashForm
		sashComp = new SashForm(parent, SWT.VERTICAL);
		sashComp.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Set up the thumbnail view
		GraphicalViewer viewer = (GraphicalViewer) editorPart.getAdapter(GraphicalViewer.class);
		RootEditPart rootEditPart = viewer.getRootEditPart();
		if (rootEditPart instanceof ScalableFreeformRootEditPart) {
			overview = createOverview(sashComp, (ScalableFreeformRootEditPart) rootEditPart);
			overview.setLayoutData(new GridData(GridData.FILL_BOTH));
		}

		// Set up the tree viewer
		navigator = createNavigator(sashComp, diagram, getSite());

		// Slip SashForm in two sections
		if (overview != null) {
			sashComp.setWeights(new int[] { 30, 70 });
		}
		createActions();
	}

	/**
	 * Create the composite that shows an overview of the model
	 * 
	 * @param parent
	 *            the parent
	 * @param rootEditPart
	 *            the root edit part
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
	 *            the outline tool bar manager
	 */
	private void createShowOutlineActions(IToolBarManager tbm) {
		final IPreferenceStore ps = getPreferenceStore();
		// Show Tree action
		showTreeAction = new Action(Messages.DiagramOutline_ShowNavigator, IAction.AS_RADIO_BUTTON) {

			public void run() {
				if (navigator != null && !navigator.isDisposed()) {
					performShowAction(navigator, ps, 1);
				}
			}
		};
		showTreeAction.setToolTipText(showTreeAction.getText());
		showTreeAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/tree_co.gif")); //$NON-NLS-1$
		tbm.add(showTreeAction);

		// Show overview action
		showOverviewAction = new Action(Messages.DiagramOutline_ShowOverview, IAction.AS_RADIO_BUTTON) {

			public void run() {
				if (overview != null && !overview.isDisposed()) {
					performShowAction(overview, ps, 2);
				}
			}
		};
		showOverviewAction.setToolTipText(showOverviewAction.getText());
		showOverviewAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/overview_co.gif")); //$NON-NLS-1$
		tbm.add(showOverviewAction);

		// Show All (Tree and Overview) action
		showAllAction = new Action(Messages.DiagramOutline_ShowBoth, IAction.AS_RADIO_BUTTON) {

			public void run() {
				if (sashComp != null && !sashComp.isDisposed()) {
					performShowAction(null, ps, 0);
				}
			}
		};
		showAllAction.setToolTipText(showAllAction.getText());
		showAllAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/all_co.gif")); //$NON-NLS-1$
		tbm.add(showAllAction);

		//
		if (ps != null) {
			int showAction = 0;// TODO restore // ps.getInt(ModelerPreferenceConstants.OUTLINE_SHOW_ACTION_PREF);
			Control control = null;
			switch (showAction) {
			case 1:
				control = navigator;
				showTreeAction.setChecked(true);
				break;
			case 2:
				control = overview;
				showOverviewAction.setChecked(true);
				break;
			case 3:
				control = null;
				showAllAction.setChecked(true);
				break;
			default:
				control = overview;
				showOverviewAction.setChecked(true);
			}
			performShowAction(control, ps, showAction);
		} else {
			showOverviewAction.setChecked(true);
			performShowAction(overview, ps, 0);
		}

	}

	private void performShowAction(Control control, IPreferenceStore ps, int pref) {
		sashComp.setMaximizedControl(control);
		if (ps != null) {
			// TODO Restore
			// ps.setValue(ModelerPreferenceConstants.OUTLINE_SHOW_ACTION_PREF, pref);
		}
	}

	private DiagramNavigator createNavigator(Composite parent, Diagram diagram, IPageSite pageSite) {
		return new DiagramNavigator(parent, diagram, pageSite);
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
		if (navigator != null && !navigator.isDisposed()) {
			navigator.getTreeViewer().addSelectionChangedListener(listener);
		}
	}

	public ISelection getSelection() {
		return navigator.getTreeViewer().getSelection();
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		if (navigator != null && !navigator.isDisposed()) {
			navigator.getTreeViewer().removeSelectionChangedListener(listener);
		}
	}

	public void setSelection(ISelection selection) {
		navigator.getTreeViewer().setSelection(selection);
	}

	protected IPreferenceStore getPreferenceStore() {
		return null;
	}

	@Override
	public void dispose() {
		super.dispose();
		navigator.dispose();
	}

}
