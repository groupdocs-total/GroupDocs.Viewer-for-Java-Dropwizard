package com.groupdocs.ui.viewer.service;

import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.common.entity.web.LoadedPageEntity;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.viewer.entity.web.RotatedPageEntity;
import com.groupdocs.ui.viewer.model.web.RotateDocumentPagesRequest;

import java.util.List;

public interface ViewerService {

    /**
     * Get files and directories
     *
     * @param fileTreeRequest request's object with specified path
     * @return files and directories list
     */
    List<FileDescriptionEntity> loadFileTree(FileTreeRequest fileTreeRequest);


    /**
     * Get document description
     *
     * @param loadDocumentRequest request's object with parameters
     * @return document description
     */
    LoadDocumentEntity loadDocumentDescription(LoadDocumentRequest loadDocumentRequest);

    /**
     * Get document page
     *
     * @param loadDocumentPageRequest request's object with parameters
     * @return document page
     */
    LoadedPageEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest);

    /**
     * Rotate page(s)
     *
     * @param rotateDocumentPagesRequest request's object with parameters
     * @return rotated pages list (each object contains page number and rotated angle information)
     */
    List<RotatedPageEntity> rotateDocumentPages(RotateDocumentPagesRequest rotateDocumentPagesRequest);
}