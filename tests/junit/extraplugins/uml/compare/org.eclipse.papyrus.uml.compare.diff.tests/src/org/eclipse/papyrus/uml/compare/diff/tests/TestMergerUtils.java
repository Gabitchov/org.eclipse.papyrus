package org.eclipse.papyrus.uml.compare.diff.tests;

import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.junit.Assert;


public class TestMergerUtils {


	private TestMergerUtils() {
		//to prevent instanciation
	}

	public static final void compareDiffList(final List<DiffElement> diff1, final List<DiffElement> diff2) {
		Assert.assertEquals("The compared lists don't have the same size.", diff1.size(), diff2.size());
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(org.eclipse.emf.compare.util.AdapterUtils.getAdapterFactory());
		int size = diff1.size();
		for(int i = 0; i < size; i++) {
			DiffElement element1 = diff1.get(i);
			DiffElement element2 = diff2.get(i);
			//we verify that we get the same label for the 2 elements
			Assert.assertTrue(provider.getText(element1).equals(provider.getText(element2)));
			//we verify that the 2 elements are instance of the same class
			Assert.assertTrue("I'm comparing 2 elements which are not instance of the same class", element1.getClass() == element2.getClass());

			if(element1 instanceof DiffGroup) {
				DiffGroup grp1 = (DiffGroup)element1;
				DiffGroup grp2 = (DiffGroup)element2;
				compareDiffList(grp1.getSubDiffElements(), grp2.getSubDiffElements());
				compareDiffList(grp1.getRequires(), grp2.getRequires());
				//				compareList(grp1.getRequiredBy(), grp2.getRequiredBy());
			}
		}
	}

}
