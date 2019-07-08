/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.impl.file.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kamil.jarmusik
 */
public class FileUtil {
    public static String toString(File file) {
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            return new String(encoded, Charset.forName("UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    public static boolean isDirectory(File file) {
        return Files.isDirectory(Paths.get(file.getAbsolutePath()), LinkOption.NOFOLLOW_LINKS);
    }
}
