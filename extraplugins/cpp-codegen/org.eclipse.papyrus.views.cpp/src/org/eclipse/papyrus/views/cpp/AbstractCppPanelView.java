/*******************************************************************************
 * Copyright (c) 2006 - 2010 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.views.cpp;

import org.eclipse.papyrus.views.panels.CppAbstractPanel;
import org.eclipse.papyrus.views.panels.PanelFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.uml2.uml.Element;


/**
 * This class extends <code>ViewPart</code>. This class draws the Accord/Cpp
 * panel in the Modeling Perspective. It also implements
 * <code>ISelectionListener</code> in order to know which element is selected
 * in the workbench. In fact, the content of the view changes depending on the
 * type of the element selected
 */
public abstract class AbstractCppPanelView extends ViewPart implements ISelectionListener {

	/** parent composite of the panels contained by this view */
    protected Composite parent;

    /** stores the current target */
    protected Object currentTarget;

    /** keeps the reference to the panel (abstract class) */
    protected CppAbstractPanel panel;

    /* (non-Javadoc)
     * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void createPartControl(Composite parent) {
    	getViewSite().getPage().addSelectionListener(this);
    	this.parent = parent;
    	panel = createPanel(parent, 0, null);
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
     */
    @Override
    public void setFocus() {
    	// delegate focus to the panel
        panel.setFocus();
    }

    /**
     * Changes the panel displayed in the view, depending on the type of the
     * newly selected element.
     */
    protected void switchUI() {
    	/*
    	 * test to check if the panel is not disposed. Closing the panel
    	 * view and open it again creates a second instance of panel, one of
    	 * it is disposed, the new one is active
    	 */
    	if (!panel.isDisposed()) {
    		panel.exitAction();
    		panel.dispose();

    		if (currentTarget != null && currentTarget instanceof Element) {
        		// creates the new panel given the current target
        		panel = createPanel(parent, 0, (Element)currentTarget);
    		} else {
    			panel = createPanel(parent, 0, null);
    		}

    		panel.setBounds(panel.getParent().getBounds());
    		panel.entryAction();
    	}
    }
    
    
    /**
     * Creates the new panel, when switching UI.
     * <p>This class should be overloaded when working with RSA or other tools, using a new PanelFactory
     * @param parent the parent of the new panel
     * @param style the SWT style of this panel
     * @param element the element for which the panel is created
     * @return the newly created panel
     */
    protected CppAbstractPanel createPanel(Composite parent, int style, Element element) {
    	return PanelFactory.eINSTANCE.createPanel(parent, 0, currentTarget);
    }
}