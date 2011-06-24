/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.dialogs;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkContentProvider;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkLabelProvider;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * dialog to display a list of hyperlinks.
 * the button ok is use to excute the action linked to the hyperlink (open new diagram, open new editor...) 
 *
 */
public class DiagramNavigationDialog extends Dialog {

	//prefered dimension
	protected int width=350;
	protected int height=150;
	
	protected ArrayList<HyperlinkObject> hyperlinkObjects;
	protected HyperLinkContentProvider contentProvider;
	private TableViewer tableViewer;
	
	protected Table availableHyperLink;
	
	protected ArrayList<HyperlinkObject> hyperlinkResult= new ArrayList<HyperlinkObject>();

	/**
	 * 
	 *dialog to display a list of hyperlinks.
	 * the button ok is use to excute the action linked to the hyperlink (open new diagram, open new editor...) 
	 *
	 * @param parentShell a shell
	 * @param hyperlinkObjects the list of hyperlinkObjects
	 */
	public DiagramNavigationDialog(Shell parentShell, ArrayList<HyperlinkObject> hyperlinkObjects) {
		super(parentShell);
		this.hyperlinkObjects=hyperlinkObjects;
		parentShell.setText("Choose hyperlink:");
	}
	@Override
	protected Control createContents(Composite parent) {
		
		parent.setBounds(parent.getBounds().x, parent.getBounds().y, width+50, height+120);
		Composite defaultHyperlinkComposite = new Composite(parent, SWT.NONE);
		

		Label lblHyperlinks = new Label(defaultHyperlinkComposite, SWT.NONE);
		lblHyperlinks.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
		lblHyperlinks.setBounds(23, 10,width , 13);
		lblHyperlinks.setText("Which hyperlinks would you like to navigate to?");


		//creation of the table
		availableHyperLink = new Table(defaultHyperlinkComposite, SWT.CHECK|SWT.BORDER | SWT.FULL_SELECTION);
		availableHyperLink.setBounds(30, 29, width, height);
		super.createContents(parent);
		 
		 //set the content provider
		 this.contentProvider= new HyperLinkContentProvider();
		 tableViewer = new TableViewer(availableHyperLink);
		 tableViewer.setContentProvider(contentProvider);
		 
		 
		 //set the label provider
		 IPageIconsRegistry editorRegistry=null;
			IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();
			try {
				editorRegistry= papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		 tableViewer.setLabelProvider(new HyperLinkLabelProvider(editorRegistry));
		 tableViewer.setInput(this.hyperlinkObjects);
		
		 return defaultHyperlinkComposite;
	}
	
	/**
	 * get the list of selected hyperlinks
	 * @return the list
	 */
	public ArrayList<HyperlinkObject> getSelectedHyperlinks(){
		return hyperlinkResult;
		
	}
	/**
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 *
	 */
	protected void okPressed() {
	
		hyperlinkResult= new ArrayList<HyperlinkObject>();
		TableItem[] tableItems=availableHyperLink.getItems();
		for(int i=0;i<tableItems.length;i++){
			if(tableItems[i].getChecked()){
				hyperlinkResult.add((HyperlinkObject)tableItems[i].getData());
			}
		}
		
		super.okPressed();
	}
}
