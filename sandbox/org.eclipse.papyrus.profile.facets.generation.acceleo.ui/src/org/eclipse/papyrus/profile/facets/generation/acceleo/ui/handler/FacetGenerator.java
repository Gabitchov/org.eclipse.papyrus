/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.facets.generation.acceleo.ui.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.papyrus.profile.facets.generation.acceleo.Generate;
import org.eclipse.papyrus.profile.facets.generation.postgeneration.FacetSetSplitter;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * This generator is used to "transform" a UML profile in EMF-Facet Facets. Its allows to generate the following files :
 * <ul>
 * <li>facetSet</li>
 * <li>QuerySet</li>
 * <li>java source</li>
 * </ul>
 * 
 */
public class FacetGenerator {

	/** the profile used to generate the facets */
	private final Profile profile;

	/** the base name for the java package */
	private final String basePackageName;

	/** the uri of the model folder */
	private  URI targetModelFolder;

	/** the java source folder */
	private File javaTargetFolder;

	/** the header for the java source */
	private String header;

	/** the list owning the generated ModelQuerySet */
	private final List<EObject> generatedModelQuerySet = new ArrayList<EObject>();

	/** the list owning the generated FacetSet */
	private final List<FacetSet> generatedFacetSet = new ArrayList<FacetSet>();

	/**
	 * 
	 * Constructor.
	 * 
	 * @param profile
	 *        the profile to transform into facet
	 * @param basePackageName
	 *        the base name for the java package generation
	 */
	public FacetGenerator(final Profile profile, final String basePackageName) {
		this.profile = profile;
		this.basePackageName = basePackageName;
	}

	/**
	 * Setter for {@link #targetModelFolder}
	 * 
	 * @param targetModelURI
	 *        the URI of the model folder
	 * 
	 */
	public void setQVTTransformationParameters(final URI targetModelURI){
		this.targetModelFolder = targetModelURI;
	}

	/**
	 * 
	 * @param header
	 *        the header for the java generation
	 * @param javaTargetFolderPath
	 *        the folder for the java source
	 */
	public void setAcceleoTransformationParameter(final String header, final String javaTargetFolderPath){
		this.javaTargetFolder = new File(javaTargetFolderPath);
		this.header = header;
	}

	/**
	 * this method allows to generate the facetSet, the querySet and the required java source
	 */
	public void generate() {
		runQVTTransformation(this.profile, this.targetModelFolder, this.basePackageName);
		runAcceleoTransformation(this.javaTargetFolder);
	}

	/**
	 * 
	 * @param sourceProfile
	 *        the source profile
	 * @param targetURI
	 *        the target folder for the generated files
	 * @param packageName
	 *        the package name
	 */
	private void runQVTTransformation(final Profile sourceProfile, final URI targetURI, final String packageName) {
		URI transformationURI = URI.createPlatformPluginURI("/org.eclipse.papyrus.profile.facets.generation/transforms/ProfileToFacetSet.qvto", true); //$NON-NLS-1$
		TransformationExecutor executor = new TransformationExecutor(transformationURI);

		//Transformation input
		ModelExtent sourceProfileExtent = new BasicModelExtent(Collections.singletonList(sourceProfile));
		ModelExtent umlEcoreExtent = new BasicModelExtent(Collections.singletonList(UMLPackage.eINSTANCE));
		ModelExtent ecoreExtent = new BasicModelExtent(Collections.singletonList(EcorePackage.eINSTANCE));

		//Transformation output
		ModelExtent facetSetsExtent = new BasicModelExtent();
		ModelExtent querySetExtent = new BasicModelExtent();

		ModelExtent[] extents = new ModelExtent[]{ sourceProfileExtent, umlEcoreExtent, ecoreExtent, facetSetsExtent, querySetExtent };

		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$
		context.setConfigProperty("packageName", packageName); //$NON-NLS-1$
		//context.setLog(new WriterLog(new OutputStreamWriter(System.out)));

		ExecutionDiagnostic result = executor.execute(context, extents);



		if(result.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK) {
			List<EObject> querySet = querySetExtent.getContents();
			EObject querySetResult = querySet.get(0);

			if(querySetResult instanceof ModelQuerySet) {
				ModelQuerySet resultQuerySet = (ModelQuerySet)querySetResult;
				ResourceSet resourceSet = new ResourceSetImpl();

				URI queriesURI = URI.createURI("queries/" + resultQuerySet.getName() + ".querySet").resolve(targetURI); //$NON-NLS-1$ //$NON-NLS-2$
				Resource querySetResource = resourceSet.createResource(queriesURI);
				querySetResource.getContents().addAll(querySet);
				this.generatedModelQuerySet.addAll(querySet);
				try {
					querySetResource.save(null);
				} catch (IOException ex) {
					ex.printStackTrace(System.err);
				}
			}

			List<EObject> facetSets = facetSetsExtent.getContents();
			EObject facetSetResult = facetSets.get(0);
			if(facetSetResult instanceof FacetSet) {
				FacetSet resultFacetSet = (FacetSet)facetSetResult;
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource facetSetResource = resourceSet.createResource(URI.createURI("facets/" + resultFacetSet.getName() + ".facetSet").resolve(targetURI)); //$NON-NLS-1$ //$NON-NLS-2$
				facetSetResource.getContents().add(resultFacetSet);

				//				repairURI(resultFacetSet); //TODO

				try {
					facetSetResource.save(null);
				} catch (IOException ex) {
					ex.printStackTrace(System.err);
				}

				runFacetSetSplit(resultFacetSet);
			}
		} else {
			IStatus status = BasicDiagnostic.toIStatus(result);
			//Activator.getDefault().getLog().log(status);
			System.err.println(status);
		}
		//return null;
	}

	public void repairURI2() {
		for(int i = 0; i < this.generatedFacetSet.size(); i++) {
			repairURI(this.generatedFacetSet.get(i));
			try {
				this.generatedFacetSet.get(i).eResource().save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void repairURI(final FacetSet facetSet) {
		if(facetSet.getFacets().isEmpty()) {
			if(!facetSet.getESubpackages().isEmpty()) {
				for(EPackage subPackage : facetSet.getESubpackages()) {
					if(subPackage instanceof FacetSet) {
						repairURI((FacetSet)subPackage);
						break;
					}
				}

			}
		} else {
			ModelQuery query = facetSet.getFacets().get(0).getConditionQuery();
			Resource queryResource = query.eResource();
			URI queryURI = queryResource.getURI();

			System.out.print("Replacing " + queryURI + " by "); //$NON-NLS-1$ //$NON-NLS-2$

			URI newURI = URI.createURI("emffacet:/query/" + queryURI.lastSegment().replace(".querySet", "")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			queryResource.setURI(newURI);
			System.out.println(newURI);
			System.out.println();
		}
	}

	private void runFacetSetSplit(final FacetSet facetSet) {
		Set<Resource> resources = FacetSetSplitter.instance.splitFacetSet(facetSet);
		List<EObject> contents = new ArrayList<EObject>();
		Iterator<Resource> iter = resources.iterator();
		while(iter.hasNext()) {
			contents.addAll(iter.next().getContents());
		}

		for(int i = 0; i < contents.size(); i++) {
			if(contents.get(i) instanceof FacetSet) {
				this.generatedFacetSet.add((FacetSet)contents.get(i));
			}
		}
	}

	/**
	 * generate the java source
	 * 
	 * @param targetFolder
	 *        the target folder for the java source
	 */
	private void runAcceleoTransformation(  final File targetFolder) {
		try {
			//			targetFolder = new File("D:\\runtime-Neptune-New_configuration(1)\\tutu\\src-gen");
			Generate generate = new Generate(this.profile, targetFolder, Collections.EMPTY_LIST);
			//TODO a tester!
			//			generate.addPropertiesFile(propertiesFile)
			generate.setHeader(this.header);
			//			generate.setHeader("");
			generate.setPackageName(this.basePackageName);
			//			generate.setPackageName("");
			//			generate.setPackageName("oep.test");
			generate.doGenerate(null);
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}

	/**
	 * Getter for {@link #generatedFacetSet}
	 * 
	 * @return
	 *         the generated facetSet
	 */
	public List<FacetSet> getGeneratedFacetSet() {
		return this.generatedFacetSet;
	}

	/**
	 * Getter for {@link #getGeneratedQuerySet()}
	 * 
	 * @return
	 *         the generated querySet
	 */
	public List<EObject> getGeneratedQuerySet() {
		return this.generatedModelQuerySet;

	}
}
