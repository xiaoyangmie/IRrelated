/* XMLWriter.java                                                  NanoXML/Java
 *
 * $Revision: 1.4 $
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


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;


/**
 * An XMLWriter writes XML data to a stream.
 *
 * @see net.n3.nanoxml.XMLElement
 * @see java.io.Writer
 *
 * @author Marc De Scheemaecker
 * @version $Name:  $, $Revision: 1.4 $
 */
public class XMLWriter
{
    
    /**
     * Where to write the output to.
     */
    private PrintWriter writer;
    
    
    /**
     * Creates a new XML writer.
     *
     * @param writer where to write the output to.
     */
    public XMLWriter(Writer writer)
    {
        if (writer instanceof PrintWriter) {
            this.writer = (PrintWriter) writer;
        } else {
            this.writer = new PrintWriter(writer);
        }
    }
    
    
    /**
     * Creates a new XML writer.
     *
     * @param stream where to write the output to.
     */
    public XMLWriter(OutputStream stream)
    {
        this.writer = new PrintWriter(stream);
    }
    
    
    /**
     * Writes an XML element.
     *
     * @param xml the non-null XML element to write.
     */
    public void write(XMLElement xml)
        throws IOException
    {
        this.write(xml, 0);
    }
    
    
    /**
     * Writes an XML element.
     *
     * @param xml the non-null XML element to write.
     * @param indent how many spaces to indent the element.
     */
    public void write(XMLElement xml,
                      int        indent)
        throws IOException
    {
        for (int i = 0; i < indent; i++) {
            this.writer.print(' ');
        }

        if (xml.getName() == null) {
            if (xml.getContent() != null) {
                this.writeEncoded(xml.getContent());
                this.writer.println();
            }
        } else {
            this.writer.print('<');
            this.writer.print(xml.getName());
            Enumeration _enum = xml._enumerateAttributeNames();
            
            while (_enum.hasMoreElements()) {
                String key = (String) _enum.nextElement();
                String value = xml.getAttribute(key);
                this.writer.print(" " + key + "=\"");
                this.writeEncoded(value);
                this.writer.print('"');
            }
            
            if ((xml.getContent() != null)
                    && (xml.getContent().length() > 0)) {
                writer.print('>');
                this.writeEncoded(xml.getContent());
                writer.println("</" + xml.getName() + '>');
            } else if (xml.hasChildren()) {
                writer.println('>');
                _enum = xml._enumerateChildren();
                
                while (_enum.hasMoreElements()) {
                    XMLElement child = (XMLElement) _enum.nextElement();
                    this.write(child, indent + 4);
                }
                
                for (int i = 0; i < indent; i++) {
                    this.writer.print(' ');
                }
                
                this.writer.println("</" + xml.getName() + ">");
            } else {
                this.writer.println("/>");
            }
        }
        
        this.writer.flush();
    }


    /**
     * Writes a string encoding reserved characters.
     *
     * @param str the string to write.
     */
    private void writeEncoded(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            switch (c) {
                case 0x0D:
                case 0x0A:
                    this.writer.print(c);
                    break;
                    
                case '<':
                    this.writer.print("&lt;");
                    break;
                    
                case '>':
                    this.writer.print("&gt;");
                    break;
                    
                case '&':
                    this.writer.print("&amp;");
                    break;
                    
                case '\'':
                    this.writer.print("&apos;");
                    break;
                    
                case '"':
                    this.writer.print("&quot;");
                    break;
                    
                default:
                    if ((c < ' ') || (c > 0x7E)) {
                        this.writer.print("&#x");
                        this.writer.print(Integer.toString(c, 16));
                        this.writer.print(';');
                    } else {
                        this.writer.print(c);
                    }
            }
        }
    }

}
