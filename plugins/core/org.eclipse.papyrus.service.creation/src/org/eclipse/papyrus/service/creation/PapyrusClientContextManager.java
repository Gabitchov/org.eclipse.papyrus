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
package org.eclipse.papyrus.service.creation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;

/**
 * this class contains method to access directly to IElement type or context used for Papyrus
 */
public class PapyrusClientContextManager {
	
	/**
	 * 
	 * @return the list of all IElementType that from all IClient context that are attached to a IPapyrusContextMatcher
	 */
	public static Set<IElementType> getAllElementTypes(){
		HashSet<IElementType> allElementTypes= new HashSet<IElementType>();
		Iterator<IClientContext>iterator=getAllCreationContext().iterator();
		while (iterator.hasNext()) {
			IClientContext iClientContext = (IClientContext) iterator.next();
			IElementType[] elementTypes=ElementTypeRegistry.getInstance().getMetamodelTypes(iClientContext);
			allElementTypes.addAll(Arrays.asList(elementTypes));
		}

		return allElementTypes;

	}

/**
 * 
 * @return the list of IClientContext which the matcher is an instance of IPapyrusContextMatcher
 */
	public static Set<IClientContext> getAllCreationContext(){
		Set<IClientContext> result=new HashSet<IClientContext>();
		Set<IClientContext> contextSet=ClientContextManager.getInstance().getClientContexts();
		Iterator<IClientContext> iterContext= contextSet.iterator();
		while (iterContext.hasNext()) {
			IClientContext iClientContext = (IClientContext) iterContext.next();

			//here filter by id to avoid gmf generated context, in the future, it will be all iclientcontext
			if (iClientContext.getMatcher() instanceof IPapyrusContextMatcher){
				result.add(iClientContext);
			}
		}
		return result;
	}

	/**
	 * 
	 * @return the list of filter that are attached to Papyrus client Context
	 */
	public static Set<PapyrusEditHelperFilter> getAllFilters(){

		Set<PapyrusEditHelperFilter> adviceset= new HashSet<PapyrusEditHelperFilter>();	
		Set<IElementType> elementTypesSet= getAllElementTypes();
		Iterator<IElementType> iter= elementTypesSet.iterator();
		while(iter.hasNext()){
			IEditHelperAdvice[] currentElement=ElementTypeRegistry.getInstance().getEditHelperAdvice(iter.next());
			for(int j =0; j <currentElement.length;j++){
				if(currentElement[j] instanceof PapyrusEditHelperFilter){
					adviceset.add((PapyrusEditHelperFilter)currentElement[j]);
				}
			}
		}
		return adviceset;
	}

}
