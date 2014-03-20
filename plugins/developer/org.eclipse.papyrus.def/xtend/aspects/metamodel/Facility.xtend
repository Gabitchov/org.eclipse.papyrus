package aspects.metamodel;

import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.Facility_qvto
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.gmf.codegen.gmfgen.DynamicModelAccess
import xpt.Common

@Singleton class Facility extends metamodel.Facility {

	@Inject extension Common;
	@Inject extension Facility_qvto;



override getMethod(GenPackage it, DynamicModelAccess dma)'''
	«generatedMemberComment('@throws IllegalStateException if no EPackage with given URI is registered.')»
	public static «className(dma)» get«getNameToken(it)»() {
		if («fieldName(it)» == null) {
			org.eclipse.emf.ecore.EPackage pkg = getRegistry().getEPackage("«getEcorePackage().nsURI»");
			if (pkg == null) {
				throw new IllegalStateException("Package «getEcorePackage().name»(«getEcorePackage().nsURI») not found");
			}
			«fieldName(it)» = new «className(dma)»(pkg);
			«fieldName(it)».init«getNameToken(it)»();
		}
		return «fieldName(it)»;
	}
'''

}