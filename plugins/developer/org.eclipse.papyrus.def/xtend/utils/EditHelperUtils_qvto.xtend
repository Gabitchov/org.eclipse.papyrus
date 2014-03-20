
package utils

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies

@Singleton class EditHelperUtils_qvto {

	def String getBaseEditHelperFullName(GenDiagram diagram) {
		if(!(diagram.eResource.allContents.filter(typeof(AdditionalEditPartCandies)).empty)) {
			return diagram.eResource.allContents.filter(typeof(AdditionalEditPartCandies)).head.baseEditHelperPackage + "." + diagram.baseEditHelperClassName
		} else {
			return diagram.getBaseEditHelperQualifiedClassName();
		}

	}
}
