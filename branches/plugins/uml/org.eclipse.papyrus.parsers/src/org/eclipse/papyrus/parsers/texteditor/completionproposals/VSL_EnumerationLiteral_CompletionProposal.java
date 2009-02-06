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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
  *****************************************************************************/

package org.eclipse.papyrus.parsers.texteditor.completionproposals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.parsers.messages.NFPMessages;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Property;


public class VSL_EnumerationLiteral_CompletionProposal implements ICompletionProposalComputer {
	
	private static ArrayList<String> enumLiterals;
	private static Enumeration enumeration;
	
	
	public void setDataType(DataType datatype){
		enumeration = (Enumeration) datatype;
	}

	
//	/** Text inserted in the editor */
//	final static private String[] TVL_EnumLiteral_Strings = {
//			"true",
//			"false",
//	};

	/** Text displayed in the information window */
	final static private String[] TVL_Enumeration_StringsInfo = {
			NFPMessages.Enumeration_StringsInfo,
	}; 

	/** Text displayed in the completion area window */
	final static private String[] TVL_Enumeration_StringName = {
		NFPMessages.Enumeration_StringName,
	};

	
	public static void computeTVL_Enumeration_String(){
		enumLiterals = new ArrayList<String>();
		
		if(enumeration!=null){
			Iterator<EnumerationLiteral> iter = enumeration.getOwnedLiterals().iterator();
			while(iter.hasNext()){
				EnumerationLiteral enumLiteral = iter.next();
				enumLiterals.add(enumLiteral.getName());
			}
		}
		else {
			enumLiterals.add("<EnumerationLiteral>");
		}
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see com.cea.papyrus.classdiagram.parsers.texteditor.completionproposals.ICompletionProposalComputer#generateCompletionProposals(int, int, java.lang.String)
	 */
	public List<ICompletionProposal> generateCompletionProposals(int documentOffset, int selectionRange, String prefix) {
		Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();
		
		// adds each Completion proposal
		ICompletionProposal proposal = null;
		computeTVL_Enumeration_String();
		
		// adds all name (static strings...)
		for(int i=0; i < enumLiterals.size(); i++) {
			if(enumLiterals.get(i).startsWith(prefix)) {
				proposal = new CompletionProposal(
						enumLiterals.get(i),
						documentOffset-prefix.length(),
						prefix.length()+selectionRange,
						enumLiterals.get(i).length(),
						null,
						enumLiterals.get(i),
						null,
						TVL_Enumeration_StringsInfo[0]);
				v.add(proposal);
			}
		}


		return v;
	}
}

