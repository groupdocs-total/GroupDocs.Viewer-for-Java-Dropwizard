package com.groupdocs.ui.common.util;

import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Utils {
    /**
     * Rename file if exist
     *
     * @param directory directory where files are located
     * @param fileName  file name
     * @return new file with new file name
     */
    public static File getFreeFileName(String directory, String fileName) {
        File file = null;
        try {
            File folder = new File(directory);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                int number = i + 1;
                String newFileName = FilenameUtils.removeExtension(fileName) + "-Copy(" + number + ")." + FilenameUtils.getExtension(fileName);
                file = new File(directory + File.separator + newFileName);
                if (file.exists()) {
                    continue;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * Create file in previewPath and name imageGuid
     * if the file is already exist, create new file with next number in name
     * examples, 001, 002, 003, etc
     *
     * @param previewPath path to file folder
     * @param imageGuid   path to file
     * @return created file
     */
    public static File getFileWithUniqueName(String previewPath, String imageGuid, String ext) {
        if (!StringUtils.isEmpty(imageGuid) && new File(imageGuid).exists()) {
            return new File(imageGuid);
        } else {
            File[] listOfFiles = new File(previewPath).listFiles();
            return createUniqueFile(previewPath, listOfFiles, ext);
        }
    }

    private static File createUniqueFile(String previewPath, File[] listOfFiles, String ext) {
        for (int i = 0; i <= listOfFiles.length; i++) {
            // set file name, for example 001
            String fileName = String.format("%03d", i + 1);
            File file = new File(String.format("%s%s%s.%s", previewPath, File.separator, fileName, ext));
            // check if file with such name already exists
            if (file.exists()) {
                continue;
            } else {
                return file;
            }
        }
        return new File(String.format("%s%s001.png", previewPath, File.separator));
    }

    /**
     * Generate empty image for future signing with signature, such approach required to get signature as image
     *
     * @param width  image width
     * @param height image height
     * @return
     */
    public static BufferedImage getBufferedImage(int width, int height) {
        BufferedImage bufImage = null;
        try {
            bufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            // Create a graphics contents on the buffered image
            Graphics2D g2d = bufImage.createGraphics();
            // Draw graphics
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, width, height);
            // Graphics context no longer needed so dispose it
            g2d.dispose();
            return bufImage;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        } finally {
            if (bufImage != null) {
                bufImage.flush();
            }
        }
    }
}