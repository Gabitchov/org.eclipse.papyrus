/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation 
 *    Mathieu Garcia (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Thomas Friol (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.documentation.view;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.documentation.DocumentationManager;
import org.eclipse.papyrus.documentation.IDocumentationChangedListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;

/**
 * A class defining an empty composite to use in an IDocPage. <br>
 * Creation : 10 oct. 2005 <br>
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public abstract class DocPageComposite extends Composite implements IDocumentationChangedListener
{
	IWorkbenchPart activePart = null;

    /**
     * Construct a new empty DocPageComposite.
     * 
     * @param parent the parent composite
     * @param style the composite style
     */
    public DocPageComposite(Composite parent, int style)
    {
        super(parent, style);
        setLayout(new GridLayout());

        this.addDisposeListener(new DisposeListener()
        {
            /**
             * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
             */
            public void widgetDisposed(DisposeEvent e)
            {
                handleDispose();
            }
        });

        DocumentationManager.getInstance().registerDocumentationChangedListener(this);
        createContents(this);
    }
    
    public void setActivePart(IWorkbenchPart part) {
    	activePart = part;
    }

    public IWorkbenchPart getActivePart() {
    	return activePart;
    }

    /**
     * Called when the composite is disposed. <b>Subclasses must release local resources and listeners here.</b>
     */
    protected void handleDispose()
    {
    	DocumentationManager.getInstance().unregisterDocumentationChangedListener(this);
    }

    /**
     * Creates the content of this composite. Clients should override this method to create their own composite.
     * 
     * @param parent the parent composite
     */
    protected abstract void createContents(Composite parent);

    /**
     * Informs this composite that it needs to be refresh.
     */
    protected void refresh()
    {
        // Do nothing
    }

    /**
     * Set the composite read only
     * 
     * @param readOnly
     */
    public void setReadOnly(boolean readOnly)
    {
        this.setEnabled(!readOnly);
    }

    public void documentationChanged(EObject eObject) {
    	// TODO don't refresh if not the documented element
    	if (Display.getCurrent() != Display.getDefault())
    	{
    		Display.getDefault().asyncExec(new Runnable()
    		{
    			public void run()
    			{
    				refresh();
    			}
    		});
    	}
    	else
    	{
    		refresh();
    	}
    }
}
