/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core.exporter.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareModelSet;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.Iterables;


/**
 * This is the AbstractModelExportTest type. Enjoy.
 */
public abstract class AbstractModelExportTest extends AbstractPapyrusCDOTest {

	protected static final String DEPENDENT_MODEL_NAME = "dependent.uml";

	protected static final String DEPENDENCY_MODEL_NAME = "dependency.uml";

	protected static final String DEPENDENT_MODEL_DI = "dependent.di";

	protected static final String DEPENDENCY_MODEL_DI = "dependency.di";

	protected void createModels() throws Exception {
		ServicesRegistry[] services = { null };

		// create the model that the other model depends on
		ModelSet modelSet = createModelSet(DEPENDENCY_MODEL_NAME, services);

		UmlModel uml = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
		Model model = (Model)uml.lookupRoot();
		model.createOwnedClass("Superclass", false);

		modelSet.save(new NullProgressMonitor());

		services[0].disposeRegistry();

		// create the model that depends on the first one
		modelSet = createModelSet(DEPENDENT_MODEL_NAME, services);

		uml = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
		model = (Model)uml.lookupRoot();
		Class subclass = model.createOwnedClass("Subclass", false);

		// add the dependency
		Model dependency = UML2Util.load(modelSet, getTestResourceURI(DEPENDENCY_MODEL_NAME), UMLPackage.Literals.MODEL);
		model.createPackageImport(dependency);
		subclass.createGeneralization((Class)dependency.getOwnedType("Superclass"));

		modelSet.save(new NullProgressMonitor());

		services[0].disposeRegistry();
	}

	protected ModelSet createModelSet(String name, ServicesRegistry[] outServices) throws Exception {

		outServices[0] = new ExtensionServicesRegistry(Activator.PLUGIN_ID);

		try {
			// start the ModelSet and its dependencies
			outServices[0].startServicesByClassKeys(ModelSet.class);
		} catch (ServiceMultiException e) {
			for(ServiceNotFoundException next : Iterables.filter(e.getExceptions(), ServiceNotFoundException.class)) {
				assertThat(next.getLocalizedMessage(), not(containsString("ModelSet")));
			}
		}

		ModelSet result = outServices[0].getService(ModelSet.class);

		assumeThat(result, instanceOf(CDOAwareModelSet.class));

		result.createModels(getTestResourceURI(name));

		// load blank model
		Resource uml = ((AbstractBaseModel)result.getModel(UmlModel.MODEL_ID)).getResource();
		Resource notation = ((AbstractBaseModel)result.getModel(NotationModel.MODEL_ID)).getResource();
		Resource di = ((AbstractBaseModel)result.getModel(DiModel.MODEL_ID)).getResource();
		loadTemplate("empty", "model", uml, notation, di);

		return result;
	}

	protected IModelTransferNode getNode(IModelTransferConfiguration config, URI uri) {
		IModelTransferNode result = null;

		for(IModelTransferNode next : config.getModelsToTransfer()) {
			if(next.getPrimaryResourceURI().equals(uri)) {
				result = next;
				break;
			}
		}

		return result;
	}

}
