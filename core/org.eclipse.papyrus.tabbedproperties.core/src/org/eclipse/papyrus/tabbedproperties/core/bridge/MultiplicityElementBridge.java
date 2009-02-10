/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.tabbedproperties.core.bridge;

import java.util.StringTokenizer;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * this class is used to manage the mapping between text and  model about multiplicity
 * @author Patrick Tessier
 *
 */
public class MultiplicityElementBridge implements Extractor, Injector{

	public String extract(Element element) {
		String out="";
		final String lower = String.valueOf(((MultiplicityElement)element).getLower());
		final String upper = String.valueOf(((MultiplicityElement)element).getUpper());
		if(upper.equals("-1")) {
			out=""+lower+".."+"*";
		} else {
			out=""+lower+".."+upper;
		}
		return out;
	}

	public void inject(String newValue, Element element, TransactionalEditingDomain domain) {
		final StringTokenizer mulToken = new StringTokenizer(newValue, "..");
		String lower = mulToken.nextToken();
		String upper = lower;
		if(mulToken.countTokens()>0) {
			upper = mulToken.nextToken();
		}

		// property multiplicity settings
		if(lower.equals("*")) {
			upper = "-1";
			lower = "0";
		}
		else if(upper.equals("*")) {
			upper="-1";
		}

		if (element instanceof MultiplicityElement) {
			final LiteralInteger eltLower= UMLFactory.eINSTANCE.createLiteralInteger();
			eltLower.setValue(Integer.parseInt(lower));
			SetValueCommand command0 = new SetValueCommand(domain, element, UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue(), (Object)eltLower);
		
			
			final LiteralUnlimitedNatural eltUpper= UMLFactory.eINSTANCE.createLiteralUnlimitedNatural();
			eltUpper.setValue(Integer.parseInt(upper));
			SetValueCommand command1 = new SetValueCommand(domain, element, UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue(), eltUpper);
			domain.getCommandStack().execute(command0.chain(command1));
		}
	}

}
