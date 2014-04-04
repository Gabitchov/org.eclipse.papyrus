/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt;

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

@Singleton class Common extends xpt.Common {
	override copyright(GenEditorGenerator it) 
	'''
	«IF copyrightText != null»
	/**
	 * «copyrightText.replaceAll('\n', '\n * ')»
	 */
 	«ENDIF»
	'''

}

