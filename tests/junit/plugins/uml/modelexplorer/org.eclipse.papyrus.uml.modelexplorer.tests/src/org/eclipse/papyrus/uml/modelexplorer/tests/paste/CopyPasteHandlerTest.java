/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.tests.paste;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.modelexplorer.tests.Activator;
import org.eclipse.papyrus.views.modelexplorer.tests.AbstractDualHandlerTest;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Assert;
import org.junit.Test;



/**
 * The Class CopyPasteHandlerTest. Test Copy/Paste inside ModelExplorer
 */
public class CopyPasteHandlerTest extends AbstractDualHandlerTest {

	private static final String CLASS2 = "Class2";
	private static final String CLASS1 = "Class1";

	/**
	 * Instantiates a new copy paste handler test.
	 */
	public CopyPasteHandlerTest() {
		super("org.eclipse.ui.edit.copy", "org.eclipse.ui.edit.paste", Activator.getDefault().getBundle());
	}
	
	/**
	 * Simple copy paste of a class1
	 */
	@Test
	public void SimpleCopyPasteofClass1Test() {
		try {
			EObject rootOfTheModel = getRootOfTheModel();
			// check that there is Class1
			Assert.assertEquals("Class1 is missing", getCountElementByName(CLASS1), 1);			
			EObject class1 = getNameElementByName(CLASS1); // get Class1
			
			// select class1
			selectElementInTheModelexplorer(class1);
			
			// copy
			IHandler copyHandler = getActiveHandler();
			Assert.assertTrue(copyHandler.isEnabled());
			copyHandler.execute(new ExecutionEvent());
			
			// select root
			selectElementInTheModelexplorer(rootOfTheModel);
			
			// paste
			IHandler pasteHandler = getSecondActiveHandler();
			Assert.assertTrue(pasteHandler.isEnabled());
			pasteHandler.execute(new ExecutionEvent());
			
			// check that there is 2 Class1 
			Assert.assertEquals("Class1 copy is missing", getCountElementByName(CLASS1), 2);
			
		} catch (ExecutionException e) {
			Assert.fail(e.toString());
		}

	}


	/**
	 * Simple copy pasteof class1 & class2 test.
	 */
	@Test
	public void SimpleCopyPasteofClass1And2Test() {
		try {
			EObject rootOfTheModel = getRootOfTheModel();
			// check that there is Class1 and Class2
			Assert.assertEquals("Class1 is missing", getCountElementByName(CLASS1), 1);
			Assert.assertEquals("Class2 is missing", getCountElementByName(CLASS2), 1);	
			
			EObject class1 = getNameElementByName(CLASS1); // get Class1
			EObject class2 = getNameElementByName(CLASS2); // get Class2
		
			// select Class1 and Class2
			List<EObject> listToCopy = new ArrayList<EObject>();
			listToCopy.add(class1);
			listToCopy.add(class2);
			selectListElementInTheModelexplorer(listToCopy);
			
			// copy
			IHandler copyHandler = getActiveHandler();
			Assert.assertTrue(copyHandler.isEnabled());
			copyHandler.execute(new ExecutionEvent());
			
			// selec root
			selectElementInTheModelexplorer(rootOfTheModel);
			
			// paste
			IHandler pasteHandler = getSecondActiveHandler();
			Assert.assertTrue(pasteHandler.isEnabled());
			pasteHandler.execute(new ExecutionEvent());
			// check that there is 2 Class1 and 2 Class2
			Assert.assertEquals("Class1 copy is missing", getCountElementByName(CLASS1), 2);
			Assert.assertEquals("Class2 copy is missing", getCountElementByName(CLASS2), 2);
			
		} catch (ExecutionException e) {
			Assert.fail(e.toString());
		}

	}
	
	// TODO : all these methods should already exist in or move to some *Utils class
	/**
	 * Gets the name element by name.
	 *
	 * @param name the name
	 * @return the name element by name
	 */
	public EObject getNameElementByName(String name){
		EObject rootOfTheModel = getRootOfTheModel();
		for(EObject child : rootOfTheModel.eContents()) {
			if (child instanceof NamedElement){
				NamedElement namedElement = (NamedElement) child;
				if (name.equals(namedElement.getName())) {
					return namedElement;
				}
			}
		}
		return null;
	}
	
	/**
	 * Gets the count element by name.
	 *
	 * @param name the name
	 * @return the count element by name
	 */
	public int getCountElementByName(String name){
		EObject rootOfTheModel = getRootOfTheModel();
		int i = 0;
		for(EObject child : rootOfTheModel.eContents()) {
			if (child instanceof NamedElement){
				NamedElement namedElement = (NamedElement) child;
				if (name.equals(namedElement.getName())) {
					i++;
				}
			}
		}
		return i;
	}	
	
	/**
	 * Log tree.
	 *
	 * @param i the i
	 * @param root the root
	 */
	public void logTree(int i, EObject root){
		for(int j = 0; j < i; j++) {
			System.out.print("\t");
		}
		if (root instanceof NamedElement){
			System.out.println(((NamedElement)root).getName());
		} else {
			System.out.println(root);
		}
	
		for(EObject child : root.eContents()) {
			logTree(i+1, child);
		} 
	}
}
