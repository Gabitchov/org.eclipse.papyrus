/**
 * 
 */
package javagen.umlparser;

import java.util.ArrayList;
import java.util.List;

import japa.parser.ast.type.Type;

/**
 * Allows to analyse an ast type, and to translate it according to recognized
 * patterns.
 * For example, this allow to translate from List<Xxx> to Xxx[0..1].
 * @author dumoulin
 *
 */
public class TypeAnalyserAndTranslator extends TypeAnalyser {

    private List<List<String>> translationList = new ArrayList<List<String>>();
    private static String[] defaultTranslatedType = {
        "java.util.List",
        "java.util.ArrayList",
        "java.util.Collection",
        "java.util.OrderedSet",
    };
    
    
    /**
     * Constructor.
     * @param importedType
     */
    public TypeAnalyserAndTranslator(ImportedTypeCatalog importedType) {
        super(importedType);
        initDefaultTranslatedTypes(defaultTranslatedType);
    }

    /**
     * Get the translated type data from the astType.
     * @param astType
     * @return
     */
    public TranslatedTypeData getTranslatedTypeData(Type astType)
    {
        TranslatedTypeData typeData = (TranslatedTypeData)getTypeData(astType);
        // Does the type correspond to a list ?
        translate(typeData);
        return typeData;
    }
    
    /**
     * Return the TRanslatedTypeData
     */
    @Override
    protected TypeData createTypeData() {
        return new TranslatedTypeData();
    }
        
    /**
     * Translate the type if it is a collection type.
     * @param data
     */
    private void translate(TranslatedTypeData data)
    {
    	List<String> qname = data.qualifiedName;
    	if(translationList.contains(qname))
    	{
    		// Check for one and only one template parameter
    		if( data.genericData != null && data.genericData.size() == 1 )
    		{
    			System.out.println("translate '" + qname + "'");
    			// Set translatable if it is a valide inner type (i.e. not a wildcard)
    			if(! data.genericData.get(0).isWildcard)
    				data.isTranslatable  = true;
    			data.isCollection = true;
    		}
    		else if(data.genericData == null)
    		{  // Collection type, with nospecified type :-(
    			data.isCollection = true;
    		}
    	}
    	else if(data.arrayCount>0)
    	{
    		data.isCollection = true;
    	}

    	// not translatable
    }
    
    
    /**
     * Data structure returned
     * @author dumoulin
     *
     */
    public class TranslatedTypeData extends TypeData {
        
        /** is the type translatable (can we use the generic's one) ?*/ 
        public boolean isTranslatable = false;
        /** is the type denoting a collection ?*/ 
        public boolean isCollection = false;

        public List<String> getTranslatedQualifiedName()
        {
            if(isTranslatable)
                return genericData.get(0).qualifiedName;
            else
                return qualifiedName;
        }
        
        public int getTranslatedUpper()
        {
            if(isCollection)
                return -1;
            else
                return 1;
        }
        
        public int getTranslatedLower()
        {
            if(isCollection)
                return 0;
            else
                return 0;
        }

        public boolean isCollection() {
            return isCollection;
        }
    }
    
    /**
     * Set the default mappings
     * @param defaultMappingNames
     */
    private void initDefaultTranslatedTypes(String[] defaultTranslatedTypes) {
        for(int i=0; i<defaultTranslatedTypes.length; i++)
        {
            translationList.add(UmlUtils.toQualifiedName(defaultTranslatedTypes[i]));
        }       
    }
    

}
