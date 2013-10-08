package org.eclipse.papyrus.uml.diagram.component.custom.ui;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.common.command.wrappers.EMFtoGEFCommandWrapper;
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


public class DisplayInterfaceMDialog extends InterfaceManagerDialog {

	protected HashSet<Interface> displayedInterface=new HashSet<Interface>();
	protected PortEditPart portEditPart=null;

	public DisplayInterfaceMDialog(Shell parentShell, PortEditPart portEditPart) {
		super(parentShell, (Port)portEditPart.resolveSemanticElement());
		this.portEditPart=portEditPart;
		this.selectorLabelProvider=new DisplayedSelectorLabelProvider();
	}

	protected void updateDisplayInterfaceList(Interface anInterface){

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
		Button Displaybutton = new Button(subComposite, SWT.PUSH);
		Displaybutton.setText("DisplayInterface");
		DisplayInterfaceListener displayInterfaceListener= new DisplayInterfaceListener();
		Displaybutton.addSelectionListener(displayInterfaceListener);


		FormData formData = new FormData();
		formData.left = new FormAttachment(0,700);
		Displaybutton.setLayoutData(formData);    


		super.createEditors();
	}
	protected Command createDisplayedInterfaceCommand(){
		CreateLollipopPortCommand cmd= new CreateLollipopPortCommand(this.portEditPart.getEditingDomain(), displayedInterface, new ArrayList<Interface>(), this.portEditPart);
		return new org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper(cmd);
	}

	//inner to class to display displayed interfaces
	class DisplayInterfaceListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent event) {
			displayedInterface.clear();
			IStructuredSelection selection = (IStructuredSelection)providedEditor.getSelectedElementsViewer().getSelection();
			for(Object o : selection.toArray()) {
				displayedInterface.add((Interface)o);
			}
			selection = (IStructuredSelection)requiredEditor.getSelectedElementsViewer().getSelection();
			for(Object o : selection.toArray()) {
				displayedInterface.add((Interface)o);
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
			if(displayedInterface.contains(element)){
				return UMLDiagramEditorPlugin.findImageDescriptor("icons/obj16/lollipop.gif").createImage();
			}
			return super.getImage(element);
		}

	}
}
