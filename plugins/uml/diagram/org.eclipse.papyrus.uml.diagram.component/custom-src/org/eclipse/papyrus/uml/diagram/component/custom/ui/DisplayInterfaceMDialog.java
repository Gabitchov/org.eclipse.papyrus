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
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.component.custom.command.CreateLollipopPortCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;

/**
 * this interface is used to displayed required and provided interfaces
 *
 */
public class DisplayInterfaceMDialog extends InterfaceManagerDialog {

	protected HashSet<Interface> displayedRequiredInterface=new HashSet<Interface>();
	protected HashSet<Interface> displayedProvidedInterface=new HashSet<Interface>();
	protected PortEditPart portEditPart=null;
	protected HashMap<Interface, GraphicalEditPart> initialList=new HashMap<Interface, GraphicalEditPart>(); 

	/**
	 * 
	 * Constructor.
	 *
	 * @param parentShell
	 * @param portEditPart
	 */
	public DisplayInterfaceMDialog(Shell parentShell, PortEditPart portEditPart) {
		super(parentShell, (Port)portEditPart.resolveSemanticElement());
		this.portEditPart=portEditPart;
		this.selectorLabelProvider=new DisplayedSelectorLabelProvider();
		initDisplayInterfaceList();
	}

	/**
	 * init the collection to detect displayed interfaces
	 */
	protected void initDisplayInterfaceList(){

		if((portEditPart.getSourceConnections().size()>0) ){

			for(Object currentConnection : portEditPart.getSourceConnections()) {
				ConnectionEditPart connection=(ConnectionEditPart) currentConnection;
				EObjectValueStyle valueStyle=(EObjectValueStyle)((View)connection.getModel()).getStyle(NotationPackage.eINSTANCE.getEObjectValueStyle());
				if( valueStyle!=null){
					if(valueStyle.getName().equals("REQUIRED")){
						displayedRequiredInterface.add((Interface)((GraphicalEditPart)connection.getTarget()).resolveSemanticElement());
					}
					else{
						displayedProvidedInterface.add((Interface)((GraphicalEditPart)connection.getTarget()).resolveSemanticElement());
					}
					initialList.put((Interface)((GraphicalEditPart)connection.getTarget()).resolveSemanticElement(),((GraphicalEditPart)connection.getTarget()));

				}
			}
		}

	}

	/**
	 * Overload the result in order to display provided and required interfaces
	 * @see org.eclipse.papyrus.uml.diagram.component.custom.ui.InterfaceManagerDialog#getCommand()
	 *
	 */
	@Override
	public Command getCommand() {
		CompoundCommand cmd= new CompoundCommand();
		Command supCmd=super.getCommand();
		if( supCmd.canExecute()){
			cmd.add(super.getCommand());
		}
		cmd.add(createDisplayedInterfaceCommand());
		return cmd;
	}
	@Override
	protected void createEditors() {
		Composite parent = (Composite)getDialogArea();
		Composite subComposite= new Composite(parent, SWT.NONE);

		subComposite.setLayout(new FormLayout());
		//createDisplay button
		Button Displaybutton = new Button(subComposite, SWT.PUSH);
		Displaybutton.setText("Display seletected Interface");
		DisplayInterfaceListener displayInterfaceListener= new DisplayInterfaceListener();
		Displaybutton.addSelectionListener(displayInterfaceListener);


		FormData formData = new FormData();
		formData.left = new FormAttachment(0,700);
		Displaybutton.setLayoutData(formData);    

		//create Remove
		Button RemoveDisplaybutton = new Button(subComposite, SWT.PUSH);
		RemoveDisplaybutton.setText(" Do not Display selected Interface");
		RemoveDisplayInterfaceListener removeDisplayInterfaceListener= new RemoveDisplayInterfaceListener();
		RemoveDisplaybutton.addSelectionListener(removeDisplayInterfaceListener);

		 formData = new FormData();
		formData.left = new FormAttachment(0,500);
		RemoveDisplaybutton.setLayoutData(formData);    
		
		super.createEditors();
	}
	
	/**
	 * 
	 * @return teh command that will be used to display interfaces
	 */
	protected Command createDisplayedInterfaceCommand(){
		//update list from initial List
		HashMap<Interface, GraphicalEditPart> viewToRemove= new HashMap<Interface, GraphicalEditPart>();
		HashSet<Interface>requiredInterfaceToDisplay= new HashSet<Interface>();
		HashSet<Interface>providedInterfaceToDisplay= new HashSet<Interface>();
		// create the list of provided interface to display
		for(Interface currentInterface : displayedProvidedInterface) {
			if(!initialList.keySet().contains(currentInterface)){
				providedInterfaceToDisplay.add(currentInterface);
			}
		}
		// create the list of required interface to display
		for(Interface currentInterface : displayedRequiredInterface) {
			if(!initialList.keySet().contains(currentInterface)){
				requiredInterfaceToDisplay.add(currentInterface);
			}
		}
		// create the list of interface to not display
		for(Interface currentInterface : initialList.keySet()) {
			if((!displayedRequiredInterface.contains(currentInterface))&&(!displayedProvidedInterface.contains(currentInterface))){
				viewToRemove.put(currentInterface, initialList.get(currentInterface));
			}
		}
		
		CompoundCommand cmd= new CompoundCommand();
		CreateLollipopPortCommand comd= new CreateLollipopPortCommand(this.portEditPart.getEditingDomain(),providedInterfaceToDisplay, requiredInterfaceToDisplay , this.portEditPart);
		cmd.add( new org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper(comd));
		if(viewToRemove.values().size()>0 ){
			cmd.add(deleteDisplayInterface(viewToRemove.values()));
		}
		return cmd;
	}

	/**
	 * @param editPartToRemove list of editpart that represents displayed interfaces, never null
	 * @return the command of interface representation to remove, never null
	 */
	protected Command deleteDisplayInterface(Collection<GraphicalEditPart> editPartToRemove){
		CompoundCommand cmd= new CompoundCommand();
		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		
		
		for(GraphicalEditPart editPart : editPartToRemove) {
			cmd.add(editPart.getCommand(deleteViewRequest));
		}

		return cmd;
	}

	/**
	 * inner to class  attached to a button to display  interfaces
	 *
	 */
	class DisplayInterfaceListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent event) {
			IStructuredSelection selection = (IStructuredSelection)providedEditor.getSelectedElementsViewer().getSelection();
			for(Object o : selection.toArray()) {
				displayedProvidedInterface.add((Interface)o);
			}
			selection = (IStructuredSelection)requiredEditor.getSelectedElementsViewer().getSelection();
			for(Object o : selection.toArray()) {
				displayedRequiredInterface.add((Interface)o);
			}
			providedEditor.getSelectedElementsViewer().refresh();
			requiredEditor.getSelectedElementsViewer().refresh();
		}

	}
	
	/**
	 * inner to class attached to a button to remove displayed  interfaces
	 *
	 */
	class RemoveDisplayInterfaceListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent event) {
			
			IStructuredSelection selection = (IStructuredSelection)providedEditor.getSelectedElementsViewer().getSelection();
			for(Object o : selection.toArray()) {
				displayedProvidedInterface.remove((Interface)o);
			}
			selection = (IStructuredSelection)requiredEditor.getSelectedElementsViewer().getSelection();
			for(Object o : selection.toArray()) {
				displayedRequiredInterface.remove((Interface)o);
			}
			providedEditor.getSelectedElementsViewer().refresh();
			requiredEditor.getSelectedElementsViewer().refresh();
		}

	}


	/**
	 * 
	 * This class provides a CustomLabelProvider for this dialog.
	 * This class manages the {@link NewElementRepresentation} and consider them like Interfaces
	 * 
	 * 
	 */
	public class DisplayedSelectorLabelProvider extends SelectorLabelProvider {


		@Override
		protected Image getImage(EObject element) {
			if(displayedRequiredInterface.contains(element)||displayedProvidedInterface.contains(element)){
				return UMLDiagramEditorPlugin.findImageDescriptor("icons/obj16/lollipop.gif").createImage();
			}
			return super.getImage(element);
		}

	}
}
