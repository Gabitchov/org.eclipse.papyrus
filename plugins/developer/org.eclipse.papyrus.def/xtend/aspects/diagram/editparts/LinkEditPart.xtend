/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.diagram.editparts

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenLink

@Singleton class LinkEditPart extends diagram.editparts.LinkEditPart {
	@Inject aspects.impl.diagram.editparts.LinkEditPart aspectsLinkEditPart;



//BEGIN: PapyrusGenCode
//patches the super type of the link edit part in case the controlled object represents a UML element
override extendsList(GenLink it) '''extends «aspectsLinkEditPart.extendsListContents(it)»'''
//END: PapyrusGenCode
	
}
