/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - refactored javaInitilizers not to use methods from GMFGen model
 *                               [221347] Got rid of generated interfaces 
 *                               (IObjectInitializer, IFeatureInitializer) and implementation thereof
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.providers

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode

/**
 * XXX should generate this class only when there is initialization logic defined in the model
 */
@Singleton class ElementInitializers extends xpt.providers.ElementInitializers {


	/////////////////////////////////
	override dispatch CharSequence javaMethod(GenNode it) '''
	«IF !it.sansDomain»
	«javaMethod(it.modelFacet, it)»
	«ENDIF»
	'''

	override dispatch CharSequence javaMethod(GenLink it) '''
	«IF !it.sansDomain»
	«javaMethod(it.modelFacet, it)»
	«ENDIF»
	'''


}
