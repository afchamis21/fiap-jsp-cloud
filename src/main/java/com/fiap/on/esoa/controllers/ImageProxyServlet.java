package com.fiap.on.esoa.controllers;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.models.BlobProperties;
import com.fiap.on.esoa.services.AzureBlobStorageService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

@WebServlet("/img")
public class ImageProxyServlet extends HttpServlet {
    private final AzureBlobStorageService blobStorageService = new AzureBlobStorageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String imageId = req.getParameter("id");
        if (imageId == null || imageId.trim().isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing image id");
            return;
        }

        Optional<BlobClient> blobClientOptional = blobStorageService.getFile(imageId);
        if (!blobClientOptional.isPresent()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Image not found");
            return;
        }

        BlobClient blobClient = blobClientOptional.get();

        BlobProperties props = blobClient.getProperties();
        resp.setContentType(props.getContentType());

        try (OutputStream out = resp.getOutputStream()) {
            blobClient.downloadStream(out);
        }
    }
}
