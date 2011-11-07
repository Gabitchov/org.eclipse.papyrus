/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * This class is a JFace dialog in which you can select different type of
 * resources. You can select workspace, external and remote resources. The
 * result is a type of resources. <br/> Creation : 10 oct. 2005
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public class TypedResourcesSelectionDialog extends Dialog
{
    /**
     * Constant defining the workspace resource type.
     */
    public static final int WORKSPACE_RESOURCE = 0;

    /**
     * Constant defining the external resource type.
     */
    public static final int EXTERNAL_RESOURCE = 1;

    /**
     * Constant defining the remote resource type.
     */
    public static final int REMOTE_RESOURCE = 2;

    private int selectedType = WORKSPACE_RESOURCE;

    private Button workspaceTypeButton;

    private Button externalTypeButton;

    private Button remoteTypeButton;

    private SelectionListener selectionListener = new SelectionAdapter()
    {
        public void widgetSelected(SelectionEvent e)
        {
            if (e.getSource() == remoteTypeButton)
            {
                selectedType = REMOTE_RESOURCE;
            }
            else if (e.getSource() == externalTypeButton)
            {
                selectedType = EXTERNAL_RESOURCE;
            }
            else
            {
                selectedType = WORKSPACE_RESOURCE;
            }
        }
    };

    /**
     * Constructor.
     * 
     * @param parentShell the parent shell
     */
    public TypedResourcesSelectionDialog(Shell parentShell)
    {
        super(parentShell);
    }

    /**
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell newShell)
    {
        super.configureShell(newShell);
        newShell.setText("Resource type selection");
    }

    /**
     * Return the selected resource type.
     * 
     * @return the selected resource type
     */
    public int getType()
    {
        return selectedType;
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent)
    {
        Composite container = (Composite) super.createDialogArea(parent);

        Label label = new Label(container, SWT.NONE);
        label.setText("Please choose the type of resource to select.");

        Composite typeComposite = new Composite(container, SWT.NONE);
        typeComposite.setLayout(new GridLayout(3, true));
        typeComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));

        workspaceTypeButton = new Button(typeComposite, SWT.RADIO);
        workspaceTypeButton.setText("Workspace");
        workspaceTypeButton.addSelectionListener(selectionListener);
        workspaceTypeButton.setSelection(true);

        externalTypeButton = new Button(typeComposite, SWT.RADIO);
        externalTypeButton.setText("External");
        externalTypeButton.addSelectionListener(selectionListener);

        remoteTypeButton = new Button(typeComposite, SWT.RADIO);
        remoteTypeButton.setText("Remote");
        remoteTypeButton.addSelectionListener(selectionListener);

        return container;
    }
}
