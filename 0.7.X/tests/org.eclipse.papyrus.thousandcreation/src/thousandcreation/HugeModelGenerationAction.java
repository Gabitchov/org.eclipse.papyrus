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
 *
 *****************************************************************************/
package thousandcreation;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.uml2.uml.Package;


public class HugeModelGenerationAction implements IActionDelegate {

	protected Package selectedPackage;
	protected final static int packageNumber=200;
	protected final static int classNumber=1000;
	protected final static String chars = "abcdefghijklmnopqrstuvwxyz";
	protected final static String mchars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public HugeModelGenerationAction() {
		// TODO Auto-generated constructor stub
	}

/**
 * generate a string
 * @param length the length of the string
 * @return a string
 */
	public static String generateName(int length)
	{
		
		String pass = "";
		for(int i=0;i<length;i++)
		{
			if( i==0){
				int integer = (int)Math.floor(Math.random() * 26); 
				pass += mchars.charAt(integer);
			}
			else{
				int integer = (int)Math.floor(Math.random() * 26); 
				pass += chars.charAt(integer);
			}
		}
		return pass;
	}


	public void run(IAction action) {
		TransactionalEditingDomain editingDomain = EditorUtils
		.getTransactionalEditingDomain();
		if (editingDomain != null && selectedPackage!=null) {
			Command command = new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					for(int i=0; i<packageNumber;i++){
						//create packages
						Package currentPackage=selectedPackage.createNestedPackage(generateName(10));
						for( int j=0; j<classNumber;j++){
						//create classes
							currentPackage.createOwnedClass(generateName(10), false);
						}
						System.out.println("package "+i +"/"+packageNumber+" done.");
					}
				}
			};
			editingDomain.getCommandStack().execute(command);
		}

	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection){
			if( ((IStructuredSelection)selection).getFirstElement() instanceof IAdaptable){
				EObject eObject=(EObject)((IAdaptable)((IStructuredSelection)selection).getFirstElement()).getAdapter(EObject.class);
				if( eObject instanceof Package){
				selectedPackage=(org.eclipse.uml2.uml.Package)eObject;
			}
			}

		}

	}

}
