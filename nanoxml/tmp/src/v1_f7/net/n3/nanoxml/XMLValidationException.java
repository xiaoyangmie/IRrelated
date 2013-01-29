/* XMLValidationException.java                                     NanoXML/Java
 *
 * $Revision: 1.2 $
 * $Date: 2001/05/06 16:18:37 $
 * $Name:  $
 *
 * This file is part of NanoXML 2 for Java.
 * Copyright (C) 2001 Marc De Scheemaecker, All Rights Reserved.
 *
 * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from the
 * use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 *  1. The origin of this software must not be misrepresented; you must not
 *     claim that you wrote the original software. If you use this software in
 *     a product, an acknowledgment in the product documentation would be
 *     appreciated but is not required.
 *
 *  2. Altered source versions must be plainly marked as such, and must not be
 *     misrepresented as being the original software.
 *
 *  3. This notice may not be removed or altered from any source distribution.
 */

package net.n3.nanoxml;


/**
 * An XMLValidationException is thrown when the XML passed to the XML parser is
 * well-formed but not valid.
 *
 * @author Marc De Scheemaecker
 * @version $Name:  $, $Revision: 1.2 $
 */
public class XMLValidationException
    extends RuntimeException
{

    /**
     * An element was missing.
     */
    public static final int MISSING_ELEMENT = 1;
    
    
    /**
     * An unexpected element was encountered.
     */
    public static final int UNEXPECTED_ELEMENT = 2;
    
    
    /**
     * An attribute was missing.
     */
    public static final int MISSING_ATTRIBUTE = 3;
    
    
    /**
     * An unexpected attribute was encountered.
     */
    public static final int UNEXPECTED_ATTRIBUTE = 4;
    
    
    /**
     * An attribute has an invalid value.
     */
    public static final int ATTRIBUTE_WITH_INVALID_VALUE = 5;
    
    
    /**
     * A PCDATA element was missing.
     */
    public static final int MISSING_PCDATA = 6;
    
    
    /**
     * An unexpected PCDATA element was encountered.
     */
    public static final int UNEXPECTED_PCDATA = 7;
    
    
    /**
     * Another error than those specified in this class was encountered.
     */
    public static final int MISC_ERROR = 0;
    
    
    /**
     * Which error occurred.
     */
    private int errorType;
    
    
    /**
     * The line number in the XML data where the exception occurred.
     */
    private int lineNr;
    
    
    /**
     * The name of the element where the exception occurred.
     */
    private String elementName;
    
    
    /**
     * The name of the attribute where the exception occurred.
     */
    private String attributeName;
    
    
    /**
     * The value of the attribute where the exception occurred.
     */
    private String attributeValue;
    
    
    /**
     * Creates a new exception.
     *
     * @param errorType the type of validity error
     * @param lineNr the line number in the XML data where the exception 
     *               occurred.
     * @param elementName the name of the offending element
     * @param attributeName the name of the offending attribute
     * @param attributeValue the value of the offending attribute
     * @param msg the message of the exception.
     */
    public XMLValidationException(int    errorType,
                                  int    lineNr,
                                  String elementName,
                                  String attributeName,
                                  String attributeValue,
                                  String msg)
    {
        super("XML Not Valid at Line " + lineNr + ": " + msg
              + "(type=" + errorType
              + ((elementName == null) ? "" : (", element: " + elementName))
              + ((attributeName == null) ? ""
                    : (", attribute: " + attributeName + "=" + attributeValue))
              + ")");
        this.lineNr = lineNr;
        this.elementName = elementName;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }
    
    
    /**
     * Returns the line number in the XML data where the exception occurred.
     * If there is no line number known, -1 is returned.
     */
    public int getLineNr()
    {
        return this.lineNr;
    }
    
    
    /**
     * Returns the name of the element in which the validation is violated.
     * If there is no current element, null is returned.
     */
    public String getElementName()
    {
        return this.elementName;
    }
    
    
    /**
     * Returns the name of the attribute in which the validation is violated.
     * If there is no current attribute, null is returned.
     */
    public String getAttributeName()
    {
        return this.attributeName;
    }
    
    
    /**
     * Returns the value of the attribute in which the validation is violated.
     * If there is no current attribute, null is returned.
     */
    public String getAttributeValue()
    {
        return this.attributeValue;
    }
    
}
