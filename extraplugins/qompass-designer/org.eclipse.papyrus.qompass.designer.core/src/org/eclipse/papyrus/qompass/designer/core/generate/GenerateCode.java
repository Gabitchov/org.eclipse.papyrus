package org.eclipse.papyrus.qompass.designer.core.generate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
// deactivated differential code generation for the moment.
/*
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.util.ModelUtils;
*/
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

import org.eclipse.papyrus.qompass.designer.core.ModelManagement;
import org.eclipse.papyrus.qompass.designer.core.extensions.ILangSupport;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;

public class GenerateCode {

	public GenerateCode(IProject genProject, ILangSupport langSupport, ModelManagement genMM, IProgressMonitor monitor) {
		this.genProject = genProject;
		this.genMM = genMM;
		this.monitor = monitor;
		this.langSupport = langSupport;
	}

	public void generate(InstanceSpecification node, String targetLanguage, boolean differential)
		throws TransformationException, InterruptedException
	{
		String path = genMM.getPath(genProject, "model", null);
		Package genModel = genMM.getModel();
		EObject oldGenModel = null;
		if(differential) {
			/*
			try {
				oldGenModel = ModelUtils.load(URI.createURI(path), ModelManagement.getResourceSet());
			} catch (IOException io) {
				System.err.println(io);
			}
			*/
		}
		genMM.saveModel(path);

		monitor.worked(1);

		if(genProject == null) {
			return;
		}

		if(oldGenModel != null) {
			// Matching model elements
			/*
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(MatchOptions.OPTION_IGNORE_XMI_ID, true);
			monitor.setTaskName("generating " + targetLanguage + " code for node " + node.getName());
			monitor.subTask("create difference model for node " + node.getName());
			monitor.worked(1);
			MatchModel match = MatchService.doMatch(genModel, oldGenModel, options);
			// Computing differences
			DiffModel diffModel = DiffService.doDiff(match, false);
			deleteRemovedClasses(diffModel);

			Map<PackageableElement, Boolean> alreadyGenerated = new HashMap<PackageableElement, Boolean>();
			monitor.subTask("generate code");

			for(DiffElement diff : diffModel.getDifferences()) {
				if((diff.getKind() == DifferenceKind.ADDITION) ||
					(diff.getKind() == DifferenceKind.CHANGE)) {
					EObject modifiedEObj = null;
					if(diff instanceof AttributeChange) {
						modifiedEObj = ((AttributeChange)diff).getLeftElement();
					}
					else if(diff instanceof ModelElementChangeLeftTarget) {
						modifiedEObj = ((ModelElementChangeLeftTarget)diff).getLeftElement();
					}
					if(modifiedEObj instanceof Element) {
						PackageableElement modifiedPElement = getNearestClassifierOrPackage((Element)modifiedEObj);
						Element modifiedElement = modifiedPElement;
						// check whether code has already been generated for a parent
						boolean found = false;
						while(modifiedElement != null) {
							modifiedElement = modifiedElement.getOwner();
							if(alreadyGenerated.containsKey(modifiedElement)) {
								found = true;
							}
						}
						// TODO: re-create code for elements that depend on this one (e.g. if the modified element is a
						// class and its name has changed, caller have to use a different name, even if the model reference
						// has not changed.
						if(!found) {
							alreadyGenerated.put(modifiedPElement, true);
							langSupport.generateCode(monitor, modifiedPElement);
						}
					}
				}
			}
			*/
		}
		else {
			monitor.setTaskName("generating " + targetLanguage + " code for node " + node.getName());
			IFolder folder = genProject.getFolder(genModel.getName());
			try {
				folder.delete(true, null);
			} catch (CoreException e) {
				throw new TransformationException("Could not delete old code: " + e.getMessage());
			}
			langSupport.generateCode(monitor, genModel);
		}
		if(monitor.isCanceled()) {
			return;
		}
		monitor.worked(1);
	}

	/**
	 * @param element
	 * @return
	 */
	public PackageableElement getNearestClassifierOrPackage(Element element) {
		while(element != null) {
			if(element instanceof Classifier) {
				return (Classifier)element;
			}
			if(element instanceof Package) {
				return (Package)element;
			}
			element = element.getOwner();
		}
		return null;
	}

	/*
	public void deleteRemovedClasses(EObject diffModelOrElement) throws TransformationException {
		EList<DiffElement> diffs;
		if(diffModelOrElement instanceof DiffModel) {
			diffs = ((DiffModel)diffModelOrElement).getDifferences();
		}
		else if(diffModelOrElement instanceof DiffElement) {
			diffs = ((DiffElement)diffModelOrElement).getSubDiffElements();
		}
		else {
			return;
		}
		for(DiffElement diff : diffs) {
			EObject modifiedEObj = null;

			if(diff.getKind() == DifferenceKind.DELETION) {
				if(diff instanceof AttributeChange) {
					modifiedEObj = ((AttributeChange)diff).getRightElement();
				}
				else if(diff instanceof ModelElementChangeRightTarget) {
					modifiedEObj = ((ModelElementChangeRightTarget)diff).getRightElement();
				}
			}
			else if(diff.getKind() == DifferenceKind.CHANGE) {
				if(diff instanceof AttributeChange) {
					modifiedEObj = ((AttributeChange)diff).getRightElement();
				}
			}
			if(modifiedEObj instanceof PackageableElement) {
				// => delete tree
				langSupport.cleanCode(monitor, (PackageableElement)modifiedEObj);
			}
			// no recursion needed?
			// deleteRemovedClasses(diff);
		}
	}
	*/

	private ModelManagement genMM;

	private IProject genProject;

	private IProgressMonitor monitor;

	private ILangSupport langSupport;
}
