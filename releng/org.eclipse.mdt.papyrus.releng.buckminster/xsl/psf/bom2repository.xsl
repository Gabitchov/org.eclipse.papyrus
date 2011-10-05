<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:md="http://www.eclipse.org/buckminster/MetaData-1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" omit-xml-declaration="no" indent="yes" />
	<xsl:strip-space elements="*" />

	<xsl:template match="/">
		<repository>
			<xsl:for-each select="//md:billOfMaterials/md:idwrapper/md:resolution">
				<!-- beginning of the string contained in repository -->
				<xsl:variable name="begin">
					<xsl:value-of select="substring(@repository, 0, string-length('file:///svnroot/modeling/org.eclipse.mdt.papyrus/'))" />
				</xsl:variable>

				<!-- Is this the Papyrus repository? -->
				<xsl:variable name="isSource">
					<xsl:value-of select="$begin = 'file:///svnroot/modeling/org.eclipse.mdt.papyrus'" />
				</xsl:variable>

				<!-- If yes, generate the right node -->
				<xsl:if test="$isSource='true'">

					<xsl:variable name="name">
						<xsl:call-template name="lastIndexOf">
							<xsl:with-param name="string" select="@repository" />
							<xsl:with-param name="char" select="'/'" />
						</xsl:call-template>
					</xsl:variable>

					<xsl:variable name="path">
						<xsl:value-of select="concat('http://dev.eclipse.org/', substring(@repository, string-length('file:///')+1))" />
					</xsl:variable>


					<!-- create the attribute Projects, with sub child name and path in repo -->
					<xsl:element name="Project">
						<xsl:attribute name="name"><xsl:value-of select="$name" /></xsl:attribute>
						<xsl:attribute name="path"><xsl:value-of select="$path" /></xsl:attribute>
					</xsl:element>
					<xsl:text>
						</xsl:text>

				</xsl:if>
			</xsl:for-each>
		</repository>
	</xsl:template>

	<!-- Retrieves the last index of a character in a given string -->
	<xsl:template name="lastIndexOf">
		<xsl:param name="string" />
		<xsl:param name="char" />
		<xsl:choose>
			<!-- if the string contains the character... -->
			<xsl:when test="contains($string, $char)">
				<!-- call the template recursively... -->
				<xsl:call-template name="lastIndexOf">
					<!-- with the string being the string after the character -->
					<xsl:with-param name="string" select="substring-after($string, $char)" />
					<!-- and the character being the same as before -->
					<xsl:with-param name="char" select="$char" />
				</xsl:call-template>
			</xsl:when>
			<!-- otherwise, return the value of the string -->
			<xsl:otherwise>
				<xsl:value-of select="$string" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>




</xsl:stylesheet>