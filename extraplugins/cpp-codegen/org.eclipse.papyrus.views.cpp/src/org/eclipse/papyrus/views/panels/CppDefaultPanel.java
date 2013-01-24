/*******************************************************************************
 * Copyright (c) 2006 - 2007 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.views.panels;

import org.eclipse.papyrus.views.cpp.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.Element;


/**
 * Default panel when selection is not relevant.
 */
public class CppDefaultPanel extends CppAbstractPanel {
    
	/** Label used to display text */
    private Label label;

    /**
     * Constructs a new instance of this class given its parent and a style
     * value describing its behavior and appearance.
     * @param parent the composite parent of this element
     * @param style the style for this panel
     * @see SWT
     */
    public CppDefaultPanel(Composite parent, int style) {
        super(parent, style);
    }

    /* (non-Javadoc)
     * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#createContent()
     */
    @Override
    public Control createContent() {
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        this.setLayout(layout);

        label = new Label(this, SWT.NONE);
        label.setText(Activator.getResourceString("panel.default.text"));
        GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 2;
        label.setLayoutData(gridData);

        return null;
    }
    
    /* (non-Javadoc)
     * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#save()
     */
    @Override
    public void save() {
    }

    /* (non-Javadoc)
     * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#getSelectedElement()
     */
    @Override
    public Element getSelectedElement() {
    	return null;
    }
    
    /* (non-Javadoc)
     * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#setSelectedElement(org.eclipse.uml2.uml.Element)
     */
    @Override
    public void setSelectedElement(Element newElement) {
    }

	@Override
	public boolean checkModifications() {
		return false;
	}

	@Override
	protected void refreshPanel() {
		
	}
}