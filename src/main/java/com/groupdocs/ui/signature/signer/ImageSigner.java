package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.options.imagesignature.PdfSignImageOptions;
import com.groupdocs.signature.options.imagesignature.WordsSignImageOptions;
import com.groupdocs.signature.options.imagesignature.SlidesSignImageOptions;
import com.groupdocs.signature.options.imagesignature.ImagesSignImageOptions;
import com.groupdocs.signature.options.imagesignature.CellsSignImageOptions;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;

/**
 * StampSigner
 * Signs documents with the stamp signature
 * @author Aspose Pty Ltd
 */
public class ImageSigner extends Signer{

    public ImageSigner(SignatureDataEntity signatureData){
        super(signatureData);
    }

    @Override
    public PdfSignImageOptions signPdf(){
        // setup options
        // setup image signature options
        PdfSignImageOptions pdfSignOptions = new PdfSignImageOptions(signatureData.getSignatureGuid());
        // image position
        pdfSignOptions.setLeft(signatureData.getLeft());
        pdfSignOptions.setTop(signatureData.getTop());
        pdfSignOptions.setWidth(signatureData.getImageWidth());
        pdfSignOptions.setHeight(signatureData.getImageHeight());
        pdfSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        pdfSignOptions.setRotationAngle(signatureData.getAngle());
        return pdfSignOptions;
    }

    @Override
    public ImagesSignImageOptions signImage(){
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        ImagesSignImageOptions imageSignOptions = new ImagesSignImageOptions(signatureData.getSignatureGuid());
        imageSignOptions.setLeft(signatureData.getLeft());
        imageSignOptions.setTop(signatureData.getTop());
        imageSignOptions.setWidth(signatureData.getImageWidth());
        imageSignOptions.setHeight(signatureData.getImageHeight());
        imageSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        imageSignOptions.setRotationAngle(signatureData.getAngle());
        return imageSignOptions;
    }

    @Override
    public WordsSignImageOptions signWord(){
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignImageOptions wordsSignOptions = new WordsSignImageOptions(signatureData.getSignatureGuid());
        wordsSignOptions.setLeft(signatureData.getLeft());
        wordsSignOptions.setTop(signatureData.getTop());
        wordsSignOptions.setWidth(signatureData.getImageWidth());
        wordsSignOptions.setHeight(signatureData.getImageHeight());
        wordsSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        wordsSignOptions.setRotationAngle(signatureData.getAngle());
        return wordsSignOptions;
    }

    @Override
    public CellsSignImageOptions signCells(){
        // setup image signature options
        CellsSignImageOptions cellsSignOptions = new CellsSignImageOptions(signatureData.getSignatureGuid());
        // image position
        cellsSignOptions.setTop(signatureData.getTop());
        cellsSignOptions.setLeft(signatureData.getLeft());
        cellsSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        cellsSignOptions.setHeight(signatureData.getImageHeight());
        cellsSignOptions.setWidth(signatureData.getImageWidth());
        cellsSignOptions.setRotationAngle(signatureData.getAngle());
        return cellsSignOptions;
    }

    @Override
    public SlidesSignImageOptions signSlides(){
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SlidesSignImageOptions slidesSignOptions = new SlidesSignImageOptions(signatureData.getSignatureGuid());
        slidesSignOptions.setLeft(signatureData.getLeft());
        slidesSignOptions.setTop(signatureData.getTop());
        slidesSignOptions.setWidth(signatureData.getImageWidth());
        slidesSignOptions.setHeight(signatureData.getImageHeight());
        slidesSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        slidesSignOptions.setRotationAngle(signatureData.getAngle());
        return slidesSignOptions;
    }
}
