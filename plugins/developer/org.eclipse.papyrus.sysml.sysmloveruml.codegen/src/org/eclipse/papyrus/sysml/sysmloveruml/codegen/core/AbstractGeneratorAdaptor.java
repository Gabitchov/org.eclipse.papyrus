/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.sysml.sysmloveruml.codegen.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.papyrus.sysml.sysmloveruml.codegen.utils.LabelHelper;

/**
 * Abstract Generator adaptor. Used has based for future generator. it's
 * provide: -> A store mechanism of JETEmitter -> A condition mechanism which
 * select JETEmitter in function of the an argument which extends genBase
 * 
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net
 *         ">arthur.daussy@atos.net</a>"
 * @param <T>
 */
public abstract class AbstractGeneratorAdaptor<T extends GenBase> extends GenBaseGeneratorAdapter {

	/**
	 * Map to store all JETEmitterDescriptor with their corresponding execution
	 * condition.
	 */
	protected Map<JETEmitterDescriptor, Condition<T>> jetEmitterMap = new HashMap<JETEmitterDescriptor, Condition<T>>();

	/**
	 * Super implementation plus initialize the store.
	 */
	public AbstractGeneratorAdaptor() {
		super();
		initializeJETEEMITTERDescriptorStore();
	}

	/**
	 * Super implementation plus initialize the store.
	 * 
	 * @param generatorAdapterFactory
	 *        See super implementation
	 */
	public AbstractGeneratorAdaptor(GeneratorAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);
		initializeJETEEMITTERDescriptorStore();
	}

	/**
	 * Get the getJETEmitterDescriptors which are stored and which are
	 * corresponding condition which is validate with the {@link GenClass} passed in argument.
	 * 
	 * @param genBase
	 *        {@link GenBase} inherited element to compute the {@link JETEmitterDescriptor} according to conditions
	 * @return List of all {@link JETEmitterDescriptor} which correspond to the {@link GenBase} element
	 */
	protected JETEmitterDescriptor[] getJETEmitterDescriptors(T genBase) {
		final ArrayList<JETEmitterDescriptor> result = new ArrayList<JETEmitterDescriptor>();
		for(JETEmitterDescriptor descriptor : jetEmitterMap.keySet()) {
			if(jetEmitterMap.get(descriptor).canGenerate(genBase)) {
				result.add(descriptor);
			}
		}
		if(result.isEmpty()) {
			return new JETEmitterDescriptor[0];
		}
		return result.toArray(new JETEmitterDescriptor[result.size()]);
	}

	@Override
	protected void addBaseTemplatePathEntries(List<String> templatePath) {
		templatePath.add(LabelHelper.TEMPLATE_LOCATION);
		super.addBaseTemplatePathEntries(templatePath);
	}

	/**
	 * Initialize all JETEmitterDescriptor with a condition of execution and put
	 * it in jetEmitterMap.
	 */
	protected abstract void initializeJETEEMITTERDescriptorStore();
}
