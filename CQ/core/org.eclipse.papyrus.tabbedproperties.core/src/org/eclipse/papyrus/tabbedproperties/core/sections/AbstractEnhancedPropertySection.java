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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.sections;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.BusinessModelResolver;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Element;

/**
 * Abstract base class for TabbedProperty sections. This class enforce the use of a separate figure. The class delegates calls to the figure when appropriate (createControls, aboutToBeShown,
 * aboutToBeHidden, dispose)
 * 
 * @author dumoulin
 * 
 */
public abstract class AbstractEnhancedPropertySection extends AbstractPropertySection implements ISection {

	/**
	 * The associated figure of the PropertyEditor.
	 */
	protected PropertyEditor figure;

	protected TransactionalEditingDomain editingDomain;

	protected BackboneContext backbone;

	protected IMultiDiagramEditor editor;

	private TabbedPropertySheetPage tabbedPropertySheetPage;

	/**
	 * Delegate construction of the figure to createFigure
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		figure = createFigure();
		figure.createControls(parent, tabbedPropertySheetPage);
		this.tabbedPropertySheetPage = tabbedPropertySheetPage;
		// TODO remove next
		// figure.initializeControls();
		initializeFigure();
	}

	/**
	 * 
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		// When the selection is computed from the outline, get the associated editor
		if (part instanceof ContentOutline) {
			IContributedContentsView contributedView = ((IContributedContentsView) ((ContentOutline) part).getAdapter(IContributedContentsView.class));
			if (contributedView != null) {
				part = (IWorkbenchPart) contributedView.getContributingPart();
			}
		}
		if (part instanceof IMultiDiagramEditor) {
			editor = (IMultiDiagramEditor) part;
			backbone = editor.getDefaultContext();
			editingDomain = editor.getDefaultContext().getTransactionalEditingDomain();
		} else
			editingDomain = null;
	}

	/**
	 * Create the figure associated to the section. Subclass should implements this method.
	 * 
	 * @return
	 */
	abstract public PropertyEditor createFigure();

	/**
	 * Initialize the figure associated to the section. Subclass should implements this method.
	 * 
	 * @return
	 */
	abstract protected void initializeFigure();

	/**
	 * Get the associated figure.
	 * 
	 * @return
	 */
	public PropertyEditor getFigure() {
		return figure;
	}

	/**
	 * 
	 */
	@Override
	public void aboutToBeShown() {
		super.dispose();
		figure.aboutToBeShown();
	}

	/**
	 * 
	 */
	@Override
	public void aboutToBeHidden() {
		super.dispose();
		figure.aboutToBeHidden();
	}

	/**
	 * 
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (figure != null) {
			figure.dispose();
		}
	}

	/**
	 * Get the business element associated to the object.
	 * 
	 * @param input
	 * @return
	 */
	protected Object getBusinessElement(Object input) {
		return BusinessModelResolver.getInstance().getBussinessModel(input);
	}

	public void navigateTo(Element element) {

		tabbedPropertySheetPage.selectionChanged(editor, new StructuredSelection(element));
	}

}
