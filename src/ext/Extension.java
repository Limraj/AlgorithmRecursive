/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ext;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import util.FileUtil;

/**
 *
 * @author kamil.jarmusik
 */
public enum Extension {
    
    PDF("pdf"),DOC("doc"),DOCX("docx"),SQL("sql"),XSD("xsd"),WSDL("wsdl"),JAVA("java"),
    TXT("txt"),CSV("csv"),XLS("xls"),XLSX("xlsx"),XML("xml"),JSON("json"),HTML("html"),
    XHTML("xhtml"),UNKNOWN("");
    
    private final String extensionName;

    Extension(String ext) {
        this.extensionName = ext;
    }

    public static Set<Extension> docExtension() {
        Set<Extension> ext = new HashSet<>(Arrays.asList(Extension.values()));
        ext.remove(UNKNOWN);
        return Collections.unmodifiableSet(ext);
    }
    
    public static Extension ext(File file) {
        if(FileUtil.isDirectory(file))
            return Extension.UNKNOWN;
        String name = file.getName();
        name = name.substring(name.lastIndexOf(".") + 1);
        if(!isKnown(name))
            return Extension.UNKNOWN;
        return Extension.valueOf(name.toUpperCase());
    }

    private static boolean isKnown(String name) {
        return Arrays.asList(Extension.values()).stream()
                .anyMatch(e -> e.getExtensionName().equalsIgnoreCase(name));
    }

    public String getExtension() {
        return "." + extensionName;
    }

    public String getExtensionName() {
        return extensionName;
    }

}
