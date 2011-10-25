/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * this is the tab in charge to display the hyperlink dor the property defaut 
 *
 */
public class DefaultHyperLinkTab {

	protected TableViewer availableHyperLinkViewer;
	protected Button defaultHRight;
	protected Button defaultHleft;
	protected Button defaultHup;
	protected Button defaultHdown;
	protected TableViewer defaultHyperLinkViewer;
	protected ArrayList<HyperlinkObject> defaultHyperLinkObject= new ArrayList<HyperlinkObject>();
	protected ArrayList<HyperlinkObject> availableHyperLinkObject=new ArrayList<HyperlinkObject>();
	protected Composite defaultHyperlinkComposite;
	
	
	/**
	 * 
	 * @return get the list of hyperlink that are to be as default hyperlinks
	 */
	public ArrayList<HyperlinkObject> getDefaultHyperLinkObject() {
		return defaultHyperLinkObject;
	}
	/**
	 * 
	 * Constructor.
	 *
	 * @param tabFolder the parent tabfolder
	 * @param hyperLinkObjectList the list of hyperlinks
	 */

	public  DefaultHyperLinkTab(CTabFolder tabFolder, ArrayList<HyperlinkObject> hyperLinkObjectList){
		CTabItem tbtmDefaultsHyperlinks = new CTabItem(tabFolder, SWT.NONE);
		tbtmDefaultsHyperlinks.setText("Defaults HyperLinks");
		defaultHyperlinkComposite = new Composite(tabFolder, SWT.NONE);
		
		defaultHyperlinkComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		tbtmDefaultsHyperlinks.setControl(defaultHyperlinkComposite);

		Label lblHyperlinks = new Label(defaultHyperlinkComposite, SWT.NONE);
		lblHyperlinks.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		lblHyperlinks.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
		lblHyperlinks.setBounds(23, 10, 71, 13);
		lblHyperlinks.setText("HyperLinks:");

		Label lblDefaultHyperlinksby = new Label(defaultHyperlinkComposite, SWT.NONE);
		lblDefaultHyperlinksby.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		lblDefaultHyperlinksby.setBounds(366, 10, 186, 13);
		lblDefaultHyperlinksby.setText("Default Hyperlinks (by double-click):");

		Table availableHyperLink = new Table(defaultHyperlinkComposite, SWT.BORDER | SWT.FULL_SELECTION);
		availableHyperLink.setBounds(30, 29, 250, 177);


		defaultHRight = new Button(defaultHyperlinkComposite, SWT.NONE);
		defaultHRight.setBounds(availableHyperLink.getBounds().x+availableHyperLink.getBounds().width+20, 
			availableHyperLink.getBounds().y+availableHyperLink.getBounds().height/2-30, 30, 23);
		defaultHRight.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {

			}
			public void mouseDown(MouseEvent e) {
				//move element left to right
				if(availableHyperLinkViewer.getSelection()!=null){
					//normally this viewer contains only hyperlinkObject
					if(availableHyperLinkViewer.getSelection() instanceof IStructuredSelection ){
						HyperlinkObject hyperlinkObjectToMove= (HyperlinkObject)((IStructuredSelection)availableHyperLinkViewer.getSelection()).getFirstElement();
						hyperlinkObjectToMove.setIsDefault(true);
						availableHyperLinkObject.remove(hyperlinkObjectToMove);
						defaultHyperLinkObject.add(hyperlinkObjectToMove);
						refresh();
					}
				}
			}
			public void mouseDoubleClick(MouseEvent e) {

			}
		});

		defaultHleft = new Button(defaultHyperlinkComposite, SWT.NONE);
		defaultHleft.setBounds(availableHyperLink.getBounds().x+availableHyperLink.getBounds().width+20, 
			availableHyperLink.getBounds().y+availableHyperLink.getBounds().height/2, 30, 23);
		defaultHleft.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {

			}
			public void mouseDown(MouseEvent e) {
				//move element right to left
				if(defaultHyperLinkViewer.getSelection()!=null){
					//normally this viewer contains only hyperlinkObject
					if(defaultHyperLinkViewer.getSelection() instanceof IStructuredSelection ){

						HyperlinkObject hyperlinkObjectToMove= (HyperlinkObject)((IStructuredSelection)defaultHyperLinkViewer.getSelection()).getFirstElement();
						hyperlinkObjectToMove.setIsDefault(false);
						defaultHyperLinkObject.remove(hyperlinkObjectToMove);
						availableHyperLinkObject.add(hyperlinkObjectToMove);
						refresh();
					}
				}
			}
			public void mouseDoubleClick(MouseEvent e) {

			}
		});


		Table defaultHyperLink = new Table(defaultHyperlinkComposite, SWT.BORDER | SWT.FULL_SELECTION);
		defaultHyperLink.setBounds(defaultHRight.getBounds().x+defaultHRight.getBounds().width+20, 29, 250, 177);


		defaultHup = new Button(defaultHyperlinkComposite, SWT.NONE);
		defaultHup.setBounds(defaultHyperLink.getBounds().x+defaultHyperLink.getBounds().width+20,
			defaultHyperLink.getBounds().y+(defaultHyperLink.getBounds().height/2)-30, 34, 23);

		defaultHup.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {

			}
			public void mouseDown(MouseEvent e) {
				//move element bottom to top
				if(defaultHyperLinkViewer.getSelection()!=null){
					//normally this viewer contains only hyperlinkObject
					if(defaultHyperLinkViewer.getSelection() instanceof IStructuredSelection ){

						HyperlinkObject hyperlinkObjectToMove= (HyperlinkObject)((IStructuredSelection)defaultHyperLinkViewer.getSelection()).getFirstElement();
						int index=defaultHyperLinkObject.indexOf(hyperlinkObjectToMove);
						if (index>0){
							defaultHyperLinkObject.remove(hyperlinkObjectToMove);
							defaultHyperLinkObject.add(index-1,hyperlinkObjectToMove);
							refresh();
						}
					}
				}
			}
			public void mouseDoubleClick(MouseEvent e) {

			}
		});

		defaultHdown = new Button(defaultHyperlinkComposite, SWT.NONE);
		defaultHdown.setBounds(defaultHyperLink.getBounds().x+defaultHyperLink.getBounds().width+20, 
			defaultHyperLink.getBounds().y+defaultHyperLink.getBounds().height/2, 34, 23);

		defaultHdown.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {

			}
			public void mouseDown(MouseEvent e) {
				//move element top to bottom
				if(defaultHyperLinkViewer.getSelection()!=null){
					//normally this viewer contains only hyperlinkObject
					if(defaultHyperLinkViewer.getSelection() instanceof IStructuredSelection ){

						HyperlinkObject hyperlinkObjectToMove= (HyperlinkObject)((IStructuredSelection)defaultHyperLinkViewer.getSelection()).getFirstElement();
						int index=defaultHyperLinkObject.indexOf(hyperlinkObjectToMove);
						if (index<defaultHyperLinkObject.size()-1){

							defaultHyperLinkObject.remove(hyperlinkObjectToMove);
							defaultHyperLinkObject.add(index+1,hyperlinkObjectToMove);
							refresh();
						}
					}
				}
			}
			public void mouseDoubleClick(MouseEvent e) {

			}
		});


		// associate image to buttons
		defaultHdown.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowDown_16x16.gif").createImage());
		defaultHup.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowUp_16x16.gif").createImage());
		defaultHleft.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowLeft_16x16.gif").createImage());
		defaultHRight.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowRight_16x16.gif").createImage());



		IPageIconsRegistry editorRegistry=null;
		IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();
		try {
			editorRegistry= papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		//init tableviewer
		availableHyperLinkViewer = new TableViewer(availableHyperLink);
		availableHyperLinkViewer.setLabelProvider(new HyperLinkLabelProvider(editorRegistry));
		availableHyperLinkViewer.setContentProvider(new HyperLinkContentProvider());

		availableHyperLinkViewer.setInput(hyperLinkObjectList);

		defaultHyperLinkViewer = new TableViewer(defaultHyperLink);
		defaultHyperLinkViewer.setLabelProvider(new HyperLinkLabelProvider(editorRegistry));
		defaultHyperLinkViewer.setContentProvider(new HyperLinkContentProvider());

	}

	/** 
	 * 
	 * @return the composite that manage all widgets in the this tab
	 */
	public Composite getMainComposite() {
		return defaultHyperlinkComposite;
	}

	/**
	 * ised to refresh table
	 */
	protected void refresh(){
		availableHyperLinkViewer.setInput(availableHyperLinkObject);
		defaultHyperLinkViewer.setInput(defaultHyperLinkObject);
	}



/**
 * input of this tab
 * 	--> fill all available hyperlinks
 *  --> fill all default hyperlinks
 * @param hyperLinkObjectList the list of hyperlinks
 */
	public void setInput(ArrayList<HyperlinkObject> hyperLinkObjectList) {
		defaultHyperLinkObject.clear();
		availableHyperLinkObject.clear();
		//filter between default and not default
		Iterator<HyperlinkObject> iterator= hyperLinkObjectList.iterator();
		while(iterator.hasNext()) {
			HyperlinkObject hyperlinkObject = (HyperlinkObject)iterator.next();
			if( hyperlinkObject.getIsDefault()){
				defaultHyperLinkObject.add(hyperlinkObject);
			}
			else{
				availableHyperLinkObject.add(hyperlinkObject);
			}

		}
		refresh();

	}
}
