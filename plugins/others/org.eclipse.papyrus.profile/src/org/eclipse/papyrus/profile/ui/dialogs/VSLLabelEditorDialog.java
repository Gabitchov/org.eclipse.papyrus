/*******************************************************************************
 * Copyright (c) 2007 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.profile.ui.dialogs;


import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
//import org.eclipse.papyrus.parsers.texteditor.vsldatatypes.VSLLabelSourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.DataType;


// import com.cea.nfp.parsers.texteditor.vsldatatypes.VSLLabelSourceViewerConfiguration;

public class VSLLabelEditorDialog extends LabelEditorDialog {

	final private static String TITLE = "DataType Valuation";
	private String datatypeName;
	
	// final private static String MESSAGE = "enter Property name";
	
	//private Property property;
	private DataType datatype;
	
	private Document tvlLabelDocument;
	
	private String value;
	
    //1.The nfpLanguage must be removed and defined as a configuration parameter
    //2.This variable is replicated in the NewAction class: we must remove both
    
	
	//public TVLLabelEditorDialog(Shell parentShell, Property property, String initialValue) {
	//	super(parentShell, TITLE, initialValue, new TVLLabelValidator(property));
	//	this.property = property;
	//	this.value = initialValue;
	//}

	public VSLLabelEditorDialog(Shell parentShell, String initialValue, Integer indexBody, DataType datatype) {
		super(parentShell, TITLE, initialValue, new VSLLabelValidator(datatype));
		this.datatype = datatype;
		this.value = initialValue;
		datatypeName="";
		if (datatype!=null){
			this.datatypeName = datatype.getName();
		}
	}
	
    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            value = this.viewer.getDocument().get();
        } else {
            value = null;
        }
        super.buttonPressed(buttonId);
    }

    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        if (title != null) {
			shell.setText(title);
		}
    }
	
	
    /* (non-Javadoc)
     * @see com.cea.papyrus.utils.dialog.LabelEditorDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent) {
        Group composite = new Group(parent, SWT.RESIZE);
        composite.setText("Type: " + datatypeName);
        GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(2*IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(2*IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        Composite viewerGroup= new Composite(composite, SWT.RESIZE); 
        FillLayout viewerLayout = new FillLayout();
        viewerGroup.setLayout(viewerLayout);
        GridData data = new GridData(GridData.GRAB_HORIZONTAL
              | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL
              | GridData.VERTICAL_ALIGN_CENTER);
        data.widthHint = convertHorizontalDLUsToPixels(2*IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);      
        viewerGroup.setLayoutData(data);
        viewer = new SourceViewer(viewerGroup, null, SWT.BORDER | SWT.FILL_EVEN_ODD );
        
        // configure source viewer
        tvlLabelDocument = new Document();
        tvlLabelDocument.set(value);
        
       // add completion processor key listener (ctrl+space keys) 
        viewer.appendVerifyKeyListener(new TVLLabelKeyListener(viewer));
        
        tvlLabelDocument.addDocumentListener(new DocumentListener());
    
//        ANTLR 2.X
//        viewer.configure(new VSLLabelSourceViewerConfiguration(datatype));
        viewer.setDocument(tvlLabelDocument);
        
        viewer.setSelectedRange(0, value.length());
        errorMessageText = new Text(composite, SWT.READ_ONLY);
        errorMessageText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
                | GridData.HORIZONTAL_ALIGN_FILL));
        errorMessageText.setBackground(errorMessageText.getDisplay()
                .getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
        // Set the error message text
        // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=66292
        setErrorMessage(errorMessage);

        applyDialogFont(composite);
        return composite;
    }

    private class TVLLabelKeyListener implements VerifyKeyListener {
        
        SourceViewer viewer;
        
        /**
         * Default constructor
         */
        public TVLLabelKeyListener(SourceViewer viewer) {
            this.viewer = viewer;
        }
        
        /* (non-Javadoc)
         * @see org.eclipse.swt.custom.VerifyKeyListener#verifyKey(org.eclipse.swt.events.VerifyEvent)
         */
        public void verifyKey(VerifyEvent event) {
            if (event.stateMask == SWT.CTRL && event.character == ' ') {
            	if (viewer.canDoOperation(ISourceViewer.CONTENTASSIST_PROPOSALS)) {
                    viewer.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
                }
                event.doit = false;
            } else if(event.character == SWT.CR) {
                event.doit=false;
            } 
        }
    }
    
    private class DocumentListener implements IDocumentListener {

		public void documentAboutToBeChanged(DocumentEvent event) {
		}

		public void documentChanged(DocumentEvent event) {
			validateInput();
		}
    	
    }
    
}
