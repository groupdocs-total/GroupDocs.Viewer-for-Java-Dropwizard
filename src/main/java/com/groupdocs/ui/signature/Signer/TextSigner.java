package com.groupdocs.ui.signature.Signer;

import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.enums.PdfTextSignatureImplementation;
import com.groupdocs.signature.domain.enums.ImagesTextSignatureImplementation;
import com.groupdocs.signature.domain.enums.WordsTextSignatureImplementation;
import com.groupdocs.signature.domain.enums.CellsTextSignatureImplementation;
import com.groupdocs.signature.domain.enums.SlidesTextSignatureImplementation;
import com.groupdocs.signature.options.appearances.PdfTextAnnotationAppearance;
import com.groupdocs.signature.options.textsignature.SlidesSignTextOptions;
import com.groupdocs.signature.options.textsignature.CellsSignTextOptions;
import com.groupdocs.signature.options.textsignature.WordsSignTextOptions;
import com.groupdocs.signature.options.textsignature.ImagesSignTextOptions;
import com.groupdocs.signature.options.textsignature.PdfSignTextOptions;
import com.groupdocs.ui.signature.domain.wrapper.SignatureDataWrapper;
import com.groupdocs.ui.signature.domain.wrapper.TextDataWrapper;

import java.awt.Color;

/**
 * StampSigner
 * Signs documents with the stamp signature
 * @author Aspose Pty Ltd
 */
public class TextSigner {
    private TextDataWrapper textData;
    private SignatureDataWrapper signatureData;

    public TextSigner(TextDataWrapper textData, SignatureDataWrapper signatureData){
        this.textData = textData;
        this.signatureData = signatureData;
    }

    public PdfSignTextOptions signPdf(){
        PdfSignTextOptions signOptions = new PdfSignTextOptions(textData.getText());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setTop(signatureData.getTop());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setRotationAngle(signatureData.getAngle());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        // setup colors settings
        signOptions.setBackgroundColor(getColor(textData.getBackgroundColor()));
        // setup text color
        signOptions.setForeColor(getColor(textData.getFontColor()));
        signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Image);
        // setup Font options
        signOptions.getFont().setBold(textData.getBold());
        signOptions.getFont().setItalic(textData.getItalic());
        signOptions.getFont().setUnderline(textData.getUnderline());
        signOptions.getFont().setFontFamily(textData.getFont());
        // set reduction size - required to recalculate Text resizing in the UI
        int reductionSize = 0;
        // check if reduction size is between 1 and 2. for example: 1.25
        if((double)textData.getHeight() / signatureData.getImageHeight() > 1 && (double)textData.getHeight() / signatureData.getImageHeight() < 2) {
            reductionSize = 2;
        } else if(textData.getHeight() / signatureData.getImageHeight() == 0) {
            reductionSize = 1;
        } else {
            reductionSize = textData.getHeight() / signatureData.getImageHeight();
        }
        signOptions.getFont().setFontSize(textData.getFontSize() / reductionSize);
        // specify extended appearance options
        PdfTextAnnotationAppearance appearance = new PdfTextAnnotationAppearance();
        appearance.setBorderColor(getColor(textData.getBorderColor()));
        appearance.setBorderStyle(textData.getBorderStyle());
        appearance.setBorderWidth(textData.getBorderWidth());
        signOptions.setAppearance(appearance);
        return signOptions;
    }

    public ImagesSignTextOptions signImage(){
        ImagesSignTextOptions signOptions = new ImagesSignTextOptions(textData.getText());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setTop(signatureData.getTop());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setRotationAngle(signatureData.getAngle());
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        // setup colors settings
        signOptions.setBackgroundColor(getColor(textData.getBackgroundColor()));
        // setup text color
        signOptions.setForeColor(getColor(textData.getFontColor()));
        // setup Font options
        signOptions.getFont().setBold(textData.getBold());
        signOptions.getFont().setItalic(textData.getItalic());
        signOptions.getFont().setUnderline(textData.getUnderline());
        signOptions.getFont().setFontFamily(textData.getFont());
        // set reduction size - required to recalculate font size after signature resizing in the UI
        int reductionSize = 0;
        // check if reduction size is between 1 and 2. for example: 1.25
        if((double)textData.getHeight() / signatureData.getImageHeight() > 1 && (double)textData.getHeight() / signatureData.getImageHeight() < 2) {
            reductionSize = 2;
        } else if(textData.getHeight() / signatureData.getImageHeight() == 0) {
            reductionSize = 1;
        } else {
            reductionSize = textData.getHeight() / signatureData.getImageHeight();
        }
        signOptions.getFont().setFontSize(textData.getFontSize() / reductionSize);
        //type of implementation
        signOptions.setSignatureImplementation(ImagesTextSignatureImplementation.TextAsImage);
        // setup border settings
        signOptions.setBorderColor(getColor(textData.getBorderColor()));
        signOptions.setBorderDashStyle(textData.getBorderStyle());
        signOptions.setBorderWeight(textData.getBorderWidth());
        // type of implementation

        return signOptions;
    }

    public WordsSignTextOptions signWord(){
        WordsSignTextOptions signOptions = new WordsSignTextOptions(textData.getText());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setTop(signatureData.getTop());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setRotationAngle(signatureData.getAngle());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        // setup colors settings
        signOptions.setBackgroundColor(getColor(textData.getBackgroundColor()));
        // setup text color
        signOptions.setForeColor(getColor(textData.getFontColor()));
        // setup Font options
        signOptions.getFont().setBold(textData.getBold());
        signOptions.getFont().setItalic(textData.getItalic());
        signOptions.getFont().setUnderline(textData.getUnderline());
        signOptions.getFont().setFontFamily(textData.getFont());
        // set reduction size - required to recalculate Text resizing in the UI
        int reductionSize = 0;
        // check if reduction size is between 1 and 2. for example: 1.25
        if((double)textData.getHeight() / signatureData.getImageHeight() > 1 && (double)textData.getHeight() / signatureData.getImageHeight() < 2) {
            reductionSize = 2;
        } else if(textData.getHeight() / signatureData.getImageHeight() == 0) {
            reductionSize = 1;
        } else {
            reductionSize = textData.getHeight() / signatureData.getImageHeight();
        }
        signOptions.getFont().setFontSize(textData.getFontSize() / reductionSize);
        signOptions.setSignatureImplementation(WordsTextSignatureImplementation.TextAsImage);
        // setup border settings
        signOptions.setBorderColor(getColor(textData.getBorderColor()));
        signOptions.setBorderDashStyle(textData.getBorderStyle());
        signOptions.setBorderWeight(textData.getBorderWidth());
        // type of implementation

        return signOptions;
    }

    public CellsSignTextOptions signCells(){
        CellsSignTextOptions signOptions = new CellsSignTextOptions(textData.getText());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setTop(signatureData.getTop());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setRotationAngle(signatureData.getAngle());
        signOptions.setSheetNumber(signatureData.getPageNumber());
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        // setup colors settings
        signOptions.setBackgroundColor(getColor(textData.getBackgroundColor()));
        // setup text color
        signOptions.setForeColor(getColor(textData.getFontColor()));
        // setup Font options
        signOptions.getFont().setBold(textData.getBold());
        signOptions.getFont().setItalic(textData.getItalic());
        signOptions.getFont().setUnderline(textData.getUnderline());
        signOptions.getFont().setFontFamily(textData.getFont());
        //type of implementation
        signOptions.setSignatureImplementation(CellsTextSignatureImplementation.TextAsImage);
        // set reduction size - required to recalculate Text resizing in the UI
        int reductionSize = 0;
        // check if reduction size is between 1 and 2. for example: 1.25
        if((double)textData.getHeight() / signatureData.getImageHeight() > 1 && (double)textData.getHeight() / signatureData.getImageHeight() < 2) {
            reductionSize = 2;
        } else if(textData.getHeight() / signatureData.getImageHeight() == 0) {
            reductionSize = 1;
        } else {
            reductionSize = textData.getHeight() / signatureData.getImageHeight();
        }
        signOptions.getFont().setFontSize(textData.getFontSize() / reductionSize);
        // setup border settings
        signOptions.setBorderColor(getColor(textData.getBorderColor()));
        signOptions.setBorderDashStyle(textData.getBorderStyle());
        signOptions.setBorderWeight(textData.getBorderWidth());
        signOptions.setBorderVisiblity(true);
        // type of implementation

        return signOptions;
    }

    public SlidesSignTextOptions signSlides(){
        SlidesSignTextOptions signOptions = new SlidesSignTextOptions(textData.getText());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setTop(signatureData.getTop());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setRotationAngle(signatureData.getAngle());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        // setup colors settings
        signOptions.setBackgroundColor(getColor(textData.getBackgroundColor()));
        // setup text color
        signOptions.setForeColor(getColor(textData.getFontColor()));
        // setup Font options
        signOptions.getFont().setBold(textData.getBold());
        signOptions.getFont().setItalic(textData.getItalic());
        signOptions.getFont().setUnderline(textData.getUnderline());
        signOptions.getFont().setFontFamily(textData.getFont());
        // set reduction size - required to recalculate Text resizing in the UI
        int reductionSize = 0;
        // check if reduction size is between 1 and 2. for example: 1.25
        if((double)textData.getHeight() / signatureData.getImageHeight() > 1 && (double)textData.getHeight() / signatureData.getImageHeight() < 2) {
            reductionSize = 2;
        } else if(textData.getHeight() / signatureData.getImageHeight() == 0) {
            reductionSize = 1;
        } else {
            reductionSize = textData.getHeight() / signatureData.getImageHeight();
        }
        signOptions.getFont().setFontSize(textData.getFontSize() / reductionSize);
        //type of implementation
        signOptions.setSignatureImplementation(SlidesTextSignatureImplementation.TextAsImage);
        // setup border settings
        signOptions.setBorderColor(getColor(textData.getBorderColor()));
        signOptions.setBorderWeight(textData.getBorderWidth());
        // type of implementation

        return signOptions;
    }

    private Color getColor(String rgbColor){
        String[] colors = rgbColor.split(",");
        int redColor = Integer.parseInt(colors[0].replaceAll("\\D+", ""));
        int greenColor = Integer.parseInt(colors[1].replaceAll("\\D+", ""));
        int blueColor = Integer.parseInt(colors[2].replaceAll("\\D+", ""));
        return new Color(redColor, greenColor, blueColor);
    }
}
