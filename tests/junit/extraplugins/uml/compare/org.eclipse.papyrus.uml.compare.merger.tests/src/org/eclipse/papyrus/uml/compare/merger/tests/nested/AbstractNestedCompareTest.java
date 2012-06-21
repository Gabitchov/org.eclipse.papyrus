package org.eclipse.papyrus.uml.compare.merger.tests.nested;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.core.resource.TransactionalEditingDomainManager;
import org.eclipse.papyrus.infra.emf.compare.common.utils.services.PapyrusFileLoader;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.compare.merge.nested.utils.NestedMatchService;
import org.eclipse.papyrus.uml.compare.merge.nested.utils.NestedMergeUtils;
import org.eclipse.papyrus.uml.compare.merge.nested.utils.UMLDiffService;
import org.eclipse.papyrus.uml.compare.merger.tests.AbstractCompareTest;
import org.eclipse.papyrus.uml.compare.merger.tests.Activator;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.junit.Assert;
import org.junit.Test;

;

/**
 * 
 * This abstract provides methods to compare 2 Papyrus uml files named "left.uml" and "right.uml"
 * 
 */
public abstract class AbstractNestedCompareTest extends AbstractCompareTest {


	/** the root of the model used for the test */
	protected static Package root;

	private static final String FOLDER_PATH = "/resources/nested/";

	/** the name of the model used to do the test */
	private static final String MODEL = "model";


	public static final void init(final String modelPath, boolean leftToRight) throws CoreException, IOException {
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		project = ProjectUtils.createProject("MyProject"); //$NON-NLS-1$
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), FOLDER_PATH + modelPath, MODEL);
		final List<IFile> comparedFiles = new ArrayList<IFile>();

		comparedFiles.add(project.getFile(MODEL + "." + "uml"));
		set = new ResourceSetImpl();
		domain = TransactionalEditingDomainManager.createDefaultTransactionalEditingDomain(set);
		EObject[] roots = PapyrusFileLoader.loadPapyrusFiles(set, comparedFiles);
		root = (Model)roots[0];
		AbstractNestedCompareTest.leftToRight = leftToRight;
	}

	/**
	 * 
	 * @param leftRoot
	 * @param rightRoot
	 * @return
	 *         The diffModel for these parameters
	 * @throws InterruptedException
	 */
	protected DiffModel getDiffModel(EObject leftRoot, EObject rightRoot) throws InterruptedException {
		Map<String, Object> options = NestedMergeUtils.getMergeOptions(null, leftElement, rightElement);;
		// Matching model elements
		final MatchModel match = NestedMatchService.doContentMatch(leftElement, rightElement, options);
		// Computing differences
		final DiffModel diff = UMLDiffService.doDiff(match, false);
		return diff;
	}


	@Test
	public void testModificationOnDiFile() {
		for(Resource current : set.getResources()) {
			if(current.getURI().fileExtension().equals("di") && isAResourceOFTheTestProject(current)) {
				Assert.assertFalse("I found modification on the di file", current.isModified());
			}
		}
	}

	@Override
	@Test
	public void testModificationOnNotationFile() {
		for(Resource current : set.getResources()) {
			if(current.getURI().fileExtension().equals("notation") && isAResourceOFTheTestProject(current)) {
				Assert.assertFalse("I found modification on the notation file", current.isModified());
			}
		}
	}

	@Override
	@Test
	public void testModificationOnUMLFile() {
		for(Resource current : set.getResources()) {
			if(current.getURI().fileExtension().equals("uml") && isAResourceOFTheTestProject(current)) {
				Assert.assertTrue("I didn't found modification on the uml file", current.isModified());
			}
		}
	}


}
