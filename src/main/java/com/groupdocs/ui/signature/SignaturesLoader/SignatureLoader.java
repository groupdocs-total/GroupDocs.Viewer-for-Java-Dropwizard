package com.groupdocs.ui.signature.SignaturesLoader;

import com.google.common.collect.Ordering;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.domain.wrapper.ExceptionWrapper;
import com.groupdocs.ui.signature.comparator.FileNameComparator;
import com.groupdocs.ui.signature.comparator.FileTypeComparator;
import com.groupdocs.ui.signature.domain.wrapper.SignatureFileDescriptionWrapper;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * SignatureLoader
 * Loads signature files from the storage
 * @author Aspose Pty Ltd
 */
public class SignatureLoader {
    private String path;
    private GlobalConfiguration globalConfiguration;

    /**
     * Constructor
     * @param path signatures root directory
     * @param globalConfiguration global configuration object
     */
    public SignatureLoader(String path, GlobalConfiguration globalConfiguration){
        this.path = path;
        this.globalConfiguration = globalConfiguration;
    }

    /**
     * Load image signatures
     * @return ArrayList<SignatureFileDescriptionWrapper>
     * @throws IOException
     */
    public ArrayList<SignatureFileDescriptionWrapper> LoadImageSignatures() throws IOException {
        File directory = new File(path);
        File[] fList = directory.listFiles();
        ArrayList<SignatureFileDescriptionWrapper> fileList = new ArrayList<SignatureFileDescriptionWrapper>();
        List<File> filesList = new ArrayList<>();
        try {
            for (File file : fList) {
                filesList.add(file);
            }
            fList = null;
            // sort list of files and folders
            Collections.sort(filesList, Ordering.from(new FileTypeComparator()).compound(new FileNameComparator()));
            for (File file : filesList) {
                // check if current file/folder is hidden
                if (file.isHidden() || file.toPath().equals(new File(globalConfiguration.getSignature().getDataDirectory()).toPath())) {
                    // ignore current file and skip to next one
                    continue;
                } else {
                    SignatureFileDescriptionWrapper fileDescription = new SignatureFileDescriptionWrapper();
                    fileDescription.setGuid(file.getAbsolutePath());
                    fileDescription.setName(file.getName());
                    // set is directory true/false
                    fileDescription.setDirectory(file.isDirectory());
                    // set file size
                    fileDescription.setSize(file.length());
                    // get image Base64 incoded String
                    FileInputStream fileInputStreamReader = new FileInputStream(file);
                    byte[] bytes = new byte[(int) file.length()];
                    fileInputStreamReader.read(bytes);
                    fileDescription.setImage(Base64.getEncoder().encodeToString(bytes));
                    // add object to array list
                    fileList.add(fileDescription);
                }
            }
            return fileList;
        } catch (Exception ex){
            throw ex;
        }
    }

    /**
     * Load digital signatures or documents for signing
     * @return ArrayList<SignatureFileDescriptionWrapper>
     */
    public ArrayList<SignatureFileDescriptionWrapper> LoadFiles() {
        File directory = new File(path);
        File[] fList = directory.listFiles();
        ArrayList<SignatureFileDescriptionWrapper> fileList = new ArrayList<SignatureFileDescriptionWrapper>();
        List<File> filesList = new ArrayList<>();
        try {
            for (File file : fList) {
                filesList.add(file);
            }
            fList = null;
            // sort list of files and folders
            Collections.sort(filesList, Ordering.from(new FileTypeComparator()).compound(new FileNameComparator()));
            for (File file : filesList) {
                // check if current file/folder is hidden
                if (file.isHidden() || file.toPath().equals(new File(globalConfiguration.getSignature().getDataDirectory()).toPath())) {
                    // ignore current file and skip to next one
                    continue;
                } else {
                    SignatureFileDescriptionWrapper fileDescription = new SignatureFileDescriptionWrapper();
                    fileDescription.setGuid(file.getAbsolutePath());
                    fileDescription.setName(file.getName());
                    // set is directory true/false
                    fileDescription.setDirectory(file.isDirectory());
                    // set file size
                    fileDescription.setSize(file.length());
                    // add object to array list
                    fileList.add(fileDescription);
                }
            }
            return fileList;
        } catch (Exception ex){
            throw ex;
        }
    }

    public ArrayList<SignatureFileDescriptionWrapper> LoadStampSignatures() throws IOException {
        String imagesPath = path + "/Preview";
        String xmlPath = path + "/XML";
        File images = new File(imagesPath);
        List<File> imageFiles = new ArrayList<File>(Arrays.asList(images.listFiles()));
        File xmls = new File(xmlPath);
        List<File> xmlFiles = new ArrayList<File>(Arrays.asList(xmls.listFiles()));
        ArrayList<SignatureFileDescriptionWrapper> fileList = new ArrayList<SignatureFileDescriptionWrapper>();
        List<File> filesList = new ArrayList<>();
        try {
            int counter = 0;
            for (File image : imageFiles) {
                for (File xmlFile : xmlFiles) {
                    if(FilenameUtils.removeExtension(xmlFile.getName()).equals(FilenameUtils.removeExtension(image.getName()))){
                        filesList.add(image);
                    }
                }
            }
            images = null;
            xmls = null;
            xmlFiles = null;
            imageFiles = null;
            // sort list of files and folders
            Collections.sort(filesList, Ordering.from(new FileTypeComparator()).compound(new FileNameComparator()));
            for (File file : filesList) {
                // check if current file/folder is hidden
                if (file.isHidden() || file.toPath().equals(new File(globalConfiguration.getSignature().getDataDirectory()).toPath())) {
                    // ignore current file and skip to next one
                    continue;
                } else {
                    SignatureFileDescriptionWrapper fileDescription = new SignatureFileDescriptionWrapper();
                    fileDescription.setGuid(file.getAbsolutePath());
                    fileDescription.setName(file.getName());
                    // set is directory true/false
                    fileDescription.setDirectory(file.isDirectory());
                    // set file size
                    fileDescription.setSize(file.length());
                    // get image Base64 incoded String
                    FileInputStream fileInputStreamReader = new FileInputStream(file);
                    byte[] bytes = new byte[(int) file.length()];
                    fileInputStreamReader.read(bytes);
                    fileDescription.setImage(Base64.getEncoder().encodeToString(bytes));
                    // add object to array list
                    fileList.add(fileDescription);
                }
            }
            return fileList;
        } catch (Exception ex){
            throw ex;
        }
    }
}
