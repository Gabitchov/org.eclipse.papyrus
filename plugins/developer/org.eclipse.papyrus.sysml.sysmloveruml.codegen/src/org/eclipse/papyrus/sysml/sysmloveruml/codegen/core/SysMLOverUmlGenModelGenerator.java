/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.sysmloveruml.codegen.core;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.papyrus.sysml.sysmloveruml.codegen.generationUtils.SysMLOverUMLHelper;
/**
 * Generator for model elements.
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>"
 *
 */
public class SysMLOverUmlGenModelGenerator extends AbstractGeneratorAdaptor<GenModel> {

	/**
	 * Id.
	 */
	private static final String GENERATOR_LABEL = Messages.SysMLOverUmlGenModelGenerator_GENERATOR_LABEL;

	/**
	 * Name of the generator.
	 */
	private static final int CHANGE_ELEMENT_ID = 0;

	@Override
	protected Diagnostic generateEdit(Object object, Monitor monitor) {
		final GenModel genModel = (GenModel)object;
		monitor.beginTask("", 2); //$NON-NLS-1$
		message = GENERATOR_LABEL;
		monitor.subTask(message);
		// final GenModel genModel = genClass.getGenModel();
		ensureProjectExists(genModel.getEditDirectory(), genModel, MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), createMonitor(monitor, 1));
		/**
		 * Generate only if there at least one good template to generate
		 */
		final JETEmitterDescriptor[] emitters = getJETEmitterDescriptors(genModel);
		if(emitters.length > 0) {
			generateJava(genModel.getEditDirectory(), SysMLOverUMLHelper.getAdapterFactoryRegistryPackageName(), SysMLOverUMLHelper.getAdapterFactoryRegistryClassName(), getJETEmitter(getJETEmitterDescriptors(genModel), CHANGE_ELEMENT_ID), null, createMonitor(monitor, 1));
		}
		return Diagnostic.OK_INSTANCE;
	}

	@Override
	protected void initializeJETEEMITTERDescriptorStore() {
		final Condition<GenModel> trueCondition = new Condition<GenModel>() {

			public boolean canGenerate(GenModel gen) {
				return true;
			}
		};
		jetEmitterMap.put(new JETEmitterDescriptor(Messages.SysMLOverUmlGenModelGenerator_SysMLAdapterFactoryRegisteryTemplate, Messages.SysMLOverUmlGenModelGenerator_package), trueCondition);
	}

	public SysMLOverUmlGenModelGenerator() {
		super();
	}

	public SysMLOverUmlGenModelGenerator(GeneratorAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);
	}
}
