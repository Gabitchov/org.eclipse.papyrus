/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.gmf.editpoliciesstates.view;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.gmfdiag.dnd.policy.CustomizableDropEditPolicy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * this class is used to see all editpolicies attached to a editpart
 * It very specify for papyrus.
 * 
 *
 */
public class EditPoliciesStateView extends ViewPart {

	/**
	 * this a object that represents a line into  the table
	 */
	class EditPolicyDescriptor{
		public String role="NO ROLE";
		public EditPolicy policy= null;
	}
	

	private  ArrayList<EditPolicyDescriptor> editPolicyList = new ArrayList<EditPolicyDescriptor>();
	private ISelectionListener myEditPartlistener;
	private TreeViewer viewer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		Viewer viewer = getViewer();
		if (viewer != null && !viewer.getControl().isDisposed()) {

			viewer.getControl().setFocus();
		}
	}

	/**
	 * Create the main tree control
	 * 
	 * @param parent
	 * @return Tree
	 */
	protected Tree createTree(Composite parent) {
		Tree tree = new Tree(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI
			| SWT.FULL_SELECTION);
		tree.setLinesVisible(true);
		return tree;
	}

	/**
	 * Return the viewer.
	 * 
	 * @return TreeViewer
	 */
	protected TreeViewer getViewer() {
		return viewer;
	}
	/**
	 * 
	 * Constructor.
	 *
	 */
	public EditPoliciesStateView() {
		myEditPartlistener = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part, ISelection selection) {

				if(selection instanceof IStructuredSelection) {
					Object[] policiesValue=null;
					Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
					if(selectedobject instanceof GraphicalEditPart) {
						GraphicalEditPart graphicalEP = ((GraphicalEditPart)selectedobject);
						Field policiesFiled = null;
						try {
							policiesFiled = AbstractEditPart.class.getDeclaredField("policies");
						} catch (NoSuchFieldException e ) {
							e.printStackTrace();
						}catch (SecurityException  e) {
							e.printStackTrace();
						}
						policiesFiled.setAccessible(true);

						try {
							policiesValue = (Object[])policiesFiled.get(graphicalEP);
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						}catch (IllegalAccessException e) {
							e.printStackTrace();
						}
						editPolicyList.clear();

						for(int i=0;i<policiesValue.length;i=i+2) {
							EditPolicyDescriptor epd= new EditPolicyDescriptor();
							if(policiesValue[i] instanceof String){
								epd.role=(String)policiesValue[i];
								editPolicyList.add(epd);
							}


							if(policiesValue[i+1] instanceof EditPolicy){
								epd.policy=(EditPolicy)policiesValue[i+1];
							}
						}
						if(viewer!=null){
							viewer.setInput(editPolicyList);
						}
					}

				}
			}
		};
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		selectionService.addSelectionListener(myEditPartlistener);

	}

	protected void createColumns() {
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);

		TreeColumn tcName =new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcName.setText("Name");
		tcName.setWidth(200);
		TreeColumn tcDescription = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcDescription.setText("Description");
		tcDescription.setWidth(800);
	}

	@Override
	public void createPartControl(final org.eclipse.swt.widgets.Composite parent) {
		final IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
		tbm.add(getClearViewAction());
		viewer = new TreeViewer(createTree(parent));
		viewer.setContentProvider(getContentProvider());
		viewer.setLabelProvider(getLabelProvider());
		createColumns();

	}

	protected ITableLabelProvider getLabelProvider(){
		return new EditpolicyLabelProvider();
	}

	protected Action getClearViewAction(){
		return new Action() {

			@Override
			public void run() {
				clear();
			}

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public String getToolTipText() {
				return getText();
			}

			@Override
			public String getText() {
				return "Clear the view";
			}

		};
	}


	protected IContentProvider getContentProvider() {
		return new ITreeContentProvider() {

			public Object[] getElements(final Object inputElement) {
				if(inputElement instanceof Collection<?>) {
					return ((Collection<?>)inputElement).toArray();
				}
				return new Object[0];

			}

			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
				// nothing
			}

			public void dispose() {
				// nothing
			}

			public boolean hasChildren(final Object element) {

				return getChildren(element).length != 0;
			}

			public Object getParent(final Object element) {
				return null;
			}

			public Object[] getChildren(final Object parentElement) {
				if(parentElement instanceof EditPolicyDescriptor) {
					if ( ((EditPolicyDescriptor)parentElement).policy!=null){
						if( ((EditPolicyDescriptor)parentElement).policy  instanceof CustomizableDropEditPolicy){
							Field defaultDropEditPolicyField;
							try {
								defaultDropEditPolicyField = CustomizableDropEditPolicy.class.getDeclaredField("defaultDropEditPolicy");

								Field defaultCreationEditPolicyField = CustomizableDropEditPolicy.class.getDeclaredField("defaultCreationEditPolicy");
								defaultDropEditPolicyField.setAccessible(true);
								defaultCreationEditPolicyField.setAccessible(true);

								EditPolicyDescriptor edp1= new EditPolicyDescriptor();
								EditPolicyDescriptor edp2= new EditPolicyDescriptor();
								edp1.policy=(EditPolicy)defaultDropEditPolicyField.get(((EditPolicyDescriptor)parentElement).policy);
								edp2.policy=(EditPolicy)defaultCreationEditPolicyField.get(((EditPolicyDescriptor)parentElement).policy);
								edp1.role="defaultDropEditPolicy";
								edp2.role="defaultCreationEditPolicy";
								Object[] result= new Object[2];
								result[0]=edp1;
								result[1]=edp2;
								return result;
							} catch (NoSuchFieldException e ) {
								e.printStackTrace();
							}catch (SecurityException e ) {
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							}
						}
					}

				}
				return new Object[0];
			}
		};
	}

	@Override
	public void dispose() {
		super.dispose();
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		selectionService.removeSelectionListener(myEditPartlistener);
		clear();
	}

	private void clear() {
		this.editPolicyList.clear();
	}
}
