/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.views.documentation.view.actions.AddElementLinkAction;
import org.eclipse.papyrus.views.documentation.view.actions.DeleteTableColumnAction;
import org.eclipse.papyrus.views.documentation.view.actions.DeleteTableRowAction;
import org.eclipse.papyrus.views.documentation.view.actions.InsertTableColumnAction;
import org.eclipse.papyrus.views.documentation.view.actions.InsertTableRowAction;
import org.eclipse.papyrus.views.documentation.view.actions.TextColorAction;
import org.eclipse.papyrus.views.documentation.view.actions.TextHighlightAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.IRichTextToolBar;
import org.eclipse.epf.richtext.RichText;
import org.eclipse.epf.richtext.RichTextToolBar;
import org.eclipse.epf.richtext.actions.AddImageAction;
import org.eclipse.epf.richtext.actions.AddLinkAction;
import org.eclipse.epf.richtext.actions.AddOrderedListAction;
import org.eclipse.epf.richtext.actions.AddTableAction;
import org.eclipse.epf.richtext.actions.AddUnorderedListAction;
import org.eclipse.epf.richtext.actions.BoldAction;
import org.eclipse.epf.richtext.actions.ClearContentAction;
import org.eclipse.epf.richtext.actions.CopyAction;
import org.eclipse.epf.richtext.actions.CutAction;
import org.eclipse.epf.richtext.actions.FindReplaceAction;
import org.eclipse.epf.richtext.actions.FontNameAction;
import org.eclipse.epf.richtext.actions.FontSizeAction;
import org.eclipse.epf.richtext.actions.FontStyleAction;
import org.eclipse.epf.richtext.actions.IndentAction;
import org.eclipse.epf.richtext.actions.ItalicAction;
import org.eclipse.epf.richtext.actions.JustifyCenterAction;
import org.eclipse.epf.richtext.actions.JustifyLeftAction;
import org.eclipse.epf.richtext.actions.JustifyRightAction;
import org.eclipse.epf.richtext.actions.OutdentAction;
import org.eclipse.epf.richtext.actions.PasteAction;
import org.eclipse.epf.richtext.actions.SubscriptAction;
import org.eclipse.epf.richtext.actions.SuperscriptAction;
import org.eclipse.epf.richtext.actions.TidyActionGroup;
import org.eclipse.epf.richtext.actions.UnderlineAction;

/**
 * A dialog using a RichText and its Toolbar to change a documentation
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class RichTextEditorDialog extends Dialog
{
    /** The minimum width of the dialog */
    private static final int MINIMUM_DIALOG_WIDTH = 600;

    /** The minimum height of the dialog */
    private static final int MINIMUM_DIALOG_HEIGHT = 300;

    private RichText commentsText;

    private String initialValue;

    private String newValue;
    
    /**
     * Constructor
     * 
     * @param parentShell the parent Shell
     * @param initialValue initial documentation value
     */
    public RichTextEditorDialog(Shell parentShell, String initialValue)
    {
        super(parentShell);

        setBlockOnOpen(true);
        setShellStyle(getShellStyle() | SWT.RESIZE);

        this.initialValue = initialValue;
    }
    
    /**
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell newShell)
    {
        newShell.setText(Messages.RichTextEditorDialog_useRichText);
        newShell.setMinimumSize(MINIMUM_DIALOG_WIDTH, MINIMUM_DIALOG_HEIGHT);

        super.configureShell(newShell);
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent)
    {
        Composite dialogComposite = (Composite) super.createDialogArea(parent);

        RichTextToolBar toolBar = new RichTextToolBar(dialogComposite, SWT.NONE, commentsText);
        Composite container = new Composite(dialogComposite, SWT.BORDER);
        GridLayout richTextLayout = new GridLayout();
        richTextLayout.marginWidth = 0;
        richTextLayout.marginHeight = 0;
        container.setLayout(richTextLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));
        commentsText = new RichText(container, SWT.NONE);
        commentsText.setLayoutData(new GridData(GridData.FILL_BOTH));
        commentsText.setText(initialValue);
        commentsText.setFocus();
        fillToolBar(toolBar, commentsText);

        return dialogComposite;
    }

    /**
     * Populate actions in the Toolbar to link with the RichText
     * 
     * @param toolBar The IRichTextToolBar
     * @param richText The IRichText
     */
    private void fillToolBar(IRichTextToolBar toolBar, IRichText richText)
    {
        toolBar.addAction(new FontStyleAction(richText));
        toolBar.addAction(new FontNameAction(richText));
        toolBar.addAction(new FontSizeAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new CutAction(richText));
        toolBar.addAction(new CopyAction(richText));
        toolBar.addAction(new PasteAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new ClearContentAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new BoldAction(richText));
        toolBar.addAction(new ItalicAction(richText));
        toolBar.addAction(new UnderlineAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new TextColorAction(richText));
        toolBar.addAction(new TextHighlightAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new SubscriptAction(richText));
        toolBar.addAction(new SuperscriptAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new TidyActionGroup(richText));
        toolBar.addSeparator();
        toolBar.addAction(new AddOrderedListAction(richText));
        toolBar.addAction(new AddUnorderedListAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new OutdentAction(richText));
        toolBar.addAction(new IndentAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new JustifyLeftAction(richText));
        toolBar.addAction(new JustifyCenterAction(richText));
        toolBar.addAction(new JustifyRightAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new FindReplaceAction(richText)
        {
            /**
             * @see org.eclipse.epf.richtext.actions.FindReplaceAction#execute(org.eclipse.epf.richtext.IRichText)
             */
            @Override
            public void execute(IRichText rText)
            {
                rText.getFindReplaceAction().execute(rText);
            }
        });
        toolBar.addSeparator();
        toolBar.addAction(new AddLinkAction(richText));
        toolBar.addAction(new AddElementLinkAction(richText));
        toolBar.addAction(new AddImageAction(richText));
        toolBar.addSeparator();
        toolBar.addAction(new AddTableAction(richText));
        
        // Only add these actions when IE is used to render the Browser
        if (Platform.getOS().equals("win32")) { //$NON-NLS-1$
            toolBar.addAction(new InsertTableColumnAction(richText));
            toolBar.addAction(new DeleteTableColumnAction(richText));
            toolBar.addAction(new InsertTableRowAction(richText));
            toolBar.addAction(new DeleteTableRowAction(richText));
        }
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    @Override
    protected void okPressed()
    {
        newValue = commentsText.getText();

        super.okPressed();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}
	
    /**
     * This method returns the text contained in the <code>RichTextCommentsComposite</code>
     * 
     * @return the text contained in the <code>RichTextCommentsComposite</code>
     */
    public String getDocumentationValue()
    {
        return newValue;
    }
}
