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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.commands;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.papyrus.uml.profile.definition.ProfileRedefinition;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.internal.operations.ProfileOperations;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.Profile2EPackageConverter;
import org.eclipse.uml2.uml.util.UMLUtil.UML2EcoreConverter;


/**
 * This command is used to define a profile
 * 
 * @author VL222926
 * 
 */
public class DefineProfileCommand extends AbstractTransactionalCommand {

	/**
	 * the {@link PapyrusDefinitionAnnotation}
	 */
	private PapyrusDefinitionAnnotation papyrusAnnotation;

	/**
	 * the profile to define
	 */
	private Profile rootProfile;

	private boolean saveConstraint;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @param papyrusAnnotation
	 * @param rootProfile
	 * @param viewer
	 */
	public DefineProfileCommand(TransactionalEditingDomain domain, PapyrusDefinitionAnnotation papyrusAnnotation, Profile rootProfile, boolean saveConstraint) {
		super(domain, "DefineProfileCommand", null); //$NON-NLS-1$
		this.rootProfile = rootProfile;
		this.papyrusAnnotation = papyrusAnnotation;
		this.saveConstraint=saveConstraint;
	}


	/**
	 * Define this package if it is a profile and its sub-profiles
	 * 
	 * @param thePackage
	 *        the package to define (if it is a profile)
	 */
	public static void defineProfiles(Package thePackage,boolean saveConstraintInDef) {
		Map<String, String> options = new HashMap<String, String>();

		options.put(Profile2EPackageConverter.OPTION__ECORE_TAGGED_VALUES, 				UMLUtil.OPTION__PROCESS);
		options.put(Profile2EPackageConverter.OPTION__DERIVED_FEATURES, 				UMLUtil.OPTION__REPORT);
		options.put(Profile2EPackageConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE,	UMLUtil.OPTION__PROCESS);
		options.put(Profile2EPackageConverter.OPTION__DUPLICATE_FEATURES,				UMLUtil.OPTION__PROCESS);
		options.put(Profile2EPackageConverter.OPTION__DUPLICATE_OPERATIONS,				UMLUtil.OPTION__REPORT);
		options.put(Profile2EPackageConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE,	UMLUtil.OPTION__REPORT);
		options.put(Profile2EPackageConverter.OPTION__REDEFINING_OPERATIONS,			UMLUtil.OPTION__REPORT);
		options.put(Profile2EPackageConverter.OPTION__REDEFINING_PROPERTIES,			UMLUtil.OPTION__REPORT);
		options.put(Profile2EPackageConverter.OPTION__SUBSETTING_PROPERTIES,			UMLUtil.OPTION__REPORT);
		options.put(Profile2EPackageConverter.OPTION__UNION_PROPERTIES,					UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__SUPER_CLASS_ORDER,						UMLUtil.OPTION__REPORT);
		options.put(Profile2EPackageConverter.OPTION__ANNOTATION_DETAILS,				UMLUtil.OPTION__REPORT);
		if(saveConstraintInDef==true){
			//		//for the validation
			options.put(Profile2EPackageConverter.OPTION__INVARIANT_CONSTRAINTS,		UMLUtil.OPTION__PROCESS);
			options.put(Profile2EPackageConverter.OPTION__VALIDATION_DELEGATES,			UMLUtil.OPTION__PROCESS);
			options.put(Profile2EPackageConverter.OPTION__INVOCATION_DELEGATES,			UMLUtil.OPTION__PROCESS);
			options.put(UML2EcoreConverter.OPTION__OPERATION_BODIES, 					UMLUtil.OPTION__PROCESS);
		}
		options.put(Profile2EPackageConverter.OPTION__COMMENTS, 					UMLUtil.OPTION__IGNORE);
		options.put(Profile2EPackageConverter.OPTION__FOREIGN_DEFINITIONS, 			UMLUtil.OPTION__IGNORE);

		// we wants to define
		if(thePackage instanceof Profile) {
			((Profile)thePackage).define(options, null, null);
		}
		Iterator<Package> it = thePackage.getNestedPackages().iterator();
		while(it.hasNext()) {
			Package p = it.next();
			defineProfiles(p, saveConstraintInDef);
		}
	}

	/**
	 * 
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		defineProfiles(rootProfile, saveConstraint);
		//PackageUtil.defineProfiles(rootProfile);
		try {
			ProfileRedefinition.redefineProfile(rootProfile, papyrusAnnotation);
			ProfileRedefinition.cleanProfile(rootProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		setResult(CommandResult.newOKCommandResult());
		return CommandResult.newOKCommandResult();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#getAffectedFiles()
	 * 
	 * @return
	 */
	@Override
	public List<IFile> getAffectedFiles() {
		IFile f = WorkspaceSynchronizer.getFile(rootProfile.eResource());
		return f != null ? Collections.<IFile> singletonList(f) : Collections.<IFile> emptyList();
	}
}
