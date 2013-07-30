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
package org.eclipse.papyrus.uml.diagram.common.ui.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ParameterableElement;

/**
 * this classs is used to display a ui in order to look for a kind of element, with a treeviewer 
 *
 */
public class ElementChooseDialog extends AbstractChooseElement {

	/** The adapter factory. */
	protected AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/** The tree viewer. */
	protected TreeViewer treeViewer;
	/** the root element*/
	protected Element context;
	/** the selected element**/
	protected Element selectedElement=null;
	/** the kind of element that we do not want to select**/
	protected List<EClass> notWanted=new ArrayList<EClass>();

	/** the kind of element that we look for**/
	private EClass elementtype;

/**
 * 
 * @return the selected element
 */
	public Element getSelectedElement() {
		return selectedElement;
	}
	/**
	 * 
	 * create the dialog box
	 *
	 * @param parent the parent shell
	 * @param style the style of the dialog box
	 * @param context the root element where we look for
	 * @param elementtype the kind of element that we look for
	 */
	public ElementChooseDialog(Shell parent, int style, Element context,EClass elementtype) {
		super(parent, style);
		this.context=context;
		this.elementtype=elementtype;
		this.notWanted=new ArrayList<EClass>();
	}
	/**
	 * 
	 * Create the dialobox
	 *
	 * @param parent the parent shell
	 * @param style the style of the dialog box
	 * @param context the root element where we look for
	 * @param elementtype the kind of element that we look for
	 * @param notWanted the list of element that we do not want to select (list of subclasses of elementtype) cannot be null 
	 */
	public ElementChooseDialog(Shell parent, int style, Element context,EClass elementtype,List<EClass> notWanted) {
		super(parent, style);
		this.context=context;
		this.elementtype=elementtype;
		assert(notWanted!=null);
		this.notWanted=notWanted;
	}
	
	@Override
	protected void createContents() {
		// TODO Auto-generated method stub
		super.createContents();
		// intall tree with uml element
		treeViewer = filtercontrol.getViewer();
		treeViewer.setUseHashlookup(true);
		
		//inner class of filter. 
		//display a parent if its childreen can be choosen
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		ViewerFilter filter= new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof EObject){//it contains nothing 
					EObject eObject=(EObject)element;
					if(eObject.eContents().size()==0){
						return isSelectableEobject(eObject);
					}
					else{ //it contains something so we have to test children before
						boolean result=false;
						if(isSelectableEobject(eObject)){
							return true;
						}

						Iterator<EObject>iter=eObject.eAllContents();
						while(iter.hasNext()){
							EObject subEObject= iter.next();
							boolean contains=select(viewer,eObject,subEObject);
							result=result||contains;
						}
						return result;


					}
				}
				return false;
			}
		};
		ViewerFilter[] filters={filter};
		treeViewer.setFilters(filters);

		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		treeViewer.setInput(context);


		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object selection = ((IStructuredSelection)filtercontrol.getViewer().getSelection()).getFirstElement();
				if(selection instanceof EObject ) {
					if(isSelectableEobject(((EObject)selection))){
						btnSelect.setEnabled(true);
						result = (ParameterableElement)selection;
						selectedElement= (ParameterableElement)selection;
					}
					else{
						btnSelect.setEnabled(false);
						result = null;
						selectedElement= null;
					}
				}

			}
		});
		btnSelect.addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				getParent().close();
			}

			public void mouseDown(MouseEvent e) {}
			public void mouseDoubleClick(MouseEvent e) {}
		});

		btnCancel.addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				result=null;
				selectedElement=null;
				getParent().close();
			}

			public void mouseDown(MouseEvent e) {}
			public void mouseDoubleClick(MouseEvent e) {}
		});
	}
	
	/**
	 * 
	 * @param eObject that we want to test
	 * @return true if the eobject can be choosen, ie this is an instance of elementType and not instance of all type contained into notWanted 
	 */
	protected boolean isSelectableEobject(EObject eObject){
		if(elementtype.isSuperTypeOf(eObject.eClass())){
			if(notWanted.size()>0){
				Iterator<EClass> iternotwanted= notWanted.iterator();
				while( iternotwanted.hasNext()){
					if(iternotwanted.next().isSuperTypeOf(eObject.eClass())){
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
}
