package com.jquispeluyo.faceserviceazure.gcs;

import com.google.api.client.util.DateTime;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jquispeluyo.faceserviceazure.FaceServiceAzureApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Service
public class GscServiceImpl implements GcsService {

    @Autowired
    private Storage storage;

    @Override
    public String upload(MultipartFile filePart) throws IOException {

        final String FILENAME = new DateTime(new Date()).toString() + "-" + filePart.getOriginalFilename();
        final String BUCKETNAME = "face-temp";

        BlobInfo blobInfo = storage.create(
                BlobInfo
                        .newBuilder(BUCKETNAME, FILENAME)
                        .setContentType(filePart.getContentType())
                        .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                        .build(),
                filePart.getBytes());

        return blobInfo.getMediaLink();
    }

}
