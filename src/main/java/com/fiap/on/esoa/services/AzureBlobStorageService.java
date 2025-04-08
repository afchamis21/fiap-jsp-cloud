package com.fiap.on.esoa.services;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.fiap.on.esoa.env.EnvLoader;

import java.util.Optional;

public class AzureBlobStorageService {
    private final static String IMAGE_CONTAINER_NAME = "images";

    private BlobServiceClient getServiceClient() {
        String accountName = EnvLoader.getInstance().getValue("AZURE_BLOB_STORAGE_ACCOUNT_NAME")
                .orElseThrow(() -> new RuntimeException("Azure BLOB Account Name is missing!"));

        String accountKey = EnvLoader.getInstance().getValue("AZURE_BLOB_STORAGE_ACCOUNT_KEY")
                .orElseThrow(() -> new RuntimeException("Azure BLOB Account Key is missing!"));

        String connectionString = String.format(
                "DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;EndpointSuffix=core.windows.net",
                accountName,
                accountKey
        );

        System.out.println("> Getting connection to Azure Blob Storage...");

        BlobServiceClient client = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();

        System.out.println("> Got connection to blob storage!");

        return client;
    }

    private BlobContainerClient getContainerClient() {
        BlobServiceClient serviceClient = getServiceClient();

        System.out.println("> Getting connection to container " + IMAGE_CONTAINER_NAME);
        BlobContainerClient containerClient = serviceClient.getBlobContainerClient(IMAGE_CONTAINER_NAME);
        System.out.println("> Got connection to container!");

        return containerClient;
    }

    public Optional<BlobClient> getFile(String fileName) {
        BlobContainerClient client = getContainerClient();

        System.out.println("> Searching for file " + fileName);
        BlobClient blobClient = client.getBlobClient(fileName);

        if (!blobClient.exists()) {
            System.out.println("> File not found!");
            return Optional.empty();
        }
        System.out.println("> File found!");

        return Optional.of(blobClient);
    }
}
